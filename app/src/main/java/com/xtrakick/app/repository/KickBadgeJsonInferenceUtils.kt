package com.xtrakick.app.repository

import java.util.Locale

private val BADGE_SUFFIX_REGEX_1 = Regex("_badges?$")
private val BADGE_SUFFIX_REGEX_2 = Regex("_badge_?\\d*$")
private val SUBSCRIBER_KEYWORDS = setOf("subscriber", "sub", "subscription", "subscribers")
private val FOUNDER_KEYWORDS = setOf("founder", "founders", "founding")
private val SUB_GIFTER_KEYWORDS = setOf("sub_gifter", "subgift", "sub_gift", "gift_sub", "gift_subscriber", "subscriber_gifter", "subscription_gifter", "gifter")

internal fun inferKickBadgeTypeFromJsonPath(path: List<String>): String? {
    return path
        .asReversed()
        .mapNotNull(::inferKickBadgeTypeFromPathSegment)
        .firstOrNull()
}

private fun inferKickBadgeTypeFromPathSegment(segment: String): String? {
    val normalized = segment
        .trim()
        .lowercase(Locale.ROOT)
        .replace('-', '_')
        .replace(' ', '_')
        .removePrefix("badge_")
        .replace(BADGE_SUFFIX_REGEX_1, "")
        .replace(BADGE_SUFFIX_REGEX_2, "")
        .trim('_')
    if (normalized.isBlank()) return null
    return when {
        normalized in SUBSCRIBER_KEYWORDS -> "subscriber"
        normalized in FOUNDER_KEYWORDS -> "founder"
        normalized in SUB_GIFTER_KEYWORDS -> "sub_gifter"
        normalized.contains("founder") -> "founder"
        normalized.contains("gift") && normalized.contains("sub") -> "sub_gifter"
        normalized.contains("gifter") -> "sub_gifter"
        normalized.contains("subscriber") || normalized.contains("subscription") || normalized == "sub" -> "subscriber"
        normalized.contains("moderator") || normalized == "mod" || normalized == "mods" -> "moderator"
        normalized.contains("verified") -> "verified"
        normalized.contains("vip") -> "vip"
        normalized.contains("staff") || normalized.contains("admin") -> "staff"
        normalized.contains("broadcaster") || normalized.contains("streamer") || normalized.contains("host") -> "broadcaster"
        normalized == "og" || normalized.contains("original") -> "og"
        else -> null
    }
}
