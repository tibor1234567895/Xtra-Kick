package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import android.util.Log
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebsiteSearchMapper
import com.xtrakick.app.util.AppConstants

class SearchStreamsDataSource(
    private val query: String,
    private val kickPublicApiHeaders: Map<String, String>,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val networkLibrary: String?,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, Stream>() {
    companion object {
        private const val LOG_TAG = "SearchStreams"
        private const val KICK_PUBLIC_BATCH_SIZE = 50
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            try {
                if (KickSearchLoadStrategy.useLegacySearch(useLegacyKickSearch)) kickLegacyLoad(params) else kickWebsiteLoad(params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickWebsiteLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
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
                    val response = kickPublicApiRepository.getLivestreams(
                        networkLibrary = networkLibrary,
                        headers = kickPublicApiHeaders,
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
                                source = AppConstants.KICK,
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
