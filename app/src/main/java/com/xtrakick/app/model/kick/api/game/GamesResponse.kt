package com.xtrakick.app.model.kick.api.game

import com.xtrakick.app.model.kick.api.Pagination
import kotlinx.serialization.Serializable

@Serializable
class GamesResponse(
    val data: List<Game>,
    val pagination: Pagination? = null,
)