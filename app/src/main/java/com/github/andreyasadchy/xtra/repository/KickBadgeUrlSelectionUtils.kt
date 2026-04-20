package com.github.andreyasadchy.xtra.repository

internal enum class KickBadgeUrlSourcePreference {
    MESSAGE_DIRECT,
    CATALOG_CACHE,
    INLINE_FALLBACK,
}

internal data class KickBadgeUrlSelection(
    val imageUrl: String?,
    val source: KickBadgeUrlSourcePreference?,
)

internal fun selectKickBadgeUrl(
    isChannelSpecific: Boolean,
    directImageUrl: String?,
    catalogImageUrl: String?,
    inlineImageUrl: String?,
): KickBadgeUrlSelection {
    val resolvedUrl = when {
        isChannelSpecific && !catalogImageUrl.isNullOrBlank() -> catalogImageUrl
        !directImageUrl.isNullOrBlank() -> directImageUrl
        !catalogImageUrl.isNullOrBlank() -> catalogImageUrl
        !inlineImageUrl.isNullOrBlank() -> inlineImageUrl
        else -> null
    }
    val source = when {
        resolvedUrl == null -> null
        resolvedUrl == directImageUrl -> KickBadgeUrlSourcePreference.MESSAGE_DIRECT
        resolvedUrl == catalogImageUrl -> KickBadgeUrlSourcePreference.CATALOG_CACHE
        else -> KickBadgeUrlSourcePreference.INLINE_FALLBACK
    }
    return KickBadgeUrlSelection(resolvedUrl, source)
}
