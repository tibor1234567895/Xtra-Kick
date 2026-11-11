package com.xtrakick.app.ui.chat

import android.graphics.Color
import android.text.Selection
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.util.Linkify
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.core.text.util.LinkifyCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentChatBinding
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.PinnedGift
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.chat.ChatAdapterUtils
import com.xtrakick.app.util.prefs
import java.text.NumberFormat
import java.util.Random

class ChatPinnedGiftUiHelper(
    private val fragment: Fragment,
    private val viewModel: ChatViewModel,
    private val getBinding: () -> FragmentChatBinding?,
    private val getChatUrl: () -> String?,
    private val onHeaderBadgesLayoutNeeded: () -> Unit,
    private val onOpenPinnedHistory: (ChatMessage) -> Unit,
) {

    private data class PinnedGiftUiState(
        val contentKey: String? = null,
        val titleExpandable: Boolean = false,
    )

    private var pinnedGiftUiState = PinnedGiftUiState()
    private var cachedPinnedGiftMessageKey: String? = null
    private var cachedPinnedGiftMessageResult: ChatAdapterUtils.MessageResult? = null

    private val context get() = fragment.requireContext()
    private val resources get() = fragment.resources

    fun resetPinnedGiftUiState() {
        attachedTitleView?.removeOnLayoutChangeListener(titleLayoutChangeListener)
        attachedTitleView = null
        getBinding()?.let { b ->
            b.pinnedGiftTitle.scrollTo(0, 0)
            b.pinnedGiftText.scrollTo(0, 0)
            ChatAdapterUtils.clearImageBinding(b.pinnedGiftTitle)
        }
        pinnedGiftUiState = PinnedGiftUiState()
        cachedPinnedGiftMessageKey = null
        cachedPinnedGiftMessageResult = null
    }

    private fun formatDisplayName(userLogin: String?, userName: String?): String {
        return if (userLogin != null && userName != null && !userLogin.equals(userName, true)) {
            when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                "0" -> "$userName($userLogin)"
                "1" -> userName
                else -> userLogin
            }
        } else {
            userName ?: userLogin ?: ""
        }
    }

    private fun resolvePinnedNameColor(color: String?, fallback: Int): Int {
        if (color.isNullOrBlank()) return fallback
        return runCatching {
            val normalized = if (color.startsWith("#")) color else "#$color"
            Color.parseColor(normalized)
        }.getOrDefault(fallback)
    }

    private fun openPinnedHistory(id: String?, login: String?, name: String?, color: String?) {
        if (id.isNullOrBlank() && login.isNullOrBlank() && name.isNullOrBlank()) return
        onOpenPinnedHistory(
            ChatMessage(
                userId = id,
                userLogin = login,
                userName = name,
                color = color,
            )
        )
    }

    private fun buildPinnedNameSpan(
        label: String,
        displayName: String,
        color: Int,
        userId: String?,
        userLogin: String?,
        userName: String?,
        userColor: String?,
    ): SpannableStringBuilder {
        return SpannableStringBuilder().apply {
            append(label.trimEnd())
            append(' ')
            val start = length
            append(displayName)
            setSpan(ForegroundColorSpan(color), start, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    openPinnedHistory(userId, userLogin, userName, userColor)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = color
                    ds.isUnderlineText = false
                }
            }, start, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    private fun buildPinnedMessageResult(pinnedGift: PinnedGift): ChatAdapterUtils.MessageResult {
        val (message, pinnedEmotes) = normalizePinnedGiftMessage(pinnedGift.message)
        val thirdPartyEmotes = buildList {
            synchronized(viewModel.thirdPartyEmotes) {
                addAll(viewModel.thirdPartyEmotes)
            }
            addAll(pinnedEmotes)
        }.distinctBy { it.name }
        val result = if (message != null) {
            ChatAdapterUtils.prepareChatMessage(
                ChatMessage(
                    id = pinnedGift.id,
                    userId = pinnedGift.userId,
                    message = message,
                ),
                buildPinnedGiftContentKey(pinnedGift).hashCode().toLong(),
                enableTimestamps = false,
                timestampFormat = null,
                firstMsgVisibility = 2,
                firstChatMsg = "",
                redeemedChatMsg = "",
                redeemedNoMsg = "",
                rewardChatMsg = "",
                replyMessage = "",
                imageClick = null,
                useRandomColors = false,
                random = Random(),
                useReadableColors = false,
                isLightTheme = false,
                nameDisplay = null,
                useBoldNames = false,
                showNamePaints = false,
                namePaints = emptyList(),
                showStvBadges = false,
                showKickBadges = false,
                stvBadges = emptyList(),
                showPersonalEmotes = true,
                personalEmoteSets = viewModel.personalEmoteSets,
                stvUsers = viewModel.stvUsers,
                enableOverlayEmotes = context.prefs().getBoolean(AppConstants.CHAT_ZEROWIDTH, true),
                showSystemMessageEmotes = false,
                loggedInUser = null,
                chatUrl = getChatUrl(),
                getEmoteBytes = viewModel::getEmoteBytes,
                userColors = hashMapOf(),
                savedColors = hashMapOf(),
                localChatEmotes = viewModel.localChatEmotes,
                thirdPartyEmotes = thirdPartyEmotes,
                globalBadges = viewModel.globalBadges,
                channelBadges = viewModel.channelBadges,
                cheerEmotes = viewModel.cheerEmotes,
                savedLocalChatEmotes = mutableMapOf(),
                savedLocalBadges = mutableMapOf(),
                savedLocalCheerEmotes = mutableMapOf(),
                savedLocalEmotes = mutableMapOf(),
            )
        } else {
            ChatAdapterUtils.MessageResult(SpannableStringBuilder(), arrayListOf(), null, null, null, 0)
        }
        pinnedGift.giftValue?.let { giftValue ->
            if (result.builder.isNotEmpty()) result.builder.append(" • ")
            result.builder.append(context.getString(R.string.pinned_gift_value))
            result.builder.append(": ")
            result.builder.append(NumberFormat.getInstance().format(giftValue))
        }
        if (result.builder.isEmpty()) {
            result.builder.append(context.getString(R.string.pinned_gift_message_fallback))
        }
        LinkifyCompat.addLinks(result.builder, Linkify.WEB_URLS)
        return result
    }

    private fun normalizePinnedGiftMessage(message: String?): Pair<String?, List<Emote>> {
        if (message.isNullOrBlank()) {
            return null to emptyList()
        }
        val builder = StringBuilder(message.length)
        val emotes = mutableListOf<Emote>()
        var consumedIndex = 0
        pinnedInlineEmoteRegex.findAll(message).forEach { match ->
            appendPinnedGiftSegment(builder, message.substring(consumedIndex, match.range.first))
            val emoteId = match.groupValues.getOrNull(1)?.trim()
            val emoteName = match.groupValues.getOrNull(2)?.trim()
            if (!emoteId.isNullOrBlank() && !emoteName.isNullOrBlank()) {
                if (builder.isNotEmpty() && builder.last().isPinnedGiftWordChar() && emoteName.firstOrNull()?.isPinnedGiftWordChar() == true) {
                    builder.append(' ')
                }
                builder.append(emoteName)
                emotes.add(
                    Emote(
                        name = emoteName,
                        url1x = "https://files.kick.com/emotes/$emoteId/fullsize",
                        url2x = "https://files.kick.com/emotes/$emoteId/fullsize",
                        url3x = "https://files.kick.com/emotes/$emoteId/fullsize",
                        url4x = "https://files.kick.com/emotes/$emoteId/fullsize",
                        format = "gif",
                        isAnimated = true,
                        source = Emote.GLOBAL_STV,
                    )
                )
            }
            consumedIndex = match.range.last + 1
        }
        appendPinnedGiftSegment(builder, message.substring(consumedIndex))
        return builder.toString().trim().takeIf { it.isNotBlank() } to emotes
    }

    private fun appendPinnedGiftSegment(builder: StringBuilder, segment: String) {
        if (segment.isBlank()) return
        if (builder.isNotEmpty() && builder.last().isPinnedGiftWordChar() && segment.first().isPinnedGiftWordChar()) {
            builder.append(' ')
        }
        builder.append(segment)
    }

    private fun Char.isPinnedGiftWordChar(): Boolean {
        return isLetterOrDigit() || this == '_' || this == '-'
    }

    private fun buildPinnedMetadataText(pinnedGift: PinnedGift, binding: FragmentChatBinding): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        val baseTextColor = binding.pinnedGiftText.currentTextColor
        val senderColor = resolvePinnedNameColor(pinnedGift.userColor, baseTextColor)
        val senderName = formatDisplayName(pinnedGift.userLogin, pinnedGift.userName)
        val pinnedByColor = resolvePinnedNameColor(pinnedGift.pinnedByUserColor, baseTextColor)
        val pinnedBy = formatDisplayName(pinnedGift.pinnedByUserLogin, pinnedGift.pinnedByUserName)
        if (senderName.isNotBlank()) {
            builder.append(
                buildPinnedNameSpan(
                    label = context.getString(R.string.pinned_gift_title_prefix),
                    displayName = senderName,
                    color = senderColor,
                    userId = pinnedGift.userId,
                    userLogin = pinnedGift.userLogin,
                    userName = pinnedGift.userName,
                    userColor = pinnedGift.userColor,
                )
            )
        }
        if (pinnedBy.isNotBlank()) {
            if (builder.isNotEmpty()) builder.append(" • ")
            builder.append(
                buildPinnedNameSpan(
                    label = context.getString(R.string.pinned_gift_pinned_by_prefix),
                    displayName = pinnedBy,
                    color = pinnedByColor,
                    userId = pinnedGift.pinnedByUserId,
                    userLogin = pinnedGift.pinnedByUserLogin,
                    userName = pinnedGift.pinnedByUserName,
                    userColor = pinnedGift.pinnedByUserColor,
                )
            )
            pinnedGift.pinnedSeconds?.takeIf { it > 0 }?.let {
                builder.append(" ")
                builder.append(context.getString(R.string.pinned_gift_pinned_by_suffix_with_seconds, it).trimStart())
            }
        }
        if (builder.isEmpty()) {
            builder.append(context.getString(R.string.pinned_gift_unknown_user))
        }
        return builder
    }

    private fun buildPinnedGiftContentKey(pinnedGift: PinnedGift): String {
        return listOf(
            pinnedGift.id,
            pinnedGift.message,
            pinnedGift.giftValue?.toString(),
            pinnedGift.userId,
            pinnedGift.userLogin
        ).joinToString("|")
    }

    private fun getPinnedGiftMessageResult(pinnedGift: PinnedGift): ChatAdapterUtils.MessageResult {
        val key = listOf(
            buildPinnedGiftContentKey(pinnedGift),
            viewModel.thirdPartyEmotes.size,
            viewModel.personalEmoteSets.size,
            viewModel.stvUsers.size,
            getChatUrl(),
        ).joinToString("|")
        if (cachedPinnedGiftMessageKey == key) {
            cachedPinnedGiftMessageResult?.let { return it.copyForBind() }
        }
        val result = buildPinnedMessageResult(pinnedGift)
        cachedPinnedGiftMessageKey = key
        cachedPinnedGiftMessageResult = result
        return result.copyForBind()
    }

    private fun syncPinnedGiftUiState(pinnedGift: PinnedGift) {
        val contentKey = buildPinnedGiftContentKey(pinnedGift)
        if (pinnedGiftUiState.contentKey != contentKey) {
            pinnedGiftUiState = PinnedGiftUiState(contentKey = contentKey)
        }
    }

    private var attachedTitleView: TextView? = null

    private val titleLayoutChangeListener = View.OnLayoutChangeListener { _, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
        val widthChanged = (right - left) != (oldRight - oldLeft)
        val heightChanged = (bottom - top) != (oldBottom - oldTop)
        if (widthChanged || heightChanged) {
            recheckExpandability()
        }
    }

    fun onConfigurationChanged() {
        val binding = getBinding() ?: return
        binding.pinnedGiftTitle.scrollTo(0, 0)
        binding.pinnedGiftText.scrollTo(0, 0)
        binding.pinnedGiftTitle.post {
            recheckExpandability()
        }
    }

    private fun recheckExpandability() {
        val binding = getBinding() ?: return
        val expanded = viewModel.pinnedGiftExpanded.value
        if (!expanded) {
            val isExpandable = isTextViewTruncated(binding.pinnedGiftTitle) || isTextViewTruncated(binding.pinnedGiftText)
            applyPinnedGiftExpandability(isExpandable = isExpandable, expanded = false)
        }
    }

    private fun applyPinnedGiftExpandability(isExpandable: Boolean, expanded: Boolean) {
        if (pinnedGiftUiState.titleExpandable != isExpandable) {
            pinnedGiftUiState = pinnedGiftUiState.copy(titleExpandable = isExpandable)
        }
        val showExpand = if (expanded) true else isExpandable
        updatePinnedGiftExpandUi(showExpand = showExpand, expanded = expanded)
    }

    fun renderPinnedGift() {
        val binding = getBinding() ?: return
        ChatAdapterUtils.beginImageBinding(binding.pinnedGiftTitle)
        val pinnedGift = viewModel.pinnedGift.value
        val dismissed = viewModel.pinnedGiftDismissed.value
        binding.pinnedGiftRestore.isVisible = pinnedGift != null && dismissed
        onHeaderBadgesLayoutNeeded()
        if (pinnedGift == null) {
            resetPinnedGiftUiState()
            binding.pinnedGiftLayout.isGone = true
            return
        }
        if (dismissed) {
            binding.pinnedGiftLayout.isGone = true
            return
        }
        syncPinnedGiftUiState(pinnedGift)
        val expanded = viewModel.pinnedGiftExpanded.value
        val pinnedGiftMessageResult = getPinnedGiftMessageResult(pinnedGift)
        binding.pinnedGiftLayout.isVisible = true
        binding.pinnedGiftTitle.scrollTo(0, 0)
        binding.pinnedGiftText.scrollTo(0, 0)
        binding.pinnedGiftTitle.text = pinnedGiftMessageResult.builder
        binding.pinnedGiftText.text = buildPinnedMetadataText(pinnedGift, binding)
        binding.pinnedGiftTitle.maxLines = if (expanded) Int.MAX_VALUE else PINNED_GIFT_COLLAPSED_MAX_LINES
        binding.pinnedGiftTitle.ellipsize = if (expanded) null else TextUtils.TruncateAt.END
        binding.pinnedGiftText.maxLines = if (expanded) Int.MAX_VALUE else 1
        binding.pinnedGiftText.ellipsize = if (expanded) null else TextUtils.TruncateAt.END
        updatePinnedGiftExpandUi(showExpand = if (expanded) true else pinnedGiftUiState.titleExpandable, expanded = expanded)

        if (attachedTitleView !== binding.pinnedGiftTitle) {
            attachedTitleView?.removeOnLayoutChangeListener(titleLayoutChangeListener)
            binding.pinnedGiftTitle.addOnLayoutChangeListener(titleLayoutChangeListener)
            attachedTitleView = binding.pinnedGiftTitle
        }

        binding.pinnedGiftTitle.post {
            recheckExpandability()
        }

        if (pinnedGiftMessageResult.images.isNotEmpty() || pinnedGiftMessageResult.imagePaint != null) {
            ChatAdapterUtils.loadImages(
                fragment,
                binding.pinnedGiftTitle,
                { updatedBuilder ->
                    binding.pinnedGiftTitle.text = updatedBuilder
                    if (!expanded) {
                        binding.pinnedGiftTitle.post {
                            recheckExpandability()
                        }
                    }
                },
                pinnedGiftMessageResult.images,
                pinnedGiftMessageResult.imagePaint,
                pinnedGiftMessageResult.userName,
                pinnedGiftMessageResult.userNameStartIndex,
                binding.pinnedGiftTitle.currentTextColor,
                context.prefs().getString(AppConstants.CHAT_IMAGE_LIBRARY, "0"),
                pinnedGiftMessageResult.builder,
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    (context.prefs().getString(AppConstants.CHAT_EMOTE_SIZE, "29.5")?.toFloatOrNull() ?: 29.5f) * (context.prefs().getInt(AppConstants.CHAT_SIZE_MODIFIER, 100).toFloat() / 100f),
                    resources.displayMetrics,
                ).toInt(),
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    (context.prefs().getString(AppConstants.CHAT_BADGE_SIZE, "18.5")?.toFloatOrNull() ?: 18.5f) * (context.prefs().getInt(AppConstants.CHAT_SIZE_MODIFIER, 100).toFloat() / 100f),
                    resources.displayMetrics,
                ).toInt(),
                context.prefs().getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4",
                context.prefs().getBoolean(AppConstants.ANIMATED_EMOTES, true),
                context.prefs().getBoolean(AppConstants.CHAT_ZEROWIDTH, true),
            )
        }
        binding.pinnedGiftLayout.isClickable = true
        binding.pinnedGiftLayout.isFocusable = true
        val onCardClick = View.OnClickListener {
            if (pinnedGiftUiState.titleExpandable) {
                viewModel.togglePinnedGiftExpanded()
            }
        }
        binding.pinnedGiftLayout.setOnClickListener(onCardClick)
        binding.pinnedGiftTitle.setOnClickListener(onCardClick)
        binding.pinnedGiftText.setOnClickListener(onCardClick)
        binding.pinnedGiftTitle.movementMethod = NonScrollingLinkMovementMethod
        binding.pinnedGiftText.movementMethod = NonScrollingLinkMovementMethod
        binding.pinnedGiftText.linksClickable = true
        val avatarUrl = pinnedGift.avatarUrl
        if (!avatarUrl.isNullOrBlank()) {
            binding.pinnedGiftAvatar.isVisible = true
            context.imageLoader.enqueue(
                ImageRequest.Builder(context)
                    .data(avatarUrl)
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
                    .target(binding.pinnedGiftAvatar)
                    .build()
            )
        } else {
            binding.pinnedGiftAvatar.isGone = true
        }
    }

    private fun isTextViewTruncated(textView: TextView): Boolean {
        val layout = textView.layout ?: return false
        val maxVisibleLines = textView.maxLines.takeIf { it > 0 } ?: return false
        val visibleLineCount = minOf(layout.lineCount, maxVisibleLines)
        if (visibleLineCount <= 0) {
            return false
        }
        if ((0 until visibleLineCount).any { lineIndex -> layout.getEllipsisCount(lineIndex) > 0 }) {
            return true
        }
        if (layout.lineCount > maxVisibleLines) {
            return true
        }
        val lastVisibleLine = visibleLineCount - 1
        val visibleTextEnd = layout.getLineVisibleEnd(lastVisibleLine)
        val text = textView.text
        var effectiveLength = text.length
        while (effectiveLength > 0 && text[effectiveLength - 1].isWhitespace()) {
            effectiveLength--
        }
        return visibleTextEnd < effectiveLength
    }

    private fun updatePinnedGiftExpandUi(showExpand: Boolean, expanded: Boolean) {
        val binding = getBinding() ?: return
        binding.pinnedGiftExpand.isInvisible = !showExpand
        binding.pinnedGiftExpand.isEnabled = showExpand
        binding.pinnedGiftExpand.rotation = if (expanded) 180f else 0f
        binding.pinnedGiftExpand.contentDescription = context.getString(
            if (expanded) R.string.pinned_message_collapse else R.string.pinned_message_expand
        )
    }

    companion object {
        private const val PINNED_GIFT_COLLAPSED_MAX_LINES = 3
        private val pinnedInlineEmoteRegex = Regex("\\[emote:(\\d+):([^\\]]+)]")
    }
}

private object NonScrollingLinkMovementMethod : LinkMovementMethod() {
    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        val action = event.actionMasked
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            val rawX = event.x.toInt()
            val rawY = event.y.toInt()

            if (rawX < widget.totalPaddingLeft ||
                rawX > widget.width - widget.totalPaddingRight ||
                rawY < widget.totalPaddingTop ||
                rawY > widget.height - widget.totalPaddingBottom
            ) {
                Selection.removeSelection(buffer)
                return false
            }

            val x = rawX - widget.totalPaddingLeft + widget.scrollX
            val y = rawY - widget.totalPaddingTop + widget.scrollY

            val layout = widget.layout ?: return false
            val line = layout.getLineForVertical(y)

            if (x < layout.getLineLeft(line) || x > layout.getLineRight(line)) {
                Selection.removeSelection(buffer)
                return false
            }

            val off = layout.getOffsetForHorizontal(line, x.toFloat())
            val links = buffer.getSpans(off, off, ClickableSpan::class.java)
            if (links.isNotEmpty()) {
                val link = links[0]
                if (action == MotionEvent.ACTION_UP) {
                    link.onClick(widget)
                    Selection.removeSelection(buffer)
                } else {
                    Selection.setSelection(buffer, buffer.getSpanStart(link), buffer.getSpanEnd(link))
                }
                return true
            } else {
                Selection.removeSelection(buffer)
            }
        } else if (action == MotionEvent.ACTION_CANCEL) {
            Selection.removeSelection(buffer)
        }
        return false
    }
}
