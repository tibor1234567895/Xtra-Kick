package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.KickLivestream
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import java.util.Collections
import java.util.Locale
import kotlinx.coroutines.CancellationException

class StreamsDataSource(
    private val gqlSort: String?,
    private val tags: Array<String> = emptyArray(),
    private val languages: Array<String> = emptyArray(),
    private val kickRepository: KickRepository,
    private val apiPref: List<String>,
) : PagingSource<Int, Stream>() {
    private var api: String? = null
    private var offset: String? = null
    private val seenStreamKeys = Collections.synchronizedSet(mutableSetOf<String>())
    private val languageCursors = mutableMapOf<Int, String>()
    private var languageEndpointActive = false
    private val activeLanguages = supportedFilterSelections(languages.toList())

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Stream> {
        return if (!offset.isNullOrBlank()) {
            try {
                loadFromApi(api, params)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                LoadResult.Error(e)
            }
        } else {
            val apisToTry = listOf(AppConstants.KICK)
            var lastError: Exception? = null
            apisToTry.forEach { pref ->
                try {
                    return loadFromApi(pref, params)
                } catch (e: Exception) {
                    if (e is CancellationException) throw e
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
        kickRepository.getEventFilterStreams(tags.toList())?.let { streams ->
            return LoadResult.Page(data = filterEventStreams(streams, activeLanguages, gqlSort), prevKey = null, nextKey = null)
        }
        val languageCodes = requestedLanguageCodes(activeLanguages, tags.toList())
        val page = params.key ?: 1
        val canUseLanguageCursor = page == 1 || languageEndpointActive
        if (canUseLanguageCursor && usesLanguageEndpoint(languageCodes, gqlSort)) {
            val cursor = if (page == 1) null else languageCursors[page] ?: error("Missing language page cursor")
            kickRepository.getLanguageFilteredLivestreams(null, languageCodes, cursor, params.loadSize,
                awaitEventMetadata = kickRepository.hasCachedEventFilter(tags.toList()))?.let { response ->
                languageEndpointActive = true
                val streams = response.livestreams
                    .filter { matchesFilters(it.toLegacyLivestream()) }
                    .map { kickRepository.toStream(it) }
                    .filter { seenStreamKeys.add(it.channelId ?: it.channelLogin ?: it.id.orEmpty()) }
                val next = response.pagination.nextCursor?.takeIf { it.isNotBlank() && it != cursor }
                    ?.let { languageCursors[page + 1] = it; page + 1 }
                return LoadResult.Page(data = streams, prevKey = null, nextKey = next)
            }
        }
        val targetSize = params.loadSize
        val hasFilters = activeLanguages.isNotEmpty() || tags.isNotEmpty()
        val minTargetSize = if (hasFilters) minOf(targetSize, 8) else targetSize
        val maxPagesToScan = if (hasFilters) 8 else 1
        var currentPage = params.key ?: 1
        var nextPageKey: Int? = currentPage
        val collectedStreams = mutableListOf<Stream>()
        var scannedPages = 0

        while (scannedPages < maxPagesToScan && nextPageKey != null) {
            val response = kickRepository.getLivestreams(
                page = currentPage,
                limit = targetSize,
                sort = if (gqlSort == "VIEWER_COUNT_ASC") "asc" else "desc",
                awaitEventMetadata = kickRepository.hasCachedEventFilter(tags.toList()),
            )
            val matched = response.data
                .filter { matchesFilters(it) }
                .map { kickRepository.toStream(it) }
                .filter { stream ->
                    val key = stream.channelId ?: stream.channelLogin?.lowercase(Locale.ROOT) ?: stream.id.orEmpty()
                    key.isEmpty() || seenStreamKeys.add(key)
                }
            collectedStreams.addAll(matched)
            scannedPages++

            if (!response.nextPageUrl.isNullOrBlank()) {
                currentPage++
                nextPageKey = currentPage
            } else {
                nextPageKey = null
            }

            if (!hasFilters || collectedStreams.size >= minTargetSize) {
                break
            }
        }

        return LoadResult.Page(
            data = collectedStreams,
            prevKey = null,
            nextKey = nextPageKey
        )
    }

    /**
     * Kick's livestreams endpoint ignores language path segments and query params (verified
     * 2026-08-28: /en and /es return identical mixed-language payloads), so the saved
     * filter's tags/languages are applied client-side. Pages may come back smaller than
     * loadSize while a filter is active; Paging compensates by loading more pages.
     */
    private fun matchesFilters(item: KickLivestream): Boolean =
        matchesFilters(item, activeLanguages, tags.toList(),
            kickRepository.getCachedChannelEventTitle((item.channel?.id ?: item.channelId)?.toString()))

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        if (languageEndpointActive) return null
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {
        internal fun supportedFilterSelections(languages: Collection<String>?): List<String> =
            languages.orEmpty().map { it.trim().uppercase(Locale.ROOT).replace('-', '_') }
                .filter { it.isNotEmpty() && it != "OTHER" }.distinct()

        internal fun usesLanguageEndpoint(codes: Collection<String>, sort: String?): Boolean =
            codes.isNotEmpty() && sort != "VIEWER_COUNT_ASC" && sort != "RECENT"

        internal fun requestedLanguageCodes(languages: Collection<String>?, tags: Collection<String>?): List<String> {
            if (!languages.isNullOrEmpty()) return languages.toList()
            return tags.orEmpty().map { tag ->
                val value = tag.trim().lowercase(Locale.ROOT)
                LANGUAGE_NAMES.entries.find { (code, names) -> code.equals(value, true) || value in names }?.key
                    ?: return emptyList()
            }
        }

        internal fun filterEventStreams(streams: List<Stream>, languages: Collection<String>?, sort: String?): List<Stream> {
            val matched = streams.filter { stream ->
                languages.isNullOrEmpty() || languages.any { code ->
                    stream.tags.orEmpty().drop(1).any { matchesLanguage(code, it.lowercase(Locale.ROOT)) }
                }
            }
            return if (sort == "VIEWER_COUNT_ASC") matched.sortedBy { it.viewerCount ?: Int.MAX_VALUE }
            else matched.sortedByDescending { it.viewerCount ?: -1 }
        }

        internal fun isLanguageQuery(query: String): Boolean {
            val value = query.trim().lowercase(Locale.ROOT)
            return LANGUAGE_NAMES.any { (code, names) ->
                names.isNotEmpty() && (code.lowercase(Locale.ROOT) == value || value in names)
            }
        }

        internal fun matchesSearchTag(item: KickLivestream, query: String): Boolean {
            val value = query.trim().lowercase(Locale.ROOT)
            if (value.isBlank()) return false
            if (isLanguageQuery(value)) {
                val codes = LANGUAGE_NAMES.filter { (code, names) ->
                    code.lowercase(Locale.ROOT) == value || value in names
                }.keys
                val language = item.language?.trim()?.lowercase(Locale.ROOT) ?: return false
                return codes.any { code -> language == code.lowercase(Locale.ROOT) || matchesLanguage(code, language) }
            }
            return item.tags.orEmpty().any { it.trim().equals(value, ignoreCase = true) } ||
                (item.isMature == true && value in setOf("18+", "mature"))
        }

        internal fun matchesFilters(
            item: KickLivestream,
            languages: Collection<String>?,
            tags: Collection<String>?,
            eventTitle: String? = null,
        ): Boolean {
            if (!languages.isNullOrEmpty()) {
                val streamLanguage = item.language?.trim()?.lowercase(Locale.ROOT)
                // Streams without a language tag are dropped while a language filter is active.
                if (streamLanguage.isNullOrEmpty()) return false
                val matched = languages.any { code -> matchesLanguage(code, streamLanguage) }
                if (!matched) return false
            }
            if (!tags.isNullOrEmpty()) {
                val streamTags = buildList {
                    eventTitle?.takeIf { it.isNotBlank() }?.let { add(it.lowercase(Locale.ROOT)) }
                    item.tags?.forEach { add(it.trim().lowercase(Locale.ROOT)) }
                    item.categories?.forEach { cat ->
                        cat.tags?.forEach { add(it.trim().lowercase(Locale.ROOT)) }
                        cat.name?.trim()?.lowercase(Locale.ROOT)?.let(::add)
                        cat.slug?.trim()?.lowercase(Locale.ROOT)?.let(::add)
                    }
                    item.language?.trim()?.lowercase(Locale.ROOT)?.let(::add)
                    if (item.isMature == true) {
                        add("18+")
                        add("mature")
                    }
                }
                val title = item.title?.trim()?.lowercase(Locale.ROOT)
                val matched = tags.any { reqTag ->
                    val query = reqTag.trim().lowercase(Locale.ROOT)
                    if (query.isEmpty()) return@any true
                    val queryClean = query.replace(" ", "").replace("_", "").replace("-", "")

                    val matchTag = streamTags.any { tag ->
                        tag == query ||
                        tag.contains(query) ||
                        query.contains(tag) ||
                        (queryClean.isNotEmpty() && tag.replace(" ", "").replace("_", "").replace("-", "").contains(queryClean))
                    }
                    if (matchTag) return@any true

                    if (title != null) {
                        if (title.contains(query)) return@any true
                        if (queryClean.isNotEmpty() && title.replace(" ", "").replace("_", "").replace("-", "").contains(queryClean)) return@any true
                    }
                    false
                }
                if (!matched) return false
            }
            return true
        }
        /**
         * Filter codes (values of R.array.gqlUserLanguageValues) to lowercase substrings of
         * the `language` display names Kick returns on its livestream payloads (e.g. the
         * code DE matches "German").
         */
        private val LANGUAGE_NAMES: Map<String, Set<String>> = mapOf(
            "AF" to setOf("afrikaans"),
            "AM" to setOf("amharic"),
            "AN" to setOf("aragonese"),
            "AR" to setOf("arabic"),
            "ASL" to setOf("american sign language", "sign language", "asl"),
            "AST" to setOf("asturian"),
            "AZ" to setOf("azerbaijani"),
            "BE" to setOf("belarusian"),
            "BG" to setOf("bulgarian"),
            "BN" to setOf("bengali", "bangla"),
            "BS" to setOf("bosnian"),
            "CA" to setOf("catalan"),
            "CS" to setOf("czech"),
            "DA" to setOf("danish"),
            "DE" to setOf("german"),
            "EL" to setOf("greek"),
            "EN" to setOf("english"),
            "EN_IN" to setOf("english (india)", "indian english"),
            "EO" to setOf("esperanto"),
            "ES" to setOf("spanish", "español", "espanol"),
            "ET" to setOf("estonian"),
            "EU" to setOf("basque"),
            "FA" to setOf("persian", "farsi"),
            "FI" to setOf("finnish"),
            "FIL" to setOf("filipino", "tagalog"),
            "FR" to setOf("french", "français", "francais"),
            "HE" to setOf("hebrew"),
            "HI" to setOf("hindi"),
            "HR" to setOf("croatian"),
            "HU" to setOf("hungarian"),
            "HY" to setOf("armenian"),
            "ID" to setOf("indonesian"),
            "IT" to setOf("italian"),
            "JA" to setOf("japanese"),
            "KN" to setOf("kannada"),
            "KO" to setOf("korean"),
            "LA" to setOf("latin"),
            "LT" to setOf("lithuanian"),
            "LV" to setOf("latvian"),
            "MK" to setOf("macedonian"),
            "ML" to setOf("malayalam"),
            "MN" to setOf("mongolian"),
            "MO" to setOf("moldavian", "moldovan", "romanian"),
            "MS" to setOf("malay"),
            "NB" to setOf("norwegian bokmål", "norwegian bokmal", "bokmål", "bokmal", "norwegian"),
            "NE" to setOf("nepali"),
            "NL" to setOf("dutch", "flemish"),
            "NO" to setOf("norwegian"),
            "PA" to setOf("punjabi"),
            "PL" to setOf("polish"),
            "PT" to setOf("portuguese"),
            "QU" to setOf("quechua"),
            "RO" to setOf("romanian"),
            "RU" to setOf("russian"),
            "SI" to setOf("sinhala", "sinhalese"),
            "SK" to setOf("slovak"),
            "SL" to setOf("slovenian", "slovene"),
            "SN" to setOf("shona"),
            "SO" to setOf("somali"),
            "SQ" to setOf("albanian"),
            "SR" to setOf("serbian"),
            "SV" to setOf("swedish"),
            "TA" to setOf("tamil"),
            "TE" to setOf("telugu"),
            "TH" to setOf("thai"),
            "TL" to setOf("tagalog", "filipino"),
            "TR" to setOf("turkish"),
            "TW" to setOf("twi", "akan"),
            "UK" to setOf("ukrainian"),
            "UR" to setOf("urdu"),
            "UZ" to setOf("uzbek"),
            "VI" to setOf("vietnamese"),
            "XH" to setOf("xhosa"),
            "ZH" to setOf("chinese", "mandarin"),
            "ZH_HK" to setOf("chinese (hong kong)", "cantonese"),
            "ZU" to setOf("zulu"),
        )

        private fun matchesLanguage(code: String, lowercaseApiLanguage: String): Boolean {
            val upper = code.trim().uppercase(Locale.ROOT)
            if (upper == "OTHER") return false
            val tag = upper.replace('_', '-').lowercase(Locale.ROOT)
            if (lowercaseApiLanguage == tag) return true
            val names = LANGUAGE_NAMES[upper]
            if (names != null) {
                return names.isNotEmpty() && names.any { lowercaseApiLanguage.contains(it) }
            }
            val displayName = Locale.forLanguageTag(tag).getDisplayLanguage(Locale.ENGLISH).trim().lowercase(Locale.ROOT)
            return displayName.isNotEmpty() && displayName != tag && lowercaseApiLanguage.contains(displayName)
        }
    }
}
