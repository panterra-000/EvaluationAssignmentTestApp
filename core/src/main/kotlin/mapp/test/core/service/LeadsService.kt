package mapp.test.core.service

import mapp.test.core.data.CountryViewData

interface LeadsService {
    suspend fun fetchCountries():List<CountryViewData>
}