package com.xtrakick.app.ui.multipov

import android.content.Context
import android.content.SharedPreferences
import android.os.SystemClock
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.FollowedLiveStreamsRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebsiteSearchMapper
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.net.ssl.X509TrustManager

enum class MultiPovPickerMode {
    /** Live channels from the user's followed list (default when search is empty). */
    FollowedLive,
    /** Top live streams across Kick (shown when no followed channels are currently live). */
    TopLive,
    /** Kick website search results. */
    Search,
}

@HiltViewModel
class MultiPovViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kickRepository: KickRepository,
    private val followedLiveStreamsRepository: FollowedLiveStreamsRepository,
    private val trustManager: X509TrustManager?,
) : ViewModel() {

    private var sessionPrefs: SharedPreferences? = null

    private val _uiState = MutableStateFlow(MultiPovUiState())
    val uiState: StateFlow<MultiPovUiState> = _uiState.asStateFlow()

    private val resolveJobs = mutableMapOf<String, Job>()
    /** Rate-limit force network resolves per slot (except explicit user Retry). */
    private val lastForceResolveAtMs = mutableMapOf<String, Long>()
    private val _pickerResults = MutableStateFlow<List<Stream>>(emptyList())
    val pickerResults: StateFlow<List<Stream>> = _pickerResults.asStateFlow()
    private val _pickerLoading = MutableStateFlow(false)
    val pickerLoading: StateFlow<Boolean> = _pickerLoading.asStateFlow()
    private val _pickerMode = MutableStateFlow(MultiPovPickerMode.FollowedLive)
    val pickerMode: StateFlow<MultiPovPickerMode> = _pickerMode.asStateFlow()
    private var pickerJob: Job? = null
    private var offlinePollJob: Job? = null

    fun initialize(
        streams: List<Stream>,
        resolvedUrls: Map<String, String> = emptyMap(),
        focusedKey: String? = null,
        streamQuality: MultiPovQuality = MultiPovQuality.SOURCE,
        bandwidthSaving: Boolean = false,
        maxStreams: Int = AppConstants.MULTIPOV_MAX_STREAMS_DEFAULT,
        prefs: SharedPreferences? = null,
    ) {
        sessionPrefs = prefs ?: sessionPrefs
        if (_uiState.value.slots.isNotEmpty()) {
            persistSession()
            return
        }
        val slots = streams
            .distinctBy { it.multiPovKey() }
            .take(maxStreams)
            .mapIndexed { index, stream ->
                val key = stream.multiPovKey()
                // Prefer trusted URLs, but seed any non-blank URL so Exo can start immediately.
                val candidate = pickPlaybackCandidate(resolvedUrls[key], stream.playbackUrl)
                MultiPovSlot(
                    key = key,
                    stream = stream,
                    resolvedUrl = candidate,
                    isFocused = focusedKey?.let { it == key } ?: (index == 0),
                    loadState = MultiPovLoadState.Loading,
                )
            }
        val focus = slots.firstOrNull { it.isFocused }?.key ?: slots.firstOrNull()?.key
        _uiState.value = MultiPovUiState(
            slots = slots.map { it.copy(isFocused = it.key == focus) },
            focusedKey = focus,
            streamQuality = streamQuality,
            bandwidthSaving = bandwidthSaving,
            maxStreams = maxStreams,
        )
        // Resolve only when needed: missing/untrusted URL. Never blanket force-refresh all slots.
        slots.forEach { slot ->
            val url = slot.resolvedUrl
            val needsNetwork = url.isNullOrBlank() || !isTrustedKickPlaybackUrl(url)
            resolveIfNeeded(slot.key, forceRefresh = needsNetwork, userInitiated = needsNetwork)
        }
        startOfflinePolling()
        persistSession()
    }

    fun setControlsVisible(visible: Boolean) {
        _uiState.update { it.copy(isControlsVisible = visible) }
    }

    fun setFocus(key: String) {
        _uiState.update { state ->
            if (state.slots.none { it.key == key }) return@update state
            state.copy(
                focusedKey = key,
                slots = state.slots.map { it.copy(isFocused = it.key == key) },
            )
        }
        persistSession()
    }

    /**
     * Rotate slot order so a different stream sits in the "primary" (first) seat.
     * Layout presets that enlarge the primary tile use this order.
     */
    fun rotateSlotOrder() {
        _uiState.update { state ->
            if (state.slots.size < 2) return@update state
            val rotated = listOf(state.slots.last()) + state.slots.dropLast(1)
            state.copy(
                slots = rotated.map { it.copy(isFocused = it.key == state.focusedKey) },
            )
        }
        persistSession()
    }

    /** Move [key] to the primary (first) seat without changing focus audio unless requested. */
    fun moveSlotToPrimary(key: String, alsoFocus: Boolean = true) {
        _uiState.update { state ->
            val target = state.slots.firstOrNull { it.key == key } ?: return@update state
            val rest = state.slots.filterNot { it.key == key }
            val nextFocus = if (alsoFocus) key else state.focusedKey
            state.copy(
                focusedKey = nextFocus,
                slots = (listOf(target) + rest).map { it.copy(isFocused = it.key == nextFocus) },
            )
        }
        persistSession()
    }

    fun setStreamQuality(quality: MultiPovQuality) {
        _uiState.update { it.copy(streamQuality = quality) }
        persistSession()
    }

    fun setBandwidthSaving(enabled: Boolean) {
        _uiState.update { it.copy(bandwidthSaving = enabled) }
        sessionPrefs?.edit()?.putBoolean(AppConstants.MULTIPOV_BANDWIDTH_SAVING, enabled)?.apply()
        persistSession()
    }

    fun toggleBandwidthSaving(): Boolean {
        val next = !_uiState.value.bandwidthSaving
        setBandwidthSaving(next)
        return next
    }

    fun updateLoadState(key: String, loadState: MultiPovLoadState) {
        if (loadState is MultiPovLoadState.Ready) {
            httpErrorAttempts.remove(key)
        }
        // Skip no-op emissions (BUFFERING↔BUFFERING) so render doesn't thrash every rebuffer tick.
        val current = _uiState.value.slots.firstOrNull { it.key == key }?.loadState
        if (current == loadState) return
        _uiState.update { state ->
            state.copy(
                slots = state.slots.map { slot ->
                    if (slot.key == key) slot.copy(loadState = loadState) else slot
                }
            )
        }
    }

    fun addStream(stream: Stream, resolvedUrl: String? = null): Boolean {
        val key = stream.multiPovKey()
        val state = _uiState.value
        if (state.slots.any { it.key == key || it.stream.sameChannelAs(stream) }) return true
        if (!state.canAdd) return false
        val candidate = pickPlaybackCandidate(resolvedUrl, stream.playbackUrl)
        val slot = MultiPovSlot(
            key = key,
            stream = stream,
            resolvedUrl = candidate,
            isFocused = state.slots.isEmpty(),
            loadState = MultiPovLoadState.Loading,
        )
        val nextSlots = state.slots + slot
        val focus = state.focusedKey ?: key
        _uiState.value = state.copy(
            slots = nextSlots.map { it.copy(isFocused = it.key == focus) },
            focusedKey = focus,
        )
        // Play candidate immediately if present; network resolve only if missing/untrusted.
        val needsNetwork = candidate.isNullOrBlank() || !isTrustedKickPlaybackUrl(candidate)
        resolveIfNeeded(key, forceRefresh = needsNetwork, userInitiated = needsNetwork)
        startOfflinePolling()
        persistSession()
        return true
    }

    private fun pickPlaybackCandidate(vararg urls: String?): String? {
        val nonBlank = urls.mapNotNull { it?.takeIf { u -> u.isNotBlank() } }
        return nonBlank.firstOrNull { isTrustedKickPlaybackUrl(it) } ?: nonBlank.firstOrNull()
    }

    private val httpErrorAttempts = mutableMapOf<String, Int>()

    /**
     * Kick search sometimes returns a bare IVS master without a token query
     * (`.../api/video/v1/...channel.XXX.m3u8`) which 403s under ExoPlayer.
     * Real channel API URLs look the same host/path but include `?token=...` — those are OK.
     * Also accept signed CloudFront/playlist paths under `/v1/playlist/`.
     */
    fun isPlayableUrl(url: String?): Boolean = !url.isNullOrBlank() && isTrustedKickPlaybackUrl(url)

    private fun isTrustedKickPlaybackUrl(url: String): Boolean {
        if (url.isBlank()) return false
        val lower = url.lowercase()
        val hasToken = lower.contains("token=") ||
            lower.contains("policy=") ||
            lower.contains("signature=")
        if (lower.contains("/api/video/v1/") && lower.contains("channel.") && !hasToken) {
            return false
        }
        if (lower.contains("playback.live-video.net") &&
            !lower.contains("/v1/playlist/") &&
            !hasToken &&
            !lower.contains('?')
        ) {
            return false
        }
        return true
    }

    fun onPlaybackHttpError(key: String, responseCode: Int, failedUrl: String?) {
        if (responseCode != 403 && responseCode != 404) return
        val attempts = (httpErrorAttempts[key] ?: 0) + 1
        httpErrorAttempts[key] = attempts
        if (attempts > 2) {
            updateLoadState(
                key,
                MultiPovLoadState.Error("Playback blocked (HTTP $responseCode). Tap Retry."),
            )
            return
        }
        val slot = _uiState.value.slots.firstOrNull { it.key == key } ?: return
        // Drop the failing URL so we don't keep restarting the same 403 source.
        if (!failedUrl.isNullOrBlank() && slot.resolvedUrl == failedUrl) {
            _uiState.update { state ->
                state.copy(
                    slots = state.slots.map {
                        if (it.key == key) it.copy(resolvedUrl = null, loadState = MultiPovLoadState.Loading) else it
                    }
                )
            }
        }
        // Cooldown-aware force refresh (not unlimited).
        resolveIfNeeded(key, forceRefresh = true, stalePlaybackUrl = failedUrl, userInitiated = false)
    }

    fun removeStream(key: String) {
        resolveJobs.remove(key)?.cancel()
        httpErrorAttempts.remove(key)
        lastForceResolveAtMs.remove(key)
        _uiState.update { state ->
            val remaining = state.slots.filterNot { it.key == key }
            val focus = when {
                remaining.isEmpty() -> null
                state.focusedKey == key -> remaining.first().key
                else -> state.focusedKey
            }
            state.copy(
                slots = remaining.map { it.copy(isFocused = it.key == focus) },
                focusedKey = focus,
            )
        }
        if (_uiState.value.slots.isEmpty()) {
            offlinePollJob?.cancel()
            offlinePollJob = null
            sessionPrefs?.let { MultiPovSessionStore.clear(it) }
        } else {
            persistSession()
        }
    }

    fun clearPersistedSession() {
        sessionPrefs?.let { MultiPovSessionStore.clear(it) }
    }

    private fun persistSession() {
        val prefs = sessionPrefs ?: return
        MultiPovSessionStore.save(prefs, _uiState.value)
    }

    fun resolveIfNeeded(
        key: String,
        forceRefresh: Boolean = false,
        stalePlaybackUrl: String? = null,
        userInitiated: Boolean = false,
    ) {
        val slot = _uiState.value.slots.firstOrNull { it.key == key } ?: return
        val existingUrl = slot.resolvedUrl
        // Never re-enter while a resolve is already running (render / poll spam guard).
        if (resolveJobs[key]?.isActive == true) {
            return
        }
        if (!forceRefresh && !existingUrl.isNullOrBlank() && isTrustedKickPlaybackUrl(existingUrl)) {
            return
        }
        // Rate-limit automatic force network hits hard. User Retry bypasses cooldown.
        if (forceRefresh && !userInitiated) {
            val last = lastForceResolveAtMs[key]
            if (last != null && SystemClock.elapsedRealtime() - last < FORCE_RESOLVE_COOLDOWN_MS) {
                if (existingUrl.isNullOrBlank()) {
                    updateLoadState(key, MultiPovLoadState.Error("Playback retry cooling down. Tap Retry."))
                }
                return
            }
        }
        val channelLogin = slot.stream.channelLogin?.takeIf { it.isNotBlank() }
            ?: slot.stream.channelName?.takeIf { it.isNotBlank() }
        if (channelLogin.isNullOrBlank()) {
            if (existingUrl.isNullOrBlank()) {
                updateLoadState(key, MultiPovLoadState.Error("Missing channel login"))
            }
            return
        }
        if (forceRefresh) {
            lastForceResolveAtMs[key] = SystemClock.elapsedRealtime()
        }
        resolveJobs[key] = viewModelScope.launch {
            if (existingUrl.isNullOrBlank()) {
                updateLoadState(key, MultiPovLoadState.Loading)
            }
            try {
                // Single network path — no double getChannel + getChannelLivestream spam.
                val url = resolveKickLiveUrl(
                    channelLogin = channelLogin,
                    forceRefresh = forceRefresh && (userInitiated || existingUrl.isNullOrBlank()),
                )?.takeIf { it != stalePlaybackUrl }
                if (url == null) {
                    // Kick answered with no playable stream — distinguish an
                    // offline channel from a failed refresh.
                    val channelOffline = runCatching {
                        kickRepository.getChannelLivestream(channelLogin, forceRefresh = true)
                    }.getOrNull() == null
                    if (channelOffline) {
                        httpErrorAttempts.remove(key)
                        updateLoadState(key, MultiPovLoadState.Offline)
                    } else {
                        updateLoadState(key, MultiPovLoadState.Error("Kick playback URL unavailable"))
                    }
                    return@launch
                }
                val previous = _uiState.value.slots.firstOrNull { it.key == key }?.resolvedUrl
                if (url == previous) {
                    return@launch
                }
                _uiState.update { state ->
                    state.copy(
                        slots = state.slots.map {
                            if (it.key == key) {
                                it.copy(
                                    resolvedUrl = url,
                                    loadState = MultiPovLoadState.Loading,
                                )
                            } else {
                                it
                            }
                        }
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                val current = _uiState.value.slots.firstOrNull { it.key == key }?.resolvedUrl
                if (current.isNullOrBlank() || !isTrustedKickPlaybackUrl(current)) {
                    updateLoadState(key, MultiPovLoadState.Error(e.message ?: "Failed to resolve stream"))
                }
            }
        }
    }

    fun retrySlot(key: String) {
        lastForceResolveAtMs.remove(key)
        httpErrorAttempts.remove(key)
        resolveIfNeeded(key, forceRefresh = true, userInitiated = true)
    }

    /**
     * Default picker content: live followed channels (excluding ones already in MultiPOV).
     *
     * Uses the same batched Public API path + shared cache as Following → Live.
     * Does **not** hammer per-channel Kick pages (that caused the logcat spam).
     * Falls back to top live streams on Kick when no followed channels are currently live.
     */
    fun loadFollowedLivePicker(forceRefresh: Boolean = false) {
        pickerJob?.cancel()
        pickerJob = viewModelScope.launch {
            val occupied = occupiedPickerKeys()
            // Instant paint from Following→Live shared cache when available.
            if (!forceRefresh) {
                val cached = followedLiveStreamsRepository.peekCache()
                val cachedAvailable = cached
                    .distinctBy { it.multiPovKey() }
                    .filterNot { it.matchesOccupied(occupied) }
                if (cachedAvailable.isNotEmpty()) {
                    _pickerMode.value = MultiPovPickerMode.FollowedLive
                    _pickerResults.value = cachedAvailable
                    _pickerLoading.value = false
                    return@launch
                }
            }
            _pickerLoading.value = true
            try {
                val result = followedLiveStreamsRepository.loadLiveFollowed(
                    forceRefresh = forceRefresh,
                    // MultiPOV picker: never fall back to N per-channel requests.
                    allowPerChannelFallback = false,
                    onPartial = { partial ->
                        val partialAvailable = partial
                            .distinctBy { it.multiPovKey() }
                            .filterNot { it.matchesOccupied(occupied) }
                        if (partialAvailable.isNotEmpty()) {
                            _pickerMode.value = MultiPovPickerMode.FollowedLive
                            _pickerResults.value = partialAvailable
                        }
                    },
                )
                displayFollowedOrTopLive(result.items, occupied)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                val fallback = followedLiveStreamsRepository.peekCache(maxAgeMs = Long.MAX_VALUE)
                displayFollowedOrTopLive(fallback, occupied)
            } finally {
                _pickerLoading.value = false
            }
        }
    }

    private suspend fun displayFollowedOrTopLive(liveItems: List<Stream>, occupied: Set<String>) {
        val available = liveItems
            .distinctBy { it.multiPovKey() }
            .filterNot { it.matchesOccupied(occupied) }
        if (available.isNotEmpty()) {
            _pickerMode.value = MultiPovPickerMode.FollowedLive
            _pickerResults.value = available
        } else {
            val topStreams = fetchTopLiveStreams(occupied)
            _pickerMode.value = if (topStreams.isNotEmpty()) MultiPovPickerMode.TopLive else MultiPovPickerMode.FollowedLive
            _pickerResults.value = topStreams
        }
    }

    private suspend fun fetchTopLiveStreams(occupied: Set<String>): List<Stream> {
        return runCatching {
            kickRepository.getLivestreams(page = 1, limit = 25, sort = "desc")
                .data
                .map { kickRepository.toStream(it) }
                .distinctBy { it.multiPovKey() }
                .filterNot { it.matchesOccupied(occupied) }
        }.getOrDefault(emptyList())
    }

    fun searchPicker(query: String) {
        pickerJob?.cancel()
        val trimmed = query.trim()
        if (trimmed.isBlank()) {
            loadFollowedLivePicker(forceRefresh = false)
            return
        }
        _pickerMode.value = MultiPovPickerMode.Search
        if (trimmed.length < 3) {
            _pickerResults.value = emptyList()
            _pickerLoading.value = false
            return
        }
        pickerJob = viewModelScope.launch {
            // Extra debounce beyond UI; avoids double search on rapid state updates.
            delay(150)
            if (!isActive) return@launch
            _pickerLoading.value = true
            try {
                val occupied = occupiedPickerKeys()
                val streamsByKey = linkedMapOf<String, Stream>()

                val websiteDeferred = async { runCatching { kickRepository.searchWebsite(trimmed) }.getOrNull() }
                val typesenseDeferred = async {
                    runCatching { kickRepository.searchTypesenseChannels(trimmed, page = 1, perPage = 20) }.getOrNull()
                }
                val typesenseCategoryDeferred = async {
                    runCatching { kickRepository.searchTypesenseCategories(trimmed, page = 1, perPage = 25) }.getOrNull()
                }

                val websiteResponse = websiteDeferred.await()
                val typesenseResult = typesenseDeferred.await()
                val typesenseCategories = typesenseCategoryDeferred.await()

                // Resolve matching categories, prioritized by live viewer count
                val websiteCatMap = websiteResponse?.categories.orEmpty().associateBy { it.slug?.lowercase() }
                data class CategoryCandidate(val slug: String, val viewers: Int, val name: String?)
                val categoryCandidates = buildList {
                    websiteResponse?.categories.orEmpty().forEach { cat ->
                        if (!cat.slug.isNullOrBlank()) {
                            add(CategoryCandidate(cat.slug, cat.viewers ?: 0, cat.name))
                        }
                    }
                    typesenseCategories?.hits.orEmpty().forEach { hit ->
                        val doc = hit.document
                        val slug = doc.slug
                        if (!slug.isNullOrBlank() && !websiteCatMap.containsKey(slug.lowercase())) {
                            add(CategoryCandidate(slug, 0, doc.name ?: slug))
                        }
                    }
                }
                .distinctBy { it.slug.lowercase() }
                .sortedByDescending { it.viewers }

                // Fetch top livestreams for the best matching category(ies)
                val topCategorySlugs = categoryCandidates.take(3)
                val categoryStreams = if (topCategorySlugs.isNotEmpty()) {
                    topCategorySlugs.flatMap { cat ->
                        runCatching {
                            kickRepository.getLivestreams(page = 1, limit = 20, sort = "desc", subcategory = cat.slug)
                                .data
                                .map { kickRepository.toStream(it, gameSlug = cat.slug, gameName = cat.name) }
                        }.getOrDefault(emptyList())
                    }
                } else emptyList()

                // 1. Kick website search livestreams (rich data with viewer counts & game)
                websiteResponse?.livestreams?.tags?.forEach { tag ->
                    val stream = KickWebsiteSearchMapper.toStream(tag)
                    val key = stream.multiPovKey()
                    if (key.isNotBlank() && !stream.matchesOccupied(occupied)) {
                        streamsByKey.putIfAbsent(key, stream)
                    }
                }

                // 2. Matching category livestreams (e.g. searching "GTA" or "Fortnite")
                categoryStreams.forEach { stream ->
                    val key = stream.multiPovKey()
                    if (key.isNotBlank() && !stream.matchesOccupied(occupied)) {
                        val existing = streamsByKey[key]
                        if (existing == null || (existing.viewerCount ?: 0) < (stream.viewerCount ?: 0)) {
                            streamsByKey[key] = stream
                        }
                    }
                }

                // 3. Typesense live channels (Kick's primary search index)
                typesenseResult?.hits?.forEach { hit ->
                    val doc = hit.document
                    if (doc.isLive == true && !doc.slug.isNullOrBlank()) {
                        val key = doc.slug.lowercase()
                        if (!occupied.contains(key) && !streamsByKey.containsKey(key)) {
                            streamsByKey[key] = Stream(
                                id = null,
                                source = AppConstants.KICK,
                                channelId = doc.id,
                                channelLogin = doc.slug,
                                channelName = doc.username ?: doc.name,
                                playbackUrl = null,
                                profileImageUrl = doc.profileImage ?: doc.profilePic,
                                user = KickWebsiteSearchMapper.toUser(doc),
                            )
                        }
                    }
                }

                // 4. Kick website search channels that are live
                websiteResponse?.channels?.forEach { channel ->
                    if (channel.isLive == true && !channel.slug.isNullOrBlank()) {
                        val key = channel.slug.lowercase()
                        if (!occupied.contains(key) && !streamsByKey.containsKey(key)) {
                            streamsByKey[key] = Stream(
                                id = null,
                                source = AppConstants.KICK,
                                channelId = channel.id?.toString() ?: channel.userId?.toString(),
                                channelLogin = channel.slug,
                                channelName = channel.user?.username,
                                playbackUrl = channel.playbackUrl,
                                profileImageUrl = channel.user?.profileImage,
                                user = KickWebsiteSearchMapper.toUser(channel),
                            )
                        }
                    }
                }

                fun sortedList(): List<Stream> = streamsByKey.values.sortedWith(
                    compareByDescending<Stream> { it.viewerCount ?: -1 }
                        .thenByDescending { it.user?.followersCount ?: -1 }
                )

                _pickerResults.value = sortedList()

                // Enrich live channels with real-time viewer count and category
                val unresolvedKeys = streamsByKey.filter { it.value.viewerCount == null }.keys.toList()
                if (unresolvedKeys.isNotEmpty()) {
                    val enrichedList = unresolvedKeys.take(8).map { key ->
                        val stream = streamsByKey[key]!!
                        val slug = stream.channelLogin ?: stream.channelName.orEmpty()
                        async {
                            val ls = runCatching { kickRepository.getChannelLivestream(slug) }.getOrNull()
                            if (ls != null) {
                                key to Stream(
                                    id = ls.id?.toString() ?: stream.id,
                                    source = stream.source,
                                    channelId = stream.channelId,
                                    channelLogin = stream.channelLogin,
                                    channelName = stream.channelName,
                                    playbackUrl = ls.playbackUrl ?: stream.playbackUrl,
                                    gameId = ls.category?.id?.toString() ?: stream.gameId,
                                    gameSlug = ls.category?.slug ?: stream.gameSlug,
                                    gameName = ls.category?.name ?: stream.gameName,
                                    title = ls.title ?: stream.title,
                                    viewerCount = ls.viewerCount ?: stream.viewerCount,
                                    startedAt = stream.startedAt,
                                    thumbnailUrl = ls.thumbnail?.imageUrl ?: stream.thumbnailUrl,
                                    profileImageUrl = stream.profileImageUrl,
                                    tags = stream.tags,
                                    user = stream.user,
                                )
                            } else null
                        }
                    }.awaitAll().filterNotNull()

                    if (isActive && enrichedList.isNotEmpty()) {
                        enrichedList.forEach { (key, enrichedStream) ->
                            streamsByKey[key] = enrichedStream
                        }
                        _pickerResults.value = sortedList()
                    }
                }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                _pickerResults.value = emptyList()
            } finally {
                _pickerLoading.value = false
            }
        }
    }

    private fun occupiedPickerKeys(): Set<String> {
        // Streams from different sources fill different id fields (player path
        // carries channelId, picker results may only carry login) — index both.
        return _uiState.value.slots.flatMap { slot ->
            listOfNotNull(
                slot.key,
                slot.stream.channelId?.lowercase(),
                slot.stream.channelLogin?.lowercase(),
            )
        }.toSet()
    }

    private fun Stream.matchesOccupied(occupied: Set<String>): Boolean =
        occupied.contains(channelId?.lowercase()) ||
            occupied.contains(channelLogin?.lowercase()) ||
            occupied.contains(multiPovKey())

    private fun startOfflinePolling() {
        if (offlinePollJob?.isActive == true) return
        offlinePollJob = viewModelScope.launch {
            while (isActive) {
                delay(OFFLINE_POLL_INTERVAL_MS)
                val slots = _uiState.value.slots.toList()
                if (slots.isEmpty()) continue
                for (slot in slots) {
                    // Recover tiles with no (or no signed) URL, and offline slots —
                    // a force resolve flips them back once the streamer goes live.
                    val offline = slot.loadState is MultiPovLoadState.Offline
                    if (slot.resolvedUrl.isNullOrBlank() ||
                        (slot.loadState is MultiPovLoadState.Error && !isTrustedKickPlaybackUrl(slot.resolvedUrl)) ||
                        offline
                    ) {
                        resolveIfNeeded(slot.key, forceRefresh = offline, userInitiated = false)
                    }
                }
            }
        }
    }

    /**
     * At most one Kick HTTP call in the common case.
     * Avoid chaining channel + livestream + force channel (was 2–3 calls per resolve).
     */
    private suspend fun resolveKickLiveUrl(channelLogin: String, forceRefresh: Boolean): String? {
        return runCatching {
            kickRepository.getPlaybackUrl(channelLogin, forceRefresh = forceRefresh)
        }.getOrNull()?.takeIf { it.isNotBlank() }
    }

    override fun onCleared() {
        resolveJobs.values.forEach { it.cancel() }
        pickerJob?.cancel()
        offlinePollJob?.cancel()
    }

    companion object {
        /** Soft recovery only — not a health-check hammer. */
        private const val OFFLINE_POLL_INTERVAL_MS = 120_000L
        /** Min gap between automatic force resolves per slot. */
        private const val FORCE_RESOLVE_COOLDOWN_MS = 30_000L
    }
}
