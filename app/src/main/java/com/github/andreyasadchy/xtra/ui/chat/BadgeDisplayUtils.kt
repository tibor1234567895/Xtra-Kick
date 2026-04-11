package com.github.andreyasadchy.xtra.ui.chat

import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.StvBadge
import java.util.Locale

internal fun normalizeDisplayBadgeId(setId: String): String {
    val normalized = setId
        .substringAfterLast(':')
        .trim()
        .lowercase(Locale.ROOT)
        .replace(Regex("[^a-z0-9_]+"), "_")
        .removePrefix("badge_")
        .replace(Regex("_badges?$"), "")
        .replace(Regex("_badge_?\\d*$"), "")
        .replace(Regex("_v\\d+$"), "")
        .replace(Regex("_\\d+$"), "")
        .trim('_')
    return when (normalized) {
        "sub", "subscription", "subscribers" -> "subscriber"
        "subgift", "sub_gift", "gift_sub", "gift_subscriber", "subscriber_gifter", "subscription_gifter", "gifter" -> "sub_gifter"
        "founders", "founding" -> "founder"
        else -> when {
            normalized.contains("founder") -> "founder"
            normalized.contains("gift") && normalized.contains("sub") -> "sub_gifter"
            normalized.contains("gifter") -> "sub_gifter"
            normalized.contains("sub") -> "subscriber"
            else -> normalized
        }
    }
}

internal fun prettifyBadgeName(value: String): String {
    return value
        .replace(':', ' ')
        .replace('_', ' ')
        .replace('-', ' ')
        .trim()
        .lowercase(Locale.getDefault())
        .split(Regex("\\s+"))
        .filter { it.isNotBlank() }
        .joinToString(" ") { token ->
            token.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
}

internal fun buildBadgeDisplayLabel(badge: Badge): String {
    val normalizedId = normalizeDisplayBadgeId(badge.setId)
    val base = badge.title
        ?.takeIf { it.isNotBlank() }
        ?.let(::prettifyBadgeName)
        ?: prettifyBadgeName(normalizedId)
    val version = badge.version.takeIf {
        shouldAppendDisplayBadgeVersion(normalizedId, base, it)
    }
    return if (version != null) "$base $version" else base
}

internal fun looksSubscriptionRelatedBadge(badge: Badge): Boolean {
    val normalized = normalizeDisplayBadgeId(badge.setId)
    val title = badge.title.orEmpty().lowercase(Locale.ROOT)
    return normalized in setOf("subscriber", "founder") ||
        title.contains("sub") ||
        title.contains("founder")
}

internal fun stvBadgeToDisplayBadge(badge: StvBadge): Badge {
    return Badge(
        setId = "7tv:${badge.id}",
        version = "1",
        title = badge.name ?: "7TV Badge",
        url1x = badge.url1x,
        url2x = badge.url2x,
        url3x = badge.url3x,
        url4x = badge.url4x,
    )
}

private fun shouldAppendDisplayBadgeVersion(normalizedId: String, base: String, version: String): Boolean {
    return version.isNotBlank() &&
        version != "1" &&
        version.none { !it.isDigit() } &&
        !base.contains(version) &&
        normalizedId in setOf("subscriber", "founder", "sub_gifter")
}
