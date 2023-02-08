package com.alagunas.data.datasources.local

import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.toCocktail
import com.alagunas.domain.model.Cocktail

interface CocktailLocalDatasource {
    suspend fun getCocktails(firstLetter: String): List<Cocktail>
}

class CocktailLocalDatasourceImpl(private val cocktailDAO: CocktailDAO) : CocktailLocalDatasource {
    override suspend fun getCocktails(firstLetter: String): List<Cocktail> =
        cocktailDAO.getByFirstLetter(firstLetter).map { it.toCocktail() }
}