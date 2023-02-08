package com.alagunas.data.datamanager.db.core

import android.app.Application
import androidx.room.Room
import com.alagunas.data.datamanager.db.CocktailDatabase

fun buildDataBase(application: Application): CocktailDatabase =
    Room.databaseBuilder(application, CocktailDatabase::class.java, "CocktailDB")
        .fallbackToDestructiveMigration()
        .build()