package com.xtrakick.app.util.chat

import android.graphics.drawable.Drawable
import java.util.LinkedHashMap

/**
 * Manages active [MasterAnimatedEmote] instances for chat rendering.
 *
 * Maintains a bounded LRU cache of running master decoders, deduplicating
 * animation decodes and frame timelines across all visible chat messages.
 */
internal object MasterEmoteManager {

    @Volatile
    var isSyncEnabled: Boolean = true

    private const val MAX_MASTERS = 100

    private val masters = object : LinkedHashMap<ChatAdapterUtils.ChatImageKey, MasterAnimatedEmote>(MAX_MASTERS, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<ChatAdapterUtils.ChatImageKey, MasterAnimatedEmote>?): Boolean {
            if (size > MAX_MASTERS) {
                eldest?.value?.release()
                return true
            }
            return false
        }
    }

    fun getMaster(key: ChatAdapterUtils.ChatImageKey): MasterAnimatedEmote? = synchronized(masters) {
        masters[key]
    }

    fun getOrCreateMaster(
        key: ChatAdapterUtils.ChatImageKey,
        rawDrawable: Drawable,
        targetHeight: Int,
        fps: Int,
    ): MasterAnimatedEmote = synchronized(masters) {
        masters.getOrPut(key) {
            MasterAnimatedEmote(key, rawDrawable, targetHeight, fps)
        }
    }

    fun updateFps(fps: Int) = synchronized(masters) {
        masters.values.forEach { it.updateFrameRate(fps) }
    }

    fun clear() = synchronized(masters) {
        masters.values.forEach { it.release() }
        masters.clear()
    }

    val activeMasterCount: Int
        get() = synchronized(masters) { masters.size }
}
