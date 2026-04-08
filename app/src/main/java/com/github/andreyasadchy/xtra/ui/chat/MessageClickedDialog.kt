package com.github.andreyasadchy.xtra.ui.chat

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.format.DateUtils
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogChatMessageClickBinding
import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.ui.User
import com.github.andreyasadchy.xtra.ui.common.IntegrityDialog
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MessageClickedDialog : BottomSheetDialogFragment(), IntegrityDialog.CallbackListener {

    private data class SubscriptionDetail(
        val text: String,
    )

    companion object {
        private const val KEY_MESSAGING = "messaging"
        private const val KEY_CHANNEL_ID = "channelId"
        private const val KEY_CHANNEL_LOGIN = "channelLogin"

        fun newInstance(messagingEnabled: Boolean, channelId: String?, channelLogin: String?): MessageClickedDialog {
            return MessageClickedDialog().apply {
                arguments = bundleOf(
                    KEY_MESSAGING to messagingEnabled,
                    KEY_CHANNEL_ID to channelId,
                    KEY_CHANNEL_LOGIN to channelLogin
                )
            }
        }
    }

    interface OnButtonClickListener {
        fun onCreateMessageClickedChatAdapter(): MessageClickedChatAdapter?
        fun onReplyClicked(replyId: String?, userLogin: String?, userName: String?, message: String?)
        fun onCopyMessageClicked(message: String)
        fun onViewProfileClicked(id: String?, login: String?, name: String?, channelLogo: String?)
    }

    private var _binding: DialogChatMessageClickBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MessageClickedViewModel by viewModels()

    private lateinit var listener: OnButtonClickListener
    var adapter: MessageClickedChatAdapter? = null
    private var isChatTouched = false
    private var messageLimit: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as OnButtonClickListener
    }

    override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?, savedInstanceState: Bundle?): android.view.View {
        _binding = DialogChatMessageClickBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as android.view.View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        binding.closeButton.setOnClickListener { dismiss() }
        binding.closeButtonInline.setOnClickListener { dismiss() }
        binding.copyClip.setOnClickListener {
            val message = adapter?.selectedMessage?.message ?: return@setOnClickListener
            getSystemService(requireContext(), ClipboardManager::class.java)
                ?.setPrimaryClip(ClipData.newPlainText("label", message))
            dismiss()
        }
        binding.copyFullMsg.setOnClickListener {
            val fullMsg = adapter?.selectedMessage?.fullMsg ?: return@setOnClickListener
            getSystemService(requireContext(), ClipboardManager::class.java)
                ?.setPrimaryClip(ClipData.newPlainText("label", fullMsg))
            dismiss()
        }

        adapter = listener.onCreateMessageClickedChatAdapter()
        binding.recyclerView.let {
            it.adapter = adapter
            it.itemAnimator = null
            it.layoutManager = LinearLayoutManager(context)
            it.setOnTouchListener { _, event ->
                when (event.action) {
                    android.view.MotionEvent.ACTION_DOWN, android.view.MotionEvent.ACTION_MOVE -> behavior.isDraggable = false
                    android.view.MotionEvent.ACTION_UP -> behavior.isDraggable = true
                }
                false
            }
            it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    isChatTouched = newState == RecyclerView.SCROLL_STATE_DRAGGING
                }
            })
        }

        adapter?.let { chatAdapter ->
            chatAdapter.messageClickListener = { selectedMessage, previousSelectedMessage ->
                updateButtons(selectedMessage)
                previousSelectedMessage?.let { previous ->
                    synchronized(chatAdapter.messages) {
                        chatAdapter.messages.indexOf(previous).takeIf { it != -1 }
                    }?.let { previousIndex ->
                        binding.recyclerView.layoutManager?.findViewByPosition(previousIndex)
                            ?.findViewById<TextView>(R.id.chatMessageText)
                            ?.let { textView -> chatAdapter.updateBackground(previous, textView) }
                            ?: chatAdapter.notifyItemChanged(previousIndex)
                    }
                }
            }
            chatAdapter.selectedMessage?.let { selectedMessage ->
                synchronized(chatAdapter.messages) {
                    chatAdapter.messages.indexOf(selectedMessage).takeIf { it != -1 }
                }?.let(binding.recyclerView::scrollToPosition)
                bindSelectedMessage(selectedMessage)
            }
        }

        if (requireContext().prefs().getBoolean(C.DEBUG_CHAT_FULLMSG, false)) {
            binding.copyFullMsg.visibility = android.view.View.VISIBLE
        }

        observeState()
    }

    private fun observeState() {
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
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest(::renderState)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.events.collectLatest {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun bindSelectedMessage(selectedMessage: ChatMessage) {
        updateButtons(selectedMessage)
        renderFallbackHeader(selectedMessage)

        val selectedUserId = selectedMessage.userId?.takeIf { it.isNotBlank() }
        val selectedUserLogin = selectedMessage.userLogin?.takeIf { it.isNotBlank() }
            ?: selectedMessage.userName?.takeIf { it.isNotBlank() }
        val selectedUserName = selectedMessage.userName?.takeIf { it.isNotBlank() } ?: selectedUserLogin
        if (selectedUserId.isNullOrBlank() && selectedUserLogin.isNullOrBlank()) {
            binding.viewProfile.visibility = android.view.View.GONE
            binding.followButton.isEnabled = false
            binding.muteButton.isEnabled = false
            return
        }

        binding.viewProfile.visibility = android.view.View.VISIBLE
        binding.viewProfile.setOnClickListener {
            listener.onViewProfileClicked(selectedUserId, selectedUserLogin, selectedUserName, null)
            dismiss()
        }

        val isKickPref = (requireContext().prefs().getString(C.API_PREFS_STREAMS, null) ?: C.DEFAULT_API_PREFS_STREAMS)
            .split(',')
            .any { item ->
                val split = item.split(':')
                split.getOrNull(0) == C.KICK && split.getOrNull(1) != "0"
            }
        val targetId = requireArguments().getString(KEY_CHANNEL_ID)
        viewModel.loadUser(
            channelId = selectedUserId,
            channelLogin = selectedUserLogin,
            channelName = selectedUserName,
            targetId = if (selectedUserId != targetId) targetId else null,
            targetLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
            networkLibrary = requireContext().prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
            gqlHeaders = KickApiHelper.getGQLHeaders(requireContext()),
            helixHeaders = KickApiHelper.getHelixHeaders(requireContext()),
            enableIntegrity = requireContext().prefs().getBoolean(C.ENABLE_INTEGRITY, false),
            isKick = isKickPref
        )
    }

    private fun renderFallbackHeader(chatMessage: ChatMessage) {
        binding.userLayout.visibility = android.view.View.VISIBLE
        binding.userName.text = chatMessage.userName ?: chatMessage.userLogin ?: getString(R.string.view_profile)
        binding.userName.visibility = android.view.View.VISIBLE
        binding.messagePreview.text = chatMessage.message ?: chatMessage.systemMsg ?: ""
        binding.messagePreview.isVisible = false
        binding.bannerImage.visibility = android.view.View.GONE
        binding.bannerScrim.visibility = android.view.View.GONE
        binding.closeButton.isVisible = false
        binding.closeButtonInline.isVisible = true
        renderDetails(null, chatMessage)
    }

    private fun renderState(state: MessageClickedUiState) {
        state.user?.let(::updateUserLayout)
        binding.followButton.text = if (state.isFollowing) getString(R.string.following) else getString(R.string.follow)
        binding.followButton.isEnabled = state.canFollow && !state.isFollowActionInProgress
        binding.muteButton.text = if (state.isMuted) getString(R.string.muted) else getString(R.string.mute)
        binding.muteButton.isEnabled = !state.isMuteActionInProgress

        val displayName = state.user?.channelName ?: adapter?.selectedMessage?.userName ?: adapter?.selectedMessage?.userLogin
        binding.followButton.setOnClickListener { viewModel.toggleFollow(displayName) }
        binding.muteButton.setOnClickListener {
            viewModel.toggleMute()
            adapter?.applyMutedState(!state.isMuted)
            updateHistoryVisibility()
        }
        updateHistoryVisibility()
    }

    private fun updateButtons(chatMessage: ChatMessage) {
        with(binding) {
            if (requireArguments().getBoolean(KEY_MESSAGING) && (!chatMessage.userId.isNullOrBlank() || !chatMessage.userLogin.isNullOrBlank())) {
                if (!chatMessage.id.isNullOrBlank()) {
                    reply.visibility = android.view.View.VISIBLE
                    reply.setOnClickListener {
                        listener.onReplyClicked(chatMessage.id, chatMessage.userLogin, chatMessage.userName, chatMessage.message)
                        dismiss()
                    }
                } else {
                    reply.visibility = android.view.View.GONE
                }
                if (!chatMessage.message.isNullOrBlank()) {
                    copyMessage.visibility = android.view.View.VISIBLE
                    copyMessage.setOnClickListener {
                        listener.onCopyMessageClicked(chatMessage.message)
                        dismiss()
                    }
                } else {
                    copyMessage.visibility = android.view.View.GONE
                }
            }
            translateMessage.visibility = android.view.View.GONE
            translateMessageSelectLanguage.visibility = android.view.View.GONE
            historyDate.text = chatMessage.timestamp?.let(::formatHistoryDate).orEmpty()
            historyDate.isVisible = historyDate.text.isNotBlank()
        }
    }

    private fun updateUserLayout(user: User) {
        with(binding) {
            userLayout.visibility = android.view.View.VISIBLE
            if (user.bannerImageURL != null) {
                bannerImage.visibility = android.view.View.VISIBLE
                bannerScrim.visibility = android.view.View.VISIBLE
                closeButton.isVisible = false
                closeButtonInline.isVisible = true
                requireContext().imageLoader.enqueue(
                    ImageRequest.Builder(requireContext())
                        .data(user.bannerImageURL)
                        .crossfade(true)
                        .target(bannerImage)
                        .build()
                )
            } else {
                bannerImage.visibility = android.view.View.GONE
                bannerScrim.visibility = android.view.View.GONE
                closeButton.isVisible = false
                closeButtonInline.isVisible = true
            }
            if (user.channelLogo != null) {
                userImage.visibility = android.view.View.VISIBLE
                requireContext().imageLoader.enqueue(
                    ImageRequest.Builder(requireContext())
                        .data(user.channelLogo)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .target(userImage)
                        .build()
                )
                userImage.setOnClickListener {
                    listener.onViewProfileClicked(user.channelId, user.channelLogin, user.channelName, user.channelLogo)
                    dismiss()
                }
            } else {
                userImage.visibility = android.view.View.GONE
            }
            userName.text = when {
                !user.channelLogin.isNullOrBlank() && !user.channelName.isNullOrBlank() && !user.channelLogin.equals(user.channelName, true) -> {
                    when (requireContext().prefs().getString(C.UI_NAME_DISPLAY, "1")) {
                        "0" -> "${user.channelName}(${user.channelLogin})"
                        "1" -> user.channelName
                        else -> user.channelLogin
                    }
                }
                else -> user.channelName ?: user.channelLogin
            }
            messagePreview.text = adapter?.selectedMessage?.message ?: adapter?.selectedMessage?.systemMsg ?: ""
            messagePreview.isVisible = false
            renderDetails(user, adapter?.selectedMessage)
            userName.setOnClickListener {
                listener.onViewProfileClicked(user.channelId, user.channelLogin, user.channelName, user.channelLogo)
                dismiss()
            }
        }
    }

    private fun updateHistoryVisibility() {
        val hasMessages = adapter?.messages?.isNotEmpty() == true
        binding.historyHeaderLayout.isVisible = hasMessages
        binding.messageLayout.isVisible = hasMessages
        binding.historyDate.isVisible = hasMessages && !binding.historyDate.text.isNullOrBlank()
    }

    private fun formatHistoryDate(timestamp: Long): String {
        return SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault()).format(Date(timestamp))
    }

    fun updateUserMessages(userId: String) {
        adapter?.let { chatAdapter ->
            synchronized(chatAdapter.messages) {
                chatAdapter.messages.mapIndexedNotNull { index, message ->
                    if (message.userId != null && message.userId == userId) index else null
                }
            }.forEach(chatAdapter::notifyItemChanged)
        }
    }

    fun updateMessage(message: ChatMessage) {
        adapter?.let { chatAdapter ->
            val updatedIndex = synchronized(chatAdapter.messages) {
                chatAdapter.messages.indexOfLast { it.id != null && it.id == message.id }.takeIf { it != -1 }?.also { index ->
                    chatAdapter.messages[index] = message
                    if (chatAdapter.selectedMessage?.id == message.id) {
                        chatAdapter.selectedMessage = message
                    }
                }
            }
            updatedIndex?.let { chatAdapter.notifyItemChanged(it) }
        }
    }

    fun newMessage(message: ChatMessage) {
        adapter?.let { chatAdapter ->
            if (chatAdapter.matchesSelectedUser(message) && !chatAdapter.muted) {
                synchronized(chatAdapter.messages) {
                    if (chatAdapter.messages.size >= (messageLimit ?: requireContext().prefs().getInt(C.CHAT_LIMIT, 600).also { messageLimit = it })) {
                        chatAdapter.messages.removeAt(0)
                        chatAdapter.notifyItemRemoved(0)
                    }
                    chatAdapter.messages.add(message)
                    val lastIndex = chatAdapter.messages.lastIndex
                    chatAdapter.notifyItemInserted(lastIndex)
                    if (!isChatTouched && !shouldShowButton()) {
                        binding.recyclerView.scrollToPosition(lastIndex)
                    }
                }
            }
        }
        updateHistoryVisibility()
    }

    fun addMessages(messages: List<ChatMessage>) {
        adapter?.let { chatAdapter ->
            synchronized(chatAdapter.messages) {
                val left = (messageLimit ?: requireContext().prefs().getInt(C.CHAT_LIMIT, 600).also { messageLimit = it }) - chatAdapter.messages.size
                if (left > 0 && !chatAdapter.muted) {
                    val items = messages.filter(chatAdapter::matchesSelectedUser).takeLast(left)
                    chatAdapter.messages.addAll(0, items)
                    chatAdapter.notifyItemRangeInserted(0, items.size)
                    if (!isChatTouched && !shouldShowButton()) {
                        binding.recyclerView.scrollToPosition(chatAdapter.messages.lastIndex)
                    }
                }
            }
        }
        updateHistoryVisibility()
    }

    private fun shouldShowButton(): Boolean {
        val offset = binding.recyclerView.computeVerticalScrollOffset()
        if (offset < 0) return false
        val extent = binding.recyclerView.computeVerticalScrollExtent()
        val range = binding.recyclerView.computeVerticalScrollRange()
        val percentage = (100f * offset / (range - extent).toFloat())
        return percentage < 100f
    }

    override fun onIntegrityDialogCallback(callback: String?) {
        if (callback == "refresh") {
            adapter?.selectedMessage?.let(::bindSelectedMessage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderDetails(user: User?, chatMessage: ChatMessage?) {
        val createdText = user?.createdAt?.let(::formatAccountDetail).orEmpty()
        val followedText = user?.followedAt?.let(::formatAccountDetail).orEmpty()
        val subscriptionText = buildSubscriptionDetail(chatMessage?.badges.orEmpty())?.text.orEmpty()

        binding.userCreated.text = createdText
        binding.userCreatedRow.isVisible = createdText.isNotBlank()
        binding.userFollowed.text = followedText
        binding.userFollowedRow.isVisible = followedText.isNotBlank()
        binding.userSubscribed.text = subscriptionText
        binding.userSubscribedRow.isVisible = subscriptionText.isNotBlank()
        binding.metaLayout.isVisible = binding.userCreatedRow.isVisible || binding.userFollowedRow.isVisible || binding.userSubscribedRow.isVisible

        renderBadges(chatMessage?.badges.orEmpty())
    }

    private fun formatAccountDetail(isoDate: String): String? {
        val formatted = KickApiHelper.formatTimeString(requireContext(), isoDate) ?: isoDate
        val timestamp = KickApiHelper.parseIso8601DateUTC(isoDate)
        val relative = timestamp?.let(::formatDaysAgo)
        return if (!relative.isNullOrBlank()) "$formatted • $relative" else formatted
    }

    private fun formatDaysAgo(timestamp: Long): String? {
        if (timestamp <= 0L) return null
        val diff = System.currentTimeMillis() - timestamp
        if (diff < 0L) return null
        val days = diff / DateUtils.DAY_IN_MILLIS
        return when (days) {
            0L -> "today"
            1L -> "1 day ago"
            else -> "$days days ago"
        }
    }

    private fun buildSubscriptionDetail(badges: List<Badge>): SubscriptionDetail? {
        val founderBadge = badges.firstOrNull { normalizedBadgeId(it) == "founder" }
        val subscriberBadge = badges.firstOrNull { normalizedBadgeId(it) == "subscriber" }
        val fallbackBadge = badges.firstOrNull(::looksSubscriptionRelated)
        return when {
            founderBadge != null -> {
                val duration = extractBadgeDuration(founderBadge)
                SubscriptionDetail(
                    duration?.let { getString(R.string.founder_badge_duration, it) }
                        ?: prettifyBadgeName(founderBadge.title ?: founderBadge.setId)
                )
            }
            subscriberBadge != null -> {
                val duration = extractBadgeDuration(subscriberBadge)
                SubscriptionDetail(
                    duration?.let { getString(R.string.subscribed_for_duration, it) }
                        ?: prettifyBadgeName(subscriberBadge.title ?: subscriberBadge.setId)
                )
            }
            fallbackBadge != null -> {
                extractBadgeDuration(fallbackBadge)?.let {
                    SubscriptionDetail(getString(R.string.subscription_history_duration, it))
                }
            }
            else -> null
        }
    }

    private fun extractBadgeDuration(badge: Badge): String? {
        val months = badge.version.toIntOrNull()?.takeIf { it > 0 }
            ?: Regex("(\\d+)").find(badge.title.orEmpty())?.groupValues?.getOrNull(1)?.toIntOrNull()?.takeIf { it > 0 }
        return months?.let(::formatMonths)
    }

    private fun formatMonths(months: Int): String {
        return "$months months"
    }

    private fun buildBadgeLabel(badge: Badge): String {
        val base = badge.title
            ?.takeIf { it.isNotBlank() }
            ?.let(::prettifyBadgeName)
            ?: prettifyBadgeName(badge.setId)
        val version = badge.version.takeIf { shouldAppendBadgeVersion(badge, base, it) }
        return if (version != null) "$base $version" else base
    }

    private fun shouldAppendBadgeVersion(badge: Badge, base: String, version: String): Boolean {
        val normalized = normalizedBadgeId(badge)
        return version.isNotBlank() &&
            version != "1" &&
            version.none { !it.isDigit() } &&
            !base.contains(version) &&
            normalized in setOf("subscriber", "founder", "sub_gifter")
    }

    private fun looksSubscriptionRelated(badge: Badge): Boolean {
        val normalized = normalizedBadgeId(badge)
        val title = badge.title.orEmpty().lowercase(Locale.ROOT)
        return normalized in setOf("subscriber", "founder") ||
            title.contains("sub") ||
            title.contains("founder")
    }

    private fun normalizedBadgeId(badge: Badge): String {
        return badge.setId
            .trim()
            .lowercase(Locale.ROOT)
            .replace(Regex("[^a-z0-9_]+"), "_")
            .removePrefix("badge_")
            .replace(Regex("_badges?$"), "")
            .replace(Regex("_badge_?\\d*$"), "")
    }

    private fun prettifyBadgeName(value: String): String {
        return value
            .replace('_', ' ')
            .replace('-', ' ')
            .trim()
            .lowercase(Locale.getDefault())
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }
            .joinToString(" ") { token ->
                token.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
    }

    private fun dp(value: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

    private fun renderBadges(badges: List<Badge>) {
        val distinctBadges = badges
            .distinctBy { "${it.setId.lowercase(Locale.ROOT)}:${it.version}" }
            .filter { it.url4x != null || it.url3x != null || it.url2x != null || it.url1x != null }

        binding.badgesContainer.removeAllViews()
        binding.badgesLayout.isVisible = distinctBadges.isNotEmpty()
        binding.badgeSelectedName.text = ""
        binding.badgeSelectedName.isVisible = false
        binding.badgesScroll.isFillViewport = distinctBadges.size > 4
        if (distinctBadges.isEmpty()) return

        distinctBadges.forEach { badge ->
            binding.badgesContainer.addView(createBadgeIcon(badge))
        }
    }

    private fun createBadgeIcon(badge: Badge): LinearLayout {
        val context = requireContext()
        val imageUrl = badge.url4x ?: badge.url3x ?: badge.url2x ?: badge.url1x
        val badgeName = buildBadgeLabel(badge)
        return LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(dp(32), dp(32)).apply {
                marginEnd = dp(6)
            }
            gravity = Gravity.CENTER
            background = context.getDrawable(android.R.color.transparent)
            isClickable = true
            isFocusable = true
            contentDescription = badgeName
            setOnClickListener {
                binding.badgeSelectedName.text = badgeName
                binding.badgeSelectedName.isVisible = true
            }
            addView(ImageView(context).apply {
                layoutParams = LinearLayout.LayoutParams(dp(22), dp(22))
                scaleType = ImageView.ScaleType.FIT_CENTER
                if (!imageUrl.isNullOrBlank()) {
                    context.imageLoader.enqueue(
                        ImageRequest.Builder(context)
                            .data(imageUrl)
                            .size(dp(22), dp(22))
                            .crossfade(true)
                            .target(this)
                            .build()
                    )
                }
            })
        }
    }
}
