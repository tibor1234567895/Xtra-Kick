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
    val kicksDonation: KicksDonation? = null,
    val giftedSubInfo: GiftedSubInfo? = null,
) {
    fun copyContent(
        timestamp: Long? = this.timestamp,
        isDeleted: Boolean = this.isDeleted,
    ): ChatMessage = ChatMessage(
        id = id,
        userId = userId,
        userLogin = userLogin,
        userName = userName,
        message = message,
        color = color,
        emotes = emotes,
        badges = badges,
        isAction = isAction,
        isDeleted = isDeleted,
        isFirst = isFirst,
        bits = bits,
        systemMsg = systemMsg,
        msgId = msgId,
        reward = reward,
        reply = reply,
        isReply = isReply,
        replyParent = replyParent,
        timestamp = timestamp,
        fullMsg = fullMsg,
        kicksDonation = kicksDonation,
        giftedSubInfo = giftedSubInfo,
    )

    /**
     * Stable alternating-row slot assigned once when the message enters the list.
     * Survives head trims so scrolled-up chat does not flip stripe colors.
     */
    @Volatile
    var visualParitySlot: Int? = null
}
