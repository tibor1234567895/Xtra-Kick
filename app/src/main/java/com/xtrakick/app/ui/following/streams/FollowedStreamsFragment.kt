package com.xtrakick.app.ui.following.streams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.xtrakick.app.R
import com.xtrakick.app.databinding.CommonRecyclerViewLayoutBinding
import com.xtrakick.app.databinding.SortBarBinding
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.ui.common.BaseNetworkFragment
import com.xtrakick.app.ui.common.IntegrityDialog
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.common.Sortable
import com.xtrakick.app.ui.common.StreamsCompactListAdapter
import com.xtrakick.app.ui.common.StreamsListAdapter
import com.xtrakick.app.ui.top.TopStreamsFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FollowedStreamsFragment : BaseNetworkFragment(), Scrollable, Sortable, IntegrityDialog.CallbackListener, FollowedStreamsSortDialog.OnFilter {

    private var _binding: CommonRecyclerViewLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FollowedStreamsViewModel by viewModels()
    private lateinit var listAdapter: ListAdapter<Stream, out RecyclerView.ViewHolder>
    private var wasRefreshing = false
    private var scrollToTopAfterSort = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CommonRecyclerViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = if (requireContext().prefs().getString(AppConstants.COMPACT_STREAMS, "disabled") != "disabled") {
            StreamsCompactListAdapter(this, {
                findNavController().navigate(
                    TopStreamsFragmentDirections.actionGlobalTopFragment(
                        tags = arrayOf(it)
                    )
                )
            })
        } else {
            StreamsListAdapter(this, {
                findNavController().navigate(
                    TopStreamsFragmentDirections.actionGlobalTopFragment(
                        tags = arrayOf(it)
                    )
                )
            })
        }
        binding.recyclerView.adapter = listAdapter
        (binding.recyclerView.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
        binding.swipeRefresh.isEnabled = true
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            if (activity?.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                binding.recyclerView.updatePadding(bottom = insets.bottom)
            }
            WindowInsetsCompat.CONSUMED
        }
    }

    override fun onResume() {
        super.onResume()
        maybeRefreshOnReturn()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            maybeRefreshOnReturn()
        }
    }

    private fun maybeRefreshOnReturn() {
        if (!isAdded || isHidden) return
        val prefs = requireContext().prefs()
        val refreshOnReturn = prefs.getBoolean(AppConstants.FOLLOWED_LIVE_REFRESH_ON_RETURN, true)
        if (refreshOnReturn) {
            viewModel.maybeRefreshIfStale(minAgeMs = 30_000L, silent = true)
        }
    }

    override fun initialize() {
        viewModel.initialize()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { state ->
                    val shouldScrollToTop = wasRefreshing && !state.isRefreshing && state.items.isNotEmpty()
                    @Suppress("UNCHECKED_CAST")
                    (listAdapter as ListAdapter<Stream, RecyclerView.ViewHolder>).submitList(state.items.toList()) {
                        if (shouldScrollToTop || scrollToTopAfterSort) {
                            binding.recyclerView.scrollToPosition(0)
                            scrollToTopAfterSort = false
                        }
                    }
                    binding.progressBar.isVisible = state.isInitialLoading && state.items.isEmpty()
                    binding.swipeRefresh.isRefreshing = state.isRefreshing && state.items.isNotEmpty()
                    binding.nothingHere.isVisible = state.showEmpty
                    if (state.integrityAction == "refresh" &&
                        requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                        requireContext().prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
                    ) {
                        viewModel.clearIntegrityAction()
                        IntegrityDialog.show(childFragmentManager, "refresh")
                    }
                    wasRefreshing = state.isRefreshing
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                while (true) {
                    val rawInterval = requireContext().prefs()
                        .getString(AppConstants.FOLLOWED_LIVE_AUTO_REFRESH_INTERVAL, "60")
                    val intervalSeconds = rawInterval?.toLongOrNull() ?: 60L
                    if (intervalSeconds <= 0L) {
                        // Polling disabled; sleep for a minute before checking preference again
                        kotlinx.coroutines.delay(60_000L)
                        continue
                    }
                    kotlinx.coroutines.delay(intervalSeconds * 1000L)
                    if (isAdded && !isHidden && isResumed) {
                        viewModel.refresh(silent = true)
                    }
                }
            }
        }
        if (requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
            requireContext().prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true) &&
            KickApiHelper.isIntegrityTokenExpired(requireContext())
        ) {
            IntegrityDialog.show(childFragmentManager, "refresh")
        }
    }

    override fun setupSortBar(sortBar: SortBarBinding) {
        sortBar.root.visibility = View.VISIBLE
        sortBar.root.setOnClickListener {
            FollowedStreamsSortDialog.newInstance(viewModel.sort.value)
                .show(childFragmentManager, null)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sortText.collectLatest {
                    sortBar.sortText.text = it
                }
            }
        }
    }

    override fun onChange(sort: String, sortText: CharSequence, changed: Boolean, saveDefault: Boolean) {
        if (changed) {
            scrollToTopAfterSort = true
        }
        if (changed || saveDefault) {
            viewModel.setSort(sort, persist = saveDefault)
        }
    }

    override fun scrollToTop() {
        binding.recyclerView.scrollToPosition(0)
    }

    override fun onNetworkRestored() {
        viewModel.refresh()
    }

    override fun onIntegrityDialogCallback(callback: String?) {
        viewModel.clearIntegrityAction()
        if (callback == "refresh") {
            viewModel.refresh()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
