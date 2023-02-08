package com.alagunas.usecases.di

import com.alagunas.data.MyResult
import com.alagunas.domain.model.Cocktail
import com.alagunas.usecases.GetCocktailsUseCase
import com.alagunas.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module

val useCasesModule = module {
    single<UseCase<String, Flow<MyResult<List<Cocktail>, String>>>> { GetCocktailsUseCase(get()) }
}