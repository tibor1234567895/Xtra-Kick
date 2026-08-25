package com.xtrakick.app.model.kick.api

import kotlinx.serialization.Serializable

@Serializable
class Pagination(
    val cursor: String? = null,
)