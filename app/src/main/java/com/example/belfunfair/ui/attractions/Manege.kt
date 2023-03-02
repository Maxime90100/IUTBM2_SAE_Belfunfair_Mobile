package com.example.belfunfair.ui.attractions

class Manege(
    private val name: String,
    private val type: String,
    private val tailleMin: Int?,
    private val description: String,
    private val slot: Int,
    private val dateStart: String,
    private val dateEnd: String
) {
    override fun toString(): String {
        val tailleMin: String = tailleMin?.toString() ?: "aucune restriction"
        return "$name ($type) \n " +
                "Du $dateStart au $dateEnd \n" +
                "- Taille minimale: $tailleMin \n " +
                "- Emplacement: $slot"
    }
}
