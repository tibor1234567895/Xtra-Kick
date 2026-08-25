package com.xtrakick.app.ui.game.clips

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.kick.ClipsPeriod
import com.xtrakick.app.model.kick.Language
import com.xtrakick.app.model.ui.SortGame
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.SortGameRepository
import com.xtrakick.app.repository.datasource.GameClipsDataSource
import com.xtrakick.app.ui.common.VideosSortDialog
import com.xtrakick.app.ui.game.GamePagerFragmentArgs
import com.xtrakick.app.util.KickApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class GameClipsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val sortGameRepository: SortGameRepository,
    private val kickRepository: KickRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = GamePagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)
    val filtersText = MutableStateFlow<CharSequence?>(null)

    val period: String
        get() = filter.value?.period ?: VideosSortDialog.PERIOD_WEEK
    val languages: Array<String>
        get() = filter.value?.languages ?: emptyArray()

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        val selectedPeriod = filter?.period ?: VideosSortDialog.PERIOD_WEEK
        val selectedLanguages = filter?.languages ?: emptyArray()
        Pager(
            PagingConfig(pageSize = 20, prefetchDistance = 3, initialLoadSize = 20)
        ) {
            val started = when (selectedPeriod) {
                VideosSortDialog.PERIOD_ALL -> null
                else -> KickApiHelper.getClipTime(
                    when (selectedPeriod) {
                        VideosSortDialog.PERIOD_DAY -> 1
                        VideosSortDialog.PERIOD_WEEK -> 7
                        VideosSortDialog.PERIOD_MONTH -> 30
                        else -> 7
                    }
                )
            }
            val ended = when (selectedPeriod) {
                VideosSortDialog.PERIOD_ALL -> null
                else -> KickApiHelper.getClipTime(0)
            }
            val gqlQueryPeriod = when (selectedPeriod) {
                VideosSortDialog.PERIOD_DAY -> ClipsPeriod.LAST_DAY
                VideosSortDialog.PERIOD_WEEK -> ClipsPeriod.LAST_WEEK
                VideosSortDialog.PERIOD_MONTH -> ClipsPeriod.LAST_MONTH
                VideosSortDialog.PERIOD_ALL -> ClipsPeriod.ALL_TIME
                else -> ClipsPeriod.LAST_WEEK
            }
            val gqlPeriod = when (selectedPeriod) {
                VideosSortDialog.PERIOD_DAY -> "LAST_DAY"
                VideosSortDialog.PERIOD_WEEK -> "LAST_WEEK"
                VideosSortDialog.PERIOD_MONTH -> "LAST_MONTH"
                VideosSortDialog.PERIOD_ALL -> "ALL_TIME"
                else -> "LAST_WEEK"
            }
            GameClipsDataSource(
                gameId = args.gameId,
                gameSlug = args.gameSlug,
                gameName = args.gameName,
                gqlQueryPeriod = gqlQueryPeriod,
                gqlPeriod = gqlPeriod,
                startedAt = started,
                endedAt = ended,
                kickRepository = kickRepository,
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

    fun setFilter(period: String?, languages: Array<String>?) {
        filter.value = Filter(period, languages)
    }

    class Filter(
        val period: String?,
        val languages: Array<String>?,
    )
}
