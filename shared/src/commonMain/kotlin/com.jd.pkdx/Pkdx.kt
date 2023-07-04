package com.jd.pkdx

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import com.jd.pkdx.data.PokemonListState
import com.jd.pkdx.presentation.animations.ProgressThresholds
import com.jd.pkdx.presentation.navigation.Screens
import com.jd.pkdx.presentation.screens.PokemonDetailsScreen
import com.jd.pkdx.presentation.screens.PokemonListScreen
import com.jd.pkdx.presentation.shared.FadeMode
import com.jd.pkdx.presentation.shared.MaterialContainerTransformSpec
import com.jd.pkdx.presentation.shared.SharedElementsRoot
import com.jd.pkdx.presentation.shared.SharedElementsTransitionSpec
import com.jd.pkdx.presentation.theme.AppTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Pkdx(state: PokemonListState) {
    var width by remember { mutableStateOf(0) }
    var updateIds by remember { mutableStateOf("") }

    AppTheme {
        val currentScreen = remember { mutableStateOf<Screens>(Screens.PokemonList) }
        Surface(
            Modifier.fillMaxSize().onGloballyPositioned { width = it.size.width },
            color = MaterialTheme.colors.surface
        ) {
            SharedElementsRoot {
                val sharedTransition = this
                Box(modifier = Modifier.fillMaxSize()) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {
                        PokemonListScreen(
                            width = width,
                            updateIds = updateIds,
                            pokemonList = state.pokemonList,
                            onClick = { pokemon, pokemonImagePainter ->
                                prepareTransition(
                                    pokemon.id,
                                    pokemon.name,
                                    pokemon.typeOfPokemon,
                                    pokemonImagePainter
                                )
                                updateIds = "abc"

                                currentScreen.value = Screens.PokemonDetails(
                                    pokemon = pokemon,
                                    imagePainter = pokemonImagePainter
                                )
                            }
                        )
                    }

                    when (val screen = currentScreen.value) {
                        is Screens.PokemonDetails -> {
                            PokemonDetailsScreen(
                                pokemon = screen.pokemon,
                                pokemonImagePainter = screen.imagePainter,
                                goBack = {
                                    updateIds = ""
                                    GlobalScope.launch {
                                        delay(100)
                                        sharedTransition.prepareTransition()
                                        currentScreen.value = Screens.PokemonList
                                    }
                                }
                            )
                        }

                        Screens.PokemonList -> Unit
                    }
                }
            }
        }
    }
}

const val ListScreen = "list"
const val DetailsScreen = "details"

private const val TransitionDurationMillis = 700

val FadeOutTransitionSpec = MaterialContainerTransformSpec(
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.Out
)

val FadeInTransitionSpec = MaterialContainerTransformSpec(
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.In
)

val CrossFadeTransitionSpec = SharedElementsTransitionSpec(
    durationMillis = TransitionDurationMillis,
    fadeMode = FadeMode.Cross,
    fadeProgressThresholds = ProgressThresholds(0.10f, 0.40f)
)