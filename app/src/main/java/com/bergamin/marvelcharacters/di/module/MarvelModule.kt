package com.bergamin.marvelcharacters.di.module

import android.content.Context
import com.bergamin.marvelcharacters.common.provider.ResourceProvider
import com.bergamin.marvelcharacters.common.provider.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class MarvelModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }
}
