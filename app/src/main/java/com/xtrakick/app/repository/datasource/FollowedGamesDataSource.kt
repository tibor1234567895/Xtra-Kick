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
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
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
        } catch (e: CancellationException) {
            throw e
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
        currentCoroutineContext().ensureActive()

        val subcategoriesById = HashMap<String, KickSubcategory>(topSubcategories.size)
        val subcategoriesBySlug = HashMap<String, KickSubcategory>(topSubcategories.size)
        val subcategoriesByName = HashMap<String, KickSubcategory>(topSubcategories.size)
        for (sub in topSubcategories) {
            sub.id?.toString()?.let { subcategoriesById[it] = sub }
            sub.slug?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesBySlug[it] = sub }
            sub.name?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesByName[it] = sub }
        }

        val missingFollows = follows.filter { follow ->
            val slug = follow.gameSlug?.trim()?.lowercase(Locale.ROOT)
            val name = follow.gameName?.trim()?.lowercase(Locale.ROOT)
            !subcategoriesById.containsKey(follow.gameId) &&
                (slug == null || !subcategoriesBySlug.containsKey(slug)) &&
                (name == null || !subcategoriesByName.containsKey(name))
        }.distinctBy { it.gameId ?: it.gameSlug?.lowercase(Locale.ROOT) ?: it.gameName?.lowercase(Locale.ROOT) }

        if (missingFollows.isNotEmpty()) {
            val requests = Semaphore(4)
            coroutineScope {
                missingFollows.map { follow ->
                    async {
                        requests.withPermit { resolveFollow(follow) }
                    }
                }.awaitAll()
            }.filterNotNull().forEach { sub ->
                sub.id?.toString()?.let { subcategoriesById[it] = sub }
                sub.slug?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesBySlug[it] = sub }
                sub.name?.trim()?.lowercase(Locale.ROOT)?.let { subcategoriesByName[it] = sub }
            }
        }

        val toUpdate = mutableListOf<LocalFollowGame>()
        val games = follows.map { follow ->
            val slug = follow.gameSlug?.trim()?.lowercase(Locale.ROOT)
                ?: KickApiHelper.toCategorySlug(follow.gameName)?.lowercase(Locale.ROOT)
            val name = follow.gameName?.trim()?.lowercase(Locale.ROOT)
            val sub = subcategoriesById[follow.gameId]
                ?: (slug?.let { subcategoriesBySlug[it] }) ?: (name?.let { subcategoriesByName[it] })

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

    private suspend fun resolveFollow(follow: LocalFollowGame): KickSubcategory? {
        val slug = follow.gameSlug?.trim()?.takeIf { it.isNotBlank() }
            ?: KickApiHelper.toCategorySlug(follow.gameName)
        val direct = slug?.let { kickRepository.getSubcategory(it) }
        currentCoroutineContext().ensureActive()
        if (direct != null) return direct
        val query = follow.gameName?.trim()?.takeIf { it.isNotBlank() } ?: slug ?: return null
        val matches = try {
            kickRepository.searchWebsite(query).categories
        } catch (e: CancellationException) {
            throw e
        } catch (_: Exception) {
            return null
        }
        val match = matches.firstOrNull { follow.gameId != null && it.id?.toString() == follow.gameId }
            ?: matches.firstOrNull { !follow.gameName.isNullOrBlank() && it.name.equals(follow.gameName, ignoreCase = true) }
            ?: matches.firstOrNull { slug != null && it.slug.equals(slug, ignoreCase = true) }
            ?: return null
        val canonicalSlug = match.slug?.trim()?.takeIf { it.isNotBlank() }
        val resolved = canonicalSlug?.let { kickRepository.getSubcategory(it) } ?: match
        currentCoroutineContext().ensureActive()
        return resolved
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
