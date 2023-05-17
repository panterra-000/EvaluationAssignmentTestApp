package mapp.test.coreui.composable.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import mapp.test.coreui.utils.getColor

@Composable
fun RowScope.StatusStepItemView(isActive: Boolean, activeColor: String, inactiveColor: String) {
    Box(
        Modifier
            .weight(1f)
            .height(8.dp)
            .clip(RoundedCornerShape(45))
            .background(
                if (isActive) getColor(activeColor) else getColor(inactiveColor)
            )
    ) {

    }
}