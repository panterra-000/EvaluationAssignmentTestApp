package mapp.test.core.service

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import mapp.test.FetchCountriesQuery
import mapp.test.FetchLeadsQuery
import mapp.test.core.data.CountryModel
import mapp.test.core.data.LeadsResponse
import mapp.test.core.mappers.mapToCountryModelList
import mapp.test.core.mappers.toLeadsResponse
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD
import mapp.test.type.PaginationInput

class LeadsServiceImpl(
    private val apolloClient: ApolloClient
) : LeadsService {

    override suspend fun fetchCountries(): List<CountryModel> {
        return try {
            apolloClient.query(FetchCountriesQuery())
                .execute().data?.fetchCountries?.mapToCountryModelList() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun fetchLeads(cursor: String?): AppNetworkResponse<LeadsResponse> {
        return try {
            val resp = apolloClient.query(
                FetchLeadsQuery(paginationInput = PaginationInput(cursor = Optional.present(cursor)))
            ).execute().data?.fetchLeads?.toLeadsResponse()
            if (resp != null) {
                AppNetworkResponse.Success(resp)
            } else {
                AppNetworkResponse.Error(message = "Null")
            }
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }
}