package mapp.test.core.domain.leadprofile

import mapp.test.core.data.leadprofile.UpdateLeadResponseModel
import mapp.test.core.service.leadprofile.LeadProfileService
import mapp.test.core.util.AppNetworkResponse
import mapp.test.type.UpdateLeadInput

class GetUpdateLeadUseCase(
    private val service: LeadProfileService
) {
    suspend fun execute(updateLeadInput: UpdateLeadInput): AppNetworkResponse<UpdateLeadResponseModel> {
        return service.updateLead(updateLeadInput)
    }
}