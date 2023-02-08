package com.alagunas.data.repositories

import com.alagunas.data.MyResult
import com.alagunas.domain.model.Cocktail

interface CocktailRepository {
    suspend fun getCocktails(firstLetter: String): MyResult<List<Cocktail>, String>
}