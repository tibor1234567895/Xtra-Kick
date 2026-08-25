package com.xtrakick.app.ui.multipov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogMultipovPickerBinding
import com.xtrakick.app.databinding.ItemMultipovPickerRowBinding
import com.xtrakick.app.model.ui.Stream
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MultiPovStreamPickerDialog : BottomSheetDialogFragment() {

    interface Listener {
        fun onStreamPicked(stream: Stream)
    }

    private var _binding: DialogMultipovPickerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MultiPovViewModel by viewModels({ requireParentFragment() })
    private var searchJob: Job? = null

    private val adapter = object : RecyclerView.Adapter<PickerVH>() {
        private val items = mutableListOf<Stream>()

        fun submit(list: List<Stream>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickerVH {
            val itemBinding = ItemMultipovPickerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PickerVH(itemBinding)
        }

        override fun onBindViewHolder(holder: PickerVH, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount(): Int = items.size
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogMultipovPickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        binding.resultsList.layoutManager = LinearLayoutManager(requireContext())
        binding.resultsList.adapter = adapter
        binding.sectionLabel.isVisible = true
        binding.sectionLabel.setText(R.string.multipov_picker_followed_live)

        // Default: live followed. Typing searches; clearing restores followed.
        viewModel.loadFollowedLivePicker()

        binding.searchInput.doAfterTextChanged { text ->
            searchJob?.cancel()
            val query = text?.toString().orEmpty()
            searchJob = viewLifecycleOwner.lifecycleScope.launch {
                if (query.isBlank()) {
                    viewModel.searchPicker("")
                } else {
                    delay(350)
                    viewModel.searchPicker(query)
                }
            }
        }
        binding.searchInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchPicker(binding.searchInput.text?.toString().orEmpty())
                true
            } else {
                false
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.pickerMode.collectLatest { mode ->
                        binding.sectionLabel.setText(
                            when (mode) {
                                MultiPovPickerMode.FollowedLive -> R.string.multipov_picker_followed_live
                                MultiPovPickerMode.Search -> R.string.multipov_picker_search_results
                            }
                        )
                        refreshListVisibility()
                    }
                }
                launch {
                    viewModel.pickerResults.collectLatest { results ->
                        adapter.submit(results)
                        refreshListVisibility()
                    }
                }
                launch {
                    viewModel.pickerLoading.collectLatest {
                        refreshListVisibility()
                    }
                }
            }
        }
    }

    private fun refreshListVisibility() {
        val binding = _binding ?: return
        val loading = viewModel.pickerLoading.value
        val empty = viewModel.pickerResults.value.isEmpty()
        binding.loadingIndicator.isVisible = loading
        binding.resultsList.isVisible = !empty
        binding.emptyText.isVisible = empty && !loading
        if (empty && !loading) {
            binding.emptyText.setText(
                when (viewModel.pickerMode.value) {
                    MultiPovPickerMode.FollowedLive -> R.string.multipov_picker_followed_empty
                    MultiPovPickerMode.Search -> R.string.multipov_search_hint
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        searchJob?.cancel()
        _binding = null
    }

    private inner class PickerVH(
        private val itemBinding: ItemMultipovPickerRowBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(stream: Stream) {
            itemBinding.title.text = stream.channelName ?: stream.channelLogin.orEmpty()
            val viewers = stream.viewerCount
            val gameOrTitle = stream.gameName ?: stream.title.orEmpty()
            itemBinding.subtitle.text = when {
                viewers != null && gameOrTitle.isNotBlank() ->
                    "${formatViewers(viewers)} · $gameOrTitle"
                viewers != null -> formatViewers(viewers)
                else -> gameOrTitle
            }
            itemBinding.root.setOnClickListener {
                (parentFragment as? Listener)?.onStreamPicked(stream)
                    ?: (activity as? Listener)?.onStreamPicked(stream)
                dismiss()
            }
        }

        private fun formatViewers(count: Int): String {
            return when {
                count >= 1_000_000 -> String.format(java.util.Locale.US, "%.1fM", count / 1_000_000.0)
                count >= 1_000 -> String.format(java.util.Locale.US, "%.1fK", count / 1_000.0)
                else -> count.toString()
            }
        }
    }

    companion object {
        const val TAG = "MultiPovStreamPickerDialog"
        fun newInstance() = MultiPovStreamPickerDialog()
    }
}
