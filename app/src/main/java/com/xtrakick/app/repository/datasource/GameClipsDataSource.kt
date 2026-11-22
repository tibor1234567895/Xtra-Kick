package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.ClipsPeriod
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.KickApiHelper
import kotlinx.coroutines.CancellationException
import java.io.IOException

class GameClipsDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val sort: String?,
    private val gqlQueryPeriod: ClipsPeriod?,
    private val gqlPeriod: String?,
    private val startedAt: String?,
    private val endedAt: String?,
    private val kickRepository: KickRepository,
) : PagingSource<String, Clip>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Clip> {
        if (gameId.isNullOrBlank() && gameSlug.isNullOrBlank() && gameName.isNullOrBlank()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
        return try {
            kickLoad(params)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun kickLoad(params: LoadParams<String>): LoadResult<String, Clip> {
        val slug = gameSlug?.takeIf { it.isNotBlank() }
            ?: kickRepository.resolveCategorySlug(gameId, gameName)
            ?: KickApiHelper.toCategorySlug(gameName)
            ?: throw Exception("Could not resolve category slug")
        val kickTime = when (gqlQueryPeriod) {
            ClipsPeriod.LAST_DAY -> "day"
            ClipsPeriod.LAST_WEEK -> "week"
            ClipsPeriod.LAST_MONTH -> "month"
            ClipsPeriod.ALL_TIME -> "all"
            else -> when (gqlPeriod) {
                "LAST_DAY" -> "day"
                "LAST_WEEK" -> "week"
                "LAST_MONTH" -> "month"
                "ALL_TIME" -> "all"
                else -> null
            }
        }
        return loadSortedClipPage(params, sort, startedAt, endedAt) { cursor, limit, serverSort ->
            kickRepository.getCategoryClipsPage(
                categorySlug = slug,
                gameId = gameId,
                gameName = gameName,
                limit = limit,
                sort = serverSort,
                time = kickTime,
                cursor = cursor,
            ) ?: throw IOException("Category clip request failed")
        }
    }

    override fun getRefreshKey(state: PagingState<String, Clip>): String? = null
}
