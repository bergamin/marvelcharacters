package com.bergamin.marvelcharacters.feature.character.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bergamin.marvelcharacters.R
import com.bergamin.marvelcharacters.common.provider.ResourceProvider
import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.domain.repository.MarvelRepository
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val repository: MarvelRepository,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val characterLiveData = MutableLiveData<Character>()
    val liveDataMediator = MediatorLiveData<Character>()
    val description = ObservableField<String>()

    init {
        setupFormatters()
    }

    private fun setupFormatters() {
        liveDataMediator.addSource(characterLiveData) { character ->
            liveDataMediator.value = character
            description.set(resourceProvider.getString(R.string.description, character?.description ?: "-"))
        }
    }

    fun loadData(id: String) {
        repository.getCharacter(id, characterLiveData)
    }
}
