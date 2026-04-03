package com.github.andreyasadchy.xtra.model.helix.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ChannelSearch(
    @SerialName("id")
    val channelId: String? = null,
    @SerialName("broadcaster_login")
    val channelLogin: String? = null,
    @SerialName("display_name")
    val channelName: String? = null,
    @SerialName("thumbnail_url")
    val profileImageUrl: String? = null,
    @SerialName("is_live")
    val isLive: Boolean? = null,
    @SerialName("game_id")
    val gameId: String? = null,
    @SerialName("game_name")
    val gameName: String? = null,
    val title: String? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    val tags: List<String>? = null,
)