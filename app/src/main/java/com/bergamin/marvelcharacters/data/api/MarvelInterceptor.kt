package com.bergamin.marvelcharacters.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest


class MarvelInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val publicKey = "placeholder"
        val privateKey = "placeholder"
        val timestamp = System.currentTimeMillis().toString()
        val hash = getMD5Hash(timestamp + privateKey + publicKey)

        val url = chain.request().url().newBuilder()
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("hash", hash)
            .build()
        val request = chain.request().newBuilder().url(url).build()

        return chain.proceed(request)
    }

    private fun getMD5Hash(text: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(text.toByteArray())).toString(16).padStart(32, '0')
    }
}
