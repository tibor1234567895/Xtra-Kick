package com.xtrakick.app.repository

import android.content.Context
import android.util.Log
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Shared loader for "Following → Live".
 *
 * Fast path: batched Public API livestream lookups (by broadcaster id).
 * Fallback: batched user-id resolve + livestreams.
 * Last resort (optional): per-channel Kick web API — avoid for MultiPOV picker.
 *
 * Cache is shared with [com.xtrakick.app.ui.following.streams.FollowedStreamsViewModel]
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
        // /public/v1/livestreams caps broadcaster_user_id params at 50 per request (400 above).
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
        val account: String? = null,
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
        val account = accountKey()
        fun publish(items: List<Stream>) {
            if (account != accountKey()) throw CancellationException("Following account changed")
            onPartial(items)
        }
        val observedGeneration = loadGeneration
        return loadMutex.withLock {
            if ((!forceRefresh || observedGeneration != loadGeneration) &&
                (!allowPerChannelFallback || lastLoadAllowedFallback)
            ) {
                freshCache()?.let {
                    publish(it)
                    return@withLock LoadResult(it, true)
                }
            }
            loadLiveFollowedUncached(allowPerChannelFallback, account, ::publish).also {
                lastLoadAllowedFallback = allowPerChannelFallback
                loadGeneration++
            }
        }
    }

    private val loadMutex = Mutex()
    @Volatile private var loadGeneration = 0L
    private var lastLoadAllowedFallback = false

    private suspend fun loadLiveFollowedUncached(
        allowPerChannelFallback: Boolean,
        account: String,
        onPartial: (List<Stream>) -> Unit,
    ): LoadResult {

        val follows = localFollowsChannel.loadFollows()
        if (follows.isEmpty()) {
            persistCache(emptyList(), account)
            onPartial(emptyList())
            return LoadResult(items = emptyList(), fromCache = false)
        }

        val resolved = LinkedHashMap<String, Stream>()

        fun putStream(stream: Stream) {
            val key = stream.cacheKey()
            val existing = resolved[key]
            resolved[key] = if (existing != null) {
                Stream(
                    id = existing.id ?: stream.id,
                    source = existing.source ?: stream.source,
                    channelId = existing.channelId ?: stream.channelId,
                    channelLogin = existing.channelLogin ?: stream.channelLogin,
                    channelName = existing.channelName ?: stream.channelName,
                    playbackUrl = existing.playbackUrl ?: stream.playbackUrl,
                    gameId = existing.gameId ?: stream.gameId,
                    gameSlug = existing.gameSlug ?: stream.gameSlug,
                    gameName = existing.gameName ?: stream.gameName,
                    title = existing.title ?: stream.title,
                    viewerCount = stream.viewerCount ?: existing.viewerCount,
                    startedAt = existing.startedAt ?: stream.startedAt,
                    thumbnailUrl = existing.thumbnailUrl?.takeIf { hasUsableThumbnail(it) } ?: stream.thumbnailUrl,
                    profileImageUrl = existing.profileImageUrl ?: stream.profileImageUrl,
                    tags = existing.tags ?: stream.tags,
                    user = existing.user ?: stream.user,
                )
            } else {
                stream
            }
        }

        var sawRateLimit = false
        val isRateLimitMessage = { message: String? -> message?.contains("429", ignoreCase = true) == true }

        var officialLiveSucceeded = false
        if (kickRepository.hasKickAccountFollowCapability()) {
            try {
                val officialLive = kickRepository.getUserLiveFollowedStreams()
                officialLive.forEach(::putStream)
                val liveLogins = officialLive.mapNotNull { it.channelLogin?.trim()?.lowercase(Locale.ROOT) }
                if (liveLogins.isNotEmpty()) {
                    localFollowsChannel.markKickFollows(liveLogins, notify = false)
                }
                if (officialLive.isNotEmpty()) {
                    onPartial(resolved.values.toList().sortedByViewersDesc())
                }
                officialLiveSucceeded = true
            } catch (error: CancellationException) {
                throw error
            } catch (error: Exception) {
                diagnosticWarn("Official followed-live path failed: ${failureDetail(error)}")
            }
        }

        val alreadyResolvedLogins = hashSetOf<String>()
        val alreadyResolvedIds = hashSetOf<String>()
        for (stream in resolved.values) {
            stream.channelLogin?.trim()?.lowercase(Locale.ROOT)?.let(alreadyResolvedLogins::add)
            stream.channelId?.trim()?.let(alreadyResolvedIds::add)
        }
        val unresolvedFollows = follows.filter { follow ->
            // If the official web session path succeeded, Kick follows were already checked;
            // only local-only follows still need resolution. If the official path failed (e.g.
            // 401 on an OAuth session or network error), all follows need resolution.
            if (officialLiveSucceeded && !follow.isLocalOnlyFollow) return@filter false
            val login = follow.userLogin?.trim()?.lowercase(Locale.ROOT)
            val id = follow.userId?.trim()
            (login == null || login !in alreadyResolvedLogins) && (id == null || id !in alreadyResolvedIds)
        }
        // Google mobile-login sessions hold a mobile-gateway token that api.kick.com's
        // OAuth-armed public API always rejects with 401 — skip those arms instead of
        // burning two guaranteed-failed calls per refresh.
        val googleSession = AuthStateHelper.isKickGoogleSession(applicationContext)
        val fast = if (googleSession) {
            null
        } else try {
            if (unresolvedFollows.isEmpty()) null else loadFromPublicApi(unresolvedFollows)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            if (isRateLimitMessage(error.message)) sawRateLimit = true
            diagnosticWarn("Fast followed-live path failed: ${failureDetail(error)}")
            null
        }
        fast?.items?.forEach(::putStream)
        if (fast != null && resolved.isNotEmpty()) {
            onPartial(resolved.values.toList().sortedByViewersDesc())
        }

        val unresolvedAfterFast = fast?.unresolved ?: unresolvedFollows
        val bulk = if (googleSession) {
            null
        } else try {
            loadFromBulkFallback(unresolvedAfterFast)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            if (isRateLimitMessage(error.message)) sawRateLimit = true
            diagnosticWarn("Bulk followed-live fallback failed: ${failureDetail(error)}")
            null
        }
        bulk?.items?.forEach(::putStream)
        if (bulk != null && bulk.items.isNotEmpty()) {
            onPartial(resolved.values.toList().sortedByViewersDesc())
        }

        val unresolvedAfterBulk = bulk?.unresolved ?: unresolvedAfterFast
        if (allowPerChannelFallback && unresolvedAfterBulk.isNotEmpty()) {
            if (sawRateLimit || (!googleSession && resolved.isNotEmpty() && unresolvedAfterBulk.size > 6)) {
                diagnosticWarn("Skipping per-channel fallback: kick API is rate limiting")
            } else {
                unresolvedAfterBulk.take(20).chunked(PER_CHANNEL_BATCH_SIZE).forEach { batch ->
                    currentCoroutineContext().ensureActive()
                    val batchResults = coroutineScope {
                        batch.map { follow ->
                            async { loadStreamForFollow(follow) }
                        }.awaitAll()
                    }.filterNotNull()
                    batchResults.forEach(::putStream)
                    if (batchResults.isNotEmpty()) {
                        onPartial(resolved.values.toList().sortedByViewersDesc())
                    }
                }
            }
        }

        val finalItems = resolved.values.toList().sortedByViewersDesc()
        persistCache(finalItems, account)
        onPartial(finalItems)
        return LoadResult(items = finalItems, fromCache = false)
    }

    fun peekCache(maxAgeMs: Long = CACHE_TTL_MS): List<Stream> = freshCache(maxAgeMs).orEmpty()

    private fun accountKey(): String = applicationContext.tokenPrefs().getString(AppConstants.KICK_USER_ID, null).orEmpty()

    private fun freshCache(maxAgeMs: Long = CACHE_TTL_MS): List<Stream>? {
        val payload = applicationContext.prefs().getString(CACHE_KEY, null)
            ?.let { encoded -> runCatching { json.decodeFromString<CachePayload>(encoded) }.getOrNull() }
            ?: return null
        if (payload.account != accountKey() || System.currentTimeMillis() - payload.cachedAt > maxAgeMs) return null
        return payload.items.map { it.toStream() }.sortedByViewersDesc()
    }

    private data class PartialResult(
        val items: List<Stream>,
        val unresolved: List<LocalFollowChannel>,
    )

    private suspend fun loadFromPublicApi(follows: List<LocalFollowChannel>): PartialResult? {
        val networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
            diagnosticWarn("Fast path skipped: missing auth token")
            return null
        }
        val broadcasterIdsByLogin = loadBroadcasterIdCache()
        var cacheChanged = false
        val followsByBroadcasterId = follows
            .mapNotNull { follow ->
                val login = follow.userLogin?.takeIf { it.isNotBlank() }?.lowercase(Locale.ROOT)
                val followUserId = follow.userId?.trim()?.takeIf { it.isNotBlank() && it.all(Char::isDigit) }
                val resolvedId = followUserId ?: login?.let { broadcasterIdsByLogin[it] }
                if (login != null && resolvedId != null && broadcasterIdsByLogin[login] != resolvedId) {
                    broadcasterIdsByLogin[login] = resolvedId
                    cacheChanged = true
                }
                resolvedId?.let { id -> id to follow }
            }
            .toMap()
        if (cacheChanged) {
            persistBroadcasterIdCache(broadcasterIdsByLogin)
        }
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

        val networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
            diagnosticWarn("Bulk fallback skipped: missing auth token")
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

        followByLogin.forEach { (login, follow) ->
            val cachedId = broadcasterIdCache[login]
            val followUserId = follow.userId?.trim()?.takeIf { it.isNotBlank() && it.all(Char::isDigit) }
            val resolvedId = followUserId ?: cachedId
            if (resolvedId != null) {
                followsByBroadcasterId[resolvedId] = follow
                if (broadcasterIdCache[login] != resolvedId) {
                    broadcasterIdCache[login] = resolvedId
                    cacheChanged = true
                }
            }
        }

        val loginsToFetch = followByLogin.keys.filter { login ->
            broadcasterIdCache[login] == null
        }

        if (loginsToFetch.isNotEmpty()) {
            coroutineScope {
                loginsToFetch
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

    private fun com.xtrakick.app.model.kick.api.livestream.Livestream.toUiStream(
        follow: LocalFollowChannel?,
    ): Stream {
        val catId = category?.id?.toString()
        val catName = category?.name
        return Stream(
            id = null,
            source = AppConstants.KICK,
            channelId = broadcasterUserId?.toString() ?: follow?.userId ?: channelId?.toString(),
            channelLogin = slug ?: follow?.userLogin,
            channelName = follow?.userName ?: slug,
            playbackUrl = null,
            gameId = catId,
            gameSlug = kickRepository.getOrInferCachedCategorySlug(catId, catName),
            gameName = catName,
            title = streamTitle,
            viewerCount = viewerCount,
            startedAt = startedAt,
            thumbnailUrl = thumbnail,
            profileImageUrl = profilePicture ?: follow?.channelLogo,
            tags = customTags,
        )
    }

    private fun persistCache(items: List<Stream>, account: String) {
        if (account != accountKey()) throw CancellationException("Following account changed")
        val payload = CachePayload(
            account = account,
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
        val slug = channelLogin?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotEmpty() }
        if (slug != null) return "slug:$slug"
        val chId = channelId?.trim()?.takeIf { it.isNotEmpty() }
        if (chId != null) return "id:$chId"
        val stId = id?.trim()?.takeIf { it.isNotEmpty() }
        if (stId != null) return "stream:$stId"
        return "${channelName.orEmpty().trim().lowercase(Locale.ROOT)}:${startedAt.orEmpty()}"
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
        return applicationContext.prefs().getBoolean(AppConstants.DEBUG_NETWORK_LOGS, false)
    }

    private fun debugInfo(message: String) {
        if (isNetworkDebugEnabled()) Log.i(TAG, message)
    }

    // Failure-path warnings always reach the diagnostic export (rare events, worth the
    // rotation budget); failureDetail keeps messages compact and secret-free.
    private fun diagnosticWarn(message: String) {
        DiagnosticLogger.w(TAG, message.take(200))
    }

    private fun failureDetail(error: Exception): String {
        return error.message?.substringBefore("JSON input:")?.take(200)
            ?: error.javaClass.simpleName
    }
}
