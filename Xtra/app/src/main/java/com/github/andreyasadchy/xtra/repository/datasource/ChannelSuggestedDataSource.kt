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
                if (channel == null) {
                    return LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                }
                channel.let {
                    val subcategory = channel.livestream?.category?.slug ?: channel.recentCategories?.firstOrNull()?.slug
                    if (subcategory.isNullOrBlank()) {
                        return LoadResult.Page(
                            data = emptyList(),
                            prevKey = null,
                            nextKey = null
                        )
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
            }
            val response = graphQLRepository.loadChannelSuggested(networkLibrary, gqlHeaders, channelLogin)
            if (enableIntegrity) {
                response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
            }
            val list = response.data!!.sideNav.sections.edges.find {
                it.node.id == "provider-side-nav-similar-streamer-currently-watching-1"
            }?.node?.content?.edges?.map { item ->
                item.node.let {
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
                        profileImageUrl = it.broadcaster?.profileImageURL,
                        tags = it.freeformTags?.mapNotNull { tag -> tag.name }
                    )
                }
            } ?: emptyList()
            LoadResult.Page(
                data = list,
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
