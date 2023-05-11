package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel
import mapp.test.core.domain.GetCountriesUseCase
import mapp.test.core.domain.GetLeadsUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class LeadsViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getLeadsUseCase: GetLeadsUseCase
) : ViewModel() {

    val countriesState = mutableStateOf(CountriesDataState())

    private val _leadsState =
        mutableStateOf<AppNetworkResponse<List<LeadModel>>>(AppNetworkResponse.Loading)
    val leadsState: State<AppNetworkResponse<List<LeadModel>>> get() = _leadsState

    data class CountriesDataState(
        val isLoading: Boolean = true, val countries: List<CountryViewData> = listOf()
    )

    init {
        getLeads()
    }

    private fun getCountries() {
        viewModelScope.launch {
            countriesState.value = countriesState.value.copy(isLoading = true)
            val a = getCountriesUseCase.execute()
            countriesState.value = countriesState.value.copy(isLoading = false, countries = a)
        }
    }

    private fun getLeads() {
        viewModelScope.launch {
            delay(500)
            val resp = getLeadsUseCase.execute()
            _leadsState.value = resp
            myLogD(msg = resp.toString())
        }
    }


}