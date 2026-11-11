package com.xtrakick.app.util

import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.IOException

class CrashReportsTest {
    @get:Rule val temporaryFolder = TemporaryFolder()

    @Test
    fun technicalContextUsesOnlyAllowlistedValues() {
        val report = CrashReports.report(RuntimeException(), "1.0", 1, 35,
            abi = "armeabi-v7a", liveEnginePreference = "exo")
        assertEquals("armeabi-v7a", report.getValue("abi").jsonPrimitive.content)
        assertEquals("exo", report.getValue("liveEnginePreference").jsonPrimitive.content)
        val unsafe = CrashReports.report(RuntimeException(), "1.0", 1, 35,
            abi = "device-user-identifier", liveEnginePreference = "https://private.example/token")
        assertEquals("unknown", unsafe.getValue("abi").jsonPrimitive.content)
        assertEquals("unknown", unsafe.getValue("liveEnginePreference").jsonPrimitive.content)
        assertFalse(unsafe.toString().contains("private.example"))
    }

    @Test
    fun reportsExcludeMessagesAndLimitStackAndCauseDepth() {
        var error: Throwable = IllegalArgumentException("Bearer secret-token https://private.example/user")
        repeat(12) {
            error = RuntimeException("chat message username", error).apply {
                stackTrace = Array(100) { StackTraceElement("com.xtrakick.app.Example", "play", "Example.kt", 42) }
            }
        }
        error.addSuppressed(IllegalStateException("access_token=secret"))
        val report = CrashReports.report(error, "1.0", 123, 35)
        val body = report.toString()
        assertFalse(body.contains("secret"))
        assertFalse(body.contains("username"))
        assertFalse(body.contains("private.example"))
        val exceptions = report.getValue("exceptions").jsonArray
        assertEquals(8, exceptions.size)
        assertEquals(32, exceptions.sumOf { it.jsonObject.getValue("frames").jsonArray.size })
        assertTrue(exceptions.all { it.jsonObject.getValue("frames").jsonArray.isNotEmpty() })
        assertTrue(body.toByteArray().size < 24 * 1024)
    }

    @Test
    fun retriesPreserveBytesAndRemoveOnlyAcknowledgedReports() {
        val dir = temporaryFolder.newFolder()
        CrashReports.enqueue(dir, CrashReports.report(IllegalStateException("private"), "1.0", 1, 35))
        val file = CrashReports.pendingFiles(dir).single()
        val original = file.readText()
        CrashReports.sendPending(dir, { true }) { assertEquals(original, it.toString(Charsets.UTF_8)); 503 }
        assertEquals(original, file.readText())
        try {
            CrashReports.sendPending(dir, { true }) { throw IOException("offline") }
        } catch (_: IOException) { }
        assertTrue(file.exists())
        CrashReports.sendPending(dir, { true }) { assertEquals(original, it.toString(Charsets.UTF_8)); 204 }
        assertTrue(CrashReports.pendingFiles(dir).isEmpty())
    }

    @Test
    fun optOutClearsReportsWithoutCallingTransport() {
        val dir = temporaryFolder.newFolder()
        CrashReports.enqueue(dir, CrashReports.report(NullPointerException(), "1.0", 1, 35))
        CrashReports.sendPending(dir, { false }) { error("Must not upload after opt-out") }
        assertTrue(dir.listFiles().orEmpty().isEmpty())
    }

    @Test
    fun queueIsBoundedAndExpiredOrCorruptFilesAreDeleted() {
        val dir = temporaryFolder.newFolder()
        val now = System.currentTimeMillis()
        repeat(8) {
            CrashReports.enqueue(dir, CrashReports.report(RuntimeException(), "1.0", 1, 35, now - it))
        }
        assertEquals(5, CrashReports.pendingFiles(dir).size)
        dir.resolve("corrupt.json").writeText("invalid")
        dir.resolve("incomplete.tmp").writeText("partial")
        CrashReports.pendingFiles(dir)
        assertEquals(5, dir.listFiles().orEmpty().size)
        assertTrue(CrashReports.pendingFiles(dir, now + CrashReports.RETENTION_MS + 1).isEmpty())
        assertTrue(dir.listFiles().orEmpty().isEmpty())
    }

    @Test
    fun cyclicCausesAndUnsafeFrameMetadataStayBounded() {
        val first = RuntimeException("first")
        val second = RuntimeException("second", first)
        first.initCause(second)
        first.stackTrace = arrayOf(StackTraceElement("<script>alert(1)</script>", "Bearer token", "/private/token", 1))
        val report = CrashReports.report(first, "1.0", 1, 35)
        assertEquals(2, report.getValue("exceptions").jsonArray.size)
        val frame = report.getValue("exceptions").jsonArray.first().jsonObject.getValue("frames").jsonArray.first().jsonObject
        assertEquals("unknown", frame.getValue("class").jsonPrimitive.content)
        assertEquals("Unknown", frame.getValue("file").jsonPrimitive.content)
    }
}
