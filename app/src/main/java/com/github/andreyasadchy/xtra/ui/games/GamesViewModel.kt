package com.github.andreyasadchy.xtra.ui.games

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.github.andreyasadchy.xtra.model.ui.Tag
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.datasource.GamesDataSource
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    @ApplicationContext applicationContext: Context,
    private val kickRepository: KickRepository,
) : ViewModel() {

    val filter = MutableStateFlow<Filter?>(null)
    val filtersText = MutableStateFlow<CharSequence?>(null)

    val tags: Array<Tag>
        get() = filter.value?.tags ?: emptyArray()

    @OptIn(ExperimentalCoroutinesApi::class)
    val flow = filter.flatMapLatest { filter ->
        Pager(
            PagingConfig(pageSize = 30, prefetchDistance = 10, initialLoadSize = 30)
        ) {
            GamesDataSource(
                tags = tags.ifEmpty { null }?.mapNotNull { it.id },
                kickRepository = kickRepository,
                apiPref = listOf(C.KICK),
            )
        }.flow
    }.cachedIn(viewModelScope)

    fun setFilter(tags: Array<Tag>?) {
        filter.value = Filter(tags)
    }

    class Filter(
        val tags: Array<Tag>?,
    )
}
