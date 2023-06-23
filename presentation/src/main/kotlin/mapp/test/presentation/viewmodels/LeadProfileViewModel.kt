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
import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.ChannelSourceModel
import mapp.test.core.data.CityModel
import mapp.test.core.data.CountryModel
import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.data.LanguageModel
import mapp.test.core.data.WebSourceModel
import mapp.test.core.domain.createlead.GetAdSourcesUseCase
import mapp.test.core.domain.createlead.GetCitiesUseCase
import mapp.test.core.domain.createlead.GetCountriesUseCase
import mapp.test.core.domain.createlead.GetIntentionTypesUseCase
import mapp.test.core.domain.createlead.GetLanguagesUseCase
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.domain.leadprofile.GetLeadStatusTypesUseCase
import mapp.test.core.domain.leadprofile.GetUpdateLeadUseCase
import mapp.test.core.mappers.mapToLanguageModelList
import mapp.test.core.mappers.toModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.extensions.addOrRemoveItem
import mapp.test.core.util.extensions.checkAndGetValue
import mapp.test.type.UpdateLeadInput
import javax.inject.Inject

@HiltViewModel
class LeadProfileViewModel @Inject constructor(
    private val getLeadProfileUseCase: GetLeadProfileUseCase,
    private val getLeadStatusTypesUseCase: GetLeadStatusTypesUseCase,
    private val getUpdateLeadUseCase: GetUpdateLeadUseCase,
    private val intentionTypesUseCase: GetIntentionTypesUseCase,
    private val countriesUseCase: GetCountriesUseCase,
    private val citiesUseCase: GetCitiesUseCase,
    private val languagesUseCase: GetLanguagesUseCase,
    private val adSourcesUseCase: GetAdSourcesUseCase,
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

    val changeEnableState = mutableStateOf(false)


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

    private val _selectedWebSourceState = mutableStateOf<WebSourceModel?>(null)
    val selectedWebSourceState: State<WebSourceModel?> get() = _selectedWebSourceState

    private val _selectedCityState = mutableStateOf<CityModel?>(null)
    val selectedCityState: State<CityModel?> get() = _selectedCityState

    private val _selectedLanguagesState = mutableStateOf<List<LanguageModel>>(listOf())
    val selectedLanguagesState: State<List<LanguageModel>> get() = _selectedLanguagesState

    private val _selectedAdSourceState = mutableStateOf<AdSourceModel?>(null)
    val selectedAdSourceState: State<AdSourceModel?> get() = _selectedAdSourceState

    private val _selectedChannelSourceState = mutableStateOf<ChannelSourceModel?>(null)
    val selectedChannelSourceState: State<ChannelSourceModel?> get() = _selectedChannelSourceState


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
        selectIntentionType(data.intention?.toModel())
        selectAdSource(data.adSource?.toModel())
        selectCountry(data.country?.toModel())
        selectWebSource(data.webSource?.toModel())
        selectCity(data.city?.toModel())
        selectChannelSource(data.channelSource?.toModel())
        selectLanguages(data.languages?.mapToLanguageModelList() ?: listOf())

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

    fun getIntentionTypes() {
        _intentionTypesState.value = AppNetworkResponse.Loading
        viewModelScope.launch {
            val resp = intentionTypesUseCase.execute()
            _intentionTypesState.value = resp
        }
    }

    fun selectIntentionType(intentionTypeModel: IntentionTypeModel?) {
        _selectedIntentionTypeState.value = intentionTypeModel
        intentionTypeState.value = intentionTypeModel?.title.checkAndGetValue()
    }

    private fun selectAdSource(adSourceModel: AdSourceModel?) {
        _selectedAdSourceState.value = adSourceModel
        adSourceState.value = adSourceModel?.title.checkAndGetValue()
    }

    private fun selectCountry(countryModel: CountryModel?) {
        _selectedCountryState.value = countryModel
        countryState.value = countryModel?.name.checkAndGetValue()
    }

    private fun selectCity(cityModel: CityModel?) {
        _selectedCityState.value = cityModel
        cityState.value = cityModel?.title.checkAndGetValue()
    }

    private fun selectWebSource(webSourceModel: WebSourceModel?) {
        _selectedWebSourceState.value = webSourceModel
        webSourceState.value = webSourceModel?.title.checkAndGetValue()
    }

    private fun selectChannelSource(channelSourceModel: ChannelSourceModel?) {
        _selectedChannelSourceState.value = channelSourceModel
        channelSourceState.value = channelSourceModel?.title.checkAndGetValue()
    }

    fun selectLanguage(languageModel: LanguageModel) {
        _selectedLanguagesState.addOrRemoveItem(languageModel)
    }

    private fun selectLanguages(languages: List<LanguageModel>) {
        _selectedLanguagesState.value = languages
        if (languages.isNotEmpty()) {
            languageState.value = languages.get(0)?.title.checkAndGetValue()
        } else {
            languageState.value = "Unknown"
        }
    }

}