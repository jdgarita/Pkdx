package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.jd.pkdx.presentation.icons.IcPokeball

@Composable
fun PokeBall(
    modifier: Modifier = Modifier,
    tint: Color = Color.White,
    alpha: Float = 1f,
) {
    Image(
        modifier = modifier,
        painter = rememberVectorPainter(IcPokeball),
        contentDescription = "PokeBall",
        alpha = alpha,
        colorFilter = ColorFilter.tint(tint)
    )
}