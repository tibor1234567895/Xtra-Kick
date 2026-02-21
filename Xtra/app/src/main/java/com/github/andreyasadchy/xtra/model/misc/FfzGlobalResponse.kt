package com.github.andreyasadchy.xtra.model.misc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class FfzGlobalResponse(
    @SerialName("default_sets")
    val globalSets: List<Int>,
    val sets: Map<String, FfzResponse>,
)