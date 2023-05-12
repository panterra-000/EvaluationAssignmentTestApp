package mapp.test.coreui.composable.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mapp.test.coreui.composable.text.PrimaryTitleText16sp
import mapp.test.coreui.theme.TestAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RowScope.PrimaryButtonInRow(
    text: String = "", onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(6.dp), onClick = {
            onClick()
        },
        backgroundColor = TestAppTheme.colors.primaryButtonBackground,
        modifier = Modifier.weight(1f)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryTitleText16sp(text = text, color = TestAppTheme.colors.buttonText)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RowScope.SecondaryButtonInRow(
    text: String = "", onClick: () -> Unit
) {
    Card(
        border = BorderStroke(1.4.dp, color = TestAppTheme.colors.primaryButtonBackground),
        shape = RoundedCornerShape(6.dp), onClick = {
            onClick()
        },
        backgroundColor = TestAppTheme.colors.secondaryButtonBackground,
        modifier = Modifier.weight(1f)
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            PrimaryTitleText16sp(text = text, color = TestAppTheme.colors.secondaryButtonText)
        }
    }
}