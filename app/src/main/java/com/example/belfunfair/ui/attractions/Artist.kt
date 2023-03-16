package com.example.belfunfair.ui.attractions

class Artist(
    private val name: String,
    private val descripton: String,
    private val type: String,
    private val groupe: Array<String>,
    private val dateStart: String,
    private val dateEnd: String
){
    override fun toString(): String {
        return "$name ($type) \n " +
                "Du $dateStart au $dateEnd \n" +
                getMembers(groupe)
    }
}

private fun getMembers(members: Array<String>): String {
    var toString = "Groupe:\n"
    members.forEach { m -> toString += "- $m\n" }
    return toString
}