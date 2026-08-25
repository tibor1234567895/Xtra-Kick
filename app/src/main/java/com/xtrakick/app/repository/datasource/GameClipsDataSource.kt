package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.ClipsPeriod
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.KickApiHelper
import kotlin.math.max

class GameClipsDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val gqlQueryPeriod: ClipsPeriod?,
    private val gqlPeriod: String?,
    private val startedAt: String?,
    private val endedAt: String?,
    private val kickRepository: KickRepository,
) : PagingSource<Int, Clip>() {
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Clip> {
        if (gameId.isNullOrBlank() && gameSlug.isNullOrBlank() && gameName.isNullOrBlank()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
        return try {
            kickLoad(params)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val slug = gameSlug?.takeIf { it.isNotBlank() }
            ?: gameName?.trim()?.lowercase()?.replace(' ', '-')
            ?: throw Exception()
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
        val startMs = startedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
        val endMs = endedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
        val page = kickRepository.getCategoryClipsPage(
            categorySlug = slug,
            gameId = gameId,
            gameName = gameName,
            limit = maxOf(params.loadSize, 20),
            time = kickTime,
            cursor = offset,
        ) ?: return LoadResult.Page(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
        val list = page.clips.asSequence()
            .filter { clip ->
                val ts = clip.uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: return@filter false
                val afterStart = startMs?.let { ts >= it } ?: true
                val beforeEnd = endMs?.let { ts <= it } ?: true
                afterStart && beforeEnd
            }
            .sortedWith(
                compareByDescending<Clip> { it.viewCount ?: -1 }
                    .thenByDescending { it.uploadDate?.let(KickApiHelper::parseIso8601DateUTC) ?: Long.MIN_VALUE }
            )
            .take(params.loadSize)
            .toList()
        offset = page.nextCursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && page.clips.isNotEmpty()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Clip>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
