package mapp.test.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TestAppColors(
    val primaryText: Color,
    val primaryTitleText: Color,
    val avatarTitleText: Color,
    val primary: Color,
    val primaryVariant: Color,
    val surface: Color,
    val onPrimary: Color,
    val onSurface: Color,
    val onBackground: Color,
    val primaryTint: Color,
    val primaryBackground: Color,
    val avatarTopGradient: Color,
    val avatarBottomGradient: Color,
    val primaryIconTint: Color,
)

@Composable
fun PrimaryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: TestAppColors = ThemeColor.getColors(darkTheme),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        MaterialTheme(
            colors = MaterialTheme.colors.copy(
                primary = colors.primary,
                primaryVariant = colors.primaryVariant,
                surface = colors.surface,
                onPrimary = colors.onPrimary,
                onSurface = colors.onSurface,
                onBackground = colors.onSurface,
            ), typography = Typography, shapes = Shapes, content = content
        )
    }
}

val LocalColors = staticCompositionLocalOf<TestAppColors> {
    error("No LocalColors specified")
}

object TestAppTheme {
    val colors: TestAppColors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography
}