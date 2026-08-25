package com.xtrakick.app.util.chat

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

    @JvmStatic
    fun isTransientGatewayFailure(message: String?): Boolean {
        if (message.isNullOrBlank()) {
            return false
        }
        return message.contains("HTTP/1.1 502", ignoreCase = true) ||
            message.contains("HTTP/1.1 503", ignoreCase = true) ||
            message.contains("HTTP/1.1 504", ignoreCase = true) ||
            message.contains("502 Bad Gateway", ignoreCase = true) ||
            message.contains("503 Service Unavailable", ignoreCase = true) ||
            message.contains("504 Gateway Time-out", ignoreCase = true) ||
            message.contains("504 Gateway Timeout", ignoreCase = true)
    }
}
