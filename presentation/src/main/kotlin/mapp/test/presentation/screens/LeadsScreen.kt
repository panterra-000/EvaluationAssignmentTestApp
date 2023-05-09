package mapp.test.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mapp.test.coreui.consts.CREATE_LEAD_SCREEN_ROUTE
import mapp.test.coreui.consts.LEAD_PROFILE_SCREEN_ROUTE

@Composable
fun LeadsScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "LeadsScreen",
            color = Color.White,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.size(40.dp))

        Text(
            "Go -> Create new Lead",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.clickable { navController.navigate(CREATE_LEAD_SCREEN_ROUTE) })
        Spacer(modifier = Modifier.size(20.dp))

        Text(
            "Go -> LeadProfile",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.clickable { navController.navigate(LEAD_PROFILE_SCREEN_ROUTE) })
        Spacer(modifier = Modifier.size(20.dp))

    }

}