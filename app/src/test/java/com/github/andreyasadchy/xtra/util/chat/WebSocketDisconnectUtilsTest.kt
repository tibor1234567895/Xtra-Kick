package com.github.andreyasadchy.xtra.util.chat

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WebSocketDisconnectUtilsTest {

    @Test
    fun detectsHostResolutionFailures() {
        assertTrue(WebSocketDisconnectUtils.isHostResolutionFailure("java.net.UnknownHostException: Unable to resolve host 'ws.kick.com'"))
        assertTrue(WebSocketDisconnectUtils.isHostResolutionFailure("No address associated with hostname"))
        assertTrue(WebSocketDisconnectUtils.isHostResolutionFailure("Unable to resolve host 'ws.kick.com'"))
    }

    @Test
    fun ignoresOtherDisconnectReasons() {
        assertFalse(WebSocketDisconnectUtils.isHostResolutionFailure(null))
        assertFalse(WebSocketDisconnectUtils.isHostResolutionFailure(""))
        assertFalse(WebSocketDisconnectUtils.isHostResolutionFailure("java.net.SocketTimeoutException: timeout"))
    }

    @Test
    fun detectsTransientGatewayFailures() {
        assertTrue(WebSocketDisconnectUtils.isTransientGatewayFailure("HTTP/1.1 502 Bad Gateway"))
        assertTrue(WebSocketDisconnectUtils.isTransientGatewayFailure("HTTP/1.1 503 Service Unavailable"))
        assertTrue(WebSocketDisconnectUtils.isTransientGatewayFailure("HTTP/1.1 504 Gateway Time-out"))
        assertTrue(WebSocketDisconnectUtils.isTransientGatewayFailure("504 Gateway Timeout"))
    }

    @Test
    fun ignoresNonGatewayFailures() {
        assertFalse(WebSocketDisconnectUtils.isTransientGatewayFailure(null))
        assertFalse(WebSocketDisconnectUtils.isTransientGatewayFailure(""))
        assertFalse(WebSocketDisconnectUtils.isTransientGatewayFailure("HTTP/1.1 401 Unauthorized"))
        assertFalse(WebSocketDisconnectUtils.isTransientGatewayFailure("java.net.UnknownHostException"))
    }
}
