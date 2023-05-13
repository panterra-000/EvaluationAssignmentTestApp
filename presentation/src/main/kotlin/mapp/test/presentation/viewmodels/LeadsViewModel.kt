package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mapp.test.core.data.CountryModel
import mapp.test.core.data.LeadModel
import mapp.test.core.domain.GetLeadsUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class LeadsViewModel @Inject constructor(
    private val getLeadsUseCase: GetLeadsUseCase
) : ViewModel() {

    private val _isRefreshingState = mutableStateOf(false)
    val isRefreshingState: State<Boolean> get() = _isRefreshingState

    private val _leadsState =
        mutableStateOf<AppNetworkResponse<List<LeadModel>>>(AppNetworkResponse.Loading)
    val leadsState: State<AppNetworkResponse<List<LeadModel>>> get() = _leadsState


    init {
        getLeads()
    }

    fun getLeads() {
        _isRefreshingState.value = true
        _leadsState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = getLeadsUseCase.execute()
            _leadsState.value = resp
            _isRefreshingState.value = false
            myLogD(msg = resp.toString())
        }
    }

}