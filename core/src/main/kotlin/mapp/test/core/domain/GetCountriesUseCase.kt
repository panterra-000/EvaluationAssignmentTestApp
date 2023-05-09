package mapp.test.core.domain

import mapp.test.core.data.CountryViewData
import mapp.test.core.service.LeadsService

class GetCountriesUseCase(
    private val service: LeadsService
) {
    suspend fun execute(): List<CountryViewData> {
        return service.fetchCountries().sortedBy { it.name }
    }

}