package mapp.test.coreui.composable.icons

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import mapp.test.coreui.theme.TestAppTheme


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
fun SimpleIcon(
    @DrawableRes resId: Int,
) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = null,
    )
}