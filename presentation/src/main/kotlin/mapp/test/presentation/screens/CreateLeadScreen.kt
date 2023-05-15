package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.Spacer20dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.PrimaryButtonInRow
import mapp.test.coreui.composable.buttons.SecondaryButtonInRow
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.coreui.composable.custom.bottomdialogs.AdSourcesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.CitiesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.CountriesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.IntentionTypesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.LanguagesDialog
import mapp.test.coreui.composable.row.PrimaryRowMaxWith
import mapp.test.coreui.composable.row.PrimaryRowMaxWithInBox
import mapp.test.coreui.composable.textfields.OutLineTextFieldInRow
import mapp.test.coreui.composable.textfields.PhoneTextFieldFillMaxWidth
import mapp.test.coreui.composable.textfields.TextFieldDisabledClickable
import mapp.test.coreui.composable.textfields.TextFieldFillMaxWidth
import mapp.test.coreui.composable.textfields.TextFieldInRowDisabledClickableInRow
import mapp.test.presentation.viewmodels.CreateLeadViewModel

@Composable
fun CreateLeadScreen(
    navController: NavHostController, viewModel: CreateLeadViewModel = hiltViewModel()
) {

    val focusManager = LocalFocusManager.current

    val countriesDialogShowState = remember {
        mutableStateOf(false)
    }
    val citiesDialogShowState = remember {
        mutableStateOf(false)
    }
    val intentionTypesDialogShowState = remember {
        mutableStateOf(false)
    }
    val languagesDialogShowState = remember {
        mutableStateOf(false)
    }
    val adSourcesDialogShowState = remember {
        mutableStateOf(false)
    }

    PrimaryBoxMaxSize {
        PrimaryScrollableColumnBodyWithAppBar(
            title = stringResource(id = mapp.test.coreui.R.string.lead_information),
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
                isActive = viewModel.selectedIntentionTypeState.value != null,
                onclick = {
                    focusManager.clearFocus()
                    intentionTypesDialogShowState.value = true
                    viewModel.getIntentionTypes()
                })

            TextFieldDisabledClickable(
                labelText = "Country",
                isActive = viewModel.selectedCountryState.value != null,
                textState = viewModel.countryState,
                onclick = {
                    focusManager.clearFocus()
                    countriesDialogShowState.value = true
                    viewModel.getCountries()
                })

            PrimaryRowMaxWith {
                TextFieldInRowDisabledClickableInRow(
                    labelText = "City",
                    isActive = viewModel.selectedCityState.value != null,
                    textState = viewModel.cityState,
                    onclick = {
                        focusManager.clearFocus()
                        citiesDialogShowState.value = true
                        viewModel.getCities()
                    })
                Spacer20dp()
                TextFieldInRowDisabledClickableInRow(
                    labelText = "Languages",
                    isActive = viewModel.selectedLanguagesState.value.isNotEmpty(),
                    textState = viewModel.languageState,
                    onclick = {
                        focusManager.clearFocus()
                        languagesDialogShowState.value = true
                        viewModel.getLanguages()
                    })
            }

            PhoneTextFieldFillMaxWidth(labelText = "Number", textState = viewModel.phoneState)
            TextFieldFillMaxWidth(labelText = "Email", textState = viewModel.emailState)

            TextFieldDisabledClickable(
                labelText = "Source",
                isActive = viewModel.selectedAdSourceState.value != null,
                textState = viewModel.adSourceState,
                onclick = {
                    focusManager.clearFocus()
                    adSourcesDialogShowState.value = true
                    viewModel.getAdSources()
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

    IntentionTypesDialog(showState = intentionTypesDialogShowState.value,
        intentionTypesData = viewModel.intentionTypesState.value,
        selectedIntentionType = viewModel.selectedIntentionTypeState.value,
        itemCLick = {
            viewModel.selectIntentionType(it); intentionTypesDialogShowState.value = false
        },
        closeClick = { intentionTypesDialogShowState.value = false })

    CountriesDialog(showState = countriesDialogShowState.value,
        countries = viewModel.countriesState.value,
        itemCLick = { viewModel.selectCountry(it); countriesDialogShowState.value = false },
        closeClick = { countriesDialogShowState.value = false })

    CitiesDialog(showState = citiesDialogShowState.value,
        citiesState = viewModel.citiesState.value,
        itemCLick = { viewModel.selectCity(it);citiesDialogShowState.value = false },
        closeClick = { citiesDialogShowState.value = false })

    LanguagesDialog(showState = languagesDialogShowState.value,
        languagesData = viewModel.languagesState.value,
        selectedLanguages = viewModel.selectedLanguagesState.value,
        itemCLick = { viewModel.selectLanguage(it) },
        closeClick = { languagesDialogShowState.value = false })

    AdSourcesDialog(showState = adSourcesDialogShowState.value,
        adSourcesState = viewModel.adSourcesState.value,
        itemCLick = { viewModel.selectAdSource(it);adSourcesDialogShowState.value = false },
        closeClick = { adSourcesDialogShowState.value = false })

}