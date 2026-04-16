package com.github.andreyasadchy.xtra.util.chat

import com.github.andreyasadchy.xtra.model.chat.ChannelPointReward
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Poll
import com.github.andreyasadchy.xtra.model.chat.Prediction
import com.github.andreyasadchy.xtra.model.chat.Raid
import com.github.andreyasadchy.xtra.util.KickApiHelper
import org.json.JSONObject

object PubSubUtils {
    private fun firstObject(root: JSONObject?, vararg keys: String): JSONObject? {
        if (root == null) return null
        keys.forEach { key ->
            root.optJSONObject(key)?.let { return it }
        }
        return null
    }

    private fun firstString(root: JSONObject?, vararg keys: String): String? {
        if (root == null) return null
        keys.forEach { key ->
            if (!root.isNull(key)) {
                root.optString(key).takeIf { it.isNotBlank() }?.let { return it }
            }
        }
        return null
    }

    private fun firstInt(root: JSONObject?, vararg keys: String): Int? {
        if (root == null) return null
        keys.forEach { key ->
            if (!root.isNull(key)) {
                return root.optInt(key)
            }
        }
        return null
    }

    fun parsePlaybackMessage(message: JSONObject): PlaybackMessage? {
        val messageType = message.optString("type")
        return when {
            messageType.startsWith("viewcount") -> PlaybackMessage(viewers = if (!message.isNull("viewers")) message.optInt("viewers") else null)
            messageType.startsWith("stream-up") -> PlaybackMessage(true, if (!message.isNull("server_time")) message.optLong("server_time").takeIf { it > 0 } else null)
            messageType.startsWith("stream-down") -> PlaybackMessage(false)
            else -> null
        }
    }

    fun parseStreamInfo(message: JSONObject): StreamInfo {
        return StreamInfo(
            title = if (!message.isNull("status")) message.optString("status").takeIf { it.isNotBlank() } else null,
            gameId = if (!message.isNull("game_id")) message.optInt("game_id").takeIf { it > 0 }?.toString() else null,
            gameName = if (!message.isNull("game")) message.optString("game").takeIf { it.isNotBlank() } else null,
        )
    }

    fun parseRewardMessage(message: JSONObject): ChatMessage {
        val messageData = message.optJSONObject("data")
        val redemption = firstObject(messageData, "redemption", "reward_redemption")
            ?: firstObject(message, "redemption", "reward_redemption")
        val user = firstObject(redemption, "user", "redeemer")
            ?: firstObject(messageData, "user", "redeemer")
            ?: firstObject(message, "user", "redeemer")
        val reward = firstObject(redemption, "reward")
            ?: firstObject(messageData, "reward")
            ?: firstObject(message, "reward")
        val rewardImage = firstObject(reward, "image", "reward_image")
        val defaultImage = firstObject(reward, "default_image", "defaultImage")
        val input = firstString(redemption, "user_input", "input", "message")
            ?: firstString(messageData, "user_input", "input", "message")
        return ChatMessage(
            userId = firstString(user, "id", "user_id"),
            userLogin = firstString(user, "login", "slug", "channel_slug", "username"),
            userName = firstString(user, "display_name", "username", "name"),
            message = input,
            reward = ChannelPointReward(
                id = firstString(reward, "id", "reward_id"),
                title = firstString(reward, "title", "name"),
                cost = firstInt(reward, "cost", "points_cost"),
                url1x = firstString(rewardImage, "url_1x", "url", "src")
                    ?: firstString(defaultImage, "url_1x", "url", "src"),
                url2x = firstString(rewardImage, "url_2x")
                    ?: firstString(defaultImage, "url_2x")
                    ?: firstString(rewardImage, "url_1x", "url", "src")
                    ?: firstString(defaultImage, "url_1x", "url", "src"),
                url4x = firstString(rewardImage, "url_4x")
                    ?: firstString(defaultImage, "url_4x")
                    ?: firstString(rewardImage, "url_2x", "url_1x", "url", "src")
                    ?: firstString(defaultImage, "url_2x", "url_1x", "url", "src"),
                backgroundColor = firstString(reward, "background_color", "color"),
                isEnabled = reward?.takeIf { !it.isNull("is_enabled") }?.optBoolean("is_enabled")
                    ?: reward?.takeIf { !it.isNull("enabled") }?.optBoolean("enabled"),
                isUserInputRequired = reward?.takeIf { !it.isNull("is_user_input_required") }?.optBoolean("is_user_input_required")
                    ?: reward?.takeIf { !it.isNull("requires_user_input") }?.optBoolean("requires_user_input"),
                prompt = firstString(reward, "prompt", "description"),
            ),
            timestamp = firstString(messageData, "timestamp", "created_at")?.let { KickApiHelper.parseIso8601DateUTC(it) }
                ?: firstString(redemption, "redeemed_at", "created_at")?.let { KickApiHelper.parseIso8601DateUTC(it) },
            fullMsg = message.toString(),
        )
    }

    fun parsePointsEarned(message: JSONObject): Pair<PointsEarned, String?> {
        val messageData = message.optJSONObject("data")
        val messageChannelId = messageData?.optString("channel_id")
        val pointGain = messageData?.optJSONObject("point_gain")
        return Pair(
            PointsEarned(
                pointsGained = pointGain?.optInt("total_points"),
                timestamp = if (messageData?.isNull("timestamp") == false) messageData.optString("timestamp").takeIf { it.isNotBlank() }?.let { KickApiHelper.parseIso8601DateUTC(it) } else null,
                fullMsg = message.toString()
            ),
            messageChannelId
        )
    }

    fun onRaidUpdate(message: JSONObject, openStream: Boolean): Raid? {
        val raid = message.optJSONObject("raid")
        return if (raid != null) {
            Raid(
                raidId = if (!raid.isNull("id")) raid.optString("id").takeIf { it.isNotBlank() } else null,
                targetId = if (!raid.isNull("target_id")) raid.optString("target_id").takeIf { it.isNotBlank() } else null,
                targetLogin = if (!raid.isNull("target_login")) raid.optString("target_login").takeIf { it.isNotBlank() } else null,
                targetName = if (!raid.isNull("target_display_name")) raid.optString("target_display_name").takeIf { it.isNotBlank() } else null,
                targetProfileImage = if (!raid.isNull("target_profile_image")) raid.optString("target_profile_image").takeIf { it.isNotBlank() }?.replace("profile_image-%s", "profile_image-300x300") else null,
                viewerCount = raid.optInt("viewer_count"),
                openStream = openStream
            )
        } else null
    }

    fun onPollUpdate(message: JSONObject): Poll? {
        val messageData = message.optJSONObject("data")
        val poll = messageData?.optJSONObject("poll")
        val choicesList = mutableListOf<Poll.PollChoice>()
        val choices = poll?.optJSONArray("choices")
        if (choices != null) {
            for (i in 0 until choices.length()) {
                val choice = choices.get(i) as? JSONObject
                val title = if (choice?.isNull("title") == false) choice.optString("title").takeIf { it.isNotBlank() } else null
                if (!title.isNullOrBlank()) {
                    choicesList.add(
                        Poll.PollChoice(
                            title = title,
                            totalVotes = choice?.optJSONObject("votes")?.let { votes -> if (!votes.isNull("total")) votes.optInt("total") else null },
                        )
                    )
                }
            }
        }
        return if (poll != null) {
            Poll(
                id = if (!poll.isNull("poll_id")) poll.optString("poll_id").takeIf { it.isNotBlank() } else null,
                title = if (!poll.isNull("title")) poll.optString("title").takeIf { it.isNotBlank() } else null,
                status = if (!poll.isNull("status")) poll.optString("status").takeIf { it.isNotBlank() } else null,
                choices = choicesList,
                totalVotes = poll.optJSONObject("votes")?.let { votes -> if (!votes.isNull("total")) votes.optInt("total") else null },
                remainingMilliseconds = if (!poll.isNull("remaining_duration_milliseconds")) poll.optInt("remaining_duration_milliseconds") else null,
            )
        } else null
    }

    fun onPredictionUpdate(message: JSONObject): Prediction? {
        val messageData = message.optJSONObject("data")
        val prediction = messageData?.optJSONObject("event")
        val outcomesList = mutableListOf<Prediction.PredictionOutcome>()
        val outcomes = prediction?.optJSONArray("outcomes")
        if (outcomes != null) {
            for (i in 0 until outcomes.length()) {
                val outcome = outcomes.get(i) as? JSONObject
                val title = if (outcome?.isNull("title") == false) outcome.optString("title").takeIf { it.isNotBlank() } else null
                if (!title.isNullOrBlank()) {
                    outcomesList.add(
                        Prediction.PredictionOutcome(
                            id = if (outcome?.isNull("id") == false) outcome.optString("id").takeIf { it.isNotBlank() } else null,
                            title = title,
                            totalPoints = if (outcome?.isNull("total_points") == false) outcome.optInt("total_points") else null,
                            totalUsers = if (outcome?.isNull("total_users") == false) outcome.optInt("total_users") else null,
                        )
                    )
                }
            }
        }
        return if (prediction != null) {
            Prediction(
                id = if (!prediction.isNull("id")) prediction.optString("id").takeIf { it.isNotBlank() } else null,
                createdAt = if (!prediction.isNull("created_at")) prediction.optString("created_at").takeIf { it.isNotBlank() }?.let { KickApiHelper.parseIso8601DateUTC(it) } else null,
                outcomes = outcomesList,
                predictionWindowSeconds = if (!prediction.isNull("prediction_window_seconds")) prediction.optInt("prediction_window_seconds") else null,
                status = if (!prediction.isNull("status")) prediction.optString("status").takeIf { it.isNotBlank() } else null,
                title = if (!prediction.isNull("title")) prediction.optString("title").takeIf { it.isNotBlank() } else null,
                winningOutcomeId = if (!prediction.isNull("winning_outcome_id")) prediction.optString("winning_outcome_id").takeIf { it.isNotBlank() } else null,
            )
        } else null
    }

    class PlaybackMessage(
        val live: Boolean? = null,
        val serverTime: Long? = null,
        val viewers: Int? = null,
    )

    class StreamInfo(
        val title: String? = null,
        val gameId: String? = null,
        val gameName: String? = null,
    )

    class PointsEarned(
        val pointsGained: Int? = null,
        val timestamp: Long? = null,
        val fullMsg: String? = null,
    )
}
