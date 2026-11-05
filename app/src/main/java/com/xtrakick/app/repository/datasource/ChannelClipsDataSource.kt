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
            val page = kickRepository.getChannelClipsPage(
                channelSlug = channelLogin,
                channelId = channelId,
                limit = maxOf(params.loadSize, 20),
                time = kickTime,
                cursor = params.key,
            ) ?: throw IOException("Channel clip request failed")
            val startMs = startedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
            val endMs = endedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
            val list = page.clips
                .asSequence()
                .filter { clip ->
                    if (startMs == null && endMs == null) return@filter true
                    val ts = clip.uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: return@filter false
                    val afterStart = startMs?.let { ts >= it } ?: true
                    val beforeEnd = endMs?.let { ts <= it } ?: true
                    afterStart && beforeEnd
                }
                .sortedWith(
                    compareByDescending<Clip> { it.viewCount ?: -1 }
                        .thenByDescending { it.uploadDate?.let(KickApiHelper::parseIso8601DateUTC) ?: Long.MIN_VALUE }
                )
                .toList()
            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = page.nextCursor?.takeIf { it.isNotBlank() && it != params.key && page.clips.isNotEmpty() }
            )
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            LoadResult.Error(error)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Clip>): String? = null
}
