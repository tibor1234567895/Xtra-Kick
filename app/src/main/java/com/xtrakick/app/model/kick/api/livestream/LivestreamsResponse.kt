package com.xtrakick.app.model.kick.api.livestream

import kotlinx.serialization.Serializable

@Serializable
class LivestreamsResponse(
    val data: List<Livestream> = emptyList(),
    val message: String? = null,
)
