package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mapp.test.core.data.LeadModel
import mapp.test.core.data.LeadsResponse
import mapp.test.core.domain.GetLeadsUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.extensions.addNewItems
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class LeadsViewModel @Inject constructor(
    private val getLeadsUseCase: GetLeadsUseCase
) : ViewModel() {

    private val _isRefreshingState = mutableStateOf(false)
    val isRefreshingState: State<Boolean> get() = _isRefreshingState

    private val _leadsResponseState = mutableStateOf<LeadsResponse?>(null)
    val leadsResponseState: State<LeadsResponse?> get() = _leadsResponseState

    private val _allLeadsState = mutableStateOf<List<LeadModel>>(emptyList())
    val allLeadsState: State<List<LeadModel>> get() = _allLeadsState


    private val _errorState = Channel<String>()
    val errorState = _errorState.receiveAsFlow()

    fun getLeads(reload: Boolean = false) {
        if (reload) {
            _leadsResponseState.value = null
            _allLeadsState.value = emptyList()
            _isRefreshingState.value = true
        }
        viewModelScope.launch {
            when (val resp = getLeadsUseCase.execute(cursor = leadsResponseState.value?.cursor)) {
                is AppNetworkResponse.Error -> {
                    _errorState.send(resp.message)
                }

                AppNetworkResponse.Loading -> {}
                is AppNetworkResponse.Success -> {
                    _leadsResponseState.value = resp.data
                    _allLeadsState.addNewItems(resp.data.data)
                    myLogD(resp.data.toString())
                }
            }
            _isRefreshingState.value = false
        }
    }

}