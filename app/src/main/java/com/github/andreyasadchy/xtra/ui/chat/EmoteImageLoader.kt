package com.github.andreyasadchy.xtra.ui.chat

import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.target
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.chat.Emote

object EmoteImageLoader {
    private const val BOUND_STATE_TAG_KEY = R.id.emotes

    fun bind(
        imageView: ImageView,
        fragment: Fragment,
        item: Emote?,
        emoteQuality: String,
        imageLibrary: String?,
        clickListener: (Emote) -> Unit,
    ) {
        val url = item?.let { emote ->
            when (emoteQuality) {
                "4" -> emote.url4x ?: emote.url3x ?: emote.url2x ?: emote.url1x
                "3" -> emote.url3x ?: emote.url2x ?: emote.url1x
                "2" -> emote.url2x ?: emote.url1x
                else -> emote.url1x
            }
        }
        val nextState = if (item == null) {
            "placeholder:${imageView.hashCode()}"
        } else {
            "loaded:${item.name}:${url.orEmpty()}"
        }
        if (imageView.getTag(BOUND_STATE_TAG_KEY) == nextState) {
            if (item != null) {
                imageView.setOnClickListener { clickListener(item) }
            } else {
                imageView.setOnClickListener(null)
            }
            return
        }
        Glide.with(fragment).clear(imageView)
        imageView.setImageDrawable(null)
        if (item == null) {
            imageView.background = fragment.requireContext().getDrawable(R.drawable.bg_emote_placeholder)
            imageView.setTag(BOUND_STATE_TAG_KEY, nextState)
            imageView.setOnClickListener(null)
            return
        }
        imageView.background = null
        if (imageLibrary == "0" || (imageLibrary == "1" && !item.format.equals("webp", true))) {
            fragment.requireContext().imageLoader.enqueue(
                ImageRequest.Builder(fragment.requireContext()).apply {
                    data(url)
                    if (item.thirdParty) {
                        httpHeaders(
                            NetworkHeaders.Builder()
                                .add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                                .build()
                        )
                    }
                    crossfade(false)
                    target(imageView)
                }.build()
            )
        } else {
            Glide.with(fragment)
                .load(
                    url?.let {
                        if (item.thirdParty) {
                            GlideUrl(it) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) }
                        } else {
                            it
                        }
                    }
                )
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageView)
        }
        imageView.setTag(BOUND_STATE_TAG_KEY, nextState)
        imageView.setOnClickListener { clickListener(item) }
    }
}
