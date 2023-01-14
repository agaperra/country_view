package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName

data class Flags (

    @SerializedName("svg" ) var svg : String? = null,
    @SerializedName("png" ) var png : String? = null

)