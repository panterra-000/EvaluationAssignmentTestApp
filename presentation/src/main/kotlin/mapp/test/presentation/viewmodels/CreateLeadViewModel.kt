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
import mapp.test.core.util.extensions.addNewItem
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
    val languageState = mutableStateOf("Languages")
    val phoneState = mutableStateOf("Number")
    val emailState = mutableStateOf("Email")
    val adSourceState = mutableStateOf("Select Source")


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

    private val _selectedIntentionTypeState = mutableStateOf<IntentionTypeModel?>(null)
    val selectedIntentionTypeState: State<IntentionTypeModel?> get() = _selectedIntentionTypeState

    private val _selectedCountryState = mutableStateOf<CountryModel?>(null)
    val selectedCountryState: State<CountryModel?> get() = _selectedCountryState

    private val _selectedCityState = mutableStateOf<CityModel?>(null)
    val selectedCityState: State<CityModel?> get() = _selectedCityState

    private val _selectedLanguagesState = mutableStateOf<List<LanguageModel>>(listOf())
    val selectedLanguagesState: State<List<LanguageModel>> get() = _selectedLanguagesState

    private val _selectedAdSourceState = mutableStateOf<AdSourceModel?>(null)
    val selectedAdSourceState: State<AdSourceModel?> get() = _selectedAdSourceState

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

    fun getCities() {
        val id = selectedCountryState.value?.id
        if (id != null) {
            _citiesState.value = AppNetworkResponse.Loading
            viewModelScope.launch {
                val resp = citiesUseCase.execute(id)
                _citiesState.value = resp
                myLogD(msg = "Cities : $resp")
            }
        } else {
            _citiesState.value = AppNetworkResponse.Error(message = "Country not selected!")
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


    fun selectIntentionType(intentionTypeModel: IntentionTypeModel) {
        _selectedIntentionTypeState.value = intentionTypeModel
        intentionTypeState.value = intentionTypeModel.title
    }

    fun selectCountry(countryModel: CountryModel) {
        _selectedCountryState.value = countryModel
        countryState.value = countryModel.emoji + " " + countryModel.name
    }

    fun selectCity(cityModel: CityModel) {
        _selectedCityState.value = cityModel
        cityState.value = cityModel.title
    }

    fun selectLanguage(languageModel: LanguageModel) {
        _selectedLanguagesState.addNewItem(languageModel)
    }

    fun selectAdSource(adSourceModel: AdSourceModel) {
        _selectedAdSourceState.value = adSourceModel
        adSourceState.value = adSourceModel.title
    }

}