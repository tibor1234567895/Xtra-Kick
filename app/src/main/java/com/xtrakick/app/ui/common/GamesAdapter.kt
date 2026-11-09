package com.xtrakick.app.ui.common

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentGamesListItemBinding
import com.xtrakick.app.model.ui.Game
import com.xtrakick.app.model.ui.Tag
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch

class GamesAdapter(
    private val fragment: Fragment,
    private val resolveViewersCount: (suspend (Game) -> Int?)? = null,
    private val selectTag: (Tag) -> Unit,
) : PagingDataAdapter<Game, GamesAdapter.PagingViewHolder>(
    object : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean =
            oldItem.gameId == newItem.gameId

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean =
            oldItem.viewersCount == newItem.viewersCount &&
                    oldItem.tags == newItem.tags
    }), ActiveTagsAdapter {

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
        val binding = FragmentGamesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        private val binding: FragmentGamesListItemBinding,
        private val fragment: Fragment,
    ) : RecyclerView.ViewHolder(binding.root) {
        private var viewersJob: Job? = null

        fun bind(item: Game?) {
            viewersJob?.cancel()
            viewersJob = null
            binding.viewers.visibility = View.GONE
            with(binding) {
                if (item != null) {
                    val context = fragment.requireContext()
                    root.setOnClickListener {
                        val resolvedSlug = KickApiHelper.resolveEffectiveCategorySlug(item.gameSlug, item.gameName)
                        val resolvedId = KickApiHelper.sanitizeGameId(item.gameId, resolvedSlug)
                        fragment.findNavController().navigate(
                            if (context.prefs().getBoolean(AppConstants.UI_GAMEPAGER, true)) {
                                GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                                    gameId = resolvedId,
                                    gameSlug = resolvedSlug,
                                    gameName = item.gameName,
                                    boxArt = item.boxArt
                                )
                            } else {
                                GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                                    gameId = resolvedId,
                                    gameSlug = resolvedSlug,
                                    gameName = item.gameName,
                                    boxArt = item.boxArt
                                )
                            }
                        )
                    }
                    if (item.boxArt != null) {
                        gameImage.visibility = View.VISIBLE
                        fragment.requireContext().imageLoader.enqueue(
                            ImageRequest.Builder(fragment.requireContext()).apply {
                                data(item.boxArt)
                                crossfade(true)
                                target(gameImage)
                            }.build()
                        )
                    } else {
                        gameImage.visibility = View.GONE
                    }
                    if (item.gameName != null) {
                        gameName.visibility = View.VISIBLE
                        gameName.text = item.gameName
                    } else {
                        gameName.visibility = View.GONE
                    }
                    showViewers(item.viewersCount)
                    val resolve = resolveViewersCount
                    if (item.viewersCount == null && resolve != null) {
                        viewersJob = fragment.viewLifecycleOwner.lifecycleScope.launch {
                            try {
                                val count = resolve(item)
                                ensureActive()
                                showViewers(count)
                            } catch (error: CancellationException) {
                                throw error
                            } catch (_: Exception) {
                            }
                        }
                    }
                    if (item.broadcastersCount != null && context.prefs().getBoolean(AppConstants.UI_BROADCASTERSCOUNT, true)) {
                        broadcastersCount.visibility = View.VISIBLE
                        val count = item.broadcastersCount ?: 0
                        broadcastersCount.text = context.resources.getQuantityString(
                            R.plurals.broadcasters,
                            count,
                            KickApiHelper.formatCount(count, context.prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true))
                        )
                    } else {
                        broadcastersCount.visibility = View.GONE
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
                        for (tag in item.tags!!) {
                            val text = TextView(context)
                            val id = View.generateViewId()
                            text.id = id
                            ids.add(id)
                            text.text = tag.name
                            val tagName = tag.name ?: tag.id.orEmpty()
                            TagFilterHelper.applyTagStyle(text, tagName, activeTags)
                            if (tag.id != null) {
                                text.setOnClickListener {
                                    selectTag(tag)
                                }
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

        private fun showViewers(count: Int?) {
            val context = binding.root.context
            binding.viewers.visibility = if (count != null) View.VISIBLE else View.GONE
            if (count != null) {
                binding.viewers.text = context.resources.getQuantityString(R.plurals.viewers, count,
                    KickApiHelper.formatCount(count, context.prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true)))
            }
        }
    }
}
