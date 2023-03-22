package com.example.belfunfair.ui.attractions

import java.util.*


internal object AttractionsExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail = HashMap<String, List<String>>()
            val description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla mattis nulla vel justo faucibus venenatis et ut tellus. Nam ac ante purus. Donec in tempor lacus. Quisque efficitur augue ut mi bibendum, ut maximus nisi consequat. Proin pretium ante vitae elit luctus varius vitae eget nulla."

            val _maneges = AttractionsViewModel.maneges
            val maneges: MutableList<String> = ArrayList()
            _maneges.forEach { m -> maneges.add(m.toString()) }
            expandableListDetail["MANEGES"] = maneges

            val _stands = AttractionsViewModel.stands
            val stands: MutableList<String> = ArrayList()
            _stands.forEach { s -> stands.add(s.toString()) }
            expandableListDetail["STANDS"] = stands

            val _artists = AttractionsViewModel.artists
            val artists: MutableList<String> = ArrayList()
            _artists.forEach { a -> artists.add(a.toString()) }
            expandableListDetail["ARTISTES"] = artists

            return expandableListDetail
        }
}