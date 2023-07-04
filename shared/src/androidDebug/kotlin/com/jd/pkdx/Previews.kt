package com.jd.pkdx

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jd.pkdx.domain.Pokemon
import com.jd.pkdx.presentation.theme.AppTheme
import com.jd.pkdx.presentation.elements.PokeBall

//@Preview
//@Composable
//fun PokemonListScreenPreview() {
//    val state = PokemonListState(listOf(fakePokemon()))
//    PokemonListScreen(state)
//}


fun fakePokemon() = Pokemon(
    id = 1,
    name = "Charmander",
    description = "Fire Typed Pokemon",
    typeOfPokemon = listOf("Fire"),
    category = "Fire",
    image = 1,
    height = 10.0, // in decimeters
    weight = 1.0, // in 10 gram chunks
    genderRate = 50,
    hp = 20,
    attack = 10,
    defense = 4,
    specialAttack = 15,
    specialDefense = 10,
    speed = 16,
    evolutionChain = emptyList()
)


@Preview
@Composable
fun PreviewPokeBall() {
    AppTheme {
        Surface {
            PokeBall()
        }
    }
}