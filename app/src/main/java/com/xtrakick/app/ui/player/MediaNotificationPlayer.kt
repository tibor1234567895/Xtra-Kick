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

    override fun getAvailableCommands(): Player.Commands {
        val commands = super.getAvailableCommands().buildUpon()
            .remove(Player.COMMAND_SEEK_TO_PREVIOUS)
            .remove(Player.COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM)
            .remove(Player.COMMAND_SEEK_TO_NEXT)
            .remove(Player.COMMAND_SEEK_TO_NEXT_MEDIA_ITEM)
            .remove(Player.COMMAND_SET_REPEAT_MODE)
            .remove(Player.COMMAND_SET_SHUFFLE_MODE)

        if (isCurrentMediaItemLive) {
            commands.remove(Player.COMMAND_SEEK_FORWARD)
        }
        return commands.build()
    }

    override fun isCommandAvailable(@Player.Command command: Int): Boolean = when (command) {
        Player.COMMAND_SEEK_TO_PREVIOUS,
        Player.COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM,
        Player.COMMAND_SEEK_TO_NEXT,
        Player.COMMAND_SEEK_TO_NEXT_MEDIA_ITEM,
        Player.COMMAND_SET_REPEAT_MODE,
        Player.COMMAND_SET_SHUFFLE_MODE -> false
        Player.COMMAND_SEEK_FORWARD -> !isCurrentMediaItemLive && super.isCommandAvailable(command)
        Player.COMMAND_SEEK_BACK -> super.isCommandAvailable(command)
        else -> super.isCommandAvailable(command)
    }

    override fun seekToPrevious() {
        if (!isCurrentMediaItemLive) seekBack()
    }

    override fun seekToPreviousMediaItem() {
        if (!isCurrentMediaItemLive) seekBack()
    }

    override fun seekToNext() {
        if (!isCurrentMediaItemLive) seekForward()
    }

    override fun seekToNextMediaItem() {
        if (!isCurrentMediaItemLive) seekForward()
    }

    override fun seekForward() {
        if (!isCurrentMediaItemLive) super.seekForward()
    }
}
