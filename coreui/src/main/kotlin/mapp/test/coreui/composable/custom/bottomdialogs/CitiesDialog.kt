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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mapp.test.core.data.CityModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.coreui.R
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith
import mapp.test.coreui.composable.custom.ErrorView
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.PrimaryTitleText18sp
import mapp.test.coreui.composable.text.Text18spInactive
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun CitiesDialog(
    showState: Boolean = false,
    citiesState: AppNetworkResponse<List<CityModel>>,
    itemCLick: (CityModel) -> Unit,
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
                    PrimaryTitleText18sp(text = "Select city")
                    FillAvailableSpacer()
                    PrimaryIconButton(resId = R.drawable.ic_down) {
                        closeClick()
                    }
                }
                Spacer18dp()
                when (citiesState) {
                    is AppNetworkResponse.Error -> {
                        ErrorView(message = citiesState.message.ifEmpty { "ERROR..." })
                    }

                    AppNetworkResponse.Loading -> {
                        Text18spInactive(text = "Loading...")
                    }

                    is AppNetworkResponse.Success -> {
                        PrimaryLazyColumnMaxWith(content = {
                            items(citiesState.data) { city ->
                                CityItemView(city = city) {
                                    itemCLick(city)
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
private fun CityItemView(
    city: CityModel,
    onclick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclick() }
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PrimaryTitleText18sp(
            text = city.title,
        )
    }
}

