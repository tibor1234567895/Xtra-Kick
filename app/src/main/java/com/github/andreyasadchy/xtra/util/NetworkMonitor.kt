package com.github.andreyasadchy.xtra.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkMonitor @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    enum class NetworkType {
        UNKNOWN,
        WIFI,
        CELLULAR,
        OTHER,
        NONE
    }

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val _networkType = MutableStateFlow(NetworkType.UNKNOWN)
    val networkType: StateFlow<NetworkType> = _networkType.asStateFlow()

    val isCellular: Boolean get() = _networkType.value == NetworkType.CELLULAR

    private var currentNetwork: Network? = null

    init {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                currentNetwork = network
                val caps = connectivityManager.getNetworkCapabilities(network)
                if (caps != null) {
                    updateNetworkType(caps)
                }
            }

            override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                if (network == currentNetwork) {
                    updateNetworkType(caps)
                }
            }

            override fun onLost(network: Network) {
                if (network == currentNetwork) {
                    currentNetwork = null
                    _networkType.value = NetworkType.NONE
                }
            }
        }
        connectivityManager.registerDefaultNetworkCallback(callback)
    }

    private fun updateNetworkType(caps: NetworkCapabilities) {
        if (!caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            return
        }
        _networkType.value = when {
            caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkType.WIFI
            caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.CELLULAR
            else -> NetworkType.OTHER
        }
    }

    fun formatNetworkType(type: NetworkType): String? {
        return when (type) {
            NetworkType.WIFI -> "Wi-Fi"
            NetworkType.CELLULAR -> "mobile data"
            else -> null
        }
    }
}
