package com.example.belfunfair.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply { value = "Map" }

    val title: LiveData<String> = _title
}
