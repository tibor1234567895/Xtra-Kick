package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.kick.KickChannelLivestream
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import com.github.andreyasadchy.xtra.util.C

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
        val semaphore = Semaphore(12)
        val streams = coroutineScope {
            follows.map { follow ->
                async {
                    semaphore.withPermit {
                        val login = follow.userLogin?.takeIf { it.isNotBlank() }
                        val id = follow.userId?.takeIf { it.isNotBlank() }
                        when {
                            !login.isNullOrBlank() -> {
                                val livestream = runCatching { kickRepository.getChannelLivestream(login) }.getOrNull()
                                    ?: return@withPermit null
                                val channel = runCatching { kickRepository.getChannel(login) }.getOrNull()
                                if (channel != null) {
                                    kickRepository.toStream(channel, livestream)
                                } else {
                                    livestream.toStream(follow.userId, login, follow.userName, follow.channelLogo)
                                }
                            }
                            !id.isNullOrBlank() -> {
                                val channel = runCatching { kickRepository.getChannel(id) }.getOrNull()
                                channel?.livestream?.let { kickRepository.toStream(channel) }
                            }
                            else -> null
                        }
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

    private fun KickChannelLivestream.toStream(
        channelId: String?,
        channelLogin: String?,
        channelName: String?,
        profileImageUrl: String?,
    ): Stream {
        return Stream(
            id = id?.toString(),
            source = C.KICK,
            channelId = channelId,
            channelLogin = channelLogin,
            channelName = channelName,
            gameId = category?.id?.toString(),
            gameSlug = category?.slug,
            gameName = category?.name,
            title = title,
            viewerCount = viewerCount,
            startedAt = createdAt,
            thumbnailUrl = thumbnail?.imageUrl,
            profileImageUrl = profileImageUrl,
        )
    }
}
