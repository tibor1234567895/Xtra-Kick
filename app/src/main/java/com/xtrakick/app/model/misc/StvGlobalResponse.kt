package com.xtrakick.app.model.misc

import kotlinx.serialization.Serializable

@Serializable
class StvGlobalResponse(
    val id: String? = null,
    val emotes: List<StvResponse>,
)