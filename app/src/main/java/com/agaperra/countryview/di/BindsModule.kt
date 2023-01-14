package com.agaperra.countryview.di

import com.agaperra.countryview.data.repository.CountryListRepositoryImpl
import com.agaperra.countryview.domain.repository.CountryListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Binds module
 *
 * @constructor Create empty Binds module
 */
@Module
@InstallIn(ViewModelComponent::class)
interface BindsModule {
    /**
     * Bind repository
     *
     * @param repositoryImpl
     * @return
     */
    @Binds
    fun bindRepository(repositoryImpl: CountryListRepositoryImpl): CountryListRepository

}