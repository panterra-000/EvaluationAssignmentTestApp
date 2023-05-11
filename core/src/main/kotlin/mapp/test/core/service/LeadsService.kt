package mapp.test.core.service

import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel

interface LeadsService {
    suspend fun fetchCountries(): List<CountryViewData>
    suspend fun fetchLeads(): List<LeadModel>

}