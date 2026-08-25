package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.BroadcastType
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.KickApiHelper

class ChannelVideosDataSource(
    private val channelId: String?,
    private val channelLogin: String?,
    private val clipPeriod: String,
    private val clipBroadcastTypes: String,
    private val clipSort: String,
    private val kickRepository: KickRepository,
) : PagingSource<Int, Video>() {
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        return if (channelLogin.isNullOrBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else try {
            kickLoad(params)
        } catch (_: Exception) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val login = channelLogin?.takeIf { it.isNotBlank() } ?: throw Exception()
        val now = System.currentTimeMillis()
        val periodStart = when (clipPeriod) {
            "day" -> now - 24L * 60L * 60L * 1000L
            "week" -> now - 7L * 24L * 60L * 60L * 1000L
            "month" -> now - 30L * 24L * 60L * 60L * 1000L
            else -> null
        }
        val desiredCount = params.loadSize
        val aggregated = mutableListOf<Video>()
        val seenIds = mutableSetOf<String>()
        var nextCursor = offset
        var pagesFetched = 0
        do {
            val page = kickRepository.getChannelVideosPage(
                channelSlug = login,
                channelId = channelId,
                limit = maxOf(desiredCount, 30),
                cursor = nextCursor,
            ) ?: break
            page.videos.forEach { video ->
                val id = video.id ?: return@forEach
                if (seenIds.add(id)) {
                    aggregated += video
                }
            }
            nextCursor = page.nextCursor
            pagesFetched++
        } while (aggregated.size < desiredCount && !nextCursor.isNullOrBlank() && pagesFetched < 5)
        val filtered = aggregated
            .asSequence()
            .filter { video ->
                when (clipBroadcastTypes) {
                    "all" -> true
                    "archive" -> video.type.equals("ARCHIVE", true) || video.type.isNullOrBlank()
                    "highlight" -> video.type.equals("HIGHLIGHT", true)
                    "upload" -> video.type.equals("UPLOAD", true)
                    else -> true
                }
            }
            .filter { video ->
                val start = periodStart ?: return@filter true
                val ts = video.uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: return@filter false
                ts >= start
            }
            .let { sequence ->
                when (clipSort) {
                    "views" -> sequence.sortedWith(
                        compareByDescending<Video> { it.viewCount ?: -1 }
                            .thenByDescending { it.uploadDate?.let(KickApiHelper::parseIso8601DateUTC) ?: Long.MIN_VALUE }
                    )
                    else -> sequence.sortedByDescending { it.uploadDate?.let(KickApiHelper::parseIso8601DateUTC) ?: Long.MIN_VALUE }
                }
            }
            .take(desiredCount)
            .toList()
        offset = nextCursor
        return LoadResult.Page(
            data = filtered,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && aggregated.isNotEmpty()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
