package mapp.test.core.service

import com.apollographql.apollo3.ApolloClient
import mapp.test.FetchCountriesQuery
import mapp.test.core.data.CountryViewData
import mapp.test.core.mappers.mapToCountryModelList

class LeadsServiceImpl(
    private val apolloClient: ApolloClient
) : LeadsService {

    override suspend fun fetchCountries(): List<CountryViewData> {
        return apolloClient.query(FetchCountriesQuery())
            .execute()
            .data?.fetchCountries?.mapToCountryModelList() ?: emptyList()
    }

}