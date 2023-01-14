package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName

data class Currencies (

    @SerializedName("code"   ) var code   : String? = null,
    @SerializedName("name"   ) var name   : String? = null,
    @SerializedName("symbol" ) var symbol : String? = null

)