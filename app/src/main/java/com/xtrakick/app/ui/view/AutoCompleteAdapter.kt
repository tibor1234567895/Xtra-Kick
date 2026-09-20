package com.xtrakick.app.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Chatter
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

class AutoCompleteAdapter(
    private val context: Context,
    private val onItemClick: (Any) -> Unit
) : RecyclerView.Adapter<AutoCompleteAdapter.ViewHolder>() {

    private var items: List<Any> = emptyList()
    private val imageLibrary = context.prefs().getString(AppConstants.CHAT_IMAGE_LIBRARY, "0")

    fun setItems(newItems: List<Any>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.auto_complete_emotes_list_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image)
        private val nameView: TextView = itemView.findViewById(R.id.name)

        init {
            itemView.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION && pos < items.size) {
                    onItemClick(items[pos])
                }
            }
        }

        fun bind(item: Any) {
            if (item is Emote) {
                nameView.text = item.name
                imageView.visibility = View.VISIBLE
                imageView.setImageDrawable(null)
                val thumbnailUrl = item.url1x ?: item.url2x ?: item.url3x ?: item.url4x
                if (imageLibrary == "0" || (imageLibrary == "1" && !item.format.equals("webp", true))) {
                    context.imageLoader.enqueue(
                        ImageRequest.Builder(context).apply {
                            data(thumbnailUrl)
                            if (item.thirdParty) {
                                httpHeaders(NetworkHeaders.Builder().apply {
                                    add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                                }.build())
                            }
                            crossfade(true)
                            target(imageView)
                        }.build()
                    )
                } else {
                    Glide.with(context)
                        .load(
                            thumbnailUrl?.let { url ->
                                if (item.thirdParty) {
                                    GlideUrl(url) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) }
                                } else url
                            }
                        )
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView)
                }
            } else {
                imageView.setImageDrawable(null)
                imageView.visibility = View.GONE
                nameView.text = (item as? Chatter)?.name ?: item.toString()
            }
        }
    }

    private class ScoredItem<T>(
        val item: T,
        val rank: Int,
        val name: String,
    ) : Comparable<ScoredItem<*>> {
        override fun compareTo(other: ScoredItem<*>): Int {
            val rankDiff = rank.compareTo(other.rank)
            if (rankDiff != 0) return rankDiff
            val lenDiff = name.length.compareTo(other.name.length)
            if (lenDiff != 0) return lenDiff
            return name.compareTo(other.name, ignoreCase = true)
        }
    }

    companion object {
        const val MAX_AUTOCOMPLETE_RESULTS = 60

        fun <T> rankAndSort(items: List<T?>, prefix: Char, queryBody: String): List<T> {
            val scored = ArrayList<ScoredItem<T>>(items.size.coerceAtMost(MAX_AUTOCOMPLETE_RESULTS * 2))
            for (item in items) {
                if (item == null) continue
                val name = when {
                    prefix == ':' && item is Emote -> item.name ?: continue
                    prefix == '@' && item is Chatter -> item.name ?: continue
                    else -> continue
                }
                val rank = getMatchRank(queryBody, name)
                if (rank >= 0) {
                    scored.add(ScoredItem(item, rank, name))
                }
            }

            scored.sort()

            val limit = scored.size.coerceAtMost(MAX_AUTOCOMPLETE_RESULTS)
            val result = ArrayList<T>(limit)
            for (i in 0 until limit) {
                result.add(scored[i].item)
            }
            return result
        }

        fun getMatchRank(query: String, target: String): Int {
            if (query.isEmpty()) return 1
            if (target.equals(query, ignoreCase = true)) return 0
            if (target.startsWith(query, ignoreCase = true)) return 1
            if (target.contains(query, ignoreCase = true)) return 2
            if (query.length >= 3 && matchesSubsequence(query, target)) return 3
            return -1
        }

        fun matchesSubsequence(query: String, target: String): Boolean {
            if (target.length < query.length) return false
            var qIdx = 0
            for (tIdx in 0 until target.length) {
                if (target[tIdx].equals(query[qIdx], ignoreCase = true)) {
                    qIdx++
                    if (qIdx == query.length) return true
                }
            }
            return false
        }
    }
}
