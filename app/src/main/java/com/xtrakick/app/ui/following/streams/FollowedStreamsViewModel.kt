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
import javax.inject.Inject
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

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

    private val _uiState = MutableStateFlow(FollowedStreamsUiState())
    val uiState: StateFlow<FollowedStreamsUiState> = _uiState.asStateFlow()

    private var refreshJob: Job? = null
    private var refreshGeneration = 0L
    private var lastRefreshedAt = 0L

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
                .debounce(250L)
                .collect { refresh() }
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

    fun refresh(silent: Boolean = false) {
        val generation = ++refreshGeneration
        refreshJob?.cancel()

        val cachedItems = if (silent) emptyList() else followedLiveStreamsRepository.peekCache().sortedForFollowedLive()
        val currentState = _uiState.value
        val currentItems = when {
            cachedItems.isNotEmpty() -> cachedItems
            currentState.items.isNotEmpty() -> currentState.items
            else -> emptyList()
        }

        _uiState.value = currentState.copy(
            items = currentItems,
            isInitialLoading = !silent && currentItems.isEmpty(),
            isRefreshing = !silent && currentItems.isNotEmpty(),
            showEmpty = false,
            integrityAction = null,
            hasLoadedOnce = currentState.hasLoadedOnce || currentItems.isNotEmpty(),
        )

        refreshJob = viewModelScope.launch {
            try {
                val result = followedLiveStreamsRepository.loadLiveFollowed(
                    forceRefresh = true,
                    allowPerChannelFallback = true,
                    onPartial = { items ->
                        if (!silent) updateStateForGeneration(
                            generation, items.sortedForFollowedLive(), false, true, false, hasLoadedOnce = true,
                        )
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
                if (refreshGeneration == generation) {
                    refreshJob = null
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

}
