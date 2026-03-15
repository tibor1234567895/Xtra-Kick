package com.github.andreyasadchy.xtra.ui.following.streams

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.andreyasadchy.xtra.model.ui.LocalFollowChannel
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.TwitchApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONObject

@HiltViewModel
class FollowedStreamsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val json: Json,
) : ViewModel() {

    companion object {
        private const val KICK_BROADCASTER_ID_CACHE_KEY = "kick_broadcaster_id_cache_v1"
        private const val LOG_TAG = "FollowedStreams"
        private const val FOLLOWED_STREAMS_CACHE_KEY = "followed_streams_cache_v1"
        private const val FOLLOWED_STREAMS_CACHE_TTL_MS = 45_000L
        private const val FOLLOWED_STREAMS_BATCH_SIZE = 12
        private const val FOLLOWED_STREAMS_PUBLIC_BATCH_SIZE = 50
    }

    @Serializable
    private data class CachedFollowedStream(
        val id: String? = null,
        val source: String? = null,
        val channelId: String? = null,
        val channelLogin: String? = null,
        val channelName: String? = null,
        val gameId: String? = null,
        val gameSlug: String? = null,
        val gameName: String? = null,
        val title: String? = null,
        val viewerCount: Int? = null,
        val startedAt: String? = null,
        val thumbnailUrl: String? = null,
        val profileImageUrl: String? = null,
    ) {
        fun toStream(): Stream {
            return Stream(
                id = id,
                source = source,
                channelId = channelId,
                channelLogin = channelLogin,
                channelName = channelName,
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
    }

    @Serializable
    private data class FollowedStreamsCachePayload(
        val cachedAt: Long = 0L,
        val items: List<CachedFollowedStream> = emptyList(),
    )

    data class FollowedStreamsUiState(
        val items: List<Stream> = emptyList(),
        val isInitialLoading: Boolean = false,
        val isRefreshing: Boolean = false,
        val showEmpty: Boolean = false,
        val integrityAction: String? = null,
        val hasLoadedOnce: Boolean = false,
    )

    private data class PublicApiLoadResult(
        val items: List<Stream>,
        val unresolvedFollows: List<LocalFollowChannel>,
    )

    val sortText = MutableStateFlow<CharSequence?>(null)

    private val _uiState = MutableStateFlow(FollowedStreamsUiState())
    val uiState: StateFlow<FollowedStreamsUiState> = _uiState.asStateFlow()

    private var refreshJob: Job? = null
    private var refreshGeneration = 0L

    fun initialize() {
        if (sortText.value == null) {
            sortText.value = "${applicationContext.getString(com.github.andreyasadchy.xtra.R.string.source)}: ${applicationContext.getString(com.github.andreyasadchy.xtra.R.string.local)}"
        }
        if (!_uiState.value.hasLoadedOnce && refreshJob == null) {
            refresh()
        }
    }

    fun refresh() {
        val generation = ++refreshGeneration
        refreshJob?.cancel()

        val cachedItems = loadFreshCache()
        val currentState = _uiState.value
        val currentItems = when {
            cachedItems.isNotEmpty() -> cachedItems
            currentState.items.isNotEmpty() -> currentState.items
            else -> emptyList()
        }

        _uiState.value = currentState.copy(
            items = currentItems,
            isInitialLoading = currentItems.isEmpty(),
            isRefreshing = currentItems.isNotEmpty(),
            showEmpty = false,
            integrityAction = null,
            hasLoadedOnce = currentState.hasLoadedOnce || currentItems.isNotEmpty(),
        )

        refreshJob = viewModelScope.launch {
            try {
                val follows = localFollowsChannel.loadFollows()
                val resolved = LinkedHashMap<String, Stream>()
                if (follows.isEmpty()) {
                    updateStateForGeneration(
                        generation = generation,
                        items = emptyList(),
                        isInitialLoading = false,
                        isRefreshing = false,
                        showEmpty = true,
                        hasLoadedOnce = true,
                    )
                    persistCache(emptyList())
                    return@launch
                }

                val fastResult = runCatching { loadStreamsFromPublicApi(follows) }
                    .onFailure { error -> Log.w(LOG_TAG, "Fast followed-live path failed, using fallback: ${error.message}") }
                    .getOrNull()

                fastResult?.items?.forEach { stream ->
                    resolved[stream.cacheKey()] = stream
                }
                if (fastResult != null) {
                    Log.i(LOG_TAG, "Fast followed-live path resolved ${fastResult.items.size} items and left ${fastResult.unresolvedFollows.size} for fallback")
                    val sorted = resolved.values.toList().sortedForFollowedLive()
                    updateStateForGeneration(
                        generation = generation,
                        items = sorted,
                        isInitialLoading = false,
                        isRefreshing = fastResult.unresolvedFollows.isNotEmpty(),
                        showEmpty = false,
                        hasLoadedOnce = true,
                    )
                }

                val followsForFallback = fastResult?.unresolvedFollows ?: follows

                followsForFallback.chunked(FOLLOWED_STREAMS_BATCH_SIZE).forEach { batch ->
                    ensureActive()
                    val batchResults = coroutineScope {
                        batch.map { follow ->
                            async {
                                loadStreamForFollow(follow)
                            }
                        }
                    }.mapNotNull { it.await() }

                    batchResults.forEach { stream ->
                        resolved[stream.cacheKey()] = stream
                    }

                    val sorted = resolved.values.toList().sortedForFollowedLive()
                    updateStateForGeneration(
                        generation = generation,
                        items = sorted,
                        isInitialLoading = false,
                        isRefreshing = true,
                        showEmpty = false,
                        hasLoadedOnce = true,
                    )
                }

                val finalItems = resolved.values.toList().sortedForFollowedLive()
                persistCache(finalItems)
                updateStateForGeneration(
                    generation = generation,
                    items = finalItems,
                    isInitialLoading = false,
                    isRefreshing = false,
                    showEmpty = finalItems.isEmpty(),
                    hasLoadedOnce = true,
                )
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                val isIntegrityFailure = e.message == "failed integrity check" &&
                    applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false) &&
                    applicationContext.prefs().getBoolean(C.USE_WEBVIEW_INTEGRITY, true)
                val fallbackItems = _uiState.value.items
                updateStateForGeneration(
                    generation = generation,
                    items = fallbackItems,
                    isInitialLoading = false,
                    isRefreshing = false,
                    showEmpty = fallbackItems.isEmpty(),
                    integrityAction = if (isIntegrityFailure) "refresh" else null,
                    hasLoadedOnce = true,
                )
            } finally {
                if (refreshGeneration == generation) {
                    refreshJob = null
                }
            }
        }
    }

    fun clearIntegrityAction() {
        _uiState.value = _uiState.value.copy(integrityAction = null)
    }

    private suspend fun loadStreamsFromPublicApi(follows: List<LocalFollowChannel>): PublicApiLoadResult? {
        val headers = TwitchApiHelper.getHelixHeaders(applicationContext)
        if (headers[C.HEADER_TOKEN].isNullOrBlank()) {
            Log.i(LOG_TAG, "Fast followed-live path skipped: missing auth token")
            return null
        }
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val broadcasterIdsByLogin = loadBroadcasterIdCache()
        val followsByBroadcasterId = follows
            .mapNotNull { follow ->
                follow.userLogin
                    ?.takeIf { it.isNotBlank() }
                    ?.lowercase()
                    ?.let { login -> broadcasterIdsByLogin[login]?.let { broadcasterId -> broadcasterId to follow } }
            }
            .toMap()
        if (followsByBroadcasterId.isEmpty()) {
            Log.i(LOG_TAG, "Fast followed-live path skipped: no cached broadcaster ids")
            return null
        }

        val resolved = LinkedHashMap<String, Stream>()

        followsByBroadcasterId.keys.chunked(FOLLOWED_STREAMS_PUBLIC_BATCH_SIZE).forEach { ids ->
            val response = helixRepository.getLivestreams(
                networkLibrary = networkLibrary,
                headers = headers,
                broadcasterUserIds = ids,
                categoryId = null,
                language = null,
                limit = ids.size,
                sort = "viewer_count",
            )
            response.data.forEach { stream ->
                val follow = stream.broadcasterUserId?.toString()?.let(followsByBroadcasterId::get)
                val mapped = stream.toUiStream(follow)
                resolved[mapped.cacheKey()] = mapped
            }
        }

        val followsWithCachedBroadcasterIds = followsByBroadcasterId.values.toSet()
        val unresolvedFollows = follows.filter { it !in followsWithCachedBroadcasterIds }
        if (unresolvedFollows.isNotEmpty()) {
            Log.i(LOG_TAG, "Fast followed-live path has ${unresolvedFollows.size} follows without cached broadcaster ids")
        }

        return PublicApiLoadResult(
            items = resolved.values.toList().sortedForFollowedLive(),
            unresolvedFollows = unresolvedFollows,
        )
    }

    private suspend fun loadStreamForFollow(follow: LocalFollowChannel): Stream? {
        val login = follow.userLogin?.takeIf { it.isNotBlank() }
        val id = follow.userId?.takeIf { it.isNotBlank() }
        return when {
            !login.isNullOrBlank() -> {
                val channel = runCatching { kickRepository.getChannel(login) }.getOrNull() ?: return null
                rememberBroadcasterId(channel.slug ?: login, channel.userId?.toString() ?: channel.user?.id?.toString())
                val livestream = channel.livestream ?: return null
                val enrichedLivestream = if (
                    !hasUsableThumbnail(livestream.thumbnail?.imageUrl) ||
                    livestream.category == null
                ) {
                    runCatching { kickRepository.getChannelLivestream(login, forceRefresh = true) }.getOrNull() ?: livestream
                } else {
                    livestream
                }
                kickRepository.toStream(channel, enrichedLivestream)
            }
            !id.isNullOrBlank() -> {
                val channel = runCatching { kickRepository.getChannel(id) }.getOrNull() ?: return null
                rememberBroadcasterId(channel.slug, channel.userId?.toString() ?: channel.user?.id?.toString())
                val livestream = channel.livestream ?: return null
                val livestreamLogin = channel.slug?.takeIf { it.isNotBlank() }
                val enrichedLivestream = if (
                    livestreamLogin != null &&
                    (!hasUsableThumbnail(livestream.thumbnail?.imageUrl) || livestream.category == null)
                ) {
                    runCatching { kickRepository.getChannelLivestream(livestreamLogin, forceRefresh = true) }.getOrNull() ?: livestream
                } else {
                    livestream
                }
                kickRepository.toStream(channel, enrichedLivestream)
            }
            else -> null
        }
    }

    private fun com.github.andreyasadchy.xtra.model.helix.livestream.Livestream.toUiStream(follow: LocalFollowChannel?): Stream {
        return Stream(
            id = channelId?.toString(),
            source = C.KICK,
            channelId = broadcasterUserId?.toString() ?: follow?.userId,
            channelLogin = slug ?: follow?.userLogin,
            channelName = follow?.userName ?: slug,
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

    private fun loadFreshCache(): List<Stream> {
        val payload = applicationContext.prefs().getString(FOLLOWED_STREAMS_CACHE_KEY, null)
            ?.let { encoded ->
                runCatching { json.decodeFromString<FollowedStreamsCachePayload>(encoded) }.getOrNull()
            }
            ?: return emptyList()
        val now = System.currentTimeMillis()
        if (now - payload.cachedAt > FOLLOWED_STREAMS_CACHE_TTL_MS) {
            return emptyList()
        }
        return payload.items.map { it.toStream() }.sortedForFollowedLive()
    }

    private fun persistCache(items: List<Stream>) {
        val payload = FollowedStreamsCachePayload(
            cachedAt = System.currentTimeMillis(),
            items = items.map {
                CachedFollowedStream(
                    id = it.id,
                    source = it.source,
                    channelId = it.channelId,
                    channelLogin = it.channelLogin,
                    channelName = it.channelName,
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
            .putString(FOLLOWED_STREAMS_CACHE_KEY, json.encodeToString(payload))
            .apply()
    }

    private fun updateStateForGeneration(
        generation: Long,
        items: List<Stream>,
        isInitialLoading: Boolean,
        isRefreshing: Boolean,
        showEmpty: Boolean,
        integrityAction: String? = _uiState.value.integrityAction,
        hasLoadedOnce: Boolean,
    ) {
        if (refreshGeneration != generation) return
        _uiState.value = _uiState.value.copy(
            items = items,
            isInitialLoading = isInitialLoading,
            isRefreshing = isRefreshing,
            showEmpty = showEmpty,
            integrityAction = integrityAction,
            hasLoadedOnce = hasLoadedOnce,
        )
    }

    private fun List<Stream>.sortedForFollowedLive(): List<Stream> {
        return this.sortedWith(
            compareByDescending<Stream> { it.viewerCount ?: 0 }
                .thenBy(String.CASE_INSENSITIVE_ORDER) { it.channelName ?: it.channelLogin ?: "" }
        )
    }

    private fun Stream.cacheKey(): String {
        return channelId ?: channelLogin ?: id ?: "${channelName.orEmpty()}:${startedAt.orEmpty()}"
    }

    private fun hasUsableThumbnail(url: String?): Boolean {
        val resolved = url?.takeIf { it.isNotBlank() }
            ?.let { TwitchApiHelper.getTemplateUrl(it, "video") }
            ?: return false
        return !resolved.contains("://stream.kick.com/", ignoreCase = true) &&
            !resolved.startsWith("https://files.kick.com/images/default-thumbnail", ignoreCase = true)
    }

    private fun loadBroadcasterIdCache(): MutableMap<String, String> {
        val raw = applicationContext.prefs().getString(KICK_BROADCASTER_ID_CACHE_KEY, null)
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
        val encoded = JSONObject(cache as Map<*, *>).toString()
        applicationContext.prefs().edit()
            .putString(KICK_BROADCASTER_ID_CACHE_KEY, encoded)
            .apply()
        Log.i(LOG_TAG, "Cached broadcaster id for $normalizedLogin")
    }
}
