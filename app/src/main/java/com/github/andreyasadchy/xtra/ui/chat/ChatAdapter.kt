package com.github.andreyasadchy.xtra.ui.chat

import android.content.Context
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
import androidx.core.text.getSpans
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.CheerEmote
import com.github.andreyasadchy.xtra.model.chat.Emote
import com.github.andreyasadchy.xtra.model.chat.NamePaint
import com.github.andreyasadchy.xtra.model.chat.StvBadge
import com.github.andreyasadchy.xtra.model.chat.StvUser
import com.github.andreyasadchy.xtra.model.chat.TwitchBadge
import com.github.andreyasadchy.xtra.model.chat.TwitchEmote
import com.github.andreyasadchy.xtra.ui.view.NamePaintImageSpan
import com.github.andreyasadchy.xtra.util.chat.ChatAdapterUtils
import com.github.andreyasadchy.xtra.util.chat.ChatBackgroundUtils
import com.github.andreyasadchy.xtra.util.chat.ChatListParityUtils
import java.util.Random

class ChatAdapter(
    private val messages: List<ChatMessage>,
    private val localTwitchEmotes: List<TwitchEmote>,
    private val thirdPartyEmotes: List<Emote>,
    private val globalBadges: List<TwitchBadge>,
    private val channelBadges: List<TwitchBadge>,
    private val cheerEmotes: List<CheerEmote>,
    private val namePaints: List<NamePaint>,
    private val stvBadges: List<StvBadge>,
    private val personalEmoteSets: Map<String, List<Emote>>,
    private val stvUsers: List<StvUser>,
    private val enableTimestamps: Boolean,
    private val timestampFormat: String?,
    private val firstMsgVisibility: Int,
    private val firstChatMsg: String,
    private val redeemedChatMsg: String,
    private val redeemedNoMsg: String,
    private val rewardChatMsg: String,
    private val replyMessage: String,
    private val useRandomColors: Boolean,
    private val useReadableColors: Boolean,
    private val isLightTheme: Boolean,
    private val nameDisplay: String?,
    private val useBoldNames: Boolean,
    private val showNamePaints: Boolean,
    private val showStvBadges: Boolean,
    private val showKickBadges: Boolean,
    private val showPersonalEmotes: Boolean,
    private val enableAlternatingLineShadows: Boolean,
    private val alternatingLineShadowStrength: Int,
    private val showSystemMessageEmotes: Boolean,
    private val chatUrl: String?,
    private val getEmoteBytes: ((String, Pair<Long, Int>) -> ByteArray?)?,
    private val fragment: Fragment,
    private val backgroundColor: Int,
    private val dialogBackgroundColor: Int,
    private val imageLibrary: String?,
    private val messageTextSize: Float,
    private val emoteSize: Int,
    private val badgeSize: Int,
    private val emoteQuality: String,
    private val animateGifs: Boolean,
    private val enableOverlayEmotes: Boolean,
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
    private val savedLocalTwitchEmotes = mutableMapOf<String, ByteArray>()
    private val savedLocalBadges = mutableMapOf<String, ByteArray>()
    private val savedLocalCheerEmotes = mutableMapOf<String, ByteArray>()
    private val savedLocalEmotes = mutableMapOf<String, ByteArray>()
    private val expandedReplyPreviewKeys = mutableSetOf<String>()
    private var renderGeneration = 0L
    private val renderConfigSignature = listOf(
        enableTimestamps,
        timestampFormat,
        firstMsgVisibility,
        firstChatMsg,
        redeemedChatMsg,
        redeemedNoMsg,
        rewardChatMsg,
        replyMessage,
        useRandomColors,
        useReadableColors,
        isLightTheme,
        nameDisplay,
        useBoldNames,
        showNamePaints,
        showStvBadges,
        showKickBadges,
        showPersonalEmotes,
        showSystemMessageEmotes,
        chatUrl,
        loggedInUser,
        true,
        false
    ).joinToString("|").hashCode().toLong()

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

    private fun renderSignature(): Long = renderConfigSignature * 31L + renderGeneration

    private fun messageBindKey(chatMessage: ChatMessage, position: Int): String {
        return listOfNotNull(
            position.toString(),
            chatMessage.id,
            chatMessage.timestamp?.toString(),
            chatMessage.userId,
            chatMessage.userLogin,
            chatMessage.userName,
            chatMessage.message,
            chatMessage.systemMsg,
            chatMessage.fullMsg
        ).joinToString("|")
    }

    private fun bindMessage(holder: ViewHolder, position: Int) {
        val chatMessage = synchronized(messages) {
            messages.getOrNull(position)
        } ?: return
        val bindKey = messageBindKey(chatMessage, position)
        val result = ChatAdapterUtils.prepareChatMessage(
            chatMessage, renderSignature(), enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg,
            rewardChatMsg, replyMessage, null, useRandomColors, random, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints,
            namePaints, showStvBadges, showKickBadges, stvBadges, showPersonalEmotes, personalEmoteSets, stvUsers, enableOverlayEmotes, showSystemMessageEmotes,
            loggedInUser, chatUrl, getEmoteBytes, userColors, savedColors, localTwitchEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, savedLocalTwitchEmotes, savedLocalBadges,
            savedLocalCheerEmotes, savedLocalEmotes
        )
        holder.bind(bindKey, chatMessage, result.builder, position, result.backgroundRes)
        ChatAdapterUtils.loadImages(
            fragment, holder.textView, { updatedBuilder ->
                if (holder.isBoundTo(bindKey)) {
                    holder.bind(bindKey, chatMessage, updatedBuilder, position, result.backgroundRes)
                }
            }, result.images, result.imagePaint, result.userName, result.userNameStartIndex,
            backgroundColor, imageLibrary, result.builder, emoteSize, badgeSize, emoteQuality, animateGifs, enableOverlayEmotes
        )
    }

    fun createMessageClickedChatAdapter(selectedMessageOverride: ChatMessage? = selectedMessage): MessageClickedChatAdapter {
        return MessageClickedChatAdapter(
            messages, localTwitchEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, namePaints, stvBadges, personalEmoteSets,
            stvUsers, enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg, rewardChatMsg, replyMessage,
            { chatMessage -> selectedMessage = chatMessage; replyClickListener?.invoke() },
            { url, name, format, isAnimated, source, thirdParty, emoteId -> imageClickListener?.invoke(url, name, format, isAnimated, source, thirdParty, emoteId) },
            useRandomColors, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints, showStvBadges, showKickBadges, showPersonalEmotes,
            enableAlternatingLineShadows, alternatingLineShadowStrength, showSystemMessageEmotes, chatUrl, getEmoteBytes, fragment, dialogBackgroundColor, imageLibrary, messageTextSize, emoteSize, badgeSize,
            emoteQuality, animateGifs, enableOverlayEmotes, random, userColors,
            savedColors, savedLocalTwitchEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes, loggedInUser, selectedMessageOverride
        )
    }

    fun createReplyClickedChatAdapter(): ReplyClickedChatAdapter {
        return ReplyClickedChatAdapter(
            messages, localTwitchEmotes, thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, namePaints, stvBadges, personalEmoteSets,
            stvUsers, enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg, rewardChatMsg, replyMessage,
            { url, name, format, isAnimated, source, thirdParty, emoteId -> imageClickListener?.invoke(url, name, format, isAnimated, source, thirdParty, emoteId) },
            useRandomColors, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints, showStvBadges, showKickBadges, showPersonalEmotes,
            enableAlternatingLineShadows, alternatingLineShadowStrength, showSystemMessageEmotes, chatUrl, getEmoteBytes, fragment, dialogBackgroundColor, imageLibrary, messageTextSize, emoteSize, badgeSize,
            emoteQuality, animateGifs, enableOverlayEmotes, random, userColors,
            savedColors, savedLocalTwitchEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes, loggedInUser, selectedMessage
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

        fun isBoundTo(bindKey: String): Boolean = currentBindKey == bindKey

        fun bind(bindKey: String, chatMessage: ChatMessage, formattedMessage: SpannableStringBuilder, position: Int, backgroundRes: Int) {
            currentBindKey = bindKey
            val resolvedBackgroundColor = resolveMessageBackgroundColor(textView.context, position, backgroundRes)
            val dividerColors = resolveDividerColor(position, resolvedBackgroundColor)
            val previewKey = replyPreviewKey(chatMessage)
            val expanded = previewKey != null && previewKey in expandedReplyPreviewKeys
            textView.apply {
                text = formattedMessage
                textSize = messageTextSize
                alpha = if (chatMessage.isDeleted) 0.62f else 1f
                containerView.setBackgroundColor(resolvedBackgroundColor)
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
                    updateReplyExpandUi(showExpand = expanded, expanded = expanded)
                    doOnLayout {
                        val layout = layout ?: return@doOnLayout
                        if (expanded) {
                            updateReplyExpandUi(showExpand = true, expanded = true)
                            return@doOnLayout
                        }
                        val isTruncated = layout.lineCount > 3 || (0 until layout.lineCount).any { lineIndex ->
                            layout.getEllipsisCount(lineIndex) > 0
                        }
                        updateReplyExpandUi(showExpand = isTruncated, expanded = false)
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
