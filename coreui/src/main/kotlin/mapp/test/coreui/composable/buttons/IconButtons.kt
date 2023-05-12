package mapp.test.coreui.composable.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mapp.test.coreui.R
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun PrimaryIconButton(
    @DrawableRes resId: Int,
    @DrawableRes iconTint: Color = TestAppTheme.colors.primaryIconTint,
    onclick: () -> Unit
) {
    Box(
        Modifier
            .clickable { onclick() }
            .padding(6.dp)
    ) {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = null,
            tint = iconTint
        )
    }
}



@Composable
fun BoxScope.BackClickableIcon(onclick: () -> Unit) {
    Box(modifier = Modifier.align(Alignment.CenterStart)) {
        PrimaryIconButton(resId = R.drawable.ic_back) {
            onclick()
        }
    }
}



