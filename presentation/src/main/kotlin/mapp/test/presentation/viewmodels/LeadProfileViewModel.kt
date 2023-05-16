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
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.util.AppNetworkResponse
import javax.inject.Inject

@HiltViewModel
class LeadProfileViewModel @Inject constructor(
    private val getLeadProfileUseCase: GetLeadProfileUseCase
) : ViewModel() {

    private val _errorState = Channel<String>()
    val errorState = _errorState.receiveAsFlow()

    private val _leadProfileState = mutableStateOf<FetchLeadQuery.Data1?>(null)
    val leadProfileState: State<FetchLeadQuery.Data1?> get() = _leadProfileState

    fun getLeadProfile(leadId: Int) {
        viewModelScope.launch {
            when (val resp = getLeadProfileUseCase.execute(leadId)) {
                is AppNetworkResponse.Error -> {

                }

                AppNetworkResponse.Loading -> {

                }

                is AppNetworkResponse.Success -> {
                    _leadProfileState.value = resp.data
                }
            }
        }
    }
}