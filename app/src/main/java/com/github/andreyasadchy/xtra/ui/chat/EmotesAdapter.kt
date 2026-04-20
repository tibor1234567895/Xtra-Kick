package com.github.andreyasadchy.xtra.ui.chat

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.andreyasadchy.xtra.databinding.FragmentEmotesListItemBinding
import com.github.andreyasadchy.xtra.model.chat.Emote
import kotlin.math.max
import kotlin.math.min

class EmotesAdapter(
    private val fragment: Fragment,
    private val clickListener: (Emote) -> Unit,
    private val emoteQuality: String,
    private val imageLibrary: String?,
) : ListAdapter<Emote, EmotesAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Emote>() {
        override fun areItemsTheSame(oldItem: Emote, newItem: Emote): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Emote, newItem: Emote): Boolean {
            return true
        }
    }
) {
    private var loadedCount = 0

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).name?.hashCode()?.toLong() ?: RecyclerView.NO_ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentEmotesListItemBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(
        private val binding: FragmentEmotesListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Emote?, isLoaded: Boolean) {
            EmoteImageLoader.bind(
                imageView = binding.root,
                fragment = fragment,
                item = if (isLoaded) item else null,
                emoteQuality = emoteQuality,
                imageLibrary = imageLibrary,
                clickListener = clickListener,
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position < loadedCount)
    }

    fun getLoadedCount(): Int = loadedCount

    fun setLoadedCount(count: Int) {
        val newCount = count.coerceIn(0, currentList.size)
        if (newCount == loadedCount) return
        val oldCount = loadedCount
        loadedCount = newCount
        if (currentList.isEmpty()) return
        val changedStart = min(oldCount, newCount)
        val changedCount = max(oldCount, newCount) - changedStart
        if (changedCount > 0) {
            notifyItemRangeChanged(changedStart, changedCount)
        }
    }
}
