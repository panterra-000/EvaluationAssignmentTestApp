package mapp.test.coreui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Spacer1dp() {
    Spacer(modifier = Modifier.size(1.dp))
}


@Composable
fun Spacer2dp() {
    Spacer(modifier = Modifier.size(2.dp))
}

@Composable
fun Spacer4dp() {
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
fun Spacer6dp() {
    Spacer(modifier = Modifier.size(6.dp))
}

@Composable
fun Spacer8dp() {
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
fun Spacer10dp() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun Spacer12dp() {
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
fun Spacer13dp() {
    Spacer(modifier = Modifier.size(13.dp))
}

@Composable
fun Spacer24dp() {
    Spacer(modifier = Modifier.size(24.dp))
}


@Composable
fun Spacer28dp() {
    Spacer(modifier = Modifier.size(28.dp))
}


@Composable
fun Spacer14dp() {
    Spacer(modifier = Modifier.size(14.dp))
}

@Composable
fun Spacer15dp() {
    Spacer(modifier = Modifier.size(15.dp))
}

@Composable
fun Spacer16dp() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
fun Spacer20dp() {
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun Spacer30dp() {
    Spacer(modifier = Modifier.size(30.dp))
}


@Composable
fun Spacer32dp() {
    Spacer(modifier = Modifier.size(36.dp))
}


@Composable
fun Spacer36dp() {
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun Spacer45dp() {
    Spacer(modifier = Modifier.size(45.dp))
}

@Composable
fun Spacer48dp() {
    Spacer(modifier = Modifier.size(48.dp))
}

@Composable
fun Spacer50dp() {
    Spacer(modifier = Modifier.size(50.dp))
}

@Composable
fun Spacer60dp() {
    Spacer(modifier = Modifier.size(60.dp))
}

@Composable
fun ColumnScope.FillAvailableSpacer(percent: Float = 1f) {
    Spacer(modifier = Modifier.weight(percent))
}


@Composable
fun Spacer150dp() {
    Spacer(modifier = Modifier.size(150.dp))
}

@Composable
fun RowScope.FillAvailableSpacer(percent: Float = 1f) {
    Spacer(modifier = Modifier.weight(percent))
}


@Composable
fun NavigationBarSpacer() {
    Spacer(modifier = Modifier.navigationBarsPadding())
}
