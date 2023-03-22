package com.example.belfunfair.ui.attractions

class Artist(
    private val name: String,
    private val descripton: String,
    private val type: String,
    private val groupe: Array<String>,
    private val date: String,
    private val startHour: String,
    private val endHour: String
){
    override fun toString(): String {
        return "$name ($type) \n " +
                "Le $date, de $startHour à $endHour\n" +
                getMembers(groupe)
    }
}

private fun getMembers(members: Array<String>): String {
    var toString = "Groupe:\n"
    members.forEach { m -> toString += "- $m\n" }
    return toString
}