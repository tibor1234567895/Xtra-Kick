package com.github.andreyasadchy.xtra.ui.following.streams

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.repository.datasource.FollowedStreamsDataSource
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class FollowedStreamsViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickRepository: KickRepository,
) : ViewModel() {

    val sortText = MutableStateFlow<CharSequence?>(null)
    private val refreshNonce = MutableStateFlow(0)

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = refreshNonce.flatMapLatest {
        Pager(
            if (applicationContext.prefs().getString(C.COMPACT_STREAMS, "disabled") != "disabled") {
                PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
            } else {
                PagingConfig(pageSize = 30, prefetchDistance = 3, initialLoadSize = 30)
            }
        ) {
            FollowedStreamsDataSource(
                localFollowsChannel = localFollowsChannel,
                kickRepository = kickRepository,
            )
        }.flow
    }.cachedIn(viewModelScope)
}
