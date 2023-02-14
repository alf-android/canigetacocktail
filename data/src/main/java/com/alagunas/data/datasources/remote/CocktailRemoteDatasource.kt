package com.alagunas.data.datasources.remote

import com.alagunas.data.MyResult
import com.alagunas.data.datamanager.api.model.toCocktail
import com.alagunas.data.datamanager.api.service.CocktailService
import com.alagunas.domain.model.Cocktail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CocktailRemoteDatasource {
    suspend fun getCocktails(firstLetter: String): MyResult<List<Cocktail>, String>
}

class CocktailRemoteDatasourceImpl(
    private val cocktailService: CocktailService,
    private val backDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CocktailRemoteDatasource {
    override suspend fun getCocktails(firstLetter: String): MyResult<List<Cocktail>, String> =
        withContext(backDispatcher) {
            return@withContext try {
                val resultCall = cocktailService.getCocktailsByFirstLetter(firstLetter)
                if (resultCall.isSuccessful) {
                    MyResult.Success(resultCall.body()?.cocktails?.map { it.toCocktail() }
                        ?: listOf())
                } else {
                    MyResult.Error("API Error (code: ${resultCall.code()})")
                }
            } catch (e: Exception) {
                MyResult.NoInternet
            }
        }

}