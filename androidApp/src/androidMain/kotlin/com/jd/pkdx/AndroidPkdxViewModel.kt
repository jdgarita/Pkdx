package com.jd.pkdx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jd.pkdx.domain.PokeClient
import com.jd.pkdx.presentation.PkdxViewModel

class AndroidPkdxViewModel(pokeClient: PokeClient) : ViewModel() {

    private val pkdxViewModel = PkdxViewModel(pokeClient = pokeClient, coroutineScope = viewModelScope)
    val state = pkdxViewModel.state
}