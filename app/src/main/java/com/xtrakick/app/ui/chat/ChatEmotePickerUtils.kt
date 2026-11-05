package com.xtrakick.app.ui.chat

import android.content.Context
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Emote
import com.xtrakick.app.model.chat.RecentEmote
import com.xtrakick.app.repository.KickRepository

object ChatEmotePickerUtils {

    @JvmStatic
    fun buildEmoteLookupMap(
        userEmotes: List<Emote>,
        kickEmoteGroups: List<KickRepository.KickEmoteGroup>,
        sevenTvEmotes: List<Emote>,
    ): Map<String, Emote> {
        val lookup = LinkedHashMap<String, Emote>()
        userEmotes.forEach { emote ->
            val name = emote.name ?: return@forEach
            lookup.putIfAbsent(name, emote)
        }
        for (group in kickEmoteGroups) {
            for (emote in group.emotes) {
                val name = emote.name ?: continue
                lookup.putIfAbsent(name, emote)
            }
        }
        sevenTvEmotes.forEach { emote ->
            val name = emote.name ?: return@forEach
            lookup.putIfAbsent(name, emote)
        }
        return lookup
    }

    @JvmStatic
    fun resolveRecentEmotes(
        recentEmotes: List<RecentEmote>,
        emoteLookup: Map<String, Emote>,
    ): List<Emote> {
        return recentEmotes
            .sortedByDescending { it.usedAt }
            .mapNotNull { recentEmote -> emoteLookup[recentEmote.name] }
            .distinctBy { it.name }
    }

    @JvmStatic
    fun buildEmotePickerSections(
        context: Context,
        resolvedRecentEmotes: List<Emote>,
        kickEmoteGroups: List<KickRepository.KickEmoteGroup>,
        currentKickGroup: KickRepository.KickEmoteGroup?,
        sevenTvEmotes: List<Emote>,
        query: String,
    ): List<EmotePickerSection> {
        val normalizedQuery = query.trim()
        val hasQuery = normalizedQuery.isNotEmpty()

        fun List<Emote>.filterForQuery(): List<Emote> {
            return if (hasQuery) {
                filter { it.name?.contains(normalizedQuery, ignoreCase = true) == true }
            } else {
                this
            }.distinctBy { it.name }
        }

        return buildList {
            fun addSection(
                key: String,
                emotes: List<Emote>?,
                expandedByDefault: Boolean,
                title: () -> String,
            ) {
                val filteredEmotes = emotes?.filterForQuery() ?: return
                if (filteredEmotes.isEmpty()) return
                add(
                    EmotePickerSection(
                        key = key,
                        title = title(),
                        emotes = filteredEmotes,
                        expandedByDefault = expandedByDefault,
                    )
                )
            }

            if (!hasQuery && resolvedRecentEmotes.isNotEmpty()) {
                add(
                    EmotePickerSection(
                        key = "recent",
                        title = context.getString(R.string.emote_section_recent),
                        emotes = resolvedRecentEmotes,
                        expandedByDefault = true,
                    )
                )
            }

            var collectiblesKickGroup: KickRepository.KickEmoteGroup? = null
            val otherKickGroups = ArrayList<KickRepository.KickEmoteGroup>()
            val currentId = currentKickGroup?.id
            kickEmoteGroups.forEach { group ->
                when {
                    currentId != null && group.id.equals(currentId, ignoreCase = true) -> Unit
                    group.id.equals("Collectibles", ignoreCase = true) || group.title.equals("Collectibles", ignoreCase = true) -> {
                        collectiblesKickGroup = group
                    }
                    else -> otherKickGroups.add(group)
                }
            }

            addSection("kick-collectibles", collectiblesKickGroup?.emotes, true) {
                context.getString(R.string.emote_section_collectibles)
            }

            currentKickGroup?.let { group ->
                addSection("kick-current", group.emotes, true) { group.title }
            }
            val globalKickEmotes = LinkedHashMap<String, Emote>()
            otherKickGroups.forEach { group ->
                val isGlobalLike = group.title.equals("Global", ignoreCase = true) ||
                    group.title.equals("Emojis", ignoreCase = true) ||
                    group.id.equals("Emoji", ignoreCase = true)
                if (isGlobalLike) {
                    group.emotes.forEach { emote ->
                        val name = emote.name ?: return@forEach
                        globalKickEmotes.putIfAbsent(name, emote)
                    }
                } else {
                    addSection("kick-${group.id}", group.emotes, hasQuery) { group.title }
                }
            }
            addSection("kick-global", globalKickEmotes.values.toList(), hasQuery) {
                context.getString(R.string.emote_section_global)
            }

            addSection("7tv", sevenTvEmotes, hasQuery) { "7TV" }
        }
    }
}
