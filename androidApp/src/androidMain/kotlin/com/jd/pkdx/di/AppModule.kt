package com.jd.pkdx.di

import com.jd.pkdx.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PokemonListViewModel(get()) }
}