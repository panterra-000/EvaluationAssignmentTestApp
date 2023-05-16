package mapp.test.core.domain.leadprofile

import mapp.test.FetchLeadQuery
import mapp.test.core.service.leadprofile.LeadProfileService
import mapp.test.core.util.AppNetworkResponse

class GetLeadProfileUseCase(
    private val service: LeadProfileService
) {
    suspend fun execute(leadId: Int): AppNetworkResponse<FetchLeadQuery.Data1> {
        return service.fetchLeadProfile(leadId)
    }
}