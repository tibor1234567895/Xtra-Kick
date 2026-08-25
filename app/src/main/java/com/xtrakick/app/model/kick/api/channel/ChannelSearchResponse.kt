package com.xtrakick.app.model.kick.api.channel

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class ChannelSearchResponse(
    val data: List<ChannelSearch>,
    val pagination: Pagination? = null,
)