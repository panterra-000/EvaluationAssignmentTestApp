package mapp.test.coreui.theme

import androidx.compose.ui.graphics.Color

object ThemeColor {

    fun getColors(darkTheme: Boolean): TestAppColors {
        return if (darkTheme) {
            themeDark
        } else {
            themeLight
        }
    }

    private val themeLight = TestAppColors(
        primary = Color(0xFFf3f4f6),
        onPrimary = Color(0xFFf3f4f6),
        primaryText = Color(0xFF9C9DAF),
        avatarTitleText = Color(0xFFFFFFFF),
        primaryTitleText = Color(0xFF00022F),
        primaryVariant = Color(0xFFf3f4f6),
        onBackground = Color(0xFFf3f4f6),
        onSurface = Color(0xFFf3f4f6),
        surface = Color(0xFFf3f4f6),
        primaryTint = Color(0xFFF5F5F8),
        primaryIconTint = Color(0xFF9C9DAF),
        primaryBackground = Color(0xFFFFFFFF),
        avatarTopGradient = Color(0xFFABF0FF),
        avatarBottomGradient = Color(0xFF27B1FF),
    )

    private val themeDark = themeLight
}
