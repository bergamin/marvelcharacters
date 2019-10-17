package com.bergamin.marvelcharacters.data.api

import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/")
    fun getSearch(@Query("name") name: String): Call<SearchResponse>

    @GET("/")
    fun getCharacter(@Query("") id: String): Call<CharacterResponse>
}
