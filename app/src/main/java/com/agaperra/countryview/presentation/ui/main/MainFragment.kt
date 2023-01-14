package com.agaperra.countryview.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.agaperra.countryview.databinding.FragmentMainBinding
import com.agaperra.countryview.presentation.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main fragment
 *
 * @constructor Create empty Main fragment
 */
@AndroidEntryPoint
class MainFragment : BindingFragment<FragmentMainBinding>() {

    /**
     * Binding inflater
     *
     * Creating a binding instance
     */
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentMainBinding::inflate

    // the model will not be recreated every time
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}