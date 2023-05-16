package mapp.test.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.util.AppNetworkResponse
import javax.inject.Inject

@HiltViewModel
class LeadProfileViewModel @Inject constructor(
    private val getLeadProfileUseCase: GetLeadProfileUseCase
) : ViewModel() {

    private val _errorState = Channel<String>()
    val errorState = _errorState.receiveAsFlow()

    val fullNameState = mutableStateOf("")

    fun getLeadProfile(leadId: Int) {
        viewModelScope.launch {
            val resp = getLeadProfileUseCase.execute(leadId)
            when (resp) {
                is AppNetworkResponse.Error -> {

                }

                AppNetworkResponse.Loading -> {

                }

                is AppNetworkResponse.Success -> {
                    fullNameState.value = resp.data.fullName
                }
            }
        }
    }
}