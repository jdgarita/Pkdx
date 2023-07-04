package com.jd.pkdx.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jd.pkdx.presentation.Type

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Composable
fun PokemonTypesTheme(
    types: List<String>,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit,
) {
    val extendedTypesColors = mapTypeToColorScheme(types = types, isDark = useDarkTheme)

    CompositionLocalProvider(
        LocalPokemonTypeColorScheme provides extendedTypesColors,
        LocalContentColor provides extendedTypesColors.onSurface
    ) {
        content()
    }
}

object PokemonTypesTheme {
    @Composable
    fun colorScheme() = LocalPokemonTypeColorScheme.current
}

@Composable
private fun mapTypeToColorScheme(
    types: List<String>,
    isDark: Boolean,
): PokemonTypeColorScheme {
    val firstType = types[0]

    if (!isDark) {
        return when (Type.valueOf(firstType)) {
            Type.Bug -> PokemonTypeColorScheme(
                primary = BugTypeColors.primaryLight,
                surface = BugTypeColors.surfaceLight,
                onSurface = BugTypeColors.onSurfaceLight,
                surfaceVariant = BugTypeColors.surfaceVariantLight
            )

            Type.Dark -> PokemonTypeColorScheme(
                primary = DarkTypeColors.primaryLight,
                surface = DarkTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = DarkTypeColors.surfaceVariantLight
            )

            Type.Dragon -> PokemonTypeColorScheme(
                primary = DragonTypeColors.primaryLight,
                surface = DragonTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = DragonTypeColors.surfaceVariantLight
            )

            Type.Electric -> PokemonTypeColorScheme(
                primary = ElectricTypeColors.primaryLight,
                surface = ElectricTypeColors.primaryLight,
                onSurface = ElectricTypeColors.onSurfaceLight,
                surfaceVariant = ElectricTypeColors.surfaceVariantLight
            )

            Type.Fairy -> PokemonTypeColorScheme(
                primary = FairyTypeColors.primaryLight,
                surface = FairyTypeColors.primaryLight,
                onSurface = FairyTypeColors.onSurfaceLight,
                surfaceVariant = FairyTypeColors.surfaceVariantLight
            )

            Type.Fighting -> PokemonTypeColorScheme(
                primary = FightingTypeColors.primaryLight,
                surface = FightingTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = FightingTypeColors.surfaceVariantLight
            )

            Type.Fire -> PokemonTypeColorScheme(
                primary = FireTypeColors.primaryLight,
                surface = FireTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = FireTypeColors.surfaceVariantLight
            )

            Type.Flying -> PokemonTypeColorScheme(
                primary = FlyingTypeColors.primaryLight,
                surface = FireTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = FireTypeColors.surfaceVariantLight
            )

            Type.Ghost -> PokemonTypeColorScheme(
                primary = GhostTypeColors.primaryLight,
                surface = GhostTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = GhostTypeColors.surfaceVariantLight
            )

            Type.Grass -> PokemonTypeColorScheme(
                primary = GrassTypeColors.primaryLight,
                surface = GrassTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = GrassTypeColors.surfaceVariantLight
            )

            Type.Ground -> PokemonTypeColorScheme(
                primary = GroundTypeColors.primaryLight,
                surface = GroundTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = GroundTypeColors.surfaceVariantLight
            )

            Type.Ice -> PokemonTypeColorScheme(
                primary = IceTypeColors.primaryLight,
                surface = IceTypeColors.primaryLight,
                onSurface = IceTypeColors.onSurfaceLight,
                surfaceVariant = IceTypeColors.surfaceVariantLight
            )

            Type.Normal -> PokemonTypeColorScheme(
                primary = NormalTypeColors.primaryLight,
                surface = NormalTypeColors.surfaceLight,
                onSurface = NormalTypeColors.onSurfaceLight,
                surfaceVariant = NormalTypeColors.surfaceVariantLight
            )

            Type.Poison -> PokemonTypeColorScheme(
                primary = PoisonTypeColors.primaryLight,
                surface = PoisonTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = PoisonTypeColors.surfaceVariantLight
            )

            Type.Psychic -> PokemonTypeColorScheme(
                primary = PsychicTypeColors.primaryLight,
                surface = PsychicTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = PsychicTypeColors.surfaceVariantLight
            )

            Type.Rock -> PokemonTypeColorScheme(
                primary = RockTypeColors.primaryLight,
                surface = RockTypeColors.primaryLight,
                onSurface = RockTypeColors.onSurfaceLight,
                surfaceVariant = RockTypeColors.surfaceVariantLight
            )

            Type.Water -> PokemonTypeColorScheme(
                primary = WaterTypeColors.primaryLight,
                surface = WaterTypeColors.primaryLight,
                onSurface = Color.White,
                surfaceVariant = WaterTypeColors.surfaceVariantLight
            )

            else -> LocalPokemonTypeColorScheme.current
        }
    } else {
        return when (Type.valueOf(firstType)) {
            Type.Bug -> PokemonTypeColorScheme(
                primary = BugTypeColors.primaryDark,
                surface = BugTypeColors.surfaceDark,
                onSurface = BugTypeColors.onSurfaceDark,
                surfaceVariant = BugTypeColors.surfaceVariantDark
            )

            Type.Dark -> PokemonTypeColorScheme(
                primary = DarkTypeColors.primaryDark,
                surface = DarkTypeColors.surfaceDark,
                onSurface = DarkTypeColors.onSurfaceDark,
                surfaceVariant = DarkTypeColors.surfaceVariantDark
            )

            Type.Dragon -> PokemonTypeColorScheme(
                primary = DragonTypeColors.primaryDark,
                surface = DragonTypeColors.surfaceDark,
                onSurface = DragonTypeColors.onSurfaceDark,
                surfaceVariant = DragonTypeColors.surfaceVariantDark
            )

            Type.Electric -> PokemonTypeColorScheme(
                primary = ElectricTypeColors.primaryDark,
                surface = ElectricTypeColors.surfaceDark,
                onSurface = ElectricTypeColors.onSurfaceDark,
                surfaceVariant = ElectricTypeColors.surfaceVariantDark
            )

            Type.Fairy -> PokemonTypeColorScheme(
                primary = FairyTypeColors.primaryDark,
                surface = FairyTypeColors.primaryDark,
                onSurface = FairyTypeColors.onSurfaceDark,
                surfaceVariant = FairyTypeColors.surfaceVariantDark
            )

            Type.Fighting -> PokemonTypeColorScheme(
                primary = FightingTypeColors.primaryDark,
                surface = FightingTypeColors.surfaceDark,
                onSurface = FightingTypeColors.onSurfaceDark,
                surfaceVariant = FightingTypeColors.surfaceVariantDark
            )

            Type.Fire -> PokemonTypeColorScheme(
                primary = FireTypeColors.primaryDark,
                surface = FireTypeColors.surfaceDark,
                onSurface = FireTypeColors.onSurfaceDark,
                surfaceVariant = FireTypeColors.surfaceVariantDark
            )

            Type.Flying -> PokemonTypeColorScheme(
                primary = FlyingTypeColors.primaryDark,
                surface = FlyingTypeColors.surfaceDark,
                onSurface = FlyingTypeColors.onSurfaceDark,
                surfaceVariant = FlyingTypeColors.surfaceVariantDark
            )

            Type.Ghost -> PokemonTypeColorScheme(
                primary = GhostTypeColors.primaryDark,
                surface = GhostTypeColors.surfaceDark,
                onSurface = GhostTypeColors.onSurfaceDark,
                surfaceVariant = GhostTypeColors.surfaceVariantDark
            )

            Type.Grass -> PokemonTypeColorScheme(
                primary = GrassTypeColors.primaryDark,
                surface = GrassTypeColors.surfaceDark,
                onSurface = GrassTypeColors.onSurfaceDark,
                surfaceVariant = GrassTypeColors.surfaceVariantDark
            )

            Type.Ground -> PokemonTypeColorScheme(
                primary = GroundTypeColors.primaryDark,
                surface = GroundTypeColors.surfaceDark,
                onSurface = GroundTypeColors.onSurfaceDark,
                surfaceVariant = GroundTypeColors.surfaceVariantDark
            )

            Type.Ice -> PokemonTypeColorScheme(
                primary = IceTypeColors.primaryDark,
                surface = IceTypeColors.surfaceDark,
                onSurface = IceTypeColors.onSurfaceDark,
                surfaceVariant = IceTypeColors.surfaceVariantDark
            )

            Type.Normal -> PokemonTypeColorScheme(
                primary = NormalTypeColors.primaryDark,
                surface = NormalTypeColors.surfaceDark,
                onSurface = NormalTypeColors.onSurfaceDark,
                surfaceVariant = NormalTypeColors.surfaceVariantDark
            )

            Type.Poison -> PokemonTypeColorScheme(
                primary = PoisonTypeColors.primaryDark,
                surface = PoisonTypeColors.surfaceDark,
                onSurface = PoisonTypeColors.onSurfaceDark,
                surfaceVariant = PoisonTypeColors.surfaceVariantDark
            )

            Type.Psychic -> PokemonTypeColorScheme(
                primary = PsychicTypeColors.primaryDark,
                surface = PsychicTypeColors.surfaceDark,
                onSurface = PsychicTypeColors.onSurfaceDark,
                surfaceVariant = PsychicTypeColors.surfaceVariantDark
            )

            Type.Rock -> PokemonTypeColorScheme(
                primary = RockTypeColors.primaryDark,
                surface = RockTypeColors.surfaceDark,
                onSurface = RockTypeColors.onSurfaceDark,
                surfaceVariant = RockTypeColors.surfaceVariantDark
            )

            Type.Water -> PokemonTypeColorScheme(
                primary = WaterTypeColors.primaryDark,
                surface = WaterTypeColors.surfaceDark,
                onSurface = WaterTypeColors.onSurfaceDark,
                surfaceVariant = WaterTypeColors.surfaceVariantDark
            )

            else -> LocalPokemonTypeColorScheme.current
        }
    }
}