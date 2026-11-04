package com.xtrakick.app.util.chat

import android.content.Context
import androidx.core.content.ContextCompat
import com.xtrakick.app.R
import android.text.Spannable
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.getSpans
import androidx.core.view.isVisible
import com.xtrakick.app.ui.view.NamePaintImageSpan
import com.xtrakick.app.model.chat.ChatMessage

object ChatListParityUtils {

    // rebindRangeAfterPrepend / rebindRangeAfterHeadRemoval used to live here and both
    // unconditionally returned null: with stable ChatMessage.visualParitySlot values, neither
    // a prepend nor a head removal invalidates existing row colors, so no adapter rebind is
    // ever required. Their call sites took a main-thread lock on chatMessages purely to
    // compute arguments for a result that was always discarded.

    fun appendPositionAfterHeadRemoval(lastIndexAfterAppend: Int, removedCount: Int): Int {
        return if (removedCount > 0) {
            lastIndexAfterAppend.coerceAtLeast(0)
        } else {
            lastIndexAfterAppend
        }
    }

    fun resolveVisualParityPosition(messages: List<ChatMessage>, position: Int): Int {
        if (position < 0 || messages.isEmpty()) {
            return 0
        }
        val cappedPosition = position.coerceAtMost(messages.lastIndex)
        // Slots are stable once assigned, so a row that already has one needs no sweep: the
        // answer is that slot whatever the rest of the list looks like. This runs on every bind
        // of every row, and [ensureVisualParitySlots] costs a full pass over the message list
        // (600 by default) even when it has nothing to do. Rows that genuinely lack a slot still
        // fall through and trigger the sweep, which fixes them and their neighbours as before.
        messages[cappedPosition].visualParitySlot?.let { return it }
        ensureVisualParitySlots(messages)
        return messages[cappedPosition].visualParitySlot ?: 0
    }

    /**
     * Assigns [ChatMessage.visualParitySlot] for a message just appended to the end of
     * [messages], in constant time.
     *
     * In the steady state of a live chat the only row missing a slot is the one that just
     * arrived, so doing this at append time keeps the O(size) sweep in
     * [ensureVisualParitySlots] off the bind path entirely. Bails out and leaves the work to
     * that sweep if the preceding message has no slot yet.
     */
    fun assignSlotForAppendedMessage(messages: List<ChatMessage>) {
        val lastIndex = messages.lastIndex
        if (lastIndex < 0) {
            return
        }
        val message = messages[lastIndex]
        if (message.visualParitySlot != null) {
            return
        }
        if (lastIndex == 0) {
            message.visualParitySlot = 0
            return
        }
        val previousSlot = messages[lastIndex - 1].visualParitySlot ?: return
        message.visualParitySlot = nextSlot(messages, lastIndex, previousSlot)
    }

    fun shouldDrawDividerAbove(messages: List<ChatMessage>, position: Int): Boolean {
        return position > 0 && !sharesVisualBlockWithPrevious(messages, position)
    }

    /**
     * Assigns [ChatMessage.visualParitySlot] for any messages that do not have one yet.
     * Existing slots are never rewritten, so head trims leave visible row colors stable.
     */
    fun ensureVisualParitySlots(messages: List<ChatMessage>) {
        if (messages.isEmpty()) {
            return
        }
        if (messages.all { it.visualParitySlot != null }) {
            return
        }

        val firstAssigned = messages.indexOfFirst { it.visualParitySlot != null }
        if (firstAssigned < 0) {
            assignForwardFrom(messages, startIndex = 0, startSlot = 0)
            return
        }

        if (firstAssigned > 0) {
            assignBackwardBefore(messages, firstAssigned)
        }

        var index = 0
        while (index < messages.size) {
            if (messages[index].visualParitySlot != null) {
                index++
                continue
            }
            val previousSlot = messages.getOrNull(index - 1)?.visualParitySlot
            if (previousSlot != null) {
                assignForwardFrom(
                    messages,
                    startIndex = index,
                    startSlot = nextSlot(messages, index, previousSlot),
                )
            } else {
                val nextAssigned = (index until messages.size).firstOrNull { messages[it].visualParitySlot != null }
                if (nextAssigned != null) {
                    assignBackwardBefore(messages, nextAssigned)
                } else {
                    assignForwardFrom(messages, startIndex = index, startSlot = 0)
                }
            }
            index++
        }
    }

    private fun assignForwardFrom(messages: List<ChatMessage>, startIndex: Int, startSlot: Int) {
        var slot = startSlot
        for (index in startIndex until messages.size) {
            val message = messages[index]
            if (message.visualParitySlot != null) {
                slot = (message.visualParitySlot ?: slot) + 1
                continue
            }
            if (index > 0 && sharesVisualBlockWithPrevious(messages, index)) {
                message.visualParitySlot = messages[index - 1].visualParitySlot ?: slot
            } else {
                message.visualParitySlot = slot
            }
            slot = (message.visualParitySlot ?: slot) + 1
        }
    }

    private fun assignBackwardBefore(messages: List<ChatMessage>, firstAssignedIndex: Int) {
        for (index in firstAssignedIndex downTo 1) {
            val previous = messages[index - 1]
            if (previous.visualParitySlot != null) {
                continue
            }
            val currentSlot = messages[index].visualParitySlot ?: continue
            previous.visualParitySlot = if (sharesVisualBlockWithPrevious(messages, index)) {
                currentSlot
            } else {
                currentSlot - 1
            }
        }
    }

    private fun nextSlot(messages: List<ChatMessage>, index: Int, previousSlot: Int): Int {
        return if (sharesVisualBlockWithPrevious(messages, index)) {
            previousSlot
        } else {
            previousSlot + 1
        }
    }

    internal fun sharesVisualBlockWithPrevious(messages: List<ChatMessage>, position: Int): Boolean {
        if (position <= 0 || position > messages.lastIndex) {
            return false
        }
        val previous = messages[position - 1]
        val current = messages[position]
        return previous.isReply &&
            !current.isReply &&
            belongsToReplyPreview(previous, current)
    }

    private fun belongsToReplyPreview(replyPreview: ChatMessage, replyMessage: ChatMessage): Boolean {
        val previewThreadParentId = replyPreview.reply?.threadParentId?.takeIf { it.isNotBlank() } ?: return false
        val messageThreadParentId = replyMessage.reply?.threadParentId?.takeIf { it.isNotBlank() } ?: return false
        if (previewThreadParentId != messageThreadParentId) {
            return false
        }
        return when {
            replyPreview.timestamp != null && replyMessage.timestamp != null -> replyPreview.timestamp == replyMessage.timestamp
            !replyPreview.fullMsg.isNullOrBlank() && !replyMessage.fullMsg.isNullOrBlank() -> replyPreview.fullMsg == replyMessage.fullMsg
            else -> true
        }
    }

    fun resolveCurrentMessagePosition(
        messages: List<ChatMessage>,
        chatMessage: ChatMessage,
        adapterPosition: Int,
        fallbackPosition: Int,
    ): Int {
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

    fun resolveMessageBackgroundColor(
        messages: List<ChatMessage>,
        context: Context,
        position: Int,
        surfaceColor: Int,
        backgroundRes: Int,
        enableAlternatingLineShadows: Boolean,
        alternatingLineShadowStrength: Int,
    ): Int {
        val overlayColor = backgroundRes.takeIf { it != 0 }?.let { ContextCompat.getColor(context, it) }
        val visualParityPosition = synchronized(messages) {
            resolveVisualParityPosition(messages, position)
        }
        return ChatBackgroundUtils.resolveMessageBackgroundColor(
            surfaceColor = surfaceColor,
            overlayColor = overlayColor,
            alternatingLineShadowEnabled = enableAlternatingLineShadows,
            alternatingLineShadowStrength = alternatingLineShadowStrength,
            position = visualParityPosition,
        )
    }

    fun resolveDividerColor(
        messages: List<ChatMessage>,
        position: Int,
        surfaceColor: Int,
        enableAlternatingLineShadows: Boolean,
        alternatingLineShadowStrength: Int,
    ): ChatBackgroundUtils.DividerColors? {
        val shouldDrawDivider = synchronized(messages) {
            shouldDrawDividerAbove(messages, position)
        }
        if (!enableAlternatingLineShadows || !shouldDrawDivider) {
            return null
        }
        return ChatBackgroundUtils.resolveDividerColors(
            surfaceColor = surfaceColor,
            dividerStrength = alternatingLineShadowStrength,
        )
    }

    fun resolveSelectedBackgroundColor(
        context: Context,
        surfaceColor: Int,
    ): Int {
        return ChatBackgroundUtils.resolveMessageBackgroundColor(
            surfaceColor = surfaceColor,
            overlayColor = ContextCompat.getColor(context, R.color.chatMessageSelected),
            alternatingLineShadowEnabled = false,
            alternatingLineShadowStrength = 0,
            position = 0,
        )
    }

    fun resolveMessageBackgroundRes(
        chatMessage: ChatMessage,
        firstMsgVisibility: Int,
        loggedInUser: String?,
        messageText: CharSequence?,
    ): Int {
        if (chatMessage.message.isNullOrBlank()) {
            return 0
        }
        return when {
            chatMessage.isFirst && firstMsgVisibility < 2 -> R.color.chatMessageFirst
            chatMessage.reward?.id != null && firstMsgVisibility < 2 -> R.color.chatMessageReward
            chatMessage.systemMsg != null || (chatMessage.msgId != null && chatMessage.msgId != "kick_moderation") -> R.color.chatMessageNotice
            ChatAdapterUtils.isMessageHighlightedForLoggedInUser(chatMessage, loggedInUser, messageText) -> R.color.chatMessageMention
            else -> 0
        }
    }

    fun updateMessageRowBackground(
        messages: List<ChatMessage>,
        chatMessage: ChatMessage,
        item: TextView,
        backgroundRes: Int,
        resolveBackgroundColor: (Context, Int, Int) -> Int,
        resolveDividerColors: (Int, Int) -> ChatBackgroundUtils.DividerColors?,
    ) {
        val position = synchronized(messages) { messages.indexOf(chatMessage) }.coerceAtLeast(0)
        val resolvedBackgroundColor = resolveBackgroundColor(item.context, position, backgroundRes)
        item.setBackgroundColor(resolvedBackgroundColor)
        (item.parent as? ViewGroup)?.findViewById<View>(R.id.chatLineDivider)?.apply {
            val dividerColors = resolveDividerColors(position, resolvedBackgroundColor)
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
}
