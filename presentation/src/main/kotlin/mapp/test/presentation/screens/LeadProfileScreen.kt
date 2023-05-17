package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.core.util.showShortToast
import mapp.test.coreui.R
import mapp.test.coreui.composable.FillAvailableSpacer
import mapp.test.coreui.composable.Spacer20dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.PrimaryIconButton
import mapp.test.coreui.composable.buttons.SecondaryButton
import mapp.test.coreui.composable.column.PrimaryColumnMaxWidth
import mapp.test.coreui.composable.custom.PrimaryCenterLoadingView
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.coreui.composable.custom.bottomdialogs.StatusTypesDialog
import mapp.test.coreui.composable.row.PrimaryRowMaxWith
import mapp.test.coreui.composable.row.PrimaryRowMaxWithVerticalAlignCenter
import mapp.test.coreui.composable.text.ActiveTitleText20sp
import mapp.test.coreui.composable.textfields.TextFieldDisabledClickable
import mapp.test.coreui.composable.textfields.TextFieldInRowDisabledClickableInRow
import mapp.test.presentation.viewmodels.LeadProfileViewModel
import mapp.test.presentation.views.leadprofile.LeadHeaderView
import mapp.test.presentation.views.leadprofile.LeadStatusView

@Composable
fun LeadProfileScreen(
    navController: NavHostController,
    id: Int,
    viewModel: LeadProfileViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val statusTypesDialogShowState = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect {
            showShortToast(context, it)
        }
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.leadIdState.value = id
        viewModel.getLeadProfile()
    })

    PrimaryBoxMaxSize {
        PrimaryScrollableColumnBodyWithAppBar(
            title = stringResource(id = R.string.lead_profile_title),
            padding = 0.dp,
            backClick = {
                navController.navigateUp()
            }) {
            LeadHeaderView(
                fullName = viewModel.leadProfileState.value?.displayName.toString(),
                avatarUrl = viewModel.leadProfileState.value?.avatar?.path.toString(),
                leadId = id,
                editClick = {})
            viewModel.leadProfileState.value?.status?.let {
                LeadStatusView(
                    status = it,
                    onClick = {
                        statusTypesDialogShowState.value = true
                        viewModel.getLeadStatusTypes()
                    })
            }

            /**
             *
             * Communications ...
             *
             * */

            PrimaryColumnMaxWidth {
                PrimaryRowMaxWithVerticalAlignCenter {
                    ActiveTitleText20sp(text = stringResource(id = R.string.general_info_title))
                    PrimaryIconButton(resId = R.drawable.ic_edit, onclick = {})
                    FillAvailableSpacer()
                    SecondaryButton(text = stringResource(id = R.string.save), onClick = {})
                }
                PrimaryRowMaxWith {
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.lead_intention_type),
                        isActive = viewModel.intentionTypeState.value != "Unknown",
                        textState = viewModel.intentionTypeState,
                        onclick = {})
                    Spacer20dp()
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.ad_source),
                        isActive = viewModel.adSourceState.value != "Unknown",
                        textState = viewModel.adSourceState,
                        onclick = {})
                }

                PrimaryRowMaxWith {
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.country),
                        isActive = viewModel.countryState.value != "Unknown",
                        textState = viewModel.countryState,
                        onclick = {})
                    Spacer20dp()
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.web_source),
                        isActive = viewModel.webSourceState.value != "Unknown",
                        textState = viewModel.webSourceState,
                        onclick = {})
                }

                PrimaryRowMaxWith {
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.city_region),
                        isActive = viewModel.cityState.value != "Unknown",
                        textState = viewModel.cityState,
                        onclick = {})
                    Spacer20dp()
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.channel_source),
                        isActive = viewModel.channelSourceState.value != "Unknown",
                        textState = viewModel.channelSourceState,
                        onclick = {})
                }

                PrimaryRowMaxWith {
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.languages),
                        isActive = viewModel.languageState.value != "Unknown",
                        textState = viewModel.languageState,
                        onclick = {})
                    Spacer20dp()
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.property_type),
                        isActive = viewModel.propertyTypeState.value != "Unknown",
                        textState = viewModel.propertyTypeState,
                        onclick = {})
                }

                PrimaryRowMaxWith {
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.nationality),
                        isActive = viewModel.nationalityState.value != "Unknown",
                        textState = viewModel.nationalityState,
                        onclick = {})
                    Spacer20dp()
                    TextFieldInRowDisabledClickableInRow(
                        labelText = stringResource(id = R.string.birth_day),
                        isActive = viewModel.birthDayState.value != "Unknown",
                        textState = viewModel.birthDayState,
                        onclick = {})
                }

                TextFieldDisabledClickable(labelText = stringResource(id = R.string.budget),
                    textState = viewModel.budgetState,
                    isActive = viewModel.budgetState.value != "Unknown",
                    onclick = { })

                TextFieldDisabledClickable(labelText = stringResource(id = R.string.location),
                    textState = viewModel.locationState,
                    isActive = viewModel.locationState.value != "Unknown",
                    onclick = { })

                Spacer20dp()
                ActiveTitleText20sp(text = stringResource(id = R.string.tags_title))
                Spacer20dp()
            }
        }
    }

    StatusTypesDialog(showState = statusTypesDialogShowState.value,
        statusTypesData = viewModel.statusTypesState.value,
        itemCLick = { statusData ->
            statusTypesDialogShowState.value = false
            viewModel.updateLeadStatusData(statusId = statusData.id)
        },
        closeClick = { statusTypesDialogShowState.value = false })

    PrimaryCenterLoadingView(state = viewModel.loadingState.value)
}

