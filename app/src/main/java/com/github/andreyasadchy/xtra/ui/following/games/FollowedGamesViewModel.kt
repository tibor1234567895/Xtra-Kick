package com.github.andreyasadchy.xtra.ui.following.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.andreyasadchy.xtra.repository.LocalFollowGameRepository
import com.github.andreyasadchy.xtra.repository.datasource.FollowedGamesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FollowedGamesViewModel @Inject constructor(
    private val localFollowsGame: LocalFollowGameRepository,
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
    ) {
        FollowedGamesDataSource(
            localFollowsGame = localFollowsGame,
        )
    }.flow.cachedIn(viewModelScope)
}
