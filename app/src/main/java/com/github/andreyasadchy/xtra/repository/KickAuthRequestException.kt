package com.github.andreyasadchy.xtra.repository

import kotlinx.coroutines.TimeoutCancellationException
import java.io.IOException
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeoutException

sealed class KickAuthRequestException(message: String, cause: Throwable? = null) : IOException(message, cause) {

    class BackendUnavailable(cause: Throwable? = null) :
        KickAuthRequestException("Kick OAuth backend is offline or unreachable", cause)

    class InvalidBackendUrl(cause: Throwable? = null) :
        KickAuthRequestException("Kick OAuth backend URL is invalid", cause)

    class HttpFailure(val statusCode: Int, cause: Throwable? = null) :
        KickAuthRequestException("Kick auth request failed ($statusCode)", cause)

    companion object {
        fun classify(throwable: Throwable, isBackendRequest: Boolean): IOException {
            if (throwable is KickAuthRequestException) {
                return throwable
            }

            val rootCause = rootCause(throwable)
            if (isBackendRequest && rootCause is IllegalArgumentException) {
                return InvalidBackendUrl(throwable)
            }
            if (isBackendRequest && isBackendUnavailableCause(rootCause)) {
                return BackendUnavailable(throwable)
            }

            return when (throwable) {
                is IOException -> throwable
                else -> IOException(throwable.message ?: "Kick auth request failed", throwable)
            }
        }

        fun isBackendUnavailable(throwable: Throwable): Boolean {
            return throwable is BackendUnavailable ||
                throwable.cause?.let(::isBackendUnavailable) == true
        }

        fun isUnauthorized(throwable: Throwable): Boolean {
            return throwable is HttpFailure && throwable.statusCode == 401
        }

        private fun isBackendUnavailableCause(throwable: Throwable): Boolean {
            return throwable is UnknownHostException ||
                throwable is ConnectException ||
                throwable is NoRouteToHostException ||
                throwable is SocketTimeoutException ||
                throwable is TimeoutException ||
                throwable is TimeoutCancellationException ||
                (throwable is InterruptedIOException && throwable.message?.contains("timeout", ignoreCase = true) == true)
        }

        private tailrec fun rootCause(throwable: Throwable): Throwable {
            val cause = when (throwable) {
                is ExecutionException -> throwable.cause
                else -> throwable.cause
            }
            return if (cause == null || cause === throwable) throwable else rootCause(cause)
        }
    }
}
