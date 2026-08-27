package com.xtrakick.app.model.kick.api.livestream

import kotlinx.serialization.Serializable

@Serializable
class UsersLivestreamsResponse(
    val data: List<LivestreamV2> = emptyList(),
    val message: String? = null,
)
