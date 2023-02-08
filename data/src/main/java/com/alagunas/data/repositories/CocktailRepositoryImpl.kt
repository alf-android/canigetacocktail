package com.alagunas.data.repositories

import com.alagunas.data.MyResult
import com.alagunas.data.datasources.local.CocktailLocalDatasource
import com.alagunas.data.datasources.remote.CocktailRemoteDatasource
import com.alagunas.domain.model.Cocktail

class CocktailRepositoryImpl(
    private val cocktailRemoteDatasource: CocktailRemoteDatasource,
    private val cocktailLocalDatasource: CocktailLocalDatasource
) : CocktailRepository {

    override suspend fun getCocktails(firstLetter: String): MyResult<List<Cocktail>, String> {
        val list = cocktailLocalDatasource.getCocktails(firstLetter)
        if (list.isEmpty()) {
            return cocktailRemoteDatasource.getCocktails(firstLetter)
        }
        return MyResult.Success(list)
    }
}