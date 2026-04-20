package com.github.andreyasadchy.xtra.util

import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.XtraApp
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

object WebSocketRuntime {
    @Volatile
    var isAppInForeground: Boolean = false

    private val activeSocketCount = AtomicInteger(0)
    private val reconnectScheduledCount = AtomicLong(0)
    private val totalConnectCount = AtomicLong(0)
    private val totalDisconnectCount = AtomicLong(0)

    fun onConnected() {
        activeSocketCount.incrementAndGet()
        totalConnectCount.incrementAndGet()
    }

    fun onDisconnected() {
        while (true) {
            val current = activeSocketCount.get()
            if (current == 0) {
                break
            }
            if (activeSocketCount.compareAndSet(current, current - 1)) {
                break
            }
        }
        totalDisconnectCount.incrementAndGet()
    }

    fun onReconnectScheduled(attempt: Int, delayMs: Long, reason: String) {
        val count = reconnectScheduledCount.incrementAndGet()
        if (isWebSocketDebugEnabled() && (count <= 5 || count % 25L == 0L)) {
            Log.d(
                TAG,
                "reconnect#$count attempt=$attempt delayMs=$delayMs foreground=$isAppInForeground reason=$reason active=${activeSocketCount.get()}"
            )
        }
    }

    private fun isWebSocketDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && runCatching {
            XtraApp.INSTANCE.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)
        }.getOrDefault(false)
    }

    fun snapshot(): String {
        return "foreground=$isAppInForeground active=${activeSocketCount.get()} connect=${totalConnectCount.get()} disconnect=${totalDisconnectCount.get()} reconnect=${reconnectScheduledCount.get()}"
    }

    private const val TAG = "WebSocketRuntime"
}
