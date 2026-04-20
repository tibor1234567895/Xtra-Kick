package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickMessageBadge

internal fun mergeKickMessageBadges(
    existingBadges: List<KickMessageBadge>,
    syntheticBadges: List<KickMessageBadge>,
    resolveType: (KickMessageBadge) -> String?,
    normalizeType: (String) -> String,
): List<KickMessageBadge> {
    val merged = LinkedHashMap<String, KickMessageBadge>()
    existingBadges.forEach { badge ->
        val type = resolveType(badge)?.let(normalizeType) ?: return@forEach
        merged[type] = badge
    }
    syntheticBadges.forEach { badge ->
        val type = resolveType(badge)?.let(normalizeType) ?: return@forEach
        val current = merged[type]
        if (current == null || kickMessageBadgeSpecificity(badge) > kickMessageBadgeSpecificity(current)) {
            merged[type] = badge
        }
    }
    return merged.values.toList()
}

internal fun kickMessageBadgeSpecificity(badge: KickMessageBadge): Int {
    return badge.count
        ?: badge.months
        ?: badge.level
        ?: badge.tier
        ?: badge.version
        ?: Regex("""(\d{1,3})""").find(badge.text.orEmpty())?.groupValues?.getOrNull(1)?.toIntOrNull()
        ?: 1
}
