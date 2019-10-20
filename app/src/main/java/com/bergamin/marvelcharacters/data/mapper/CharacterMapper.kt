package com.bergamin.marvelcharacters.data.mapper

import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse

object CharacterMapper {

    fun toCharactersList(response: SearchResponse?): List<Character> {
        return response?.data?.results?.map { toCharacter(it) } ?: emptyList()
    }

    fun toCharacter(response: CharacterResponse?): Character {
        return response?.let {
            Character(
                response.id,
                response.name,
                response.description,
                response.thumbnail?.path + "." + response.thumbnail?.extension
            )
        } ?: run { Character() }
    }
}
