package com.xtrakick.app.ui.following.streams

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.FollowedLiveStreamsRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

@HiltViewModel
@OptIn(FlowPreview::class)
class FollowedStreamsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val followedLiveStreamsRepository: FollowedLiveStreamsRepository,
    private val sortChannelRepository: SortChannelRepository,
) : ViewModel() {

    data class FollowedStreamsUiState(
        val items: List<Stream> = emptyList(),
        val isInitialLoading: Boolean = false,
        val isRefreshing: Boolean = false,
        val showEmpty: Boolean = false,
        val integrityAction: String? = null,
        val hasLoadedOnce: Boolean = false,
    )

    val sortText = MutableStateFlow<CharSequence?>(null)
    val sort = MutableStateFlow(FollowedStreamsSortDialog.SORT_VIEWERS)
    val filtersText = MutableStateFlow<CharSequence?>(null)
    val activeTags = MutableStateFlow<Set<String>>(emptySet())
    private var allLoadedStreams = emptyList<Stream>()

    private val _uiState = MutableStateFlow(FollowedStreamsUiState())
    val uiState: StateFlow<FollowedStreamsUiState> = _uiState.asStateFlow()

    private var refreshJob: Job? = null
    private var refreshGeneration = 0L
    private var lastRefreshedAt = 0L
    private var lastRefreshProgressAt = 0L

    companion object {
        // Bound loading indicators while large follow lists continue loading in batches.
        private const val REFRESH_TIMEOUT_MS = 30_000L
        private const val STALE_CACHE_MAX_AGE_MS = 24L * 60L * 60L * 1000L
    }

    fun maybeRefreshIfStale(minAgeMs: Long = 30_000L, silent: Boolean = true): Boolean {
        val now = System.currentTimeMillis()
        if (now - lastRefreshedAt >= minAgeMs && refreshJob == null) {
            refresh(silent = silent)
            return true
        }
        return false
    }

    init {
        viewModelScope.launch {
            localFollowsChannel.followsChanged
                .debounce(500L)
                .collect {
                    if (refreshJob?.isActive != true) {
                        refresh()
                    }
                }
        }
    }

    fun initialize() {
        if (sortText.value == null) {
            viewModelScope.launch {
                val savedSort = sortChannelRepository.getById("followed_streams")?.videoSort
                setSort(savedSort, persist = false)
            }
        }
        // Recompute every time so the sort bar follows app-locale changes
        sortText.value = buildSortText(sort.value)
        if (!_uiState.value.hasLoadedOnce && refreshJob == null) {
            refresh()
        }
    }

    fun setSort(value: String?, persist: Boolean) {
        val normalizedSort = normalizeSort(value)
        sort.value = normalizedSort
        sortText.value = buildSortText(normalizedSort)
        applyFilterAndSort()
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

    fun toggleTagFilter(tag: String) {
        val current = activeTags.value
        val normalized = tag.trim()
        val newSet = if (current.any { it.equals(normalized, ignoreCase = true) }) {
            current.filterNot { it.equals(normalized, ignoreCase = true) }.toSet()
        } else {
            current + normalized
        }
        setTagFilters(newSet)
    }

    fun clearTagFilters() {
        setTagFilters(emptySet())
    }

    fun setTagFilters(tags: Set<String>) {
        activeTags.value = tags
        updateFiltersText()
        applyFilterAndSort()
    }

    private fun updateFiltersText() {
        val tags = activeTags.value
        filtersText.value = if (tags.isNotEmpty()) {
            applicationContext.resources.getQuantityString(
                com.xtrakick.app.R.plurals.tags,
                tags.size,
                tags.joinToString()
            )
        } else {
            null
        }
    }

    private fun applyFilterAndSort() {
        val deduped = allLoadedStreams.filterByTags(activeTags.value).distinctByStreamer().sortedForFollowedLive()
        _uiState.value = _uiState.value.copy(
            items = deduped,
            showEmpty = deduped.isEmpty() && _uiState.value.hasLoadedOnce,
        )
    }

    private fun List<Stream>.filterByTags(tags: Set<String>): List<Stream> {
        if (tags.isEmpty()) return this
        return filter { stream ->
            val streamTags = stream.tags?.map { it.trim().lowercase(Locale.ROOT) } ?: emptyList()
            val title = stream.title?.trim()?.lowercase(Locale.ROOT)
            val game = stream.gameName?.trim()?.lowercase(Locale.ROOT)
            tags.all { req ->
                val q = req.trim().lowercase(Locale.ROOT)
                if (q.isEmpty()) return@all true
                val qClean = q.replace(" ", "").replace("_", "").replace("-", "")
                val matchTag = streamTags.any { t ->
                    t == q || t.contains(q) || q.contains(t) ||
                    (qClean.isNotEmpty() && t.replace(" ", "").replace("_", "").replace("-", "").contains(qClean))
                }
                if (matchTag) return@all true
                if (title != null && (title.contains(q) || (qClean.isNotEmpty() && title.replace(" ", "").replace("_", "").replace("-", "").contains(qClean)))) return@all true
                if (game != null && (game.contains(q) || (qClean.isNotEmpty() && game.replace(" ", "").replace("_", "").replace("-", "").contains(qClean)))) return@all true
                false
            }
        }
    }

    fun refresh(silent: Boolean = false, isPullToRefresh: Boolean = false) {
        val now = System.currentTimeMillis()
        if (silent && refreshJob?.isActive == true) {
            // A hung first load must not starve unlock/pull retries forever.
            if (now - lastRefreshProgressAt < REFRESH_TIMEOUT_MS) {
                return
            }
            refreshJob?.cancel()
        }
        val generation = ++refreshGeneration
        lastRefreshProgressAt = now
        refreshJob?.cancel()

        // Stale-while-revalidate: seed even the first load from cache (up to a
        // day old) so unlock shows a list + top spinner instead of a stuck
        // full-screen spinner when the network is slow (screen-off launch).
        val cachedItems = followedLiveStreamsRepository.peekCache(STALE_CACHE_MAX_AGE_MS).distinctByStreamer().sortedForFollowedLive()
        val currentState = _uiState.value
        val currentItems = when {
            cachedItems.isNotEmpty() -> cachedItems
            currentState.items.isNotEmpty() -> currentState.items
            else -> emptyList()
        }

        val isInitial = !silent && currentItems.isEmpty() && !isPullToRefresh && !currentState.hasLoadedOnce
        val isRefreshing = !silent && (currentItems.isNotEmpty() || isPullToRefresh)

        _uiState.value = currentState.copy(
            items = currentItems,
            isInitialLoading = isInitial,
            isRefreshing = isRefreshing,
            showEmpty = currentItems.isEmpty() && currentState.hasLoadedOnce,
            integrityAction = null,
            hasLoadedOnce = currentState.hasLoadedOnce || currentItems.isNotEmpty(),
        )

        refreshJob = viewModelScope.launch {
            val loadingTimeout = launch {
                delay(REFRESH_TIMEOUT_MS)
                if (refreshGeneration == generation) {
                    _uiState.value = _uiState.value.copy(isInitialLoading = false, isRefreshing = false)
                }
            }
            try {
                val result = followedLiveStreamsRepository.loadLiveFollowed(
                    forceRefresh = true,
                    allowPerChannelFallback = true,
                    onPartial = { items ->
                        lastRefreshProgressAt = System.currentTimeMillis()
                        if (items.isNotEmpty()) {
                            updateStateForGeneration(
                                generation, items.sortedForFollowedLive(), false, false, false, hasLoadedOnce = true,
                            )
                        }
                    },
                )
                val items = result.items.sortedForFollowedLive()
                lastRefreshedAt = System.currentTimeMillis()
                updateStateForGeneration(generation, items, false, false, items.isEmpty(), hasLoadedOnce = true)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                lastRefreshedAt = System.currentTimeMillis()
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
                loadingTimeout.cancel()
                if (refreshGeneration == generation) {
                    refreshJob = null
                    val finalState = _uiState.value
                    if (finalState.isRefreshing || finalState.isInitialLoading) {
                        _uiState.value = finalState.copy(
                            isInitialLoading = false,
                            isRefreshing = false,
                            showEmpty = finalState.items.isEmpty() && finalState.hasLoadedOnce,
                            hasLoadedOnce = true,
                        )
                    }
                }
            }
        }
    }

    fun clearIntegrityAction() {
        _uiState.value = _uiState.value.copy(integrityAction = null)
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
        allLoadedStreams = items
        val deduped = items.filterByTags(activeTags.value).distinctByStreamer().sortedForFollowedLive()
        _uiState.value = _uiState.value.copy(
            items = deduped,
            isInitialLoading = isInitialLoading,
            isRefreshing = isRefreshing,
            showEmpty = deduped.isEmpty() && hasLoadedOnce,
            integrityAction = integrityAction,
            hasLoadedOnce = hasLoadedOnce,
        )
    }

    private fun List<Stream>.distinctByStreamer(): List<Stream> {
        return distinctBy { stream ->
            stream.channelLogin?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotEmpty() }
                ?: stream.channelId?.trim()?.takeIf { it.isNotEmpty() }
                ?: stream.id?.trim()?.takeIf { it.isNotEmpty() }
                ?: stream.channelName?.trim()?.lowercase(Locale.ROOT)
        }
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

}
