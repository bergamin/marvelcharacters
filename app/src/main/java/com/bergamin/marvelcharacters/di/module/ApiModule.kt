package com.bergamin.marvelcharacters.di.module

import com.bergamin.marvelcharacters.data.api.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @Provides
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }
}
