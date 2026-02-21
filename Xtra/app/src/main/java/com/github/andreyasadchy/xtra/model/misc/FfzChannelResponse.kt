package com.github.andreyasadchy.xtra.model.misc

import kotlinx.serialization.Serializable

@Serializable
class FfzChannelResponse(
    val sets: Map<String, FfzResponse>,
)