package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Tag
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.KickWebsiteSearchMapper
import com.github.andreyasadchy.xtra.util.C

class SearchGamesDataSource(
    private val query: String,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
    private val useLegacyKickSearch: Boolean,
) : PagingSource<Int, Game>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return if (query.isBlank()) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        } else {
            if (params.key != null && !offset.isNullOrBlank()) {
                try {
                    loadFromApi(api, params)
                } catch (e: Exception) {
                    LoadResult.Error(e)
                }
            } else {
                val apisToTry = apiPref.ifEmpty { listOf(C.KICK) }
                var lastError: Exception? = null
                var emptyResult: LoadResult.Page<Int, Game>? = null
                apisToTry.forEach { pref ->
                    try {
                        val result = loadFromApi(pref, params)
                        if (result is LoadResult.Page && KickSearchLoadStrategy.shouldTryNextApi(pref, useLegacyKickSearch, result)) {
                            emptyResult = emptyResult ?: result
                        } else {
                            return result
                        }
                    } catch (e: Exception) {
                        lastError = e
                    }
                }
                emptyResult ?: LoadResult.Error(lastError ?: Exception("No enabled APIs"))
            }
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Game> {
        api = apiPref
        return when (apiPref) {
            C.GQL -> gqlQueryLoad(params)
            C.GQL_PERSISTED_QUERY -> gqlLoad(params)
            C.HELIX -> helixLoad(params)
            C.KICK -> if (KickSearchLoadStrategy.useLegacySearch(useLegacyKickSearch)) kickLegacyLoad(params) else kickWebsiteLoad()
            else -> throw Exception()
        }
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = graphQLRepository.loadQuerySearchGames(networkLibrary, gqlHeaders, query, params.loadSize, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.searchCategories!!
        val list = data.edges!!.mapNotNull { item ->
            item.node?.let {
                Game(
                    gameId = it.id,
                    gameSlug = it.slug,
                    gameName = it.displayName,
                    boxArtUrl = it.boxArtURL,
                    viewersCount = it.viewersCount ?: 0,
                    broadcastersCount = it.broadcastersCount ?: 0,
                    tags = it.tags?.map { tag ->
                        Tag(
                            id = tag.id,
                            name = tag.localizedName
                        )
                    }
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

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = graphQLRepository.loadSearchGames(networkLibrary, gqlHeaders, query, offset)
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data!!.searchFor.games
        val list = data.edges.map { item ->
            item.item.let {
                Game(
                    gameId = it.id,
                    gameSlug = it.slug,
                    gameName = it.displayName,
                    boxArtUrl = it.boxArtURL,
                    viewersCount = it.viewersCount ?: 0,
                    tags = it.tags?.map { tag ->
                        Tag(
                            id = tag.id,
                            name = tag.localizedName
                        )
                    }
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

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        val response = helixRepository.getSearchGames(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            query = query,
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

    private suspend fun kickWebsiteLoad(): LoadResult<Int, Game> {
        offset = null
        val response = kickRepository.searchWebsite(query)
        return LoadResult.Page(
            data = response.categories.map { KickWebsiteSearchMapper.toGame(it) },
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun kickLegacyLoad(params: LoadParams<Int>): LoadResult<Int, Game> {
        var page = params.key ?: 1
        var nextPage: Int? = page
        val list = mutableListOf<Game>()
        var scannedPages = 0
        while (list.size < params.loadSize && nextPage != null && scannedPages < 5) {
            val response = kickRepository.getSubcategories(page = page, limit = params.loadSize)
            list.addAll(
                response.data
                    .filter { kickRepository.matchesQuery(it, query) }
                    .map { kickRepository.toGame(it) }
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

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
