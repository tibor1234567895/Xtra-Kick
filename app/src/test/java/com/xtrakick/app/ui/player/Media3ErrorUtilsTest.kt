package com.xtrakick.app.ui.player

import android.app.Application
import android.net.Uri
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.HttpDataSource
import androidx.media3.exoplayer.source.BehindLiveWindowException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class Media3ErrorUtilsTest {

    @Test
    fun testHttpResponseCode_withDirectInvalidResponseCodeException() {
        val ex = HttpDataSource.InvalidResponseCodeException(
            403,
            "Forbidden",
            null,
            emptyMap(),
            DataSpec(Uri.parse("https://example.com")),
            byteArrayOf(),
        )
        assertEquals(403, Media3ErrorUtils.httpResponseCode(ex))
    }

    @Test
    fun testHttpResponseCode_withNestedException() {
        val ex = HttpDataSource.InvalidResponseCodeException(
            404,
            "Not Found",
            null,
            emptyMap(),
            DataSpec(Uri.parse("https://example.com")),
            byteArrayOf(),
        )
        val wrapper = RuntimeException("Wrapper error", IOException("IO root", ex))
        assertEquals(404, Media3ErrorUtils.httpResponseCode(wrapper))
    }

    @Test
    fun testHttpResponseCode_withNoHttpExceptionReturnsNull() {
        assertNull(Media3ErrorUtils.httpResponseCode(null))
        assertNull(Media3ErrorUtils.httpResponseCode(IllegalStateException("Not http")))
    }

    @Test
    fun testIsBehindLiveWindowError_withDirectAndNestedException() {
        val behind = BehindLiveWindowException()
        assertTrue(Media3ErrorUtils.isBehindLiveWindowError(behind))

        val wrapped = RuntimeException("Playback failed", behind)
        assertTrue(Media3ErrorUtils.isBehindLiveWindowError(wrapped))

        assertFalse(Media3ErrorUtils.isBehindLiveWindowError(null))
        assertFalse(Media3ErrorUtils.isBehindLiveWindowError(IllegalArgumentException("Other error")))
    }

    @Test
    fun testIsObsoleteSurfaceError_detectsObsoleteAndReleasedSurfaceExceptions() {
        val obsoleteException = RuntimeException("rendering to non-initialized(obsolete) surface")
        val wrappedObsolete = RuntimeException("Decoder failed: c2.qti.avc.decoder", obsoleteException)
        assertTrue(Media3ErrorUtils.isObsoleteSurfaceError(obsoleteException))
        assertTrue(Media3ErrorUtils.isObsoleteSurfaceError(wrappedObsolete))

        val releasedException = IllegalStateException("releaseOutputBuffer() is valid only at Executing states; currently at Released state")
        val wrappedReleased = RuntimeException("Decoder failed", releasedException)
        assertTrue(Media3ErrorUtils.isObsoleteSurfaceError(releasedException))
        assertTrue(Media3ErrorUtils.isObsoleteSurfaceError(wrappedReleased))

        assertFalse(Media3ErrorUtils.isObsoleteSurfaceError(null))
        assertFalse(Media3ErrorUtils.isObsoleteSurfaceError(RuntimeException("Different decoding error")))
    }
}
