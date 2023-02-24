package com.kroger.classdemoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classdemoapp.model.Character
import com.kroger.classdemoapp.databinding.CharacterCardViewBinding

class CharacterAdapter(
    private val characters: List<Character>,
    private val onItemClick: (adapterPosition: Int) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CharacterCardViewBinding.inflate(layoutInflater, parent, false)

        return CharacterViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    inner class CharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(character: Character) {
            Glide
                .with(binding.root)
                .load(character.image)
                .into(binding.characterImage)

            binding.characterName.text = character.name
            binding.characterAge.text = character.age.toString()
        }
    }
}
