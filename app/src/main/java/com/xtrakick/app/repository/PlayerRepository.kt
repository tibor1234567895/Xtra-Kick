package com.xtrakick.app.repository

import android.content.Context
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import android.util.Base64
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.RecentEmotesDao
import com.xtrakick.app.db.VideoPositionsDao
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.model.chat.CheerEmote
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.model.misc.StvChannelResponse
import com.xtrakick.app.model.misc.StvGlobalResponse
import com.xtrakick.app.model.misc.StvResponse
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okio.source
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.RedirectHandlers
import org.chromium.net.apihelpers.UploadDataProviders
import org.chromium.net.apihelpers.UrlRequestCallbacks
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.concurrent.ExecutorService
import java.util.zip.DeflaterOutputStream
import java.util.zip.InflaterOutputStream
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.suspendCoroutine

private val SETTINGS_URL_REGEX = Regex("https://[\\w.]+/config/settings\\..+?\\.js")
private val SPADE_URL_REGEX = Regex("\"(?:beacon_url|spade_url)\":\"(.*?)\"")
private val EMOTE_SMILIE_PAREN_REGEX = Regex("\\((.)\\|.\\)")
private val EMOTE_SMILIE_BRACKET_REGEX = Regex("\\[(.).*?]")

@Singleton
class PlayerRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
    private val kickRepository: KickRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val recentEmotes: RecentEmotesDao,
    private val videoPositions: VideoPositionsDao,
) {

    val resolutionChangeFlow = kotlinx.coroutines.flow.MutableSharedFlow<String>(extraBufferCapacity = 1)
    val qualityChangeFlow = kotlinx.coroutines.flow.MutableSharedFlow<String>(extraBufferCapacity = 1)

    suspend fun loadTextFromUrl(networkLibrary: String?, url: String): String? = withContext(Dispatchers.IO) {
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                }
                if (response.first.httpStatusCode in 200..299) {
                    String(response.second)
                } else null
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).build().start()
                    val response = request.future.get()
                    if (response.urlResponseInfo.httpStatusCode in 200..299) {
                        response.responseBody as String
                    } else null
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                    }
                    if (response.first.httpStatusCode in 200..299) {
                        String(response.second)
                    } else null
                }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().url(url).build()).execute().use { response ->
                    if (response.isSuccessful) {
                        response.body.string()
                    } else null
                }
            }
        }
    }

    suspend fun loadClipUrls(networkLibrary: String?, kickWebHeaders: Map<String, String>, clipId: String?, enableIntegrity: Boolean): Map<Pair<String, String?>, String>? = withContext(Dispatchers.IO) {
        val id = clipId?.takeIf { it.isNotBlank() } ?: return@withContext null
        // Kick serves clips as a source MP4 plus an IVS HLS multivariant playlist
        // obtained from the web player playback endpoint. Every HLS variant becomes
        // a selectable quality; the MP4 stays as "source".
        kickRepository.getClipPlayback(id)?.let { playback ->
            val map = linkedMapOf<Pair<String, String?>, String>()
            playback.sourceUrl?.let { map[Pair("source", null)] = it }
            playback.qualities.forEach { quality ->
                map.putIfAbsent(Pair(quality.name, quality.codec), quality.url)
            }
            map.takeIf { it.isNotEmpty() }
        }
    }

    suspend fun sendMinuteWatched(networkLibrary: String?, userId: String?, streamId: String?, channelId: String?, channelLogin: String?) = withContext(Dispatchers.IO) {
        val pageResponse = channelLogin?.let {
            when {
                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                    val response = suspendCoroutine { continuation ->
                        httpEngine.get().newUrlRequestBuilder("https://kick.com/${channelLogin}", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                    }
                    String(response.second)
                }
                networkLibrary == "Cronet" && cronetEngine != null -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                        cronetEngine.get().newUrlRequestBuilder("https://kick.com/${channelLogin}", request.callback, cronetExecutor).build().start()
                        request.future.get().responseBody as String
                    } else {
                        val response = suspendCoroutine { continuation ->
                            cronetEngine.get().newUrlRequestBuilder("https://kick.com/${channelLogin}", getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                        }
                        String(response.second)
                    }
                }
                else -> {
                    okHttpClient.newCall(Request.Builder().url("https://kick.com/${channelLogin}").build()).execute().use { response ->
                        response.body.string()
                    }
                }
            }
        }
        if (!pageResponse.isNullOrBlank()) {
            val settingsRegex = Regex("https://[\\w.]+/config/settings\\..+?\\.js")
            val settingsUrl = settingsRegex.find(pageResponse)?.value
            val settingsResponse = settingsUrl?.let {
                when {
                    networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                        val response = suspendCoroutine { continuation ->
                            httpEngine.get().newUrlRequestBuilder(settingsUrl, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).build().start()
                        }
                        String(response.second)
                    }
                    networkLibrary == "Cronet" && cronetEngine != null -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                            cronetEngine.get().newUrlRequestBuilder(settingsUrl, request.callback, cronetExecutor).build().start()
                            request.future.get().responseBody as String
                        } else {
                            val response = suspendCoroutine { continuation ->
                                cronetEngine.get().newUrlRequestBuilder(settingsUrl, getByteArrayCronetCallback(continuation), cronetExecutor).build().start()
                            }
                            String(response.second)
                        }
                    }
                    else -> {
                        okHttpClient.newCall(Request.Builder().url(settingsUrl).build()).execute().use { response ->
                            response.body.string()
                        }
                    }
                }
            }
            if (!settingsResponse.isNullOrBlank()) {
                val spadeRegex = SPADE_URL_REGEX
                val spadeUrl = spadeRegex.find(settingsResponse)?.groups?.get(1)?.value
                if (!spadeUrl.isNullOrBlank()) {
                    val body = buildJsonObject {
                        put("event", "minute-watched")
                        putJsonObject("properties") {
                            put("channel_id", channelId)
                            put("broadcast_id", streamId)
                            put("player", "site")
                            put("user_id", userId?.toLong())
                        }
                    }.toString()
                    val spadeRequest = "data=" + Base64.encodeToString(body.toByteArray(), Base64.NO_WRAP)
                    when {
                        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                            suspendCoroutine { continuation ->
                                httpEngine.get().newUrlRequestBuilder(spadeUrl, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                                    addHeader("Content-Type", "application/x-www-form-urlencoded")
                                    setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(spadeRequest.toByteArray()), cronetExecutor)
                                }.build().start()
                            }
                        }
                        networkLibrary == "Cronet" && cronetEngine != null -> {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                                cronetEngine.get().newUrlRequestBuilder(spadeUrl, request.callback, cronetExecutor).apply {
                                    addHeader("Content-Type", "application/x-www-form-urlencoded")
                                    setUploadDataProvider(UploadDataProviders.create(spadeRequest.toByteArray()), cronetExecutor)
                                }.build().start()
                                request.future.get().responseBody as String
                            } else {
                                suspendCoroutine<Pair<org.chromium.net.UrlResponseInfo, ByteArray>> { continuation ->
                                    cronetEngine.get().newUrlRequestBuilder(spadeUrl, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                                        addHeader("Content-Type", "application/x-www-form-urlencoded")
                                        setUploadDataProvider(UploadDataProviders.create(spadeRequest.toByteArray()), cronetExecutor)
                                    }.build().start()
                                }
                            }
                        }
                        else -> {
                            okHttpClient.newCall(Request.Builder().apply {
                                url(spadeUrl)
                                header("Content-Type", "application/x-www-form-urlencoded")
                                post(spadeRequest.toRequestBody())
                            }.build()).execute().close()
                        }
                    }
                }
            }
        }
    }

    private fun readCachedEmoteResponse(name: String): String? = try {
        val bytes = FileInputStream(File(File(context.cacheDir, "emote_responses"), name)).use { it.readBytes() }
        val decompressed = ByteArrayOutputStream()
        InflaterOutputStream(decompressed).use { it.write(bytes) }
        decompressed.toByteArray().decodeToString()
    } catch (_: Exception) {
        null
    }

    private fun writeCachedEmoteResponse(name: String, response: String) {
        try {
            val directory = File(context.cacheDir, "emote_responses")
            directory.mkdirs()
            val compressed = ByteArrayOutputStream()
            DeflaterOutputStream(compressed).use { it.write(response.encodeToByteArray()) }
            File(directory, name).writeBytes(compressed.toByteArray())
        } catch (_: Exception) {
        }
    }

    suspend fun loadGlobalStvEmotes(networkLibrary: String?, useWebp: Boolean): List<Emote> = withContext(Dispatchers.IO) {
        // try the network first; fall back to the last cached response when it is
        // slow or unavailable so emotes still load offline / during 7tv outages
        val pair = try {
            withTimeout(20_000) {
                loadGlobalStvEmotesResponse(networkLibrary) to true
            }
        } catch (e: Exception) {
            try {
                readCachedEmoteResponse("global.stv")?.let { cached ->
                    json.decodeFromString<StvGlobalResponse>(cached) to false
                }
            } catch (_: Exception) {
                null
            }
        }
        val (response, online) = pair ?: (null to false)
        if (response != null) {
            if (online && response.emotes.isNotEmpty()) {
                writeCachedEmoteResponse("global.stv", json.encodeToString(StvGlobalResponse.serializer(), response))
            }
            parseStvEmotes(response.emotes, useWebp, Emote.GLOBAL_STV)
        } else {
            emptyList()
        }
    }

    private suspend fun loadGlobalStvEmotesResponse(networkLibrary: String?): StvGlobalResponse = when {
        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
            val response = suspendCoroutine { continuation ->
                httpEngine.get().newUrlRequestBuilder("https://7tv.io/v3/emote-sets/global", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                    addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build().start()
            }
            json.decodeFromString<StvGlobalResponse>(String(response.second))
        }
        networkLibrary == "Cronet" && cronetEngine != null -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/emote-sets/global", request.callback, cronetExecutor).apply {
                    addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build().start()
                val response = request.future.get().responseBody as String
                json.decodeFromString<StvGlobalResponse>(response)
            } else {
                val response = suspendCoroutine { continuation ->
                    cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/emote-sets/global", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                }
                json.decodeFromString<StvGlobalResponse>(String(response.second))
            }
        }
        else -> {
            okHttpClient.newCall(Request.Builder().apply {
                url("https://7tv.io/v3/emote-sets/global")
                header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
            }.build()).execute().use { response ->
                json.decodeFromString<StvGlobalResponse>(response.body.string())
            }
        }
    }

    suspend fun loadStvEmotes(networkLibrary: String?, channelId: String, useWebp: Boolean): Pair<String?, List<Emote>> = withContext(Dispatchers.IO) {
        val pair = try {
            withTimeout(20_000) {
                loadStvEmotesResponse(networkLibrary, channelId) to true
            }
        } catch (e: Exception) {
            try {
                readCachedEmoteResponse("channel_$channelId.stv")?.let { cached ->
                    json.decodeFromString<StvChannelResponse>(cached) to false
                }
            } catch (_: Exception) {
                null
            }
        }
        val (response, online) = pair ?: (null to false)
        if (response != null) {
            val set = response.emoteSet
            if (online && set.emotes.isNotEmpty()) {
                writeCachedEmoteResponse("channel_$channelId.stv", json.encodeToString(StvChannelResponse.serializer(), response))
            }
            Pair(set.id, parseStvEmotes(set.emotes, useWebp, Emote.CHANNEL_STV))
        } else {
            Pair(null, emptyList())
        }
    }

    private suspend fun loadStvEmotesResponse(networkLibrary: String?, channelId: String): StvChannelResponse = when {
        networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
            val response = suspendCoroutine { continuation ->
                httpEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${channelId}", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                    addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build().start()
            }
            json.decodeFromString<StvChannelResponse>(String(response.second))
        }
        networkLibrary == "Cronet" && cronetEngine != null -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${channelId}", request.callback, cronetExecutor).apply {
                    addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build().start()
                val response = request.future.get().responseBody as String
                json.decodeFromString<StvChannelResponse>(response)
            } else {
                val response = suspendCoroutine { continuation ->
                    cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${channelId}", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                }
                json.decodeFromString<StvChannelResponse>(String(response.second))
            }
        }
        else -> {
            okHttpClient.newCall(Request.Builder().apply {
                url("https://7tv.io/v3/users/kick/${channelId}")
                header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
            }.build()).execute().use { response ->
                json.decodeFromString<StvChannelResponse>(response.body.string())
            }
        }
    }

    /**
     * 7TV style (equipped paint/badge ids) of a Kick channel owner, or null when the channel
     * has no 7TV account, nothing equipped, or the request failed. The EventApi only pushes
     * cosmetic *changes*, so without this up-front lookup a fresh session renders no flair
     * until some unrelated cosmetic event happens to fire.
     */
    suspend fun loadStvChannelStyle(networkLibrary: String?, kickUserId: String?): Pair<String?, String?>? = withContext(Dispatchers.IO) {
        if (kickUserId.isNullOrBlank()) return@withContext null
        val body = stvGet(networkLibrary, "https://7tv.io/v3/users/kick/$kickUserId") ?: return@withContext null
        runCatching {
            fun JsonObject?.text(key: String): String? =
                (this?.get(key) as? JsonPrimitive)?.takeIf { it !is JsonNull }?.content
            val style = json.parseToJsonElement(body).jsonObject["user"]?.jsonObject?.get("style")?.jsonObject
            Pair(style.text("paint_id"), style.text("badge_id"))
        }.getOrNull()?.takeIf { (paintId, badgeId) -> !paintId.isNullOrBlank() || !badgeId.isNullOrBlank() }
    }

    /**
     * Batch-fetch 7TV cosmetic definitions from the public GQL endpoint. Returns the raw
     * `data.cosmetics` object ({paints:[...], badges:[...]}) for StvEventApiUtils to map onto
     * the same models the live event stream produces.
     */
    suspend fun loadStvCosmetics(paintIds: List<String>, badgeIds: List<String>): JsonObject? = withContext(Dispatchers.IO) {
        val ids = (paintIds + badgeIds).filter { it.isNotBlank() }.joinToString(",") { "\\\"$it\\\"" }
        if (ids.isEmpty()) return@withContext null
        // Small authenticated-free POST; OkHttp is always available and Cronet upload plumbing
        // is not worth it for a one-off hydration request.
        runCatching {
            okHttpClient.newCall(Request.Builder().apply {
                url("https://7tv.io/v3/gql")
                header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                post(
                    ("{\"query\":\"{ cosmetics(list: [$ids]) { paints { id name gradients { function angle repeat " +
                        "image_url stops { at color } } shadows { x_offset y_offset radius color } } " +
                        "badges { id name tooltip host { url files { name format } } } } }\"}")
                        .toRequestBody("application/json".toMediaType())
                )
            }.build()).execute().use { response ->
                if (!response.isSuccessful) return@withContext null
                val data = json.parseToJsonElement(response.body.string()).jsonObject["data"]?.jsonObject
                data?.get("cosmetics")?.jsonObject
            }
        }.getOrNull()
    }

    /** GET honoring the network-library preference; null on any failure or non-2xx. */
    private suspend fun stvGet(networkLibrary: String?, url: String): String? = withContext(Dispatchers.IO) {
        runCatching {
            when {
                networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                    val response = suspendCoroutine { continuation ->
                        httpEngine.get().newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                            addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        }.build().start()
                    }
                    String(response.second).takeIf { response.first.httpStatusCode in 200..299 }
                }
                networkLibrary == "Cronet" && cronetEngine != null -> {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder(url, request.callback, cronetExecutor).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                    val response = request.future.get()
                    response.responseBody?.takeIf { response.urlResponseInfo.httpStatusCode in 200..299 }
                }
                else -> {
                    okHttpClient.newCall(Request.Builder().apply {
                        url(url)
                        header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build()).execute().use { response ->
                        response.body.string().takeIf { response.isSuccessful }
                    }
                }
            }
        }.getOrNull()
    }

    suspend fun loadStvKickEmotes(networkLibrary: String?, userId: String, useWebp: Boolean): Pair<String?, List<Emote>> = withContext(Dispatchers.IO) {
        val response = when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                }
                json.decodeFromString<StvChannelResponse>(String(response.second))
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", request.callback, cronetExecutor).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                    val response = request.future.get().responseBody as String
                    json.decodeFromString<StvChannelResponse>(response)
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        }.build().start()
                    }
                    json.decodeFromString<StvChannelResponse>(String(response.second))
                }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().apply {
                    url("https://7tv.io/v3/users/kick/${userId}")
                    header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build()).execute().use { response ->
                    json.decodeFromString<StvChannelResponse>(response.body.string())
                }
            }
        }
        val set = response.emoteSet
        Pair(set.id, parseStvEmotes(set.emotes, useWebp, Emote.CHANNEL_STV))
    }

    private fun parseStvEmotes(response: List<StvResponse>, useWebp: Boolean, source: Int): List<Emote> {
        return response.mapNotNull { emote ->
            emote.name?.takeIf { it.isNotBlank() }?.let { name ->
                emote.data?.let { data ->
                    data.host?.let { host ->
                        host.url?.takeIf { it.isNotBlank() }?.let { template ->
                            val urls = host.files?.mapNotNull { file ->
                                file.name?.takeIf { it.isNotBlank() &&
                                        if (useWebp) {
                                            file.format == "WEBP"
                                        } else {
                                            file.format == "GIF" || file.format == "PNG"
                                        }
                                }?.let { name ->
                                    "https:${template}/${name}"
                                }
                            }
                            Emote(
                                name = name,
                                url1x = urls?.getOrNull(0) ?: "https:${template}/1x.webp",
                                url2x = urls?.getOrNull(1) ?: if (urls.isNullOrEmpty()) "https:${template}/2x.webp" else null,
                                url3x = urls?.getOrNull(2) ?: if (urls.isNullOrEmpty()) "https:${template}/3x.webp" else null,
                                url4x = urls?.getOrNull(3) ?: if (urls.isNullOrEmpty()) "https:${template}/4x.webp" else null,
                                format = urls?.getOrNull(0)?.substringAfterLast(".") ?: "webp",
                                isAnimated = data.animated != false,
                                isOverlayEmote = emote.flags == 1,
                                source = source,
                            )
                        }
                    }
                }
            }
        }
    }

    suspend fun getStvUser(networkLibrary: String?, userId: String): String? = withContext(Dispatchers.IO) {
        val response = when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                val response = suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                }
                String(response.second)
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", request.callback, cronetExecutor).apply {
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build().start()
                    request.future.get().responseBody as String
                } else {
                    val response = suspendCoroutine { continuation ->
                        cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/kick/${userId}", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        }.build().start()
                    }
                    String(response.second)
                }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().apply {
                    url("https://7tv.io/v3/users/kick/${userId}")
                    header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                }.build()).execute().use { response ->
                    response.body.string()
                }
            }
        }
        JSONObject(response).optJSONObject("user")?.optString("id")
    }

    suspend fun sendStvPresence(networkLibrary: String?, stvUserId: String, channelId: String, sessionId: String?, self: Boolean) = withContext(Dispatchers.IO) {
        val body = buildJsonObject {
            put("kind", 1)
            put("passive", self)
            put("session_id", if (self) sessionId else "undefined")
            putJsonObject("data") {
                put("platform", "KICK")
                put("id", channelId)
            }
        }.toString()
        when {
            networkLibrary == "HttpEngine" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 && httpEngine != null -> {
                suspendCoroutine { continuation ->
                    httpEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/${stvUserId}/presences", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("Content-Type", "application/json")
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(body.toByteArray()), cronetExecutor)
                    }.build().start()
                }
            }
            networkLibrary == "Cronet" && cronetEngine != null -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val request = UrlRequestCallbacks.forStringBody(RedirectHandlers.alwaysFollow())
                    cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/${stvUserId}/presences", request.callback, cronetExecutor).apply {
                        addHeader("Content-Type", "application/json")
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }.build().start()
                    request.future.get().responseBody as String
                } else {
                    suspendCoroutine<Pair<org.chromium.net.UrlResponseInfo, ByteArray>> { continuation ->
                        cronetEngine.get().newUrlRequestBuilder("https://7tv.io/v3/users/${stvUserId}/presences", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            addHeader("Content-Type", "application/json")
                            addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                            setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                        }.build().start()
                    }
                }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().apply {
                    url("https://7tv.io/v3/users/${stvUserId}/presences")
                    header("Content-Type", "application/json")
                    header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    post(body.toRequestBody())
                }.build()).execute().close()
            }
        }
    }

    suspend fun loadGlobalBadges(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, emoteQuality: String, enableIntegrity: Boolean): List<ChatBadge> = withContext(Dispatchers.IO) {
        // The Twitch GQL badge queries this used to try first can never succeed against Kick.
        if (kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) return@withContext emptyList()
        kickPublicApiRepository.getGlobalBadges(networkLibrary, kickPublicApiHeaders).data.mapNotNull { set ->
            set.setId?.let { setId ->
                set.versions?.mapNotNull {
                    it.id?.let { version ->
                        ChatBadge(
                            setId = setId,
                            version = version,
                            url1x = it.url1x,
                            url2x = it.url2x,
                            url3x = it.url4x,
                            url4x = it.url4x
                        )
                    }
                }
            }
        }.flatten()
    }


    suspend fun loadChannelBadges(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, channelId: String?, channelLogin: String?, emoteQuality: String, enableIntegrity: Boolean): List<ChatBadge> = withContext(Dispatchers.IO) {
        if (kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) return@withContext emptyList()
        kickPublicApiRepository.getChannelBadges(networkLibrary, kickPublicApiHeaders, channelId).data.mapNotNull { set ->
            set.setId?.let { setId ->
                set.versions?.mapNotNull {
                    it.id?.let { version ->
                        ChatBadge(
                            setId = setId,
                            version = version,
                            url1x = it.url1x,
                            url2x = it.url2x,
                            url3x = it.url4x,
                            url4x = it.url4x
                        )
                    }
                }
            }
        }.flatten()
    }


    suspend fun loadCheerEmotes(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, channelId: String?, channelLogin: String?, animateGifs: Boolean, enableIntegrity: Boolean): List<CheerEmote> = withContext(Dispatchers.IO) {
        if (kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) return@withContext emptyList()
        kickPublicApiRepository.getCheerEmotes(networkLibrary, kickPublicApiHeaders, channelId).data.map { set ->
            set.tiers.mapNotNull { tier ->
                tier.images.let { it.dark ?: it.light }?.let { formats ->
                    if (animateGifs) {
                        formats.animated ?: formats.static
                    } else {
                        formats.static
                    }?.let { urls ->
                        CheerEmote(
                            name = set.prefix,
                            url1x = urls.url1x,
                            url2x = urls.url2x,
                            url3x = urls.url3x,
                            url4x = urls.url4x,
                            format = if (urls == formats.animated) "gif" else null,
                            isAnimated = urls == formats.animated,
                            minBits = tier.minBits,
                            color = tier.color
                        )
                    }
                }
            }
        }.flatten()
    }


    suspend fun loadUserEmotes(networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, kickWebHeaders: Map<String, String>, channelId: String?, userId: String?, animateGifs: Boolean, enableIntegrity: Boolean): List<ChatEmote> = withContext(Dispatchers.IO) {
        if (kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()) return@withContext emptyList()
        val emotes = mutableListOf<ChatEmote>()
        var offset: String? = null
        do {
            val response = kickPublicApiRepository.getUserEmotes(networkLibrary, kickPublicApiHeaders, userId, channelId, offset)
            response.data.mapNotNull { emote ->
                emote.name?.let { name ->
                    emote.id?.let { id ->
                        val format = if (animateGifs) {
                            emote.format?.find { it == "animated" } ?: emote.format?.find { it == "static" }
                        } else {
                            emote.format?.find { it == "static" }
                        } ?: emote.format?.firstOrNull() ?: ""
                        val theme = emote.theme?.find { it == "dark" } ?: emote.theme?.lastOrNull() ?: ""
                        val scale1x = emote.scale?.find { it.startsWith("1") } ?: emote.scale?.lastOrNull() ?: ""
                        val scale2x = emote.scale?.find { it.startsWith("2") } ?: scale1x
                        val scale3x = emote.scale?.find { it.startsWith("3") } ?: scale2x
                        val url = response.template
                            .replaceFirst("{{id}}", id)
                            .replaceFirst("{{format}}", format)
                            .replaceFirst("{{theme_mode}}", theme)
                        ChatEmote(
                            name = if (emote.type == "smilies") {
                                name.replace("\\", "").replace("?", "")
                                    .replace("&lt;", "<").replace("&gt;", ">")
                                    .replace(EMOTE_SMILIE_PAREN_REGEX) { it.groups[1]?.value ?: "" }
                                    .replace(EMOTE_SMILIE_BRACKET_REGEX) { it.groups[1]?.value ?: "" }
                            } else name,
                            url1x = url.replaceFirst("{{scale}}", scale1x),
                            url2x = url.replaceFirst("{{scale}}", scale2x),
                            url3x = url.replaceFirst("{{scale}}", scale3x),
                            url4x = url.replaceFirst("{{scale}}", scale3x),
                            format = if (format == "animated") "gif" else null,
                            setId = emote.setId,
                            ownerId = emote.ownerId
                        )
                    }
                }
            }.let { emotes.addAll(it) }
            offset = response.pagination?.cursor
        } while (!response.pagination?.cursor.isNullOrBlank())
        emotes
    }



    fun loadRecentEmotesFlow() = recentEmotes.getAllFlow()

    suspend fun loadRecentEmotes(): List<RecentEmote> = withContext(Dispatchers.IO) {
        recentEmotes.getAll()
    }

    suspend fun insertRecentEmotes(emotes: Collection<RecentEmote>) = withContext(Dispatchers.IO) {
        val list = if (emotes.size <= RecentEmote.MAX_SIZE) {
            emotes
        } else {
            emotes.toList().takeLast(RecentEmote.MAX_SIZE)
        }
        recentEmotes.ensureMaxSizeAndInsert(list)
    }

    fun loadVideoPositions() = videoPositions.getAll()

    suspend fun getVideoPosition(id: Long) = withContext(Dispatchers.IO) {
        videoPositions.getById(id)
    }

    suspend fun saveVideoPosition(position: VideoPosition) = withContext(Dispatchers.IO) {
        videoPositions.insert(position)
    }

    suspend fun deleteVideoPositions() = withContext(Dispatchers.IO) {
        videoPositions.deleteAll()
    }
}
