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
}
