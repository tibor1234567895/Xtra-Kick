package com.github.andreyasadchy.xtra.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.andreyasadchy.xtra.graphql.type.ClipsPeriod
import com.github.andreyasadchy.xtra.graphql.type.Language
import com.github.andreyasadchy.xtra.model.ui.Clip
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import kotlin.math.max

class GameClipsDataSource(
    private val gameId: String?,
    private val gameSlug: String?,
    private val gameName: String?,
    private val gqlQueryLanguages: List<Language>?,
    private val gqlQueryPeriod: ClipsPeriod?,
    private val gqlLanguages: List<String>?,
    private val gqlPeriod: String?,
    private val startedAt: String?,
    private val endedAt: String?,
    private val gqlHeaders: Map<String, String>,
    private val graphQLRepository: GraphQLRepository,
    private val helixHeaders: Map<String, String>,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val enableIntegrity: Boolean,
    private val apiPref: List<String>,
    private val networkLibrary: String?,
) : PagingSource<Int, Clip>() {
    private var api: String? = null
    private var offset: String? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Clip> {
        if (gameId.isNullOrBlank() && gameSlug.isNullOrBlank() && gameName.isNullOrBlank()) {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
        return if (params.key != null && !offset.isNullOrBlank()) {
            try {
                loadFromApi(api, params)
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        } else {
            val apisToTry = when {
                !gameSlug.isNullOrBlank() || !gameName.isNullOrBlank() -> listOf(C.KICK)
                !gameId.isNullOrBlank() -> listOf(C.HELIX)
                else -> apiPref.filter { it == C.GQL || it == C.GQL_PERSISTED_QUERY || it == C.HELIX }
                    .ifEmpty { listOf(C.GQL, C.GQL_PERSISTED_QUERY, C.HELIX) }
            }
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

    private suspend fun loadFromApi(apiPref: String?, params: LoadParams<Int>): LoadResult<Int, Clip> {
        api = apiPref
        return when (apiPref) {
            C.KICK -> kickLoad(params)
            C.GQL, C.GQL_PERSISTED_QUERY -> gqlQueryLoad(params)
            C.HELIX -> if (!gameId.isNullOrBlank()) helixLoad(params) else throw Exception()
            else -> throw Exception()
        }
    }

    private suspend fun kickLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val slug = gameSlug?.takeIf { it.isNotBlank() }
            ?: gameName?.trim()?.lowercase()?.replace(' ', '-')
            ?: throw Exception()
        val kickTime = when (gqlQueryPeriod) {
            ClipsPeriod.LAST_DAY -> "day"
            ClipsPeriod.LAST_WEEK -> "week"
            ClipsPeriod.LAST_MONTH -> "month"
            ClipsPeriod.ALL_TIME -> "all"
            else -> when (gqlPeriod) {
                "LAST_DAY" -> "day"
                "LAST_WEEK" -> "week"
                "LAST_MONTH" -> "month"
                "ALL_TIME" -> "all"
                else -> null
            }
        }
        val startMs = startedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
        val endMs = endedAt?.let { KickApiHelper.parseIso8601DateUTC(it) }
        val page = kickRepository.getCategoryClipsPage(
            categorySlug = slug,
            gameId = gameId,
            gameName = gameName,
            limit = maxOf(params.loadSize, 20),
            time = kickTime,
            cursor = offset,
        ) ?: return LoadResult.Page(
            data = emptyList(),
            prevKey = null,
            nextKey = null
        )
        val list = page.clips.asSequence()
            .filter { clip ->
                val ts = clip.uploadDate?.let { KickApiHelper.parseIso8601DateUTC(it) } ?: return@filter false
                val afterStart = startMs?.let { ts >= it } ?: true
                val beforeEnd = endMs?.let { ts <= it } ?: true
                afterStart && beforeEnd
            }
            .sortedWith(
                compareByDescending<Clip> { it.viewCount ?: -1 }
                    .thenByDescending { it.uploadDate?.let(KickApiHelper::parseIso8601DateUTC) ?: Long.MIN_VALUE }
            )
            .take(params.loadSize)
            .toList()
        offset = page.nextCursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && page.clips.isNotEmpty()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlQueryLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = graphQLRepository.loadQueryGameClips(
            networkLibrary = networkLibrary,
            headers = gqlHeaders,
            id = gameId,
            slug = gameSlug.takeIf { gameId.isNullOrBlank() },
            name = gameName.takeIf { gameId.isNullOrBlank() && gameSlug.isNullOrBlank() },
            languages = gqlQueryLanguages,
            period = gqlQueryPeriod,
            first = params.loadSize,
            after = offset
        )
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.game?.clips
        if (response.data?.game == null || data == null) {
            throw IllegalStateException("Game clips GraphQL returned no game/clips data")
        }
        val items = data?.edges.orEmpty()
        val list = items.mapNotNull { item ->
            item?.node?.let {
                Clip(
                    id = it.slug,
                    channelId = it.broadcaster?.id,
                    channelLogin = it.broadcaster?.login,
                    channelName = it.broadcaster?.displayName,
                    videoId = it.video?.id,
                    vodOffset = if (it.videoOffsetSeconds != null && it.durationSeconds != null) {
                        max(it.videoOffsetSeconds - it.durationSeconds, 0)
                    } else {
                        it.videoOffsetSeconds
                    },
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt?.toString(),
                    duration = it.durationSeconds?.toDouble(),
                    thumbnailUrl = it.thumbnailURL,
                    profileImageUrl = it.broadcaster?.profileImageURL,
                    videoAnimatedPreviewURL = it.video?.animatedPreviewURL
                )
            }
        }
        offset = items.lastOrNull()?.cursor?.toString()
        val nextPage = data?.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun gqlLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = graphQLRepository.loadGameClips(
            networkLibrary = networkLibrary,
            headers = gqlHeaders,
            gameSlug = gameSlug,
            period = gqlPeriod,
            languages = gqlLanguages,
            limit = params.loadSize,
            cursor = offset,
        )
        if (enableIntegrity) {
            response.errors?.find { it.message == "failed integrity check" }?.let { return LoadResult.Error(Exception(it.message)) }
        }
        val data = response.data?.game?.clips
        val items = data?.edges.orEmpty()
        val list = items.map { item ->
            item.node.let {
                Clip(
                    id = it.slug,
                    channelId = it.broadcaster?.id,
                    channelLogin = it.broadcaster?.login,
                    channelName = it.broadcaster?.displayName,
                    gameId = gameId,
                    gameSlug = gameSlug,
                    gameName = gameName,
                    title = it.title,
                    viewCount = it.viewCount,
                    uploadDate = it.createdAt,
                    duration = it.durationSeconds,
                    thumbnailUrl = it.thumbnailURL,
                    profileImageUrl = it.broadcaster?.profileImageURL,
                )
            }
        }
        offset = items.lastOrNull()?.cursor
        val nextPage = data?.pageInfo?.hasNextPage != false
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank() && nextPage) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    private suspend fun helixLoad(params: LoadParams<Int>): LoadResult<Int, Clip> {
        val response = helixRepository.getClips(
            networkLibrary = networkLibrary,
            headers = helixHeaders,
            gameId = gameId,
            startedAt = startedAt,
            endedAt = endedAt,
            limit = params.loadSize,
            offset = offset,
        )
        val list = response.data.map {
            Clip(
                id = it.id,
                channelId = it.channelId,
                channelName = it.channelName,
                videoId = it.videoId,
                vodOffset = if (it.vodOffset != null && it.duration != null) {
                    max(it.vodOffset - it.duration.toInt(), 0)
                } else {
                    it.vodOffset
                },
                gameId = gameId,
                gameSlug = gameSlug,
                gameName = gameName,
                title = it.title,
                viewCount = it.viewCount,
                uploadDate = it.createdAt,
                duration = it.duration,
                thumbnailUrl = it.thumbnailUrl,
            )
        }
        offset = response.pagination?.cursor
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = if (!offset.isNullOrBlank()) {
                (params.key ?: 1) + 1
            } else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Clip>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
