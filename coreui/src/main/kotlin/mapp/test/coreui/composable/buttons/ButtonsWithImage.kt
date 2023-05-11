package mapp.test.coreui.composable.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mapp.test.coreui.R
import mapp.test.coreui.composable.DividerMin
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.text.PrimaryTitleText16sp
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun IconButtonWithTitle(
    @DrawableRes resourceId: Int,
    iconTint: Color = TestAppTheme.colors.primaryIconTint,
    title: String,
    onclick: () -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable { onclick() }
                .padding(vertical = 21.dp, horizontal = 18.dp)

        ) {
            Icon(
                painter = painterResource(id = resourceId),
                contentDescription = null,
                tint = iconTint
            )
            Spacer18dp()
            PrimaryTitleText16sp(text = title)
        }
        DividerMin()
    }
}

@Composable
fun CreateLeadButton(
    onclick: () -> Unit
) {
    IconButtonWithTitle(
        resourceId = R.drawable.ic_add_new,
        title = stringResource(id = R.string.create_new_lead)
    ) {
        onclick()
    }
}