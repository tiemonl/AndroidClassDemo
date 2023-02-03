package com.kroger.classdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = mutableListOf<Character>()

        for (i in 0..30) {
            characters.add(createCharacter())
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter
    }

    private fun createCharacter() = Character(
        name = "Liam",
        age = Random.nextInt(10, 99),
        image = R.drawable.baseline_10k_24,
        universe = "Earth",
        id = 0,
        relation = listOf()
    )
}
