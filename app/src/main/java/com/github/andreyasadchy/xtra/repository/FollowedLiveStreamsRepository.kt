package com.github.andreyasadchy.xtra.repository

import android.content.Context
import android.util.Log
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Shared loader for "Following → Live".
 *
 * Fast path: batched Public API livestream lookups (by broadcaster id).
 * Fallback: batched user-id resolve + livestreams.
 * Last resort (optional): per-channel Kick web API — avoid for MultiPOV picker.
 *
 * Cache is shared with [com.github.andreyasadchy.xtra.ui.following.streams.FollowedStreamsViewModel]
 * so MultiPOV add-stream can open instantly after a Following visit.
 */
@Singleton
class FollowedLiveStreamsRepository @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val json: Json,
) {
    companion object {
        private const val TAG = "FollowedLiveRepo"
        const val CACHE_KEY = "followed_streams_cache_v1"
        private const val BROADCASTER_ID_CACHE_KEY = "kick_broadcaster_id_cache_v1"
        const val CACHE_TTL_MS = 45_000L
        private const val LIVESTREAM_BATCH_SIZE = 50
        private const val USER_LOOKUP_BATCH_SIZE = 100
        private const val PUBLIC_API_PARALLELISM = 3
        private const val PER_CHANNEL_BATCH_SIZE = 12
    }

    @Serializable
    private data class CachedFollowedStream(
        val id: String? = null,
        val source: String? = null,
        val channelId: String? = null,
        val channelLogin: String? = null,
        val channelName: String? = null,
        val playbackUrl: String? = null,
        val gameId: String? = null,
        val gameSlug: String? = null,
        val gameName: String? = null,
        val title: String? = null,
        val viewerCount: Int? = null,
        val startedAt: String? = null,
        val thumbnailUrl: String? = null,
        val profileImageUrl: String? = null,
    ) {
        fun toStream(): Stream = Stream(
            id = id,
            source = source,
            channelId = channelId,
            channelLogin = channelLogin,
            channelName = channelName,
            playbackUrl = playbackUrl,
            gameId = gameId,
            gameSlug = gameSlug,
            gameName = gameName,
            title = title,
            viewerCount = viewerCount,
            startedAt = startedAt,
            thumbnailUrl = thumbnailUrl,
            profileImageUrl = profileImageUrl,
        )
    }

    @Serializable
    private data class CachePayload(
        val cachedAt: Long = 0L,
        val items: List<CachedFollowedStream> = emptyList(),
    )

    data class LoadResult(
        val items: List<Stream>,
        val fromCache: Boolean,
    )

    /**
     * @param forceRefresh ignore TTL cache
     * @param allowPerChannelFallback only for Following tab completeness; MultiPOV should leave false
     * @param onPartial optional progressive updates (Following tab UI)
     */
    suspend fun loadLiveFollowed(
        forceRefresh: Boolean = false,
        allowPerChannelFallback: Boolean = false,
        onPartial: (List<Stream>) -> Unit = {},
    ): LoadResult {
        if (!forceRefresh) {
            val cached = peekCache()
            if (cached.isNotEmpty()) {
                onPartial(cached)
                return LoadResult(items = cached, fromCache = true)
            }
        }

        val follows = localFollowsChannel.loadFollows()
        if (follows.isEmpty()) {
            persistCache(emptyList())
            onPartial(emptyList())
            return LoadResult(items = emptyList(), fromCache = false)
        }

        val resolved = LinkedHashMap<String, Stream>()

        val fast = runCatching { loadFromPublicApi(follows) }
            .onFailure { debugWarn("Fast followed-live path failed: ${it.message}") }
            .getOrNull()
        fast?.items?.forEach { resolved[it.cacheKey()] = it }
        if (fast != null && resolved.isNotEmpty()) {
            onPartial(resolved.values.toList().sortedByViewersDesc())
        }

        val unresolvedAfterFast = fast?.unresolved ?: follows
        val bulk = runCatching { loadFromBulkFallback(unresolvedAfterFast) }
            .onFailure { debugWarn("Bulk followed-live fallback failed: ${it.message}") }
            .getOrNull()
        bulk?.items?.forEach { resolved[it.cacheKey()] = it }
        if (bulk != null && bulk.items.isNotEmpty()) {
            onPartial(resolved.values.toList().sortedByViewersDesc())
        }

        val unresolvedAfterBulk = bulk?.unresolved ?: unresolvedAfterFast
        if (allowPerChannelFallback && unresolvedAfterBulk.isNotEmpty()) {
            unresolvedAfterBulk.chunked(PER_CHANNEL_BATCH_SIZE).forEach { batch ->
                currentCoroutineContext().ensureActive()
                val batchResults = coroutineScope {
                    batch.map { follow ->
                        async { loadStreamForFollow(follow) }
                    }.awaitAll()
                }.filterNotNull()
                batchResults.forEach { resolved[it.cacheKey()] = it }
                if (batchResults.isNotEmpty()) {
                    onPartial(resolved.values.toList().sortedByViewersDesc())
                }
            }
        }

        val finalItems = resolved.values.toList().sortedByViewersDesc()
        // Prefetch a handful of playback masters for snappy MultiPOV add (no badge spam).
        kickRepository.prefetchChannelLivestreams(
            finalItems.mapNotNull { it.channelLogin }.take(PER_CHANNEL_BATCH_SIZE)
        )
        persistCache(finalItems)
        onPartial(finalItems)
        return LoadResult(items = finalItems, fromCache = false)
    }

    fun peekCache(maxAgeMs: Long = CACHE_TTL_MS): List<Stream> {
        val payload = applicationContext.prefs().getString(CACHE_KEY, null)
            ?.let { encoded -> runCatching { json.decodeFromString<CachePayload>(encoded) }.getOrNull() }
            ?: return emptyList()
        if (System.currentTimeMillis() - payload.cachedAt > maxAgeMs) return emptyList()
        return payload.items.map { it.toStream() }.sortedByViewersDesc()
    }

    private data class PartialResult(
        val items: List<Stream>,
        val unresolved: List<LocalFollowChannel>,
    )

    private suspend fun loadFromPublicApi(follows: List<LocalFollowChannel>): PartialResult? {
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[C.HEADER_TOKEN].isNullOrBlank()) {
            debugInfo("Fast path skipped: missing auth token")
            return null
        }
        val broadcasterIdsByLogin = loadBroadcasterIdCache()
        val followsByBroadcasterId = follows
            .mapNotNull { follow ->
                follow.userLogin
                    ?.takeIf { it.isNotBlank() }
                    ?.lowercase()
                    ?.let { login -> broadcasterIdsByLogin[login]?.let { id -> id to follow } }
            }
            .toMap()
        if (followsByBroadcasterId.isEmpty()) {
            debugInfo("Fast path skipped: no cached broadcaster ids")
            return null
        }

        val resolved = LinkedHashMap<String, Stream>()
        coroutineScope {
            followsByBroadcasterId.keys
                .chunked(LIVESTREAM_BATCH_SIZE)
                .chunked(PUBLIC_API_PARALLELISM)
                .forEach { requestWindow ->
                    currentCoroutineContext().ensureActive()
                    requestWindow.map { ids ->
                        async {
                            kickPublicApiRepository.getLivestreams(
                                networkLibrary = networkLibrary,
                                headers = headers,
                                broadcasterUserIds = ids,
                                categoryId = null,
                                language = null,
                                limit = ids.size,
                                sort = "viewer_count",
                            )
                        }
                    }.awaitAll().forEach { response ->
                        response.data.forEach { stream ->
                            val follow = stream.broadcasterUserId?.toString()?.let(followsByBroadcasterId::get)
                            val mapped = stream.toUiStream(follow)
                            resolved[mapped.cacheKey()] = mapped
                        }
                    }
                }
        }

        val known = followsByBroadcasterId.values.toSet()
        return PartialResult(
            items = resolved.values.toList().sortedByViewersDesc(),
            unresolved = follows.filter { it !in known },
        )
    }

    private suspend fun loadFromBulkFallback(follows: List<LocalFollowChannel>): PartialResult? {
        if (follows.isEmpty()) return PartialResult(emptyList(), emptyList())

        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[C.HEADER_TOKEN].isNullOrBlank()) {
            debugInfo("Bulk fallback skipped: missing auth token")
            return null
        }
        val followByLogin = follows
            .mapNotNull { follow ->
                follow.userLogin
                    ?.takeIf { it.isNotBlank() }
                    ?.lowercase()
                    ?.let { login -> login to follow }
            }
            .toMap(LinkedHashMap())
        if (followByLogin.isEmpty()) {
            return PartialResult(emptyList(), follows)
        }

        val broadcasterIdCache = loadBroadcasterIdCache()
        val followsByBroadcasterId = LinkedHashMap<String, LocalFollowChannel>()
        var cacheChanged = false

        coroutineScope {
            followByLogin.keys
                .chunked(USER_LOOKUP_BATCH_SIZE)
                .chunked(PUBLIC_API_PARALLELISM)
                .forEach { requestWindow ->
                    currentCoroutineContext().ensureActive()
                    requestWindow.map { logins ->
                        async {
                            kickPublicApiRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = headers,
                                logins = logins,
                            )
                        }
                    }.awaitAll().forEach { response ->
                        response.data.forEach { user ->
                            val login = user.channelLogin?.takeIf { it.isNotBlank() }?.lowercase() ?: return@forEach
                            val broadcasterId = user.channelId?.takeIf { it.isNotBlank() } ?: return@forEach
                            val follow = followByLogin[login] ?: return@forEach
                            followsByBroadcasterId[broadcasterId] = follow
                            if (broadcasterIdCache[login] != broadcasterId) {
                                broadcasterIdCache[login] = broadcasterId
                                cacheChanged = true
                            }
                        }
                    }
                }
        }

        if (cacheChanged) {
            persistBroadcasterIdCache(broadcasterIdCache)
        }

        val resolved = LinkedHashMap<String, Stream>()
        coroutineScope {
            followsByBroadcasterId.keys
                .chunked(LIVESTREAM_BATCH_SIZE)
                .chunked(PUBLIC_API_PARALLELISM)
                .forEach { requestWindow ->
                    currentCoroutineContext().ensureActive()
                    requestWindow.map { ids ->
                        async {
                            kickPublicApiRepository.getLivestreams(
                                networkLibrary = networkLibrary,
                                headers = headers,
                                broadcasterUserIds = ids,
                                categoryId = null,
                                language = null,
                                limit = ids.size,
                                sort = "viewer_count",
                            )
                        }
                    }.awaitAll().forEach { response ->
                        response.data.forEach { stream ->
                            val follow = stream.broadcasterUserId?.toString()?.let(followsByBroadcasterId::get)
                            val mapped = stream.toUiStream(follow)
                            resolved[mapped.cacheKey()] = mapped
                        }
                    }
                }
        }

        val resolvedFollows = followsByBroadcasterId.values.toSet()
        return PartialResult(
            items = resolved.values.toList().sortedByViewersDesc(),
            unresolved = follows.filter { it !in resolvedFollows },
        )
    }

    private suspend fun loadStreamForFollow(follow: LocalFollowChannel): Stream? {
        val login = follow.userLogin?.takeIf { it.isNotBlank() }
        val id = follow.userId?.takeIf { it.isNotBlank() }
        return when {
            !login.isNullOrBlank() -> {
                val channel = runCatching {
                    kickRepository.getChannel(channelSlug = login, prefetchBadgeCatalog = false)
                }.getOrNull() ?: return null
                rememberBroadcasterId(
                    channel.slug ?: login,
                    channel.userId?.toString() ?: channel.user?.id?.toString()
                )
                val livestream = channel.livestream ?: return null
                val enriched = if (
                    !hasUsableThumbnail(livestream.thumbnail?.imageUrl) || livestream.category == null
                ) {
                    runCatching { kickRepository.getChannelLivestream(login, forceRefresh = true) }.getOrNull()
                        ?: livestream
                } else {
                    livestream
                }
                kickRepository.toStream(channel, enriched)
            }
            !id.isNullOrBlank() -> {
                val channel = runCatching {
                    kickRepository.getChannel(channelSlug = id, prefetchBadgeCatalog = false)
                }.getOrNull() ?: return null
                rememberBroadcasterId(
                    channel.slug,
                    channel.userId?.toString() ?: channel.user?.id?.toString()
                )
                val livestream = channel.livestream ?: return null
                kickRepository.toStream(channel, livestream)
            }
            else -> null
        }
    }

    private fun com.github.andreyasadchy.xtra.model.helix.livestream.Livestream.toUiStream(
        follow: LocalFollowChannel?,
    ): Stream {
        return Stream(
            id = channelId?.toString(),
            source = C.KICK,
            channelId = broadcasterUserId?.toString() ?: follow?.userId,
            channelLogin = slug ?: follow?.userLogin,
            channelName = follow?.userName ?: slug,
            playbackUrl = null,
            gameId = category?.id?.toString(),
            gameSlug = null,
            gameName = category?.name,
            title = streamTitle,
            viewerCount = viewerCount,
            startedAt = startedAt,
            thumbnailUrl = thumbnail,
            profileImageUrl = profilePicture ?: follow?.channelLogo,
            tags = customTags,
        )
    }

    private fun persistCache(items: List<Stream>) {
        val payload = CachePayload(
            cachedAt = System.currentTimeMillis(),
            items = items.map {
                CachedFollowedStream(
                    id = it.id,
                    source = it.source,
                    channelId = it.channelId,
                    channelLogin = it.channelLogin,
                    channelName = it.channelName,
                    playbackUrl = it.playbackUrl,
                    gameId = it.gameId,
                    gameSlug = it.gameSlug,
                    gameName = it.gameName,
                    title = it.title,
                    viewerCount = it.viewerCount,
                    startedAt = it.startedAt,
                    thumbnailUrl = it.thumbnailUrl,
                    profileImageUrl = it.profileImageUrl,
                )
            }
        )
        applicationContext.prefs().edit()
            .putString(CACHE_KEY, json.encodeToString(payload))
            .apply()
    }

    private fun loadBroadcasterIdCache(): MutableMap<String, String> {
        val raw = applicationContext.prefs().getString(BROADCASTER_ID_CACHE_KEY, null)
            ?.takeIf { it.isNotBlank() }
            ?: return linkedMapOf()
        return runCatching {
            val root = JSONObject(raw)
            buildMap {
                root.keys().forEach { key ->
                    val value = root.optString(key).takeIf { it.isNotBlank() } ?: return@forEach
                    put(key.lowercase(), value)
                }
            }.toMutableMap()
        }.getOrDefault(linkedMapOf())
    }

    private fun rememberBroadcasterId(login: String?, broadcasterUserId: String?) {
        val normalizedLogin = login?.takeIf { it.isNotBlank() }?.lowercase() ?: return
        val normalizedId = broadcasterUserId?.takeIf { it.isNotBlank() } ?: return
        val cache = loadBroadcasterIdCache()
        if (cache[normalizedLogin] == normalizedId) return
        cache[normalizedLogin] = normalizedId
        persistBroadcasterIdCache(cache)
    }

    private fun persistBroadcasterIdCache(cache: Map<String, String>) {
        applicationContext.prefs().edit()
            .putString(BROADCASTER_ID_CACHE_KEY, JSONObject(cache as Map<*, *>).toString())
            .apply()
    }

    private fun Stream.cacheKey(): String {
        return channelId ?: channelLogin ?: id ?: "${channelName.orEmpty()}:${startedAt.orEmpty()}"
    }

    private fun List<Stream>.sortedByViewersDesc(): List<Stream> {
        val name = compareBy<Stream, String>(String.CASE_INSENSITIVE_ORDER) {
            it.channelName ?: it.channelLogin ?: ""
        }
        return sortedWith(compareByDescending<Stream> { it.viewerCount ?: 0 }.then(name))
    }

    private fun hasUsableThumbnail(url: String?): Boolean {
        val resolved = url?.takeIf { it.isNotBlank() }
            ?.let { KickApiHelper.getTemplateUrl(it, "video") }
            ?: return false
        return !resolved.contains("://stream.kick.com/", ignoreCase = true) &&
            !resolved.startsWith("https://files.kick.com/images/default-thumbnail", ignoreCase = true)
    }

    private fun isNetworkDebugEnabled(): Boolean {
        return applicationContext.prefs().getBoolean(C.DEBUG_NETWORK_LOGS, false)
    }

    private fun debugInfo(message: String) {
        if (isNetworkDebugEnabled()) Log.i(TAG, message)
    }

    private fun debugWarn(message: String) {
        if (isNetworkDebugEnabled()) Log.w(TAG, message)
    }
}
