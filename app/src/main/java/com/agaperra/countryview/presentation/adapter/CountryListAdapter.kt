package com.agaperra.countryview.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.agaperra.countryview.R
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.databinding.CountryItemBinding

/**
 * Country list adapter
 *
 * @property onCountryClickListener
 * @constructor Create empty Country list adapter
 */
class CountryListAdapter(val onCountryClickListener: CountryItemClickListener) :
    ListAdapter<Country, CountryListAdapter.BinListViewHolder>(CountryDiffUtil()) {

    /**
     * Bin list view holder
     *
     * @property binding
     * @constructor Create empty Bin list view holder
     */
    inner class BinListViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemPosition: Int) {

            val country = getItem(itemPosition)

            binding.countryName.text = country.name
            binding.countryFlag.load(country.flags?.png) {
                placeholder(R.drawable.ic_baseline_no_photography_24)
            }

            binding.root.setOnClickListener {
                onCountryClickListener.onItemClick(country)
            }
        }
    }

    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BinListViewHolder(
            CountryItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.country_item,
                    parent,
                    false
                )
            )
        )

    /**
     * On bind view holder
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: BinListViewHolder, position: Int) =
        holder.bind(itemPosition = position)


}