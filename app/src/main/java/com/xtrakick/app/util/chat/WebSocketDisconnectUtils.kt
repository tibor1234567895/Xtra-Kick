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

    /**
     * Raw socket failures (lost Wi-Fi, airplane mode, NAT timeouts). Callers should show
     * a friendly reconnecting note instead of the raw message. Host-resolution failures
     * are excluded — they keep existing silent handling.
     */
    @JvmStatic
    fun isTransportError(message: String?): Boolean {
        if (message.isNullOrBlank()) {
            return false
        }
        return message.contains("SocketException", ignoreCase = true) ||
            message.contains("SocketTimeoutException", ignoreCase = true) ||
            message.contains("ConnectException", ignoreCase = true) ||
            message.contains("NoRouteToHostException", ignoreCase = true) ||
            message.contains("software caused connection abort", ignoreCase = true) ||
            message.contains("connection reset", ignoreCase = true) ||
            message.contains("broken pipe", ignoreCase = true) ||
            message.contains("socket closed", ignoreCase = true) ||
            message.contains("connection timed out", ignoreCase = true) ||
            message.contains("network is unreachable", ignoreCase = true) ||
            message.contains("ENETUNREACH", ignoreCase = true) ||
            message.contains("ETIMEDOUT", ignoreCase = true) ||
            message.contains("ECONNRESET", ignoreCase = true) ||
            message.contains("EPIPE", ignoreCase = true)
    }
}
