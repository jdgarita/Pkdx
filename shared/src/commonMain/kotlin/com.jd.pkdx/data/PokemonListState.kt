package com.jd.pkdx.data

import com.jd.pkdx.domain.Pokemon

data class PokemonListState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val selectedPokemon: Pokemon? = null,
)