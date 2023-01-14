package com.agaperra.countryview.presentation.adapter

import com.agaperra.countryview.data.dto.country_list.Country

interface CountryItemClickListener {
    fun onItemClick(item: Country)
}