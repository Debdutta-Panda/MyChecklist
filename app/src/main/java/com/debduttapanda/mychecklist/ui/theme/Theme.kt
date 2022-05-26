package com.debduttapanda.mychecklist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = blue,
    primaryVariant = blueVariant,
    secondary = red,
    background = Color(0xff1a1a1a),
    surface = Color(0xff1a1a1a),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = blue,
    onSurface = blue,
)

private val LightColorPalette = lightColors(
    primary = blue,
    primaryVariant = blueVariant,
    secondary = red,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = blue,
    onSurface = blue,
)

@Composable
fun MyChecklistTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}