package mapp.test.coreui.composable.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mapp.test.coreui.theme.TestAppTheme


@Composable
fun PrimaryChipText14sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryText
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        color = color,
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(TestAppTheme.colors.primaryTint)
            .padding(vertical = 3.dp, horizontal = 6.dp)
    )
}