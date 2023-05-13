package mapp.test.core.domain.createlead

import mapp.test.core.data.AdSourceModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class GetAdSourcesUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(): AppNetworkResponse<List<AdSourceModel>> {
        return service.fetchAdSources()
    }
}