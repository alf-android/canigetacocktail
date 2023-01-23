package com.alagunas.data.datamanager.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alagunas.domain.model.Cocktail

@Dao
interface CocktailDAO {
    @Query("SELECT * FROM cocktails ORDER BY name DESC")
    suspend fun getAll(): List<CocktailEntity>

    @Query("SELECT * FROM cocktails WHERE name LIKE :nameCocktail LIMIT 1")
    suspend fun findByName(nameCocktail: String): CocktailEntity

    @Insert
    suspend fun insertAll(vararg cocktails: CocktailEntity)

    @Insert
    suspend fun insert(cocktail: CocktailEntity)

    @Delete
    suspend fun delete(cocktail: CocktailEntity)
}