package mapp.test.core.service

import mapp.test.core.data.CountryModel
import mapp.test.core.data.LeadsResponse
import mapp.test.core.util.AppNetworkResponse

interface LeadsService {
    suspend fun fetchCountries(): List<CountryModel>
    suspend fun fetchLeads(cursor: String? = null): AppNetworkResponse<LeadsResponse>

}