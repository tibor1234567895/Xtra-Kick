package com.xtrakick.app.ui.chat

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.TooltipCompat
import androidx.core.text.getSpans
import androidx.core.view.isVisible
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

class ReplyClickedChatAdapter(
    messages: List<ChatMessage>,
    private val localChatEmotes: List<ChatEmote>,
    private val thirdPartyEmotes: List<Emote>,
    private val globalBadges: List<ChatBadge>,
    private val channelBadges: List<ChatBadge>,
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
    private val savedLocalChatEmotes: MutableMap<String, ByteArray>,
    private val savedLocalBadges: MutableMap<String, ByteArray>,
    private val savedLocalCheerEmotes: MutableMap<String, ByteArray>,
    private val savedLocalEmotes: MutableMap<String, ByteArray>,
    private val loggedInUser: String?,
    var selectedMessage: ChatMessage?,
) : RecyclerView.Adapter<ReplyClickedChatAdapter.ViewHolder>() {

    val threadParentId = selectedMessage?.reply?.threadParentId ?: selectedMessage?.id
    val messages = synchronized(messages) {
        messages.filter {
            (it.reply?.threadParentId == threadParentId || it.id == threadParentId) && !it.isReply
        }.toMutableList()
    }.ifEmpty {
        selectedMessage?.let { mutableListOf(it) } ?: mutableListOf()
    }

    var messageClickListener: ((ChatMessage, ChatMessage?) -> Unit)? = null
    private var renderGeneration = 0L
    private val renderConfigSignature: Long = run {
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
        result
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
            getEmoteBytes, userColors, savedColors, localChatEmotes,
            thirdPartyEmotes, globalBadges, channelBadges, cheerEmotes, savedLocalChatEmotes, savedLocalBadges, savedLocalCheerEmotes, savedLocalEmotes, holder.textView.context
        )
        holder.bind(chatMessage, result.builder, position, result.backgroundRes)
        if (chatMessage == selectedMessage) {
            holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
        }
        if (result.images.isNotEmpty() || result.imagePaint != null) {
            ChatAdapterUtils.loadImages(
                fragment, holder.textView, {
                    holder.bind(chatMessage, it, position, result.backgroundRes)
                    if (chatMessage == selectedMessage) {
                        holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
                    }
                }, result.images, result.imagePaint, result.userName, result.userNameStartIndex,
                backgroundColor, imageLibrary, result.builder, emoteSize, badgeSize, emoteQuality, animateGifs, enableOverlayEmotes
            )
        }
        if (chatMessage == selectedMessage) {
            holder.textView.setBackgroundColor(resolveSelectedBackgroundColor(holder.textView.context))
        }
    }

    fun updateBackground(chatMessage: ChatMessage, item: TextView) {
        val backgroundRes = getBackgroundRes(chatMessage, item)
        ChatListParityUtils.updateMessageRowBackground(
            messages = messages,
            chatMessage = chatMessage,
            item = item,
            backgroundRes = backgroundRes,
            resolveBackgroundColor = ::resolveMessageBackgroundColor,
            resolveDividerColors = ::resolveDividerColor,
        )
    }

    override fun getItemCount(): Int = synchronized(messages) {
        messages.size
    }

    private fun getBackgroundRes(chatMessage: ChatMessage, item: TextView): Int =
        ChatListParityUtils.resolveMessageBackgroundRes(chatMessage, firstMsgVisibility, loggedInUser, item.text)

    private fun resolveMessageBackgroundColor(context: Context, position: Int, backgroundRes: Int): Int =
        ChatListParityUtils.resolveMessageBackgroundColor(
            messages = messages,
            context = context,
            position = position,
            surfaceColor = backgroundColor,
            backgroundRes = backgroundRes,
            enableAlternatingLineShadows = enableAlternatingLineShadows,
            alternatingLineShadowStrength = alternatingLineShadowStrength,
        )

    private fun resolveCurrentMessagePosition(chatMessage: ChatMessage, adapterPosition: Int, fallbackPosition: Int): Int =
        ChatListParityUtils.resolveCurrentMessagePosition(messages, chatMessage, adapterPosition, fallbackPosition)

    private fun resolveSelectedBackgroundColor(context: Context): Int =
        ChatListParityUtils.resolveSelectedBackgroundColor(context, backgroundColor)

    private fun resolveDividerColor(position: Int, backgroundColor: Int): ChatBackgroundUtils.DividerColors? =
        ChatListParityUtils.resolveDividerColor(
            messages = messages,
            position = position,
            surfaceColor = backgroundColor,
            enableAlternatingLineShadows = enableAlternatingLineShadows,
            alternatingLineShadowStrength = alternatingLineShadowStrength,
        )

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (animateGifs) {
            ChatAdapterUtils.startSpanAnimations(holder.textView.text)
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        if (animateGifs) {
            ChatAdapterUtils.stopSpanAnimations(holder.textView.text)
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        if (animateGifs) {
            for (i in 0 until recyclerView.childCount) {
                val text = recyclerView.getChildAt(i).findViewById<TextView>(R.id.chatMessageText)?.text
                ChatAdapterUtils.stopSpanAnimations(text)
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
            val currentPosition = resolveCurrentMessagePosition(chatMessage, bindingAdapterPosition, position)
            val resolvedBackgroundColor = resolveMessageBackgroundColor(textView.context, currentPosition, backgroundRes)
            val dividerColors = resolveDividerColor(currentPosition, resolvedBackgroundColor)
            textView.apply {
                text = formattedMessage
                textSize = messageTextSize
                alpha = if (chatMessage.isDeleted) 0.62f else 1f
                setBackgroundColor(resolvedBackgroundColor)
                setLineSpacing(0f, 1.12f)
                movementMethod = LinkMovementMethod.getInstance()
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
            dividerView.isVisible = dividerColors != null
            dividerColors?.let {
                dividerHighlightView.setBackgroundColor(it.highlightColor)
                dividerShadowView.setBackgroundColor(it.shadowColor)
            }
        }
    }
}
