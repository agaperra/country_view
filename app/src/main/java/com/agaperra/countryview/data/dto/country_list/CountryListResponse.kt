package com.agaperra.countryview.data.dto.country_list

import com.google.gson.annotations.SerializedName

data class CountryListResponse (
    @SerializedName("name"           ) var name           : String?                  = null,
    @SerializedName("topLevelDomain" ) var topLevelDomain : ArrayList<String>        = arrayListOf(),
    @SerializedName("alpha2Code"     ) var alpha2Code     : String?                  = null,
    @SerializedName("alpha3Code"     ) var alpha3Code     : String?                  = null,
    @SerializedName("callingCodes"   ) var callingCodes   : ArrayList<String>        = arrayListOf(),
    @SerializedName("capital"        ) var capital        : String?                  = null,
    @SerializedName("altSpellings"   ) var altSpellings   : ArrayList<String>        = arrayListOf(),
    @SerializedName("subregion"      ) var subregion      : String?                  = null,
    @SerializedName("region"         ) var region         : String?                  = null,
    @SerializedName("population"     ) var population     : Int?                     = null,
    @SerializedName("latlng"         ) var latlng         : ArrayList<Int>           = arrayListOf(),
    @SerializedName("demonym"        ) var demonym        : String?                  = null,
    @SerializedName("area"           ) var area           : Int?                     = null,
    @SerializedName("timezones"      ) var timezones      : ArrayList<String>        = arrayListOf(),
    @SerializedName("borders"        ) var borders        : ArrayList<String>        = arrayListOf(),
    @SerializedName("nativeName"     ) var nativeName     : String?                  = null,
    @SerializedName("numericCode"    ) var numericCode    : String?                  = null,
    @SerializedName("flags"          ) var flags          : Flags?                   = Flags(),
    @SerializedName("currencies"     ) var currencies     : ArrayList<Currencies>    = arrayListOf(),
    @SerializedName("languages"      ) var languages      : ArrayList<Languages>     = arrayListOf(),
    @SerializedName("translations"   ) var translations   : Translations?            = Translations(),
    @SerializedName("flag"           ) var flag           : String?                  = null,
    @SerializedName("regionalBlocs"  ) var regionalBlocs  : ArrayList<RegionalBlocs> = arrayListOf(),
    @SerializedName("cioc"           ) var cioc           : String?                  = null,
    @SerializedName("independent"    ) var independent    : Boolean?                 = null
)