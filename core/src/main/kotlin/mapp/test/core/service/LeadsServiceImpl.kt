package mapp.test.core.service

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpHeader
import mapp.test.FetchCountriesQuery
import mapp.test.FetchLeadsQuery
import mapp.test.core.data.CountryViewData
import mapp.test.core.data.LeadModel
import mapp.test.core.mappers.mapToCountryModelList
import mapp.test.core.mappers.mapToLeadsModelList
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

    override suspend fun fetchLeads(): List<LeadModel> {
        return try {
            apolloClient.query(FetchLeadsQuery()).execute().data?.fetchLeads?.mapToLeadsModelList()
                ?: emptyList()
        } catch (e: Exception) {
            myLogD("Error: $e")
            emptyList()
        }
    }
}