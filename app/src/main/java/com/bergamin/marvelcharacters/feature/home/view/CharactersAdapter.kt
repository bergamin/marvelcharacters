package com.bergamin.marvelcharacters.feature.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergamin.marvelcharacters.databinding.CharacterItemBinding
import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.feature.home.viewmodel.CharacterItemViewModel

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var listener: CharactersAdapterListener? = null
    var items: List<CharacterItemViewModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterItemViewModel) {
            with(binding) {
                root.setOnClickListener {
                    listener?.didSelectCharacter(item.character)
                }
                character = item
            }
        }
    }
}

interface CharactersAdapterListener {
    fun didSelectCharacter(character: Character)
}
