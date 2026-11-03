package com.xtrakick.app.ui.search.channels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.Disposable
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentSearchChannelsListItemBinding
import com.xtrakick.app.model.ui.User
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch

class ChannelSearchAdapter(
    private val fragment: Fragment,
    private val resolveProfileImage: suspend (String) -> String?,
) : PagingDataAdapter<User, ChannelSearchAdapter.PagingViewHolder>(
    object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.channelId == newItem.channelId

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.channelLogin == newItem.channelLogin &&
                    oldItem.channelName == newItem.channelName &&
                    oldItem.profileImageUrl == newItem.profileImageUrl &&
                    oldItem.followersCount == newItem.followersCount &&
                    oldItem.isLive == newItem.isLive
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding = FragmentSearchChannelsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding, fragment)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: PagingViewHolder) {
        holder.bind(null)
        super.onViewRecycled(holder)
    }

    inner class PagingViewHolder(
        private val binding: FragmentSearchChannelsListItemBinding,
        private val fragment: Fragment,
    ) : RecyclerView.ViewHolder(binding.root) {
        private var avatarJob: Job? = null
        private var imageRequest: Disposable? = null
        private var channelLogo: String? = null

        fun bind(item: User?) {
            avatarJob?.cancel()
            avatarJob = null
            imageRequest?.dispose()
            imageRequest = null
            channelLogo = item?.channelLogo
            binding.userImage.setImageDrawable(null)
            binding.root.setOnClickListener(null)
            if (item == null) {
                binding.userImage.visibility = View.GONE
                return
            }
            with(binding) {
                val context = fragment.requireContext()
                root.setOnClickListener {
                    fragment.findNavController().navigate(
                        ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                            channelId = item.channelId,
                            channelLogin = item.channelLogin,
                            channelName = item.channelName,
                            channelLogo = channelLogo,
                        )
                    )
                }
                showImage(channelLogo)
                val login = item.channelLogin
                if (item.profileImageUrl.isNullOrBlank() && !login.isNullOrBlank()) {
                    avatarJob = fragment.viewLifecycleOwner.lifecycleScope.launch {
                        try {
                            val image = resolveProfileImage(login)?.takeIf { it.isNotBlank() }
                            ensureActive()
                            if (image != null) {
                                channelLogo = KickApiHelper.getTemplateUrl(image, "profileimage")
                                showImage(channelLogo)
                            }
                        } catch (e: CancellationException) {
                            throw e
                        } catch (_: Exception) {
                        }
                    }
                }
                if (item.channelName != null) {
                    userName.visibility = View.VISIBLE
                    userName.text = if (item.channelLogin != null && !item.channelLogin.equals(item.channelName, true)) {
                        when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                            "0" -> "${item.channelName}(${item.channelLogin})"
                            "1" -> item.channelName
                            else -> item.channelLogin
                        }
                    } else {
                        item.channelName
                    }
                } else {
                    userName.visibility = View.GONE
                }
                if (item.followersCount != null) {
                    userFollowers.visibility = View.VISIBLE
                    val count = item.followersCount
                    userFollowers.text = context.resources.getQuantityString(
                        R.plurals.followers,
                        count,
                        KickApiHelper.formatCount(count, context.prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true))
                    )
                } else {
                    userFollowers.visibility = View.GONE
                }
                if (item.isLive == true) {
                    typeText.visibility = View.VISIBLE
                    typeText.text = context.getString(R.string.live)
                } else {
                    typeText.visibility = View.GONE
                }
            }
        }

        private fun showImage(url: String?) {
            val context = binding.root.context
            binding.userImage.visibility = if (url != null) View.VISIBLE else View.GONE
            imageRequest = context.imageLoader.enqueue(
                ImageRequest.Builder(context).apply {
                    data(url)
                    if (context.prefs().getBoolean(AppConstants.UI_ROUNDUSERIMAGE, true)) {
                        transformations(CircleCropTransformation())
                    }
                    crossfade(true)
                    target(binding.userImage)
                }.build()
            )
        }
    }
}
