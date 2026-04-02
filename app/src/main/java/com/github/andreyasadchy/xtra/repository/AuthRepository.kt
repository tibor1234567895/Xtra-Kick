package com.github.andreyasadchy.xtra.repository

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import com.github.andreyasadchy.xtra.model.kick.auth.KickOAuthTokenResponse
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendExchangeRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendIntrospectRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendRefreshRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickBackendRevokeRequest
import com.github.andreyasadchy.xtra.model.kick.auth.KickTokenIntrospectResponse
import com.github.andreyasadchy.xtra.model.kick.auth.KickUsersResponse
import com.github.andreyasadchy.xtra.util.HttpEngineUtils
import com.github.andreyasadchy.xtra.util.getByteArrayCronetCallback
import dagger.Lazy
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UploadDataProviders
import org.chromium.net.apihelpers.UrlRequestCallbacks
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {
    companion object {
        internal const val KICK_AUTH_REQUEST_TIMEOUT_MS = 15_000L
    }

    private val kickAuthOkHttpClient: OkHttpClient by lazy {
        okHttpClient.newBuilder()
            .connectTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .readTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .writeTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .callTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .build()
    }

    suspend fun exchangeKickAuthorizationCode(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendExchangeRequest
    ): KickOAuthTokenResponse = withContext(Dispatchers.IO) {
        executeRequest(isBackendRequest = true) {
            val url = buildBackendUrl(backendBaseUrl, "exchange")
            val body = json.encodeToString(request)
            json.decodeFromString(postJson(networkLibrary, url, body))
        }
    }

    suspend fun refreshKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendRefreshRequest
    ): KickOAuthTokenResponse = withContext(Dispatchers.IO) {
        executeRequest(isBackendRequest = true) {
            val url = buildBackendUrl(backendBaseUrl, "refresh")
            val body = json.encodeToString(request)
            json.decodeFromString(postJson(networkLibrary, url, body))
        }
    }

    suspend fun revokeKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendRevokeRequest
    ) = withContext(Dispatchers.IO) {
        executeRequest(isBackendRequest = true) {
            val url = buildBackendUrl(backendBaseUrl, "revoke")
            val body = json.encodeToString(request)
            postJson(networkLibrary, url, body)
        }
    }

    suspend fun introspectKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendIntrospectRequest
    ): KickTokenIntrospectResponse = withContext(Dispatchers.IO) {
        executeRequest(isBackendRequest = true) {
            val url = buildBackendUrl(backendBaseUrl, "introspect")
            val body = json.encodeToString(request)
            json.decodeFromString(postJson(networkLibrary, url, body))
        }
    }

    suspend fun getKickCurrentUser(networkLibrary: String?, accessToken: String): KickUsersResponse = withContext(Dispatchers.IO) {
        executeRequest(isBackendRequest = false) {
            json.decodeFromString(get(networkLibrary, "https://api.kick.com/public/v1/users", mapOf("Authorization" to "Bearer $accessToken")))
        }
    }

    private suspend fun get(networkLibrary: String?, url: String, headers: Map<String, String>): String = withContext(Dispatchers.IO) {
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = awaitTimedHttpEngineResponse(url) {
                    headers.forEach { (k, v) -> addHeader(k, v) }
                }
                response.asHttpEngineStringBody()
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        headers.forEach { (k, v) -> addHeader(k, v) }
                    }.build().start()
                    val response = request.future.get(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    val statusCode = response.urlResponseInfo.httpStatusCode
                    if (statusCode in 200..299) {
                        response.responseBody as String
                    } else {
                        throw KickAuthRequestException.HttpFailure(statusCode)
                    }
                } else {
                    val response = awaitTimedCronetResponse(url) {
                        headers.forEach { (k, v) -> addHeader(k, v) }
                    }
                    response.asCronetStringBody()
                }
            }
            else -> {
                executeOkHttp(
                    Request.Builder()
                        .url(url)
                        .apply { headers.forEach { (k, v) -> header(k, v) } }
                        .build()
                )
            }
        }
    }

    private fun buildBackendUrl(baseUrl: String, path: String): String {
        val sanitized = baseUrl.trim().trimEnd('/')
        val parsed = sanitized.toHttpUrlOrNull() ?: throw IllegalArgumentException("Kick OAuth backend URL is invalid")
        return parsed.newBuilder()
            .addPathSegment("v1")
            .addPathSegment("kick")
            .addPathSegment("oauth")
            .addPathSegment(path)
            .build()
            .toString()
    }

    private suspend fun postJson(networkLibrary: String?, url: String, body: String): String = withContext(Dispatchers.IO) {
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = awaitTimedHttpEngineResponse(url) {
                    addHeader("Content-Type", "application/json")
                    setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(body.toByteArray()), cronetExecutor)
                }
                response.asHttpEngineStringBody()
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        addHeader("Content-Type", "application/json")
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }.build().start()
                    val response = request.future.get(KICK_AUTH_REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    val statusCode = response.urlResponseInfo.httpStatusCode
                    if (statusCode in 200..299) {
                        response.responseBody as String
                    } else {
                        throw KickAuthRequestException.HttpFailure(statusCode)
                    }
                } else {
                    val response = awaitTimedCronetResponse(url) {
                        addHeader("Content-Type", "application/json")
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }
                    response.asCronetStringBody()
                }
            }
            else -> {
                executeOkHttp(
                    Request.Builder()
                        .url(url)
                        .header("Content-Type", "application/json")
                        .post(body.toRequestBody("application/json".toMediaTypeOrNull()))
                        .build()
                )
            }
        }
    }

    private suspend fun <T> executeRequest(isBackendRequest: Boolean, block: suspend () -> T): T {
        return try {
            block()
        } catch (e: Throwable) {
            if (e is CancellationException && e !is TimeoutCancellationException) {
                throw e
            }
            throw KickAuthRequestException.classify(e, isBackendRequest)
        }
    }

    private suspend fun awaitTimedHttpEngineResponse(
        url: String,
        configure: android.net.http.UrlRequest.Builder.() -> Unit,
    ): Pair<android.net.http.UrlResponseInfo, ByteArray> = withTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS) {
        suspendCancellableCoroutine { continuation ->
            val request = httpEngine!!.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation))
                .apply(configure)
                .build()
            continuation.invokeOnCancellation { request.cancel() }
            request.start()
        }
    }

    private suspend fun awaitTimedCronetResponse(
        url: String,
        configure: org.chromium.net.UrlRequest.Builder.() -> Unit,
    ): Pair<org.chromium.net.UrlResponseInfo, ByteArray> = withTimeout(KICK_AUTH_REQUEST_TIMEOUT_MS) {
        suspendCancellableCoroutine { continuation ->
            val request = cronetEngine!!.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor)
                .apply(configure)
                .build()
            continuation.invokeOnCancellation { request.cancel() }
            request.start()
        }
    }

    private fun executeOkHttp(request: Request): String {
        return kickAuthOkHttpClient.newCall(request).awaitStringBody()
    }

    private fun Call.awaitStringBody(): String {
        execute().use { response ->
            if (response.isSuccessful) {
                return response.body.string()
            }
            throw KickAuthRequestException.HttpFailure(response.code)
        }
    }

    private fun Pair<android.net.http.UrlResponseInfo, ByteArray>.asHttpEngineStringBody(): String {
        val statusCode = first.httpStatusCode
        if (statusCode in 200..299) {
            return String(second)
        }
        throw KickAuthRequestException.HttpFailure(statusCode)
    }

    private fun Pair<org.chromium.net.UrlResponseInfo, ByteArray>.asCronetStringBody(): String {
        val statusCode = first.httpStatusCode
        if (statusCode in 200..299) {
            return String(second)
        }
        throw KickAuthRequestException.HttpFailure(statusCode)
    }
}
