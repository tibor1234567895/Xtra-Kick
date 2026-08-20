package com.github.andreyasadchy.xtra.ui.following.streams

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.github.andreyasadchy.xtra.util.bundleOf
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.DialogFollowedStreamsSortBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FollowedStreamsSortDialog : BottomSheetDialogFragment() {

    interface OnFilter {
        fun onChange(sort: String, sortText: CharSequence, changed: Boolean, saveDefault: Boolean)
    }

    companion object {
        const val SORT_VIEWERS = "VIEWER_COUNT"
        const val SORT_VIEWERS_ASC = "VIEWER_COUNT_ASC"
        const val SORT_RECENT = "RECENT"

        private const val SORT = "sort"

        fun newInstance(sort: String?): FollowedStreamsSortDialog {
            return FollowedStreamsSortDialog().apply {
                arguments = bundleOf(SORT to sort)
            }
        }
    }

    private var _binding: DialogFollowedStreamsSortBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnFilter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as OnFilter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogFollowedStreamsSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        with(binding) {
            val originalSortId = when (requireArguments().getString(SORT)) {
                SORT_VIEWERS_ASC -> R.id.viewers_low
                SORT_RECENT -> R.id.recent
                else -> R.id.viewers_high
            }
            sort.check(originalSortId)
            saveDefault.setOnClickListener {
                applyFilters(originalSortId, saveDefault = true)
                dismiss()
            }
            apply.setOnClickListener {
                applyFilters(originalSortId, saveDefault = false)
                dismiss()
            }
        }
    }

    private fun applyFilters(originalSortId: Int, saveDefault: Boolean) {
        with(binding) {
            val checkedSortId = sort.checkedRadioButtonId
            val sortBtn = requireView().findViewById<RadioButton>(checkedSortId)
            listener.onChange(
                when (checkedSortId) {
                    R.id.viewers_low -> SORT_VIEWERS_ASC
                    R.id.recent -> SORT_RECENT
                    else -> SORT_VIEWERS
                },
                sortBtn.text,
                checkedSortId != originalSortId,
                saveDefault,
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
