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
import com.github.andreyasadchy.xtra.model.id.DeviceCodeResponse
import com.github.andreyasadchy.xtra.model.id.TokenResponse
import com.github.andreyasadchy.xtra.model.id.ValidationResponse
import com.github.andreyasadchy.xtra.util.HttpEngineUtils
import com.github.andreyasadchy.xtra.util.getByteArrayCronetCallback
import dagger.Lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
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
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.suspendCoroutine

@Singleton
class AuthRepository @Inject constructor(
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {

    suspend fun validate(networkLibrary: String?, token: String): ValidationResponse {
        throw UnsupportedOperationException("Legacy Twitch OAuth validation has been removed")
    }

    suspend fun revoke(networkLibrary: String?, body: String) {
        throw UnsupportedOperationException("Legacy Twitch OAuth revocation has been removed")
    }

    suspend fun getDeviceCode(networkLibrary: String?, body: String): DeviceCodeResponse {
        throw UnsupportedOperationException("Legacy Twitch device code flow has been removed")
    }

    suspend fun getToken(networkLibrary: String?, body: String): TokenResponse {
        throw UnsupportedOperationException("Legacy Twitch token flow has been removed")
    }

    suspend fun exchangeKickAuthorizationCode(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendExchangeRequest
    ): KickOAuthTokenResponse = withContext(Dispatchers.IO) {
        val url = buildBackendUrl(backendBaseUrl, "exchange")
        val body = json.encodeToString(request)
        json.decodeFromString(postJson(networkLibrary, url, body))
    }

    suspend fun refreshKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendRefreshRequest
    ): KickOAuthTokenResponse = withContext(Dispatchers.IO) {
        val url = buildBackendUrl(backendBaseUrl, "refresh")
        val body = json.encodeToString(request)
        json.decodeFromString(postJson(networkLibrary, url, body))
    }

    suspend fun revokeKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendRevokeRequest
    ) = withContext(Dispatchers.IO) {
        val url = buildBackendUrl(backendBaseUrl, "revoke")
        val body = json.encodeToString(request)
        postJson(networkLibrary, url, body)
    }

    suspend fun introspectKickToken(
        networkLibrary: String?,
        backendBaseUrl: String,
        request: KickBackendIntrospectRequest
    ): KickTokenIntrospectResponse = withContext(Dispatchers.IO) {
        val url = buildBackendUrl(backendBaseUrl, "introspect")
        val body = json.encodeToString(request)
        json.decodeFromString(postJson(networkLibrary, url, body))
    }

    suspend fun getKickCurrentUser(networkLibrary: String?, accessToken: String): KickUsersResponse = withContext(Dispatchers.IO) {
        json.decodeFromString(get(networkLibrary, "https://api.kick.com/public/v1/users", mapOf("Authorization" to "Bearer $accessToken")))
    }

    private suspend fun postForm(networkLibrary: String?, url: String, body: String): String = withContext(Dispatchers.IO) {
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("Content-Type", "application/x-www-form-urlencoded")
                        setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(body.toByteArray()), cronetExecutor)
                    }.build().start()
                }
                if (response.first.httpStatusCode in 200..299) {
                    String(response.second)
                } else {
                    throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                }
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        addHeader("Content-Type", "application/x-www-form-urlencoded")
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }.build().start()
                    val response = request.future.get()
                    if (response.urlResponseInfo.httpStatusCode in 200..299) {
                        response.responseBody as String
                    } else {
                        throw IOException("Kick auth request failed (${response.urlResponseInfo.httpStatusCode})")
                    }
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            addHeader("Content-Type", "application/x-www-form-urlencoded")
                            setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                        }.build().start()
                    }
                    if (response.first.httpStatusCode in 200..299) {
                        String(response.second)
                    } else {
                        throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                    }
                }
            }
            else -> {
                okHttpClient.newCall(
                    Request.Builder()
                        .url(url)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .post(body.toRequestBody())
                        .build()
                ).execute().use { response ->
                    if (response.isSuccessful) {
                        response.body.string()
                    } else {
                        throw IOException("Kick auth request failed (${response.code})")
                    }
                }
            }
        }
    }

    private suspend fun get(networkLibrary: String?, url: String, headers: Map<String, String>): String = withContext(Dispatchers.IO) {
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        headers.forEach { (k, v) -> addHeader(k, v) }
                    }.build().start()
                }
                if (response.first.httpStatusCode in 200..299) {
                    String(response.second)
                } else {
                    throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                }
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        headers.forEach { (k, v) -> addHeader(k, v) }
                    }.build().start()
                    val response = request.future.get()
                    if (response.urlResponseInfo.httpStatusCode in 200..299) {
                        response.responseBody as String
                    } else {
                        throw IOException("Kick auth request failed (${response.urlResponseInfo.httpStatusCode})")
                    }
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            headers.forEach { (k, v) -> addHeader(k, v) }
                        }.build().start()
                    }
                    if (response.first.httpStatusCode in 200..299) {
                        String(response.second)
                    } else {
                        throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                    }
                }
            }
            else -> {
                okHttpClient.newCall(
                    Request.Builder()
                        .url(url)
                        .apply { headers.forEach { (k, v) -> header(k, v) } }
                        .build()
                ).execute().use { response ->
                    if (response.isSuccessful) {
                        response.body.string()
                    } else {
                        throw IOException("Kick auth request failed (${response.code})")
                    }
                }
            }
        }
    }

    private fun buildBackendUrl(baseUrl: String, path: String): String {
        val sanitized = baseUrl.trim().trimEnd('/')
        val parsed = sanitized.toHttpUrlOrNull() ?: throw IOException("Kick OAuth backend URL is invalid")
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
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("Content-Type", "application/json")
                        setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(body.toByteArray()), cronetExecutor)
                    }.build().start()
                }
                if (response.first.httpStatusCode in 200..299) {
                    String(response.second)
                } else {
                    throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                }
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        addHeader("Content-Type", "application/json")
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }.build().start()
                    val response = request.future.get()
                    if (response.urlResponseInfo.httpStatusCode in 200..299) {
                        response.responseBody as String
                    } else {
                        throw IOException("Kick auth request failed (${response.urlResponseInfo.httpStatusCode})")
                    }
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            addHeader("Content-Type", "application/json")
                            setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                        }.build().start()
                    }
                    if (response.first.httpStatusCode in 200..299) {
                        String(response.second)
                    } else {
                        throw IOException("Kick auth request failed (${response.first.httpStatusCode})")
                    }
                }
            }
            else -> {
                okHttpClient.newCall(
                    Request.Builder()
                        .url(url)
                        .header("Content-Type", "application/json")
                        .post(body.toRequestBody("application/json".toMediaTypeOrNull()))
                        .build()
                ).execute().use { response ->
                    if (response.isSuccessful) {
                        response.body.string()
                    } else {
                        throw IOException("Kick auth request failed (${response.code})")
                    }
                }
            }
        }
    }
}
