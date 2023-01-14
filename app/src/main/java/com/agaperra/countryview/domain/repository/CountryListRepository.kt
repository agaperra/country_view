package com.agaperra.countryview.domain.repository

import com.agaperra.countryview.data.dto.country_list.Country

/**
 * Country list repository
 *
 * @constructor Create empty Country list repository
 */
interface CountryListRepository {
    suspend fun getCountryList(): List<Country>
}