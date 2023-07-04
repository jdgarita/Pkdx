package com.jd.pkdx.domain

interface PokeClient {
    suspend fun getPokemonList(): List<Pokemon>
}