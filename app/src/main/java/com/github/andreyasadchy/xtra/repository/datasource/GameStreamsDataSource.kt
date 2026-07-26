package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.type.Language
import com.github.andreyasadchy.xtra.graphql.type.StreamSort
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.KickGraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickPublicApiRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C

class GameStreamsDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val gqlQueryLanguages: List<Language>?,
    private val gqlLanguages: List<String>?,
    private val gqlSort: String?,
    private val tags: List<String>?,
    private val kickRepository: KickRepository,
    private val apiPref: List<String>,
) : PagingSource<Int, Stream>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
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

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Stream> {
        api = apiPref
        return when (apiPref) {
            C.KICK -> if (tags.isNullOrEmpty() && gqlQueryLanguages.isNullOrEmpty() && gqlLanguages.isNullOrEmpty()) kickLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val page = params.key ?: 1
        val slug = gameSlug ?: gameName?.trim()?.lowercase()?.replace(' ', '-')
        val response = kickRepository.getLivestreams(
            page = page,
            limit = params.loadSize,
            sort = if (gqlSort == "VIEWER_COUNT_ASC") "asc" else "desc",
            subcategory = slug
        )
        val list = response.data.map {
            kickRepository.toStream(
                item = it,
                gameId = gameId ?: it.categories?.firstOrNull()?.id?.toString(),
                gameSlug = gameSlug ?: it.categories?.firstOrNull()?.slug,
                gameName = gameName ?: it.categories?.firstOrNull()?.name
            )
        }
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
