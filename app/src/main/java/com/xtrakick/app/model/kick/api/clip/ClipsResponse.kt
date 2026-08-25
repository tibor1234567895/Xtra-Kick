package com.xtrakick.app.model.kick.api.clip

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class ClipsResponse(
    val data: List<Clip>,
    val pagination: Pagination? = null,
)