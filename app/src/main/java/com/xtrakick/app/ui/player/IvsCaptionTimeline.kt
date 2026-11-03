package com.xtrakick.app.ui.player

/** Maps IVS cue timestamps onto player position, as the SDK's PlayerView does. */
internal class IvsCaptionTimeline {
    private data class Entry(val text: String, val start: Long, val end: Long, val cueEnd: Long)
    private val entries = ArrayDeque<Entry>()
    val isEmpty: Boolean get() = entries.isEmpty()

    fun add(text: String, start: Long, end: Long, position: Long) {
        if (end <= start) return
        val previous = entries.lastOrNull()
        val display = previous?.let { it.end + start - it.cueEnd } ?: position
        entries.addLast(Entry(text, display, display + end - start, end))
    }

    fun textAt(position: Long): String? {
        while (entries.firstOrNull()?.let { position >= it.end } == true) entries.removeFirst()
        return entries.firstOrNull()?.takeIf { position >= it.start }?.text
    }

    fun clear() = entries.clear()
}
