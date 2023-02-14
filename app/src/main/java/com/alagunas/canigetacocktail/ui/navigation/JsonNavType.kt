package com.alagunas.canigetacocktail.ui.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.alagunas.domain.model.Cocktail
import com.google.gson.Gson

abstract class JsonNavType<T> : NavType<T>(isNullableAllowed = false) {
    abstract fun fromJsonParse(value: String): T
    abstract fun T.getJsonParse(): String

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { parseValue(it) }

    override fun parseValue(value: String): T = fromJsonParse(value)

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.getJsonParse())
    }
}

class CocktailArgType : JsonNavType<Cocktail>() {
    override fun fromJsonParse(value: String): Cocktail = Gson().fromJson(value, Cocktail::class.java)

    override fun Cocktail.getJsonParse(): String = Gson().toJson(this)
}