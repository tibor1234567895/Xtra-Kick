package com.xtrakick.app.ui.common

import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.databinding.CommonRecyclerViewLayoutBinding
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class PagedListFragment : BaseNetworkFragment(), IntegrityDialog.CallbackListener {

    @Inject lateinit var eventRepository: KickRepository

    var concatAdapter: RecyclerView.Adapter<*>? = null
        protected set

    fun <T : Any, VH : RecyclerView.ViewHolder> setAdapter(
        recyclerView: RecyclerView,
        adapter: PagingDataAdapter<T, VH>,
        withFooter: Boolean = true
    ) {
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                adapter.unregisterAdapterDataObserver(this)
                adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                        try {
                            if (positionStart == 0) {
                                recyclerView.scrollToPosition(0)
                            }
                        } catch (e: Exception) {

                        }
                    }
                })
            }
        })
        val targetAdapter: RecyclerView.Adapter<*> = if (withFooter) {
            val footerAdapter = CommonLoadStateAdapter { adapter.retry() }
            val combined = adapter.withLoadStateFooter(footerAdapter)
            (recyclerView.layoutManager as? GridLayoutManager)?.let { glm ->
                val defaultSpanLookup = glm.spanSizeLookup
                glm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (position >= adapter.itemCount) {
                            glm.spanCount
                        } else {
                            defaultSpanLookup.getSpanSize(position)
                        }
                    }
                }
            }
            combined
        } else {
            adapter
        }
        concatAdapter = targetAdapter
        recyclerView.adapter = targetAdapter
        if (adapter is StreamsAdapter || adapter is StreamsCompactAdapter) {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    combine(eventRepository.channelEventTitles, adapter.onPagesUpdatedFlow.onStart { emit(Unit) }) { titles, _ -> titles }
                        .collectLatest { titles ->
                            adapter.snapshot().forEachIndexed { index, item ->
                                if (item is Stream && titles.containsKey(item.channelId)) {
                                    val title = titles[item.channelId]
                                    if (item.eventTitle != title) {
                                        val tags = item.tags.orEmpty().filterNot { it == item.eventTitle }
                                        item.eventTitle = title
                                        item.tags = (listOfNotNull(title) + tags).distinct().ifEmpty { null }
                                        adapter.notifyItemChanged(index)
                                    }
                                }
                            }
                        }
                }
            }
        }
    }

    fun shouldShowButton(recyclerView: RecyclerView): Boolean {
        val offset = recyclerView.computeVerticalScrollOffset()
        if (offset < 0) {
            return false
        }
        val extent = recyclerView.computeVerticalScrollExtent()
        val range = recyclerView.computeVerticalScrollRange()
        val scrollableRange = range - extent
        if (scrollableRange <= 0) {
            return false
        }
        val percentage = (100f * offset / scrollableRange.toFloat())
        return percentage > 3f
    }

    fun <T : Any, VH : RecyclerView.ViewHolder> initializeAdapter(binding: CommonRecyclerViewLayoutBinding, pagingAdapter: PagingDataAdapter<T, VH>, enableSwipeRefresh: Boolean = true, enableScrollTopButton: Boolean = true) {
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    pagingAdapter.loadStateFlow.collectLatest { loadState ->
                        progressBar.isVisible = loadState.refresh is LoadState.Loading && pagingAdapter.itemCount == 0
                        if (enableSwipeRefresh) {
                            swipeRefresh.isRefreshing = loadState.refresh is LoadState.Loading && pagingAdapter.itemCount != 0
                        }
                        nothingHere.isVisible = loadState.refresh !is LoadState.Loading && loadState.append !is LoadState.Loading && pagingAdapter.itemCount == 0
                        if ((loadState.refresh as? LoadState.Error ?:
                            loadState.append as? LoadState.Error ?:
                            loadState.prepend as? LoadState.Error)?.error?.message == "failed integrity check" &&
                            requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                            requireContext().prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
                        ) {
                            IntegrityDialog.show(childFragmentManager, "refresh")
                        }
                    }
                }
            }
            if (enableSwipeRefresh) {
                swipeRefresh.isEnabled = true
                swipeRefresh.setOnRefreshListener { pagingAdapter.refresh() }
            }
            if (enableScrollTopButton && requireContext().prefs().getBoolean(AppConstants.UI_SCROLLTOP, true)) {
                recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        scrollTop.isVisible = shouldShowButton(recyclerView)
                    }
                })
                scrollTop.setOnClickListener {
                    (parentFragment as? Scrollable)?.scrollToTop()
                    it.visibility = View.GONE
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
}
