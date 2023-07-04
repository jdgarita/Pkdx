package com.jd.pkdx.presentation.navigation

import androidx.compose.ui.graphics.painter.Painter
import com.jd.pkdx.domain.Pokemon

sealed interface Screens {
    object PokemonList : Screens
    data class PokemonDetails(
        val pokemon: Pokemon,
        val imagePainter: Painter,
    ) : Screens
}