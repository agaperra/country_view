package com.agaperra.countryview.presentation.utils.network

import kotlinx.coroutines.flow.SharedFlow

interface NetworkStatusListener {

    val networkStatus: SharedFlow<NetworkStatus>

}