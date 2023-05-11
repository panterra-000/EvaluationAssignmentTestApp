package mapp.test.coreui.composable.row

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun PrimaryScrollableRow(
    content: @Composable RowScope.() -> Unit
) {
    Row(Modifier.horizontalScroll(rememberScrollState())) {
        content()
    }
}