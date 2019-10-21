package com.bergamin.marvelcharacters.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("thumbnail") val thumbnail: ThumbnailResponse? = null
)
