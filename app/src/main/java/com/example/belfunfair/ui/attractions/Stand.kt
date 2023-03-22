package com.example.belfunfair.ui.attractions

class Stand(
    private val idSlot: Int,
    private val name: String,
    private val type: String,
    private val description: String,
    private val dateStart: String,
    private val dateEnd: String
) {

    fun getIdSlot(): Int {return idSlot}

    override fun toString(): String {
        return "$name ($type) \n " +
                "Du $dateStart au $dateEnd"
    }
}
