package com.bergamin.marvelcharacters.data.api

import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().newBuilder()
            .addQueryParameter("apikey", "c8fd5369ef29029e9f47daa2ae283344").build()
        val request = chain.request().newBuilder().url(url).build()

        return chain.proceed(request)
    }
}
