package com.github.andreyasadchy.xtra.model.helix.livestream

import kotlinx.serialization.Serializable

@Serializable
class LivestreamsResponse(
    val data: List<Livestream> = emptyList(),
    val message: String? = null,
)
