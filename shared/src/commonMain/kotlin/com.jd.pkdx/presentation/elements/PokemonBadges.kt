package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
    modifier: Modifier = Modifier,
    pokemonTypes: List<String>,
    colored: Boolean = false,
    style: PokemonBadgesStyle,
) {
    val numberOfColumns = if (style == PokemonBadgesStyle.VERTICAL) 1 else 2
    val width = if (style == PokemonBadgesStyle.VERTICAL) 100.dp else 200.dp
    PokemonTypesTheme(types = pokemonTypes) {
        LazyVerticalGrid(
            modifier = modifier.width(width),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            columns = GridCells.Fixed(numberOfColumns)
        ) {
            items(items = pokemonTypes) { pokemonType ->
                PokemonBadge(pokemonType = pokemonType, colored = colored)
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
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