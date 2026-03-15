package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.repository.LocalFollowGameRepository
import java.io.File

class FollowedGamesDataSource(
    private val localFollowsGame: LocalFollowGameRepository,
) : PagingSource<Int, Game>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val follows = localFollowsGame.loadFollows()
        val list = follows
            .map {
                val boxArt = it.boxArt?.takeUnless { value -> value.startsWith("/") && !File(value).exists() }
                Game(
                    gameId = it.gameId,
                    gameSlug = it.gameSlug,
                    gameName = it.gameName,
                    boxArtUrl = boxArt,
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
