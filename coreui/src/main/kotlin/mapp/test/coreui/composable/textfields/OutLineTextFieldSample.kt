package mapp.test.coreui.composable.textfields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mapp.test.coreui.R
import mapp.test.coreui.composable.icons.PrimaryIcon
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun TextFieldFillMaxWidth(labelText: String = "", textState: MutableState<String>) {
    OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TestAppTheme.colors.unFocusedBorderColor,
            focusedBorderColor = TestAppTheme.colors.focusedBorderColor,
            unfocusedLabelColor = TestAppTheme.colors.unFocusedLabelColor,
            focusedLabelColor = TestAppTheme.colors.focusedLabelColor,
        ),
        textStyle = TextStyle(fontSize = 16.sp, color = TestAppTheme.colors.textFieldFont),
        value = textState.value,
        label = { Text(text = labelText) },
        onValueChange = {
            textState.value = it
        },
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
    )
}


@Composable
fun PhoneTextFieldFillMaxWidth(labelText: String = "", textState: MutableState<String>) {
    OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TestAppTheme.colors.unFocusedBorderColor,
            focusedBorderColor = TestAppTheme.colors.focusedBorderColor,
            unfocusedLabelColor = TestAppTheme.colors.unFocusedLabelColor,
            focusedLabelColor = TestAppTheme.colors.focusedLabelColor,
        ),
        textStyle = TextStyle(fontSize = 16.sp, color = TestAppTheme.colors.textFieldFont),
        value = textState.value,
        label = { Text(text = labelText) },
        onValueChange = {
            textState.value = it
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
    )
}


@Composable
fun RowScope.OutLineTextFieldInRow(labelText: String = "", textState: MutableState<String>) {
    OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TestAppTheme.colors.unFocusedBorderColor,
            focusedBorderColor = TestAppTheme.colors.focusedBorderColor,
            unfocusedLabelColor = TestAppTheme.colors.unFocusedLabelColor,
            focusedLabelColor = TestAppTheme.colors.focusedLabelColor,
        ),
        maxLines = 1,
        textStyle = TextStyle(fontSize = 16.sp, color = TestAppTheme.colors.textFieldFont),
        value = textState.value,
        label = { Text(text = labelText) },
        onValueChange = {
            textState.value = it
        },
        modifier = Modifier.weight(1f)
    )
}


@Composable
fun TextFieldDisabledClickable(
    labelText: String = "",
    isActive: Boolean = false,
    textState: MutableState<String>,
    onclick: () -> Unit
) {
    OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TestAppTheme.colors.unFocusedBorderColor,
            focusedBorderColor = TestAppTheme.colors.focusedBorderColor,
            unfocusedLabelColor = TestAppTheme.colors.unFocusedLabelColor,
            focusedLabelColor = TestAppTheme.colors.focusedLabelColor,
            textColor = TestAppTheme.colors.focusedLabelColor
        ),
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = if (isActive) TestAppTheme.colors.textFieldFont else TestAppTheme.colors.inactiveFieldFont
        ),
        value = textState.value,
        enabled = false,
        trailingIcon = {
            PrimaryIcon(resId = R.drawable.ic_down, iconTint = TestAppTheme.colors.trailingIcon)
        },
        label = { Text(text = labelText) },
        onValueChange = {
            textState.value = it
        },
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable { onclick() }
            .fillMaxWidth()
    )
}


@Composable
fun RowScope.TextFieldInRowDisabledClickableInRow(
    labelText: String = "",
    isActive: Boolean = false,
    textState: MutableState<String>,
    onclick: () -> Unit
) {
    OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = TestAppTheme.colors.unFocusedBorderColor,
            focusedBorderColor = TestAppTheme.colors.focusedBorderColor,
            unfocusedLabelColor = TestAppTheme.colors.unFocusedLabelColor,
            focusedLabelColor = TestAppTheme.colors.focusedLabelColor,
        ),
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = if (isActive) TestAppTheme.colors.textFieldFont else TestAppTheme.colors.inactiveFieldFont
        ),
        value = textState.value,
        enabled = false,
        trailingIcon = {
            PrimaryIcon(resId = R.drawable.ic_down, iconTint = TestAppTheme.colors.trailingIcon)
        },
        label = { Text(text = labelText) },
        onValueChange = {
            textState.value = it
        },
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable { onclick() }
            .weight(1f)
    )
}
