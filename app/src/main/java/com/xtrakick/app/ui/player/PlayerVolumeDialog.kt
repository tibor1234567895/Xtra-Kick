package com.xtrakick.app.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import com.xtrakick.app.util.bundleOf
import com.xtrakick.app.R
import com.xtrakick.app.databinding.PlayerVolumeBinding
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider
import java.util.Locale

import androidx.annotation.DrawableRes
import com.xtrakick.app.ui.multipov.MultiPovFragment

class PlayerVolumeDialog : BottomSheetDialogFragment() {

    companion object {
        private const val VOLUME = "volume"

        fun newInstance(volume: Float?): PlayerVolumeDialog {
            return PlayerVolumeDialog().apply {
                arguments = bundleOf(VOLUME to (volume ?: 1f))
            }
        }

        @DrawableRes
        fun getVolumeIconRes(volumeFraction: Float): Int = getVolumeIconRes((volumeFraction * 100f).toInt())

        @DrawableRes
        fun getVolumeIconRes(volumePercent: Int): Int = when {
            volumePercent <= 0 -> R.drawable.baseline_volume_off_black_24
            volumePercent <= 33 -> R.drawable.ic_volume_low
            volumePercent <= 66 -> R.drawable.ic_volume_medium
            else -> R.drawable.ic_volume_high
        }
    }

    private var _binding: PlayerVolumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = PlayerVolumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        with(binding) {
            val prefVolume = requireContext().prefs().getInt(AppConstants.PLAYER_VOLUME, 100) / 100f
            val argVolume = if (requireArguments().containsKey(VOLUME)) requireArguments().getFloat(VOLUME, prefVolume) else prefVolume
            val initialVolume = ((if (argVolume in 0f..1f) argVolume else prefVolume) * 100f).coerceIn(0f, 100f)
            setVolume(initialVolume)
            volumeBar.value = initialVolume
            volumeBar.addOnChangeListener { _, value, _ ->
                notifyVolumeChanged(value / 100f)
                setVolume(value)
            }
            volumeBar.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                override fun onStartTrackingTouch(slider: Slider) {}

                override fun onStopTrackingTouch(slider: Slider) {
                    requireContext().prefs().edit { putInt(AppConstants.PLAYER_VOLUME, slider.value.toInt()) }
                }
            })
        }
    }

    private fun notifyVolumeChanged(volumeFraction: Float) {
        (parentFragment as? PlayerFragment)?.changeVolume(volumeFraction)
        (parentFragment as? MultiPovFragment)?.changeVolume(volumeFraction)
    }

    private fun setVolume(volume: Float) {
        with(binding) {
            volumeText.text = String.format(Locale.getDefault(), "%d", volume.toInt())
            volumeMute.setImageResource(getVolumeIconRes(volume.toInt()))
            if (volume == 0f) {
                volumeMute.setOnClickListener {
                    val restoredVolume = requireContext().prefs().getInt(AppConstants.PLAYER_VOLUME, 100).takeIf { it > 0 }?.toFloat() ?: 100f
                    volumeBar.value = restoredVolume
                    notifyVolumeChanged(restoredVolume / 100f)
                    setVolume(restoredVolume)
                }
            } else {
                volumeMute.setOnClickListener {
                    volumeBar.value = 0f
                    notifyVolumeChanged(0f)
                    setVolume(0f)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
