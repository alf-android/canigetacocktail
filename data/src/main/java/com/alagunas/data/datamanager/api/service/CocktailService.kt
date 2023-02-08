package com.alagunas.data.datamanager.api.service

import com.alagunas.data.datamanager.api.responses.ResponseGetCocktails
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface CocktailService {

    @GET("search.php")
    suspend fun getCocktailsByFirstLetter(
        @Query("f") firstLetter: String
    ): Response<ResponseGetCocktails>

    @GET("search.php")
    suspend fun getCocktailsByName(
        @Query("s") name: String
    ): Response<ResponseGetCocktails>

}