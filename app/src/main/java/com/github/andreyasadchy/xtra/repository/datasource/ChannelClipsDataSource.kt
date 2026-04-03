package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.type.ClipsPeriod
import com.github.andreyasadchy.xtra.model.ui.Clip
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import kotlin.math.max

class ChannelClipsDataSource(
    private val channelId: String?,
    private val channelLogin: String?,
    private val gqlQueryPeriod: ClipsPeriod?,
    private val gqlPeriod: String?,
    private val startedAt: String?,
    private val endedAt: String?,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Clip>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Clip> {
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
                cursor = offset,
            ) ?: return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
            val startMs = startedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
            val endMs = endedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
            val list = page.clips
                .asSequence()
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
            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = if (!offset.isNullOrBlank() && page.clips.isNotEmpty()) {
                    (params.key ?: 1) + 1
                } else null
            )
        } catch (_: Exception) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Clip> {
        api = apiPref
        return when (apiPref) {
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = graphQLRepository.loadQueryUserClips(networkLibrary, gqlHeaders, channelId, channelLogin.takeIf { channelId.isNullOrBlank() }, gqlQueryPeriod, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.user!!
        val items = data.clips!!.edges!!
        val list = items.mapNotNull { item ->
            item?.node?.let {
                Clip(
                    id = it.slug,
                    channelId = channelId,
                    channelLogin = data.login,
                    channelName = data.displayName,
                    videoId = it.video?.id,
                    vodOffset = if (it.videoOffsetSeconds != null && it.durationSeconds != null) {
                        max(it.videoOffsetSeconds - it.durationSeconds, 0) // api is returning wrong offset
                    } else {
                        it.videoOffsetSeconds
                    },
                    gameId = it.game?.id,
                    gameSlug = it.game?.slug,
                    gameName = it.game?.displayName,
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt?.toString(),
                    duration = it.durationSeconds?.toDouble(),
                    thumbnailUrl = it.thumbnailURL,
                    profileImageUrl = data.profileImageURL,
                    videoAnimatedPreviewURL = it.video?.animatedPreviewURL
                )
            }
        }
        offset = items.lastOrNull()?.cursor?.toString()
        val nextPage = data.clips.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = graphQLRepository.loadChannelClips(networkLibrary, gqlHeaders, channelLogin, gqlPeriod, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.user
        val items = data.clips!!.edges
        val list = items.map { item ->
            item.node.let {
                Clip(
                    id = it.slug,
                    channelId = channelId,
                    channelLogin = it.broadcaster?.login,
                    channelName = it.broadcaster?.displayName,
                    gameId = it.game?.id,
                    gameSlug = it.game?.slug,
                    gameName = it.game?.name,
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt,
                    duration = it.durationSeconds,
                    thumbnailUrl = it.thumbnailURL,
                    profileImageUrl = it.broadcaster?.profileImageURL,
                )
            }
        }
        offset = items.lastOrNull()?.cursor
        val nextPage = data.clips.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = helixRepository.getClips(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            channelId = channelId,
            startedAt = startedAt,
            endedAt = endedAt,
            limit = params.loadSize,
            offset = offset,
        )
        val games = response.data.mapNotNull { it.gameId }.let {
            helixRepository.getGames(
                networkLibrary = networkLibrary,
                headers = helixHeaders,
                ids = it,
            ).data
        }
        val list = response.data.map {
            Clip(
                id = it.id,
                channelId = channelId,
                channelLogin = channelLogin,
                channelName = it.channelName,
                videoId = it.videoId,
                vodOffset = if (it.vodOffset != null && it.duration != null) {
                    max(it.vodOffset - it.duration.toInt(), 0)
                } else {
                    it.vodOffset
                },
                gameId = it.gameId,
                gameName = it.gameId?.let { id ->
                    games.find { game -> game.id == id }?.name
                },
                title = it.title,
                viewCount = it.viewCount,
                uploadDate = it.createdAt,
                duration = it.duration,
                thumbnailUrl = it.thumbnailUrl,
            )
        }
        offset = response.pagination?.cursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank()) {
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
