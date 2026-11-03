package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.repository.KickRepository
import kotlinx.coroutines.CancellationException
import java.io.IOException
import java.util.ArrayDeque
import java.util.Locale

class SearchVideosDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
    private val loadFailureMessage: String,
) : PagingSource<Int, Video>() {
    private data class ChannelPage(val slug: String, val id: String?, val cursor: String? = null)
    private val pending = ArrayDeque<ChannelPage>()
    private val emittedVideoIds = mutableSetOf<String>()
    private val visitedPages = mutableSetOf<Pair<String, String?>>()
    private var initialized = false

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        if (query.isBlank()) return LoadResult.Page(emptyList(), null, null)
        return try {
            if (!initialized) {
                val candidates = try {
                    kickRepository.searchTypesenseChannels(query, page = 1, perPage = 10).hits.mapNotNull { hit ->
                        hit.document.slug?.takeIf { it.isNotBlank() }?.let { ChannelPage(it, hit.document.id) }
                    }
                } catch (error: CancellationException) {
                    throw error
                } catch (_: Exception) {
                    emptyList()
                }
                val channels = candidates.ifEmpty {
                    kickRepository.searchWebsite(query).channels.mapNotNull { channel ->
                        channel.slug?.takeIf { it.isNotBlank() }?.let { ChannelPage(it, channel.id?.toString()) }
                    }
                }
                channels.distinctBy { it.slug.lowercase(Locale.ROOT) }.take(5).forEach(pending::addLast)
                initialized = true
            }
            val failures = mutableListOf<ChannelPage>()
            var lastError: Exception? = null
            var attempts = 0
            while (pending.isNotEmpty() && attempts++ < 5) {
                val request = pending.first
                val response = try {
                    kickRepository.getChannelVideosPage(request.slug, request.id,
                        limit = params.loadSize.coerceIn(20, 50), cursor = request.cursor)
                        ?: throw IOException(loadFailureMessage)
                } catch (error: CancellationException) {
                    throw error
                } catch (error: Exception) {
                    pending.removeFirst()
                    failures += request
                    lastError = error
                    continue
                }
                pending.removeFirst()
                visitedPages += request.slug to request.cursor
                response.nextCursor?.takeIf { it.isNotBlank() && (request.slug to it) !in visitedPages }?.let {
                    pending.addLast(request.copy(cursor = it))
                }
                val videos = response.videos.filter { matchesVideoQuery(it) }.filter { video ->
                    emittedVideoIds.add(video.id?.takeIf { it.isNotBlank() }
                        ?: "${video.channelLogin}:${video.title}:${video.uploadDate}")
                }.sortedByDescending { it.uploadDate }
                if (videos.isNotEmpty()) {
                    failures.forEach(pending::addLast)
                    return LoadResult.Page(videos, null, if (pending.isEmpty()) null else (params.key ?: 1) + 1)
                }
            }
            failures.forEach(pending::addLast)
            if (lastError != null) LoadResult.Error(lastError)
            else LoadResult.Page(emptyList(), null, if (pending.isEmpty()) null else (params.key ?: 1) + 1)
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            LoadResult.Error(error)
        }
    }

    private fun matchesVideoQuery(item: Video): Boolean {
        val value = query.trim()
        return item.title?.contains(value, ignoreCase = true) == true ||
            item.channelLogin?.contains(value, ignoreCase = true) == true ||
            item.channelName?.contains(value, ignoreCase = true) == true ||
            item.gameName?.contains(value, ignoreCase = true) == true
    }

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? = null
}
