package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.type.BroadcastType
import com.github.andreyasadchy.xtra.graphql.type.VideoSort
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper

class ChannelVideosDataSource(
    private val channelId: String?,
    private val channelLogin: String?,
    private val gqlQueryType: BroadcastType?,
    private val gqlQuerySort: VideoSort?,
    private val gqlType: String?,
    private val gqlSort: String?,
    private val helixPeriod: String,
    private val helixBroadcastTypes: String,
    private val helixSort: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Video>() {
    private var api: String? = null
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

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Video> {
        api = apiPref
        return when (apiPref) {
            C.KICK -> if (helixPeriod == "all") kickLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val login = channelLogin?.takeIf { it.isNotBlank() } ?: throw Exception()
        val now = System.currentTimeMillis()
        val periodStart = when (helixPeriod) {
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
                when (helixBroadcastTypes) {
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
                when (helixSort) {
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

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = graphQLRepository.loadQueryUserVideos(networkLibrary, gqlHeaders, channelId, channelLogin.takeIf { channelId.isNullOrBlank() }, gqlQuerySort, gqlQueryType?.let { listOf(it) }, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.user!!
        val items = data.videos!!.edges!!
        val list = items.mapNotNull { item ->
            item?.node?.let {
                Video(
                    id = it.id,
                    channelId = channelId,
                    channelLogin = data.login,
                    channelName = data.displayName,
                    gameId = it.game?.id,
                    gameSlug = it.game?.slug,
                    gameName = it.game?.displayName,
                    type = it.broadcastType?.toString(),
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt?.toString(),
                    duration = it.lengthSeconds?.toString(),
                    thumbnailUrl = it.previewThumbnailURL,
                    profileImageUrl = data.profileImageURL,
                    animatedPreviewURL = it.animatedPreviewURL
                )
            }
        }
        offset = items.lastOrNull()?.cursor?.toString()
        val nextPage = data.videos.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = graphQLRepository.loadChannelVideos(networkLibrary, gqlHeaders, channelLogin, gqlType, gqlSort, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.user
        val items = data.videos!!.edges
        val list = items.map { item ->
            item.node.let {
                Video(
                    id = it.id,
                    channelId = it.owner?.id,
                    channelLogin = it.owner?.login,
                    channelName = it.owner?.displayName,
                    gameId = it.game?.id,
                    gameSlug = it.game?.slug,
                    gameName = it.game?.displayName,
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.publishedAt,
                    duration = it.lengthSeconds?.toString(),
                    thumbnailUrl = it.previewThumbnailURL,
                    profileImageUrl = it.owner?.profileImageURL,
                    animatedPreviewURL = it.animatedPreviewURL
                )
            }
        }
        offset = items.lastOrNull()?.cursor
        val nextPage = data.videos.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = helixRepository.getVideos(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            channelId = channelId,
            period = helixPeriod,
            broadcastType = helixBroadcastTypes,
            sort = helixSort,
            limit = params.loadSize,
            offset = offset,
        )
        val list = response.data.map {
            Video(
                id = it.id,
                channelId = channelId,
                channelLogin = it.channelLogin,
                channelName = it.channelName,
                title = it.title,
                viewCount = it.viewCount,
                uploadDate = it.uploadDate,
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

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
