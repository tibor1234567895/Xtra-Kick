package com.xtrakick.app.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogMutedUsersBinding
import com.xtrakick.app.databinding.ItemMutedUserBinding
import com.xtrakick.app.databinding.ItemMutedUserHeaderBinding
import com.xtrakick.app.repository.KickAccountMutedUsersStore
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.MutedChatUsersRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

/**
 * Lists the muted users of the logged-in Kick account (`/api/v2/silenced-users`)
 * with per-row unmute, plus local-only chat mutes that never made it to the
 * account (e.g. muted while signed out).
 */
@AndroidEntryPoint
class MutedUsersDialog : BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "MutedUsersDialog"
    }

    @Inject
    lateinit var kickRepository: KickRepository

    @Inject
    lateinit var kickAccountMutedUsersStore: KickAccountMutedUsersStore

    @Inject
    lateinit var mutedChatUsersRepository: MutedChatUsersRepository

    private var _binding: DialogMutedUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MutedUsersAdapter
    private var unmuteInFlight = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogMutedUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val maxHeight = (resources.displayMetrics.heightPixels * 0.60).toInt()
        view.layoutParams = view.layoutParams.apply { height = maxHeight }
        behavior.peekHeight = maxHeight

        adapter = MutedUsersAdapter(::unmuteUser)
        binding.mutedListRv.layoutManager = LinearLayoutManager(requireContext())
        binding.mutedListRv.adapter = adapter

        binding.refreshButton.setOnClickListener { loadData() }
        binding.closeButton.setOnClickListener { dismiss() }
        binding.retryButton.setOnClickListener { loadData() }

        loadData()
    }

    private fun loadData() {
        binding.loadingProgress.isVisible = true
        binding.errorLayout.isVisible = false
        binding.emptyText.isVisible = false

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                // Refreshing the shared store also updates the live chat filter.
                kickAccountMutedUsersStore.refresh()
                rebuildRows()
            } catch (e: CancellationException) {
                // viewLifecycleOwner.lifecycleScope cancels on onDestroyView, which also
                // nulls _binding; touching the binding here would NPE.
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "Failed to load muted users: ${e.message}")
                binding.loadingProgress.isVisible = false
                binding.errorLayout.isVisible = true
                binding.errorText.text = e.message?.takeIf { it.isNotBlank() }
                    ?: getString(R.string.muted_users_load_failed)
            }
        }
    }

    /** Rebuilds the list from the shared store and the local table without a network round trip. */
    private suspend fun rebuildRows() {
        val accountUsers = kickAccountMutedUsersStore.users.value
        val localUsers = mutedChatUsersRepository.loadUsersFlow().first()
        val accountIds = accountUsers.mapTo(HashSet()) { it.id.lowercase(Locale.ROOT) }
        val rows = buildList {
            if (accountUsers.isNotEmpty()) {
                add(MutedUserRow.Header(getString(R.string.muted_users_account_section)))
                accountUsers.forEach { user ->
                    add(MutedUserRow.User(user.id, user.username ?: user.id, onKickAccount = true))
                }
            }
            val localOnly = localUsers.filter { candidate ->
                val id = candidate.userId?.trim()?.lowercase(Locale.ROOT)
                id.isNullOrBlank() || id !in accountIds
            }
            if (localOnly.isNotEmpty()) {
                add(MutedUserRow.Header(getString(R.string.muted_users_device_section)))
                localOnly.forEach { user ->
                    add(
                        MutedUserRow.User(
                            user.userId,
                            user.userName ?: user.userLogin ?: user.userId.orEmpty(),
                            onKickAccount = false,
                        )
                    )
                }
            }
        }
        adapter.submitList(rows)
        binding.loadingProgress.isVisible = false
        binding.emptyText.isVisible = rows.isEmpty()
    }

    private fun unmuteUser(row: MutedUserRow.User) {
        if (unmuteInFlight) return
        val id = row.id?.trim()?.takeIf { it.isNotBlank() }
        if (row.onKickAccount && id == null) return
        unmuteInFlight = true
        viewLifecycleOwner.lifecycleScope.launch {
            val accountResult = if (row.onKickAccount && id != null) {
                runCatching { kickRepository.setKickAccountMutedUser(id, mute = false) }
                    .onFailure { Log.w(TAG, "Account unmute failed for $id: ${it.message}") }
                    .getOrNull() == true
            } else {
                true
            }
            if (accountResult) {
                kickAccountMutedUsersStore.onAccountUnmuteApplied(requireNotNull(id))
                mutedChatUsersRepository.removeMutedUser(id, row.username, row.username)
                rebuildRows()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.muted_users_unmute_failed, row.username),
                    Toast.LENGTH_SHORT,
                ).show()
            }
            unmuteInFlight = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    sealed interface MutedUserRow {
        data class Header(val title: String) : MutedUserRow
        data class User(val id: String?, val username: String, val onKickAccount: Boolean) : MutedUserRow
    }

    private class MutedUsersAdapter(
        private val onUnmuteClicked: (MutedUserRow.User) -> Unit,
    ) : ListAdapter<MutedUserRow, RecyclerView.ViewHolder>(DiffCallback) {

        companion object {
            private const val TYPE_HEADER = 0
            private const val TYPE_USER = 1

            private val DiffCallback = object : DiffUtil.ItemCallback<MutedUserRow>() {
                override fun areItemsTheSame(oldItem: MutedUserRow, newItem: MutedUserRow): Boolean {
                    return when {
                        oldItem is MutedUserRow.Header && newItem is MutedUserRow.Header ->
                            oldItem.title == newItem.title
                        oldItem is MutedUserRow.User && newItem is MutedUserRow.User ->
                            oldItem.id == newItem.id &&
                                oldItem.username.equals(newItem.username, ignoreCase = true)
                        else -> false
                    }
                }

                override fun areContentsTheSame(oldItem: MutedUserRow, newItem: MutedUserRow): Boolean {
                    return oldItem == newItem
                }
            }
        }

        override fun getItemViewType(position: Int): Int {
            return when (getItem(position)) {
                is MutedUserRow.Header -> TYPE_HEADER
                is MutedUserRow.User -> TYPE_USER
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return if (viewType == TYPE_HEADER) {
                HeaderViewHolder(ItemMutedUserHeaderBinding.inflate(inflater, parent, false))
            } else {
                UserViewHolder(ItemMutedUserBinding.inflate(inflater, parent, false), onUnmuteClicked)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (val item = getItem(position)) {
                is MutedUserRow.Header -> (holder as HeaderViewHolder).bind(item)
                is MutedUserRow.User -> (holder as UserViewHolder).bind(item)
            }
        }

        class HeaderViewHolder(
            private val binding: ItemMutedUserHeaderBinding,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: MutedUserRow.Header) {
                binding.headerTitle.text = item.title.uppercase(Locale.ROOT)
            }
        }

        class UserViewHolder(
            private val binding: ItemMutedUserBinding,
            private val onUnmute: (MutedUserRow.User) -> Unit,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: MutedUserRow.User) {
                binding.userName.text = item.username
                binding.unmuteButton.setOnClickListener { onUnmute(item) }
            }
        }
    }
}
