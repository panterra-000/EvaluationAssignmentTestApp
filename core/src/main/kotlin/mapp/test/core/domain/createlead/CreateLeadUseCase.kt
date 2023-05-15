package mapp.test.core.domain.createlead

import mapp.test.core.data.CreateLeadResponseModel
import mapp.test.core.data.request.CreateLeadInputModel
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.util.AppNetworkResponse

class CreateLeadUseCase(
    private val service: CreateLeadService
) {
    suspend fun execute(request: CreateLeadInputModel): AppNetworkResponse<CreateLeadResponseModel> {
        return service.createLead(request)
    }
}