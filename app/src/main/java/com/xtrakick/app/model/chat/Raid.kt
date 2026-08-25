package com.xtrakick.app.model.chat

import com.xtrakick.app.util.KickApiHelper

class Raid(
    val raidId: String? = null,
    val targetId: String? = null,
    val targetLogin: String? = null,
    val targetName: String? = null,
    val targetProfileImage: String? = null,
    val viewerCount: Int? = null,
    val countdownSeconds: Int? = null,
    val openStream: Boolean,
) {

    val targetLogo: String?
        get() = KickApiHelper.getTemplateUrl(targetProfileImage, "profileimage")
}
