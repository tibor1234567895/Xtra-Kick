package com.xtrakick.app.model.chat

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
    fun isActive(): Boolean = status.equals("ACTIVE", ignoreCase = true) ||
        status.equals("OPEN", ignoreCase = true)

    fun isLocked(): Boolean = status.equals("LOCKED", ignoreCase = true)

    fun isResolved(): Boolean = status.equals("RESOLVED", ignoreCase = true) ||
        status.equals("RESOLVE_PENDING", ignoreCase = true)

    fun isCanceled(): Boolean = status.equals("CANCELED", ignoreCase = true) ||
        status.equals("CANCELLED", ignoreCase = true) ||
        status.equals("CANCEL_PENDING", ignoreCase = true)

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
