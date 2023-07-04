package com.jd.pkdx.presentation.elements

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PokemonName(modifier: Modifier = Modifier, pokemonName: String) {
    Text(
        modifier = modifier,
        text = pokemonName,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.W700
    )
}