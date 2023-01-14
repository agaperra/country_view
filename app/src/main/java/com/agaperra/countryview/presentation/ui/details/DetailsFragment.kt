package com.agaperra.countryview.presentation.ui.details

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import coil.load
import com.agaperra.countryview.R
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.databinding.FragmentDetailsBinding
import com.agaperra.countryview.presentation.BindingFragment
import com.agaperra.countryview.presentation.ui.country.CountryViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import java.io.Serializable
import javax.inject.Inject

/**
 * Details fragment
 *
 * @constructor Create empty Details fragment
 */
@AndroidEntryPoint
class DetailsFragment : BindingFragment<FragmentDetailsBinding>() {

    /**
     * Binding inflater
     *
     * Creating a binding instance
     */
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentDetailsBinding::inflate

    private
    val Fragment.navArgs: Serializable?
        get() = arguments?.getSerializable("country")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if ((navArgs as? Country) == null) {
            showSnack(view)
        } else {
            showResult(navArgs as Country)
        }

    }

    /**
     * Show snack
     *
     * Snack bar make helper
     *
     * @param view
     */
    private fun showSnack(view: View) {
        val snackBar =
            Snackbar.make(
                view,
                resources.getString(R.string.error_serialize),
                Snackbar.LENGTH_LONG
            )
        val customSnackView: View =
            layoutInflater.inflate(R.layout.rounded, null)
        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        val snackbarLayout = snackBar.view as Snackbar.SnackbarLayout

        snackbarLayout.setPadding(20, 20, 20, 200)
        snackbarLayout.addView(customSnackView, 0)
        snackBar.show()
    }

    /**
     * Show result
     *
     * Show result in the view
     *
     * @param country
     */
    private fun showResult(country: Country?) = with(binding) {
        country.let {

            countryFlag.load(
                country!!.flags?.png,
            ) {
                placeholder(R.drawable.ic_baseline_no_photography_24)
            }

            region.text = getString(
                R.string.region,
                it?.region ?: R.string.unknown
            )

            countryName.text = it?.name ?: getString(R.string.unknown)

            capital.text = getString(
                R.string.capital,
                it?.capital ?: R.string.unknown
            )
            currencies.text = getString(
                R.string.currencies,
                (it?.currencies?.get(0)?.name + " " + it?.currencies?.get(0)?.symbol)
            )

            timezone.text = getString(
                R.string.timezone,
                it?.timezones?.joinToString(" ,") ?: R.string.unknown
            )
            population.text = getString(
                R.string.population,
                it?.population.toString()
            )
            independent.text = getString(
                R.string.independent,
                it?.independent.toString()
            )


        }
    }

}