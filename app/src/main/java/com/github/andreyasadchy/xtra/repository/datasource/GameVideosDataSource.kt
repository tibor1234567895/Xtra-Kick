package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.type.BroadcastType
import com.github.andreyasadchy.xtra.graphql.type.VideoSort
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.util.C

class GameVideosDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val gqlQueryType: BroadcastType?,
    private val gqlQuerySort: VideoSort?,
    private val gqlLanguages: List<String>?,
    private val gqlType: String?,
    private val gqlSort: String?,
    private val helixPeriod: String,
    private val helixBroadcastTypes: String,
    private val helixLanguage: String?,
    private val helixSort: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Video>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        if (gameId.isNullOrBlank() && gameSlug.isNullOrBlank() && gameName.isNullOrBlank()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
        // Kick categories currently expose livestreams and clips, but not a category videos API.
        return LoadResult.Page(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Video> {
        api = apiPref
        return when (apiPref) {
            C.GQL, C.GQL_PERSISTED_QUERY -> gqlQueryLoad(params)
            C.HELIX -> if (!gameId.isNullOrBlank()) helixLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = graphQLRepository.loadQueryGameVideos(
            networkLibrary = networkLibrary,
            headers = gqlHeaders,
            id = gameId,
            slug = gameSlug.takeIf { gameId.isNullOrBlank() },
            name = gameName.takeIf { gameId.isNullOrBlank() && gameSlug.isNullOrBlank() },
            languages = gqlLanguages,
            sort = gqlQuerySort,
            type = gqlQueryType?.let { listOf(it) },
            first = params.loadSize,
            after = offset
        )
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.game?.videos
        val items = data?.edges.orEmpty()
        val list = items.mapNotNull { item ->
            item?.node?.let {
                Video(
                    id = it.id,
                    channelId = it.owner?.id,
                    channelLogin = it.owner?.login,
                    channelName = it.owner?.displayName,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                    type = it.broadcastType?.toString(),
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt?.toString(),
                    duration = it.lengthSeconds?.toString(),
                    thumbnailUrl = it.previewThumbnailURL,
                    profileImageUrl = it.owner?.profileImageURL,
                    animatedPreviewURL = it.animatedPreviewURL
                )
            }
        }
        offset = items.lastOrNull()?.cursor?.toString()
        val nextPage = data?.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = graphQLRepository.loadGameVideos(
            networkLibrary = networkLibrary,
            headers = gqlHeaders,
            gameSlug = gameSlug,
            type = gqlType,
            sort = gqlSort,
            languages = gqlLanguages,
            limit = params.loadSize,
            cursor = offset,
        )
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.game?.videos
        val items = data?.edges.orEmpty()
        val list = items.map { item ->
            item.node.let {
                Video(
                    id = it.id,
                    channelId = it.owner?.id,
                    channelLogin = it.owner?.login,
                    channelName = it.owner?.displayName,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
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
        val nextPage = data?.pageInfo?.hasNextPage != false
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
            gameId = gameId,
            period = helixPeriod,
            broadcastType = helixBroadcastTypes,
            sort = helixSort,
            language = helixLanguage,
            limit = params.loadSize,
            offset = offset,
        )
        val list = response.data.map {
            Video(
                id = it.id,
                channelId = it.channelId,
                channelLogin = it.channelLogin,
                channelName = it.channelName,
                gameId = gameId,
                gameSlug = gameSlug,
                gameName = gameName,
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
