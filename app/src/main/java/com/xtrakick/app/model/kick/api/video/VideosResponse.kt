package com.xtrakick.app.model.kick.api.video

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class VideosResponse(
    val data: List<Video>,
    val pagination: Pagination? = null,
)