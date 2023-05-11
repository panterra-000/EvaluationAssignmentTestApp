package mapp.test.core.domain

import mapp.test.core.data.LeadModel
import mapp.test.core.service.LeadsService
import mapp.test.core.util.AppNetworkResponse

class GetLeadsUseCase(
    private val service: LeadsService
) {
    suspend fun execute(): AppNetworkResponse<List<LeadModel>> {
        return service.fetchLeads()
    }
}