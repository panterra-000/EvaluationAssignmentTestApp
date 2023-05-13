package mapp.test.core.service.createlead

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import mapp.test.FetchAdSourcesQuery
import mapp.test.FetchCitiesQuery
import mapp.test.FetchCountriesQuery
import mapp.test.FetchIntentionTypesQuery
import mapp.test.FetchLanguagesQuery
import mapp.test.core.data.AdSourceModel
import mapp.test.core.data.CityModel
import mapp.test.core.data.CountryModel
import mapp.test.core.data.IntentionModel
import mapp.test.core.data.LanguageModel
import mapp.test.core.mappers.mapToAdSourceModelList
import mapp.test.core.mappers.mapToCityModelList
import mapp.test.core.mappers.mapToCountryModelList
import mapp.test.core.mappers.mapToIntentionTypeModelList
import mapp.test.core.mappers.mapToLanguageModelList
import mapp.test.core.util.AppNetworkResponse
import mapp.test.core.util.myLogD

class CreateLeadServiceImpl(
    private val apolloClient: ApolloClient
) : CreateLeadService {

    override suspend fun fetchIntentionTypes(): AppNetworkResponse<List<IntentionModel>> {
        return try {
            val resp = apolloClient.query(FetchIntentionTypesQuery())
                .execute().data?.fetchLeadIntentionTypes?.mapToIntentionTypeModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }

    override suspend fun fetchCountries(): AppNetworkResponse<List<CountryModel>> {
        return try {
            val resp = apolloClient.query(FetchCountriesQuery())
                .execute().data?.fetchCountries?.mapToCountryModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }

    override suspend fun fetchCities(id: Int): AppNetworkResponse<List<CityModel>> {
        return try {
            val resp = apolloClient.query(FetchCitiesQuery(id))
                .execute().data?.cities?.mapToCityModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }

    override suspend fun fetchLanguages(): AppNetworkResponse<List<LanguageModel>> {
        return try {
            val resp = apolloClient.query(FetchLanguagesQuery())
                .execute().data?.languages?.mapToLanguageModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }

    override suspend fun fetchAdSources(): AppNetworkResponse<List<AdSourceModel>> {
        return try {
            val resp = apolloClient.query(FetchAdSourcesQuery())
                .execute().data?.fetchAdSources?.mapToAdSourceModelList()
                ?: emptyList()
            AppNetworkResponse.Success(resp)
        } catch (e: ApolloException) {
            myLogD("Error: $e")
            AppNetworkResponse.Error(message = e.message.toString())
        }
    }

}