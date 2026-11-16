package com.xtrakick.app.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ItemDropCampaignBinding
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.model.kick.KickDropRewardItem
import java.text.DateFormat
import java.util.Date

class DropsCampaignsAdapter(
    private val onParticipate: (KickDropCampaignFull) -> Unit,
    private val onMoreDetails: (KickDropCampaignFull) -> Unit,
    private val onClaimReward: (KickDropCampaignFull, KickDropRewardItem) -> Unit,
) : ListAdapter<KickDropCampaignFull, DropsCampaignsAdapter.CampaignViewHolder>(DiffCallback) {

    companion object {
        private object DiffCallback : DiffUtil.ItemCallback<KickDropCampaignFull>() {
            override fun areItemsTheSame(oldItem: KickDropCampaignFull, newItem: KickDropCampaignFull): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: KickDropCampaignFull, newItem: KickDropCampaignFull): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignViewHolder {
        val binding = ItemDropCampaignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CampaignViewHolder(
        private val binding: ItemDropCampaignBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentCampaign: KickDropCampaignFull? = null

        private val rewardsAdapter = DropsRewardsAdapter(
            onClaimClick = { reward -> currentCampaign?.let { onClaimReward(it, reward) } },
            onRewardClick = { currentCampaign?.let { onParticipate(it) } },
        )

        init {
            binding.rewardsRecycler.adapter = rewardsAdapter
        }

        fun bind(campaign: KickDropCampaignFull) {
            currentCampaign = campaign
            val context = binding.root.context
            val bannerUrl = campaign.category?.bannerImageUrl?.takeIf { it.isNotBlank() }
                ?: campaign.category?.imageUrl?.takeIf { it.isNotBlank() }

            Glide.with(itemView)
                .load(bannerUrl)
                .placeholder(R.drawable.bg_bottom_sheet_surface)
                .error(R.drawable.bg_bottom_sheet_surface)
                .into(binding.campaignBanner)

            binding.campaignTitle.text = campaign.category?.name?.takeIf { it.isNotBlank() } ?: campaign.name

            val orgName = campaign.organization?.name?.takeIf { it.isNotBlank() } ?: "KICK"
            val ruleName = campaign.rule?.name?.takeIf { it.isNotBlank() }
            binding.organizationText.text = when {
                campaign.isChannelSpecific && campaign.channels.size == 1 -> {
                    context.getString(R.string.drops_channel_event_single, orgName, campaign.channels.first())
                }
                campaign.isChannelSpecific && campaign.channels.size > 1 -> {
                    context.getString(R.string.drops_channel_event_multiple, orgName, campaign.channels.size)
                }
                ruleName != null -> "$orgName • $ruleName"
                else -> orgName
            }

            // Drops count badge (Active Drops only on active campaigns, total drops on upcoming/expired)
            val rewardCount = campaign.rewards.size
            binding.dropsCountBadge.isVisible = rewardCount > 0
            binding.activeDropsText.text = if (campaign.isActive) {
                context.resources.getQuantityString(
                    R.plurals.drops_active_count,
                    rewardCount,
                    rewardCount,
                )
            } else {
                context.resources.getQuantityString(
                    R.plurals.drops_count,
                    rewardCount,
                    rewardCount,
                )
            }

            // Date Range
            val starts = campaign.startsAtEpochMs
            val ends = campaign.endsAtEpochMs
            if (starts != null && ends != null) {
                binding.dateRangePill.isVisible = true
                val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
                binding.dateRangePill.text = "${df.format(Date(starts))} – ${df.format(Date(ends))}"
            } else {
                binding.dateRangePill.isVisible = false
            }

            // Rewards horizontal list
            rewardsAdapter.submitList(campaign.rewards)

            // Click actions: Whole card, banner, Participate button, More Details button
            binding.root.setOnClickListener { onParticipate(campaign) }
            binding.campaignBanner.setOnClickListener { onParticipate(campaign) }
            binding.participateButton.setOnClickListener { onParticipate(campaign) }
            binding.detailsButton.setOnClickListener { onMoreDetails(campaign) }

            if (campaign.isExpired) {
                binding.participateButton.text = context.getString(R.string.drops_view_streams)
                binding.participateButton.backgroundTintList = null
                binding.participateButton.setTextColor(ContextCompat.getColor(context, android.R.color.white))
                binding.participateButton.iconTint = ContextCompat.getColorStateList(context, android.R.color.white)
            } else {
                val buttonText = if (campaign.isChannelSpecific && campaign.channels.size > 1) {
                    context.getString(R.string.drops_view_channels)
                } else {
                    context.getString(R.string.drops_participate)
                }
                binding.participateButton.text = buttonText
                binding.participateButton.backgroundTintList = ContextCompat.getColorStateList(context, R.color.dropsParticipateGreen)
                binding.participateButton.setTextColor(ContextCompat.getColor(context, R.color.dropsOnParticipate))
                binding.participateButton.iconTint = ContextCompat.getColorStateList(context, R.color.dropsOnParticipate)
            }
        }
    }
}
