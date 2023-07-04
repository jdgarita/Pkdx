package com.jd.pkdx.presentation

import com.jd.pkdx.data.PokemonListState
import com.jd.pkdx.domain.PokeClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PkdxViewModel(
    private val pokeClient: PokeClient,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob()),
) {

    private val _state = MutableStateFlow(PokemonListState())
    val state = _state.asStateFlow()

    init {
        coroutineScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            _state.update {
                it.copy(
                    pokemonList = pokeClient.getPokemonList(),
                    isLoading = false
                )
            }
        }
    }
}