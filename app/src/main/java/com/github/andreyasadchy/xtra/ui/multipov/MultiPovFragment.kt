package com.github.andreyasadchy.xtra.ui.multipov

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.PictureInPictureParams
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.os.SystemClock
import android.util.Rational
import android.util.TypedValue
import android.view.GestureDetector
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.graphics.Color
import android.text.TextUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.OptIn
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import com.github.andreyasadchy.xtra.util.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.databinding.FragmentMultipovBinding
import com.github.andreyasadchy.xtra.databinding.ItemMultipovTileBinding
import com.github.andreyasadchy.xtra.databinding.PlayerLayoutBinding
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.ui.chat.ChatFragment
import com.github.andreyasadchy.xtra.ui.main.MainActivity
import com.github.andreyasadchy.xtra.ui.player.PlayerVolumeDialog
import com.github.andreyasadchy.xtra.ui.player.VideoZoomController
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.NetworkMonitor
import com.github.andreyasadchy.xtra.util.prefs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.roundToInt

@OptIn(UnstableApi::class)
@AndroidEntryPoint
class MultiPovFragment : Fragment(), MultiPovStreamPickerDialog.Listener {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private var _binding: FragmentMultipovBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MultiPovViewModel by viewModels()

    private var playbackController: MultiPovPlaybackController? = null
    private val tileBindings = linkedMapOf<String, ItemMultipovTileBinding>()
    private var currentChatKey: String? = null
    /** Slot keys + layout/orientation signature used to decide when to rebuild the grid. */
    private var lastGridSignature: List<String> = emptyList()
    private var isPortrait = true
    private var isChatOpen = true
    var isMaximized = true
        private set
    private var thermalStatusListener: PowerManager.OnThermalStatusChangedListener? = null
    private var gestureDetector: GestureDetector? = null
    /** Same pinch/pan zoom as the solo player ([VideoZoomController]). */
    private var videoZoom: VideoZoomController? = null
    private var touchSlop: Int = 0
    /** Blocks long-press menu after pinch/pan (GestureDetector would still fire otherwise). */
    private var suppressTileMenu = false

    // Landscape chat scrub — same interaction model as PlayerFragment.
    private var chatWidthLandscape = 0
    private var chatOpenProgress = 1f
    private var chatDragActive = false
    private var chatDragCandidate = false
    private var chatDragStartX = 0f
    private var chatDragStartY = 0f
    private var chatDragStartProgress = 0f
    private var chatProgressAnimator: ValueAnimator? = null
    private var velocityTracker: VelocityTracker? = null
    private var latencyPollJob: Job? = null
    private var backgroundPauseRunnable: Runnable? = null
    private val backgroundGraceMs = 20_000L

    /**
     * When set, only this stream fills the video area (in-MultiPOV fullscreen).
     * Other players are released while immersive to free decoders/bandwidth.
     */
    private var immersiveKey: String? = null

    /** Brief green focus ring after focus change — not a permanent overlay. */
    private var focusFlashKey: String? = null
    private var lastFocusFlashForKey: String? = null

    private val hideControlsRunnable = Runnable {
        if (isAdded && isMaximized && !isInPipMode()) {
            viewModel.setControlsVisible(false)
        }
    }

    private val hideFocusBorderRunnable = Runnable {
        if (!isAdded) return@Runnable
        focusFlashKey = null
        tileBindings.forEach { (_, tile) ->
            tile.focusBorder.isVisible = false
        }
    }

    private val backCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            when {
                !isMaximized -> maximize()
                immersiveKey != null -> exitImmersive()
                videoZoom?.isZoomed() == true -> resetVideoZoom()
                viewModel.uiState.value.isControlsVisible -> {
                    viewModel.setControlsVisible(false)
                    cancelHideControls()
                }
                else -> confirmClose()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val streams = readStreamsArg()
        val keys = requireArguments().getStringArrayList(ARG_RESOLVED_KEYS).orEmpty()
        val values = requireArguments().getStringArrayList(ARG_RESOLVED_VALUES).orEmpty()
        val resolved = keys.zip(values).toMap()
        val focused = requireArguments().getString(ARG_FOCUSED_KEY)
        val prefs = requireContext().prefs()
        viewModel.initialize(
            streams = streams,
            resolvedUrls = resolved,
            focusedKey = focused,
            streamQuality = MultiPovQuality.fromPrefs(prefs),
            bandwidthSaving = prefs.getBoolean(C.MULTIPOV_BANDWIDTH_SAVING, false),
            maxStreams = prefs.getInt(C.MULTIPOV_MAX_STREAMS, C.MULTIPOV_MAX_STREAMS_DEFAULT)
                .coerceIn(2, C.MULTIPOV_MAX_STREAMS_DEFAULT),
            prefs = prefs,
        )
    }

    @Suppress("DEPRECATION")
    private fun readStreamsArg(): List<Stream> {
        val args = requireArguments()
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            args.getParcelableArrayList(ARG_STREAMS, Stream::class.java).orEmpty()
        } else {
            args.getParcelableArrayList<Stream>(ARG_STREAMS).orEmpty()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMultipovBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isPortrait = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        val prefs = requireContext().prefs()
        isChatOpen = prefs.getBoolean(C.KEY_CHAT_OPENED, true) && !prefs.getBoolean(C.CHAT_DISABLE, false)
        chatOpenProgress = if (isChatOpen) 1f else 0f
        ensureChatWidthLandscape()
        applyOrientationLayout()
        applySystemBarInsets(view)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backCallback)

        playbackController = MultiPovPlaybackController(
            context = requireContext().applicationContext,
            okHttpClient = okHttpClient,
            prefs = requireContext().prefs(),
            onLoadState = { key, state -> viewModel.updateLoadState(key, state) },
            onHttpError = { key, code, failedUrl ->
                viewModel.onPlaybackHttpError(key, code, failedUrl)
            },
        ).also {
            it.setStreamQuality(viewModel.uiState.value.streamQuality)
            it.setBandwidthSaving(viewModel.uiState.value.bandwidthSaving)
        }
        updateAdaptiveQuality()
        registerAdaptiveMonitors()

        wireMultiPovTools()
        wireFocusedPlayerControls()
        binding.minimizeBadge.setOnClickListener { maximize() }
        binding.multiPovShell.setOnClickListener {
            if (!isMaximized) maximize()
        }
        setupGestures()
        updateFocusedControlsVisibility(show = false)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Use collect (not collectLatest): collectLatest was cancelling render mid-flight
                // when resolve emitted Loading, which re-entered resolveIfNeeded and cancelled
                // URL jobs — playback only started ~60s later via offline poll.
                viewModel.uiState.collect { state ->
                    render(state)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                networkMonitor.networkType.collect {
                    updateAdaptiveQuality()
                }
            }
        }
    }

    /**
     * MultiPOV is drawn edge-to-edge in playerContainer. Push the top control bar below the
     * status bar / cutout so buttons remain visible and tappable.
     */
    private fun applySystemBarInsets(root: View) {
        val baseHorizontal = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics
        ).toInt()
        val baseVertical = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 6f, resources.displayMetrics
        ).toInt()
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, windowInsets ->
            val insets = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            // Session bar under status bar; focused player chrome under that.
            _binding?.multiPovToolsBar?.updatePadding(
                left = baseHorizontal + insets.left,
                top = baseVertical + insets.top,
                right = baseHorizontal + insets.right,
                bottom = baseVertical,
            )
            _binding?.focusedControls?.root?.updatePadding(
                left = insets.left,
                top = 0,
                right = insets.right,
                bottom = insets.bottom,
            )
            // Keep chat clear of nav bar / gesture bar when open.
            _binding?.chatFragmentContainer?.updatePadding(bottom = insets.bottom)
            windowInsets
        }
        ViewCompat.requestApplyInsets(root)
    }

    private fun focusedControls(): PlayerLayoutBinding? = _binding?.focusedControls

    private fun wireMultiPovTools() {
        val binding = _binding ?: return
        // Tap empty scrim area (not a button) to dismiss chrome — same as solo player.
        binding.controlsOverlay.setOnClickListener { toggleControls() }
        binding.closeButton.setOnClickListener { confirmClose() }
        binding.addButton.setOnClickListener {
            showControlsTemporarily()
            openPicker()
        }
        binding.layoutButton.setOnClickListener {
            showControlsTemporarily()
            cycleLayoutPreset()
        }
        binding.layoutButton.setOnLongClickListener {
            showLayoutPickerDialog()
            true
        }
        binding.rotateButton.setOnClickListener {
            showControlsTemporarily()
            rotateStreamOrder()
        }
        binding.removeFocusedButton.setOnClickListener {
            showControlsTemporarily()
            viewModel.uiState.value.focusedKey?.let { removeSlot(it) }
        }
    }

    /** Solo-player control chrome applied to the currently focused MultiPOV stream. */
    private fun wireFocusedPlayerControls() {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        with(controls) {
            // Live MultiPOV — hide VOD-only chrome.
            rewind.isVisible = false
            fastForward.isVisible = false
            position.isVisible = false
            duration.isVisible = false
            bottomLayout.isVisible = false
            progressBar.isVisible = false
            speed.isVisible = false
            download.isVisible = false
            vodGames.isVisible = false
            subtitles.isVisible = false
            audioOnly.isVisible = false
            sleepTimer.isVisible = false
            follow.isVisible = false
            aspectRatio.isVisible = false
            toggleChatInput.isVisible = false

            playPause.isVisible = prefs.getBoolean(C.PLAYER_PAUSE, false)
            playPause.setOnClickListener {
                val key = viewModel.uiState.value.focusedKey
                val playing = playbackController?.togglePlayPause(key) == true
                updatePlayPauseIcon(playing)
                showControlsTemporarily()
            }

            // MultiPOV session bar already has close; keep minimize as solo-style collapse.
            minimize.isVisible = prefs.getBoolean(C.PLAYER_MINIMIZE, true)
            minimize.setOnClickListener { minimize() }

            volume.isVisible = prefs.getBoolean(C.PLAYER_VOLUMEBUTTON, true)
            volume.setOnClickListener {
                showControlsTemporarily()
                showVolumeDialog()
            }

            audioCompressor.isVisible = prefs.getBoolean(C.PLAYER_AUDIO_COMPRESSOR_BUTTON, true)
            audioCompressor.setOnClickListener {
                showControlsTemporarily()
                val key = viewModel.uiState.value.focusedKey
                val enabled = playbackController?.toggleCompressor(key) == true
                updateCompressorIcon(enabled)
            }

            restart.isVisible = prefs.getBoolean(C.PLAYER_RESTART, true)
            restart.setOnClickListener {
                showControlsTemporarily()
                restartFocused()
            }

            seekLive.isVisible = prefs.getBoolean(C.PLAYER_SEEKLIVE, false)
            seekLive.setOnClickListener {
                showControlsTemporarily()
                playbackController?.seekToLive(viewModel.uiState.value.focusedKey)
            }

            quality.isVisible = prefs.getBoolean(C.PLAYER_SETTINGS, true)
            quality.setOnClickListener {
                showControlsTemporarily()
                showStreamQualityDialog()
            }

            menu.isVisible = prefs.getBoolean(C.PLAYER_MENU, true)
            menu.setOnClickListener {
                showControlsTemporarily()
                showFocusedPlayerMenu()
            }

            toggleChat.isVisible = prefs.getBoolean(C.PLAYER_CHATTOGGLE, true) &&
                !prefs.getBoolean(C.CHAT_DISABLE, false)
            toggleChat.setOnClickListener {
                showControlsTemporarily()
                toggleChat()
            }

            fullscreen.isVisible = prefs.getBoolean(C.PLAYER_FULLSCREEN, true)
            fullscreen.setOnClickListener {
                showControlsTemporarily()
                toggleImmersiveForFocused()
            }
            fullscreen.setOnLongClickListener {
                openFocusedSolo()
                true
            }

            viewersLayout.isVisible = true
            viewersLayout.setOnClickListener {
                if (prefs.getBoolean(C.PLAYER_VIEWERLIST, false)) {
                    // Viewer list needs Kick API context — open focused stream solo for now.
                    openFocusedSolo()
                }
            }
        }
    }

    private fun updateFocusedControlsVisibility(show: Boolean) {
        val binding = _binding ?: return
        val overlay = binding.controlsOverlay
        val controls = binding.focusedControls
        if (show && isMaximized && !isInPipMode()) {
            // Stacked overlay — not two competing full-screen layers.
            overlay.isVisible = true
            controls.root.alpha = 1f
            controls.root.isVisible = true
            bindFocusedStreamChrome()
            startLatencyPolling()
        } else {
            overlay.isVisible = false
            controls.root.isVisible = false
            stopLatencyPolling()
        }
    }

    private fun bindFocusedStreamChrome() {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        val focused = viewModel.uiState.value.focusedSlot
        val stream = focused?.stream
        val key = focused?.key

        with(controls) {
            // Focus identity lives on chips; keep title/category/viewers for context.
            channel.isVisible = false
            title.apply {
                val t = stream?.title?.trim()
                if (!t.isNullOrBlank() && prefs.getBoolean(C.PLAYER_TITLE, true)) {
                    text = t
                    isVisible = true
                } else {
                    isVisible = false
                }
            }
            category.apply {
                val game = stream?.gameName
                if (!game.isNullOrBlank() && prefs.getBoolean(C.PLAYER_CATEGORY, true)) {
                    text = game
                    isVisible = true
                } else {
                    isVisible = false
                }
            }
            val viewers = stream?.viewerCount
            if (viewers != null) {
                viewersText.text = KickApiHelper.formatCount(
                    viewers,
                    prefs.getBoolean(C.UI_TRUNCATEVIEWCOUNT, true),
                )
                viewersText.isVisible = true
                viewersIcon.isVisible = prefs.getBoolean(C.PLAYER_VIEWERICON, true)
                viewersLayout.isVisible = true
            } else {
                viewersText.isVisible = false
                viewersIcon.isVisible = false
            }
            // Keep info row if anything in it is showing (viewers/title/category).
            channelRow.isVisible = viewersLayout.isVisible || title.isVisible || category.isVisible
            updatePlayPauseIcon(playbackController?.isPlaying(key) == true)
            updateCompressorIcon(playbackController?.isCompressorEnabled(key) == true)
            updateFullscreenIcon()
            updateChatToggleIcon()
            updateUptime(stream?.startedAt)
            updateLatencyDisplay(playbackController?.getLiveOffsetMs(key))
        }
        val state = viewModel.uiState.value
        // Compact count only — stream names live in chips.
        _binding?.titleText?.text = getString(
            R.string.multipov_stream_count,
            state.slots.size,
            state.maxStreams,
        )
        _binding?.addButton?.isVisible = state.canAdd && immersiveKey == null
        _binding?.layoutButton?.isVisible = immersiveKey == null && state.slots.size >= 2
        _binding?.rotateButton?.isVisible = immersiveKey == null && state.slots.size >= 2
        _binding?.removeFocusedButton?.isVisible = state.slots.size > 1 && immersiveKey == null
        rebuildFocusChips(state)
    }

    /**
     * Pill chips for deliberate focus switching — live in the top bar's flexible center.
     */
    private fun rebuildFocusChips(state: MultiPovUiState) {
        val row = _binding?.focusChipsRow ?: return
        row.removeAllViews()
        if (state.slots.isEmpty() || immersiveKey != null) {
            _binding?.focusChipsScroll?.isVisible = false
            return
        }
        _binding?.focusChipsScroll?.isVisible = true
        val density = resources.displayMetrics.density
        val padH = (12 * density).toInt()
        val padV = (7 * density).toInt()
        val gap = (8 * density).toInt()
        val maxChipWidth = (120 * density).toInt()
        state.slots.forEach { slot ->
            val focused = slot.key == state.focusedKey
            val label = slot.stream.channelName ?: slot.stream.channelLogin.orEmpty()
            val chip = TextView(requireContext()).apply {
                text = label
                setTextColor(if (focused) Color.parseColor("#0A0A0A") else Color.parseColor("#EEFFFFFF"))
                textSize = 13f
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                maxWidth = maxChipWidth
                setPadding(padH, padV, padH, padV)
                background = ContextCompat.getDrawable(
                    requireContext(),
                    if (focused) R.drawable.bg_multipov_chip_selected
                    else R.drawable.bg_multipov_chip,
                )
                if (focused) {
                    val icon = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.baseline_volume_up_black_24,
                    )?.mutate()
                    icon?.setBounds(0, 0, (16 * density).toInt(), (16 * density).toInt())
                    icon?.setTint(Color.parseColor("#0A0A0A"))
                    setCompoundDrawablesRelative(icon, null, null, null)
                    compoundDrawablePadding = (5 * density).toInt()
                } else {
                    setCompoundDrawablesRelative(null, null, null, null)
                }
                contentDescription = if (focused) {
                    getString(R.string.multipov_audio_focus) + ": $label"
                } else {
                    label
                }
                setOnClickListener {
                    if (viewModel.uiState.value.focusedKey != slot.key) {
                        resetVideoZoom()
                        viewModel.setFocus(slot.key)
                    }
                    showControlsTemporarily()
                    bindFocusedStreamChrome()
                }
            }
            row.addView(
                chip,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                ).apply { marginEnd = gap },
            )
        }
    }

    private fun updatePlayPauseIcon(playing: Boolean) {
        focusedControls()?.playPause?.setImageResource(
            if (playing) R.drawable.baseline_pause_black_48
            else R.drawable.baseline_play_arrow_black_48
        )
    }

    private fun updateCompressorIcon(enabled: Boolean) {
        focusedControls()?.audioCompressor?.setImageResource(
            if (enabled) R.drawable.baseline_audio_compressor_on_24dp
            else R.drawable.baseline_audio_compressor_off_24dp
        )
    }

    private fun updateFullscreenIcon() {
        val controls = focusedControls() ?: return
        val immersive = immersiveKey != null
        controls.fullscreen.setImageResource(
            if (immersive) R.drawable.baseline_fullscreen_exit_black_24
            else R.drawable.baseline_fullscreen_black_24
        )
        controls.fullscreen.contentDescription = getString(
            if (immersive) R.string.multipov_exit_fullscreen else R.string.multipov_expand_focus
        )
    }

    private fun updateUptime(startedAtIso: String?) {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        controls.uptimeTimer.stop()
        val startedMs = startedAtIso?.let { KickApiHelper.parseIso8601DateUTC(it) }
        if (startedMs != null && prefs.getBoolean(C.PLAYER_SHOW_UPTIME, true)) {
            controls.uptimeLayout.isVisible = true
            controls.uptimeTimer.base =
                SystemClock.elapsedRealtime() + startedMs - System.currentTimeMillis()
            controls.uptimeTimer.start()
            controls.uptimeIcon.isVisible = prefs.getBoolean(C.PLAYER_VIEWERICON, true)
        } else {
            controls.uptimeLayout.isVisible = false
        }
    }

    private fun updateLatencyDisplay(liveOffsetMs: Long?) {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        if (liveOffsetMs != null && prefs.getBoolean(C.PLAYER_SHOW_LATENCY, true)) {
            controls.latencyLayout.isVisible = true
            controls.latencyText.text = getString(
                R.string.multipov_latency_approx,
                liveOffsetMs / 1000.0,
            )
        } else {
            controls.latencyLayout.isVisible = false
        }
    }

    private fun startLatencyPolling() {
        stopLatencyPolling()
        if (!requireContext().prefs().getBoolean(C.PLAYER_SHOW_LATENCY, true)) return
        latencyPollJob = viewLifecycleOwner.lifecycleScope.launch {
            while (isActive) {
                val key = viewModel.uiState.value.focusedKey
                updateLatencyDisplay(playbackController?.getLiveOffsetMs(key))
                delay(1_500L)
            }
        }
    }

    private fun stopLatencyPolling() {
        latencyPollJob?.cancel()
        latencyPollJob = null
    }

    private fun restartFocused() {
        val slot = viewModel.uiState.value.focusedSlot ?: return
        viewModel.retrySlot(slot.key)
        val refreshed = viewModel.uiState.value.slots.firstOrNull { it.key == slot.key }
        val url = refreshed?.resolvedUrl ?: slot.resolvedUrl
        if (!url.isNullOrBlank()) {
            playbackController?.retry(slot.key, url, focused = true)
        }
    }

    fun changeVolume(volume: Float) {
        playbackController?.setVolume(viewModel.uiState.value.focusedKey, volume)
    }

    fun getCurrentVolume(): Float {
        val key = viewModel.uiState.value.focusedKey ?: return 1f
        return playbackController?.volumeFor(key) ?: 1f
    }

    private fun showVolumeDialog() {
        PlayerVolumeDialog.newInstance(getCurrentVolume())
            .show(childFragmentManager, "closeOnPip")
    }

    private fun showFocusedPlayerMenu() {
        val items = buildList {
            add(getString(R.string.multipov_stream_quality))
            add(getString(R.string.multipov_add_stream))
            if (viewModel.uiState.value.slots.size >= 2) {
                add(getString(R.string.multipov_cycle_layout))
                add(getString(R.string.multipov_rotate_order))
            }
            val bw = viewModel.uiState.value.bandwidthSaving
            add(
                getString(
                    if (bw) R.string.multipov_bandwidth_saving_off
                    else R.string.multipov_bandwidth_saving_on
                )
            )
            add(getString(R.string.restart_player))
            if (viewModel.uiState.value.slots.size > 1) {
                add(getString(R.string.multipov_remove))
            }
            add(getString(R.string.multipov_open_solo))
        }.toTypedArray()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(viewModel.uiState.value.focusedSlot?.stream?.channelName
                ?: getString(R.string.multipov))
            .setItems(items) { _, which ->
                when (items[which]) {
                    getString(R.string.multipov_stream_quality) -> showStreamQualityDialog()
                    getString(R.string.multipov_add_stream) -> openPicker()
                    getString(R.string.multipov_cycle_layout) -> cycleLayoutPreset()
                    getString(R.string.multipov_rotate_order) -> rotateStreamOrder()
                    getString(R.string.multipov_bandwidth_saving_on),
                    getString(R.string.multipov_bandwidth_saving_off) -> {
                        val enabled = viewModel.toggleBandwidthSaving()
                        Toast.makeText(
                            requireContext(),
                            if (enabled) R.string.multipov_bandwidth_saving_enabled
                            else R.string.multipov_bandwidth_saving_disabled,
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                    getString(R.string.restart_player) -> restartFocused()
                    getString(R.string.multipov_remove) ->
                        viewModel.uiState.value.focusedKey?.let { removeSlot(it) }
                    getString(R.string.multipov_open_solo) -> openFocusedSolo()
                }
            }
            .show()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupGestures() {
        touchSlop = ViewConfiguration.get(requireContext()).scaledTouchSlop
        videoZoom = VideoZoomController(
            requireContext(),
            object : VideoZoomController.Host {
                override fun getZoomView(): View? = focusedZoomSurface()

                override fun getViewportSize(): Pair<Int, Int> {
                    val tile = focusedTileBinding() ?: return 0 to 0
                    return tile.root.width to tile.root.height
                }

                override fun getZoomViewOriginInViewport(): Pair<Float, Float> {
                    val tile = focusedTileBinding() ?: return 0f to 0f
                    // Match solo player: surface origin inside the tile viewport.
                    val left = tile.tileAspect.left + tile.tileSurface.left
                    val top = tile.tileAspect.top + tile.tileSurface.top
                    return left.toFloat() to top.toFloat()
                }

                override fun onZoomActiveChanged(active: Boolean) {
                    val tile = focusedTileBinding() ?: return
                    tile.tileAspect.resizeMode = if (active) {
                        AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                    } else {
                        AspectRatioFrameLayout.RESIZE_MODE_FIT
                    }
                    // Clear transforms on non-focused tiles.
                    if (!active) {
                        clearZoomTransformsExcept(focusedTileKey())
                    }
                }
            }
        )

        val detector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean = true

            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                if (!isMaximized) {
                    maximize()
                } else {
                    toggleControls()
                }
                return true
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                if (!isMaximized) {
                    maximize()
                    return true
                }
                // Double-tap empty video area: immersive on focused stream.
                toggleImmersiveForFocused()
                return true
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float,
            ): Boolean {
                val zoom = videoZoom
                if (e1 == null || !isMaximized || zoom?.gestureActive == true || zoom?.isZoomed() == true ||
                    chatDragActive
                ) {
                    return false
                }
                val dy = e2.y - e1.y
                val dx = e2.x - e1.x
                // Swipe down to minimize MultiPOV.
                if (dy > 120 && abs(dy) > abs(dx) * 1.2f && velocityY > 400f) {
                    minimize()
                    return true
                }
                // Portrait: horizontal fling toggles chat (landscape uses interactive drag).
                if (isPortrait && abs(dx) > 120 && abs(dx) > abs(dy) * 1.2f && abs(velocityX) > 400f) {
                    toggleChat()
                    return true
                }
                return false
            }
        })
        gestureDetector = detector

        // Shell targets (gaps between tiles / letterbox): pinch zoom + chat drag + fling/tap.
        val shellTouchListener = View.OnTouchListener { _, event ->
            val zoom = videoZoom
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                suppressTileMenu = false
            }
            if (event.pointerCount > 1 && isMaximized) {
                if (chatDragActive) endChatDrag(event)
                chatDragCandidate = false
                suppressTileMenu = true
                cancelHideControls()
                viewModel.setControlsVisible(false)
                zoom?.scaleDetector?.onTouchEvent(event)
                return@OnTouchListener true
            }
            if (handleChatDragTouch(event)) {
                return@OnTouchListener true
            }
            if (zoom?.gestureActive != true && !suppressTileMenu && !chatDragActive) {
                detector.onTouchEvent(event)
            }
            false
        }
        binding.tileGrid.setOnTouchListener(shellTouchListener)
        binding.videoSection.setOnTouchListener(shellTouchListener)
    }

    private fun focusedTileKey(): String? = immersiveKey ?: viewModel.uiState.value.focusedKey

    private fun focusedTileBinding(): ItemMultipovTileBinding? {
        return focusedTileKey()?.let { tileBindings[it] }
    }

    private fun focusedZoomSurface(): View? = focusedTileBinding()?.tileSurface

    private fun clearZoomTransformsExcept(keepKey: String?) {
        tileBindings.forEach { (key, tile) ->
            if (key != keepKey) {
                tile.tileSurface.pivotX = 0f
                tile.tileSurface.pivotY = 0f
                tile.tileSurface.scaleX = 1f
                tile.tileSurface.scaleY = 1f
                tile.tileSurface.translationX = 0f
                tile.tileSurface.translationY = 0f
                tile.tileAspect.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
            }
        }
    }

    private fun showControlsTemporarily() {
        if (!isMaximized || isInPipMode()) return
        viewModel.setControlsVisible(true)
        scheduleHideControls()
    }

    private fun scheduleHideControls() {
        val root = view ?: return
        root.removeCallbacks(hideControlsRunnable)
        root.postDelayed(hideControlsRunnable, CONTROLS_HIDE_DELAY_MS)
    }

    private fun cancelHideControls() {
        view?.removeCallbacks(hideControlsRunnable)
    }

    private fun resetVideoZoom() {
        videoZoom?.reset()
        clearZoomTransformsExcept(null)
    }

    private fun toggleImmersiveForFocused() {
        val key = viewModel.uiState.value.focusedKey ?: return
        if (immersiveKey == key) {
            exitImmersive()
        } else {
            enterImmersive(key)
        }
    }

    private fun enterImmersive(key: String) {
        if (viewModel.uiState.value.slots.none { it.key == key }) return
        resetVideoZoom()
        immersiveKey = key
        viewModel.setFocus(key)
        viewModel.setControlsVisible(false)
        cancelHideControls()
        // Free bandwidth/decoders for the full-screen stream.
        playbackController?.pauseSecondaries()
        updateExpandButtonIcon()
        render(viewModel.uiState.value, forceGridRebuild = true)
    }

    private fun exitImmersive() {
        if (immersiveKey == null) return
        resetVideoZoom()
        immersiveKey = null
        playbackController?.resumeSecondaries()
        updateExpandButtonIcon()
        render(viewModel.uiState.value, forceGridRebuild = true)
        showControlsTemporarily()
    }

    private fun updateExpandButtonIcon() {
        updateFullscreenIcon()
    }

    private fun openFocusedSolo() {
        val focused = viewModel.uiState.value.focusedSlot ?: return
        (activity as? MainActivity)?.expandMultiPovFocus(focused.stream, focused.resolvedUrl)
    }

    override fun onStart() {
        super.onStart()
        // Cancel pending grace-period pause if user returned quickly.
        backgroundPauseRunnable?.let { view?.removeCallbacks(it) }
        backgroundPauseRunnable = null
        val inPip = isInPipMode()
        if (!inPip) {
            if (!requireContext().prefs().getBoolean(C.MULTIPOV_PAUSE_INACTIVE_ON_BACKGROUND, true) || isMaximized) {
                playbackController?.resumeAll()
            } else {
                // Toggle ON but was background-paused with grace: resume secondaries.
                // If we kept only focused audible in background, resume the rest now.
                playbackController?.resumeAll()
            }
        }
    }

    override fun onStop() {
        val inPip = isInPipMode()
        if (!inPip && requireContext().prefs().getBoolean(C.MULTIPOV_PAUSE_INACTIVE_ON_BACKGROUND, true)) {
            // Grace period: avoid re-buffer if user accidentally hid or rotated and comes back quickly.
            // When optimization is ON:
            // - if background audio is allowed, keep focused stream audible, pause others after grace
            // - otherwise pause all after grace
            val prefs = requireContext().prefs()
            val keepFocusedAudible = prefs.getBoolean(C.PLAYER_BACKGROUND_AUDIO, true) ||
                prefs.getString(C.PLAYER_BACKGROUND_PLAYBACK, "0") != "0" ||
                prefs.getBoolean(C.PLAYER_BACKGROUND_AUDIO_LOCKED, true)
            val runnable = Runnable {
                if (!isAdded || isInPipMode()) return@Runnable
                if (keepFocusedAudible && viewModel.uiState.value.focusedKey != null) {
                    playbackController?.pauseSecondaries()
                } else {
                    playbackController?.pauseAll()
                }
            }
            backgroundPauseRunnable = runnable
            view?.postDelayed(runnable, backgroundGraceMs)
        }
        super.onStop()
    }

    override fun onDestroyView() {
        backgroundPauseRunnable?.let { view?.removeCallbacks(it) }
        backgroundPauseRunnable = null
        cancelHideControls()
        view?.removeCallbacks(hideFocusBorderRunnable)
        chatProgressAnimator?.cancel()
        chatProgressAnimator = null
        velocityTracker?.recycle()
        velocityTracker = null
        stopLatencyPolling()
        chatDragActive = false
        chatDragCandidate = false
        focusFlashKey = null
        lastFocusFlashForKey = null
        unregisterAdaptiveMonitors()
        playbackController?.releaseAll()
        playbackController = null
        tileBindings.clear()
        currentChatKey = null
        lastGridSignature = emptyList()
        immersiveKey = null
        resetVideoZoom()
        videoZoom = null
        _binding = null
        super.onDestroyView()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        isPortrait = newConfig.orientation == Configuration.ORIENTATION_PORTRAIT
        // Landscape chat width is orientation-dependent; refresh after rotate.
        chatWidthLandscape = 0
        ensureChatWidthLandscape()
        chatOpenProgress = if (isChatOpen) 1f else 0f
        chatDragActive = false
        chatDragCandidate = false
        chatProgressAnimator?.cancel()
        applyOrientationLayout(rebuildTiles = false)
        if (isMaximized) {
            render(viewModel.uiState.value, forceGridRebuild = true)
        } else {
            applyMinimizedTransform()
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        if (isInPictureInPictureMode) {
            enterPipUi()
        } else {
            exitPipUi()
        }
    }

    override fun onStreamPicked(stream: Stream) {
        addStream(stream)
    }

    fun addStream(stream: Stream, resolvedUrl: String? = null): Boolean {
        val key = stream.multiPovKey()
        val alreadyPresent = viewModel.uiState.value.slots.any { it.key == key }
        val added = viewModel.addStream(stream, resolvedUrl)
        if (!added) {
            Toast.makeText(requireContext(), R.string.multipov_max_reached, Toast.LENGTH_SHORT).show()
        } else if (alreadyPresent) {
            Toast.makeText(
                requireContext(),
                getString(R.string.multipov_already_added, stream.channelName ?: stream.channelLogin.orEmpty()),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.multipov_added, stream.channelName ?: stream.channelLogin.orEmpty()),
                Toast.LENGTH_SHORT
            ).show()
            // Force grid rebuild path by ensuring signature updates after state emission.
            view?.post { render(viewModel.uiState.value, forceGridRebuild = true) }
        }
        return added
    }

    fun canEnterPictureInPicture(): Boolean {
        return isMaximized &&
            viewModel.uiState.value.focusedSlot != null &&
            requireContext().prefs().getBoolean(C.MULTIPOV_PIP_FOCUSED, true) &&
            requireContext().prefs().getBoolean(C.PLAYER_PICTURE_IN_PICTURE, true)
    }

    fun enterFocusedPip(): Boolean {
        if (!canEnterPictureInPicture()) return false
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
        if (!requireActivity().packageManager.hasSystemFeature(android.content.pm.PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            return false
        }
        return try {
            requireActivity().enterPictureInPictureMode(
                PictureInPictureParams.Builder()
                    .setAspectRatio(Rational(16, 9))
                    .build()
            )
        } catch (_: IllegalStateException) {
            false
        }
    }

    fun minimize() {
        if (!isMaximized) return
        isMaximized = false
        cancelHideControls()
        resetVideoZoom()
        val binding = _binding ?: return
        binding.chatFragmentContainer.isVisible = false
        updateFocusedControlsVisibility(show = false)
        binding.minimizeBadge.isVisible = true
        binding.minimizeBadge.text = getString(R.string.multipov_badge, viewModel.uiState.value.slots.size)
        playbackController?.pauseSecondaries()
        // Keep focused player only while minimized to free decoders.
        viewModel.uiState.value.slots.forEach { slot ->
            if (!slot.isFocused) {
                playbackController?.releasePlayer(slot.key)
            }
        }
        applyMinimizedTransform()
        backCallback.isEnabled = true
    }

    fun maximize() {
        if (isMaximized) return
        isMaximized = true
        val binding = _binding ?: return
        binding.multiPovRoot.animate().cancel()
        binding.multiPovRoot.scaleX = 1f
        binding.multiPovRoot.scaleY = 1f
        binding.multiPovRoot.translationX = 0f
        binding.multiPovRoot.translationY = 0f
        binding.chatFragmentContainer.isVisible = isChatOpen
        binding.minimizeBadge.isVisible = false
        applyOrientationLayout(rebuildTiles = false)
        playbackController?.resumeSecondaries()
        render(viewModel.uiState.value, forceGridRebuild = true)
        showControlsTemporarily()
    }

    private fun applyMinimizedTransform() {
        val binding = _binding ?: return
        val root = binding.multiPovRoot
        root.doOnPreDraw {
            val scale = if (isPortrait) 0.42f else 0.32f
            root.scaleX = scale
            root.scaleY = scale
            val windowInsets = ViewCompat.getRootWindowInsets(requireView())
            val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            val navBarHeight = requireView().rootView.findViewById<LinearLayout>(R.id.navBarContainer)?.height
                ?.takeIf { it > 0 } ?: (insets?.bottom ?: 0)
            val margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)
            val scaledXDiff = (root.width * (1f - scale)) / 2f
            val scaledYDiff = (root.height * (1f - scale)) / 2f
            val newX = root.width - (insets?.right ?: 0) - (root.width * scale) - margin
            val newY = root.height - navBarHeight - (root.height * scale * 0.55f) - margin
            root.translationX = 0f - scaledXDiff - ((insets?.left ?: 0) * scale) + newX
            root.translationY = 0f - scaledYDiff - ((insets?.top ?: 0) * scale) + newY
        }
    }

    private fun enterPipUi() {
        val binding = _binding ?: return
        binding.chatFragmentContainer.isVisible = false
        updateFocusedControlsVisibility(show = false)
        binding.minimizeBadge.isVisible = false
        playbackController?.pauseSecondaries()
        // Show only focused tile surface area as much as possible
        tileBindings.forEach { (key, tile) ->
            tile.root.isVisible = key == viewModel.uiState.value.focusedKey
        }
    }

    private fun exitPipUi() {
        if (!isAdded) return
        tileBindings.values.forEach { it.root.isVisible = true }
        if (isMaximized) {
            playbackController?.resumeSecondaries()
            applyOrientationLayout(rebuildTiles = false)
            render(viewModel.uiState.value, forceGridRebuild = true)
        } else {
            minimize()
        }
    }

    private fun isInPipMode(): Boolean {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> requireActivity().isInPictureInPictureMode
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> requireActivity().isInPictureInPictureMode
            else -> false
        }
    }

    private fun render(state: MultiPovUiState, forceGridRebuild: Boolean = false) {
        val binding = _binding ?: return
        val controller = playbackController ?: return
        if (isInPipMode()) {
            // Keep focused stream only while system PiP is active.
            state.slots.forEach { slot ->
                val url = slot.resolvedUrl
                if (slot.isFocused && !url.isNullOrBlank()) {
                    controller.ensurePlaying(slot.key, url, focused = true)
                } else {
                    controller.releasePlayer(slot.key)
                }
            }
            return
        }

        // Floating chrome — GONE when hidden so video is fully visible.
        updateFocusedControlsVisibility(show = state.isControlsVisible && isMaximized)
        binding.minimizeBadge.text = getString(R.string.multipov_badge, state.slots.size)
        updateExpandButtonIcon()

        controller.setStreamQuality(state.streamQuality)
        controller.setBandwidthSaving(state.bandwidthSaving)
        controller.setFocus(state.focusedKey, crossfade = isMaximized)

        // Green ring flashes only when focus changes — not a permanent frame.
        val focused = state.focusedKey
        if (focused != null && focused != lastFocusFlashForKey) {
            lastFocusFlashForKey = focused
            flashFocusBorder(focused)
        }

        if (!isMaximized) {
            // While minimized, keep focused playback only on the scaled surface.
            state.slots.forEach { slot ->
                val url = slot.resolvedUrl
                if (slot.isFocused && !url.isNullOrBlank()) {
                    controller.ensurePlaying(slot.key, url, focused = true)
                } else {
                    controller.releasePlayer(slot.key)
                }
            }
            return
        }

        // Drop stale immersive key if that slot was removed.
        if (immersiveKey != null && state.slots.none { it.key == immersiveKey }) {
            immersiveKey = null
        }

        // Rebuild only when slots/order/layout/orientation change — not on focus (that freezes tiles).
        val gridSignature = state.slots.map { it.key } + listOfNotNull(
            currentLayoutPreset().prefValue,
            immersiveKey?.let { "imm:$it" },
            if (isPortrait) "port" else "land",
        )
        val gridChanged = forceGridRebuild || gridSignature != lastGridSignature
        if (gridChanged) {
            rebuildGrid(state)
            lastGridSignature = gridSignature
            // Tiles recreated — re-show flash ring if still within the flash window.
            focusFlashKey?.let { key ->
                tileBindings[key]?.focusBorder?.isVisible = true
            }
        }

        state.slots.forEach { slot ->
            val tile = tileBindings[slot.key]
            tile?.let { bindTileChrome(it, slot) }
            val url = slot.resolvedUrl
            val inImmersiveBackground = immersiveKey != null && slot.key != immersiveKey
            when {
                slot.loadState is MultiPovLoadState.Offline -> controller.releasePlayer(slot.key)
                // Fullscreen tile mode: release non-visible players so the focused stream is clean.
                inImmersiveBackground -> controller.releasePlayer(slot.key)
                !url.isNullOrBlank() -> {
                    controller.ensurePlaying(slot.key, url, focused = slot.isFocused)
                    tile?.let { controller.attachSurface(slot.key, it.tileSurface, it.tileAspect) }
                }
                // Missing URL: ask ViewModel once; it no-ops if a resolve is already running.
                else -> viewModel.resolveIfNeeded(slot.key, forceRefresh = false, userInitiated = false)
            }
        }

        val activeKeys = state.slots.map { it.key }.toSet()
        tileBindings.keys.filter { it !in activeKeys }.forEach { key ->
            controller.releasePlayer(key)
            tileBindings.remove(key)
        }

        // Keep solo-player zoom transforms applied after layout/rebuild.
        if (videoZoom?.isZoomed() == true) {
            videoZoom?.clampAndApply()
        } else {
            clearZoomTransformsExcept(focusedTileKey())
        }
        updateChat(state.focusedSlot)

        if (state.slots.isEmpty()) {
            (activity as? MainActivity)?.closeMultiPov()
        }
    }

    private fun currentLayoutPreset(): MultiPovLayoutPreset {
        return MultiPovLayoutPreset.fromPrefs(requireContext().prefs())
    }

    private fun cycleLayoutPreset() {
        val next = currentLayoutPreset().next()
        requireContext().prefs().edit {
            putString(C.MULTIPOV_LAYOUT, next.prefValue)
        }
        Toast.makeText(
            requireContext(),
            getString(R.string.multipov_layout_toast, getString(next.labelRes())),
            Toast.LENGTH_SHORT
        ).show()
        render(viewModel.uiState.value, forceGridRebuild = true)
    }

    private fun showLayoutPickerDialog() {
        val presets = MultiPovLayoutPreset.entries
        val labels = presets.map { getString(it.labelRes()) }.toTypedArray()
        val selected = presets.indexOf(currentLayoutPreset()).coerceAtLeast(0)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.multipov_layout)
            .setSingleChoiceItems(labels, selected) { dialog, which ->
                val chosen = presets[which]
                requireContext().prefs().edit {
                    putString(C.MULTIPOV_LAYOUT, chosen.prefValue)
                }
                dialog.dismiss()
                render(viewModel.uiState.value, forceGridRebuild = true)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.multipov_layout_toast, getString(chosen.labelRes())),
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun rotateStreamOrder() {
        if (viewModel.uiState.value.slots.size < 2) return
        viewModel.rotateSlotOrder()
        Toast.makeText(requireContext(), R.string.multipov_rotate_toast, Toast.LENGTH_SHORT).show()
        // Force rebuild immediately so order change is visible even before flow re-collects.
        view?.post { render(viewModel.uiState.value, forceGridRebuild = true) }
    }

    private fun rebuildGrid(state: MultiPovUiState) {
        val binding = _binding ?: return
        val grid = binding.tileGrid
        val controller = playbackController ?: return

        tileBindings.keys.forEach { controller.detachSurface(it) }
        tileBindings.clear()
        grid.removeAllViews()
        grid.orientation = LinearLayout.VERTICAL
        grid.clipChildren = true
        grid.clipToPadding = true

        // Immersive: one stream fills the entire video section.
        val immersiveSlot = immersiveKey?.let { key -> state.slots.firstOrNull { it.key == key } }
        if (immersiveSlot != null) {
            addFullBleedTile(grid, immersiveSlot)
            return
        }

        val slots = state.slots
        if (slots.isEmpty()) return

        val preset = currentLayoutPreset()
        val landscape = !isPortrait

        when {
            // Primary layouts need at least 2 real streams to be meaningful.
            preset == MultiPovLayoutPreset.PRIMARY_TOP && slots.size >= 2 ->
                buildPrimaryTopGrid(grid, slots)
            preset == MultiPovLayoutPreset.PRIMARY_LEFT && slots.size >= 2 ->
                buildPrimaryLeftGrid(grid, slots, landscape)
            else ->
                buildEqualGrid(grid, slots, landscape)
        }
    }

    private fun buildEqualGrid(
        grid: LinearLayout,
        slots: List<MultiPovSlot>,
        landscape: Boolean,
    ) {
        val columns = equalColumnsFor(slots.size, landscape)
        slots.chunked(columns).forEach { rowSlots ->
            val row = horizontalRow(weight = 1f)
            rowSlots.forEach { slot ->
                row.addView(createTileView(row, slot), weightedCellParams(width = 0))
            }
            grid.addView(row)
        }
    }

    /** Large primary (slots[0]) on top; remaining streams share the bottom row(s). */
    private fun buildPrimaryTopGrid(
        grid: LinearLayout,
        slots: List<MultiPovSlot>,
    ) {
        val primary = slots.first()
        val rest = slots.drop(1)

        val primaryRow = horizontalRow(weight = if (rest.isEmpty()) 1f else 1.7f)
        primaryRow.addView(
            createTileView(primaryRow, primary),
            weightedCellParams(width = ViewGroup.LayoutParams.MATCH_PARENT),
        )
        grid.addView(primaryRow)

        if (rest.isEmpty()) return

        val secondaryCols = when {
            rest.size <= 1 -> 1
            rest.size <= 3 -> rest.size
            else -> 2
        }
        rest.chunked(secondaryCols).forEach { rowSlots ->
            val row = horizontalRow(weight = 1f)
            rowSlots.forEach { slot ->
                row.addView(createTileView(row, slot), weightedCellParams(width = 0))
            }
            grid.addView(row)
        }
    }

    /** Large primary on the left; remaining streams stacked on the right. */
    private fun buildPrimaryLeftGrid(
        grid: LinearLayout,
        slots: List<MultiPovSlot>,
        landscape: Boolean,
    ) {
        val primary = slots.first()
        val rest = slots.drop(1)

        val outer = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            clipChildren = true
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f,
            )
        }

        val primaryWeight = if (rest.isEmpty()) 1f else if (landscape) 1.8f else 1.4f
        outer.addView(
            createTileView(outer, primary),
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, primaryWeight).withTileMargins(),
        )

        if (rest.isNotEmpty()) {
            val secondaryCol = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
                clipChildren = true
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            }
            rest.forEach { slot ->
                secondaryCol.addView(
                    createTileView(secondaryCol, slot),
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f).withTileMargins(),
                )
            }
            outer.addView(secondaryCol)
        }
        grid.addView(outer)
    }

    private fun addFullBleedTile(grid: LinearLayout, slot: MultiPovSlot) {
        val row = horizontalRow(weight = 1f)
        row.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
            1f,
        )
        row.addView(
            createTileView(row, slot),
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f,
            ),
        )
        grid.addView(row)
    }

    private fun horizontalRow(weight: Float): LinearLayout {
        return LinearLayout(requireContext()).apply {
            orientation = LinearLayout.HORIZONTAL
            clipChildren = true
            clipToPadding = true
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                weight,
            )
        }
    }

    private fun weightedCellParams(width: Int): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT, 1f).withTileMargins()
    }

    private fun LinearLayout.LayoutParams.withTileMargins(): LinearLayout.LayoutParams {
        setMargins(TILE_MARGIN_PX, TILE_MARGIN_PX, TILE_MARGIN_PX, TILE_MARGIN_PX)
        return this
    }

    private fun createTileView(
        parent: ViewGroup,
        slot: MultiPovSlot,
    ): View {
        return ItemMultipovTileBinding.inflate(layoutInflater, parent, false).also { tileBinding ->
            // FIT shows the full stream; ZOOM is only applied while the user pinches.
            tileBinding.tileAspect.setAspectRatio(16f / 9f)
            tileBinding.tileAspect.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
            tileBindings[slot.key] = tileBinding
            bindTileChrome(tileBinding, slot)
            wireTileInteractions(tileBinding, slot)
        }.root
    }

    private fun equalColumnsFor(count: Int, landscape: Boolean): Int {
        return when {
            count <= 1 -> 1
            count == 2 -> if (landscape) 2 else 1
            count <= 4 -> 2
            count <= 6 -> if (landscape) 3 else 2
            else -> if (landscape) 4 else 2
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun wireTileInteractions(tileBinding: ItemMultipovTileBinding, slot: MultiPovSlot) {
        val tileGesture = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onDown(e: MotionEvent): Boolean = true

            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                if (suppressTileMenu) return true
                // Tap never retargets focus — open/close chrome for the current focus only.
                // Switch focus via the stream chips in the control bar (or double-tap immersive).
                toggleControls()
                return true
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                if (suppressTileMenu) return true
                resetVideoZoom()
                if (viewModel.uiState.value.focusedKey != slot.key) {
                    viewModel.setFocus(slot.key)
                }
                if (immersiveKey == slot.key) {
                    exitImmersive()
                } else {
                    enterImmersive(slot.key)
                }
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                // Never open the tile menu during/after a zoom or pan gesture.
                if (suppressTileMenu || videoZoom?.gestureActive == true || videoZoom?.panMoved == true) {
                    return
                }
                showTileMenu(slot)
            }
        })
        tileBinding.root.setOnTouchListener { v, event ->
            val zoom = videoZoom
            val isFocusedTile = viewModel.uiState.value.focusedKey == slot.key || immersiveKey == slot.key

            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> suppressTileMenu = false
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Keep suppress until this gesture fully ends; cleared on next DOWN.
                }
            }

            // Pinch zoom (and finishing POINTER_UP while the detector is still active).
            val multiTouch = event.pointerCount > 1 ||
                (zoom?.gestureActive == true &&
                    (event.actionMasked == MotionEvent.ACTION_POINTER_UP ||
                        event.actionMasked == MotionEvent.ACTION_MOVE))
            if (multiTouch && isFocusedTile && isMaximized) {
                if (chatDragActive) endChatDrag(event)
                chatDragCandidate = false
                suppressTileMenu = true
                cancelHideControls()
                viewModel.setControlsVisible(false)
                // Cancel pending long-press / taps in GestureDetector (solo player does this too).
                tileGesture.onTouchEvent(
                    MotionEvent.obtain(
                        event.downTime,
                        event.eventTime,
                        MotionEvent.ACTION_CANCEL,
                        event.x,
                        event.y,
                        0,
                    )
                )
                zoom?.scaleDetector?.onTouchEvent(event)
                // Pinch almost always ends one finger first — re-anchor pan to the leftover finger
                // so the next MOVE doesn't jump from stale pan coords.
                if (zoom != null && !zoom.gestureActive && zoom.isZoomed() &&
                    event.actionMasked == MotionEvent.ACTION_POINTER_UP
                ) {
                    val upIndex = event.actionIndex
                    val remainIndex = (0 until event.pointerCount).firstOrNull { it != upIndex }
                    if (remainIndex != null) {
                        zoom.beginPan(event.getX(remainIndex), event.getY(remainIndex))
                    }
                }
                return@setOnTouchListener true
            }

            // Landscape interactive chat open/close (same as solo player).
            if (handleChatDragTouch(event)) {
                tileGesture.onTouchEvent(
                    MotionEvent.obtain(
                        event.downTime,
                        event.eventTime,
                        MotionEvent.ACTION_CANCEL,
                        event.x,
                        event.y,
                        0,
                    )
                )
                return@setOnTouchListener true
            }

            // One-finger pan while zoomed. panBy re-anchors if a pinch just ended mid-gesture.
            if (isFocusedTile && zoom?.isZoomed() == true && zoom.gestureActive != true) {
                when (event.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        zoom.beginPan(event.x, event.y)
                        tileGesture.onTouchEvent(event)
                        return@setOnTouchListener true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        zoom.panBy(event.x, event.y, touchSlop)
                        if (zoom.panMoved) {
                            suppressTileMenu = true
                            tileGesture.onTouchEvent(
                                MotionEvent.obtain(
                                    event.downTime,
                                    event.eventTime,
                                    MotionEvent.ACTION_CANCEL,
                                    event.x,
                                    event.y,
                                    0,
                                )
                            )
                            return@setOnTouchListener true
                        }
                    }
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        if (!zoom.panMoved && !suppressTileMenu) {
                            tileGesture.onTouchEvent(event)
                            if (event.actionMasked == MotionEvent.ACTION_UP) v.performClick()
                        }
                        return@setOnTouchListener true
                    }
                }
            }

            // If a pinch just ended but GestureDetector still has a long-press timer, kill it.
            if (suppressTileMenu || zoom?.gestureActive == true) {
                if (event.actionMasked == MotionEvent.ACTION_UP || event.actionMasked == MotionEvent.ACTION_CANCEL) {
                    return@setOnTouchListener true
                }
            }

            val handled = tileGesture.onTouchEvent(event)
            if (event.actionMasked == MotionEvent.ACTION_UP && handled && !suppressTileMenu) {
                v.performClick()
            }
            true
        }
        tileBinding.removeButton.setOnClickListener {
            showControlsTemporarily()
            removeSlot(slot.key)
        }
        tileBinding.errorText.setOnClickListener { retrySlot(slot) }
    }

    private fun flashFocusBorder(key: String) {
        focusFlashKey = key
        tileBindings.forEach { (slotKey, tile) ->
            tile.focusBorder.isVisible = slotKey == key
        }
        val root = view ?: return
        root.removeCallbacks(hideFocusBorderRunnable)
        root.postDelayed(hideFocusBorderRunnable, FOCUS_BORDER_FLASH_MS)
    }

    private fun bindTileChrome(tile: ItemMultipovTileBinding, slot: MultiPovSlot) {
        // Immersive tiles: no permanent labels/X. Focus ring is a brief flash only.
        tile.focusBorder.isVisible = slot.isFocused && focusFlashKey == slot.key
        tile.tileChrome.isVisible = false
        when (val load = slot.loadState) {
            MultiPovLoadState.Loading -> {
                tile.loadingIndicator.isVisible = true
                tile.errorText.isVisible = false
            }
            MultiPovLoadState.Ready -> {
                tile.loadingIndicator.isVisible = false
                tile.errorText.isVisible = false
            }
            is MultiPovLoadState.Error -> {
                tile.loadingIndicator.isVisible = false
                tile.errorText.isVisible = true
                tile.errorText.text = getString(
                    R.string.multipov_error_with_retry,
                    load.message,
                    getString(R.string.multipov_retry),
                )
            }
            MultiPovLoadState.Offline -> {
                tile.loadingIndicator.isVisible = false
                tile.errorText.isVisible = true
                tile.errorText.text = getString(
                    R.string.multipov_error_with_retry,
                    getString(R.string.stream_ended),
                    getString(R.string.multipov_retry),
                )
            }
        }
    }

    private fun updateChat(focused: MultiPovSlot?) {
        if (focused == null || !isMaximized || isInPipMode()) return
        if (currentChatKey == focused.key) return
        currentChatKey = focused.key
        val stream = focused.stream
        childFragmentManager.beginTransaction()
            .replace(
                R.id.chatFragmentContainer,
                ChatFragment.newInstance(
                    channelId = stream.channelId,
                    channelLogin = stream.channelLogin,
                    channelName = stream.channelName,
                    streamId = stream.id,
                    source = stream.source ?: C.KICK,
                )
            )
            .commitNowAllowingStateLoss()
    }

    private fun applyOrientationLayout(rebuildTiles: Boolean = false) {
        val binding = _binding ?: return
        if (!isMaximized) return
        val prefs = requireContext().prefs()
        val chatDisabled = prefs.getBoolean(C.CHAT_DISABLE, false)
        if (chatDisabled) {
            isChatOpen = false
            chatOpenProgress = 0f
        }
        focusedControls()?.toggleChat?.isVisible =
            !chatDisabled && requireContext().prefs().getBoolean(C.PLAYER_CHATTOGGLE, true)
        if (isPortrait) {
            applyPortraitChatLayout()
        } else {
            ensureChatWidthLandscape()
            applyChatOpenProgress(if (isChatOpen) 1f else 0f, finalize = true)
        }
        updateChatToggleIcon()
        if (rebuildTiles && viewModel.uiState.value.slots.isNotEmpty()) {
            view?.post { render(viewModel.uiState.value, forceGridRebuild = true) }
        }
    }

    /** Portrait: stacked video + chat (same ~55/45 split as the old LinearLayout weights). */
    private fun applyPortraitChatLayout() {
        val binding = _binding ?: return
        binding.chatFragmentContainer.translationX = 0f
        fun applyHeights() {
            val root = _binding?.multiPovRoot ?: return
            val total = root.height
            if (total <= 0) return
            val videoH = if (isChatOpen) (total * (1.15f / 2f)).roundToInt() else total
            val chatH = (total - videoH).coerceAtLeast(0)
            binding.videoSection.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                videoH,
                Gravity.TOP,
            ).apply { marginEnd = 0 }
            binding.chatFragmentContainer.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                if (isChatOpen) chatH else 0,
                Gravity.BOTTOM,
            )
            binding.chatFragmentContainer.isVisible = isChatOpen
        }
        // Immediate pass + post so we have a real height after rotation.
        applyHeights()
        binding.multiPovRoot.post { applyHeights() }
    }

    private fun canInteractiveChatDrag(): Boolean {
        return !isPortrait &&
            isMaximized &&
            !isInPipMode() &&
            !requireContext().prefs().getBoolean(C.CHAT_DISABLE, false) &&
            chatWidthLandscape > 0 &&
            videoZoom?.isZoomed() != true &&
            videoZoom?.gestureActive != true
    }

    private fun ensureChatWidthLandscape() {
        if (chatWidthLandscape > 0) return
        val prefs = requireContext().prefs()
        chatWidthLandscape = prefs.getInt(C.LANDSCAPE_CHAT_WIDTH, 0)
        if (chatWidthLandscape <= 0) {
            val metrics = resources.displayMetrics
            val longest = max(metrics.widthPixels, metrics.heightPixels)
            chatWidthLandscape = (longest * 0.30f).toInt()
        }
    }

    /**
     * Landscape chat open progress: 0 = closed, 1 = fully open.
     *
     * Matches solo [PlayerFragment]:
     * - video stays left-aligned and shrinks via marginEnd
     * - chat keeps a **fixed** width and slides in/out via translationX
     *   (messages never reflow during the scrub)
     */
    private fun applyChatOpenProgress(progress: Float, finalize: Boolean) {
        val binding = _binding ?: return
        if (isPortrait) return
        val width = chatWidthLandscape
        if (width <= 0) {
            chatOpenProgress = if (isChatOpen) 1f else 0f
            return
        }
        val p = progress.coerceIn(0f, 1f)
        chatOpenProgress = p
        val margin = (width * p).roundToInt().coerceIn(0, width)
        val chatTranslation = (width - margin).toFloat()

        binding.videoSection.translationX = 0f
        if (p <= 0f && finalize) {
            binding.chatFragmentContainer.translationX = 0f
            binding.chatFragmentContainer.isVisible = false
            binding.videoSection.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.START,
            ).apply { marginEnd = 0 }
            return
        }

        prepareLandscapeChatLayout()
        binding.chatFragmentContainer.translationX = chatTranslation
        binding.chatFragmentContainer.isVisible = true
        val videoLp = binding.videoSection.layoutParams as? FrameLayout.LayoutParams
        if (videoLp == null ||
            videoLp.width != ViewGroup.LayoutParams.MATCH_PARENT ||
            videoLp.height != ViewGroup.LayoutParams.MATCH_PARENT ||
            videoLp.gravity != Gravity.START ||
            videoLp.marginEnd != margin
        ) {
            binding.videoSection.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.START,
            ).apply { marginEnd = margin }
        }
    }

    /** Fixed chat column on the end — never resize its width while scrubbing. */
    private fun prepareLandscapeChatLayout() {
        val binding = _binding ?: return
        val width = chatWidthLandscape
        if (width <= 0) return
        val chatLp = binding.chatFragmentContainer.layoutParams as? FrameLayout.LayoutParams
        if (chatLp == null ||
            chatLp.width != width ||
            chatLp.height != ViewGroup.LayoutParams.MATCH_PARENT ||
            chatLp.gravity != Gravity.END
        ) {
            binding.chatFragmentContainer.layoutParams = FrameLayout.LayoutParams(
                width,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.END,
            )
        }
        if (!binding.chatFragmentContainer.isVisible) {
            binding.chatFragmentContainer.isVisible = true
        }
    }

    private fun animateChatOpenProgressTo(target: Float) {
        if (_binding == null) return
        val clampedTarget = target.coerceIn(0f, 1f)
        chatProgressAnimator?.cancel()
        if (isPortrait || chatWidthLandscape <= 0) {
            applyChatOpenProgress(clampedTarget, finalize = true)
            return
        }
        val start = chatOpenProgress
        if (abs(start - clampedTarget) < 0.001f) {
            applyChatOpenProgress(clampedTarget, finalize = true)
            return
        }
        applyChatOpenProgress(start, finalize = false)
        val durationMs = (220f * abs(clampedTarget - start)).toLong().coerceIn(120L, 250L)
        chatProgressAnimator = ValueAnimator.ofFloat(start, clampedTarget).apply {
            duration = durationMs
            interpolator = if (clampedTarget >= start) DecelerateInterpolator() else AccelerateInterpolator()
            addUpdateListener { va ->
                applyChatOpenProgress(va.animatedValue as Float, finalize = false)
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    chatProgressAnimator = null
                    applyChatOpenProgress(clampedTarget, finalize = true)
                }

                override fun onAnimationCancel(animation: Animator) {
                    chatProgressAnimator = null
                }
            })
            start()
        }
    }

    private fun settleChatOpen(open: Boolean, animate: Boolean) {
        isChatOpen = open
        requireContext().prefs().edit { putBoolean(C.KEY_CHAT_OPENED, open) }
        updateChatToggleIcon()
        if (isPortrait) {
            applyOrientationLayout(rebuildTiles = false)
        } else if (animate) {
            animateChatOpenProgressTo(if (open) 1f else 0f)
        } else {
            applyChatOpenProgress(if (open) 1f else 0f, finalize = true)
        }
    }

    /**
     * @return true when this event is consumed by chat scrub (or finishing a scrub).
     */
    private fun handleChatDragTouch(event: MotionEvent): Boolean {
        if (!canInteractiveChatDrag() && !chatDragActive) {
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                chatDragCandidate = false
            }
            return false
        }
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                chatProgressAnimator?.cancel()
                chatDragActive = false
                chatDragCandidate = canInteractiveChatDrag()
                chatDragStartX = event.rawX
                chatDragStartY = event.rawY
                chatDragStartProgress = chatOpenProgress
                return false
            }
            MotionEvent.ACTION_MOVE -> {
                if (!chatDragActive) {
                    if (!beginChatDragIfNeeded(event)) return false
                }
                if (chatDragActive) {
                    updateChatDrag(event)
                    return true
                }
                return false
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                if (chatDragActive) {
                    endChatDrag(event)
                    return true
                }
                chatDragCandidate = false
                return false
            }
            else -> return false
        }
    }

    private fun beginChatDragIfNeeded(event: MotionEvent): Boolean {
        if (!chatDragCandidate || chatDragActive || !canInteractiveChatDrag()) return false
        val dx = event.rawX - chatDragStartX
        val dy = event.rawY - chatDragStartY
        if (abs(dx) <= touchSlop && abs(dy) <= touchSlop) return false
        // Prefer horizontal intent so vertical minimize still works.
        if (abs(dx) < abs(dy) * 1.2f) {
            chatDragCandidate = false
            return false
        }
        chatDragActive = true
        chatDragCandidate = false
        suppressTileMenu = true
        cancelHideControls()
        viewModel.setControlsVisible(false)
        chatProgressAnimator?.cancel()
        chatDragStartProgress = chatOpenProgress
        chatDragStartX = event.rawX
        velocityTracker?.recycle()
        velocityTracker = VelocityTracker.obtain().also {
            it.addMovement(event)
        }
        applyChatOpenProgress(chatOpenProgress, finalize = false)
        return true
    }

    private fun updateChatDrag(event: MotionEvent) {
        // Drag left (negative dx) opens; drag right closes — same as solo player.
        val dx = event.rawX - chatDragStartX
        val progress = chatDragStartProgress - (dx / chatWidthLandscape.toFloat())
        applyChatOpenProgress(progress, finalize = false)
        velocityTracker?.addMovement(event)
    }

    private fun endChatDrag(event: MotionEvent) {
        velocityTracker?.addMovement(event)
        velocityTracker?.computeCurrentVelocity(1000)
        val velocityX = velocityTracker?.xVelocity ?: 0f
        velocityTracker?.recycle()
        velocityTracker = null
        val shouldOpen = when {
            velocityX < -CHAT_FLING_VELOCITY -> true
            velocityX > CHAT_FLING_VELOCITY -> false
            else -> chatOpenProgress >= 0.5f
        }
        settleChatOpen(shouldOpen, animate = true)
        chatDragActive = false
        chatDragCandidate = false
    }

    private fun toggleChat() {
        if (requireContext().prefs().getBoolean(C.CHAT_DISABLE, false)) return
        settleChatOpen(open = !isChatOpen, animate = !isPortrait)
    }

    private fun updateChatToggleIcon() {
        val toggle = focusedControls()?.toggleChat ?: return
        toggle.setImageResource(
            if (isChatOpen) R.drawable.baseline_speaker_notes_black_24
            else R.drawable.baseline_speaker_notes_off_black_24
        )
        toggle.contentDescription = getString(
            if (isChatOpen) R.string.hide_chat else R.string.show_chat
        )
    }

    private fun toggleControls() {
        if (!isMaximized) {
            maximize()
            return
        }
        if (viewModel.uiState.value.isControlsVisible) {
            cancelHideControls()
            viewModel.setControlsVisible(false)
        } else {
            showControlsTemporarily()
        }
    }

    private fun openPicker() {
        if (!viewModel.uiState.value.canAdd) {
            Toast.makeText(requireContext(), R.string.multipov_max_reached, Toast.LENGTH_SHORT).show()
            return
        }
        if (childFragmentManager.findFragmentByTag(MultiPovStreamPickerDialog.TAG) == null) {
            MultiPovStreamPickerDialog.newInstance().show(childFragmentManager, MultiPovStreamPickerDialog.TAG)
        }
    }

    private fun showStreamQualityDialog() {
        val qualities = MultiPovQuality.entries
        val labels = qualities.map { getString(it.labelRes()) }.toTypedArray()
        val selected = qualities.indexOf(viewModel.uiState.value.streamQuality).coerceAtLeast(0)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.multipov_stream_quality)
            .setSingleChoiceItems(labels, selected) { dialog, which ->
                val quality = qualities[which]
                requireContext().prefs().edit {
                    putString(C.MULTIPOV_QUALITY, quality.prefValue)
                    // Keep legacy key in sync for older installs / resume paths.
                    putString(C.MULTIPOV_SECONDARY_QUALITY, quality.prefValue)
                }
                viewModel.setStreamQuality(quality)
                dialog.dismiss()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showTileMenu(slot: MultiPovSlot) {
        val isImmersive = immersiveKey == slot.key
        val isFocused = viewModel.uiState.value.focusedKey == slot.key
        val isPrimary = viewModel.uiState.value.slots.firstOrNull()?.key == slot.key
        val bandwidthOn = viewModel.uiState.value.bandwidthSaving
        val audioFocusLabel = getString(R.string.multipov_audio_focus)
        val items = buildList {
            if (!isFocused) add(audioFocusLabel)
            add(getString(if (isImmersive) R.string.multipov_exit_fullscreen else R.string.multipov_expand_focus))
            if (!isPrimary) add(getString(R.string.multipov_make_primary))
            add(getString(R.string.multipov_open_solo))
            add(
                getString(
                    if (bandwidthOn) R.string.multipov_bandwidth_saving_off
                    else R.string.multipov_bandwidth_saving_on
                )
            )
            add(getString(R.string.multipov_retry))
            if (viewModel.uiState.value.slots.size > 1) {
                add(getString(R.string.multipov_remove))
            }
        }.toTypedArray()
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(slot.stream.channelName ?: slot.stream.channelLogin)
            .setItems(items) { _, which ->
                val label = items[which]
                when (label) {
                    audioFocusLabel -> {
                        resetVideoZoom()
                        viewModel.setFocus(slot.key)
                        showControlsTemporarily()
                    }
                    getString(R.string.multipov_exit_fullscreen),
                    getString(R.string.multipov_expand_focus) -> {
                        viewModel.setFocus(slot.key)
                        if (isImmersive) exitImmersive() else enterImmersive(slot.key)
                    }
                    getString(R.string.multipov_make_primary) -> {
                        viewModel.moveSlotToPrimary(slot.key, alsoFocus = true)
                        view?.post { render(viewModel.uiState.value, forceGridRebuild = true) }
                    }
                    getString(R.string.multipov_open_solo) -> {
                        viewModel.setFocus(slot.key)
                        openFocusedSolo()
                    }
                    getString(R.string.multipov_bandwidth_saving_on),
                    getString(R.string.multipov_bandwidth_saving_off) -> {
                        val enabled = viewModel.toggleBandwidthSaving()
                        Toast.makeText(
                            requireContext(),
                            if (enabled) R.string.multipov_bandwidth_saving_enabled
                            else R.string.multipov_bandwidth_saving_disabled,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    getString(R.string.multipov_retry) -> retrySlot(slot)
                    getString(R.string.multipov_remove) -> removeSlot(slot.key)
                }
            }
            .show()
    }

    private fun retrySlot(slot: MultiPovSlot) {
        viewModel.retrySlot(slot.key)
        val refreshed = viewModel.uiState.value.slots.firstOrNull { it.key == slot.key }
        val url = refreshed?.resolvedUrl ?: slot.resolvedUrl
        if (!url.isNullOrBlank()) {
            playbackController?.retry(slot.key, url, focused = slot.isFocused)
        }
    }

    private fun removeSlot(key: String) {
        playbackController?.releasePlayer(key)
        viewModel.removeStream(key)
    }

    private fun confirmClose() {
        if (viewModel.uiState.value.slots.size <= 1) {
            (activity as? MainActivity)?.closeMultiPov()
            return
        }
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.multipov)
            .setMessage(R.string.multipov_close_confirm)
            .setPositiveButton(R.string.close) { _, _ ->
                (activity as? MainActivity)?.closeMultiPov()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun updateAdaptiveQuality() {
        if (!requireContext().prefs().getBoolean(C.MULTIPOV_ADAPTIVE_QUALITY, true)) {
            playbackController?.setAdaptiveMaxHeight(null)
            return
        }
        val powerManager = requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
        val thermalCap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            when (powerManager.currentThermalStatus) {
                PowerManager.THERMAL_STATUS_SEVERE,
                PowerManager.THERMAL_STATUS_CRITICAL,
                PowerManager.THERMAL_STATUS_EMERGENCY,
                PowerManager.THERMAL_STATUS_SHUTDOWN -> 360
                PowerManager.THERMAL_STATUS_MODERATE -> 480
                else -> null
            }
        } else {
            null
        }
        val cellularCap = if (networkMonitor.networkType.value == NetworkMonitor.NetworkType.CELLULAR) {
            480
        } else {
            null
        }
        val adaptive = listOfNotNull(thermalCap, cellularCap).minOrNull()
        playbackController?.setAdaptiveMaxHeight(adaptive)
    }

    private fun registerAdaptiveMonitors() {
        if (!requireContext().prefs().getBoolean(C.MULTIPOV_ADAPTIVE_QUALITY, true)) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val powerManager = requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
            val listener = PowerManager.OnThermalStatusChangedListener { updateAdaptiveQuality() }
            thermalStatusListener = listener
            runCatching {
                powerManager.addThermalStatusListener(requireContext().mainExecutor, listener)
            }
        }
    }

    private fun unregisterAdaptiveMonitors() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val powerManager = requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager
            thermalStatusListener?.let { runCatching { powerManager.removeThermalStatusListener(it) } }
        }
        thermalStatusListener = null
    }

    companion object {
        private const val ARG_STREAMS = "streams"
        private const val ARG_RESOLVED_KEYS = "resolved_keys"
        private const val ARG_RESOLVED_VALUES = "resolved_values"
        private const val ARG_FOCUSED_KEY = "focused_key"
        private const val CONTROLS_HIDE_DELAY_MS = 3_000L
        private const val FOCUS_BORDER_FLASH_MS = 1_000L
        private const val TILE_MARGIN_PX = 1
        private const val CHAT_FLING_VELOCITY = 600f

        fun newInstance(
            streams: List<Stream>,
            resolvedUrls: Map<String, String> = emptyMap(),
            focusedKey: String? = null,
        ): MultiPovFragment {
            return MultiPovFragment().apply {
                arguments = bundleOf(
                    ARG_STREAMS to ArrayList(streams),
                    ARG_RESOLVED_KEYS to ArrayList(resolvedUrls.keys),
                    ARG_RESOLVED_VALUES to ArrayList(resolvedUrls.values),
                    ARG_FOCUSED_KEY to focusedKey,
                )
            }
        }
    }
}
