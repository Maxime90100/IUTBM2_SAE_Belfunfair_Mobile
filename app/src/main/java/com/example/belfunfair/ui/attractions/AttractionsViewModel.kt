package com.example.belfunfair.ui.attractions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttractionsViewModel : ViewModel() {
    private var _title = MutableLiveData<String>().apply { value = "Découvrez toutes nos attractions" }

    val title: LiveData<String> = _title

    companion object {
        private val description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mattis nulla vel justo faucibus venenatis et ut tellus. Nam ac ante purus. Donec in tempor lacus. Quisque efficitur augue ut mi bibendum, ut maximus nisi consequat. Proin pretium ante vitae elit luctus varius vitae eget nulla."
        val maneges: Array<Manege> = arrayOf(
            Manege(1,"Autos-tamponeuses","Grand Public",120,description,"2023-06-10","2023-06-25"),
            Manege(2,"Bras-mécanique","Sensations",150,description,"2023-07-01","2023-07-15"),
            Manege(3,"Tasses","Grand Public",null,description,"2023-06-20","2023-07-10"),
            Manege(4,"Chenille","Grand Public",120,description,"2023-06-15","2023-06-25"),
            Manege(5,"Carrousel","Grand Public",null,description,"2023-07-20","2023-07-30"),
            Manege(6,"Pieuvre","Grand Public",120,description,"2023-06-12","2023-06-23"),
            Manege(6,"Chaises-volantes","Sensations",130,description,"2023-07-20","2023-08-01")
        )
        val stands: Array<Stand> = arrayOf(
            Stand(1,"Vapiano","Restaurant",description,"2023-06-10","2023-06-25"),
            Stand(2,"Ritz","Snack",description,"2023-07-01","2023-07-15"),
        )
        val artists: Array<Artist> = arrayOf(
            Artist("Le trio", description, "Jazz", arrayOf("Eustache Durand","Emmanuelle Souplet","Daniel Dandonneau"), "2023-06-10","9H30", "11H")
        )
    }

}