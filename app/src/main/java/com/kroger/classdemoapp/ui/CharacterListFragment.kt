package com.kroger.classdemoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.kroger.classdemoapp.model.Character
import com.kroger.classdemoapp.ui.adapter.CharacterAdapter
import com.kroger.classdemoapp.R
import com.kroger.classdemoapp.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        binding.characterRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = mutableListOf<Character>()

        val genders = mutableListOf("Male", "Female", "Pickle", "Squanch", "01010")
        val characterLocations = mutableListOf(
            "Earth",
            "Citadel of Ricks",
            "Interdimensional Cable",
            "Random Dimension",
        )
        val nameMods = mutableListOf("Pickle", "", "Smart", "Fused", "Big Arm")
        val characterNames = mutableListOf("Rick", "Morty", "Summer", "Jerry", "Beth")

        for (i in 0..30) {
            characters.add(
                createCharacter(
                    "${nameMods.random()} ${characterNames.random()}".trimStart(),
                    characterLocations.random(),
                    genders.random(),
                    i,
                ),
            )
        }

        val adapter = CharacterAdapter(characters) { position ->
            val character = characters[position]

            val bundle = bundleOf(
                "name" to character.name,
                "age" to character.age,
                "image" to character.image,
                "universe" to character.universe
            )

            val detailFragment = CharacterDetailFragment()
            detailFragment.arguments = bundle

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
        binding.characterRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun createCharacter(
        name: String,
        location: String,
        gender: String,
        id: Int,
    ) = Character(
        name = name,
        age = Random.nextInt(10, 99),
        image = "https://rickandmortyapi.com/api/character/avatar/291.jpeg",
        gender = gender,
        universe = location,
        id = id,
        relation = listOf(),
    )
}
