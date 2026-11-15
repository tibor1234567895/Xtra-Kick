package com.xtrakick.app.ui.player

import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.KickRewardsRepository
import com.xtrakick.app.util.chat.KickViewerWatchWebSocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.net.ssl.X509TrustManager

/**
 * Single owner for viewer watch presence. Both player engines delegate here
 * so timings, messages and ID resolution stay identical.
 */
class KickViewerWatchOwner(
    private val kickRepository: KickRepository,
    private val trustManager: X509TrustManager?,
    private val debugLogging: Boolean = false,
    private val isRewardsEnabled: () -> Boolean,
    private val isPlaying: () -> Boolean,
    private val rewardsRepository: KickRewardsRepository? = null,
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var watch: KickViewerWatchWebSocket? = null
    private var job: Job? = null
    private var channelId: String? = null
    private var livestreamId: String? = null
    private var channelLogin: String? = null

    fun setMetadata(channelId: String?, livestreamId: String?, channelLogin: String?) {
        val nextChannelId = channelId?.takeIf { it.isNotBlank() }
        val nextLivestreamId = livestreamId?.takeIf { it.isNotBlank() }
        val nextChannelLogin = channelLogin?.takeIf { it.isNotBlank() }
        if (this.channelId == nextChannelId && this.livestreamId == nextLivestreamId && this.channelLogin == nextChannelLogin) {
            if (isPlaying()) startIfNeeded()
            return
        }
        stop()
        this.channelId = nextChannelId
        this.livestreamId = nextLivestreamId
        this.channelLogin = nextChannelLogin
        if (isPlaying()) {
            startIfNeeded()
        }
    }

    fun clearMetadata() {
        stop()
        channelId = null
        livestreamId = null
        channelLogin = null
    }

    fun startIfNeeded() {
        val cid = channelId?.takeIf { it.isNotBlank() }
        val lid = livestreamId?.takeIf { it.isNotBlank() }
        val login = channelLogin?.takeIf { it.isNotBlank() }
        if (cid == null && lid == null && login == null) return
        if (!isRewardsEnabled()) return
        if (job?.isActive == true) return
        watch = KickViewerWatchWebSocket(
            kickRepository = kickRepository,
            channelId = cid,
            livestreamId = lid,
            channelLogin = login,
            trustManager = trustManager,
            debugLogging = debugLogging,
            rewardsRepository = rewardsRepository,
        ).also { job = it.start(scope) }
    }

    fun stop() {
        val w = watch ?: run {
            job?.cancel()
            job = null
            return
        }
        watch = null
        job?.cancel()
        job = null
        scope.launch { w.stop() }
    }

    fun onRewardsToggle(enabled: Boolean) {
        if (enabled) {
            if (isPlaying()) startIfNeeded()
        } else {
            stop()
        }
    }

    fun release() {
        job?.cancel()
        job = null
        watch = null
        scope.cancel()
    }
}
