package mapp.test.evaluationassignmenttestapp.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mapp.test.core.domain.GetLeadsUseCase
import mapp.test.core.domain.createlead.CreateLeadUseCase
import mapp.test.core.domain.createlead.GetAdSourcesUseCase
import mapp.test.core.domain.createlead.GetCitiesUseCase
import mapp.test.core.domain.createlead.GetCountriesUseCase
import mapp.test.core.domain.createlead.GetIntentionTypesUseCase
import mapp.test.core.domain.createlead.GetLanguagesUseCase
import mapp.test.core.domain.leadprofile.GetLeadProfileUseCase
import mapp.test.core.domain.leadprofile.GetLeadStatusTypesUseCase
import mapp.test.core.service.LeadsService
import mapp.test.core.service.LeadsServiceImpl
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.service.createlead.CreateLeadServiceImpl
import mapp.test.core.service.leadprofile.LeadProfileService
import mapp.test.core.service.leadprofile.LeadProfileServiceImpl
import mapp.test.evaluationassignmenttestapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BuildConfig.BASE_URL)
            .okHttpClient(
                OkHttpClient.Builder()
                    .addInterceptor(AuthorizationInterceptor())
                    .build()
            )
            .build()
    }

    private class AuthorizationInterceptor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .apply {
                    addHeader("Authorization", BuildConfig.JWT)
                }
                .build()
            return chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideLeadsService(apolloClient: ApolloClient): LeadsService {
        return LeadsServiceImpl(apolloClient)
    }


    @Provides
    @Singleton
    fun provideGetLeadsUseCase(leadsService: LeadsService): GetLeadsUseCase {
        return GetLeadsUseCase(leadsService)
    }

    @Provides
    @Singleton
    fun provideCreateLeadService(apolloClient: ApolloClient): CreateLeadService {
        return CreateLeadServiceImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetIntentionTypesUseCase(service: CreateLeadService): GetIntentionTypesUseCase {
        return GetIntentionTypesUseCase(service)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(service: CreateLeadService): GetCountriesUseCase {
        return GetCountriesUseCase(service)
    }

    @Provides
    @Singleton
    fun provideGetCitiesUseCase(service: CreateLeadService): GetCitiesUseCase {
        return GetCitiesUseCase(service)
    }

    @Provides
    @Singleton
    fun provideGetLanguagesUseCase(service: CreateLeadService): GetLanguagesUseCase {
        return GetLanguagesUseCase(service)
    }

    @Provides
    @Singleton
    fun provideGetAdSourcesUseCase(service: CreateLeadService): GetAdSourcesUseCase {
        return GetAdSourcesUseCase(service)
    }

    @Provides
    @Singleton
    fun provideCreateLeadUseCase(service: CreateLeadService): CreateLeadUseCase {
        return CreateLeadUseCase(service)
    }

    @Provides
    @Singleton
    fun provideLeadProfileService(apolloClient: ApolloClient): LeadProfileService {
        return LeadProfileServiceImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetLeadProfileUseCase(service: LeadProfileService): GetLeadProfileUseCase {
        return GetLeadProfileUseCase(service)
    }

    @Provides
    @Singleton
    fun provideGetLeadStatusTypesUseCase(service: LeadProfileService): GetLeadStatusTypesUseCase {
        return GetLeadStatusTypesUseCase(service)
    }


}