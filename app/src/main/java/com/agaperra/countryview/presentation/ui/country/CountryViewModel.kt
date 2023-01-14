package com.agaperra.countryview.presentation.ui.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agaperra.countryview.data.dto.country_list.Country
import com.agaperra.countryview.domain.use_case.GetCountryList
import com.agaperra.countryview.presentation.utils.network.HandleConnection
import com.agaperra.countryview.presentation.utils.network.NetworkConnectionReceiver
import com.agaperra.countryview.presentation.utils.network.NetworkStatusListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Country view model
 *
 * @property networkStatusListener
 * @property getCountryList
 * @constructor Create empty Country view model
 */
@HiltViewModel
class CountryViewModel @Inject constructor(
    private val networkStatusListener: NetworkStatusListener,
    private val getCountryList: GetCountryList
) : ViewModel(), HandleConnection {

    // access from the fragment is closed
    private val _contentEvent =
        MutableStateFlow<ContentEvent<List<Country>>>(ContentEvent.Loading())

    // access from the fragment is open
    val contentEvent = _contentEvent.asStateFlow()

    /**
     * Get content
     *
     * Getting the main content
     */
    fun getContent() {
        networkStatusListener.networkStatus.onEach { status ->
            status.apply(this)
        }.launchIn(viewModelScope)
    }

    /**
     * Get list
     *
     * The function of getting a list of countries
     */
    private fun getList() {
        getCountryList().onEach { result ->
            _contentEvent.value = result
        }.flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }


    /**
     * Available
     *
     * Actions if the network is present
     */
    override fun available() {
        getList()
    }

    /**
     * Unavailable
     *
     * Actions if there is no network
     */
    override fun unavailable() {
        if (_contentEvent.value.data != null) _contentEvent.value =
            ContentEvent.Error(error = "No internet connection")
    }


    /**
     * Content event
     *
     * Sealed class for error handling or correct operation
     *
     * @constructor Create empty Content event
     */
    sealed class ContentEvent<T>(val data: T? = null) {
        // error from the server side
        data class Error<T>(val error: String) : ContentEvent<T>()

        // success
        class Success<T>(data: T) : ContentEvent<T>(data)

        // loading
        class Loading<T>(data: T? = null) : ContentEvent<T>(data)
    }


}