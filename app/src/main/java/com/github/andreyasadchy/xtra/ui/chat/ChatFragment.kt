package com.github.andreyasadchy.xtra.ui.chat

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.method.LinkMovementMethod
import android.text.format.DateUtils
import android.text.util.Linkify
import android.util.Log
import android.util.TypedValue
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MultiAutoCompleteTextView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import androidx.core.graphics.ColorUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams
import androidx.core.text.util.LinkifyCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.view.doOnLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.databinding.FragmentChatBinding
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Emote
import com.github.andreyasadchy.xtra.model.chat.PinnedGift
import com.github.andreyasadchy.xtra.model.chat.Poll
import com.github.andreyasadchy.xtra.model.chat.Prediction
import com.github.andreyasadchy.xtra.model.chat.RoomState
import com.github.andreyasadchy.xtra.model.kick.KickOfficialReward
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardCreateRequest
import com.github.andreyasadchy.xtra.model.kick.KickOfficialRewardUpdateRequest
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemption
import com.github.andreyasadchy.xtra.model.kick.KickRewardRedemptionsPage
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragmentDirections
import com.github.andreyasadchy.xtra.ui.common.BaseNetworkFragment
import com.github.andreyasadchy.xtra.ui.common.IntegrityDialog
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.ui.player.PlayerFragment
import com.github.andreyasadchy.xtra.ui.view.AutoCompleteAdapter
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.KickOAuthConfig
import com.github.andreyasadchy.xtra.util.chat.ChatAdapterUtils
import com.github.andreyasadchy.xtra.util.chat.ChatBackgroundUtils
import com.github.andreyasadchy.xtra.util.chat.ChatListParityUtils
import com.github.andreyasadchy.xtra.util.getAlertDialogBuilder
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.reduceDragSensitivity
import com.github.andreyasadchy.xtra.util.tokenPrefs
import com.google.android.material.color.MaterialColors
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.NumberFormat
import kotlin.math.max
import kotlin.math.roundToInt
import javax.inject.Inject

@AndroidEntryPoint
class ChatFragment : BaseNetworkFragment(), MessageClickedDialog.OnButtonClickListener, ReplyClickedDialog.OnButtonClickListener {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ChatViewModel by viewModels()
    private var adapter: ChatAdapter? = null

    @Inject
    lateinit var kickRepository: KickRepository

    private var isChatTouched = false
    private var showChatStatus = false
    private var hasRecentEmotes = false
    private var delayBadgeActive = false
    private var roomModeBadgeText: String? = null
    private var lastRoomStateSignature: String? = null
    private var delayBadgeFirstShown = false
    private val hideDelayBadgeRunnable = Runnable {
        _binding?.chatDelayText?.visibility = View.GONE
        updateHeaderBadgeLayout()
    }
    private val hideRoomModeBadgeRunnable = Runnable {
        _binding?.chatModeText?.apply {
            isSelected = false
            visibility = View.GONE
        }
        updateHeaderBadgeLayout()
    }
    private var messagingEnabled = false
    private var pinnedMessageDialogSeed: ChatMessage? = null
    private var tappedMessageDialogSeed: ChatMessage? = null
    private var pinnedGiftContentKey: String? = null
    private var pinnedGiftTitleExpandable = false

    private var autoCompleteAdapter: AutoCompleteAdapter<Any>? = null

    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            toggleEmoteMenu(false)
        }
    }

    private val messageDialog: MessageClickedDialog?
        get() = childFragmentManager.findFragmentByTag("messageDialog") as? MessageClickedDialog

    private val replyDialog: ReplyClickedDialog?
        get() = childFragmentManager.findFragmentByTag("replyDialog") as? ReplyClickedDialog

    private fun renderBufferedMessages() {
        val binding = _binding ?: return
        val adapter = adapter ?: return
        val size = synchronized(viewModel.chatMessages) {
            viewModel.chatMessages.size
        }
        if (size > 0) {
            adapter.notifyDataSetChanged()
            if (!isChatTouched && binding.btnDown.isGone) {
                scrollChatToBottom(size - 1)
            }
        }
    }

    private fun scrollChatToBottom(position: Int) {
        val binding = _binding ?: return
        if (position < 0) return
        val recyclerView = binding.recyclerView
        recyclerView.post {
            val activeBinding = _binding ?: return@post
            activeBinding.recyclerView.scrollToPosition(position)
            activeBinding.recyclerView.doOnLayout { view ->
                val laidOutRecyclerView = view as? RecyclerView ?: return@doOnLayout
                if (laidOutRecyclerView.canScrollVertically(1)) {
                    laidOutRecyclerView.scrollBy(0, laidOutRecyclerView.computeVerticalScrollRange())
                }
            }
        }
    }

    private fun formatDisplayName(userLogin: String?, userName: String?): String {
        return if (userLogin != null && userName != null && !userLogin.equals(userName, true)) {
            when (requireContext().prefs().getString(C.UI_NAME_DISPLAY, "1")) {
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
        pinnedMessageDialogSeed = ChatMessage(
            userId = id,
            userLogin = login,
            userName = name,
            color = color,
        )
        MessageClickedDialog.newInstance(messagingEnabled, requireArguments().getString(KEY_CHANNEL_ID), requireArguments().getString(KEY_CHANNEL_LOGIN))
            .show(childFragmentManager, "messageDialog")
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
            append(label)
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

    private fun buildPinnedMessageText(pinnedGift: PinnedGift): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        pinnedGift.message?.takeIf { it.isNotBlank() }?.let { builder.append(it) }
        pinnedGift.giftValue?.let { giftValue ->
            if (builder.isNotEmpty()) builder.append(" • ")
            builder.append(getString(R.string.pinned_gift_value))
            builder.append(": ")
            builder.append(NumberFormat.getInstance().format(giftValue))
        }
        if (builder.isEmpty()) {
            builder.append(getString(R.string.pinned_gift_message_fallback))
        }
        LinkifyCompat.addLinks(builder, Linkify.WEB_URLS)
        return builder
    }

    private fun buildPinnedMetadataText(pinnedGift: PinnedGift): SpannableStringBuilder {
        val builder = SpannableStringBuilder()
        val baseTextColor = binding.pinnedGiftText.currentTextColor
        val senderColor = resolvePinnedNameColor(pinnedGift.userColor, baseTextColor)
        val senderName = formatDisplayName(pinnedGift.userLogin, pinnedGift.userName)
        val pinnedByColor = resolvePinnedNameColor(pinnedGift.pinnedByUserColor, baseTextColor)
        val pinnedBy = formatDisplayName(pinnedGift.pinnedByUserLogin, pinnedGift.pinnedByUserName)
        if (senderName.isNotBlank()) {
            builder.append(
                buildPinnedNameSpan(
                    label = getString(R.string.pinned_gift_title_prefix),
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
                    label = getString(R.string.pinned_gift_pinned_by_prefix),
                    displayName = pinnedBy,
                    color = pinnedByColor,
                    userId = pinnedGift.pinnedByUserId,
                    userLogin = pinnedGift.pinnedByUserLogin,
                    userName = pinnedGift.pinnedByUserName,
                    userColor = pinnedGift.pinnedByUserColor,
                )
            )
            pinnedGift.pinnedSeconds?.takeIf { it > 0 }?.let {
                builder.append(getString(R.string.pinned_gift_pinned_by_suffix_with_seconds, it))
            }
        }
        if (builder.isEmpty()) {
            builder.append(getString(R.string.pinned_gift_unknown_user))
        }
        return builder
    }

    private fun renderPinnedGift() {
        val binding = _binding ?: return
        val pinnedGift = viewModel.pinnedGift.value
        val dismissed = viewModel.pinnedGiftDismissed.value
        binding.pinnedGiftRestore.isVisible = pinnedGift != null && dismissed
        updateHeaderBadgeLayout()
        if (pinnedGift == null || dismissed) {
            pinnedGiftContentKey = null
            pinnedGiftTitleExpandable = false
            binding.pinnedGiftLayout.isGone = true
            return
        }
        val contentKey = listOf(
            pinnedGift.id,
            pinnedGift.message,
            pinnedGift.giftValue?.toString(),
            pinnedGift.userId,
            pinnedGift.userLogin
        ).joinToString("|")
        if (pinnedGiftContentKey != contentKey) {
            pinnedGiftContentKey = contentKey
            pinnedGiftTitleExpandable = false
        }
        val expanded = viewModel.pinnedGiftExpanded.value
        binding.pinnedGiftLayout.isVisible = true
        binding.pinnedGiftTitle.text = buildPinnedMessageText(pinnedGift)
        binding.pinnedGiftText.text = buildPinnedMetadataText(pinnedGift)
        binding.pinnedGiftTitle.maxLines = if (expanded) Int.MAX_VALUE else 1
        binding.pinnedGiftTitle.ellipsize = if (expanded) null else TextUtils.TruncateAt.END
        updatePinnedGiftExpandUi(showExpand = expanded && pinnedGiftTitleExpandable, expanded = expanded)
        if (!expanded) {
            binding.pinnedGiftTitle.doOnLayout {
                val layout = binding.pinnedGiftTitle.layout ?: return@doOnLayout
                val titleIsTruncated = (0 until layout.lineCount).any { lineIndex ->
                    layout.getEllipsisCount(lineIndex) > 0
                }
                if (pinnedGiftTitleExpandable != titleIsTruncated) {
                    pinnedGiftTitleExpandable = titleIsTruncated
                    updatePinnedGiftExpandUi(showExpand = titleIsTruncated, expanded = false)
                }
            }
        }
        binding.pinnedGiftLayout.isClickable = true
        binding.pinnedGiftLayout.isFocusable = true
        binding.pinnedGiftLayout.setOnClickListener { }
        binding.pinnedGiftTitle.setOnClickListener { }
        binding.pinnedGiftText.setOnClickListener { }
        binding.pinnedGiftTitle.movementMethod = LinkMovementMethod.getInstance()
        binding.pinnedGiftText.movementMethod = LinkMovementMethod.getInstance()
        binding.pinnedGiftText.linksClickable = true
        val avatarUrl = pinnedGift.avatarUrl
        if (!avatarUrl.isNullOrBlank()) {
            binding.pinnedGiftAvatar.isVisible = true
            requireContext().imageLoader.enqueue(
                ImageRequest.Builder(requireContext())
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

    private fun updatePinnedGiftExpandUi(showExpand: Boolean, expanded: Boolean) {
        val binding = _binding ?: return
        binding.pinnedGiftExpand.isVisible = showExpand
        binding.pinnedGiftExpand.isEnabled = showExpand
        binding.pinnedGiftExpand.rotation = if (expanded) 180f else 0f
        binding.pinnedGiftExpand.contentDescription = getString(
            if (expanded) R.string.pinned_message_collapse else R.string.pinned_message_expand
        )
        val endTarget = if (showExpand) R.id.pinnedGiftExpand else R.id.pinnedGiftClose
        binding.pinnedGiftTitle.updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = endTarget
        }
        binding.pinnedGiftText.updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = endTarget
        }
    }

    private fun currentKickScopes(): String? {
        return requireContext().prefs().getString(C.KICK_SCOPES, null)
    }

    private fun currentChannelLogin(): String? {
        return requireArguments().getString(KEY_CHANNEL_LOGIN)
    }

    private fun isKickRewardsOwnerChannel(): Boolean {
        val accountLogin = requireContext().tokenPrefs().getString(C.KICK_USER_LOGIN, null)
        return !accountLogin.isNullOrBlank() &&
            !currentChannelLogin().isNullOrBlank() &&
            accountLogin.equals(currentChannelLogin(), ignoreCase = true)
    }

    private fun hasKickScopes(vararg scopes: String): Boolean {
        return KickOAuthConfig.hasScopes(currentKickScopes(), scopes.toSet())
    }

    private fun hasAnyKickScope(vararg scopes: String): Boolean {
        val configured = currentKickScopes()
        return scopes.any { scope -> KickOAuthConfig.hasScopes(configured, setOf(scope)) }
    }

    private fun requireKickRewardScopes(vararg scopes: String): Boolean {
        if (!com.github.andreyasadchy.xtra.util.AuthStateHelper.isKickLoggedIn(requireContext())) {
            requireContext().getAlertDialogBuilder()
                .setMessage(getString(R.string.log_in))
                .setPositiveButton(getString(R.string.close), null)
                .show()
            return false
        }
        if (!hasKickScopes(*scopes)) {
            Toast.makeText(
                requireContext(),
                getString(
                    if (scopes.size > 1) R.string.kick_scope_required_multiple else R.string.kick_scope_required,
                    scopes.joinToString(" ")
                ),
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }

    private fun refreshKickRewardState() {
        if (!currentChatSource().equals(C.KICK, true)) {
            return
        }
        viewModel.refreshKickChannelPointState(
            networkLibrary = requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
            channelId = requireArguments().getString(KEY_CHANNEL_ID),
            channelLogin = currentChannelLogin(),
        )
    }

    private fun currentChatSource(): String? {
        return requireArguments().getString(KEY_SOURCE)
    }

    private fun hasVisibleChannelPointState(): Boolean {
        val summary = viewModel.channelPointsSummary.value
        return summary.balance != null || summary.rewards.isNotEmpty() || summary.rewardsAvailable
    }

    private fun buildChannelPointsButtonText(): String {
        val summary = viewModel.channelPointsSummary.value
        val balanceText = summary.balance?.let { getString(R.string.channel_points_balance, NumberFormat.getInstance().format(it)) }
        val rewardCountText = if (summary.rewards.isNotEmpty()) {
            resources.getQuantityString(R.plurals.kick_reward_count, summary.rewards.size, summary.rewards.size)
        } else {
            null
        }
        return listOfNotNull(balanceText, rewardCountText).joinToString(" • ").ifBlank {
            getString(R.string.channel_points_rewards_title)
        }
    }

    private fun renderChannelPointsButton() {
        val binding = _binding ?: return
        val isKickChat = currentChatSource().equals(C.KICK, true)
        val visible = hasVisibleChannelPointState()
        binding.channelPointsButton.isGone = true
        binding.channelPointsInputButton.isVisible = isKickChat
        binding.channelPointsInputButton.alpha = 1f
        binding.channelPointsInputButton.contentDescription = buildChannelPointsButtonText()
        binding.channelPointsInputButton.setOnClickListener {
            if (visible) {
                showChannelPointRewardsDialog()
            } else {
                refreshKickRewardState()
                Toast.makeText(requireContext(), getString(R.string.channel_points_loading), Toast.LENGTH_SHORT).show()
            }
        }
        binding.channelPointsInputButton.setOnLongClickListener {
            if (currentChatSource().equals(C.KICK, true) &&
                isKickRewardsOwnerChannel() &&
                hasAnyKickScope("channel:rewards:read", "channel:rewards:write")
            ) {
                showKickChannelPointActionsDialog()
                true
            } else {
                false
            }
        }
    }

    private fun Int.dp(): Int = (this * resources.displayMetrics.density).roundToInt()

    private fun parseRewardBackgroundColor(color: String?): Int? {
        if (color.isNullOrBlank()) return null
        return runCatching { Color.parseColor(color) }.getOrNull()
    }

    private fun createViewerRewardTile(
        reward: com.github.andreyasadchy.xtra.model.chat.ChannelPointReward,
        tileWidth: Int,
        onClick: () -> Unit,
    ): View {
        val context = requireContext()
        val rewardColor = parseRewardBackgroundColor(reward.backgroundColor)
            ?: ContextCompat.getColor(context, R.color.accent)
        val tileBackground = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 10.dp().toFloat()
            setColor(rewardColor)
        }
        val title = reward.title ?: reward.prompt ?: reward.id ?: getString(R.string.channel_points_rewards_title)
        val metadata = buildList {
            if (reward.isUserInputRequired == true) add(getString(R.string.channel_points_reward_input_required))
            if (reward.isEnabled == false) add(getString(R.string.channel_points_reward_disabled))
        }.joinToString(" • ")
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = GridLayout.LayoutParams().apply {
                width = tileWidth
                height = GridLayout.LayoutParams.WRAP_CONTENT
                setMargins(0, 0, 8.dp(), 10.dp())
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED)
            }

            addView(FrameLayout(context).apply {
                background = tileBackground
                foreground = ContextCompat.getDrawable(context, android.R.drawable.list_selector_background)
                isClickable = true
                isFocusable = true
                setOnClickListener { onClick() }
                minimumHeight = tileWidth
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    tileWidth
                )

                addView(ImageView(context).apply {
                    setImageResource(R.drawable.ic_channel_points_black_24)
                    imageTintList = android.content.res.ColorStateList.valueOf(ColorUtils.setAlphaComponent(Color.BLACK, 215))
                    layoutParams = FrameLayout.LayoutParams(18.dp(), 18.dp()).apply {
                        topMargin = 10.dp()
                        gravity = android.view.Gravity.TOP or android.view.Gravity.CENTER_HORIZONTAL
                    }
                })

                addView(TextView(context).apply {
                    text = NumberFormat.getInstance().format(reward.cost ?: 0)
                    setTypeface(typeface, Typeface.BOLD)
                    setTextColor(Color.WHITE)
                    textSize = 12f
                    background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 11.dp().toFloat()
                        setColor(ColorUtils.setAlphaComponent(Color.BLACK, 130))
                    }
                    setPadding(10.dp(), 4.dp(), 10.dp(), 4.dp())
                    layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        bottomMargin = 10.dp()
                        gravity = android.view.Gravity.BOTTOM or android.view.Gravity.CENTER_HORIZONTAL
                    }
                })

                if (reward.isUserInputRequired == true) {
                    addView(TextView(context).apply {
                        text = "Aa"
                        setTypeface(typeface, Typeface.BOLD)
                        setTextColor(Color.WHITE)
                        textSize = 10f
                        background = GradientDrawable().apply {
                            shape = GradientDrawable.RECTANGLE
                            cornerRadius = 9.dp().toFloat()
                            setColor(ColorUtils.setAlphaComponent(Color.BLACK, 118))
                        }
                        setPadding(7.dp(), 3.dp(), 7.dp(), 3.dp())
                        layoutParams = FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.WRAP_CONTENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT
                        ).apply {
                            rightMargin = 10.dp()
                            topMargin = 10.dp()
                            gravity = android.view.Gravity.TOP or android.view.Gravity.END
                        }
                    })
                }
            })

            addView(TextView(context).apply {
                text = title.uppercase()
                setTypeface(typeface, Typeface.BOLD)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_LabelLarge)
                gravity = android.view.Gravity.CENTER_HORIZONTAL
                minLines = 1
                maxLines = 2
                ellipsize = TextUtils.TruncateAt.END
                setPadding(2.dp(), 6.dp(), 2.dp(), 0)
            })
        }
    }

    private fun showKickChannelPointActionsDialog() {
        requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.channel_points_rewards_title))
            .setItems(
                arrayOf(
                    getString(R.string.kick_manage_rewards),
                    getString(R.string.kick_manage_redemptions),
                )
            ) { _, which ->
                when (which) {
                    0 -> openKickRewardsManager()
                    1 -> openKickRedemptionsManager()
                }
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    private fun getChannelPointsDialogPrediction(): Prediction? {
        return viewModel.prediction.value ?: viewModel.latestPrediction.value
    }

    private fun formatCompactPoints(value: Long): String {
        fun compact(amount: Double, suffix: String): String {
            val rounded = (amount * 10).roundToInt() / 10.0
            val text = if (rounded % 1.0 == 0.0) {
                rounded.toInt().toString()
            } else {
                rounded.toString()
            }
            return "$text$suffix"
        }
        return when {
            value >= 1_000_000_000L -> compact(value / 1_000_000_000.0, "B")
            value >= 1_000_000L -> compact(value / 1_000_000.0, "M")
            value >= 1_000L -> compact(value / 1_000.0, "K")
            else -> NumberFormat.getInstance().format(value)
        }
    }

    private fun buildChannelPointsPredictionStatusText(prediction: Prediction): String {
        val totalPoints = prediction.outcomes.orEmpty().sumOf { it.totalPoints?.toLong() ?: 0L }
        val statusText = when (prediction.status) {
            "ACTIVE" -> {
                val secondsLeft = (
                    if (viewModel.prediction.value?.id == prediction.id) {
                        viewModel.predictionSecondsLeft.value
                    } else {
                        null
                    }
                    ) ?: prediction.createdAt?.let { createdAt ->
                    prediction.predictionWindowSeconds?.let { duration ->
                        (((createdAt + (duration * 1000L)) - System.currentTimeMillis()) / 1000L).toInt()
                    }
                }
                if (secondsLeft != null && secondsLeft > 0) {
                    getString(R.string.remaining_time, DateUtils.formatElapsedTime(secondsLeft.toLong()))
                } else {
                    getString(R.string.channel_points_prediction_open)
                }
            }
            "LOCKED" -> getString(R.string.prediction_locked)
            "CANCELED", "CANCEL_PENDING" -> getString(R.string.prediction_refunded)
            else -> getString(R.string.channel_points_prediction_closed)
        }
        val poolText = getString(R.string.channel_points_prediction_pool, formatCompactPoints(totalPoints))
        return "$statusText • $poolText"
    }

    private fun formatPredictionOdds(returnRate: Double?): String? {
        if (returnRate == null || returnRate <= 0.0) return null
        val rounded = (returnRate * 10).roundToInt() / 10.0
        val text = if (rounded % 1.0 == 0.0) rounded.toInt().toString() else rounded.toString()
        return getString(R.string.channel_points_prediction_odds, text)
    }

    private fun buildChannelPointsPredictionSummaryText(prediction: Prediction): String? {
        val userVote = prediction.userVote ?: return null
        val stake = userVote.totalVoteAmount ?: return null
        val selectedOutcome = prediction.outcomes.orEmpty().firstOrNull { it.id == userVote.outcomeId }
        val payout = selectedOutcome?.returnRate
            ?.takeIf { it > 0.0 }
            ?.let { (stake * it).roundToInt() }
            ?.let { NumberFormat.getInstance().format(it) }
        return when {
            payout != null -> {
                getString(
                    R.string.channel_points_prediction_summary_full,
                    NumberFormat.getInstance().format(stake),
                    payout,
                )
            }
            else -> {
                getString(
                    R.string.channel_points_prediction_summary_basic,
                    NumberFormat.getInstance().format(stake),
                )
            }
        }
    }

    private fun buildResolvedPredictionResultText(prediction: Prediction): String? {
        if (prediction.status != "RESOLVED" && prediction.status != "RESOLVE_PENDING") return null
        val userVote = prediction.userVote ?: return null
        val stake = userVote.totalVoteAmount ?: return null
        val selectedOutcome = prediction.outcomes.orEmpty().firstOrNull { it.id == userVote.outcomeId }
        val won = prediction.winningOutcomeId != null && prediction.winningOutcomeId == userVote.outcomeId
        return if (won) {
            val payout = selectedOutcome?.returnRate
                ?.takeIf { it > 0.0 }
                ?.let { (stake * it).roundToInt() }
                ?: stake
            getString(R.string.prediction_result_won, formatCompactPoints(payout.toLong()))
        } else {
            getString(R.string.prediction_result_lost, formatCompactPoints(stake.toLong()))
        }
    }

    private fun buildChannelPointsPredictionOutcomesText(prediction: Prediction): CharSequence {
        val totalPoints = prediction.outcomes?.sumOf { it.totalPoints?.toLong() ?: 0 } ?: 0
        val selectedOutcomeId = prediction.userVote?.outcomeId
        val resolved = prediction.status == "RESOLVED" || prediction.status == "RESOLVE_PENDING"
        val builder = SpannableStringBuilder()
        prediction.outcomes.orEmpty().forEachIndexed { index, outcome ->
            if (index > 0) {
                builder.append('\n')
            }
            val isSelected = selectedOutcomeId != null && outcome.id == selectedOutcomeId
            val isWinner = resolved && prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id
            val line = buildString {
                val title = if (isWinner) {
                    getString(R.string.channel_points_prediction_outcome_winner_title, outcome.title)
                } else {
                    outcome.title
                }
                append(title)
                append(" • ")
                append(getString(R.string.channel_points_prediction_percent, (((outcome.totalPoints ?: 0).toLong() * 100.0) / max(totalPoints, 1)).roundToInt()))
                append(" • ")
                append(getString(R.string.channel_points_prediction_points_short, outcome.totalPoints?.let { NumberFormat.getInstance().format(it) }))
                append(" • ")
                append(getString(R.string.channel_points_prediction_votes_short, outcome.totalUsers?.let { NumberFormat.getInstance().format(it) }))
                formatPredictionOdds(outcome.returnRate)?.let {
                    append(" • ")
                    append(it)
                }
            }
            val start = builder.length
            builder.append(line)
            val end = builder.length
            when {
                isSelected -> {
                    builder.setSpan(BackgroundColorSpan(ColorUtils.setAlphaComponent(Color.WHITE, 36)), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                isWinner -> {
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
        return builder
    }

    private fun createChannelPointsPredictionCard(prediction: Prediction): View {
        val context = requireContext()
        val surfaceColor = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainerHighest, Color.DKGRAY)
        val titleText = prediction.title?.takeIf { it.isNotBlank() }
            ?: getString(R.string.channel_points_prediction_fallback_title)
        val outcomesText = buildChannelPointsPredictionOutcomesText(prediction)
        val summaryText = buildChannelPointsPredictionSummaryText(prediction)
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 12.dp().toFloat()
                setColor(surfaceColor)
            }
            setPadding(14.dp(), 12.dp(), 14.dp(), 12.dp())
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = 12.dp()
            }

            addView(TextView(context).apply {
                text = titleText
                setTypeface(typeface, Typeface.BOLD)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleMedium)
                maxLines = 2
                ellipsize = TextUtils.TruncateAt.END
            })

            addView(TextView(context).apply {
                text = buildChannelPointsPredictionStatusText(prediction)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                setTextColor(MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY))
                setPadding(0, 4.dp(), 0, 0)
            })

            summaryText?.let {
                addView(TextView(context).apply {
                    text = it
                    setTypeface(typeface, Typeface.BOLD)
                    setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                    setPadding(0, 8.dp(), 0, 0)
                })
            }

            addView(TextView(context).apply {
                text = outcomesText
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                setPadding(0, 10.dp(), 0, 0)
            })
        }
    }

    private fun showChannelPointRewardsDialog() {
        val context = requireContext()
        val balanceText = getString(
            R.string.channel_points_rewards_balance,
            viewModel.channelPointsBalance.value?.let { NumberFormat.getInstance().format(it) } ?: "?"
        )
        val rewards = viewModel.channelPointRewards.value
        val prediction = getChannelPointsDialogPrediction()
        val dialogHorizontalPadding = 14.dp()
        val tileGap = 8.dp()
        val screenWidth = resources.displayMetrics.widthPixels
        val dialogWidth = (screenWidth - 16.dp()).coerceAtLeast(280.dp())
        // AlertDialog adds its own horizontal insets around a custom view, so reserve space for them
        // before dividing the remaining width into three equal tiles.
        val tileWidth = (
            dialogWidth -
                48.dp() -
                (dialogHorizontalPadding * 2) -
                (tileGap * 2)
            ).div(3)
            .coerceAtLeast(72.dp())
        val content = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dialogHorizontalPadding, 10.dp(), dialogHorizontalPadding, 6.dp())
        }
        prediction?.let {
            content.addView(createChannelPointsPredictionCard(it))
        }
        content.addView(TextView(context).apply {
            text = balanceText
            setTypeface(typeface, Typeface.BOLD)
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge)
            setPadding(0, 0, 0, 10.dp())
        })
        val rewardsContainer = GridLayout(context).apply {
            columnCount = 3
            useDefaultMargins = false
            alignmentMode = GridLayout.ALIGN_BOUNDS
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        content.addView(rewardsContainer)
        val builder = context.getAlertDialogBuilder()
            .setTitle(getString(R.string.channel_points_rewards_title))
            .setView(ScrollView(context).apply {
                isFillViewport = true
                addView(content)
            })
            .setNegativeButton(getString(R.string.close), null)
        if (rewards.isEmpty()) {
            rewardsContainer.addView(TextView(context).apply {
                text = buildString {
                    append(balanceText)
                    append("\n\n")
                    append(getString(R.string.channel_points_rewards_unavailable))
                }
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                setTextColor(MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY))
                layoutParams = GridLayout.LayoutParams().apply {
                    width = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(0, 2)
                }
            })
        }
        if (currentChatSource().equals(C.KICK, true) &&
            isKickRewardsOwnerChannel() &&
            hasAnyKickScope("channel:rewards:read", "channel:rewards:write")
        ) {
            builder
                .setPositiveButton(getString(R.string.kick_manage_rewards)) { _, _ ->
                    openKickRewardsManager()
                }
                .setNeutralButton(getString(R.string.kick_manage_redemptions)) { _, _ ->
                    openKickRedemptionsManager()
                }
        }
        val dialog = builder.show()
        if (rewards.isNotEmpty()) {
            rewards.forEach { reward ->
                rewardsContainer.addView(createViewerRewardTile(reward, tileWidth) {
                    dialog.dismiss()
                    showViewerKickRewardRedeemDialog(reward)
                })
            }
        }
        dialog.window?.setLayout(dialogWidth, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    private fun formatViewerKickRewardLabel(reward: com.github.andreyasadchy.xtra.model.chat.ChannelPointReward): String {
        val title = reward.title ?: reward.prompt ?: reward.id ?: getString(R.string.channel_points_rewards_title)
        return buildString {
            append(getString(R.string.channel_points_reward_line, NumberFormat.getInstance().format(reward.cost ?: 0), title))
            if (reward.isUserInputRequired == true) {
                append(" • ")
                append(getString(R.string.channel_points_reward_input_required))
            }
        }
    }

    private fun showViewerKickRewardRedeemDialog(reward: com.github.andreyasadchy.xtra.model.chat.ChannelPointReward) {
        val channelLogin = currentChannelLogin() ?: return
        val rewardId = reward.id ?: return
        val rewardTitle = reward.title ?: reward.prompt ?: rewardId
        if (reward.isUserInputRequired == true) {
            val input = EditText(requireContext()).apply {
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES or InputType.TYPE_TEXT_FLAG_MULTI_LINE
                hint = getString(R.string.kick_reward_redeem_input_hint)
                minLines = 3
            }
            requireContext().getAlertDialogBuilder()
                .setTitle(rewardTitle)
                .setView(input)
                .setPositiveButton(getString(R.string.kick_reward_redeem)) { _, _ ->
                    redeemViewerKickReward(channelLogin, rewardId, rewardTitle, input.text?.toString())
                }
                .setNegativeButton(getString(R.string.close)) { _, _ ->
                    showChannelPointRewardsDialog()
                }
                .show()
        } else {
            requireContext().getAlertDialogBuilder()
                .setTitle(rewardTitle)
                .setMessage(getString(R.string.kick_reward_redeem_confirm, rewardTitle))
                .setPositiveButton(getString(R.string.kick_reward_redeem)) { _, _ ->
                    redeemViewerKickReward(channelLogin, rewardId, rewardTitle, null)
                }
                .setNegativeButton(getString(R.string.close)) { _, _ ->
                    showChannelPointRewardsDialog()
                }
                .show()
        }
    }

    private fun redeemViewerKickReward(
        channelLogin: String,
        rewardId: String,
        rewardTitle: String,
        userInput: String?,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                kickRepository.redeemKickWebReward(
                    channelSlug = channelLogin,
                    rewardId = rewardId,
                    userInput = userInput,
                )
            }.onSuccess {
                Toast.makeText(requireContext(), getString(R.string.kick_reward_redeemed, rewardTitle), Toast.LENGTH_SHORT).show()
                refreshKickRewardState()
            }.onFailure(::showKickApiError)
        }
    }

    private fun buildKickPollChoicesText(poll: Poll, clickable: Boolean): CharSequence {
        val channelLogin = currentChannelLogin()
        val primaryColor = MaterialColors.getColor(requireContext(), androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val neutralBackground = ColorUtils.setAlphaComponent(primaryColor, 28)
        val selectedBackground = ColorUtils.setAlphaComponent(primaryColor, 72)
        val selectedTextColor = Color.WHITE
        val maxVotes = poll.choices.orEmpty().maxOfOrNull { it.totalVotes ?: 0 } ?: 0
        val winnerCount = poll.choices.orEmpty().count { (it.totalVotes ?: 0) == maxVotes && maxVotes > 0 }
        val builder = SpannableStringBuilder()
        poll.choices.orEmpty().forEachIndexed { index, choice ->
            if (index > 0) {
                builder.append('\n')
            }
            val isSelected = poll.votedChoiceId != null && choice.id == poll.votedChoiceId
            val isUniqueWinner = poll.status != "ACTIVE" && winnerCount == 1 && maxVotes > 0 && (choice.totalVotes ?: 0) == maxVotes
            val line = getString(
                if (isUniqueWinner) R.string.poll_choice_winner else R.string.poll_choice,
                (((choice.totalVotes ?: 0).toLong() * 100.0) / max((poll.totalVotes ?: 0), 1)).roundToInt(),
                choice.totalVotes?.let { NumberFormat.getInstance().format(it) },
                choice.title
            )
            val start = builder.length
            builder.append(line)
            val end = builder.length
            when {
                poll.status == "ACTIVE" && poll.hasVoted == true && isSelected -> {
                    builder.setSpan(BackgroundColorSpan(selectedBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(ForegroundColorSpan(selectedTextColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                poll.status == "ACTIVE" && poll.hasVoted != true && choice.id != null -> {
                    builder.setSpan(BackgroundColorSpan(neutralBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                isUniqueWinner -> {
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
            if (clickable &&
                channelLogin != null &&
                poll.status == "ACTIVE" &&
                poll.hasVoted != true &&
                choice.id != null
            ) {
                builder.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            submitKickPollVote(channelLogin, choice.id)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.isUnderlineText = false
                            ds.color = ds.linkColor
                        }
                    },
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return builder
    }

    private fun submitKickPollVote(channelLogin: String, choiceId: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                kickRepository.voteKickWebPoll(channelLogin, choiceId)
            }.onSuccess { updatedPoll ->
                updatedPoll?.let(viewModel::applyLocalPollUpdate)
                Toast.makeText(requireContext(), getString(R.string.kick_poll_vote_submitted), Toast.LENGTH_SHORT).show()
            }.onFailure(::showKickApiError)
        }
    }

    private fun buildKickPredictionOutcomesText(prediction: Prediction, clickable: Boolean): CharSequence {
        val channelLogin = currentChannelLogin()
        val primaryColor = MaterialColors.getColor(requireContext(), androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val neutralBackground = ColorUtils.setAlphaComponent(primaryColor, 28)
        val selectedBackground = ColorUtils.setAlphaComponent(primaryColor, 72)
        val selectedTextColor = Color.WHITE
        val totalPoints = prediction.outcomes?.sumOf { it.totalPoints?.toLong() ?: 0 } ?: 0
        val selectedOutcomeId = prediction.userVote?.outcomeId
        val resolved = prediction.status == "RESOLVED" || prediction.status == "RESOLVE_PENDING"
        val builder = SpannableStringBuilder()
        prediction.outcomes.orEmpty().forEachIndexed { index, outcome ->
            if (index > 0) {
                builder.append('\n')
            }
            val isSelected = selectedOutcomeId != null && outcome.id == selectedOutcomeId
            val isWinner = resolved && prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id
            val line = getString(
                if (isWinner) R.string.prediction_outcome_compact_winner else R.string.prediction_outcome_compact,
                (((outcome.totalPoints ?: 0).toLong() * 100.0) / max(totalPoints, 1)).roundToInt(),
                outcome.title
            )
            val start = builder.length
            builder.append(line)
            val end = builder.length
            when {
                isSelected -> {
                    builder.setSpan(BackgroundColorSpan(selectedBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(ForegroundColorSpan(selectedTextColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                prediction.status == "ACTIVE" && selectedOutcomeId == null && outcome.id != null -> {
                    builder.setSpan(BackgroundColorSpan(neutralBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                isWinner -> {
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
            if (clickable &&
                channelLogin != null &&
                prediction.status == "ACTIVE" &&
                outcome.id != null &&
                (selectedOutcomeId == null || selectedOutcomeId == outcome.id)
            ) {
                builder.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            showKickPredictionVoteDialog(prediction, outcome)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.isUnderlineText = false
                            ds.color = ds.linkColor
                        }
                    },
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return builder
    }

    private fun showKickPredictionVoteDialog(
        prediction: Prediction,
        outcome: Prediction.PredictionOutcome,
    ) {
        val context = requireContext()
        val channelLogin = currentChannelLogin() ?: return
        val outcomeId = outcome.id ?: return
        val selectedOutcomeId = prediction.userVote?.outcomeId
        if (selectedOutcomeId != null && selectedOutcomeId != outcomeId) {
            Toast.makeText(context, getString(R.string.kick_prediction_vote_only_selected), Toast.LENGTH_SHORT).show()
            return
        }
        val currentBalance = viewModel.channelPointsBalance.value
        val currentStake = prediction.userVote?.takeIf { it.outcomeId == outcomeId }?.totalVoteAmount
        val minAmount = 10
        val content = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
        content.addView(TextView(context).apply {
            text = buildString {
                append(getString(R.string.channel_points_balance, currentBalance?.let { NumberFormat.getInstance().format(it) } ?: getString(R.string.channel_points_loading)))
                append('\n')
                append(getString(R.string.kick_prediction_vote_minimum, NumberFormat.getInstance().format(minAmount)))
                if (currentStake != null) {
                    append('\n')
                    append(getString(R.string.kick_prediction_vote_current_stake, NumberFormat.getInstance().format(currentStake)))
                }
            }
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
            setPadding(0, 0, 0, 12.dp())
        })
        val input = EditText(context).apply {
            inputType = InputType.TYPE_CLASS_NUMBER
            hint = getString(R.string.kick_prediction_vote_amount_hint)
        }
        content.addView(input)
        val dialog = context.getAlertDialogBuilder()
            .setTitle(outcome.title)
            .setView(content)
            .setPositiveButton(getString(R.string.kick_prediction_vote_submit), null)
            .setNegativeButton(getString(R.string.close), null)
            .show()
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val updateButtonState = {
            val amount = input.text?.toString()?.toIntOrNull()
            positiveButton.isEnabled = currentBalance != null && amount != null && amount >= minAmount && amount <= currentBalance
        }
        positiveButton.isEnabled = false
        input.addTextChangedListener(onTextChanged = { _, _, _, _ ->
            updateButtonState()
        })
        updateButtonState()
        positiveButton.setOnClickListener {
            val amount = input.text?.toString()?.toIntOrNull() ?: return@setOnClickListener
            submitKickPredictionVote(channelLogin, outcomeId, amount)
            dialog.dismiss()
        }
    }

    private fun submitKickPredictionVote(
        channelLogin: String,
        outcomeId: String,
        amount: Int,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                kickRepository.voteKickWebPrediction(channelLogin, outcomeId, amount)
            }.onSuccess { updatedPrediction ->
                updatedPrediction?.let(viewModel::applyLocalPredictionUpdate)
                refreshKickRewardState()
                Toast.makeText(requireContext(), getString(R.string.kick_prediction_vote_submitted), Toast.LENGTH_SHORT).show()
            }.onFailure(::showKickApiError)
        }
    }

    private fun updateHeaderBadgeLayout() {
        val binding = _binding ?: return
        val row = binding.chatHeaderBadges
        val applyLayout = {
            val density = resources.displayMetrics.density
            val minWidthPx = (HEADER_BADGE_MIN_WIDTH_DP * density).roundToInt()
            val horizontalMarginPx = (HEADER_BADGE_HORIZONTAL_MARGIN_DP * density).roundToInt()
            val siblingsWidth = listOf(binding.chatDelayText, binding.pinnedGiftRestore)
                .filter { it.visibility == View.VISIBLE }
                .sumOf { view ->
                    val layoutParams = view.layoutParams as? ViewGroup.MarginLayoutParams
                    view.width + (layoutParams?.leftMargin ?: 0) + (layoutParams?.rightMargin ?: 0)
                }
            val availableWidth = (row.width - siblingsWidth - horizontalMarginPx).coerceAtLeast(minWidthPx)
            binding.chatModeText.maxWidth = availableWidth
        }
        if (row.width > 0) {
            applyLayout()
        } else {
            row.doOnLayout { applyLayout() }
        }
    }

    private fun renderRoomModeBadge() {
        val binding = _binding ?: return
        binding.chatModeText.text = roomModeBadgeText
        if (roomModeBadgeText == null) {
            binding.chatModeText.removeCallbacks(hideRoomModeBadgeRunnable)
            binding.chatModeText.isSelected = false
            binding.chatModeText.visibility = View.GONE
        }
        updateHeaderBadgeLayout()
        featureDebugLog("roomModeBadge visible=${binding.chatModeText.visibility == View.VISIBLE} text=${roomModeBadgeText ?: "-"}")
    }

    private fun buildRoomStateSignature(roomState: RoomState): String {
        return listOf(
            roomState.followers,
            roomState.slow,
            roomState.subs,
            roomState.emote,
            roomState.unique,
        ).joinToString(separator = "|") { it ?: "null" }
    }

    private fun isFeatureDebugLoggingEnabled(): Boolean {
        val ctx = context ?: return false
        return BuildConfig.DEBUG && ctx.prefs().getBoolean(C.DEBUG_KICK_CHAT_UI_LOGS, false)
    }

    private fun featureDebugLog(message: String) {
        if (isFeatureDebugLoggingEnabled()) {
            Log.d(FEATURE_LOG_TAG, message)
        }
    }

    private fun flashRoomModeBadge() {
        val b = _binding ?: return
        b.chatModeText.removeCallbacks(hideRoomModeBadgeRunnable)
        val visible = !roomModeBadgeText.isNullOrBlank()
        b.chatModeText.isSelected = visible
        b.chatModeText.visibility = if (visible) View.VISIBLE else View.GONE
        updateHeaderBadgeLayout()
        featureDebugLog("modeBadgeFlash visible=$visible text=${roomModeBadgeText ?: "-"}")
        if (visible) {
            b.chatModeText.postDelayed(hideRoomModeBadgeRunnable, HEADER_BADGE_FLASH_DURATION_MS)
        }
    }

    private fun flashHeaderBadges() {
        if (!roomModeBadgeText.isNullOrBlank()) {
            flashRoomModeBadge()
        }
        flashDelayBadge()
    }

    private fun buildRoomModeBadgeText(
        followers: String?,
        slow: String?,
        subs: String?,
        emote: String?,
        unique: String?,
    ): String? {
        val statuses = mutableListOf<String>()
        if (slow != null && slow != "0") {
            statuses += getString(
                R.string.chat_mode_slow,
                KickApiHelper.getDurationFromSeconds(requireContext(), slow)
            )
        }
        if (followers != null) {
            when (followers) {
                "-1" -> Unit
                "0" -> statuses += getString(R.string.chat_mode_followers_only)
                else -> statuses += getString(
                    R.string.chat_mode_followers_for,
                    KickApiHelper.getDurationFromSeconds(requireContext(), (followers.toInt() * 60).toString())
                )
            }
        }
        if (subs == "1") statuses += getString(R.string.chat_mode_subs_only)
        if (emote == "1") statuses += getString(R.string.chat_mode_emote_only)
        if (unique == "1") statuses += getString(R.string.chat_mode_unique)
        featureDebugLog("roomModes raw followers=$followers slow=$slow subs=$subs emote=$emote unique=$unique parsed=${statuses.joinToString(" | ").ifBlank { "-" }}")
        return statuses.takeIf { it.isNotEmpty() }?.joinToString(" • ")
    }

    private fun currentNetworkLibrary(): String? {
        return requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
    }

    private fun showKickApiError(error: Throwable) {
        Toast.makeText(requireContext(), error.message ?: getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    private fun openKickRewardsManager() {
        if (!isKickRewardsOwnerChannel() || !hasAnyKickScope("channel:rewards:read", "channel:rewards:write")) {
            requireKickRewardScopes("channel:rewards:read")
            return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                kickRepository.getOfficialChannelRewards(currentNetworkLibrary())
            }.onSuccess(::showKickRewardsManagerDialog)
                .onFailure(::showKickApiError)
        }
    }

    private fun showKickRewardsManagerDialog(rewards: List<KickOfficialReward>) {
        val labels = rewards.map(::formatKickRewardLabel).toTypedArray()
        val builder = requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.kick_manage_rewards))
            .setNegativeButton(getString(R.string.close), null)
            .setPositiveButton(getString(R.string.kick_reward_create)) { _, _ ->
                showKickRewardEditor()
            }
            .setNeutralButton(getString(R.string.refresh)) { _, _ ->
                refreshKickRewardState()
                openKickRewardsManager()
            }
        if (labels.isNotEmpty()) {
            builder.setItems(labels) { _, which ->
                rewards.getOrNull(which)?.let(::showKickRewardActionsDialog)
            }
        } else {
            builder.setMessage(getString(R.string.kick_reward_empty))
        }
        builder.show()
    }

    private fun formatKickRewardLabel(reward: KickOfficialReward): String {
        val title = reward.title ?: reward.id ?: getString(R.string.kick_manage_rewards)
        val cost = reward.cost?.toString() ?: "?"
        val extras = buildList {
            if (reward.isEnabled == false) add("disabled")
            if (reward.isPaused == true) add("paused")
        }
        return if (extras.isEmpty()) {
            "$title ($cost)"
        } else {
            "$title ($cost, ${extras.joinToString(", ")})"
        }
    }

    private fun showKickRewardActionsDialog(reward: KickOfficialReward) {
        requireContext().getAlertDialogBuilder()
            .setTitle(reward.title ?: reward.id ?: getString(R.string.kick_manage_rewards))
            .setMessage(
                buildString {
                    appendLine(getString(R.string.kick_reward_cost) + ": " + (reward.cost ?: "?"))
                    reward.description?.takeIf { it.isNotBlank() }?.let {
                        appendLine(getString(R.string.kick_reward_description) + ": $it")
                    }
                    reward.backgroundColor?.takeIf { it.isNotBlank() }?.let {
                        appendLine(getString(R.string.kick_reward_background_color) + ": $it")
                    }
                    appendLine(getString(R.string.kick_reward_enabled) + ": " + (reward.isEnabled ?: false))
                    appendLine(getString(R.string.kick_reward_paused) + ": " + (reward.isPaused ?: false))
                    append(getString(R.string.kick_reward_requires_input) + ": " + (reward.isUserInputRequired ?: false))
                }
            )
            .setPositiveButton(getString(R.string.kick_reward_edit)) { _, _ ->
                showKickRewardEditor(reward)
            }
            .setNeutralButton(getString(R.string.kick_reward_delete)) { _, _ ->
                confirmKickRewardDelete(reward)
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    private data class RewardEditorView(
        val view: View,
        val title: EditText,
        val description: EditText,
        val cost: EditText,
        val backgroundColor: EditText,
        val enabled: androidx.appcompat.widget.SwitchCompat,
        val paused: androidx.appcompat.widget.SwitchCompat?,
        val requiresInput: androidx.appcompat.widget.SwitchCompat,
        val skipQueue: androidx.appcompat.widget.SwitchCompat,
    )

    private fun showKickRewardEditor(existing: KickOfficialReward? = null) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val editor = createRewardEditorView(existing)
        requireContext().getAlertDialogBuilder()
            .setTitle(if (existing == null) getString(R.string.kick_reward_create) else getString(R.string.kick_reward_edit))
            .setView(editor.view)
            .setPositiveButton(getString(R.string.save)) { _, _ ->
                val title = editor.title.text.toString().trim()
                val description = editor.description.text.toString().trim().takeIf { it.isNotBlank() }
                val cost = editor.cost.text.toString().trim().toIntOrNull()
                val backgroundColor = editor.backgroundColor.text.toString().trim().takeIf { it.isNotBlank() }
                viewLifecycleOwner.lifecycleScope.launch {
                    runCatching {
                        if (existing == null) {
                            kickRepository.createOfficialChannelReward(
                                currentNetworkLibrary(),
                                KickOfficialRewardCreateRequest(
                                    title = title,
                                    cost = cost ?: 0,
                                    description = description,
                                    backgroundColor = backgroundColor,
                                    isEnabled = editor.enabled.isChecked,
                                    isUserInputRequired = editor.requiresInput.isChecked,
                                    shouldRedemptionsSkipRequestQueue = editor.skipQueue.isChecked,
                                )
                            )
                        } else {
                            kickRepository.updateOfficialChannelReward(
                                currentNetworkLibrary(),
                                rewardId = existing.id ?: error("Missing reward id"),
                                input = KickOfficialRewardUpdateRequest(
                                    title = title,
                                    cost = cost,
                                    description = description,
                                    backgroundColor = backgroundColor,
                                    isEnabled = editor.enabled.isChecked,
                                    isPaused = editor.paused?.isChecked,
                                    isUserInputRequired = editor.requiresInput.isChecked,
                                    shouldRedemptionsSkipRequestQueue = editor.skipQueue.isChecked,
                                )
                            )
                        }
                    }.onSuccess {
                        Toast.makeText(requireContext(), R.string.kick_rewards_saved, Toast.LENGTH_SHORT).show()
                        refreshKickRewardState()
                        openKickRewardsManager()
                    }.onFailure(::showKickApiError)
                }
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    private fun createRewardEditorView(existing: KickOfficialReward?): RewardEditorView {
        val context = requireContext()
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 16, 32, 16)
        }
        fun addField(hintRes: Int, value: String? = null, inputType: Int = InputType.TYPE_CLASS_TEXT): EditText {
            return EditText(context).apply {
                hint = getString(hintRes)
                setText(value.orEmpty())
                this.inputType = inputType
                container.addView(this)
            }
        }
        fun addSwitch(labelRes: Int, checked: Boolean): androidx.appcompat.widget.SwitchCompat {
            return androidx.appcompat.widget.SwitchCompat(context).apply {
                text = getString(labelRes)
                isChecked = checked
                container.addView(this)
            }
        }
        val title = addField(R.string.kick_reward_title, existing?.title)
        val description = addField(R.string.kick_reward_description, existing?.description)
        val cost = addField(R.string.kick_reward_cost, existing?.cost?.toString(), InputType.TYPE_CLASS_NUMBER)
        val backgroundColor = addField(R.string.kick_reward_background_color, existing?.backgroundColor)
        val enabled = addSwitch(R.string.kick_reward_enabled, existing?.isEnabled != false)
        val paused = existing?.let { addSwitch(R.string.kick_reward_paused, it.isPaused == true) }
        val requiresInput = addSwitch(R.string.kick_reward_requires_input, existing?.isUserInputRequired == true)
        val skipQueue = addSwitch(R.string.kick_reward_skip_queue, existing?.shouldRedemptionsSkipRequestQueue == true)
        return RewardEditorView(
            view = ScrollView(context).apply { addView(container) },
            title = title,
            description = description,
            cost = cost,
            backgroundColor = backgroundColor,
            enabled = enabled,
            paused = paused,
            requiresInput = requiresInput,
            skipQueue = skipQueue,
        )
    }

    private fun confirmKickRewardDelete(reward: KickOfficialReward) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val rewardId = reward.id ?: return
        requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.kick_reward_delete))
            .setMessage(reward.title ?: rewardId)
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewLifecycleOwner.lifecycleScope.launch {
                    runCatching {
                        kickRepository.deleteOfficialChannelReward(currentNetworkLibrary(), rewardId)
                    }.onSuccess {
                        Toast.makeText(requireContext(), R.string.kick_reward_deleted, Toast.LENGTH_SHORT).show()
                        refreshKickRewardState()
                        openKickRewardsManager()
                    }.onFailure(::showKickApiError)
                }
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }

    private fun openKickRedemptionsManager(status: String? = "pending", rewardId: String? = null, cursor: String? = null) {
        if (!isKickRewardsOwnerChannel() || !hasAnyKickScope("channel:rewards:read", "channel:rewards:write")) {
            requireKickRewardScopes("channel:rewards:read")
            return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                kickRepository.getOfficialRewardRedemptions(
                    networkLibrary = currentNetworkLibrary(),
                    rewardId = rewardId,
                    status = status,
                    cursor = cursor,
                )
            }.onSuccess { page ->
                showKickRedemptionsDialog(page, status, rewardId)
            }.onFailure(::showKickApiError)
        }
    }

    private fun showKickRedemptionsDialog(page: KickRewardRedemptionsPage, status: String?, rewardId: String?) {
        val visible = page.groups.flatMap { group ->
            group.redemptions.map { redemption -> (group.reward?.title ?: getString(R.string.kick_manage_redemptions)) to redemption }
        }
        val message = if (visible.isEmpty()) {
            getString(R.string.kick_redemptions_empty)
        } else {
            visible.joinToString("\n\n") { (title, redemption) -> formatKickRedemptionLabel(title, redemption) }
        }
        requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.kick_manage_redemptions))
            .setMessage(message)
            .setPositiveButton(if (visible.isNotEmpty()) getString(R.string.kick_redemption_accept) else getString(R.string.close)) { _, _ ->
                if (visible.isNotEmpty()) {
                    showKickRedemptionSelectionDialog(visible, status, rewardId)
                }
            }
            .setNeutralButton(getString(R.string.kick_redemption_filters)) { _, _ ->
                showKickRedemptionFilterDialog(status, rewardId, page.nextCursor)
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    private fun formatKickRedemptionLabel(rewardTitle: String, redemption: KickRewardRedemption): String {
        return buildString {
            append(rewardTitle)
            append(" • ")
            append(redemption.redeemer?.username ?: redemption.redeemer?.userId ?: redemption.id ?: "?")
            append(" • ")
            append(redemption.status ?: "?")
            redemption.userInput?.takeIf { it.isNotBlank() }?.let {
                append("\n")
                append(it)
            }
        }
    }

    private fun showKickRedemptionSelectionDialog(
        visible: List<Pair<String, KickRewardRedemption>>,
        status: String?,
        rewardId: String?,
    ) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val labels = visible.map { (title, redemption) -> formatKickRedemptionLabel(title, redemption) }.toTypedArray()
        val checked = BooleanArray(labels.size)
        requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.kick_manage_redemptions))
            .setMultiChoiceItems(labels, checked) { _, which, isChecked ->
                checked[which] = isChecked
            }
            .setPositiveButton(getString(R.string.kick_redemption_accept)) { _, _ ->
                updateKickSelectedRedemptions(visible, checked, true, status, rewardId)
            }
            .setNeutralButton(getString(R.string.kick_redemption_reject)) { _, _ ->
                updateKickSelectedRedemptions(visible, checked, false, status, rewardId)
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    private fun updateKickSelectedRedemptions(
        visible: List<Pair<String, KickRewardRedemption>>,
        checked: BooleanArray,
        accept: Boolean,
        status: String?,
        rewardId: String?,
    ) {
        val ids = checked.indices.mapNotNull { index ->
            visible.getOrNull(index)?.second?.id?.takeIf { checked[index] }
        }
        if (ids.isEmpty()) {
            Toast.makeText(requireContext(), R.string.kick_no_selection, Toast.LENGTH_SHORT).show()
            return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching {
                if (accept) {
                    kickRepository.acceptOfficialRewardRedemptions(currentNetworkLibrary(), ids)
                } else {
                    kickRepository.rejectOfficialRewardRedemptions(currentNetworkLibrary(), ids)
                }
            }.onSuccess { failures ->
                if (failures.isNotEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        failures.joinToString("\n") { "${it.id ?: "?"}: ${it.reason ?: "UNKNOWN"}" },
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(requireContext(), R.string.kick_redemptions_updated, Toast.LENGTH_SHORT).show()
                }
                refreshKickRewardState()
                openKickRedemptionsManager(status = status, rewardId = rewardId)
            }.onFailure(::showKickApiError)
        }
    }

    private fun showKickRedemptionFilterDialog(currentStatus: String?, rewardId: String?, nextCursor: String?) {
        viewLifecycleOwner.lifecycleScope.launch {
            val rewards = runCatching {
                kickRepository.getOfficialChannelRewards(currentNetworkLibrary())
            }.getOrDefault(emptyList())
            val options = buildList {
                nextCursor?.let { add(getString(R.string.kick_load_more)) }
                add(getString(R.string.kick_all_rewards))
                addAll(rewards.map { it.title ?: it.id ?: getString(R.string.kick_manage_rewards) })
            }
            requireContext().getAlertDialogBuilder()
                .setTitle(getString(R.string.kick_select_reward))
                .setItems(options.toTypedArray()) { _, which ->
                    if (nextCursor != null && which == 0) {
                        openKickRedemptionsManager(status = currentStatus, rewardId = rewardId, cursor = nextCursor)
                        return@setItems
                    }
                    val baseIndex = if (nextCursor != null) 1 else 0
                    val selectedRewardId = if (which == baseIndex) null else rewards.getOrNull(which - baseIndex - 1)?.id
                    showKickRedemptionStatusDialog(selectedRewardId)
                }
                .setNegativeButton(getString(R.string.close), null)
                .show()
        }
    }

    private fun showKickRedemptionStatusDialog(selectedRewardId: String?) {
        val options = arrayOf(
            getString(R.string.kick_redemption_status_all),
            getString(R.string.kick_redemption_status_pending),
            getString(R.string.kick_redemption_status_accepted),
            getString(R.string.kick_redemption_status_rejected),
        )
        requireContext().getAlertDialogBuilder()
            .setTitle(getString(R.string.kick_redemption_filters))
            .setItems(options) { _, which ->
                val selectedStatus = when (which) {
                    1 -> "pending"
                    2 -> "accepted"
                    3 -> "rejected"
                    else -> null
                }
                openKickRedemptionsManager(status = selectedStatus, rewardId = selectedRewardId)
            }
            .setNegativeButton(getString(R.string.close), null)
            .show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.integrity.collectLatest {
                    if (it != null &&
                        it != "done" &&
                        requireContext().prefs().getBoolean(C.ENABLE_INTEGRITY, false) &&
                        requireContext().prefs().getBoolean(C.USE_WEBVIEW_INTEGRITY, true)
                    ) {
                        IntegrityDialog.show(childFragmentManager, it)
                        viewModel.integrity.value = "done"
                    }
                }
            }
        }
        with(binding) {
            if (!requireContext().prefs().getBoolean(C.CHAT_DISABLE, false)) {
                val args = requireArguments()
                val channelId = args.getString(KEY_CHANNEL_ID)
                val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
                val isLive = args.getBoolean(KEY_IS_LIVE)
                val accountLogin = requireContext().tokenPrefs().getString(C.KICK_USER_LOGIN, null)
                val isLoggedIn = com.github.andreyasadchy.xtra.util.AuthStateHelper.isKickLoggedIn(requireContext())
                val chatUrl = args.getString(KEY_CHAT_URL)
                val suppressReplayUnavailable = args.getBoolean(KEY_SUPPRESS_REPLAY_UNAVAILABLE)
                val kickReplayFallback = args.getBoolean(KEY_KICK_REPLAY_FALLBACK)
                if (isLive || (args.getString(KEY_VIDEO_ID) != null && args.getInt(KEY_START_TIME) != -1) || chatUrl != null || kickReplayFallback) {
                    val enableMessaging = isLive && isLoggedIn
                    val sizeModifier = (requireContext().prefs().getInt(C.CHAT_SIZE_MODIFIER, 100).toFloat() / 100f)
                    adapter = ChatAdapter(
                        messages = viewModel.chatMessages,
                        localTwitchEmotes = viewModel.localTwitchEmotes,
                        thirdPartyEmotes = viewModel.thirdPartyEmotes,
                        globalBadges = viewModel.globalBadges,
                        channelBadges = viewModel.channelBadges,
                        cheerEmotes = viewModel.cheerEmotes,
                        namePaints = viewModel.namePaints,
                        stvBadges = viewModel.stvBadges,
                        personalEmoteSets = viewModel.personalEmoteSets,
                        stvUsers = viewModel.stvUsers,
                        enableTimestamps = requireContext().prefs().getBoolean(C.CHAT_TIMESTAMPS, false),
                        timestampFormat = requireContext().prefs().getString(C.CHAT_TIMESTAMP_FORMAT, "0"),
                        firstMsgVisibility = requireContext().prefs().getString(C.CHAT_FIRSTMSG_VISIBILITY, "0")?.toIntOrNull() ?: 0,
                        firstChatMsg = getString(R.string.chat_first),
                        redeemedChatMsg = getString(R.string.redeemed),
                        redeemedNoMsg = getString(R.string.user_redeemed),
                        rewardChatMsg = getString(R.string.chat_reward),
                        replyMessage = getString(R.string.replying_to_message),
                        useRandomColors = requireContext().prefs().getBoolean(C.CHAT_RANDOMCOLOR, true),
                        useReadableColors = requireContext().prefs().getBoolean(C.CHAT_THEME_ADAPTED_USERNAME_COLOR, true),
                        isLightTheme = requireContext().obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.isLightTheme)).use {
                            it.getBoolean(0, false)
                        },
                        nameDisplay = requireContext().prefs().getString(C.UI_NAME_DISPLAY, "1"),
                        useBoldNames = requireContext().prefs().getBoolean(C.CHAT_BOLDNAMES, false),
                        showNamePaints = requireContext().prefs().getBoolean(C.CHAT_SHOW_PAINTS, true),
                        showStvBadges = requireContext().prefs().getBoolean(C.CHAT_SHOW_STV_BADGES, true),
                        showKickBadges = requireContext().prefs().getBoolean(C.CHAT_SHOW_KICK_BADGES, true),
                        showPersonalEmotes = requireContext().prefs().getBoolean(C.CHAT_SHOW_PERSONAL_EMOTES, true),
                        enableAlternatingLineShadows = requireContext().prefs().getBoolean(C.CHAT_ALTERNATING_LINE_SHADOW, true),
                        alternatingLineShadowStrength = requireContext().prefs().getInt(
                            C.CHAT_ALTERNATING_LINE_SHADOW_STRENGTH,
                            ChatBackgroundUtils.DEFAULT_ALTERNATING_LINE_SHADOW_STRENGTH
                        ),
                        showSystemMessageEmotes = requireContext().prefs().getBoolean(C.CHAT_SYSTEM_MESSAGE_EMOTES, true),
                        chatUrl = chatUrl,
                        getEmoteBytes = viewModel::getEmoteBytes,
                        fragment = this@ChatFragment,
                        backgroundColor = MaterialColors.getColor(requireView(), com.google.android.material.R.attr.colorSurface),
                        dialogBackgroundColor = MaterialColors.getColor(
                            requireView(),
                            if (requireContext().prefs().getBoolean(C.UI_THEME_MATERIAL3, true)) {
                                com.google.android.material.R.attr.colorSurfaceContainerLow
                            } else {
                                com.google.android.material.R.attr.colorSurface
                            }
                        ),
                        imageLibrary = requireContext().prefs().getString(C.CHAT_IMAGE_LIBRARY, "0"),
                        messageTextSize = (requireContext().prefs().getString(C.CHAT_TEXT_SIZE, "14")?.toFloatOrNull() ?: 14f) * sizeModifier,
                        emoteSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (requireContext().prefs().getString(C.CHAT_EMOTE_SIZE, "29.5")?.toFloatOrNull() ?: 29.5f) * sizeModifier, resources.displayMetrics).toInt(),
                        badgeSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (requireContext().prefs().getString(C.CHAT_BADGE_SIZE, "18.5")?.toFloatOrNull() ?: 18.5f) * sizeModifier, resources.displayMetrics).toInt(),
                        emoteQuality = requireContext().prefs().getString(C.CHAT_IMAGE_QUALITY, "4") ?: "4",
                        animateGifs = requireContext().prefs().getBoolean(C.ANIMATED_EMOTES, true),
                        enableOverlayEmotes = requireContext().prefs().getBoolean(C.CHAT_ZEROWIDTH, true),
                        channelId = channelId,
                        loggedInUser = if (enableMessaging) accountLogin else null,
                        messageClickListener = { channelId, tappedMessage ->
                            if (ChatAdapterUtils.hasUserIdentity(tappedMessage)) {
                                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                                editText.clearFocus()
                                tappedMessageDialogSeed = tappedMessage
                                MessageClickedDialog.newInstance(enableMessaging, channelId, requireArguments().getString(KEY_CHANNEL_LOGIN)).show(this@ChatFragment.childFragmentManager, "messageDialog")
                            }
                        },
                        replyClickListener = {
                            (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                            editText.clearFocus()
                            ReplyClickedDialog.newInstance(enableMessaging).show(this@ChatFragment.childFragmentManager, "replyDialog")
                        },
                        imageClickListener = { url, name, format, isAnimated, source, thirdParty, emoteId ->
                            (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                            editText.clearFocus()
                            ImageClickedDialog.newInstance(url, name, format, isAnimated, source, thirdParty, emoteId).show(this@ChatFragment.childFragmentManager, "imageDialog")
                        },
                    )
                    recyclerView.let {
                        it.adapter = adapter
                        it.itemAnimator = null
                        it.layoutManager = LinearLayoutManager(context).apply { stackFromEnd = true }
                        it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                                super.onScrollStateChanged(recyclerView, newState)
                                isChatTouched = newState == RecyclerView.SCROLL_STATE_DRAGGING
                                val offset = recyclerView.computeVerticalScrollOffset()
                                if (offset < 0) {
                                    btnDown.isVisible = false
                                } else {
                                    val extent = recyclerView.computeVerticalScrollExtent()
                                    val range = recyclerView.computeVerticalScrollRange()
                                    val percentage = (100f * offset / (range - extent).toFloat())
                                    btnDown.isVisible = percentage < 100f
                                }
                                if (showChatStatus && chatStatus.isGone) {
                                    chatStatus.visibility = View.VISIBLE
                                    chatStatus.postDelayed({ chatStatus.visibility = View.GONE }, 5000)
                                }
                                if ((!roomModeBadgeText.isNullOrBlank() && chatModeText.isGone) || (delayBadgeActive && chatDelayText.isGone)) {
                                    flashHeaderBadges()
                                }
                            }
                        })
                    }
                    renderBufferedMessages()
                    renderPinnedGift()
                    renderChannelPointsButton()
                    pinnedGiftClose.setOnClickListener {
                        viewModel.dismissPinnedGift()
                    }
                    pinnedGiftExpand.setOnClickListener {
                        viewModel.togglePinnedGiftExpanded()
                    }
                    pinnedGiftRestore.setOnClickListener {
                        viewModel.restorePinnedGift()
                    }
                    btnDown.setOnClickListener {
                        view.post {
                            val lastIndex = synchronized(viewModel.chatMessages) {
                                viewModel.chatMessages.lastIndex
                            }
                            scrollChatToBottom(lastIndex)
                            it.visibility = View.GONE
                        }
                    }
                    if (enableMessaging) {
                        viewModel.loadRecentEmotes()
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.hasRecentEmotes.collectLatest {
                                    if (it) {
                                        hasRecentEmotes = true
                                    }
                                }
                            }
                        }
                        autoCompleteAdapter = AutoCompleteAdapter(
                            requireContext(),
                            R.layout.auto_complete_emotes_list_item,
                            R.id.name,
                            viewModel.autoCompleteList,
                        ).apply {
                            setNotifyOnChange(false)
                            editText.setAdapter(this)

                            var previousSize = 0
                            editText.setOnFocusChangeListener { _, hasFocus ->
                                if (hasFocus && count != previousSize) {
                                    previousSize = count
                                    notifyDataSetChanged()
                                }
                                setNotifyOnChange(hasFocus)
                            }
                        }
                        editText.addTextChangedListener(onTextChanged = { text, _, _, _ ->
                            if (text?.isNotBlank() == true) {
                                send.visibility = View.VISIBLE
                                clear.visibility = View.VISIBLE
                            } else {
                                send.visibility = View.GONE
                                clear.visibility = View.GONE
                            }
                        })
                        editText.setTokenizer(SpaceTokenizer())
                        editText.setOnKeyListener { _, keyCode, event ->
                            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                                sendMessage()
                            } else {
                                false
                            }
                        }
                        clear.setOnClickListener {
                            val text = editText.text.toString().trimEnd()
                            editText.setText(text.substring(0, max(text.lastIndexOf(' '), 0)))
                            editText.setSelection(editText.length())
                        }
                        clear.setOnLongClickListener {
                            editText.text.clear()
                            true
                        }
                        replyView.visibility = View.GONE
                        send.setOnClickListener { sendMessage() }
                        if ((view.parent?.parent?.parent?.parent as? View)?.id == R.id.slidingLayout && !requireContext().prefs().getBoolean(C.KEY_CHAT_BAR_VISIBLE, true)) {
                            messageView.visibility = View.GONE
                        } else {
                            messageView.visibility = View.VISIBLE
                        }
                        viewPager.adapter = object : FragmentStateAdapter(this@ChatFragment) {
                            override fun getItemCount(): Int = 3

                            override fun createFragment(position: Int): Fragment {
                                return EmotesFragment.newInstance(position)
                            }
                        }
                        viewPager.offscreenPageLimit = 2
                        viewPager.reduceDragSensitivity()
                        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                            tab.text = when (position) {
                                0 -> getString(R.string.recent_emotes)
                                1 -> "Kick"
                                else -> "7TV"
                            }
                        }.attach()
                        emotes.setOnClickListener {
                            //TODO add animation
                            if (emoteMenu.isGone) {
                                if (!hasRecentEmotes && viewPager.currentItem == 0) {
                                    viewPager.setCurrentItem(1, false)
                                }
                                toggleEmoteMenu(true)
                            } else {
                                toggleEmoteMenu(false)
                            }
                        }
                        messagingEnabled = true
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.channelPointsSummary.collectLatest {
                                renderChannelPointsButton()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.roomState.collectLatest { roomState ->
                                if (roomState != null) {
                                    val roomStateSignature = buildRoomStateSignature(roomState)
                                    if (roomStateSignature == lastRoomStateSignature) {
                                        viewModel.roomState.value = null
                                        return@collectLatest
                                    }
                                    lastRoomStateSignature = roomStateSignature
                                    when (roomState.emote) {
                                        "0" -> textEmote.visibility = View.GONE
                                        "1" -> textEmote.visibility = View.VISIBLE
                                    }
                                    if (roomState.followers != null) {
                                        when (roomState.followers) {
                                            "-1" -> textFollowers.visibility = View.GONE
                                            "0" -> {
                                                textFollowers.text = getString(R.string.room_followers)
                                                textFollowers.visibility = View.VISIBLE
                                            }
                                            else -> {
                                                textFollowers.text = getString(
                                                    R.string.room_followers_min,
                                                    KickApiHelper.getDurationFromSeconds(requireContext(), (roomState.followers.toInt() * 60).toString())
                                                )
                                                textFollowers.visibility = View.VISIBLE
                                            }
                                        }
                                    }
                                    when (roomState.unique) {
                                        "0" -> textUnique.visibility = View.GONE
                                        "1" -> textUnique.visibility = View.VISIBLE
                                    }
                                    if (roomState.slow != null) {
                                        when (roomState.slow) {
                                            "0" -> textSlow.visibility = View.GONE
                                            else -> {
                                                textSlow.text = getString(
                                                    R.string.room_slow,
                                                    KickApiHelper.getDurationFromSeconds(requireContext(), roomState.slow)
                                                )
                                                textSlow.visibility = View.VISIBLE
                                            }
                                        }
                                    }
                                    when (roomState.subs) {
                                        "0" -> textSubs.visibility = View.GONE
                                        "1" -> textSubs.visibility = View.VISIBLE
                                    }
                                    val updatedRoomModeBadgeText = buildRoomModeBadgeText(
                                        followers = roomState.followers,
                                        slow = roomState.slow,
                                        subs = roomState.subs,
                                        emote = roomState.emote,
                                        unique = roomState.unique,
                                    )
                                    val roomModeChanged = roomModeBadgeText != updatedRoomModeBadgeText
                                    roomModeBadgeText = updatedRoomModeBadgeText
                                    if (roomModeChanged) {
                                        renderRoomModeBadge()
                                        if (!roomModeBadgeText.isNullOrBlank()) {
                                            flashRoomModeBadge()
                                        }
                                    }
                                    showChatStatus = false
                                    chatStatus.visibility = View.GONE
                                    viewModel.roomState.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.reloadMessages.collectLatest {
                                if (it) {
                                    adapter?.let { adapter ->
                                        adapter.invalidateFormatting()
                                        val size = synchronized(viewModel.chatMessages) {
                                            viewModel.chatMessages.size
                                        }
                                        adapter.notifyItemRangeChanged(0, size, ChatAdapter.PAYLOAD_REFORMAT)
                                    }
                                    messageDialog?.adapter?.let { adapter ->
                                        adapter.invalidateFormatting()
                                        val size = synchronized(adapter.messages) {
                                            adapter.messages.size
                                        }
                                        adapter.notifyItemRangeChanged(0, size, ChatAdapter.PAYLOAD_REFORMAT)
                                    }
                                    replyDialog?.adapter?.let { adapter ->
                                        adapter.invalidateFormatting()
                                        val size = synchronized(adapter.messages) {
                                            adapter.messages.size
                                        }
                                        adapter.notifyItemRangeChanged(0, size, ChatAdapter.PAYLOAD_REFORMAT)
                                    }
                                    viewModel.reloadMessages.value = false
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pinnedGift.collectLatest {
                                renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pinnedGiftDismissed.collectLatest {
                                renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pinnedGiftExpanded.collectLatest {
                                renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.hideRaid.collectLatest {
                                if (it) {
                                    raidLayout.visibility = View.GONE
                                    viewModel.raidClosed = true
                                    viewModel.hideRaid.value = false
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.raid.collectLatest { raid ->
                                if (raid != null) {
                                    if (!viewModel.raidClosed) {
                                        if (raid.openStream) {
                                            if (requireContext().prefs().getBoolean(C.CHAT_RAIDS_AUTO_SWITCH, true) && parentFragment is PlayerFragment) {
                                                (requireActivity() as? MainActivity)?.startStream(
                                                    Stream(
                                                        source = C.KICK,
                                                        channelId = raid.targetId,
                                                        channelLogin = raid.targetLogin,
                                                        channelName = raid.targetName,
                                                        profileImageUrl = raid.targetProfileImage,
                                                    )
                                                )
                                            }
                                            raidLayout.visibility = View.GONE
                                            viewModel.raidClosed = true
                                        } else {
                                            raidLayout.visibility = View.VISIBLE
                                            raidLayout.setOnClickListener { viewModel.raidClicked.value = raid }
                                            requireContext().imageLoader.enqueue(
                                                ImageRequest.Builder(requireContext()).apply {
                                                    data(raid.targetLogo)
                                                    if (requireContext().prefs().getBoolean(C.UI_ROUNDUSERIMAGE, true)) {
                                                        transformations(CircleCropTransformation())
                                                    }
                                                    crossfade(true)
                                                    target(raidImage)
                                                }.build()
                                            )
                                            raidClose.setOnClickListener {
                                                raidLayout.visibility = View.GONE
                                                viewModel.raidClosed = true
                                            }
                                            raidText.text = getString(
                                                R.string.raid_text,
                                                if (raid.targetLogin != null && !raid.targetLogin.equals(raid.targetName, true)) {
                                                    when (requireContext().prefs().getString(C.UI_NAME_DISPLAY, "1")) {
                                                        "0" -> "${raid.targetName}(${raid.targetLogin})"
                                                        "1" -> raid.targetName
                                                        else -> raid.targetLogin
                                                    }
                                                } else {
                                                    raid.targetName
                                                },
                                                raid.viewerCount
                                            )
                                        }
                                    }
                                    viewModel.raid.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.raidClicked.collectLatest {
                                if (it != null) {
                                    (requireActivity() as? MainActivity)?.startStream(
                                        Stream(
                                            source = C.KICK,
                                            channelId = it.targetId,
                                            channelLogin = it.targetLogin,
                                            channelName = it.targetName,
                                            profileImageUrl = it.targetProfileImage,
                                        )
                                    )
                                    viewModel.raidClicked.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.hidePoll.collectLatest {
                                if (it) {
                                    pollLayout.visibility = View.GONE
                                    viewModel.pollSecondsLeft.value = null
                                    viewModel.pollTimer?.cancel()
                                    viewModel.pollClosed = true
                                    viewModel.hidePoll.value = false
                                }
                            }
                        }
                    }
                    pollClose.setOnClickListener {
                        pollLayout.visibility = View.GONE
                        viewModel.pollSecondsLeft.value = null
                        viewModel.pollTimer?.cancel()
                        viewModel.pollClosed = true
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.poll.collectLatest { poll ->
                                if (poll != null) {
                                    if (!viewModel.pollClosed) {
                                            when (poll.status) {
                                                "ACTIVE" -> {
                                                    pollLayout.visibility = View.VISIBLE
                                                    pollTitle.text = getString(R.string.poll_title, poll.title)
                                                    pollChoices.text = buildKickPollChoicesText(poll, clickable = true)
                                                pollChoices.movementMethod = LinkMovementMethod.getInstance()
                                                pollStatus.visibility = View.VISIBLE
                                                }
                                                "COMPLETED", "TERMINATED" -> {
                                                    pollLayout.visibility = View.VISIBLE
                                                    pollTitle.text = getString(R.string.poll_title, poll.title)
                                                    pollChoices.text = buildKickPollChoicesText(poll, clickable = false)
                                                pollChoices.movementMethod = null
                                                pollStatus.visibility = View.GONE
                                                viewModel.pollSecondsLeft.value = null
                                                viewModel.pollTimer?.cancel()
                                                viewModel.startPollTimeout(
                                                    delayMs = poll.resultDisplayMilliseconds?.toLong() ?: 20_000L
                                                ) {
                                                    pollLayout.visibility = View.GONE
                                                }
                                            }
                                            else -> {
                                                pollLayout.visibility = View.GONE
                                                pollChoices.movementMethod = null
                                                viewModel.pollSecondsLeft.value = null
                                                viewModel.pollTimer?.cancel()
                                                viewModel.pollClosed = true
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pollSecondsLeft.collectLatest {
                                if (it != null) {
                                    pollStatus.text = getString(R.string.remaining_time, DateUtils.formatElapsedTime(it.toLong()))
                                    if (it <= 0) {
                                        viewModel.pollSecondsLeft.value = null
                                    }
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.hidePrediction.collectLatest {
                                if (it) {
                                    predictionLayout.visibility = View.GONE
                                    predictionOutcomes.movementMethod = null
                                    viewModel.predictionSecondsLeft.value = null
                                    viewModel.predictionTimer?.cancel()
                                    viewModel.predictionClosed = true
                                    viewModel.hidePrediction.value = false
                                }
                            }
                        }
                    }
                    predictionClose.setOnClickListener {
                        predictionLayout.visibility = View.GONE
                        predictionOutcomes.movementMethod = null
                        viewModel.predictionSecondsLeft.value = null
                        viewModel.predictionTimer?.cancel()
                        viewModel.predictionClosed = true
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.prediction.collectLatest { prediction ->
                                if (prediction != null) {
                                    if (!viewModel.predictionClosed) {
                                        when (prediction.status) {
                                            "ACTIVE" -> {
                                                predictionLayout.visibility = View.VISIBLE
                                                predictionTitle.text = getString(R.string.prediction_title, prediction.title)
                                                predictionOutcomes.text = buildKickPredictionOutcomesText(prediction, clickable = true)
                                                predictionOutcomes.movementMethod = LinkMovementMethod.getInstance()
                                                predictionStatus.visibility = View.VISIBLE
                                            }
                                            "LOCKED" -> {
                                                predictionLayout.visibility = View.VISIBLE
                                                predictionTitle.text = getString(R.string.prediction_title, prediction.title)
                                                predictionOutcomes.text = buildKickPredictionOutcomesText(prediction, clickable = false)
                                                predictionOutcomes.movementMethod = null
                                                viewModel.predictionSecondsLeft.value = null
                                                viewModel.predictionTimer?.cancel()
                                                viewModel.startPredictionTimeout { predictionLayout.visibility = View.GONE }
                                                predictionStatus.visibility = View.VISIBLE
                                                predictionStatus.text = getString(R.string.prediction_locked)
                                            }
                                            "CANCELED", "CANCEL_PENDING", "RESOLVED", "RESOLVE_PENDING" -> {
                                                predictionLayout.visibility = View.VISIBLE
                                                predictionTitle.text = getString(R.string.prediction_title, prediction.title)
                                                predictionOutcomes.text = buildKickPredictionOutcomesText(prediction, clickable = false)
                                                predictionOutcomes.movementMethod = null
                                                viewModel.predictionSecondsLeft.value = null
                                                viewModel.predictionTimer?.cancel()
                                                viewModel.startPredictionTimeout { predictionLayout.visibility = View.GONE }
                                                if (prediction.status == "RESOLVED" || prediction.status == "RESOLVE_PENDING") {
                                                    val resultText = buildResolvedPredictionResultText(prediction)
                                                    if (resultText != null) {
                                                        predictionStatus.visibility = View.VISIBLE
                                                        predictionStatus.text = resultText
                                                    } else {
                                                        predictionStatus.visibility = View.GONE
                                                    }
                                                } else {
                                                    predictionStatus.visibility = View.VISIBLE
                                                    predictionStatus.text = getString(R.string.prediction_refunded)
                                                }
                                            }
                                            else -> {
                                                predictionLayout.visibility = View.GONE
                                                predictionOutcomes.movementMethod = null
                                                viewModel.predictionSecondsLeft.value = null
                                                viewModel.predictionTimer?.cancel()
                                                viewModel.predictionClosed = true
                                            }
                                        }
                                    }
                                    viewModel.prediction.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.predictionSecondsLeft.collectLatest {
                                if (it != null) {
                                    predictionStatus.text = getString(R.string.remaining_time, DateUtils.formatElapsedTime(it.toLong()))
                                    if (it <= 0) {
                                        viewModel.predictionSecondsLeft.value = null
                                    }
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.playbackMessage.collectLatest {
                                if (it != null) {
                                    if (it.live != null) {
                                        (parentFragment as? PlayerFragment)?.updateLiveStatus(it.live, it.serverTime, channelLogin)
                                    }
                                    (parentFragment as? PlayerFragment)?.updateViewerCount(it.viewers)
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.streamInfo.collectLatest {
                                if (it != null) {
                                    (parentFragment as? PlayerFragment)?.updateStreamInfo(it.title, it.gameId, null, it.gameName)
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.newMessage.collect { result ->
                                val message = result.first
                                val lastIndex = result.second
                                val removeCount = result.third
                                adapter?.let { adapter ->
                                    adapter.notifyItemInserted(lastIndex)
                                    if (removeCount > 0) {
                                        adapter.notifyItemRangeRemoved(0, removeCount)
                                        val remainingCount = synchronized(viewModel.chatMessages) {
                                            viewModel.chatMessages.size
                                        }
                                        ChatListParityUtils.rebindRangeAfterHeadRemoval(
                                            removedCount = removeCount,
                                            totalCountAfterRemoval = remainingCount
                                        )?.let {
                                            adapter.notifyItemRangeChanged(it.start, it.count, ChatAdapter.PAYLOAD_REFORMAT)
                                        }
                                    }
                                    if (!isChatTouched && binding.btnDown.isGone) {
                                        scrollChatToBottom(lastIndex - removeCount)
                                    }
                                }
                                messageDialog?.newMessage(message)
                                replyDialog?.newMessage(message)
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.addMessages.collect { result ->
                                val messages = result.first
                                val lastIndex = result.second
                                adapter?.let { adapter ->
                                    adapter.notifyItemRangeInserted(0, messages.size)
                                    val totalCount = synchronized(viewModel.chatMessages) {
                                        viewModel.chatMessages.size
                                    }
                                    ChatListParityUtils.rebindRangeAfterPrepend(
                                        insertedCount = messages.size,
                                        totalCountAfterInsert = totalCount
                                    )?.let {
                                        adapter.notifyItemRangeChanged(it.start, it.count, ChatAdapter.PAYLOAD_REFORMAT)
                                    }
                                    if (!isChatTouched && binding.btnDown.isGone) {
                                        scrollChatToBottom(lastIndex)
                                    }
                                }
                                messageDialog?.addMessages(messages)
                                replyDialog?.addMessages(messages)
                                viewModel.clearAddMessagesReplay()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.appendMessages.collect { result ->
                                val messages = result.first
                                val insertStart = result.second
                                adapter?.let { adapter ->
                                    adapter.notifyItemRangeInserted(insertStart, messages.size)
                                    if (!isChatTouched && binding.btnDown.isGone) {
                                        scrollChatToBottom(insertStart + messages.size - 1)
                                    }
                                }
                                messageDialog?.addMessages(messages)
                                replyDialog?.addMessages(messages)
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.removeMessages.collect { size ->
                                adapter?.notifyItemRangeRemoved(0, size)
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.refreshMessages.collect {
                                adapter?.notifyDataSetChanged()
                                renderBufferedMessages()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.updateUserMessages.collectLatest { userId ->
                                adapter?.let { adapter ->
                                    synchronized(viewModel.chatMessages) {
                                        viewModel.chatMessages.mapIndexedNotNull { index, message ->
                                            if (message.userId != null && message.userId == userId) {
                                                index to message
                                            } else null
                                        }
                                    }.forEach {
                                        ChatAdapterUtils.invalidatePreparedMessage(it.second)
                                        adapter.notifyItemChanged(it.first, ChatAdapter.PAYLOAD_REFORMAT)
                                    }
                                }
                                messageDialog?.updateUserMessages(userId)
                                replyDialog?.updateUserMessages(userId)
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.updateMessage.collectLatest { update ->
                                val index = update.first
                                val message = update.second
                                adapter?.let { adapter ->
                                    ChatAdapterUtils.invalidatePreparedMessage(message)
                                    adapter.notifyItemChanged(index, ChatAdapter.PAYLOAD_REFORMAT)
                                }
                                messageDialog?.updateMessage(message)
                                replyDialog?.updateMessage(message)
                            }
                        }
                    }
                    if (chatUrl != null) {
                        viewModel.startReplay(
                            channelId = channelId,
                            channelLogin = channelLogin,
                            chatUrl = chatUrl,
                            getCurrentPosition = (parentFragment as PlayerFragment)::getCurrentPosition,
                            getCurrentSpeed = (parentFragment as PlayerFragment)::getCurrentSpeed,
                            kickReplayFallback = kickReplayFallback,
                            kickReplayStartTime = args.getString(KEY_KICK_REPLAY_START_TIME),
                            kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL)
                        )
                    }
                } else {
                    if (!suppressReplayUnavailable) {
                        chatReplayUnavailable.visibility = View.VISIBLE
                    }
                }
            }
            if ((view.parent?.parent?.parent?.parent as? View)?.id != R.id.slidingLayout) {
                ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                    if (activity?.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                            bottomMargin = insets.bottom
                        }
                    }
                    WindowInsetsCompat.CONSUMED
                }
            }
        }
    }

    override fun initialize() {
        if (!requireContext().prefs().getBoolean(C.CHAT_DISABLE, false)) {
            lastRoomStateSignature = null
            val args = requireArguments()
            val channelId = args.getString(KEY_CHANNEL_ID)
            val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
            refreshKickRewardState()
            if (args.getBoolean(KEY_IS_LIVE)) {
                viewModel.startLive(requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp"), channelId, channelLogin, args.getString(KEY_CHANNEL_NAME), args.getString(KEY_STREAM_ID))
            } else {
                val videoId = args.getString(KEY_VIDEO_ID)
                val startTime = args.getInt(KEY_START_TIME)
                if ((videoId != null && startTime != -1) || args.getBoolean(KEY_KICK_REPLAY_FALLBACK)) {
                    viewModel.startReplay(
                        channelId = channelId,
                        channelLogin = channelLogin,
                        videoId = videoId,
                        startTime = startTime,
                        getCurrentPosition = (parentFragment as PlayerFragment)::getCurrentPosition,
                        getCurrentSpeed = (parentFragment as PlayerFragment)::getCurrentSpeed,
                        kickReplayFallback = args.getBoolean(KEY_KICK_REPLAY_FALLBACK),
                        kickReplayStartTime = args.getString(KEY_KICK_REPLAY_START_TIME),
                        kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL)
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        view?.post { renderBufferedMessages() }
        val args = requireArguments()
        val channelId = args.getString(KEY_CHANNEL_ID)
        val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
        if (args.getBoolean(KEY_IS_LIVE)) {
            viewModel.resumeLive(channelId, channelLogin)
        } else {
            viewModel.resumeReplay(
                channelId = channelId,
                channelLogin = channelLogin,
                chatUrl = args.getString(KEY_CHAT_URL),
                videoId = args.getString(KEY_VIDEO_ID),
                startTime = args.getInt(KEY_START_TIME),
                getCurrentPosition = (parentFragment as PlayerFragment)::getCurrentPosition,
                getCurrentSpeed = (parentFragment as PlayerFragment)::getCurrentSpeed,
                kickReplayFallback = args.getBoolean(KEY_KICK_REPLAY_FALLBACK),
                kickReplayStartTime = args.getString(KEY_KICK_REPLAY_START_TIME),
                kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL)
            )
        }
    }

    fun isActive(): Boolean? {
        return viewModel.isActive()
    }

    fun disconnect() {
        viewModel.disconnect()
    }

    fun reconnect() {
        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
        if (channelLogin != null) {
            refreshKickRewardState()
            viewModel.startLiveChat(requireArguments().getString(KEY_CHANNEL_ID), channelLogin)
            if (requireContext().prefs().getBoolean(C.CHAT_RECENT, true)) {
                viewModel.loadRecentMessages(
                    requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
                    channelLogin,
                    requireArguments().getString(KEY_CHANNEL_ID)
                )
            }
        }
        viewModel.autoReconnect = true
    }

    fun reloadEmotes() {
        viewModel.reloadEmotes(
            requireArguments().getString(KEY_CHANNEL_ID),
            requireArguments().getString(KEY_CHANNEL_LOGIN)
        )
    }

    fun startReplayChatLoad() {
        viewModel.startReplayChatLoad()
    }

    fun stopReplayChat() {
        viewModel.stopReplayChat()
    }

    fun updatePosition(position: Long) {
        viewModel.updatePosition(position)
    }

    fun updateSpeed(speed: Float) {
        viewModel.updateSpeed(speed)
    }

    fun updateStreamId(id: String?) {
        viewModel.streamId = id
    }

    fun updateLiveLatency(ms: Long) {
        if (!isAdded) return
        viewModel.setLiveLatency(ms)
        val ctx = context ?: return
        val b = _binding ?: return
        val delayMs = when (ctx.prefs().getString(C.CHAT_DELAY_MODE, "0")) {
            "1" -> ms
            "2" -> ctx.prefs().getInt(C.CHAT_DELAY_CUSTOM_SECS, 5) * 1000L
            else -> 0L
        }
        if (delayMs > 0L) {
            b.chatDelayText.text = ctx.getString(R.string.chat_delay_indicator, "%.0f".format(delayMs / 1000.0))
            delayBadgeActive = true
            featureDebugLog("delayBadge active mode=${ctx.prefs().getString(C.CHAT_DELAY_MODE, "0")} delayMs=$delayMs text=${b.chatDelayText.text}")
            if (!delayBadgeFirstShown) {
                delayBadgeFirstShown = true
                flashDelayBadge()
            }
        } else {
            delayBadgeActive = false
            delayBadgeFirstShown = false
            b.chatDelayText.removeCallbacks(hideDelayBadgeRunnable)
            b.chatDelayText.visibility = View.GONE
            updateHeaderBadgeLayout()
            featureDebugLog("delayBadge inactive mode=${ctx.prefs().getString(C.CHAT_DELAY_MODE, "0")}")
        }
    }

    private fun flashDelayBadge() {
        val ctx = context ?: return
        val b = _binding ?: return
        if (!ctx.prefs().getBoolean(C.CHAT_SHOW_DELAY_INDICATOR, true)) {
            b.chatDelayText.visibility = View.GONE
            updateHeaderBadgeLayout()
            return
        }
        b.chatDelayText.removeCallbacks(hideDelayBadgeRunnable)
        b.chatDelayText.visibility = if (delayBadgeActive) View.VISIBLE else View.GONE
        updateHeaderBadgeLayout()
        featureDebugLog("badgeFlash delayVisible=${delayBadgeActive} modeVisible=${roomModeBadgeText != null} modeText=${roomModeBadgeText ?: "-"}")
        if (delayBadgeActive) {
            b.chatDelayText.postDelayed(hideDelayBadgeRunnable, HEADER_BADGE_FLASH_DURATION_MS)
        }
    }

    fun emoteMenuIsVisible() = binding.emoteMenu.isVisible

    fun toggleEmoteMenu(enable: Boolean) {
        if (enable) {
            binding.emoteMenu.visibility = View.VISIBLE
        } else {
            binding.emoteMenu.visibility = View.GONE
        }
        toggleBackPressedCallback(enable)
    }

    fun toggleBackPressedCallback(enable: Boolean) {
        if (enable) {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedCallback)
        } else {
            backPressedCallback.remove()
        }
    }

    fun appendEmote(emote: Emote) {
        binding.editText.text.append(emote.name).append(' ')
    }

    private fun sendMessage(replyId: String? = null): Boolean {
        with(binding) {
            (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
            editText.clearFocus()
            toggleEmoteMenu(false)
            replyView.visibility = View.GONE
            send.setOnClickListener { sendMessage() }
            editText.setOnKeyListener { _, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    sendMessage()
                } else {
                    false
                }
            }
            val text = editText.text.trim()
            editText.text.clear()
            return if (text.isNotEmpty()) {
                viewModel.send(
                    message = text,
                    replyId = replyId,
                    networkLibrary = requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
                    gqlHeaders = KickApiHelper.getGQLHeaders(requireContext(), true),
                    helixHeaders = KickApiHelper.getHelixHeaders(requireContext()),
                    accountId = requireContext().tokenPrefs().getString(C.USER_ID, null),
                    channelId = requireArguments().getString(KEY_CHANNEL_ID),
                    channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                    useApiCommands = requireContext().prefs().getBoolean(C.DEBUG_API_COMMANDS, true),
                    useApiChatMessages = requireContext().prefs().getBoolean(C.DEBUG_API_CHAT_MESSAGES, true),
                    enableIntegrity = requireContext().prefs().getBoolean(C.ENABLE_INTEGRITY, false),
                )
                val lastIndex = synchronized(viewModel.chatMessages) {
                    viewModel.chatMessages.lastIndex
                }
                scrollChatToBottom(lastIndex)
                true
            } else {
                false
            }
        }
    }

    override fun onCreateMessageClickedChatAdapter(): MessageClickedChatAdapter? {
        val seed = pinnedMessageDialogSeed ?: tappedMessageDialogSeed
        pinnedMessageDialogSeed = null
        tappedMessageDialogSeed = null
        return adapter?.createMessageClickedChatAdapter(seed)
    }

    override fun onCreateReplyClickedChatAdapter(): ReplyClickedChatAdapter? {
        return adapter?.createReplyClickedChatAdapter()
    }

    override fun onLoadReplyThreadHistory(selectedMessage: ChatMessage, historyStartTimeMs: Long) {
        viewLifecycleOwner.lifecycleScope.launch {
            val messages = runCatching {
                viewModel.loadKickReplyThreadHistory(
                    channelId = requireArguments().getString(KEY_CHANNEL_ID),
                    channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                    selectedMessage = selectedMessage,
                    historyStartTimeMs = historyStartTimeMs
                )
            }.getOrDefault(emptyList())
            val activeSelectedMessage = replyDialog?.adapter?.selectedMessage
            val activeThreadParentId = activeSelectedMessage?.reply?.threadParentId
            if (activeSelectedMessage === selectedMessage ||
                (activeSelectedMessage?.id != null && activeSelectedMessage.id == selectedMessage.id) ||
                (activeThreadParentId != null && activeThreadParentId == selectedMessage.reply?.threadParentId)
            ) {
                replyDialog?.onThreadHistoryLoaded(historyStartTimeMs, messages)
            }
        }
    }

    override fun onReplyClicked(replyId: String?, userLogin: String?, userName: String?, message: String?) {
        with(binding) {
            if (!replyId.isNullOrBlank()) {
                messageDialog?.dismiss()
                replyView.visibility = View.VISIBLE
                replyText.text = message?.let {
                    val name = if (userName != null && userLogin != null && !userLogin.equals(userName, true)) {
                        when (requireContext().prefs().getString(C.UI_NAME_DISPLAY, "1")) {
                            "0" -> "${userName}(${userLogin})"
                            "1" -> userName
                            else -> userLogin
                        }
                    } else {
                        userName ?: userLogin
                    }.orEmpty()
                    getString(R.string.replying_to_message, name, message)
                } ?: run {
                    val name = userName ?: userLogin ?: ""
                    getString(R.string.replying_to_message, name, "")
                }
                replyClose.setOnClickListener {
                    replyView.visibility = View.GONE
                    send.setOnClickListener { sendMessage() }
                    editText.setOnKeyListener { _, keyCode, event ->
                        if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                            sendMessage()
                        } else {
                            false
                        }
                    }
                }
                send.setOnClickListener { sendMessage(replyId) }
                editText.setOnKeyListener { _, keyCode, event ->
                    if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                        sendMessage(replyId)
                    } else {
                        false
                    }
                }
            }
            editText.apply {
                requestFocus()
                WindowCompat.getInsetsController(this@ChatFragment.requireActivity().window, this).show(WindowInsetsCompat.Type.ime())
            }
        }
    }

    override fun onCopyMessageClicked(message: String) {
        binding.editText.setText(message)
    }

    override fun onViewProfileClicked(id: String?, login: String?, name: String?, channelLogo: String?) {
        findNavController().navigate(
            ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                channelId = id,
                channelLogin = login,
                channelName = name,
                channelLogo = channelLogo
            )
        )
        (parentFragment as? PlayerFragment)?.minimize()
    }

    override fun onNetworkRestored() {
        if (isResumed) {
            val args = requireArguments()
            val channelId = args.getString(KEY_CHANNEL_ID)
            val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
            refreshKickRewardState()
            if (args.getBoolean(KEY_IS_LIVE)) {
                viewModel.resumeLive(channelId, channelLogin)
            } else {
                viewModel.resumeReplay(
                    channelId = channelId,
                    channelLogin = channelLogin,
                    chatUrl = args.getString(KEY_CHAT_URL),
                    videoId = args.getString(KEY_VIDEO_ID),
                    startTime = args.getInt(KEY_START_TIME),
                    getCurrentPosition = (parentFragment as PlayerFragment)::getCurrentPosition,
                    getCurrentSpeed = (parentFragment as PlayerFragment)::getCurrentSpeed,
                    kickReplayFallback = args.getBoolean(KEY_KICK_REPLAY_FALLBACK),
                    kickReplayStartTime = args.getString(KEY_KICK_REPLAY_START_TIME),
                    kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL)
                )
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (!requireArguments().getBoolean(KEY_IS_LIVE) || !requireContext().prefs().getBoolean(C.PLAYER_KEEP_CHAT_OPEN, false)) {
            viewModel.stopLiveChat()
            viewModel.stopReplayChat()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    class SpaceTokenizer : MultiAutoCompleteTextView.Tokenizer {

        override fun findTokenStart(text: CharSequence, cursor: Int): Int {
            var i = cursor

            while (i > 0 && text[i - 1] != ' ') {
                i--
            }
            while (i < cursor && text[i] == ' ') {
                i++
            }

            return i
        }

        override fun findTokenEnd(text: CharSequence, cursor: Int): Int {
            var i = cursor
            val len = text.length

            while (i < len) {
                if (text[i] == ' ') {
                    return i
                } else {
                    i++
                }
            }

            return len
        }

        override fun terminateToken(text: CharSequence): CharSequence {
            return "${if (text.startsWith(':')) text.substring(1) else text} "
        }
    }

    companion object {
        private const val FEATURE_LOG_TAG = "KickChatUi"
        private const val HEADER_BADGE_FLASH_DURATION_MS = 6500L
        private const val HEADER_BADGE_HORIZONTAL_MARGIN_DP = 8
        private const val HEADER_BADGE_MIN_WIDTH_DP = 96
        private const val KEY_IS_LIVE = "isLive"
        private const val KEY_CHANNEL_ID = "channel_id"
        private const val KEY_CHANNEL_LOGIN = "channel_login"
        private const val KEY_CHANNEL_NAME = "channel_name"
        private const val KEY_STREAM_ID = "streamId"
        private const val KEY_VIDEO_ID = "videoId"
        private const val KEY_CHAT_URL = "chatUrl"
        private const val KEY_START_TIME = "startTime"
        private const val KEY_SUPPRESS_REPLAY_UNAVAILABLE = "suppressReplayUnavailable"
        private const val KEY_KICK_REPLAY_FALLBACK = "kickReplayFallback"
        private const val KEY_KICK_REPLAY_START_TIME = "kickReplayStartTime"
        private const val KEY_KICK_REPLAY_URL = "kickReplayUrl"
        private const val KEY_SOURCE = "source"

        fun newInstance(channelId: String?, channelLogin: String?, channelName: String?, streamId: String?, source: String? = null): ChatFragment {
            return ChatFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(KEY_IS_LIVE, true)
                    putString(KEY_CHANNEL_ID, channelId)
                    putString(KEY_CHANNEL_LOGIN, channelLogin)
                    putString(KEY_CHANNEL_NAME, channelName)
                    putString(KEY_STREAM_ID, streamId)
                    putString(KEY_SOURCE, source)
                }
            }
        }

        fun newInstance(
            channelId: String?,
            channelLogin: String?,
            videoId: String?,
            startTime: Int?,
            suppressReplayUnavailable: Boolean = false,
            kickReplayFallback: Boolean = false,
            kickReplayStartTime: String? = null,
            kickReplayUrl: String? = null,
            source: String? = null,
        ): ChatFragment {
            return ChatFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(KEY_IS_LIVE, false)
                    putString(KEY_CHANNEL_ID, channelId)
                    putString(KEY_CHANNEL_LOGIN, channelLogin)
                    putString(KEY_VIDEO_ID, videoId)
                    putInt(KEY_START_TIME, (startTime ?: -1))
                    putBoolean(KEY_SUPPRESS_REPLAY_UNAVAILABLE, suppressReplayUnavailable)
                    putBoolean(KEY_KICK_REPLAY_FALLBACK, kickReplayFallback)
                    putString(KEY_KICK_REPLAY_START_TIME, kickReplayStartTime)
                    putString(KEY_KICK_REPLAY_URL, kickReplayUrl)
                    putString(KEY_SOURCE, source)
                }
            }
        }

        fun newLocalInstance(channelId: String?, channelLogin: String?, chatUrl: String?, source: String? = null): ChatFragment {
            return ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_CHANNEL_ID, channelId)
                    putString(KEY_CHANNEL_LOGIN, channelLogin)
                    putString(KEY_CHAT_URL, chatUrl)
                    putString(KEY_SOURCE, source)
                }
            }
        }
    }
}
