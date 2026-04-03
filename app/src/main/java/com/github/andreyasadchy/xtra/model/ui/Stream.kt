package com.github.andreyasadchy.xtra.model.ui

import android.os.Parcelable
import com.github.andreyasadchy.xtra.util.KickApiHelper
import kotlinx.parcelize.Parcelize

@Parcelize
class Stream(
    var id: String? = null,
    val source: String? = null,
    val channelId: String? = null,
    val channelLogin: String? = null,
    val channelName: String? = null,
    val playbackUrl: String? = null,
    var gameId: String? = null,
    var gameSlug: String? = null,
    var gameName: String? = null,
    var title: String? = null,
    var viewerCount: Int? = null,
    var startedAt: String? = null,
    val thumbnailUrl: String? = null,

    var profileImageUrl: String? = null,
    val tags: List<String>? = null,
    val user: User? = null,
) : Parcelable {

    val thumbnail: String?
        get() {
            val raw = thumbnailUrl?.takeIf { it.isNotBlank() } ?: return null
            return KickApiHelper.getTemplateUrl(raw, "video")
                ?.takeUnless { it.contains("://stream.kick.com/", ignoreCase = true) }
                ?.takeUnless { it.startsWith("https://files.kick.com/images/default-thumbnail", ignoreCase = true) }
        }
    val channelLogo: String?
        get() = KickApiHelper.getTemplateUrl(profileImageUrl, "profileimage")
}
