package com.example.belfunfair.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DateFormat
import java.util.Date

class HomeViewModel : ViewModel() {

    private var _title = MutableLiveData<String>().apply { value = "Belfunfair" }
    private var _date = MutableLiveData<String>().apply { value = "Du 1er juin au 31 août 2023" }
    private var _description = MutableLiveData<String>().apply { value = "Organisée et financée par la Ville de Belfort avec le soutien des associations étudiantes de l’Aire urbaine, BELFUNFAIR à Belfort se déroule chaque année pendant les vacances d'été. Du 20 juin au 20 août, la cité du Lion se transforme en une majestueuse fête foraine. Diversité, gaieté et convivialité  résument, depuis sa création en 2022, l’ambiance de cette manifestation unique en son genre." }

    val title: LiveData<String> = _title
    val date: LiveData<String> = _date
    val description: LiveData<String> = _description
}