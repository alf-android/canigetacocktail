package com.alagunas.data.datamanager.db.core

import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailDatabase

fun provideDao(dataBase: CocktailDatabase): CocktailDAO {
    return dataBase.cocktailDao
}