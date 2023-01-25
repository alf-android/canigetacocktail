package com.alagunas.data.datamanager.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CocktailEntity::class], version = 1, exportSchema = false)
abstract class CocktailDatabase : RoomDatabase() {
    abstract val cocktailDao: CocktailDAO
}