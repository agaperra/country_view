package com.agaperra.countryview.presentation.utils.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData

/**
 * Network connection receiver
 *
 * Required to get the network status during a request to the server
 *
 * @constructor Create empty Network connection receiver
 */
class NetworkConnectionReceiver : BroadcastReceiver() {

    companion object {
        private val flag: MutableLiveData<Boolean> = MutableLiveData()
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        when(checkInternet(context)){
            true -> flag.value = false
            false -> flag.value = true
        }
    }

    fun checkInternet(context: Context?): Boolean {
        context?.let {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork!= null && activeNetwork.isConnectedOrConnecting
        }?: return false
    }

}