package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.KickSubcategory
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.LocalFollowGame
import com.xtrakick.app.model.ui.Tag
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowGameRepository
import com.xtrakick.app.util.KickApiHelper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import java.io.File
import java.util.Locale

class FollowedGamesDataSource(
    private val localFollowsGame: LocalFollowGameRepository,
    private val kickRepository: KickRepository,
) : PagingSource<Int, Game>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val follows = localFollowsGame.loadFollows()
        if (follows.isEmpty()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }

        val updatedGames = try {
            refreshFollowsFromKick(follows)
        } catch (_: Exception) {
            null
        }

        val list = (updatedGames ?: follows.map { follow ->
            val boxArt = follow.boxArt?.takeUnless { value -> value.startsWith("/") && !File(value).exists() }
            Game(
                gameId = follow.gameId,
                gameSlug = follow.gameSlug,
                gameName = follow.gameName,
                boxArtUrl = boxArt,
                followLocal = true
            )
        }).sortedBy { it.gameName?.lowercase(Locale.ROOT) }

        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = null
        )
    }

    private suspend fun refreshFollowsFromKick(follows: List<LocalFollowGame>): List<Game> {
        // Fetch top subcategories to batch-resolve most popular games in a single network request
        val topSubcategories = runCatching {
            kickRepository.getSubcategories(page = 1, limit = 100).data
        }.getOrDefault(emptyList())

        val subcategoriesBySlug = HashMap<String, KickSubcategory>(topSubcategories.size)
        val subcategoriesByName = HashMap<String, KickSubcategory>(topSubcategories.size)
        for (sub in topSubcategories) {
            sub.slug?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesBySlug[it] = sub }
            sub.name?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesByName[it] = sub }
        }

        // Identify follows not covered by the top 100 categories and fetch them in parallel
        val missingSlugs = follows.mapNotNull { follow ->
            val slug = follow.gameSlug?.trim()?.lowercase(Locale.ROOT)
                ?: KickApiHelper.toCategorySlug(follow.gameName)?.lowercase(Locale.ROOT)
            val name = follow.gameName?.trim()?.lowercase(Locale.ROOT)
            if (slug != null && !subcategoriesBySlug.containsKey(slug) && (name == null || !subcategoriesByName.containsKey(name))) {
                slug
            } else null
        }.distinct()

        if (missingSlugs.isNotEmpty()) {
            coroutineScope {
                missingSlugs.map { slug ->
                    async {
                        runCatching { kickRepository.getSubcategory(slug) }.getOrNull()
                    }
                }.awaitAll()
            }.filterNotNull().forEach { sub ->
                sub.slug?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesBySlug[it] = sub }
                sub.name?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesByName[it] = sub }
            }
        }

        val toUpdate = mutableListOf<LocalFollowGame>()
        val games = follows.map { follow ->
            val slug = follow.gameSlug?.trim()?.lowercase(Locale.ROOT)
                ?: KickApiHelper.toCategorySlug(follow.gameName)?.lowercase(Locale.ROOT)
            val name = follow.gameName?.trim()?.lowercase(Locale.ROOT)
            val sub = (slug?.let { subcategoriesBySlug[it] }) ?: (name?.let { subcategoriesByName[it] })

            if (sub != null) {
                var changed = false
                val freshBanner = sub.banner?.imageUrl
                if (!freshBanner.isNullOrBlank() && follow.boxArt != freshBanner) {
                    follow.boxArt?.takeIf { it.startsWith("/") }?.let { File(it).delete() }
                    follow.boxArt = freshBanner
                    changed = true
                }
                if (!sub.name.isNullOrBlank() && follow.gameName != sub.name) {
                    follow.gameName = sub.name
                    changed = true
                }
                if (!sub.slug.isNullOrBlank() && follow.gameSlug != sub.slug) {
                    follow.gameSlug = sub.slug
                    changed = true
                }
                val freshId = sub.id?.toString()
                if (!freshId.isNullOrBlank() && follow.gameId != freshId) {
                    follow.gameId = freshId
                    changed = true
                }
                if (changed) {
                    toUpdate.add(follow)
                }

                Game(
                    gameId = freshId ?: follow.gameId,
                    gameSlug = sub.slug ?: follow.gameSlug,
                    gameName = sub.name ?: follow.gameName,
                    boxArtUrl = freshBanner ?: follow.boxArt,
                    viewersCount = sub.viewers,
                    tags = sub.tags?.filter { it.isNotBlank() }?.map { Tag(id = it, name = it) },
                    followLocal = true,
                )
            } else {
                val boxArt = follow.boxArt?.takeUnless { value -> value.startsWith("/") && !File(value).exists() }
                Game(
                    gameId = follow.gameId,
                    gameSlug = follow.gameSlug,
                    gameName = follow.gameName,
                    boxArtUrl = boxArt,
                    followLocal = true,
                )
            }
        }

        if (toUpdate.isNotEmpty()) {
            localFollowsGame.updateFollows(toUpdate, notify = false)
        }

        return games
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
