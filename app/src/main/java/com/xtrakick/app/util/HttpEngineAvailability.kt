package com.xtrakick.app.util

import android.os.Build
import android.os.ext.SdkExtensions
import androidx.annotation.VisibleForTesting

object HttpEngineAvailability {

    @Volatile
    private var cachedAvailability: Boolean? = null

    val isAvailable: Boolean
        get() = cachedAvailability ?: synchronized(this) {
            cachedAvailability ?: computeAvailability().also { cachedAvailability = it }
        }

    @VisibleForTesting
    fun resetForTests() {
        cachedAvailability = null
    }

    internal fun computeAvailability(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return false
        }
        val hasExtension = try {
            SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7
        } catch (_: Throwable) {
            false
        }
        if (!hasExtension) {
            return false
        }
        return try {
            Class.forName(
                "android.net.http.HttpEngine",
                false,
                HttpEngineAvailability::class.java.classLoader
            )
            true
        } catch (_: Throwable) {
            false
        }
    }
}
