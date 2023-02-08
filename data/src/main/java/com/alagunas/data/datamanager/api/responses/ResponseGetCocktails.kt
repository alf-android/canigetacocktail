package com.alagunas.data.datamanager.api.responses

import com.alagunas.data.datamanager.api.model.NetworkCocktail
import com.google.gson.annotations.SerializedName

data class ResponseGetCocktails(
    @SerializedName("drinks")
    val cocktails: List<NetworkCocktail>
)