package com.alagunas.canigetacocktail.di

import com.alagunas.canigetacocktail.viewmodels.CocktailDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel {
        CocktailDetailViewModel(get())
    }
}