package com.alagunas.usecases

import com.alagunas.data.MyResult
import com.alagunas.domain.model.Cocktail
import com.alagunas.data.repositories.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCocktailsUseCase(
    private val cocktailRepository: CocktailRepository
) : UseCase<String, Flow<MyResult<List<Cocktail>, String>>> {

    override operator fun invoke(params: String): Flow<MyResult<List<Cocktail>, String>> = flow {
        emit(cocktailRepository.getCocktails(firstLetter = params))
    }
}