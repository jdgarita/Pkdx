package com.jd.pkdx.presentation.navigation

import androidx.compose.ui.graphics.painter.Painter
import com.jd.pkdx.domain.Pokemon
import io.kamel.core.Resource

sealed interface Screens {
    object PokemonList : Screens
    data class PokemonDetails(
        val pokemon: Pokemon,
        val imagePainter: Resource<Painter>,
    ) : Screens
}