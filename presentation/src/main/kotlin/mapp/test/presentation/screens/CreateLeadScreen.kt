package mapp.test.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import mapp.test.coreui.composable.custom.PrimaryScrollableColumnBodyWithAppBar
import mapp.test.coreui.composable.textfields.OutLineTextFieldSample

@Composable
fun CreateLeadScreen(navController: NavHostController) {

    PrimaryScrollableColumnBodyWithAppBar(
        title = stringResource(id = mapp.test.coreui.R.string.lead_information),
        backClick = {
            navController.navigateUp()
        }) {
        OutLineTextFieldSample()
    }
}