package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.api.Optional
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mapp.test.FetchLeadQuery
import mapp.test.FetchStatusTypesQuery
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.domain.leadprofile.GetLeadStatusTypesUseCase
import mapp.test.core.domain.leadprofile.GetUpdateLeadUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.extensions.checkAndGetValue
import mapp.test.type.UpdateLeadInput
import javax.inject.Inject

@HiltViewModel
class LeadProfileViewModel @Inject constructor(
    private val getLeadProfileUseCase: GetLeadProfileUseCase,
    private val getLeadStatusTypesUseCase: GetLeadStatusTypesUseCase,
    private val getUpdateLeadUseCase: GetUpdateLeadUseCase
) : ViewModel() {

    val leadIdState = mutableStateOf(-1)

    private val _errorState = Channel<String>()
    val errorState = _errorState.receiveAsFlow()

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> get() = _loadingState


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

    fun getLeadProfile() {
        _loadingState.value = true
        viewModelScope.launch {
            when (val resp = getLeadProfileUseCase.execute(leadIdState.value)) {
                is AppNetworkResponse.Error -> {
                    _errorState.send(resp.message)
                }

                AppNetworkResponse.Loading -> {

                }

                is AppNetworkResponse.Success -> {
                    setFields(resp.data)
                }
            }
            _loadingState.value = false
        }
    }

    private fun setFields(data: FetchLeadQuery.Data1) {
        _leadProfileState.value = data
        intentionTypeState.value = data.intention?.title.checkAndGetValue()
        adSourceState.value = data.adSource?.title.checkAndGetValue()
        countryState.value = data.country?.title.checkAndGetValue()
        webSourceState.value = data.webSource?.title.checkAndGetValue()
        cityState.value = data.city?.title.checkAndGetValue()
        channelSourceState.value = data.channelSource?.title.checkAndGetValue()
        languageState.value = data.languages?.get(0)?.title.checkAndGetValue()
        propertyTypeState.value = data.propertyType?.title.checkAndGetValue()
        nationalityState.value = data.nationality?.title.checkAndGetValue()
        birthDayState.value = data.birthDate.toString().checkAndGetValue()
    }

    fun updateLeadStatusData(statusId: Int) {
        _loadingState.value = true
        viewModelScope.launch {
            val resp = getUpdateLeadUseCase.execute(
                UpdateLeadInput(
                    leadId = leadIdState.value,
                    statusId = Optional.present(statusId)
                )
            )
            when (resp) {
                is AppNetworkResponse.Error -> {
                    _errorState.send(resp.message)
                }
                AppNetworkResponse.Loading -> {}
                is AppNetworkResponse.Success -> {
                    getLeadProfile()
                }
            }
            _loadingState.value = false
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