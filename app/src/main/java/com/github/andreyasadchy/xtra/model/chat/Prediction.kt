package com.github.andreyasadchy.xtra.model.chat

class Prediction(
    val id: String?,
    val createdAt: Long?,
    val endedAt: Long?,
    val outcomes: List<PredictionOutcome>?,
    val predictionWindowSeconds: Int?,
    val status: String?,
    val title: String?,
    val winningOutcomeId: String?,
    val userVote: UserVote? = null,
) {
    class PredictionOutcome(
        val id: String?,
        val title: String?,
        val totalPoints: Int?,
        val totalUsers: Int?,
        val returnRate: Double?,
        val isWinner: Boolean? = null,
    )

    class UserVote(
        val outcomeId: String?,
        val totalVoteAmount: Int?,
    )
}
