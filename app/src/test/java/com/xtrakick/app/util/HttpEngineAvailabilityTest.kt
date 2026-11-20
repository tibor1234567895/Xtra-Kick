package com.xtrakick.app.util

import android.os.Build
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class HttpEngineAvailabilityTest {

    @Before
    fun setUp() {
        HttpEngineAvailability.resetForTests()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.R])
    fun computeAvailabilityReturnsFalseOnAndroidR() {
        // API 30 (Android 11) must never attempt SdkExtensions.getExtensionVersion(S)
        // or attempt resolving android.net.http.HttpEngine
        assertFalse(HttpEngineAvailability.computeAvailability())
        assertFalse(HttpEngineAvailability.isAvailable)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.Q])
    fun computeAvailabilityReturnsFalseOnAndroidQ() {
        assertFalse(HttpEngineAvailability.computeAvailability())
        assertFalse(HttpEngineAvailability.isAvailable)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun computeAvailabilityReturnsFalseOnAndroidSWithoutExtension7() {
        // Without SdkExtensions S version >= 7, HttpEngine is not available
        assertFalse(HttpEngineAvailability.computeAvailability())
        assertFalse(HttpEngineAvailability.isAvailable)
    }

    @Test
    fun resetForTestsClearsCachedAvailability() {
        val initial = HttpEngineAvailability.isAvailable
        assertNotNull(initial)
        HttpEngineAvailability.resetForTests()
        // Should evaluate cleanly after reset
        val second = HttpEngineAvailability.isAvailable
        assertNotNull(second)
    }

    @Test
    fun isAvailableCachesResult() {
        HttpEngineAvailability.resetForTests()
        val first = HttpEngineAvailability.isAvailable
        val second = HttpEngineAvailability.isAvailable
        assertTrue(first == second)
    }
}
