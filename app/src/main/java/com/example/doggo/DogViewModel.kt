package com.example.doggo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doggo.network.DogPhoto
import com.example.doggo.network.DogPhotoApi

import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val _dogPhoto = MutableLiveData<DogPhoto>()
    val dogPhoto: LiveData<DogPhoto> = _dogPhoto

    init {
        getNewPhoto()
    }

    fun getNewPhoto(){

        viewModelScope.launch {

            _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()

        }

    }

}