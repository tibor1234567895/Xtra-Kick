package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebsiteSearchMapper

class SearchGamesDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, Game>() {

    companion object {
        private const val KEY_WEBSITE_SEARCH = 10000
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
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
                } else if (KickSearchLoadStrategy.useLegacySearch(useLegacyKickSearch)) {
                    kickLegacyLoad(params)
                } else {
                    kickTypesenseLoad(params)
                }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickTypesenseLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val page = params.key ?: 1
        val pageSize = params.loadSize.coerceIn(10, 50)
        return try {
            val result = kickRepository.searchTypesenseCategories(
                query = query,
                page = page,
                perPage = pageSize
            )
            val games = result.hits.map { KickWebsiteSearchMapper.toGame(it.document) }
            val totalFound = result.found ?: 0
            val hasMore = (page * pageSize) < totalFound && games.isNotEmpty()
            val nextKey = if (hasMore) {
                page + 1
            } else {
                KEY_WEBSITE_SEARCH
            }
            val prevKey = if (page > 1) page - 1 else null
            LoadResult.Page(
                data = games,
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

    private suspend fun loadWebsiteSearchResults(): LoadResult<Int, Game> {
        val typesenseSlugs = runCatching {
            kickRepository.searchTypesenseCategories(query, page = 1, perPage = 50).hits
                .mapNotNull { it.document.slug?.lowercase() }
                .toSet()
        }.getOrDefault(emptySet())

        val response = runCatching { kickRepository.searchWebsite(query) }.getOrNull()
        val websiteGames = response?.categories.orEmpty()
            .filter { cat ->
                val slug = cat.slug?.lowercase() ?: return@filter true
                !typesenseSlugs.contains(slug)
            }
            .map { KickWebsiteSearchMapper.toGame(it) }

        return LoadResult.Page(
            data = websiteGames,
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun kickLegacyLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        var page = params.key ?: 1
        var nextPage: Int? = page
        val list = mutableListOf<Game>()
        var scannedPages = 0
        while (list.size < params.loadSize && nextPage != null && scannedPages < 5) {
            val response = kickRepository.getSubcategories(page = page, limit = params.loadSize)
            list.addAll(
                response.data
                    .filter { kickRepository.matchesQuery(it, query) }
                    .map { kickRepository.toGame(it) }
            )
            scannedPages += 1
            nextPage = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else {
                null
            }
            page += 1
        }
        return LoadResult.Page(
            data = list.take(params.loadSize),
            prevKey = null,
            nextKey = nextPage
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
