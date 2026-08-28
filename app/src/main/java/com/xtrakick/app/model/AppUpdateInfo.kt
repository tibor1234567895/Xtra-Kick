package com.xtrakick.app.model

data class AppUpdateInfo(
    val downloadUrl: String,
    val size: Long?,
    val updatedAt: Long,
    val releaseTitle: String? = null,
    val releaseNotes: String? = null
)
