package com.jd.pkdx.di

import com.jd.pkdx.AndroidPkdxViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AndroidPkdxViewModel(get()) }
}
