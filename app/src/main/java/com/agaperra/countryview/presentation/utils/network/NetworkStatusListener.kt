package com.agaperra.countryview.presentation.utils.network

import kotlinx.coroutines.flow.SharedFlow

/**
 * Network status listener
 *
 * @constructor Create empty Network status listener
 */
interface NetworkStatusListener {

    val networkStatus: SharedFlow<NetworkStatus>

}