package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.Emote

data class EmotePickerSection(
    val key: String,
    val title: String,
    val emotes: List<Emote>,
    val expanded: Boolean = true,
    val expandedByDefault: Boolean = true,
)
