package mapp.test.core.service

import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel
import mapp.test.core.util.AppNetworkResponse

interface LeadsService {
    suspend fun fetchCountries(): List<CountryViewData>
    suspend fun fetchLeads(): AppNetworkResponse<List<LeadModel>>

}