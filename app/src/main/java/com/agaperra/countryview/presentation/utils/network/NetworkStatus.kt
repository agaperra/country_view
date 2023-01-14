package com.agaperra.countryview.presentation.utils.network

/**
 * Network status
 *
 * @constructor Create empty Network status
 */
sealed class NetworkStatus{
    abstract fun apply(handle: HandleConnection)

    object Available: NetworkStatus(){
        override fun apply(handle: HandleConnection) {
            handle.available()
        }
    }

    object Unavailable: NetworkStatus(){
        override fun apply(handle: HandleConnection) {
            handle.unavailable()
        }
    }
}
