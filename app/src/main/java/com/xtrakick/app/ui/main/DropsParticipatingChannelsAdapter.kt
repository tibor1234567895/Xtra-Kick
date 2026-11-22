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
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ItemDropParticipatingChannelBinding
import com.xtrakick.app.model.kick.KickDropParticipatingChannel

class DropsParticipatingChannelsAdapter(
    private val onChannelClick: (KickDropParticipatingChannel) -> Unit,
) : ListAdapter<KickDropParticipatingChannel, DropsParticipatingChannelsAdapter.ChannelViewHolder>(ChannelDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val binding = ItemDropParticipatingChannelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChannelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ChannelViewHolder(
        private val binding: ItemDropParticipatingChannelBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(channel: KickDropParticipatingChannel) {
            binding.channelName.text = channel.username
            binding.channelSlug.text = "@${channel.slug}"
            binding.liveBadge.isVisible = channel.isLive

            binding.channelAvatar.load(channel.profilePicture) {
                transformations(CircleCropTransformation())
                placeholder(R.drawable.baseline_person_black_24)
                error(R.drawable.baseline_person_black_24)
            }

            binding.root.setOnClickListener { onChannelClick(channel) }
            binding.watchButton.setOnClickListener { onChannelClick(channel) }
        }
    }

    private object ChannelDiffCallback : DiffUtil.ItemCallback<KickDropParticipatingChannel>() {
        override fun areItemsTheSame(
            oldItem: KickDropParticipatingChannel,
            newItem: KickDropParticipatingChannel,
        ): Boolean = oldItem.slug.equals(newItem.slug, ignoreCase = true)

        override fun areContentsTheSame(
            oldItem: KickDropParticipatingChannel,
            newItem: KickDropParticipatingChannel,
        ): Boolean = oldItem == newItem
    }
}
