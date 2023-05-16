package mapp.test.core.service.leadprofile

import mapp.test.core.data.leadprofile.LeadProfileModel
import mapp.test.core.util.AppNetworkResponse

interface LeadProfileService {

    suspend fun fetchLeadProfile(leadId: Int): AppNetworkResponse<LeadProfileModel>

}