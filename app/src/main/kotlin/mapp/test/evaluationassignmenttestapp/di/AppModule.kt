package mapp.test.evaluationassignmenttestapp.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mapp.test.core.domain.GetCountriesUseCase
import mapp.test.core.service.LeadsService
import mapp.test.core.service.LeadsServiceImpl
import mapp.test.evaluationassignmenttestapp.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BuildConfig.BASE_URL)
//            .addHttpHeader("Authorization",BuildConfig.JWT)
            .build()
    }

    @Provides
    @Singleton
    fun provideLeadsService(apolloClient: ApolloClient): LeadsService {
        return LeadsServiceImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(leadsService: LeadsService): GetCountriesUseCase {
        return GetCountriesUseCase(leadsService)
    }

}