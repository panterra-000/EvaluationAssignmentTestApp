package mapp.test.core.service.leadprofile

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import mapp.test.FetchLeadQuery
import mapp.test.core.data.leadprofile.LeadProfileModel
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.extensions.getErrorMessages
import mapp.test.type.FetchLeadInput

class LeadProfileServiceImpl(
    private val apolloClient: ApolloClient
) : LeadProfileService {
    override suspend fun fetchLeadProfile(leadId: Int): AppNetworkResponse<LeadProfileModel> {
        return try {
            val resp = apolloClient.query(FetchLeadQuery(FetchLeadInput(leadId)))
                .execute()
            val data = resp.data?.fetchLead?.data
            val responseErrors = resp.errors
            if (responseErrors == null && data != null) {
                AppNetworkResponse.Success(
                    data = LeadProfileModel(
                        id = data.id,
                        fullName = data.firstName + data.lastName
                    )
                )
            } else {
                AppNetworkResponse.Error(message = responseErrors?.getErrorMessages().toString())
            }
        } catch (e: ApolloException) {
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }
}