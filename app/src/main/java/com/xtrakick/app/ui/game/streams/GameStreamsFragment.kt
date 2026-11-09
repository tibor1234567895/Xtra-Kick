package com.xtrakick.app.ui.game.streams

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
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.databinding.CommonRecyclerViewLayoutBinding
import com.xtrakick.app.databinding.SortBarBinding
import com.xtrakick.app.model.ui.SavedFilter
import com.xtrakick.app.model.ui.SortGame
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.ui.common.ActiveTagsAdapter
import com.xtrakick.app.ui.common.FragmentHost
import com.xtrakick.app.ui.common.IntegrityDialog
import com.xtrakick.app.ui.common.PagedListFragment
import com.xtrakick.app.ui.common.Scrollable
import com.xtrakick.app.ui.common.Sortable
import com.xtrakick.app.ui.common.StreamsAdapter
import com.xtrakick.app.ui.common.StreamsCompactAdapter
import com.xtrakick.app.ui.common.StreamsSortDialog
import com.xtrakick.app.ui.common.TagFilterHelper
import com.xtrakick.app.ui.common.StreamsSortDialog.Companion.RECENT
import com.xtrakick.app.ui.common.StreamsSortDialog.Companion.SORT_VIEWERS
import com.xtrakick.app.ui.common.StreamsSortDialog.Companion.SORT_VIEWERS_ASC
import com.xtrakick.app.ui.game.GamePagerFragmentArgs
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameStreamsFragment : PagedListFragment(), Scrollable, Sortable, StreamsSortDialog.OnFilter {

    private var _binding: CommonRecyclerViewLayoutBinding? = null
    private val binding get() = _binding!!
    private val args: GamePagerFragmentArgs by navArgs()
    private val viewModel: GameStreamsViewModel by viewModels()
    private lateinit var pagingAdapter: PagingDataAdapter<Stream, out RecyclerView.ViewHolder>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CommonRecyclerViewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagingAdapter = if (requireContext().prefs().getString(AppConstants.COMPACT_STREAMS, "disabled") == "all") {
            StreamsCompactAdapter(this, { toggleTag(it) }, showGame = false)
        } else {
            StreamsAdapter(this, { toggleTag(it) }, showGame = false)
        }
        setAdapter(binding.recyclerView, pagingAdapter)
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            if (activity?.findViewById<LinearLayout>(R.id.navBarContainer)?.isVisible == false) {
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                binding.recyclerView.updatePadding(bottom = insets.bottom)
            }
            WindowInsetsCompat.CONSUMED
        }
    }

    private fun getEffectiveGameId(): String? {
        val slug = KickApiHelper.resolveEffectiveCategorySlug(args.gameSlug, args.gameName)
        return KickApiHelper.sanitizeGameId(args.gameId, slug)
            ?: viewModel.getCachedCategoryId(slug, args.gameName)
    }

    override fun initialize() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (viewModel.filter.value == null) {
                val effectiveId = getEffectiveGameId()
                val sortValues = effectiveId?.let { viewModel.getSortGame(it) } ?: viewModel.getSortGame("default")
                viewModel.setFilter(
                    sort = sortValues?.streamSort,
                    tags = args.tags ?: sortValues?.streamTags?.split(',')?.toTypedArray(),
                    languages = args.languages ?: sortValues?.streamLanguages?.split(',')?.toTypedArray(),
                )
            }
            // Recompute every time so the sort bar follows app-locale changes
            viewModel.sortText.value = getString(
                R.string.sort_by,
                getString(
                    when (viewModel.sort) {
                        SORT_VIEWERS -> R.string.viewers_high
                        SORT_VIEWERS_ASC -> R.string.viewers_low
                        RECENT -> R.string.recent
                        else -> R.string.viewers_high
                    }
                )
            )
            viewModel.filtersText.value = if (viewModel.tags.isNotEmpty() || viewModel.languages.isNotEmpty()) {
                buildString {
                    if (viewModel.tags.isNotEmpty()) {
                        append(
                            resources.getQuantityString(
                                R.plurals.tags,
                                viewModel.tags.size,
                                viewModel.tags.joinToString()
                            )
                        )
                    }
                    if (viewModel.languages.isNotEmpty()) {
                        if (isNotEmpty()) {
                            append(". ")
                        }
                        append(
                            resources.getQuantityString(
                                R.plurals.languages,
                                viewModel.languages.size,
                                viewModel.languages.joinToString()
                            )
                        )
                    }
                }
            } else null
            (pagingAdapter as? ActiveTagsAdapter)?.activeTags = viewModel.tags.toSet()
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.flow.collectLatest { pagingData ->
                    pagingAdapter.submitData(pagingData)
                }
            }
        }
        initializeAdapter(binding, pagingAdapter, enableScrollTopButton = args.gameId != null || args.gameName != null || !args.tags.isNullOrEmpty())
    }

    override fun setupSortBar(sortBar: SortBarBinding) {
        sortBar.root.visibility = View.VISIBLE
        sortBar.root.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                StreamsSortDialog.newInstance(
                    sort = viewModel.sort,
                    tags = viewModel.tags,
                    languages = viewModel.languages,
                    saved = getEffectiveGameId()?.let { viewModel.getSortGame(it) } != null
                ).show(childFragmentManager, null)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sortText.collectLatest {
                    sortBar.sortText.text = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.filtersText.collectLatest {
                    if (it != null) {
                        sortBar.filtersText.visibility = View.VISIBLE
                        sortBar.filtersText.text = it
                    } else {
                        sortBar.filtersText.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun toggleTag(tag: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            val newTags = TagFilterHelper.toggleTag(viewModel.tags.toList(), tag)
            viewModel.setFilter(viewModel.sort, newTags, viewModel.languages)
            updateFiltersText()
            (pagingAdapter as? ActiveTagsAdapter)?.activeTags = newTags.toSet()
        }
    }

    private fun updateFiltersText() {
        viewModel.filtersText.value = TagFilterHelper.formatFiltersText(resources, viewModel.tags.toList(), viewModel.languages.toList())
    }

    override fun onChange(sort: String, sortText: CharSequence, tags: Array<String>, languages: Array<String>, changed: Boolean, saveFilters: Boolean, saveSort: Boolean, saveDefault: Boolean) {
        if ((parentFragment as? FragmentHost)?.currentFragment == this) {
            viewLifecycleOwner.lifecycleScope.launch {
                if (changed) {
                    viewModel.setFilter(sort, tags, languages)
                    viewModel.sortText.value = getString(R.string.sort_by, sortText)
                    updateFiltersText()
                    (pagingAdapter as? ActiveTagsAdapter)?.activeTags = tags.toSet()
                }
                val effectiveGameId = getEffectiveGameId()
                val effectiveSlug = KickApiHelper.resolveEffectiveCategorySlug(args.gameSlug, args.gameName)
                if (saveFilters && (tags.isNotEmpty() || languages.isNotEmpty())) {
                    viewModel.saveFilters(
                        SavedFilter(
                            gameId = effectiveGameId,
                            gameSlug = effectiveSlug,
                            gameName = args.gameName,
                            tags = tags.takeIf { it.isNotEmpty() }?.joinToString(","),
                            languages = languages.takeIf { it.isNotEmpty() }?.joinToString(",")
                        )
                    )
                }
                if (saveSort) {
                    effectiveGameId?.let { id ->
                        val item = viewModel.getSortGame(id)?.apply {
                            streamSort = sort
                            streamTags = tags.takeIf { it.isNotEmpty() }?.joinToString(",")
                            streamLanguages = languages.takeIf { it.isNotEmpty() }?.joinToString(",")
                        } ?: SortGame(
                            id = id,
                            streamSort = sort,
                            streamTags = tags.takeIf { it.isNotEmpty() }?.joinToString(","),
                            streamLanguages = languages.takeIf { it.isNotEmpty() }?.joinToString(",")
                        )
                        viewModel.saveSortGame(item)
                    }
                }
                if (saveDefault) {
                    val item = viewModel.getSortGame("default")?.apply {
                        streamSort = sort
                        streamTags = tags.takeIf { it.isNotEmpty() }?.joinToString(",")
                        streamLanguages = languages.takeIf { it.isNotEmpty() }?.joinToString(",")
                    } ?: SortGame(
                        id = "default",
                        streamSort = sort,
                        streamTags = tags.takeIf { it.isNotEmpty() }?.joinToString(","),
                        streamLanguages = languages.takeIf { it.isNotEmpty() }?.joinToString(",")
                    )
                    viewModel.saveSortGame(item)
                }
            }
        }
    }

    override fun deleteSavedSort() {
        if ((parentFragment as? FragmentHost)?.currentFragment == this) {
            viewLifecycleOwner.lifecycleScope.launch {
                getEffectiveGameId()?.let { viewModel.getSortGame(it) }?.let { viewModel.deleteSortGame(it) }
            }
        }
    }

    override fun scrollToTop() {
        binding.recyclerView.scrollToPosition(0)
    }

    override fun onNetworkRestored() {
        pagingAdapter.retry()
    }

    override fun onIntegrityDialogCallback(callback: String?) {
        (parentFragment as? IntegrityDialog.CallbackListener)?.onIntegrityDialogCallback("refresh")
        if (callback == "refresh") {
            pagingAdapter.refresh()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
