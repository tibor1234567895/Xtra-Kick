package com.xtrakick.app.repository

import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDailyClaimResult
import com.xtrakick.app.model.kick.KickDropCampaign
import com.xtrakick.app.model.kick.KickRewardsParsing
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
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
        const val REWARDS_POLL_INTERVAL_MS = 120_000L
    }

    private val _dailyChallengesFlow = MutableStateFlow<List<KickDailyChallenge>?>(null)
    val dailyChallengesFlow: StateFlow<List<KickDailyChallenge>?> = _dailyChallengesFlow

    fun canAttemptClaims(): Boolean = kickRepository.hasUsableKickWebsiteSession()

    suspend fun getDailyChallenges(): List<KickDailyChallenge> =
        getAndParse("$BASE_URL/gamification/challenges") { KickRewardsParsing.parseChallenges(it) }.also {
            _dailyChallengesFlow.value = it
        }

    suspend fun refreshDailyChallenges(): List<KickDailyChallenge>? {
        if (!canAttemptClaims()) return null
        return runCatching {
            getDailyChallenges()
        }.getOrNull()
    }

    fun pollDailyChallenges(intervalMs: Long = REWARDS_POLL_INTERVAL_MS): Flow<List<KickDailyChallenge>> = flow {
        while (currentCoroutineContext().isActive) {
            if (canAttemptClaims()) {
                val challenges = runCatching { getDailyChallenges() }.getOrNull()
                if (challenges != null) {
                    emit(challenges)
                }
            }
            delay(intervalMs)
        }
    }

    suspend fun claimDailyChallenge(challengeId: String): KickDailyClaimResult =
        postAndParse("$BASE_URL/gamification/challenges/${urlEncode(challengeId)}/claim", body = null) {
            KickRewardsParsing.parseDailyClaim(it)
        }

    suspend fun getDailyStreak(userId: String): Long? =
        getAndParse("$BASE_URL/gamification/users/${urlEncode(userId)}/streak") {
            KickRewardsParsing.parseStreakLengthDays(it)
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

    private suspend fun <T> getAndParse(url: String, transform: (JsonElement) -> T): T =
        requestAndParse(url, body = null, post = false, transform = transform)

    private suspend fun post(url: String, body: String?): String =
        kickRepository.executeKickWebSessionRequest(url, body, post = true)

    private suspend fun <T> postAndParse(url: String, body: String?, transform: (JsonElement) -> T): T =
        requestAndParse(url, body, post = true, transform = transform)

    private suspend fun <T> requestAndParse(
        url: String,
        body: String?,
        post: Boolean,
        transform: (JsonElement) -> T,
    ): T {
        val raw = kickRepository.executeKickWebSessionRequest(url, body, post)
        if (raw.isBlank()) {
            throw IOException("Kick rewards request returned an empty response for $url")
        }
        return transform(json.parseToJsonElement(raw))
    }

    private fun urlEncode(value: String): String =
        URLEncoder.encode(value, "UTF-8").replace("+", "%20")
}
