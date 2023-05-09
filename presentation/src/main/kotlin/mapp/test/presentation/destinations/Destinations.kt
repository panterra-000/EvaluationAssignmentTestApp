package mapp.test.presentation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import mapp.test.coreui.consts.CREATE_LEAD_SCREEN_ROUTE
import mapp.test.coreui.consts.LEADS_SCREEN_ROUTE
import mapp.test.coreui.consts.LEAD_PROFILE_SCREEN_ROUTE
import mapp.test.presentation.screens.CreateLeadScreen
import mapp.test.presentation.screens.LeadProfileScreen
import mapp.test.presentation.screens.LeadsScreen

fun NavGraphBuilder.leadsDestination(
    navController: NavHostController,
) {
    composable(LEADS_SCREEN_ROUTE) {
        LeadsScreen(navController)
    }
}

fun NavGraphBuilder.leadProfileDestination(
    navController: NavHostController,
) {
    composable(LEAD_PROFILE_SCREEN_ROUTE) {
        LeadProfileScreen(navController)
    }
}

fun NavGraphBuilder.createLeadDestination(
    navController: NavHostController,
) {
    composable(CREATE_LEAD_SCREEN_ROUTE) {
        CreateLeadScreen(navController)
    }
}
