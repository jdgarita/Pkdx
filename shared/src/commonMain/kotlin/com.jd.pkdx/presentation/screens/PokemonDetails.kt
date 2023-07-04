package com.jd.pkdx.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.jd.pkdx.CrossFadeTransitionSpec
import com.jd.pkdx.DetailsScreen
import com.jd.pkdx.FadeInTransitionSpec
import com.jd.pkdx.FadeOutTransitionSpec
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.elements.PokemonBadges
import com.jd.pkdx.presentation.elements.PokemonImage
import com.jd.pkdx.presentation.elements.PokemonName
import com.jd.pkdx.presentation.shared.SharedElement
import com.jd.pkdx.presentation.shared.SharedMaterialContainer
import com.jd.pkdx.presentation.theme.PokemonTypesTheme
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun PokemonDetailsScreen(
    pokemon: Pokemon,
    pokemonImagePainter: Painter,
    goBack: () -> Unit,
) {

    val toolbarOffsetHeightPx = remember { mutableStateOf(340f) }

    val candidateHeight = maxOf(toolbarOffsetHeightPx.value, 200f)
    val (fraction, setFraction) = remember { mutableStateOf(1f) }

    PokemonTypesTheme(types = pokemon.typeOfPokemon) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.surface)
        ) {
            Box {

                SharedMaterialContainer(
                    key = "$pokemon ",
                    screenKey = DetailsScreen,
                    color = PokemonTypesTheme.colorScheme().surface,
                    shape = RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp),
                    onFractionChanged = setFraction,
                    transitionSpec = FadeInTransitionSpec
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.Transparent,
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
                                screenKey = DetailsScreen,
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

            Box {
                SharedElement(
                    key = pokemon.name,
                    screenKey = DetailsScreen,
                    transitionSpec = CrossFadeTransitionSpec,
                ) {
                    PokemonName(pokemonName = pokemon.name)
                }

                SharedElement(
                    key = "${pokemon.id}${pokemon.typeOfPokemon.first()}",
                    screenKey = DetailsScreen,
                    transitionSpec = CrossFadeTransitionSpec
                ) {
                    PokemonBadges(pokemonTypes = pokemon.typeOfPokemon, colored = true)
                }
            }
        }
        Box(
            modifier = Modifier.padding(10.dp).background(
                color = Color.Black, shape = RoundedCornerShape(50)
            ).padding(5.dp).clickable(onClick = goBack)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}