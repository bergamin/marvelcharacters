package com.bergamin.marvelcharacters.data.response

import com.google.gson.annotations.SerializedName

data class ThumbnailResponse(
    @SerializedName("extension") val extension: String? = null,
    @SerializedName("path") val path: String? = null
)
