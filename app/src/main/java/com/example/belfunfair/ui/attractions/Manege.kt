package com.example.belfunfair.ui.attractions

class Manege(
    private val idSlot: Int,
    private val name: String,
    private val type: String,
    private val tailleMin: Int?,
    private val description: String,
    private val dateStart: String,
    private val dateEnd: String
) {

    fun getIdSlot(): Int {return idSlot}

    override fun toString(): String {
        val tailleMin: String = tailleMin?.toString() ?: "aucune restriction"
        return "$name ($type) \n " +
                "Du $dateStart au $dateEnd \n" +
                "- Taille minimale: $tailleMin"
    }
}
