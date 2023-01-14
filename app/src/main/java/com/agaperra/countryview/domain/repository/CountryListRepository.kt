package com.agaperra.countryview.domain.repository

import com.agaperra.countryview.data.dto.country_list.Country

interface CountryListRepository {
    suspend fun getCountryList(): List<Country>
}