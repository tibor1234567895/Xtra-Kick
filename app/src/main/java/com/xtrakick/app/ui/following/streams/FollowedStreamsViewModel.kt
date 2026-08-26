package com.xtrakick.app.ui.following.streams

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
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
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val sortChannelRepository: SortChannelRepository,
    private val json: Json,
) : ViewModel() {

    companion object {
        private const val KICK_BROADCASTER_ID_CACHE_KEY = "kick_broadcaster_id_cache_v1"
        private const val LOG_TAG = "FollowedStreams"
        private const val FOLLOWED_STREAMS_CACHE_KEY = "followed_streams_cache_v1"
        private const val FOLLOWED_STREAMS_CACHE_TTL_MS = 45_000L
        private const val FOLLOWED_STREAMS_BATCH_SIZE = 12
        private const val FOLLOWED_STREAMS_USER_LOOKUP_BATCH_SIZE = 100
        private const val FOLLOWED_STREAMS_LIVESTREAM_BATCH_SIZE = 50
        private const val FOLLOWED_STREAMS_PUBLIC_API_PARALLELISM = 3
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
        fun toStream(): Stream {
            return Stream(
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

    private data class BulkFallbackLoadResult(
        val items: List<Stream>,
        val unresolvedFollows: List<LocalFollowChannel>,
    )

    val sortText = MutableStateFlow<CharSequence?>(null)
    val sort = MutableStateFlow(FollowedStreamsSortDialog.SORT_VIEWERS)

    private val _uiState = MutableStateFlow(FollowedStreamsUiState())
    val uiState: StateFlow<FollowedStreamsUiState> = _uiState.asStateFlow()

    private var refreshJob: Job? = null
    private var refreshGeneration = 0L

    private fun isNetworkDebugEnabled(): Boolean {
        return applicationContext.prefs().getBoolean(AppConstants.DEBUG_NETWORK_LOGS, false)
    }

    private fun logFollowedStreamsInfo(message: String) {
        if (isNetworkDebugEnabled()) {
            Log.i(LOG_TAG, message)
        }
    }

    private fun logFollowedStreamsWarn(message: String) {
        if (isNetworkDebugEnabled()) {
            Log.w(LOG_TAG, message)
        }
    }

    init {
        viewModelScope.launch {
            localFollowsChannel.followsChanged.collect {
                refresh()
            }
        }
    }

    fun initialize() {
        if (sortText.value == null) {
            sortText.value = buildSortText(sort.value)
            viewModelScope.launch {
                val savedSort = sortChannelRepository.getById("followed_streams")?.videoSort
                setSort(savedSort, persist = false)
            }
        }
        if (!_uiState.value.hasLoadedOnce && refreshJob == null) {
            refresh()
        }
    }

    fun setSort(value: String?, persist: Boolean) {
        val normalizedSort = normalizeSort(value)
        sort.value = normalizedSort
        sortText.value = buildSortText(normalizedSort)
        _uiState.value = _uiState.value.copy(items = _uiState.value.items.sortedForFollowedLive())
        if (persist) {
            viewModelScope.launch {
                val item = sortChannelRepository.getById("followed_streams")?.apply {
                    videoSort = normalizedSort
                } ?: SortChannel(
                    id = "followed_streams",
                    videoSort = normalizedSort,
                )
                sortChannelRepository.save(item)
            }
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
                    .onFailure { error -> logFollowedStreamsWarn("Fast followed-live path failed, using fallback: ${error.message}") }
                    .getOrNull()

                fastResult?.items?.forEach { stream ->
                    resolved[stream.cacheKey()] = stream
                }
                if (fastResult != null) {
                    logFollowedStreamsInfo("Fast followed-live path resolved ${fastResult.items.size} items and left ${fastResult.unresolvedFollows.size} for fallback")
                    val sorted = resolved.values.toList().sortedForFollowedLive()
                    kickRepository.prefetchChannelLivestreams(
                        sorted.mapNotNull { it.channelLogin }.take(FOLLOWED_STREAMS_BATCH_SIZE)
                    )
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

                val bulkFallbackResult = runCatching { loadStreamsFromBulkFallback(followsForFallback) }
                    .onFailure { error -> logFollowedStreamsWarn("Bulk followed-live fallback failed, using per-channel fallback: ${error.message}") }
                    .getOrNull()

                bulkFallbackResult?.items?.forEach { stream ->
                    resolved[stream.cacheKey()] = stream
                }
                if (bulkFallbackResult != null) {
                    val sorted = resolved.values.toList().sortedForFollowedLive()
                    kickRepository.prefetchChannelLivestreams(
                        sorted.mapNotNull { it.channelLogin }.take(FOLLOWED_STREAMS_BATCH_SIZE)
                    )
                    updateStateForGeneration(
                        generation = generation,
                        items = sorted,
                        isInitialLoading = false,
                        isRefreshing = bulkFallbackResult.unresolvedFollows.isNotEmpty(),
                        showEmpty = false,
                        hasLoadedOnce = true,
                    )
                }

                val followsForPerChannelFallback = bulkFallbackResult?.unresolvedFollows ?: followsForFallback

                followsForPerChannelFallback.chunked(FOLLOWED_STREAMS_BATCH_SIZE).forEach { batch ->
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
                    applicationContext.prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                    applicationContext.prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
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
        val networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
            logFollowedStreamsInfo("Fast followed-live path skipped: missing auth token")
            return null
        }
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
            logFollowedStreamsInfo("Fast followed-live path skipped: no cached broadcaster ids")
            return null
        }

        val resolved = LinkedHashMap<String, Stream>()

        coroutineScope {
            followsByBroadcasterId.keys
                .chunked(FOLLOWED_STREAMS_LIVESTREAM_BATCH_SIZE)
                .chunked(FOLLOWED_STREAMS_PUBLIC_API_PARALLELISM)
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

        val followsWithCachedBroadcasterIds = followsByBroadcasterId.values.toSet()
        val unresolvedFollows = follows.filter { it !in followsWithCachedBroadcasterIds }
        if (unresolvedFollows.isNotEmpty()) {
            logFollowedStreamsInfo("Fast followed-live path has ${unresolvedFollows.size} follows without cached broadcaster ids")
        }

        return PublicApiLoadResult(
            items = resolved.values.toList().sortedForFollowedLive(),
            unresolvedFollows = unresolvedFollows,
        )
    }

    private suspend fun loadStreamsFromBulkFallback(follows: List<LocalFollowChannel>): BulkFallbackLoadResult? {
        if (follows.isEmpty()) {
            return BulkFallbackLoadResult(emptyList(), emptyList())
        }

        val networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(networkLibrary)
        if (headers[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
            logFollowedStreamsInfo("Bulk followed-live fallback skipped: missing auth token")
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
            logFollowedStreamsInfo("Bulk followed-live fallback skipped: no unresolved logins")
            return BulkFallbackLoadResult(emptyList(), follows)
        }

        val broadcasterIdCache = loadBroadcasterIdCache()
        val followsByBroadcasterId = LinkedHashMap<String, LocalFollowChannel>()
        var cacheChanged = false

        coroutineScope {
            followByLogin.keys
                .chunked(FOLLOWED_STREAMS_USER_LOOKUP_BATCH_SIZE)
                .chunked(FOLLOWED_STREAMS_PUBLIC_API_PARALLELISM)
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
                .chunked(FOLLOWED_STREAMS_LIVESTREAM_BATCH_SIZE)
                .chunked(FOLLOWED_STREAMS_PUBLIC_API_PARALLELISM)
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
        val unresolvedFollows = follows.filter { it !in resolvedFollows }
        if (unresolvedFollows.isNotEmpty()) {
            logFollowedStreamsInfo("Bulk followed-live fallback left ${unresolvedFollows.size} follows for per-channel fallback")
        }

        return BulkFallbackLoadResult(
            items = resolved.values.toList().sortedForFollowedLive(),
            unresolvedFollows = unresolvedFollows,
        )
    }

    private suspend fun loadStreamForFollow(follow: LocalFollowChannel): Stream? {
        val login = follow.userLogin?.takeIf { it.isNotBlank() }
        val id = follow.userId?.takeIf { it.isNotBlank() }
        return when {
            !login.isNullOrBlank() -> {
                val channel = runCatching {
                    kickRepository.getChannel(
                        channelSlug = login,
                        prefetchBadgeCatalog = false,
                    )
                }.getOrNull() ?: return null
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
                val channel = runCatching {
                    kickRepository.getChannel(
                        channelSlug = id,
                        prefetchBadgeCatalog = false,
                    )
                }.getOrNull() ?: return null
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

    private fun com.xtrakick.app.model.kick.api.livestream.Livestream.toUiStream(follow: LocalFollowChannel?): Stream {
        return Stream(
            id = channelId?.toString(),
            source = AppConstants.KICK,
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
        val nameComparator = compareBy<Stream, String>(String.CASE_INSENSITIVE_ORDER) { it.channelName ?: it.channelLogin ?: "" }
        return when (sort.value) {
            FollowedStreamsSortDialog.SORT_VIEWERS_ASC -> sortedWith(
                compareBy<Stream> { it.viewerCount ?: 0 }.then(nameComparator)
            )
            FollowedStreamsSortDialog.SORT_RECENT -> sortedWith(
                compareByDescending<Stream> { it.startedAt ?: "" }.then(nameComparator)
            )
            else -> sortedWith(
                compareByDescending<Stream> { it.viewerCount ?: 0 }.then(nameComparator)
            )
        }
    }

    private fun normalizeSort(value: String?): String {
        return when (value) {
            FollowedStreamsSortDialog.SORT_VIEWERS_ASC,
            FollowedStreamsSortDialog.SORT_RECENT -> value
            else -> FollowedStreamsSortDialog.SORT_VIEWERS
        }
    }

    private fun buildSortText(value: String): CharSequence {
        return applicationContext.getString(
            com.xtrakick.app.R.string.sort_by,
            applicationContext.getString(
                when (normalizeSort(value)) {
                    FollowedStreamsSortDialog.SORT_VIEWERS_ASC -> com.xtrakick.app.R.string.viewers_low
                    FollowedStreamsSortDialog.SORT_RECENT -> com.xtrakick.app.R.string.recent
                    else -> com.xtrakick.app.R.string.viewers_high
                }
            )
        )
    }

    private fun Stream.cacheKey(): String {
        return channelId ?: channelLogin ?: id ?: "${channelName.orEmpty()}:${startedAt.orEmpty()}"
    }

    private fun hasUsableThumbnail(url: String?): Boolean {
        val resolved = url?.takeIf { it.isNotBlank() }
            ?.let { KickApiHelper.getTemplateUrl(it, "video") }
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
        persistBroadcasterIdCache(cache)
        logFollowedStreamsInfo("Cached broadcaster id for $normalizedLogin")
    }

    private fun persistBroadcasterIdCache(cache: Map<String, String>) {
        val encoded = JSONObject(cache as Map<*, *>).toString()
        applicationContext.prefs().edit()
            .putString(KICK_BROADCASTER_ID_CACHE_KEY, encoded)
            .apply()
    }
}
