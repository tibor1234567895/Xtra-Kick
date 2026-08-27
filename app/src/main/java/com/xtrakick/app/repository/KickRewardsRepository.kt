package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDropCampaign
import com.xtrakick.app.model.kick.KickRewardsParsing
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import java.io.IOException
import java.net.URLEncoder
import javax.inject.Inject
import javax.inject.Singleton

/** Client for Kick's private web gamification API (daily reward roulette + drop campaigns). */
@Singleton
class KickRewardsRepository @Inject constructor(
    private val kickRepository: KickRepository,
    private val json: Json,
) {
    companion object {
        private const val BASE_URL = "https://web.kick.com/api/v1"
    }

    fun canAttemptClaims(): Boolean = kickRepository.hasUsableKickWebsiteSession()

    suspend fun getDailyChallenges(): List<KickDailyChallenge> =
        getAndParse("$BASE_URL/gamification/challenges") { KickRewardsParsing.parseChallenges(it) }

    suspend fun claimDailyChallenge(challengeId: String) {
        post("$BASE_URL/gamification/challenges/${urlEncode(challengeId)}/claim", body = null)
    }

    suspend fun getDropCampaigns(): List<KickDropCampaign> =
        getAndParse("$BASE_URL/drops/progress") { KickRewardsParsing.parseDropCampaigns(it) }

    suspend fun claimDropReward(rewardId: String, campaignId: String) {
        val body = buildJsonObject {
            put("reward_id", JsonPrimitive(rewardId))
            put("campaign_id", JsonPrimitive(campaignId))
        }.toString()
        post("$BASE_URL/drops/claim", body = body)
    }

    private suspend fun <T> getAndParse(url: String, transform: (JsonElement) -> T): T {
        val raw = kickRepository.executeKickWebSessionRequest(url)
        if (raw.isBlank()) {
            throw IOException("Kick rewards request returned an empty response for $url")
        }
        return transform(json.parseToJsonElement(raw))
    }

    private suspend fun post(url: String, body: String?): String =
        kickRepository.executeKickWebSessionRequest(url, body, post = true)

    private fun urlEncode(value: String): String =
        URLEncoder.encode(value, "UTF-8").replace("+", "%20")
}
