package com.xtrakick.app.util.chat

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Typeface
import android.graphics.drawable.Animatable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.SystemClock
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.util.Patterns
import android.view.View
import androidx.core.graphics.ColorUtils
import androidx.fragment.app.Fragment
import coil3.asDrawable
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.CheerEmote
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.Image
import com.xtrakick.app.model.chat.NamePaint
import com.xtrakick.app.model.chat.StvBadge
import com.xtrakick.app.model.chat.StvUser
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.ui.view.CenteredImageSpan
import com.xtrakick.app.ui.view.NamePaintImageSpan
import com.xtrakick.app.ui.view.NamePaintSpan
import com.xtrakick.app.util.KickApiHelper
import java.lang.ref.WeakReference
import java.util.Collections
import java.util.LinkedHashMap
import java.util.Random
import java.util.WeakHashMap
import kotlin.math.floor
import kotlin.math.pow

object ChatAdapterUtils {

    /** Neutral grey already used throughout this file for system/notice text. */
    private const val FALLBACK_USERNAME_COLOR = 0xFF999999.toInt()
    private const val DEFAULT_ANIMATED_EMOTE_FPS = 15
    private val animatedFrameSchedulers = Collections.synchronizedMap(
        WeakHashMap<View, AnimatedFrameScheduler>()
    )

    private class AnimatedFrameScheduler(rootView: View, framesPerSecond: Int) {
        private val rootViewRef = WeakReference(rootView)
        private val dirtyViews = Collections.synchronizedMap(WeakHashMap<View, Unit>())
        private var frameIntervalMs = frameIntervalMs(framesPerSecond)
        private var lastInvalidateMs = 0L
        private var invalidateScheduled = false
        private val invalidateRunnable = Runnable {
            invalidateScheduled = false
            lastInvalidateMs = SystemClock.uptimeMillis()
            val views = synchronized(dirtyViews) {
                dirtyViews.keys.toList().also { dirtyViews.clear() }
            }
            views.forEach(View::invalidate)
        }

        fun updateFrameRate(framesPerSecond: Int) {
            frameIntervalMs = frameIntervalMs(framesPerSecond)
        }

        fun requestInvalidate(view: View) {
            dirtyViews[view] = Unit
            val rootView = rootViewRef.get() ?: return
            val now = SystemClock.uptimeMillis()
            val delayMs = frameIntervalMs - (now - lastInvalidateMs)
            if (delayMs <= 0L) {
                if (invalidateScheduled) {
                    rootView.removeCallbacks(invalidateRunnable)
                    invalidateScheduled = false
                }
                invalidateRunnable.run()
            } else if (!invalidateScheduled) {
                invalidateScheduled = true
                rootView.postDelayed(invalidateRunnable, delayMs)
            }
        }

        companion object {
            private fun frameIntervalMs(framesPerSecond: Int): Long =
                (1_000L / framesPerSecond.coerceIn(5, 60)).coerceAtLeast(1L)
        }
    }

    private fun animatedFrameScheduler(itemView: View, framesPerSecond: Int): AnimatedFrameScheduler {
        val rootView = itemView.rootView
        return synchronized(animatedFrameSchedulers) {
            animatedFrameSchedulers[rootView]?.apply {
                updateFrameRate(framesPerSecond)
            } ?: AnimatedFrameScheduler(rootView, framesPerSecond).also {
                animatedFrameSchedulers[rootView] = it
            }
        }
    }

    private class ThrottledAnimatedDrawable(
        private val delegate: Drawable,
        private val itemView: View,
        framesPerSecond: Int,
    ) : Drawable(), Animatable, Drawable.Callback {
        private val scheduler = animatedFrameScheduler(itemView, framesPerSecond)
        private val animation = delegate as Animatable

        init {
            delegate.callback = this
        }

        override fun draw(canvas: Canvas) = delegate.draw(canvas)

        override fun onBoundsChange(bounds: android.graphics.Rect) {
            delegate.bounds = bounds
        }

        override fun setAlpha(alpha: Int) {
            delegate.alpha = alpha
        }

        override fun setColorFilter(colorFilter: ColorFilter?) {
            delegate.colorFilter = colorFilter
        }

        @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
        override fun getOpacity(): Int = delegate.opacity

        override fun getIntrinsicWidth(): Int = delegate.intrinsicWidth

        override fun getIntrinsicHeight(): Int = delegate.intrinsicHeight

        override fun start() = animation.start()

        override fun stop() = animation.stop()

        override fun isRunning(): Boolean = animation.isRunning

        override fun invalidateDrawable(who: Drawable) {
            scheduler.requestInvalidate(itemView)
        }

        override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
            itemView.postDelayed(what, (`when` - SystemClock.uptimeMillis()).coerceAtLeast(0L))
        }

        override fun unscheduleDrawable(who: Drawable, what: Runnable) {
            itemView.removeCallbacks(what)
        }
    }

    private fun throttleAnimatedDrawable(drawable: Drawable, itemView: View, framesPerSecond: Int): Drawable {
        return if (drawable is Animatable) {
            ThrottledAnimatedDrawable(drawable, itemView, framesPerSecond).apply {
                bounds = drawable.bounds
            }
        } else {
            drawable
        }
    }

    private fun resolveKickRewardNoticeColor(
        rewardColor: String?,
        savedColors: HashMap<String, Int>,
        useReadableColors: Boolean,
        isLightTheme: Boolean,
    ): Int {
        val parsed = runCatching { Color.parseColor(rewardColor) }.getOrNull()
        if (parsed != null) {
            val background = if (isLightTheme) Color.WHITE else Color.BLACK
            val contrast = ColorUtils.calculateContrast(parsed, background)
            return if (contrast >= 3.0) {
                parsed
            } else if (isLightTheme) {
                ColorUtils.blendARGB(parsed, Color.BLACK, 0.45f)
            } else {
                ColorUtils.blendARGB(parsed, Color.WHITE, 0.35f)
            }
        }
        return getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)
    }

    private fun applyKickRewardNoticeStyle(
        builder: SpannableStringBuilder,
        start: Int,
        end: Int,
        rewardColor: String?,
        savedColors: HashMap<String, Int>,
        useReadableColors: Boolean,
        isLightTheme: Boolean,
    ) {
        if (end <= start) return
        builder.setSpan(
            ForegroundColorSpan(resolveKickRewardNoticeColor(rewardColor, savedColors, useReadableColors, isLightTheme)),
            start,
            end,
            SPAN_EXCLUSIVE_EXCLUSIVE,
        )
        builder.setSpan(RelativeSizeSpan(1.08f), start, end, SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.setSpan(StyleSpan(Typeface.BOLD), start, end, SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    internal fun splitConcatenatedThirdPartyEmotes(token: String, emotes: List<Emote>): List<Emote>? {
        if (token.isBlank() || emotes.isEmpty()) return null
        val emotesByName = emotes
            .mapNotNull { emote -> emote.name?.takeIf(String::isNotBlank)?.let { it to emote } }
            .groupBy({ it.first }, { it.second })
        if (emotesByName.isEmpty()) return null
        val names = emotesByName.keys.sortedByDescending { it.length }
        val memo = HashMap<Int, List<Emote>?>()

        fun resolve(index: Int): List<Emote>? {
            if (index == token.length) return emptyList()
            memo[index]?.let { return it }
            for (name in names) {
                if (!token.startsWith(name, index)) continue
                val match = emotesByName[name]?.firstOrNull() ?: continue
                val suffix = resolve(index + name.length)
                if (suffix != null) {
                    return listOf(match) + suffix
                }
            }
            memo[index] = null
            return null
        }

        return resolve(0)?.takeIf { it.size > 1 }
    }

    private val chatNameColors = intArrayOf(-65536, -16776961, -16744448, -5103070, -32944, -6632142, -47872, -13726889, -2448096, -2987746, -10510688, -14774017, -38476, -7722014, -16711809)
    private const val RED_HUE_DEGREES = 0f
    private const val GREEN_HUE_DEGREES = 120f
    private const val BLUE_HUE_DEGREES = 240f
    private const val PI_DEGREES = 180f
    private const val TWO_PI_DEGREES = 360f
    private const val CHAT_IMAGE_CACHE_SIZE = 300
    private val preparedMessages = Collections.synchronizedMap(WeakHashMap<ChatMessage, MutableMap<Long, MessageResult>>())
    private val chatImageCoordinator = RequestCoordinator<ChatImageKey, Drawable>(CHAT_IMAGE_CACHE_SIZE)

    internal data class ChatImageKey(
        val source: String,
        val targetHeight: Int,
        val isEmote: Boolean,
        val isAnimated: Boolean,
    )

    internal class RequestCoordinator<K, V>(private val maxEntries: Int) {
        private val cache = object : LinkedHashMap<K, V>(maxEntries, 0.75f, true) {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
                return size > maxEntries
            }
        }
        private val inFlight = mutableMapOf<K, MutableList<(V?) -> Unit>>()

        fun load(
            key: K,
            onCacheHit: ((K) -> Unit)? = null,
            onInFlightJoin: ((K) -> Unit)? = null,
            onEnqueue: ((K) -> Unit)? = null,
            startLoad: (((V?) -> Unit) -> Unit),
            callback: (V?) -> Unit,
        ) {
            synchronized(this) {
                cache[key]?.let {
                    onCacheHit?.invoke(key)
                    callback(it)
                    return
                }
                inFlight[key]?.let {
                    it.add(callback)
                    onInFlightJoin?.invoke(key)
                    return
                }
                inFlight[key] = mutableListOf(callback)
                onEnqueue?.invoke(key)
            }
            startLoad { value ->
                val callbacks = synchronized(this) {
                    if (value != null) {
                        cache[key] = value
                    }
                    inFlight.remove(key).orEmpty()
                }
                callbacks.forEach { it(value) }
            }
        }

        fun clear() {
            synchronized(this) {
                cache.clear()
                inFlight.clear()
            }
        }
    }

    internal fun chatImageKeyForTest(image: Image, emoteQuality: String, targetHeight: Int): ChatImageKey? {
        return resolveImageSource(image, emoteQuality)?.let { source ->
            createChatImageKey(image, source, targetHeight)
        }
    }

    private fun resolveReplyDisplayName(chatMessage: ChatMessage, nameDisplay: String?): String? {
        val replyLogin = chatMessage.replyParent?.userLogin ?: chatMessage.reply?.userLogin
        val replyName = chatMessage.replyParent?.userName ?: chatMessage.reply?.userName
        return if (replyName != null && replyLogin != null && !replyLogin.equals(replyName, true)) {
            when (nameDisplay) {
                "0" -> "${replyName}(${replyLogin})"
                "1" -> replyName
                else -> replyLogin
            }
        } else {
            replyName ?: replyLogin
        }
    }

    private fun appendDeletedLabel(
        builder: SpannableStringBuilder,
        start: Int,
        savedColors: HashMap<String, Int>,
        useReadableColors: Boolean,
        isLightTheme: Boolean,
    ): Int {
        val deletedLabel = "(Deleted)"
        builder.append(deletedLabel)
        builder.setSpan(
            ForegroundColorSpan(getSavedColor("#B95C5C", savedColors, useReadableColors, isLightTheme)),
            start,
            start + deletedLabel.length,
            SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(StyleSpan(Typeface.ITALIC), start, start + deletedLabel.length, SPAN_EXCLUSIVE_EXCLUSIVE)
        return deletedLabel.length
    }

    private fun isReplyDirectedAtLoggedInUser(chatMessage: ChatMessage, loggedInUser: String?): Boolean {
        if (loggedInUser.isNullOrBlank()) {
            return false
        }
        if (chatMessage.userLogin.equals(loggedInUser, true)) {
            return false
        }
        val replyTargets = listOfNotNull(
            chatMessage.replyParent?.userLogin,
            chatMessage.replyParent?.userName,
            chatMessage.reply?.userLogin,
            chatMessage.reply?.userName,
        )
        return replyTargets.any { it.equals(loggedInUser, true) }
    }

    fun hasUserIdentity(chatMessage: ChatMessage?): Boolean {
        return chatMessage != null &&
            (!chatMessage.userId.isNullOrBlank() ||
                !chatMessage.userLogin.isNullOrBlank() ||
                !chatMessage.userName.isNullOrBlank())
    }

    fun isMessageHighlightedForLoggedInUser(
        chatMessage: ChatMessage,
        loggedInUser: String?,
        renderedText: CharSequence? = null,
    ): Boolean {
        if (loggedInUser.isNullOrBlank()) {
            return false
        }
        if (chatMessage.isReply) {
            return false
        }
        if (isReplyDirectedAtLoggedInUser(chatMessage, loggedInUser)) {
            return true
        }
        if (chatMessage.userLogin.equals(loggedInUser, true)) {
            return false
        }
        val textToInspect = renderedText?.toString() ?: chatMessage.message ?: return false
        return textToInspect
            .split(" ")
            .any { token ->
                !Patterns.WEB_URL.matcher(token).matches() && token.contains(loggedInUser, true)
            }
    }

    fun prepareChatMessage(chatMessage: ChatMessage, cacheSignature: Long, enableTimestamps: Boolean, timestampFormat: String?, firstMsgVisibility: Int, firstChatMsg: String, redeemedChatMsg: String, redeemedNoMsg: String, rewardChatMsg: String, replyMessage: String, imageClick: ((String?, String?, String?, Boolean?, Int?, Boolean?, String?) -> Unit)?, useRandomColors: Boolean, random: Random, useReadableColors: Boolean, isLightTheme: Boolean, nameDisplay: String?, useBoldNames: Boolean, showNamePaints: Boolean, namePaints: List<NamePaint>, showStvBadges: Boolean, showKickBadges: Boolean, stvBadges: List<StvBadge>, showPersonalEmotes: Boolean, personalEmoteSets: Map<String, List<Emote>>, stvUsers: List<StvUser>, enableOverlayEmotes: Boolean, showSystemMessageEmotes: Boolean, loggedInUser: String?, chatUrl: String?, getEmoteBytes: ((String, Pair<Long, Int>) -> ByteArray?)?, userColors: HashMap<String, Int>, savedColors: HashMap<String, Int>, localChatEmotes: List<ChatEmote>, thirdPartyEmotes: List<Emote>, globalBadges: List<ChatBadge>, channelBadges: List<ChatBadge>, cheerEmotes: List<CheerEmote>, savedLocalChatEmotes: MutableMap<String, ByteArray>, savedLocalBadges: MutableMap<String, ByteArray>, savedLocalCheerEmotes: MutableMap<String, ByteArray>, savedLocalEmotes: MutableMap<String, ByteArray>): MessageResult {
        synchronized(preparedMessages) {
            preparedMessages[chatMessage]?.get(cacheSignature)?.let { return it.copyForBind() }
        }
        val builder = SpannableStringBuilder()
        val images = ArrayList<Image>()
        var imagePaint: NamePaint? = null
        var userName: String? = null
        var userNameStartIndex: Int? = null
        var wasMentioned = false
        var builderIndex = 0
        var backgroundRes = 0
        when {
            chatMessage.isReply -> {
                val userName = resolveReplyDisplayName(chatMessage, nameDisplay).orEmpty()
                val string = replyMessage.format(userName, "")
                builder.append(string)
                builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), 0, string.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                builderIndex += string.length
                val message = chatMessage.reply?.message
                if (message != null) {
                    builder.append(message)
                    builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), builderIndex, builderIndex + message.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    val replySourceMessage = chatMessage.replyParent?.takeIf { it.message == message } ?: chatMessage
                    prepareEmotes(replySourceMessage, message, builder, builderIndex, images, null, useReadableColors, isLightTheme, enableOverlayEmotes, useBoldNames, loggedInUser, chatUrl, getEmoteBytes, savedColors, localChatEmotes, showPersonalEmotes, personalEmoteSets, null, thirdPartyEmotes, cheerEmotes, savedLocalChatEmotes, savedLocalCheerEmotes, savedLocalEmotes)
                    builderIndex = builder.length
                }
                if (isReplyDirectedAtLoggedInUser(chatMessage, loggedInUser)) {
                    backgroundRes = R.color.chatMessageMention
                }
            }
            chatMessage.message.isNullOrBlank() && (chatMessage.systemMsg != null || chatMessage.reward?.title != null) -> {
                if (chatMessage.timestamp != null && enableTimestamps) {
                    val timestamp = KickApiHelper.getTimestamp(chatMessage.timestamp, timestampFormat)
                    if (timestamp != null) {
                        builder.append("$timestamp ")
                        builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), 0, timestamp.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                        builderIndex += timestamp.length + 1
                    }
                }
                if (chatMessage.systemMsg != null) {
                    builder.append(chatMessage.systemMsg)
                    builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), builderIndex, builderIndex + chatMessage.systemMsg.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    if (showSystemMessageEmotes) {
                        prepareEmotes(chatMessage, chatMessage.systemMsg, builder, builderIndex, images, imageClick, useReadableColors, isLightTheme, enableOverlayEmotes, useBoldNames, loggedInUser, chatUrl, getEmoteBytes, savedColors, localChatEmotes, showPersonalEmotes, personalEmoteSets, null, thirdPartyEmotes, cheerEmotes, savedLocalChatEmotes, savedLocalCheerEmotes, savedLocalEmotes)
                    }
                    builderIndex = builder.length
                } else {
                    if (chatMessage.reward?.title != null) {
                        val userName = if (chatMessage.userLogin != null && !chatMessage.userLogin.equals(chatMessage.userName, true)) {
                            when (nameDisplay) {
                                "0" -> "${chatMessage.userName}(${chatMessage.userLogin})"
                                "1" -> chatMessage.userName
                                else -> chatMessage.userLogin
                            }
                        } else {
                            chatMessage.userName
                        }
                        val string = redeemedNoMsg.format(userName, chatMessage.reward.title)
                        builder.append("$string ")
                        applyKickRewardNoticeStyle(
                            builder = builder,
                            start = builderIndex,
                            end = builderIndex + string.length,
                            rewardColor = chatMessage.reward.backgroundColor,
                            savedColors = savedColors,
                            useReadableColors = useReadableColors,
                            isLightTheme = isLightTheme,
                        )
                        if (showSystemMessageEmotes) {
                            prepareEmotes(chatMessage, string, builder, builderIndex, images, imageClick, useReadableColors, isLightTheme, enableOverlayEmotes, useBoldNames, loggedInUser, chatUrl, getEmoteBytes, savedColors, localChatEmotes, showPersonalEmotes, personalEmoteSets, null, thirdPartyEmotes, cheerEmotes, savedLocalChatEmotes, savedLocalCheerEmotes, savedLocalEmotes)
                        }
                        builderIndex = builder.length
                        builder.append(". ")
                        builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        images.add(Image(
                            url1x = chatMessage.reward.url1x,
                            url2x = chatMessage.reward.url2x,
                            url3x = chatMessage.reward.url4x,
                            url4x = chatMessage.reward.url4x,
                            start = builderIndex++,
                            end = builderIndex++
                        ))
                        if (chatMessage.reward.cost != null) {
                            builder.append("${chatMessage.reward.cost}")
                            builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), builderIndex, builderIndex + chatMessage.reward.cost.toString().length, SPAN_EXCLUSIVE_EXCLUSIVE)
                            builderIndex += chatMessage.reward.cost.toString().length
                        }
                    }
                }
            }
            else -> {
                if (chatMessage.systemMsg != null) {
                    builder.append("${chatMessage.systemMsg}\n")
                    builderIndex += chatMessage.systemMsg.length + 1
                } else {
                    if (chatMessage.msgId != null && chatMessage.msgId != "kick_moderation") {
                        val msgId = KickApiHelper.getMessageIdString(chatMessage.msgId) ?: chatMessage.msgId
                        builder.append("$msgId\n")
                        builderIndex += msgId.length + 1
                    }
                }
                if (chatMessage.isFirst && firstMsgVisibility == 0) {
                    builder.append("$firstChatMsg\n")
                    builderIndex += firstChatMsg.length + 1
                }
                if (chatMessage.reward?.title != null) {
                    val string = redeemedChatMsg.format(chatMessage.reward.title)
                    builder.append("$string ")
                    applyKickRewardNoticeStyle(
                        builder = builder,
                        start = builderIndex,
                        end = builderIndex + string.length,
                        rewardColor = chatMessage.reward.backgroundColor,
                        savedColors = savedColors,
                        useReadableColors = useReadableColors,
                        isLightTheme = isLightTheme,
                    )
                    builderIndex += string.length + 1
                    builder.append(". ")
                    builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                    images.add(Image(
                        url1x = chatMessage.reward.url1x,
                        url2x = chatMessage.reward.url2x,
                        url3x = chatMessage.reward.url4x,
                        url4x = chatMessage.reward.url4x,
                        start = builderIndex++,
                        end = builderIndex++
                    ))
                    if (chatMessage.reward.cost != null) {
                        builder.append("${chatMessage.reward.cost}")
                        builderIndex += chatMessage.reward.cost.toString().length
                    }
                    builder.append("\n")
                    builderIndex += 1
                } else {
                    if (chatMessage.reward?.id != null && firstMsgVisibility == 0) {
                        builder.append("$rewardChatMsg\n")
                        builderIndex += rewardChatMsg.length + 1
                    }
                }
                if (chatMessage.timestamp != null && enableTimestamps) {
                    val timestamp = KickApiHelper.getTimestamp(chatMessage.timestamp, timestampFormat)
                    if (timestamp != null) {
                        builder.append("$timestamp ")
                        builder.setSpan(ForegroundColorSpan(getSavedColor("#999999", savedColors, useReadableColors, isLightTheme)), builderIndex, builderIndex + timestamp.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                        builderIndex += timestamp.length + 1
                    }
                }
                chatMessage.badges?.forEach { chatBadge ->
                    val badge = synchronized(channelBadges) {
                        channelBadges.find { it.setId == chatBadge.setId && it.version == chatBadge.version }
                    } ?:
                    synchronized(globalBadges) {
                        globalBadges.find { it.setId == chatBadge.setId && it.version == chatBadge.version }
                    }
                    if (badge != null) {
                        builder.append(". ")
                        builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        if (imageClick != null) {
                            builder.setSpan(object : ClickableSpan() {
                                override fun onClick(widget: View) {
                                    imageClick(badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x, badge.title, null, null, null, null, null)
                                }

                                override fun updateDrawState(ds: TextPaint) {}
                            }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        images.add(Image(
                            localData = badge.localData?.let { getLocalEmoteData(badge.setId + badge.version, it, savedLocalBadges, chatUrl, getEmoteBytes) },
                            url1x = badge.url1x,
                            url2x = badge.url2x,
                            url3x = badge.url3x,
                            url4x = badge.url4x,
                            start = builderIndex++,
                            end = builderIndex++
                        ))
                    } else if (showKickBadges) {
                        val kickBadgeUrl = chatBadge.url4x ?: chatBadge.url3x ?: chatBadge.url2x ?: chatBadge.url1x
                        if (!kickBadgeUrl.isNullOrBlank()) {
                            builder.append(". ")
                            builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                            if (imageClick != null) {
                                builder.setSpan(object : ClickableSpan() {
                                    override fun onClick(widget: View) {
                                        imageClick(
                                            kickBadgeUrl,
                                            chatBadge.title ?: chatBadge.setId.removePrefix("kick:"),
                                            null,
                                            null,
                                            null,
                                            null,
                                            null
                                        )
                                    }

                                    override fun updateDrawState(ds: TextPaint) {}
                                }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            images.add(Image(
                                url1x = chatBadge.url1x,
                                url2x = chatBadge.url2x,
                                url3x = chatBadge.url3x,
                                url4x = chatBadge.url4x,
                                start = builderIndex++,
                                end = builderIndex++
                            ))
                        }
                    }
                }
                val stvUser = if ((showStvBadges || showNamePaints || showPersonalEmotes) && !chatMessage.userId.isNullOrBlank()) {
                    synchronized(stvUsers) {
                        stvUsers.find { it.userId == chatMessage.userId }
                    }
                } else null
                if (showStvBadges && !chatMessage.userId.isNullOrBlank()) {
                    val badge = stvUser?.badgeId?.let { badgeId ->
                        synchronized(stvBadges) {
                            stvBadges.find { it.id == badgeId }
                        }
                    }
                    if (badge != null) {
                        builder.append(". ")
                        builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        if (imageClick != null) {
                            builder.setSpan(object : ClickableSpan() {
                                override fun onClick(widget: View) {
                                    imageClick(badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x, badge.name, badge.format, true, null, true, null)
                                }

                                override fun updateDrawState(ds: TextPaint) {}
                            }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        images.add(Image(
                            url1x = badge.url1x,
                            url2x = badge.url2x,
                            url3x = badge.url3x,
                            url4x = badge.url4x,
                            format = badge.format,
                            isAnimated = true,
                            thirdParty = true,
                            start = builderIndex++,
                            end = builderIndex++
                        ))
                    }
                }
                val color = if (chatMessage.color != null) {
                    getSavedColor(chatMessage.color, savedColors, useReadableColors, isLightTheme)
                } else {
                    userColors[chatMessage.userName] ?: if (useRandomColors) {
                        chatNameColors[random.nextInt(chatNameColors.size)]
                    } else {
                        -10066329
                    }.let { newColor ->
                        if (useReadableColors) {
                            adaptUsernameColor(newColor, isLightTheme)
                        } else {
                            newColor
                        }.also { if (chatMessage.userName != null) userColors[chatMessage.userName] = it }
                    }
                }
                if (!chatMessage.userName.isNullOrBlank()) {
                    userName = if (chatMessage.userLogin != null && !chatMessage.userLogin.equals(chatMessage.userName, true)) {
                        when (nameDisplay) {
                            "0" -> "${chatMessage.userName}(${chatMessage.userLogin})"
                            "1" -> chatMessage.userName
                            else -> chatMessage.userLogin
                        }
                    } else {
                        chatMessage.userName
                    }
                    builder.append(userName)
                    builder.setSpan(ForegroundColorSpan(color), builderIndex, builderIndex + userName.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    if (useBoldNames) {
                        builder.setSpan(StyleSpan(Typeface.BOLD), builderIndex, builderIndex + userName.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    if (showNamePaints && !chatMessage.userId.isNullOrBlank()) {
                        stvUser?.paintId?.let { paintId ->
                            synchronized(namePaints) {
                                namePaints.find { it.id == paintId }
                            }
                        }?.let { paint ->
                            when (paint.type) {
                                "LINEAR_GRADIENT", "RADIAL_GRADIENT" -> {
                                    if (paint.colors != null && paint.colorPositions != null) {
                                        builder.setSpan(
                                            NamePaintSpan(
                                                userName,
                                                paint.type,
                                                paint.colors,
                                                paint.colorPositions,
                                                paint.angle,
                                                paint.repeat,
                                                paint.shadows
                                            ),
                                            builderIndex,
                                            builderIndex + userName.length,
                                            SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                    }
                                }
                                "URL" -> {
                                    if (!paint.imageUrl.isNullOrBlank()) {
                                        imagePaint = paint
                                        userNameStartIndex = builderIndex
                                    }
                                }
                            }
                        }
                    }
                    builderIndex += userName.length
                    if (!chatMessage.isAction) {
                        builder.append(": ")
                        builderIndex += 2
                    } else {
                        builder.append(" ")
                        builderIndex += 1
                    }
                }
                if (chatMessage.message != null) {
                    val messageStart = builderIndex
                    builder.append(chatMessage.message)
                    if (chatMessage.isAction) {
                        builder.setSpan(ForegroundColorSpan(color), builderIndex, builderIndex + chatMessage.message.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    val result = prepareEmotes(chatMessage, chatMessage.message, builder, builderIndex, images, imageClick, useReadableColors, isLightTheme, enableOverlayEmotes, useBoldNames, loggedInUser, chatUrl, getEmoteBytes, savedColors, localChatEmotes, showPersonalEmotes, personalEmoteSets, stvUser, thirdPartyEmotes, cheerEmotes, savedLocalChatEmotes, savedLocalCheerEmotes, savedLocalEmotes)
                    wasMentioned = result || isMessageHighlightedForLoggedInUser(chatMessage, loggedInUser, builder.subSequence(messageStart, builder.length))
                    builderIndex = builder.length
                    if (chatMessage.isDeleted) {
                        builder.setSpan(StrikethroughSpan(), messageStart, builderIndex, SPAN_EXCLUSIVE_EXCLUSIVE)
                        builder.append(" ")
                        builderIndex += 1
                        builderIndex += appendDeletedLabel(builder, builderIndex, savedColors, useReadableColors, isLightTheme)
                    }
                }
                when {
                    chatMessage.isFirst && firstMsgVisibility < 2 -> backgroundRes = R.color.chatMessageFirst
                    chatMessage.reward?.id != null && firstMsgVisibility < 2 -> backgroundRes = R.color.chatMessageReward
                    chatMessage.systemMsg != null || (chatMessage.msgId != null && chatMessage.msgId != "kick_moderation") -> backgroundRes = R.color.chatMessageNotice
                    wasMentioned -> backgroundRes = R.color.chatMessageMention
                }
            }
        }
        val result = MessageResult(builder, images, imagePaint, userName, userNameStartIndex, backgroundRes)
        synchronized(preparedMessages) {
            val messageCache = preparedMessages.getOrPut(chatMessage) { mutableMapOf() }
            messageCache[cacheSignature] = result
        }
        return result.copyForBind()
    }

    class MessageResult(
        val builder: SpannableStringBuilder,
        val images: ArrayList<Image>,
        val imagePaint: NamePaint?,
        val userName: String?,
        val userNameStartIndex: Int?,
        val backgroundRes: Int,
    ) {
        fun copyForBind(): MessageResult {
            return MessageResult(
                builder = SpannableStringBuilder(builder),
                images = ArrayList(images),
                imagePaint = imagePaint,
                userName = userName,
                userNameStartIndex = userNameStartIndex,
                backgroundRes = backgroundRes
            )
        }
    }

    fun invalidatePreparedMessage(chatMessage: ChatMessage) {
        synchronized(preparedMessages) {
            preparedMessages.remove(chatMessage)
        }
    }

    fun reserveImagePlaceholders(
        builder: SpannableStringBuilder,
        images: List<Image>,
        emoteSize: Int,
        badgeSize: Int,
    ) {
        images.forEach { image ->
            val imageSize = if (image.isEmote) {
                emoteSize
            } else {
                badgeSize
            }
            val placeholder = ColorDrawable(Color.TRANSPARENT).apply {
                setBounds(0, 0, imageSize, imageSize)
            }
            replaceImageSpan(builder, image.start, image.end, CenteredImageSpan(placeholder))
        }
    }

    private fun replaceImageSpan(
        builder: SpannableStringBuilder,
        start: Int,
        end: Int,
        span: CenteredImageSpan,
    ) {
        builder.getSpans(start, end, ImageSpan::class.java)
            .filter { builder.getSpanStart(it) == start && builder.getSpanEnd(it) == end }
            .forEach(builder::removeSpan)
        builder.setSpan(span, start, end, SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    private fun getSavedColor(color: String, savedColors: HashMap<String, Int>, useReadableColors: Boolean, isLightTheme: Boolean): Int {
        // Color.parseColor throws on any malformed string, and both callers feed it wire data
        // (chatMessage.color and emote.color) from inside onBindViewHolder — so one bad value
        // from any chatter crashed the app mid-scroll. Fall back instead, and cache the
        // fallback so a bad value isn't re-parsed for every message.
        return savedColors[color] ?: runCatching { Color.parseColor(color) }
            .getOrDefault(FALLBACK_USERNAME_COLOR)
            .let { newColor ->
                if (useReadableColors) {
                    adaptUsernameColor(newColor, isLightTheme)
                } else {
                    newColor
                }.also { savedColors[color] = it }
            }
    }

    private fun adaptUsernameColor(color: Int, isLightTheme: Boolean): Int {
        val colorArray = FloatArray(3)
        ColorUtils.colorToHSL(color, colorArray)
        if (isLightTheme) {
            val luminanceMax = 0.75f -
                    maxOf(1f - ((colorArray[0] - GREEN_HUE_DEGREES) / 100f).pow(2f), RED_HUE_DEGREES) * 0.4f
            colorArray[2] = minOf(colorArray[2], luminanceMax)
        } else {
            val distToRed = RED_HUE_DEGREES - colorArray[0]
            val distToBlue = BLUE_HUE_DEGREES - colorArray[0]
            val normDistanceToRed = distToRed - TWO_PI_DEGREES * floor((distToRed + PI_DEGREES) / TWO_PI_DEGREES)
            val normDistanceToBlue = distToBlue - TWO_PI_DEGREES * floor((distToBlue + PI_DEGREES) / TWO_PI_DEGREES)

            val luminanceMin = 0.3f +
                    maxOf((1f - (normDistanceToBlue / 40f).pow(2f)) * 0.35f, RED_HUE_DEGREES) +
                    maxOf((1f - (normDistanceToRed / 40f).pow(2f)) * 0.1f, RED_HUE_DEGREES)
            colorArray[2] = maxOf(colorArray[2], luminanceMin)
        }

        return ColorUtils.HSLToColor(colorArray)
    }

    private fun prepareEmotes(chatMessage: ChatMessage, message: String, builder: SpannableStringBuilder, startIndex: Int, images: ArrayList<Image>, imageClick: ((String?, String?, String?, Boolean?, Int?, Boolean?, String?) -> Unit)?, useReadableColors: Boolean, isLightTheme: Boolean, enableOverlayEmotes: Boolean, useBoldNames: Boolean, loggedInUser: String?, chatUrl: String?, getEmoteBytes: ((String, Pair<Long, Int>) -> ByteArray?)?, savedColors: HashMap<String, Int>, localChatEmotes: List<ChatEmote>, showPersonalEmotes: Boolean, personalEmoteSets: Map<String, List<Emote>>, stvUser: StvUser?, thirdPartyEmotes: List<Emote>, cheerEmotes: List<CheerEmote>, savedLocalChatEmotes: MutableMap<String, ByteArray>, savedLocalCheerEmotes: MutableMap<String, ByteArray>, savedLocalEmotes: MutableMap<String, ByteArray>): Boolean {
        var wasMentioned = false
        try {
            var builderIndex = startIndex
            val split = builder.substring(builderIndex).split(" ")
            var previousImage: Image? = null
            val chatEmotes = chatMessage.emotes?.map {
                val realBegin = message.offsetByCodePoints(0, it.begin)
                val realEnd = if (it.begin == realBegin) {
                    it.end
                } else {
                    it.end + realBegin - it.begin
                }
                localChatEmotes.find { emote -> emote.id == it.id }?.let { emote ->
                    ChatEmote(
                        id = emote.id,
                        name = emote.name,
                        localData = emote.localData,
                        format = emote.format,
                        isAnimated = emote.isAnimated,
                        begin = realBegin,
                        end = realEnd,
                        setId = emote.setId,
                        ownerId = emote.ownerId
                    )
                } ?: ChatEmote(id = it.id, begin = realBegin, end = realEnd)
            }?.sortedBy { it.begin }?.toMutableList()
            val personalEmotes = if (showPersonalEmotes) {
                stvUser?.emoteSetId?.let { setId ->
                    synchronized(personalEmoteSets) {
                        personalEmoteSets.entries.find { it.key == setId }?.value
                    }
                }
            } else null
            val availableThirdPartyEmotes = buildList {
                addAll(personalEmotes.orEmpty())
                addAll(synchronized(thirdPartyEmotes) { thirdPartyEmotes.toList() })
            }.distinctBy { it.name }
            for (value in split) {
                if (chatMessage.bits != null) {
                    val bitsCount = value.takeLastWhile { it.isDigit() }
                    val bitsName = value.substringBeforeLast(bitsCount)
                    if (bitsCount.isNotEmpty()) {
                        val emote = synchronized(cheerEmotes) {
                            cheerEmotes.findLast { it.name.equals(bitsName, true) && it.minBits <= bitsCount.toInt() }
                        }
                        if (emote != null) {
                            builder.replace(builderIndex, builderIndex + bitsName.length, ".")
                            builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                            if (imageClick != null) {
                                builder.setSpan(object : ClickableSpan() {
                                    override fun onClick(widget: View) {
                                        imageClick(emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x, value, emote.format, emote.isAnimated, null, null, null)
                                    }

                                    override fun updateDrawState(ds: TextPaint) {}
                                }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            images.add(Image(
                                localData = emote.localData?.let { getLocalEmoteData(emote.name + emote.minBits, it, savedLocalCheerEmotes, chatUrl, getEmoteBytes) },
                                url1x = emote.url1x,
                                url2x = emote.url2x,
                                url3x = emote.url3x,
                                url4x = emote.url4x,
                                format = emote.format,
                                isAnimated = emote.isAnimated,
                                isEmote = true,
                                start = builderIndex,
                                end = builderIndex + 1
                            ))
                            builderIndex += 1
                            if (!emote.color.isNullOrBlank()) {
                                builder.setSpan(ForegroundColorSpan(getSavedColor(emote.color, savedColors, useReadableColors, isLightTheme)), builderIndex, builderIndex + bitsCount.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            if (!chatEmotes.isNullOrEmpty()) {
                                val removed = bitsName.length - 1
                                chatEmotes.forEach {
                                    it.begin -= removed
                                    it.end -= removed
                                }
                            }
                            previousImage = null
                            builderIndex += bitsCount.length + 1
                            continue
                        }
                    }
                }
                val emote = personalEmotes?.find {
                    it.name == value
                } ?: availableThirdPartyEmotes.find { it.name == value }
                if (emote != null) {
                    if (emote.isOverlayEmote && enableOverlayEmotes && previousImage != null) {
                        builder.replace(builderIndex - 1, builderIndex + value.length, "")
                        val image = Image(
                            localData = emote.localData?.let { getLocalEmoteData(emote.name!!, it, savedLocalEmotes, chatUrl, getEmoteBytes) },
                            url1x = emote.url1x,
                            url2x = emote.url2x,
                            url3x = emote.url3x,
                            url4x = emote.url4x,
                            format = emote.format,
                            isAnimated = emote.isAnimated,
                            isEmote = true,
                            thirdParty = emote.thirdParty,
                            start = previousImage.start,
                            end = previousImage.end
                        )
                        if (!chatEmotes.isNullOrEmpty()) {
                            val removed = value.length + 1
                            chatEmotes.forEach {
                                it.begin -= removed
                                it.end -= removed
                            }
                        }
                        previousImage.overlayEmote = image
                        previousImage = image
                        continue
                    } else {
                        builder.replace(builderIndex, builderIndex + value.length, ".")
                        builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        if (imageClick != null) {
                            builder.setSpan(object : ClickableSpan() {
                                override fun onClick(widget: View) {
                                    imageClick(emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x, emote.name, emote.format, emote.isAnimated, emote.source, emote.thirdParty, null)
                                }

                                override fun updateDrawState(ds: TextPaint) {}
                            }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        val image = Image(
                            localData = emote.localData?.let { getLocalEmoteData(emote.name!!, it, savedLocalEmotes, chatUrl, getEmoteBytes) },
                            url1x = emote.url1x,
                            url2x = emote.url2x,
                            url3x = emote.url3x,
                            url4x = emote.url4x,
                            format = emote.format,
                            isAnimated = emote.isAnimated,
                            isEmote = true,
                            thirdParty = emote.thirdParty,
                            start = builderIndex,
                            end = builderIndex + 1
                        )
                        images.add(image)
                        if (!chatEmotes.isNullOrEmpty()) {
                            val removed = value.length - 1
                            chatEmotes.forEach {
                                it.begin -= removed
                                it.end -= removed
                            }
                        }
                        previousImage = image
                        builderIndex += 2
                        continue
                    }
                }
                val concatenatedEmotes = splitConcatenatedThirdPartyEmotes(value, availableThirdPartyEmotes)
                if (!concatenatedEmotes.isNullOrEmpty()) {
                    val nonOverlayCount = concatenatedEmotes.count { !(it.isOverlayEmote && enableOverlayEmotes && previousImage != null) }
                    val replacement = ".".repeat(nonOverlayCount.coerceAtLeast(1))
                    builder.replace(builderIndex, builderIndex + value.length, replacement)
                    builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + replacement.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    var imageOffset = 0
                    concatenatedEmotes.forEach { matchedEmote ->
                        if (matchedEmote.isOverlayEmote && enableOverlayEmotes && previousImage != null) {
                            previousImage.overlayEmote = Image(
                                localData = matchedEmote.localData?.let { getLocalEmoteData(matchedEmote.name!!, it, savedLocalEmotes, chatUrl, getEmoteBytes) },
                                url1x = matchedEmote.url1x,
                                url2x = matchedEmote.url2x,
                                url3x = matchedEmote.url3x,
                                url4x = matchedEmote.url4x,
                                format = matchedEmote.format,
                                isAnimated = matchedEmote.isAnimated,
                                isEmote = true,
                                thirdParty = matchedEmote.thirdParty,
                                start = previousImage.start,
                                end = previousImage.end
                            )
                        } else {
                            val imageStart = builderIndex + imageOffset
                            if (imageClick != null) {
                                builder.setSpan(object : ClickableSpan() {
                                    override fun onClick(widget: View) {
                                        imageClick(
                                            matchedEmote.url4x ?: matchedEmote.url3x ?: matchedEmote.url2x ?: matchedEmote.url1x,
                                            matchedEmote.name,
                                            matchedEmote.format,
                                            matchedEmote.isAnimated,
                                            matchedEmote.source,
                                            matchedEmote.thirdParty,
                                            null
                                        )
                                    }

                                    override fun updateDrawState(ds: TextPaint) {}
                                }, imageStart, imageStart + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            val image = Image(
                                localData = matchedEmote.localData?.let { getLocalEmoteData(matchedEmote.name!!, it, savedLocalEmotes, chatUrl, getEmoteBytes) },
                                url1x = matchedEmote.url1x,
                                url2x = matchedEmote.url2x,
                                url3x = matchedEmote.url3x,
                                url4x = matchedEmote.url4x,
                                format = matchedEmote.format,
                                isAnimated = matchedEmote.isAnimated,
                                isEmote = true,
                                thirdParty = matchedEmote.thirdParty,
                                start = imageStart,
                                end = imageStart + 1
                            )
                            images.add(image)
                            previousImage = image
                            imageOffset += 1
                        }
                    }
                    if (!chatEmotes.isNullOrEmpty()) {
                        val removed = value.length - replacement.length
                        chatEmotes.forEach {
                            it.begin -= removed
                            it.end -= removed
                        }
                    }
                    builderIndex += replacement.length + 1
                    continue
                }
                val chatEmote = chatEmotes?.firstOrNull()?.let { first ->
                    val messageIndex = builderIndex - startIndex
                    when {
                        first.begin == messageIndex -> first
                        first.begin < messageIndex -> {
                            chatEmotes.remove(first)
                            chatEmotes.firstOrNull()?.takeIf { it.begin == messageIndex }
                        }
                        else -> null
                    }
                }
                if (chatEmote != null) {
                    chatEmotes.remove(chatEmote)
                    builder.replace(builderIndex, builderIndex + value.length, ".")
                    builder.setSpan(ForegroundColorSpan(Color.TRANSPARENT), builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                    val emote = localChatEmotes.find { emote -> emote.id == chatEmote.id }?.let { emote ->
                        ChatEmote(
                            id = emote.id,
                            name = emote.name,
                            localData = emote.localData,
                            format = emote.format,
                            isAnimated = emote.isAnimated,
                            begin = builderIndex,
                            end = builderIndex + 1,
                            setId = emote.setId,
                            ownerId = emote.ownerId
                        )
                    } ?: ChatEmote(id = chatEmote.id)
                    if (imageClick != null) {
                        builder.setSpan(object : ClickableSpan() {
                            override fun onClick(widget: View) {
                                imageClick(emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x, value, emote.format, emote.isAnimated, null, null, emote.id)
                            }

                            override fun updateDrawState(ds: TextPaint) {}
                        }, builderIndex, builderIndex + 1, SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    val image = Image(
                        localData = emote.localData?.let { getLocalEmoteData(emote.id!!, it, savedLocalChatEmotes, chatUrl, getEmoteBytes) },
                        url1x = emote.url1x,
                        url2x = emote.url2x,
                        url3x = emote.url3x,
                        url4x = emote.url4x,
                        format = emote.format,
                        isAnimated = emote.isAnimated,
                        isEmote = true,
                        start = builderIndex,
                        end = builderIndex + 1
                    )
                    images.add(image)
                    if (!chatEmotes.isNullOrEmpty()) {
                        val removed = value.length - 1
                        chatEmotes.forEach {
                            it.begin -= removed
                            it.end -= removed
                        }
                    }
                    previousImage = image
                    builderIndex += 2
                    continue
                }
                if (Patterns.WEB_URL.matcher(value).matches()) {
                    val url = if (value.startsWith("http")) value else "https://$value"
                    builder.setSpan(URLSpan(url), builderIndex, builderIndex + value.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    previousImage = null
                    builderIndex += value.length + 1
                    continue
                }
                if (value.startsWith('@') && useBoldNames) {
                    builder.setSpan(StyleSpan(Typeface.BOLD), builderIndex, builderIndex + value.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                if (!wasMentioned &&
                    !loggedInUser.isNullOrBlank() &&
                    value.contains(loggedInUser, true) &&
                    chatMessage.userId != null &&
                    chatMessage.userLogin != loggedInUser
                ) {
                    wasMentioned = true
                }
                previousImage = null
                builderIndex += value.length + 1
            }
        } catch (e: Exception) {

        }
        return wasMentioned
    }

    private fun getLocalEmoteData(name: String, data: Pair<Long, Int>, savedLocalEmotes: MutableMap<String, ByteArray>, chatUrl: String?, getEmoteBytes: ((String, Pair<Long, Int>) -> ByteArray?)?): ByteArray? {
        return savedLocalEmotes[name] ?: chatUrl?.let { url ->
            getEmoteBytes?.let { get ->
                get(url, data)?.also {
                    if (savedLocalEmotes.size >= 100) {
                        savedLocalEmotes.remove(savedLocalEmotes.keys.first())
                    }
                    savedLocalEmotes[name] = it
                }
            }
        }
    }

    fun loadImages(fragment: Fragment, itemView: View, bind: (SpannableStringBuilder) -> Unit, images: List<Image>, imagePaint: NamePaint?, userName: String?, userNameStartIndex: Int?, backgroundColor: Int, imageLibrary: String?, builder: SpannableStringBuilder, emoteSize: Int, badgeSize: Int, emoteQuality: String, animateGifs: Boolean, enableOverlayEmotes: Boolean, animatedEmoteFps: Int = DEFAULT_ANIMATED_EMOTE_FPS) {
        if (imagePaint != null) {
            if (imageLibrary == "0") {
                fragment.requireContext().imageLoader.enqueue(
                    ImageRequest.Builder(fragment.requireContext()).apply {
                        data(imagePaint.imageUrl)
                        val targetSize = (itemView as? android.widget.TextView)?.lineHeight?.takeIf { it > 0 } ?: badgeSize
                        size(targetSize, targetSize)
                        crossfade(false)
                        httpHeaders(NetworkHeaders.Builder().apply {
                            add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                        }.build())
                        target(
                            onSuccess = {
                                (it.asDrawable(fragment.resources)).let { loaded ->
                                    val result = if (loaded is Animatable && animateGifs) {
                                        throttleAnimatedDrawable(loaded, itemView, animatedEmoteFps).also {
                                            startAnimationIfOnScreen(it, itemView)
                                        }
                                    } else loaded
                                    try {
                                        builder.setSpan(
                                            NamePaintImageSpan(
                                                userName!!,
                                                imagePaint.shadows,
                                                (itemView.background as? ColorDrawable)?.color,
                                                backgroundColor,
                                                result
                                            ),
                                            userNameStartIndex!!,
                                            userNameStartIndex + userName.length,
                                            SPAN_EXCLUSIVE_EXCLUSIVE
                                        )
                                    } catch (e: IndexOutOfBoundsException) {
                                    }
                                    bind(builder)
                                }
                            },
                        )
                    }.build()
                )
            } else {
                Glide.with(fragment)
                    .load(GlideUrl(imagePaint.imageUrl) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) })
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(object : CustomTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            val result = if (resource is Animatable && animateGifs) {
                                throttleAnimatedDrawable(resource, itemView, animatedEmoteFps).also {
                                    startAnimationIfOnScreen(it, itemView)
                                }
                            } else resource
                            try {
                                builder.setSpan(
                                    NamePaintImageSpan(
                                        userName!!,
                                        imagePaint.shadows,
                                        (itemView.background as? ColorDrawable)?.color,
                                        backgroundColor,
                                        result
                                    ),
                                    userNameStartIndex!!,
                                    userNameStartIndex + userName.length,
                                    SPAN_EXCLUSIVE_EXCLUSIVE
                                )
                            } catch (e: IndexOutOfBoundsException) {
                            }
                            bind(builder)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
            }
        }
        images.forEach { image ->
            val imageSize = if (image.isEmote) {
                emoteSize
            } else {
                badgeSize
            }
            loadImage(imageLibrary, fragment, image, emoteQuality, imageSize) { loaded ->
                val result = prepareDrawableForChat(fragment, loaded, imageSize, itemView, animateGifs, animatedEmoteFps)
                if (image.overlayEmote != null) {
                    val drawables = arrayOf(result)
                    nextOverlayEmote(imageLibrary, fragment, drawables, image.overlayEmote!!, image, itemView, bind, builder, emoteSize, emoteQuality, animateGifs, enableOverlayEmotes, animatedEmoteFps)
                } else {
                    replaceImageSpan(builder, image.start, image.end, CenteredImageSpan(result))
                    bind(builder)
                }
            }
        }
    }

    private fun nextOverlayEmote(imageLibrary: String?, fragment: Fragment, drawables: Array<Drawable>, image: Image, bottomImage: Image, itemView: View, bind: (SpannableStringBuilder) -> Unit, builder: SpannableStringBuilder, emoteSize: Int, emoteQuality: String, animateGifs: Boolean, enableOverlayEmotes: Boolean, animatedEmoteFps: Int) {
        loadImage(imageLibrary, fragment, image, emoteQuality, emoteSize) { loaded ->
            val result = prepareDrawableForChat(fragment, loaded, emoteSize, itemView, animateGifs, animatedEmoteFps)
            val array = drawables.plus(result)
            if (image.overlayEmote != null) {
                nextOverlayEmote(imageLibrary, fragment, array, image.overlayEmote!!, bottomImage, itemView, bind, builder, emoteSize, emoteQuality, animateGifs, enableOverlayEmotes, animatedEmoteFps)
            } else {
                val layer = LayerDrawable(array)
                val width = array.maxOf { it.bounds.right }
                val height = array.maxOf { it.bounds.bottom }
                layer.setBounds(0, 0, width, height)
                replaceImageSpan(builder, bottomImage.start, bottomImage.end, CenteredImageSpan(layer))
                bind(builder)
            }
        }
    }

    private fun loadImage(imageLibrary: String?, fragment: Fragment, image: Image, emoteQuality: String, targetHeight: Int, onLoaded: (Drawable) -> Unit) {
        val source = resolveImageSource(image, emoteQuality) ?: return
        val key = createChatImageKey(image, source, targetHeight)
        if (key != null) {
            chatImageCoordinator.load(
                key = key,
                startLoad = { complete ->
                    loadImageUncached(imageLibrary, fragment, image, source, targetHeight) { result ->
                        complete(result)
                    }
                },
                callback = { cached ->
                    cached?.let { cloneDrawableForBind(fragment, it) }?.let(onLoaded)
                },
            )
        } else {
            loadImageUncached(imageLibrary, fragment, image, source, targetHeight, onLoaded)
        }
    }

    private fun loadImageUncached(imageLibrary: String?, fragment: Fragment, image: Image, source: Any, targetHeight: Int, onLoaded: (Drawable) -> Unit) {
        if (imageLibrary == "0" || (imageLibrary == "1" && !image.format.equals("webp", true))) {
            loadCoil(fragment, image, source, targetHeight, onLoaded)
        } else {
            loadGlide(fragment, image, source, onLoaded)
        }
    }

    private fun loadCoil(fragment: Fragment, image: Image, source: Any, targetHeight: Int, onLoaded: (Drawable) -> Unit) {
        fragment.requireContext().imageLoader.enqueue(
            ImageRequest.Builder(fragment.requireContext()).apply {
                data(source)
                size(targetHeight, targetHeight)
                crossfade(false)
                if (image.thirdParty) {
                    httpHeaders(NetworkHeaders.Builder().apply {
                        add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                    }.build())
                }
                target(
                    onSuccess = {
                        onLoaded((it.asDrawable(fragment.resources)))
                    },
                )
            }.build()
        )
    }

    private fun loadGlide(fragment: Fragment, image: Image, source: Any, onLoaded: (Drawable) -> Unit) {
        Glide.with(fragment)
            .load(source.let {
                if (image.thirdParty && it is String) {
                    GlideUrl(it) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) }
                } else it
            })
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    onLoaded(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }
            })
    }

    private fun cloneDrawableForBind(fragment: Fragment, drawable: Drawable): Drawable {
        return (drawable.constantState?.newDrawable(fragment.resources) ?: drawable).mutate()
    }

    private fun prepareDrawableForChat(
        fragment: Fragment,
        drawable: Drawable,
        targetHeight: Int,
        itemView: View,
        animateGifs: Boolean,
        animatedEmoteFps: Int,
    ): Drawable {
        val result = cloneDrawableForBind(fragment, drawable)
        val intrinsicWidth = result.intrinsicWidth.takeIf { it > 0 } ?: targetHeight
        val intrinsicHeight = result.intrinsicHeight.takeIf { it > 0 } ?: targetHeight
        val widthRatio = intrinsicWidth.toFloat() / intrinsicHeight.toFloat()
        val width = if (widthRatio == 1f) {
            targetHeight
        } else {
            (targetHeight * widthRatio).toInt().coerceAtLeast(1)
        }
        result.setBounds(0, 0, width, targetHeight)
        if (result is Animatable && animateGifs) {
            return throttleAnimatedDrawable(result, itemView, animatedEmoteFps).also {
                startAnimationIfOnScreen(it, itemView)
            }
        }
        return result
    }

    /**
     * Starts an animated chat drawable only while its row is on screen.
     *
     * Rows recycle while their emotes are still downloading, and ChatAdapter's
     * onViewDetachedFromWindow has already run by the time a late image arrives. Starting the
     * animation unconditionally leaves it decoding frames and rescheduling itself through
     * [View.postDelayed] forever, for a row nobody can see. ChatAdapter.onViewAttachedToWindow
     * starts the animation if the row scrolls back into view.
     */
    private fun startAnimationIfOnScreen(drawable: Drawable, itemView: View) {
        if (itemView.isAttachedToWindow) {
            (drawable as? Animatable)?.start()
        }
    }

    private fun createChatImageKey(image: Image, source: Any, targetHeight: Int): ChatImageKey? {
        if (image.localData != null || targetHeight <= 0) {
            return null
        }
        val sourceString = source as? String ?: return null
        return ChatImageKey(
            source = sourceString,
            targetHeight = targetHeight,
            isEmote = image.isEmote,
            isAnimated = image.isAnimated,
        )
    }

    private fun resolveImageSource(image: Image, emoteQuality: String): Any? {
        return image.localData ?: if (image.isEmote) {
            when (emoteQuality) {
                "4" -> image.url4x ?: image.url3x ?: image.url2x ?: image.url1x
                "3" -> image.url3x ?: image.url2x ?: image.url1x
                "2" -> image.url2x ?: image.url1x
                else -> image.url1x
            }
        } else {
            image.url4x ?: image.url3x ?: image.url2x ?: image.url1x
        }
    }

}
