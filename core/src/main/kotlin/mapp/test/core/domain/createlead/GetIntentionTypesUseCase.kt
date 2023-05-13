package mapp.test.core.domain.createlead

import mapp.test.core.data.IntentionTypeModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class GetIntentionTypesUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(): AppNetworkResponse<List<IntentionTypeModel>> {
        return service.fetchIntentionTypes()
    }
}