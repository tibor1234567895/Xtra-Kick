package com.xtrakick.app.ui.game.streams

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.kick.Language
import com.xtrakick.app.model.ui.SavedFilter
import com.xtrakick.app.model.ui.SortGame
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.SavedFiltersRepository
import com.xtrakick.app.repository.SortGameRepository
import com.xtrakick.app.repository.datasource.GameStreamsDataSource
import com.xtrakick.app.ui.common.StreamsSortDialog
import com.xtrakick.app.ui.game.GamePagerFragmentArgs
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class GameStreamsViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val sortGameRepository: SortGameRepository,
    private val savedFiltersRepository: SavedFiltersRepository,
    private val kickRepository: KickRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = GamePagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
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
        Pager(
            if (applicationContext.prefs().getString(AppConstants.COMPACT_STREAMS, "disabled") == "all") {
                PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
            } else {
                PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30)
            }
        ) {
            GameStreamsDataSource(
                gameId = args.gameId,
                gameSlug = args.gameSlug,
                gameName = args.gameName,
                gqlQueryLanguages = languages.ifEmpty { null }?.mapNotNull { language ->
                    Language.entries.find { it.rawValue == language }
                },
                gqlLanguages = languages.ifEmpty { null }?.toList(),
                gqlSort = when (sort) {
                    StreamsSortDialog.Companion.SORT_VIEWERS -> "VIEWER_COUNT"
                    StreamsSortDialog.Companion.SORT_VIEWERS_ASC -> "VIEWER_COUNT_ASC"
                    StreamsSortDialog.Companion.RECENT -> "RECENT"
                    else -> "VIEWER_COUNT"
                },
                tags = tags.ifEmpty { null }?.toList(),
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

    suspend fun deleteSortGame(item: SortGame) {
        sortGameRepository.delete(item)
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
