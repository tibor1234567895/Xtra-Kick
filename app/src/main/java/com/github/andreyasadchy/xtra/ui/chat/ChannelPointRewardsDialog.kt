package com.github.andreyasadchy.xtra.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogChannelPointRewardsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChannelPointRewardsDialog : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_BALANCE = "balance"
        private const val ARG_SUMMARY = "summary"

        fun newInstance(balanceText: String, summaryText: String): ChannelPointRewardsDialog {
            return ChannelPointRewardsDialog().apply {
                arguments = bundleOf(
                    ARG_BALANCE to balanceText,
                    ARG_SUMMARY to summaryText,
                )
            }
        }
    }

    private var _binding: DialogChannelPointRewardsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogChannelPointRewardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomSheetBehavior.from(view.parent as View).apply {
            skipCollapsed = true
            state = BottomSheetBehavior.STATE_EXPANDED
        }
        binding.balance.text = requireArguments().getString(ARG_BALANCE).orEmpty()
        binding.message.text = requireArguments().getString(ARG_SUMMARY).orEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
