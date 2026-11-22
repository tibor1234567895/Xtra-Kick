package com.xtrakick.app.ui.chat

import android.content.Context
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil3.decode.DataSource
import coil3.dispose
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.crossfade
import coil3.request.target
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.util.chat.ChatAdapterUtils
import com.xtrakick.app.util.chat.StvCdnHealth
import com.xtrakick.app.util.chat.stvPrefetchUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.util.WeakHashMap
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

object EmoteImageLoader {
    private data class EmoteRequest(val url: String, val thirdParty: Boolean)

    private class ViewLoad(
        val primary: EmoteRequest,
        val fallback: EmoteRequest?,
        val generation: Long,
        var failed: Boolean = false,
    )

    private val boundStates = WeakHashMap<ImageView, ViewLoad>()
    private val pendingWarming = mutableSetOf<EmoteRequest>()
    private val warmRetryDelaysMs = longArrayOf(5_000, 15_000, 45_000, 120_000, 300_000)
    private var cacheGeneration = 0L

    val warmingCacheEvents = MutableSharedFlow<Unit>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    internal fun pickerUrls(item: Emote, quality: String): List<String> {
        val primary = when (quality) {
            "4" -> item.url4x ?: item.url3x ?: item.url2x ?: item.url1x
            "3" -> item.url3x ?: item.url2x ?: item.url1x
            "2" -> item.url2x ?: item.url1x
            else -> item.url1x
        } ?: return emptyList()
        val fallback = when {
            !item.thirdParty -> null
            quality == "3" || quality == "4" -> item.stvPrefetchUrl().takeUnless { it == primary } ?: item.url1x
            else -> item.url1x
        }?.takeUnless { it == primary }
        return listOfNotNull(primary, fallback)
    }

    fun bind(
        imageView: ImageView,
        fragment: Fragment,
        item: Emote?,
        emoteQuality: String,
        clickListener: (Emote) -> Unit,
    ) {
        val urls = item?.let { pickerUrls(it, emoteQuality) }.orEmpty()
        val url = urls.firstOrNull()
        if (item == null || url == null) {
            clear(imageView)
            boundStates.remove(imageView)
            imageView.background = if (item == null) {
                fragment.requireContext().getDrawable(R.drawable.bg_emote_placeholder)
            } else {
                null
            }
            imageView.setOnClickListener(item?.let { View.OnClickListener { clickListener(item) } })
            return
        }

        val primary = EmoteRequest(url, item.thirdParty)
        val fallback = urls.getOrNull(1)?.let { primary.copy(url = it) }
        val previous = boundStates[imageView]
        imageView.setOnClickListener { clickListener(item) }
        if (previous?.primary == primary && previous.fallback == fallback &&
            (!previous.failed || previous.generation == cacheGeneration || primary in pendingWarming)
        ) return

        clear(imageView)
        imageView.background = null
        val load = ViewLoad(primary, fallback, cacheGeneration)
        boundStates[imageView] = load
        val viewScope = fragment.viewLifecycleOwner.lifecycleScope

        fun failed() {
            if (boundStates[imageView] !== load || !primary.isStvCdn) return
            load.failed = true
            viewScope.launch(Dispatchers.Main) {
                if (!pendingWarming.add(primary)) return@launch
                try {
                    warmCache(fragment, primary)
                } finally {
                    pendingWarming.remove(primary)
                }
                cacheGeneration++
                warmingCacheEvents.tryEmit(Unit)
            }
        }

        val context = fragment.requireContext()
        fun enqueue(request: EmoteRequest, onFailure: () -> Unit) {
            context.imageLoader.enqueue(
                request.coilRequest(context)
                    .target(imageView)
                    .listener(
                        onSuccess = { _, result ->
                            if (result.dataSource == DataSource.NETWORK) request.recordHealth(true)
                        },
                        onError = { _, _ ->
                            request.recordHealth(false)
                            if (boundStates[imageView] === load) onFailure()
                        },
                    ).build(),
            )
        }
        enqueue(primary) {
            if (fallback == null) failed() else enqueue(fallback, ::failed)
        }
    }

    private fun clear(imageView: ImageView) {
        imageView.dispose()
        imageView.setImageDrawable(null)
    }

    private suspend fun warmCache(fragment: Fragment, request: EmoteRequest) {
        val context = fragment.requireContext()
        var retry = 0
        while (true) {
            delay(warmRetryDelaysMs[retry])
            val result = context.imageLoader.execute(request.coilRequest(context).build())
            if (result !is SuccessResult || result.dataSource == DataSource.NETWORK) {
                request.recordHealth(result is SuccessResult)
            }
            if (result is SuccessResult) return
            retry = (retry + 1).coerceAtMost(warmRetryDelaysMs.lastIndex)
        }
    }

    private val EmoteRequest.isStvCdn: Boolean
        get() = thirdParty && url.toHttpUrlOrNull()?.host == StvCdnHealth.CDN_HOST

    private fun EmoteRequest.recordHealth(success: Boolean) {
        if (isStvCdn) StvCdnHealth.DEFAULT.record(success)
    }

    private fun EmoteRequest.coilRequest(context: Context) = ImageRequest.Builder(context).apply {
        data(url)
        if (thirdParty) {
            httpHeaders(NetworkHeaders.Builder().add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME).build())
        }
        crossfade(false)
    }

    /**
     * Stops animated emote drawables under [root] (Coil AnimatedImageDrawable / GifDrawable
     * implement Animatable). Used when the chat panel is hidden: the decode loop keeps
     * running against invisible views otherwise.
     */
    fun freezeAll(root: View) {
        forEachAnimatedView(root) { view ->
            when (view) {
                is ImageView -> (view.drawable as? Animatable)?.stop()
                is TextView -> ChatAdapterUtils.stopSpanAnimations(view.text)
            }
        }
    }

    /** Resumes animations stopped by [freezeAll]. */
    fun unfreezeAll(root: View) {
        forEachAnimatedView(root) { view ->
            when (view) {
                is ImageView -> (view.drawable as? Animatable)?.start()
                is TextView -> ChatAdapterUtils.startSpanAnimations(view.text)
            }
        }
    }

    private fun forEachAnimatedView(root: View, action: (View) -> Unit) {
        if (root is ImageView || root is TextView) {
            action(root)
            return
        }
        if (root is ViewGroup) {
            for (i in 0 until root.childCount) {
                forEachAnimatedView(root.getChildAt(i), action)
            }
        }
    }
}
