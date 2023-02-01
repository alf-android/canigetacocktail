package com.alagunas.canigetacocktail.viewmodels

import androidx.lifecycle.viewModelScope
import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailEntity
import com.alagunas.domain.model.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class CocktailListViewModel(private val cocktailDAO: CocktailDAO) : BaseViewModel() {

    private val _showCocktails: MutableStateFlow<List<Cocktail>?> = MutableStateFlow(null)
    val showCocktails: StateFlow<List<Cocktail>?> = _showCocktails

    fun setCocktail(name: String) {
        viewModelScope.launch {
            cocktailDAO.insert(
                CocktailEntity(
                    id = List(1) { Random.nextInt(100) }.first(),
                    name = name,
                    desription = ""
                )
            )
        }

    }

    fun getAllCocktails() {
        viewModelScope.launch {
            val cocktail = cocktailDAO.getAll().lastOrNull()
            _showCocktails.value = null
            _showCocktails.value = listOf(
                Cocktail(
                    id = cocktail?.id ?: 0,
                    name = cocktail?.name ?: "Cocktail not found",
                    description = "${cocktailDAO.getAll().size}"
                )
            )
        }
    }
}