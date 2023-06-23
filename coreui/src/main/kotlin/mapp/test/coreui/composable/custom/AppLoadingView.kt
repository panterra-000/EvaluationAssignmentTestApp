package mapp.test.coreui.composable.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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


@Composable
fun PrimaryCenterLoadingView(state: Boolean) {
    if (state) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(TestAppTheme.colors.dialogOverFlowBackground)
            .clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }) { },
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = TestAppTheme.colors.selectedIconTint, modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}