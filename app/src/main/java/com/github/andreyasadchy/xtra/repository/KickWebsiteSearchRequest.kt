package com.github.andreyasadchy.xtra.repository

internal object KickWebsiteSearchRequest {
    private const val minQueryLength = 3
    private const val baseUrl = "https://kick.com/api/search"
    private const val queryParam = "searched_word"

    fun buildUrl(query: String): String {
        val normalizedQuery = query.trim()
        require(normalizedQuery.length >= minQueryLength) {
            "Kick website search requires at least $minQueryLength characters"
        }
        return "$baseUrl?$queryParam=${java.net.URLEncoder.encode(normalizedQuery, Charsets.UTF_8.name())}"
    }
}
