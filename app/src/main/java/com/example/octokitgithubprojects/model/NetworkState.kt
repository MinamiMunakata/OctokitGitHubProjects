package com.example.octokitgithubprojects.model

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import com.example.octokitgithubprojects.NetworkApplication

class NetworkState(private val network: Network) {
    private val connectivityManager =
        NetworkApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkInfo: NetworkInfo?
        get() {
            return connectivityManager.getNetworkInfo(network)
        }

    val isConnected: Boolean = networkInfo?.isConnected ?: false
}