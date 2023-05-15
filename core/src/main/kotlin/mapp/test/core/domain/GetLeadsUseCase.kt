package mapp.test.core.domain

import mapp.test.core.data.LeadsResponse
import mapp.test.core.service.LeadsService
import mapp.test.core.util.AppNetworkResponse

class GetLeadsUseCase(
    private val service: LeadsService
) {
    suspend fun execute(cursor: String? = null): AppNetworkResponse<LeadsResponse> {
        return service.fetchLeads(cursor)
    }

}