package com.xtrakick.app.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xtrakick.app.model.kick.Language
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import java.util.Collections
import java.util.Locale
import kotlinx.coroutines.CancellationException

class GameStreamsDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val gqlQueryLanguages: List<Language>?,
    private val gqlLanguages: List<String>?,
    private val gqlSort: String?,
    private val tags: List<String>?,
    private val kickRepository: KickRepository,
    private val apiPref: List<String>,
) : PagingSource<Int, Stream>() {
    private var api: String? = null
    private var offset: String? = null
    private val seenStreamKeys = Collections.synchronizedSet(mutableSetOf<String>())
    private val languageCursors = mutableMapOf<Int, String>()
    private var languageEndpointActive = false

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
        val slug = gameSlug?.takeIf { it.isNotBlank() }
            ?: kickRepository.resolveCategorySlug(gameId, gameName)
            ?: KickApiHelper.toCategorySlug(gameName)
        val normalizedSlug = slug?.trim()?.lowercase(Locale.ROOT)
        val normalizedName = gameName?.trim()?.lowercase(Locale.ROOT)
        val targetInferredSlug = KickApiHelper.toCategorySlug(gameName)
        val sanitizedTargetId = KickApiHelper.sanitizeGameId(gameId, normalizedSlug)

        kickRepository.getEventFilterStreams(tags.orEmpty())?.let { streams ->
            val matched = streams.filter { stream ->
                matchesCategory(stream, sanitizedTargetId, normalizedSlug, normalizedName, targetInferredSlug)
            }
            return LoadResult.Page(
                data = StreamsDataSource.filterEventStreams(matched, gqlLanguages, gqlSort),
                prevKey = null,
                nextKey = null,
            )
        }
        val languageCodes = StreamsDataSource.requestedLanguageCodes(gqlLanguages, tags)
        val resolvedGameId = sanitizedTargetId
            ?: kickRepository.getCachedCategoryId(slug, gameName)
        if (languageCodes.isNotEmpty() && !resolvedGameId.isNullOrBlank() && gqlSort != "VIEWER_COUNT_ASC" && gqlSort != "RECENT") {
            val page = params.key ?: 1
            val cursor = if (page == 1) null else languageCursors[page] ?: error("Missing language page cursor")
            kickRepository.getLanguageFilteredLivestreams(resolvedGameId, languageCodes, cursor, params.loadSize,
                awaitEventMetadata = kickRepository.hasCachedEventFilter(tags.orEmpty()))?.let { response ->
                languageEndpointActive = true
                val streams = response.livestreams
                    .filter { stream ->
                        val cat = stream.category
                        val catId = cat?.id?.toString()
                        val catSlug = cat?.slug?.lowercase(Locale.ROOT)
                        val catName = cat?.name?.lowercase(Locale.ROOT)
                        val catInferred = KickApiHelper.toCategorySlug(cat?.name)
                        val targetInferred = KickApiHelper.toCategorySlug(normalizedName)
                        catId == resolvedGameId ||
                            (normalizedSlug != null && (catSlug == normalizedSlug || catInferred == normalizedSlug)) ||
                            (normalizedName != null && (catName == normalizedName || catInferred == targetInferred))
                    }
                    .filter { StreamsDataSource.matchesFilters(it.toLegacyLivestream(), gqlLanguages, tags,
                        kickRepository.getCachedChannelEventTitle(it.channel.id.toString())) }
                    .map { kickRepository.toStream(it) }
                    .filter { seenStreamKeys.add(it.channelId ?: it.channelLogin ?: it.id.orEmpty()) }
                val next = response.pagination.nextCursor?.takeIf { it.isNotBlank() && it != cursor }
                    ?.let { languageCursors[page + 1] = it; page + 1 }
                return LoadResult.Page(data = streams, prevKey = null, nextKey = next)
            }
        }
        val targetSize = params.loadSize
        val hasFilters = !gqlLanguages.isNullOrEmpty() || !tags.isNullOrEmpty()
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
                subcategory = slug,
                awaitEventMetadata = kickRepository.hasCachedEventFilter(tags.orEmpty()),
            )
            val matched = response.data
                .filter { item ->
                    // Guard against Kick falling back to global popular livestreams when subcategory is unmatched
                    val itemCats = item.categories
                    val targetInferred = KickApiHelper.toCategorySlug(normalizedName)
                    val matchesCategory = (normalizedSlug.isNullOrBlank() && normalizedName.isNullOrBlank() && gameId.isNullOrBlank()) ||
                        itemCats.isNullOrEmpty() ||
                        itemCats.any { cat ->
                            val catId = cat.id?.toString()
                            val catSlug = cat.slug?.lowercase(Locale.ROOT)
                            val catName = cat.name?.lowercase(Locale.ROOT)
                            val catInferred = KickApiHelper.toCategorySlug(cat.name)
                            (gameId != null && catId == gameId) ||
                            (normalizedSlug != null && (catSlug == normalizedSlug || catInferred == normalizedSlug)) ||
                            (normalizedName != null && (catName == normalizedName || catInferred == targetInferred))
                        }
                    matchesCategory && StreamsDataSource.matchesFilters(item, gqlLanguages, tags,
                        kickRepository.getCachedChannelEventTitle((item.channel?.id ?: item.channelId)?.toString()))
                }
                .map {
                    val itemCat = it.categories?.firstOrNull()
                    kickRepository.toStream(
                        item = it,
                        gameId = itemCat?.id?.toString() ?: gameId,
                        gameSlug = itemCat?.slug ?: slug,
                        gameName = itemCat?.name ?: gameName
                    )
                }
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

    internal fun matchesCategory(
        stream: Stream,
        targetId: String? = null,
        targetSlug: String? = null,
        targetName: String? = null,
        targetInferredSlug: String? = null
    ): Boolean {
        val tSlug = targetSlug ?: gameSlug?.trim()?.lowercase(Locale.ROOT)
        val tId = targetId ?: KickApiHelper.sanitizeGameId(gameId, tSlug)
        val tName = targetName ?: gameName?.trim()?.lowercase(Locale.ROOT)
        val tInferred = targetInferredSlug ?: KickApiHelper.toCategorySlug(gameName)

        val hasCategoryConstraint = !tId.isNullOrBlank() || !tSlug.isNullOrBlank() || !tName.isNullOrBlank()
        if (!hasCategoryConstraint) return true

        val sId = stream.gameId?.trim()
        val sSlug = stream.gameSlug?.trim()?.lowercase(Locale.ROOT)
        val sName = stream.gameName?.trim()?.lowercase(Locale.ROOT)
        val sInferredSlug = KickApiHelper.toCategorySlug(stream.gameName)

        // 1. Direct ID match
        if (!tId.isNullOrBlank() && !sId.isNullOrBlank() && sId == tId) return true

        // 2. Direct slug match
        if (!tSlug.isNullOrBlank() && !sSlug.isNullOrBlank() && sSlug == tSlug) return true

        // 3. Direct name match
        if (!tName.isNullOrBlank() && !sName.isNullOrBlank() && sName == tName) return true

        // 4. Inferred slug from stream name matches target slug
        if (!tSlug.isNullOrBlank() && !sInferredSlug.isNullOrBlank() && sInferredSlug == tSlug) return true

        // 5. Inferred slug from target name matches stream slug
        if (!sSlug.isNullOrBlank() && !tInferred.isNullOrBlank() && sSlug == tInferred) return true

        // 6. Inferred slug from target name matches inferred slug from stream name
        if (!tInferred.isNullOrBlank() && !sInferredSlug.isNullOrBlank() && sInferredSlug == tInferred) return true

        // 7. Cached slug/ID cross-referencing
        if (!sId.isNullOrBlank() && !tSlug.isNullOrBlank()) {
            val cachedSlug = kickRepository.getCachedCategorySlug(sId)?.lowercase(Locale.ROOT)
            if (cachedSlug != null && (cachedSlug == tSlug || cachedSlug == tInferred)) return true
        }
        if (!tId.isNullOrBlank() && !sSlug.isNullOrBlank()) {
            val cachedSlug = kickRepository.getCachedCategorySlug(tId)?.lowercase(Locale.ROOT)
            if (cachedSlug != null && (cachedSlug == sSlug || cachedSlug == sInferredSlug)) return true
        }

        return false
    }

    override fun getRefreshKey(state: PagingState<Int, Stream>): Int? {
        if (languageEndpointActive) return null
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
