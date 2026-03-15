package com.github.andreyasadchy.xtra.repository

import com.github.andreyasadchy.xtra.model.kick.KickLivestream
import com.github.andreyasadchy.xtra.model.kick.KickChannelLivestream
import com.github.andreyasadchy.xtra.model.kick.KickSearchChannel
import com.github.andreyasadchy.xtra.model.kick.KickSubcategory
import com.github.andreyasadchy.xtra.model.ui.Game
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.util.C
import java.util.Locale

internal object KickWebsiteSearchMapper {

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
            source = C.KICK,
            channelId = item.channel?.id?.toString() ?: item.channelId?.toString(),
            channelLogin = channelLogin,
            channelName = item.channel?.user?.username,
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
            source = C.KICK,
            channelId = channel.id?.toString() ?: channel.userId?.toString(),
            channelLogin = channelLogin,
            channelName = channel.user?.username,
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
