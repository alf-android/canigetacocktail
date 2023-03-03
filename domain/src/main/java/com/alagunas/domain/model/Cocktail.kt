package com.alagunas.domain.model

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Cocktail(
    val id: String,
    val name: String? = null,
    val alternativeName: String? = null,
    val instructionsEN: String? = null,
    val instructionsES: String? = null,
    val instructionsDE: String? = null,
    val instructionsFR: String? = null,
    val instructionsIT: String? = null,
    val ingredients: List<String> = listOf(),
    val measures: List<String> = listOf(),
    val thumb: String? = null
) {
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}

fun Cocktail.bestInstruction() =
    instructionsES ?: instructionsEN ?: instructionsDE ?: instructionsFR ?: instructionsIT
    ?: "No instructions."

fun Cocktail.bestName() = when {
    name == null && alternativeName != null -> alternativeName
    name != null && alternativeName == null -> name
    name != null && alternativeName != null -> "$name ($alternativeName)"
    else -> null
}

fun Cocktail.ingredientsWithMeasure() = ingredients.mapIndexed { index, ingredient ->
    if (index < measures.size) {
        "$ingredient (${measures[index]})"
    } else ingredient
}