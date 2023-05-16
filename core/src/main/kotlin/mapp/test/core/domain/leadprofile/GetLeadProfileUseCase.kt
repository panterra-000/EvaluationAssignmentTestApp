package mapp.test.core.domain.leadprofile

import mapp.test.core.data.leadprofile.LeadProfileModel
import mapp.test.core.service.leadprofile.LeadProfileService
import mapp.test.core.util.AppNetworkResponse

class GetLeadProfileUseCase(
    private val service: LeadProfileService
) {
    suspend fun execute(leadId: Int): AppNetworkResponse<LeadProfileModel> {
        return service.fetchLeadProfile(leadId)
    }
}