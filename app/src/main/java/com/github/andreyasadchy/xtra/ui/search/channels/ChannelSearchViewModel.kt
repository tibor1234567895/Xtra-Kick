package com.github.andreyasadchy.xtra.ui.search.channels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.andreyasadchy.xtra.model.ui.RecentSearch
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.RecentSearchRepository
import com.github.andreyasadchy.xtra.repository.datasource.SearchChannelsDataSource
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChannelSearchViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val recentSearchRepository: RecentSearchRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query
    val recentSearches = recentSearchRepository.loadRecentSearchFlow(RecentSearch.TYPE_CHANNEL)

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = _query.flatMapLatest { query ->
        Pager(
            PagingConfig(pageSize = 15, prefetchDistance = 5, initialLoadSize = 15)
        ) {
            SearchChannelsDataSource(
                query = query,
                kickRepository = kickRepository,
                useLegacyKickSearch = applicationContext.prefs().getBoolean(C.DEBUG_KICK_LEGACY_SEARCH, false),
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
                recentSearchRepository.getItem(query, RecentSearch.TYPE_CHANNEL)?.let {
                    recentSearchRepository.delete(it)
                }
                recentSearchRepository.save(RecentSearch(query, RecentSearch.TYPE_CHANNEL, System.currentTimeMillis()))
            }
        }
    }

    fun deleteRecentSearch(item: RecentSearch) {
        viewModelScope.launch {
            recentSearchRepository.delete(item)
        }
    }
}
