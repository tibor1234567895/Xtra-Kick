package com.xtrakick.app.model.kick.api.stream

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class StreamsResponse(
    val data: List<Stream>,
    val pagination: Pagination? = null,
)