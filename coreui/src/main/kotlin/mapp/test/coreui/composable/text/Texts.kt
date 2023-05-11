package mapp.test.coreui.composable.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import mapp.test.coreui.theme.TestAppTheme


@Composable
fun Text20sp(
    text: String,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = color
    )
}



@Composable
fun Text18spInactive(
    text: String,
    color: Color = TestAppTheme.colors.primaryText
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = color
    )
}
