package com.agaperra.countryview.data.repository

import com.agaperra.countryview.data.api.CountryApi
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.domain.repository.CountryListRepository
import javax.inject.Inject

class CountryListRepositoryImpl @Inject constructor(
    private val api: CountryApi,
) : CountryListRepository {
    override suspend fun getCountryList(): List<Country> = api.countryList()

}