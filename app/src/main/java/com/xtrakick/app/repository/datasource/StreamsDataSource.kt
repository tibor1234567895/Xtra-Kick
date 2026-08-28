package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import java.util.Locale

class StreamsDataSource(
    private val gqlSort: String?,
    private val tags: Array<String> = emptyArray(),
    private val languages: Array<String> = emptyArray(),
    private val kickRepository: KickRepository,
    private val apiPref: List<String>,
) : PagingSource<Int, Stream>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        return if (!offset.isNullOrBlank()) {
            try {
                loadFromApi(api, params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        } else {
            val apisToTry = listOf(AppConstants.KICK)
            var lastError: Exception? = null
            apisToTry.forEach { pref ->
                try {
                    return loadFromApi(pref, params)
                } catch (e: Exception) {
                    lastError = e
                }
            }
            LoadResult.Error(lastError ?: Exception("No enabled APIs"))
        }
    }

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Stream> {
        api = apiPref
        return when (apiPref) {
            AppConstants.KICK -> kickLoad(params)
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Stream> {
        val page = params.key ?: 1
        val response = kickRepository.getLivestreams(
            page = page,
            limit = params.loadSize,
            sort = if (gqlSort == "VIEWER_COUNT_ASC") "asc" else "desc",
        )
        val list = response.data
            .filter { matchesFilters(it) }
            .map { kickRepository.toStream(it) }
        if (page == 1) {
            kickRepository.prefetchChannelLivestreams(
                list.mapNotNull { it.channelLogin }.take(12)
            )
        }
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!response.nextPageUrl.isNullOrBlank()) {
                page + 1
            } else null
        )
    }

    /**
     * Kick's livestreams endpoint ignores language path segments and query params (verified
     * 2026-08-28: /en and /es return identical mixed-language payloads), so the saved
     * filter's tags/languages are applied client-side. Pages may come back smaller than
     * loadSize while a filter is active; Paging compensates by loading more pages.
     */
    private fun matchesFilters(item: KickLivestream): Boolean {
        if (languages.isNotEmpty()) {
            val streamLanguage = item.language?.trim()?.lowercase(Locale.ROOT)
            // Streams without a language tag are dropped while a language filter is active.
            if (streamLanguage.isNullOrEmpty()) return false
            val matched = languages.any { code -> matchesLanguage(code, streamLanguage) }
            if (!matched) return false
        }
        if (tags.isNotEmpty()) {
            val streamTags = item.tags.orEmpty().map { it.lowercase(Locale.ROOT) }
            val matched = tags.any { streamTags.contains(it.lowercase(Locale.ROOT)) }
            if (!matched) return false
        }
        return true
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {
        /**
         * Filter codes (values of R.array.gqlUserLanguageValues) to lowercase substrings of
         * the `language` display names Kick returns on its livestream payloads (e.g. the
         * code DE matches "German"). OTHER has no reliable display name and matches nothing.
         */
        private val LANGUAGE_NAMES: Map<String, Set<String>> = mapOf(
            "AR" to setOf("arabic"),
            "ASL" to setOf("american sign language", "sign language", "asl"),
            "BG" to setOf("bulgarian"),
            "CA" to setOf("catalan"),
            "CS" to setOf("czech"),
            "DA" to setOf("danish"),
            "DE" to setOf("german"),
            "EL" to setOf("greek"),
            "EN" to setOf("english"),
            "ES" to setOf("spanish", "español", "espanol"),
            "FI" to setOf("finnish"),
            "FR" to setOf("french", "français", "francais"),
            "HI" to setOf("hindi"),
            "HU" to setOf("hungarian"),
            "ID" to setOf("indonesian"),
            "IT" to setOf("italian"),
            "JA" to setOf("japanese"),
            "KO" to setOf("korean"),
            "MS" to setOf("malay"),
            "NL" to setOf("dutch", "flemish"),
            "NO" to setOf("norwegian"),
            "PL" to setOf("polish"),
            "PT" to setOf("portuguese"),
            "RO" to setOf("romanian"),
            "RU" to setOf("russian"),
            "SK" to setOf("slovak"),
            "SV" to setOf("swedish"),
            "TH" to setOf("thai"),
            "TL" to setOf("tagalog", "filipino"),
            "TR" to setOf("turkish"),
            "UK" to setOf("ukrainian"),
            "VI" to setOf("vietnamese"),
            "ZH" to setOf("chinese", "mandarin"),
            "ZH_HK" to setOf("chinese (hong kong)", "cantonese"),
            "OTHER" to emptySet(),
        )

        private fun matchesLanguage(code: String, lowercaseApiLanguage: String): Boolean {
            val names = LANGUAGE_NAMES[code.trim().uppercase(Locale.ROOT)] ?: return false
            if (names.isEmpty()) return false
            return names.any { lowercaseApiLanguage.contains(it) }
        }
    }
}
