package com.jd.pkdx.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import com.jd.pkdx.CrossFadeTransitionSpec
import com.jd.pkdx.FadeOutTransitionSpec
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.elements.PokemonBadges
import com.jd.pkdx.presentation.elements.PokemonImage
import com.jd.pkdx.presentation.elements.PokemonName
import com.jd.pkdx.presentation.shared.SharedElement
import com.jd.pkdx.presentation.shared.SharedMaterialContainer
import com.jd.pkdx.presentation.theme.PokemonTypesTheme
import kotlin.math.PI

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonDetailsScreen(
    pokemon: Pokemon,
    pokemonImagePainter: Painter,
    goBack: () -> Unit,
) {

    val imageRotation = remember { mutableStateOf(0) }

    val toolbarOffsetHeightPx = remember { mutableStateOf(340f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource,
            ): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(0f, 340f)
                imageRotation.value += (available.y * 0.5).toInt()
                return Offset.Zero
            }

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource,
            ): Offset {
                val delta = available.y
                imageRotation.value += ((delta * PI / 180) * 10).toInt()
                return super.onPostScroll(consumed, available, source)
            }

            override suspend fun onPreFling(available: Velocity): Velocity {
                imageRotation.value += available.y.toInt()

                return super.onPreFling(available)
            }
        }
    }

    val candidateHeight = maxOf(toolbarOffsetHeightPx.value, 200f)
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.surface)
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(), state = listState
        ) {

            stickyHeader {
                PokemonTypesTheme(types = pokemon.typeOfPokemon) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = PokemonTypesTheme.colorScheme().surface,
                                RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp),
                            ).clip(
                                RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp),
                            ).height(candidateHeight.dp),
                    ) {
                        Box(
                            modifier = Modifier.padding(16.dp).aspectRatio(1f).align(Alignment.Center)
                        ) {
                            SharedMaterialContainer(
                                key = pokemon.image.toString(),
                                screenKey = "DetailsScreen",
                                color = Color.Transparent,
                                transitionSpec = FadeOutTransitionSpec
                            ) {
                                PokemonImage(
                                    pokemonImagePainter = pokemonImagePainter, pokemonName = pokemon.name
                                )
                            }
                        }
                    }
                }
            }

            item {
                SharedElement(
                    key = pokemon.name,
                    screenKey = "DetailsScreen",
                    transitionSpec = CrossFadeTransitionSpec,
                ) {
                    PokemonName(pokemonName = pokemon.name)
                }

                SharedElement(
                    key = "${pokemon.id}${pokemon.typeOfPokemon.first()}",
                    screenKey = "DetailsScreen",
                    transitionSpec = CrossFadeTransitionSpec
                ) {
                    PokemonBadges(pokemonTypes = pokemon.typeOfPokemon, colored = true)
                }
//
//                    AnimateInEffect(pokemon = pokemon, intervalStart = 0 / (pokemon.typeOfPokemon.size).toFloat(), content = {
//                        Text(
//                            text = "Details",
//                            style = MaterialTheme.typography.h6,
//                            fontWeight = FontWeight.W700,
//                            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
//                        )
//                    })
            }
        }

        Box(modifier = Modifier.padding(10.dp).background(
            color = Color.Black, shape = RoundedCornerShape(50)
        ).padding(5.dp).clickable {
            goBack()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}