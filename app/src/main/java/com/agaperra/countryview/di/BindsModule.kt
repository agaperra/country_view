package com.agaperra.countryview.di

import android.content.BroadcastReceiver
import com.agaperra.countryview.data.repository.CountryListRepositoryImpl
import com.agaperra.countryview.domain.repository.CountryListRepository
import com.agaperra.countryview.presentation.utils.network.NetworkConnectionReceiver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface BindsModule {
    @Binds
    fun bindRepository(repositoryImpl: CountryListRepositoryImpl): CountryListRepository

//    @Binds
//    fun bindNetworkConnectionReceiver(networkConnectionReceiver: NetworkConnectionReceiver): BroadcastReceiver

}