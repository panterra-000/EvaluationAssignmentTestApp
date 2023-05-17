package mapp.test.coreui.composable.icons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mapp.test.coreui.theme.TestAppTheme
import mapp.test.coreui.utils.getColor


@Composable
fun PrimaryIcon(
    @DrawableRes resId: Int,
    @DrawableRes iconTint: Color = TestAppTheme.colors.primaryIconTint,
) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = null,
        tint = iconTint
    )
}


@Composable
fun SimpleRoundIconWithBackground(
    color: String
) {
    Box(
        Modifier
            .size(16.dp)
            .clip(RoundedCornerShape(50))
            .background(color = getColor(color))
    )
}

