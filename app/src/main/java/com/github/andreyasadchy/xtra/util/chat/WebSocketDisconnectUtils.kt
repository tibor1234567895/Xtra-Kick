package com.github.andreyasadchy.xtra.util.chat

object WebSocketDisconnectUtils {
    @JvmStatic
    fun isHostResolutionFailure(message: String?): Boolean {
        if (message.isNullOrBlank()) {
            return false
        }
        return message.contains("UnknownHostException", ignoreCase = true) ||
            message.contains("Unable to resolve host", ignoreCase = true) ||
            message.contains("No address associated with hostname", ignoreCase = true)
    }
}
