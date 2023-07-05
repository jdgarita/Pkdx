package com.jd.pkdx.presentation.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jd.pkdx.presentation.icons.Female
import com.jd.pkdx.presentation.icons.Male
import com.jd.pkdx.presentation.screens.Label

@Composable
fun PokemonGenderTable(pokemonGenderRate: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Label(
            text = "Gender",
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)
        )
        if (pokemonGenderRate != -1) {
            Row(Modifier.weight(2f)) {
                val femaleGenderRate = pokemonGenderRate * 12.5
                Row {
                    Icon(
                        modifier = Modifier.requiredSize(26.dp),
                        imageVector = Male,
                        contentDescription = null,
                        tint = Color(0xff6C79DB)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text("${100 - femaleGenderRate}%")
                }
                Spacer(Modifier.width(12.dp))
                Row {
                    Icon(
                        modifier = Modifier.requiredSize(26.dp),
                        imageVector = Female,
                        contentDescription = null,
                        tint = Color(0xffF0729F)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text("$femaleGenderRate%")
                }
            }
        } else {
            Text(
                "Genderless",
                modifier = Modifier.weight(2.2f)
            )
        }
    }
}