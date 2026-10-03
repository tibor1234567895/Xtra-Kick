package com.xtrakick.app.ui.multipov

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Rect
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.os.IBinder
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
import com.xtrakick.app.util.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import android.view.HapticFeedbackConstants
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import com.xtrakick.app.util.isKeyboardShown
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentMultipovBinding
import com.xtrakick.app.databinding.ItemMultipovTileBinding
import com.xtrakick.app.databinding.PlayerLayoutBinding
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.ui.chat.ChatFragment
import com.xtrakick.app.ui.player.KickLivePlayback
import com.xtrakick.app.ui.common.CompactDialogs.compact
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.ui.player.IvsPlayerService
import com.xtrakick.app.ui.player.PlayerVolumeDialog
import com.xtrakick.app.ui.player.PlayerViewerListDialog
import com.xtrakick.app.ui.player.VideoZoomController
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.NetworkMonitor
import com.xtrakick.app.util.prefs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.roundToInt

@OptIn(UnstableApi::class)
@AndroidEntryPoint
class MultiPovFragment : Fragment(), MultiPovStreamPickerDialog.Listener {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private var _binding: FragmentMultipovBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MultiPovViewModel by viewModels()

    private var playbackController: MultiPovIvsPlaybackController? = null
    private var playbackService: IvsPlayerService? = null
    private var serviceConnection: ServiceConnection? = null
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
    private var dividerStartY: Float = 0f
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
    // Tracks the soft keyboard state for the POV layout; named to avoid shadowing the
    // `View.isKeyboardShown` extension imported below.
    private var keyboardVisible = false
    private var keyboardLayoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null

    /**
     * When set, only this stream fills the video area (in-MultiPOV fullscreen).
     * Other players are released while immersive to free decoders/bandwidth.
     */
    private var immersiveKey: String? = null

    /** Transient tile chrome: names + focus ring flash on interaction, then clear.
     * The audio badge stays as the only persistent focus hint. */
    private var chromeFlashActive = false
    private var lastFocusFlashForKey: String? = null
    private var lastControlsVisible = false
    private var lastAutoCatchupMs = 0L

    private val hideControlsRunnable = Runnable {
        if (isAdded && isMaximized && !isInPipMode()) {
            viewModel.setControlsVisible(false)
        }
    }

    private val hideTransientChromeRunnable = Runnable {
        if (!isAdded) return@Runnable
        chromeFlashActive = false
        tileBindings.forEach { (_, tile) ->
            tile.focusBorder.isVisible = false
            tile.channelName.isVisible = tileNamesVisible()
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
            bandwidthSaving = prefs.getBoolean(AppConstants.MULTIPOV_BANDWIDTH_SAVING, true),
            maxStreams = prefs.getInt(AppConstants.MULTIPOV_MAX_STREAMS, AppConstants.MULTIPOV_MAX_STREAMS_DEFAULT)
                .coerceIn(2, AppConstants.MULTIPOV_MAX_STREAMS_DEFAULT),
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
        isChatOpen = prefs.getBoolean(AppConstants.KEY_CHAT_OPENED, true) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
        chatOpenProgress = if (isChatOpen) 1f else 0f
        ensureChatWidthLandscape()
        val activity = requireActivity()
        WindowCompat.getInsetsController(
            activity.window,
            activity.window.decorView
        ).systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        applyOrientationLayout()
        applySystemBarInsets(view)
        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, backCallback)

        binding.focusedControls.controllerScrim.isVisible = false
        bindPlaybackService()

        playbackController = MultiPovIvsPlaybackController(
            context = requireContext().applicationContext,
            prefs = requireContext().prefs(),
            onLoadState = { key, state ->
                viewModel.updateLoadState(key, state)
                if (key == viewModel.uiState.value.focusedKey) {
                    syncFocusedToPlaybackService()
                }
            },
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
        binding.multiPovRoot.setOnClickListener {
            if (!isMaximized) maximize()
        }
        binding.videoSection.setOnClickListener {
            if (!isMaximized) maximize()
        }
        setupGestures()
        setupDividerGesture()
        updateFocusedControlsVisibility(show = false)

        val root = binding.multiPovRoot
        val keyboardListener = ViewTreeObserver.OnGlobalLayoutListener {
            if (_binding == null || !isAdded) return@OnGlobalLayoutListener
            if (root.isKeyboardShown) {
                if (!keyboardVisible) {
                    keyboardVisible = true
                    if (!isPortrait) {
                        _binding?.chatFragmentContainer?.updateLayoutParams {
                            width = (root.width / 1.8f).toInt()
                        }
                        showStatusBar()
                    }
                }
            } else {
                if (keyboardVisible) {
                    keyboardVisible = false
                    _binding?.chatFragmentContainer?.findViewById<View>(R.id.chatLayout)?.clearFocus()
                    if (!isPortrait) {
                        _binding?.chatFragmentContainer?.updateLayoutParams {
                            width = chatWidthLandscape
                        }
                        if (isMaximized) {
                            hideStatusBar()
                        }
                    }
                }
            }
        }
        keyboardLayoutListener = keyboardListener
        root.viewTreeObserver.addOnGlobalLayoutListener(keyboardListener)

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
        view.post { updatePictureInPictureParams() }
    }

    private fun showStatusBar() {
        activity?.let {
            WindowCompat.getInsetsController(it.window, it.window.decorView)
                .show(WindowInsetsCompat.Type.systemBars())
        }
    }

    private fun hideStatusBar() {
        activity?.let {
            WindowCompat.getInsetsController(it.window, it.window.decorView)
                .hide(WindowInsetsCompat.Type.systemBars())
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
            val ignoreCutouts = root.context.prefs().getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)
            val insets = if (!isPortrait && ignoreCutouts) {
                windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            } else {
                windowInsets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
                )
            }
            // Portrait keeps the status bar visible like the solo player — the
            // player starts below it. Landscape is edge-to-edge, bar hidden.
            val topInset = if (isPortrait) insets.top else 0
            _binding?.multiPovRoot?.updatePadding(top = topInset)
            // Session bar under status bar; focused player chrome underneath.
            _binding?.multiPovToolsBar?.updatePadding(
                left = baseHorizontal + insets.left,
                top = baseVertical + (insets.top - topInset),
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

    private fun bindPlaybackService() {
        if (serviceConnection != null) return
        val connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val boundService = (service as? IvsPlayerService.ServiceBinder)?.getService() ?: return
                playbackService = boundService
                boundService.attachMultiPovSession(object : IvsPlayerService.MultiPovDelegate {
                    override fun isPlaying(): Boolean {
                        val focusedKey = viewModel.uiState.value.focusedKey
                        return playbackController?.isPlaying(focusedKey) == true
                    }

                    override fun onPlay() {
                        val focusedKey = viewModel.uiState.value.focusedKey
                        playbackController?.setPaused(focusedKey, false)
                        syncFocusedToPlaybackService()
                        updatePlayPauseIcon(true)
                    }

                    override fun onPause() {
                        val focusedKey = viewModel.uiState.value.focusedKey
                        playbackController?.setPaused(focusedKey, true)
                        syncFocusedToPlaybackService()
                        updatePlayPauseIcon(false)
                    }
                })
                syncFocusedToPlaybackService()
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                playbackService = null
            }
        }
        serviceConnection = connection
        val intent = Intent(requireContext(), IvsPlayerService::class.java)
        try {
            requireContext().startService(intent)
        } catch (e: Exception) {
            DiagnosticLogger.w("MultiPovFragment", "Failed to start IvsPlayerService for MultiPOV", e)
        }
        requireContext().bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun unbindPlaybackService() {
        playbackService?.detachMultiPovSession()
        serviceConnection?.let {
            runCatching { requireContext().unbindService(it) }
        }
        serviceConnection = null
        playbackService = null
    }

    private fun syncFocusedToPlaybackService() {
        val service = playbackService ?: return
        val focused = viewModel.uiState.value.focusedSlot
        val stream = focused?.stream
        val url = focused?.resolvedUrl
        val isPlaying = playbackController?.isPlaying(focused?.key) == true
        service.updateMultiPovFocus(
            stream = stream,
            url = url,
            isPlaying = isPlaying,
        )
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
            val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())
            val chatBarToggleEnabled = prefs.getBoolean(AppConstants.PLAYER_CHATBARTOGGLE, false)
            val chatDisabled = prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
            toggleChatInput.isVisible = isLoggedIn && chatBarToggleEnabled && !chatDisabled
            toggleChatInput.setOnClickListener {
                showControlsTemporarily()
                toggleChatBar()
            }

            playPause.isVisible = prefs.getBoolean(AppConstants.PLAYER_PAUSE, false)
            playPause.setOnClickListener {
                togglePlayPause()
                showControlsTemporarily()
            }

            // MultiPOV session bar already has close; keep minimize as solo-style collapse.
            minimize.isVisible = prefs.getBoolean(AppConstants.PLAYER_MINIMIZE, true)
            minimize.setOnClickListener { minimize() }

            volume.isVisible = prefs.getBoolean(AppConstants.PLAYER_VOLUMEBUTTON, true)
            updateVolumeButtonVisual()
            volume.setOnClickListener {
                showControlsTemporarily()
                showVolumeDialog()
            }

            audioCompressor.isVisible = prefs.getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR_BUTTON, true)
            audioCompressor.setOnClickListener {
                showControlsTemporarily()
                val key = viewModel.uiState.value.focusedKey
                val enabled = playbackController?.toggleCompressor(key) == true
                updateCompressorIcon(enabled)
            }

            restart.isVisible = prefs.getBoolean(AppConstants.PLAYER_RESTART, true)
            restart.setOnClickListener {
                showControlsTemporarily()
                restartFocused()
            }

            seekLive.isVisible = prefs.getBoolean(AppConstants.PLAYER_SEEKLIVE, false)
            seekLive.setOnClickListener {
                showControlsTemporarily()
                playbackController?.seekToLive(viewModel.uiState.value.focusedKey)
            }

            quality.isVisible = prefs.getBoolean(AppConstants.PLAYER_SETTINGS, true)
            quality.setOnClickListener {
                showControlsTemporarily()
                showStreamQualityDialog()
            }

            menu.isVisible = prefs.getBoolean(AppConstants.PLAYER_MENU, true)
            menu.setOnClickListener {
                showControlsTemporarily()
                showFocusedPlayerMenu()
            }

            toggleChat.isVisible = prefs.getBoolean(AppConstants.PLAYER_CHATTOGGLE, true) &&
                !chatDisabled
            toggleChat.setOnClickListener {
                showControlsTemporarily()
                toggleChat()
            }

            fullscreen.isVisible = prefs.getBoolean(AppConstants.PLAYER_FULLSCREEN, true)
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
                if (prefs.getBoolean(AppConstants.PLAYER_VIEWERLIST, false)) {
                    showFocusedViewerList()
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

    private fun isCompactHeight(): Boolean {
        val rootW = _binding?.multiPovRoot?.width ?: 0
        return isPortrait && rootW > 0 && ((_binding?.videoSection?.height ?: 0) < rootW * 9 / 16)
    }

    private fun bindFocusedStreamChrome() {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        val focused = viewModel.uiState.value.focusedSlot
        val stream = focused?.stream
        val key = focused?.key
        val isCompact = isCompactHeight()
        val density = resources.displayMetrics.density

        with(controls) {
            if (isCompact) {
                topLeftLayout.isVisible = false
                topRightLayout.isVisible = false
                playPause.isVisible = false
                restart.isVisible = false
                seekLive.isVisible = false
                audioCompressor.isVisible = false
                uptimeLayout.isVisible = false
                latencyLayout.isVisible = false
                toggleChat.isVisible = false
                toggleChatInput.isVisible = false

                // Bottom left has ONLY volume — no crowding
                volume.isVisible = prefs.getBoolean(AppConstants.PLAYER_VOLUMEBUTTON, true)

                // Bottom right has quality, fullscreen, menu
                if (quality.parent == topRightLayout) {
                    topRightLayout.removeView(quality)
                    topRightLayout.removeView(menu)
                    bottomRightLayout.addView(quality, 0)
                    bottomRightLayout.addView(menu)
                }
                quality.isVisible = prefs.getBoolean(AppConstants.PLAYER_SETTINGS, true)
                fullscreen.isVisible = prefs.getBoolean(AppConstants.PLAYER_FULLSCREEN, true)
                menu.isVisible = prefs.getBoolean(AppConstants.PLAYER_MENU, true)

                bottomLeftLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    bottomMargin = (2 * density).toInt()
                }
                bottomRightLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    bottomMargin = (2 * density).toInt()
                }
            } else {
                if (quality.parent == bottomRightLayout) {
                    bottomRightLayout.removeView(quality)
                    bottomRightLayout.removeView(menu)
                    topRightLayout.addView(quality)
                    topRightLayout.addView(menu)
                }
                val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())
                val chatBarToggleEnabled = prefs.getBoolean(AppConstants.PLAYER_CHATBARTOGGLE, false)
                val chatDisabled = prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
                topRightLayout.isVisible = true
                topLeftLayout.isVisible = true
                playPause.isVisible = prefs.getBoolean(AppConstants.PLAYER_PAUSE, false)
                restart.isVisible = prefs.getBoolean(AppConstants.PLAYER_RESTART, true)
                seekLive.isVisible = prefs.getBoolean(AppConstants.PLAYER_SEEKLIVE, false)
                audioCompressor.isVisible = prefs.getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR_BUTTON, true)
                volume.isVisible = prefs.getBoolean(AppConstants.PLAYER_VOLUMEBUTTON, true)
                toggleChatInput.isVisible = isLoggedIn && chatBarToggleEnabled && !chatDisabled
                toggleChat.isVisible = prefs.getBoolean(AppConstants.PLAYER_CHATTOGGLE, true) && !chatDisabled
                quality.isVisible = prefs.getBoolean(AppConstants.PLAYER_SETTINGS, true)
                fullscreen.isVisible = prefs.getBoolean(AppConstants.PLAYER_FULLSCREEN, true)
                menu.isVisible = prefs.getBoolean(AppConstants.PLAYER_MENU, true)

                bottomLeftLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    bottomMargin = (8 * density).toInt()
                }
                bottomRightLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    bottomMargin = (8 * density).toInt()
                }
            }
            channel.isVisible = false
            title.apply {
                val t = stream?.title?.trim()
                if (!isCompact && !t.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_TITLE, true)) {
                    text = t
                    isVisible = true
                } else {
                    isVisible = false
                }
            }
            category.apply {
                val game = stream?.gameName
                if (!isCompact && !game.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_CATEGORY, true)) {
                    text = game
                    isVisible = true
                } else {
                    isVisible = false
                }
            }
            val viewers = stream?.viewerCount
            if (viewers != null && !isCompact) {
                viewersText.text = KickApiHelper.formatCount(
                    viewers,
                    prefs.getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true),
                )
                viewersText.isVisible = true
                viewersIcon.isVisible = prefs.getBoolean(AppConstants.PLAYER_VIEWERICON, true)
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
            updateVolumeButtonVisual(getCurrentVolume())
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
        if (isCompact) {
            _binding?.multiPovToolsBar?.updatePadding(
                top = (2 * density).toInt(),
                bottom = (2 * density).toInt(),
            )
            _binding?.multiPovToolsBar?.setBackgroundColor(Color.parseColor("#99000000"))
        } else {
            _binding?.multiPovToolsBar?.updatePadding(
                top = (4 * density).toInt(),
                bottom = (4 * density).toInt(),
            )
            _binding?.multiPovToolsBar?.setBackgroundColor(Color.parseColor("#E6000000"))
        }
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
                        PlayerVolumeDialog.getVolumeIconRes(getCurrentVolume()),
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
        if (!isCompactHeight() && startedMs != null && prefs.getBoolean(AppConstants.PLAYER_SHOW_UPTIME, true)) {
            controls.uptimeLayout.isVisible = true
            controls.uptimeTimer.base =
                SystemClock.elapsedRealtime() + startedMs - System.currentTimeMillis()
            controls.uptimeTimer.start()
            controls.uptimeIcon.isVisible = prefs.getBoolean(AppConstants.PLAYER_VIEWERICON, true)
        } else {
            controls.uptimeLayout.isVisible = false
        }
    }

    private fun updateLatencyDisplay(liveOffsetMs: Long?) {
        val controls = focusedControls() ?: return
        val prefs = requireContext().prefs()
        if (!isCompactHeight() && liveOffsetMs != null && prefs.getBoolean(AppConstants.PLAYER_SHOW_LATENCY, true)) {
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
        if (!requireContext().prefs().getBoolean(AppConstants.PLAYER_SHOW_LATENCY, true)) return
        latencyPollJob = viewLifecycleOwner.lifecycleScope.launch {
            while (isActive) {
                val key = viewModel.uiState.value.focusedKey
                val offset = playbackController?.getLiveOffsetMs(key)
                updateLatencyDisplay(offset)
                // Pull back to live when drift gets big. Quality untouched.
                // Cooldown so we don't seek-loop on a struggling connection.
                if (offset != null && offset > 5_000L) {
                    val now = SystemClock.elapsedRealtime()
                    if (now - lastAutoCatchupMs > 10_000L) {
                        lastAutoCatchupMs = now
                        playbackController?.seekToLive(key)
                    }
                }
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

    fun updateVolumeButtonVisual(volumeFraction: Float = getCurrentVolume()) {
        focusedControls()?.volume?.setImageResource(
            PlayerVolumeDialog.getVolumeIconRes(volumeFraction)
        )
    }

    private var preMuteVolume: Float? = null
    private var isVolumeReduced: Boolean = false

    private fun getPipReducedVolume(): Float {
        val ctx = context ?: return 0f
        return ctx.prefs().getInt(AppConstants.PIP_REDUCED_VOLUME_LEVEL, 0).coerceIn(0, 50) / 100f
    }

    private fun isVolumeDuckedOrMuted(currentVol: Float, targetVol: Float): Boolean =
        isVolumeReduced || currentVol <= 0f || (targetVol > 0f && currentVol <= targetVol)

    fun toggleMute() {
        val targetVol = getPipReducedVolume()
        val currentVol = getCurrentVolume()
        val prefs = context?.prefs()

        if (isVolumeDuckedOrMuted(currentVol, targetVol)) {
            isVolumeReduced = false
            val minRestore = if (targetVol > 0f) targetVol else 0f
            val restore = preMuteVolume?.takeIf { it > minRestore }
                ?: prefs?.getFloat(AppConstants.PLAYER_PRE_MUTE_VOLUME, -1f)?.takeIf { it > minRestore }
                ?: (prefs?.getInt(AppConstants.PLAYER_VOLUME, 100)?.takeIf { it > (minRestore * 100).toInt() }?.toFloat()?.div(100f) ?: 1f)
            changeVolume(restore)
        } else {
            isVolumeReduced = true
            preMuteVolume = currentVol
            prefs?.edit { putFloat(AppConstants.PLAYER_PRE_MUTE_VOLUME, currentVol) }
            changeVolume(targetVol)
        }
    }

    fun togglePlayPause(): Boolean {
        val key = viewModel.uiState.value.focusedKey ?: return false
        val playing = playbackController?.togglePlayPause(key) == true
        updatePlayPauseIcon(playing)
        syncFocusedToPlaybackService()
        updatePictureInPictureParams()
        return playing
    }

    fun changeVolume(volume: Float) {
        val targetVol = getPipReducedVolume()
        if (volume > targetVol) {
            preMuteVolume = volume
            isVolumeReduced = false
        }
        playbackController?.setVolume(viewModel.uiState.value.focusedKey, volume)
        updateVolumeButtonVisual(volume)
        context?.prefs()?.edit { putInt(AppConstants.PLAYER_VOLUME, (volume * 100f).toInt()) }
        updatePictureInPictureParams()
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
        val prefs = requireContext().prefs()
        val chatDisabled = prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
        val isLoggedIn = com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())
        val chatFrag = childFragmentManager.findFragmentById(R.id.chatFragmentContainer) as? ChatFragment
        val items = buildList {
            add(getString(R.string.multipov_stream_quality))
            add(getString(R.string.multipov_add_stream))
            if (viewModel.uiState.value.slots.size >= 2) {
                add(getString(R.string.multipov_cycle_layout))
                add(getString(R.string.multipov_rotate_order))
            }
            if (canEnterPictureInPicture()) {
                add(getString(R.string.picture_in_picture))
            }
            val bw = viewModel.uiState.value.bandwidthSaving
            add(
                getString(
                    if (bw) R.string.multipov_bandwidth_saving_off
                    else R.string.multipov_bandwidth_saving_on
                )
            )
            add(getString(R.string.restart_player))
            if (!chatDisabled) {
                if (isLoggedIn && prefs.getBoolean(AppConstants.PLAYER_MENU_CHAT_BAR, true)) {
                    val isChatBarVisible = prefs.getBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true)
                    add(getString(if (isChatBarVisible) R.string.hide_chat_bar else R.string.show_chat_bar))
                }
                if (prefs.getBoolean(AppConstants.PLAYER_MENU_CHAT_TOGGLE, true)) {
                    add(getString(if (isChatOpen) R.string.hide_chat else R.string.show_chat))
                }
                if (prefs.getBoolean(AppConstants.PLAYER_MENU_CHAT_DISCONNECT, true)) {
                    if (chatFrag?.isActive() == true) {
                        add(getString(R.string.disconnect_chat))
                    } else {
                        add(getString(R.string.connect_chat))
                    }
                }
            }
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
                    getString(R.string.picture_in_picture) -> enterFocusedPip()
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
                    getString(R.string.hide_chat_bar),
                    getString(R.string.show_chat_bar) -> toggleChatBar()
                    getString(R.string.hide_chat),
                    getString(R.string.show_chat) -> toggleChat()
                    getString(R.string.disconnect_chat) -> chatFrag?.disconnect()
                    getString(R.string.connect_chat) -> chatFrag?.reconnect()
                    getString(R.string.multipov_remove) ->
                        viewModel.uiState.value.focusedKey?.let { removeSlot(it) }
                    getString(R.string.multipov_open_solo) -> openFocusedSolo()
                }
            }
            .show().also { it.compact() }
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
        val shellTouchListener = View.OnTouchListener { v, event ->
            if (!isMaximized) {
                if (event.actionMasked == MotionEvent.ACTION_UP) {
                    v.performClick()
                }
                return@OnTouchListener true
            }
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

    @SuppressLint("ClickableViewAccessibility")
    private fun setupDividerGesture() {
        val binding = _binding ?: return
        val detector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onDoubleTap(e: MotionEvent): Boolean {
                val current = currentLayoutPreset()
                val target = if (current == MultiPovLayoutPreset.PRIMARY_TOP) MultiPovLayoutPreset.EQUAL else MultiPovLayoutPreset.PRIMARY_TOP
                android.transition.TransitionManager.beginDelayedTransition(
                    binding.multiPovRoot,
                    android.transition.AutoTransition().apply {
                        duration = 200L
                        interpolator = DecelerateInterpolator()
                    },
                )
                requireContext().prefs().edit {
                    putString(AppConstants.MULTIPOV_LAYOUT, target.prefValue)
                }
                applyPortraitChatLayout()
                render(viewModel.uiState.value, forceGridRebuild = true)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.multipov_layout_toast, getString(target.labelRes(isPortrait))),
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }
        })
        var initialPreset: MultiPovLayoutPreset = currentLayoutPreset()
        var initialVideoHeight: Int = 0
        var hoveredPreset: MultiPovLayoutPreset = currentLayoutPreset()
        var isDraggingDivider = false

        binding.chatDivider.setOnTouchListener { _, event ->
            detector.onTouchEvent(event)
            val root = _binding?.multiPovRoot ?: return@setOnTouchListener false
            val total = root.height - root.paddingTop
            if (total <= 0 || !isPortrait) return@setOnTouchListener false

            val count = viewModel.uiState.value.slots.size
            val unit = root.width * 9f / 16f
            val hEqual = (unit * solvePortraitRows(count, MultiPovLayoutPreset.EQUAL).sumOf { it.heightFactor.toDouble() }).roundToInt()
            val hLargeTop = (unit * solvePortraitRows(count, MultiPovLayoutPreset.PRIMARY_TOP).sumOf { it.heightFactor.toDouble() }).roundToInt()
            val hStacked = (unit * solvePortraitRows(count, MultiPovLayoutPreset.PRIMARY_LEFT).sumOf { it.heightFactor.toDouble() }).roundToInt()
            val thresh1 = (hEqual + hLargeTop) / 2
            val thresh2 = (hLargeTop + hStacked) / 2

            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    dividerStartY = event.rawY
                    initialPreset = currentLayoutPreset()
                    hoveredPreset = initialPreset
                    initialVideoHeight = binding.videoSection.height.coerceAtLeast(1)
                    isDraggingDivider = true
                    binding.tileGrid.pivotY = 0f
                    binding.tileGrid.pivotX = root.width / 2f

                    binding.chatDividerHandle.animate().scaleX(1.2f).scaleY(1.2f).setDuration(120).start()
                    binding.chatDividerHandle.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#53FC18"))

                    // Reveal mode badge
                    binding.chatDividerLabel.text = getString(hoveredPreset.labelRes(isPortrait))
                    binding.chatDividerLabel.alpha = 0f
                    binding.chatDividerLabel.isVisible = true
                    binding.chatDividerLabel.animate().alpha(1f).setDuration(120).start()
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    if (!isDraggingDivider) return@setOnTouchListener false
                    val delta = event.rawY - dividerStartY
                    val candidateH = (initialVideoHeight + delta).coerceIn((total * 0.15f), (total * 0.85f))
                    val transY = candidateH - initialVideoHeight

                    // Real-time video scaling with divider drag
                    val scale = (candidateH / initialVideoHeight.toFloat()).coerceIn(0.6f, 2.5f)
                    binding.tileGrid.scaleY = scale
                    binding.tileGrid.scaleX = scale

                    // Smooth 1:1 real-time translation of divider and chat
                    binding.chatDivider.translationY = transY
                    binding.chatFragmentContainer.translationY = transY

                    val newHoverPreset = when {
                        candidateH < thresh1 -> MultiPovLayoutPreset.EQUAL
                        candidateH <= thresh2 -> MultiPovLayoutPreset.PRIMARY_TOP
                        else -> MultiPovLayoutPreset.PRIMARY_LEFT
                    }
                    if (newHoverPreset != hoveredPreset) {
                        hoveredPreset = newHoverPreset
                        binding.chatDividerLabel.text = getString(newHoverPreset.labelRes(isPortrait))
                        binding.chatDividerLabel.animate().scaleX(1.15f).scaleY(1.15f).setDuration(80).withEndAction {
                            binding.chatDividerLabel.animate().scaleX(1f).scaleY(1f).setDuration(80).start()
                        }.start()
                        view?.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
                    }
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    if (!isDraggingDivider) return@setOnTouchListener false
                    isDraggingDivider = false
                    val targetPreset = hoveredPreset
                    val targetHeight = when (targetPreset) {
                        MultiPovLayoutPreset.EQUAL -> hEqual
                        MultiPovLayoutPreset.PRIMARY_TOP -> hLargeTop
                        else -> hStacked
                    }
                    val startTrans = binding.chatDivider.translationY
                    val endTrans = (targetHeight - initialVideoHeight).toFloat()
                    val startScale = binding.tileGrid.scaleY
                    val endScale = targetHeight.toFloat() / initialVideoHeight.toFloat()

                    // Smooth deceleration animation to snap directly into the target position
                    ValueAnimator.ofFloat(0f, 1f).apply {
                        duration = 180L
                        interpolator = DecelerateInterpolator()
                        addUpdateListener { va ->
                            val frac = va.animatedFraction
                            val currentTrans = startTrans + (endTrans - startTrans) * frac
                            val currentScale = startScale + (endScale - startScale) * frac
                            binding.chatDivider.translationY = currentTrans
                            binding.chatFragmentContainer.translationY = currentTrans
                            binding.tileGrid.scaleY = currentScale
                            binding.tileGrid.scaleX = currentScale
                        }
                        addListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                binding.tileGrid.scaleX = 1f
                                binding.tileGrid.scaleY = 1f
                                binding.chatDivider.translationY = 0f
                                binding.chatFragmentContainer.translationY = 0f
                                binding.chatDividerHandle.backgroundTintList = null
                                binding.chatDividerHandle.animate().scaleX(1.0f).scaleY(1.0f).setDuration(120).start()
                                binding.chatDividerLabel.animate().alpha(0f).setDuration(120).withEndAction {
                                    binding.chatDividerLabel.isVisible = false
                                }.start()

                                android.transition.TransitionManager.beginDelayedTransition(
                                    binding.multiPovRoot,
                                    android.transition.AutoTransition().apply {
                                        duration = 200L
                                        interpolator = DecelerateInterpolator()
                                    },
                                )
                                requireContext().prefs().edit {
                                    putString(AppConstants.MULTIPOV_LAYOUT, targetPreset.prefValue)
                                }
                                applyPortraitChatLayout()
                                render(viewModel.uiState.value, forceGridRebuild = true)
                                if (targetPreset != initialPreset) {
                                    Toast.makeText(
                                        requireContext(),
                                        getString(R.string.multipov_layout_toast, getString(targetPreset.labelRes(isPortrait))),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        })
                        start()
                    }
                    true
                }
                else -> false
            }
        }
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

    private fun showFocusedViewerList() {
        val slot = viewModel.uiState.value.focusedSlot ?: return
        val stream = slot.stream
        val cid = stream.channelId
        val login = stream.channelLogin ?: stream.channelName
        val name = stream.channelName ?: stream.channelLogin
        PlayerViewerListDialog.newInstance(
            channelId = cid,
            channelLogin = login,
            channelName = name,
        ).show(childFragmentManager, "closeOnPip")
    }

    override fun onStart() {
        super.onStart()
        // Cancel pending grace-period pause if user returned quickly.
        backgroundPauseRunnable?.let { view?.removeCallbacks(it) }
        backgroundPauseRunnable = null
        val inPip = isInPipMode()
        if (!inPip) {
            playbackController?.resumeAll()
            syncFocusedToPlaybackService()
        }
    }

    override fun onStop() {
        val inPip = isInPipMode()
        if (!inPip && requireContext().prefs().getBoolean(AppConstants.MULTIPOV_PAUSE_INACTIVE_ON_BACKGROUND, true)) {
            // Grace period: avoid re-buffer if user accidentally hid or rotated and comes back quickly.
            // When optimization is ON:
            // - if background audio is allowed, keep focused stream audible, pause others after grace
            // - otherwise pause all after grace
            val prefs = requireContext().prefs()
            val keepFocusedAudible = prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO, true) ||
                prefs.getString(AppConstants.PLAYER_BACKGROUND_PLAYBACK, "0") != "0" ||
                prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO_LOCKED, true)
            val runnable = Runnable {
                if (!isAdded || isInPipMode()) return@Runnable
                if (keepFocusedAudible && viewModel.uiState.value.focusedKey != null) {
                    playbackController?.pauseSecondaries()
                } else {
                    playbackController?.pauseAll()
                    playbackService?.setMultiPovPlayingState(false)
                }
            }
            backgroundPauseRunnable = runnable
            view?.postDelayed(runnable, backgroundGraceMs)
        }
        super.onStop()
    }

    override fun onDestroyView() {
        showStatusBar()
        backgroundPauseRunnable?.let { view?.removeCallbacks(it) }
        backgroundPauseRunnable = null
        cancelHideControls()
        view?.removeCallbacks(hideTransientChromeRunnable)
        chatProgressAnimator?.cancel()
        chatProgressAnimator = null
        velocityTracker?.recycle()
        velocityTracker = null
        keyboardLayoutListener?.let {
            _binding?.multiPovRoot?.viewTreeObserver?.removeOnGlobalLayoutListener(it)
        }
        keyboardLayoutListener = null
        stopLatencyPolling()
        chatDragActive = false
        chatDragCandidate = false
        chromeFlashActive = false
        lastFocusFlashForKey = null
        unregisterAdaptiveMonitors()
        unbindPlaybackService()
        playbackController?.releaseAll()
        playbackController = null
        tileBindings.clear()
        currentChatKey = null
        lastGridSignature = emptyList()
        immersiveKey = null
        resetVideoZoom()
        videoZoom = null
        _binding = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            runCatching {
                activity?.setPictureInPictureParams(
                    PictureInPictureParams.Builder().setAutoEnterEnabled(false).build()
                )
            }
        }
        super.onDestroyView()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (isInPipMode()) return
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
        view?.post { updatePictureInPictureParams() }
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
        val ctx = context ?: return false
        val prefs = ctx.prefs()
        return isMaximized &&
            viewModel.uiState.value.focusedSlot != null &&
            prefs.getBoolean(AppConstants.MULTIPOV_PIP_FOCUSED, true) &&
            prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
    }

    fun enterFocusedPip(): Boolean {
        if (!canEnterPictureInPicture()) return false
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
        val act = activity ?: return false
        if (!act.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            return false
        }
        return try {
            val builder = PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16, 9))
            val focusedKey = viewModel.uiState.value.focusedKey
            val focusedView = focusedKey?.let { tileBindings[it]?.root }
            if (focusedView != null && focusedView.isAttachedToWindow && focusedView.isShown) {
                val rect = Rect()
                focusedView.getGlobalVisibleRect(rect)
                if (!rect.isEmpty) {
                    builder.setSourceRectHint(rect)
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                builder.setSeamlessResizeEnabled(true)
            }
            act.enterPictureInPictureMode(builder.build())
        } catch (_: IllegalStateException) {
            false
        }
    }

    fun updatePictureInPictureParams() {
        val act = activity ?: return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
            act.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) &&
            isAdded
        ) {
            val canPip = canEnterPictureInPicture()
            val inPip = isInPipMode()
            val prefs = act.prefs()
            val builder = PictureInPictureParams.Builder().apply {
                setAspectRatio(Rational(16, 9))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    setSeamlessResizeEnabled(true)
                    setAutoEnterEnabled(!inPip && canPip)
                }
                val focusedKey = viewModel.uiState.value.focusedKey
                val focusedView = focusedKey?.let { tileBindings[it]?.root }
                if (focusedView != null && focusedView.isAttachedToWindow && focusedView.isShown) {
                    val rect = Rect()
                    focusedView.getGlobalVisibleRect(rect)
                    if (!rect.isEmpty) {
                        setSourceRectHint(rect)
                    }
                }

                val actions = mutableListOf<RemoteAction>()
                val isPlaying = playbackController?.isPlaying(focusedKey) == true
                actions.add(
                    if (isPlaying) {
                        RemoteAction(
                            Icon.createWithResource(act, R.drawable.baseline_pause_black_48),
                            getString(R.string.pause),
                            getString(R.string.pause),
                            PendingIntent.getBroadcast(
                                act,
                                REQUEST_CODE_PLAY_PAUSE,
                                Intent(MainActivity.INTENT_PLAY_PAUSE_PLAYER).setPackage(act.packageName),
                                PendingIntent.FLAG_IMMUTABLE,
                            ),
                        )
                    } else {
                        RemoteAction(
                            Icon.createWithResource(act, R.drawable.baseline_play_arrow_black_48),
                            getString(R.string.resume),
                            getString(R.string.resume),
                            PendingIntent.getBroadcast(
                                act,
                                REQUEST_CODE_PLAY_PAUSE,
                                Intent(MainActivity.INTENT_PLAY_PAUSE_PLAYER).setPackage(act.packageName),
                                PendingIntent.FLAG_IMMUTABLE,
                            ),
                        )
                    },
                )

                if (prefs.getBoolean(AppConstants.PIP_SHOW_MUTE, true)) {
                    val targetVol = getPipReducedVolume()
                    val currentVol = getCurrentVolume()
                    val isLowered = isVolumeDuckedOrMuted(currentVol, targetVol)
                    val iconRes = PlayerVolumeDialog.getVolumeIconRes(currentVol)
                    val actionTitle = when {
                        isLowered -> if (targetVol == 0f) getString(R.string.unmute) else getString(R.string.restore_volume)
                        else -> if (targetVol == 0f) getString(R.string.mute) else getString(R.string.lower_volume)
                    }
                    actions.add(
                        RemoteAction(
                            Icon.createWithResource(act, iconRes),
                            actionTitle,
                            actionTitle,
                            PendingIntent.getBroadcast(
                                act,
                                REQUEST_CODE_MUTE_UNMUTE,
                                Intent(MainActivity.INTENT_MUTE_UNMUTE_PLAYER).setPackage(act.packageName),
                                PendingIntent.FLAG_IMMUTABLE,
                            ),
                        ),
                    )
                }

                setActions(actions)
            }
            try {
                act.setPictureInPictureParams(builder.build())
            } catch (_: Exception) {}
        }
    }

    fun minimize() {
        if (!isMaximized) return
        isMaximized = false
        showStatusBar()
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
        backCallback.isEnabled = false
        updatePictureInPictureParams()
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
        if (isPortrait) {
            showStatusBar()
        } else {
            hideStatusBar()
        }
        applyOrientationLayout(rebuildTiles = false)
        playbackController?.resumeSecondaries()
        render(viewModel.uiState.value, forceGridRebuild = true)
        showControlsTemporarily()
        backCallback.isEnabled = true
        view?.post { updatePictureInPictureParams() }
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
        binding.multiPovRoot.apply {
            scaleX = 1f
            scaleY = 1f
            translationX = 0f
            translationY = 0f
        }
        binding.videoSection.apply {
            translationX = 0f
            translationY = 0f
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER,
            ).apply { marginEnd = 0 }
        }
        rebuildGrid(viewModel.uiState.value)
    }

    private fun exitPipUi() {
        if (!isAdded) return
        tileBindings.values.forEach {
            it.root.isVisible = true
            it.tileChrome.isVisible = true
        }
        if (isMaximized) {
            playbackController?.resumeSecondaries()
            applyOrientationLayout(rebuildTiles = false)
            render(viewModel.uiState.value, forceGridRebuild = true)
        } else {
            minimize()
        }
        view?.post { updatePictureInPictureParams() }
    }

    private fun isInPipMode(): Boolean {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> activity?.isInPictureInPictureMode == true
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
                }
            }
            controller.pauseSecondaries()
            return
        }

        // Floating chrome — GONE when hidden so video is fully visible.
        updateFocusedControlsVisibility(show = state.isControlsVisible && isMaximized)
        binding.minimizeBadge.text = getString(R.string.multipov_badge, state.slots.size)
        updateExpandButtonIcon()

        controller.setStreamQuality(state.streamQuality)
        controller.setBandwidthSaving(state.bandwidthSaving)
        controller.setFocus(state.focusedKey, crossfade = isMaximized)

        // Ring + names flash on focus change; audio badge stays as the persistent hint.
        val focused = state.focusedKey
        if (focused != null && focused != lastFocusFlashForKey) {
            lastFocusFlashForKey = focused
            flashFocusBorder(focused)
        }
        // Grace flash when controls hide, so chrome doesn't pop off abruptly.
        if (lastControlsVisible && !state.isControlsVisible) {
            startChromeFlash()
        }
        lastControlsVisible = state.isControlsVisible

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
            // Tiles recreated — bindTileChrome below restores persistent ring/badges.
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
                // IVS fails fast on bare unsigned candidates, so hold new tiles on
                // the spinner until the signed URL lands instead of flashing an error.
                viewModel.isPlayableUrl(url) -> {
                    // isPlayableUrl true implies non-blank; orEmpty is unreachable.
                    controller.ensurePlaying(slot.key, url.orEmpty(), focused = slot.isFocused)
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
        // Portrait chat layout tracks grid/immersive/preset/count changes;
        // applyHeights no-ops when nothing moved.
        if (isPortrait && isMaximized) {
            applyPortraitChatLayout()
        }
        updateChat(state.focusedSlot)
        syncFocusedToPlaybackService()

        if (state.slots.isEmpty()) {
            (activity as? MainActivity)?.closeMultiPov()
        }
        view?.post { updatePictureInPictureParams() }
    }

    private fun currentLayoutPreset(): MultiPovLayoutPreset {
        return MultiPovLayoutPreset.fromPrefs(requireContext().prefs())
    }

    private fun cycleLayoutPreset() {
        val next = currentLayoutPreset().next()
        requireContext().prefs().edit {
            putString(AppConstants.MULTIPOV_LAYOUT, next.prefValue)
        }
        Toast.makeText(
            requireContext(),
            getString(R.string.multipov_layout_toast, getString(next.labelRes(isPortrait))),
            Toast.LENGTH_SHORT
        ).show()
        render(viewModel.uiState.value, forceGridRebuild = true)
    }

    private fun showLayoutPickerDialog() {
        val presets = MultiPovLayoutPreset.entries.toList()
        val labels = presets.map { getString(it.labelRes(isPortrait)) }.toTypedArray()
        val selected = presets.indexOf(currentLayoutPreset()).coerceAtLeast(0)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.multipov_layout)
            .setSingleChoiceItems(labels, selected) { dialog, which ->
                val chosen = presets[which]
                requireContext().prefs().edit {
                    putString(AppConstants.MULTIPOV_LAYOUT, chosen.prefValue)
                }
                dialog.dismiss()
                render(viewModel.uiState.value, forceGridRebuild = true)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.multipov_layout_toast, getString(chosen.labelRes(isPortrait))),
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show().also { it.compact() }
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

        // Reuse surviving tile views so their surfaces never drop: only gone
        // slots are detached. Reparenting keeps TextureViews (and frames) alive.
        val liveKeys = state.slots.map { it.key }.toSet()
        tileBindings.keys.filter { it !in liveKeys }.forEach {
            controller.detachSurface(it)
            tileBindings.remove(it)
        }
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

        // PiP mode: focused stream fills the floating window.
        if (isInPipMode()) {
            val pipSlot = state.slots.firstOrNull { it.key == state.focusedKey }
                ?: state.slots.firstOrNull { it.isFocused }
                ?: state.slots.firstOrNull()
            if (pipSlot != null) {
                addFullBleedTile(grid, pipSlot)
            }
            return
        }

        val slots = state.slots
        if (slots.isEmpty()) return

        val preset = currentLayoutPreset()
        val landscape = !isPortrait

        when {
            // Portrait: one solver defines the rows, one builder places them —
            // heights and tiles can never disagree.
            isPortrait && slots.size >= 2 ->
                buildPortraitGrid(grid, slots, solvePortraitRows(slots.size, preset))
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
        // Same stream already has a live view: rebind chrome + gestures onto it
        // instead of inflating. The TextureView (and its surface) survives the
        // reparent, so playback never blinks on add/remove/layout changes.
        tileBindings[slot.key]?.let { existing ->
            bindTileChrome(existing, slot)
            wireTileInteractions(existing, slot)
            // Drop from the previous row first: a view can only have one parent.
            (existing.root.parent as? ViewGroup)?.removeView(existing.root)
            return existing.root
        }
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
                // Two jobs, split by target so they can't collide:
                // - tap another tile = silent sound swap, overlay stays off
                // - tap the loud tile = toggle the main overlay
                // Menu mode needs no extra guard: the open overlay covers the
                // tiles and eats stray taps, so focus can't jump mid-menu.
                if (viewModel.uiState.value.focusedKey != slot.key) {
                    viewModel.setFocus(slot.key)
                    tileBindings[slot.key]?.let { pulseTile(it) }
                } else {
                    toggleControls()
                }
                return true
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                if (suppressTileMenu) return true
                // Immersive toggle rebuilds the grid mid-gesture; the old detector
                // never sees ACTION_UP, so its pending long-press would open the
                // tile menu right after every double-tap.
                suppressTileMenu = true
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
        tileBinding.root.setOnClickListener {
            if (!isMaximized) maximize()
        }
        tileBinding.root.setOnTouchListener { v, event ->
            if (!isMaximized) {
                if (event.actionMasked == MotionEvent.ACTION_UP) {
                    v.performClick()
                }
                return@setOnTouchListener true
            }
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

    /** Names ride the controls chrome; otherwise they only show during a flash. */
    private fun tileNamesVisible(): Boolean =
        (viewModel.uiState.value.isControlsVisible || chromeFlashActive) && immersiveKey == null

    private fun startChromeFlash() {
        chromeFlashActive = true
        val root = view ?: return
        root.removeCallbacks(hideTransientChromeRunnable)
        root.postDelayed(hideTransientChromeRunnable, TRANSIENT_CHROME_MS)
    }

    private fun flashFocusBorder(key: String) {
        startChromeFlash()
        tileBindings[key]?.let { pulseTile(it) }
    }

    private fun pulseTile(tile: ItemMultipovTileBinding) {
        tile.root.animate().cancel()
        tile.root.scaleX = 0.97f
        tile.root.scaleY = 0.97f
        tile.root.animate().scaleX(1f).scaleY(1f).setDuration(150L).start()
    }

    private fun bindTileChrome(tile: ItemMultipovTileBinding, slot: MultiPovSlot) {
        if (isInPipMode()) {
            tile.focusBorder.isVisible = false
            tile.tileChrome.isVisible = false
            tile.channelName.isVisible = false
            tile.audioBadge.isVisible = false
            tile.removeButton.isVisible = false
            tile.loadingIndicator.isVisible = false
            tile.errorText.isVisible = false
            tile.tileAspect.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
            tile.root.alpha = 1f
            return
        }
        // Readable + immersive: name pill always, speaker on focused only.
        // Green ring only matters with 2+ tiles; single stream hides it.
        // Remove X only while chrome is open so grid stays clean.
        val multi = viewModel.uiState.value.slots.size > 1
        tile.focusBorder.isVisible =
            slot.isFocused && multi && immersiveKey == null && chromeFlashActive
        tile.tileChrome.isVisible = true
        tile.channelName.text = slot.stream.channelName ?: slot.stream.channelLogin ?: slot.key
        tile.channelName.isVisible = tileNamesVisible()
        tile.audioBadge.isVisible = slot.isFocused && multi
        tile.removeButton.isVisible = false
        // Single stream fills like the solo player (no letterbox gap).
        tile.tileAspect.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
        tile.root.alpha = if (!multi || slot.isFocused || immersiveKey != null) 1f else 0.88f
        val isActuallyPlaying = playbackController?.isPlaying(slot.key) == true
        when (val load = slot.loadState) {
            MultiPovLoadState.Loading -> {
                tile.loadingIndicator.isVisible = !isActuallyPlaying
                tile.errorText.isVisible = false
            }
            MultiPovLoadState.Ready -> {
                tile.loadingIndicator.isVisible = false
                tile.errorText.isVisible = false
            }
            is MultiPovLoadState.Error -> {
                tile.loadingIndicator.isVisible = false
                tile.errorText.isVisible = !isActuallyPlaying
                if (!isActuallyPlaying) {
                    tile.errorText.text = getString(
                        R.string.multipov_error_with_retry,
                        load.message,
                        getString(R.string.multipov_retry),
                    )
                }
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
                    source = stream.source ?: AppConstants.KICK,
                )
            )
            .commitNowAllowingStateLoss()
    }

    private fun applyOrientationLayout(rebuildTiles: Boolean = false) {
        val binding = _binding ?: return
        if (!isMaximized || isInPipMode()) return
        val prefs = requireContext().prefs()
        val chatDisabled = prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
        if (chatDisabled) {
            isChatOpen = false
            chatOpenProgress = 0f
        }
        focusedControls()?.toggleChat?.isVisible =
            !chatDisabled && requireContext().prefs().getBoolean(AppConstants.PLAYER_CHATTOGGLE, true)
        if (isPortrait) {
            showStatusBar()
            applyPortraitChatLayout()
        } else {
            hideStatusBar()
            ensureChatWidthLandscape()
            applyChatOpenProgress(if (isChatOpen) 1f else 0f, finalize = true)
        }
        updateChatToggleIcon()
        if (rebuildTiles && viewModel.uiState.value.slots.isNotEmpty()) {
            view?.post { render(viewModel.uiState.value, forceGridRebuild = true) }
        }
    }

    /** Portrait: stacked video + chat. The video section hugs the grid's actual
     * 16:9 content (single, immersive and grids alike) so chat starts right
     * below it instead of floating over letterbox black. */
    private fun applyPortraitChatLayout() {
        val binding = _binding ?: return
        if (isInPipMode()) return
        binding.chatFragmentContainer.translationX = 0f
        fun applyHeights() {
            if (isInPipMode()) return
            val root = _binding?.multiPovRoot ?: return
            // Root is padded below the status bar in portrait — play area only.
            val total = root.height - root.paddingTop
            if (total <= 0) return
            val state = viewModel.uiState.value
            val resizableEnabled = requireContext().prefs().getBoolean(AppConstants.MULTIPOV_RESIZABLE_SPLIT, false)
            val videoH = when {
                !isChatOpen -> total
                // Single, immersive, or pre-layout: 16:9 video only — chat gets the rest.
                state.slots.size <= 1 || immersiveKey != null || root.width <= 0 ->
                    ((root.width * 9f / 16f).roundToInt()).coerceIn(
                        (total * 0.30f).roundToInt(),
                        (total * 0.48f).roundToInt(),
                    )
                else -> {
                    // Same solver the builder uses — chat hugs the grid by construction.
                    val unit = root.width * 9f / 16f
                    val factorSum = solvePortraitRows(state.slots.size, currentLayoutPreset())
                        .sumOf { it.heightFactor.toDouble() }
                    (unit * factorSum).roundToInt()
                }
            }
            val chatH = (total - videoH).coerceAtLeast(0)
            val overlayH = videoH
            val videoLp = binding.videoSection.layoutParams as? FrameLayout.LayoutParams
            val chatLp = binding.chatFragmentContainer.layoutParams as? FrameLayout.LayoutParams
            val overlayLp = binding.controlsOverlay.layoutParams as? FrameLayout.LayoutParams
            val showDivider = isChatOpen && resizableEnabled && !isInPipMode() && state.slots.size >= 2
            binding.chatDivider.isVisible = showDivider
            val dividerHeightPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 44f, resources.displayMetrics).roundToInt()
            val dividerTop = videoH - (dividerHeightPx / 2)
            val dividerLp = binding.chatDivider.layoutParams as? FrameLayout.LayoutParams
            if (videoLp?.height == videoH && videoLp.marginEnd == 0 &&
                chatLp?.height == chatH && chatLp.gravity == Gravity.BOTTOM &&
                overlayLp?.height == overlayH && overlayLp.marginEnd == 0 &&
                (!showDivider || dividerLp?.topMargin == dividerTop) &&
                binding.chatFragmentContainer.isVisible == isChatOpen
            ) return
            binding.videoSection.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                videoH,
                Gravity.TOP,
            ).apply { marginEnd = 0 }
            binding.controlsOverlay.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                overlayH,
                Gravity.TOP,
            ).apply { marginEnd = 0 }
            if (showDivider) {
                binding.chatDivider.layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dividerHeightPx,
                    Gravity.TOP,
                ).apply { topMargin = dividerTop }
            }
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

    private fun solvePortraitRows(count: Int, preset: MultiPovLayoutPreset): List<PortraitRow> {
        return MultiPovLayoutPreset.solvePortraitRows(count, preset)
    }

    /** Portrait grid: one row per solver row, weight = height factor so rows
     * fill the video section exactly; empty matrix cells render as black. */
    private fun buildPortraitGrid(
        grid: LinearLayout,
        slots: List<MultiPovSlot>,
        rows: List<PortraitRow>,
    ) {
        var index = 0
        rows.forEach { row ->
            val container = horizontalRow(weight = row.heightFactor)
            val slotsInThisRow = minOf(row.tilesInRow, slots.size - index)
            if (row.tilesInRow == 2 && slotsInThisRow == 1) {
                container.addView(View(requireContext()), LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 0.5f))
                container.addView(createTileView(container, slots[index]), LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
                index++
                container.addView(View(requireContext()), LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 0.5f))
            } else {
                repeat(row.tilesInRow) {
                    if (index < slots.size) {
                        container.addView(createTileView(container, slots[index]), weightedCellParams(width = 0))
                        index++
                    } else {
                        container.addView(View(requireContext()), weightedCellParams(width = 0))
                    }
                }
            }
            grid.addView(container)
        }
    }

    private fun canInteractiveChatDrag(): Boolean {
        return !isPortrait &&
            isMaximized &&
            !isInPipMode() &&
            !requireContext().prefs().getBoolean(AppConstants.CHAT_DISABLE, false) &&
            chatWidthLandscape > 0 &&
            videoZoom?.isZoomed() != true &&
            videoZoom?.gestureActive != true
    }

    private fun ensureChatWidthLandscape() {
        val prefs = requireContext().prefs()
        val metrics = resources.displayMetrics
        val screenWidth = max(metrics.widthPixels, metrics.heightPixels)
        var percent = prefs.getInt(AppConstants.LANDSCAPE_CHAT_WIDTH, 30)
        if (percent > 100) {
            // Legacy raw pixel migration: convert old pixel value to percentage
            percent = ((percent * 100f) / screenWidth).roundToInt().coerceIn(10, 80)
            prefs.edit { putInt(AppConstants.LANDSCAPE_CHAT_WIDTH, percent) }
        } else if (percent <= 0) {
            percent = 30
        }
        chatWidthLandscape = (screenWidth * (percent / 100f)).roundToInt()
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
        binding.controlsOverlay.translationX = 0f
        if (p <= 0f && finalize) {
            binding.chatFragmentContainer.translationX = 0f
            binding.chatFragmentContainer.isVisible = false
            binding.videoSection.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.START,
            ).apply { marginEnd = 0 }
            binding.controlsOverlay.layoutParams = FrameLayout.LayoutParams(
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
            binding.controlsOverlay.layoutParams = FrameLayout.LayoutParams(
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
        requireContext().prefs().edit { putBoolean(AppConstants.KEY_CHAT_OPENED, open) }
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
        if (requireContext().prefs().getBoolean(AppConstants.CHAT_DISABLE, false)) return
        settleChatOpen(open = !isChatOpen, animate = !isPortrait)
    }

    fun toggleChatBar() {
        val container = _binding?.chatFragmentContainer ?: return
        val messageView = container.findViewById<LinearLayout>(R.id.messageView)
        val chatFrag = childFragmentManager.findFragmentById(R.id.chatFragmentContainer) as? ChatFragment
        val prefs = requireContext().prefs()
        if (!isChatOpen) {
            settleChatOpen(open = true, animate = !isPortrait)
            messageView?.visibility = View.VISIBLE
            prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true) }
            return
        }
        if (messageView != null) {
            if (messageView.isVisible) {
                val chatLayout = container.findViewById<View>(R.id.chatLayout) ?: container
                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
                    ?.hideSoftInputFromWindow(chatLayout.windowToken, 0)
                chatLayout.clearFocus()
                if (chatFrag?.emoteMenuIsVisible() == true) {
                    chatFrag.toggleEmoteMenu(false)
                }
                messageView.visibility = View.GONE
                prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, false) }
            } else {
                messageView.visibility = View.VISIBLE
                prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true) }
            }
        } else {
            val currentlyVisible = prefs.getBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true)
            prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, !currentlyVisible) }
        }
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
        val currentQuality = playbackController?.getCurrentQuality(viewModel.uiState.value.focusedKey)
        val activeKey = currentQuality?.let { KickLivePlayback.qualityKey(it) }

        // Best-first like the solo player: Source, 1080p … 360p.
        val qualities = MultiPovQuality.entries.reversed()
        val labels = qualities.map { q ->
            val base = getString(q.labelRes())
            if (activeKey != null && (q == viewModel.uiState.value.streamQuality || (q == MultiPovQuality.SOURCE && activeKey.startsWith("1080")))) {
                "$base ($activeKey)"
            } else {
                base
            }
        }.toTypedArray()
        val selected = qualities.indexOf(viewModel.uiState.value.streamQuality).coerceAtLeast(0)
        val titleText = activeKey?.let { "${getString(R.string.multipov_stream_quality)} ($it)" }
            ?: getString(R.string.multipov_stream_quality)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(titleText)
            .setSingleChoiceItems(labels, selected) { dialog, which ->
                val quality = qualities[which]
                if (quality == viewModel.uiState.value.streamQuality) {
                    // Same ceiling re-selected: force ABR back up to it.
                    playbackController?.bumpFocusedToCeiling()
                }
                requireContext().prefs().edit {
                    putString(AppConstants.MULTIPOV_QUALITY, quality.prefValue)
                    // Keep legacy key in sync for older installs / resume paths.
                    putString(AppConstants.MULTIPOV_SECONDARY_QUALITY, quality.prefValue)
                }
                viewModel.setStreamQuality(quality)
                dialog.dismiss()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show().also { it.compact() }
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
            .show().also { it.compact() }
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
            .show().also { it.compact() }
    }

    private fun updateAdaptiveQuality() {
        if (!requireContext().prefs().getBoolean(AppConstants.MULTIPOV_ADAPTIVE_QUALITY, true)) {
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
        if (!requireContext().prefs().getBoolean(AppConstants.MULTIPOV_ADAPTIVE_QUALITY, true)) return
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
        private const val REQUEST_CODE_PLAY_PAUSE = 3
        private const val REQUEST_CODE_MUTE_UNMUTE = 4
        private const val ARG_STREAMS = "streams"
        private const val ARG_RESOLVED_KEYS = "resolved_keys"
        private const val ARG_RESOLVED_VALUES = "resolved_values"
        private const val ARG_FOCUSED_KEY = "focused_key"
        private const val CONTROLS_HIDE_DELAY_MS = 3_000L
        private const val TRANSIENT_CHROME_MS = 2_000L
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
