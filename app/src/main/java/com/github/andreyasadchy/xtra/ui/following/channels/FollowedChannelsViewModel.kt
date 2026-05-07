package com.github.andreyasadchy.xtra.ui.following.channels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.andreyasadchy.xtra.model.ui.SortChannel
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.repository.SortChannelRepository
import com.github.andreyasadchy.xtra.repository.datasource.FollowedChannelsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class FollowedChannelsViewModel @Inject constructor(
    private val sortChannelRepository: SortChannelRepository,
    private val localFollowsChannel: LocalFollowChannelRepository,
) : ViewModel() {

    val filter = MutableStateFlow<Filter?>(null)
    val sortText = MutableStateFlow<CharSequence?>(null)

    val sort: String
        get() = normalizeSort(filter.value?.sort)
    val order: String
        get() = normalizeOrder(filter.value?.order)

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest {
        Pager(
            PagingConfig(pageSize = 15, prefetchDistance = 5, initialLoadSize = 15)
        ) {
            FollowedChannelsDataSource(
                sort = when (sort) {
                    FollowedChannelsSortDialog.SORT_FOLLOWED_AT -> "created_at"
                    FollowedChannelsSortDialog.SORT_ALPHABETICALLY -> "login"
                    else -> "login"
                },
                order = when (order) {
                    FollowedChannelsSortDialog.ORDER_DESC -> "desc"
                    FollowedChannelsSortDialog.ORDER_ASC -> "asc"
                    else -> "asc"
                },
                localFollowsChannel = localFollowsChannel,
            )
        }.flow
    }.cachedIn(viewModelScope)

    suspend fun getSortChannel(id: String): SortChannel? {
        return sortChannelRepository.getById(id)
    }

    suspend fun saveSortChannel(item: SortChannel) {
        sortChannelRepository.save(item)
    }

    fun setFilter(sort: String?, order: String?) {
        filter.value = Filter(normalizeSort(sort), normalizeOrder(order))
    }

    private fun normalizeSort(sort: String?): String {
        return when (sort) {
            FollowedChannelsSortDialog.SORT_FOLLOWED_AT,
            FollowedChannelsSortDialog.SORT_ALPHABETICALLY -> sort
            else -> FollowedChannelsSortDialog.SORT_ALPHABETICALLY
        }
    }

    private fun normalizeOrder(order: String?): String {
        return when (order) {
            FollowedChannelsSortDialog.ORDER_DESC,
            FollowedChannelsSortDialog.ORDER_ASC -> order
            else -> FollowedChannelsSortDialog.ORDER_ASC
        }
    }

    class Filter(
        val sort: String?,
        val order: String?,
    )
}
