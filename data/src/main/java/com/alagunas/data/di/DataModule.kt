package com.alagunas.data.di

import android.app.Application
import androidx.room.Room
import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    fun provideDataBase(application: Application): CocktailDatabase {
        return Room.databaseBuilder(application, CocktailDatabase::class.java, "CocktailDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: CocktailDatabase): CocktailDAO {
        return dataBase.cocktailDao
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}