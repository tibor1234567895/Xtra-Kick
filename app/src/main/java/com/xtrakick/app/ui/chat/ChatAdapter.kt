package com.xtrakick.app.ui.chat

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.InsetDrawable
import android.graphics.drawable.Animatable
import android.graphics.drawable.LayerDrawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.text.getSpans
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.CheerEmote
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.NamePaint
import com.xtrakick.app.model.chat.StvBadge
import com.xtrakick.app.model.chat.StvUser
import com.xtrakick.app.model.chat.ChatBadge
import com.xtrakick.app.model.chat.ChatEmote
import com.xtrakick.app.ui.view.NamePaintImageSpan
import com.xtrakick.app.util.chat.ChatAdapterUtils
import com.xtrakick.app.util.chat.ChatBackgroundUtils
import com.xtrakick.app.util.chat.ChatListParityUtils
import java.util.Random

class ChatAdapter(
    private val messages: List<ChatMessage>,
    private val localChatEmotes: List<ChatEmote>,
    private val thirdPartyEmotes: List<Emote>,
    private val globalBadges: List<ChatBadge>,
    private val channelBadges: List<ChatBadge>,
    private val cheerEmotes: List<CheerEmote>,
    private val namePaints: List<NamePaint>,
    private val stvBadges: List<StvBadge>,
    private val personalEmoteSets: Map<String, List<Emote>>,
    private val stvUsers: List<StvUser>,
    private var enableTimestamps: Boolean,
    private var timestampFormat: String?,
    private var firstMsgVisibility: Int,
    private val firstChatMsg: String,
    private val redeemedChatMsg: String,
    private val redeemedNoMsg: String,
    private val rewardChatMsg: String,
    private val replyMessage: String,
    private var useRandomColors: Boolean,
    private var useReadableColors: Boolean,
    private val isLightTheme: Boolean,
    private val nameDisplay: String?,
    private var useBoldNames: Boolean,
    private var showNamePaints: Boolean,
    private var showStvBadges: Boolean,
    private var showKickBadges: Boolean,
    private var showPersonalEmotes: Boolean,
    private var enableAlternatingLineShadows: Boolean,
    private var alternatingLineShadowStrength: Int,
    private var showSystemMessageEmotes: Boolean,
    private val chatUrl: String?,
    private val getEmoteBytes: ((String, Pair<Long, Int>) -> ByteArray?)?,
    private val fragment: Fragment,
    private val backgroundColor: Int,
    private val dialogBackgroundColor: Int,
    private var imageLibrary: String?,
    private var messageTextSize: Float,
    private var emoteSize: Int,
    private var badgeSize: Int,
    private var emoteQuality: String,
    private var animateGifs: Boolean,
    private var animatedEmoteFps: Int,
    private var enableOverlayEmotes: Boolean,
    private val channelId: String?,
    private val loggedInUser: String?,
    private val messageClickListener: ((String?, ChatMessage?) -> Unit)?,
    private val replyClickListener: (() -> Unit)?,
    private val imageClickListener: ((String?, String?, String?, Boolean?, Int?, Boolean?, String?) -> Unit)?,
) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    companion object {
        const val PAYLOAD_REFORMAT = "payload_reformat"
    }

    private var selectedMessage: ChatMessage? = null
    private val random = Random()
    private val userColors = HashMap<String, Int>()
    private val savedColors = HashMap<String, Int>()
    private val savedLocalChatEmotes = mutableMapOf<String, ByteArray>()
    private val savedLocalBadges = mutableMapOf<String, ByteArray>()
    private val savedLocalCheerEmotes = mutableMapOf<String, ByteArray>()
    private val savedLocalEmotes = mutableMapOf<String, ByteArray>()
    private val expandedReplyPreviewKeys = mutableSetOf<String>()
    private val truncatableReplyPreviewKeys = mutableSetOf<String>()
    private var renderGeneration = 0L

    data class LiveSettings(
        val enableTimestamps: Boolean,
        val timestampFormat: String?,
        val firstMsgVisibility: Int,
        val useRandomColors: Boolean,
        val useReadableColors: Boolean,
        val useBoldNames: Boolean,
        val showNamePaints: Boolean,
        val showStvBadges: Boolean,
        val showKickBadges: Boolean,
        val showPersonalEmotes: Boolean,
        val enableAlternatingLineShadows: Boolean,
        val alternatingLineShadowStrength: Int,
        val showSystemMessageEmotes: Boolean,
        val imageLibrary: String?,
        val messageTextSize: Float,
        val emoteSize: Int,
        val badgeSize: Int,
        val emoteQuality: String,
        val animateGifs: Boolean,
        val animatedEmoteFps: Int,
        val enableOverlayEmotes: Boolean,
    )

    private fun renderConfigSignature(): Long {
        var result = 1L
        result = 31L * result + (if (enableTimestamps) 1 else 0)
        result = 31L * result + (timestampFormat?.hashCode() ?: 0)
        result = 31L * result + firstMsgVisibility
        result = 31L * result + firstChatMsg.hashCode()
        result = 31L * result + redeemedChatMsg.hashCode()
        result = 31L * result + redeemedNoMsg.hashCode()
        result = 31L * result + rewardChatMsg.hashCode()
        result = 31L * result + replyMessage.hashCode()
        result = 31L * result + (if (useRandomColors) 1 else 0)
        result = 31L * result + (if (useReadableColors) 1 else 0)
        result = 31L * result + (if (isLightTheme) 1 else 0)
        result = 31L * result + (nameDisplay?.hashCode() ?: 0)
        result = 31L * result + (if (useBoldNames) 1 else 0)
        result = 31L * result + (if (showNamePaints) 1 else 0)
        result = 31L * result + (if (showStvBadges) 1 else 0)
        result = 31L * result + (if (showKickBadges) 1 else 0)
        result = 31L * result + (if (showPersonalEmotes) 1 else 0)
        result = 31L * result + (if (showSystemMessageEmotes) 1 else 0)
        result = 31L * result + (chatUrl?.hashCode() ?: 0)
        result = 31L * result + (loggedInUser?.hashCode() ?: 0)
        result = 31L * result + (imageLibrary?.hashCode() ?: 0)
        result = 31L * result + java.lang.Float.floatToIntBits(messageTextSize)
        result = 31L * result + emoteSize
        result = 31L * result + badgeSize
        result = 31L * result + emoteQuality.hashCode()
        result = 31L * result + (if (animateGifs) 1 else 0)
        result = 31L * result + animatedEmoteFps
        result = 31L * result + (if (enableOverlayEmotes) 1 else 0)
        result = 31L * result + (if (enableAlternatingLineShadows) 1 else 0)
        result = 31L * result + alternatingLineShadowStrength
        return result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindMessage(holder, position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            bindMessage(holder, position)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    fun invalidateFormatting() {
        renderGeneration += 1L
        synchronized(messages) {
            messages.forEach(ChatAdapterUtils::invalidatePreparedMessage)
        }
    }

    fun updateLiveSettings(settings: LiveSettings): Boolean {
        if (
            enableTimestamps == settings.enableTimestamps &&
            timestampFormat == settings.timestampFormat &&
            firstMsgVisibility == settings.firstMsgVisibility &&
            useRandomColors == settings.useRandomColors &&
            useReadableColors == settings.useReadableColors &&
            useBoldNames == settings.useBoldNames &&
            showNamePaints == settings.showNamePaints &&
            showStvBadges == settings.showStvBadges &&
            showKickBadges == settings.showKickBadges &&
            showPersonalEmotes == settings.showPersonalEmotes &&
            enableAlternatingLineShadows == settings.enableAlternatingLineShadows &&
            alternatingLineShadowStrength == settings.alternatingLineShadowStrength &&
            showSystemMessageEmotes == settings.showSystemMessageEmotes &&
            imageLibrary == settings.imageLibrary &&
            messageTextSize == settings.messageTextSize &&
            emoteSize == settings.emoteSize &&
            badgeSize == settings.badgeSize &&
            emoteQuality == settings.emoteQuality &&
            animateGifs == settings.animateGifs &&
            animatedEmoteFps == settings.animatedEmoteFps &&
            enableOverlayEmotes == settings.enableOverlayEmotes
        ) {
            return false
        }
        enableTimestamps = settings.enableTimestamps
        timestampFormat = settings.timestampFormat
        firstMsgVisibility = settings.firstMsgVisibility
        useRandomColors = settings.useRandomColors
        useReadableColors = settings.useReadableColors
        useBoldNames = settings.useBoldNames
        showNamePaints = settings.showNamePaints
        showStvBadges = settings.showStvBadges
        showKickBadges = settings.showKickBadges
        showPersonalEmotes = settings.showPersonalEmotes
        enableAlternatingLineShadows = settings.enableAlternatingLineShadows
        alternatingLineShadowStrength = settings.alternatingLineShadowStrength
        showSystemMessageEmotes = settings.showSystemMessageEmotes
        imageLibrary = settings.imageLibrary
        messageTextSize = settings.messageTextSize
        emoteSize = settings.emoteSize
        badgeSize = settings.badgeSize
        emoteQuality = settings.emoteQuality
        animateGifs = settings.animateGifs
        animatedEmoteFps = settings.animatedEmoteFps
        enableOverlayEmotes = settings.enableOverlayEmotes
        invalidateFormatting()
        return true
    }

    private fun renderSignature(): Long = renderConfigSignature() * 31L + renderGeneration

    /**
     * Identifies the message a holder is bound to, so a late image load can tell whether the
     * holder still shows the same message before applying its update.
     *
     * Deliberately excludes the adapter position: the head of the list is trimmed constantly on
     * a busy channel, which shifts every position by one and used to change the key of every
     * visible row. That made [ViewHolder.isBoundTo] report false for rows that had not actually
     * changed, dropping their pending emote updates on the floor.
     */
    private fun messageBindKey(chatMessage: ChatMessage): String {
        return chatMessage.id
            ?: chatMessage.fullMsg
            ?: "${chatMessage.timestamp ?: 0L}:${chatMessage.userId.orEmpty()}:${chatMessage.message.orEmpty()}"
    }

    private fun bindMessage(holder: ViewHolder, position: Int) {
        val chatMessage = synchronized(messages) {
            messages.getOrNull(position)
        } ?: return
        val bindKey = messageBindKey(chatMessage)
        val result = ChatAdapterUtils.prepareChatMessage(
            chatMessage, renderSignature(), enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg,
            rewardChatMsg, replyMessage, null, useRandomColors, random, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints,
            namePaints, showStvBadges, showKickBadges, stvBadges, showPersonalEmotes, personalEmoteSets, stvUsers, enableOverlayEmotes, showSystemMessageEmotes,
            loggedInUser, chatUrl, getEmoteBytes, userColors, savedColors, localChatEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, savedLocalChatEmotes, savedLocalBadges,
            savedLocalCheerEmotes, savedLocalEmotes
        )
        val effectiveEmoteSize = if (chatMessage.isReply) (emoteSize * 0.7f).toInt().coerceAtLeast(12) else emoteSize
        val effectiveBadgeSize = if (chatMessage.isReply) (badgeSize * 0.7f).toInt().coerceAtLeast(10) else badgeSize
        ChatAdapterUtils.reserveImagePlaceholders(result.builder, result.images, effectiveEmoteSize, effectiveBadgeSize)
        holder.bind(bindKey, chatMessage, result.builder, position, result.backgroundRes)
        if (result.images.isNotEmpty() || result.imagePaint != null) {
            ChatAdapterUtils.loadImages(
                fragment, holder.textView, { updatedBuilder ->
                    if (holder.isBoundTo(bindKey)) {
                        holder.bind(bindKey, chatMessage, updatedBuilder, position, result.backgroundRes)
                    }
                }, result.images, result.imagePaint, result.userName, result.userNameStartIndex,
                backgroundColor, imageLibrary, result.builder, effectiveEmoteSize, effectiveBadgeSize, emoteQuality, animateGifs, enableOverlayEmotes,
                animatedEmoteFps
            )
        }
    }

    fun createMessageClickedChatAdapter(selectedMessageOverride: ChatMessage? = selectedMessage): MessageClickedChatAdapter {
        return MessageClickedChatAdapter(
            messages, localChatEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, namePaints, stvBadges, personalEmoteSets,
            stvUsers, enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg, rewardChatMsg, replyMessage,
            { chatMessage -> selectedMessage = chatMessage; replyClickListener?.invoke() },
            { url, name, format, isAnimated, source, thirdParty, emoteId -> imageClickListener?.invoke(url, name, format, isAnimated, source, thirdParty, emoteId) },
            useRandomColors, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints, showStvBadges, showKickBadges, showPersonalEmotes,
            enableAlternatingLineShadows, alternatingLineShadowStrength, showSystemMessageEmotes, chatUrl, getEmoteBytes, fragment, dialogBackgroundColor, imageLibrary, messageTextSize, emoteSize, badgeSize,
            emoteQuality, animateGifs, enableOverlayEmotes, random, userColors,
            savedColors, savedLocalChatEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes, loggedInUser, selectedMessageOverride
        )
    }

    fun createReplyClickedChatAdapter(): ReplyClickedChatAdapter {
        return ReplyClickedChatAdapter(
            messages, localChatEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, namePaints, stvBadges, personalEmoteSets,
            stvUsers, enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg, rewardChatMsg, replyMessage,
            { url, name, format, isAnimated, source, thirdParty, emoteId -> imageClickListener?.invoke(url, name, format, isAnimated, source, thirdParty, emoteId) },
            useRandomColors, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints, showStvBadges, showKickBadges, showPersonalEmotes,
            enableAlternatingLineShadows, alternatingLineShadowStrength, showSystemMessageEmotes, chatUrl, getEmoteBytes, fragment, dialogBackgroundColor, imageLibrary, messageTextSize, emoteSize, badgeSize,
            emoteQuality, animateGifs, enableOverlayEmotes, random, userColors,
            savedColors, savedLocalChatEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes, loggedInUser, selectedMessage
        )
    }

    override fun getItemCount(): Int = synchronized(messages) {
        messages.size
    }

    private fun replyPreviewKey(chatMessage: ChatMessage): String? {
        if (!chatMessage.isReply) return null
        return listOfNotNull(
            chatMessage.reply?.threadParentId,
            chatMessage.reply?.userLogin,
            chatMessage.reply?.userName,
            chatMessage.reply?.message,
            chatMessage.timestamp?.toString(),
            chatMessage.fullMsg
        ).joinToString("|").takeIf { it.isNotBlank() }
    }

    private fun resolveMessageBackgroundColor(context: Context, position: Int, backgroundRes: Int): Int {
        val overlayColor = backgroundRes.takeIf { it != 0 }?.let { ContextCompat.getColor(context, it) }
        val visualParityPosition = synchronized(messages) {
            ChatListParityUtils.resolveVisualParityPosition(messages, position)
        }
        return ChatBackgroundUtils.resolveMessageBackgroundColor(
            surfaceColor = backgroundColor,
            overlayColor = overlayColor,
            alternatingLineShadowEnabled = enableAlternatingLineShadows,
            alternatingLineShadowStrength = alternatingLineShadowStrength,
            position = visualParityPosition,
        )
    }

    private fun resolveCurrentMessagePosition(chatMessage: ChatMessage, adapterPosition: Int, fallbackPosition: Int): Int {
        synchronized(messages) {
            if (adapterPosition in messages.indices && messages[adapterPosition] == chatMessage) {
                return adapterPosition
            }
            val currentPosition = messages.indexOf(chatMessage)
            if (currentPosition >= 0) {
                return currentPosition
            }
        }
        return fallbackPosition
    }

    private fun resolveDividerColor(position: Int, backgroundColor: Int): ChatBackgroundUtils.DividerColors? {
        val shouldDrawDivider = synchronized(messages) {
            ChatListParityUtils.shouldDrawDividerAbove(messages, position)
        }
        if (!enableAlternatingLineShadows || !shouldDrawDivider) {
            return null
        }
        return ChatBackgroundUtils.resolveDividerColors(
            surfaceColor = backgroundColor,
            dividerStrength = alternatingLineShadowStrength,
        )
    }

    private fun parseRewardColor(color: String?): Int? {
        return runCatching { Color.parseColor(color) }.getOrNull()
    }

    private fun createRewardBackgroundDrawable(baseBackgroundColor: Int, rewardColor: Int): LayerDrawable {
        val stripeDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 0f
            setColor(ColorUtils.setAlphaComponent(rewardColor, 235))
        }
        val cardDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 10f
            setColor(
                ColorUtils.compositeColors(
                    ColorUtils.setAlphaComponent(rewardColor, 40),
                    baseBackgroundColor
                )
            )
        }
        val insetCardDrawable = InsetDrawable(cardDrawable, 18, 4, 8, 4)
        return LayerDrawable(arrayOf(stripeDrawable, insetCardDrawable)).apply {
            setLayerInset(0, 8, 4, 0, 4)
            setLayerSize(0, 6, -1)
        }
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (animateGifs) {
            (holder.textView.text as? Spannable)?.let { view ->
                view.getSpans<ImageSpan>().forEach {
                    (it.drawable as? Animatable)?.start() ?:
                    (it.drawable as? LayerDrawable)?.let {
                        val lastIndex = it.numberOfLayers - 1
                        if (lastIndex > -1) {
                            for (i in 0..lastIndex) {
                                (it.getDrawable(i) as? Animatable)?.start()
                            }
                        }
                    }
                }
                view.getSpans<NamePaintImageSpan>().forEach {
                    (it.drawable as? Animatable)?.start()
                }
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        if (animateGifs) {
            (holder.textView.text as? Spannable)?.let { view ->
                view.getSpans<ImageSpan>().forEach {
                    (it.drawable as? Animatable)?.stop() ?:
                    (it.drawable as? LayerDrawable)?.let {
                        val lastIndex = it.numberOfLayers - 1
                        if (lastIndex > -1) {
                            for (i in 0..lastIndex) {
                                (it.getDrawable(i) as? Animatable)?.stop()
                            }
                        }
                    }
                }
                view.getSpans<NamePaintImageSpan>().forEach {
                    (it.drawable as? Animatable)?.stop()
                }
            }
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        val childCount = recyclerView.childCount
        if (animateGifs) {
            for (i in 0 until childCount) {
                (recyclerView.getChildAt(i).findViewById<TextView>(R.id.chatMessageText)?.text as? Spannable)?.let { view ->
                    view.getSpans<ImageSpan>().forEach {
                        (it.drawable as? Animatable)?.stop() ?:
                        (it.drawable as? LayerDrawable)?.let {
                            val lastIndex = it.numberOfLayers - 1
                            if (lastIndex > -1) {
                                for (i in 0..lastIndex) {
                                    (it.getDrawable(i) as? Animatable)?.stop()
                                }
                            }
                        }
                    }
                    view.getSpans<NamePaintImageSpan>().forEach {
                        (it.drawable as? Animatable)?.stop()
                    }
                }
            }
        }
        super.onDetachedFromRecyclerView(recyclerView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val containerView: View = itemView.findViewById(R.id.chatMessageContainer)
        private val dividerView: View = itemView.findViewById(R.id.chatLineDivider)
        private val dividerHighlightView: View = itemView.findViewById(R.id.chatLineDividerHighlight)
        private val dividerShadowView: View = itemView.findViewById(R.id.chatLineDividerShadow)
        val textView: TextView = itemView.findViewById(R.id.chatMessageText)
        private val expandView: ImageView = itemView.findViewById(R.id.chatMessageExpand)
        private var currentBindKey: String? = null
        private var bindSeq = 0L

        fun isBoundTo(bindKey: String): Boolean = currentBindKey == bindKey

        fun bind(bindKey: String, chatMessage: ChatMessage, formattedMessage: SpannableStringBuilder, position: Int, backgroundRes: Int) {
            currentBindKey = bindKey
            bindSeq++
            val boundSeq = bindSeq
            val currentPosition = resolveCurrentMessagePosition(chatMessage, bindingAdapterPosition, position)
            val resolvedBackgroundColor = resolveMessageBackgroundColor(textView.context, currentPosition, backgroundRes)
            val dividerColors = resolveDividerColor(currentPosition, resolvedBackgroundColor)
            val previewKey = replyPreviewKey(chatMessage)
            val expanded = previewKey != null && previewKey in expandedReplyPreviewKeys
            val rewardColor = parseRewardColor(chatMessage.reward?.backgroundColor)
            val isRewardRedemption = chatMessage.reward?.title != null
            textView.apply {
                text = formattedMessage
                textSize = if (chatMessage.isReply) messageTextSize * 0.85f else messageTextSize
                alpha = if (chatMessage.isDeleted) 0.62f else if (chatMessage.isReply) 0.8f else 1f
                if (isRewardRedemption && rewardColor != null) {
                    containerView.background = createRewardBackgroundDrawable(resolvedBackgroundColor, rewardColor)
                    setPaddingRelative(26, 8, 12, 8)
                } else if (chatMessage.isReply) {
                    containerView.setBackgroundColor(resolvedBackgroundColor)
                    setPaddingRelative(5, 6, 5, 6)
                } else {
                    containerView.setBackgroundColor(resolvedBackgroundColor)
                    setPaddingRelative(5, 1, 5, 1)
                }
                if (chatMessage.isReply) {
                    setLineSpacing(3f, 1.12f)
                } else {
                    setLineSpacing(0f, 1f)
                }
                minHeight = (if (chatMessage.isReply) (emoteSize * 0.7f).toInt().coerceAtLeast(12) else emoteSize) + paddingTop + paddingBottom
                setBackgroundColor(android.graphics.Color.TRANSPARENT)
                if (chatMessage.isReply) {
                    movementMethod = null
                    maxLines = if (expanded) Int.MAX_VALUE else 3
                    ellipsize = if (expanded) null else TextUtils.TruncateAt.END
                    TooltipCompat.setTooltipText(this, chatMessage.replyParent?.message ?: chatMessage.replyParent?.systemMsg)
                    setOnClickListener {
                        if (selectionStart == -1 && selectionEnd == -1) {
                            selectedMessage = chatMessage.replyParent
                            val tappedMessage = selectedMessage
                            if (ChatAdapterUtils.hasUserIdentity(tappedMessage)) {
                                messageClickListener?.invoke(channelId, tappedMessage)
                            }
                        }
                    }
                    updateReplyExpandUi(showExpand = expanded || (previewKey != null && previewKey in truncatableReplyPreviewKeys), expanded = expanded)
                    doOnLayout {
                        if (boundSeq != bindSeq || !isBoundTo(bindKey)) return@doOnLayout
                        val layout = layout ?: return@doOnLayout
                        if (expanded && previewKey != null) {
                            truncatableReplyPreviewKeys.add(previewKey)
                            updateReplyExpandUi(showExpand = true, expanded = true)
                            return@doOnLayout
                        }
                        val isTruncated = layout.lineCount > 3 || (0 until layout.lineCount).any { lineIndex ->
                            layout.getEllipsisCount(lineIndex) > 0
                        }
                        if (isTruncated) {
                            previewKey?.let { truncatableReplyPreviewKeys.add(it) }
                        }
                        updateReplyExpandUi(
                            showExpand = isTruncated || (previewKey != null && previewKey in truncatableReplyPreviewKeys),
                            expanded = false
                        )
                    }
                } else {
                    movementMethod = LinkMovementMethod.getInstance()
                    maxLines = Int.MAX_VALUE
                    ellipsize = null
                    updateReplyExpandUi(showExpand = false, expanded = false)
                    TooltipCompat.setTooltipText(this, chatMessage.message ?: chatMessage.systemMsg)
                    setOnClickListener {
                        if (selectionStart == -1 && selectionEnd == -1) {
                            selectedMessage = chatMessage
                            val tappedMessage = selectedMessage
                            if (ChatAdapterUtils.hasUserIdentity(tappedMessage)) {
                                messageClickListener?.invoke(channelId, tappedMessage)
                            }
                        }
                    }
                }
            }
            dividerView.isVisible = dividerColors != null
            dividerColors?.let {
                dividerHighlightView.setBackgroundColor(it.highlightColor)
                dividerShadowView.setBackgroundColor(it.shadowColor)
            }
            expandView.setOnClickListener {
                val key = previewKey ?: return@setOnClickListener
                if (key in expandedReplyPreviewKeys) {
                    expandedReplyPreviewKeys.remove(key)
                } else {
                    expandedReplyPreviewKeys.add(key)
                }
                val adapterPosition = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                notifyItemChanged(adapterPosition, PAYLOAD_REFORMAT)
            }
        }

        private fun updateReplyExpandUi(showExpand: Boolean, expanded: Boolean) {
            expandView.isVisible = showExpand
            expandView.isEnabled = showExpand
            expandView.rotation = if (expanded) 180f else 0f
            expandView.contentDescription = textView.context.getString(
                if (expanded) R.string.pinned_message_collapse else R.string.pinned_message_expand
            )
            textView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                endToStart = if (showExpand) R.id.chatMessageExpand else ConstraintLayout.LayoutParams.UNSET
                endToEnd = if (showExpand) ConstraintLayout.LayoutParams.UNSET else ConstraintLayout.LayoutParams.PARENT_ID
            }
        }
    }
}
