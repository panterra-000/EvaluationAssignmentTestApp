package mapp.test.coreui.composable.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mapp.test.core.data.CountryModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.coreui.R
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.PrimaryTitleText18sp
import mapp.test.coreui.composable.text.Text18spInactive
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun CountriesDialog(
    showState: Boolean = false,
    countries: AppNetworkResponse<List<CountryModel>>,
    itemCLick: (CountryModel) -> Unit,
    closeClick: () -> Unit
) {
    if (showState) {
        Column(
            Modifier
                .fillMaxSize()
                .background(TestAppTheme.colors.dialogOverFlowBackground)
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
                    PrimaryTitleText18sp(text = "Select country")
                    FillAvailableSpacer()
                    PrimaryIconButton(resId = R.drawable.ic_down) {
                        closeClick()
                    }
                }
                Spacer18dp()
                when (countries) {
                    is AppNetworkResponse.Error -> {
                        ErrorView(message = countries.message)
                    }

                    AppNetworkResponse.Loading -> {
                        Text18spInactive(text = "Loading...")
                    }

                    is AppNetworkResponse.Success -> {
                        PrimaryLazyColumnMaxWith(content = {
                            items(countries.data) { country ->
                                CountryItemView(country = country) {
                                    itemCLick(country)
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
private fun CountryItemView(
    country: CountryModel,
    onclick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclick() }
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.emoji,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        PrimaryTitleText18sp(
            text = country.name,
        )
        FillAvailableSpacer()
        Text18spInactive(text = "+"+country.phoneCode)
    }
}

