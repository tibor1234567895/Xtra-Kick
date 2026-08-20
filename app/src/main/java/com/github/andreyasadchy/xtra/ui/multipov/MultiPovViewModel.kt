package com.github.andreyasadchy.xtra.ui.multipov

import android.content.SharedPreferences
import android.os.SystemClock
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.FollowedLiveStreamsRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.KickWebsiteSearchMapper
import com.github.andreyasadchy.xtra.util.C
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class MultiPovPickerMode {
    /** Live channels from the user's followed list (default when search is empty). */
    FollowedLive,
    /** Kick website search results. */
    Search,
}

@HiltViewModel
class MultiPovViewModel @Inject constructor(
    private val kickRepository: KickRepository,
    private val followedLiveStreamsRepository: FollowedLiveStreamsRepository,
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
        maxStreams: Int = C.MULTIPOV_MAX_STREAMS_DEFAULT,
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
            val rotated = state.slots.drop(1) + state.slots.first()
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
        sessionPrefs?.edit()?.putBoolean(C.MULTIPOV_BANDWIDTH_SAVING, enabled)?.apply()
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
        if (state.slots.any { it.key == key }) return true
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
        if (forceRefresh && !userInitiated && !existingUrl.isNullOrBlank()) {
            val last = lastForceResolveAtMs[key] ?: 0L
            if (SystemClock.elapsedRealtime() - last < FORCE_RESOLVE_COOLDOWN_MS) {
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
                    ?: throw Exception("Kick playback URL unavailable")
                httpErrorAttempts.remove(key)
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
                if (_uiState.value.slots.firstOrNull { it.key == key }?.resolvedUrl.isNullOrBlank()) {
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
     */
    fun loadFollowedLivePicker(forceRefresh: Boolean = false) {
        pickerJob?.cancel()
        _pickerMode.value = MultiPovPickerMode.FollowedLive
        pickerJob = viewModelScope.launch {
            val occupied = occupiedPickerKeys()
            // Instant paint from Following→Live shared cache when available.
            if (!forceRefresh) {
                val cached = followedLiveStreamsRepository.peekCache()
                if (cached.isNotEmpty()) {
                    _pickerResults.value = cached
                        .distinctBy { it.multiPovKey() }
                        .filterNot { it.multiPovKey() in occupied }
                    _pickerLoading.value = false
                    // Still refresh in background if cache is all we have and user re-opens often —
                    // but only when forced. Cache TTL is already short (45s).
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
                        _pickerResults.value = partial
                            .distinctBy { it.multiPovKey() }
                            .filterNot { it.multiPovKey() in occupiedPickerKeys() }
                    },
                )
                _pickerResults.value = result.items
                    .distinctBy { it.multiPovKey() }
                    .filterNot { it.multiPovKey() in occupiedPickerKeys() }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                val fallback = followedLiveStreamsRepository.peekCache(maxAgeMs = Long.MAX_VALUE)
                _pickerResults.value = fallback
                    .distinctBy { it.multiPovKey() }
                    .filterNot { it.multiPovKey() in occupiedPickerKeys() }
            } finally {
                _pickerLoading.value = false
            }
        }
    }

    fun searchPicker(query: String) {
        pickerJob?.cancel()
        val trimmed = query.trim()
        if (trimmed.isBlank()) {
            loadFollowedLivePicker(forceRefresh = false)
            return
        }
        _pickerMode.value = MultiPovPickerMode.Search
        pickerJob = viewModelScope.launch {
            // Extra debounce beyond UI; avoids double search on rapid state updates.
            delay(150)
            if (!isActive) return@launch
            _pickerLoading.value = true
            try {
                val response = kickRepository.searchWebsite(trimmed)
                val occupied = occupiedPickerKeys()
                val streamsByKey = linkedMapOf<String, Stream>()
                response.livestreams.tags
                    .map { KickWebsiteSearchMapper.toStream(it) }
                    .forEach { stream ->
                        val key = stream.multiPovKey()
                        if (key.isNotBlank() && key !in occupied) {
                            streamsByKey.putIfAbsent(key, stream)
                        }
                    }
                // Kick search often returns live channels under `channels` with camelCase isLive
                // and may leave livestreams.tags empty — include those with playback URLs too.
                response.channels
                    .asSequence()
                    .filter { channel ->
                        channel.isLive == true || !channel.playbackUrl.isNullOrBlank()
                    }
                    .forEach { channel ->
                        val stream = Stream(
                            id = null,
                            source = C.KICK,
                            channelId = channel.id?.toString() ?: channel.userId?.toString(),
                            channelLogin = channel.slug,
                            channelName = channel.user?.username,
                            playbackUrl = channel.playbackUrl,
                            profileImageUrl = channel.user?.profileImage,
                        )
                        val key = stream.multiPovKey()
                        if (key.isNotBlank() && key !in occupied) {
                            streamsByKey.putIfAbsent(key, stream)
                        }
                    }
                // If still empty (offline-only matches), surface channels so the user can pick;
                // URL resolve will fail with Offline/Error if not live.
                if (streamsByKey.isEmpty()) {
                    response.channels.forEach { channel ->
                        val stream = Stream(
                            source = C.KICK,
                            channelId = channel.id?.toString() ?: channel.userId?.toString(),
                            channelLogin = channel.slug,
                            channelName = channel.user?.username,
                            playbackUrl = channel.playbackUrl,
                            profileImageUrl = channel.user?.profileImage,
                        )
                        val key = stream.multiPovKey()
                        if (key.isNotBlank() && key !in occupied) {
                            streamsByKey.putIfAbsent(key, stream)
                        }
                    }
                }
                _pickerResults.value = streamsByKey.values.toList()
            } catch (_: Exception) {
                _pickerResults.value = emptyList()
            } finally {
                _pickerLoading.value = false
            }
        }
    }

    private fun occupiedPickerKeys(): Set<String> {
        return _uiState.value.slots.map { it.key }.toSet()
    }

    private fun startOfflinePolling() {
        if (offlinePollJob?.isActive == true) return
        offlinePollJob = viewModelScope.launch {
            while (isActive) {
                delay(OFFLINE_POLL_INTERVAL_MS)
                val slots = _uiState.value.slots.toList()
                if (slots.isEmpty()) continue
                for (slot in slots) {
                    // Only recover tiles with NO url. Do NOT force-refresh healthy Loading/Ready
                    // tiles — that was hammering Kick's channel API every few seconds.
                    if (slot.resolvedUrl.isNullOrBlank()) {
                        resolveIfNeeded(slot.key, forceRefresh = false, userInitiated = false)
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
        val fromChannel = runCatching {
            kickRepository
                .getChannel(
                    channelSlug = channelLogin,
                    prefetchBadgeCatalog = false,
                    forceRefresh = forceRefresh,
                )
                .let { kickRepository.getPlayableUrl(it) }
                ?.takeIf { it.isNotBlank() }
        }.getOrNull()
        if (fromChannel != null) return fromChannel

        // Fallback only if channel payload had no playable URL.
        return runCatching {
            kickRepository
                .getChannelLivestream(channelLogin, forceRefresh = forceRefresh)
                ?.playbackUrl
                ?.takeIf { it.isNotBlank() }
        }.getOrNull()
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
