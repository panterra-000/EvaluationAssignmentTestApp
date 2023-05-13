package mapp.test.core.domain

import mapp.test.core.data.CountryModel
import mapp.test.core.service.LeadsService

class GetCountriesUseCase(
    private val service: LeadsService
) {
    suspend fun execute(): List<CountryModel> {
        return service.fetchCountries().sortedBy { it.name }
    }
}