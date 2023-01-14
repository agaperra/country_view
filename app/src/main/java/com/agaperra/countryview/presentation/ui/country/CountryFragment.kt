package com.agaperra.countryview.presentation.ui.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.agaperra.countryview.databinding.FragmentCountryBinding
import com.agaperra.countryview.presentation.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main fragment
 *
 * @constructor Create empty Main fragment
 */
@AndroidEntryPoint
class CountryFragment : BindingFragment<FragmentCountryBinding>() {

    /**
     * Binding inflater
     *
     * Creating a binding instance
     */
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentCountryBinding::inflate

    // the model will not be recreated every time
    private val viewModel: CountryViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}