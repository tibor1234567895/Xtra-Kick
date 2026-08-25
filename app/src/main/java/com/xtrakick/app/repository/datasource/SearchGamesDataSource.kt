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

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            try {
                if (KickSearchLoadStrategy.useLegacySearch(useLegacyKickSearch)) kickLegacyLoad(params) else kickWebsiteLoad()
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickWebsiteLoad(): LoadResult<Int, Game> {
        val response = kickRepository.searchWebsite(query)
        return LoadResult.Page(
            data = response.categories.map { KickWebsiteSearchMapper.toGame(it) },
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
