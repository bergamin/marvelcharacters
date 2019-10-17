package com.bergamin.marvelcharacters.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @SerializedName("Name") val name: String? = null,
    @SerializedName("Picture") val picture: String? = null
)
