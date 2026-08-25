package com.xtrakick.app.ui.chat

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xtrakick.app.util.bundleOf
import coil3.asDrawable
import coil3.imageLoader
import coil3.network.NetworkHeaders
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogChatImageClickBinding
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageClickedDialog : BottomSheetDialogFragment() {

    companion object {
        private const val IMAGE_URL = "image_url"
        private const val IMAGE_NAME = "image_name"
        private const val IMAGE_FORMAT = "image_format"
        private const val IMAGE_ANIMATED = "image_animated"
        private const val IMAGE_SOURCE = "image_source"
        private const val IMAGE_THIRD_PARTY = "image_third_party"
        private const val EMOTE_ID = "emote_id"

        fun newInstance(url: String?, name: String?, format: String?, isAnimated: Boolean?, source: Int?, thirdParty: Boolean?, emoteId: String?): ImageClickedDialog {
            return ImageClickedDialog().apply {
                arguments = bundleOf(
                    IMAGE_URL to url,
                    IMAGE_NAME to name,
                    IMAGE_FORMAT to format,
                    IMAGE_ANIMATED to isAnimated,
                    IMAGE_SOURCE to source,
                    IMAGE_THIRD_PARTY to thirdParty,
                    EMOTE_ID to emoteId
                )
            }
        }
    }

    private var _binding: DialogChatImageClickBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogChatImageClickBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        with(binding) {
            val args = requireArguments()
            val imageLibrary = requireContext().prefs().getString(AppConstants.CHAT_IMAGE_LIBRARY, "0")
            if (imageLibrary == "0" || (imageLibrary == "1" && !args.getString(IMAGE_FORMAT).equals("webp", true))) {
                requireContext().imageLoader.enqueue(
                    ImageRequest.Builder(requireContext()).apply {
                        data(args.getString(IMAGE_URL))
                        if (args.getBoolean(IMAGE_THIRD_PARTY)) {
                            httpHeaders(NetworkHeaders.Builder().apply {
                                add("User-Agent", "Xtra/" + BuildConfig.VERSION_NAME)
                            }.build())
                        }
                        target(
                            onSuccess = {
                                val result = it.asDrawable(resources)
                                if (result is Animatable && args.getBoolean(IMAGE_ANIMATED) && requireContext().prefs().getBoolean(AppConstants.ANIMATED_EMOTES, true)) {
                                    (result as Animatable).start()
                                }
                                image.setImageDrawable(result)
                            }
                        )
                    }.build()
                )
            } else {
                Glide.with(this@ImageClickedDialog)
                    .load(args.getString(IMAGE_URL).let {
                        if (args.getBoolean(IMAGE_THIRD_PARTY)) {
                            GlideUrl(it) { mapOf("User-Agent" to "Xtra/" + BuildConfig.VERSION_NAME) }
                        } else it
                    })
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(object : CustomTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            if (resource is Animatable && args.getBoolean(IMAGE_ANIMATED) && requireContext().prefs().getBoolean(AppConstants.ANIMATED_EMOTES, true)) {
                                (resource as Animatable).start()
                            }
                            image.setImageDrawable(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {}
                    })
            }
            args.getString(IMAGE_NAME)?.let {
                imageName.visibility = View.VISIBLE
                imageName.text = it
            }
            args.getInt(IMAGE_SOURCE, -1).takeIf { it != -1 }?.let {
                imageSource.visibility = View.VISIBLE
                imageSource.text = when (it) {
                    Emote.PERSONAL_STV -> getString(R.string.personal_stv_emote)
                    Emote.CHANNEL_STV -> getString(R.string.channel_stv_emote)
                    Emote.GLOBAL_STV -> getString(R.string.global_stv_emote)
                    else -> null
                }
            }        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
