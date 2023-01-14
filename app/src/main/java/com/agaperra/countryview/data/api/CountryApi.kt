package com.agaperra.countryview.data.api

import com.agaperra.countryview.data.dto.country_list.CountryListResponse
import retrofit2.http.GET

interface CountryApi {

    @GET("v2/all")
    suspend fun countryList(
    ): CountryListResponse

//    @GET("v2/name/{name}?fullText=true")
//    suspend fun countryDetails(
//        @Path("name", encoded = true) name: String
//    ): CountryResponse

}