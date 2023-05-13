package mapp.test.coreui.composable.custom.bottomdialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.coreui.R
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.Spacer8dp
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.custom.ErrorView
import mapp.test.coreui.composable.grids.PrimaryLazyVerticalGrid
import mapp.test.coreui.composable.icons.PrimaryIcon
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.PrimaryTitleText18sp
import mapp.test.coreui.composable.text.Text18spInactive
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun IntentionTypesDialog(
    showState: Boolean = false,
    intentionTypesData: AppNetworkResponse<List<IntentionTypeModel>>,
    itemCLick: (IntentionTypeModel) -> Unit,
    closeClick: () -> Unit
) {
    if (showState) {
        Column(
            Modifier
                .fillMaxSize()
                .background(TestAppTheme.colors.dialogOverFlowBackground)
                .clickable(indication = null,
                    interactionSource = remember { MutableInteractionSource() } // This is mandatory
                ) {

                }
        ) {
            Spacer(modifier = Modifier.weight(0.2f))

            Column(
                Modifier
                    .weight(0.8f)
                    .fillMaxWidth()
                    .background(TestAppTheme.colors.dialogBodyBackground)
                    .padding(18.dp)
            ) {
                PrimaryRowMaxWithVerticalAlignCenter {
                    PrimaryTitleText18sp(text = "Select type")
                    FillAvailableSpacer()
                    PrimaryIconButton(resId = R.drawable.ic_down) {
                        closeClick()
                    }
                }
                Spacer18dp()
                when (intentionTypesData) {
                    is AppNetworkResponse.Error -> {
                        ErrorView(message = intentionTypesData.message)
                    }

                    AppNetworkResponse.Loading -> {
                        Text18spInactive(text = "Loading...")
                    }

                    is AppNetworkResponse.Success -> {
                        PrimaryLazyVerticalGrid(content = {
                            items(intentionTypesData.data) { type ->
                                IntentionTypeView(type = type) {
                                    itemCLick(type)
                                }
                            }
                        })
                    }
                }
            }
        }
    }
}

@Composable
private fun IntentionTypeView(
    type: IntentionTypeModel,
    onclick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclick() }
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PrimaryIcon(resId = R.drawable.ic_radio)
        Spacer8dp()
        Text18spInactive(text = type.title)
    }
}

