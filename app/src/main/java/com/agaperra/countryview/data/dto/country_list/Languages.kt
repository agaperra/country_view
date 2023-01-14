package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName

data class Languages (

    @SerializedName("iso639_1"   ) var iso6391    : String? = null,
    @SerializedName("iso639_2"   ) var iso6392    : String? = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("nativeName" ) var nativeName : String? = null

)