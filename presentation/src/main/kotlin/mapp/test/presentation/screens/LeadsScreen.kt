package mapp.test.presentation.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.core.util.showShortToast
import mapp.test.coreui.composable.Spacer10dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.CreateLeadButton
import mapp.test.coreui.composable.column.PrimaryColumnMaxSize
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith
import mapp.test.coreui.composable.swiperefesh.PrimarySwipeRefreshColumn
import mapp.test.coreui.consts.CREATE_LEAD_SCREEN_ROUTE
import mapp.test.coreui.consts.LEAD_PROFILE_SCREEN_ROUTE
import mapp.test.presentation.viewmodels.LeadsViewModel
import mapp.test.presentation.views.LeadView

@Composable
fun LeadsScreen(
    navController: NavHostController, viewModel: LeadsViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getLeads(true)
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect { errorMessage ->
            showShortToast(context, errorMessage)
        }
    })

    PrimaryBoxMaxSize {
        PrimaryColumnMaxSize {
            CreateLeadButton {
                navController.navigate(CREATE_LEAD_SCREEN_ROUTE)
            }
            Spacer10dp()
            PrimarySwipeRefreshColumn(isRefreshing = viewModel.isRefreshingState.value, refresh = {
                viewModel.getLeads(true)
            }) {
                PrimaryLazyColumnMaxWith {
                    items(viewModel.allLeadsState.value) { lead ->
                        LeadView(lead, onclick = {
                            navController.navigate(LEAD_PROFILE_SCREEN_ROUTE)
                        })
                    }

                    item {
                        if (viewModel.leadsResponseState.value?.hasMore == true) {
                            CircularProgressIndicator()
                            viewModel.getLeads()
                        }
                    }
                }
            }
        }
    }
}