package com.bergamin.marvelcharacters.data.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val search: List<CharacterResponse>? = null
)
