package com.example.octokitgithubprojects

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.getSystemService

class NetworkApplication: Application() {
    companion object {
        private lateinit var instance: NetworkApplication

        fun getInstance(): NetworkApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        // Receive notifications about changes in the system default network.
        val connectivityManager: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback())
    }
}