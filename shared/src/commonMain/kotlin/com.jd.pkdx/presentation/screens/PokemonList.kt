package com.jd.pkdx.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.elements.PokemonCard
import com.jd.pkdx.presentation.elements.PokemonCardContainer
import com.jd.pkdx.presentation.elements.ScrollDirection
import io.kamel.core.Resource

@Composable
fun PokemonListScreen(
    pokemonList: List<Pokemon>,
    width: Int,
    onClick: (pokemon: Pokemon, pokemonImagePainter: Resource<Painter>) -> Unit,
    updateIds: String,
) {

    val scrollingDirection = mutableStateOf(ScrollDirection.Forward)
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(pokemonList) { pokemon ->

            when {
                listState.isScrollingUp() -> scrollingDirection.value = ScrollDirection.Backward
                else -> scrollingDirection.value = ScrollDirection.Forward
            }

            PokemonCardContainer(
                scrollDirection = scrollingDirection.value,
                content = {
                    PokemonCard(
                        width = width,
                        updateIds = updateIds,
                        pokemon = pokemon,
                        onClick = onClick,
                    )
                }
            )
        }
    }
}

@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}