package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.repository.KickRepository

class SearchVideosDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
) : PagingSource<Int, Video>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            try {
                kickLoad(params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Video> {
        val candidateChannelSlugs = linkedSetOf<Pair<String, String?>>()
        runCatching {
            kickRepository.searchTypesenseChannels(query, page = 1, perPage = 10).hits.map { it.document }
        }.getOrNull()?.forEach { doc ->
            val slug = doc.slug?.takeIf { it.isNotBlank() } ?: return@forEach
            candidateChannelSlugs.add(slug to doc.id)
        }

        if (candidateChannelSlugs.isEmpty()) {
            val response = runCatching { kickRepository.searchWebsite(query) }.getOrNull()
            response?.channels.orEmpty().forEach { channel ->
                val slug = channel.slug?.takeIf { it.isNotBlank() } ?: return@forEach
                candidateChannelSlugs.add(slug to (channel.id?.toString() ?: channel.userId?.toString()))
            }
        }

        val videosById = linkedMapOf<String, Video>()
        val perChannelLimit = params.loadSize.coerceAtMost(15).coerceAtLeast(10)
        candidateChannelSlugs
            .take(5)
            .forEach { (slug, id) ->
                val videos = runCatching {
                    kickRepository.getChannelVideosPage(
                        channelSlug = slug,
                        channelId = id,
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
