package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.showShortToast
import mapp.test.coreui.R.string
import mapp.test.coreui.composable.Spacer18dp
import mapp.test.coreui.composable.Spacer20dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.PrimaryButtonInRow
import mapp.test.coreui.composable.buttons.SecondaryButtonInRow
import mapp.test.coreui.composable.custom.PrimaryLoadingView
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.coreui.composable.custom.bottomdialogs.AdSourcesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.CitiesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.CountriesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.IntentionTypesDialog
import mapp.test.coreui.composable.custom.bottomdialogs.LanguagesDialog
import mapp.test.coreui.composable.row.PrimaryRowMaxWith
import mapp.test.coreui.composable.row.PrimaryRowMaxWithInBox
import mapp.test.coreui.composable.textfields.EmailTextFieldFillMaxWidth
import mapp.test.coreui.composable.textfields.OutLineTextFieldInRow
import mapp.test.coreui.composable.textfields.PhoneTextFieldFillMaxWidth
import mapp.test.coreui.composable.textfields.TextFieldDisabledClickable
import mapp.test.coreui.composable.textfields.TextFieldInRowDisabledClickableInRow
import mapp.test.presentation.viewmodels.CreateLeadViewModel

@Composable
fun CreateLeadScreen(
    navController: NavHostController, viewModel: CreateLeadViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val createLeadLoadingState = remember {
        mutableStateOf(false)
    }

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

    LaunchedEffect(key1 = Unit, block = {
        viewModel.createLeadResponseState.collect { response ->
            when (response) {
                is AppNetworkResponse.Error -> {
                    createLeadLoadingState.value = false
                    showShortToast(context, response.message)
                }

                AppNetworkResponse.Loading -> {
                    createLeadLoadingState.value = true
                }

                is AppNetworkResponse.Success -> {
                    navController.navigateUp()
                    showShortToast(context, "Lead created!")
                    createLeadLoadingState.value = false
                }
            }
        }
    })

    PrimaryBoxMaxSize {
        PrimaryScrollableColumnBodyWithAppBar(title = stringResource(id = string.lead_information),
            backClick = {
                navController.navigateUp()
            }) {

            PrimaryRowMaxWith {
                OutLineTextFieldInRow(
                    labelText = stringResource(id = string.first_name),
                    textState = viewModel.firstNameState
                )
                Spacer18dp()
                OutLineTextFieldInRow(
                    labelText = stringResource(id = string.last_name),
                    textState = viewModel.lastNameState
                )
            }

            TextFieldDisabledClickable(labelText = stringResource(id = string.lead_intention_type),
                textState = viewModel.intentionTypeState,
                isActive = viewModel.selectedIntentionTypeState.value != null,
                onclick = {
                    focusManager.clearFocus()
                    intentionTypesDialogShowState.value = true
                    viewModel.getIntentionTypes()
                })

            TextFieldDisabledClickable(labelText = stringResource(id = string.country),
                isActive = viewModel.selectedCountryState.value != null,
                textState = viewModel.countryState,
                onclick = {
                    focusManager.clearFocus()
                    countriesDialogShowState.value = true
                    viewModel.getCountries()
                })

            PrimaryRowMaxWith {
                TextFieldInRowDisabledClickableInRow(labelText = stringResource(id = string.city),
                    isActive = viewModel.selectedCityState.value != null,
                    textState = viewModel.cityState,
                    onclick = {
                        focusManager.clearFocus()
                        citiesDialogShowState.value = true
                        viewModel.getCities()
                    })
                Spacer20dp()
                TextFieldInRowDisabledClickableInRow(labelText = stringResource(id = string.languages),
                    isActive = viewModel.selectedLanguagesState.value.isNotEmpty(),
                    textState = viewModel.languageState,
                    onclick = {
                        focusManager.clearFocus()
                        languagesDialogShowState.value = true
                        viewModel.getLanguages()
                    })
            }

            PhoneTextFieldFillMaxWidth(
                labelText = stringResource(id = string.number),
                textState = viewModel.phoneState
            )
            EmailTextFieldFillMaxWidth(
                labelText = stringResource(id = string.email),
                textState = viewModel.emailState
            )

            TextFieldDisabledClickable(labelText = stringResource(id = string.source),
                isActive = viewModel.selectedAdSourceState.value != null,
                textState = viewModel.adSourceState,
                onclick = {
                    focusManager.clearFocus()
                    adSourcesDialogShowState.value = true
                    viewModel.getAdSources()
                })
        }

        PrimaryRowMaxWithInBox {
            SecondaryButtonInRow(stringResource(id = string.cancel)) {

            }
            Spacer18dp()
            PrimaryButtonInRow(stringResource(id = string.save)) {
                viewModel.createLead()
            }
        }

        PrimaryLoadingView(state = createLeadLoadingState.value)
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