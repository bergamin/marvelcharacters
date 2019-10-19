package com.bergamin.marvelcharacters

import android.app.Application
import com.bergamin.marvelcharacters.di.component.DaggerMarvelComponent
import com.bergamin.marvelcharacters.di.component.MarvelComponent
import com.bergamin.marvelcharacters.di.module.MarvelModule

class MarvelApplication : Application() {

    companion object {
        lateinit var appComponent: MarvelComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerMarvelComponent
            .builder()
            .marvelModule(MarvelModule(this))
            .build()
    }
}
