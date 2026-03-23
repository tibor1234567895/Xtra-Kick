package com.github.andreyasadchy.xtra.ui.following.streams

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
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.CommonRecyclerViewLayoutBinding
import com.github.andreyasadchy.xtra.databinding.SortBarBinding
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.ui.common.BaseNetworkFragment
import com.github.andreyasadchy.xtra.ui.common.IntegrityDialog
import com.github.andreyasadchy.xtra.ui.common.Scrollable
import com.github.andreyasadchy.xtra.ui.common.Sortable
import com.github.andreyasadchy.xtra.ui.common.StreamsCompactListAdapter
import com.github.andreyasadchy.xtra.ui.common.StreamsListAdapter
import com.github.andreyasadchy.xtra.ui.top.TopStreamsFragmentDirections
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FollowedStreamsFragment : BaseNetworkFragment(), Scrollable, Sortable, IntegrityDialog.CallbackListener {

    private var _binding: CommonRecyclerViewLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FollowedStreamsViewModel by viewModels()
    private lateinit var listAdapter: ListAdapter<Stream, out RecyclerView.ViewHolder>
    private var wasRefreshing = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CommonRecyclerViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = if (requireContext().prefs().getString(C.COMPACT_STREAMS, "disabled") != "disabled") {
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

    override fun initialize() {
        viewModel.initialize()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { state ->
                    val shouldScrollToTop = wasRefreshing && !state.isRefreshing && state.items.isNotEmpty()
                    @Suppress("UNCHECKED_CAST")
                    (listAdapter as ListAdapter<Stream, RecyclerView.ViewHolder>).submitList(state.items.toList()) {
                        if (shouldScrollToTop) {
                            binding.recyclerView.scrollToPosition(0)
                        }
                    }
                    binding.progressBar.isVisible = state.isInitialLoading && state.items.isEmpty()
                    binding.swipeRefresh.isRefreshing = state.isRefreshing && state.items.isNotEmpty()
                    binding.nothingHere.isVisible = state.showEmpty
                    if (state.integrityAction == "refresh" &&
                        requireContext().prefs().getBoolean(C.ENABLE_INTEGRITY, false) &&
                        requireContext().prefs().getBoolean(C.USE_WEBVIEW_INTEGRITY, true)
                    ) {
                        viewModel.clearIntegrityAction()
                        IntegrityDialog.show(childFragmentManager, "refresh")
                    }
                    wasRefreshing = state.isRefreshing
                }
            }
        }
        if (requireContext().prefs().getBoolean(C.ENABLE_INTEGRITY, false) &&
            requireContext().prefs().getBoolean(C.USE_WEBVIEW_INTEGRITY, true) &&
            KickApiHelper.isIntegrityTokenExpired(requireContext())
        ) {
            IntegrityDialog.show(childFragmentManager, "refresh")
        }
    }

    override fun setupSortBar(sortBar: SortBarBinding) {
        sortBar.root.visibility = View.VISIBLE
        sortBar.root.setOnClickListener(null)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sortText.collectLatest {
                    sortBar.sortText.text = it
                }
            }
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
