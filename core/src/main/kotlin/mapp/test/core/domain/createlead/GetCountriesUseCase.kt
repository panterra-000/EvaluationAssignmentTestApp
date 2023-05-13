package mapp.test.core.domain.createlead

import mapp.test.core.data.CountryModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class GetCountriesUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(): AppNetworkResponse<List<CountryModel>> {
        return service.fetchCountries()
    }
}