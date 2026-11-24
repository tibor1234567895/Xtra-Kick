package com.xtrakick.app.repository

import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import com.xtrakick.app.util.NetworkUtils
import com.xtrakick.app.model.kick.api.game.GamesResponse
import com.xtrakick.app.model.kick.api.livestream.LivestreamsResponse
import com.xtrakick.app.model.kick.api.livestream.UsersLivestreamsResponse
import com.xtrakick.app.model.kick.api.livestream.toLegacyLivestream
import com.xtrakick.app.model.kick.api.user.UsersResponse
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Headers.Companion.toHeaders
import okhttp3.OkHttpClient
import okhttp3.Request
import org.chromium.net.CronetEngine
import java.io.IOException
import java.net.URLEncoder
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout
import com.xtrakick.app.util.NetworkUtils.useCancellable

@Singleton
class KickPublicApiRepository @Inject constructor(
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
) {

    /** Non-401 HTTP failure from the Kick Public API, carrying the status code. */
    class KickPublicApiHttpException(val statusCode: Int, body: String?) :
        IOException("Kick Public API request failed ($statusCode): $body")

    private suspend fun executePublicApiRaw(
        networkLibrary: String?,
        path: String,
        headers: Map<String, String>,
        query: String = "",
    ): Pair<Int, String> = withContext(Dispatchers.IO) {
        val url = "https://api.kick.com$path$query"
        val http = NetworkUtils.resolveHttpEngine(networkLibrary, httpEngine)
        val cronet = NetworkUtils.resolveCronetEngine(networkLibrary, cronetEngine)
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
                http is HttpEngine -> {
                val response = withTimeout(20_000L) {
                    suspendCancellableCoroutine { continuation ->
                        val request = http.newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                            setHttpMethod("GET")
                            headers.forEach { addHeader(it.key, it.value) }
                        }.build()
                        continuation.invokeOnCancellation { request.cancel() }
                        request.start()
                    }
                }
                Pair(response.first.httpStatusCode, String(response.second))
            }
            cronet != null -> {
                val response = withTimeout(20_000L) {
                    suspendCancellableCoroutine { continuation ->
                        val request = cronet.newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            setHttpMethod("GET")
                            headers.forEach { addHeader(it.key, it.value) }
                        }.build()
                        continuation.invokeOnCancellation { request.cancel() }
                        request.start()
                    }
                }
                Pair(response.first.httpStatusCode, String(response.second))
            }
            else -> {
                val request = Request.Builder().url(url).headers(headers.toHeaders()).build()
                okHttpClient.newCall(request).useCancellable { response ->
                    Pair(response.code, response.body.string())
                }
            }
        }
    }

    private suspend inline fun <reified T> executePublicApi(
        networkLibrary: String?,
        path: String,
        headers: Map<String, String>,
        query: String = "",
    ): T {
        val (statusCode, rawBody) = executePublicApiRaw(networkLibrary, path, headers, query)
        if (statusCode !in 200..299) {
            if (statusCode == 401) {
                throw KickAuthRequestException.HttpFailure(statusCode)
            }
            throw KickPublicApiHttpException(statusCode, rawBody)
        }
        return json.decodeFromString<T>(rawBody)
    }

    private fun encodeParam(v: String): String = URLEncoder.encode(v, Charsets.UTF_8.name())

    suspend fun getGames(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, names: List<String>? = null): GamesResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
            names?.forEach { add("name=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/games", headers, query = query)
    }

    // /public/v1/livestreams is deprecated but, unlike its replacement, still returns true viewer
    // counts for channels that hide them (the replacement reports 0 and sinks them in Following >
    // Live). It takes at most 50 broadcaster_user_id params (400 above) and truncates to 25 items
    // unless limit is passed, so callers must batch at 50 with limit=size. Flip to the replacement
    // permanently only on a 4xx response — that means the endpoint itself is gone; transient
    // failures (timeouts, 429, 5xx) must keep retrying it.
    @Volatile
    private var legacyLivestreamsEndpointDisabled = false

    suspend fun getLivestreams(networkLibrary: String?, headers: Map<String, String>, broadcasterUserIds: List<String>? = null): LivestreamsResponse {
        val ids = broadcasterUserIds.orEmpty()
            .map { it.trim() }
            .filter { it.isNotEmpty() }
        if (!legacyLivestreamsEndpointDisabled && ids.isNotEmpty()) {
            try {
                val query = "?" + ids.joinToString("&") { "broadcaster_user_id=${encodeParam(it)}" } +
                    "&limit=${ids.size}&sort=viewer_count"
                return executePublicApi(networkLibrary, "/public/v1/livestreams", headers, query = query)
            } catch (error: CancellationException) {
                throw error
            } catch (error: KickAuthRequestException) {
                throw error
            } catch (error: Exception) {
                // A definitive client-side rejection (4xx, except 429 Too Many Requests,
                // which is transient rate limiting) means the legacy endpoint is gone and
                // can never work again — flip permanently. Anything else — 429, 5xx,
                // timeouts — must NOT: one transient blip would otherwise downgrade all
                // viewer counts for the rest of the process lifetime. Either way the code
                // below falls through to the replacement for this call.
                if (error is KickPublicApiHttpException && error.statusCode in 400..499 && error.statusCode != 429) {
                    legacyLivestreamsEndpointDisabled = true
                }
            }
        }
        val query = ids
            .joinToString("&") { "user_id=${encodeParam(it)}" }
            .takeIf { it.isNotEmpty() }
            ?.let { "?$it" }
            .orEmpty()
        val payload: UsersLivestreamsResponse = executePublicApi(networkLibrary, "/public/v1/users/livestreams", headers, query = query)
        return LivestreamsResponse(
            data = payload.data.map { it.toLegacyLivestream() },
            message = payload.message,
        )
    }

    /**
     * Retrieves user information from Kick's /public/v1/users endpoint.
     * Note: Kick's public API accepts only numeric user IDs ('id' query param).
     * If no IDs are provided, Kick returns the currently authorized user.
     */
    suspend fun getUsers(networkLibrary: String?, headers: Map<String, String>, ids: List<String>? = null, logins: List<String>? = null): UsersResponse {
        val queryParams = mutableListOf<String>().apply {
            ids?.forEach { add("id=${encodeParam(it)}") }
        }
        val query = queryParams.takeIf { it.isNotEmpty() }?.joinToString("&", "?") ?: ""
        return executePublicApi(networkLibrary, "/public/v1/users", headers, query = query)
    }

    /**
     * Resolves user ids to login names and profile pictures via the official public users
     * endpoint. Unlike [getUsers], this parses the endpoint's actual response shape
     * (user_id/username) — the web-style [UsersResponse] fields (id/login) are absent from
     * api.kick.com replies. The endpoint rejects long id lists with a 400, so ids are
     * fetched in batches; a failed batch is skipped rather than losing the rest.
     */
    suspend fun lookupUsersByIds(networkLibrary: String?, headers: Map<String, String>, ids: List<String>): Map<String, PublicUserSummary> {
        if (ids.isEmpty()) return emptyMap()
        val users = ids.chunked(USER_LOOKUP_BATCH_SIZE).flatMap { batch ->
            val query = batch.joinToString("&", "?") { "id=${encodeParam(it)}" }
            runCatching {
                executePublicApi<PublicUserLookupResponse>(networkLibrary, "/public/v1/users", headers, query = query).data
            }.getOrElse { error ->
                if (error is CancellationException) throw error
                emptyList()
            }
        }
        return users.mapNotNull { user ->
            val id = user.userId?.toString() ?: user.id?.toString() ?: return@mapNotNull null
            val login = user.username ?: user.login ?: user.name ?: user.channelSlug
            id to PublicUserSummary(
                login = login?.trim()?.takeIf { it.isNotBlank() },
                profilePictureUrl = user.profilePicture?.trim()?.takeIf { it.isNotBlank() },
            )
        }.toMap()
    }

    private companion object {
        /** Kick's users endpoint rejects long id lists with a 400, so look up in batches. */
        private const val USER_LOOKUP_BATCH_SIZE = 50
    }
}

/** Response shape actually returned by GET /public/v1/users on api.kick.com. */
@Serializable
private data class PublicUserLookupResponse(
    val data: List<PublicUserLookupUser> = emptyList(),
)

@Serializable
private data class PublicUserLookupUser(
    @SerialName("user_id") val userId: Long? = null,
    val id: Long? = null,
    val username: String? = null,
    val login: String? = null,
    val name: String? = null,
    @SerialName("channel_slug") val channelSlug: String? = null,
    @SerialName("profile_picture") val profilePicture: String? = null,
)

data class PublicUserSummary(
    val login: String?,
    val profilePictureUrl: String?,
)
