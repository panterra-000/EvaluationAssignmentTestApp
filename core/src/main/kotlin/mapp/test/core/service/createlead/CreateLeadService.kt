package mapp.test.core.service.createlead

import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.CityModel
import mapp.test.core.data.CountryModel
import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.data.LanguageModel
import mapp.test.core.util.AppNetworkResponse

interface CreateLeadService {
    suspend fun fetchIntentionTypes(): AppNetworkResponse<List<IntentionTypeModel>>
    suspend fun fetchCountries(): AppNetworkResponse<List<CountryModel>>
    suspend fun fetchCities(id: Int): AppNetworkResponse<List<CityModel>>
    suspend fun fetchLanguages(): AppNetworkResponse<List<LanguageModel>>
    suspend fun fetchAdSources(): AppNetworkResponse<List<AdSourceModel>>
}