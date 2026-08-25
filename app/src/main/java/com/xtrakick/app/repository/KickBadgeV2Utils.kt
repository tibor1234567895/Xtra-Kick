package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickMessageBadge
import com.xtrakick.app.model.kick.KickMessageIdentity
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull

internal fun selectedKickIdentityBadges(identity: KickMessageIdentity?): List<KickMessageBadge> {
    if (identity == null) return emptyList()
    return buildList {
        addAll(identity.badges.orEmpty())
        addAll(identity.badgesV2.orEmpty().filter { it.selected == true })
    }
}

internal fun kickMessageBadgeType(badge: KickMessageBadge): String? {
    return badge.type?.trim()?.takeIf { it.isNotBlank() }
        ?: badge.name?.trim()?.takeIf { it.isNotBlank() }
        ?: badge.slug?.trim()?.takeIf { it.isNotBlank() }
        ?: badge.badgeType?.trim()?.takeIf { it.isNotBlank() && !it.equals("global", ignoreCase = true) && !it.equals("channel", ignoreCase = true) }
        ?: badge.text?.trim()?.takeIf { it.isNotBlank() }
        ?: badge.badgeType?.trim()?.takeIf { it.isNotBlank() }
}

internal fun kickMessageBadgeVersion(badge: KickMessageBadge): String {
    val parsedFromText = badge.text
        ?.let { Regex("""(\d{1,3})""").find(it) }
        ?.groupValues
        ?.getOrNull(1)
        ?.toIntOrNull()
    return (badge.count
        ?: badge.months
        ?: badge.level
        ?: metadataInt(badge, "level")
        ?: badge.tier
        ?: badge.version
        ?: parsedFromText
        ?: 1).toString()
}

internal fun kickMessageBadgeSpecificityValue(badge: KickMessageBadge): Int {
    return badge.count
        ?: badge.months
        ?: badge.level
        ?: metadataInt(badge, "level")
        ?: badge.tier
        ?: badge.version
        ?: Regex("""(\d{1,3})""").find(badge.text.orEmpty())?.groupValues?.getOrNull(1)?.toIntOrNull()
        ?: 1
}

private fun metadataInt(badge: KickMessageBadge, key: String): Int? {
    val obj = badge.metadata as? JsonObject ?: return null
    val primitive = obj[key] as? JsonPrimitive ?: return null
    return primitive.intOrNull ?: primitive.contentOrNull?.toIntOrNull()
}
