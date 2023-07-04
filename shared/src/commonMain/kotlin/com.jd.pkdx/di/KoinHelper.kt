package com.jd.pkdx.di

import com.jd.pkdx.presentation.PkdxViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

object KoinHelper : KoinComponent {
    val pkdxViewModel: PkdxViewModel

    init {
        initKoin()
        pkdxViewModel = PkdxViewModel(pokeClient = get())

    }

    private fun initKoin() {
        startKoin {
            modules(commonModule)
        }
    }
}