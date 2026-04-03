package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickRepository

class ChannelSuggestedDataSource(
    private val channelLogin: String?,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val networkLibrary: String?,
) : PagingSource<Int, Stream>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        return try {
            channelLogin?.let { login ->
                val channel = runCatching { kickRepository.getChannel(login) }.getOrNull()
                    ?: return LoadResult.Page(data = emptyList(), prevKey = null, nextKey = null)
                val subcategory = channel.livestream?.category?.slug ?: channel.recentCategories?.firstOrNull()?.slug
                if (subcategory.isNullOrBlank()) {
                    return LoadResult.Page(data = emptyList(), prevKey = null, nextKey = null)
                }
                val currentChannelId = channel.id?.toString()
                val list = kickRepository.getLivestreams(
                    page = 1,
                    limit = params.loadSize,
                    subcategory = subcategory
                ).data.map {
                    kickRepository.toStream(it)
                }.filter { stream ->
                    !stream.channelLogin.equals(login, true) && (currentChannelId.isNullOrBlank() || stream.channelId != currentChannelId)
                }.distinctBy { stream ->
                    stream.channelId ?: stream.channelLogin ?: stream.id
                }
                return LoadResult.Page(
                    data = list,
                    prevKey = null,
                    nextKey = null
                )
            }
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
