package mapp.test.core.service

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import mapp.test.FetchCountriesQuery
import mapp.test.FetchLeadsQuery
import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel
import mapp.test.core.mappers.mapToCountryModelList
import mapp.test.core.mappers.mapToLeadsModelList
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD

class LeadsServiceImpl(
    private val apolloClient: ApolloClient
) : LeadsService {

    override suspend fun fetchCountries(): List<CountryViewData> {
        return try {
            apolloClient.query(FetchCountriesQuery())
                .execute().data?.fetchCountries?.mapToCountryModelList() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun fetchLeads(): AppNetworkResponse<List<LeadModel>> {
        return try {
            val resp = apolloClient.query(FetchLeadsQuery())
                .execute().data?.fetchLeads?.mapToLeadsModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }
}