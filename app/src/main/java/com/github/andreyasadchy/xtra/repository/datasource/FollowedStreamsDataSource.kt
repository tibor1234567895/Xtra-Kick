package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import java.util.Locale
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class FollowedStreamsDataSource(
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickRepository: KickRepository,
) : PagingSource<Int, Stream>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        return try {
            kickLoad()
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun kickLoad(): LoadResult<Int, Stream> {
        val follows = localFollowsChannel.loadFollows()
        val followsByLogin = follows.mapNotNull { it.userLogin?.lowercase(Locale.ROOT) }.toSet()
        val followsById = follows.mapNotNull { it.userId }.toSet()

        val indexedLive = mutableMapOf<String, Stream>()
        runCatching {
            val pages = coroutineScope {
                (1..8).map { page ->
                    async {
                        kickRepository.getLivestreams(page = page, limit = 100, sort = "desc")
                    }
                }.awaitAll()
            }
            pages.forEach { live ->
                live.data.forEach { item ->
                    val stream = kickRepository.toStream(item)
                    val login = stream.channelLogin?.lowercase(Locale.ROOT)
                    val id = stream.channelId
                    val matched = (login != null && followsByLogin.contains(login)) || (id != null && followsById.contains(id))
                    if (matched) {
                        val key = login ?: id ?: stream.id ?: return@forEach
                        indexedLive[key] = stream
                    }
                }
            }
        }

        val semaphore = Semaphore(8)
        val streams = coroutineScope {
            follows.map { follow ->
                async {
                    semaphore.withPermit {
                        val login = follow.userLogin?.takeIf { it.isNotBlank() }
                        val id = follow.userId?.takeIf { it.isNotBlank() }
                        val key = login?.lowercase(Locale.ROOT) ?: id
                        key?.let { indexedLive[it] }?.let { return@withPermit it }
                        val channel = try {
                            when {
                                !login.isNullOrBlank() -> kickRepository.getChannel(login)
                                !id.isNullOrBlank() -> kickRepository.getChannel(id)
                                else -> null
                            }
                        } catch (_: Exception) {
                            null
                        }
                        channel?.livestream?.let { kickRepository.toStream(channel) }
                    }
                }
            }.awaitAll()
        }

        return LoadResult.Page(
            data = streams
                .filterNotNull()
                .distinctBy { it.channelId ?: it.channelLogin ?: it.id }
                .sortedByDescending { it.viewerCount ?: 0 },
            prevKey = null,
            nextKey = null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
