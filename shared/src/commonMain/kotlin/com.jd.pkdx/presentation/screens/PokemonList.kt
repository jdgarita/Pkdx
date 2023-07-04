package com.jd.pkdx.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.elements.PokemonCard
import com.jd.pkdx.presentation.elements.PokemonCardContainer
import com.jd.pkdx.presentation.elements.ScrollDirection

@Composable
fun PokemonListScreen(
    pokemonList: List<Pokemon>,
    width: Int,
    onClick: (pokemon: Pokemon, pokemonImagePainter: Painter) -> Unit,
    listState: LazyListState,
    updateIds: String,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonCardContainer(
                content = {
                    PokemonCard(
                        width = width,
                        updateIds = updateIds,
                        pokemon = pokemon,
                        onClick = onClick,
                    )
                },
                scrollDirection = if (listState.isScrollingDown()) ScrollDirection.Backward else ScrollDirection.Forward
            )
        }
    }
}

@Composable
private fun LazyListState.isScrollingDown(): Boolean {
    val offset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) { derivedStateOf { (firstVisibleItemScrollOffset - offset) > 0 } }.value
}