package com.alagunas.canigetacocktail

import android.app.Application
import com.alagunas.canigetacocktail.di.uiModule
import com.alagunas.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CocktailApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@CocktailApplication)
            modules(
                listOf(uiModule, dataModule)
            )
        }
    }
}