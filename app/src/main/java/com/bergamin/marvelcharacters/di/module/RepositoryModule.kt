package com.bergamin.marvelcharacters.di.module

import com.bergamin.marvelcharacters.data.api.MarvelApi
import com.bergamin.marvelcharacters.domain.repository.MarvelRepository
import com.bergamin.marvelcharacters.domain.repository.MarvelRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMarvelRepository(api: MarvelApi): MarvelRepository {
        return MarvelRepositoryImpl(api)
    }
}
