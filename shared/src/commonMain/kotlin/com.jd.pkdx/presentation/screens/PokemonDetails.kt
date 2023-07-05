package com.jd.pkdx.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jd.pkdx.CrossFadeTransitionSpec
import com.jd.pkdx.DetailsScreen
import com.jd.pkdx.FadeInTransitionSpec
import com.jd.pkdx.FadeOutTransitionSpec
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.elements.PokemonBadges
import com.jd.pkdx.presentation.elements.PokemonBadgesStyle
import com.jd.pkdx.presentation.elements.PokemonImage
import com.jd.pkdx.presentation.elements.PokemonName
import com.jd.pkdx.presentation.elements.PokemonNumber
import com.jd.pkdx.presentation.icons.Female
import com.jd.pkdx.presentation.icons.Male
import com.jd.pkdx.presentation.shared.SharedElement
import com.jd.pkdx.presentation.shared.SharedMaterialContainer
import com.jd.pkdx.presentation.theme.PokemonTypesTheme
import io.kamel.core.Resource

@Composable
fun PokemonDetailsScreen(
    pokemon: Pokemon,
    pokemonImagePainter: Resource<Painter>,
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
                    key = "$pokemon",
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
                                key = "${pokemon.id}",
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

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    SharedElement(
                        key = pokemon.name,
                        screenKey = DetailsScreen,
                        transitionSpec = CrossFadeTransitionSpec,
                    ) {
                        PokemonName(pokemonName = pokemon.name)
                    }
                    SharedElement(
                        key = "${pokemon.id}${pokemon.name}",
                        screenKey = DetailsScreen,
                        transitionSpec = CrossFadeTransitionSpec,
                    ) {
                        PokemonNumber(pokemon.id)
                    }
                }

                SharedElement(
                    key = "${pokemon.id}${pokemon.typeOfPokemon.first()}",
                    screenKey = DetailsScreen,
                    transitionSpec = CrossFadeTransitionSpec
                ) {
                    PokemonBadges(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        pokemonTypes = pokemon.typeOfPokemon,
                        colored = true,
                        style = PokemonBadgesStyle.HORIZONTAL
                    )
                }

                Text(
                    text = pokemon.description,
                    textAlign = TextAlign.Justify,
                    lineHeight = 24.sp
                )
                Surface(
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp, horizontal = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(Modifier.weight(1f)) {
                            Label(text = "Height")
                            Spacer(Modifier.height(12.dp))
                            Text("${pokemon.height}m")
                        }
                        Column(Modifier.weight(1f)) {
                            Label(text = "Weight")
                            Spacer(Modifier.height(12.dp))
                            Text("${pokemon.weight}kg")
                        }
                    }
                }
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Label(
                            text = "Gender",
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 12.dp)
                        )
                        if (pokemon.genderRate != -1) {
                            Row(Modifier.weight(2f)) {
                                val femaleGenderRate = pokemon.genderRate * 12.5
                                Row {
                                    Icon(
                                        modifier = Modifier.requiredSize(26.dp),
                                        imageVector = Male,
                                        contentDescription = null,
                                        tint = Color(0xff6C79DB)
                                    )
                                    Spacer(Modifier.width(2.dp))
                                    Text("${100 - femaleGenderRate}%")
                                }
                                Spacer(Modifier.width(12.dp))
                                Row {
                                    Icon(
                                        modifier = Modifier.requiredSize(26.dp),
                                        imageVector = Female,
                                        contentDescription = null,
                                        tint = Color(0xffF0729F)
                                    )
                                    Spacer(Modifier.width(2.dp))
                                    Text("$femaleGenderRate%")
                                }
                            }
                        } else {
                            Text(
                                "Genderless",
                                modifier = Modifier.weight(2.2f)
                            )
                        }
                    }
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

@Composable
fun Label(
    modifier: Modifier = Modifier,
    text: String,
    emphasis: Emphasis = Emphasis.Medium,
) {
    Text(
        text = text,
        modifier = modifier.graphicsLayer {
            alpha = emphasis.alpha
        },
    )
}

enum class Emphasis(val alpha: Float) {
    Disabled(0.5f),
    Medium(0.7f),
    High(1f)
}