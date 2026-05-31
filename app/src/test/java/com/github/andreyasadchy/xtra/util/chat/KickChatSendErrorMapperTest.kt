package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.RoomState
import org.junit.Assert.assertEquals
import org.junit.Test

class KickChatSendErrorMapperTest {

    @Test
    fun mapsForbiddenToFollowersOnlyWhenRoomStateRequiresFollow() {
        val reason = KickChatSendErrorMapper.classify(
            """Kick request failed (403): {"data":{},"message":"Forbidden"}""",
            RoomState(emote = null, followers = "600", unique = null, slow = null, subs = null)
        )

        assertEquals(KickChatSendErrorMapper.Reason.FOLLOWERS_ONLY, reason)
    }

    @Test
    fun mapsForbiddenToSubscribersOnlyWhenRoomStateRequiresSub() {
        val reason = KickChatSendErrorMapper.classify(
            """Kick request failed (403): {"message":"Forbidden"}""",
            RoomState(emote = null, followers = "-1", unique = null, slow = null, subs = "1")
        )

        assertEquals(KickChatSendErrorMapper.Reason.SUBSCRIBERS_ONLY, reason)
    }

    @Test
    fun mapsExplicitEmoteOnlyResponse() {
        val reason = KickChatSendErrorMapper.classify(
            "This room is in emote-only mode.",
            RoomState(emote = null, followers = null, unique = null, slow = null, subs = null)
        )

        assertEquals(KickChatSendErrorMapper.Reason.EMOTES_ONLY, reason)
    }

    @Test
    fun mapsRateLimitWithSlowRoomStateToSlowMode() {
        val reason = KickChatSendErrorMapper.classify(
            "Kick request failed (429): too quickly",
            RoomState(emote = null, followers = null, unique = null, slow = "30", subs = null)
        )

        assertEquals(KickChatSendErrorMapper.Reason.SLOW_MODE, reason)
    }

    @Test
    fun mapsTokenFailure() {
        val reason = KickChatSendErrorMapper.classify(
            "Kick request failed (401): Unauthorized",
            null
        )

        assertEquals(KickChatSendErrorMapper.Reason.TOKEN_EXPIRED, reason)
    }

    @Test
    fun mapsUnknownForbiddenToGenericKickRejection() {
        val reason = KickChatSendErrorMapper.classify(
            """Kick request failed (403): {"data":{},"message":"Forbidden"}""",
            null
        )

        assertEquals(KickChatSendErrorMapper.Reason.FORBIDDEN, reason)
    }
}
