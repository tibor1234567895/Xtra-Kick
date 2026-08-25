package com.xtrakick.app.ui.chat

import com.xtrakick.app.model.chat.Emote

data class EmotePickerSection(
    val key: String,
    val title: String,
    val emotes: List<Emote>,
    val expanded: Boolean = true,
    val expandedByDefault: Boolean = true,
)
