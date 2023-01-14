package com.agaperra.countryview.di

import android.content.Context
import com.agaperra.countryview.BuildConfig
import com.agaperra.countryview.data.api.CountryApi
import com.agaperra.countryview.presentation.utils.network.NetworkConnectionReceiver
import com.agaperra.countryview.presentation.utils.network.NetworkStatusListener
import com.agaperra.countryview.presentation.utils.network.NetworkStatusListenerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val API = "https://restcountries.com"


    @Singleton
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
        }
        interceptors.add(loggingInterceptor)
        return interceptors
    }

    @Singleton
    @Provides
    fun provideClient(interceptors: ArrayList<Interceptor>): OkHttpClient =
        OkHttpClient.Builder().followRedirects(false).also { client ->
            interceptors.forEach { client.addInterceptor(it) }
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(API)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CountryApi = retrofit.create(CountryApi::class.java)

    @Singleton
    @Provides
    fun provideNetworkStatusListener(@ApplicationContext context: Context): NetworkStatusListener =
        NetworkStatusListenerImpl(context)


    @Singleton
    @Provides
    fun provideNetworkConnectionReceiver(): NetworkConnectionReceiver =
        NetworkConnectionReceiver()

}