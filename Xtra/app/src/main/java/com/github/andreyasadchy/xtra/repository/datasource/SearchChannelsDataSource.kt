package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C

class SearchChannelsDataSource(
    private val query: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, User>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            if (!offset.isNullOrBlank()) {
                try {
                    loadFromApi(api, params)
                } catch (e: Exception) {
                    LoadResult.Error(e)
                }
            } else {
                val apisToTry = (apiPref + C.KICK).distinct()
                var lastError: Exception? = null
                apisToTry.forEach { pref ->
                    try {
                        return loadFromApi(pref, params)
                    } catch (e: Exception) {
                        lastError = e
                    }
                }
                LoadResult.Error(lastError ?: Exception("No enabled APIs"))
            }
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, User> {
        api = apiPref
        return when (apiPref) {
            C.GQL -> gqlQueryLoad(params)
            C.GQL_PERSISTED_QUERY -> gqlLoad(params)
            C.HELIX -> if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) helixLoad(params) else throw Exception()
            C.KICK -> kickLoad(params)
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        val response = graphQLRepository.loadQuerySearchChannels(networkLibrary, gqlHeaders, query, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.searchUsers!!
        val list = data.edges!!.mapNotNull { item ->
            item.node?.let {
                User(
                    channelId = it.id,
                    channelLogin = it.login,
                    channelName = it.displayName,
                    profileImageUrl = it.profileImageURL,
                    followersCount = it.followers?.totalCount,
                    isLive = it.stream?.viewersCount != null
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

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        val response = graphQLRepository.loadSearchChannels(networkLibrary, gqlHeaders, query, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.searchFor.channels
        val list = data.edges.map { item ->
            item.item.let {
                User(
                    channelId = it.id,
                    channelLogin = it.login,
                    channelName = it.displayName,
                    profileImageUrl = it.profileImageURL,
                    followersCount = it.followers?.totalCount,
                    isLive = it.stream?.viewersCount != null
                )
            }
        }
        offset = data.cursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        val response = helixRepository.getSearchChannels(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            query = query,
            limit = params.loadSize,
            offset = offset,
        )
        val list = response.data.map {
            User(
                channelId = it.channelId,
                channelLogin = it.channelLogin,
                channelName = it.channelName,
                profileImageUrl = it.profileImageUrl,
                isLive = it.isLive
            )
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

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, User> {
        var page = params.key ?: 1
        var nextPage: Int? = page
        val users = linkedMapOf<String, User>()
        var scannedPages = 0
        while (users.size < params.loadSize && nextPage != null && scannedPages < 5) {
            val response = kickRepository.getLivestreams(page = page, limit = params.loadSize, sort = "desc")
            response.data
                .filter { kickRepository.matchesQuery(it, query) }
                .forEach { stream ->
                    val channelId = stream.channel?.id?.toString() ?: stream.channelId?.toString() ?: return@forEach
                    if (!users.containsKey(channelId)) {
                        users[channelId] = User(
                            channelId = channelId,
                            channelLogin = stream.channel?.slug,
                            channelName = stream.channel?.user?.username,
                            profileImageUrl = stream.channel?.user?.profileImage,
                            isLive = true
                        )
                    }
                }
            scannedPages += 1
            nextPage = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else {
                null
            }
            page += 1
        }
        return LoadResult.Page(
            data = users.values.take(params.loadSize),
            prevKey = null,
            nextKey = nextPage
        )
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
