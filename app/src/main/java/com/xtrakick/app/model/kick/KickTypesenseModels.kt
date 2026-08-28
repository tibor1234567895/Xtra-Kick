package com.xtrakick.app.model.kick

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KickMultiSearchRequest(
    val searches: List<KickTypesenseQuery>,
)

@Serializable
data class KickTypesenseQuery(
    val preset: String,
    val q: String,
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
)

@Serializable
data class KickMultiSearchResponse(
    val results: List<KickTypesenseResult> = emptyList(),
)

@Serializable
data class KickTypesenseResult(
    val found: Int? = null,
    val page: Int? = null,
    @SerialName("out_of")
    val outOf: Long? = null,
    @SerialName("search_time_ms")
    val searchTimeMs: Int? = null,
    val hits: List<KickTypesenseHit> = emptyList(),
)

@Serializable
data class KickTypesenseHit(
    val document: KickTypesenseDocument = KickTypesenseDocument(),
    @SerialName("text_match")
    val textMatch: Long? = null,
)

@Serializable
data class KickTypesenseDocument(
    val id: String? = null,
    val slug: String? = null,
    val username: String? = null,
    val name: String? = null,
    @SerialName("followers_count")
    val followersCount: Int? = null,
    @SerialName("is_live")
    val isLive: Boolean? = null,
    @SerialName("is_banned")
    val isBanned: Boolean? = null,
    val verified: Boolean? = null,
    @SerialName("category_id")
    val categoryId: Long? = null,
    val parent: String? = null,
    val description: String? = null,
    val src: String? = null,
    val srcset: String? = null,
    @SerialName("is_mature")
    val isMature: Boolean? = null,
    @SerialName("profile_image")
    val profileImage: String? = null,
    @SerialName("profilepic")
    val profilePic: String? = null,
)
