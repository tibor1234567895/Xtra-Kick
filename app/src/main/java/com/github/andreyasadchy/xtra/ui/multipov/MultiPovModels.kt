package com.github.andreyasadchy.xtra.ui.multipov

import com.github.andreyasadchy.xtra.model.ui.Stream

sealed interface MultiPovLoadState {
    data object Loading : MultiPovLoadState
    data object Ready : MultiPovLoadState
    data class Error(val message: String) : MultiPovLoadState
    data object Offline : MultiPovLoadState
}

data class MultiPovSlot(
    val key: String,
    val stream: Stream,
    val resolvedUrl: String? = null,
    val isFocused: Boolean = false,
    val loadState: MultiPovLoadState = MultiPovLoadState.Loading,
)

data class MultiPovUiState(
    val slots: List<MultiPovSlot> = emptyList(),
    val focusedKey: String? = null,
    /** Quality for every stream unless [bandwidthSaving] is on. */
    val streamQuality: MultiPovQuality = MultiPovQuality.SOURCE,
    /** When true, non-focused tiles are forced to 480p. */
    val bandwidthSaving: Boolean = false,
    val maxStreams: Int = 8,
    /** Floating chrome starts hidden; first tap reveals it. */
    val isControlsVisible: Boolean = false,
) {
    val canAdd: Boolean get() = slots.size < maxStreams
    val focusedSlot: MultiPovSlot?
        get() = slots.firstOrNull { it.key == focusedKey } ?: slots.firstOrNull()
}

fun Stream.multiPovKey(): String {
    return (channelId ?: channelLogin ?: id ?: channelName.orEmpty()).lowercase()
}
