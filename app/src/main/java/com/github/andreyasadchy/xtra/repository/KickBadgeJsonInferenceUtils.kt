package com.github.andreyasadchy.xtra.repository

import java.util.Locale

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
        .replace(Regex("_badges?$"), "")
        .replace(Regex("_badge_?\\d*$"), "")
        .trim('_')
    if (normalized.isBlank()) return null
    return when {
        normalized in setOf("subscriber", "sub", "subscription", "subscribers") -> "subscriber"
        normalized in setOf("founder", "founders", "founding") -> "founder"
        normalized in setOf("sub_gifter", "subgift", "sub_gift", "gift_sub", "gift_subscriber", "subscriber_gifter", "subscription_gifter", "gifter") -> "sub_gifter"
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
