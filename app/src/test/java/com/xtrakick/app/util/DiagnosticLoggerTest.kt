package com.xtrakick.app.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DiagnosticLoggerTest {

    @Test
    fun crashOnlyMinimumLogsOnlyCrashes() {
        assertTrue(DiagnosticLogger.shouldLogForMinimum("crash", "crash"))
        assertFalse(DiagnosticLogger.shouldLogForMinimum("error", "crash"))
        assertFalse(DiagnosticLogger.shouldLogForMinimum("warning", "crash"))
    }

    @Test
    fun errorMinimumLogsErrorsAndCrashes() {
        assertTrue(DiagnosticLogger.shouldLogForMinimum("crash", "error"))
        assertTrue(DiagnosticLogger.shouldLogForMinimum("error", "error"))
        assertFalse(DiagnosticLogger.shouldLogForMinimum("warning", "error"))
    }

    @Test
    fun warningMinimumLogsWarningsErrorsAndCrashes() {
        assertTrue(DiagnosticLogger.shouldLogForMinimum("crash", "warning"))
        assertTrue(DiagnosticLogger.shouldLogForMinimum("error", "warning"))
        assertTrue(DiagnosticLogger.shouldLogForMinimum("warning", "warning"))
    }

    @Test
    fun isNetworkExceptionIdentifiesNetworkThrowables() {
        assertTrue(DiagnosticLogger.isNetworkException(java.net.UnknownHostException("images.kick.com")))
        assertTrue(DiagnosticLogger.isNetworkException(java.net.SocketTimeoutException("timeout")))
        assertTrue(DiagnosticLogger.isNetworkException(java.net.ConnectException("failed to connect")))
        assertTrue(DiagnosticLogger.isNetworkException(RuntimeException("wrapper", java.net.UnknownHostException("nested"))))
        assertFalse(DiagnosticLogger.isNetworkException(IllegalStateException("state error")))
        assertFalse(DiagnosticLogger.isNetworkException(NullPointerException("null value")))
    }

    @Test
    fun updateAppStateTogglesIsForeground() {
        DiagnosticLogger.updateAppState(isForeground = true)
        assertTrue(DiagnosticLogger.isForeground)

        DiagnosticLogger.updateAppState(isForeground = false)
        assertFalse(DiagnosticLogger.isForeground)
    }

    @Test
    fun shouldLogPauseRespectsTogglesAndInitiator() {
        // When log all is enabled, all pauses are logged
        assertTrue(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = true, logNonUserPausesEnabled = false, isUserInitiated = true))
        assertTrue(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = true, logNonUserPausesEnabled = false, isUserInitiated = false))
        assertTrue(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = true, logNonUserPausesEnabled = true, isUserInitiated = true))
        assertTrue(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = true, logNonUserPausesEnabled = true, isUserInitiated = false))

        // When only log non-user is enabled, only non-user pauses are logged
        assertTrue(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = false, logNonUserPausesEnabled = true, isUserInitiated = false))
        assertFalse(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = false, logNonUserPausesEnabled = true, isUserInitiated = true))

        // When both are disabled, nothing is logged
        assertFalse(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = false, logNonUserPausesEnabled = false, isUserInitiated = false))
        assertFalse(DiagnosticLogger.shouldLogPause(logAllPausesEnabled = false, logNonUserPausesEnabled = false, isUserInitiated = true))
    }
}
