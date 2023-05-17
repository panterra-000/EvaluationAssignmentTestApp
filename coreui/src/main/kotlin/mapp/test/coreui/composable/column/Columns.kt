package mapp.test.coreui.composable.column

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import mapp.test.coreui.theme.TestAppTheme


@Composable
fun PrimaryColumnMaxSize(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        content()
    }
}


@Composable
fun PrimaryColumnMaxWidth(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
        content()
    }
}

@Composable
fun PrimaryBorderedColumnMaxSize(
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(2.dp, color = TestAppTheme.colors.primaryBorderColor))
            .clickable { onClick() }
            .padding(14.dp)
    ) {
        content()
    }
}
