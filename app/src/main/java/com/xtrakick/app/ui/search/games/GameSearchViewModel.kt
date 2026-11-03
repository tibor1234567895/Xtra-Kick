package com.xtrakick.app.ui.search.games

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.ui.RecentSearch
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.RecentSearchRepository
import com.xtrakick.app.repository.datasource.SearchGamesDataSource
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameSearchViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val recentSearchRepository: RecentSearchRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    private val _query = MutableStateFlow("")
    private var viewerCounts: Deferred<Map<String, Int>>? = null
    val query: StateFlow<String> = _query
    val recentSearches = recentSearchRepository.loadRecentSearchFlow(RecentSearch.TYPE_GAME)

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = _query.flatMapLatest { query ->
        Pager(
            PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
        ) {
            SearchGamesDataSource(
                query = query,
                kickRepository = kickRepository,
                useLegacyKickSearch = applicationContext.prefs().getBoolean(AppConstants.DEBUG_KICK_LEGACY_SEARCH, false),
            )
        }.flow
    }.cachedIn(viewModelScope)

    fun setQuery(newQuery: String) {
        if (_query.value != newQuery) {
            viewerCounts?.cancel()
            viewerCounts = null
            _query.value = newQuery
        }
    }

    suspend fun resolveViewersCount(game: Game): Int? {
        val query = _query.value
        val counts = viewerCounts ?: viewModelScope.async {
            try {
                kickRepository.searchWebsite(query).categories.mapNotNull { category ->
                    val id = category.id?.toString() ?: return@mapNotNull null
                    val viewers = category.viewers ?: return@mapNotNull null
                    id to viewers
                }.toMap()
            } catch (error: CancellationException) {
                throw error
            } catch (_: Exception) {
                emptyMap()
            }
        }.also { viewerCounts = it }
        return counts.await()[game.gameId]
    }

    fun saveRecentSearch(query: String) {
        if (query.isNotBlank()) {
            viewModelScope.launch {
                recentSearchRepository.save(RecentSearch(query, RecentSearch.TYPE_GAME, System.currentTimeMillis()))
            }
        }
    }

    fun deleteRecentSearch(item: RecentSearch) {
        viewModelScope.launch {
            recentSearchRepository.delete(item)
        }
    }
}
