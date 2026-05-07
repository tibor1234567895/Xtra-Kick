package com.github.andreyasadchy.xtra.ui.chat

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogChatMessageClickBinding
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.prefs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReplyClickedDialog : BottomSheetDialogFragment() {

    interface OnButtonClickListener {
        fun onCreateReplyClickedChatAdapter(): ReplyClickedChatAdapter?
        fun onLoadReplyThreadHistory(selectedMessage: ChatMessage, historyStartTimeMs: Long)
        fun onReplyClicked(replyId: String?, userLogin: String?, userName: String?, message: String?)
        fun onCopyMessageClicked(message: String)
    }

    companion object {
        private const val KEY_MESSAGING = "messaging"
        private const val THREAD_HISTORY_WINDOW_MS = 6L * 60L * 60L * 1000L
        fun newInstance(messagingEnabled: Boolean): ReplyClickedDialog {
            return ReplyClickedDialog().apply {
                arguments = bundleOf(
                    KEY_MESSAGING to messagingEnabled,
                )
            }
        }
    }

    private var _binding: DialogChatMessageClickBinding? = null
    private val binding get() = _binding!!

    private lateinit var listener: OnButtonClickListener
    var adapter: ReplyClickedChatAdapter? = null
    private var isChatTouched = false
    private var messageLimit: Int? = null
    private var isLoadingHistory = false
    private var threadHistoryExhausted = false
    private var nextHistoryCursorMs: Long? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as OnButtonClickListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogChatMessageClickBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        with(binding) {
            closeButton.setOnClickListener { dismiss() }
            primaryActionLayout.visibility = View.GONE
            historyHeaderLayout.visibility = View.GONE
            historyDate.visibility = View.GONE
            adapter = listener.onCreateReplyClickedChatAdapter()
            recyclerView.let {
                it.adapter = adapter
                it.itemAnimator = null
                it.layoutManager = LinearLayoutManager(context).apply { stackFromEnd = true }
                it.setOnTouchListener(object : View.OnTouchListener {
                    override fun onTouch(v: View, event: MotionEvent): Boolean {
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> behavior.isDraggable = false
                            MotionEvent.ACTION_UP -> behavior.isDraggable = true
                        }
                        return false
                    }
                })
                it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        isChatTouched = newState == RecyclerView.SCROLL_STATE_DRAGGING
                    }

                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val firstVisible = (recyclerView.layoutManager as? LinearLayoutManager)?.findFirstVisibleItemPosition() ?: return
                        if (dy < 0 && firstVisible <= 3) {
                            requestMoreHistory()
                        }
                    }
                })
            }
            adapter?.let { adapter ->
                adapter.messageClickListener = { selectedMessage, previousSelectedMessage ->
                    updateButtons(selectedMessage)
                    previousSelectedMessage?.let {
                        synchronized(adapter.messages) {
                            adapter.messages.indexOf(it).takeIf { it != -1 }
                        }?.let {
                            recyclerView.layoutManager?.findViewByPosition(it)
                                ?.findViewById<TextView>(R.id.chatMessageText)
                                ?.let { textView ->
                                    adapter.updateBackground(previousSelectedMessage, textView)
                                } ?: adapter.notifyItemChanged(it)
                        }
                    }
                }
                adapter.selectedMessage?.let { selectedMessage ->
                    updateButtons(selectedMessage)
                    synchronized(adapter.messages) {
                        adapter.messages.indexOf(selectedMessage).takeIf { it != -1 }
                    }?.let {
                        binding.recyclerView.scrollToPosition(it)
                    }
                    nextHistoryCursorMs = (selectedMessage.timestamp ?: System.currentTimeMillis()) + THREAD_HISTORY_WINDOW_MS
                    requestMoreHistory()
                }
            }
            if (requireContext().prefs().getBoolean(C.DEBUG_CHAT_FULLMSG, false)) {
                copyFullMsg.visibility = View.VISIBLE
            }
        }
    }

    private fun requestMoreHistory() {
        val adapter = adapter ?: return
        val selectedMessage = adapter.selectedMessage ?: return
        if (isLoadingHistory || threadHistoryExhausted) {
            return
        }
        val currentCursor = nextHistoryCursorMs ?: ((selectedMessage.timestamp ?: System.currentTimeMillis()) + THREAD_HISTORY_WINDOW_MS)
        val historyStartTimeMs = (currentCursor - THREAD_HISTORY_WINDOW_MS).coerceAtLeast(0L)
        nextHistoryCursorMs = historyStartTimeMs
        isLoadingHistory = true
        if (historyStartTimeMs == 0L) {
            threadHistoryExhausted = true
        }
        listener.onLoadReplyThreadHistory(selectedMessage, historyStartTimeMs)
    }

    fun onThreadHistoryLoaded(requestStartTimeMs: Long, messages: List<ChatMessage>) {
        addMessages(messages)
        isLoadingHistory = false
        if (messages.isEmpty() && requestStartTimeMs == 0L) {
            threadHistoryExhausted = true
        }
    }

    private fun updateButtons(chatMessage: ChatMessage) {
        with(binding) {
            if (requireArguments().getBoolean(KEY_MESSAGING) && (!chatMessage.userId.isNullOrBlank() || !chatMessage.userLogin.isNullOrBlank())) {
                if (!chatMessage.id.isNullOrBlank()) {
                    reply.visibility = View.VISIBLE
                    reply.setOnClickListener {
                        listener.onReplyClicked(chatMessage.id, chatMessage.userLogin, chatMessage.userName, chatMessage.message)
                        dismiss()
                    }
                } else {
                    reply.visibility = View.GONE
                }
                if (!chatMessage.message.isNullOrBlank()) {
                    copyMessage.visibility = View.VISIBLE
                    copyMessage.setOnClickListener {
                        listener.onCopyMessageClicked(chatMessage.message)
                        dismiss()
                    }
                } else {
                    copyMessage.visibility = View.GONE
                }
            }
            val clipboard = getSystemService(requireContext(), ClipboardManager::class.java)
            copyClip.setOnClickListener {
                clipboard?.setPrimaryClip(ClipData.newPlainText("label", chatMessage.message))
                dismiss()
            }
            copyFullMsg.setOnClickListener {
                clipboard?.setPrimaryClip(ClipData.newPlainText("label", chatMessage.fullMsg))
                dismiss()
            }
            translateMessage.visibility = View.GONE
            translateMessageSelectLanguage.visibility = View.GONE
        }
    }

    fun updateUserMessages(userId: String) {
        adapter?.let { adapter ->
            synchronized(adapter.messages) {
                adapter.messages.mapIndexedNotNull { index, message ->
                    if (message.userId != null && message.userId == userId) {
                        index
                    } else null
                }
            }.forEach {
                adapter.notifyItemChanged(it)
            }
        }
    }

    fun updateMessage(message: ChatMessage) {
        adapter?.let { adapter ->
            val updatedIndex = synchronized(adapter.messages) {
                adapter.messages.indexOfLast { it.id != null && it.id == message.id }.takeIf { it != -1 }?.also { index ->
                    adapter.messages[index] = message
                    if (adapter.selectedMessage?.id == message.id) {
                        adapter.selectedMessage = message
                    }
                }
            }
            updatedIndex?.let { adapter.notifyItemChanged(it) }
        }
    }

    fun newMessage(message: ChatMessage) {
        adapter?.let { adapter ->
            if ((message.reply?.threadParentId == adapter.threadParentId || message.id == adapter.threadParentId) && !message.isReply) {
                synchronized(adapter.messages) {
                    if (adapter.messages.size >= (messageLimit ?: requireContext().prefs().getInt(C.CHAT_LIMIT, 600).also { messageLimit = it })) {
                        adapter.messages.removeAt(0)
                        adapter.notifyItemRemoved(0)
                    }
                    adapter.messages.add(message)
                    val lastIndex = adapter.messages.lastIndex
                    adapter.notifyItemInserted(lastIndex)
                    if (!isChatTouched && !shouldShowButton()) {
                        binding.recyclerView.scrollToPosition(lastIndex)
                    }
                }
            }
        }
    }

    fun addMessages(messages: List<ChatMessage>) {
        adapter?.let { adapter ->
            synchronized(adapter.messages) {
                val left = (messageLimit ?: requireContext().prefs().getInt(C.CHAT_LIMIT, 600).also { messageLimit = it }) - adapter.messages.size
                if (left > 0) {
                    val existingKeys = adapter.messages.mapTo(mutableSetOf()) { message ->
                        message.id ?: "${message.timestamp}:${message.userLogin}:${message.message}:${message.systemMsg}"
                    }
                    val items = messages.filter { message ->
                        (message.reply?.threadParentId == adapter.threadParentId || message.id == adapter.threadParentId) &&
                            !message.isReply &&
                            existingKeys.add(message.id ?: "${message.timestamp}:${message.userLogin}:${message.message}:${message.systemMsg}")
                    }.takeLast(left)
                    adapter.messages.addAll(0, items)
                    adapter.notifyItemRangeInserted(0, items.size)
                    if (!isChatTouched && !shouldShowButton()) {
                        binding.recyclerView.scrollToPosition(adapter.messages.lastIndex)
                    }
                }
            }
        }
    }

    private fun shouldShowButton(): Boolean {
        with(binding) {
            val offset = recyclerView.computeVerticalScrollOffset()
            if (offset < 0) {
                return false
            }
            val extent = recyclerView.computeVerticalScrollExtent()
            val range = recyclerView.computeVerticalScrollRange()
            val percentage = (100f * offset / (range - extent).toFloat())
            return percentage < 100f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoadingHistory = false
        threadHistoryExhausted = false
        nextHistoryCursorMs = null
        _binding = null
    }
}
