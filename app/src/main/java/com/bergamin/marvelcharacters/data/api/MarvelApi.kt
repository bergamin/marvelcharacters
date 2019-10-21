package com.bergamin.marvelcharacters.data.api

import com.bergamin.marvelcharacters.data.response.CharacterResponse
import com.bergamin.marvelcharacters.data.response.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    fun getSearch(@Query("nameStartsWith") name: String): Call<SearchResponse>

    @GET("/v1/public/characters/{id}")
    fun getCharacter(@Path("id") id: String): Call<CharacterResponse>
}
