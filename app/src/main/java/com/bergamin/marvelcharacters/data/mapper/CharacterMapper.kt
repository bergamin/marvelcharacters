package com.bergamin.marvelcharacters.data.mapper

import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse

object CharacterMapper {

    fun toCharactersList(response: SearchResponse?): List<Character> {
        return response?.search?.map { toCharacter(it) } ?: emptyList()
    }

    fun toCharacter(response: CharacterResponse?): Character {
        return response?.let {
            Character(
                response.name,
                response.picture
            )
        } ?: run { Character() }
    }
}
