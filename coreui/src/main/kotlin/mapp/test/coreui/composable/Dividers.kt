package mapp.test.coreui.composable

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun DividerMin(){
    Divider(color = TestAppTheme.colors.primaryTint, thickness = 1.dp)
}

@Composable
fun DividerNorm(){
    Divider(color = TestAppTheme.colors.primaryTint, thickness = 2.dp)
}


@Composable
fun DividerMax(){
    Divider(color = TestAppTheme.colors.primaryTint, thickness = 3.dp)
}
