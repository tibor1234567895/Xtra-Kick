package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.KickWebsiteSearchMapper

class SearchChannelsDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, User>() {
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            try {
                if (params.key != null && !offset.isNullOrBlank() && useLegacyKickSearch) {
                    kickLegacyLoad(params)
                } else if (useLegacyKickSearch) {
                    val result = kickLegacyLoad(params)
                    if (result is LoadResult.Page && KickSearchLoadStrategy.shouldTryNextApi("kick", useLegacyKickSearch, result)) {
                        kickWebsiteLoad()
                    } else {
                        result
                    }
                } else {
                    kickWebsiteLoad()
                }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickWebsiteLoad(): LoadResult<Int, User> {
        offset = null
        val response = kickRepository.searchWebsite(query)
        return LoadResult.Page(
            data = response.channels.map { KickWebsiteSearchMapper.toUser(it) },
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun kickLegacyLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        var page = params.key ?: 1
        var nextPage: Int? = page
        val users = linkedMapOf<String, User>()
        var scannedPages = 0
        while (users.size < params.loadSize && nextPage != null && scannedPages < 5) {
            val response = kickRepository.getLivestreams(page = page, limit = params.loadSize, sort = "desc")
            response.data
                .filter { kickRepository.matchesQuery(it, query) }
                .forEach { stream ->
                    val channelId = stream.channel?.id?.toString() ?: stream.channelId?.toString() ?: return@forEach
                    if (!users.containsKey(channelId)) {
                        users[channelId] = User(
                            channelId = channelId,
                            channelLogin = stream.channel?.slug,
                            channelName = stream.channel?.user?.username,
                            profileImageUrl = stream.channel?.user?.profileImage,
                            isLive = true
                        )
                    }
                }
            scannedPages += 1
            nextPage = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else {
                null
            }
            page += 1
        }
        return LoadResult.Page(
            data = users.values.take(params.loadSize),
            prevKey = null,
            nextKey = nextPage
        )
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
