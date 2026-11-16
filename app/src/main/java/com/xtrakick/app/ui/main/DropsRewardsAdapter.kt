package com.xtrakick.app.ui.main

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ItemDropRewardBinding
import com.xtrakick.app.model.kick.KickDropRewardItem

class DropsRewardsAdapter(
    private val onClaimClick: (KickDropRewardItem) -> Unit,
    private val onRewardClick: ((KickDropRewardItem) -> Unit)? = null,
) : ListAdapter<KickDropRewardItem, DropsRewardsAdapter.RewardViewHolder>(DiffCallback) {

    companion object {
        private const val VIEW_TYPE_SINGLE = 1
        private const val VIEW_TYPE_CAROUSEL = 2

        private object DiffCallback : DiffUtil.ItemCallback<KickDropRewardItem>() {
            override fun areItemsTheSame(oldItem: KickDropRewardItem, newItem: KickDropRewardItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: KickDropRewardItem, newItem: KickDropRewardItem): Boolean =
                oldItem == newItem
        }
    }

    // A size change flips the view type, so RecyclerView rebinds item 0 instead of
    // keeping stale full-width params from a previous single-item layout.
    override fun getItemViewType(position: Int): Int =
        if (itemCount == 1) VIEW_TYPE_SINGLE else VIEW_TYPE_CAROUSEL

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val binding = ItemDropRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RewardViewHolder(binding, isSingleItem = viewType == VIEW_TYPE_SINGLE)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RewardViewHolder(
        private val binding: ItemDropRewardBinding,
        isSingleItem: Boolean,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            if (isSingleItem) {
                val density = binding.root.context.resources.displayMetrics.density
                binding.rewardCard.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    marginEnd = 0
                }
                binding.contentLayout.orientation = LinearLayout.HORIZONTAL
                binding.contentLayout.gravity = Gravity.CENTER_VERTICAL
                binding.rewardImage.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    marginEnd = (12 * density).toInt()
                }
                binding.infoLayout.updateLayoutParams<LinearLayout.LayoutParams> {
                    width = 0
                    weight = 1f
                }
                binding.infoLayout.gravity = Gravity.START
                binding.rewardName.gravity = Gravity.START
                binding.rewardName.minLines = 1
                binding.progressText.gravity = Gravity.START
                binding.claimButton.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    width = (90 * density).toInt()
                    marginStart = (10 * density).toInt()
                    topMargin = 0
                }
                binding.claimedBadge.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    marginStart = (10 * density).toInt()
                    topMargin = 0
                }
            }
        }

        fun bind(reward: KickDropRewardItem) {
            val context = binding.root.context

            binding.rewardName.text = reward.name

            Glide.with(itemView)
                .load(reward.resolvedImageUrl)
                .placeholder(R.drawable.ic_kick_gem)
                .error(R.drawable.ic_kick_gem)
                .into(binding.rewardImage)

            val progressPct = (reward.progressFraction * 100).toInt()
            binding.progressBar.progress = progressPct

            binding.rewardCard.setOnClickListener {
                if (reward.isClaimable) {
                    onClaimClick(reward)
                } else {
                    onRewardClick?.invoke(reward)
                }
            }

            when {
                reward.claimed -> {
                    binding.claimedBadge.isVisible = true
                    binding.claimButton.isVisible = false
                    binding.progressText.text = context.getString(R.string.drops_reward_completed)
                }
                reward.isClaimable -> {
                    binding.claimedBadge.isVisible = false
                    binding.claimButton.isVisible = true
                    binding.claimButton.isEnabled = true
                    binding.progressText.text = context.getString(R.string.drops_reward_claimable)
                    binding.claimButton.setOnClickListener {
                        onClaimClick(reward)
                    }
                }
                else -> {
                    binding.claimedBadge.isVisible = false
                    binding.claimButton.isVisible = false
                    val requiredMin = reward.requiredUnits / 60
                    val currentMin = reward.currentUnits / 60
                    binding.progressText.text = if (requiredMin > 0) {
                        context.getString(R.string.drops_reward_progress_format, currentMin, requiredMin)
                    } else {
                        "${reward.currentUnits} / ${reward.requiredUnits}"
                    }
                }
            }
        }
    }
}
