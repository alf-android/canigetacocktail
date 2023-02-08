package com.alagunas.canigetacocktail.viewmodels

import androidx.lifecycle.viewModelScope
import com.alagunas.data.MyResult
import com.alagunas.data.datamanager.db.CocktailDAO
import com.alagunas.data.datamanager.db.CocktailEntity
import com.alagunas.domain.model.Cocktail
import com.alagunas.data.repositories.CocktailRepository
import com.alagunas.usecases.GetCocktailsUseCase
import com.alagunas.usecases.UseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class CocktailListViewModel(
    private val cocktailDAO: CocktailDAO,
    private val cocktailRepository: CocktailRepository,
    getCocktailsUseCase: UseCase<String, Flow<MyResult<List<Cocktail>, String>>>
) : BaseViewModel() {

    private val _showCocktails: MutableStateFlow<List<Cocktail>> = MutableStateFlow(listOf())

    val showCocktails: StateFlow<MyResult<List<Cocktail>, String>> =
        getCocktailsUseCase("a").stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = MyResult.Loading
        )

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

    fun getAllCocktails() {
        viewModelScope.launch {
            val cocktail = cocktailDAO.getAll().lastOrNull()
            _showCocktails.value = listOf(
                Cocktail(
                    id = cocktail?.id ?: "0",
                    name = cocktail?.name ?: "Cocktail not found",
                    description = "${cocktailDAO.getAll().size}"
                )
            )
        }
    }
}