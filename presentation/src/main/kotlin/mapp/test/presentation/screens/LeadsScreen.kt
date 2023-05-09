package mapp.test.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mapp.test.core.data.CountryViewData
import mapp.test.presentation.viewmodels.LeadsViewModel

@Composable
fun LeadsScreen(
    navController: NavHostController,
    viewModel: LeadsViewModel = hiltViewModel()
) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (viewModel.countriesState.value.isLoading) {
            CircularProgressIndicator(color = Color.Black)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.countriesState.value.countries) { country ->
                    CountryItem(country = country)
                }
            }
        }

        Text(
            text = viewModel.textState.value,
            fontSize = 27.sp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}


@Composable
private fun CountryItem(
    country: CountryViewData,
) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = country.emoji,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = country.name,
                fontSize = 24.sp
            )
        }
        Divider(color = Color.Blue, thickness = 1.dp)
    }
}
