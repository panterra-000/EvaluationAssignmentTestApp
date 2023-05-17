package mapp.test.core.domain.leadprofile

import mapp.test.FetchStatusTypesQuery
import mapp.test.core.service.leadprofile.LeadProfileService
import mapp.test.core.util.AppNetworkResponse

class GetLeadStatusTypesUseCase(
    private val service: LeadProfileService
) {
    suspend fun execute(): AppNetworkResponse<List<FetchStatusTypesQuery.FetchLeadStatusType>> {
        return service.fetchLeadStatusTypes()
    }
}