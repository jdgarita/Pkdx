package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun PokemonImage(modifier: Modifier = Modifier, pokemonImagePainter: Painter, pokemonName: String) {
    Box(modifier = modifier) {
        PokeBall(
            modifier = Modifier.align(Alignment.Center),
            tint = Color.White,
            alpha = 0.25f
        )
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(0.8f),
            painter = pokemonImagePainter,
            contentDescription = pokemonName
        )
    }
}