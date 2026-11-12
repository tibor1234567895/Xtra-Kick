package com.xtrakick.app.ui.common

import android.content.Intent
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentClipsListItemBinding
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs

class ClipsAdapter(
    private val fragment: Fragment,
    private val showDownloadDialog: (Clip) -> Unit,
    private val showGame: Boolean = true,
    private val showChannel: Boolean = true,
) : PagingDataAdapter<Clip, ClipsAdapter.PagingViewHolder>(
    object : DiffUtil.ItemCallback<Clip>() {
        override fun areItemsTheSame(oldItem: Clip, newItem: Clip): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Clip, newItem: Clip): Boolean =
            oldItem.viewCount == newItem.viewCount &&
                    oldItem.title == newItem.title &&
                    oldItem.channelName == newItem.channelName &&
                    oldItem.channelLogo == newItem.channelLogo &&
                    oldItem.creatorName == newItem.creatorName &&
                    oldItem.thumbnail == newItem.thumbnail &&
                    oldItem.uploadDate == newItem.uploadDate
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding = FragmentClipsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding, fragment, showGame, showChannel)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PagingViewHolder(
        private val binding: FragmentClipsListItemBinding,
        private val fragment: Fragment,
        private val showGame: Boolean,
        private val showChannel: Boolean,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Clip?) {
            with(binding) {
                if (item != null) {
                    val context = fragment.requireContext()
                    root.setOnClickListener {
                        (fragment.activity as MainActivity).startClip(item)
                    }
                    root.setOnLongClickListener { showDownloadDialog(item); true }
                    val resolvedThumbnail = item.thumbnail
                    thumbnail.visibility = View.VISIBLE
                    if (!resolvedThumbnail.isNullOrBlank()) {
                        fragment.requireContext().imageLoader.enqueue(
                            ImageRequest.Builder(fragment.requireContext()).apply {
                                data(resolvedThumbnail)
                                diskCachePolicy(CachePolicy.DISABLED)
                                crossfade(true)
                                target(thumbnail)
                            }.build()
                        )
                    } else {
                        thumbnail.setImageDrawable(null)
                    }
                    date.visibility = View.GONE
                    if (item.viewCount != null) {
                        views.visibility = View.VISIBLE
                        val count = item.viewCount
                        views.text = context.resources.getQuantityString(
                            R.plurals.views,
                            count,
                            KickApiHelper.formatCount(count, context.prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true))
                        )
                    } else {
                        views.visibility = View.GONE
                    }
                    if (item.duration != null) {
                        duration.visibility = View.VISIBLE
                        duration.text = DateUtils.formatElapsedTime(item.duration.toLong())
                    } else {
                        duration.visibility = View.GONE
                    }
                    if (showChannel) {
                        val effectiveChannelName = item.channelName ?: item.channelLogin
                        val channelListener: (View) -> Unit = {
                            if (effectiveChannelName != null || item.channelId != null) {
                                fragment.findNavController().navigate(
                                    ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                        channelId = item.channelId,
                                        channelLogin = item.channelLogin ?: item.channelName,
                                        channelName = effectiveChannelName,
                                        channelLogo = item.channelLogo,
                                    )
                                )
                            }
                        }
                        if (item.channelLogo != null) {
                            userImage.visibility = View.VISIBLE
                            fragment.requireContext().imageLoader.enqueue(
                                ImageRequest.Builder(fragment.requireContext()).apply {
                                    data(item.channelLogo)
                                    if (context.prefs().getBoolean(AppConstants.UI_ROUNDUSERIMAGE, true)) {
                                        transformations(CircleCropTransformation())
                                    }
                                    crossfade(true)
                                    target(userImage)
                                }.build()
                            )
                            userImage.setOnClickListener(channelListener)
                        } else {
                            userImage.visibility = View.GONE
                            userImage.setOnClickListener(null)
                        }
                        if (effectiveChannelName != null) {
                            username.visibility = View.VISIBLE
                            username.text = if (item.channelLogin != null && !item.channelLogin.equals(effectiveChannelName, true)) {
                                when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                                    "0" -> "${effectiveChannelName}(${item.channelLogin})"
                                    "1" -> effectiveChannelName
                                    else -> item.channelLogin
                                }
                            } else {
                                effectiveChannelName
                            }
                            username.setOnClickListener(channelListener)
                        } else {
                            username.visibility = View.GONE
                            username.setOnClickListener(null)
                        }
                    } else {
                        userImage.visibility = View.GONE
                        userImage.setOnClickListener(null)
                        username.visibility = View.GONE
                        username.setOnClickListener(null)
                    }
                    if (item.title != null && item.title != "") {
                        title.visibility = View.VISIBLE
                        title.text = item.title.trim()
                    } else {
                        title.visibility = View.GONE
                    }
                    val effectiveGameName = item.gameName ?: item.gameSlug
                    if (showGame && effectiveGameName != null) {
                        val gameListener: (View) -> Unit = {
                            val resolvedSlug = KickApiHelper.resolveEffectiveCategorySlug(item.gameSlug, effectiveGameName)
                            val resolvedId = KickApiHelper.sanitizeGameId(item.gameId, resolvedSlug)
                            fragment.findNavController().navigate(
                                if (context.prefs().getBoolean(AppConstants.UI_GAMEPAGER, true)) {
                                    GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                                        gameId = resolvedId,
                                        gameSlug = resolvedSlug,
                                        gameName = effectiveGameName
                                    )
                                } else {
                                    GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                                        gameId = resolvedId,
                                        gameSlug = resolvedSlug,
                                        gameName = effectiveGameName
                                    )
                                }
                            )
                        }
                        gameName.visibility = View.VISIBLE
                        gameName.text = effectiveGameName
                        gameName.setOnClickListener(gameListener)
                    } else {
                        gameName.visibility = View.GONE
                        gameName.setOnClickListener(null)
                    }
                    val creatorDisplayName = item.creatorName ?: item.creatorLogin
                    val relativeDate = item.uploadDate?.let {
                        KickApiHelper.formatRelativeTimeString(it) ?: KickApiHelper.formatTimeString(context, it)
                    }
                    val clipperString = if (!creatorDisplayName.isNullOrBlank()) {
                        context.getString(R.string.clipped_by, creatorDisplayName)
                    } else null
                    val combinedClipper = when {
                        !relativeDate.isNullOrBlank() && clipperString != null -> "$relativeDate • $clipperString"
                        clipperString != null -> clipperString
                        !relativeDate.isNullOrBlank() -> relativeDate
                        else -> null
                    }
                    if (combinedClipper != null) {
                        clipper.visibility = View.VISIBLE
                        clipper.text = combinedClipper
                        if (!creatorDisplayName.isNullOrBlank()) {
                            clipper.setOnClickListener {
                                fragment.findNavController().navigate(
                                    ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                        channelId = item.creatorId,
                                        channelLogin = item.creatorLogin ?: creatorDisplayName,
                                        channelName = creatorDisplayName,
                                        channelLogo = item.creatorLogo,
                                    )
                                )
                            }
                        } else {
                            clipper.setOnClickListener(null)
                        }
                    } else {
                        clipper.visibility = View.GONE
                        clipper.setOnClickListener(null)
                    }
                    options.setOnClickListener { it ->
                        PopupMenu(context, it).apply {
                            inflate(R.menu.media_item)
                            setOnMenuItemClickListener {
                                when (it.itemId) {
                                    R.id.download -> showDownloadDialog(item)
                                    R.id.share -> {
                                        val clipId = item.id?.takeIf { it.isNotBlank() }
                                        val channelLogin = item.channelLogin?.takeIf { it.isNotBlank() }
                                        val shareUrl = when {
                                            clipId != null && channelLogin != null -> "https://kick.com/$channelLogin/clips/$clipId"
                                            clipId != null -> "https://kick.com/clips/$clipId"
                                            channelLogin != null -> "https://kick.com/$channelLogin"
                                            else -> null
                                        }
                                        if (shareUrl != null) {
                                            context.startActivity(Intent.createChooser(Intent().apply {
                                                action = Intent.ACTION_SEND
                                                putExtra(Intent.EXTRA_TEXT, shareUrl)
                                                item.title?.let {
                                                    putExtra(Intent.EXTRA_TITLE, it)
                                                }
                                                type = "text/plain"
                                            }, null))
                                        }
                                    }
                                    else -> menu.close()
                                }
                                true
                            }
                            show()
                        }
                    }
                }
            }
        }
    }
}
