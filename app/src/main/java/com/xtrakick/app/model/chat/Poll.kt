package com.xtrakick.app.model.chat

class Poll(
    val id: String?,
    val title: String?,
    val status: String?,
    val choices: List<PollChoice>?,
    val totalVotes: Int?,
    val remainingMilliseconds: Int?,
    val durationMilliseconds: Int? = null,
    val resultDisplayMilliseconds: Int? = null,
    val hasVoted: Boolean? = null,
    val votedChoiceId: Int? = null,
) {
    fun isActive(): Boolean = status.equals("ACTIVE", ignoreCase = true)

    fun isEnded(): Boolean = status.equals("COMPLETED", ignoreCase = true) ||
        status.equals("TERMINATED", ignoreCase = true)

    class PollChoice(
        val id: Int? = null,
        val title: String?,
        val totalVotes: Int?,
    )
}
