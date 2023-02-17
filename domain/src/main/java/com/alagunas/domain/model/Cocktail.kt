package com.alagunas.domain.model

import android.net.Uri
import com.google.gson.Gson

data class Cocktail(
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val thumb: String? = null
) {
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}
