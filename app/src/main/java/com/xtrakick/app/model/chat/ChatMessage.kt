package com.xtrakick.app.model.chat

class ChatMessage(
    val id: String? = null,
    val userId: String? = null,
    val userLogin: String? = null,
    val userName: String? = null,
    val message: String? = null,
    val color: String? = null,
    val emotes: List<ChatEmote>? = null,
    val badges: List<Badge>? = null,
    val isAction: Boolean = false,
    val isDeleted: Boolean = false,
    val isFirst: Boolean = false,
    val bits: Int? = null,
    val systemMsg: String? = null,
    val msgId: String? = null,
    val reward: ChannelPointReward? = null,
    val reply: Reply? = null,
    val isReply: Boolean = false,
    val replyParent: ChatMessage? = null,
    val timestamp: Long? = null,
    val fullMsg: String? = null,
) {
    /**
     * Stable alternating-row slot assigned once when the message enters the list.
     * Survives head trims so scrolled-up chat does not flip stripe colors.
     */
    @Volatile
    var visualParitySlot: Int? = null
}
