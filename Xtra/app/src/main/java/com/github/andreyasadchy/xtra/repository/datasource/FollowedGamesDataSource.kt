package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowGameRepository
import java.io.File
import java.util.Locale
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class FollowedGamesDataSource(
    private val localFollowsGame: LocalFollowGameRepository,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Game>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val follows = localFollowsGame.loadFollows()
        val missingArt = follows.filter { follow ->
            val value = follow.boxArt
            value.isNullOrBlank() || (value.startsWith("/") && !File(value).exists())
        }
        if (missingArt.isNotEmpty()) {
            val artById = mutableMapOf<String, String>()
            val artBySlug = mutableMapOf<String, String>()
            val artByName = mutableMapOf<String, String>()
            runCatching {
                val responses = coroutineScope {
                    (1..6).map { page ->
                        async { kickRepository.getSubcategories(page = page, limit = 100) }
                    }.awaitAll()
                }
                responses.forEach { response ->
                    response.data.forEach { category ->
                        val url = category.banner?.url?.takeIf { it.isNotBlank() } ?: return@forEach
                        category.id?.toString()?.let { artById[it] = url }
                        category.slug?.lowercase(Locale.ROOT)?.let { artBySlug[it] = url }
                        category.name?.lowercase(Locale.ROOT)?.let { artByName[it] = url }
                    }
                }
            }
            missingArt.forEach { follow ->
                val resolved = follow.gameId?.let(artById::get)
                    ?: follow.gameSlug?.lowercase(Locale.ROOT)?.let(artBySlug::get)
                    ?: follow.gameName?.lowercase(Locale.ROOT)?.let(artByName::get)
                val currentArt = follow.boxArt
                if (!resolved.isNullOrBlank()) {
                    follow.boxArt = resolved
                    runCatching { localFollowsGame.updateFollow(follow) }
                } else if (!currentArt.isNullOrBlank() && currentArt.startsWith("/") && !File(currentArt).exists()) {
                    // Clear stale local-file paths so future loads keep trying to resolve remote art.
                    follow.boxArt = null
                    runCatching { localFollowsGame.updateFollow(follow) }
                }
            }
        }
        val list = follows
            .map {
                Game(
                    gameId = it.gameId,
                    gameSlug = it.gameSlug,
                    gameName = it.gameName,
                    boxArtUrl = it.boxArt,
                    followLocal = true
                )
            }
            .sortedBy { it.gameName }
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
