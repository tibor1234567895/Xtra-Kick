package com.xtrakick.app.repository

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

    class HttpFailure(
        val statusCode: Int,
        cause: Throwable? = null,
        val body: String? = null,
        val synthetic: Boolean = false,
    ) : KickAuthRequestException("Kick auth request failed ($statusCode)", cause)

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
            val failure = (throwable as? HttpFailure)
                ?: (throwable.cause as? HttpFailure)
            return failure != null && (failure.statusCode == 401 || failure.statusCode == 400)
        }

        /**
         * True only when an auth failure means the session is genuinely unusable
         * and a forced logout is warranted:
         * - app-raised synthetic failures (no refresh token to refresh with, dead
         *   Google mobile token), and
         * - backend responses that explicitly rejected the OAuth grant
         *   (HTTP 4xx with body code "invalid_grant").
         *
         * Everything else — signature/clock failures ("unauthorized" body),
         * rate limits, upstream 5xx, transport errors — is retryable and must
         * keep the session: a phone with a wrong clock must not lose its login.
         */
        fun isSessionUnusable(throwable: Throwable): Boolean {
            val failure = (throwable as? HttpFailure)
                ?: (throwable.cause as? HttpFailure)
            if (failure != null) {
                if (failure.synthetic) return true
                if (failure.statusCode !in 400..499) return false
                val body = failure.body ?: return false
                return body.contains("\"invalid_grant\"", ignoreCase = true)
            }
            // MainViewModel's auth validation signals a dead session with
            // IllegalStateException("401"); preserve that convention.
            return throwable is IllegalStateException && throwable.message == "401"
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
