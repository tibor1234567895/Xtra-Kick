package com.xtrakick.app.ui.channel.suggested

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.datasource.ChannelSuggestedDataSource
import com.xtrakick.app.ui.channel.ChannelPagerFragmentArgs
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ChannelSuggestedViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val kickRepository: KickRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = ChannelPagerFragmentArgs.fromSavedStateHandle(savedStateHandle)

    val flow = Pager(
        PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
    ) {
        ChannelSuggestedDataSource(
            channelLogin = args.channelLogin,
            kickWebHeaders = KickApiHelper.getKickWebHeaders(applicationContext, true),
            kickRepository = kickRepository,
            enableIntegrity = applicationContext.prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
            networkLibrary = applicationContext.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
        )
    }.flow.cachedIn(viewModelScope)
}
