package com.agaperra.countryview.presentation.ui.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agaperra.countryview.data.dto.country_list.CountryListResponse
import com.agaperra.countryview.presentation.utils.network.HandleConnection
import com.agaperra.countryview.presentation.utils.network.NetworkStatusListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val networkStatusListener: NetworkStatusListener,
) : ViewModel(), HandleConnection {

    // access from the fragment is closed
    private val _contentEvent =
        MutableStateFlow<ContentEvent<CountryListResponse>>(ContentEvent.Loading())

    // access from the fragment is open
    val contentEvent = _contentEvent.asStateFlow()

    fun getContent() {
        networkStatusListener.networkStatus.onEach { status ->
            status.apply(this)
        }.launchIn(viewModelScope)
    }

    fun getCountryList() {
        TODO("Take country list")
    }


    override fun available() {
        getCountryList()
    }

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