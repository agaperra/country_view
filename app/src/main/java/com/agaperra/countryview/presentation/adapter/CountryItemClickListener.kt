package com.agaperra.countryview.presentation.adapter

import com.agaperra.countryview.data.dto.country_list.Country

/**
 * Country item click listener
 *
 * @constructor Create empty Country item click listener
 */
interface CountryItemClickListener {
    fun onItemClick(item: Country)
}