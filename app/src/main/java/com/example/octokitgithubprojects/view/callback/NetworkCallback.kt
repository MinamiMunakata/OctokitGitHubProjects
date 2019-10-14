package com.example.octokitgithubprojects.view.callback

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import com.example.octokitgithubprojects.model.NetworkState
import com.example.octokitgithubprojects.model.NetworkStateLiveData

class NetworkCallback:ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        updateNetworkState(network)
    }

    override fun onCapabilitiesChanged(
        network: Network,
        networkCapabilities: NetworkCapabilities?
    ) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        updateNetworkState(network)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        updateNetworkState(network)
    }

    override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties?) {
        super.onLinkPropertiesChanged(network, linkProperties)
        updateNetworkState(network)
    }

    override fun onUnavailable() {
        super.onUnavailable()
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
        updateNetworkState(network)
    }

    private fun updateNetworkState(network: Network) {
        NetworkStateLiveData.networkState.postValue(NetworkState(network))
    }
}