package mapp.test.core.domain.createlead

import mapp.test.core.data.CityModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class GetCitiesUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(id: Int): AppNetworkResponse<List<CityModel>> {
        return service.fetchCities(id)
    }
}