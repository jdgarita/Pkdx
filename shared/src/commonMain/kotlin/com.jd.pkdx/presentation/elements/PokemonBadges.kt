package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jd.pkdx.presentation.theme.PokemonTypesTheme

enum class PokemonBadgesStyle {
    VERTICAL, HORIZONTAL
}

@Composable
fun PokemonBadges(
    pokemonTypes: List<String>,
    colored: Boolean = false,
    style: PokemonBadgesStyle,
) {
    PokemonTypesTheme(types = pokemonTypes) {
        GridPokemonBadges(style = style) {
            pokemonTypes.forEach { pokemonType ->
                PokemonBadge(pokemonType = pokemonType, colored = colored)
            }
        }
    }
}

@Composable
private fun GridPokemonBadges(
    style: PokemonBadgesStyle,
    content: @Composable () -> Unit,
) = when (style) {
    PokemonBadgesStyle.VERTICAL -> Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        content = { content.invoke() }
    )

    PokemonBadgesStyle.HORIZONTAL -> Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        content = { content.invoke() }
    )
}

@Composable
private fun PokemonBadge(
    pokemonType: String,
    colored: Boolean = false,
) {
    Surface(
        color = if (colored) PokemonTypesTheme.colorScheme().surface else Color(0x38FFFFFF), shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = pokemonType,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                horizontal = 12.dp, vertical = 4.dp,
            )
        )
    }
}