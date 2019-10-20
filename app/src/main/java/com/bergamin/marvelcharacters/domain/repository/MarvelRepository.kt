package com.bergamin.marvelcharacters.domain.repository

import androidx.lifecycle.MutableLiveData
import com.bergamin.marvelcharacters.domain.model.Character

interface MarvelRepository {
    fun searchCharacters(name: String, characterLiveData: MutableLiveData<List<Character>>)
    fun getCharacter(id: String, characterLiveData: MutableLiveData<Character>)
}
