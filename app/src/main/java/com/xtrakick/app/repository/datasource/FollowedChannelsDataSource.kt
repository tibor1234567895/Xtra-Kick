package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.LocalFollowChannelRepository

class FollowedChannelsDataSource(
    private val sort: String,
    private val order: String,
    private val localFollowsChannel: LocalFollowChannelRepository,
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val follows = localFollowsChannel.loadFollows()
        val list = follows.map { FollowedChannelRow(it.toUser(), it.id) }
        val sorted = list.sortedForFilter().map { it.user }

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

    private fun LocalFollowChannel.toUser(): User {
        return User(
            channelId = userId,
            channelLogin = userLogin,
            channelName = userName,
            profileImageUrl = channelLogo,
            followLocal = true,
        )
    }

    private fun List<FollowedChannelRow>.sortedForFilter(): List<FollowedChannelRow> {
        val nameComparator = compareBy<FollowedChannelRow, String?>(nullsLast(String.CASE_INSENSITIVE_ORDER)) { it.user.channelLogin }
            .thenBy(nullsLast(String.CASE_INSENSITIVE_ORDER)) { it.user.channelName }
        return when (sort) {
            "created_at" -> {
                if (order == "asc") sortedBy { it.followId } else sortedByDescending { it.followId }
            }
            "login" -> {
                if (order == "asc") sortedWith(nameComparator) else sortedWith(nameComparator.reversed())
            }
            else -> {
                sortedWith(nameComparator)
            }
        }
    }

    private data class FollowedChannelRow(
        val user: User,
        val followId: Int,
    )
}
