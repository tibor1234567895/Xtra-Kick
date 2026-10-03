package com.xtrakick.app.model.ui

/** A user muted on the logged-in Kick account (`/api/v2/silenced-users` entry). */
data class KickMutedUser(
    val id: String,
    val username: String?,
)
