package com.github.andreyasadchy.xtra.ui.chat

import android.content.Context
import android.graphics.drawable.Animatable
import android.graphics.drawable.LayerDrawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ImageSpan
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.core.text.getSpans
import androidx.core.view.isVisible
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

class MessageClickedChatAdapter(
    private val sourceMessages: List<ChatMessage>,
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
    private val replyClick: (ChatMessage) -> Unit,
    private val imageClick: (String?, String?, String?, Boolean?, Int?, Boolean?, String?) -> Unit,
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
    private val imageLibrary: String?,
    private val messageTextSize: Float,
    private val emoteSize: Int,
    private val badgeSize: Int,
    private val emoteQuality: String,
    private val animateGifs: Boolean,
    private val enableOverlayEmotes: Boolean,
    private val random: Random,
    private val userColors: HashMap<String, Int>,
    private val savedColors: HashMap<String, Int>,
    private val savedLocalTwitchEmotes: MutableMap<String, ByteArray>,
    private val savedLocalBadges: MutableMap<String, ByteArray>,
    private val savedLocalCheerEmotes: MutableMap<String, ByteArray>,
    private val savedLocalEmotes: MutableMap<String, ByteArray>,
    private val loggedInUser: String?,
    var selectedMessage: ChatMessage?,
) : RecyclerView.Adapter<MessageClickedChatAdapter.ViewHolder>() {

    val userId = selectedMessage?.userId?.takeIf { it.isNotBlank() }
    val userLogin = selectedMessage?.userLogin?.takeIf { it.isNotBlank() }
    val userName = selectedMessage?.userName?.takeIf { it.isNotBlank() }

    private fun equalsIgnoreCase(left: String?, right: String?): Boolean {
        return !left.isNullOrBlank() && !right.isNullOrBlank() && left.equals(right, true)
    }

    fun matchesSelectedUser(message: ChatMessage): Boolean {
        if (message.isReply) return false
        return (!userId.isNullOrBlank() && message.userId == userId) ||
            (!userLogin.isNullOrBlank() && (
                equalsIgnoreCase(message.userLogin, userLogin) ||
                    equalsIgnoreCase(message.userName, userLogin)
                )) ||
            (!userName.isNullOrBlank() && (
                equalsIgnoreCase(message.userName, userName) ||
                    equalsIgnoreCase(message.userLogin, userName)
                ))
    }

    fun resolveSelectedStvBadge(): StvBadge? {
        if (!showStvBadges || userId.isNullOrBlank()) {
            return null
        }
        val badgeId = synchronized(stvUsers) {
            stvUsers.find { it.userId == userId }?.badgeId
        } ?: return null
        return synchronized(stvBadges) {
            stvBadges.find { it.id == badgeId }
        }
    }

    val messages = if (!userId.isNullOrBlank() || !userLogin.isNullOrBlank() || !userName.isNullOrBlank()) {
        synchronized(sourceMessages) {
            sourceMessages.filter(::matchesSelectedUser).toMutableList().ifEmpty { null }
        }
    } else {
        null
    } ?: selectedMessage?.let { mutableListOf(it) } ?: mutableListOf()
    var muted = false

    var messageClickListener: ((ChatMessage, ChatMessage?) -> Unit)? = null
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
        false,
        true
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

    private fun bindMessage(holder: ViewHolder, position: Int) {
        val chatMessage = synchronized(messages) {
            messages.getOrNull(position)
        } ?: return
        val result = ChatAdapterUtils.prepareChatMessage(
            chatMessage, renderSignature(), enableTimestamps, timestampFormat, firstMsgVisibility, firstChatMsg, redeemedChatMsg, redeemedNoMsg,
            rewardChatMsg, replyMessage, { url, name, format, isAnimated, source, thirdParty, emoteId -> imageClick(url, name, format, isAnimated, source, thirdParty, emoteId) },
            useRandomColors, random, useReadableColors, isLightTheme, nameDisplay, useBoldNames, showNamePaints, namePaints, showStvBadges,
            showKickBadges, stvBadges, showPersonalEmotes, personalEmoteSets, stvUsers, enableOverlayEmotes, showSystemMessageEmotes, loggedInUser, chatUrl,
            getEmoteBytes, userColors, savedColors, localTwitchEmotes,
            thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, savedLocalTwitchEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes
        )
        holder.bind(chatMessage, result.builder, position, result.backgroundRes)
        if (chatMessage == selectedMessage) {
            holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
        }
        ChatAdapterUtils.loadImages(
            fragment, holder.textView, {
                holder.bind(chatMessage, it, position, result.backgroundRes)
                if (chatMessage == selectedMessage) {
                    holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
                }
            }, result.images, result.imagePaint, result.userName, result.userNameStartIndex,
            backgroundColor, imageLibrary, result.builder, emoteSize, badgeSize, emoteQuality, animateGifs, enableOverlayEmotes
        )
        if (chatMessage == selectedMessage) {
            holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
        }
    }

    fun updateBackground(chatMessage: ChatMessage, item: TextView) {
        val backgroundRes = getBackgroundRes(chatMessage, item)
        val position = synchronized(messages) { messages.indexOf(chatMessage) }.coerceAtLeast(0)
        val resolvedBackgroundColor = resolveMessageBackgroundColor(item.context, position, backgroundRes)
        item.setBackgroundColor(resolvedBackgroundColor)
        (item.parent as? ViewGroup)?.findViewById<View>(R.id.chatLineDivider)?.apply {
            val dividerColors = resolveDividerColor(position, resolvedBackgroundColor)
            isVisible = dividerColors != null
            dividerColors?.let {
                findViewById<View>(R.id.chatLineDividerHighlight).setBackgroundColor(it.highlightColor)
                findViewById<View>(R.id.chatLineDividerShadow).setBackgroundColor(it.shadowColor)
            }
        }
        (item.text as? Spannable)?.let { view ->
            view.getSpans<NamePaintImageSpan>().forEach {
                it.backgroundColor = resolvedBackgroundColor
                view.setSpan(it, view.getSpanStart(it), view.getSpanEnd(it), SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }

    override fun getItemCount(): Int = synchronized(messages) {
        messages.size
    }

    fun applyMutedState(muted: Boolean) {
        if (this.muted == muted) return
        this.muted = muted
        synchronized(messages) {
            messages.clear()
            if (!muted) {
                val rebuilt = if (!userId.isNullOrBlank() || !userLogin.isNullOrBlank() || !userName.isNullOrBlank()) {
                    synchronized(sourceMessages) {
                        sourceMessages.filter(::matchesSelectedUser).toMutableList()
                    }
                } else {
                    selectedMessage?.let { mutableListOf(it) } ?: mutableListOf()
                }
                messages.addAll(rebuilt)
            }
        }
        notifyDataSetChanged()
    }

    private fun getBackgroundRes(chatMessage: ChatMessage, item: TextView): Int {
        if (chatMessage.message.isNullOrBlank()) {
            return 0
        }
        return when {
            chatMessage.isFirst && firstMsgVisibility < 2 -> R.color.chatMessageFirst
            chatMessage.reward?.id != null && firstMsgVisibility < 2 -> R.color.chatMessageReward
            chatMessage.systemMsg != null || (chatMessage.msgId != null && chatMessage.msgId != "kick_moderation") -> R.color.chatMessageNotice
            ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, loggedInUser, item.text) -> R.color.chatMessageMention
            else -> 0
        }
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

    private fun resolveSelectedBackgroundColor(context: Context): Int {
        return ChatBackgroundUtils.resolveMessageBackgroundColor(
            surfaceColor = backgroundColor,
            overlayColor = ContextCompat.getColor(context, R.color.chatMessageSelected),
            alternatingLineShadowEnabled = false,
            alternatingLineShadowStrength = 0,
            position = 0,
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
                ((recyclerView.getChildAt(i) as TextView).text as? Spannable)?.let { view ->
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

        private val dividerView: View = itemView.findViewById(R.id.chatLineDivider)
        private val dividerHighlightView: View = itemView.findViewById(R.id.chatLineDividerHighlight)
        private val dividerShadowView: View = itemView.findViewById(R.id.chatLineDividerShadow)
        val textView: TextView = itemView.findViewById(R.id.chatMessageText)

        fun bind(chatMessage: ChatMessage, formattedMessage: SpannableStringBuilder, position: Int, backgroundRes: Int) {
            val resolvedBackgroundColor = resolveMessageBackgroundColor(textView.context, position, backgroundRes)
            val dividerColors = resolveDividerColor(position, resolvedBackgroundColor)
            textView.apply {
                text = formattedMessage
                textSize = messageTextSize
                alpha = if (chatMessage.isDeleted) 0.62f else 1f
                setBackgroundColor(resolvedBackgroundColor)
                if (chatMessage.isReply) {
                    movementMethod = null
                    maxLines = 2
                    ellipsize = TextUtils.TruncateAt.END
                    TooltipCompat.setTooltipText(this, chatMessage.replyParent?.message ?: chatMessage.replyParent?.systemMsg)
                    setOnClickListener {
                        chatMessage.replyParent?.takeIf(ChatAdapterUtils::hasUserIdentity)?.let { replyClick(it) }
                    }
                } else {
                    movementMethod = LinkMovementMethod.getInstance()
                    maxLines = Int.MAX_VALUE
                    ellipsize = null
                    TooltipCompat.setTooltipText(this, chatMessage.message ?: chatMessage.systemMsg)
                    setOnClickListener {
                        if (selectionStart == -1 && selectionEnd == -1 && chatMessage != selectedMessage && ChatAdapterUtils.hasUserIdentity(chatMessage)) {
                            messageClickListener?.invoke(chatMessage, selectedMessage)
                            selectedMessage = chatMessage
                            setBackgroundColor(resolveSelectedBackgroundColor(context))
                            (text as? Spannable)?.let { view ->
                                view.getSpans<NamePaintImageSpan>().forEach {
                                    it.backgroundColor = resolveSelectedBackgroundColor(context)
                                    view.setSpan(it, view.getSpanStart(it), view.getSpanEnd(it), SPAN_EXCLUSIVE_EXCLUSIVE)
                                }
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
        }
    }
}
