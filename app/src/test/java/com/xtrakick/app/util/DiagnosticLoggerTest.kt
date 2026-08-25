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
}
