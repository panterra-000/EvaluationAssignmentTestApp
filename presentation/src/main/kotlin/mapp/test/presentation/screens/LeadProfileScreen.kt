package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.coreui.R
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.presentation.viewmodels.LeadProfileViewModel
import mapp.test.presentation.views.leadprofile.LeadHeaderView

@Composable
fun LeadProfileScreen(
    navController: NavHostController,
    id: Int,
    viewModel: LeadProfileViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getLeadProfile(id)
    })

    PrimaryBoxMaxSize {
        PrimaryScrollableColumnBodyWithAppBar(
            title = stringResource(id = R.string.lead_profile_title),
            padding = 0.dp,
            backClick = {
                navController.navigateUp()
            }) {
            LeadHeaderView(
                fullName = viewModel.fullNameState.value,
                avatarUrl = "",
                leadId = id,
                editClick = {})

        }
    }
}

