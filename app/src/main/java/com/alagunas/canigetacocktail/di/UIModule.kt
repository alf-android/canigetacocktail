package com.alagunas.canigetacocktail.di

import com.alagunas.canigetacocktail.viewmodels.CocktailDetailViewModel
import com.alagunas.canigetacocktail.viewmodels.CocktailListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { CocktailListViewModel(get()) }
    viewModel { CocktailDetailViewModel(get()) }
}