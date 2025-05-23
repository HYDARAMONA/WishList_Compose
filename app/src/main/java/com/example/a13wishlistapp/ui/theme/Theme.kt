package com.example.a13wishlistapp.ui.theme

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

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),    // Light purple
    secondary = Color(0xFF03DAC6),  // Teal
    tertiary = Color(0xFF3700B3),
    background = Color(0xFF121212), // Dark background
    surface = Color(0xFF1E1E1E),    // Dark cards
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color(0xFFE6E1E5),  // Light text
    onSurface = Color(0xFFE6E1E5),
    error = Color(0xFFCF6679)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),  // Deep purple (primary actions)
    secondary = Color(0xFF03DAC6),  // Teal (secondary actions)
    tertiary = Color(0xFF3700B3),   // Dark purple (accent)
    background = Color(0xFFFFFBFE),  // Off-white (background)
    surface = Color(0xFFFFFBFE),     // Card/item background
    onPrimary = Color.White,         // Text/icons on primary
    onSecondary = Color.Black,       // Text/icons on secondary
    onBackground = Color(0xFF1C1B1F),  // Dark gray (text)
    onSurface = Color(0xFF1C1B1F),     // Text on cards
    error = Color(0xFFB00020)       // Error red
)

@Composable
fun _13WishListAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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