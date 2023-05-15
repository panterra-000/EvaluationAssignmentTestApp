package mapp.test.coreui.composable.custom

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun BoxScope.PrimaryLoadingView(state: Boolean) {
    if (state) {
        CircularProgressIndicator(
            color = TestAppTheme.colors.selectedIconTint, modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}