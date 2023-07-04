package com.jd.pkdx.di

import com.apollographql.apollo3.ApolloClient
import com.jd.pkdx.data.ApolloPokeClient
import com.jd.pkdx.domain.PokeClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(ApolloClient.Builder().serverUrl("https://beta.pokeapi.co/graphql/v1beta")::build)
    factory<PokeClient> { ApolloPokeClient(get()) }
}