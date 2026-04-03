package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import android.util.Log
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.KickWebsiteSearchMapper
import com.github.andreyasadchy.xtra.util.C

class SearchStreamsDataSource(
    private val query: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, Stream>() {
    companion object {
        private const val LOG_TAG = "SearchStreams"
        private const val KICK_PUBLIC_BATCH_SIZE = 50
    }

    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
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
                val apisToTry = apiPref.ifEmpty { listOf(C.KICK) }
                var lastError: Exception? = null
                var emptyResult: LoadResult.Page<Int, Stream>? = null
                apisToTry.forEach { pref ->
                    try {
                        val result = loadFromApi(pref, params)
                        if (result is LoadResult.Page && KickSearchLoadStrategy.shouldTryNextApi(pref, useLegacyKickSearch, result)) {
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

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Stream> {
        api = apiPref
        return when (apiPref) {
            C.GQL, C.GQL_PERSISTED_QUERY -> gqlQueryLoad(params)
            C.HELIX -> helixLoad(params)
            C.KICK -> if (KickSearchLoadStrategy.useLegacySearch(useLegacyKickSearch)) kickLegacyLoad(params) else kickWebsiteLoad(params)
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val response = graphQLRepository.loadQuerySearchStreams(networkLibrary, gqlHeaders, query, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.searchStreams!!
        val list = data.edges!!.mapNotNull { item ->
            item.node?.let {
                Stream(
                    id = it.id,
                    channelId = it.broadcaster?.id,
                    channelLogin = it.broadcaster?.login,
                    channelName = it.broadcaster?.displayName,
                    gameId = it.game?.id,
                    gameSlug = it.game?.slug,
                    gameName = it.game?.displayName,
                    title = it.broadcaster?.broadcastSettings?.title,
                    viewerCount = it.viewersCount,
                    startedAt = it.createdAt?.toString(),
                    thumbnailUrl = it.previewImageURL,
                    profileImageUrl = it.broadcaster?.profileImageURL,
                    tags = it.freeformTags?.mapNotNull { tag -> tag.name }
                )
            }
        }
        offset = data.edges.lastOrNull()?.cursor?.toString()
        val nextPage = data.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val response = helixRepository.getSearchChannels(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            query = query,
            limit = params.loadSize,
            offset = offset,
            live = true,
        )
        val list = response.data.mapNotNull {
            if (it.isLive == true) {
                Stream(
                    channelId = it.channelId,
                    channelLogin = it.channelLogin,
                    channelName = it.channelName,
                    gameId = it.gameId,
                    gameName = it.gameName,
                    title = it.title,
                    startedAt = it.startedAt,
                    profileImageUrl = it.profileImageUrl,
                    tags = it.tags
                )
            } else null
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

    private suspend fun kickWebsiteLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        offset = null
        val kickResponse = kickRepository.searchWebsite(query)
        val streamsByChannel = linkedMapOf<String, Stream>()
        kickResponse.livestreams.tags
            .map { KickWebsiteSearchMapper.toStream(it) }
            .forEach { stream ->
                streamIdentity(
                    channelId = stream.channelId,
                    channelLogin = stream.channelLogin,
                    fallback = stream.id
                )?.let { key ->
                    if (streamsByChannel[key] == null) {
                        streamsByChannel[key] = stream
                    }
                }
            }
        val liveChannels = kickResponse.channels
            .asSequence()
            .filter { it.isLive == true }
            .filter { !it.slug.isNullOrBlank() }
            .toList()
        val unresolvedChannels = liveChannels
            .filter { channel ->
                val channelKey = streamIdentity(
                    channelId = channel.id?.toString() ?: channel.userId?.toString(),
                    channelLogin = channel.slug,
                    fallback = null
                ) ?: return@filter false
                !streamsByChannel.containsKey(channelKey)
            }

        val publicBatchIds = unresolvedChannels
            .mapNotNull { it.userId?.toString() }
            .distinct()
        if (publicBatchIds.isNotEmpty()) {
            runCatching {
                publicBatchIds.chunked(KICK_PUBLIC_BATCH_SIZE).forEach { batch ->
                    val response = helixRepository.getLivestreams(
                        networkLibrary = networkLibrary,
                        headers = helixHeaders,
                        broadcasterUserIds = batch,
                        limit = batch.size,
                        sort = "viewer_count",
                    )
                    response.data.forEach { item ->
                        val broadcasterId = item.broadcasterUserId?.toString() ?: return@forEach
                        val matchedChannel = unresolvedChannels.find { it.userId?.toString() == broadcasterId } ?: return@forEach
                        val channelKey = streamIdentity(
                            channelId = matchedChannel.id?.toString() ?: matchedChannel.userId?.toString(),
                            channelLogin = matchedChannel.slug,
                            fallback = null
                        ) ?: return@forEach
                        if (streamsByChannel[channelKey] == null) {
                            streamsByChannel[channelKey] = Stream(
                                id = item.channelId?.toString(),
                                source = C.KICK,
                                channelId = item.broadcasterUserId.toString(),
                                channelLogin = item.slug ?: matchedChannel.slug,
                                channelName = matchedChannel.user?.username ?: item.slug,
                                gameId = item.category?.id?.toString(),
                                gameSlug = null,
                                gameName = item.category?.name,
                                title = item.streamTitle,
                                viewerCount = item.viewerCount,
                                startedAt = item.startedAt,
                                thumbnailUrl = item.thumbnail,
                                profileImageUrl = item.profilePicture ?: matchedChannel.user?.profileImage,
                                tags = item.customTags,
                            )
                        }
                    }
                }
            }.onFailure { error ->
                Log.w(LOG_TAG, "Kick website stream search batch enrichment failed, using per-channel fallback: ${error.message}")
            }
        }

        liveChannels
            .asSequence()
            .forEach { channel ->
                if (streamsByChannel.size >= params.loadSize) return@forEach
                val channelKey = streamIdentity(
                    channelId = channel.id?.toString() ?: channel.userId?.toString(),
                    channelLogin = channel.slug,
                    fallback = null
                ) ?: return@forEach
                if (streamsByChannel.containsKey(channelKey)) return@forEach
                val livestream = runCatching { kickRepository.getChannelLivestream(channel.slug.orEmpty()) }.getOrNull() ?: return@forEach
                streamsByChannel[channelKey] = KickWebsiteSearchMapper.toStream(channel, livestream)
            }
        return LoadResult.Page(
            data = streamsByChannel.values.take(params.loadSize),
            prevKey = null,
            nextKey = null
        )
    }

    private fun streamIdentity(channelId: String?, channelLogin: String?, fallback: String?): String? {
        return channelId?.takeIf { it.isNotBlank() }
            ?: channelLogin?.takeIf { it.isNotBlank() }?.lowercase()
            ?: fallback?.takeIf { it.isNotBlank() }
    }

    private suspend fun kickLegacyLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        var page = params.key ?: 1
        var nextPage: Int? = page
        val list = mutableListOf<Stream>()
        var scannedPages = 0
        while (list.size < params.loadSize && nextPage != null && scannedPages < 5) {
            val response = kickRepository.getLivestreams(page = page, limit = params.loadSize, sort = "desc")
            list.addAll(
                response.data
                    .filter { kickRepository.matchesQuery(it, query) }
                    .map { kickRepository.toStream(it) }
            )
            scannedPages += 1
            nextPage = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else {
                null
            }
            page += 1
        }
        return LoadResult.Page(
            data = list.take(params.loadSize),
            prevKey = null,
            nextKey = nextPage
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
