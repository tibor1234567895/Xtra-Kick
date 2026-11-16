package com.xtrakick.app.ui.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentCollectiblesBinding
import com.xtrakick.app.model.kick.KickCollectible
import com.xtrakick.app.model.kick.KickUserLevel
import com.xtrakick.app.ui.view.SafeGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Locale

@AndroidEntryPoint
class CollectiblesFragment : Fragment(R.layout.fragment_collectibles) {

    private val viewModel: CollectiblesViewModel by viewModels()

    private var _binding: FragmentCollectiblesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CollectiblesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCollectiblesBinding.bind(view)

        ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            binding.toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }
            WindowInsetsCompat.CONSUMED
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        setupRecyclerView()

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadCollectibles()
        }

        binding.retryButton.setOnClickListener {
            viewModel.loadCollectibles()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    render(state)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = CollectiblesAdapter { collectible ->
            CollectiblesPreviewBottomSheet.show(parentFragmentManager, collectible)
        }

        val gridLayoutManager = SafeGridLayoutManager(requireContext(), 3)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                when (adapter.getItemViewType(position)) {
                    CollectiblesAdapter.TYPE_OVERVIEW,
                    CollectiblesAdapter.TYPE_HEADER -> 3
                    else -> 1
                }
        }

        binding.collectiblesRecycler.layoutManager = gridLayoutManager
        binding.collectiblesRecycler.adapter = adapter
    }

    private fun render(state: CollectiblesViewModel.UiState) {
        val showInitialLoading = state.isLoading && state.collectibles.isEmpty()
        binding.loadingIndicator.isVisible = showInitialLoading
        binding.swipeRefresh.isRefreshing = state.isLoading && state.collectibles.isNotEmpty()

        if (showInitialLoading) {
            binding.errorContainer.isVisible = false
            return
        }

        if (state.errorRes != null) {
            binding.errorContainer.isVisible = true
            binding.errorText.setText(state.errorRes)
            binding.retryButton.isVisible = true
            adapter.submitList(emptyList())
        } else if (state.collectibles.isEmpty()) {
            binding.errorContainer.isVisible = true
            binding.errorText.setText(R.string.collectibles_empty)
            binding.retryButton.isVisible = false
            adapter.submitList(emptyList())
        } else {
            binding.errorContainer.isVisible = false
            adapter.submitList(buildListItems(state.collectibles, state.userLevel))
        }
    }

    private fun buildListItems(
        collectibles: List<KickCollectible>,
        userLevel: KickUserLevel?,
    ): List<CollectiblesListItem> {
        val result = mutableListOf<CollectiblesListItem>()

        val totalUnlocked = collectibles.count { it.owned }
        val totalCount = collectibles.size

        // Item 0: Overview Header
        result.add(CollectiblesListItem.Overview(totalUnlocked, totalCount, userLevel))

        // Order of rarity tiers descending
        val rarityOrder = listOf("mythic", "legendary", "epic", "rare", "uncommon", "common")

        // Group by normalized lowercase rarity
        val groups = collectibles.groupBy { it.rarity.lowercase(Locale.ROOT) }

        rarityOrder.forEach { rarityKey ->
            val itemsInTier = groups[rarityKey].orEmpty()
            if (itemsInTier.isNotEmpty()) {
                val unlockedInTier = itemsInTier.count { it.owned }
                result.add(CollectiblesListItem.Header(rarityKey, unlockedInTier, itemsInTier.size))

                // Sort: unlocked (owned == true) first, then by name
                val sortedCards = itemsInTier.sortedWith(
                    compareByDescending<KickCollectible> { it.owned }.thenBy { it.name }
                )
                sortedCards.forEach { card ->
                    result.add(CollectiblesListItem.Card(card))
                }
            }
        }

        // Include any remaining unknown rarities if present
        groups.keys.filter { it !in rarityOrder }.forEach { otherRarity ->
            val itemsInTier = groups[otherRarity].orEmpty()
            if (itemsInTier.isNotEmpty()) {
                val unlockedInTier = itemsInTier.count { it.owned }
                result.add(CollectiblesListItem.Header(otherRarity, unlockedInTier, itemsInTier.size))
                itemsInTier.sortedByDescending { it.owned }.forEach { card ->
                    result.add(CollectiblesListItem.Card(card))
                }
            }
        }

        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
