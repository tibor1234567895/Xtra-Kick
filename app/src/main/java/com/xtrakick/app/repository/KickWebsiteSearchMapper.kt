package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.model.kick.KickChannelLivestream
import com.xtrakick.app.model.kick.KickSearchChannel
import com.xtrakick.app.model.kick.KickSubcategory
import com.xtrakick.app.model.kick.KickTypesenseDocument
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.util.AppConstants
import java.util.Locale

internal object KickWebsiteSearchMapper {

    fun toUser(item: KickTypesenseDocument): User {
        return User(
            channelId = item.id,
            channelLogin = item.slug,
            channelName = item.username ?: item.name,
            profileImageUrl = item.profileImage ?: item.profilePic,
            followersCount = item.followersCount,
            isLive = item.isLive == true
        )
    }

    fun toGame(item: KickTypesenseDocument): Game {
        return Game(
            gameId = item.id,
            gameSlug = item.slug,
            gameName = item.name,
            boxArtUrl = item.src,
            viewersCount = 0
        )
    }

    fun toUser(item: KickSearchChannel): User {
        return User(
            channelId = item.id?.toString(),
            channelLogin = item.slug,
            channelName = item.user?.username,
            profileImageUrl = item.user?.profileImage,
            followersCount = item.followersCount,
            isLive = item.isLive == true
        )
    }

    fun toGame(item: KickSubcategory): Game {
        return Game(
            gameId = item.id?.toString(),
            gameSlug = item.slug,
            gameName = item.name,
            boxArtUrl = item.banner?.imageUrl,
            viewersCount = item.viewers
        )
    }

    fun toStream(item: KickLivestream): Stream {
        val category = item.categories?.firstOrNull()
        val channelLogin = item.channel?.slug ?: item.channel?.user?.username?.lowercase(Locale.ROOT)
        return Stream(
            id = item.id?.toString(),
            source = AppConstants.KICK,
            channelId = item.channel?.id?.toString() ?: item.channelId?.toString(),
            channelLogin = channelLogin,
            channelName = item.channel?.user?.username,
            playbackUrl = item.channel?.playbackUrl,
            gameId = category?.id?.toString(),
            gameSlug = category?.slug,
            gameName = category?.name,
            title = item.title,
            viewerCount = item.viewerCount,
            startedAt = normalizeDate(item.createdAt),
            thumbnailUrl = item.thumbnail?.imageUrl,
            profileImageUrl = item.channel?.user?.profileImage,
            tags = item.tags
        )
    }

    fun toStream(channel: KickSearchChannel, livestream: KickChannelLivestream): Stream {
        val channelLogin = channel.slug ?: channel.user?.username?.lowercase(Locale.ROOT)
        return Stream(
            id = livestream.id?.toString(),
            source = AppConstants.KICK,
            channelId = channel.id?.toString() ?: channel.userId?.toString(),
            channelLogin = channelLogin,
            channelName = channel.user?.username,
            playbackUrl = livestream.playbackUrl ?: channel.playbackUrl,
            gameId = livestream.category?.id?.toString(),
            gameSlug = livestream.category?.slug,
            gameName = livestream.category?.name,
            title = livestream.title,
            viewerCount = livestream.viewerCount,
            startedAt = normalizeDate(livestream.createdAt),
            thumbnailUrl = livestream.thumbnail?.imageUrl,
            profileImageUrl = channel.user?.profileImage
        )
    }

    private fun normalizeDate(input: String?): String? {
        if (input.isNullOrBlank()) return null
        return when {
            input.contains('T') -> if (input.endsWith("Z") || input.contains("+")) input else "${input}Z"
            else -> input.replace(' ', 'T') + "Z"
        }
    }
}
