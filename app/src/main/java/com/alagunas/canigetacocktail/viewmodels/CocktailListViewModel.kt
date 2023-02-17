package com.alagunas.canigetacocktail.viewmodels

import androidx.lifecycle.viewModelScope
import com.alagunas.data.MyResult
import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailEntity
import com.alagunas.domain.model.Cocktail
import com.alagunas.usecases.core.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.random.Random

class CocktailListViewModel(
    private val cocktailDAO: CocktailDAO,
    private val getCocktailsUseCase: UseCase<String, Flow<MyResult<List<Cocktail>, String>>>
) : BaseViewModel() {

//    val showCocktails: StateFlow<MyResult<List<Cocktail>, String>> =
//        getCocktailsUseCase("a").stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.Eagerly,
//            initialValue = MyResult.Loading
//        )

    private val _showCocktails: MutableStateFlow<MyResult<List<Cocktail>, String>> =
        MutableStateFlow(MyResult.Loading)
    val showCocktails = _showCocktails.asStateFlow()

    init {
        getCocktailsByFirstLetter("A")
    }

    fun setCocktail(name: String) {
        viewModelScope.launch {
            cocktailDAO.insert(
                CocktailEntity(
                    id = List(1) { Random.nextInt(100) }.first().toString(),
                    name = name,
                    instruction = ""
                )
            )
        }
    }

    fun getCocktailsByFirstLetter(fl: String) {
        viewModelScope.launch {
            _showCocktails.value = getCocktailsUseCase(fl).first()
        }
    }
}