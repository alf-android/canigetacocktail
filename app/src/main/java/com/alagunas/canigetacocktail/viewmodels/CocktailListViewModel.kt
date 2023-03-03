package com.alagunas.canigetacocktail.viewmodels

import androidx.lifecycle.viewModelScope
import com.alagunas.data.MyResult
import com.alagunas.domain.model.Cocktail
import com.alagunas.usecases.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CocktailListViewModel(
    private val getCocktailsUseCase: UseCase<String, Flow<MyResult<List<Cocktail>, String>>>
) : BaseViewModel() {

    private val _showCocktails: MutableStateFlow<MyResult<List<Cocktail>, String>> =
        MutableStateFlow(MyResult.Loading)
    val showCocktails = _showCocktails.asStateFlow()

    init {
        getCocktailsByFirstLetter("A")
    }

    fun getCocktailsByFirstLetter(fl: String) {
        viewModelScope.launch {
            _showCocktails.value = getCocktailsUseCase(fl).first()
        }
    }
}