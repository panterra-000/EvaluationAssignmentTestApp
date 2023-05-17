package mapp.test.coreui.composable.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import mapp.test.coreui.theme.TestAppTheme


@Composable
fun ActiveTitleText18sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = color,
        fontWeight = FontWeight(600),
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}


@Composable
fun ActiveTitleText22sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 22.sp,
        color = color,
        fontWeight = FontWeight(600),
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}


@Composable
fun ActiveTitleText20sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = color,
        fontWeight = FontWeight(600),
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}



@Composable
fun AvatarText23sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.avatarTitleText
) {
    Text(
        text = text,
        fontSize = 23.sp,
        color = color,
        fontWeight = FontWeight(600),
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun PrimaryTitleText16sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryText
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        color = color,
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}


@Composable
fun PrimaryBoldText15sp(
    text: String,
    color: Color = TestAppTheme.colors.primaryText
) {
    Text(
        text = text,
        fontSize = 15.sp,
        fontWeight = FontWeight(500),
        color = color
    )
}

@Composable
fun PrimaryTitleText18sp(
    text: String,
    alignCenter: Boolean = false,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight(400),
        color = color,
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start
    )
}


@Composable
fun PrimaryActiveText14sp(
    text: String,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight(500),
        color = color,
    )
}


@Composable
fun PrimaryTitleText17sp(
    text: String,
) {
    Text(
        text = text,
        fontSize = 17.sp,
        fontWeight = FontWeight(400),
        color = Color.Black,
    )
}


@Composable
fun PrimarySubTitleText13sp(
    text: String,
    color: Color = TestAppTheme.colors.primaryTitleText
) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight(400),
        color = color,
    )
}


@Composable
fun PrimarySubTitleBoldText13sp(
    text: String,
    color: Color = TestAppTheme.colors.subTitleText
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight(500),
        color = color,
    )
}



