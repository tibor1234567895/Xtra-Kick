package com.github.andreyasadchy.xtra.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.andreyasadchy.xtra.databinding.FragmentEmotesListItemBinding
import com.github.andreyasadchy.xtra.databinding.ItemEmoteSectionBinding
import com.github.andreyasadchy.xtra.model.chat.Emote

class EmoteSectionAdapter(
    private val fragment: Fragment,
    private val onToggle: (EmotePickerSection) -> Unit,
    private val onEmoteClick: (Emote) -> Unit,
    private val emoteQuality: String,
    private val imageLibrary: String?,
) : ListAdapter<EmotePickerListItem, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<EmotePickerListItem>() {
        override fun areItemsTheSame(oldItem: EmotePickerListItem, newItem: EmotePickerListItem): Boolean {
            return when {
                oldItem is EmotePickerListItem.SectionHeader && newItem is EmotePickerListItem.SectionHeader ->
                    oldItem.section.key == newItem.section.key
                oldItem is EmotePickerListItem.EmoteEntry && newItem is EmotePickerListItem.EmoteEntry ->
                    oldItem.sectionKey == newItem.sectionKey && oldItem.emote.name == newItem.emote.name
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: EmotePickerListItem, newItem: EmotePickerListItem): Boolean {
            return oldItem == newItem
        }
    }
) {
    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_EMOTE = 1
    }

    private val sharedRecycledViewPool = RecyclerView.RecycledViewPool().apply {
        setMaxRecycledViews(VIEW_TYPE_EMOTE, 160)
        setMaxRecycledViews(VIEW_TYPE_HEADER, 16)
    }

    init {
        setHasStableIds(true)
    }

    fun submitSections(sections: List<EmotePickerSection>) {
        submitList(
            buildList {
                sections.forEach { section ->
                    add(EmotePickerListItem.SectionHeader(section))
                    if (section.expanded) {
                        section.emotes.forEachIndexed { index, emote ->
                            add(EmotePickerListItem.EmoteEntry(section.key, emote, index))
                        }
                    }
                }
            }
        )
    }

    fun getSpanSize(position: Int, spanCount: Int): Int {
        return when (getItem(position)) {
            is EmotePickerListItem.SectionHeader -> spanCount
            is EmotePickerListItem.EmoteEntry -> 1
        }
    }

    override fun getItemId(position: Int): Long {
        return when (val item = getItem(position)) {
            is EmotePickerListItem.SectionHeader -> item.section.key.hashCode().toLong()
            is EmotePickerListItem.EmoteEntry -> (31L * item.sectionKey.hashCode()) + (item.emote.name?.hashCode()?.toLong() ?: item.indexInSection.toLong())
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is EmotePickerListItem.SectionHeader -> VIEW_TYPE_HEADER
            is EmotePickerListItem.EmoteEntry -> VIEW_TYPE_EMOTE
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.setRecycledViewPool(sharedRecycledViewPool)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> SectionHeaderViewHolder(
                ItemEmoteSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> EmoteViewHolder(
                FragmentEmotesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is EmotePickerListItem.SectionHeader -> (holder as SectionHeaderViewHolder).bind(item.section)
            is EmotePickerListItem.EmoteEntry -> (holder as EmoteViewHolder).bind(item.emote)
        }
    }

    inner class SectionHeaderViewHolder(
        private val binding: ItemEmoteSectionBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EmotePickerSection) {
            binding.sectionTitle.text = item.title
            binding.sectionChevron.rotation = if (item.expanded) 180f else 0f
            binding.sectionHeader.setOnClickListener { onToggle(item) }
        }
    }

    inner class EmoteViewHolder(
        private val binding: FragmentEmotesListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Emote) {
            EmoteImageLoader.bind(
                imageView = binding.root,
                fragment = fragment,
                item = item,
                emoteQuality = emoteQuality,
                imageLibrary = imageLibrary,
                clickListener = onEmoteClick,
            )
        }
    }
}
