package com.xtrakick.app.ui.player

import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.HttpDataSource
import androidx.media3.exoplayer.source.BehindLiveWindowException

object Media3ErrorUtils {

    @JvmStatic
    fun httpResponseCode(error: Throwable?): Int? {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is HttpDataSource.InvalidResponseCodeException) {
                return cause.responseCode
            }
            cause = cause.cause
        }
        return null
    }

    @JvmStatic
    @OptIn(UnstableApi::class)
    fun isBehindLiveWindowError(error: Throwable?): Boolean {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is BehindLiveWindowException) {
                return true
            }
            cause = cause.cause
        }
        return false
    }

    @JvmStatic
    fun isObsoleteSurfaceError(error: Throwable?): Boolean {
        var cause: Throwable? = error
        while (cause != null) {
            val message = cause.message.orEmpty()
            if (message.contains("obsolete", ignoreCase = true) ||
                message.contains("non-initialized", ignoreCase = true) ||
                (message.contains("releaseOutputBuffer", ignoreCase = true) && message.contains("Released state", ignoreCase = true))
            ) {
                return true
            }
            cause = cause.cause
        }
        return false
    }
}
