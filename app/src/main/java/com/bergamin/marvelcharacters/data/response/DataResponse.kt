package com.bergamin.marvelcharacters.data.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("results") val results: List<CharacterResponse>? = null
)
