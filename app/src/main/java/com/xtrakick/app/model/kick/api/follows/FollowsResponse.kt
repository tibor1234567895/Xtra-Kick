package com.xtrakick.app.model.kick.api.follows

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class FollowsResponse(
    val data: List<Follow>,
    val pagination: Pagination? = null,
)