package com.xtrakick.app.ui.following

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import com.xtrakick.app.R
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickWebResponseException
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.util.AppConstants
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
    /**
     * Auto import failed with an auth error and there is no website session to retry
     * with (typical after external-browser login). The UI should point at manual import.
     */
    object NeedsManualImport : KickFollowImportState()
}

@Singleton
class KickFollowImporter @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val localFollowsChannel: LocalFollowChannelRepository,
    private val kickRepository: KickRepository,
) {

    // Outlives the login screen so a post-login import keeps running after LoginActivity finishes.
    private val postLoginImportScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val _importState = kotlinx.coroutines.flow.MutableStateFlow<KickFollowImportState>(KickFollowImportState.Idle)
    val importState: kotlinx.coroutines.flow.StateFlow<KickFollowImportState> = _importState

    companion object {
        private const val LOG_TAG = "KickFollowImport"
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
                if (isManualImportNeeded(error)) {
                    _importState.value = KickFollowImportState.NeedsManualImport
                }
                Log.i(LOG_TAG, "Post-login Kick follow import skipped or unavailable: ${error.message}")
            }
        }
    }

    private fun isManualImportNeeded(error: Exception): Boolean {
        if (!com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(context)) return false
        if (com.xtrakick.app.util.AuthStateHelper.isKickGoogleSession(context)) return false
        if (kickRepository.hasKickWebsiteSessionCookieOnly()) return false
        val webResponse = error as? KickWebResponseException
        if (webResponse != null) {
            return webResponse.statusCode == 401 || webResponse.statusCode == 403
        }
        val message = error.message.orEmpty()
        return message.contains("401", ignoreCase = true) ||
            message.contains("unauthenticated", ignoreCase = true)
    }

    /** One-time backfill: mark locally stored follows that also exist on Kick. Safe to re-run. */
    suspend fun ensureKickSourceMarks(networkLibrary: String?): Int {
        if (context.prefs().getBoolean(AppConstants.KICK_FOLLOW_MARK_DONE, false)) return 0
        if (!com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(context)) return 0
        fun markDone() = context.prefs().edit().putBoolean(AppConstants.KICK_FOLLOW_MARK_DONE, true).apply()
        val channels = try {
            kickRepository.getFollowedChannelsWithStoredAuth(networkLibrary)
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            return 0
        }
        if (channels.isEmpty()) {
            // Only mark done if confirmed logged in and returned empty from authenticated call
            if (com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(context)) {
                markDone()
            }
            return 0
        }
        val marked = localFollowsChannel.markKickFollows(channels.map { it.login })
        markDone()
        Log.i(LOG_TAG, "Kick follow source-mark backfill marked=$marked of ${channels.size}")
        return marked
    }

    internal suspend fun importFollows(follows: List<KickImportedFollow>): Int {
        val ownLogin = context.prefs().getString(AppConstants.KICK_USER_LOGIN, null)
            ?.trim()?.lowercase()?.takeIf { it.isNotBlank() }
        val dedupedFollows = follows
            .asSequence()
            .mapNotNull { follow ->
                val login = follow.login.trim().takeIf { it.isNotBlank() } ?: return@mapNotNull null
                follow.copy(login = login)
            }
            // Kick's api.kick.com users arm ignores `login` filters and echoes the token
            // owner back; importers upstream of this call could therefore wrap the
            // logged-in account itself as a followed channel. Never store it.
            .filter { ownLogin == null || it.login.lowercase() != ownLogin }
            .distinctBy { it.login.lowercase() }
            .toList()
        localFollowsChannel.upsertLocalFollows(dedupedFollows.map { follow ->
            LocalFollowChannel(
                userId = null,
                userLogin = follow.login,
                userName = follow.name,
                channelLogo = follow.profilePicture,
                sourceMask = AppConstants.FOLLOW_SOURCE_MASK_KICK,
            )
        })
        Log.i(LOG_TAG, "Kick follow import stored follows count=${dedupedFollows.size}")
        return dedupedFollows.size
    }
}
