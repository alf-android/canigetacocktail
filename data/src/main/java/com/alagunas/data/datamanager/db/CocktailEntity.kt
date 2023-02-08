package com.alagunas.data.datamanager.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alagunas.domain.model.Cocktail

@Entity(tableName = "cocktails")
data class CocktailEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "instruction") val instruction: String?
)

fun CocktailEntity.toCocktail() =
    Cocktail(
        id = id,
        name = name.orEmpty(),
        description = instruction.orEmpty()
    )