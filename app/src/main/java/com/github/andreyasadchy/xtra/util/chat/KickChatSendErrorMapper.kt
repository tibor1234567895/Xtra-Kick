package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.RoomState

object KickChatSendErrorMapper {
    enum class Reason {
        TOKEN_EXPIRED,
        FOLLOWERS_ONLY,
        SUBSCRIBERS_ONLY,
        EMOTES_ONLY,
        SLOW_MODE,
        BOT_PROTECTION,
        RATE_LIMITED,
        FORBIDDEN,
        GENERIC,
    }

    fun classify(message: String?, roomState: RoomState?): Reason {
        val normalized = message?.lowercase().orEmpty()
        return when {
            normalized.contains("(401)") ||
                normalized.contains("unauthorized") ||
                normalized.contains("invalid token") ||
                normalized.contains("token") && normalized.contains("expired") -> Reason.TOKEN_EXPIRED
            normalized.contains("(429)") ||
                normalized.contains("rate limit") ||
                normalized.contains("too quickly") -> {
                if (roomState?.slow != null && roomState.slow != "0") Reason.SLOW_MODE else Reason.RATE_LIMITED
            }
            normalized.contains("slow") -> Reason.SLOW_MODE
            normalized.contains("bot") ||
                normalized.contains("advanced_bot_protection") ||
                normalized.contains("advanced bot") ||
                normalized.contains("protected") -> Reason.BOT_PROTECTION
            normalized.contains("followers") || normalized.contains("follow") -> Reason.FOLLOWERS_ONLY
            normalized.contains("subscribers") || normalized.contains("subscriber") || normalized.contains("subs") -> Reason.SUBSCRIBERS_ONLY
            normalized.contains("emote") -> Reason.EMOTES_ONLY
            normalized.contains("(403)") || normalized.contains("forbidden") -> classifyForbidden(roomState)
            else -> Reason.GENERIC
        }
    }

    private fun classifyForbidden(roomState: RoomState?): Reason {
        return when {
            roomState?.followers != null && roomState.followers != "-1" -> Reason.FOLLOWERS_ONLY
            roomState?.subs == "1" -> Reason.SUBSCRIBERS_ONLY
            roomState?.emote == "1" -> Reason.EMOTES_ONLY
            roomState?.slow != null && roomState.slow != "0" -> Reason.SLOW_MODE
            else -> Reason.FORBIDDEN
        }
    }
}
