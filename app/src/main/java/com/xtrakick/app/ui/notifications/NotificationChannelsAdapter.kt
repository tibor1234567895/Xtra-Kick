package com.xtrakick.app.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentNotificationChannelsListItemBinding
import com.xtrakick.app.ui.notifications.NotificationChannelsViewModel.ChannelUi
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

class NotificationChannelsAdapter(
    private val onOpen: (ChannelUi) -> Unit,
    private val onToggle: (ChannelUi, Boolean) -> Unit,
) : ListAdapter<ChannelUi, NotificationChannelsAdapter.ViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentNotificationChannelsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: FragmentNotificationChannelsListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: ChannelUi) {
            val context = binding.root.context
            binding.root.setOnClickListener { onOpen(entry) }
            binding.title.text = entry.name
                ?: context.getString(R.string.live_notification_channels_unknown, entry.id)
            binding.subtitle.text = context.getString(R.string.live_notification_channels_not_followed)
            binding.subtitle.isVisible = !entry.followed
            binding.switchWidget.setOnCheckedChangeListener(null)
            binding.switchWidget.isChecked = entry.enabled
            binding.switchWidget.setOnCheckedChangeListener { _, checked ->
                onToggle(entry, checked)
            }
            val logo = entry.logoUrl
            if (logo != null) {
                binding.userImage.isVisible = true
                context.imageLoader.enqueue(
                    ImageRequest.Builder(context).apply {
                        data(logo)
                        if (context.prefs().getBoolean(AppConstants.UI_ROUNDUSERIMAGE, true)) {
                            transformations(CircleCropTransformation())
                        }
                        crossfade(true)
                        target(binding.userImage)
                    }.build()
                )
            } else {
                binding.userImage.isVisible = false
            }
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<ChannelUi>() {
            override fun areItemsTheSame(oldItem: ChannelUi, newItem: ChannelUi): Boolean =
                oldItem.id == newItem.id && oldItem.followed == newItem.followed

            override fun areContentsTheSame(oldItem: ChannelUi, newItem: ChannelUi): Boolean =
                oldItem == newItem
        }
    }
}
