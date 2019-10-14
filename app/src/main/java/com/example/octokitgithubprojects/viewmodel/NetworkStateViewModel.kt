package com.example.octokitgithubprojects.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.octokitgithubprojects.model.NetworkState
import com.example.octokitgithubprojects.model.NetworkStateLiveData

class NetworkStateViewModel(application: Application) {
    val networkStateObservable: MutableLiveData<NetworkState> = NetworkStateLiveData.networkState

}