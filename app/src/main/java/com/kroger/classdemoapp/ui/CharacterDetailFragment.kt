package com.kroger.classdemoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kroger.classdemoapp.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val image = requireArguments().getString("image")
            val universe = requireArguments().getString("universe")

            binding.characterUniverse.text = universe
        }

        return binding.root
    }
}
