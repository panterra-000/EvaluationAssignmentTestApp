package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mapp.test.FetchLeadQuery
import mapp.test.FetchStatusTypesQuery
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.domain.leadprofile.GetLeadStatusTypesUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.extensions.checkAndGetValue
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class LeadProfileViewModel @Inject constructor(
    private val getLeadProfileUseCase: GetLeadProfileUseCase,
    private val getLeadStatusTypesUseCase: GetLeadStatusTypesUseCase
) : ViewModel() {

    private val _errorState = Channel<String>()
    val errorState = _errorState.receiveAsFlow()

    private val _leadProfileState = mutableStateOf<FetchLeadQuery.Data1?>(null)
    val leadProfileState: State<FetchLeadQuery.Data1?> get() = _leadProfileState

    val intentionTypeState = mutableStateOf("Unknown")
    val adSourceState = mutableStateOf("Unknown")
    val countryState = mutableStateOf("Unknown")
    val webSourceState = mutableStateOf("Unknown")
    val cityState = mutableStateOf("Unknown")
    val channelSourceState = mutableStateOf("Unknown")
    val languageState = mutableStateOf("Unknown")
    val propertyTypeState = mutableStateOf("Unknown")
    val nationalityState = mutableStateOf("Unknown")
    val birthDayState = mutableStateOf("Unknown")

    val budgetState = mutableStateOf("Unknown")
    val locationState = mutableStateOf("Unknown")


    private val _statusTypesState =
        mutableStateOf<AppNetworkResponse<List<FetchStatusTypesQuery.FetchLeadStatusType>>>(
            AppNetworkResponse.Loading
        )
    val statusTypesState: State<AppNetworkResponse<List<FetchStatusTypesQuery.FetchLeadStatusType>>>
        get() = _statusTypesState

    fun getLeadProfile(leadId: Int) {
        viewModelScope.launch {
            when (val resp = getLeadProfileUseCase.execute(leadId)) {
                is AppNetworkResponse.Error -> {

                }

                AppNetworkResponse.Loading -> {

                }

                is AppNetworkResponse.Success -> {

                    myLogD("::::::: => Lead Profile => :  ${resp.data}")

                    _leadProfileState.value = resp.data
                    intentionTypeState.value = resp.data.intention?.title.checkAndGetValue()
                    adSourceState.value = resp.data.adSource?.title.checkAndGetValue()
                    countryState.value = resp.data.country?.title.checkAndGetValue()
                    webSourceState.value = resp.data.webSource?.title.checkAndGetValue()
                    cityState.value = resp.data.city?.title.checkAndGetValue()
                    channelSourceState.value = resp.data.channelSource?.title.checkAndGetValue()
                    languageState.value = resp.data.languages?.get(0)?.title.checkAndGetValue()
                    propertyTypeState.value = resp.data.propertyType?.title.checkAndGetValue()
                    nationalityState.value = resp.data.nationality?.title.checkAndGetValue()
                    birthDayState.value = resp.data.birthDate.toString().checkAndGetValue()

                }
            }
        }
    }

    fun getLeadStatusTypes() {
        viewModelScope.launch {
            _statusTypesState.value = AppNetworkResponse.Loading
            val resp = getLeadStatusTypesUseCase.execute()
            _statusTypesState.value = resp
        }
    }

}