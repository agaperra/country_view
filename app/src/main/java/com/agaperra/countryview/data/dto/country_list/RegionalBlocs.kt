package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegionalBlocs (

    @SerializedName("acronym" ) var acronym : String? = null,
    @SerializedName("name"    ) var name    : String? = null

): Serializable