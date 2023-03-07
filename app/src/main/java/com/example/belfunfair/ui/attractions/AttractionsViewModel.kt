package com.example.belfunfair.ui.attractions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttractionsViewModel : ViewModel() {

    private var _title = MutableLiveData<String>().apply { value = "Liste des attractions" }

    val title: LiveData<String> = _title

}