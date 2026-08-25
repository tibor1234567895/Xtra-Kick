package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Emote

sealed class EmotePickerListItem {
    data class SectionHeader(val section: EmotePickerSection) : EmotePickerListItem()
    data class EmoteEntry(
        val sectionKey: String,
        val emote: Emote,
        val indexInSection: Int,
    ) : EmotePickerListItem()
}
