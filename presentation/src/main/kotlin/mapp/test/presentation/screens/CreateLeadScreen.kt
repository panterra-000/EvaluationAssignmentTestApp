package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.Spacer20dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.PrimaryButtonInRow
import mapp.test.coreui.composable.buttons.SecondaryButtonInRow
import mapp.test.coreui.composable.custom.CountriesDialog
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.coreui.composable.row.PrimaryRowMaxWith
import mapp.test.coreui.composable.row.PrimaryRowMaxWithInBox
import mapp.test.coreui.composable.textfields.OutLineTextFieldInRow
import mapp.test.coreui.composable.textfields.TextFieldDisabledClickable
import mapp.test.coreui.composable.textfields.TextFieldFillMaxWidth
import mapp.test.coreui.composable.textfields.TextFieldInRowDisabledClickableInRow
import mapp.test.presentation.viewmodels.CreateLeadViewModel

@Composable
fun CreateLeadScreen(
    navController: NavHostController, viewModel: CreateLeadViewModel = hiltViewModel()
) {

    val countriesDialogShowState = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    PrimaryBoxMaxSize {
        PrimaryScrollableColumnBodyWithAppBar(title = stringResource(id = mapp.test.coreui.R.string.lead_information),
            backClick = {
                navController.navigateUp()
            }) {

            PrimaryRowMaxWith {
                OutLineTextFieldInRow(
                    labelText = "First Name", textState = viewModel.firstNameState
                )
                Spacer18dp()
                OutLineTextFieldInRow(labelText = "Last name", textState = viewModel.lastNameState)
            }

            TextFieldDisabledClickable(labelText = "Lead Intention type",
                textState = viewModel.intentionTypeState,
                onclick = {
                    viewModel.intentionTypeState.value = "edited"
                })

            TextFieldDisabledClickable(labelText = "Country",
                textState = viewModel.countryState,
                onclick = {
                    countriesDialogShowState.value = true
                    viewModel.getCountries()
                })

            PrimaryRowMaxWith {
                TextFieldInRowDisabledClickableInRow(labelText = "City",
                    textState = viewModel.cityState,
                    onclick = {
                        viewModel.cityState.value = "edited City"
                    })
                Spacer20dp()
                TextFieldInRowDisabledClickableInRow(labelText = "Language",
                    textState = viewModel.languageState,
                    onclick = {
                        viewModel.languageState.value = "edited Language"
                    })
            }

            TextFieldFillMaxWidth(labelText = "Number", textState = viewModel.phoneState)
            TextFieldFillMaxWidth(labelText = "Email", textState = viewModel.emailState)

            TextFieldDisabledClickable(labelText = "Source",
                textState = viewModel.sourceState,
                onclick = {
                    viewModel.sourceState.value = "edited Source"
                })
        }

        PrimaryRowMaxWithInBox {
            SecondaryButtonInRow("Cancel") {

            }
            Spacer18dp()
            PrimaryButtonInRow("Save") {

            }
        }
    }

    CountriesDialog(showState = countriesDialogShowState.value,
        countries = viewModel.countriesState.value,
        itemCLick = {},
        closeClick = { countriesDialogShowState.value = false })

}