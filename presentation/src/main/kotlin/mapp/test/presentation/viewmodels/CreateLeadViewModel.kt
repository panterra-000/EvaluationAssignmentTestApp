package mapp.test.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.CityModel
import mapp.test.core.data.CountryModel
import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.data.LanguageModel
import mapp.test.core.domain.createlead.GetAdSourcesUseCase
import mapp.test.core.domain.createlead.GetCitiesUseCase
import mapp.test.core.domain.createlead.GetCountriesUseCase
import mapp.test.core.domain.createlead.GetIntentionTypesUseCase
import mapp.test.core.domain.createlead.GetLanguagesUseCase
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD
import javax.inject.Inject

@HiltViewModel
class CreateLeadViewModel @Inject constructor(
    private val intentionTypesUseCase: GetIntentionTypesUseCase,
    private val countriesUseCase: GetCountriesUseCase,
    private val citiesUseCase: GetCitiesUseCase,
    private val languagesUseCase: GetLanguagesUseCase,
    private val adSourcesUseCase: GetAdSourcesUseCase,
) : ViewModel() {

    val firstNameState = mutableStateOf("")
    val lastNameState = mutableStateOf("")
    val intentionTypeState = mutableStateOf("Type")
    val countryState = mutableStateOf("Country")
    val cityState = mutableStateOf("City")
    val languageState = mutableStateOf("Language")
    val phoneState = mutableStateOf("Number")
    val emailState = mutableStateOf("Email")
    val sourceState = mutableStateOf("Select Source")


    private val _intentionTypesState =
        mutableStateOf<AppNetworkResponse<List<IntentionTypeModel>>>(AppNetworkResponse.Loading)
    val intentionTypesState: State<AppNetworkResponse<List<IntentionTypeModel>>>
        get() = _intentionTypesState

    private val _countriesState =
        mutableStateOf<AppNetworkResponse<List<CountryModel>>>(AppNetworkResponse.Loading)
    val countriesState: State<AppNetworkResponse<List<CountryModel>>>
        get() = _countriesState

    private val _citiesState =
        mutableStateOf<AppNetworkResponse<List<CityModel>>>(AppNetworkResponse.Loading)
    val citiesState: State<AppNetworkResponse<List<CityModel>>>
        get() = _citiesState

    private val _languagesState =
        mutableStateOf<AppNetworkResponse<List<LanguageModel>>>(AppNetworkResponse.Loading)
    val languagesState: State<AppNetworkResponse<List<LanguageModel>>>
        get() = _languagesState

    private val _adSourcesState =
        mutableStateOf<AppNetworkResponse<List<AdSourceModel>>>(AppNetworkResponse.Loading)
    val adSourcesState: State<AppNetworkResponse<List<AdSourceModel>>>
        get() = _adSourcesState


    fun getIntentionTypes() {
        _intentionTypesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = intentionTypesUseCase.execute()
            _intentionTypesState.value = resp
            myLogD(msg = "Intention types: $resp")
        }
    }

    fun getCountries() {
        _countriesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = countriesUseCase.execute()
            _countriesState.value = resp
            myLogD(msg = "Countries : $resp")
        }
    }

    fun getCities(id: Int) {
        _citiesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = citiesUseCase.execute(id)
            _citiesState.value = resp
            myLogD(msg = "Cities : $resp")
        }
    }

    fun getLanguages() {
        _languagesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = languagesUseCase.execute()
            _languagesState.value = resp
            myLogD(msg = "Languages : $resp")
        }
    }

    fun getAdSources() {
        _adSourcesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = adSourcesUseCase.execute()
            _adSourcesState.value = resp
            myLogD(msg = "AdSources : $resp")
        }
    }

}