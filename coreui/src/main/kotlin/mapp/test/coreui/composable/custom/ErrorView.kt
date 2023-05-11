package mapp.test.coreui.composable.custom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith

@Composable
fun ErrorView(message: String = "Error:?") {
    PrimaryLazyColumnMaxWith {
        item {
            Box(Modifier.padding(12.dp)) {
                Text(text = "Error: $message", color = Color.Red)
            }
        }
    }
}