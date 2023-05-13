package mapp.test.coreui.composable.row

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryRowMaxWith(
    horizontalPadding: Dp = 0.dp,
    verticalPadding: Dp = 0.dp,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
    ) {
        content()
    }
}


@Composable
fun PrimaryRowMaxWithVerticalAlignCenter(
    horizontalPadding: Dp = 0.dp,
    verticalPadding: Dp = 0.dp,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}


@Composable
fun BoxScope.PrimaryRowMaxWithInBox(
    horizontalPadding: Dp = 18.dp,
    verticalPadding: Dp = 18.dp,
    align: Alignment = Alignment.BottomCenter,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            .align(align), verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}