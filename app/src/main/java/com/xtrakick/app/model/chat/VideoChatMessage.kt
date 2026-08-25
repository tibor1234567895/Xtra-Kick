package com.xtrakick.app.model.chat

class VideoChatMessage(
    val id: String?,
    val offsetSeconds: Int?,
    val userId: String?,
    val userLogin: String?,
    val userName: String?,
    val message: String?,
    val color: String?,
    val emotes: List<ChatEmote>?,
    val badges: List<Badge>?,
    val fullMsg: String?,
)