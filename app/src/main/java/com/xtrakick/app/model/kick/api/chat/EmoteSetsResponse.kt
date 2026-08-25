package com.xtrakick.app.model.kick.api.chat

import kotlinx.serialization.Serializable

@Serializable
class EmoteSetsResponse(
    val template: String,
    val data: List<EmoteTemplate>,
)