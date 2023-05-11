package mapp.test.presentation.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.core.util.AppNetworkResponse
import mapp.test.coreui.composable.Spacer10dp
import mapp.test.coreui.composable.box.PrimaryBoxMaxSize
import mapp.test.coreui.composable.buttons.CreateLeadButton
import mapp.test.coreui.composable.column.PrimaryColumnMaxSize
import mapp.test.coreui.composable.column.PrimaryLazyColumnMaxWith
import mapp.test.coreui.composable.swiperefesh.PrimarySwipeRefreshColumn
import mapp.test.coreui.composable.text.Text18spInactive
import mapp.test.coreui.consts.CREATE_LEAD_SCREEN_ROUTE
import mapp.test.coreui.consts.LEAD_PROFILE_SCREEN_ROUTE
import mapp.test.presentation.viewmodels.LeadsViewModel
import mapp.test.presentation.views.LeadView

@Composable
fun LeadsScreen(
    navController: NavHostController, viewModel: LeadsViewModel = hiltViewModel()
) {
    PrimaryBoxMaxSize {
        PrimaryColumnMaxSize {
            CreateLeadButton {
                navController.navigate(CREATE_LEAD_SCREEN_ROUTE)
            }
            Spacer10dp()
            PrimarySwipeRefreshColumn(isRefreshing = viewModel.isRefreshingState.value, refresh = {
                viewModel.getLeads()
            }) {
                when (val leadsValue = viewModel.leadsState.value) {
                    is AppNetworkResponse.Error -> {
                        Text(text = "Error: ${leadsValue.message}", color = Color.Red)
                    }

                    AppNetworkResponse.Loading -> {
                        Text18spInactive(text = stringResource(id = mapp.test.coreui.R.string.loading_title))
                    }

                    is AppNetworkResponse.Success -> {
                        PrimaryLazyColumnMaxWith {
                            items(leadsValue.data) { lead ->
                                LeadView(lead, onclick = {
                                    navController.navigate(LEAD_PROFILE_SCREEN_ROUTE)
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}