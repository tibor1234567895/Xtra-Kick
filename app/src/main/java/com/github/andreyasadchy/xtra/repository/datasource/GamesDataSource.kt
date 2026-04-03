package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Tag
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C

class GamesDataSource(
    private val tags: List<String>?,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Game>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return if (!offset.isNullOrBlank()) {
            try {
                loadFromApi(api, params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        } else {
            val apisToTry = listOf(C.KICK)
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

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Game> {
        api = apiPref
        return when (apiPref) {
            C.KICK -> if (tags.isNullOrEmpty()) kickLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = graphQLRepository.loadQueryTopGames(networkLibrary, gqlHeaders, tags, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.games!!
        val items = data.edges!!
        val list = items.mapNotNull { item ->
            item?.node?.let {
                Game(
                    gameId = it.id,
                    gameSlug = it.slug,
                    gameName = it.displayName,
                    boxArtUrl = it.boxArtURL,
                    viewersCount = it.viewersCount,
                    broadcastersCount = it.broadcastersCount,
                    tags = it.tags?.map { tag ->
                        Tag(
                            id = tag.id,
                            name = tag.localizedName
                        )
                    }
                )
            }
        }
        offset = items.lastOrNull()?.cursor?.toString()
        val nextPage = data.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = graphQLRepository.loadTopGames(networkLibrary, gqlHeaders, tags, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.directoriesWithTags
        val items = data.edges
        val list = items.map { item ->
            item.node.let {
                Game(
                    gameId = it.id,
                    gameSlug = it.slug,
                    gameName = it.displayName,
                    boxArtUrl = it.avatarURL,
                    viewersCount = it.viewersCount,
                    tags = it.tags?.map { tag ->
                        Tag(
                            id = tag.id,
                            name = tag.localizedName
                        )
                    }
                )
            }
        }
        offset = items.lastOrNull()?.cursor
        val nextPage = data.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = helixRepository.getTopGames(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            limit = params.loadSize,
            offset = offset,
        )
        val list = response.data.map {
            Game(
                gameId = it.id,
                gameName = it.name,
                boxArtUrl = it.boxArtUrl,
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

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val page = params.key ?: 1
        val response = kickRepository.getSubcategories(page = page, limit = params.loadSize)
        val list = response.data.map { kickRepository.toGame(it) }
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
