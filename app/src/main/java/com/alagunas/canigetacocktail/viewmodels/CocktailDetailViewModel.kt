package com.alagunas.canigetacocktail.viewmodels

import androidx.lifecycle.viewModelScope
import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailEntity
import com.alagunas.domain.model.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class CocktailDetailViewModel(private val cocktailDAO: CocktailDAO) : BaseViewModel() {

    private val _showCocktail: MutableStateFlow<Cocktail?> = MutableStateFlow(null)
    val showCocktail: StateFlow<Cocktail?> = _showCocktail

    fun setCocktail(name: String) {
        viewModelScope.launch {
//            cocktailDAO.insert(
//                CocktailEntity(
//                    id = List(1) { Random.nextInt(100) }.first().toString(),
//                    name = name
//                )
//            )
        }

    }
}