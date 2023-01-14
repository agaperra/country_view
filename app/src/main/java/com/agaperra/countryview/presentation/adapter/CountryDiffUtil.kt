package com.agaperra.countryview.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.agaperra.countryview.data.dto.country_list.Country

/**
 * Country diff util
 *
 * @constructor Create empty Country diff util
 */
class CountryDiffUtil : DiffUtil.ItemCallback<Country>() {

    /**
     * Are items the same
     *
     * @param oldItem
     * @param newItem
     */
    override fun areItemsTheSame(oldItem: Country, newItem: Country) =
        oldItem.name == newItem.name

    /**
     * Are contents the same
     *
     * @param oldItem
     * @param newItem
     */
    override fun areContentsTheSame(oldItem: Country, newItem: Country) =
        oldItem == newItem

}