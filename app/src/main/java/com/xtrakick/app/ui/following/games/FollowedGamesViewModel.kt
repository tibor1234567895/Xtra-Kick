package com.xtrakick.app.ui.following.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowGameRepository
import com.xtrakick.app.repository.datasource.FollowedGamesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowedGamesViewModel @Inject constructor(
    private val localFollowsGame: LocalFollowGameRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    private var currentDataSource: FollowedGamesDataSource? = null

    init {
        viewModelScope.launch {
            localFollowsGame.followsChanged.collect {
                currentDataSource?.invalidate()
            }
        }
    }

    val flow = Pager(
        PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
    ) {
        FollowedGamesDataSource(
            localFollowsGame = localFollowsGame,
            kickRepository = kickRepository,
        ).also { currentDataSource = it }
    }.flow.cachedIn(viewModelScope)
}
