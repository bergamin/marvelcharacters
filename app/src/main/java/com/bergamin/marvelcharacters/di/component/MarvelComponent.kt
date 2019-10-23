package com.bergamin.marvelcharacters.di.component

import com.bergamin.marvelcharacters.di.module.*
import com.bergamin.marvelcharacters.feature.character.view.CharacterActivity
import com.bergamin.marvelcharacters.feature.home.view.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        NetworkModule::class,
        ApiModule::class,
        RepositoryModule::class,
        MarvelModule::class
    ]
)
interface MarvelComponent {
    fun inject(activity: HomeActivity)
    fun inject(activity: CharacterActivity)
}
