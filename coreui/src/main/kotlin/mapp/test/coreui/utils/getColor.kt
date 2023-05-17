package mapp.test.coreui.utils

import androidx.compose.ui.graphics.Color

fun getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}