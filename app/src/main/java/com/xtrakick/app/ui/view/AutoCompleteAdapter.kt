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
    private val emoteQuality = context.prefs().getString(AppConstants.CHAT_IMAGE_QUALITY, "4") ?: "4"

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val item = getItem(position)
        when (item) {
            is Emote -> {
                view.findViewById<ImageView>(R.id.image)?.let {
                    it.visibility = View.VISIBLE
                    if (imageLibrary == "0" || (imageLibrary == "1" && !item.format.equals("webp", true))) {
                        context.imageLoader.enqueue(
                            ImageRequest.Builder(context).apply {
                                data(
                                    when (emoteQuality) {
                                        "4" -> item.url4x ?: item.url3x ?: item.url2x ?: item.url1x
                                        "3" -> item.url3x ?: item.url2x ?: item.url1x
                                        "2" -> item.url2x ?: item.url1x
                                        else -> item.url1x
                                    }
                                )
                                if (item.thirdParty) {
                                    httpHeaders(NetworkHeaders.Builder().apply {
                                        add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                                    }.build())
                                }
                                crossfade(true)
                                target(it)
                            }.build()
                        )
                    } else {
                        Glide.with(context)
                            .load(
                                when (emoteQuality) {
                                    "4" -> item.url4x ?: item.url3x ?: item.url2x ?: item.url1x
                                    "3" -> item.url3x ?: item.url2x ?: item.url1x
                                    "2" -> item.url2x ?: item.url1x
                                    else -> item.url1x
                                }.let {
                                    if (item.thirdParty) {
                                        GlideUrl(it) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) }
                                    } else it
                                }
                            )
                            .diskCacheStrategy(DiskCacheStrategy.DATA)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(it)
                    }
                }
                view.findViewById<TextView>(R.id.name)?.text = item.name
            }
            is Chatter -> view.findViewById<TextView>(R.id.name)?.text = item.name
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
            val results = list.filter { item ->
                val name = item?.toString() ?: return@filter false
                matchesSubsequence(constraint, name)
            }
            return FilterResults().apply {
                values = results
                count = results.size
            }
        }

        private fun matchesSubsequence(query: CharSequence, target: String): Boolean {
            if (target.length < query.length || target[0] != query[0]) return false
            if (query.length == 1) return true
            var qIdx = 1
            for (tIdx in 1 until target.length) {
                if (target[tIdx].equals(query[qIdx], ignoreCase = true)) {
                    qIdx++
                    if (qIdx == query.length) return true
                }
            }
            return false
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
}
