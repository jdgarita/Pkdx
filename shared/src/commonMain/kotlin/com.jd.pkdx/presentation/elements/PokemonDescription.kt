package com.jd.pkdx.presentation.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PokemonDescription(pokemonDescription: String) {
    Text(
        text = pokemonDescription,
        textAlign = TextAlign.Justify,
        lineHeight = 24.sp
    )
}