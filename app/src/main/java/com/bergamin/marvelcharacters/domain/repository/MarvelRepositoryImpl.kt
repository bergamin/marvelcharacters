package com.bergamin.marvelcharacters.domain.repository

import androidx.lifecycle.MutableLiveData
import com.bergamin.marvelcharacters.data.api.MarvelApi
import com.bergamin.marvelcharacters.data.mapper.CharacterMapper
import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse
import com.bergamin.marvelcharacters.domain.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(private val api: MarvelApi) : MarvelRepository {

    override fun searchCharacters(
        name: String,
        characterLiveData: MutableLiveData<List<Character>>
    ) {
        api.getSearch(name).enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                characterLiveData.value = null
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                characterLiveData.value = CharacterMapper.toCharactersList(response.body())
            }
        })
    }

    override fun getCharacter(id: String, characterLiveData: MutableLiveData<Character>) {
        api.getCharacter(id).enqueue(object : Callback<CharacterResponse> {
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                characterLiveData.value = null
            }

            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                characterLiveData.value = CharacterMapper.toCharacter(response.body())
            }
        })
    }
}
