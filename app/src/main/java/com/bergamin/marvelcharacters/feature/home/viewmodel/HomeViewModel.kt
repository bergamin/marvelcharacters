package com.bergamin.marvelcharacters.feature.home.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.domain.repository.MarvelRepository
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val charactersLiveData = MutableLiveData<List<Character>>()
    val liveDataMediator = MediatorLiveData<List<CharacterItemViewModel>>()

    val isLoading = ObservableBoolean()
    private var timer = Timer()
    private val debounceTime: Long = 750

    init {
        liveDataMediator.addSource(charactersLiveData) { characters ->
            isLoading.set(false)
            liveDataMediator.value = characters.map { CharacterItemViewModel(it) }
        }
    }

    fun searchCharacter(name: String) {
        if (name.isEmpty()) {
            charactersLiveData.value = emptyList()
            return
        }
        isLoading.set(true)
        timer.cancel()
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                marvelRepository.searchCharacters(name, charactersLiveData)
            }
        }, debounceTime)
    }
}
