package com.github.andreyasadchy.xtra.model.chat

class Poll(
    val id: String?,
    val title: String?,
    val status: String?,
    val choices: List<PollChoice>?,
    val totalVotes: Int?,
    val remainingMilliseconds: Int?,
    val resultDisplayMilliseconds: Int? = null,
    val hasVoted: Boolean? = null,
    val votedChoiceId: Int? = null,
) {
    class PollChoice(
        val id: Int? = null,
        val title: String?,
        val totalVotes: Int?,
    )
}
