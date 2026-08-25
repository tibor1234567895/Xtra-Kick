package com.xtrakick.app.ui.search.streams

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.ui.RecentSearch
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.RecentSearchRepository
import com.xtrakick.app.repository.datasource.SearchStreamsDataSource
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StreamSearchViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val recentSearchRepository: RecentSearchRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query
    val recentSearches = recentSearchRepository.loadRecentSearchFlow(RecentSearch.TYPE_STREAM)

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = _query.flatMapLatest { query ->
        Pager(
            if (applicationContext.prefs().getString(AppConstants.COMPACT_STREAMS, "disabled") == "all") {
                PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
            } else {
                PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30)
            }
        ) {
            SearchStreamsDataSource(
                query = query,
                kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(applicationContext),
                kickPublicApiRepository = kickPublicApiRepository,
                kickRepository = kickRepository,
                networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                useLegacyKickSearch = applicationContext.prefs().getBoolean(AppConstants.DEBUG_KICK_LEGACY_SEARCH, false),
            )
        }.flow
    }.cachedIn(viewModelScope)

    fun setQuery(newQuery: String) {
        if (_query.value != newQuery) {
            _query.value = newQuery
        }
    }

    fun saveRecentSearch(query: String) {
        if (query.isNotBlank()) {
            viewModelScope.launch {
                recentSearchRepository.getItem(query, RecentSearch.TYPE_STREAM)?.let {
                    recentSearchRepository.delete(it)
                }
                recentSearchRepository.save(RecentSearch(query, RecentSearch.TYPE_STREAM, System.currentTimeMillis()))
            }
        }
    }

    fun deleteRecentSearch(item: RecentSearch) {
        viewModelScope.launch {
            recentSearchRepository.delete(item)
        }
    }
}
