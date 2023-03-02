package com.example.belfunfair.ui.attractions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttractionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Attractions"
    }
    val text: LiveData<String> = _text
}