package com.xtrakick.app.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.error
import coil3.request.placeholder
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ItemCollectibleCardBinding
import com.xtrakick.app.databinding.ItemCollectibleOverviewHeaderBinding
import com.xtrakick.app.databinding.ItemCollectibleRarityHeaderBinding
import com.xtrakick.app.model.kick.KickCollectible
import com.xtrakick.app.model.kick.KickUserLevel

sealed class CollectiblesListItem {
    data class Overview(
        val totalUnlocked: Int,
        val totalItems: Int,
        val userLevel: KickUserLevel?,
    ) : CollectiblesListItem()

    data class Header(
        val rarity: String,
        val unlocked: Int,
        val total: Int,
    ) : CollectiblesListItem()

    data class Card(
        val collectible: KickCollectible,
    ) : CollectiblesListItem()
}

class CollectiblesAdapter(
    private val onCardClick: (KickCollectible) -> Unit,
) : ListAdapter<CollectiblesListItem, RecyclerView.ViewHolder>(DiffCallback) {

    companion object {
        const val TYPE_OVERVIEW = 0
        const val TYPE_HEADER = 1
        const val TYPE_CARD = 2

        private object DiffCallback : DiffUtil.ItemCallback<CollectiblesListItem>() {
            override fun areItemsTheSame(oldItem: CollectiblesListItem, newItem: CollectiblesListItem): Boolean =
                when {
                    oldItem is CollectiblesListItem.Overview && newItem is CollectiblesListItem.Overview -> true
                    oldItem is CollectiblesListItem.Header && newItem is CollectiblesListItem.Header ->
                        oldItem.rarity.equals(newItem.rarity, ignoreCase = true)
                    oldItem is CollectiblesListItem.Card && newItem is CollectiblesListItem.Card ->
                        oldItem.collectible.id == newItem.collectible.id
                    else -> false
                }

            override fun areContentsTheSame(oldItem: CollectiblesListItem, newItem: CollectiblesListItem): Boolean =
                oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is CollectiblesListItem.Overview -> TYPE_OVERVIEW
        is CollectiblesListItem.Header -> TYPE_HEADER
        is CollectiblesListItem.Card -> TYPE_CARD
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_OVERVIEW -> {
                val binding = ItemCollectibleOverviewHeaderBinding.inflate(inflater, parent, false)
                OverviewViewHolder(binding)
            }
            TYPE_HEADER -> {
                val binding = ItemCollectibleRarityHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }
            else -> {
                val binding = ItemCollectibleCardBinding.inflate(inflater, parent, false)
                CardViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is CollectiblesListItem.Overview -> (holder as OverviewViewHolder).bind(item)
            is CollectiblesListItem.Header -> (holder as HeaderViewHolder).bind(item)
            is CollectiblesListItem.Card -> (holder as CardViewHolder).bind(item.collectible)
        }
    }

    class OverviewViewHolder(
        private val binding: ItemCollectibleOverviewHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(overview: CollectiblesListItem.Overview) {
            val context = binding.root.context
            val level = overview.userLevel
            if (level != null && level.level > 0) {
                binding.userLevelContainer.isVisible = true
                // Live payloads may omit the XP fields; show the bare level instead of "0 / 0 XP".
                binding.userLevelText.text = if (level.nextLevelXp > 0) {
                    context.getString(
                        R.string.collectibles_user_level_format,
                        level.level,
                        level.currentXp,
                        level.nextLevelXp,
                    )
                } else {
                    context.getString(R.string.collectibles_level_format, level.level)
                }
            } else {
                binding.userLevelContainer.isVisible = false
            }

            binding.inventoryCountText.text = context.getString(
                R.string.collectibles_inventory_count_format,
                overview.totalUnlocked,
                overview.totalItems,
            )

            val pct = if (overview.totalItems > 0) {
                (overview.totalUnlocked * 100) / overview.totalItems
            } else 0
            binding.inventoryPercentText.text = "$pct%"
            binding.inventoryProgressBar.progress = pct
        }
    }

    class HeaderViewHolder(
        private val binding: ItemCollectibleRarityHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(header: CollectiblesListItem.Header) {
            val color = KickRewardsUiUtils.rarityColor(header.rarity)
            binding.rarityDot.background?.mutate()?.setTint(color)
            binding.rarityTitle.text = KickRewardsUiUtils.rarityLabel(header.rarity)
            binding.rarityCount.text = "${header.unlocked} / ${header.total}"
        }
    }

    inner class CardViewHolder(
        private val binding: ItemCollectibleCardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(collectible: KickCollectible) {
            binding.cardImage.load(collectible.resolvedCardUrl) {
                placeholder(R.drawable.ic_kick_gem)
                error(R.drawable.ic_kick_gem)
            }

            val isLocked = !collectible.owned
            binding.lockedScrim.isVisible = isLocked
            binding.lockIcon.isVisible = isLocked

            binding.cardContainer.setOnClickListener {
                onCardClick(collectible)
            }
        }
    }
}
