package mapp.test.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mapp.test.core.data.CountryModel
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.text.PrimaryTitleText18sp

@Composable
private fun CountryItemView(
    country: CountryModel,
    onclick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.emoji,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        PrimaryTitleText18sp(
            text = country.name,
        )
        FillAvailableSpacer()
        Text(text = country.phoneCode, fontSize = 18.sp, color = Color.Red)
    }
}
