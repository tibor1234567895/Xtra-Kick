package com.xtrakick.app.repository

import android.util.Log
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.model.kick.KickCollectible
import com.xtrakick.app.model.kick.KickDailyChallenge
import com.xtrakick.app.model.kick.KickDailyClaimResult
import com.xtrakick.app.model.kick.KickDropCampaign
import com.xtrakick.app.model.kick.KickDropCampaignFull
import com.xtrakick.app.model.kick.KickDropParticipatingChannel
import com.xtrakick.app.model.kick.KickRewardsParsing
import com.xtrakick.app.model.kick.KickUserLevel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
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
        getAndParse("$BASE_URL/gamification/challenges") {
            KickRewardsParsing.parseChallenges(it)
        }.also {
            _dailyChallengesFlow.value = it
        }

    suspend fun refreshDailyChallenges(): List<KickDailyChallenge>? {
        if (!canAttemptClaims()) return null
        return runCatching {
            getDailyChallenges()
        }.getOrNull()
    }

    fun updateChallengesFromRaw(rawJson: String) {
        runCatching {
            val root = json.parseToJsonElement(rawJson)
            val challenges = KickRewardsParsing.parseChallenges(root)
            _dailyChallengesFlow.value = challenges
        }
    }

    suspend fun claimDailyChallenge(challengeId: String): KickDailyClaimResult =
        postAndParse("$BASE_URL/gamification/challenges/${urlEncode(challengeId)}/claim", body = null) {
            KickRewardsParsing.parseDailyClaim(it)
        }.also {
            kickRepository.clearKickEmoteGroupsCache()
        }

    suspend fun getDailyStreak(userId: String): Long? =
        getAndParse("$BASE_URL/gamification/users/${urlEncode(userId)}/streak") {
            KickRewardsParsing.parseStreakLengthDays(it)
        }

    suspend fun getDropCampaigns(): List<KickDropCampaign> =
        getAndParse("$BASE_URL/drops/progress") { KickRewardsParsing.parseDropCampaigns(it) }

    suspend fun getAllDropCampaigns(): List<KickDropCampaignFull> {
        val userProgress = if (canAttemptClaims()) {
            runCatching { getDropCampaigns() }.getOrDefault(emptyList())
        } else {
            emptyList()
        }
        // /drops/campaigns is public in the official app — no session required.
        return getAndParse("$BASE_URL/drops/campaigns", requireAuth = false) { root ->
            KickRewardsParsing.parseAllDropCampaigns(root, userProgress)
        }
    }

    suspend fun getCampaignLivestreams(campaignId: String): List<KickDropParticipatingChannel> =
        runCatching {
            // Livestreams of a campaign are public; failures degrade to the static channel list.
            getAndParse(
                "$BASE_URL/drops/campaigns/${urlEncode(campaignId)}/livestreams",
                requireAuth = false,
            ) { root ->
                KickRewardsParsing.parseCampaignLivestreams(root)
            }
        }.getOrDefault(emptyList())

    suspend fun getCollectibles(): List<KickCollectible> =
        getAndParse("$BASE_URL/gamification/collectibles") {
            KickRewardsParsing.parseCollectibles(it)
        }

    suspend fun getUserLevel(): KickUserLevel? =
        getAndParse("$BASE_URL/gamification/user/level") {
            KickRewardsParsing.parseUserLevel(it)
        }

    suspend fun claimDropReward(rewardId: String, campaignId: String) {
        val body = buildJsonObject {
            put("reward_id", JsonPrimitive(rewardId))
            put("campaign_id", JsonPrimitive(campaignId))
        }.toString()
        post("$BASE_URL/drops/claim", body = body)
        kickRepository.clearKickEmoteGroupsCache()
    }

    private suspend fun <T> getAndParse(url: String, requireAuth: Boolean = true, transform: (JsonElement) -> T): T =
        requestAndParse(url, body = null, post = false, requireAuth = requireAuth, transform = transform)

    private suspend fun post(url: String, body: String?): String = withContext(Dispatchers.IO) {
        kickRepository.executeKickWebSessionRequest(url, body, post = true)
    }

    private suspend fun <T> postAndParse(url: String, body: String?, transform: (JsonElement) -> T): T =
        requestAndParse(url, body, post = true, requireAuth = true, transform = transform)

    private suspend fun <T> requestAndParse(
        url: String,
        body: String?,
        post: Boolean,
        requireAuth: Boolean,
        transform: (JsonElement) -> T,
    ): T = withContext(Dispatchers.IO) {
        val raw = kickRepository.executeKickWebSessionRequest(url, body, post, requireAuth = requireAuth)
        if (raw.isBlank()) {
            throw IOException("Kick rewards request returned an empty response for $url")
        }
        val root = json.parseToJsonElement(raw)
        logRawJson(url.substringBefore('?').substringAfterLast('/'), root)
        transform(root)
    }

    private fun urlEncode(value: String): String =
        URLEncoder.encode(value, "UTF-8").replace("+", "%20")

    /**
     * Debug-only capture of the raw gamification payloads (challenges, drops, collectibles,
     * user level, livestreams) so live schema shapes can be verified against the parsers —
     * event crates like Trick or Treat carry shapes the parser can't reveal.
     */
    private fun logRawJson(label: String, root: JsonElement) {
        if (!BuildConfig.DEBUG) return
        val raw = root.toString()
        val chunkSize = 3_500
        var start = 0
        var part = 0
        while (start < raw.length) {
            val end = (start + chunkSize).coerceAtMost(raw.length)
            Log.d("KickRewardsRaw", "$label part=${part++}: ${raw.substring(start, end)}")
            start = end
        }
    }
}
