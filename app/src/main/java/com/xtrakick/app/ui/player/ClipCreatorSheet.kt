package com.xtrakick.app.ui.player

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.text.format.DateUtils
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.SeekParameters
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.R
import com.xtrakick.app.databinding.SheetClipCreatorBinding
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickClipApi
import com.xtrakick.app.util.bundleOf
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * Official-app-style clip editor: opens immediately with responsive loading feedback,
 * features a single unified timeline, and supports fast keyframe-accurate scrubbing,
 * audio mute control, and draggable Start/End markers.
 */
@androidx.annotation.OptIn(UnstableApi::class)
class ClipCreatorSheet : BottomSheetDialogFragment() {

    companion object {
        private const val KEY_CHANNEL_LOGIN = "channelLogin"
        private const val KEY_VOD_ID = "vodId"
        private const val KEY_POSITION_SECONDS = "positionSeconds"
        const val TAG = "clipCreator"

        fun newInstance(
            channelLogin: String,
            vodId: String? = null,
            positionSeconds: Long? = null,
        ): ClipCreatorSheet {
            return ClipCreatorSheet().apply {
                arguments = bundleOf(
                    KEY_CHANNEL_LOGIN to channelLogin,
                    KEY_VOD_ID to vodId,
                    KEY_POSITION_SECONDS to (positionSeconds ?: -1L),
                )
            }
        }
    }

    private var _binding: SheetClipCreatorBinding? = null
    private val binding get() = _binding!!
    private var previewPlayer: ExoPlayer? = null

    private var channelLogin: String = ""
    private var clipId: String? = null
    private var sourceDuration = KickClipApi.CLIP_DEFAULT_LENGTH_SECONDS
    private var previousLow = 0f
    private var previousHigh = 0f
    private var isUserScrubbing = false
    private var isMuted = false
    private var isLoopSeeking = false
    private var shouldResumeLiveStreamOnDismiss = true
    private var lastSeekTimestamp = 0L

    private val progressPoller = object : Runnable {
        override fun run() {
            val player = previewPlayer ?: return
            val b = _binding ?: return
            if (player.playWhenReady) {
                if (player.playbackState == Player.STATE_READY) {
                    val currentPosSec = player.currentPosition / 1000f
                    if (!isUserScrubbing) {
                        updateScrubberUi(currentPosSec)
                    }
                    if (!isLoopSeeking && currentPosSec >= previousHigh - 0.15f) {
                        isLoopSeeking = true
                        player.seekTo((previousLow * 1000L).toLong())
                    }
                }
                b.root.postDelayed(this, 40L)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SheetClipCreatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        binding.clipCloseButton.setOnClickListener { dismiss() }
        binding.clipCancelButton.setOnClickListener { dismiss() }

        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN).orEmpty()
        initiateClip(channelLogin)
    }

    private fun initiateClip(channelLogin: String) {
        binding.clipLoadingContainer.visibility = View.VISIBLE
        binding.clipContentContainer.visibility = View.GONE

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val parent = parentFragment as? PlayerFragment
                val vm = parent?.getPlayerViewModel()
                if (vm == null) {
                    dismiss()
                    return@launch
                }

                val directVodId = requireArguments().getString(KEY_VOD_ID)?.takeIf { it.isNotBlank() }
                val positionSeconds = requireArguments().getLong(KEY_POSITION_SECONDS, -1L).takeIf { it >= 0L }

                val vodId = if (directVodId != null) {
                    vm.resolveVodId(channelLogin, directVodId, directVodId) ?: directVodId
                } else {
                    vm.getLivestreamVodId(channelLogin)
                }

                if (vodId.isNullOrBlank()) {
                    DiagnosticLogger.w("ClipCreatorSheet", "No vod_id found (direct=$directVodId, channel=$channelLogin)")
                    Toast.makeText(requireContext(), R.string.clip_creation_vod_unavailable, Toast.LENGTH_LONG).show()
                    dismiss()
                    return@launch
                }

                DiagnosticLogger.i("ClipCreatorSheet", "Initiating clip for vodId: $vodId at pos: $positionSeconds")
                val temporaryClip = vm.initiateKickClip(vodId, positionSeconds)
                val previewUrl = temporaryClip.previewUrl?.takeIf { it.isNotBlank() }
                if (previewUrl == null) {
                    DiagnosticLogger.w("ClipCreatorSheet", "Clip initiate returned no preview_url")
                    Toast.makeText(requireContext(), R.string.clip_creation_failed, Toast.LENGTH_LONG).show()
                    dismiss()
                    return@launch
                }

                clipId = temporaryClip.id
                sourceDuration = (temporaryClip.sourceDurationSeconds ?: KickClipApi.CLIP_DEFAULT_LENGTH_SECONDS)
                    .coerceAtLeast(KickClipApi.CLIP_MIN_LENGTH_SECONDS)

                val (defaultStart, defaultDuration) = KickClipApi.computeClipRange(
                    sourceDuration,
                    KickClipApi.CLIP_DEFAULT_LENGTH_SECONDS,
                )
                previousLow = defaultStart.toFloat()
                previousHigh = (defaultStart + defaultDuration).toFloat().coerceAtMost(sourceDuration.toFloat())

                setupEditorUi(previewUrl)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                DiagnosticLogger.w("ClipCreatorSheet", "Clip initiate failed: ${e.message}")
                if (isAdded) {
                    Toast.makeText(requireContext(), R.string.clip_creation_failed, Toast.LENGTH_LONG).show()
                    dismiss()
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupEditorUi(previewUrl: String) {
        val b = _binding ?: return
        b.clipLoadingContainer.visibility = View.GONE
        b.clipPreviewCard.visibility = View.VISIBLE
        b.clipContentContainer.visibility = View.VISIBLE
        b.clipSuccessContainer.visibility = View.GONE

        val maxDurationFloat = sourceDuration.toFloat()
        b.clipTotalTime.text = "/ " + DateUtils.formatElapsedTime(sourceDuration.toLong())
        b.clipCurrentTime.text = DateUtils.formatElapsedTime(previousLow.toLong())

        // 1. Unified Timeline Setup
        with(b.clipTimeline) {
            maxDurationSeconds = maxDurationFloat
            startSeconds = previousLow
            endSeconds = previousHigh
            playheadSeconds = previousLow

            onRangeChanged = { start, end, fromUser ->
                previousLow = start
                previousHigh = end
                isLoopSeeking = false
                updateRangeLabel()
                if (fromUser) {
                    val target = if (playheadSeconds == start) start else end
                    performThrottledSeek((target * 1000L).toLong(), isFinal = true)
                    b.clipCurrentTime.text = DateUtils.formatElapsedTime(target.toLong())
                }
            }

            onPlayheadScrubbing = { position ->
                isUserScrubbing = true
                performThrottledSeek((position * 1000L).toLong(), isFinal = false)
                b.clipCurrentTime.text = DateUtils.formatElapsedTime(position.toLong())
            }

            onPlayheadScrubFinished = { position ->
                isUserScrubbing = false
                performThrottledSeek((position * 1000L).toLong(), isFinal = true)
            }
        }
        updateRangeLabel()

        // 2. Quick Marker Buttons
        b.clipSetStartButton.setOnClickListener {
            val currentSec = ((previewPlayer?.currentPosition ?: 0L) / 1000f).coerceIn(0f, maxDurationFloat)
            val (newLow, newHigh) = clampClipRange(currentSec, previousHigh, maxDurationFloat)
            previousLow = newLow
            previousHigh = newHigh
            isLoopSeeking = false
            b.clipTimeline.startSeconds = previousLow
            b.clipTimeline.endSeconds = previousHigh
            updateRangeLabel()
        }

        b.clipSetEndButton.setOnClickListener {
            val currentSec = ((previewPlayer?.currentPosition ?: 0L) / 1000f).coerceIn(0f, maxDurationFloat)
            val (newLow, newHigh) = clampClipRange(previousLow, currentSec, maxDurationFloat)
            previousLow = newLow
            previousHigh = newHigh
            isLoopSeeking = false
            b.clipTimeline.startSeconds = previousLow
            b.clipTimeline.endSeconds = previousHigh
            updateRangeLabel()
        }

        // 3. Play/Pause Controls
        b.clipPlayPauseButton.setOnClickListener { togglePlayPause() }
        b.clipCenterPlayPause.setOnClickListener { togglePlayPause() }

        // 4. Mute / Unmute Button
        b.clipMuteButton.setOnClickListener { toggleMute() }

        // 5. Video Preview Gesture Listener
        var isHorizontalDrag = false
        val gestureDetector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean = true

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                togglePlayPause()
                return true
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
                if (abs(distanceX) > abs(distanceY)) {
                    val player = previewPlayer ?: return false
                    isHorizontalDrag = true
                    isUserScrubbing = true
                    val deltaSec = -distanceX / 15f
                    val currentSec = player.currentPosition / 1000f
                    val targetSec = (currentSec + deltaSec).coerceIn(0f, maxDurationFloat)
                    performThrottledSeek((targetSec * 1000L).toLong(), isFinal = false)
                    updateScrubberUi(targetSec)
                    return true
                }
                return false
            }
        })
        b.clipPreview.setOnTouchListener { _, event ->
            val handled = gestureDetector.onTouchEvent(event)
            if (event.actionMasked == MotionEvent.ACTION_UP || event.actionMasked == MotionEvent.ACTION_CANCEL) {
                if (isHorizontalDrag) {
                    isHorizontalDrag = false
                    isUserScrubbing = false
                    val player = previewPlayer
                    if (player != null) {
                        performThrottledSeek(player.currentPosition, isFinal = true)
                    }
                }
            }
            handled || true
        }

        b.clipSaveButton.setOnClickListener { saveClip() }
        b.clipTitleInput.doAfterTextChanged { b.clipTitleLayout.error = null }

        // 6. Responsive ExoPlayer Configuration
        val loadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                /* minBufferMs = */ 10_000,
                /* maxBufferMs = */ 40_000,
                /* bufferForPlaybackMs = */ 200,
                /* bufferForPlaybackAfterRebufferMs = */ 400,
            )
            .build()

        previewPlayer = ExoPlayer.Builder(requireContext())
            .setLoadControl(loadControl)
            .setSeekParameters(SeekParameters.CLOSEST_SYNC)
            .build().apply {
                b.clipPreview.player = this
                addListener(object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        val curB = _binding ?: return
                        val isBuffering = (playbackState == Player.STATE_BUFFERING)
                        curB.clipBufferingIndicator.isVisible = isBuffering
                        if (isBuffering && playWhenReady) {
                            curB.clipCenterPlayPause.visibility = View.GONE
                        }
                        if (playbackState == Player.STATE_ENDED) {
                            seekTo((previousLow * 1000L).toLong())
                            playWhenReady = true
                        }
                    }

                    override fun onPositionDiscontinuity(
                        oldPosition: Player.PositionInfo,
                        newPosition: Player.PositionInfo,
                        reason: Int,
                    ) {
                        if (reason == Player.DISCONTINUITY_REASON_SEEK) {
                            isLoopSeeking = false
                        }
                    }

                    override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                        updatePlayPauseUi(playWhenReady)
                    }
                })
                setMediaItem(MediaItem.fromUri(previewUrl))
                seekTo((previousLow * 1000L).toLong())
                prepare()
                playWhenReady = true
                updatePlayPauseUi(true)
            }
    }

    private fun updatePlayPauseUi(playWhenReady: Boolean) {
        val curB = _binding ?: return
        val iconRes = if (playWhenReady) R.drawable.baseline_pause_black_48 else R.drawable.baseline_play_arrow_black_48
        val contentDesc = getString(if (playWhenReady) R.string.pause else R.string.play)

        curB.clipPlayPauseButton.setImageResource(iconRes)
        curB.clipPlayPauseButton.contentDescription = contentDesc
        curB.clipSuccessPlayPause.setImageResource(iconRes)
        curB.clipSuccessPlayPause.contentDescription = contentDesc

        curB.root.removeCallbacks(progressPoller)
        if (playWhenReady) {
            curB.clipCenterPlayPause.animate().cancel()
            curB.clipCenterPlayPause.animate()
                .scaleX(1.15f)
                .scaleY(1.15f)
                .alpha(0f)
                .setDuration(120L)
                .setInterpolator(DecelerateInterpolator())
                .withEndAction {
                    curB.clipCenterPlayPause.visibility = View.GONE
                    curB.clipCenterPlayPause.scaleX = 1f
                    curB.clipCenterPlayPause.scaleY = 1f
                }
                .start()
            curB.root.post(progressPoller)
        } else {
            curB.clipCenterPlayPause.animate().cancel()
            curB.clipCenterPlayPause.visibility = View.VISIBLE
            curB.clipCenterPlayPause.scaleX = 0.85f
            curB.clipCenterPlayPause.scaleY = 0.85f
            curB.clipCenterPlayPause.alpha = 0f
            curB.clipCenterPlayPause.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(140L)
                .setInterpolator(DecelerateInterpolator())
                .start()
            previewPlayer?.let { updateScrubberUi(it.currentPosition / 1000f) }
        }
    }

    private fun performThrottledSeek(positionMs: Long, isFinal: Boolean) {
        val now = SystemClock.uptimeMillis()
        if (isFinal || now - lastSeekTimestamp >= 75L) {
            lastSeekTimestamp = now
            previewPlayer?.seekTo(positionMs)
        }
    }

    private fun updateScrubberUi(positionSec: Float) {
        val b = _binding ?: return
        val clamped = positionSec.coerceIn(0f, sourceDuration.toFloat())
        b.clipTimeline.playheadSeconds = clamped
        b.clipCurrentTime.text = DateUtils.formatElapsedTime(clamped.toLong())

        if (b.clipSuccessContainer.isVisible) {
            val clipDuration = (previousHigh - previousLow).coerceAtLeast(1f)
            val relativeSec = (positionSec - previousLow).coerceIn(0f, clipDuration)
            b.clipSuccessCurrentTime.text = DateUtils.formatElapsedTime(relativeSec.toLong())
            b.clipSuccessTotalTime.text = DateUtils.formatElapsedTime(clipDuration.toLong())
            if (!isUserScrubbing) {
                b.clipSuccessSeekBar.progress = ((relativeSec / clipDuration) * 1000).toInt()
            }
        }
    }

    private fun togglePlayPause() {
        val player = previewPlayer ?: return
        if (player.playWhenReady) {
            player.pause()
        } else {
            val currentSec = player.currentPosition / 1000f
            if (currentSec >= previousHigh - 0.25f) {
                player.seekTo((previousLow * 1000L).toLong())
                updateScrubberUi(previousLow)
            }
            player.play()
        }
    }

    private fun toggleMute() {
        val player = previewPlayer ?: return
        isMuted = !isMuted
        player.volume = if (isMuted) 0f else 1f
        val b = _binding ?: return
        if (isMuted) {
            b.clipMuteButton.setImageResource(R.drawable.ic_volume_off)
            b.clipMuteButton.contentDescription = getString(R.string.unmute)
        } else {
            b.clipMuteButton.setImageResource(R.drawable.ic_volume_high)
            b.clipMuteButton.contentDescription = getString(R.string.mute)
        }
    }

    private fun updateRangeLabel() {
        val low = previousLow.roundToInt()
        val high = previousHigh.roundToInt()
        binding.clipRangeLabel.text = getString(
            R.string.clip_range_label,
            DateUtils.formatElapsedTime(low.toLong()),
            DateUtils.formatElapsedTime(high.toLong()),
            high - low,
        )
    }

    private fun clampClipRange(low: Float, high: Float, maxDuration: Float): Pair<Float, Float> {
        var l = low
        var h = high
        if (h - l < KickClipApi.CLIP_MIN_LENGTH_SECONDS) {
            h = (l + KickClipApi.CLIP_MIN_LENGTH_SECONDS).coerceAtMost(maxDuration)
            if (h - l < KickClipApi.CLIP_MIN_LENGTH_SECONDS) {
                l = (h - KickClipApi.CLIP_MIN_LENGTH_SECONDS).coerceAtLeast(0f)
            }
        }
        if (h - l > KickClipApi.CLIP_MAX_LENGTH_SECONDS) {
            h = (l + KickClipApi.CLIP_MAX_LENGTH_SECONDS).coerceAtMost(maxDuration)
        }
        return l to h
    }

    private fun saveClip() {
        val b = _binding ?: return
        val id = clipId ?: return
        val rawTitle = b.clipTitleInput.text?.toString()?.trim().orEmpty()
        if (rawTitle.isEmpty()) {
            b.clipTitleLayout.error = getString(R.string.clip_title_required)
            b.clipTitleInput.requestFocus()
            return
        }
        b.clipTitleLayout.error = null
        var duration = kotlin.math.ceil((previousHigh - previousLow).toDouble()).toInt()
            .coerceIn(KickClipApi.CLIP_MIN_LENGTH_SECONDS, KickClipApi.CLIP_MAX_LENGTH_SECONDS)
            .coerceAtMost(sourceDuration)
        var start = kotlin.math.floor(previousLow.toDouble()).toInt().coerceIn(0, sourceDuration)
        if (start + duration > sourceDuration) {
            start = maxOf(0, sourceDuration - duration)
        }
        val title = KickClipApi.clampTitle(rawTitle)
        b.clipSaveProgress.isVisible = true
        b.clipSaveButton.isEnabled = false
        b.clipCancelButton.isEnabled = false
        (parentFragment as? PlayerFragment)?.saveClip(
            clipId = id,
            title = title,
            startSeconds = start,
            durationSeconds = duration,
            channelLogin = channelLogin,
        ) { finalized ->
            val curBinding = _binding ?: return@saveClip
            curBinding.clipSaveProgress.isVisible = false
            if (finalized != null) {
                showSuccessScreen(finalized, start, duration)
            } else {
                Toast.makeText(requireContext(), R.string.clip_creation_failed, Toast.LENGTH_LONG).show()
                curBinding.clipSaveButton.isEnabled = true
                curBinding.clipCancelButton.isEnabled = true
            }
        }
    }

    private fun showSuccessScreen(finalized: KickClipApi.FinalizedClip, start: Int, duration: Int) {
        val b = _binding ?: return

        // 1. Confine preview player to loop only the cut clip
        previousLow = start.toFloat()
        previousHigh = (start + duration).toFloat()
        isLoopSeeking = false
        previewPlayer?.seekTo((previousLow * 1000L).toLong())
        previewPlayer?.playWhenReady = true

        // 2. Transition views
        b.clipHeaderTitle.text = getString(R.string.clip_created)
        b.clipContentContainer.visibility = View.GONE
        b.clipSuccessContainer.visibility = View.VISIBLE

        // 3. Populate clip details
        b.clipSuccessTitle.text = finalized.title
        b.clipSuccessSubtitle.text = getString(
            R.string.clip_created_subtitle,
            channelLogin,
            duration,
        )
        b.clipSuccessCurrentTime.text = DateUtils.formatElapsedTime(0L)
        b.clipSuccessTotalTime.text = DateUtils.formatElapsedTime(duration.toLong())
        b.clipSuccessSeekBar.progress = 0

        // 4. Wire Scrubber & Controls
        b.clipSuccessPlayPause.setOnClickListener { togglePlayPause() }
        b.clipSuccessSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val clipDuration = (previousHigh - previousLow).coerceAtLeast(1f)
                    val relativeSec = (progress / 1000f) * clipDuration
                    val targetSec = previousLow + relativeSec
                    b.clipSuccessCurrentTime.text = DateUtils.formatElapsedTime(relativeSec.toLong())
                    performThrottledSeek((targetSec * 1000L).toLong(), isFinal = false)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                isUserScrubbing = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val clipDuration = (previousHigh - previousLow).coerceAtLeast(1f)
                val relativeSec = ((seekBar?.progress ?: 0) / 1000f) * clipDuration
                val targetSec = previousLow + relativeSec
                performThrottledSeek((targetSec * 1000L).toLong(), isFinal = true)
                isUserScrubbing = false
                previewPlayer?.play()
            }
        })

        // 5. Wire Action Buttons
        b.clipCopyButton.setOnClickListener {
            val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
            val clipData = ClipData.newPlainText("Kick Clip", finalized.clipUrl)
            clipboard?.setPrimaryClip(clipData)
            Toast.makeText(requireContext(), R.string.link_copied_to_clipboard, Toast.LENGTH_SHORT).show()
        }

        b.clipShareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, finalized.title)
                putExtra(Intent.EXTRA_TEXT, "${finalized.title} - ${finalized.clipUrl}")
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_clip)))
        }

        b.clipWatchButton.setOnClickListener {
            shouldResumeLiveStreamOnDismiss = false
            dismiss()
            (parentFragment as? PlayerFragment)?.openCreatedClip(finalized.id)
        }
    }

    override fun onPause() {
        super.onPause()
        previewPlayer?.playWhenReady = false
    }

    override fun onDismiss(dialog: android.content.DialogInterface) {
        super.onDismiss(dialog)
        if (shouldResumeLiveStreamOnDismiss) {
            (parentFragment as? PlayerFragment)?.resumePlaybackAfterOverlay()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.root?.removeCallbacks(progressPoller)
        previewPlayer?.release()
        previewPlayer = null
        _binding = null
    }
}
