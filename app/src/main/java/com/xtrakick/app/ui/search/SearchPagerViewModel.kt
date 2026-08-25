package com.xtrakick.app.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtrakick.app.repository.KickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchPagerViewModel @Inject constructor(
    private val kickRepository: KickRepository,
) : ViewModel() {

    val userResult = MutableStateFlow<Pair<String?, String?>?>(null)
    private var isLoading = false

    /**
     * Checks whether a channel exists via the public Kick channel endpoint.
     *
     * The old Twitch GQL user-result queries could never succeed against Kick, which made this
     * check silently report every input as invalid. Kick slugs are canonical here: numeric ids
     * have no public lookup, so any input is treated as a slug.
     */
    fun loadUserResult(result: String) {
        if (userResult.value != null || isLoading) return
        isLoading = true
        viewModelScope.launch {
            try {
                kickRepository.getChannel(
                    channelSlug = result.trim().lowercase(),
                    prefetchBadgeCatalog = false,
                )
                userResult.value = Pair(null, null)
            } catch (e: Exception) {
                userResult.value = Pair(NOT_FOUND, null)
            } finally {
                isLoading = false
            }
        }
    }

    companion object {
        /** Sentinel consumed by the fragment to show a localized "not found" title. */
        const val NOT_FOUND = "NOT_FOUND"
    }
}
