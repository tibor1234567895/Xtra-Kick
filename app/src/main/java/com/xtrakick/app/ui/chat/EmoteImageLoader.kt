package com.xtrakick.app.ui.chat

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
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Emote
import java.util.WeakHashMap

object EmoteImageLoader {
    // Bind-state memoization uses a WeakHashMap instead of View.setTag(key, ...) because this
    // platform throws "The key must be an application-specific resource id." for keyed tags
    // even when the key is a dedicated ids.xml id. Weak keys drop entries automatically when
    // a recycled/forgotten ImageView is collected, so nothing leaks.
    private val boundStates = WeakHashMap<ImageView, String>()

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
        if (boundStates[imageView] == nextState) {
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
            boundStates[imageView] = nextState
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
        boundStates[imageView] = nextState
        imageView.setOnClickListener { clickListener(item) }
    }
}
