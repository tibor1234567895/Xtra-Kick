package com.xtrakick.app.ui.channel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogFollowChannelSheetBinding
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs

class FollowChannelBottomSheet : BottomSheetDialogFragment() {

    interface Callback {
        fun onFollowModeSelected(kickFollow: Boolean)
    }

    companion object {
        const val REQUEST_KEY = "follow_channel_choice"
        const val RESULT_KICK_FOLLOW = "result_kick_follow"
        private const val ARG_CHANNEL_NAME = "arg_channel_name"
        private const val ARG_IS_OWN_CHANNEL = "arg_is_own_channel"

        fun newInstance(channelName: String? = null, isOwnChannel: Boolean = false): FollowChannelBottomSheet {
            return FollowChannelBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_CHANNEL_NAME, channelName ?: "")
                    putBoolean(ARG_IS_OWN_CHANNEL, isOwnChannel)
                }
            }
        }
    }

    private var _binding: DialogFollowChannelSheetBinding? = null
    private val binding get() = _binding!!
    private var callback: Callback? = null
    private var selectedKickFollow: Boolean = true

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = (parentFragment as? Callback) ?: (context as? Callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFollowChannelSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        val channelName = arguments?.getString(ARG_CHANNEL_NAME).orEmpty()
        val isOwnChannel = arguments?.getBoolean(ARG_IS_OWN_CHANNEL, false) ?: false
        val prefs = requireContext().prefs()
        val defaultSetting = prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0
        val isRemembered = prefs.getBoolean(AppConstants.FOLLOW_MODE_REMEMBERED, false)

        binding.followSheetTitle.text = if (channelName.isNotBlank()) {
            getString(R.string.follow_channel_title, channelName)
        } else {
            getString(R.string.follow)
        }

        val defaultTag = " " + getString(R.string.default_tag)
        if (defaultSetting == 0) {
            binding.kickFollowTitle.text = getString(R.string.follow_on_kick) + defaultTag
            binding.localFollowTitle.text = getString(R.string.follow_local_only)
        } else {
            binding.kickFollowTitle.text = getString(R.string.follow_on_kick)
            binding.localFollowTitle.text = getString(R.string.follow_local_only) + defaultTag
        }

        selectedKickFollow = if (isOwnChannel) {
            false
        } else {
            savedInstanceState?.getBoolean("selected_kick_follow") ?: (defaultSetting == 0)
        }
        updateRadioSelection(selectedKickFollow)
        binding.rememberChoiceCheckbox.isChecked = isRemembered

        if (isOwnChannel) {
            binding.optionKickFollow.isEnabled = false
            binding.optionKickFollow.alpha = 0.4f
            binding.radioKickFollow.isEnabled = false
            binding.kickFollowDesc.setText(R.string.follow_on_kick_own_account_unsupported)
            binding.rememberChoiceCheckbox.visibility = View.GONE
        } else {
            binding.optionKickFollow.setOnClickListener {
                selectedKickFollow = true
                updateRadioSelection(true)
            }
            binding.radioKickFollow.setOnClickListener {
                selectedKickFollow = true
                updateRadioSelection(true)
            }
        }

        binding.optionLocalFollow.setOnClickListener {
            selectedKickFollow = false
            updateRadioSelection(false)
        }
        binding.radioLocalFollow.setOnClickListener {
            selectedKickFollow = false
            updateRadioSelection(false)
        }

        binding.btnFollow.setOnClickListener {
            confirmSelection()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("selected_kick_follow", selectedKickFollow)
    }

    private fun updateRadioSelection(kickFollow: Boolean) {
        binding.radioKickFollow.isChecked = kickFollow
        binding.radioLocalFollow.isChecked = !kickFollow
    }

    private fun confirmSelection() {
        val remember = binding.rememberChoiceCheckbox.isChecked
        val isOwnChannel = arguments?.getBoolean(ARG_IS_OWN_CHANNEL, false) ?: false
        if (!isOwnChannel) {
            requireContext().prefs().edit {
                putBoolean(AppConstants.FOLLOW_MODE_REMEMBERED, remember)
                if (remember) {
                    putString(AppConstants.UI_FOLLOW_BUTTON, if (selectedKickFollow) "0" else "1")
                }
            }
        }
        setFragmentResult(
            REQUEST_KEY,
            Bundle().apply { putBoolean(RESULT_KICK_FOLLOW, selectedKickFollow) },
        )
        callback?.onFollowModeSelected(selectedKickFollow)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
