package com.xtrakick.app.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.error
import coil3.request.placeholder
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ItemDropClaimedRewardBinding
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.model.kick.KickDropRewardItem

data class ClaimedRewardEntry(
    val reward: KickDropRewardItem,
    val campaignName: String,
    val campaign: KickDropCampaignFull? = null,
)

class DropsClaimedAdapter(
    private val onItemClick: ((KickDropCampaignFull) -> Unit)? = null,
) : ListAdapter<ClaimedRewardEntry, DropsClaimedAdapter.ClaimedViewHolder>(DiffCallback) {

    companion object {
        private object DiffCallback : DiffUtil.ItemCallback<ClaimedRewardEntry>() {
            override fun areItemsTheSame(oldItem: ClaimedRewardEntry, newItem: ClaimedRewardEntry): Boolean =
                oldItem.reward.id == newItem.reward.id

            override fun areContentsTheSame(oldItem: ClaimedRewardEntry, newItem: ClaimedRewardEntry): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaimedViewHolder {
        val binding = ItemDropClaimedRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClaimedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClaimedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ClaimedViewHolder(
        private val binding: ItemDropClaimedRewardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: ClaimedRewardEntry) {
            binding.claimedRewardName.text = entry.reward.name
            binding.claimedCampaignName.text = entry.campaignName

            entry.campaign?.let { c ->
                binding.root.setOnClickListener {
                    onItemClick?.invoke(c)
                }
            }

            binding.claimedImage.load(entry.reward.resolvedImageUrl) {
                placeholder(R.drawable.ic_kick_gem)
                error(R.drawable.ic_kick_gem)
            }
        }
    }
}
