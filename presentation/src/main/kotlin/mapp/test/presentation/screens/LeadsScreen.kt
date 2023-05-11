package mapp.test.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.coreui.consts.LEAD_PROFILE_SCREEN_ROUTE
import mapp.test.presentation.viewmodels.LeadsViewModel
import mapp.test.presentation.views.LeadView

@Composable
fun LeadsScreen(
    navController: NavHostController, viewModel: LeadsViewModel = hiltViewModel()
) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (viewModel.leadsState.value.isLoading) {
            CircularProgressIndicator(color = Color.Black)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.leadsState.value.leads) { lead ->
                    LeadView(lead, onclick = {
                        navController.navigate(LEAD_PROFILE_SCREEN_ROUTE)
                    })
                }
            }
        }
    }

}

