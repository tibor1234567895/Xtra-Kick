package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.Language
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import java.util.Locale

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
            val apisToTry = listOf(AppConstants.KICK)
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
            AppConstants.KICK -> if (tags.isNullOrEmpty() && gqlQueryLanguages.isNullOrEmpty() && gqlLanguages.isNullOrEmpty()) kickLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val page = params.key ?: 1
        val slug = gameSlug?.takeIf { it.isNotBlank() }
            ?: kickRepository.resolveCategorySlug(gameId, gameName)
            ?: KickApiHelper.toCategorySlug(gameName)
        val response = kickRepository.getLivestreams(
            page = page,
            limit = params.loadSize,
            sort = if (gqlSort == "VIEWER_COUNT_ASC") "asc" else "desc",
            subcategory = slug
        )
        val normalizedSlug = slug?.trim()?.lowercase(Locale.ROOT)
        val normalizedName = gameName?.trim()?.lowercase(Locale.ROOT)
        val list = response.data
            .filter { item ->
                // Guard against Kick falling back to global popular livestreams when subcategory is unmatched
                if (normalizedSlug.isNullOrBlank() && normalizedName.isNullOrBlank() && gameId.isNullOrBlank()) {
                    return@filter true
                }
                val itemCats = item.categories
                if (itemCats.isNullOrEmpty()) {
                    true
                } else {
                    itemCats.any { cat ->
                        (gameId != null && cat.id?.toString() == gameId) ||
                        (normalizedSlug != null && cat.slug?.lowercase(Locale.ROOT) == normalizedSlug) ||
                        (normalizedName != null && cat.name?.lowercase(Locale.ROOT) == normalizedName)
                    }
                }
            }
            .map {
                val itemCat = it.categories?.firstOrNull()
                kickRepository.toStream(
                    item = it,
                    gameId = itemCat?.id?.toString() ?: gameId,
                    gameSlug = itemCat?.slug ?: slug,
                    gameName = itemCat?.name ?: gameName
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
