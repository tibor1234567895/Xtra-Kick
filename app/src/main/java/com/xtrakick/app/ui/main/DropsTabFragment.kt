package com.xtrakick.app.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentDropsTabBinding
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import kotlinx.coroutines.launch

class DropsTabFragment : Fragment() {

    companion object {
        private const val ARG_TAB_INDEX = "tab_index"

        const val TAB_ACTIVE = 0
        const val TAB_UPCOMING = 1
        const val TAB_CLAIMED = 2
        const val TAB_EXPIRED = 3

        fun newInstance(tabIndex: Int): DropsTabFragment =
            DropsTabFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TAB_INDEX, tabIndex)
                }
            }
    }

    private val viewModel: DropsViewModel by viewModels({ requireParentFragment() })

    private var _binding: FragmentDropsTabBinding? = null
    private val binding get() = _binding!!

    private var tabIndex: Int = TAB_ACTIVE

    private lateinit var campaignsAdapter: DropsCampaignsAdapter
    private lateinit var claimedAdapter: DropsClaimedAdapter

    private var filterOnlyProgress = false
    private var selectedCategoryName: String? = null
    private var currentCampaigns: List<KickDropCampaignFull> = emptyList()
    private var errorResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabIndex = arguments?.getInt(ARG_TAB_INDEX, TAB_ACTIVE) ?: TAB_ACTIVE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDropsTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapters()

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadCampaigns()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.isLoading.collect { loading ->
                        binding.swipeRefresh.isRefreshing = loading
                        binding.loadingIndicator.isVisible = loading && getItemCount() == 0
                        renderTabContent(currentCampaigns)
                    }
                }
                launch {
                    viewModel.campaigns.collect { allCampaigns ->
                        renderTabContent(allCampaigns)
                    }
                }
                launch {
                    viewModel.errorRes.collect { resId ->
                        errorResId = resId
                        renderTabContent(currentCampaigns)
                    }
                }
            }
        }
    }

    private fun setupAdapters() {
        campaignsAdapter = DropsCampaignsAdapter(
            onParticipate = { campaign -> handleParticipate(campaign) },
            onMoreDetails = { campaign -> handleMoreDetails(campaign) },
            onClaimReward = { campaign, reward ->
                viewModel.claimReward(campaign, reward) { success ->
                    if (!isAdded) return@claimReward
                    val msgRes = if (success) R.string.drops_claim_success else R.string.drops_claim_failed
                    Toast.makeText(requireContext(), msgRes, Toast.LENGTH_SHORT).show()
                }
            },
        )
        claimedAdapter = DropsClaimedAdapter { campaign -> handleParticipate(campaign) }

        if (tabIndex == TAB_CLAIMED) {
            binding.itemsRecycler.adapter = claimedAdapter
        } else {
            binding.itemsRecycler.adapter = campaignsAdapter
            binding.yourProgressChip.isChecked = filterOnlyProgress
            binding.yourProgressChip.setOnCheckedChangeListener { _, isChecked ->
                filterOnlyProgress = isChecked
                filterAndSubmitActive()
            }
        }
    }

    private fun handleParticipate(campaign: KickDropCampaignFull) {
        if (campaign.isChannelSpecific) {
            val singleSlug = campaign.participatingChannels.firstOrNull()?.slug
                ?: campaign.channels.firstOrNull()
            if (campaign.channels.size == 1 && !singleSlug.isNullOrBlank()) {
                try {
                    findNavController().navigate(
                        ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                            channelLogin = singleSlug
                        )
                    )
                } catch (_: Exception) {
                }
                return
            } else if (campaign.channels.size > 1 || campaign.participatingChannels.isNotEmpty()) {
                DropsParticipatingChannelsBottomSheet.show(parentFragmentManager, campaign)
                return
            }
        }

        val category = campaign.category
        val gameName = category?.name?.takeIf { it.isNotBlank() } ?: campaign.name
        val gameSlug = category?.slug?.takeIf { it.isNotBlank() }
        val gameId = category?.id?.toString()
        val boxArt = category?.imageUrl

        val resolvedSlug = KickApiHelper.resolveEffectiveCategorySlug(gameSlug, gameName)
        val resolvedId = KickApiHelper.sanitizeGameId(gameId, resolvedSlug)

        val prefs = requireContext().prefs()
        val isGamePager = prefs.getBoolean(AppConstants.UI_GAMEPAGER, true)

        try {
            findNavController().navigate(
                if (isGamePager) {
                    GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                        gameId = resolvedId,
                        gameSlug = resolvedSlug,
                        gameName = gameName,
                        boxArt = boxArt
                    )
                } else {
                    GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                        gameId = resolvedId,
                        gameSlug = resolvedSlug,
                        gameName = gameName,
                        boxArt = boxArt
                    )
                }
            )
        } catch (_: Exception) {
        }
    }

    private fun handleMoreDetails(campaign: KickDropCampaignFull) {
        val url = campaign.url?.takeIf { it.isNotBlank() }
            ?: campaign.connectUrl?.takeIf { it.isNotBlank() }
            ?: campaign.category?.slug?.let { "https://kick.com/category/$it" }
            ?: "https://kick.com"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (_: Exception) {
        }
    }

    private fun getItemCount(): Int =
        if (tabIndex == TAB_CLAIMED) claimedAdapter.itemCount else campaignsAdapter.itemCount

    private fun renderTabContent(allCampaigns: List<KickDropCampaignFull>) {
        currentCampaigns = allCampaigns
        when (tabIndex) {
            TAB_ACTIVE -> {
                val activeCampaigns = allCampaigns.filter { it.isActive }
                setupFilterChips(activeCampaigns)
                filterAndSubmitActive()
            }
            TAB_UPCOMING -> {
                val upcoming = allCampaigns.filter { it.isUpcoming }
                campaignsAdapter.submitList(upcoming)
                updateEmptyState(upcoming.isEmpty(), R.string.drops_empty_upcoming)
            }
            TAB_CLAIMED -> {
                val claimedEntries = allCampaigns.flatMap { c ->
                    c.rewards.filter { it.claimed }.map { reward ->
                        ClaimedRewardEntry(reward, c.category?.name ?: c.name, c)
                    }
                }
                claimedAdapter.submitList(claimedEntries)
                updateEmptyState(claimedEntries.isEmpty(), R.string.drops_empty_claimed)
            }
            TAB_EXPIRED -> {
                val expired = allCampaigns.filter { it.isExpired }
                campaignsAdapter.submitList(expired)
                updateEmptyState(expired.isEmpty(), R.string.drops_empty_expired)
            }
        }
    }

    private fun filterAndSubmitActive() {
        val activeCampaigns = currentCampaigns.filter { it.isActive }
        val filtered = applyFilters(activeCampaigns)
        campaignsAdapter.submitList(filtered)
        updateEmptyState(filtered.isEmpty(), R.string.drops_empty_active)
    }

    private fun applyFilters(campaigns: List<KickDropCampaignFull>): List<KickDropCampaignFull> {
        return campaigns.filter { campaign ->
            val matchesProgress = !filterOnlyProgress || campaign.hasProgress
            val matchesCategory = selectedCategoryName == null || campaign.category?.name == selectedCategoryName
            matchesProgress && matchesCategory
        }
    }

    private fun setupFilterChips(activeCampaigns: List<KickDropCampaignFull>) {
        binding.filterChipsScroll.isVisible = activeCampaigns.isNotEmpty()
        if (activeCampaigns.isEmpty()) return

        val currentContext = context ?: return
        val categories = activeCampaigns.mapNotNull { it.category?.name?.takeIf { n -> n.isNotBlank() } }.distinct()

        if (selectedCategoryName != null && selectedCategoryName !in categories) {
            selectedCategoryName = null
        }

        val existingCategories = (1 until binding.filterChipsGroup.childCount).mapNotNull { i ->
            (binding.filterChipsGroup.getChildAt(i) as? Chip)?.text?.toString()
        }

        if (existingCategories == categories) return

        while (binding.filterChipsGroup.childCount > 1) {
            binding.filterChipsGroup.removeViewAt(1)
        }

        val inflater = LayoutInflater.from(currentContext)
        categories.forEach { catName ->
            val catChip = (inflater.inflate(R.layout.item_filter_chip, binding.filterChipsGroup, false) as Chip).apply {
                text = catName
                isChecked = (selectedCategoryName == catName)
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        selectedCategoryName = catName
                    } else if (selectedCategoryName == catName) {
                        selectedCategoryName = null
                    } else {
                        return@setOnCheckedChangeListener
                    }
                    if (isChecked) {
                        for (i in 1 until binding.filterChipsGroup.childCount) {
                            val other = binding.filterChipsGroup.getChildAt(i) as? Chip
                            if (other != null && other != this && other.isChecked) {
                                other.isChecked = false
                            }
                        }
                    }
                    filterAndSubmitActive()
                }
            }
            binding.filterChipsGroup.addView(catChip)
        }
    }

    private fun updateEmptyState(isEmpty: Boolean, emptyMsgResId: Int) {
        val isLoading = binding.loadingIndicator.isVisible || binding.swipeRefresh.isRefreshing
        binding.emptyText.isVisible = isEmpty && !isLoading
        if (isEmpty && !isLoading) {
            binding.emptyText.setText(errorResId ?: emptyMsgResId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
