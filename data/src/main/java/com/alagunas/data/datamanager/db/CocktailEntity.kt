package com.alagunas.data.datamanager.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alagunas.domain.model.Cocktail

@Entity(tableName = "cocktails")
data class CocktailEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "alternativeName") val alternativeName: String?,
    @ColumnInfo(name = "instructionsEN") val instructionsEN: String?,
    @ColumnInfo(name = "instructionsES") val instructionsES: String?,
    @ColumnInfo(name = "instructionsDE") val instructionsDE: String?,
    @ColumnInfo(name = "instructionsFR") val instructionsFR: String?,
    @ColumnInfo(name = "instructionsIT") val instructionsIT: String?,
    @ColumnInfo(name = "thumb") val thumb: String?
)

fun CocktailEntity.toCocktail() =
    Cocktail(
        id = id,
        name = name,
        alternativeName = alternativeName,
        instructionsEN = instructionsEN,
        instructionsES = instructionsES,
        instructionsDE = instructionsDE,
        instructionsFR = instructionsFR,
        instructionsIT = instructionsIT,
        thumb = thumb
    )