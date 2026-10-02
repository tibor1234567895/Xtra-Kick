package com.xtrakick.app.ui.player

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogPlayerViewerListBinding
import com.xtrakick.app.databinding.ItemPlayerViewerHeaderBinding
import com.xtrakick.app.databinding.ItemPlayerViewerUserBinding
import com.xtrakick.app.model.ui.ChannelViewerList
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.bundleOf
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class PlayerViewerListDialog : BottomSheetDialogFragment() {

    companion object {
        private const val KEY_CHANNEL_ID = "key_channel_id"
        private const val KEY_CHANNEL_LOGIN = "key_channel_login"
        private const val KEY_CHANNEL_NAME = "key_channel_name"

        fun newInstance(
            channelId: String?,
            channelLogin: String?,
            channelName: String? = null,
        ): PlayerViewerListDialog {
            return PlayerViewerListDialog().apply {
                arguments = bundleOf(
                    KEY_CHANNEL_ID to channelId,
                    KEY_CHANNEL_LOGIN to channelLogin,
                    KEY_CHANNEL_NAME to channelName,
                )
            }
        }
    }

    @Inject
    lateinit var kickRepository: KickRepository

    private var _binding: DialogPlayerViewerListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ViewerListAdapter
    private var currentViewerList: ChannelViewerList? = null
    private var unfilteredItems: List<ViewerListItem> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogPlayerViewerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val maxHeight = (resources.displayMetrics.heightPixels * 0.75).toInt()
        view.layoutParams = view.layoutParams.apply { height = maxHeight }
        behavior.peekHeight = maxHeight

        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
        val channelName = requireArguments().getString(KEY_CHANNEL_NAME) ?: channelLogin
        binding.channelSubtitle.text = channelName.orEmpty()
        binding.channelSubtitle.isVisible = !channelName.isNullOrBlank()

        adapter = ViewerListAdapter { username ->
            val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
            val clip = ClipData.newPlainText("username", username)
            clipboard?.setPrimaryClip(clip)
            Toast.makeText(
                requireContext(),
                getString(R.string.copied_username, username),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.viewerListRv.layoutManager = LinearLayoutManager(requireContext())
        binding.viewerListRv.adapter = adapter

        binding.refreshButton.setOnClickListener { loadData() }
        binding.closeButton.setOnClickListener { dismiss() }
        binding.retryButton.setOnClickListener { loadData() }

        binding.searchInput.addTextChangedListener { text ->
            val query = text?.toString().orEmpty()
            binding.clearSearchButton.isVisible = query.isNotBlank()
            filterList(query)
        }

        binding.clearSearchButton.setOnClickListener {
            binding.searchInput.text?.clear()
        }

        loadData()
    }

    private fun loadData() {
        val channelId = requireArguments().getString(KEY_CHANNEL_ID)
        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)

        binding.loadingProgress.isVisible = true
        binding.errorLayout.isVisible = false
        binding.emptySearchText.isVisible = false

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val list = kickRepository.getChannelViewerList(channelId, channelLogin)
                currentViewerList = list
                unfilteredItems = buildUnfilteredItems(list)
                binding.loadingProgress.isVisible = false

                val count = list.count ?: (list.broadcasters.size + list.moderators.size + list.vips.size + list.ogs.size + list.viewers.size)
                if (count > 0) {
                    binding.totalCountBadge.isVisible = true
                    binding.totalCountBadge.text = KickApiHelper.formatCount(count, false)
                } else {
                    binding.totalCountBadge.isVisible = false
                }

                filterList(binding.searchInput.text?.toString().orEmpty())
            } catch (e: Exception) {
                binding.loadingProgress.isVisible = false
                binding.errorLayout.isVisible = true
            }
        }
    }

    private fun buildUnfilteredItems(list: ChannelViewerList): List<ViewerListItem> = buildList {
        fun addSection(role: Role, titleRes: Int, users: List<String>) {
            if (users.isNotEmpty()) {
                add(ViewerListItem.Header(role, getString(titleRes), users.size))
                users.forEach { add(ViewerListItem.UserItem(it, role)) }
            }
        }
        addSection(Role.BROADCASTER, R.string.broadcaster, list.broadcasters)
        addSection(Role.MODERATOR, R.string.moderators, list.moderators)
        addSection(Role.VIP, R.string.vips, list.vips)
        addSection(Role.OG, R.string.ogs, list.ogs)
        addSection(Role.CHATTER, R.string.chatters, list.viewers)
    }

    private fun filterList(query: String) {
        val q = query.trim()
        if (q.isEmpty()) {
            adapter.submitList(unfilteredItems)
            binding.emptySearchText.isVisible = unfilteredItems.isEmpty()
            return
        }

        val list = currentViewerList ?: return
        val items = buildList {
            fun addSection(role: Role, titleRes: Int, users: List<String>) {
                val matches = users.filter { it.contains(q, ignoreCase = true) }
                if (matches.isNotEmpty()) {
                    add(ViewerListItem.Header(role, getString(titleRes), matches.size))
                    matches.forEach { add(ViewerListItem.UserItem(it, role)) }
                }
            }

            addSection(Role.BROADCASTER, R.string.broadcaster, list.broadcasters)
            addSection(Role.MODERATOR, R.string.moderators, list.moderators)
            addSection(Role.VIP, R.string.vips, list.vips)
            addSection(Role.OG, R.string.ogs, list.ogs)
            addSection(Role.CHATTER, R.string.chatters, list.viewers)
        }

        adapter.submitList(items)
        binding.emptySearchText.isVisible = items.isEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    enum class Role {
        BROADCASTER,
        MODERATOR,
        VIP,
        OG,
        CHATTER,
    }

    sealed interface ViewerListItem {
        data class Header(val role: Role, val title: String, val count: Int) : ViewerListItem
        data class UserItem(val username: String, val role: Role) : ViewerListItem
    }

    private class ViewerListAdapter(
        private val onUserClicked: (String) -> Unit,
    ) : ListAdapter<ViewerListItem, RecyclerView.ViewHolder>(DiffCallback) {

        companion object {
            private const val TYPE_HEADER = 0
            private const val TYPE_USER = 1

            private const val COLOR_BROADCASTER = 0xFF53FC18.toInt()
            private const val COLOR_MODERATOR = 0xFF2ECC71.toInt()
            private const val COLOR_VIP = 0xFFE056FD.toInt()
            private const val COLOR_OG = 0xFFF1C40F.toInt()

            private val DiffCallback = object : DiffUtil.ItemCallback<ViewerListItem>() {
                override fun areItemsTheSame(oldItem: ViewerListItem, newItem: ViewerListItem): Boolean {
                    return when {
                        oldItem is ViewerListItem.Header && newItem is ViewerListItem.Header ->
                            oldItem.role == newItem.role
                        oldItem is ViewerListItem.UserItem && newItem is ViewerListItem.UserItem ->
                            oldItem.username.equals(newItem.username, ignoreCase = true)
                        else -> false
                    }
                }

                override fun areContentsTheSame(oldItem: ViewerListItem, newItem: ViewerListItem): Boolean {
                    return oldItem == newItem
                }
            }
        }

        override fun getItemViewType(position: Int): Int {
            return when (getItem(position)) {
                is ViewerListItem.Header -> TYPE_HEADER
                is ViewerListItem.UserItem -> TYPE_USER
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return if (viewType == TYPE_HEADER) {
                val binding = ItemPlayerViewerHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            } else {
                val binding = ItemPlayerViewerUserBinding.inflate(inflater, parent, false)
                val defaultColor = ContextCompat.getColor(parent.context, R.color.secondaryTextColorDark)
                UserViewHolder(binding, defaultColor, onUserClicked)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (val item = getItem(position)) {
                is ViewerListItem.Header -> (holder as HeaderViewHolder).bind(item)
                is ViewerListItem.UserItem -> (holder as UserViewHolder).bind(item)
            }
        }

        class HeaderViewHolder(
            private val binding: ItemPlayerViewerHeaderBinding,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: ViewerListItem.Header) {
                binding.headerTitle.text = item.title.uppercase(Locale.ROOT)
                binding.headerCount.text = item.count.toString()
            }
        }

        class UserViewHolder(
            private val binding: ItemPlayerViewerUserBinding,
            private val defaultColor: Int,
            private val onClick: (String) -> Unit,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: ViewerListItem.UserItem) {
                binding.userName.text = item.username

                val color = when (item.role) {
                    Role.BROADCASTER -> COLOR_BROADCASTER
                    Role.MODERATOR -> COLOR_MODERATOR
                    Role.VIP -> COLOR_VIP
                    Role.OG -> COLOR_OG
                    Role.CHATTER -> defaultColor
                }
                binding.userRoleIcon.setColorFilter(color)

                binding.root.setOnClickListener {
                    onClick(item.username)
                }
            }
        }
    }
}
