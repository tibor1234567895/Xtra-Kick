package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository

class FollowedChannelsDataSource(
    private val sort: String,
    private val order: String,
    private val localFollowsChannel: LocalFollowChannelRepository,
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val list = localFollowsChannel.loadFollows()
            .map {
                User(
                    channelId = it.userId,
                    channelLogin = it.userLogin,
                    channelName = it.userName,
                    followLocal = true
                )
            }
            .toMutableList()

        val sorted = if (order == "asc") {
            when (sort) {
                "login" -> list.sortedWith(compareBy(nullsLast()) { it.channelLogin })
                else -> list.sortedWith(compareBy(nullsLast()) { it.channelName })
            }
        } else {
            when (sort) {
                "login" -> list.sortedWith(compareByDescending(nullsFirst()) { it.channelLogin })
                else -> list.sortedWith(compareByDescending(nullsFirst()) { it.channelName })
            }
        }

        return LoadResult.Page(
            data = sorted,
            prevKey = null,
            nextKey = null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
