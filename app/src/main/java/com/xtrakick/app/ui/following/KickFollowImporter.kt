package com.xtrakick.app.ui.following

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import com.xtrakick.app.BuildConfig
import com.xtrakick.app.R
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.prefs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.CancellationException
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

sealed class KickFollowImportState {
    object Idle : KickFollowImportState()
    data class Importing(val count: Int) : KickFollowImportState()
    data class Success(val count: Int) : KickFollowImportState()
    data class Error(val message: String?) : KickFollowImportState()
}

@Singleton
class KickFollowImporter @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
) {

    private val enrichmentScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    // Outlives the login screen so a post-login import keeps running after LoginActivity finishes.
    private val postLoginImportScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val _importState = kotlinx.coroutines.flow.MutableStateFlow<KickFollowImportState>(KickFollowImportState.Idle)
    val importState: kotlinx.coroutines.flow.StateFlow<KickFollowImportState> = _importState

    companion object {
        private const val LOG_TAG = "KickFollowImport"
    }

    private fun isDebugLoggingEnabled(): Boolean {
        return BuildConfig.DEBUG && context.prefs().getBoolean(AppConstants.DEBUG_KICK_FOLLOW_IMPORT_LOGS, false)
    }

    private fun debugLogI(message: String) {
        if (isDebugLoggingEnabled()) {
            Log.i(LOG_TAG, message)
        }
    }

    private fun logWarn(message: String, throwable: Throwable? = null) {
        if (isDebugLoggingEnabled()) {
            if (throwable != null) {
                Log.w(LOG_TAG, message, throwable)
            } else {
                Log.w(LOG_TAG, message)
            }
        }
    }

    suspend fun importPayload(payload: String): Int {
        return runImport {
            importFollows(KickFollowImportPayloadParser.parse(payload))
        }
    }

    /** Fetches followed channels with OAuth fallback, then stores them locally. */
    suspend fun importAuthenticatedKickFollows(networkLibrary: String?): Int {
        return runImport {
            val channels = kickRepository.getFollowedChannelsWithStoredAuth(networkLibrary)
            importFollows(channels.map { channel ->
                KickImportedFollow(channel.login, channel.name, channel.profilePicture)
            })
        }
    }

    private suspend fun runImport(block: suspend () -> Int): Int {
        _importState.value = KickFollowImportState.Importing(0)
        return try {
            val count = block()
            _importState.value = KickFollowImportState.Success(count)
            count
        } catch (error: CancellationException) {
            throw error
        } catch (error: Exception) {
            _importState.value = KickFollowImportState.Error(error.message)
            throw error
        }
    }

    /**
     * Runs follow import on a scope that outlives the login screen.
     * If followed channels are found, a toast reports the count.
     * Failures are non-fatal and silently logged; the manual import dialog in Following tab remains
     * available as a fallback.
     */
    fun schedulePostLoginImport(networkLibrary: String?) {
        postLoginImportScope.launch {
            try {
                val count = importAuthenticatedKickFollows(networkLibrary)
                Log.i(LOG_TAG, "Post-login Kick follow import succeeded count=$count")
                if (count > 0) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.import_kick_followed_success, count),
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            } catch (error: CancellationException) {
                throw error
            } catch (error: Exception) {
                Log.i(LOG_TAG, "Post-login Kick follow import skipped or unavailable: ${error.message}")
            }
        }
    }

    /** One-time backfill: mark locally stored follows that also exist on Kick. Safe to re-run. */
    suspend fun ensureKickSourceMarks(networkLibrary: String?): Int {
        if (context.prefs().getBoolean(AppConstants.KICK_FOLLOW_MARK_DONE, false)) return 0
        fun markDone() = context.prefs().edit().putBoolean(AppConstants.KICK_FOLLOW_MARK_DONE, true).apply()
        val channels = try {
            kickRepository.getFollowedChannelsWithStoredAuth(networkLibrary)
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            return 0
        }
        if (channels.isEmpty()) {
            markDone()
            return 0
        }
        val marked = localFollowsChannel.markKickFollows(channels.map { it.login })
        markDone()
        Log.i(LOG_TAG, "Kick follow source-mark backfill marked=$marked of ${channels.size}")
        return marked
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
        localFollowsChannel.upsertLocalFollows(dedupedFollows.map { follow ->
            LocalFollowChannel(
                userId = null,
                userLogin = follow.login,
                userName = follow.name,
                channelLogo = follow.profilePicture,
                sourceMask = AppConstants.FOLLOW_SOURCE_MASK_LOCAL or AppConstants.FOLLOW_SOURCE_MASK_KICK,
            )
        })
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
                logWarn("imported follow enrichment failed: ${error.message}", error)
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
        val headers = KickApiHelper.getKickPublicApiHeaders(context)
        if (headers[AppConstants.HEADER_TOKEN].isNullOrBlank()) {
            debugLogI("skip imported follow id enrichment: missing auth token")
            return
        }
        val networkLibrary = context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp")
        normalizedLogins.chunked(100).forEach { chunk ->
            val response = kickPublicApiRepository.getUsers(
                networkLibrary = networkLibrary,
                headers = headers,
                logins = chunk,
            )
            val enrichedFollows = response.data.mapNotNull { user ->
                val login = user.channelLogin?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
                val channelId = user.channelId?.takeIf { it.isNotBlank() }
                val name = user.channelName?.takeIf { it.isNotBlank() }
                val profileImageUrl = user.profileImageUrl?.takeIf { it.isNotBlank() }
                LocalFollowChannel(channelId, login, name, profileImageUrl)
            }
            localFollowsChannel.upsertLocalFollows(enrichedFollows)
        }
        debugLogI("enriched imported follows with broadcaster ids count=${normalizedLogins.size}")
    }
}
