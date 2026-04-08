package com.github.andreyasadchy.xtra.model.chat

data class PinnedGift(
    val id: String,
    val userId: String? = null,
    val userLogin: String? = null,
    val userName: String? = null,
    val userColor: String? = null,
    val avatarUrl: String? = null,
    val pinnedByUserId: String? = null,
    val pinnedByUserLogin: String? = null,
    val pinnedByUserName: String? = null,
    val pinnedByUserColor: String? = null,
    val message: String? = null,
    val giftCount: Int? = null,
    val giftValue: Int? = null,
    val pinnedSeconds: Int? = null,
    val pinnedUntilMs: Long? = null,
    val rawEventName: String? = null,
    val fullMsg: String? = null,
)
