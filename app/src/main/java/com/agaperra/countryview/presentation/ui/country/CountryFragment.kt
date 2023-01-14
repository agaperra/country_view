package com.agaperra.countryview.presentation.ui.country

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.agaperra.countryview.R
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.databinding.FragmentCountryBinding
import com.agaperra.countryview.presentation.BindingFragment
import com.agaperra.countryview.presentation.adapter.CountryItemClickListener
import com.agaperra.countryview.presentation.adapter.CountryListAdapter
import com.agaperra.countryview.presentation.utils.network.NetworkConnectionReceiver
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


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

    @Inject
    internal lateinit var networkConnectionReceiver: NetworkConnectionReceiver

    private val countryAdapter by lazy {
        CountryListAdapter(object : CountryItemClickListener {
            override fun onItemClick(item: Country) {
                TODO("add action after click")
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countryList.adapter = countryAdapter
        when (networkConnectionReceiver.checkInternet(requireContext())) {
            true -> {
                viewModel.getContent()
                subscribeToEvents()
            }
            false -> {
                makeBar(view)
                setupIdleUiState()
            }
        }
        viewModel.getContent()
        subscribeToEvents()



        binding.btnUpdate.setOnClickListener {
            setupConnectingUiState()
            when (networkConnectionReceiver.checkInternet(requireContext())) {
                true -> {
                    countryAdapter.notifyItemRangeRemoved(0, countryAdapter.itemCount-1)
                    viewModel.getContent()
                    subscribeToEvents()
                }
                false -> {
                    makeBar(view)
                    setupIdleUiState()
                }
            }
        }
    }


    private fun makeBar(view: View) {
        val snackBar =
            Snackbar.make(view, resources.getString(R.string.no_internet), Snackbar.LENGTH_LONG)
        val customSnackView: View =
            layoutInflater.inflate(R.layout.rounded, null)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        val snackbarLayout = snackBar.view as Snackbar.SnackbarLayout

        snackbarLayout.setPadding(20, 20, 20, 200)
        snackbarLayout.addView(customSnackView, 0)
        snackBar.show()
    }


    private fun subscribeToEvents() {
        lifecycleScope.launchWhenStarted {
            viewModel.contentEvent.collect { event ->
                when (event) {
                    is CountryViewModel.ContentEvent.Error -> {
                        setupIdleUiState()
                        binding.progressBar.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            event.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is CountryViewModel.ContentEvent.Loading -> {
                        setupIdleUiState()
                        binding.progressBar.isVisible = true
                    }
                    is CountryViewModel.ContentEvent.Success -> {
                        setupIdleUiState()
                        binding.progressBar.isVisible = false
                        countryAdapter.submitList(event.data)
                    }
                }
            }
        }
    }

    /**
     * Setup connecting ui state
     *
     * changing view settings
     */
    private fun setupConnectingUiState() {
        binding.progressBar.isVisible = true
        binding.btnUpdate.isEnabled = false
    }

    /**
     * Setup idle ui state
     *
     * changing view settings
     */
    private fun setupIdleUiState() {
        binding.progressBar.isVisible = false
        binding.btnUpdate.isEnabled = true
    }
}