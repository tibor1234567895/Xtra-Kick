package com.xtrakick.app.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.BundleCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.databinding.DialogDropsParticipatingChannelsBinding
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.model.kick.KickDropParticipatingChannel
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class DropsParticipatingChannelsBottomSheet : BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "DropsParticipatingChannelsBottomSheet"
        private const val ARG_CAMPAIGN_ID = "campaign_id"
        private const val ARG_CAMPAIGN_NAME = "campaign_name"
        private const val ARG_CHANNELS = "channels"

        fun show(fragmentManager: FragmentManager, campaign: KickDropCampaignFull) {
            val sheet = DropsParticipatingChannelsBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_CAMPAIGN_ID, campaign.id)
                    putString(
                        ARG_CAMPAIGN_NAME,
                        campaign.category?.name?.takeIf { it.isNotBlank() } ?: campaign.name
                    )
                    putSerializable(ARG_CHANNELS, ArrayList(campaign.participatingChannels))
                }
            }
            sheet.show(fragmentManager, TAG)
        }
    }

    @Inject
    lateinit var rewardsRepository: KickRewardsRepository

    private var _binding: DialogDropsParticipatingChannelsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: DropsParticipatingChannelsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogDropsParticipatingChannelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val campaignId = arguments?.getString(ARG_CAMPAIGN_ID).orEmpty()
        val campaignName = arguments?.getString(ARG_CAMPAIGN_NAME).orEmpty()

        @Suppress("UNCHECKED_CAST")
        val initialChannels = (arguments?.let { BundleCompat.getSerializable(it, ARG_CHANNELS, ArrayList::class.java) } as? ArrayList<KickDropParticipatingChannel>).orEmpty()

        binding.campaignSubtitle.text = campaignName
        binding.closeButton.setOnClickListener { dismiss() }

        adapter = DropsParticipatingChannelsAdapter { channel ->
            dismiss()
            try {
                findNavController().navigate(
                    ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                        channelLogin = channel.slug
                    )
                )
            } catch (_: Exception) {
            }
        }
        binding.channelsRecycler.adapter = adapter

        if (initialChannels.isNotEmpty()) {
            adapter.submitList(initialChannels)
        }

        if (campaignId.isNotBlank()) {
            loadCampaignLiveChannels(campaignId, initialChannels)
        } else {
            updateEmptyState(initialChannels.isEmpty())
        }
    }

    private fun loadCampaignLiveChannels(
        campaignId: String,
        initialChannels: List<KickDropParticipatingChannel>,
    ) {
        binding.progressBar.isVisible = initialChannels.isEmpty()

        viewLifecycleOwner.lifecycleScope.launch {
            val liveChannels = withContext(Dispatchers.IO) {
                rewardsRepository.getCampaignLivestreams(campaignId)
            }
            if (!isAdded) return@launch
            binding.progressBar.isVisible = false

            val mergedList = if (liveChannels.isNotEmpty()) {
                val liveSlugs = liveChannels.map { it.slug.lowercase() }.toSet()
                val updatedInitial = initialChannels.map { ch ->
                    if (ch.slug.lowercase() in liveSlugs) ch.copy(isLive = true) else ch
                }
                val initialSlugs = initialChannels.map { it.slug.lowercase() }.toSet()
                val newDiscovered = liveChannels.filter { it.slug.lowercase() !in initialSlugs }
                (updatedInitial + newDiscovered).sortedByDescending { it.isLive }
            } else {
                initialChannels
            }

            adapter.submitList(mergedList)
            updateEmptyState(mergedList.isEmpty())
        }
    }

    private fun updateEmptyState(isEmpty: Boolean) {
        binding.emptyStateText.isVisible = isEmpty
        binding.channelsRecycler.isVisible = !isEmpty
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
