package com.xtrakick.app.repository

import com.xtrakick.app.model.chat.Poll
import com.xtrakick.app.model.chat.Prediction
import com.xtrakick.app.model.chat.Raid
import com.xtrakick.app.model.kick.KickChannelMoveEvent
import com.xtrakick.app.model.kick.KickLiveNotificationEvent
import com.xtrakick.app.model.kick.KickRealtimeChannelPointsUpdate
import com.xtrakick.app.util.KickApiHelper
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import java.util.Locale

private val CHANNEL_MOVE_EVENTS = setOf(
    "chatmovetosupportedchannelevent",
    "app\\events\\chatmovetosupportedchannelevent",
)

private val PREDICTION_EVENTS = setOf(
    "predictioncreated",
    "app\\events\\predictioncreated",
    "predictionupdated",
    "app\\events\\predictionupdated",
    "predictionlocked",
    "app\\events\\predictionlocked",
    "predictionended",
    "app\\events\\predictionended",
    "predictionresolved",
    "app\\events\\predictionresolved",
    "predictioncancelled",
    "app\\events\\predictioncancelled",
)

private val ROOM_STATE_KEYS = setOf(
    "slow", "follower", "follow", "subscriber", "sub", "emote", "unique", "r9k", "interval"
)

private val VIEWER_COUNT_JSON_KEYS = listOf("data", "payload", "message")

private val VIEWER_COUNT_NUMERIC_KEYS = listOf(
    "viewer_count", "viewers_count", "viewers", "view_count", "viewerCount", "total_viewers"
)

internal class KickRealtimeEventParsers(private val json: Json) {

    fun parseKickChannelMoveEvent(eventName: String?, messageJson: String): KickChannelMoveEvent? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent !in CHANNEL_MOVE_EVENTS) {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        val channel = root.objOrNull("channel")
        val hosted = root.objOrNull("hosted")
            ?: channel?.objOrNull("hosted")
            ?: root.objOrNull("target")
            ?: root.objOrNull("destination")
            ?: return null
        val targetLogin = hosted.firstPrimitiveOrNull("slug", "channel_slug", "login")
            ?: hosted.primitiveOrNull("username")?.lowercase(Locale.ROOT)
            ?: root.firstPrimitiveOrNull("slug", "hosted_slug", "target_slug")
        val targetName = hosted.firstPrimitiveOrNull("username", "name", "slug")
            ?: targetLogin
        val targetId = hosted.firstPrimitiveOrNull("id", "channel_id")
            ?: channel?.firstPrimitiveOrNull("id", "channel_id")
        if (targetLogin.isNullOrBlank() && targetId.isNullOrBlank()) {
            return null
        }
        val viewerCount = hosted.firstLongOrNull("viewers_count", "viewer_count", "number_viewers", "numberOfViewers")
            ?: root.firstLongOrNull("viewers_count", "viewer_count", "number_viewers", "numberOfViewers")
        val countdownSeconds = root.firstLongOrNull(
            "countdown_seconds",
            "remaining_seconds",
            "move_in_seconds",
            "redirect_in_seconds",
            "duration",
            "remaining",
        ) ?: hosted.firstLongOrNull(
            "countdown_seconds",
            "remaining_seconds",
            "move_in_seconds",
            "redirect_in_seconds",
            "duration",
            "remaining",
        )
        val profileImage = hosted.firstPrimitiveOrNull("profile_pic", "profile_picture", "profile_image")
        val sourceSlug = channel?.firstPrimitiveOrNull("slug", "channel_slug")
            ?: root.firstPrimitiveOrNull("source_slug", "from_slug", "channel_slug")
        val message = buildString {
            if (!sourceSlug.isNullOrBlank()) {
                append(sourceSlug)
                append(" moved viewers to ")
            } else {
                append("Moving viewers to ")
            }
            append(targetName ?: targetLogin ?: targetId)
            viewerCount?.takeIf { it > 0 }?.let {
                append(" with ")
                append(it)
                append(" viewers")
            }
        }
        val parsedCountdownSeconds = countdownSeconds?.toInt()
        val effectiveCountdownSeconds = when {
            parsedCountdownSeconds == null -> 10
            parsedCountdownSeconds > 0 -> parsedCountdownSeconds
            else -> null
        }
        return KickChannelMoveEvent(
            raid = Raid(
                raidId = "kick_move:${targetId ?: targetLogin}:${root.primitiveOrNull("created_at") ?: messageJson.hashCode()}",
                targetId = targetId,
                targetLogin = targetLogin,
                targetName = targetName,
                targetProfileImage = profileImage,
                viewerCount = viewerCount?.toInt(),
                countdownSeconds = effectiveCountdownSeconds,
                openStream = effectiveCountdownSeconds == null,
            ),
            message = message,
            rawEventName = eventName,
            rawPayload = messageJson,
        )
    }

    fun parseKickRealtimeChannelPointsUpdate(eventName: String?, messageJson: String): KickRealtimeChannelPointsUpdate? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent != "pointsupdated") {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        return KickRealtimeChannelPointsUpdate(
            reason = root.primitiveOrNull("reason"),
            points = (root["points"] as? JsonPrimitive)?.intOrNull,
            balance = (root["balance"] as? JsonPrimitive)?.intOrNull,
            userId = root.primitiveOrNull("user_id"),
            channelId = root.primitiveOrNull("channel_id"),
        )
    }

    fun parseKickRealtimePredictionUpdate(eventName: String?, messageJson: String): Prediction? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent !in PREDICTION_EVENTS) {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        val predictionObject = root.objOrNull("prediction") ?: root
        return parseKickPredictionObject(
            predictionObject = predictionObject,
            userVoteObject = root.objOrNull("user_vote"),
            normalizedEvent = normalizedEvent,
        )
    }

    fun parseKickRealtimePollUpdate(eventName: String?, messageJson: String): Poll? {
        val normalizedEvent = eventName?.trim()?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent == "app\\events\\polldeleteevent") {
            val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull()
            val pollObject = root?.objOrNull("poll") ?: root
            return Poll(
                id = pollObject?.firstPrimitiveOrNull("poll_id", "id", "title"),
                title = pollObject?.primitiveOrNull("title"),
                status = "DELETED",
                choices = null,
                totalVotes = null,
                remainingMilliseconds = 0,
            )
        }
        if (normalizedEvent != "app\\events\\pollupdateevent") {
            return null
        }
        val root = runCatching { json.parseToJsonElement(messageJson).jsonObject }.getOrNull() ?: return null
        val pollObject = root.objOrNull("poll") ?: root
        return parseKickPollObject(pollObject)
    }

    fun parseKickLiveNotificationEvent(eventName: String?, messageJson: String): KickLiveNotificationEvent? {
        val normalized = eventName?.trim().orEmpty()
        if (!normalized.equals("NotifyFollowersStreamHasStarted", ignoreCase = true) &&
            !normalized.equals("App\\Events\\NotifyFollowersStreamHasStarted", ignoreCase = true)
        ) {
            return null
        }
        return runCatching {
            json.decodeFromString<KickLiveNotificationEvent>(messageJson)
        }.getOrNull()
    }

    /** Viewer count pushed via `App\Events\LivestreamUpdated` (official `useViewCountWSHandler`). */
    fun parseKickLivestreamViewerCount(eventName: String?, messageJson: String): Int? {
        val normalized = eventName?.trim().orEmpty()
        if (normalized.isBlank()) return null
        val lower = normalized.lowercase(Locale.ROOT)
        val isLivestreamEvent = lower == "app\\events\\livestreamupdated" ||
            lower == "livestreamupdated" ||
            lower == "livestream.updated" ||
            lower == "livestream_update" ||
            lower == "livestream.viewer_count.updated"
        if (!isLivestreamEvent) return null
        return extractViewerCountFromRealtimeJson(messageJson)
    }

    fun shouldRefreshRoomStateFromRealtimeEvent(eventName: String?, messageJson: String): Boolean {
        val normalizedEvent = eventName?.lowercase(Locale.ROOT).orEmpty()
        if (normalizedEvent.contains("chatroomupdatedevent")) {
            return true
        }
        val root = runCatching { json.parseToJsonElement(messageJson) }.getOrNull() ?: return false
        return findInterestingKeyPaths(root, ROOM_STATE_KEYS).isNotEmpty()
    }

    fun parseKickWebPollResponse(raw: String): Poll? {
        val root = runCatching { json.parseToJsonElement(raw).jsonObject }.getOrNull() ?: return null
        val data = root.objOrNull("data") ?: root
        val pollObject = data.objOrNull("poll") ?: return null
        return parseKickPollObject(pollObject)
    }

    fun parseKickWebPredictionResponse(raw: String): Prediction? {
        val root = runCatching { json.parseToJsonElement(raw).jsonObject }.getOrNull() ?: return null
        val data = root.objOrNull("data") ?: root
        val predictionObject = data.objOrNull("prediction") ?: return null
        return parseKickPredictionObject(
            predictionObject = predictionObject,
            userVoteObject = data.objOrNull("user_vote") ?: root.objOrNull("user_vote"),
            normalizedEvent = null,
        )
    }

    private fun extractViewerCountFromRealtimeJson(messageJson: String): Int? {
        val root = runCatching { json.parseToJsonElement(messageJson) }.getOrNull() ?: return null
        val queue = ArrayDeque<JsonElement>()
        queue.add(root)
        var visits = 0
        while (queue.isNotEmpty() && visits++ < 8) {
            val element = queue.removeFirst() as? JsonObject ?: continue
            directViewerCount(element)?.let { return it }
            element["livestream"]?.let(queue::add)
            for (key in VIEWER_COUNT_JSON_KEYS) {
                val child = element[key] ?: continue
                val inner = (child as? JsonPrimitive)?.contentOrNull?.let { raw ->
                    runCatching { json.parseToJsonElement(raw) }.getOrNull()
                }
                if (inner != null) queue.add(inner) else if (child is JsonObject) queue.add(child)
            }
        }
        return null
    }

    private fun directViewerCount(obj: JsonObject?): Int? {
        if (obj == null) return null
        for (key in VIEWER_COUNT_NUMERIC_KEYS) {
            (obj[key] as? JsonPrimitive)?.let { primitive ->
                val parsed = primitive.intOrNull ?: primitive.contentOrNull?.toIntOrNull()
                if (parsed != null && parsed >= 0) return parsed
            }
        }
        return null
    }

    private fun parseKickPollObject(pollObject: JsonObject): Poll {
        val choices = pollObject.arrayOrNull("options").orEmpty().mapNotNull { element ->
            val option = element as? JsonObject ?: return@mapNotNull null
            val title = option.firstPrimitiveOrNull("label", "title")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
            Poll.PollChoice(
                id = option.firstLongOrNull("id", "option_id")?.toInt(),
                title = title,
                totalVotes = option.firstLongOrNull("votes", "total_votes", "vote_count")?.toInt(),
            )
        }
        val totalVotes = choices.sumOf { it.totalVotes ?: 0 }
        val remainingSeconds = pollObject.firstLongOrNull("remaining", "remaining_seconds")
        val status = when {
            !pollObject.primitiveOrNull("status").isNullOrBlank() -> pollObject.primitiveOrNull("status")
            remainingSeconds == null -> "ACTIVE"
            remainingSeconds <= 0L -> "COMPLETED"
            else -> "ACTIVE"
        }
        return Poll(
            id = pollObject.firstPrimitiveOrNull("poll_id", "id", "title"),
            title = pollObject.primitiveOrNull("title"),
            status = status,
            choices = choices,
            totalVotes = totalVotes,
            remainingMilliseconds = remainingSeconds?.times(1000)?.toInt(),
            durationMilliseconds = pollObject.firstLongOrNull("duration", "duration_seconds")?.times(1000)?.toInt(),
            resultDisplayMilliseconds = pollObject.firstLongOrNull("result_display_duration", "result_display_seconds")?.times(1000)?.toInt(),
            hasVoted = pollObject["has_voted"]?.let { (it as? JsonPrimitive)?.contentOrNull?.toBooleanStrictOrNull() ?: (it as? JsonPrimitive)?.intOrNull?.let { intValue -> intValue != 0 } },
            votedChoiceId = pollObject.firstLongOrNull("voted_option_id", "voted_choice_id")?.toInt(),
        )
    }

    private fun parseKickPredictionObject(
        predictionObject: JsonObject,
        userVoteObject: JsonObject? = null,
        normalizedEvent: String? = null,
    ): Prediction {
        val outcomes = predictionObject.arrayOrNull("outcomes").orEmpty().mapNotNull { element ->
            val outcome = element as? JsonObject ?: return@mapNotNull null
            val title = outcome.primitiveOrNull("title")?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
            Prediction.PredictionOutcome(
                id = outcome.primitiveOrNull("id"),
                title = title,
                totalPoints = outcome.firstLongOrNull("total_points", "total_vote_amount")?.toInt(),
                totalUsers = outcome.firstLongOrNull("total_users", "vote_count")?.toInt(),
                returnRate = (outcome["return_rate"] as? JsonPrimitive)?.contentOrNull?.toDoubleOrNull(),
                isWinner = outcome.firstBooleanOrNull("is_winner", "winner", "won", "isWinningOutcome")
                    ?: outcome.firstPrimitiveOrNull("status", "state", "result")?.equals("won", ignoreCase = true),
            )
        }
        val status = predictionObject.firstPrimitiveOrNull("status", "state") ?: when (normalizedEvent?.substringAfterLast('\\')) {
            "predictionlocked" -> "LOCKED"
            "predictionresolved", "predictionended" -> "RESOLVED"
            "predictioncancelled" -> "CANCELED"
            else -> null
        }
        val winningOutcomeId = predictionObject.firstPrimitiveOrNull("winning_outcome_id", "winningOutcomeId")
            ?: outcomes.firstOrNull { it.isWinner == true }?.id
        return Prediction(
            id = predictionObject.primitiveOrNull("id"),
            createdAt = predictionObject.primitiveOrNull("created_at")?.let(KickApiHelper::parseIso8601DateUTC),
            endedAt = predictionObject.firstPrimitiveOrNull("ended_at", "resolved_at", "closed_at", "updated_at")
                ?.let(KickApiHelper::parseIso8601DateUTC),
            outcomes = outcomes,
            predictionWindowSeconds = predictionObject.firstLongOrNull("prediction_window_seconds", "duration")?.toInt(),
            status = status,
            title = predictionObject.primitiveOrNull("title"),
            winningOutcomeId = winningOutcomeId,
            userVote = userVoteObject?.let {
                Prediction.UserVote(
                    outcomeId = it.primitiveOrNull("outcome_id")?.takeIf { outcomeId -> outcomeId.isNotBlank() },
                    totalVoteAmount = it.firstLongOrNull("total_vote_amount")?.toInt(),
                )
            },
        )
    }
}
