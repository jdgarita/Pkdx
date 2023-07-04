package com.jd.pkdx.data

import com.apollographql.apollo3.ApolloClient
import com.jd.PokemonOriginalQuery
import com.jd.pkdx.domain.PokeClient
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.domain.toDataClass

class ApolloPokeClient(
    private val apolloClient: ApolloClient,
) : PokeClient {
    override suspend fun getPokemonList(): List<Pokemon> = apolloClient
        .query(PokemonOriginalQuery())
        .execute()
        .data
        ?.pokemon
        ?.map { pokemon ->
            pokemon.toDataClass()
        }
        ?: emptyList()
}