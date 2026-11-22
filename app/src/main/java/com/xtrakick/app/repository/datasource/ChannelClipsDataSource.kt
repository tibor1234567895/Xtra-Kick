package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.ClipsPeriod
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.KickApiHelper
import kotlinx.coroutines.CancellationException
import java.io.IOException

class ChannelClipsDataSource(
    private val channelId: String?,
    private val channelLogin: String?,
    private val sort: String?,
    private val gqlQueryPeriod: ClipsPeriod?,
    private val gqlPeriod: String?,
    private val startedAt: String?,
    private val endedAt: String?,
    private val kickRepository: KickRepository,
) : PagingSource<String, Clip>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Clip> {
        if (channelLogin.isNullOrBlank()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
        return try {
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
            loadSortedClipPage(params, sort, startedAt, endedAt) { cursor, limit, serverSort ->
                kickRepository.getChannelClipsPage(
                    channelSlug = channelLogin,
                    channelId = channelId,
                    limit = limit,
                    sort = serverSort,
                    time = kickTime,
                    cursor = cursor,
                ) ?: throw IOException("Channel clip request failed")
            }
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            LoadResult.Error(error)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Clip>): String? = null
}

internal const val RECENT_CLIP_SORT_LIMIT = 100
private const val RECENT_CLIP_PAGE_SIZE = 20

internal suspend fun loadSortedClipPage(
    params: PagingSource.LoadParams<String>,
    sort: String?,
    startedAt: String?,
    endedAt: String?,
    fetch: suspend (cursor: String?, limit: Int, sort: String?) -> KickRepository.KickClipPage,
): PagingSource.LoadResult.Page<String, Clip> {
    val sortRecent = sort in setOf("time", "date", "duration")
    var cursor = params.key
    val clips = mutableListOf<Clip>()
    val cursors = mutableSetOf(cursor)
    var remainingPages = if (sortRecent) RECENT_CLIP_SORT_LIMIT / RECENT_CLIP_PAGE_SIZE else 1
    while (remainingPages > 0) {
        val page = fetch(
            cursor,
            if (sortRecent) RECENT_CLIP_PAGE_SIZE else maxOf(params.loadSize, RECENT_CLIP_PAGE_SIZE),
            if (sortRecent) "time" else sort,
        )
        clips.addAll(page.clips)
        cursor = page.nextCursor?.takeIf { next -> next.isNotBlank() && page.clips.isNotEmpty() && cursors.add(next) }
        remainingPages--
        if (cursor == null) break
    }
    val start = startedAt?.let(KickApiHelper::parseIso8601DateUTC)
    val end = endedAt?.let(KickApiHelper::parseIso8601DateUTC)
    val comparator = when (sort) {
        "time", "date" -> compareByDescending<Pair<Clip, Long>> { it.second }
            .thenByDescending { it.first.viewCount ?: -1 }
        "duration" -> compareByDescending<Pair<Clip, Long>> { it.first.duration ?: -1.0 }
            .thenByDescending { it.second }
        else -> compareByDescending<Pair<Clip, Long>> { it.first.viewCount ?: -1 }
            .thenByDescending { it.second }
    }
    val sorted = clips.asSequence()
        .distinctBy { it.id }
        .take(if (sortRecent) RECENT_CLIP_SORT_LIMIT else clips.size)
        .mapNotNull { clip ->
            val date = clip.uploadDate?.let(KickApiHelper::parseIso8601DateUTC)
            if (date == null && (start != null || end != null)) return@mapNotNull null
            val timestamp = date ?: Long.MIN_VALUE
            if (start != null && timestamp < start) return@mapNotNull null
            if (end != null && timestamp > end) return@mapNotNull null
            clip to timestamp
        }
        .sortedWith(comparator)
        .map { it.first }
        .toList()
    return PagingSource.LoadResult.Page(sorted, prevKey = null, nextKey = if (sortRecent) null else cursor)
}
