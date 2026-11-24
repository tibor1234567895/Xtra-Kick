package com.xtrakick.app.repository

import android.content.Context
import android.net.http.HttpEngine
import android.os.Build
import android.os.ext.SdkExtensions
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.db.RecentEmotesDao
import com.xtrakick.app.db.VideoPositionsDao
import com.xtrakick.app.model.VideoPosition
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.model.misc.StvChannelResponse
import com.xtrakick.app.model.misc.StvGlobalResponse
import com.xtrakick.app.model.misc.StvResponse
import com.xtrakick.app.util.HttpEngineUtils
import com.xtrakick.app.util.NetworkUtils
import com.xtrakick.app.util.NetworkUtils.useCancellable
import com.xtrakick.app.util.getByteArrayCronetCallback
import dagger.Lazy
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okio.source
import org.chromium.net.CronetEngine
import org.chromium.net.apihelpers.UploadDataProviders
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutorService
import java.util.zip.DeflaterOutputStream
import java.util.zip.InflaterOutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val httpEngine: Lazy<HttpEngine>?,
    private val cronetEngine: Lazy<CronetEngine>?,
    private val cronetExecutor: ExecutorService,
    private val okHttpClient: OkHttpClient,
    private val json: Json,
    private val kickRepository: KickRepository,
    private val recentEmotes: RecentEmotesDao,
    private val videoPositions: VideoPositionsDao,
) {

    val resolutionChangeFlow = kotlinx.coroutines.flow.MutableSharedFlow<String>(extraBufferCapacity = 1)
    val qualityChangeFlow = kotlinx.coroutines.flow.MutableSharedFlow<String>(extraBufferCapacity = 1)

    suspend fun downloadTo(
        networkLibrary: String?,
        url: String,
        output: OutputStream,
        progressListener: NetworkUtils.ProgressListener? = null,
    ) = withContext(Dispatchers.IO) {
        var bytesRead = 0
        val progress = NetworkUtils.ProgressListener {
            bytesRead = it
            progressListener?.update(it)
        }
        val http = NetworkUtils.resolveHttpEngine(networkLibrary, httpEngine)
        val cronet = NetworkUtils.resolveCronetEngine(networkLibrary, cronetEngine)
        val status = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
                http is HttpEngine -> {
                val response = NetworkUtils.awaitDownloadRequest { continuation, touch ->
                    val trackedProgress = NetworkUtils.ProgressListener {
                        touch()
                        progress.update(it)
                    }
                    val request = http.newUrlRequestBuilder(
                        url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation, trackedProgress, output)
                    ).build()
                    request.start()
                    return@awaitDownloadRequest { request.cancel() }
                }
                response.first.httpStatusCode
            }
            cronet != null -> {
                val response = NetworkUtils.awaitDownloadRequest { continuation, touch ->
                    val trackedProgress = NetworkUtils.ProgressListener {
                        touch()
                        progress.update(it)
                    }
                    val request = cronet.newUrlRequestBuilder(
                        url, NetworkUtils.ByteArrayCronetUrlCallback(continuation, trackedProgress, output), cronetExecutor
                    ).build()
                    request.start()
                    return@awaitDownloadRequest { request.cancel() }
                }
                response.first.httpStatusCode
            }
            else -> okHttpClient.newCall(Request.Builder().url(url).build()).useCancellable { response ->
                if (response.isSuccessful) {
                    response.body.byteStream().use { input ->
                        val buffer = ByteArray(32 * 1024)
                        var count = input.read(buffer)
                        while (count != -1) {
                            output.write(buffer, 0, count)
                            progress.update(Math.addExact(bytesRead, count))
                            count = input.read(buffer)
                        }
                    }
                }
                response.code
            }
        }
        if (status !in 200..299 || bytesRead == 0) throw IOException("Update download failed: HTTP $status, $bytesRead bytes")
    }

    suspend fun loadTextFromUrl(networkLibrary: String?, url: String, headers: Map<String, String> = emptyMap()): String? = withContext(Dispatchers.IO) {
        val http = NetworkUtils.resolveHttpEngine(networkLibrary, httpEngine)
        val cronet = NetworkUtils.resolveCronetEngine(networkLibrary, cronetEngine)
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
                http is HttpEngine -> {
                val response = kotlinx.coroutines.withTimeout(20_000L) {
                    suspendCancellableCoroutine { continuation ->
                        val request = http.newUrlRequestBuilder(url, cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                            headers.forEach { (name, value) -> addHeader(name, value) }
                        }.build()
                        continuation.invokeOnCancellation { request.cancel() }
                        request.start()
                    }
                }
                if (response.first.httpStatusCode in 200..299) {
                    String(response.second)
                } else null
            }
            cronet != null -> {
                val response = kotlinx.coroutines.withTimeout(20_000L) {
                    suspendCancellableCoroutine { continuation ->
                        val request = cronet.newUrlRequestBuilder(url, getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                            headers.forEach { (name, value) -> addHeader(name, value) }
                        }.build()
                        continuation.invokeOnCancellation { request.cancel() }
                        request.start()
                    }
                }
                String(response.second).takeIf { response.first.httpStatusCode in 200..299 }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().url(url).apply {
                    headers.forEach { (name, value) -> header(name, value) }
                }.build()).useCancellable { response ->
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

    // REST lookups for emotes, channel style, and presence share the same cache entry.
    private val stvResponseMemoryCache = ConcurrentHashMap<String, Pair<Long, String>>()
    private val STV_GLOBAL_CACHE_TTL_MS = 6L * 60 * 60 * 1000   // global set changes rarely
    private val STV_EMOTE_SET_CACHE_TTL_MS = 60L * 60 * 1000     // channel emote set
    private val STV_LOOKUP_CACHE_TTL_MS = 10L * 60 * 1000        // style / presence lookups
    private val STV_CACHE_MAX_ENTRIES = 32
    private val stvFetchMutexes = Array(32) { Mutex() }

    /**
     * Explicit refresh path (chat emote reload): drop the memory cache so a reload
     * re-fetches instead of replaying up to the 6h global / 60min channel TTLs. Disk
     * fallbacks still apply on a failed refetch.
     */
    fun clearStvMemoryCache() {
        stvResponseMemoryCache.clear()
    }

    /**
     * Fetch a 7TV response through the shared memory cache and, when [diskCacheName] is set,
     * the deflate-compressed disk cache. A fresh memory hit skips the network entirely; on
     * failure the last persisted response (any age) is returned so emotes still load offline
     * or during a 7TV outage. Fetches are serialized by key so the concurrent lookups
     * at chat start share one network call instead of racing three.
     */
    private suspend fun stvGetCached(
        networkLibrary: String?,
        cacheKey: String,
        ttlMs: Long,
        diskCacheName: String? = null,
        fetch: suspend () -> String? = { stvGet(networkLibrary, cacheKey) },
    ): String? {
        val now = System.currentTimeMillis()
        stvResponseMemoryCache[cacheKey]?.let { (fetchedAtMs, body) ->
            if (now - fetchedAtMs <= ttlMs) return body
        }
        val fetched = stvFetchMutexes[(cacheKey.hashCode() and Int.MAX_VALUE) % stvFetchMutexes.size].withLock {
            // Re-check: another coroutine may have fetched while we waited for the lock.
            stvResponseMemoryCache[cacheKey]?.let { (fetchedAtMs, body) ->
                if (System.currentTimeMillis() - fetchedAtMs <= ttlMs) return@withLock body
            }
            val body = fetch()
            if (body != null && body.trimStart().startsWith("{")) {
                // Only cache JSON-shaped bodies so an error page / CDN response cannot be
                // replayed from memory later; callers decode it and fall back to disk anyway.
                synchronized(stvResponseMemoryCache) {
                    stvResponseMemoryCache[cacheKey] = System.currentTimeMillis() to body
                    while (stvResponseMemoryCache.size > STV_CACHE_MAX_ENTRIES) {
                        stvResponseMemoryCache.entries.minByOrNull { it.value.first }
                            ?.let { stvResponseMemoryCache.remove(it.key) }
                    }
                }
            }
            body
        }
        if (fetched != null) return fetched
        return diskCacheName?.let { readCachedEmoteResponse(it) }
    }

    suspend fun loadGlobalStvEmotes(networkLibrary: String?, useWebp: Boolean): List<Emote> = withContext(Dispatchers.IO) {
        // network first (deduped by the shared TTL cache), falling back to the last
        // persisted response on a timeout/failure so emotes load offline / during 7tv outages
        val response = try {
            withTimeout(20_000) {
                val body = stvGetCached(networkLibrary, "https://7tv.io/v3/emote-sets/global", STV_GLOBAL_CACHE_TTL_MS, "global.stv") ?: return@withTimeout null
                json.decodeFromString<StvGlobalResponse>(body).also { decoded ->
                    if (decoded.emotes.isNotEmpty()) {
                        writeCachedEmoteResponse("global.stv", json.encodeToString(StvGlobalResponse.serializer(), decoded))
                    }
                }
            }
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            readCachedGlobalStvSet()
        }
        response?.let { parseStvEmotes(it.emotes, useWebp, Emote.GLOBAL_STV) } ?: emptyList()
    }

    suspend fun loadCachedGlobalStvEmotes(useWebp: Boolean): List<Emote> = withContext(Dispatchers.IO) {
        val set = readCachedGlobalStvSet() ?: return@withContext emptyList()
        parseStvEmotes(set.emotes, useWebp, Emote.GLOBAL_STV)
    }

    private fun readCachedGlobalStvSet(): StvGlobalResponse? =
        readCachedEmoteResponse("global.stv")?.let { cached ->
            runCatching { json.decodeFromString<StvGlobalResponse>(cached) }.getOrNull()
        }

    suspend fun loadStvEmotes(
        networkLibrary: String?,
        channelId: String,
        useWebp: Boolean,
        preferGraphQl: Boolean = false,
        cacheChannelId: String = channelId,
        useDiskFallback: Boolean = true,
    ): Pair<String?, List<Emote>> = withContext(Dispatchers.IO) {
        val cacheName = "channel_$cacheChannelId.stv"
        val restUrl = "https://7tv.io/v3/users/KICK/$channelId"
        val response = try {
            withTimeout(20_000) {
                val decoded = if (preferGraphQl) {
                    coroutineScope {
                        val graphQl = async {
                            val body = stvGetCached(networkLibrary, "kick-emote-set/$channelId", STV_EMOTE_SET_CACHE_TTL_MS) {
                                withTimeoutOrNull(7_000) { fetchStvKickEmoteSet(channelId) }
                            }
                            decodeStvChannelSet(body)
                        }
                        val rest = async {
                            delay(1_500)
                            decodeStvChannelSet(stvGetCached(networkLibrary, restUrl, STV_EMOTE_SET_CACHE_TTL_MS))
                        }
                        select {
                            graphQl.onAwait { it?.also { rest.cancel() } ?: rest.await() }
                            rest.onAwait { it?.also { graphQl.cancel() } ?: graphQl.await() }
                        }
                    }
                } else {
                    decodeStvChannelSet(stvGetCached(networkLibrary, restUrl, STV_EMOTE_SET_CACHE_TTL_MS))
                } ?: return@withTimeout null
                if (decoded.emoteSet.id != null || decoded.emoteSet.emotes.isNotEmpty()) {
                    writeCachedEmoteResponse(cacheName, json.encodeToString(StvChannelResponse.serializer(), decoded))
                }
                decoded
            }
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            null
        } ?: if (useDiskFallback) readCachedStvChannelSet(cacheChannelId) else null
        val set = response?.emoteSet ?: return@withContext null to emptyList()
        set.id to parseStvEmotes(set.emotes, useWebp, Emote.CHANNEL_STV)
    }

    suspend fun loadCachedStvChannelEmotes(channelId: String, useWebp: Boolean): Pair<String?, List<Emote>>? =
        withContext(Dispatchers.IO) {
            val set = readCachedStvChannelSet(channelId)?.emoteSet ?: return@withContext null
            set.id to parseStvEmotes(set.emotes, useWebp, Emote.CHANNEL_STV)
        }

    private fun readCachedStvChannelSet(channelId: String): StvChannelResponse? =
        decodeStvChannelSet(readCachedEmoteResponse("channel_$channelId.stv"))

    private fun decodeStvChannelSet(body: String?): StvChannelResponse? =
        body?.let { runCatching { json.decodeFromString<StvChannelResponse>(it) }.getOrNull() }

    private suspend fun fetchStvKickEmoteSet(channelId: String): String? {
        val connection = runCatching {
            val data = requestStvGraphQl(
                "{ userByConnection(platform: KICK, id: ${JsonPrimitive(channelId)}) { connections { id platform emote_set_id } } }"
            )
            data?.get("userByConnection")?.jsonObject?.get("connections")?.jsonArray
                ?.firstOrNull {
                    it.jsonObject["platform"]?.jsonPrimitive?.content == "KICK" &&
                        it.jsonObject["id"]?.jsonPrimitive?.content == channelId
                }?.jsonObject
        }.getOrElse {
            currentCoroutineContext().ensureActive()
            return null
        }
        val setId = connection?.get("emote_set_id") as? JsonPrimitive ?: return null
        if (setId is JsonNull) return null
        val data = requestStvGraphQl(
            "{ emoteSet(id: $setId) { id emotes { name flags data { animated host { url files { name format } } } } } }"
        )
        val set = data?.get("emoteSet") as? JsonObject ?: return null
        return buildJsonObject { put("emote_set", set) }.toString()
    }

    /**
     * 7TV style (equipped paint/badge ids) of a Kick channel owner, or null when the channel
     * has no 7TV account, nothing equipped, or the request failed. The EventApi only pushes
     * cosmetic *changes*, so without this up-front lookup a fresh session renders no flair
     * until some unrelated cosmetic event happens to fire.
     */
    suspend fun loadStvChannelStyle(networkLibrary: String?, kickUserId: String?): Pair<String?, String?>? = withContext(Dispatchers.IO) {
        if (kickUserId.isNullOrBlank()) return@withContext null
        val body = stvGetCached(networkLibrary, "https://7tv.io/v3/users/KICK/$kickUserId", STV_LOOKUP_CACHE_TTL_MS) ?: return@withContext null
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
        val ids = (paintIds + badgeIds).filter { it.isNotBlank() }.distinct().joinToString(",") { JsonPrimitive(it).toString() }
        if (ids.isEmpty()) return@withContext null
        val query = "{ cosmetics(list: [$ids]) { paints { id name gradients { function angle repeat " +
            "image_url stops { at color } } shadows { x_offset y_offset radius color } } " +
            "badges { id name tooltip host { url files { name format } } } } }"
        requestStvGraphQl(query)?.get("cosmetics") as? JsonObject
    }

    private suspend fun requestStvGraphQl(query: String): JsonObject? =
        try {
            okHttpClient.newCall(Request.Builder().apply {
                url("https://7tv.io/v3/gql")
                header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                post(
                    buildJsonObject { put("query", query) }.toString()
                        .toRequestBody("application/json".toMediaType())
                )
            }.build()).useCancellable { response ->
                if (response.isSuccessful) {
                    json.parseToJsonElement(response.body.string()).jsonObject["data"] as? JsonObject
                } else null
            }
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            null
        }

    /** GET honoring the network-library preference; null on any failure or non-2xx. */
    private suspend fun stvGet(networkLibrary: String?, url: String): String? {
        return try {
            loadTextFromUrl(networkLibrary, url, mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME))
        } catch (_: Exception) {
            currentCoroutineContext().ensureActive()
            null
        }
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
        // Same users/KICK/{id} endpoint as the emote/style lookups; the shared cache means a
        // chat start that also loads channel emotes and style pays for this once, not three times.
        val response = stvGetCached(networkLibrary, "https://7tv.io/v3/users/KICK/$userId", STV_LOOKUP_CACHE_TTL_MS)
            ?: return@withContext null
        runCatching { JSONObject(response).optJSONObject("user")?.optString("id")?.takeIf { it.isNotBlank() } }.getOrNull()
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
        val http = NetworkUtils.resolveHttpEngine(networkLibrary, httpEngine)
        val cronet = NetworkUtils.resolveCronetEngine(networkLibrary, cronetEngine)
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                SdkExtensions.getExtensionVersion(Build.VERSION_CODES.S) >= 7 &&
                http is HttpEngine -> {
                suspendCancellableCoroutine { continuation ->
                    val request = http.newUrlRequestBuilder("https://7tv.io/v3/users/${stvUserId}/presences", cronetExecutor, HttpEngineUtils.byteArrayUrlCallback(continuation)).apply {
                        addHeader("Content-Type", "application/json")
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        setUploadDataProvider(HttpEngineUtils.byteArrayUploadProvider(body.toByteArray()), cronetExecutor)
                    }.build()
                    continuation.invokeOnCancellation { request.cancel() }
                    request.start()
                }
            }
            cronet != null -> {
                suspendCancellableCoroutine<Pair<org.chromium.net.UrlResponseInfo, ByteArray>> { continuation ->
                    val request = cronet.newUrlRequestBuilder("https://7tv.io/v3/users/${stvUserId}/presences", getByteArrayCronetCallback(continuation), cronetExecutor).apply {
                        addHeader("Content-Type", "application/json")
                        addHeader("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        setUploadDataProvider(UploadDataProviders.create(body.toByteArray()), cronetExecutor)
                    }.build()
                    continuation.invokeOnCancellation { request.cancel() }
                    request.start()
                }
            }
            else -> {
                okHttpClient.newCall(Request.Builder().apply {
                    url("https://7tv.io/v3/users/${stvUserId}/presences")
                    header("Content-Type", "application/json")
                    header("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    post(body.toRequestBody())
                }.build()).useCancellable { }
            }
        }
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
