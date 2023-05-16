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
        primary = Color(0xFF123341),
        onPrimary = Color(0xFF9C9DAF),
        primaryText = Color(0xFF9C9DAF),
        buttonText = Color(0xFFFFFFFF),
        secondaryButtonText = Color(0xFF9E95FF),
        primaryButtonBackground = Color(0xFF9E95FF),
        secondaryButtonBackground = Color(0xFFFFFFFF),
        avatarTitleText = Color(0xFFFFFFFF),
        primaryTitleText = Color(0xFF00022F),
        primaryVariant = Color(0xFF123341),
        onBackground = Color(0xFFC8C9D9),
        onSurface = Color(0xFFFFFFFF),
        surface = Color(0xFFC8C9D9),
        primaryTint = Color(0xFFF5F5F8),
        primaryIconTint = Color(0xFF9C9DAF),
        primaryBackground = Color(0xFFFFFFFF),
        avatarTopGradient = Color(0xFFABF0FF),
        avatarBottomGradient = Color(0xFF27B1FF),
        unFocusedBorderColor = Color(0xFFEDEDF3),
        focusedBorderColor = Color(0xFFEDEDF3),
        primaryBorderColor = Color(0xFFF5F5F8),
        focusedLabelColor = Color(0xFFA0A1B5),
        unFocusedLabelColor = Color(0xFFA0A1B5),
        trailingIcon = Color(0xFFC8C9D9),
        textFieldFont = Color(0xFF00022F),
        inactiveFieldFont = Color(0xFFA0A1B5),
        dialogOverFlowBackground = Color(0x4400022F),
        dialogBodyBackground = Color(0xFFFFFFFF),
        selectedIconTint = Color(0xFF037EE5),
        selectedRadioTint = Color(0xFF00A3FF),
        subTitleText = Color(0xFF818097),
        activeStatusItemTint = Color(0xFF122AFF),
        inActiveactiveStatusItemTint = Color(0xFFEDEDF3),
        )

    private val themeDark = themeLight
}
