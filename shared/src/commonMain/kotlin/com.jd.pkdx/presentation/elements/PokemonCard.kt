package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import com.jd.pkdx.CrossFadeTransitionSpec
import com.jd.pkdx.FadeOutTransitionSpec
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.shared.SharedElement
import com.jd.pkdx.presentation.shared.SharedMaterialContainer
import com.jd.pkdx.presentation.theme.PokemonTypesTheme
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
internal fun PokemonCard(
    modifier: Modifier = Modifier,
    width: Int,
    pokemon: Pokemon,
    updateIds: String,
    onClick: (pokemon: Pokemon, pokemonImagePainter: Painter) -> Unit,
) {
    var parentOffset by remember { mutableStateOf(Offset.Unspecified) }
    var mySize by remember { mutableStateOf(0) }
    val pokemonImagePainter = rememberAsyncImagePainter(artworkUrl(pokemon.id))

    PokemonTypesTheme(types = pokemon.typeOfPokemon) {
        Box(modifier = modifier) {
            Box(
                modifier = Modifier
                    .width(width.dp)
                    .background(
                        shape = RoundedCornerShape(35.dp),
                        color = PokemonTypesTheme.colorScheme().surface
                    )
                    .aspectRatio(1.5f).clickable {
                        onClick(pokemon, pokemonImagePainter)
                    }.fillMaxHeight(),
            ) {
                PokemonNumber(pokemon.id, modifier = Modifier.align(Alignment.TopEnd))
                Column(
                    modifier = Modifier.padding(top = 25.dp, start = 20.dp)
                ) {
                    SharedElement(
                        key = "${pokemon.name}${updateIds}",
                        screenKey = "ListScreen",
                        transitionSpec = CrossFadeTransitionSpec
                    ) {
                        PokemonName(pokemonName = pokemon.name)
                    }
                    SharedElement(
                        key = "${pokemon.id}${pokemon.typeOfPokemon.first()}${updateIds}",
                        screenKey = "ListScreen",
                        transitionSpec = CrossFadeTransitionSpec
                    ) {
                        PokemonBadges(pokemonTypes = pokemon.typeOfPokemon)
                    }
                }
            }
            PokemonImageContainer(modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth(0.45f)
                .aspectRatio(1f)
                .onGloballyPositioned { coordinates ->
                    parentOffset = coordinates.positionInRoot()
                    mySize = coordinates.size.width
                }, content = {
                SharedMaterialContainer(
                    key = "${pokemon.id}${updateIds}",
                    screenKey = "ListScreen",
                    shape = CircleShape,
                    color = Color.Transparent,
                    transitionSpec = FadeOutTransitionSpec
                ) {
                    PokemonImage(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        pokemonImagePainter = pokemonImagePainter,
                        pokemonName = pokemon.name
                    )
                }
            })
        }
    }
}

private fun artworkUrl(pokemonId: Int): String =
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokemonId.toString().padStart(3, '0')}.png"