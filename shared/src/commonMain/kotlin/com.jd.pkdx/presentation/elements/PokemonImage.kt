package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import io.kamel.core.Resource
import io.kamel.image.KamelImage

@Composable
fun PokemonImage(modifier: Modifier = Modifier, pokemonImagePainter: Resource<Painter>, pokemonName: String) {
    Box(modifier = modifier) {
        PokeBall(
            modifier = Modifier.align(Alignment.Center),
            tint = Color.White,
            alpha = 0.25f
        )
        KamelImage(
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(0.8f),
            resource = pokemonImagePainter,
            contentDescription = pokemonName
        )
    }
}