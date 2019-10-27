package com.bergamin.marvelcharacters.data.mapper

import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.DataResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse
import com.bergamin.marvelcharacters.data.response.ThumbnailResponse
import com.bergamin.marvelcharacters.domain.model.Character
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CharacterMapperTest {

    @Test
    fun characterResponseToCharacter() {
        assertThat(CharacterMapper.toCharacter(character1Response))
            .isEqualTo(character1)
    }

    @Test
    fun charactersListResponseToCharactersList() {
        assertThat(CharacterMapper.toCharactersList(SearchResponse(dataResponse)))
            .containsExactlyElementsIn(listOf(character1, character2))
    }

    private val dataResponse by lazy {
        DataResponse(listOf(character1Response, character2Response))
    }
    private val character1Response by lazy {
        CharacterResponse(
            "1009610",
            "Spider-Man",
            "Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider. Adopting the name Spider-Man, Peter hoped to start a career using his new abilities. Taught that with great power comes great responsibility, Spidey has vowed to use his powers to help people.",
            thumbnail1Response
        )
    }
    private val character1 by lazy {
        Character(
            "1009610",
            "Spider-Man",
            "Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider. Adopting the name Spider-Man, Peter hoped to start a career using his new abilities. Taught that with great power comes great responsibility, Spidey has vowed to use his powers to help people.",
            "http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b.jpg"
        )
    }
    private val thumbnail1Response by lazy {
        ThumbnailResponse(
            "jpg",
            "http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b"
        )
    }

    private val character2Response by lazy {
        CharacterResponse(
            "1009157",
            "Spider-Girl (Anya Corazon)",
            " ",
            thumbnail2Response
        )
    }
    private val character2 by lazy {
        Character(
            "1009157",
            "Spider-Girl (Anya Corazon)",
            " ",
            "http://i.annihil.us/u/prod/marvel/i/mg/a/10/528d369de3e4f.jpg"
        )
    }
    private val thumbnail2Response by lazy {
        ThumbnailResponse(
            "jpg",
            "http://i.annihil.us/u/prod/marvel/i/mg/a/10/528d369de3e4f"
        )
    }
}
