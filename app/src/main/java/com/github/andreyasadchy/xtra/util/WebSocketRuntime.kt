package com.github.andreyasadchy.xtra.util

import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

object WebSocketRuntime {
    @Volatile
    var isAppInForeground: Boolean = false

    private val activeSocketCount = AtomicInteger(0)
    private val healthySocketCount = AtomicInteger(0)
    private val reconnectScheduledCount = AtomicLong(0)
    private val totalConnectCount = AtomicLong(0)
    private val totalDisconnectCount = AtomicLong(0)

    fun onConnected() {
        activeSocketCount.incrementAndGet()
        totalConnectCount.incrementAndGet()
    }

    fun onDisconnected() {
        while (true) {
            val currentHealthy = healthySocketCount.get()
            if (currentHealthy == 0) {
                break
            }
            if (healthySocketCount.compareAndSet(currentHealthy, currentHealthy - 1)) {
                break
            }
        }
        while (true) {
            val current = activeSocketCount.get()
            if (current == 0) {
                break
            }
            if (activeSocketCount.compareAndSet(current, current - 1)) {
                if (current - 1 == 0) {
                    healthySocketCount.set(0)
                }
                break
            }
        }
        totalDisconnectCount.incrementAndGet()
    }

    fun onSubscriptionHealthy() {
        healthySocketCount.incrementAndGet()
        reconnectScheduledCount.set(0)
    }

    fun onReconnectScheduled(attempt: Int, delayMs: Long, reason: String) {
        if (healthySocketCount.get() > 0) {
            return
        }
        val count = reconnectScheduledCount.incrementAndGet()
        if (BuildConfig.DEBUG && (count <= 5 || count % 25L == 0L)) {
            Log.d(
                TAG,
                "reconnect#$count attempt=$attempt delayMs=$delayMs foreground=$isAppInForeground reason=$reason active=${activeSocketCount.get()}"
            )
        }
    }

    fun snapshot(): String {
        return "foreground=$isAppInForeground active=${activeSocketCount.get()} healthy=${healthySocketCount.get()} connect=${totalConnectCount.get()} disconnect=${totalDisconnectCount.get()} reconnect=${reconnectScheduledCount.get()}"
    }

    private const val TAG = "WebSocketRuntime"
}
