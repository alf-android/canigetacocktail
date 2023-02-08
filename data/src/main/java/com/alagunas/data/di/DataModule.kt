package com.alagunas.data.di

import com.alagunas.data.datamanager.api.core.buildClient
import com.alagunas.data.datamanager.api.core.buildRetrofit
import com.alagunas.data.datamanager.api.service.CocktailService
import com.alagunas.data.datamanager.db.core.buildDataBase
import com.alagunas.data.datamanager.db.core.provideDao
import com.alagunas.data.datasources.local.CocktailLocalDatasource
import com.alagunas.data.datasources.local.CocktailLocalDatasourceImpl
import com.alagunas.data.datasources.remote.CocktailRemoteDatasource
import com.alagunas.data.datasources.remote.CocktailRemoteDatasourceImpl
import com.alagunas.data.repositories.CocktailRepositoryImpl
import com.alagunas.data.repositories.CocktailRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    single { buildDataBase(androidApplication()) }
    single { provideDao(get()) }
    single { buildClient() }
    single { buildRetrofit(get()) }
    single { get<Retrofit>().create(CocktailService::class.java) }

    single<CocktailRemoteDatasource> { CocktailRemoteDatasourceImpl(get()) }
    single<CocktailLocalDatasource> { CocktailLocalDatasourceImpl(get()) }
    single<CocktailRepository> { CocktailRepositoryImpl(get(), get()) }
}