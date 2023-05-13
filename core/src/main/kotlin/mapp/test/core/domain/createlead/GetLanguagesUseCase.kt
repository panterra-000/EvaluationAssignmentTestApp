package mapp.test.core.domain.createlead

import mapp.test.core.data.LanguageModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class GetLanguagesUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(): AppNetworkResponse<List<LanguageModel>> {
        return service.fetchLanguages()
    }
}