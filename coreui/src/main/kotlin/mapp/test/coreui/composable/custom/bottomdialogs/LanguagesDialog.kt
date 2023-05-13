package mapp.test.coreui.composable.custom.bottomdialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mapp.test.core.data.LanguageModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.coreui.R
import mapp.test.coreui.composable.DividerMin
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer10dp
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith
import mapp.test.coreui.composable.custom.ErrorView
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.PrimarySubTitleText13sp
import mapp.test.coreui.composable.text.PrimaryTitleText17sp
import mapp.test.coreui.composable.text.PrimaryTitleText18sp
import mapp.test.coreui.composable.text.Text18spInactive
import mapp.test.coreui.theme.TestAppTheme

@Composable
fun LanguagesDialog(
    showState: Boolean = false,
    languagesData: AppNetworkResponse<List<LanguageModel>>,
    itemCLick: (LanguageModel) -> Unit,
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
                    PrimaryTitleText18sp(text = "Select Language")
                    FillAvailableSpacer()
                    PrimaryIconButton(resId = R.drawable.ic_down) {
                        closeClick()
                    }
                }
                Spacer18dp()
                when (languagesData) {
                    is AppNetworkResponse.Error -> {
                        ErrorView(message = languagesData.message)
                    }

                    AppNetworkResponse.Loading -> {
                        Text18spInactive(text = "Loading...")
                    }

                    is AppNetworkResponse.Success -> {
                        PrimaryLazyColumnMaxWith(content = {
                            items(languagesData.data) { language ->
                                LanguageItemView(language = language) {
                                    itemCLick(language)
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
private fun LanguageItemView(
    language: LanguageModel,
    onclick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable { onclick() }
            .padding(horizontal = 16.dp)) {
        Spacer10dp()
        PrimaryTitleText17sp(text = language.title)
        Spacer(modifier = Modifier.width(8.dp))
        PrimarySubTitleText13sp(text = language.shortCode)
        Spacer10dp()
        DividerMin()
    }
}

