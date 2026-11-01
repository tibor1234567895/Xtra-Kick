package com.xtrakick.app.model.kick

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.longOrNull
import kotlinx.serialization.json.put
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
    val winnerCardUrl: String?,
    val name: String? = null,
    val featured: Boolean = false,
    val description: String? = null,
    val idleAnimationUrl: String? = null,
    val unboxAnimationUrl: String? = null,
    val activePeriodEndsAtEpochMs: Long? = null,
    val dropTable: List<KickChallengeDropTableItem> = emptyList(),
    val winnerThumbnailUrl: String? = null,
) {
    /** Watch-time minutes still missing before the daily becomes claimable. */
    val remainingMinutes: Long?
        get() = if (thresholdMinutes != null && progressMinutes != null) {
            (thresholdMinutes - progressMinutes).coerceAtLeast(0)
        } else {
            null
        }
}

data class KickChallengeDropTableItem(
    val rarity: String,
    val weighting: Long,
    val percentage: Double,
    val percentageFormatted: String,
)

data class KickDailyClaimResult(
    val challengeId: String?,
    val roulette: List<KickDailyRouletteItem>,
    val winner: KickDailyRewardWinner?,
) {
    /** Inverse of `KickRewardsParsing.parseDailyClaim` for persisting the debug replay payload. */
    fun toJsonElement(): JsonElement = buildJsonObject {
        challengeId?.let { put("challenge_id", JsonPrimitive(it)) }
        put(
            "roulette",
            JsonArray(roulette.map { item ->
                buildJsonObject {
                    put("id", JsonPrimitive(item.id))
                    item.itemUrl?.let { put("item_url", JsonPrimitive(it)) }
                }
            }),
        )
        winner?.let { w ->
            put(
                "winner",
                buildJsonObject {
                    put("id", JsonPrimitive(w.id))
                    w.cardUrl?.let { put("card_url", JsonPrimitive(it)) }
                    w.rarity?.let { put("rarity", JsonPrimitive(it)) }
                    w.thumbnailUrl?.let { put("thumbnail_url", JsonPrimitive(it)) }
                },
            )
        }
    }
}

data class KickDailyRouletteItem(
    val id: String,
    val itemUrl: String?,
)

data class KickDailyRewardWinner(
    val id: String,
    val cardUrl: String?,
    val rarity: String?,
    val thumbnailUrl: String? = null,
)

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

    fun parseDailyClaim(root: JsonElement): KickDailyClaimResult {
        val data = (root as? JsonObject)?.objectAt("data") ?: root as? JsonObject
            ?: return KickDailyClaimResult(null, emptyList(), null)
        val roulette = (data["roulette"] as? JsonArray)
            ?.filterIsInstance<JsonObject>()
            .orEmpty()
            .mapNotNull { item ->
                val id = item.scalar("id") ?: return@mapNotNull null
                val itemUrl = item.scalar("item_url")
                    ?: item.scalar("thumbnail_url")
                    ?: item.scalar("card_url")
                    ?: item.scalar("image_url")
                KickDailyRouletteItem(id, itemUrl)
            }
        val winnerObj = data.objectAt("winner") ?: data.objectAt("reward")
        val winner = winnerObj?.let { item ->
            val id = item.scalar("id") ?: return@let null
            val parsedCard = item.scalar("card_url")
            val parsedThumbnail = item.scalar("thumbnail_url")
                ?: item.scalar("image_url")
                ?: item.scalar("item_url")
            KickDailyRewardWinner(
                id = id,
                cardUrl = parsedCard ?: parsedThumbnail,
                rarity = item.scalar("rarity"),
                thumbnailUrl = parsedThumbnail ?: parsedCard,
            )
        }
        return KickDailyClaimResult(
            challengeId = data.scalar("challenge_id"),
            roulette = roulette,
            winner = winner,
        )
    }

    fun parseStreakLengthDays(root: JsonElement): Long? {
        val data = (root as? JsonObject)?.objectAt("data") ?: root as? JsonObject ?: return null
        return data.longValue("length_days")
    }

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
        is JsonPrimitive -> value.booleanOrNull
            ?: value.contentOrNull?.trim()?.toBooleanStrictOrNull()
            ?: (value.longOrNull?.let { it != 0L })
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
        val animations = objectAt("animations")
        val activePeriod = objectAt("active_period")

        val rawDropTable = (this["drop_table"] as? JsonArray)?.filterIsInstance<JsonObject>().orEmpty()
        val totalWeight = rawDropTable.sumOf { it.longValue("weighting") ?: 0L }
        val parsedDropTable = rawDropTable.mapNotNull { item ->
            val rarity = item.scalar("rarity") ?: return@mapNotNull null
            val weighting = item.longValue("weighting") ?: 0L
            val percentage = if (totalWeight > 0) (weighting.toDouble() / totalWeight) * 100.0 else 0.0
            val diffFromInt = kotlin.math.abs(percentage - kotlin.math.round(percentage))
            val formatted = when {
                percentage > 0.0 && percentage < 0.01 -> "<0.01%"
                percentage >= 0.01 && percentage < 0.1 -> String.format(Locale.US, "%.2f%%", percentage)
                diffFromInt < 0.001 -> "${kotlin.math.round(percentage).toInt()}%"
                else -> String.format(Locale.US, "%.1f%%", percentage)
            }
            KickChallengeDropTableItem(
                rarity = rarity,
                weighting = weighting,
                percentage = percentage,
                percentageFormatted = formatted,
            )
        }

        val parsedCard = winner?.scalar("card_url")
        val parsedThumbnail = winner?.scalar("thumbnail_url")
            ?: winner?.scalar("image_url")
            ?: winner?.scalar("item_url")

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
            winnerCardUrl = parsedCard ?: parsedThumbnail,
            name = scalar("name") ?: scalar("title"),
            featured = booleanValue("featured") ?: false,
            description = scalar("description"),
            idleAnimationUrl = animations?.scalar("idle_url")?.let { url ->
                if (url.endsWith(".gif", ignoreCase = true) ||
                    url.endsWith(".webp", ignoreCase = true) ||
                    url.endsWith(".png", ignoreCase = true)
                ) url else "$url.gif"
            },
            unboxAnimationUrl = animations?.scalar("unbox_url")?.let { url ->
                if (url.endsWith(".gif", ignoreCase = true) ||
                    url.endsWith(".webp", ignoreCase = true) ||
                    url.endsWith(".png", ignoreCase = true)
                ) url else "$url.gif"
            },
            activePeriodEndsAtEpochMs = activePeriod?.scalar("ends_at")?.let(::parseIsoTimestampMs),
            dropTable = parsedDropTable,
            winnerThumbnailUrl = parsedThumbnail ?: parsedCard,
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
