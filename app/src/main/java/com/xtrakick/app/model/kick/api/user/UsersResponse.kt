package com.xtrakick.app.model.kick.api.user

import kotlinx.serialization.Serializable

@Serializable
class UsersResponse(
    val data: List<User>,
)