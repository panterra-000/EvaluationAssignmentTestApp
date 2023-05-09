package mapp.test.evaluationassignmenttestapp.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mapp.test.coreui.consts.LEADS_SCREEN_ROUTE
import mapp.test.coreui.theme.PrimaryAppTheme
import mapp.test.presentation.destinations.createLeadDestination
import mapp.test.presentation.destinations.leadProfileDestination
import mapp.test.presentation.destinations.leadsDestination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppMainComposableRoot() {
    val navController: NavHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    PrimaryAppTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        ) {
            NavHost(
                navController = navController,
                startDestination = LEADS_SCREEN_ROUTE
            ) {
                leadsDestination(navController)
                leadProfileDestination(navController)
                createLeadDestination(navController)
            }
        }
    }
}