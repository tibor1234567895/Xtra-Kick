package com.xtrakick.app.ui.player

import androidx.media3.common.C
import androidx.media3.common.ForwardingPlayer
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi

@UnstableApi
internal class MediaNotificationPlayer(
    player: Player,
    private val showLiveSeekbar: () -> Boolean,
) : ForwardingPlayer(player) {
    // Platform metadata reads this getter; Media3 controllers retain the real DVR timeline.
    override fun getDuration(): Long =
        if (isCurrentMediaItemLive && !showLiveSeekbar()) C.TIME_UNSET else super.getDuration()
}
