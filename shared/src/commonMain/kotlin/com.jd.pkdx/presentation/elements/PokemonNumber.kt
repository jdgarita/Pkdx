package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PokemonNumber(pokemonId: Int = 0, modifier: Modifier = Modifier) {
    Text(
        text = formatId(pokemonId),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h6,
        modifier = modifier
            .padding(top = 20.dp, end = 20.dp)
            .graphicsLayer {
                alpha = 0.5f
            },
    )
}

private fun formatId(id: Int): String = "#" + "$id".padStart(3, '0')