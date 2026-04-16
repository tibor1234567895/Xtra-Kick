package com.github.andreyasadchy.xtra.ui.following

import android.content.Context
import android.util.Log
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.LocalFollowChannelRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.prefs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal data class KickImportedFollow(
    val login: String,
    val name: String?,
    val profilePicture: String?,
)

internal object KickFollowImportPayloadParser {

    private val json = Json { ignoreUnknownKeys = true }

    fun parse(payload: String): List<KickImportedFollow> {
        val channels = runCatching {
            json.parseToJsonElement(payload).jsonObject["channels"]?.jsonArray.orEmpty()
        }.getOrDefault(emptyList())
        val seen = LinkedHashSet<String>()
        val parsed = ArrayList<KickImportedFollow>(channels.size)
        channels.forEach { element ->
            val channel = runCatching { element.jsonObject }.getOrNull() ?: return@forEach
            val login = channel["channel_slug"]?.jsonPrimitive?.contentOrNull
                ?.trim()
                ?.takeIf { it.isNotBlank() }
                ?: return@forEach
            val normalizedLogin = login.lowercase()
            if (!seen.add(normalizedLogin)) return@forEach
            val normalizedName = sanitizeImportedName(
                rawName = channel["user_username"]?.jsonPrimitive?.contentOrNull,
                login = login,
            )
            parsed += KickImportedFollow(
                login = login,
                name = normalizedName,
                profilePicture = channel["profile_picture"]?.jsonPrimitive?.contentOrNull?.trim()?.takeIf { it.isNotBlank() },
            )
        }
        return parsed
    }

    private fun sanitizeImportedName(rawName: String?, login: String): String {
        val fallback = login.trim().ifBlank { login }
        val trimmed = rawName?.trim().orEmpty()
        if (trimmed.isBlank()) {
            return fallback
        }
        val noPrefix = trimmed
            .replace(Regex("^(?i)live[_\\s-]*"), "")
            .replace(Regex("^(?i)live"), "")
            .trim(' ', '-', '_', '(', ')')
        if (noPrefix.isBlank()) {
            return fallback
        }
        if (noPrefix.equals(login, ignoreCase = true)) {
            return fallback
        }
        val lower = noPrefix.lowercase()
        val loginLower = fallback.lowercase()
        if (lower.startsWith(loginLower) || loginLower.startsWith(lower)) {
            return fallback
        }
        return noPrefix
    }
}

@Singleton
class KickFollowImporter @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
) {

    private val enrichmentScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    companion object {
        private const val LOG_TAG = "KickFollowImport"
    }

    private fun isDebugLoggingEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(C.DEBUG_KICK_FOLLOW_IMPORT_LOGS, false)
    }

    private fun debugLogI(message: String) {
        if (isDebugLoggingEnabled()) {
            Log.i(LOG_TAG, message)
        }
    }

    private fun debugLogW(message: String) {
        if (isDebugLoggingEnabled()) {
            Log.w(LOG_TAG, message)
        }
    }

    suspend fun importPayload(payload: String): Int {
        val follows = KickFollowImportPayloadParser.parse(payload)
        return importFollows(follows)
    }

    suspend fun importStoredKickFollows(networkLibrary: String?): Int {
        val collected = LinkedHashMap<String, KickImportedFollow>()
        var cursor: String? = null
        Log.i(LOG_TAG, "Kick follow import pagination started")
        do {
            val response = kickRepository.getFollowedChannelsWebPage(cursor)
            response.channels.forEach { follow ->
                val login = follow.login.trim().takeIf { it.isNotBlank() } ?: return@forEach
                collected[login.lowercase()] = KickImportedFollow(
                    login = login,
                    name = follow.name,
                    profilePicture = follow.profilePicture,
                )
            }
            val nextCursor = response.nextCursor?.takeIf { it.isNotBlank() }
            cursor = nextCursor?.takeIf { it != cursor }
        } while (!cursor.isNullOrBlank())
        Log.i(LOG_TAG, "Kick follow import pagination finished total=${collected.size}")
        val follows = collected.values.map { channel ->
            KickImportedFollow(
                login = channel.login,
                name = channel.name,
                profilePicture = channel.profilePicture,
            )
        }
        return importFollows(follows)
    }

    internal suspend fun importFollows(follows: List<KickImportedFollow>): Int {
        val dedupedFollows = follows
            .asSequence()
            .mapNotNull { follow ->
                val login = follow.login.trim().takeIf { it.isNotBlank() } ?: return@mapNotNull null
                follow.copy(login = login)
            }
            .distinctBy { it.login.lowercase() }
            .toList()
        dedupedFollows.forEach { follow ->
            localFollowsChannel.upsertLocalFollow(
                userId = null,
                userLogin = follow.login,
                userName = follow.name,
                channelLogo = follow.profilePicture,
            )
        }
        Log.i(LOG_TAG, "Kick follow import stored follows count=${dedupedFollows.size}")
        enqueueImportedFollowEnrichment(dedupedFollows.map { it.login })
        return dedupedFollows.size
    }

    private fun enqueueImportedFollowEnrichment(logins: List<String>) {
        val snapshot = logins.toList()
        enrichmentScope.launch {
            runCatching {
                enrichImportedFollows(snapshot)
            }.onFailure { error ->
                debugLogW("imported follow enrichment failed: ${error.message}")
            }
        }
    }

    private suspend fun enrichImportedFollows(logins: List<String>) {
        val normalizedLogins = logins
            .map { it.trim().lowercase() }
            .filter { it.isNotBlank() }
            .distinct()
        if (normalizedLogins.isEmpty()) {
            return
        }
        val headers = KickApiHelper.getHelixHeaders(context)
        if (headers[C.HEADER_TOKEN].isNullOrBlank()) {
            debugLogI("skip imported follow id enrichment: missing auth token")
            return
        }
        val networkLibrary = context.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        normalizedLogins.chunked(100).forEach { chunk ->
            val response = helixRepository.getUsers(
                networkLibrary = networkLibrary,
                headers = headers,
                logins = chunk,
            )
            response.data.forEach { user ->
                val login = user.channelLogin?.takeIf { it.isNotBlank() } ?: return@forEach
                val channelId = user.channelId?.takeIf { it.isNotBlank() }
                val name = user.channelName?.takeIf { it.isNotBlank() }
                val profileImageUrl = user.profileImageUrl?.takeIf { it.isNotBlank() }
                localFollowsChannel.upsertLocalFollow(channelId, login, name, profileImageUrl)
            }
        }
        debugLogI("enriched imported follows with broadcaster ids count=${normalizedLogins.size}")
    }
}
