package com.jd.pkdx.domain

import androidx.compose.ui.graphics.Color
import com.jd.PokemonOriginalQuery
import com.jd.pkdx.presentation.mapTypeToColor

data class Pokemon(
    val id: Int,
    val name: String,
    val description: String,
    val typeOfPokemon: List<String> = listOf(),
    val category: String,
    val image: Int,
    val height: Double,
    val weight: Double,
    val genderRate: Int = -1,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
    val evolutionChain: List<Evolution> = listOf(),
)

fun Pokemon.color(): Color {
    val type = typeOfPokemon.elementAtOrNull(0)
    return type?.let { mapTypeToColor(it) } ?: Color.Magenta
}

internal fun PokemonOriginalQuery.Pokemon.toDataClass(): Pokemon {
    val detail = detail.first()
    val stats = detail.stats.map { it.baseStat }

    return Pokemon(
        id = id,
        name = formatName(this.name),
        description = formatFlavorText(this.description.first().flavorText, name),
        typeOfPokemon = detail.types.map { formatName(it.type!!.name) },
        category = species[0].genus,
        image = id,
        height = (detail.height ?: 0) / 10.0, // in decimeters
        weight = (detail.weight ?: 0) / 10.0, // in 10 gram chunks
        genderRate = this.genderRate ?: -1,
        hp = stats[0],
        attack = stats[1],
        defense = stats[2],
        specialAttack = stats[3],
        specialDefense = stats[4],
        speed = stats[5],
        evolutionChain = transformEvolutionChain(this.evolutionChain?.evolutions ?: emptyList())
    )
}

private fun transformEvolutionChain(
    list: List<PokemonOriginalQuery.Evolution>,
): List<Evolution> = list
    .map {
        if (it.targetLevels.isNotEmpty()) {
            val target = it.targetLevels.first()

            Evolution(
                id = it.id,
                targetLevel = target.level ?: -1,
                trigger = when (target.triggerType) {
                    3 -> EvolutionTrigger.UseItem
                    2 -> EvolutionTrigger.Trade
                    else -> EvolutionTrigger.LevelUp
                },
                itemId = target.itemId ?: -1
            )
        } else {
            Evolution(id = it.id)
        }
    }

private fun formatName(
    name: String,
): String = name.replaceFirstChar { it.uppercase() }

private fun formatFlavorText(
    text: String,
    pokemonName: String,
): String = text
    .replace("\n", " ")
    .replace("\u000c", " ")
    .replace("POKéMON", "pokemon")
    .replace(pokemonName.uppercase(), formatName(pokemonName))