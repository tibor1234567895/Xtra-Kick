package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import java.util.Locale

class GamesDataSource(
    private val tags: List<String>?,
    private val kickRepository: KickRepository,
    private val apiPref: List<String>,
) : PagingSource<Int, Game>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return if (!offset.isNullOrBlank()) {
            try {
                loadFromApi(api, params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        } else {
            val apisToTry = listOf(AppConstants.KICK)
            var lastError: Exception? = null
            apisToTry.forEach { pref ->
                try {
                    return loadFromApi(pref, params)
                } catch (e: Exception) {
                    lastError = e
                }
            }
            LoadResult.Error(lastError ?: Exception("No enabled APIs"))
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Game> {
        api = apiPref
        return when (apiPref) {
            AppConstants.KICK -> kickLoad(params)
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val page = params.key ?: 1
        val response = kickRepository.getSubcategories(page = page, limit = params.loadSize)
        val list = response.data
            .map { kickRepository.toGame(it) }
            .filter { game ->
                if (tags.isNullOrEmpty()) true
                else {
                    val gameTags = game.tags.orEmpty().mapNotNull { it.name?.trim()?.lowercase(Locale.ROOT) }
                    tags.any { tag -> gameTags.contains(tag.trim().lowercase(Locale.ROOT)) }
                }
            }
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
