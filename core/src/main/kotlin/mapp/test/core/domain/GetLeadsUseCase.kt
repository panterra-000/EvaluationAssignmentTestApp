package mapp.test.core.domain

import mapp.test.core.data.LeadModel
import mapp.test.core.service.LeadsService

class GetLeadsUseCase(
    private val service: LeadsService
) {
    suspend fun execute(): List<LeadModel> {
        return service.fetchLeads()
    }
}