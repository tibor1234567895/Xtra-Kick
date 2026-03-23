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
}
