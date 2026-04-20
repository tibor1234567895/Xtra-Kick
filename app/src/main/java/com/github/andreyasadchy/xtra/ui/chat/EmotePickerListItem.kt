package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.Emote

sealed class EmotePickerListItem {
    data class SectionHeader(val section: EmotePickerSection) : EmotePickerListItem()
    data class EmoteEntry(
        val sectionKey: String,
        val emote: Emote,
        val indexInSection: Int,
    ) : EmotePickerListItem()
}
