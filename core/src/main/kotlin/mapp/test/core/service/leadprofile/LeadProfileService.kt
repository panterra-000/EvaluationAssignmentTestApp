package mapp.test.core.service.leadprofile

import mapp.test.FetchLeadQuery
import mapp.test.core.util.AppNetworkResponse

interface LeadProfileService {

    suspend fun fetchLeadProfile(leadId: Int): AppNetworkResponse<FetchLeadQuery.Data1>

}