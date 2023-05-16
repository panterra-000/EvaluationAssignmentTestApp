package mapp.test.coreui.composable.custom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mapp.test.coreui.composable.DividerMin
import mapp.test.coreui.composable.buttons.BackClickableIcon
import mapp.test.coreui.composable.text.PrimaryTitleText18sp

@Composable
fun PrimaryScrollableColumnBodyWithAppBar(
    title: String = "",
    padding: Dp = 18.dp,
    backClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            BackClickableIcon {
                backClick()
            }
            Box(modifier = Modifier.align(Alignment.Center)) {
                PrimaryTitleText18sp(text = title)
            }
        }
        DividerMin()
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            content()
        }
    }
}