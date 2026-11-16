package com.xtrakick.app.ui.main

import java.util.Locale

object KickRewardsUiUtils {
    fun rarityColor(rarity: String?): Int = when (rarity?.lowercase(Locale.ROOT)) {
        "mythic" -> 0xFFEC4899.toInt()     // Pink / Magenta
        "legendary" -> 0xFFF59E0B.toInt()  // Amber / Gold
        "epic" -> 0xFFA855F7.toInt()       // Purple
        "rare" -> 0xFF38BDF8.toInt()       // Sky Blue
        "uncommon" -> 0xFF53FC18.toInt()   // Kick Green
        else -> 0xFF9E9E9E.toInt()         // Common / Grey
    }

    fun rarityLabel(rarity: String?): String {
        val raw = rarity?.trim()?.lowercase(Locale.ROOT) ?: return "Common"
        return raw.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }
}
