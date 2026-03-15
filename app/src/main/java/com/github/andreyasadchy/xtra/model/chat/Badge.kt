package com.github.andreyasadchy.xtra.model.chat

data class Badge(
    val setId: String,
    val version: String,
    val title: String? = null,
    val url1x: String? = null,
    val url2x: String? = null,
    val url3x: String? = null,
    val url4x: String? = null,
)
