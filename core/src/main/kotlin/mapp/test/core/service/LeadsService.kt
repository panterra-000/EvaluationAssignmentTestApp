package mapp.test.core.service

import mapp.test.core.data.CountryModel
import mapp.test.core.data.LeadModel
import mapp.test.core.util.AppNetworkResponse

interface LeadsService {
    suspend fun fetchCountries(): List<CountryModel>
    suspend fun fetchLeads(): AppNetworkResponse<List<LeadModel>>

}