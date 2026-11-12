package com.xtrakick.app.ui.following

import android.content.Context
import android.os.SystemClock
import android.util.Log
import com.xtrakick.app.model.ui.LocalFollowChannel
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickFollowSnapshotException
import com.xtrakick.app.repository.KickWebResponseException
import com.xtrakick.app.repository.LocalFollowChannelRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull

@Singleton
class KickFollowSync internal constructor(
    private val scope: CoroutineScope,
    private val currentSession: () -> Session?,
    private val currentVersion: () -> Long,
    private val fetch: suspend (Session) -> List<KickRepository.KickFollowedChannel>,
    private val apply: suspend (List<KickRepository.KickFollowedChannel>, () -> Boolean) -> Boolean,
    private val now: () -> Long,
    private val log: (String) -> Unit,
) {
    internal data class Session(val accountId: String, val credential: String)
    private data class Snapshot(val session: Session, val version: Long, val channels: List<KickRepository.KickFollowedChannel>)

    @Inject
    constructor(
        @ApplicationContext context: Context,
        kickRepository: KickRepository,
        localFollows: LocalFollowChannelRepository,
    ) : this(
        scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate),
        currentSession = {
            val prefs = context.tokenPrefs()
            val accountId = prefs.getString(AppConstants.KICK_USER_ID, null)?.takeIf { it.isNotBlank() }
            val token = prefs.getString(AppConstants.KICK_ACCESS_TOKEN, null)?.takeIf { it.isNotBlank() }
            if (accountId != null && token != null && AuthStateHelper.isKickLoggedIn(context)) Session(accountId, token) else null
        },
        currentVersion = { localFollows.changeVersion },
        fetch = { session ->
            val channels = kickRepository.getFollowedChannelsForSync(
                context.prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"), session.accountId,
            )
            val ownLogin = context.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)
            channels.filterNot { it.login.equals(ownLogin, ignoreCase = true) }
        },
        apply = { channels, canApply ->
            localFollows.reconcileKickFollows(channels.map { channel ->
                LocalFollowChannel(
                    userLogin = channel.login, userName = channel.name, channelLogo = channel.profilePicture,
                    sourceMask = AppConstants.FOLLOW_SOURCE_MASK_KICK,
                )
            }, canApply)
        },
        now = SystemClock::elapsedRealtime,
        log = { Log.i("KickFollowSync", it) },
    )

    @Volatile private var followingVisible = true
    @Volatile private var visit = 0L
    private var session: Session? = null
    private var pending: Snapshot? = null
    private var job: Job? = null
    private var nextCheckAt = 0L
    private var retryDelay = 60_000L
    @Volatile private var activeImports = 0
    private val applyMutex = Mutex()

    fun setFollowingVisible(visible: Boolean) {
        if (followingVisible == visible) return
        followingVisible = visible
        visit++
        if (!visible) scope.launch { applyPending() }
    }

    fun beginImport() {
        activeImports++
        job?.cancel()
        pending = null
        nextCheckAt = 0L
    }

    fun endImport() {
        activeImports = (activeImports - 1).coerceAtLeast(0)
    }

    fun requestSync(force: Boolean = false): Job? {
        if (activeImports > 0) return null
        val account = currentSession()
        if (account != session) {
            job?.cancel()
            pending = null
            nextCheckAt = 0L
            retryDelay = 60_000L
            session = account
        }
        if (account == null) return null
        job?.takeIf { it.isActive }?.let { return it }
        if (!force && now() < nextCheckAt) return null
        val requestedVisit = visit
        return scope.launch {
            if (applyPending(if (force) requestedVisit else null) && now() < nextCheckAt) return@launch
            val version = currentVersion()
            try {
                val channels = withTimeoutOrNull(45_000L) { fetch(account) }
                    ?: throw java.io.IOException("Kick follow sync timed out")
                if (currentSession() != account || currentVersion() != version) {
                    nextCheckAt = 0L
                    return@launch
                }
                pending = Snapshot(account, version, channels)
                nextCheckAt = now() + 10L * 60_000L
                retryDelay = 60_000L
                log("Fetched ${channels.size} follows; staged=$followingVisible")
                applyPending(if (force) requestedVisit else null)
            } catch (error: CancellationException) {
                throw error
            } catch (error: Exception) {
                nextCheckAt = now() + retryDelay
                retryDelay = (retryDelay * 2).coerceAtMost(10L * 60_000L)
                val reason = when (error) {
                    is KickFollowSnapshotException -> error.message
                    is KickWebResponseException -> "HTTP ${error.statusCode}"
                    else -> error.javaClass.simpleName
                }
                log("Sync unavailable ($reason); keeping saved follows")
            }
        }.also { job = it }
    }

    suspend fun refreshNow() {
        if (activeImports > 0) return
        val account = currentSession()
        val requestedVisit = visit
        requestSync(force = true)?.join()
        if (currentSession() == account) applyPending(requestedVisit)
    }

    private suspend fun applyPending(allowedVisit: Long? = null): Boolean = applyMutex.withLock {
        val snapshot = pending ?: return@withLock false
        fun stillCurrent() = currentSession() == snapshot.session && currentVersion() == snapshot.version
        if (!stillCurrent()) {
            pending = null
            nextCheckAt = 0L
            return@withLock false
        }
        fun canApply() = activeImports == 0 && stillCurrent() && (!followingVisible || allowedVisit == visit)
        if (!canApply()) return@withLock false
        pending = null
        val applied = try {
            apply(snapshot.channels, ::canApply)
        } catch (error: CancellationException) {
            throw error
        } catch (_: Exception) {
            log("Could not apply follows; keeping saved follows")
            false
        }
        if (applied) {
            log("Applied ${snapshot.channels.size} follows")
        } else if (pending == null && stillCurrent()) {
            pending = snapshot
        } else {
            nextCheckAt = 0L
        }
        applied
    }
}
