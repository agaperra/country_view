package com.agaperra.countryview.data.api

import com.agaperra.countryview.data.dto.country_list.Country
import retrofit2.http.GET

/**
 * Country api
 *
 * @constructor Create empty Country api
 */
interface CountryApi {

    /**
     * Country list
     *
     * @return
     */
    @GET("v2/all")
    suspend fun countryList(
    ): List<Country>

}