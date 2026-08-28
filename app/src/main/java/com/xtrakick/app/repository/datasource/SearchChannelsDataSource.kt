package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebsiteSearchMapper

class SearchChannelsDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, User>() {
    private var offset: String? = null

    companion object {
        private const val KEY_WEBSITE_SEARCH = 10000
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val trimmedQuery = query.trim()
        return if (trimmedQuery.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            try {
                val key = params.key ?: 1
                if (key == KEY_WEBSITE_SEARCH) {
                    loadWebsiteSearchResults()
                } else if (params.key != null && !offset.isNullOrBlank() && useLegacyKickSearch) {
                    kickLegacyLoad(params)
                } else if (useLegacyKickSearch) {
                    val result = kickLegacyLoad(params)
                    if (result is LoadResult.Page && KickSearchLoadStrategy.shouldTryNextApi("kick", useLegacyKickSearch, result)) {
                        kickTypesenseLoad(params)
                    } else {
                        result
                    }
                } else {
                    kickTypesenseLoad(params)
                }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickTypesenseLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: 1
        val pageSize = params.loadSize.coerceIn(10, 50)
        return try {
            val result = kickRepository.searchTypesenseChannels(
                query = query,
                page = page,
                perPage = pageSize
            )
            val users = result.hits.map { KickWebsiteSearchMapper.toUser(it.document) }
            val totalFound = result.found ?: 0
            val hasMore = (page * pageSize) < totalFound && users.isNotEmpty()
            val nextKey = if (hasMore) {
                page + 1
            } else {
                KEY_WEBSITE_SEARCH
            }
            val prevKey = if (page > 1) page - 1 else null
            LoadResult.Page(
                data = users,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            if (page == 1) {
                loadWebsiteSearchResults()
            } else {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun loadWebsiteSearchResults(): LoadResult<Int, User> {
        offset = null
        val typesenseSlugs = runCatching {
            kickRepository.searchTypesenseChannels(query, page = 1, perPage = 50).hits
                .mapNotNull { it.document.slug?.lowercase() }
                .toSet()
        }.getOrDefault(emptySet())

        val response = runCatching { kickRepository.searchWebsite(query) }.getOrNull()
        val websiteChannels = response?.channels.orEmpty()
            .filter { ch ->
                val slug = ch.slug?.lowercase() ?: return@filter true
                !typesenseSlugs.contains(slug)
            }
            .map { KickWebsiteSearchMapper.toUser(it) }

        return LoadResult.Page(
            data = websiteChannels,
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
