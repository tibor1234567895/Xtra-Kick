package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.SearchVideosQuery
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C

class SearchVideosDataSource(
    private val query: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Video>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            if (params.key != null && !offset.isNullOrBlank()) {
                try {
                    loadFromApi(api, params)
                } catch (e: Exception) {
                    LoadResult.Error(e)
                }
            } else {
                val apisToTry = apiPref
                    .filter { it == C.KICK || it == C.GQL || it == C.GQL_PERSISTED_QUERY }
                    .let { if (it.contains(C.KICK)) it else listOf(C.KICK) + it }
                    .ifEmpty { listOf(C.KICK) }
                var lastError: Exception? = null
                var emptyResult: LoadResult.Page<Int, Video>? = null
                apisToTry.forEach { pref ->
                    try {
                        val result = loadFromApi(pref, params)
                        if (result is LoadResult.Page && KickSearchLoadStrategy.shouldTryNextApi(pref, false, result)) {
                            emptyResult = emptyResult ?: result
                        } else {
                            return result
                        }
                    } catch (e: Exception) {
                        lastError = e
                    }
                }
                emptyResult ?: LoadResult.Error(lastError ?: Exception("No enabled APIs"))
            }
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Video> {
        api = apiPref
        return when (apiPref) {
            C.KICK -> kickLoad(params)
            C.GQL -> gqlQueryLoad(params)
            C.GQL_PERSISTED_QUERY -> gqlLoad(params)
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        offset = null
        val response = kickRepository.searchWebsite(query)
        val videosById = linkedMapOf<String, Video>()
        val perChannelLimit = params.loadSize.coerceAtMost(15).coerceAtLeast(10)
        response.channels
            .asSequence()
            .filter { !it.slug.isNullOrBlank() }
            .take(5)
            .forEach { channel ->
                val videos = runCatching {
                    kickRepository.getChannelVideosPage(
                        channelSlug = channel.slug.orEmpty(),
                        channelId = channel.id?.toString() ?: channel.userId?.toString(),
                        limit = perChannelLimit
                    )
                }.getOrNull()?.videos.orEmpty()
                videos
                    .filter { matchesVideoQuery(it, query) }
                    .forEach { video ->
                        val key = video.id?.takeIf { it.isNotBlank() }
                            ?: "${video.channelLogin}:${video.title}:${video.uploadDate}"
                        if (videosById[key] == null) {
                            videosById[key] = video
                        }
                    }
                if (videosById.size >= params.loadSize) return@forEach
            }
        return LoadResult.Page(
            data = videosById.values
                .sortedByDescending { it.uploadDate }
                .take(params.loadSize),
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val response = graphQLRepository.loadQuerySearchVideos(networkLibrary, gqlHeaders, query, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.searchFor?.videos
        val list = data?.items.orEmpty().map { it.toVideo() }
        offset = data?.cursor
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
        val response = graphQLRepository.loadSearchVideos(networkLibrary, gqlHeaders, query, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.searchFor?.videos
        val list = data?.edges.orEmpty().map { item ->
            Video(
                id = item.item.id,
                channelId = item.item.owner?.id,
                channelLogin = item.item.owner?.login,
                channelName = item.item.owner?.displayName,
                title = item.item.title,
                uploadDate = item.item.createdAt,
                thumbnailUrl = item.item.previewThumbnailURL,
                viewCount = item.item.viewCount,
                type = "ARCHIVE",
                duration = item.item.lengthSeconds?.toString(),
                gameId = item.item.game?.id,
                gameSlug = item.item.game?.slug,
                gameName = item.item.game?.displayName
            )
        }
        offset = data?.cursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private fun SearchVideosQuery.Item.toVideo(): Video {
        return Video(
            id = id,
            channelId = owner?.id,
            channelLogin = owner?.login,
            channelName = owner?.displayName,
            title = title,
            uploadDate = createdAt?.toString(),
            thumbnailUrl = previewThumbnailURL,
            viewCount = viewCount,
            type = "ARCHIVE",
            duration = lengthSeconds?.toString(),
            gameId = game?.id,
            gameSlug = game?.slug,
            gameName = game?.displayName,
            profileImageUrl = owner?.profileImageURL,
            animatedPreviewURL = animatedPreviewURL
        )
    }

    private fun matchesVideoQuery(item: Video, query: String): Boolean {
        val value = query.trim()
        if (value.isBlank()) return true
        return item.title?.contains(value, ignoreCase = true) == true ||
                item.channelLogin?.contains(value, ignoreCase = true) == true ||
                item.channelName?.contains(value, ignoreCase = true) == true ||
                item.gameName?.contains(value, ignoreCase = true) == true
    }

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
