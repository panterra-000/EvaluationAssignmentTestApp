package mapp.test.evaluationassignmenttestapp.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mapp.test.core.domain.GetCountriesUseCase
import mapp.test.core.domain.GetLeadsUseCase
import mapp.test.core.service.LeadsService
import mapp.test.core.service.LeadsServiceImpl
import mapp.test.core.service.createlead.CreateLeadService
import mapp.test.core.service.createlead.CreateLeadServiceImpl
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
    fun provideCreateLeadService(apolloClient: ApolloClient): CreateLeadService {
        return CreateLeadServiceImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(leadsService: LeadsService): GetCountriesUseCase {
        return GetCountriesUseCase(leadsService)
    }

    @Provides
    @Singleton
    fun provideGetLeadsUseCase(leadsService: LeadsService): GetLeadsUseCase {
        return GetLeadsUseCase(leadsService)
    }
}