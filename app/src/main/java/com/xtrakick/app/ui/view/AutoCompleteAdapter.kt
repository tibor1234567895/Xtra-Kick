package com.xtrakick.app.ui.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
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

class AutoCompleteAdapter<T>(
    context: Context,
    resource: Int,
    textViewResourceId: Int,
    private val originalValues: MutableList<T?>
): ArrayAdapter<T?>(context, resource, textViewResourceId) {

    private var objects = originalValues
    private val imageLibrary = context.prefs().getString(AppConstants.CHAT_IMAGE_LIBRARY, "0")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val item = getItem(position)
        val imageView = view.findViewById<ImageView>(R.id.image)
        val nameView = view.findViewById<TextView>(R.id.name)

        if (item is Emote) {
            nameView?.text = item.name
            imageView?.let { targetView ->
                targetView.visibility = View.VISIBLE
                targetView.setImageDrawable(null)
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
                            target(targetView)
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
                        .into(targetView)
                }
            }
        } else {
            imageView?.apply {
                setImageDrawable(null)
                visibility = View.GONE
            }
            nameView?.text = (item as? Chatter)?.name ?: item?.toString()
        }
        return view
    }

    override fun getFilter(): Filter = filter

    private val filter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            if (constraint.isNullOrBlank() || (constraint[0] != ':' && constraint[0] != '@')) {
                return FilterResults()
            }
            val list = synchronized(originalValues) {
                originalValues.toList()
            }
            val prefix = constraint[0]
            val rawQuery = constraint.substring(1)
            val queryBody = if (prefix == ':' && rawQuery.endsWith(':')) {
                rawQuery.dropLast(1)
            } else {
                rawQuery
            }

            val sortedResults = rankAndSort(list, prefix, queryBody)
            return FilterResults().apply {
                values = sortedResults
                count = sortedResults.size
            }
        }

        @Suppress("UNCHECKED_CAST")
        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            objects = (results?.values as? List<T?>)?.toMutableList() ?: mutableListOf()
            if (results != null && results.count > 0) {
                notifyDataSetChanged()
            } else {
                notifyDataSetInvalidated()
            }
        }
    }

    override fun getCount(): Int = objects.size

    override fun getItem(position: Int): T? = objects[position]

    private class ScoredItem<T>(val item: T, val rank: Int, val name: String)

    companion object {
        const val MAX_AUTOCOMPLETE_RESULTS = 60

        internal fun <T> rankAndSort(items: List<T?>, prefix: Char, queryBody: String): List<T> {
            val scored = ArrayList<ScoredItem<T>>(items.size.coerceAtMost(MAX_AUTOCOMPLETE_RESULTS * 2))
            for (item in items) {
                if (item == null) continue
                val (itemPrefix, name) = when (item) {
                    is Emote -> ':' to (item.name ?: continue)
                    is Chatter -> '@' to (item.name ?: continue)
                    else -> continue
                }
                if (itemPrefix != prefix) continue
                val rank = getMatchRank(queryBody, name)
                if (rank >= 0) {
                    scored.add(ScoredItem(item, rank, name))
                }
            }

            scored.sortWith(
                compareBy<ScoredItem<T>> { it.rank }
                    .thenBy { it.name.length }
                    .thenBy(String.CASE_INSENSITIVE_ORDER) { it.name }
            )

            val limit = scored.size.coerceAtMost(MAX_AUTOCOMPLETE_RESULTS)
            val result = ArrayList<T>(limit)
            for (i in 0 until limit) {
                result.add(scored[i].item)
            }
            return result
        }

        internal fun getItemName(item: Any?): String {
            return when (item) {
                is Emote -> item.name.orEmpty()
                is Chatter -> item.name.orEmpty()
                else -> item?.toString().orEmpty().removePrefix(":").removePrefix("@")
            }
        }

        internal fun getMatchRank(query: String, target: String): Int {
            if (query.isEmpty()) return 1
            if (target.equals(query, ignoreCase = true)) return 0
            if (target.startsWith(query, ignoreCase = true)) return 1
            if (target.contains(query, ignoreCase = true)) return 2
            if (query.length >= 3 && matchesSubsequence(query, target)) return 3
            return -1
        }

        internal fun matchesSubsequence(query: String, target: String): Boolean {
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
