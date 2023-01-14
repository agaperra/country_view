package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Flags (

    @SerializedName("svg" ) var svg : String? = null,
    @SerializedName("png" ) var png : String? = null

): Serializable