package com.github.andreyasadchy.xtra.ui.player

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.util.Log
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.core.content.edit
import androidx.core.view.isVisible
import androidx.media3.common.util.UnstableApi
import com.amazonaws.ivs.player.Cue
import com.amazonaws.ivs.player.Player
import com.amazonaws.ivs.player.PlayerException
import com.amazonaws.ivs.player.Quality
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.ui.Clip
import com.github.andreyasadchy.xtra.model.ui.OfflineVideo
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.model.ui.Video
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.util.C
import java.util.Locale

@OptIn(UnstableApi::class)
class IvsPlayerFragment : PlayerFragment() {

    private var player: Player? = null
    private var playerListener: Player.Listener? = null
    private var surfaceHolderCallback: SurfaceHolder.Callback? = null
    private var surfaceCreated = false
    private val updateProgressAction = Runnable { if (view != null) updateProgress() }
    private val qualitiesByKey = linkedMapOf<String, Quality>()
    private var currentUrl: String? = null
    private var fallbackTriggered = false

    override fun onStart() {
        super.onStart()
        val callback = object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                surfaceCreated = true
                player?.setSurface(holder.surface)
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) = Unit

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                surfaceCreated = false
                player?.setSurface(null)
            }
        }
        binding.playerSurface.holder.addCallback(callback)
        surfaceHolderCallback = callback
        if (binding.playerSurface.holder.surface?.isValid == true) {
            surfaceCreated = true
        }
        if (player == null) {
            createPlayer()
        } else if (surfaceCreated) {
            player?.setSurface(binding.playerSurface.holder.surface)
        }
    }

    override fun initialize() {
        if (player != null && !viewModel.started) {
            startPlayer()
        }
        super.initialize()
    }

    private fun createPlayer() {
        val ivsPlayer = Player.Factory.create(requireContext()).apply {
            setLogLevel(Player.LogLevel.ERROR)
            setLiveLowLatencyEnabled(true)
            setRebufferToLive(true)
        }
        val listener = object : Player.Listener() {
            override fun onCue(cue: Cue) = Unit

            override fun onDurationChanged(duration: Long) {
                binding.playerControls.progressBar.setDuration(duration.coerceAtLeast(0L))
                updateProgress()
            }

            override fun onStateChanged(state: Player.State) {
                binding.bufferingIndicator.isVisible = state == Player.State.BUFFERING
                if (state == Player.State.READY || state == Player.State.PLAYING) {
                    populateQualities()
                }
                updatePlayingState()
            }

            override fun onError(exception: PlayerException) {
                Log.w(
                    TAG,
                    "IVS playback error code=${exception.code} type=${exception.errorType} source=${exception.source} session=${player?.sessionId}: ${exception.errorMessage}"
                )
                fallbackToStandardPlayer(showMessage = true)
            }

            override fun onRebuffering() {
                binding.bufferingIndicator.isVisible = true
            }

            override fun onSeekCompleted(position: Long) {
                updateProgress()
            }

            override fun onVideoSizeChanged(width: Int, height: Int) = Unit

            override fun onQualityChanged(quality: Quality) {
                if (player?.isAutoQualityMode == false) {
                    val key = qualitiesByKey.entries.find { it.value == quality }?.key
                    if (key != null) {
                        viewModel.quality = key
                        setQualityText()
                    }
                }
            }
        }
        ivsPlayer.addListener(listener)
        if (surfaceCreated) {
            ivsPlayer.setSurface(binding.playerSurface.holder.surface)
        }
        player = ivsPlayer
        playerListener = listener
        updatePlayingState()
    }

    private fun updatePlayingState() {
        val state = player?.state ?: Player.State.IDLE
        val isPlaying = state == Player.State.PLAYING
        with(binding.playerControls) {
            if (isPlaying) {
                playPause.setImageResource(R.drawable.baseline_pause_black_48)
                if (videoType == STREAM && !prefs.getBoolean(C.PLAYER_PAUSE, false)) {
                    playPause.visibility = View.GONE
                } else {
                    playPause.visibility = View.VISIBLE
                }
            } else {
                playPause.setImageResource(R.drawable.baseline_play_arrow_black_48)
                playPause.visibility = View.VISIBLE
            }
            val duration = player?.duration?.takeIf { it > 0 } ?: 0L
            progressBar.setDuration(duration)
        }
        setPipActions(isPlaying)
        controllerAutoHide = isPlaying
        updateProgress()
        if (videoType != STREAM && useController) {
            showController()
        }
    }

    private fun populateQualities() {
        val ivsPlayer = player ?: return
        val availableQualities = ivsPlayer.qualities
            .sortedWith(compareByDescending<Quality> { it.height }.thenByDescending { it.framerate }.thenByDescending { it.bitrate })
        qualitiesByKey.clear()
        val map = linkedMapOf<String, Pair<String, String?>>()
        map[AUTO_QUALITY] = getString(R.string.auto) to null
        availableQualities.forEach { quality ->
            val baseKey = KickLivePlayback.qualityKey(quality)
            val key = generateSequence(baseKey) { "$it+" }.first { !qualitiesByKey.containsKey(it) }
            qualitiesByKey[key] = quality
            map[key] = KickLivePlayback.qualityLabel(quality) to null
        }
        if (map != viewModel.qualities) {
            viewModel.qualities = map
            setDefaultQuality()
            changePlayerMode()
            changeQuality(viewModel.quality)
        }
    }

    override fun startStream(url: String?) {
        val ivsPlayer = player ?: return
        val resolvedUrl = url?.takeIf { it.isNotBlank() } ?: return
        fallbackTriggered = false
        currentUrl = resolvedUrl
        requireArguments().putString(KEY_RESOLVED_STREAM_URL, resolvedUrl)
        viewModel.playlistUrl = null
        binding.playerSurface.visibility = View.VISIBLE
        binding.playerControls.progressBar.setDuration(0L)
        binding.playerControls.duration.text = null
        binding.playerControls.position.text = null
        ivsPlayer.setLiveLowLatencyEnabled(true)
        ivsPlayer.setRebufferToLive(true)
        ivsPlayer.setVolume(prefs.getInt(C.PLAYER_VOLUME, 100) / 100f)
        ivsPlayer.load(Uri.parse(resolvedUrl))
        ivsPlayer.play()
        updatePlayingState()
    }

    override fun getCurrentPosition(): Long? = player?.position

    override fun getCurrentSpeed(): Float? = player?.playbackRate

    override fun getCurrentVolume(): Float? = player?.volume

    override fun playPause() {
        when (player?.state) {
            Player.State.PLAYING -> player?.pause()
            Player.State.READY,
            Player.State.IDLE,
            Player.State.ENDED -> player?.play()
            else -> Unit
        }
        updatePlayingState()
    }

    override fun seek(position: Long) {
        player?.seekTo(position)
    }

    override fun seekToLivePosition() {
        val ivsPlayer = player ?: return
        ivsPlayer.setRebufferToLive(true)
        val duration = ivsPlayer.duration
        if (duration > 0L) {
            ivsPlayer.seekTo(duration)
        } else {
            currentUrl?.let { ivsPlayer.load(Uri.parse(it)) }
            ivsPlayer.play()
        }
    }

    override fun setPlaybackSpeed(speed: Float) {
        player?.setPlaybackRate(speed)
    }

    override fun changeVolume(volume: Float) {
        player?.setVolume(volume)
        prefs.edit { putInt(C.PLAYER_VOLUME, (volume * 100f).toInt()) }
    }

    override fun updateProgress() {
        with(binding.playerControls) {
            if (root.isVisible && !progressBar.isPressed) {
                val currentPosition = player?.position ?: 0L
                progressBar.setPosition(currentPosition)
                progressBar.setBufferedPosition(player?.bufferedPosition ?: 0L)
                position.text = if (currentPosition > 0L) {
                    android.text.format.DateUtils.formatElapsedTime(currentPosition / 1000)
                } else {
                    null
                }
                updateLatency(player?.liveLatency?.takeIf { it > 0L })
                root.removeCallbacks(updateProgressAction)
                if (player?.state == Player.State.PLAYING || player?.state == Player.State.BUFFERING) {
                    root.postDelayed(updateProgressAction, 500L)
                }
            }
        }
    }

    override fun changeQuality(selectedQuality: String?) {
        viewModel.previousQuality = viewModel.quality
        viewModel.quality = selectedQuality
        val ivsPlayer = player ?: return
        when (selectedQuality) {
            AUTO_QUALITY -> ivsPlayer.setAutoQualityMode(true)
            else -> qualitiesByKey[selectedQuality]?.let { quality ->
                ivsPlayer.setAutoQualityMode(false)
                ivsPlayer.setQuality(quality)
            }
        }
        persistSelectedQuality(selectedQuality)
        setQualityText()
    }

    private fun persistSelectedQuality(selectedQuality: String?) {
        val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        val cellular = networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true
        val defaultQualityPref = if (cellular) C.PLAYER_DEFAULT_CELLULAR_QUALITY else C.PLAYER_DEFAULTQUALITY
        if (prefs.getString(defaultQualityPref, "saved") == "saved") {
            prefs.edit { putString(C.PLAYER_QUALITY, selectedQuality) }
        }
    }

    override fun startAudioOnly() {
        binding.playerSurface.visibility = View.GONE
        showController(true)
    }

    override fun downloadVideo() {
        Toast.makeText(requireContext(), R.string.ivs_feature_not_supported, Toast.LENGTH_SHORT).show()
    }

    override fun setSubtitlesButton() {
        binding.playerControls.subtitles.visibility = View.GONE
    }

    override fun showPlaylistTags(mediaPlaylist: Boolean) {
        Toast.makeText(requireContext(), R.string.ivs_feature_not_supported, Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        binding.playerControls.root.removeCallbacks(updateProgressAction)
    }

    override fun onDestroyView() {
        binding.playerControls.root.removeCallbacks(updateProgressAction)
        surfaceHolderCallback?.let { binding.playerSurface.holder.removeCallback(it) }
        surfaceHolderCallback = null
        releasePlayer()
        super.onDestroyView()
    }

    override fun onNetworkRestored() {
        if (isResumed && videoType == STREAM && currentUrl != null) {
            startStream(currentUrl)
        }
    }

    override fun onNetworkLost() {
        if (videoType == STREAM && isResumed) {
            player?.pause()
            updatePlayingState()
        }
    }

    private fun fallbackToStandardPlayer(showMessage: Boolean) {
        if (fallbackTriggered || !isAdded) {
            return
        }
        fallbackTriggered = true
        if (showMessage) {
            Toast.makeText(requireContext(), R.string.ivs_fallback_to_standard_player, Toast.LENGTH_SHORT).show()
        }
        (activity as? MainActivity)?.startStream(
            stream = getCurrentStream(),
            resolvedUrl = currentUrl ?: requireArguments().getString(KEY_RESOLVED_STREAM_URL),
            forceStandardLiveEngine = true
        )
    }

    private fun releasePlayer() {
        playerListener?.let { listener ->
            player?.removeListener(listener)
        }
        playerListener = null
        player?.release()
        player = null
    }

    companion object {
        private const val TAG = "IvsPlayerFragment"

        fun newInstance(item: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): IvsPlayerFragment {
            return IvsPlayerFragment().apply {
                arguments = getStreamArguments(item, resolvedUrl, forceStandardLiveEngine)
            }
        }

        private fun Float.formatMbps(): String = String.format(Locale.US, "%.1f", this)
    }
}
