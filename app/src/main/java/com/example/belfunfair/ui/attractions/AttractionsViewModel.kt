package com.example.belfunfair.ui.attractions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttractionsViewModel : ViewModel() {

    private val description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mattis nulla vel justo faucibus venenatis et ut tellus. Nam ac ante purus. Donec in tempor lacus. Quisque efficitur augue ut mi bibendum, ut maximus nisi consequat. Proin pretium ante vitae elit luctus varius vitae eget nulla."

    private var _title = MutableLiveData<String>().apply { value = "Liste des attractions" }
    private var _attractions = MutableLiveData<Array<Manege>>().apply { value = arrayOf(
        Manege("Autos-tamponeuses","Grand Public",120,description,1,"2023-06-10","2023-06-25"),
        Manege("Bras-mécanique","Sensations",150,description,2,"2023-07-01","2023-07-15"),
        Manege("Tasses","Grand Public",null,description,3,"2023-06-20","2023-07-10"),
        Manege("Chenille","Grand Public",120,description,4,"2023-06-15","2023-06-25"),
        Manege("Carrousel","Grand Public",null,description,5,"2023-07-20","2023-07-30"),
        Manege("Pieuvre","Grand Public",120,description,6,"2023-06-12","2023-06-23"),
        Manege("Chaises-volantes","Sensations",130,description,7,"2023-07-20","2023-08-01")
    ) }

    val title: LiveData<String> = _title
    val attractions: LiveData<Array<Manege>> = _attractions
}