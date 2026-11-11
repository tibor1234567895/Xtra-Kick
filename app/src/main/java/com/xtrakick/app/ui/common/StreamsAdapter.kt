package com.xtrakick.app.ui.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
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
import com.xtrakick.app.databinding.FragmentStreamsListItemBinding
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs

class StreamsAdapter(
    private val fragment: Fragment,
    private val selectTag: (String) -> Unit,
    private val showGame: Boolean = true,
) : PagingDataAdapter<Stream, StreamsAdapter.PagingViewHolder>(
    object : DiffUtil.ItemCallback<Stream>() {
        override fun areItemsTheSame(oldItem: Stream, newItem: Stream): Boolean =
            (oldItem.channelId ?: oldItem.channelLogin ?: oldItem.id) ==
                (newItem.channelId ?: newItem.channelLogin ?: newItem.id)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Stream, newItem: Stream): Boolean =
            oldItem.channelName == newItem.channelName &&
                    oldItem.viewerCount == newItem.viewerCount &&
                    oldItem.gameName == newItem.gameName &&
                    oldItem.title == newItem.title &&
                    oldItem.thumbnailUrl == newItem.thumbnailUrl &&
                    oldItem.profileImageUrl == newItem.profileImageUrl &&
                    oldItem.startedAt == newItem.startedAt &&
                    oldItem.tags == newItem.tags &&
                    oldItem.eventTitle == newItem.eventTitle
    }) , ActiveTagsAdapter {

    override var activeTags: Set<String> = emptySet()
        set(value) {
            if (field != value) {
                field = value
                if (itemCount > 0) {
                    notifyItemRangeChanged(0, itemCount)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding = FragmentStreamsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding, fragment, showGame)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PagingViewHolder(
        private val binding: FragmentStreamsListItemBinding,
        private val fragment: Fragment,
        private val showGame: Boolean,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Stream?) {
            with(binding) {
                if (item != null) {
                    val context = fragment.requireContext()
                    val channelListener: (View) -> Unit = {
                        fragment.findNavController().navigate(
                            ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                channelId = item.channelId,
                                channelLogin = item.channelLogin,
                                channelName = item.channelName,
                                channelLogo = item.channelLogo,
                                streamId = item.id
                            )
                        )
                    }
                    root.setOnClickListener {
                        (fragment.activity as MainActivity).startStream(item)
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
                    }
                    val effectiveChannelName = item.channelName ?: item.channelLogin
                    if (effectiveChannelName != null) {
                        username.visibility = View.VISIBLE
                        username.text = if (item.channelLogin != null && item.channelName != null && !item.channelLogin.equals(item.channelName, true)) {
                            when (context.prefs().getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                                "0" -> "${item.channelName}(${item.channelLogin})"
                                "1" -> item.channelName
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
                    if (item.title != null && item.title != "") {
                        title.visibility = View.VISIBLE
                        title.text = item.title?.trim()
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
                    val resolvedThumbnail = item.thumbnail
                    if (!resolvedThumbnail.isNullOrBlank()) {
                        thumbnail.visibility = View.VISIBLE
                        val key = KickApiHelper.getThumbnailCacheKey()
                        fragment.requireContext().imageLoader.enqueue(
                            ImageRequest.Builder(fragment.requireContext()).apply {
                                data(resolvedThumbnail)
                                memoryCacheKeyExtra("minutes", key)
                                diskCachePolicy(CachePolicy.DISABLED)
                                crossfade(true)
                                target(thumbnail)
                            }.build()
                        )
                    } else {
                        thumbnail.setImageDrawable(null)
                        thumbnail.visibility = View.GONE
                    }
                    if (item.viewerCount != null) {
                        viewers.visibility = View.VISIBLE
                        val count = item.viewerCount ?: 0
                        viewers.text = context.resources.getQuantityString(
                            R.plurals.viewers,
                            count,
                            KickApiHelper.formatCount(count, context.prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true))
                        )
                    } else {
                        viewers.visibility = View.GONE
                    }
                    if (context.prefs().getBoolean(AppConstants.UI_UPTIME, true) && item.startedAt != null) {
                        val text = KickApiHelper.getUptime(startedAt = item.startedAt)
                        if (text != null) {
                            uptime.visibility = View.VISIBLE
                            uptime.text = context.getString(R.string.uptime, text)
                        } else {
                            uptime.visibility = View.GONE
                        }
                    } else {
                        uptime.visibility = View.GONE
                    }
                    if (!item.tags.isNullOrEmpty() && context.prefs().getBoolean(AppConstants.UI_TAGS, true)) {
                        tagsLayout.removeAllViews()
                        tagsLayout.visibility = View.VISIBLE
                        val tagsFlowLayout = Flow(context).apply {
                            layoutParams = ConstraintLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            ).apply {
                                topToTop = tagsLayout.id
                                bottomToBottom = tagsLayout.id
                                startToStart = tagsLayout.id
                                endToEnd = tagsLayout.id
                            }
                            setWrapMode(Flow.WRAP_CHAIN)
                        }
                        tagsLayout.addView(tagsFlowLayout)
                        val ids = mutableListOf<Int>()
                        for (tag in item.tags) {
                            val text = TextView(context)
                            val id = View.generateViewId()
                            text.id = id
                            ids.add(id)
                            text.text = tag
                            TagFilterHelper.applyTagStyle(text, tag, activeTags, isEvent = tag == item.eventTitle)
                            text.setOnClickListener {
                                selectTag(tag)
                            }
                            tagsLayout.addView(text)
                        }
                        tagsFlowLayout.referencedIds = ids.toIntArray()
                    } else {
                        tagsLayout.visibility = View.GONE
                    }
                }
            }
        }
    }
}
