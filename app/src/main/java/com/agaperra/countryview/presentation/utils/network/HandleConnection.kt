package com.agaperra.countryview.presentation.utils.network

/**
 * Handle connection
 *
 *Interface with network states
 *
 * @constructor Create empty Handle connection
 */
interface HandleConnection {
    /**
     * Available
     *
     * network is available
     */
    fun available()

    /**
     * Unavailable
     *
     * network is unavailable
     */
    fun unavailable()
}