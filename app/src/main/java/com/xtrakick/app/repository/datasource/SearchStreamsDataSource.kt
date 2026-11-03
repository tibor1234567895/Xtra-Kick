package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.kick.KickEvent
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebsiteSearchMapper
import kotlinx.coroutines.CancellationException
import com.xtrakick.app.util.AppConstants

class SearchStreamsDataSource(
    private val query: String,
    private val kickRepository: KickRepository,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<String, Stream>() {
    private var matchingEvents: List<KickEvent>? = null
    private val emittedEventChannels = mutableSetOf<String>()
    private val languageCodes = StreamsDataSource.requestedLanguageCodes(null, listOf(query))
    private val languageSource = if (!useLegacyKickSearch && languageCodes.isNotEmpty()) {
        StreamsDataSource("VIEWER_COUNT", languages = languageCodes.toTypedArray(), kickRepository = kickRepository,
            apiPref = listOf(AppConstants.KICK))
    } else null

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Stream> {
        if (query.isBlank()) return LoadResult.Page(emptyList(), null, null)
        return try {
            languageSource?.let { source ->
                val key = params.key?.toIntOrNull()
                val request = when (params) {
                    is LoadParams.Refresh -> LoadParams.Refresh(key, params.loadSize, params.placeholdersEnabled)
                    is LoadParams.Append -> LoadParams.Append(requireNotNull(key), params.loadSize, params.placeholdersEnabled)
                    is LoadParams.Prepend -> LoadParams.Prepend(requireNotNull(key), params.loadSize, params.placeholdersEnabled)
                }
                return when (val result = source.load(request)) {
                    is LoadResult.Page -> LoadResult.Page(result.data, result.prevKey?.toString(), result.nextKey?.toString())
                    is LoadResult.Error -> LoadResult.Error(result.throwable)
                    is LoadResult.Invalid -> LoadResult.Invalid()
                }
            }
            if (useLegacyKickSearch) {
                loadDirectory(params)
            } else {
                val events = matchingEvents ?: try {
                    kickRepository.getSearchEvents().filter { KickWebsiteSearchMapper.matchesEvent(it, query) }
                        .also { matchingEvents = it }
                } catch (e: CancellationException) {
                    throw e
                } catch (_: Exception) {
                    emptyList()
                }
                if (events.isNotEmpty()) return loadEvent(params, events)
                val streams = kickRepository.searchWebsite(query).livestreams.tags
                    .filter { StreamsDataSource.matchesSearchTag(it, query) }
                    .distinctBy { it.channel?.id ?: it.channelId ?: it.id }
                    .map { KickWebsiteSearchMapper.toStream(it) }
                LoadResult.Page(data = streams, prevKey = null, nextKey = null)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun loadEvent(params: LoadParams<String>, events: List<KickEvent>): LoadResult<String, Stream> {
        val eventIndex = params.key?.substringBefore(':')?.toIntOrNull() ?: 0
        val cursor = params.key?.substringAfter(':', "")?.takeIf { it.isNotBlank() }
        val event = events[eventIndex]
        val response = kickRepository.getEventStreams(event.id, cursor)
        val streams = kickRepository.toEventStreams(event, response.streams)
            .filter { stream ->
                val key = stream.channelId ?: stream.channelLogin ?: return@filter false
                emittedEventChannels.add(key)
            }
        val nextKey = when {
            !response.nextCursor.isNullOrBlank() && response.nextCursor != cursor -> "$eventIndex:${response.nextCursor}"
            eventIndex + 1 < events.size -> "${eventIndex + 1}:"
            else -> null
        }
        return LoadResult.Page(data = streams, prevKey = null, nextKey = nextKey)
    }

    private suspend fun loadDirectory(params: LoadParams<String>): LoadResult<String, Stream> {
        var page = params.key?.toIntOrNull() ?: 1
        var nextPage: Int? = page
        val streams = mutableListOf<Stream>()
        var scannedPages = 0
        while (streams.size < minOf(params.loadSize, 8) && nextPage != null && scannedPages < 8) {
            val response = kickRepository.getLivestreams(page = page, limit = params.loadSize, sort = "desc")
            streams += response.data
                .filter { StreamsDataSource.matchesSearchTag(it, query) }
                .map { kickRepository.toStream(it) }
            scannedPages++
            nextPage = if (!response.nextPageUrl.isNullOrBlank()) page + 1 else null
            page++
        }
        return LoadResult.Page(data = streams, prevKey = null, nextKey = nextPage?.toString())
    }

    override fun getRefreshKey(state: PagingState<String, Stream>): String? = null
}
