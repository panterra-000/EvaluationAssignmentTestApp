package mapp.test.core.service.leadprofile

import mapp.test.FetchLeadQuery
import mapp.test.FetchStatusTypesQuery
import mapp.test.core.data.leadprofile.UpdateLeadResponseModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.type.UpdateLeadInput

interface LeadProfileService {

    suspend fun fetchLeadProfile(leadId: Int): AppNetworkResponse<FetchLeadQuery.Data1>

    suspend fun fetchLeadStatusTypes(): AppNetworkResponse<List<FetchStatusTypesQuery.FetchLeadStatusType>>

    suspend fun updateLead(updateLeadInput: UpdateLeadInput): AppNetworkResponse<UpdateLeadResponseModel>
}