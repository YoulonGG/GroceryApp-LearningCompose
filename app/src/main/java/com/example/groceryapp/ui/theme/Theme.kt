package com.example.groceryapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = GreenLight,
    //For background
    secondary = White,
    surface = Dark,

    //Always Dark
    onSecondary = Dark,
    //Always White
    onSurface = White,

    tertiary = Color.Gray,

    onBackground = blue2,
    background = blue1

)

private val DarkColorScheme = darkColorScheme(
    primary = GreenLight,
    //For background
    secondary = Dark,
    surface = White,

    //Always Dark
    onSecondary = Dark,
    //Always White
    onSurface = White,

    tertiary = Color.Gray,

    onBackground = blue2,
    background = blue1,
)


@Composable
fun GroceryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}




