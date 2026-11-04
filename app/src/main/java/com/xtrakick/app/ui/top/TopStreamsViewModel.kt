package com.xtrakick.app.ui.top

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.ui.SavedFilter
import com.xtrakick.app.model.ui.SortGame
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.SavedFiltersRepository
import com.xtrakick.app.repository.SortGameRepository
import com.xtrakick.app.repository.datasource.StreamsDataSource
import com.xtrakick.app.ui.common.StreamsSortDialog
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class TopStreamsViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val sortGameRepository: SortGameRepository,
    private val savedFiltersRepository: SavedFiltersRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)
    val filtersText = MutableStateFlow<CharSequence?>(null)

    val sort: String
        get() = filter.value?.sort ?: StreamsSortDialog.Companion.SORT_VIEWERS
    val tags: Array<String>
        get() = filter.value?.tags ?: emptyArray()
    val languages: Array<String>
        get() = filter.value?.languages ?: emptyArray()

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        val hasFilters = tags.isNotEmpty() || languages.isNotEmpty()
        val isCompact = applicationContext.prefs().getString(AppConstants.COMPACT_STREAMS, "disabled") == "all"
        val prefetch = if (hasFilters) (if (isCompact) 12 else 8) else (if (isCompact) 10 else 3)
        val initialSize = if (hasFilters) 60 else 30
        Pager(
            PagingConfig(
                pageSize = 30,
                prefetchDistance = prefetch,
                initialLoadSize = initialSize
            )
        ) {
            StreamsDataSource(
                gqlSort = when (sort) {
                    StreamsSortDialog.Companion.SORT_VIEWERS -> "VIEWER_COUNT"
                    StreamsSortDialog.Companion.SORT_VIEWERS_ASC -> "VIEWER_COUNT_ASC"
                    StreamsSortDialog.Companion.RECENT -> "RECENT"
                    else -> "VIEWER_COUNT"
                },
                tags = tags,
                languages = languages,
                kickRepository = kickRepository,
                apiPref = listOf(AppConstants.KICK),
            )
        }.flow
    }.cachedIn(viewModelScope)

    suspend fun getSortGame(id: String): SortGame? {
        return sortGameRepository.getById(id)
    }

    suspend fun saveSortGame(item: SortGame) {
        sortGameRepository.save(item)
    }

    suspend fun saveFilters(item: SavedFilter) {
        savedFiltersRepository.saveFilter(item)
    }

    fun setFilter(sort: String?, tags: Array<String>?, languages: Array<String>?) {
        filter.value = Filter(sort, tags, languages)
    }

    class Filter(
        val sort: String?,
        val tags: Array<String>?,
        val languages: Array<String>?,
    )
}
