package com.xtrakick.app.ui.chat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.SystemClock
import android.os.CountDownTimer
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.method.LinkMovementMethod
import android.text.format.DateUtils
import android.util.Log
import android.util.TypedValue
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
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
import androidx.core.widget.addTextChangedListener
import androidx.core.view.doOnLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.databinding.FragmentChatBinding
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.model.chat.Chatter
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.KickGiftTrain
import com.xtrakick.app.model.chat.Prediction
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.model.chat.RoomState
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.common.BaseNetworkFragment
import com.xtrakick.app.ui.common.IntegrityDialog
import com.xtrakick.app.ui.login.LoginActivity
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.ui.multipov.MultiPovFragment
import com.xtrakick.app.ui.player.PlayerFragment
import com.xtrakick.app.ui.view.GridAutofitLayoutManager
import com.xtrakick.app.ui.view.AutoCompleteAdapter
import com.xtrakick.app.ui.view.SlashCommand
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.chat.ChatAdapterUtils
import com.xtrakick.app.util.chat.ChatBackgroundUtils
import com.xtrakick.app.util.chat.ChatListParityUtils
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import com.google.android.material.color.MaterialColors
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.text.NumberFormat
import java.util.Date
import java.util.Locale
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

    private val rewardsUiHelper by lazy {
        KickRewardsUiHelper(
            fragment = this,
            kickRepository = kickRepository,
            getNetworkLibrary = ::currentNetworkLibrary,
            getChannelLogin = ::currentChannelLogin,
            onRewardStateChanged = ::refreshKickRewardState,
        )
    }

    private val pollPredictionUiHelper by lazy {
        KickPollPredictionUiHelper(
            fragment = this,
            kickRepository = kickRepository,
            viewModel = viewModel,
            getChannelLogin = ::currentChannelLogin,
            onRewardStateChanged = ::refreshKickRewardState,
        )
    }

    private val pinnedGiftUiHelper by lazy {
        ChatPinnedGiftUiHelper(
            fragment = this,
            viewModel = viewModel,
            getBinding = { _binding },
            getChatUrl = { requireArguments().getString(KEY_CHAT_URL) },
            onHeaderBadgesLayoutNeeded = ::updateHeaderBadgeLayout,
            onOpenPinnedHistory = { seed ->
                pinnedMessageDialogSeed = seed
                val isContentLive = requireArguments().getBoolean(KEY_IS_LIVE, false) && !isLiveRewound
                MessageClickedDialog.newInstance(
                    messagingEnabled,
                    requireArguments().getString(KEY_CHANNEL_ID),
                    requireArguments().getString(KEY_CHANNEL_LOGIN),
                    isLive = isContentLive,
                ).show(childFragmentManager, "messageDialog")
            },
        )
    }

    private var isChatTouched = false
    private var showChatStatus = false
    private var recentEmotes = emptyList<RecentEmote>()
    private var delayBadgeActive = false
    private var roomModeBadgeText: String? = null
    private var lastRoomStateSignature: String? = null
    private var delayBadgeFirstShown = false
    private var raidCountdownTimer: CountDownTimer? = null
    private var giftTrainAdapter: GiftTrainCardsAdapter? = null
    private var giftTrainTimer: CountDownTimer? = null
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
    var isLiveRewound = false
    private var pinnedMessageDialogSeed: ChatMessage? = null
    private var tappedMessageDialogSeed: ChatMessage? = null
    private var channelPointsDialog: AlertDialog? = null
    private var rebuildingChannelPointsDialog = false
    private var scrollToBottomQueued = false
    private var pendingScrollToBottomPosition: Int? = null
    private val chatPreferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        if (key in LIVE_CHAT_RENDER_SETTING_KEYS) {
            refreshLiveChatRenderSettings()
        }
        if (key == AppConstants.CHAT_DISABLE_GIFT_TRAIN_BANNER) {
            viewModel.dismissGiftTrain()
        }
    }

    private var autoCompleteAdapter: AutoCompleteAdapter? = null
    private val spaceTokenizer = SpaceTokenizer()
    private var emoteSectionAdapter: EmoteSectionAdapter? = null
    private var emoteSearchQuery = ""
    private val emoteSectionExpansion = mutableMapOf<String, Boolean>()
    private val prewarmedEmoteUrls = LinkedHashSet<String>()
    private var pickerWarmupQueued = false

    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (_binding?.autoCompleteContainer?.isVisible == true) {
                hideAutoComplete()
                return
            }
            toggleEmoteMenu(false)
        }
    }

    private val messageDialog: MessageClickedDialog?
        get() = childFragmentManager.findFragmentByTag("messageDialog") as? MessageClickedDialog

    private val replyDialog: ReplyClickedDialog?
        get() = childFragmentManager.findFragmentByTag("replyDialog") as? ReplyClickedDialog

    private fun openRaidTarget(raid: com.xtrakick.app.model.chat.Raid) {
        (requireActivity() as? MainActivity)?.startStream(
            Stream(
                source = AppConstants.KICK,
                channelId = raid.targetId,
                channelLogin = raid.targetLogin,
                channelName = raid.targetName,
                profileImageUrl = raid.targetProfileImage,
            )
        )
    }

    private fun formatRaidTargetName(raid: com.xtrakick.app.model.chat.Raid): String? {
        return if (raid.targetLogin != null && !raid.targetLogin.equals(raid.targetName, true)) {
            when (requireContext().prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                "0" -> "${raid.targetName}(${raid.targetLogin})"
                "1" -> raid.targetName
                else -> raid.targetLogin
            }
        } else {
            raid.targetName ?: raid.targetLogin
        }
    }

    private fun setRaidBannerText(raid: com.xtrakick.app.model.chat.Raid, secondsLeft: Int? = null) {
        val baseText = getString(
            R.string.raid_text,
            formatRaidTargetName(raid),
            raid.viewerCount ?: 0
        )
        binding.raidText.text = secondsLeft?.takeIf { it > 0 }?.let {
            "$baseText - switching in ${it}s"
        } ?: baseText
    }

    private fun dismissRaidBanner() {
        raidCountdownTimer?.cancel()
        raidCountdownTimer = null
        binding.raidLayout.visibility = View.GONE
        viewModel.raidClosed = true
    }

    private val chatLoginLauncher = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            val isLoggedIn = AuthStateHelper.isKickLoggedIn(requireContext())
            AuthStateHelper.notifyAuthStateChanged(isLoggedIn)
            updateMessagingState(isLoggedIn)
            if (isLoggedIn) {
                reconnect()
            }
        }
    }

    private fun configureRaidAction(raid: com.xtrakick.app.model.chat.Raid) {
        val autoSwitch = requireContext().prefs().getBoolean(AppConstants.CHAT_RAIDS_AUTO_SWITCH, true) && parentFragment is PlayerFragment
        val countdownActive = (raid.countdownSeconds ?: 0) > 0
        if (autoSwitch && countdownActive) {
            binding.raidAction.setText(R.string.raid_stay)
            binding.raidAction.setOnClickListener { dismissRaidBanner() }
        } else {
            binding.raidAction.setText(R.string.raid_join)
            binding.raidAction.setOnClickListener {
                dismissRaidBanner()
                openRaidTarget(raid)
            }
        }
    }

    private fun startRaidCountdown(raid: com.xtrakick.app.model.chat.Raid, seconds: Int) {
        raidCountdownTimer?.cancel()
        setRaidBannerText(raid, seconds)
        raidCountdownTimer = object : CountDownTimer(seconds * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                setRaidBannerText(raid, ((millisUntilFinished + 999L) / 1000L).toInt())
            }

            override fun onFinish() {
                if (requireContext().prefs().getBoolean(AppConstants.CHAT_RAIDS_AUTO_SWITCH, true) && parentFragment is PlayerFragment) {
                    dismissRaidBanner()
                    openRaidTarget(raid)
                } else {
                    raidCountdownTimer = null
                    setRaidBannerText(raid)
                    configureRaidAction(raid)
                }
            }
        }.also { it.start() }
    }

    private fun renderGiftTrain(train: KickGiftTrain?) {
        val binding = _binding ?: return
        giftTrainTimer?.cancel()
        giftTrainTimer = null
        if (train == null) {
            binding.giftTrainLayout.visibility = View.GONE
            return
        }
        binding.giftTrainLayout.visibility = View.VISIBLE
        binding.giftTrainTitle.text = buildGiftTrainTitle(train)
        giftTrainAdapter?.submit(train.gifterName, train.giftees)
        val durationMs = train.displayDurationMs
        val remainingMs = (train.lastUpdatedAtMs + durationMs - SystemClock.elapsedRealtime()).coerceIn(1L, durationMs)
        binding.giftTrainProgress.progress = ((remainingMs.toFloat() / durationMs) * binding.giftTrainProgress.max).toInt()
        giftTrainTimer = object : CountDownTimer(remainingMs, 100L) {
            override fun onTick(millisUntilFinished: Long) {
                val binding = _binding ?: return
                binding.giftTrainProgress.progress = ((millisUntilFinished.toFloat() / durationMs) * binding.giftTrainProgress.max).toInt()
            }

            override fun onFinish() {
                giftTrainTimer = null
                _binding?.giftTrainLayout?.visibility = View.GONE
            }
        }.also { it.start() }
    }

    private fun buildGiftTrainTitle(train: KickGiftTrain): CharSequence {
        val binding = _binding ?: return ""
        val gifter = train.gifterName ?: binding.root.context.getString(R.string.kick_gift_train_someone)
        val text = if (train.totalGifted > 1) {
            binding.root.context.getString(R.string.kick_gift_train_banner, gifter, train.totalGifted)
        } else {
            binding.root.context.getString(R.string.kick_gift_train_banner_one, gifter)
        }
        return SpannableStringBuilder(text).apply {
            val start = text.indexOf(gifter)
            if (start >= 0) {
                setSpan(StyleSpan(Typeface.BOLD), start, start + gifter.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                setSpan(ForegroundColorSpan(binding.root.context.getColor(R.color.giftTrainAccent)), start, start + gifter.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }

    private fun setupEmotePicker() {
        val binding = _binding ?: return
        if (emoteSectionAdapter == null) {
            emoteSectionAdapter = EmoteSectionAdapter(
                fragment = this,
                onToggle = ::toggleEmoteSection,
                onEmoteClick = ::appendEmote,
                emoteQuality = requireContext().prefs().getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4",
                imageLibrary = requireContext().prefs().getString(AppConstants.CHAT_IMAGE_LIBRARY, "0"),
            )
        }
        binding.emoteSections.itemAnimator = null
        val columnWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 52f, resources.displayMetrics).toInt()
        val gridLayoutManager = (binding.emoteSections.layoutManager as? GridAutofitLayoutManager)
            ?: GridAutofitLayoutManager(requireContext(), columnWidth)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val adapter = emoteSectionAdapter ?: return gridLayoutManager.spanCount
                return adapter.getSpanSize(position, gridLayoutManager.spanCount)
            }
        }
        binding.emoteSections.layoutManager = gridLayoutManager
        binding.emoteSections.adapter = emoteSectionAdapter
        binding.emoteSections.setHasFixedSize(true)
        binding.emoteSections.setItemViewCacheSize(64)
        if (binding.emoteSearch.tag == null) {
            binding.emoteSearch.setText(emoteSearchQuery)
            binding.emoteSearch.addTextChangedListener(onTextChanged = { text, _, _, _ ->
                val nextQuery = text?.toString().orEmpty()
                if (nextQuery != emoteSearchQuery) {
                    emoteSearchQuery = nextQuery
                    refreshEmotePickerSections()
                }
            })
            binding.emoteSearch.tag = true
        }
        refreshEmotePickerSections()
    }

    private fun toggleEmoteSection(section: EmotePickerSection) {
        if (emoteSearchQuery.isNotBlank()) return
        val expanded = emoteSectionExpansion[section.key] ?: section.expandedByDefault
        emoteSectionExpansion[section.key] = !expanded
        refreshEmotePickerSections()
    }

    private fun refreshEmotePickerSections() {
        val adapter = emoteSectionAdapter ?: return
        val hasQuery = emoteSearchQuery.isNotBlank()
        val sections = viewModel.getEmotePickerSections(recentEmotes, emoteSearchQuery).map { section ->
            section.copy(
                expanded = if (hasQuery) true else emoteSectionExpansion[section.key] ?: section.expandedByDefault
            )
        }
        adapter.submitSections(sections)
        queueEmotePickerWarmup(sections)
    }

    private fun queueEmotePickerWarmup(sections: List<EmotePickerSection>) {
        if (pickerWarmupQueued || sections.isEmpty()) return
        pickerWarmupQueued = true
        binding.emoteSections.post {
            pickerWarmupQueued = false
            prewarmEmotePickerAssets(sections)
        }
    }

    private fun prewarmEmotePickerAssets(sections: List<EmotePickerSection>) {
        val context = context ?: return
        val quality = context.prefs().getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4"
        val warmupCandidates = sections
            .take(4)
            .flatMapIndexed { index, section ->
                section.emotes.take(if (index == 0) 18 else 10)
            }
            .distinctBy { it.name }
            .take(36)

        warmupCandidates.forEach { emote ->
            val url = when (quality) {
                "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                "2" -> emote.url2x ?: emote.url1x
                else -> emote.url1x
            } ?: return@forEach
            if (!prewarmedEmoteUrls.add(url)) {
                return@forEach
            }
            context.imageLoader.enqueue(
                ImageRequest.Builder(context).apply {
                    data(url)
                    size(40.dp(), 40.dp())
                    if (emote.thirdParty) {
                        httpHeaders(
                            NetworkHeaders.Builder()
                                .add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                                .build()
                        )
                    }
                    crossfade(false)
                }.build()
            )
        }
    }

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

    private fun setScrollDownButtonVisible(visible: Boolean) {
        val btn = _binding?.btnDown ?: return
        if (visible) {
            if (btn.isGone || btn.alpha < 0.9f) {
                btn.animate().cancel()
                btn.visibility = View.VISIBLE
                btn.scaleX = 0.8f
                btn.scaleY = 0.8f
                btn.alpha = 0f
                btn.animate()
                    .alpha(1f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(160L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        } else if (btn.isVisible && btn.alpha > 0.05f) {
            btn.animate().cancel()
            btn.animate()
                .alpha(0f)
                .scaleX(0.8f)
                .scaleY(0.8f)
                .setDuration(120L)
                .setInterpolator(DecelerateInterpolator())
                .withEndAction {
                    btn.visibility = View.GONE
                    btn.scaleX = 1f
                    btn.scaleY = 1f
                }
                .start()
        }
    }

    private fun scrollChatToBottom(position: Int) {
        val binding = _binding ?: return
        if (position < 0) return
        pendingScrollToBottomPosition = position
        if (scrollToBottomQueued) return
        scrollToBottomQueued = true
        val recyclerView = binding.recyclerView
        recyclerView.post {
            val activeBinding = _binding ?: return@post
            scrollToBottomQueued = false
            val targetPosition = pendingScrollToBottomPosition ?: return@post
            pendingScrollToBottomPosition = null
            activeBinding.recyclerView.scrollToPosition(targetPosition)
            activeBinding.recyclerView.doOnLayout { view ->
                val laidOutRecyclerView = view as? RecyclerView ?: return@doOnLayout
                if (laidOutRecyclerView.canScrollVertically(1)) {
                    laidOutRecyclerView.scrollBy(0, laidOutRecyclerView.computeVerticalScrollRange())
                }
            }
        }
    }

    private fun currentChannelLogin(): String? {
        return requireArguments().getString(KEY_CHANNEL_LOGIN)
    }

    private fun refreshKickRewardState() {
        if (!currentChatSource().equals(AppConstants.KICK, true)) {
            return
        }
        viewModel.refreshKickChannelPointState(
            networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
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
        val isKickChat = currentChatSource().equals(AppConstants.KICK, true)
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
            if (currentChatSource().equals(AppConstants.KICK, true) &&
                rewardsUiHelper.isKickRewardsOwnerChannel() &&
                rewardsUiHelper.hasAnyKickScope("channel:rewards:read", "channel:rewards:write")
            ) {
                rewardsUiHelper.showKickChannelPointActionsDialog()
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
        reward: com.xtrakick.app.model.chat.ChannelPointReward,
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
                        setText(R.string.chat_reward_input_required_abbreviation)
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

    private fun isPastPrediction(prediction: Prediction): Boolean {
        return when (prediction.status) {
            "RESOLVED", "RESOLVE_PENDING", "CANCELED", "CANCEL_PENDING" -> true
            "ACTIVE", "LOCKED" -> false
            else -> prediction.endedAt != null
        }
    }

    private fun predictionFinishedAt(prediction: Prediction): Long? {
        return prediction.endedAt ?: prediction.createdAt?.let { createdAt ->
            prediction.predictionWindowSeconds?.let { duration -> createdAt + (duration * 1000L) }
        }
    }

    private fun formatPredictionFinishedAt(prediction: Prediction): String? {
        val finishedAt = predictionFinishedAt(prediction) ?: return null
        return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(Date(finishedAt))
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
        val won = selectedOutcome?.isWinner == true || (prediction.winningOutcomeId != null && prediction.winningOutcomeId == userVote.outcomeId)
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


    private fun createChannelPointsPredictionCard(
        prediction: Prediction,
        compact: Boolean = false,
    ): View {
        val context = requireContext()
        val surfaceBaseColor = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainerHighest, Color.DKGRAY)
        val surfaceColor = ColorUtils.blendARGB(surfaceBaseColor, Color.WHITE, 0.06f)
        val onSurfaceVariant = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY)
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.WHITE)
        val titleText = prediction.title?.takeIf { it.isNotBlank() }
            ?: getString(R.string.channel_points_prediction_fallback_title)
        val summaryText = buildChannelPointsPredictionSummaryText(prediction)
        val totalPoints = prediction.outcomes.orEmpty().sumOf { it.totalPoints?.toLong() ?: 0L }
        val resolved = prediction.status == "RESOLVED" || prediction.status == "RESOLVE_PENDING"
        val selectedOutcomeId = prediction.userVote?.outcomeId
        val pastPrediction = isPastPrediction(prediction)
        val metaText = buildString {
            append(getString(if (pastPrediction) R.string.channel_points_prediction_past_label else R.string.channel_points_prediction_current_label))
            formatPredictionFinishedAt(prediction)?.let {
                append('\n')
                append(getString(R.string.channel_points_prediction_closed_at, it))
            } ?: run {
                append('\n')
                append(buildChannelPointsPredictionStatusText(prediction))
            }
            append('\n')
            append(getString(R.string.channel_points_prediction_pool, formatCompactPoints(totalPoints)))
        }
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 12.dp().toFloat()
                setColor(surfaceColor)
                setStroke(1.dp(), ColorUtils.setAlphaComponent(Color.WHITE, 42))
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
                text = metaText
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                setTextColor(onSurfaceVariant)
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

            val outcomes = prediction.outcomes.orEmpty()
            val visibleOutcomes = if (compact) {
                outcomes.filter { outcome ->
                    resolved && (outcome.isWinner == true || (prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id))
                }.ifEmpty {
                    outcomes.take(1)
                }
            } else {
                outcomes
            }
            visibleOutcomes.forEach { outcome ->
                val isSelected = selectedOutcomeId != null && outcome.id == selectedOutcomeId
                val isWinner = resolved && (outcome.isWinner == true || (prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id))
                val percent = (((outcome.totalPoints ?: 0).toLong() * 100.0) / max(totalPoints, 1)).roundToInt()
                val details = listOfNotNull(
                    getString(R.string.channel_points_prediction_percent, percent),
                    getString(R.string.channel_points_prediction_points_short, outcome.totalPoints?.let { NumberFormat.getInstance().format(it) }),
                    getString(R.string.channel_points_prediction_votes_short, outcome.totalUsers?.let { NumberFormat.getInstance().format(it) }),
                    formatPredictionOdds(outcome.returnRate),
                ).joinToString("  ")
                addView(LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                    if (isWinner || isSelected) {
                        background = GradientDrawable().apply {
                            shape = GradientDrawable.RECTANGLE
                            cornerRadius = 8.dp().toFloat()
                            if (isWinner) {
                                setColor(ColorUtils.setAlphaComponent(primaryColor, 34))
                                setStroke(1.dp(), ColorUtils.setAlphaComponent(primaryColor, 120))
                            } else {
                                setColor(ColorUtils.setAlphaComponent(Color.WHITE, 24))
                            }
                        }
                    }
                    setPadding(if (isWinner || isSelected) 8.dp() else 0, 7.dp(), if (isWinner || isSelected) 8.dp() else 0, 7.dp())
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        topMargin = 6.dp()
                    }
                    addView(TextView(context).apply {
                        text = if (isWinner) {
                            getString(R.string.channel_points_prediction_outcome_winner_title, outcome.title)
                        } else {
                            outcome.title
                        }
                        setTypeface(typeface, if (isWinner || isSelected) Typeface.BOLD else Typeface.NORMAL)
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                    })
                    addView(TextView(context).apply {
                        text = details
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodySmall)
                        setTextColor(onSurfaceVariant)
                        setPadding(0, 2.dp(), 0, 0)
                    })
                })
            }
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
        val screenHeight = resources.displayMetrics.heightPixels
        val isWideViewport = screenWidth > screenHeight
        val useCompactPrediction = isWideViewport && prediction != null
        val useWidePanels = useCompactPrediction && screenWidth >= 700.dp()
        val landscapeHeightLimit = (screenHeight - 24.dp()).coerceAtLeast(240.dp())
        val landscapeScrollableHeight = (landscapeHeightLimit - 112.dp()).coerceAtLeast(160.dp())
        val dialogWidth = (
            if (isWideViewport) {
                (screenWidth * 0.72f).roundToInt()
            } else {
                screenWidth - 16.dp()
            }
            ).coerceAtLeast(if (isWideViewport) 520.dp() else 280.dp())
            .coerceAtMost(screenWidth - 16.dp())
        val tileColumns = 3
        // AlertDialog adds its own horizontal insets around a custom view, so reserve space for them
        // before dividing the remaining width into equal tiles.
        val rewardsWidth = if (useWidePanels) {
            ((dialogWidth - 48.dp() - (dialogHorizontalPadding * 2) - 12.dp()) * 0.48f).roundToInt()
        } else {
            dialogWidth - 48.dp() - (dialogHorizontalPadding * 2)
        }
        val tileWidth = (
            rewardsWidth - (tileGap * (tileColumns - 1))
            ).div(tileColumns)
            .coerceAtLeast(if (useWidePanels) 58.dp() else 72.dp())
        val dialogContent = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dialogHorizontalPadding, 10.dp(), dialogHorizontalPadding, 6.dp())
        }
        val closeButton = TextView(context).apply {
            text = getString(R.string.close)
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_TitleMedium)
            setTextColor(MaterialColors.getColor(context, androidx.appcompat.R.attr.colorAccent, Color.WHITE))
            gravity = android.view.Gravity.CENTER
            setPadding(18.dp(), 6.dp(), 0, 8.dp())
        }
        dialogContent.addView(LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = android.view.Gravity.CENTER_VERTICAL
            setPadding(0, 0, 0, 8.dp())
            addView(TextView(context).apply {
                text = getString(R.string.channel_points_rewards_title)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_HeadlineSmall)
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                )
            })
            addView(closeButton)
        })
        val scrollContent = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
        val content = LinearLayout(context).apply {
            orientation = if (useWidePanels) LinearLayout.HORIZONTAL else LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        val rewardsContent = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            if (useWidePanels) {
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                ).apply {
                    leftMargin = 12.dp()
                }
            }
        }
        prediction?.let {
            val predictionView = createChannelPointsPredictionCard(it, compact = useCompactPrediction && !useWidePanels)
            if (useWidePanels) {
                content.addView(predictionView.apply {
                    layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.08f
                    )
                })
            } else {
                content.addView(predictionView)
            }
        }
        rewardsContent.addView(TextView(context).apply {
            text = balanceText
            setTypeface(typeface, Typeface.BOLD)
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyLarge)
            setPadding(0, 0, 0, 10.dp())
        })
        val rewardsContainer = GridLayout(context).apply {
            columnCount = tileColumns
            useDefaultMargins = false
            alignmentMode = GridLayout.ALIGN_BOUNDS
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        rewardsContent.addView(rewardsContainer)
        content.addView(rewardsContent)
        scrollContent.addView(content)
        dialogContent.addView(ScrollView(context).apply {
            isFillViewport = true
            overScrollMode = View.OVER_SCROLL_IF_CONTENT_SCROLLS
            if (isWideViewport) {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    landscapeScrollableHeight
                )
            } else {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            addView(scrollContent)
        })
        val builder = context.getAlertDialogBuilder()
            .setView(dialogContent)
        if (rewards.isEmpty()) {
            rewardsContainer.addView(TextView(context).apply {
                text = getString(R.string.channel_points_rewards_unavailable)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                setTextColor(MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY))
                layoutParams = GridLayout.LayoutParams().apply {
                    width = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(0, 2)
                }
            })
        }
        if (currentChatSource().equals(AppConstants.KICK, true) &&
            rewardsUiHelper.isKickRewardsOwnerChannel() &&
            rewardsUiHelper.hasAnyKickScope("channel:rewards:read", "channel:rewards:write")
        ) {
            builder
                .setPositiveButton(getString(R.string.kick_manage_rewards)) { _, _ ->
                    rewardsUiHelper.openRewardsManager()
                }
                .setNeutralButton(getString(R.string.kick_manage_redemptions)) { _, _ ->
                    rewardsUiHelper.openRedemptionsManager()
                }
        }
        val dialog = builder.show()
        closeButton.setOnClickListener {
            dialog.dismiss()
        }
        channelPointsDialog = dialog
        dialog.setOnDismissListener {
            if (channelPointsDialog === dialog) {
                channelPointsDialog = null
            }
        }
        if (rewards.isNotEmpty()) {
            rewards.forEach { reward ->
                rewardsContainer.addView(createViewerRewardTile(reward, tileWidth) {
                    dialog.dismiss()
                    showViewerKickRewardRedeemDialog(reward)
                })
            }
        }
        dialog.window?.setLayout(
            dialogWidth,
            if (isWideViewport) landscapeHeightLimit else WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.decorView?.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
            if (channelPointsDialog === dialog && (resources.displayMetrics.widthPixels > resources.displayMetrics.heightPixels) != isWideViewport) {
                rebuildChannelPointsDialogAfterLayoutChange()
            }
        }
    }

    private fun rebuildChannelPointsDialogAfterLayoutChange() {
        if (channelPointsDialog?.isShowing == true && !rebuildingChannelPointsDialog) {
            rebuildingChannelPointsDialog = true
            channelPointsDialog?.dismiss()
            _binding?.root?.post {
                rebuildingChannelPointsDialog = false
                if (_binding != null && isAdded) {
                    showChannelPointRewardsDialog()
                }
            }
        }
    }


    private fun showViewerKickRewardRedeemDialog(reward: com.xtrakick.app.model.chat.ChannelPointReward) {
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
        return BuildConfig.DEBUG && ctx.prefs().getBoolean(AppConstants.DEBUG_KICK_CHAT_UI_LOGS, false)
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
        return requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
    }

    private fun showKickApiError(error: Throwable) {
        Toast.makeText(requireContext(), error.message ?: getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext().prefs().registerOnSharedPreferenceChangeListener(chatPreferenceChangeListener)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.integrity.collectLatest {
                    if (it != null &&
                        it != "done" &&
                        requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                        requireContext().prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
                    ) {
                        IntegrityDialog.show(childFragmentManager, it)
                        viewModel.integrity.value = "done"
                    }
                }
            }
        }
        with(binding) {
            if (!requireContext().prefs().getBoolean(AppConstants.CHAT_DISABLE, false)) {
                val args = requireArguments()
                val channelId = args.getString(KEY_CHANNEL_ID)
                val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
                val isLive = args.getBoolean(KEY_IS_LIVE)
                val accountLogin = requireContext().tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)
                val isLoggedIn = AuthStateHelper.isKickLoggedIn(requireContext())
                val chatUrl = args.getString(KEY_CHAT_URL)
                val suppressReplayUnavailable = args.getBoolean(KEY_SUPPRESS_REPLAY_UNAVAILABLE)
                val kickReplayFallback = args.getBoolean(KEY_KICK_REPLAY_FALLBACK)
                if (isLive || (args.getString(KEY_VIDEO_ID) != null && args.getInt(KEY_START_TIME) != -1) || chatUrl != null || kickReplayFallback) {
                    val enableMessaging = isLive && isLoggedIn
                    val liveSettings = createLiveChatRenderSettings()
                    adapter = ChatAdapter(
                        messages = viewModel.chatMessages,
                        localChatEmotes = viewModel.localChatEmotes,
                        thirdPartyEmotes = viewModel.thirdPartyEmotes,
                        globalBadges = viewModel.globalBadges,
                        channelBadges = viewModel.channelBadges,
                        cheerEmotes = viewModel.cheerEmotes,
                        namePaints = viewModel.namePaints,
                        stvBadges = viewModel.stvBadges,
                        personalEmoteSets = viewModel.personalEmoteSets,
                        stvUsers = viewModel.stvUsers,
                        enableTimestamps = liveSettings.enableTimestamps,
                        timestampFormat = liveSettings.timestampFormat,
                        firstMsgVisibility = liveSettings.firstMsgVisibility,
                        firstChatMsg = getString(R.string.chat_first),
                        redeemedChatMsg = getString(R.string.redeemed),
                        redeemedNoMsg = getString(R.string.user_redeemed),
                        rewardChatMsg = getString(R.string.chat_reward),
                        replyMessage = getString(R.string.replying_to_message),
                        useRandomColors = liveSettings.useRandomColors,
                        useReadableColors = liveSettings.useReadableColors,
                        isLightTheme = requireContext().obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.isLightTheme)).use {
                            it.getBoolean(0, false)
                        },
                        nameDisplay = requireContext().prefs().getString(AppConstants.UI_NAME_DISPLAY, "1"),
                        useBoldNames = liveSettings.useBoldNames,
                        showNamePaints = liveSettings.showNamePaints,
                        showStvBadges = liveSettings.showStvBadges,
                        showKickBadges = liveSettings.showKickBadges,
                        showPersonalEmotes = liveSettings.showPersonalEmotes,
                        enableAlternatingLineShadows = liveSettings.enableAlternatingLineShadows,
                        alternatingLineShadowStrength = liveSettings.alternatingLineShadowStrength,
                        showSystemMessageEmotes = liveSettings.showSystemMessageEmotes,
                        chatUrl = chatUrl,
                        getEmoteBytes = viewModel::getEmoteBytes,
                        fragment = this@ChatFragment,
                        backgroundColor = MaterialColors.getColor(requireView(), com.google.android.material.R.attr.colorSurface),
                        dialogBackgroundColor = MaterialColors.getColor(
                            requireView(),
                            if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
                                com.google.android.material.R.attr.colorSurfaceContainerLow
                            } else {
                                com.google.android.material.R.attr.colorSurface
                            }
                        ),
                        imageLibrary = liveSettings.imageLibrary,
                        messageTextSize = liveSettings.messageTextSize,
                        emoteSize = liveSettings.emoteSize,
                        badgeSize = liveSettings.badgeSize,
                        emoteQuality = liveSettings.emoteQuality,
                        animateGifs = liveSettings.animateGifs,
                        animatedEmoteFps = liveSettings.animatedEmoteFps,
                        enableOverlayEmotes = liveSettings.enableOverlayEmotes,
                        channelId = channelId,
                        loggedInUser = if (enableMessaging) accountLogin else null,
                        messageClickListener = { channelId, tappedMessage ->
                            if (ChatAdapterUtils.hasUserIdentity(tappedMessage)) {
                                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                                editText.clearFocus()
                                tappedMessageDialogSeed = tappedMessage
                                val isContentLive = isLive && !isLiveRewound
                                val canMessage = isContentLive && AuthStateHelper.isKickLoggedIn(requireContext())
                                MessageClickedDialog.newInstance(
                                    canMessage,
                                    channelId,
                                    requireArguments().getString(KEY_CHANNEL_LOGIN),
                                    isLive = isContentLive,
                                ).show(this@ChatFragment.childFragmentManager, "messageDialog")
                            }
                        },
                        replyClickListener = {
                            (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                            editText.clearFocus()
                            val canMessage = isLive && AuthStateHelper.isKickLoggedIn(requireContext())
                            ReplyClickedDialog.newInstance(canMessage).show(this@ChatFragment.childFragmentManager, "replyDialog")
                        },
                        imageClickListener = { url, name, format, isAnimated, source, thirdParty, emoteId ->
                            (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(editText.windowToken, 0)
                            editText.clearFocus()
                            if (this@ChatFragment.childFragmentManager.findFragmentByTag("imageDialog") == null) {
                                ImageClickedDialog.newInstance(url, name, format, isAnimated, source, thirdParty, emoteId).show(this@ChatFragment.childFragmentManager, "imageDialog")
                            }
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
                                    setScrollDownButtonVisible(false)
                                } else {
                                    val extent = recyclerView.computeVerticalScrollExtent()
                                    val range = recyclerView.computeVerticalScrollRange()
                                    val percentage = (100f * offset / (range - extent).toFloat())
                                    setScrollDownButtonVisible(percentage < 100f)
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
                    pinnedGiftUiHelper.renderPinnedGift()
                    renderChannelPointsButton()
                    giftTrainAdapter = GiftTrainCardsAdapter()
                    binding.giftTrainCards.apply {
                        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                        adapter = giftTrainAdapter
                    }
                    binding.giftTrainClose.setOnClickListener {
                        viewModel.dismissGiftTrain()
                    }
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
                        hideAutoComplete()
                        view.post {
                            val lastIndex = synchronized(viewModel.chatMessages) {
                                viewModel.chatMessages.lastIndex
                            }
                            scrollChatToBottom(lastIndex)
                            setScrollDownButtonVisible(false)
                        }
                    }
                    editText.setOnFocusChangeListener { _, hasFocus ->
                        if (!hasFocus) {
                            hideAutoComplete()
                        } else {
                            updateAutoComplete(editText.text)
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
                        updateAutoComplete(text)
                    })
                    editText.setTokenizer(spaceTokenizer)
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
                        hideAutoComplete()
                    }
                    clear.setOnLongClickListener {
                        editText.text.clear()
                        hideAutoComplete()
                        true
                    }
                    replyView.visibility = View.GONE
                    send.setOnClickListener { sendMessage() }
                    emotes.setOnClickListener {
                        if (emoteMenu.isGone) {
                            toggleEmoteMenu(true)
                        } else {
                            toggleEmoteMenu(false)
                        }
                    }
                    if (BuildConfig.DEBUG) {
                        emotes.setOnLongClickListener {
                            viewModel.simulateGiftTrain()
                            true
                        }
                    }
                    btnGuestLoginChat.setOnClickListener {
                        chatLoginLauncher.launch(Intent(requireContext(), LoginActivity::class.java))
                    }

                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.recentEmotes.collectLatest {
                                recentEmotes = it
                                refreshEmotePickerSections()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.userEmotesUpdated.collectLatest {
                                refreshEmotePickerSections()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.thirdPartyEmotesUpdated.collectLatest {
                                refreshEmotePickerSections()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.kickEmoteGroups.collectLatest {
                                refreshEmotePickerSections()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            AuthStateHelper.authStateChanged.collectLatest { loggedIn ->
                                updateMessagingState(loggedIn)
                                if (loggedIn) {
                                    reconnect()
                                }
                            }
                        }
                    }

                    updateMessagingState(isLoggedIn)
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.channelPointsSummary.collectLatest {
                                renderChannelPointsButton()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.kickViewerCount.collectLatest { update ->
                                if (update != null) {
                                    (parentFragment as? PlayerFragment)?.updateViewerCount(update.first, updatedAt = update.second)
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.roomState.collectLatest { roomState ->
                                if (roomState != null) {
                                    val roomStateSignature = buildRoomStateSignature(roomState)
                                    if (roomStateSignature == lastRoomStateSignature) {
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
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.chatRestriction.collectLatest { restriction ->
                                editText.hint = restriction?.inputHint
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
                                pinnedGiftUiHelper.renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pinnedGiftDismissed.collectLatest {
                                pinnedGiftUiHelper.renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.pinnedGiftExpanded.collectLatest {
                                pinnedGiftUiHelper.renderPinnedGift()
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.giftTrain.collectLatest { train ->
                                renderGiftTrain(train)
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.hideRaid.collectLatest {
                                if (it) {
                                    dismissRaidBanner()
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
                                            if (requireContext().prefs().getBoolean(AppConstants.CHAT_RAIDS_AUTO_SWITCH, true) && parentFragment is PlayerFragment) {
                                                openRaidTarget(raid)
                                            }
                                            raidLayout.visibility = View.GONE
                                            viewModel.raidClosed = true
                                        } else {
                                            raidCountdownTimer?.cancel()
                                            raidCountdownTimer = null
                                            raidLayout.visibility = View.VISIBLE
                                            raidLayout.setOnClickListener { viewModel.raidClicked.value = raid }
                                            requireContext().imageLoader.enqueue(
                                                ImageRequest.Builder(requireContext()).apply {
                                                    data(raid.targetLogo)
                                                    if (requireContext().prefs().getBoolean(AppConstants.UI_ROUNDUSERIMAGE, true)) {
                                                        transformations(CircleCropTransformation())
                                                    }
                                                    crossfade(true)
                                                    target(raidImage)
                                                }.build()
                                            )
                                            raidClose.setOnClickListener {
                                                dismissRaidBanner()
                                            }
                                            configureRaidAction(raid)
                                            val countdownSeconds = raid.countdownSeconds
                                            if (countdownSeconds != null && countdownSeconds > 0) {
                                                startRaidCountdown(raid, countdownSeconds)
                                            } else {
                                                setRaidBannerText(raid)
                                            }
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
                                    raidCountdownTimer?.cancel()
                                    raidCountdownTimer = null
                                    openRaidTarget(it)
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
                                                    pollChoices.text = pollPredictionUiHelper.buildKickPollChoicesText(poll, clickable = true)
                                                pollChoices.movementMethod = LinkMovementMethod.getInstance()
                                                pollStatus.visibility = View.VISIBLE
                                                }
                                                "COMPLETED", "TERMINATED" -> {
                                                    pollLayout.visibility = View.VISIBLE
                                                    pollTitle.text = getString(R.string.poll_title, poll.title)
                                                    pollChoices.text = pollPredictionUiHelper.buildKickPollChoicesText(poll, clickable = false)
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
                                                predictionOutcomes.text = pollPredictionUiHelper.buildKickPredictionOutcomesText(prediction, clickable = true)
                                                predictionOutcomes.movementMethod = LinkMovementMethod.getInstance()
                                                predictionStatus.visibility = View.VISIBLE
                                            }
                                            "LOCKED" -> {
                                                predictionLayout.visibility = View.VISIBLE
                                                predictionTitle.text = getString(R.string.prediction_title, prediction.title)
                                                predictionOutcomes.text = pollPredictionUiHelper.buildKickPredictionOutcomesText(prediction, clickable = false)
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
                                                predictionOutcomes.text = pollPredictionUiHelper.buildKickPredictionOutcomesText(prediction, clickable = false)
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
                            viewModel.newMessage.collect { result ->
                                val message = result.first
                                val lastIndex = result.second
                                val removeCount = result.third
                                adapter?.let { adapter ->
                                    // Positions are computed pre-emit; a seek reset can clear the
                                    // list mid-flight and leave them stale. Fall back to a full
                                    // rebind instead of a range RecyclerView cannot reconcile.
                                    val liveSize = synchronized(viewModel.chatMessages) {
                                        viewModel.chatMessages.size
                                    }
                                    if (removeCount > 0) {
                                        runCatching {
                                            adapter.notifyItemRangeRemoved(0, removeCount)
                                        }.onFailure {
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                    val appendPosition = ChatListParityUtils.appendPositionAfterHeadRemoval(lastIndex, removeCount)
                                    if (appendPosition < 0 || appendPosition >= liveSize) {
                                        adapter.notifyDataSetChanged()
                                    } else {
                                        runCatching {
                                            adapter.notifyItemInserted(appendPosition)
                                        }.onFailure {
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                    if (!isChatTouched && binding.btnDown.isGone && liveSize > 0) {
                                        scrollChatToBottom(liveSize - 1)
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
                                    // Same staleness hazard as newMessage: a seek reset between
                                    // the buffer write and this collection invalidates insertStart.
                                    val liveSize = synchronized(viewModel.chatMessages) {
                                        viewModel.chatMessages.size
                                    }
                                    if (messages.isNotEmpty() && insertStart >= 0 && insertStart + messages.size <= liveSize) {
                                        runCatching {
                                            adapter.notifyItemRangeInserted(insertStart, messages.size)
                                        }.onFailure {
                                            adapter.notifyDataSetChanged()
                                        }
                                    } else {
                                        adapter.notifyDataSetChanged()
                                    }
                                    if (!isChatTouched && binding.btnDown.isGone && liveSize > 0) {
                                        scrollChatToBottom((insertStart + messages.size - 1).coerceIn(0, liveSize - 1))
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
                                adapter?.let { adapter ->
                                    if (size > 0) {
                                        runCatching {
                                            adapter.notifyItemRangeRemoved(0, size)
                                        }.onFailure {
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.refreshMessages.collect {
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
                            kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL),
                            isClipReplay = args.getBoolean(KEY_IS_CLIP_REPLAY),
                            isPlaybackPlaying = (parentFragment as PlayerFragment)::isPlaybackPlaying
                        )
                    }
                } else {
                    if (!suppressReplayUnavailable) {
                        chatReplayUnavailable.visibility = View.VISIBLE
                    }
                }
            }
            val isPlayerContext = parentFragment is PlayerFragment || parentFragment is MultiPovFragment || (view.parent?.parent?.parent?.parent as? View)?.id == R.id.slidingLayout
            if (!isPlayerContext) {
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
        if (!requireContext().prefs().getBoolean(AppConstants.CHAT_DISABLE, false)) {
            lastRoomStateSignature = null
            val args = requireArguments()
            val channelId = args.getString(KEY_CHANNEL_ID)
            val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
            refreshKickRewardState()
            if (args.getBoolean(KEY_IS_LIVE)) {
                viewModel.startLive(requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), channelId, channelLogin, args.getString(KEY_CHANNEL_NAME), args.getString(KEY_STREAM_ID))
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
                        kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL),
                        isClipReplay = args.getBoolean(KEY_IS_CLIP_REPLAY),
                        isPlaybackPlaying = (parentFragment as PlayerFragment)::isPlaybackPlaying
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        updateMessagingState()
        view?.post { renderBufferedMessages() }
        val args = requireArguments()
        val channelId = args.getString(KEY_CHANNEL_ID)
        val channelLogin = args.getString(KEY_CHANNEL_LOGIN)
        refreshKickRewardState()
        if (args.getBoolean(KEY_IS_LIVE) && !isLiveRewound) {
            viewModel.resumeLive(channelId, channelLogin)
        } else if (isLiveRewound) {
            val currentPos = (parentFragment as? PlayerFragment)?.getCurrentPosition() ?: 0L
            startLiveRewind(null, currentPos)
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
                kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL),
                isClipReplay = args.getBoolean(KEY_IS_CLIP_REPLAY),
                isPlaybackPlaying = (parentFragment as PlayerFragment)::isPlaybackPlaying
            )
        }
    }

    fun isActive(): Boolean? {
        return viewModel.isActive()
    }

    fun disconnect() {
        viewModel.disconnect()
    }

    fun updateMessagingState(isLoggedIn: Boolean? = null) {
        if (!isAdded || _binding == null) return
        val ctx = context ?: return
        val currentLoggedIn = isLoggedIn ?: AuthStateHelper.isKickLoggedIn(ctx)
        val args = arguments ?: return
        val isLive = args.getBoolean(KEY_IS_LIVE)
        val enableMessaging = isLive && !isLiveRewound && currentLoggedIn
        val isPlayerContext = parentFragment is PlayerFragment || parentFragment is MultiPovFragment || (view?.parent?.parent?.parent?.parent as? View)?.id == R.id.slidingLayout
        val accountLogin = ctx.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)

        with(binding) {
            adapter?.loggedInUser = if (enableMessaging) accountLogin else null

            if (enableMessaging) {
                guestLoginPromptView.visibility = View.GONE
                if (isPlayerContext && !ctx.prefs().getBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true)) {
                    messageView.visibility = View.GONE
                } else {
                    messageView.visibility = View.VISIBLE
                }
                if (autoCompleteAdapter == null) {
                    autoCompleteAdapter = AutoCompleteAdapter(ctx) { item ->
                        insertAutoComplete(item)
                    }
                    autoCompleteRecyclerView.apply {
                        layoutManager = LinearLayoutManager(ctx)
                        adapter = autoCompleteAdapter
                    }
                    (autoCompleteContainer.parent as? View)?.addOnLayoutChangeListener { _, _, top, _, bottom, _, oldTop, _, oldBottom ->
                        if ((bottom - top) != (oldBottom - oldTop) && autoCompleteContainer.isVisible) {
                            updateAutoComplete(editText.text)
                        }
                    }
                }
                viewModel.loadRecentEmotes()
                setupEmotePicker()
                messagingEnabled = true
            } else {
                messageView.visibility = View.GONE
                val isChatBarVisible = !isPlayerContext || ctx.prefs().getBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true)
                guestLoginPromptView.visibility = if (isLive && !isLiveRewound && !currentLoggedIn && isChatBarVisible) View.VISIBLE else View.GONE
                messagingEnabled = false
            }
        }
    }

    fun reconnect() {
        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
        if (channelLogin != null) {
            viewModel.autoReconnect = true
            refreshKickRewardState()
            updateMessagingState()
            viewModel.startLiveChat(requireArguments().getString(KEY_CHANNEL_ID), channelLogin)
            if (requireContext().prefs().getBoolean(AppConstants.CHAT_RECENT, true)) {
                viewModel.loadRecentMessages(
                    requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    channelLogin,
                    requireArguments().getString(KEY_CHANNEL_ID)
                )
            }
        }
    }

    fun reloadEmotes() {
        viewModel.reloadEmotes(
            requireArguments().getString(KEY_CHANNEL_ID),
            requireArguments().getString(KEY_CHANNEL_LOGIN)
        )
    }

    fun startLiveRewind(streamStartTime: String?, targetPositionMs: Long) {
        if (!isAdded) return
        isLiveRewound = true
        updateMessagingState()
        val effectiveStart = streamStartTime ?: requireArguments().getString(KEY_STARTED_AT)
        if (!effectiveStart.isNullOrBlank()) {
            requireArguments().putString(KEY_STARTED_AT, effectiveStart)
        }
        val channelId = requireArguments().getString(KEY_CHANNEL_ID)
        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN) ?: return
        val channelName = requireArguments().getString(KEY_CHANNEL_NAME)
        val startTimeMs = effectiveStart?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: 0L
        val getCurrentPosition = (parentFragment as? PlayerFragment)?.let { it::getCurrentPosition } ?: { targetPositionMs }
        val getCurrentSpeed = (parentFragment as? PlayerFragment)?.let { it::getCurrentSpeed } ?: { 1.0f }
        viewModel.startLiveRewindChat(
            channelId = channelId ?: "",
            channelLogin = channelLogin,
            channelName = channelName,
            replayStartTimeMs = startTimeMs,
            targetPositionMs = targetPositionMs,
            getCurrentPosition = getCurrentPosition,
            getCurrentSpeed = getCurrentSpeed,
            isPlaybackPlaying = { (parentFragment as? PlayerFragment)?.isPlaybackPlaying() == true },
        )
    }

    fun returnToLiveChat() {
        if (!isAdded) return
        isLiveRewound = false
        updateMessagingState()
        val channelId = requireArguments().getString(KEY_CHANNEL_ID)
        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN) ?: return
        val channelName = requireArguments().getString(KEY_CHANNEL_NAME)
        val streamId = requireArguments().getString(KEY_STREAM_ID)
        val networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        viewModel.returnToLiveChat(
            networkLibrary = networkLibrary,
            channelId = channelId,
            channelLogin = channelLogin,
            channelName = channelName,
            streamId = streamId
        )
    }

    fun startReplayChatLoad(seekPosition: Long? = null, forceNewSession: Boolean = false) {
        viewModel.startReplayChatLoad(seekPosition, forceNewSession)
    }

    fun updateKickReplayStartTime(startTime: String?) {
        viewModel.updateKickReplayStartTime(startTime)
    }

    fun stopReplayChat() {
        viewModel.stopReplayChat()
    }

    fun updatePosition(position: Long) {
        viewModel.updatePosition(position)
    }

    fun seekTo(position: Long) {
        viewModel.seekTo(position)
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
        val delayMs = when (ctx.prefs().getString(AppConstants.CHAT_DELAY_MODE, "0")) {
            "1" -> ms
            "2" -> ctx.prefs().getInt(AppConstants.CHAT_DELAY_CUSTOM_SECS, 5) * 1000L
            else -> 0L
        }
        if (delayMs > 0L) {
            b.chatDelayText.text = ctx.getString(R.string.chat_delay_indicator, "%.0f".format(delayMs / 1000.0))
            delayBadgeActive = true
            featureDebugLog("delayBadge active mode=${ctx.prefs().getString(AppConstants.CHAT_DELAY_MODE, "0")} delayMs=$delayMs text=${b.chatDelayText.text}")
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
            featureDebugLog("delayBadge inactive mode=${ctx.prefs().getString(AppConstants.CHAT_DELAY_MODE, "0")}")
        }
    }

    private fun flashDelayBadge() {
        val ctx = context ?: return
        val b = _binding ?: return
        if (!ctx.prefs().getBoolean(AppConstants.CHAT_SHOW_DELAY_INDICATOR, true)) {
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

    fun emoteMenuIsVisible() = _binding?.emoteMenu?.isVisible == true

    fun toggleEmoteMenu(enable: Boolean) {
        if (enable) {
            hideAutoComplete()
            binding.emoteMenu.visibility = View.VISIBLE
        } else {
            binding.emoteMenu.visibility = View.GONE
        }
        toggleBackPressedCallback(enable)
    }

    fun toggleBackPressedCallback(enable: Boolean) {
        val shouldEnable = enable || _binding?.autoCompleteContainer?.isVisible == true
        if (shouldEnable) {
            if (!backPressedCallback.isEnabled) {
                backPressedCallback.isEnabled = true
                requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedCallback)
            }
        } else {
            backPressedCallback.isEnabled = false
            backPressedCallback.remove()
        }
    }

    fun appendEmote(emote: Emote) {
        binding.editText.text.append(emote.name).append(' ')
    }

    private fun hideAutoComplete() {
        _binding?.autoCompleteContainer?.visibility = View.GONE
        autoCompleteAdapter?.setItems(emptyList())
        toggleBackPressedCallback(emoteMenuIsVisible())
    }

    private fun updateAutoComplete(text: CharSequence?) {
        val binding = _binding ?: return
        if (text.isNullOrEmpty() || !binding.editText.hasFocus()) {
            hideAutoComplete()
            return
        }
        val cursor = binding.editText.selectionEnd.coerceAtLeast(0)
        val start = spaceTokenizer.findTokenStart(text, cursor)
        val token = if (cursor >= start) text.subSequence(start, cursor).toString() else ""
        if (token.isEmpty() || (token[0] != ':' && token[0] != '@' && token[0] != '/')) {
            hideAutoComplete()
            return
        }

        val prefix = token[0]
        val queryBody = if (prefix == ':' && token.endsWith(':') && token.length > 1) {
            token.substring(1, token.length - 1)
        } else {
            token.substring(1)
        }

        val list: List<Any?> = if (prefix == '/') {
            slashCommands
        } else {
            synchronized(viewModel.autoCompleteList) {
                viewModel.autoCompleteList.toList()
            }
        }
        val recentNames = if (prefix == ':') {
            recentEmotes.mapTo(HashSet()) { it.name.lowercase(Locale.ROOT) }
        } else {
            emptySet()
        }
        val matches = AutoCompleteAdapter.rankAndSort(list, prefix, queryBody, recentNames)
        if (matches.isEmpty()) {
            hideAutoComplete()
        } else {
            // Best match sits on the bottom, closest to the input, like the IME suggestion strip
            autoCompleteAdapter?.setItems(matches.asReversed())
            val density = resources.displayMetrics.density
            val rowHeight = (44 * density).toInt()
            val parentHeight = (binding.autoCompleteContainer.parent as? View)?.height ?: 0
            val topSafetyMargin = (8 * density).toInt()
            val maxAvailableHeight = if (parentHeight > 0) {
                (parentHeight - topSafetyMargin).coerceAtLeast(rowHeight)
            } else {
                (180 * density).toInt()
            }
            val defaultMaxHeight = (180 * density).toInt()
            val effectiveMaxHeight = minOf(defaultMaxHeight, maxAvailableHeight)
            val desiredHeight = matches.size * rowHeight + (1 * density).toInt()
            val targetHeight = minOf(desiredHeight, effectiveMaxHeight)

            binding.autoCompleteContainer.updateLayoutParams {
                height = targetHeight
            }
            binding.autoCompleteRecyclerView.scrollToPosition(matches.lastIndex)
            binding.autoCompleteContainer.visibility = View.VISIBLE
            toggleBackPressedCallback(true)
        }
    }

    private fun insertAutoComplete(item: Any) {
        val binding = _binding ?: return
        val text = binding.editText.text ?: return
        val cursor = binding.editText.selectionEnd.coerceAtLeast(0)
        val start = spaceTokenizer.findTokenStart(text, cursor)
        val end = spaceTokenizer.findTokenEnd(text, cursor)

        val replacement = when (item) {
            is Emote -> "${item.name.orEmpty()} "
            is Chatter -> "@${item.name.orEmpty()} "
            is SlashCommand -> "/${item.command} "
            else -> "${item.toString().removePrefix(":")} "
        }

        val safeStart = start.coerceIn(0, text.length)
        val safeEnd = end.coerceIn(safeStart, text.length)
        text.replace(safeStart, safeEnd, replacement)
        binding.editText.setSelection((safeStart + replacement.length).coerceAtMost(text.length))
        hideAutoComplete()
    }

    private fun sendMessage(replyId: String? = null): Boolean {
        with(binding) {
            hideAutoComplete()
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
                    networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), true),
                    kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext()),
                    accountId = requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                    channelId = requireArguments().getString(KEY_CHANNEL_ID),
                    channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                    useApiCommands = requireContext().prefs().getBoolean(AppConstants.DEBUG_API_COMMANDS, true),
                    useApiChatMessages = requireContext().prefs().getBoolean(AppConstants.DEBUG_API_CHAT_MESSAGES, true),
                    enableIntegrity = requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
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
                        when (requireContext().prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
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
        (parentFragment as? PlayerFragment)?.minimize() ?: (parentFragment as? MultiPovFragment)?.minimize()
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
                    kickReplayUrl = args.getString(KEY_KICK_REPLAY_URL),
                    isClipReplay = args.getBoolean(KEY_IS_CLIP_REPLAY),
                    isPlaybackPlaying = (parentFragment as PlayerFragment)::isPlaybackPlaying
                )
            }
        }
    }

    override fun onStop() {
        super.onStop()
        // Battery optimization: always disconnect live chat when fragment not visible.
        // onResume will re-establish via resumeLive(). Previously kept socket alive
        // when PLAYER_KEEP_CHAT_OPEN was true, holding radio even with no visible chat.
        viewModel.stopLiveChat()
        viewModel.stopReplayChat()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        rebuildChannelPointsDialogAfterLayoutChange()
        pinnedGiftUiHelper.onConfigurationChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireContext().prefs().unregisterOnSharedPreferenceChangeListener(chatPreferenceChangeListener)
        raidCountdownTimer?.cancel()
        raidCountdownTimer = null
        giftTrainTimer?.cancel()
        giftTrainTimer = null
        giftTrainAdapter = null
        channelPointsDialog?.dismiss()
        channelPointsDialog = null
        _binding?.emoteSections?.adapter = null
        emoteSectionAdapter = null
        _binding?.recyclerView?.adapter = null
        adapter = null
        ChatAdapterUtils.clearMasterEmotes()
        _binding?.autoCompleteRecyclerView?.adapter = null
        autoCompleteAdapter = null
        pinnedGiftUiHelper.resetPinnedGiftUiState()
        _binding = null
    }

    private fun refreshLiveChatRenderSettings() {
        val adapter = adapter ?: return
        val changed = adapter.updateLiveSettings(createLiveChatRenderSettings())
        if (changed) {
            val size = adapter.itemCount
            if (size > 0) {
                adapter.notifyItemRangeChanged(0, size, ChatAdapter.PAYLOAD_REFORMAT)
            }
        }
    }

    private fun createLiveChatRenderSettings(): ChatAdapter.LiveSettings {
        val prefs = requireContext().prefs()
        val sizeModifier = prefs.getInt(AppConstants.CHAT_SIZE_MODIFIER, 100).toFloat() / 100f
        return ChatAdapter.LiveSettings(
            enableTimestamps = prefs.getBoolean(AppConstants.CHAT_TIMESTAMPS, false),
            timestampFormat = prefs.getString(AppConstants.CHAT_TIMESTAMP_FORMAT, "0"),
            firstMsgVisibility = prefs.getString(AppConstants.CHAT_FIRSTMSG_VISIBILITY, "0")?.toIntOrNull() ?: 0,
            useRandomColors = prefs.getBoolean(AppConstants.CHAT_RANDOMCOLOR, true),
            useReadableColors = prefs.getBoolean(AppConstants.CHAT_THEME_ADAPTED_USERNAME_COLOR, true),
            useBoldNames = prefs.getBoolean(AppConstants.CHAT_BOLDNAMES, false),
            showNamePaints = prefs.getBoolean(AppConstants.CHAT_SHOW_PAINTS, true),
            showStvBadges = prefs.getBoolean(AppConstants.CHAT_SHOW_STV_BADGES, true),
            showKickBadges = prefs.getBoolean(AppConstants.CHAT_SHOW_KICK_BADGES, true),
            showPersonalEmotes = prefs.getBoolean(AppConstants.CHAT_SHOW_PERSONAL_EMOTES, true),
            enableAlternatingLineShadows = prefs.getBoolean(AppConstants.CHAT_ALTERNATING_LINE_SHADOW, true),
            alternatingLineShadowStrength = prefs.getInt(
                AppConstants.CHAT_ALTERNATING_LINE_SHADOW_STRENGTH,
                ChatBackgroundUtils.DEFAULT_ALTERNATING_LINE_SHADOW_STRENGTH
            ),
            showSystemMessageEmotes = prefs.getBoolean(AppConstants.CHAT_SYSTEM_MESSAGE_EMOTES, true),
            imageLibrary = prefs.getString(AppConstants.CHAT_IMAGE_LIBRARY, "0"),
            messageTextSize = (prefs.getString(AppConstants.CHAT_TEXT_SIZE, "14")?.toFloatOrNull() ?: 14f) * sizeModifier,
            emoteSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                (prefs.getString(AppConstants.CHAT_EMOTE_SIZE, "29.5")?.toFloatOrNull() ?: 29.5f) * sizeModifier,
                resources.displayMetrics
            ).toInt(),
            badgeSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                (prefs.getString(AppConstants.CHAT_BADGE_SIZE, "18.5")?.toFloatOrNull() ?: 18.5f) * sizeModifier,
                resources.displayMetrics
            ).toInt(),
            emoteQuality = prefs.getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4",
            animateGifs = prefs.getBoolean(AppConstants.ANIMATED_EMOTES, true),
            animatedEmoteFps = prefs.getString(AppConstants.CHAT_ANIMATED_EMOTE_FPS, "15")?.toIntOrNull()?.coerceIn(5, 60) ?: 15,
            enableOverlayEmotes = prefs.getBoolean(AppConstants.CHAT_ZEROWIDTH, true),
        )
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
        private const val KEY_STARTED_AT = "startedAt"
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
        private const val KEY_IS_CLIP_REPLAY = "isClipReplay"
        private const val KEY_SOURCE = "source"
        private val LIVE_CHAT_RENDER_SETTING_KEYS = setOf(
            AppConstants.CHAT_TIMESTAMPS,
            AppConstants.CHAT_TIMESTAMP_FORMAT,
            AppConstants.CHAT_FIRSTMSG_VISIBILITY,
            AppConstants.CHAT_RANDOMCOLOR,
            AppConstants.CHAT_THEME_ADAPTED_USERNAME_COLOR,
            AppConstants.CHAT_BOLDNAMES,
            AppConstants.CHAT_SHOW_PAINTS,
            AppConstants.CHAT_SHOW_STV_BADGES,
            AppConstants.CHAT_SHOW_KICK_BADGES,
            AppConstants.CHAT_SHOW_PERSONAL_EMOTES,
            AppConstants.CHAT_ALTERNATING_LINE_SHADOW,
            AppConstants.CHAT_ALTERNATING_LINE_SHADOW_STRENGTH,
            AppConstants.CHAT_SYSTEM_MESSAGE_EMOTES,
            AppConstants.CHAT_IMAGE_LIBRARY,
            AppConstants.CHAT_IMAGE_QUALITY,
            AppConstants.CHAT_SIZE_MODIFIER,
            AppConstants.CHAT_TEXT_SIZE,
            AppConstants.CHAT_EMOTE_SIZE,
            AppConstants.CHAT_BADGE_SIZE,
            AppConstants.ANIMATED_EMOTES,
            AppConstants.CHAT_ANIMATED_EMOTE_FPS,
            AppConstants.CHAT_ZEROWIDTH,
        )

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
            isClipReplay: Boolean = false,
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
                    putBoolean(KEY_IS_CLIP_REPLAY, isClipReplay)
                    putString(KEY_SOURCE, source)
                }
            }
        }

        fun newLocalInstance(channelId: String?, channelLogin: String?, chatUrl: String?, startTime: Int? = null, source: String? = null): ChatFragment {
            return ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_CHANNEL_ID, channelId)
                    putString(KEY_CHANNEL_LOGIN, channelLogin)
                    putString(KEY_CHAT_URL, chatUrl)
                    putInt(KEY_START_TIME, startTime ?: -1)
                    putString(KEY_SOURCE, source)
                }
            }
        }
    }
}
