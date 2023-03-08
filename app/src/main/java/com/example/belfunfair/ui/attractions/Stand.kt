package com.example.belfunfair.ui.attractions

class Stand(
    private val name: String,
    private val type: String,
    private val description: String,
    private val slot: Int,
    private val dateStart: String,
    private val dateEnd: String
) {
    override fun toString(): String {
        return "$name ($type) \n " +
                "Du $dateStart au $dateEnd \n" +
                "- Emplacement: $slot"
    }
}
