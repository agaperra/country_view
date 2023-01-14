package com.agaperra.countryview.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.agaperra.countryview.data.dto.country_list.Country

class CountryDiffUtil : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Country, newItem: Country) =
        oldItem == newItem

}