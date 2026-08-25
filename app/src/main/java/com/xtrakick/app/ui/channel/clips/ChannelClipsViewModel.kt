package com.xtrakick.app.ui.channel.clips

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.model.kick.ClipsPeriod
import com.xtrakick.app.model.ui.SortChannel
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.SortChannelRepository
import com.xtrakick.app.repository.datasource.ChannelClipsDataSource
import com.xtrakick.app.ui.channel.ChannelPagerFragmentArgs
import com.xtrakick.app.ui.common.VideosSortDialog
import com.xtrakick.app.util.KickApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class ChannelClipsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val sortChannelRepository: SortChannelRepository,
    private val kickRepository: KickRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = ChannelPagerFragmentArgs.fromSavedStateHandle(savedStateHandle)
    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)

    val period: String
        get() = filter.value?.period ?: VideosSortDialog.PERIOD_WEEK

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        val selectedPeriod = filter?.period ?: VideosSortDialog.PERIOD_WEEK
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
            ChannelClipsDataSource(
                channelId = args.channelId,
                channelLogin = args.channelLogin,
                gqlQueryPeriod = gqlQueryPeriod,
                gqlPeriod = gqlPeriod,
                startedAt = started,
                endedAt = ended,
                kickRepository = kickRepository,
            )
        }.flow
    }.cachedIn(viewModelScope)

    suspend fun getSortChannel(id: String): SortChannel? {
        return sortChannelRepository.getById(id)
    }

    suspend fun saveSortChannel(item: SortChannel) {
        sortChannelRepository.save(item)
    }

    suspend fun deleteSortChannel(item: SortChannel) {
        sortChannelRepository.delete(item)
    }

    fun setFilter(period: String?) {
        filter.value = Filter(period)
    }

    class Filter(
        val period: String?,
    )
}
