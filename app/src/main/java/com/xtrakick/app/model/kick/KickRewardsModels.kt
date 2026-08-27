package com.xtrakick.app.model.kick

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.longOrNull
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

data class KickDailyChallenge(
    val id: String,
    val status: String?,
    val recurrence: String?,
    val thresholdMinutes: Long?,
    val progressMinutes: Long?,
    val endsAtEpochMs: Long?,
    val winnerName: String?,
    val winnerRarity: String?,
) {
    /** Watch-time minutes still missing before the daily becomes claimable. */
    val remainingMinutes: Long?
        get() = if (thresholdMinutes != null && progressMinutes != null) {
            (thresholdMinutes - progressMinutes).coerceAtLeast(0)
        } else {
            null
        }
}

data class KickDropReward(
    val id: String,
    val name: String?,
    val claimed: Boolean,
    val requiredUnits: Long?,
    val progressFraction: Double?,
)

data class KickDropCampaign(
    val id: String,
    val name: String?,
    val status: String?,
    val progressUnits: Long,
    val rewards: List<KickDropReward>,
)

/** Tolerant parsers for Kick's private gamification/drops endpoints (`{data:[...]}` or bare array). */
object KickRewardsParsing {

    private fun dataArray(root: JsonElement): List<JsonObject> {
        val arrayElement: JsonElement? = when (root) {
            is JsonObject -> root["data"] ?: root["challenges"] ?: root["campaigns"]
            else -> root
        }
        return (arrayElement as? JsonArray)?.filterIsInstance<JsonObject>().orEmpty()
    }

    fun parseChallenges(root: JsonElement): List<KickDailyChallenge> =
        dataArray(root).mapNotNull { it.toDailyChallenge() }

    fun parseDropCampaigns(root: JsonElement): List<KickDropCampaign> =
        dataArray(root).mapNotNull { it.toDropCampaign() }

    /** Parses Kick ISO-8601 timestamps (`...Z`, optional millis, or explicit offsets); null when unparseable. */
    fun parseIsoTimestampMs(value: String): Long? {
        val normalized = value.trim()
        if (normalized.isEmpty()) return null
        val patterns = listOf(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            "yyyy-MM-dd'T'HH:mm:ssXXX",
        )
        for (pattern in patterns) {
            try {
                val format = SimpleDateFormat(pattern, Locale.US).apply {
                    timeZone = TimeZone.getTimeZone("UTC")
                    isLenient = false
                }
                format.parse(normalized)?.let { return it.time }
            } catch (_: Exception) {
                // try next pattern
            }
        }
        return null
    }

    private fun JsonObject.scalar(key: String): String? =
        (this[key] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }

    private fun JsonObject.longValue(key: String): Long? = when (val value = this[key]) {
        is JsonPrimitive -> value.longOrNull ?: value.doubleOrNull?.toLong()
            ?: value.contentOrNull?.trim()?.toDoubleOrNull()?.toLong()
        else -> null
    }

    private fun JsonObject.booleanValue(key: String): Boolean? = when (val value = this[key]) {
        is JsonPrimitive -> value.booleanOrNull ?: value.contentOrNull?.trim()?.toBooleanStrictOrNull()
        else -> null
    }

    private fun JsonObject.doubleValue(key: String): Double? = when (val value = this[key]) {
        is JsonPrimitive -> value.doubleOrNull ?: value.contentOrNull?.trim()?.toDoubleOrNull()
        else -> null
    }

    private fun JsonObject.objectAt(key: String): JsonObject? = this[key] as? JsonObject

    private fun JsonObject.toDailyChallenge(): KickDailyChallenge? {
        val id = scalar("id") ?: return null
        val condition = objectAt("condition")
        val window = objectAt("window")
        val winner = objectAt("winner") ?: objectAt("reward")
        return KickDailyChallenge(
            id = id,
            status = scalar("status"),
            recurrence = scalar("recurrence"),
            thresholdMinutes = condition?.longValue("threshold"),
            progressMinutes = condition?.longValue("progress"),
            endsAtEpochMs = window?.scalar("ends_at")?.let(::parseIsoTimestampMs),
            winnerName = winner?.let { currentWinner ->
                currentWinner.scalar("name")
                    ?: currentWinner.scalar("title")
                    ?: currentWinner.scalar("emote_name")
                    ?: currentWinner.scalar("label")
            },
            winnerRarity = winner?.scalar("rarity"),
        )
    }

    private fun JsonObject.toDropCampaign(): KickDropCampaign? {
        val id = scalar("id") ?: return null
        return KickDropCampaign(
            id = id,
            name = scalar("name") ?: scalar("campaign_name"),
            status = scalar("status"),
            progressUnits = longValue("progress_units") ?: 0L,
            rewards = (this["rewards"] as? JsonArray)?.filterIsInstance<JsonObject>().orEmpty()
                .mapNotNull { element ->
                    val rewardId = element.scalar("id") ?: return@mapNotNull null
                    KickDropReward(
                        id = rewardId,
                        name = element.scalar("name") ?: element.scalar("reward_name"),
                        claimed = element.booleanValue("claimed") ?: false,
                        requiredUnits = element.longValue("required_units"),
                        progressFraction = element.doubleValue("progress"),
                    )
                },
        )
    }
}