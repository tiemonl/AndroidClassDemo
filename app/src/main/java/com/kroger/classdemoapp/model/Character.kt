package com.kroger.classdemoapp.model

data class Character(
    val name: String,
    val age: Int,
    val image: String,
    val gender: String,
    val universe: String,
    val id: Int,
    val relation: List<Int>
)

