package mapp.test.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mapp.test.core.data.CountryViewData
import mapp.test.core.domain.GetCountriesUseCase
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class LeadsViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    val countriesState = mutableStateOf(CountriesDataState())

    val textState = mutableStateOf("")

    data class CountriesDataState(
        val isLoading: Boolean = true,
        val countries: List<CountryViewData> = listOf()
    )

    init {
        getCountries()
        testQuery()
    }

    private fun getCountries() {
        viewModelScope.launch {
            countriesState.value = countriesState.value.copy(isLoading = true)
            val a = getCountriesUseCase.execute()
            countriesState.value = countriesState.value.copy(isLoading = false, countries = a)
        }
    }

    private fun testQuery() {
        viewModelScope.launch {
            val a = getCountriesUseCase.testExecute()
            textState.value = a
        }
    }
}