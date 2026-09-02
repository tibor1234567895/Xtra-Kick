package com.xtrakick.app.ui.player

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.os.SystemClock
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.util.TypedValue
import android.view.GestureDetector
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.RoundedCorner
import android.view.ScaleGestureDetector
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.trackPipAnimationHintView
import androidx.annotation.OptIn
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.edit
import com.xtrakick.app.util.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.doOnLayout
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.TimeBar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.databinding.FragmentPlayerBinding
import com.xtrakick.app.model.ui.Clip
import com.xtrakick.app.model.ui.OfflineVideo
import com.xtrakick.app.model.ui.Stream
import com.xtrakick.app.model.ui.Video
import com.xtrakick.app.ui.channel.ChannelPagerFragmentDirections
import com.xtrakick.app.ui.chat.ChatFragment
import com.xtrakick.app.ui.common.BaseNetworkFragment
import com.xtrakick.app.ui.common.IntegrityDialog
import com.xtrakick.app.ui.common.RadioButtonDialogFragment
import com.xtrakick.app.ui.download.DownloadDialog
import com.xtrakick.app.ui.game.GameMediaFragmentDirections
import com.xtrakick.app.ui.game.GamePagerFragmentDirections
import com.xtrakick.app.ui.main.MainActivity
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.DiagnosticLogger
import com.xtrakick.app.util.KickApiHelper
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.isKeyboardShown
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.color.MaterialColors
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.xtrakick.app.util.NetworkMonitor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.roundToInt

@OptIn(UnstableApi::class)
@AndroidEntryPoint
abstract class PlayerFragment : BaseNetworkFragment(), RadioButtonDialogFragment.OnSortOptionChanged, IntegrityDialog.CallbackListener {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private var _binding: FragmentPlayerBinding? = null
    protected val binding get() = _binding!!
    protected val viewModel: PlayerViewModel by viewModels()
    protected var chatFragment: ChatFragment? = null

    protected var videoType: String? = null
    private var isPortrait = false
    var isMaximized = true
    private var isChatOpen = true
    private var isKeyboardShown = false
    private var resizeMode = 0
    private var chatWidthLandscape = 0
    /** 0 = fully closed, 1 = fully open. Scrubbed interactively in landscape fullscreen. */
    private var chatOpenProgress = 0f
    private var chatDragActive = false
    private var chatDragCandidate = false
    private var chatDragStartX = 0f
    private var chatDragStartY = 0f
    private var chatDragStartProgress = 0f
    private var chatProgressAnimator: ValueAnimator? = null
    /** Delayed orientation unlock after in-app minimize; cancelled if user maximizes again first. */
    private var unlockOrientationJob: Job? = null

    private var activePointerId = -1
    private var lastX = 0f
    private var lastY = 0f
    private var velocityTracker: VelocityTracker? = null
    private var isTap = false
    private var tapEventTime = 0L
    private var startTranslationX = 0f
    private var startTranslationY = 0f
    private var statusBarSwipe = false
    private var chatStatusBarSwipe = false
    private var isAnimating = false
    private var moveAnimation: ViewPropertyAnimator? = null
    protected var useController = true
    protected var controllerAutoHide = true
    private var controllerHideOnTouch = true
    private val controllerHideAction = Runnable { if (view != null) hideController() }
    private var controllerIsAnimating = false
    private var controllerAnimation: ViewPropertyAnimator? = null
    private var backgroundColor: Int? = null
    private var backgroundVisible = false
    private var wasInPictureInPictureMode = false
    private var videoZoomScale = 1f
    private var videoZoomTranslationX = 0f
    private var videoZoomTranslationY = 0f
    private var videoZoomGestureActive = false
    private var videoZoomGestureStartScale = 1f
    private var videoZoomGestureStartSpan = 0f
    private var videoZoomGestureScaleDeadzonePassed = false
    private var videoZoomGestureLastFocusX = 0f
    private var videoZoomGestureLastFocusY = 0f
    private var videoZoomPanLastX = 0f
    private var videoZoomPanLastY = 0f
    private var videoZoomPanMoved = false
    private var videoZoomFillHintActive = false
    private var videoZoomFillMode = false
    private var videoZoomFillHintAnimation: ViewPropertyAnimator? = null
    private var videoZoomIndicatorAnimation: ViewPropertyAnimator? = null
    protected var previousNetworkType: NetworkMonitor.NetworkType? = null
    protected var automaticQualityChangeInProgress = false

    protected lateinit var prefs: SharedPreferences

    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            minimize()
        }
    }

    protected var activePlaybackUrl: String? = null

    open fun startStream(url: String?) {}
    open fun startVideo(url: String?, playbackPosition: Long?, multivariantPlaylist: Boolean) {}
    open fun startClip(url: String?) {}
    open fun currentPlaybackUrl(): String? = activePlaybackUrl
    open fun startOfflineVideo(url: String?, position: Long) {}
    open fun getCurrentPosition(): Long? = null
    open fun getCurrentSpeed(): Float? = null
    open fun getCurrentVolume(): Float? = null
    open fun playPause() {}
    open fun rewind() {}
    open fun fastForward() {}
    open fun seek(position: Long) {}
    open fun seekToLivePosition() {}
    open fun setPlaybackSpeed(speed: Float) {}
    open fun changeVolume(volume: Float) {}
    open fun updateProgress() {}
    open fun toggleAudioCompressor() {}
    open fun setSubtitlesButton() {}
    open fun toggleSubtitles(enabled: Boolean) {}
    open fun showPlaylistTags(mediaPlaylist: Boolean) {}
    open fun changeQuality(selectedQuality: String?) {}
    open fun startAudioOnly() {}
    open fun downloadVideo() {}
    open fun close() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        videoType = requireArguments().getString(KEY_TYPE)
        if (videoType == OFFLINE_VIDEO) {
            enableNetworkCheck = false
        }
        super.onCreate(savedInstanceState)
        val activity = requireActivity()
        prefs = activity.prefs()
        isPortrait = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        activity.onBackPressedDispatcher.addCallback(this, backPressedCallback)
        WindowCompat.getInsetsController(
            requireActivity().window,
            requireActivity().window.decorView
        ).systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.integrity.collectLatest {
                        if (it != null &&
                            it != "done" &&
                            requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false) &&
                            requireContext().prefs().getBoolean(AppConstants.USE_WEBVIEW_INTEGRITY, true)
                        ) {
                            IntegrityDialog.show(childFragmentManager, it)
                            viewModel.integrity.value = "done"
                        }
                    }
                }
            }
            val ignoreCutouts = prefs.getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)
            val cornerPadding = prefs.getBoolean(AppConstants.PLAYER_ROUNDED_CORNER_PADDING, false)
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, windowInsets ->
                val insets = if (!isPortrait && ignoreCutouts) {
                    windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime())
                } else {
                    windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.displayCutout())
                }
                if (isPortrait) {
                    slidingLayout.updatePadding(left = 0, top = insets.top, right = 0)
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && cornerPadding) {
                        val rootWindowInsets = view.rootView.rootWindowInsets
                        val topLeft = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_TOP_LEFT)
                        val topRight = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_TOP_RIGHT)
                        val bottomLeft = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_BOTTOM_LEFT)
                        val bottomRight = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_BOTTOM_RIGHT)
                        val leftRadius = max(topLeft?.radius ?: 0, bottomLeft?.radius ?: 0)
                        val rightRadius = max(topRight?.radius ?: 0, bottomRight?.radius ?: 0)
                        if (ignoreCutouts) {
                            slidingLayout.updatePadding(left = leftRadius, top = 0, right = rightRadius)
                        } else {
                            val cutoutInsets = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout())
                            slidingLayout.updatePadding(left = max(cutoutInsets.left, leftRadius), top = 0, right = max(cutoutInsets.right, rightRadius))
                        }
                    } else {
                        if (ignoreCutouts) {
                            slidingLayout.updatePadding(left = 0, top = 0, right = 0)
                        } else {
                            val cutoutInsets = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout())
                            slidingLayout.updatePadding(left = cutoutInsets.left, top = 0, right = cutoutInsets.right)
                        }
                    }
                }
                chatLayout.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
                viewLifecycleOwner.lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        requireActivity().trackPipAnimationHintView(playerLayout)
                    }
                }
            }
            if (prefs.getBoolean(AppConstants.PLAYER_KEEP_SCREEN_ON_WHEN_PAUSED, false)) {
                view.keepScreenOn = true
            }
            if (isMaximized) {
                enableBackground()
            } else {
                disableBackground()
            }
            isChatOpen = prefs.getBoolean(AppConstants.KEY_CHAT_OPENED, true) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
            chatWidthLandscape = prefs.getInt(AppConstants.LANDSCAPE_CHAT_WIDTH, 0)
            chatOpenProgress = if (isChatOpen) 1f else 0f
            resizeMode = prefs.getInt(AppConstants.ASPECT_RATIO_LANDSCAPE, AspectRatioFrameLayout.RESIZE_MODE_FIT)
            aspectRatioFrameLayout.setAspectRatio(16f / 9f)
            initLayout()
            changePlayerMode()
            val viewConfiguration = ViewConfiguration.get(requireContext())
            val touchSlop = viewConfiguration.scaledTouchSlop
            val touchSlopRange = -touchSlop.toFloat()..touchSlop.toFloat()
            val longPressTimeout = ViewConfiguration.getLongPressTimeout()
            val moveFreely = prefs.getBoolean(AppConstants.PLAYER_MOVE_FREELY, false)
            val doubleTap = prefs.getBoolean(AppConstants.PLAYER_DOUBLETAP, true) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
            val chatFlingVelocity = 600f

            val controllerTapDetector = GestureDetector(
                requireContext(),
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onSingleTapUp(e: MotionEvent): Boolean {
                        if (offlineOverlay.isVisible) {
                            return false
                        }
                        return if (!doubleTap || isPortrait) {
                            val visible = playerControls.root.isVisible
                            if (visible) {
                                if (controllerHideOnTouch) {
                                    hideController()
                                }
                            } else {
                                showController()
                            }
                            if (!visible) {
                                updateProgress()
                            }
                            true
                        } else {
                            false
                        }
                    }

                    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                        if (offlineOverlay.isVisible) {
                            return false
                        }
                        return if (doubleTap && !isPortrait) {
                            val visible = playerControls.root.isVisible
                            if (visible) {
                                if (controllerHideOnTouch) {
                                    hideController()
                                }
                            } else {
                                showController()
                            }
                            if (!visible) {
                                updateProgress()
                            }
                            true
                        } else {
                            false
                        }
                    }

                    override fun onDoubleTap(e: MotionEvent): Boolean {
                        return if (doubleTap && !isPortrait && isMaximized) {
                            if (chatLayout.isVisible) {
                                hideChat()
                            } else {
                                showChat()
                            }
                            true
                        } else {
                            false
                        }
                    }
                }
            )

            val zoomDetector = ScaleGestureDetector(
                requireContext(),
                object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                        videoZoomGestureActive = true
                        if (videoZoomFillMode) {
                            videoZoomFillMode = false
                            restoreVideoResizeMode()
                        }
                        videoZoomGestureStartScale = videoZoomScale
                        videoZoomGestureStartSpan = detector.currentSpan
                        videoZoomGestureScaleDeadzonePassed = isVideoZoomed()
                        videoZoomGestureLastFocusX = detector.focusX
                        videoZoomGestureLastFocusY = detector.focusY
                        activePointerId = -1
                        playerControls.root.dispatchTouchEvent(
                            MotionEvent.obtain(
                                detector.eventTime,
                                detector.eventTime,
                                MotionEvent.ACTION_CANCEL,
                                detector.focusX,
                                detector.focusY,
                                0
                            )
                        )
                        showVideoZoomIndicator(formatVideoZoomScale(videoZoomScale), false)
                        return true
                    }

                    override fun onScale(detector: ScaleGestureDetector): Boolean {
                        if (!videoZoomGestureScaleDeadzonePassed) {
                            val spanRatio = if (videoZoomGestureStartSpan > 0f) detector.currentSpan / videoZoomGestureStartSpan else 1f
                            if (abs(spanRatio - 1f) < VIDEO_ZOOM_SCALE_DEADZONE_RATIO) {
                                videoZoomGestureLastFocusX = detector.focusX
                                videoZoomGestureLastFocusY = detector.focusY
                                return true
                            }
                            videoZoomGestureScaleDeadzonePassed = true
                        }
                        val oldScale = videoZoomScale
                        val newScale = (oldScale * detector.scaleFactor).coerceIn(MIN_VIDEO_ZOOM_SCALE, MAX_VIDEO_ZOOM_SCALE)
                        if (newScale > MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_EPSILON) {
                            binding.aspectRatioFrameLayout.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                        }
                        videoZoomTranslationX += (detector.focusX - videoZoomGestureLastFocusX) * VIDEO_ZOOM_TWO_FINGER_PAN_MULTIPLIER
                        videoZoomTranslationY += (detector.focusY - videoZoomGestureLastFocusY) * VIDEO_ZOOM_TWO_FINGER_PAN_MULTIPLIER
                        if (newScale != oldScale) {
                            val scaleChange = newScale / oldScale
                            videoZoomTranslationX = getScaledVideoTranslation(
                                focus = detector.focusX,
                                viewStart = getVideoSurfaceLeft(),
                                currentTranslation = videoZoomTranslationX,
                                scaleChange = scaleChange
                            )
                            videoZoomTranslationY = getScaledVideoTranslation(
                                focus = detector.focusY,
                                viewStart = getVideoSurfaceTop(),
                                currentTranslation = videoZoomTranslationY,
                                scaleChange = scaleChange
                            )
                        }
                        videoZoomScale = newScale
                        videoZoomGestureLastFocusX = detector.focusX
                        videoZoomGestureLastFocusY = detector.focusY
                        clampVideoZoomTranslation()
                        applyVideoZoom()
                        updateVideoZoomFillHint()
                        showVideoZoomIndicator(formatVideoZoomScale(videoZoomScale), false)
                        return true
                    }

                    override fun onScaleEnd(detector: ScaleGestureDetector) {
                        when {
                            videoZoomFillHintActive -> {
                                snapVideoZoomToFill()
                            }
                            videoZoomGestureStartScale > MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_EPSILON && videoZoomScale <= MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_RESET_TOLERANCE -> {
                                resetVideoZoom(true)
                            }
                            videoZoomScale <= MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_EPSILON -> {
                                resetVideoZoom(false)
                            }
                            else -> {
                                clampVideoZoomTranslation()
                                applyVideoZoom()
                                updateVideoZoomFillHint(false)
                                showVideoZoomIndicator(formatVideoZoomScale(videoZoomScale), true)
                            }
                        }
                        videoZoomGestureActive = false
                    }
                }
            )

            fun canInteractiveChatDrag(): Boolean {
                return !isPortrait &&
                    isMaximized &&
                    !prefs.getBoolean(AppConstants.CHAT_DISABLE, false) &&
                    chatWidthLandscape > 0
            }

            fun beginChatDragIfNeeded(event: MotionEvent, pointerIndex: Int): Boolean {
                if (!chatDragCandidate || chatDragActive || !canInteractiveChatDrag()) {
                    return false
                }
                // Use raw/screen coords so resizing/translating the player mid-drag can't
                // feed back into the pointer position and cause jitter.
                val rawX = event.rawX
                val rawY = event.rawY
                val dx = rawX - chatDragStartX
                val dy = rawY - chatDragStartY
                if (abs(dx) <= touchSlop && abs(dy) <= touchSlop) {
                    return false
                }
                // Prefer horizontal intent so vertical minimize still works.
                if (abs(dx) < abs(dy) * 1.2f) {
                    chatDragCandidate = false
                    return false
                }
                chatDragActive = true
                chatDragCandidate = false
                isTap = false
                chatProgressAnimator?.cancel()
                chatDragStartProgress = chatOpenProgress
                chatDragStartX = rawX
                velocityTracker?.clear()
                if (velocityTracker == null) {
                    velocityTracker = VelocityTracker.obtain()
                }
                velocityTracker?.addMovement(event)
                // Don't leave the controller half-pressed when we steal the gesture.
                if (playerControls.root.isVisible) {
                    val cancel = MotionEvent.obtain(
                        event.downTime,
                        event.eventTime,
                        MotionEvent.ACTION_CANCEL,
                        event.x,
                        event.y,
                        event.metaState
                    )
                    playerControls.root.dispatchTouchEvent(cancel)
                    cancel.recycle()
                }
                // One layout pass to prepare, then scrub with transforms only.
                prepareChatDragLayout()
                applyChatOpenProgress(chatOpenProgress, finalize = false)
                return true
            }

            fun updateChatDrag(event: MotionEvent, pointerIndex: Int) {
                val dx = event.rawX - chatDragStartX
                // Drag left (negative dx) opens; drag right closes.
                val progress = chatDragStartProgress - (dx / chatWidthLandscape.toFloat())
                applyChatOpenProgress(progress, finalize = false)
                velocityTracker?.addMovement(event)
            }

            fun endChatDrag(event: MotionEvent) {
                velocityTracker?.addMovement(event)
                velocityTracker?.computeCurrentVelocity(1000)
                val velocityX = velocityTracker?.xVelocity ?: 0f
                velocityTracker?.recycle()
                velocityTracker = null
                val shouldOpen = when {
                    velocityX < -chatFlingVelocity -> true
                    velocityX > chatFlingVelocity -> false
                    else -> chatOpenProgress >= 0.5f
                }
                settleChatOpen(shouldOpen, animate = true)
                chatDragActive = false
                chatDragCandidate = false
            }

            fun downAction(event: MotionEvent) {
                moveAnimation?.cancel()
                chatProgressAnimator?.cancel()
                isTap = true
                tapEventTime = event.eventTime
                if (isMaximized) {
                    chatDragActive = false
                    chatDragCandidate = canInteractiveChatDrag()
                    chatDragStartX = event.rawX
                    chatDragStartY = event.rawY
                    chatDragStartProgress = chatOpenProgress
                    if (offlineOverlay.isVisible) {
                        offlineOverlay.dispatchTouchEvent(event)
                    } else if (playerControls.root.isVisible) {
                        playerControls.root.dispatchTouchEvent(event)
                    } else {
                        controllerTapDetector.onTouchEvent(event)
                    }
                } else {
                    chatDragActive = false
                    chatDragCandidate = false
                    velocityTracker?.clear()
                    if (velocityTracker == null) {
                        velocityTracker = VelocityTracker.obtain()
                    }
                    velocityTracker?.addMovement(
                        MotionEvent.obtain(
                            event.downTime,
                            event.eventTime,
                            event.action,
                            slidingLayout.translationX,
                            slidingLayout.translationY,
                            event.metaState
                        )
                    )
                    startTranslationX = slidingLayout.translationX
                    startTranslationY = slidingLayout.translationY
                }
            }

            fun upAction(event: MotionEvent) {
                if (isMaximized) {
                    if (chatDragActive) {
                        endChatDrag(event)
                        // Keep player docked; chat scrub owns this gesture.
                        if (slidingLayout.translationY !in touchSlopRange) {
                            moveAnimation = slidingLayout.animate().apply {
                                translationX(0f)
                                translationY(0f)
                                setDuration(200L)
                                start()
                            }
                        }
                        return
                    }
                    chatDragCandidate = false
                    if (offlineOverlay.isVisible) {
                        offlineOverlay.dispatchTouchEvent(event)
                    } else if (playerControls.progressBar.isPressed) {
                        playerControls.root.dispatchTouchEvent(event)
                    } else {
                        if (slidingLayout.translationY in touchSlopRange) {
                            if (playerControls.root.isVisible) {
                                playerControls.root.dispatchTouchEvent(event)
                            } else {
                                controllerTapDetector.onTouchEvent(event)
                            }
                        }
                        val minimizeThreshold = slidingLayout.height / 5
                        if (slidingLayout.translationY < minimizeThreshold) {
                            moveAnimation = slidingLayout.animate().apply {
                                translationX(0f)
                                translationY(0f)
                                setDuration(250L)
                                setListener(
                                    object : AnimatorListenerAdapter() {
                                        override fun onAnimationEnd(animation: Animator) {
                                            setListener(null)
                                            if (this@PlayerFragment.view != null && slidingLayout.translationY < touchSlop) {
                                                enableBackground()
                                            }
                                        }
                                    }
                                )
                                start()
                            }
                        } else {
                            minimize()
                        }
                    }
                } else {
                    velocityTracker?.computeCurrentVelocity(1000)
                    val xVelocity = velocityTracker?.xVelocity ?: 0f
                    velocityTracker?.recycle()
                    velocityTracker = null
                    when {
                        xVelocity > 1500 -> {
                            isAnimating = true
                            slidingLayout.animate().apply {
                                translationX(slidingLayout.translationX + (slidingLayout.width * slidingLayout.scaleX))
                                setDuration(250L)
                                start()
                            }
                            close()
                            (activity as? MainActivity)?.closePlayer()
                        }
                        xVelocity < -1500 -> {
                            isAnimating = true
                            slidingLayout.animate().apply {
                                translationX(slidingLayout.translationX - (slidingLayout.width * slidingLayout.scaleX))
                                setDuration(250L)
                                start()
                            }
                            close()
                            (activity as? MainActivity)?.closePlayer()
                        }
                        else -> {
                            if (isTap && (event.eventTime - tapEventTime) < longPressTimeout) {
                                maximize()
                            } else {
                                if (moveFreely) {
                                    val windowInsets = ViewCompat.getRootWindowInsets(requireView())
                                    val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                                    val scaledXDiff = (slidingLayout.width * (1f - slidingLayout.scaleX)) / 2
                                    val scaledYDiff = (slidingLayout.height * (1f - slidingLayout.scaleY)) / 2
                                    val minX = 0f - scaledXDiff - ((insets?.left ?: 0) * slidingLayout.scaleX) + (insets?.left ?: 0)
                                    val minY = 0f - scaledYDiff - ((insets?.top ?: 0) * slidingLayout.scaleY) + (insets?.top ?: 0)
                                    val maxX = 0f - scaledXDiff - ((insets?.left ?: 0) * slidingLayout.scaleX) + slidingLayout.width - (playerLayout.width * slidingLayout.scaleX) - (insets?.right ?: 0)
                                    val maxY = 0f - scaledYDiff - ((insets?.top ?: 0) * slidingLayout.scaleY) + slidingLayout.height - (playerLayout.height * slidingLayout.scaleY) - (insets?.bottom ?: 0)
                                    val newX = when {
                                        slidingLayout.translationX < minX -> minX
                                        slidingLayout.translationX > maxX -> maxX
                                        else -> null
                                    }
                                    val newY = when {
                                        slidingLayout.translationY < minY -> minY
                                        slidingLayout.translationY > maxY -> maxY
                                        else -> null
                                    }
                                    if (newX != null || newY != null) {
                                        moveAnimation = slidingLayout.animate().apply {
                                            newX?.let { translationX(it) }
                                            newY?.let { translationY(it) }
                                            setDuration(250L)
                                            start()
                                        }
                                    }
                                } else {
                                    val windowInsets = ViewCompat.getRootWindowInsets(requireView())
                                    val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                                    val keyboardInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.ime())?.bottom?.let { if (it > 0) it - (insets?.bottom ?: 0) else it } ?: 0
                                    val scaledXDiff = (slidingLayout.width * (1f - slidingLayout.scaleX)) / 2
                                    val scaledYDiff = (slidingLayout.height * (1f - slidingLayout.scaleY)) / 2
                                    val navBarHeight = requireView().rootView.findViewById<LinearLayout>(R.id.navBarContainer)?.height?.takeIf { it > 0 }?.let { it - keyboardInsets } ?: (insets?.bottom ?: 0)
                                    val newX = slidingLayout.width - (insets?.right ?: 0) - (playerLayout.width * slidingLayout.scaleX) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics) * slidingLayout.scaleX)
                                    val newY = slidingLayout.height - navBarHeight - (playerLayout.height * slidingLayout.scaleY) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30F, resources.displayMetrics) * slidingLayout.scaleY)
                                    moveAnimation = slidingLayout.animate().apply {
                                        translationX(0f - scaledXDiff - ((insets?.left ?: 0) * slidingLayout.scaleX) + newX)
                                        translationY(0f - scaledYDiff - ((insets?.top ?: 0) * slidingLayout.scaleY) + newY)
                                        setDuration(250L)
                                        start()
                                    }
                                }
                            }
                        }
                    }
                }
            }

            dragView.setOnTouchListener { _, event ->
                if (!isAnimating) {
                    if (event.pointerCount > 1 || videoZoomGestureActive) {
                        if (chatDragActive) {
                            // Multi-touch cancels interactive chat scrub mid-gesture.
                            endChatDrag(event)
                        }
                        chatDragCandidate = false
                        zoomDetector.onTouchEvent(event)
                        isTap = false
                        activePointerId = -1
                        return@setOnTouchListener true
                    }
                    when (event.actionMasked) {
                        MotionEvent.ACTION_DOWN -> {
                            activePointerId = event.getPointerId(0)
                            val x = event.x
                            val y = event.y
                            lastX = x * slidingLayout.scaleX
                            lastY = y * slidingLayout.scaleY
                            videoZoomPanLastX = x
                            videoZoomPanLastY = y
                            statusBarSwipe = !isPortrait && y <= 100
                            if (isVideoZoomed()) {
                                isTap = true
                                tapEventTime = event.eventTime
                                videoZoomPanMoved = false
                                moveAnimation?.cancel()
                                if (playerControls.root.isVisible) {
                                    playerControls.root.dispatchTouchEvent(event)
                                } else {
                                    controllerTapDetector.onTouchEvent(event)
                                }
                            } else {
                                downAction(event)
                            }
                        }
                        MotionEvent.ACTION_POINTER_DOWN -> {
                            if (activePointerId == -1) {
                                val pointerIndex = event.actionIndex
                                val pointerId = event.getPointerId(pointerIndex)
                                val x = event.getX(pointerIndex)
                                val y = event.getY(pointerIndex)
                                if (x in 0f..playerLayout.width.toFloat() && y in 0f..playerLayout.height.toFloat()) {
                                    activePointerId = pointerId
                                    lastX = x * slidingLayout.scaleX
                                    lastY = y * slidingLayout.scaleY
                                    statusBarSwipe = !isPortrait && y <= 100
                                    downAction(event)
                                }
                            }
                        }
                        MotionEvent.ACTION_MOVE -> {
                            if (isMaximized && isVideoZoomed()) {
                                if (playerControls.root.isVisible) {
                                    playerControls.root.dispatchTouchEvent(event)
                                }
                                if (!playerControls.progressBar.isPressed && activePointerId != -1) {
                                    val pointerIndex = event.findPointerIndex(activePointerId)
                                    if (pointerIndex != -1) {
                                        val x = event.getX(pointerIndex)
                                        val y = event.getY(pointerIndex)
                                        val translationX = x - videoZoomPanLastX
                                        val translationY = y - videoZoomPanLastY
                                        if (abs(translationX) > touchSlop || abs(translationY) > touchSlop) {
                                            videoZoomPanMoved = true
                                        }
                                        videoZoomTranslationX += translationX
                                        videoZoomTranslationY += translationY
                                        videoZoomPanLastX = x
                                        videoZoomPanLastY = y
                                        clampVideoZoomTranslation()
                                        applyVideoZoom()
                                    }
                                }
                            } else if (isMaximized) {
                                val pointerIndex = if (activePointerId != -1) {
                                    event.findPointerIndex(activePointerId)
                                } else {
                                    -1
                                }
                                if (pointerIndex != -1) {
                                    if (!chatDragActive) {
                                        beginChatDragIfNeeded(event, pointerIndex)
                                    }
                                    if (chatDragActive) {
                                        updateChatDrag(event, pointerIndex)
                                    } else {
                                        if (offlineOverlay.isVisible) {
                                            offlineOverlay.dispatchTouchEvent(event)
                                        } else {
                                            playerControls.root.dispatchTouchEvent(event)
                                        }
                                        if (!playerControls.progressBar.isPressed && !statusBarSwipe) {
                                            val y = event.getY(pointerIndex)
                                            val translationY = y - lastY
                                            if (slidingLayout.translationY + translationY < 0) {
                                                slidingLayout.translationY = 0f
                                                lastY = y
                                            } else {
                                                slidingLayout.translationY += translationY
                                                lastY = y - translationY
                                            }
                                            if (slidingLayout.translationY < touchSlop) {
                                                if (!backgroundVisible) {
                                                    enableBackground()
                                                }
                                            } else {
                                                if (offlineOverlay.isVisible) {
                                                    val cancel = MotionEvent.obtain(
                                                        event.downTime,
                                                        event.eventTime,
                                                        MotionEvent.ACTION_CANCEL,
                                                        event.x,
                                                        event.y,
                                                        event.metaState
                                                    )
                                                    offlineOverlay.dispatchTouchEvent(cancel)
                                                    cancel.recycle()
                                                }
                                                if (backgroundVisible) {
                                                    disableBackground()
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (offlineOverlay.isVisible) {
                                        offlineOverlay.dispatchTouchEvent(event)
                                    } else {
                                        playerControls.root.dispatchTouchEvent(event)
                                    }
                                }
                            } else {
                                if (activePointerId != -1) {
                                    val pointerIndex = event.findPointerIndex(activePointerId)
                                    if (pointerIndex != -1) {
                                        val x = event.getX(pointerIndex) * slidingLayout.scaleX
                                        val y = event.getY(pointerIndex) * slidingLayout.scaleY
                                        val translationX = x - lastX
                                        val translationY = y - lastY
                                        slidingLayout.translationX += translationX
                                        if (moveFreely) {
                                            slidingLayout.translationY += translationY
                                        }
                                        lastX = x - translationX
                                        lastY = y - translationY
                                        velocityTracker?.addMovement(
                                            MotionEvent.obtain(
                                                event.downTime,
                                                event.eventTime,
                                                event.action,
                                                slidingLayout.translationX,
                                                slidingLayout.translationY,
                                                event.metaState
                                            )
                                        )
                                        if (isTap && ((startTranslationX - slidingLayout.translationX) !in touchSlopRange || (startTranslationY - slidingLayout.translationY) !in touchSlopRange)) {
                                            isTap = false
                                        }
                                    }
                                }
                            }
                        }
                        MotionEvent.ACTION_POINTER_UP -> {
                            val pointerIndex = event.actionIndex
                            val pointerId = event.getPointerId(pointerIndex)
                            if (pointerId == activePointerId) {
                                var newId = -1
                                for (i in 0 until event.pointerCount) {
                                    val id = event.getPointerId(i)
                                    if (id != activePointerId) {
                                        val x = event.getX(i)
                                        val y = event.getY(i)
                                        if (x in 0f..playerLayout.width.toFloat() && y in 0f..playerLayout.height.toFloat()) {
                                            newId = id
                                            lastX = x * slidingLayout.scaleX
                                            lastY = y * slidingLayout.scaleY
                                            break
                                        }
                                    }
                                }
                                if (newId == -1) {
                                    upAction(event)
                                }
                                activePointerId = newId
                            }
                        }
                        MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                            if (isVideoZoomed()) {
                                if (playerControls.root.isVisible) {
                                    playerControls.root.dispatchTouchEvent(event)
                                } else if (!videoZoomPanMoved && isTap && (event.eventTime - tapEventTime) < longPressTimeout) {
                                    controllerTapDetector.onTouchEvent(event)
                                }
                                activePointerId = -1
                            } else {
                                upAction(event)
                                activePointerId = -1
                            }
                        }
                    }
                }
                true
            }
            chatTouchView.setOnTouchListener { _, event ->
                when (event.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        chatStatusBarSwipe = !isPortrait && event.y <= 100
                        chatLinearLayout.dispatchTouchEvent(event)
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if (chatStatusBarSwipe) {
                            chatLinearLayout.dispatchTouchEvent(
                                MotionEvent.obtain(event).apply {
                                    action = MotionEvent.ACTION_CANCEL
                                }
                            )
                        } else {
                            chatLinearLayout.dispatchTouchEvent(event)
                        }
                    }
                    else -> chatLinearLayout.dispatchTouchEvent(event)
                }
                true
            }
            zoomIndicator.setOnClickListener {
                if (isVideoZoomed() || videoZoomFillMode) {
                    resetVideoZoom(true)
                }
            }
            with(playerControls) {
                root.setOnTouchListener { _, event ->
                    controllerTapDetector.onTouchEvent(event)
                }
                playPause.setOnClickListener {
                    showController(force = true)
                    playPause()
                }
                rewind.text = String.format(Locale.getDefault(), "%d", (prefs.getString(AppConstants.PLAYER_REWIND, "10")?.toLongOrNull() ?: 10))
                rewind.setOnClickListener {
                    showController(force = true)
                    rewind()
                }
                fastForward.text = String.format(Locale.getDefault(), "%d", (prefs.getString(AppConstants.PLAYER_FORWARD, "10")?.toLongOrNull() ?: 10))
                fastForward.setOnClickListener {
                    showController(force = true)
                    fastForward()
                }
                progressBar.addListener(
                    object : TimeBar.OnScrubListener {
                        override fun onScrubStart(timeBar: TimeBar, position: Long) {
                            binding.playerControls.position.text = DateUtils.formatElapsedTime(position / 1000)
                            binding.playerControls.root.removeCallbacks(controllerHideAction)
                        }

                        override fun onScrubMove(timeBar: TimeBar, position: Long) {
                            binding.playerControls.position.text = DateUtils.formatElapsedTime(position / 1000)
                        }

                        override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                            if (!canceled) {
                                seek(position)
                            } else {
                                if (controllerAutoHide && controllerHideOnTouch) {
                                    binding.playerControls.root.postDelayed(controllerHideAction, 3000)
                                }
                            }
                        }
                    }
                )
                position.text = DateUtils.formatElapsedTime(0)
                duration.text = DateUtils.formatElapsedTime(0)
                subtitleView.setUserDefaultStyle()
                subtitleView.setUserDefaultTextSize()
                val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)?.trim()?.takeIf { it.isNotBlank() }
                val channelName = requireArguments().getString(KEY_CHANNEL_NAME)?.trim()?.takeIf { it.isNotBlank() }
                val displayName = if (!channelLogin.isNullOrBlank() && !channelName.isNullOrBlank() && !channelLogin.equals(channelName, true)) {
                    when (prefs.getString(AppConstants.UI_NAME_DISPLAY, "1")) {
                        "0" -> "${channelName}(${channelLogin})"
                        "1" -> channelName
                        else -> channelLogin
                    }
                } else {
                    channelName ?: channelLogin
                }
                if (prefs.getBoolean(AppConstants.PLAYER_CHANNEL, true) && !displayName.isNullOrBlank()) {
                    channel.visibility = View.VISIBLE
                    channel.text = displayName
                    channel.setOnClickListener {
                        val navChannelId = requireArguments().getString(KEY_CHANNEL_ID)
                        val navChannelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN) ?: channelLogin ?: channelName
                        val navChannelName = requireArguments().getString(KEY_CHANNEL_NAME) ?: channelName ?: channelLogin
                        findNavController().navigate(
                            ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                channelId = navChannelId,
                                channelLogin = navChannelLogin,
                                channelName = navChannelName,
                            )
                        )
                        minimize()
                    }
                }
                val titleText = requireArguments().getString(KEY_TITLE)
                if (!titleText.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_TITLE, true)) {
                    title.visibility = View.VISIBLE
                    title.text = titleText
                }
                val gameName = requireArguments().getString(KEY_GAME_NAME)
                if (!gameName.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_CATEGORY, true)) {
                    category.visibility = View.VISIBLE
                    category.text = gameName
                    category.setOnClickListener {
                        findNavController().navigate(
                            if (prefs.getBoolean(AppConstants.UI_GAMEPAGER, true)) {
                                GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                                    gameId = requireArguments().getString(KEY_GAME_ID),
                                    gameSlug = requireArguments().getString(KEY_GAME_SLUG),
                                    gameName = gameName
                                )
                            } else {
                                GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                                    gameId = requireArguments().getString(KEY_GAME_ID),
                                    gameSlug = requireArguments().getString(KEY_GAME_SLUG),
                                    gameName = gameName
                                )
                            }
                        )
                        minimize()
                    }
                }
                if (prefs.getBoolean(AppConstants.PLAYER_MINIMIZE, true)) {
                    minimize.visibility = View.VISIBLE
                    minimize.setOnClickListener { minimize() }
                }
                if (prefs.getBoolean(AppConstants.PLAYER_VOLUMEBUTTON, true)) {
                    volume.visibility = View.VISIBLE
                    volume.setOnClickListener {
                        showController(force = true)
                        showVolumeDialog()
                    }
                }
                if (prefs.getBoolean(AppConstants.PLAYER_SETTINGS, true)) {
                    quality.visibility = View.VISIBLE
                    quality.setOnClickListener {
                        showController(force = true)
                        showQualityDialog()
                    }
                }
                if (prefs.getBoolean(AppConstants.PLAYER_MODE, false)) {
                    audioOnly.visibility = View.VISIBLE
                    audioOnly.setOnClickListener {
                        showController(force = true)
                        if (viewModel.quality == AUDIO_ONLY_QUALITY) {
                            changeQuality(viewModel.previousQuality)
                        } else {
                            changeQuality(AUDIO_ONLY_QUALITY)
                        }
                        changePlayerMode()
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && prefs.getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR_BUTTON, true)) {
                    audioCompressor.visibility = View.VISIBLE
                    if (prefs.getBoolean(AppConstants.PLAYER_AUDIO_COMPRESSOR, false)) {
                        audioCompressor.setImageResource(R.drawable.baseline_audio_compressor_on_24dp)
                    } else {
                        audioCompressor.setImageResource(R.drawable.baseline_audio_compressor_off_24dp)
                    }
                    audioCompressor.setOnClickListener {
                        toggleAudioCompressor()
                    }
                }
                if (prefs.getBoolean(AppConstants.PLAYER_MENU, true)) {
                    menu.visibility = View.VISIBLE
                    menu.setOnClickListener {
                        PlayerSettingsDialog.newInstance(
                            videoType = videoType,
                            speedText = getCurrentSpeed()?.let { speed ->
                                prefs.getString(AppConstants.PLAYER_SPEED_LIST, "0.25\n0.5\n0.75\n1.0\n1.25\n1.5\n1.75\n2.0\n3.0\n4.0\n8.0")
                                    ?.split("\n")?.find { it == speed.toString() }
                            },
                            vodGames = !viewModel.gamesList.value.isNullOrEmpty()
                        ).show(childFragmentManager, "closeOnPip")
                    }
                }
                if (videoType == STREAM) {
                    offlineRetryButton.setOnClickListener {
                        hideOfflineOverlay()
                        bufferingIndicator.isVisible = true
                        loadStream(forceRefresh = true)
                    }
                    offlineChannelButton.setOnClickListener {
                        val channelId = requireArguments().getString(KEY_CHANNEL_ID)
                        val channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)
                        if (!channelId.isNullOrBlank() || !channelLogin.isNullOrBlank()) {
                            minimize()
                            (activity as? MainActivity)?.closePlayer()
                            findNavController().navigate(
                                ChannelPagerFragmentDirections.actionGlobalChannelPagerFragment(
                                    channelId = channelId,
                                    channelLogin = channelLogin,
                                    channelName = requireArguments().getString(KEY_CHANNEL_NAME),
                                    channelLogo = requireArguments().getString(KEY_CHANNEL_LOGO),
                                )
                            )
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.streamError.collectLatest { errorResId ->
                                if (errorResId != null) {
                                    showOfflineOverlay(errorResId)
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.streamResult.collectLatest {
                                if (it != null) {
                                    hideOfflineOverlay()
                                    requireArguments().putString(KEY_RESOLVED_STREAM_URL, it)
                                    startStream(it)
                                    viewModel.streamResult.value = null
                                }
                            }
                        }
                    }
                    if (com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())) {
                        if (prefs.getBoolean(AppConstants.PLAYER_CHATBARTOGGLE, false) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)) {
                            toggleChatInput.visibility = View.VISIBLE
                            toggleChatInput.setOnClickListener {
                        showController(force = true)
                        toggleChatBar()
                    }
                        }
                        slidingLayout.viewTreeObserver.addOnGlobalLayoutListener {
                            if (slidingLayout.isKeyboardShown) {
                                if (!isKeyboardShown) {
                                    isKeyboardShown = true
                                    if (!isPortrait) {
                                        chatLayout.updateLayoutParams { width = (slidingLayout.width / 1.8f).toInt() }
                                        showStatusBar()
                                    }
                                }
                            } else {
                                if (isKeyboardShown) {
                                    isKeyboardShown = false
                                    chatLayout.clearFocus()
                                    if (!isPortrait) {
                                        chatLayout.updateLayoutParams { width = chatWidthLandscape }
                                        if (isMaximized) {
                                            hideStatusBar()
                                        }
                                    }
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.stream.collectLatest { stream ->
                                if (stream != null) {
                                    stream.id?.let { chatFragment?.updateStreamId(it) }
                                    if (prefs.getBoolean(AppConstants.CHAT_DISABLE, false) ||
                                        !prefs.getBoolean(AppConstants.CHAT_PUBSUB_ENABLED, true) ||
                                        viewersText.text.isNullOrBlank()
                                    ) {
                                        updateViewerCount(stream.viewerCount)
                                    }
                                    if (prefs.getBoolean(AppConstants.CHAT_DISABLE, false) ||
                                        !prefs.getBoolean(AppConstants.CHAT_PUBSUB_ENABLED, true) ||
                                        title.text.isNullOrBlank() ||
                                        category.text.isNullOrBlank()
                                    ) {
                                        updateStreamInfo(stream.title, stream.gameId, stream.gameSlug, stream.gameName)
                                    }
                                    if (prefs.getBoolean(AppConstants.PLAYER_SHOW_UPTIME, true) &&
                                        !uptimeLayout.isVisible
                                    ) {
                                        stream.startedAt?.let { date ->
                                            KickApiHelper.parseIso8601DateUTC(date)?.let { startedAtMs ->
                                                updateUptime(startedAtMs)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_RESTART, true)) {
                        restart.visibility = View.VISIBLE
                        restart.setOnClickListener {
                        showController(force = true)
                        restartPlayer()
                    }
                        updateRestartButtonUi()
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_SEEKLIVE, false)) {
                        seekLive.visibility = View.VISIBLE
                        seekLive.setOnClickListener {
                        showController(force = true)
                        seekToLivePosition()
                    }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_SHOW_UPTIME, true)) {
                        requireArguments().getString(KEY_STARTED_AT)?.let {
                            KickApiHelper.parseIso8601DateUTC(it)?.let { startedAtMs ->
                                updateUptime(startedAtMs)
                            }
                        }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_SHOW_LATENCY, true)) {
                        latencyLayout.visibility = View.VISIBLE
                    }
                    rewind.visibility = View.GONE
                    fastForward.visibility = View.GONE
                    position.visibility = View.GONE
                    progressBar.visibility = View.GONE
                    duration.visibility = View.GONE
                    updateStreamInfo(
                        requireArguments().getString(KEY_TITLE),
                        requireArguments().getString(KEY_GAME_ID),
                        requireArguments().getString(KEY_GAME_SLUG),
                        requireArguments().getString(KEY_GAME_NAME)
                    )
                    updateViewerCount(requireArguments().getInt(KEY_VIEWER_COUNT).takeIf { it != -1 })
                } else {
                    if (prefs.getBoolean(AppConstants.PLAYER_SPEEDBUTTON, true)) {
                        speed.visibility = View.VISIBLE
                        speed.setOnClickListener {
                    showController(force = true)
                    showSpeedDialog()
                }
                    }
                }
                if (videoType == VIDEO) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.videoResult.collectLatest {
                                if (it != null) {
                                    viewModel.qualities = emptyMap()
                                    viewModel.quality = null
                                    viewModel.updateQualities = true
                                    startVideo(it, viewModel.playbackPosition, true)
                                    viewModel.videoResult.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.videoError.collectLatest {
                                if (it != null) {
                                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                                    viewModel.videoError.value = null
                                }
                            }
                        }
                    }
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.savedPosition.collectLatest {
                                if (it != null) {
                                    playVideo((prefs.getString(AppConstants.TOKEN_SKIP_VIDEO_ACCESS_TOKEN, "2")?.toIntOrNull() ?: 2) <= 1, it)
                                    viewModel.savedPosition.value = null
                                }
                            }
                        }
                    }
                    if (requireContext().prefs().getBoolean(AppConstants.PLAYER_MENU_BOOKMARK, true)) {
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.isBookmarked.collectLatest {
                                    if (it != null) {
                                        (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog?)?.setBookmarkText(it)
                                        viewModel.isBookmarked.value = null
                                    }
                                }
                            }
                        }
                    }
                    if (!requireArguments().getString(KEY_VIDEO_ID).isNullOrBlank() && (prefs.getBoolean(AppConstants.PLAYER_GAMESBUTTON, true) || prefs.getBoolean(AppConstants.PLAYER_MENU_GAMES, false))) {
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.gamesList.collectLatest { list ->
                                    if (!list.isNullOrEmpty()) {
                                        if (prefs.getBoolean(AppConstants.PLAYER_GAMESBUTTON, true)) {
                                            vodGames.visibility = View.VISIBLE
                                            vodGames.setOnClickListener { showVodGames() }
                                        }
                                        (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog?)?.setVodGames()
                                    }
                                }
                            }
                        }
                    }
                }
                if (videoType == CLIP) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.clipUrls.collectLatest { map ->
                                if (map != null) {
                                    val supportedCodecs = prefs.getString(AppConstants.TOKEN_SUPPORTED_CODECS, "av1,h265,h264")?.split(',') ?: emptyList()
                                    val filtered = map.filterNot {
                                        it.key.second?.substringBefore('.').let { codec ->
                                            (codec == "av01" && !supportedCodecs.contains("av1")) || ((codec == "hev1" || codec == "hvc1") && !supportedCodecs.contains("h265"))
                                        }
                                    }
                                    val hideCodecs = filtered.all {
                                        it.key.second?.substringBefore('.').let { codec ->
                                            codec == "avc1" || codec == "mp4a" || codec.isNullOrBlank()
                                        }
                                    }
                                    val map = mutableMapOf<String, Pair<String, String?>>()
                                    filtered.forEach {
                                        val quality = it.key.first.let { quality ->
                                            val quality = if (quality == "source") {
                                                getString(R.string.source)
                                            } else {
                                                quality
                                            }
                                            if (hideCodecs) {
                                                quality
                                            } else {
                                                val codec = it.key.second?.substringBefore('.').let { codec ->
                                                    when {
                                                        codec == "av01" -> "AV1"
                                                        codec == "hev1" || codec == "hvc1" -> "H.265"
                                                        codec == "avc1" || codec.isNullOrBlank() -> "H.264"
                                                        else -> it
                                                    }
                                                }
                                                "$quality $codec"
                                            }
                                        }
                                        map[it.key.first] = Pair(quality, it.value)
                                    }
                                    map.put(AUDIO_ONLY_QUALITY, Pair(getString(R.string.audio_only), null))
                                    viewModel.qualities = map.toList()
                                        .sortedByDescending {
                                            it.first.substringAfter("p", "").takeWhile { it.isDigit() }.toIntOrNull()
                                        }
                                        .sortedByDescending {
                                            it.first.substringBefore("p", "").takeWhile { it.isDigit() }.toIntOrNull()
                                        }
                                        .sortedByDescending {
                                            it.first == "source"
                                        }
                                        .toMap()
                                    setDefaultQuality()
                                    changePlayerMode()
                                    val quality = viewModel.qualities.entries.find { it.key == viewModel.quality }
                                    val targetUrl = quality?.value?.second ?: viewModel.qualities.values.firstOrNull()?.second
                                    if (!targetUrl.isNullOrBlank() && targetUrl != currentPlaybackUrl() && targetUrl != requireArguments().getString(KEY_URL)) {
                                        activePlaybackUrl = targetUrl
                                        startClip(targetUrl)
                                    }
                                    viewModel.clipUrls.value = null
                                }
                            }
                        }
                    }
                    val videoId = requireArguments().getString(KEY_VIDEO_ID)
                    if (!videoId.isNullOrBlank()) {
                        binding.watchVideo.visibility = View.VISIBLE
                        binding.watchVideo.setOnClickListener {
                            viewLifecycleOwner.lifecycleScope.launch {
                                val offset = requireArguments().getInt(KEY_VOD_OFFSET).takeIf { it != -1 }?.let {
                                    (it * 1000) + (getCurrentPosition() ?: 0)
                                } ?: 0
                                if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                                    videoId.toLongOrNull()?.let { id ->
                                        viewModel.savePosition(id, offset)
                                    }
                                }
                                (requireActivity() as MainActivity).startVideo(
                                    Video(
                                        id = videoId,
                                        channelId = requireArguments().getString(KEY_CHANNEL_ID),
                                        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                                        channelName = requireArguments().getString(KEY_CHANNEL_NAME),
                                        profileImageUrl = requireArguments().getString(KEY_PROFILE_IMAGE_URL),
                                        animatedPreviewURL = requireArguments().getString(KEY_VIDEO_ANIMATED_PREVIEW)
                                    ),
                                    offset,
                                    true
                                )
                            }
                        }
                    }
                } else {
                    if (prefs.getBoolean(AppConstants.PLAYER_SLEEP, false)) {
                        sleepTimer.visibility = View.VISIBLE
                        sleepTimer.setOnClickListener { showSleepTimerDialog() }
                    }
                }
                if (videoType == OFFLINE_VIDEO) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.savedOfflineVideoPosition.collectLatest {
                                if (it != null) {
                                    val url = requireArguments().getString(KEY_URL)
                                    viewModel.qualities = mapOf(
                                        "source" to Pair(getString(R.string.source), url),
                                        AUDIO_ONLY_QUALITY to Pair(getString(R.string.audio_only), null)
                                    )
                                    setDefaultQuality()
                                    changePlayerMode()
                                    startOfflineVideo(url, it)
                                    viewModel.savedOfflineVideoPosition.value = null
                                }
                            }
                        }
                    }
                } else {
                    quality.isEnabled = false
                    quality.setColorFilter(Color.GRAY)
                    download.isEnabled = false
                    download.setColorFilter(Color.GRAY)
                    audioOnly.isEnabled = false
                    audioOnly.setColorFilter(Color.GRAY)
                    viewLifecycleOwner.lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED) {
                            viewModel.loaded.collectLatest {
                                if (it) {
                                    quality.isEnabled = true
                                    quality.setColorFilter(Color.WHITE)
                                    download.isEnabled = true
                                    download.setColorFilter(Color.WHITE)
                                    audioOnly.isEnabled = true
                                    audioOnly.setColorFilter(Color.WHITE)
                                    setQualityText()
                                }
                            }
                        }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_DOWNLOAD, false)) {
                        download.visibility = View.VISIBLE
                        download.setOnClickListener { showDownloadDialog() }
                    }
                    val setting = prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0
                    if (prefs.getBoolean(AppConstants.PLAYER_FOLLOW, true) && (setting == 0 || setting == 1)) {
                        follow.visibility = View.VISIBLE
                        follow.setOnClickListener {
                            viewModel.isFollowing.value?.let {
                                if (it) {
                                    requireContext().getAlertDialogBuilder()
                                        .setMessage(getString(R.string.unfollow_channel, displayName))
                                        .setNegativeButton(getString(R.string.no), null)
                                        .setPositiveButton(getString(R.string.yes)) { _, _ ->
                                            viewModel.deleteFollowChannel(
                                                requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                                                requireArguments().getString(KEY_CHANNEL_ID),
                                                requireArguments().getString(KEY_CHANNEL_LOGIN),
                                                setting,
                                                requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                                KickApiHelper.getKickWebHeaders(requireContext(), true),
                                                requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                            )
                                        }
                                        .show()
                                } else {
                                    viewModel.saveFollowChannel(
                                        requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                                        requireArguments().getString(KEY_CHANNEL_ID),
                                        requireArguments().getString(KEY_CHANNEL_LOGIN),
                                        requireArguments().getString(KEY_CHANNEL_NAME),
                                        setting,
                                        requireContext().prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false),
                                        requireArguments().getString(KEY_STARTED_AT),
                                        requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                        KickApiHelper.getKickWebHeaders(requireContext(), true),
                                        requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                    )
                                }
                            }
                        }
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.isFollowing.collectLatest {
                                    if (it != null) {
                                        if (it) {
                                            follow.setImageResource(R.drawable.baseline_favorite_black_24)
                                        } else {
                                            follow.setImageResource(R.drawable.baseline_favorite_border_black_24)
                                        }
                                    }
                                }
                            }
                        }
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.follow.collectLatest { pair ->
                                    if (pair != null) {
                                        val following = pair.first
                                        val errorMessage = pair.second
                                        if (!errorMessage.isNullOrBlank()) {
                                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                                        } else {
                                            if (following) {
                                                Toast.makeText(requireContext(), getString(R.string.now_following, displayName), Toast.LENGTH_SHORT).show()
                                            } else {
                                                Toast.makeText(requireContext(), getString(R.string.unfollowed, displayName), Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                        viewModel.follow.value = null
                                    }
                                }
                            }
                        }
                    }
                }
            }
            val currentChatFragment = (childFragmentManager.findFragmentById(R.id.chatFragmentContainer) as? ChatFragment)
            if (currentChatFragment != null && videoType != CLIP) {
                chatFragment = currentChatFragment
            } else {
                val fragment = when (videoType) {
                    STREAM -> ChatFragment.newInstance(
                        requireArguments().getString(KEY_CHANNEL_ID),
                        requireArguments().getString(KEY_CHANNEL_LOGIN),
                        requireArguments().getString(KEY_CHANNEL_NAME),
                        requireArguments().getString(KEY_STREAM_ID),
                        requireArguments().getString(KEY_STREAM_SOURCE)
                    )
                    VIDEO -> ChatFragment.newInstance(
                        channelId = requireArguments().getString(KEY_CHANNEL_ID),
                        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                        videoId = requireArguments().getString(KEY_VIDEO_ID),
                        startTime = 0,
                        suppressReplayUnavailable = requireArguments().getString(KEY_VIDEO_SOURCE).equals(AppConstants.KICK, true),
                        kickReplayFallback = requireArguments().getString(KEY_VIDEO_SOURCE).equals(AppConstants.KICK, true),
                        kickReplayStartTime = requireArguments().getString(KEY_UPLOAD_DATE),
                        kickReplayUrl = requireArguments().getString(KEY_URL),
                        source = requireArguments().getString(KEY_VIDEO_SOURCE)
                    )
                    CLIP -> run {
                        val clipUrl = requireArguments().getString(KEY_URL)
                        val isKickClip = clipUrl?.contains("clips.kick.com", ignoreCase = true) == true ||
                                clipUrl?.contains("kick.com", ignoreCase = true) == true
                        ChatFragment.newInstance(
                            requireArguments().getString(KEY_CHANNEL_ID),
                            requireArguments().getString(KEY_CHANNEL_LOGIN),
                            requireArguments().getString(KEY_VIDEO_ID),
                            requireArguments().getInt(KEY_VOD_OFFSET).takeIf { it != -1 },
                            isKickClip,
                            isKickClip,
                            requireArguments().getString(KEY_CLIP_REPLAY_START_TIME) ?: requireArguments().getString(KEY_UPLOAD_DATE),
                            clipUrl,
                            source = requireArguments().getString(KEY_VIDEO_SOURCE)
                        )
                    }
                    OFFLINE_VIDEO -> ChatFragment.newLocalInstance(
                        requireArguments().getString(KEY_CHANNEL_ID),
                        requireArguments().getString(KEY_CHANNEL_LOGIN),
                        requireArguments().getString(KEY_CHAT_URL),
                        requireArguments().getInt(KEY_OFFLINE_CHAT_START_TIME, -1).takeIf { it != -1 },
                        requireArguments().getString(KEY_VIDEO_SOURCE)
                    )
                    else -> null
                }
                if (fragment != null) {
                    childFragmentManager.beginTransaction().replace(R.id.chatFragmentContainer, fragment).commit()
                }
                chatFragment = fragment
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                networkMonitor.networkType.collect { type ->
                    onNetworkTypeChanged(type)
                }
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun initLayout() {
        with(binding) {
            if (isPortrait) {
                requireActivity().window.decorView.setOnSystemUiVisibilityChangeListener(null)
                showStatusBar()
                chatProgressAnimator?.cancel()
                playerLayout.translationX = 0f
                chatLayout.translationX = 0f
                playerLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                    marginEnd = 0
                }
                chatLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                    gravity = Gravity.BOTTOM
                }
                if (isMaximized) {
                    chatLayout.visibility = View.VISIBLE
                } else {
                    chatLayout.visibility = View.GONE
                    val (minimizedScaleX, minimizedScaleY) = getScaleValues()
                    slidingLayout.scaleX = minimizedScaleX
                    slidingLayout.scaleY = minimizedScaleY
                    slidingLayout.doOnPreDraw {
                        val (minimizedScaleX, minimizedScaleY) = getScaleValues()
                        val windowInsets = ViewCompat.getRootWindowInsets(requireView())
                        val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                        val keyboardInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.ime())?.bottom?.let { if (it > 0) it - (insets?.bottom ?: 0) else it } ?: 0
                        val playerHeight = (slidingLayout.width / (16f / 9f)).toInt()
                        val scaledXDiff = (slidingLayout.width * (1f - minimizedScaleX)) / 2
                        val scaledYDiff = (slidingLayout.height * (1f - minimizedScaleY)) / 2
                        val navBarHeight = requireView().rootView.findViewById<LinearLayout>(R.id.navBarContainer)?.height?.takeIf { it > 0 }?.let { it - keyboardInsets } ?: (insets?.bottom ?: 0)
                        val newX = slidingLayout.width - (insets?.right ?: 0) - (slidingLayout.width * minimizedScaleX) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics) * minimizedScaleX)
                        val newY = slidingLayout.height - navBarHeight - (playerHeight * minimizedScaleY) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30F, resources.displayMetrics) * minimizedScaleY)
                        slidingLayout.translationX = 0f - scaledXDiff - ((insets?.left ?: 0) * minimizedScaleX) + newX
                        slidingLayout.translationY = 0f - scaledYDiff - ((insets?.top ?: 0) * minimizedScaleY) + newY
                    }
                }
                aspectRatioFrameLayout.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                if (videoZoomFillMode) {
                    aspectRatioFrameLayout.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                }
                aspectRatioFrameLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    gravity = Gravity.NO_GRAVITY
                }
                playerLayout.isPortrait = true
                chatLayout.isPortrait = true
                with(playerControls) {
                    if (prefs.getBoolean(AppConstants.PLAYER_FULLSCREEN, true)) {
                        fullscreen.visibility = View.VISIBLE
                        fullscreen.setImageResource(R.drawable.baseline_fullscreen_black_24)
                        fullscreen.setOnClickListener {
                            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                        }
                    }
                    aspectRatio.visibility = View.GONE
                    toggleChat.visibility = View.GONE
                }
            } else {
                requireActivity().window.decorView.setOnSystemUiVisibilityChangeListener {
                    if (!isKeyboardShown && isMaximized && activity != null) {
                        hideStatusBar()
                    }
                }
                if (isMaximized) {
                    hideStatusBar()
                    // After rotate while maximized (e.g. leave portrait PiP restore into landscape),
                    // always rebuild landscape chat from the user preference — not the temporary
                    // hideChatLayout() state used while minimized.
                    restoreLandscapeChatIfNeeded(animate = false)
                } else {
                    showStatusBar()
                    chatProgressAnimator?.cancel()
                    playerLayout.translationX = 0f
                    chatLayout.translationX = 0f
                    playerLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                        width = ViewGroup.LayoutParams.MATCH_PARENT
                        height = ViewGroup.LayoutParams.MATCH_PARENT
                        marginEnd = 0
                    }
                    chatLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                        width = chatWidthLandscape
                        height = ViewGroup.LayoutParams.MATCH_PARENT
                        gravity = Gravity.END
                    }
                    chatLayout.visibility = View.GONE
                    val (minimizedScaleX, minimizedScaleY) = getScaleValues()
                    slidingLayout.scaleX = minimizedScaleX
                    slidingLayout.scaleY = minimizedScaleY
                    slidingLayout.doOnPreDraw {
                        val (minimizedScaleX, minimizedScaleY) = getScaleValues()
                        val windowInsets = ViewCompat.getRootWindowInsets(requireView())
                        val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                        val keyboardInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.ime())?.bottom?.let { if (it > 0) it - (insets?.bottom ?: 0) else it } ?: 0
                        val playerWidth = slidingLayout.width - getHorizontalInsets(windowInsets)
                        val scaledXDiff = (slidingLayout.width * (1f - minimizedScaleX)) / 2
                        val scaledYDiff = (slidingLayout.height * (1f - minimizedScaleY)) / 2
                        val navBarHeight = requireView().rootView.findViewById<LinearLayout>(R.id.navBarContainer)?.height?.takeIf { it > 0 }?.let { it - keyboardInsets } ?: (insets?.bottom ?: 0)
                        val newX = slidingLayout.width - (insets?.right ?: 0) - (playerWidth * minimizedScaleX) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics) * minimizedScaleX)
                        val newY = slidingLayout.height - navBarHeight - (slidingLayout.height * minimizedScaleY) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30F, resources.displayMetrics) * minimizedScaleY)
                        slidingLayout.translationX = 0f - scaledXDiff - ((insets?.left ?: 0) * minimizedScaleX) + newX
                        slidingLayout.translationY = 0f - scaledYDiff - ((insets?.top ?: 0) * minimizedScaleY) + newY
                    }
                }
                aspectRatioFrameLayout.resizeMode = resizeMode
                if (videoZoomFillMode) {
                    aspectRatioFrameLayout.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                }
                aspectRatioFrameLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    gravity = Gravity.CENTER
                }
                playerLayout.isPortrait = false
                chatLayout.isPortrait = false
                with(playerControls) {
                    if (prefs.getBoolean(AppConstants.PLAYER_FULLSCREEN, true)) {
                        fullscreen.visibility = View.VISIBLE
                        fullscreen.setImageResource(R.drawable.baseline_fullscreen_exit_black_24)
                        fullscreen.setOnClickListener {
                            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                        }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_ASPECT, true)) {
                        aspectRatio.visibility = View.VISIBLE
                        aspectRatio.setOnClickListener { setResizeMode() }
                    }
                    if (prefs.getBoolean(AppConstants.PLAYER_CHATTOGGLE, true) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)) {
                        toggleChat.visibility = View.VISIBLE
                        if (isChatOpen) {
                            toggleChat.setImageResource(R.drawable.baseline_speaker_notes_off_black_24)
                            toggleChat.setOnClickListener { hideChat() }
                        } else {
                            toggleChat.setImageResource(R.drawable.baseline_speaker_notes_black_24)
                            toggleChat.setOnClickListener { showChat() }
                        }
                    }
                }
            }
        }
    }

    fun setResizeMode() {
        resizeMode = (resizeMode + 1).let { if (it < 5) it else 0 }
        videoZoomFillMode = false
        binding.aspectRatioFrameLayout.resizeMode = resizeMode
        prefs.edit { putInt(AppConstants.ASPECT_RATIO_LANDSCAPE, resizeMode) }
    }

    fun showSleepTimerDialog() {
        if (requireContext().prefs().getBoolean(AppConstants.SLEEP_TIMER_USE_TIME_PICKER, false)) {
            if (((activity as? MainActivity)?.getSleepTimerTimeLeft() ?: 0) > 0L) {
                requireContext().getAlertDialogBuilder()
                    .setMessage(getString(R.string.stop_sleep_timer_message))
                    .setPositiveButton(getString(R.string.yes)) { _, _ ->
                        onSleepTimerChanged(-1L, 0, 0, requireContext().prefs().getBoolean(AppConstants.SLEEP_TIMER_LOCK, false))
                    }
                    .setNegativeButton(getString(R.string.no), null)
                    .show()
            } else {
                val savedValue = requireContext().prefs().getInt(AppConstants.SLEEP_TIMER_TIME, 15)
                val picker = MaterialTimePicker.Builder()
                    .setTimeFormat(if (DateFormat.is24HourFormat(requireContext())) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H)
                    .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                    .setHour(savedValue / 60)
                    .setMinute(savedValue % 60)
                    .build()
                picker.addOnPositiveButtonClickListener {
                    val minutes = KickApiHelper.getMinutesLeft(picker.hour, picker.minute)
                    onSleepTimerChanged(minutes * 60_000L, minutes / 60, minutes % 60, requireContext().prefs().getBoolean(AppConstants.SLEEP_TIMER_LOCK, false))
                    requireContext().prefs().edit {
                        putInt(AppConstants.SLEEP_TIMER_TIME, picker.hour * 60 + picker.minute)
                    }
                }
                picker.show(childFragmentManager, null)
            }
        } else {
            SleepTimerDialog.newInstance((activity as? MainActivity)?.getSleepTimerTimeLeft() ?: 0).show(childFragmentManager, null)
        }
    }

    fun showQualityDialog() {
        if (viewModel.qualities.isNotEmpty()) {
            RadioButtonDialogFragment.newInstance(
                REQUEST_CODE_QUALITY,
                viewModel.qualities.values.map { it.first },
                null,
                viewModel.qualities.keys.indexOf(viewModel.quality)
            ).show(childFragmentManager, "closeOnPip")
        }
    }

    fun showSpeedDialog() {
        val speed = getCurrentSpeed()
        if (speed != null) {
            val speedList = prefs.getString(AppConstants.PLAYER_SPEED_LIST, "0.25\n0.5\n0.75\n1.0\n1.25\n1.5\n1.75\n2.0\n3.0\n4.0\n8.0")?.split("\n")
            if (speedList != null) {
                RadioButtonDialogFragment.newInstance(
                    REQUEST_CODE_SPEED,
                    speedList,
                    null,
                    speedList.indexOf(speed.toString())
                ).show(childFragmentManager, "closeOnPip")
            }
        }
    }

    fun showVolumeDialog() {
        PlayerVolumeDialog.newInstance(getCurrentVolume()).show(childFragmentManager, "closeOnPip")
    }

    fun toggleChatBar() {
        with(binding) {
            requireView().findViewById<LinearLayout>(R.id.messageView)?.let {
                if (it.isVisible) {
                    (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(chatLayout.windowToken, 0)
                    chatLayout.clearFocus()
                    if (videoType == STREAM && chatFragment?.emoteMenuIsVisible() == true) {
                        chatFragment?.toggleEmoteMenu(false)
                    }
                    it.visibility = View.GONE
                    prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, false) }
                } else {
                    it.visibility = View.VISIBLE
                    prefs.edit { putBoolean(AppConstants.KEY_CHAT_BAR_VISIBLE, true) }
                }
            }
        }
    }

    fun hideChat() {
        settleChatOpen(open = false, animate = true)
    }

    fun showChat() {
        settleChatOpen(open = true, animate = true)
    }

    private fun hideChatLayout(animate: Boolean = false) {
        // Visual-only hide (minimize / system PiP). Does not change isChatOpen / prefs.
        if (animate) {
            animateChatOpenProgressTo(0f)
        } else {
            applyChatOpenProgress(0f, finalize = true)
        }
    }

    private fun showChatLayout(animate: Boolean = false) {
        ensureChatWidthLandscape()
        if (animate) {
            animateChatOpenProgressTo(1f)
        } else {
            applyChatOpenProgress(1f, finalize = true)
        }
    }

    private fun settleChatOpen(open: Boolean, animate: Boolean) {
        isChatOpen = open
        prefs.edit { putBoolean(AppConstants.KEY_CHAT_OPENED, open) }
        updateChatToggleButton(open)
        if (animate) {
            animateChatOpenProgressTo(if (open) 1f else 0f)
        } else {
            applyChatOpenProgress(if (open) 1f else 0f, finalize = true)
        }
        if (open) {
            scrollChatToBottomIfFollowing()
        }
    }

    /** User preference for landscape chat (not the temporary hide used by minimize/PiP). */
    private fun refreshChatOpenFromPrefs() {
        isChatOpen = prefs.getBoolean(AppConstants.KEY_CHAT_OPENED, true) && !prefs.getBoolean(AppConstants.CHAT_DISABLE, false)
    }

    private fun ensureChatWidthLandscape() {
        if (chatWidthLandscape > 0) {
            return
        }
        chatWidthLandscape = prefs.getInt(AppConstants.LANDSCAPE_CHAT_WIDTH, 0)
        if (chatWidthLandscape <= 0) {
            val metrics = resources.displayMetrics
            val longest = max(metrics.widthPixels, metrics.heightPixels)
            chatWidthLandscape = (longest * 0.30f).toInt()
        }
    }

    /**
     * Restores landscape chat after in-app minimize or system PiP.
     * Minimize only hides chat visually; user preference stays in [isChatOpen] / prefs.
     */
    private fun restoreLandscapeChatIfNeeded(animate: Boolean = false) {
        if (!isAdded || _binding == null || isPortrait || prefs.getBoolean(AppConstants.CHAT_DISABLE, false)) {
            return
        }
        refreshChatOpenFromPrefs()
        ensureChatWidthLandscape()
        updateChatToggleButton(isChatOpen)
        if (isChatOpen) {
            showChatLayout(animate = animate)
            scrollChatToBottomIfFollowing()
        } else {
            hideChatLayout(animate = false)
        }
    }

    private fun updateChatToggleButton(open: Boolean) {
        if (!prefs.getBoolean(AppConstants.PLAYER_CHATTOGGLE, true) || prefs.getBoolean(AppConstants.CHAT_DISABLE, false)) {
            return
        }
        if (!isAdded || _binding == null || isPortrait) {
            return
        }
        binding.playerControls.toggleChat.apply {
            visibility = View.VISIBLE
            if (open) {
                setImageResource(R.drawable.baseline_speaker_notes_off_black_24)
                setOnClickListener { hideChat() }
            } else {
                setImageResource(R.drawable.baseline_speaker_notes_black_24)
                setOnClickListener { showChat() }
            }
        }
    }

    private fun scrollChatToBottomIfFollowing() {
        if (!isAdded || view == null) {
            return
        }
        if (requireView().findViewById<Button>(R.id.btnDown)?.isVisible == false) {
            requireView().findViewById<RecyclerView>(R.id.recyclerView)?.let { recyclerView ->
                recyclerView.adapter?.itemCount?.let { recyclerView.scrollToPosition(it - 1) }
            }
        }
    }

    /**
     * Ensures chat has the correct landscape size/gravity once. Player stays left-anchored
     * (never translated); open amount uses marginEnd + chat translation like the original animation.
     */
    private fun prepareChatDragLayout() {
        if (_binding == null || chatWidthLandscape <= 0) {
            return
        }
        val width = chatWidthLandscape
        with(binding) {
            // Never leave a leftover translation from the bad transform-only path.
            playerLayout.translationX = 0f
            val chatLp = chatLayout.layoutParams as? FrameLayout.LayoutParams
            if (chatLp == null ||
                chatLp.width != width ||
                chatLp.height != ViewGroup.LayoutParams.MATCH_PARENT ||
                chatLp.gravity != Gravity.END
            ) {
                chatLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    this.width = width
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                    gravity = Gravity.END
                }
            }
            if (chatLayout.visibility != View.VISIBLE) {
                chatLayout.visibility = View.VISIBLE
            }
        }
    }

    /**
     * Landscape chat open progress: 0 = closed, 1 = fully open.
     *
     * Matches original visual model:
     * - player stays left-aligned and shrinks from the right via marginEnd
     * - chat slides in from the right via translationX
     *
     * Finger tracking uses rawX (screen space) so resizing the player does not feed back
     * into the drag coordinate system.
     */
    private fun applyChatOpenProgress(progress: Float, finalize: Boolean) {
        if (_binding == null) {
            return
        }
        val width = chatWidthLandscape
        if (width <= 0) {
            chatOpenProgress = if (isChatOpen) 1f else 0f
            return
        }
        val p = progress.coerceIn(0f, 1f)
        chatOpenProgress = p
        val margin = (width * p).roundToInt().coerceIn(0, width)
        val chatTranslation = (width - margin).toFloat()

        with(binding) {
            // Always clear any player translation (regression guard).
            playerLayout.translationX = 0f

            if (p <= 0f && finalize) {
                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(chatLayout.windowToken, 0)
                chatLayout.clearFocus()
                chatLayout.translationX = 0f
                chatLayout.visibility = View.GONE
                val playerLp = playerLayout.layoutParams as? FrameLayout.LayoutParams
                if (playerLp == null ||
                    playerLp.width != ViewGroup.LayoutParams.MATCH_PARENT ||
                    playerLp.marginEnd != 0
                ) {
                    playerLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                        this.width = ViewGroup.LayoutParams.MATCH_PARENT
                        height = ViewGroup.LayoutParams.MATCH_PARENT
                        marginEnd = 0
                    }
                }
                return
            }

            prepareChatDragLayout()
            chatLayout.translationX = chatTranslation
            chatLayout.visibility = View.VISIBLE

            val playerLp = playerLayout.layoutParams as? FrameLayout.LayoutParams
            if (playerLp == null ||
                playerLp.width != ViewGroup.LayoutParams.MATCH_PARENT ||
                playerLp.marginEnd != margin
            ) {
                playerLayout.updateLayoutParams<FrameLayout.LayoutParams> {
                    this.width = ViewGroup.LayoutParams.MATCH_PARENT
                    height = ViewGroup.LayoutParams.MATCH_PARENT
                    marginEnd = margin
                }
            }
        }
    }

    private fun animateChatOpenProgressTo(target: Float) {
        if (_binding == null) {
            return
        }
        val clampedTarget = target.coerceIn(0f, 1f)
        chatProgressAnimator?.cancel()
        if (chatWidthLandscape <= 0 || isPortrait) {
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

    fun setQualityText() {
        (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog?)?.setQuality(
            viewModel.qualities[viewModel.quality]?.first
        )
    }

    fun updateViewerCount(viewerCount: Int?) {
        with(binding.playerControls) {
            if (viewerCount != null) {
                viewersText.text = KickApiHelper.formatCount(viewerCount, requireContext().prefs().getBoolean(AppConstants.UI_TRUNCATEVIEWCOUNT, true))
                if (prefs.getBoolean(AppConstants.PLAYER_VIEWERICON, true)) {
                    viewersIcon.visibility = View.VISIBLE
                }
            } else {
                viewersText.text = null
                viewersIcon.visibility = View.GONE
            }
        }
    }

    fun updateLiveStatus(live: Boolean, serverTime: Long?, channelLogin: String?) {
        if (channelLogin == requireArguments().getString(KEY_CHANNEL_LOGIN)) {
            if (live) {
                restartPlayer()
            }
            updateUptime(serverTime?.times(1000))
        }
    }

    private fun updateUptime(uptimeMs: Long?) {
        with(binding.playerControls) {
            uptimeTimer.stop()
            if (uptimeMs != null && prefs.getBoolean(AppConstants.PLAYER_SHOW_UPTIME, true)) {
                uptimeLayout.visibility = View.VISIBLE
                uptimeTimer.base = SystemClock.elapsedRealtime() + uptimeMs - System.currentTimeMillis()
                uptimeTimer.start()
                if (prefs.getBoolean(AppConstants.PLAYER_VIEWERICON, true)) {
                    uptimeIcon.visibility = View.VISIBLE
                } else {
                    uptimeIcon.visibility = View.GONE
                }
            } else {
                uptimeLayout.visibility = View.GONE
            }
        }
    }

    fun updateLatency(liveOffsetMs: Long?, targetOffsetMs: Long? = null) {
        with(binding.playerControls) {
            if (liveOffsetMs != null && prefs.getBoolean(AppConstants.PLAYER_SHOW_LATENCY, true)) {
                latencyLayout.visibility = View.VISIBLE
                val seconds = liveOffsetMs / 1000.0
                latencyText.text = if (targetOffsetMs != null) {
                    "~%.1fs / %.1fs".format(seconds, targetOffsetMs / 1000.0)
                } else {
                    "~%.1fs".format(seconds)
                }
            } else {
                latencyLayout.visibility = View.GONE
            }
        }
        chatFragment?.updateLiveLatency(liveOffsetMs ?: 0L)
    }

    fun updateStreamInfo(title: String?, gameId: String?, gameSlug: String?, gameName: String?) {
        binding.playerControls.title.apply {
            if (!title.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_TITLE, true)) {
                text = title.trim()
                visibility = View.VISIBLE
            } else {
                text = null
                visibility = View.GONE
            }
        }
        binding.playerControls.category.apply {
            if (!gameName.isNullOrBlank() && prefs.getBoolean(AppConstants.PLAYER_CATEGORY, true)) {
                text = gameName
                visibility = View.VISIBLE
                setOnClickListener {
                    findNavController().navigate(
                        if (prefs.getBoolean(AppConstants.UI_GAMEPAGER, true)) {
                            GamePagerFragmentDirections.actionGlobalGamePagerFragment(
                                gameId = gameId,
                                gameSlug = gameSlug,
                                gameName = gameName
                            )
                        } else {
                            GameMediaFragmentDirections.actionGlobalGameMediaFragment(
                                gameId = gameId,
                                gameSlug = gameSlug,
                                gameName = gameName
                            )
                        }
                    )
                    minimize()
                }
            } else {
                text = null
                visibility = View.GONE
            }
        }
    }

    fun restartPlayer() {
        if (viewModel.quality != CHAT_ONLY_QUALITY) {
            val shouldRetryPreferredKickEngine =
                videoType == STREAM &&
                    requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) &&
                    requireArguments().getBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE)
            if (shouldRetryPreferredKickEngine) {
                requireArguments().putBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE, false)
                updateRestartButtonUi()
                (activity as? MainActivity)?.startStream(
                    stream = getCurrentStream(),
                    resolvedUrl = requireArguments().getString(KEY_RESOLVED_STREAM_URL),
                    forceStandardLiveEngine = false
                ) ?: loadStream()
            } else {
                loadStream()
            }
        }
    }

    protected fun retryKickStreamWithFreshResolvedUrl(reason: String = "403 recovery"): Boolean {
        return reloadKickStreamWithFreshResolvedUrl(
            stalePlaybackUrl = requireArguments().getString(KEY_RESOLVED_STREAM_URL),
            reason = reason,
            delayMs = 1500L
        )
    }

    open fun showOfflineOverlay(messageResId: Int = R.string.stream_ended) {
        if (_binding == null) return
        binding.bufferingIndicator.isVisible = false
        binding.offlineText.setText(messageResId)
        binding.offlineOverlay.visibility = View.VISIBLE
        hideController(force = true)
        binding.playerControls.root.visibility = View.GONE
        binding.playerControls.root.alpha = 0f
    }

    open fun hideOfflineOverlay() {
        if (_binding == null) return
        binding.offlineOverlay.visibility = View.GONE
    }

    protected fun reloadKickStreamWithFreshResolvedUrl(
        stalePlaybackUrl: String? = requireArguments().getString(KEY_RESOLVED_STREAM_URL),
        reason: String,
        delayMs: Long = 0L
    ): Boolean {
        if (!isAdded) {
            return false
        }
        val isKickStream =
            videoType == STREAM &&
                requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true)
        val hasChannelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN)?.isNotBlank() == true
        if (!isKickStream || !hasChannelLogin || !viewModel.shouldRetryKickStreamWithFreshUrl()) {
            return false
        }
        requireArguments().putString(KEY_RESOLVED_STREAM_URL, null)
        viewModel.streamResult.value = null
        // Keep real recovery signals (IVS/HTTP/403) as warnings; idle refresh is routine.
        val logAsWarning = reason.contains("error", ignoreCase = true) ||
            reason.contains("403", ignoreCase = true) ||
            reason.contains("http", ignoreCase = true)
        val refreshMessage =
            "Kick stream $reason: forcing fresh playback URL channel=${requireArguments().getString(KEY_CHANNEL_LOGIN)} " +
                "hadStaleUrl=${!stalePlaybackUrl.isNullOrBlank()} customProxy=${viewModel.useCustomProxy}"
        if (logAsWarning) {
            DiagnosticLogger.w("PlayerFragment", refreshMessage)
        } else {
            DiagnosticLogger.i("PlayerFragment", refreshMessage)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            if (delayMs > 0L) {
                delay(delayMs)
            }
            try {
                DiagnosticLogger.i(
                    "PlayerFragment",
                    "Kick stream $reason: loading fresh URL channel=${requireArguments().getString(KEY_CHANNEL_LOGIN)}"
                )
                loadStream(forceRefresh = true, stalePlaybackUrl = stalePlaybackUrl)
            } catch (e: Exception) {
                DiagnosticLogger.e("PlayerFragment", "Kick stream $reason failed", e)
            }
        }
        return true
    }

    private fun updateRestartButtonUi() {
        val isRetryIvsAction =
            videoType == STREAM &&
                requireArguments().getString(KEY_STREAM_SOURCE).equals(AppConstants.KICK, true) &&
                requireArguments().getBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE)
        val description = if (isRetryIvsAction) {
            getString(R.string.retry_ivs)
        } else {
            getString(R.string.restart_player)
        }
        binding.playerControls.restart.contentDescription = description
        TooltipCompat.setTooltipText(binding.playerControls.restart, description)
    }

    fun openMultiPov() {
        if (videoType != STREAM) return
        val stream = getCurrentStream()
        val resolvedUrl = requireArguments().getString(KEY_RESOLVED_STREAM_URL)
        val key = (stream.channelId ?: stream.channelLogin ?: stream.id ?: stream.channelName.orEmpty()).lowercase()
        val urls = buildMap {
            resolvedUrl?.takeIf { it.isNotBlank() }?.let { put(key, it) }
                ?: stream.playbackUrl?.takeIf { it.isNotBlank() }?.let { put(key, it) }
        }
        (activity as? MainActivity)?.startMultiPov(
            streams = listOf(stream),
            resolvedUrls = urls,
            focusedKey = key,
        )
    }

    fun showVodGames() {
        viewModel.gamesList.value?.let {
            PlayerGamesDialog.newInstance(it).show(childFragmentManager, "closeOnPip")
        }
    }

    fun checkBookmark() {
        requireArguments().getString(KEY_VIDEO_ID)?.let { viewModel.checkBookmark(it) }
    }

    fun saveBookmark() {
        viewModel.saveBookmark(
            filesDir = requireContext().filesDir.path,
            networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
            kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext()),
            kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext()),
            videoId = requireArguments().getString(KEY_VIDEO_ID),
            title = requireArguments().getString(KEY_TITLE),
            uploadDate = requireArguments().getString(KEY_UPLOAD_DATE),
            duration = requireArguments().getString(KEY_DURATION),
            type = requireArguments().getString(KEY_VIDEO_TYPE),
            animatedPreviewUrl = requireArguments().getString(KEY_VIDEO_ANIMATED_PREVIEW),
            channelId = requireArguments().getString(KEY_CHANNEL_ID),
            channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
            channelName = requireArguments().getString(KEY_CHANNEL_NAME),
            channelLogo = requireArguments().getString(KEY_CHANNEL_LOGO),
            thumbnail = requireArguments().getString(KEY_THUMBNAIL),
            gameId = requireArguments().getString(KEY_GAME_ID),
            gameSlug = requireArguments().getString(KEY_GAME_SLUG),
            gameName = requireArguments().getString(KEY_GAME_NAME),
        )
    }

    protected fun setDefaultQuality() {
        viewModel.quality = resolvePreferredQualityForCurrentNetwork()
    }

    protected open fun onNetworkTypeChanged(type: NetworkMonitor.NetworkType) {
        handleDefaultNetworkTypeChanged(type)
    }

    private fun handleDefaultNetworkTypeChanged(type: NetworkMonitor.NetworkType) {
        val previous = previousNetworkType
        previousNetworkType = type
        if (previous == null || previous == type) return
        if (type == NetworkMonitor.NetworkType.OTHER || type == NetworkMonitor.NetworkType.NONE || type == NetworkMonitor.NetworkType.UNKNOWN) return
        if (previous == NetworkMonitor.NetworkType.OTHER || previous == NetworkMonitor.NetworkType.NONE || previous == NetworkMonitor.NetworkType.UNKNOWN) return
        val isCellular = type == NetworkMonitor.NetworkType.CELLULAR
        val preferredQuality = resolvePreferredQuality(isCellular) ?: return
        if (preferredQuality != viewModel.quality) {
            runAutomaticQualityChange {
                changeQuality(preferredQuality)
            }
            logAutomaticQualityChange(preferredQuality, type)
        }
    }

    protected fun runAutomaticQualityChange(block: () -> Unit) {
        automaticQualityChangeInProgress = true
        try {
            block()
        } finally {
            automaticQualityChangeInProgress = false
        }
    }

    protected fun logAutomaticQualityChange(qualityKey: String?, type: NetworkMonitor.NetworkType? = null) {
        val qualityName = viewModel.qualities[qualityKey]?.first ?: qualityKey ?: return
        val typeName = type?.let { networkMonitor.formatNetworkType(it) }
        viewModel.qualityChangeFlow.tryEmit(
            if (typeName != null) {
                "$typeName -> $qualityName"
            } else {
                qualityName
            }
        )
    }

    protected fun isActiveNetworkCellular(): Boolean {
        return networkMonitor.isCellular
    }

    protected fun resolvePreferredQualityForCurrentNetwork(): String? {
        return resolvePreferredQuality(networkMonitor.isCellular)
            ?: viewModel.qualities.entries.firstOrNull()?.key
    }

    protected fun resolvePreferredQuality(cellular: Boolean): String? {
        val defaultQuality = if (cellular) {
            prefs.getString(AppConstants.PLAYER_DEFAULT_CELLULAR_QUALITY, "saved")
        } else {
            prefs.getString(AppConstants.PLAYER_DEFAULTQUALITY, "saved")
        }?.substringBefore(" ")
        return when (defaultQuality) {
            "saved" -> {
                val savedQuality = prefs.getString(AppConstants.PLAYER_QUALITY, "720p60")?.substringBefore(" ")
                when (savedQuality) {
                    AUTO_QUALITY -> viewModel.qualities.entries.find { it.key == AUTO_QUALITY }?.key
                    AUDIO_ONLY_QUALITY -> viewModel.qualities.entries.find { it.key == AUDIO_ONLY_QUALITY }?.key
                    CHAT_ONLY_QUALITY -> viewModel.qualities.entries.find { it.key == CHAT_ONLY_QUALITY }?.key
                    else -> findQuality(savedQuality)
                }
            }
            AUTO_QUALITY -> viewModel.qualities.entries.find { it.key == AUTO_QUALITY }?.key
            "Source" -> viewModel.qualities.entries.find { it.key != AUTO_QUALITY }?.key
            AUDIO_ONLY_QUALITY -> viewModel.qualities.entries.find { it.key == AUDIO_ONLY_QUALITY }?.key
            CHAT_ONLY_QUALITY -> viewModel.qualities.entries.find { it.key == CHAT_ONLY_QUALITY }?.key
            else -> findQuality(defaultQuality)
        }
    }

    private fun findQuality(targetQualityString: String?): String? {
        val targetQuality = targetQualityString?.split("p")
        return targetQuality?.getOrNull(0)?.takeWhile { it.isDigit() }?.toIntOrNull()?.let { targetResolution ->
            val targetFps = targetQuality.getOrNull(1)?.takeWhile { it.isDigit() }?.toIntOrNull() ?: 30
            val selectableQualities = viewModel.qualities.keys.filter {
                it != AUDIO_ONLY_QUALITY && it != CHAT_ONLY_QUALITY
            }
            val fallbackQuality = selectableQualities.lastOrNull()
            selectableQualities.find { qualityString ->
                val quality = qualityString.split("p")
                val resolution = quality.getOrNull(0)?.takeWhile { it.isDigit() }?.toIntOrNull()
                val fps = quality.getOrNull(1)?.takeWhile { it.isDigit() }?.toIntOrNull() ?: 30
                resolution != null && ((targetResolution == resolution && targetFps >= fps) || targetResolution > resolution || qualityString == fallbackQuality)
            } ?: fallbackQuality
        }
    }

    fun changePlayerMode() {
        with(binding) {
            if (canEnterPictureInPicture()) {
                if (!controllerHideOnTouch && !controllerIsAnimating && controllerAutoHide && !binding.playerControls.progressBar.isPressed) {
                    playerControls.root.postDelayed(controllerHideAction, 3000)
                }
                controllerHideOnTouch = true
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) &&
                    prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
                ) {
                    requireActivity().setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(true).build())
                }
            } else {
                controllerHideOnTouch = false
                showController(true)
                updateProgress()
                requireView().keepScreenOn = true
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
                ) {
                    requireActivity().setPictureInPictureParams(PictureInPictureParams.Builder().setAutoEnterEnabled(false).build())
                }
            }
        }
    }

    protected fun showController(force: Boolean = false) {
        if (_binding != null && binding.offlineOverlay.isVisible) {
            return
        }
        if (!controllerIsAnimating) {
            if (!binding.playerControls.root.isVisible) {
                binding.playerControls.root.removeCallbacks(controllerHideAction)
                controllerAnimation = binding.playerControls.root.animate().apply {
                    alpha(1f)
                    setDuration(250L)
                    setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationStart(animation: Animator) {
                                controllerIsAnimating = true
                                if (view != null) {
                                    binding.playerControls.root.visibility = View.VISIBLE
                                    updateProgress()
                                }
                            }

                            override fun onAnimationEnd(animation: Animator) {
                                controllerIsAnimating = false
                                setListener(null)
                                if (view != null && controllerAutoHide && controllerHideOnTouch && !binding.playerControls.progressBar.isPressed) {
                                    binding.playerControls.root.postDelayed(controllerHideAction, 3000)
                                }
                            }
                        }
                    )
                    start()
                }
            } else {
                binding.playerControls.root.removeCallbacks(controllerHideAction)
                if (controllerAutoHide && controllerHideOnTouch && !binding.playerControls.progressBar.isPressed) {
                    binding.playerControls.root.postDelayed(controllerHideAction, 3000)
                }
            }
        } else {
            if (force) {
                controllerAnimation?.cancel()
                binding.playerControls.root.removeCallbacks(controllerHideAction)
                binding.playerControls.root.alpha = 1f
                binding.playerControls.root.visibility = View.VISIBLE
                if (controllerAutoHide && controllerHideOnTouch && !binding.playerControls.progressBar.isPressed) {
                    binding.playerControls.root.postDelayed(controllerHideAction, 3000)
                }
            }
        }
    }

    private fun hideController(force: Boolean = false) {
        if (!controllerIsAnimating && binding.playerControls.root.isVisible) {
            controllerAnimation = binding.playerControls.root.animate().apply {
                alpha(0f)
                setDuration(250L)
                setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationStart(animation: Animator) {
                            controllerIsAnimating = true
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            controllerIsAnimating = false
                            setListener(null)
                            if (view != null) {
                                binding.playerControls.root.visibility = View.GONE
                            }
                        }
                    }
                )
                start()
            }
        } else {
            if (force) {
                controllerAnimation?.cancel()
                binding.playerControls.root.alpha = 0f
                binding.playerControls.root.visibility = View.GONE
            }
        }
    }

    private fun showStatusBar() {
        WindowCompat.getInsetsController(
            requireActivity().window,
            requireActivity().window.decorView
        ).show(WindowInsetsCompat.Type.systemBars())
    }

    private fun hideStatusBar() {
        WindowCompat.getInsetsController(
            requireActivity().window,
            requireActivity().window.decorView
        ).hide(WindowInsetsCompat.Type.systemBars())
    }

    private fun enableBackground() {
        backgroundVisible = true
        binding.playerBackground.setBackgroundColor(
            if (isPortrait) {
                backgroundColor ?: MaterialColors.getColor(binding.playerBackground, com.google.android.material.R.attr.colorSurface).also { backgroundColor = it }
            } else {
                Color.BLACK
            }
        )
        binding.playerBackground.isClickable = true
    }

    private fun disableBackground() {
        backgroundVisible = false
        binding.playerBackground.setBackgroundColor(Color.TRANSPARENT)
        binding.playerBackground.isClickable = false
    }

    private fun getHorizontalInsets(windowInsets: WindowInsetsCompat?): Int {
        return if (windowInsets != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && prefs.getBoolean(AppConstants.PLAYER_ROUNDED_CORNER_PADDING, false)) {
                val rootWindowInsets = requireView().rootWindowInsets
                val topLeft = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_TOP_LEFT)
                val topRight = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_TOP_RIGHT)
                val bottomLeft = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_BOTTOM_LEFT)
                val bottomRight = rootWindowInsets.getRoundedCorner(RoundedCorner.POSITION_BOTTOM_RIGHT)
                val leftRadius = max(topLeft?.radius ?: 0, bottomLeft?.radius ?: 0)
                val rightRadius = max(topRight?.radius ?: 0, bottomRight?.radius ?: 0)
                if (prefs.getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)) {
                    leftRadius + rightRadius
                } else {
                    val cutoutInsets = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout())
                    max(cutoutInsets.left, leftRadius) + max(cutoutInsets.right, rightRadius)
                }
            } else {
                if (prefs.getBoolean(AppConstants.UI_DRAW_BEHIND_CUTOUTS, false)) {
                    0
                } else {
                    val cutoutInsets = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout())
                    cutoutInsets.left + cutoutInsets.right
                }
            }
        } else 0
    }

    private fun getScaleValues(): Pair<Float, Float> {
        return if (isPortrait) {
            0.5f to 0.5f
        } else {
            0.3f to 0.325f
        }
    }

    fun getIsPortrait() = isPortrait

    fun reloadEmotes() = chatFragment?.reloadEmotes()

    fun isActive() = chatFragment?.isActive()

    fun disconnect() = chatFragment?.disconnect()

    fun reconnect() = chatFragment?.reconnect()

    fun secondViewIsHidden() = _binding?.let { !it.chatLayout.isVisible && isMaximized } == true

    fun canEnterPictureInPicture(): Boolean {
        val quality = if (viewModel.restoreQuality) {
            viewModel.previousQuality
        } else {
            viewModel.quality
        }
        return quality != AUDIO_ONLY_QUALITY && quality != CHAT_ONLY_QUALITY
    }

    protected fun shouldContinuePlaybackInBackground(): Boolean {
        if ((activity as? com.xtrakick.app.ui.main.MainActivity)?.isLaunchingSettings() == true) {
            return true
        }
        val isInteractive = (requireContext().getSystemService(Context.POWER_SERVICE) as PowerManager).isInteractive
        val isInPipMode = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> requireActivity().isInPictureInPictureMode
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> !useController && isMaximized
            else -> false
        }
        return when {
            isInPipMode -> {
                (isInteractive && prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_CLOSED, false)) ||
                    (!isInteractive && prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO_PIP_LOCKED, true))
            }
            !isMaximized -> false
            else -> {
                (isInteractive && prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO, true)) ||
                    (!isInteractive && prefs.getBoolean(AppConstants.PLAYER_BACKGROUND_AUDIO_LOCKED, true))
            }
        }
    }

    protected fun shouldClosePlaybackAfterPipDismiss(): Boolean {
        if (shouldContinuePlaybackInBackground()) {
            return false
        }
        val activity = activity ?: return false
        val isInPipMode = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> activity.isInPictureInPictureMode
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> !useController && isMaximized
            else -> false
        }
        return wasInPictureInPictureMode &&
            !isInPipMode &&
            !activity.isChangingConfigurations &&
            !activity.isFinishing
    }

    protected fun clearPipDismissState() {
        wasInPictureInPictureMode = false
    }

    protected fun setPipActions(playing: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
            requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) &&
            prefs.getBoolean(AppConstants.PLAYER_PICTURE_IN_PICTURE, true)
        ) {
            requireActivity().setPictureInPictureParams(
                PictureInPictureParams.Builder().apply {
                    setActions(listOf(
                        RemoteAction(
                            Icon.createWithResource(requireContext(), R.drawable.baseline_audiotrack_black_24),
                            getString(R.string.audio_only),
                            getString(R.string.audio_only),
                            PendingIntent.getBroadcast(
                                requireContext(),
                                REQUEST_CODE_AUDIO_ONLY,
                                Intent(MainActivity.INTENT_START_AUDIO_ONLY).setPackage(requireContext().packageName),
                                PendingIntent.FLAG_IMMUTABLE
                            )
                        ),
                        if (playing) {
                            RemoteAction(
                                Icon.createWithResource(requireContext(), R.drawable.baseline_pause_black_48),
                                getString(R.string.pause),
                                getString(R.string.pause),
                                PendingIntent.getBroadcast(
                                    requireContext(),
                                    REQUEST_CODE_PLAY_PAUSE,
                                    Intent(MainActivity.INTENT_PLAY_PAUSE_PLAYER).setPackage(requireContext().packageName),
                                    PendingIntent.FLAG_IMMUTABLE
                                )
                            )
                        } else {
                            RemoteAction(
                                Icon.createWithResource(requireContext(), R.drawable.baseline_play_arrow_black_48),
                                getString(R.string.resume),
                                getString(R.string.resume),
                                PendingIntent.getBroadcast(
                                    requireContext(),
                                    REQUEST_CODE_PLAY_PAUSE,
                                    Intent(MainActivity.INTENT_PLAY_PAUSE_PLAYER).setPackage(requireContext().packageName),
                                    PendingIntent.FLAG_IMMUTABLE
                                )
                            )
                        }
                    ))
                }.build()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        val isInPIPMode = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> requireActivity().isInPictureInPictureMode
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> !useController && isMaximized
            else -> false
        }
        if (isInPIPMode) {
            if (isPortrait) {
                binding.chatLayout.visibility = View.GONE
            } else {
                hideChatLayout()
            }
            useController = false
        }
    }

    override fun initialize() {
        if (requireArguments().getString(KEY_TYPE) != OFFLINE_VIDEO) {
            viewModel.isFollowingChannel(
                requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                requireArguments().getString(KEY_CHANNEL_ID),
                requireArguments().getString(KEY_CHANNEL_LOGIN),
                prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                KickApiHelper.getKickWebHeaders(requireContext(), true),
                KickApiHelper.getKickPublicApiHeaders(requireContext()),
            )
            if (videoType == VIDEO) {
                val videoId = requireArguments().getString(KEY_VIDEO_ID)
                if (!videoId.isNullOrBlank() &&
                    !requireArguments().getString(KEY_VIDEO_SOURCE).equals(AppConstants.KICK, true) &&
                    (prefs.getBoolean(AppConstants.PLAYER_GAMESBUTTON, true) || prefs.getBoolean(AppConstants.PLAYER_MENU_GAMES, false))
                ) {
                    viewModel.loadGamesList(
                        videoId,
                        prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                        KickApiHelper.getKickWebHeaders(requireContext()),
                        prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                    )
                }
            }
        }
    }

    protected fun startPlayer() {
        viewModel.started = true
        when (videoType) {
            STREAM -> {
                viewModel.useCustomProxy = prefs.getBoolean(AppConstants.PLAYER_STREAM_PROXY, false)
                loadStream()
                viewModel.loadStream(
                    channelId = requireArguments().getString(KEY_CHANNEL_ID),
                    channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                    viewerCount = requireArguments().getInt(KEY_VIEWER_COUNT).takeIf { it != -1 },
                    loop = requireContext().prefs().getBoolean(AppConstants.CHAT_DISABLE, false) ||
                            !requireContext().prefs().getBoolean(AppConstants.CHAT_PUBSUB_ENABLED, true) ||
                            (requireContext().prefs().getBoolean(AppConstants.CHAT_POINTS_COLLECT, true) &&
                                    !requireContext().tokenPrefs().getString(AppConstants.USER_ID, null).isNullOrBlank() &&
                                    com.xtrakick.app.util.AuthStateHelper.isKickLoggedIn(requireContext())),
                    networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(requireContext()),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext()),
                    enableIntegrity = requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                )
            }
            VIDEO -> {
                if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                    val id = requireArguments().getString(KEY_VIDEO_ID)?.toLongOrNull()
                    if (id != null) {
                        viewModel.getVideoPosition(id)
                    } else {
                        playVideo((prefs.getString(AppConstants.TOKEN_SKIP_VIDEO_ACCESS_TOKEN, "2")?.toIntOrNull() ?: 2) <= 1, 0)
                    }
                } else {
                    if (requireArguments().getBoolean(KEY_IGNORE_SAVED_POSITION)) {
                        playVideo((prefs.getString(AppConstants.TOKEN_SKIP_VIDEO_ACCESS_TOKEN, "2")?.toIntOrNull() ?: 2) <= 1, requireArguments().getLong(KEY_OFFSET).takeIf { it != -1L } ?: 0)
                        requireArguments().putBoolean(KEY_IGNORE_SAVED_POSITION, false)
                        requireArguments().putLong(KEY_OFFSET, -1)
                    } else {
                        playVideo((prefs.getString(AppConstants.TOKEN_SKIP_VIDEO_ACCESS_TOKEN, "2")?.toIntOrNull() ?: 2) <= 1, 0)
                    }
                }
            }
            CLIP -> {
                val clipUrl = requireArguments().getString(KEY_URL)
                if (!clipUrl.isNullOrBlank()) {
                    viewModel.qualities = mapOf(
                        "source" to Pair(getString(R.string.source), clipUrl),
                        AUDIO_ONLY_QUALITY to Pair(getString(R.string.audio_only), null)
                    )
                    setDefaultQuality()
                    changePlayerMode()
                    activePlaybackUrl = clipUrl
                    startClip(clipUrl)
                }
                // Kick serves the clip quality ladder through the web playback
                // endpoint, so fetch it even when the MP4 URL is already known.
                viewModel.loadClip(
                    networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext()),
                    id = requireArguments().getString(KEY_CLIP_ID),
                    enableIntegrity = requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                )
            }
            OFFLINE_VIDEO -> {
                if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                    viewModel.getOfflineVideoPosition(requireArguments().getInt(KEY_OFFLINE_VIDEO_ID))
                } else {
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.savedOfflineVideoPosition.value = 0
                    }
                }
            }
        }
    }

    private fun loadStream(forceRefresh: Boolean = false, stalePlaybackUrl: String? = null) {
        if (forceRefresh) {
            hideOfflineOverlay()
        }
        if (!forceRefresh) {
            requireArguments().getString(KEY_RESOLVED_STREAM_URL)?.takeIf { it.isNotBlank() }?.let { resolvedUrl ->
                hideOfflineOverlay()
                startStream(resolvedUrl)
                return
            }
        }
        requireArguments().getString(KEY_CHANNEL_LOGIN)?.let { channelLogin ->
            val proxyUrl = prefs.getString(AppConstants.PLAYER_PROXY_URL, "")
            if (!forceRefresh && viewModel.useCustomProxy && !proxyUrl.isNullOrBlank()) {
                DiagnosticLogger.w(
                    "PlayerFragment",
                    "Kick stream load: using custom proxy channel=$channelLogin"
                )
                startStream(proxyUrl.replace("\$channel", channelLogin))
            } else {
                if (viewModel.useCustomProxy) {
                    DiagnosticLogger.w(
                        "PlayerFragment",
                        "Kick stream load: disabling custom proxy for forceRefresh=$forceRefresh channel=$channelLogin"
                    )
                    viewModel.useCustomProxy = false
                }
                if (forceRefresh) {
                    DiagnosticLogger.i(
                        "PlayerFragment",
                        "Kick stream load: requesting resolved URL channel=$channelLogin staleUrlPresent=${!stalePlaybackUrl.isNullOrBlank()}"
                    )
                }
                viewModel.loadStreamResult(
                    networkLibrary = prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), prefs.getBoolean(AppConstants.TOKEN_INCLUDE_TOKEN_STREAM, true)),
                    channelLogin = channelLogin,
                    randomDeviceId = prefs.getBoolean(AppConstants.TOKEN_RANDOM_DEVICEID, true),
                    xDeviceId = prefs.getString(AppConstants.TOKEN_XDEVICEID, "kick-web-player"),
                    playerType = prefs.getString(AppConstants.TOKEN_PLAYERTYPE, "site"),
                    supportedCodecs = prefs.getString(AppConstants.TOKEN_SUPPORTED_CODECS, "av1,h265,h264"),
                    proxyPlaybackAccessToken = prefs.getBoolean(AppConstants.PROXY_PLAYBACK_ACCESS_TOKEN, false),
                    proxyHost = prefs.getString(AppConstants.PROXY_HOST, null),
                    proxyPort = prefs.getString(AppConstants.PROXY_PORT, null)?.toIntOrNull(),
                    proxyUser = prefs.getString(AppConstants.PROXY_USER, null),
                    proxyPassword = prefs.getString(AppConstants.PROXY_PASSWORD, null),
                    enableIntegrity = prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                    forceRefresh = forceRefresh,
                    stalePlaybackUrl = stalePlaybackUrl
                )
            }
        }
    }

    protected fun playVideo(skipAccessToken: Boolean, playbackPosition: Long?) {
        // start from the beginning when the saved position is at (or past) the end
        val position = playbackPosition?.let { saved ->
            val durationMs = requireArguments().getString(KEY_DURATION)?.let { KickApiHelper.getDuration(it) }?.times(1000L)
            if (durationMs != null && durationMs > 0 && saved >= durationMs) 0L else saved
        }
        requireArguments().getString(KEY_URL)?.takeIf { it.isNotBlank() }?.let { directUrl ->
            val isHlsPlaylist = directUrl.contains(".m3u8", ignoreCase = true)
            if (isHlsPlaylist) {
                viewModel.qualities = emptyMap()
                viewModel.quality = null
                viewModel.updateQualities = true
                startVideo(directUrl, position, true)
            } else {
                viewModel.qualities = mapOf(
                    "source" to Pair(getString(R.string.source), directUrl),
                    AUDIO_ONLY_QUALITY to Pair(getString(R.string.audio_only), null)
                )
                setDefaultQuality()
                changePlayerMode()
                startVideo(directUrl, position, false)
            }
            return
        }
        if (skipAccessToken && !requireArguments().getString(KEY_VIDEO_ANIMATED_PREVIEW).isNullOrBlank()) {
            requireArguments().getString(KEY_VIDEO_ANIMATED_PREVIEW)?.let { preview ->
                val qualityMap = KickApiHelper.getVideoUrlMapFromPreview(preview, requireArguments().getString(KEY_VIDEO_TYPE), viewModel.backupQualities)
                val map = mutableMapOf<String, Pair<String, String?>>()
                qualityMap.forEach {
                    when (it.key) {
                        "source" -> map[it.key] = Pair(getString(R.string.source), it.value)
                        "audio_only" -> map[it.key] = Pair(getString(R.string.audio_only), it.value)
                        else -> map[it.key] = Pair(it.key, it.value)
                    }
                }
                map.put(AUDIO_ONLY_QUALITY, map.remove(AUDIO_ONLY_QUALITY) //move audio option to bottom
                    ?: Pair(getString(R.string.audio_only), null))
                val qualities = map.toList()
                    .sortedByDescending {
                        it.first.substringAfter("p", "").takeWhile { it.isDigit() }.toIntOrNull()
                    }
                    .sortedByDescending {
                        it.first.substringBefore("p", "").takeWhile { it.isDigit() }.toIntOrNull()
                    }
                    .sortedByDescending {
                        it.first == "source"
                    }
                    .toMap()
                viewModel.qualities = qualities
                viewModel.quality = qualities.keys.firstOrNull()
                qualities.values.firstOrNull()?.second
            }?.let { url ->
                startVideo(url, position, false)
            }
        } else {
            viewModel.playbackPosition = position
            viewModel.loadVideo(
                networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), prefs.getBoolean(AppConstants.TOKEN_INCLUDE_TOKEN_VIDEO, true)),
                videoId = requireArguments().getString(KEY_VIDEO_ID),
                videoSource = requireArguments().getString(KEY_VIDEO_SOURCE),
                channelId = requireArguments().getString(KEY_CHANNEL_ID),
                channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                playerType = prefs.getString(AppConstants.TOKEN_PLAYERTYPE_VIDEO, "channel_home_live"),
                supportedCodecs = prefs.getString(AppConstants.TOKEN_SUPPORTED_CODECS, "av1,h265,h264"),
                enableIntegrity = prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
            )
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        with(binding) {
            resetVideoZoom(false)
            isPortrait = newConfig.orientation == Configuration.ORIENTATION_PORTRAIT
            if (isMaximized) {
                enableBackground()
            } else {
                disableBackground()
            }
            val isInPIPMode = when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> requireActivity().isInPictureInPictureMode
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> !useController && isMaximized
                else -> false
            }
            if (!isInPIPMode) {
                (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(chatLayout.windowToken, 0)
                chatLayout.clearFocus()
                initLayout()
            }
            (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog?)?.dismiss()
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        wasInPictureInPictureMode = wasInPictureInPictureMode || isInPictureInPictureMode
        with(binding) {
            if (isInPictureInPictureMode) {
                resetVideoZoom(false)
                if (!isMaximized) {
                    isMaximized = true
                    requireActivity().onBackPressedDispatcher.addCallback(this@PlayerFragment, backPressedCallback)
                    if (videoType == STREAM && chatFragment?.emoteMenuIsVisible() == true) {
                        chatFragment?.toggleBackPressedCallback(true)
                    }
                    slidingLayout.translationX = 0f
                    slidingLayout.translationY = 0f
                    slidingLayout.scaleX = 1f
                    slidingLayout.scaleY = 1f
                }
                if (isPortrait) {
                    chatLayout.visibility = View.GONE
                } else {
                    hideChatLayout()
                }
                useController = false
                controllerAnimation?.cancel()
                binding.playerControls.root.alpha = 0f
                binding.playerControls.root.visibility = View.GONE
                // player dialog
                (childFragmentManager.findFragmentByTag("closeOnPip") as? BottomSheetDialogFragment)?.dismiss()
                // player chat message dialog
                (chatFragment?.childFragmentManager?.findFragmentByTag("messageDialog") as? BottomSheetDialogFragment)?.dismiss()
                (chatFragment?.childFragmentManager?.findFragmentByTag("replyDialog") as? BottomSheetDialogFragment)?.dismiss()
                (chatFragment?.childFragmentManager?.findFragmentByTag("imageDialog") as? BottomSheetDialogFragment)?.dismiss()
            } else {
                useController = true
                // System PiP hides chat while active; restore the user's landscape preference on exit.
                if (isMaximized && !isPortrait) {
                    restoreLandscapeChatIfNeeded(animate = false)
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unlockOrientationJob?.cancel()
        unlockOrientationJob = null

        binding.playerControls.root.removeCallbacks(controllerHideAction)
    }

    private fun isVideoZoomed() = videoZoomScale > MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_EPSILON

    private fun restoreVideoResizeMode() {
        _binding?.aspectRatioFrameLayout?.resizeMode = if (isPortrait) {
            AspectRatioFrameLayout.RESIZE_MODE_FIT
        } else {
            resizeMode
        }
    }

    private fun formatVideoZoomScale(scale: Float): String {
        return String.format(Locale.US, "%.1fx", scale.coerceIn(MIN_VIDEO_ZOOM_SCALE, MAX_VIDEO_ZOOM_SCALE))
    }

    private fun applyVideoZoom() {
        val binding = _binding ?: return
        val zoomView = getVideoZoomView()
        listOf(binding.aspectRatioFrameLayout, binding.playerSurface, binding.playerTexture).forEach { view ->
            view.pivotX = 0f
            view.pivotY = 0f
            if (view == zoomView) {
                view.scaleX = videoZoomScale
                view.scaleY = videoZoomScale
                view.translationX = videoZoomTranslationX
                view.translationY = videoZoomTranslationY
            } else {
                view.scaleX = MIN_VIDEO_ZOOM_SCALE
                view.scaleY = MIN_VIDEO_ZOOM_SCALE
                view.translationX = 0f
                view.translationY = 0f
            }
        }
    }

    private fun getScaledVideoTranslation(
        focus: Float,
        viewStart: Float,
        currentTranslation: Float,
        scaleChange: Float
    ): Float {
        return focus - viewStart - ((focus - viewStart - currentTranslation) * scaleChange)
    }

    private fun clampVideoZoomTranslation() {
        val binding = _binding ?: return
        val videoView = getVideoZoomView()
        val videoWidth = videoView.width
        val videoHeight = videoView.height
        val viewportWidth = binding.playerLayout.width
        val viewportHeight = binding.playerLayout.height
        if (videoWidth <= 0 || videoHeight <= 0 || viewportWidth <= 0 || viewportHeight <= 0) {
            videoZoomTranslationX = 0f
            videoZoomTranslationY = 0f
            return
        }
        videoZoomTranslationX = getClampedVideoTranslation(
            translation = videoZoomTranslationX,
            viewStart = getVideoSurfaceLeft(),
            viewSize = videoWidth.toFloat(),
            viewportSize = viewportWidth.toFloat()
        )
        videoZoomTranslationY = getClampedVideoTranslation(
            translation = videoZoomTranslationY,
            viewStart = getVideoSurfaceTop(),
            viewSize = videoHeight.toFloat(),
            viewportSize = viewportHeight.toFloat()
        )
    }

    private fun getClampedVideoTranslation(
        translation: Float,
        viewStart: Float,
        viewSize: Float,
        viewportSize: Float
    ): Float {
        val scaledSize = viewSize * videoZoomScale
        return if (scaledSize <= viewportSize) {
            ((viewportSize - scaledSize) / 2f) - viewStart
        } else {
            translation.coerceIn(viewportSize - viewStart - scaledSize, -viewStart)
        }
    }

    private fun getVideoSurfaceLeft(): Float {
        val binding = _binding ?: return 0f
        return binding.aspectRatioFrameLayout.left + getVideoZoomView().left.toFloat()
    }

    private fun getVideoSurfaceTop(): Float {
        val binding = _binding ?: return 0f
        return binding.aspectRatioFrameLayout.top + getVideoZoomView().top.toFloat()
    }

    private fun getVideoZoomView(): View {
        val binding = _binding ?: return requireView()
        return when {
            binding.playerTexture.isVisible -> binding.playerTexture
            binding.playerSurface.isVisible -> binding.playerSurface
            else -> binding.aspectRatioFrameLayout
        }
    }

    private fun snapVideoZoomToFill() {
        videoZoomFillMode = true
        binding.aspectRatioFrameLayout.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        videoZoomScale = MIN_VIDEO_ZOOM_SCALE
        videoZoomTranslationX = 0f
        videoZoomTranslationY = 0f
        applyVideoZoom()
        updateVideoZoomFillHint(false)
        showVideoZoomIndicator(getString(R.string.zoomed_to_fill), true)
    }

    private fun resetVideoZoom(showIndicator: Boolean) {
        videoZoomFillMode = false
        videoZoomScale = MIN_VIDEO_ZOOM_SCALE
        videoZoomTranslationX = 0f
        videoZoomTranslationY = 0f
        restoreVideoResizeMode()
        applyVideoZoom()
        updateVideoZoomFillHint(false)
        videoZoomIndicatorAnimation?.cancel()
        if (showIndicator) {
            showVideoZoomIndicator(getString(R.string.original), true)
        } else {
            _binding?.zoomIndicator?.apply {
                removeCallbacks(hideVideoZoomIndicatorAction)
                alpha = 0f
                visibility = View.GONE
            }
        }
    }

    private fun performVideoZoomFillHaptic() {
        _binding?.dragView?.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
    }

    private fun updateVideoZoomFillHint(active: Boolean = isVideoZoomInFillHintZone()) {
        val binding = _binding ?: return
        if (active == videoZoomFillHintActive) {
            return
        }
        videoZoomFillHintActive = active
        if (active) {
            performVideoZoomFillHaptic()
        }
        videoZoomFillHintAnimation?.cancel()
        binding.zoomFillHint.animate().setListener(null)
        binding.zoomFillHint.animate().cancel()
        if (active) {
            updateVideoZoomFillHintBounds()
            binding.zoomFillHint.visibility = View.VISIBLE
            binding.zoomFillHint.alpha = VIDEO_ZOOM_FILL_HINT_ALPHA
        } else {
            videoZoomFillHintAnimation = binding.zoomFillHint.animate()
                .alpha(0f)
                .setDuration(120L)
                .setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.zoomFillHint.visibility = View.GONE
                            videoZoomFillHintAnimation = null
                        }
                    }
                )
        }
    }

    private fun updateVideoZoomFillHintBounds() {
        val binding = _binding ?: return
        val viewportWidth = binding.playerLayout.width
        val viewportHeight = binding.playerLayout.height
        val videoView = getVideoZoomView()
        val videoLeft = getVideoSurfaceLeft()
        val videoTop = getVideoSurfaceTop()
        val videoRight = videoLeft + videoView.width
        val videoBottom = videoTop + videoView.height
        if (viewportWidth <= 0 || viewportHeight <= 0 || videoRight <= videoLeft || videoBottom <= videoTop) {
            return
        }
        binding.zoomFillHint.setVideoBounds(videoLeft, videoTop, videoRight, videoBottom)
    }

    private fun isVideoZoomInFillHintZone(): Boolean {
        return !videoZoomFillMode &&
            videoZoomScale in (MIN_VIDEO_ZOOM_SCALE + VIDEO_ZOOM_EPSILON)..VIDEO_ZOOM_FILL_ZONE_MAX_SCALE
    }

    private val hideVideoZoomIndicatorAction = Runnable {
        _binding?.zoomIndicator?.let { indicator ->
            videoZoomIndicatorAnimation?.cancel()
            videoZoomIndicatorAnimation = indicator.animate()
                .alpha(0f)
                .setDuration(180L)
                .setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            indicator.visibility = View.GONE
                            videoZoomIndicatorAnimation = null
                        }
                    }
                )
        }
    }

    private fun showVideoZoomIndicator(text: String, delayedHide: Boolean) {
        val indicator = _binding?.zoomIndicator ?: return
        indicator.removeCallbacks(hideVideoZoomIndicatorAction)
        videoZoomIndicatorAnimation?.cancel()
        videoZoomIndicatorAnimation = null
        indicator.text = text
        indicator.visibility = View.VISIBLE
        indicator.animate().setListener(null)
        indicator.animate().cancel()
        indicator.alpha = 1f
        if (delayedHide) {
            indicator.postDelayed(hideVideoZoomIndicatorAction, VIDEO_ZOOM_INDICATOR_HIDE_DELAY_MS)
        }
    }

    protected fun savePosition() {
        when (videoType) {
            VIDEO -> {
                if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                    requireArguments().getString(KEY_VIDEO_ID)?.toLongOrNull()?.let { id ->
                        getCurrentPosition()?.let { position ->
                            viewModel.saveVideoPosition(id, position)
                        }
                    }
                }
            }
            OFFLINE_VIDEO -> {
                if (prefs.getBoolean(AppConstants.PLAYER_USE_VIDEOPOSITIONS, true)) {
                    getCurrentPosition()?.let { position ->
                        viewModel.saveOfflineVideoPosition(requireArguments().getInt(KEY_OFFLINE_VIDEO_ID), position)
                    }
                }
            }
        }
    }

    fun minimize() {
        with(binding) {
            resetVideoZoom(false)
            isMaximized = false
            if (videoType == STREAM && chatFragment?.emoteMenuIsVisible() == true) {
                chatFragment?.toggleBackPressedCallback(false)
            }
            backPressedCallback.remove()
            useController = false
            hideController(true)
            fun animate() {
                val (minimizedScaleX, minimizedScaleY) = getScaleValues()
                val windowInsets = ViewCompat.getRootWindowInsets(requireView())
                val insets = windowInsets?.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
                val keyboardInsets = windowInsets?.getInsets(WindowInsetsCompat.Type.ime())?.bottom?.let { if (it > 0) it - (insets?.bottom ?: 0) else it } ?: 0
                val scaledXDiff = (slidingLayout.width * (1f - minimizedScaleX)) / 2
                val scaledYDiff = (slidingLayout.height * (1f - minimizedScaleY)) / 2
                val navBarHeight = requireView().rootView.findViewById<LinearLayout>(R.id.navBarContainer)?.height?.takeIf { it > 0 }?.let { it - keyboardInsets } ?: (insets?.bottom ?: 0)
                val playerWidth = if (isPortrait) {
                    playerLayout.width
                } else {
                    slidingLayout.width - getHorizontalInsets(windowInsets)
                }
                val newX = slidingLayout.width - (insets?.right ?: 0) - (playerWidth * minimizedScaleX) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, resources.displayMetrics) * minimizedScaleX)
                val newY = slidingLayout.height - navBarHeight - (playerLayout.height * minimizedScaleY) - (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30F, resources.displayMetrics) * minimizedScaleY)
                slidingLayout.animate().apply {
                    translationX(0f - scaledXDiff - ((insets?.left ?: 0) * minimizedScaleX) + newX)
                    translationY(0f - scaledYDiff - ((insets?.top ?: 0) * minimizedScaleY) + newY)
                    scaleX(minimizedScaleX)
                    scaleY(minimizedScaleY)
                    setDuration(250L)
                    setListener(
                        object : AnimatorListenerAdapter() {
                            override fun onAnimationStart(animation: Animator) {
                                isAnimating = true
                                if (view != null) {
                                    disableBackground()
                                }
                            }

                            override fun onAnimationEnd(animation: Animator) {
                                isAnimating = false
                                setListener(null)
                                activePointerId = -1
                            }
                        }
                    )
                    start()
                }
            }
            if (isPortrait) {
                chatLayout.visibility = View.GONE
                slidingLayout.doOnLayout {
                    animate()
                }
            } else {
                showStatusBar()
                // Hide chat only for the mini-player chrome. Keep isChatOpen / KEY_CHAT_OPENED intact
                // so maximize can restore the user's landscape chat preference.
                hideChatLayout()
                slidingLayout.doOnPreDraw {
                    animate()
                }
                val activity = requireActivity()
                unlockOrientationJob?.cancel()
                unlockOrientationJob = activity.lifecycleScope.launch {
                    delay(500L)
                    // Skip if the user already maximized again — unlocking orientation mid-restore
                    // was collapsing landscape chat via configuration/layout races.
                    if (!isMaximized && isAdded) {
                        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                    }
                    unlockOrientationJob = null
                }
            }
        }
    }

    fun maximize() {
        with(binding) {
            unlockOrientationJob?.cancel()
            unlockOrientationJob = null
            isMaximized = true
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedCallback)
            if (videoType == STREAM && chatFragment?.emoteMenuIsVisible() == true) {
                chatFragment?.toggleBackPressedCallback(true)
            }
            useController = true
            if (!controllerHideOnTouch) {
                showController(true)
                updateProgress()
            }
            if (isPortrait) {
                chatLayout.visibility = View.VISIBLE
            } else {
                hideStatusBar()
                restoreLandscapeChatIfNeeded(animate = false)
            }
            slidingLayout.animate().apply {
                translationX(0f)
                translationY(0f)
                scaleX(1f)
                scaleY(1f)
                setDuration(250L)
                setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationStart(animation: Animator) {
                            isAnimating = true
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            isAnimating = false
                            setListener(null)
                            if (view != null) {
                                enableBackground()
                                // Re-apply after the mini-player scale animation so chat width/margins
                                // match the restored full-size landscape layout.
                                if (!isPortrait && isMaximized) {
                                    restoreLandscapeChatIfNeeded(animate = false)
                                }
                            }
                            activePointerId = -1
                        }
                    }
                )
                start()
            }
        }
    }

    fun share() {
        val text = when (videoType) {
            STREAM -> {
                requireArguments().getString(KEY_CHANNEL_LOGIN)?.let { channelLogin ->
                    "https://kick.com/$channelLogin"
                }
            }
            VIDEO -> {
                requireArguments().getString(KEY_VIDEO_ID)?.let { videoId ->
                    val position = getCurrentPosition()?.takeIf { it > 0L }?.let { position ->
                        val totalSeconds = position / 1000
                        String.format(Locale.US, "?t=%02dh%02dm%02ds", totalSeconds / 3600, (totalSeconds % 3600) / 60, totalSeconds % 60)
                    } ?: ""
                    "https://kick.com/video/$videoId$position"
                }
            }
            CLIP -> {
                requireArguments().getString(KEY_CLIP_ID)?.let { clipId ->
                    "https://kick.com/clip/$clipId"
                }
            }
            else -> null
        }
        if (!text.isNullOrBlank()) {
            startActivity(
                Intent.createChooser(
                    Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, text)
                        putExtra(Intent.EXTRA_TITLE, requireArguments().getString(KEY_TITLE))
                        type = "text/plain"
                    },
                    null,
                )
            )
        }
    }

    fun showDownloadDialog() {
        if (viewModel.loaded.value) {
            when (videoType) {
                STREAM -> {
                    val qualities = viewModel.qualities.filter { !it.value.second.isNullOrBlank() }
                    DownloadDialog.newInstance(
                        id = requireArguments().getString(KEY_STREAM_ID),
                        title = requireArguments().getString(KEY_TITLE),
                        startedAt = requireArguments().getString(KEY_STARTED_AT),
                        channelId = requireArguments().getString(KEY_CHANNEL_ID),
                        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                        channelName = requireArguments().getString(KEY_CHANNEL_NAME),
                        channelLogo = requireArguments().getString(KEY_CHANNEL_LOGO),
                        thumbnail = requireArguments().getString(KEY_THUMBNAIL),
                        gameId = requireArguments().getString(KEY_GAME_ID),
                        gameSlug = requireArguments().getString(KEY_GAME_SLUG),
                        gameName = requireArguments().getString(KEY_GAME_NAME),
                        qualityKeys = qualities.keys.toTypedArray(),
                        qualityNames = qualities.map { it.value.first }.toTypedArray(),
                        qualityUrls = qualities.mapNotNull { it.value.second }.toTypedArray(),
                    ).show(childFragmentManager, null)
                }
                VIDEO -> {
                    downloadVideo()
                }
                CLIP -> {
                    val qualities = viewModel.qualities.filter { !it.value.second.isNullOrBlank() }
                    DownloadDialog.newInstance(
                        clipId = requireArguments().getString(KEY_CLIP_ID),
                        title = requireArguments().getString(KEY_TITLE),
                        uploadDate = requireArguments().getString(KEY_UPLOAD_DATE),
                        duration = requireArguments().getDouble(KEY_DURATION),
                        videoId = requireArguments().getString(KEY_VIDEO_ID),
                        vodOffset = requireArguments().getInt(KEY_VOD_OFFSET),
                        channelId = requireArguments().getString(KEY_CHANNEL_ID),
                        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                        channelName = requireArguments().getString(KEY_CHANNEL_NAME),
                        channelLogo = requireArguments().getString(KEY_CHANNEL_LOGO),
                        thumbnail = requireArguments().getString(KEY_THUMBNAIL),
                        gameId = requireArguments().getString(KEY_GAME_ID),
                        gameSlug = requireArguments().getString(KEY_GAME_SLUG),
                        gameName = requireArguments().getString(KEY_GAME_NAME),
                        qualityKeys = qualities.keys.toTypedArray(),
                        qualityNames = qualities.map { it.value.first }.toTypedArray(),
                        qualityUrls = qualities.mapNotNull { it.value.second }.toTypedArray(),
                    ).show(childFragmentManager, null)
                }
            }
        }
    }

    fun onSleepTimerChanged(durationMs: Long, hours: Int, minutes: Int, lockScreen: Boolean) {
        if (durationMs > 0L) {
            Toast.makeText(
                requireContext(),
                when {
                    hours == 0 -> getString(
                        R.string.playback_will_stop,
                        resources.getQuantityString(R.plurals.minutes, minutes, minutes)
                    )
                    minutes == 0 -> getString(
                        R.string.playback_will_stop,
                        resources.getQuantityString(R.plurals.hours, hours, hours)
                    )
                    else -> getString(
                        R.string.playback_will_stop_hours_minutes,
                        resources.getQuantityString(R.plurals.hours, hours, hours),
                        resources.getQuantityString(R.plurals.minutes, minutes, minutes)
                    )
                },
                Toast.LENGTH_LONG
            ).show()
        } else if (((activity as? MainActivity)?.getSleepTimerTimeLeft() ?: 0) > 0L) {
            Toast.makeText(requireContext(), R.string.timer_canceled, Toast.LENGTH_LONG).show()
        }
        if (lockScreen != prefs.getBoolean(AppConstants.SLEEP_TIMER_LOCK, false)) {
            prefs.edit { putBoolean(AppConstants.SLEEP_TIMER_LOCK, lockScreen) }
        }
        (activity as? MainActivity)?.setSleepTimer(durationMs)
    }

    override fun onChange(requestCode: Int, index: Int, text: CharSequence, tag: Int?) {
        when (requestCode) {
            REQUEST_CODE_QUALITY -> {
                changeQuality(viewModel.qualities.keys.elementAtOrNull(index))
                changePlayerMode()
                setQualityText()
            }
            REQUEST_CODE_SPEED -> {
                prefs.getString(AppConstants.PLAYER_SPEED_LIST, "0.25\n0.5\n0.75\n1.0\n1.25\n1.5\n1.75\n2.0\n3.0\n4.0\n8.0")?.split("\n")?.let { speeds ->
                    speeds.getOrNull(index)?.toFloatOrNull()?.let { speed ->
                        setPlaybackSpeed(speed)
                        prefs.edit { putFloat(AppConstants.PLAYER_SPEED, speed) }
                        (childFragmentManager.findFragmentByTag("closeOnPip") as? PlayerSettingsDialog?)?.setSpeed(speed.toString())
                    }
                }
            }
        }
    }

    override fun onIntegrityDialogCallback(callback: String?) {
        if (callback != null) {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    when (callback) {
                        "refreshStream" -> {
                            requireArguments().getString(KEY_CHANNEL_LOGIN)?.let { channelLogin ->
                                viewModel.loadStreamResult(
                                    networkLibrary = prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), prefs.getBoolean(AppConstants.TOKEN_INCLUDE_TOKEN_STREAM, true)),
                                    channelLogin = channelLogin,
                                    randomDeviceId = prefs.getBoolean(AppConstants.TOKEN_RANDOM_DEVICEID, true),
                                    xDeviceId = prefs.getString(AppConstants.TOKEN_XDEVICEID, "kick-web-player"),
                                    playerType = prefs.getString(AppConstants.TOKEN_PLAYERTYPE, "site"),
                                    supportedCodecs = prefs.getString(AppConstants.TOKEN_SUPPORTED_CODECS, "av1,h265,h264"),
                                    proxyPlaybackAccessToken = prefs.getBoolean(AppConstants.PROXY_PLAYBACK_ACCESS_TOKEN, false),
                                    proxyHost = prefs.getString(AppConstants.PROXY_HOST, null),
                                    proxyPort = prefs.getString(AppConstants.PROXY_PORT, null)?.toIntOrNull(),
                                    proxyUser = prefs.getString(AppConstants.PROXY_USER, null),
                                    proxyPassword = prefs.getString(AppConstants.PROXY_PASSWORD, null),
                                    enableIntegrity = prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                    forceRefresh = true
                                )
                            }
                            viewModel.isFollowingChannel(
                                requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                                requireArguments().getString(KEY_CHANNEL_ID),
                                requireArguments().getString(KEY_CHANNEL_LOGIN),
                                prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                                requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                KickApiHelper.getKickWebHeaders(requireContext(), true),
                                KickApiHelper.getKickPublicApiHeaders(requireContext()),
                            )
                        }
                        "refreshVideo" -> {
                            val videoId = requireArguments().getString(KEY_VIDEO_ID)
                            viewModel.loadVideo(
                                networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext(), prefs.getBoolean(AppConstants.TOKEN_INCLUDE_TOKEN_VIDEO, true)),
                                videoId = videoId,
                                videoSource = requireArguments().getString(KEY_VIDEO_SOURCE),
                                channelId = requireArguments().getString(KEY_CHANNEL_ID),
                                channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
                                playerType = prefs.getString(AppConstants.TOKEN_PLAYERTYPE_VIDEO, "channel_home_live"),
                                supportedCodecs = prefs.getString(AppConstants.TOKEN_SUPPORTED_CODECS, "av1,h265,h264"),
                                enableIntegrity = prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                            )
                            viewModel.isFollowingChannel(
                                requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                                requireArguments().getString(KEY_CHANNEL_ID),
                                requireArguments().getString(KEY_CHANNEL_LOGIN),
                                prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                                requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                KickApiHelper.getKickWebHeaders(requireContext(), true),
                                KickApiHelper.getKickPublicApiHeaders(requireContext()),
                            )
                            if (!videoId.isNullOrBlank() &&
                                !requireArguments().getString(KEY_VIDEO_SOURCE).equals(AppConstants.KICK, true) &&
                                (prefs.getBoolean(AppConstants.PLAYER_GAMESBUTTON, true) || prefs.getBoolean(AppConstants.PLAYER_MENU_GAMES, false))
                            ) {
                                viewModel.loadGamesList(
                                    videoId,
                                    prefs.getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                    KickApiHelper.getKickWebHeaders(requireContext()),
                                    prefs.getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                                )
                            }
                        }
                        "refreshClip" -> {
                            val clipUrl = requireArguments().getString(KEY_URL)
                            if (!clipUrl.isNullOrBlank()) {
                                viewModel.qualities = mapOf(
                                    "source" to Pair(getString(R.string.source), clipUrl),
                                    AUDIO_ONLY_QUALITY to Pair(getString(R.string.audio_only), null)
                                )
                                setDefaultQuality()
                                changePlayerMode()
                                startClip(clipUrl)
                            }
                            viewModel.loadClip(
                                networkLibrary = requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                kickWebHeaders = KickApiHelper.getKickWebHeaders(requireContext()),
                                id = requireArguments().getString(KEY_CLIP_ID),
                                enableIntegrity = requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                            )
                            viewModel.isFollowingChannel(
                                requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                                requireArguments().getString(KEY_CHANNEL_ID),
                                requireArguments().getString(KEY_CHANNEL_LOGIN),
                                prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                                requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                                KickApiHelper.getKickWebHeaders(requireContext(), true),
                                KickApiHelper.getKickPublicApiHeaders(requireContext()),
                            )
                        }
                        "follow" -> viewModel.saveFollowChannel(
                            requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                            requireArguments().getString(KEY_CHANNEL_ID),
                            requireArguments().getString(KEY_CHANNEL_LOGIN),
                            requireArguments().getString(KEY_CHANNEL_NAME),
                            prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                            requireContext().prefs().getBoolean(AppConstants.LIVE_NOTIFICATIONS_ENABLED, false),
                            requireArguments().getString(KEY_STARTED_AT),
                            requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                            KickApiHelper.getKickWebHeaders(requireContext(), true),
                            requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                        )
                        "unfollow" -> viewModel.deleteFollowChannel(
                            requireContext().tokenPrefs().getString(AppConstants.USER_ID, null),
                            requireArguments().getString(KEY_CHANNEL_ID),
                            requireArguments().getString(KEY_CHANNEL_LOGIN),
                            prefs.getString(AppConstants.UI_FOLLOW_BUTTON, "0")?.toIntOrNull() ?: 0,
                            requireContext().prefs().getString(AppConstants.NETWORK_LIBRARY, "OkHttp"),
                            KickApiHelper.getKickWebHeaders(requireContext(), true),
                            requireContext().prefs().getBoolean(AppConstants.ENABLE_INTEGRITY, false),
                        )
                    }
                }
            }
        }
    }

    protected fun getStreamArguments(item: Stream): Bundle {
        return bundleOf(
            KEY_TYPE to STREAM,
            KEY_STREAM_ID to item.id,
            KEY_STREAM_SOURCE to item.source,
            KEY_TITLE to item.title,
            KEY_VIEWER_COUNT to (item.viewerCount ?: -1),
            KEY_STARTED_AT to item.startedAt,
            KEY_CHANNEL_ID to item.channelId,
            KEY_CHANNEL_LOGIN to item.channelLogin,
            KEY_CHANNEL_NAME to item.channelName,
            KEY_CHANNEL_LOGO to item.channelLogo,
            KEY_THUMBNAIL to item.thumbnail,
            KEY_GAME_ID to item.gameId,
            KEY_GAME_SLUG to item.gameSlug,
            KEY_GAME_NAME to item.gameName,
        )
    }

    protected fun getStreamArguments(item: Stream, resolvedUrl: String?, forceStandardLiveEngine: Boolean): Bundle {
        return getStreamArguments(item).apply {
            putString(KEY_RESOLVED_STREAM_URL, resolvedUrl)
            putBoolean(KEY_FORCE_STANDARD_LIVE_ENGINE, forceStandardLiveEngine)
        }
    }

    protected fun getCurrentStream() = Stream(
        id = requireArguments().getString(KEY_STREAM_ID),
        source = requireArguments().getString(KEY_STREAM_SOURCE),
        channelId = requireArguments().getString(KEY_CHANNEL_ID),
        channelLogin = requireArguments().getString(KEY_CHANNEL_LOGIN),
        channelName = requireArguments().getString(KEY_CHANNEL_NAME),
        gameId = requireArguments().getString(KEY_GAME_ID),
        gameSlug = requireArguments().getString(KEY_GAME_SLUG),
        gameName = requireArguments().getString(KEY_GAME_NAME),
        title = requireArguments().getString(KEY_TITLE),
        viewerCount = requireArguments().getInt(KEY_VIEWER_COUNT).takeIf { it != -1 },
        startedAt = requireArguments().getString(KEY_STARTED_AT),
        thumbnailUrl = requireArguments().getString(KEY_THUMBNAIL),
        profileImageUrl = requireArguments().getString(KEY_CHANNEL_LOGO),
    )

    protected fun getVideoArguments(item: Video, offset: Long?, ignoreSavedPosition: Boolean): Bundle {
        return bundleOf(
            KEY_TYPE to VIDEO,
            KEY_VIDEO_ID to item.id,
            KEY_VIDEO_SOURCE to item.source,
            KEY_TITLE to item.title,
            KEY_UPLOAD_DATE to item.uploadDate,
            KEY_DURATION to item.duration,
            KEY_OFFSET to (offset ?: -1L),
            KEY_IGNORE_SAVED_POSITION to ignoreSavedPosition,
            KEY_VIDEO_TYPE to item.type,
            KEY_VIDEO_ANIMATED_PREVIEW to item.animatedPreviewURL,
            KEY_URL to item.url,
            KEY_CHANNEL_ID to item.channelId,
            KEY_CHANNEL_LOGIN to item.channelLogin,
            KEY_CHANNEL_NAME to item.channelName,
            KEY_CHANNEL_LOGO to item.channelLogo,
            KEY_THUMBNAIL to item.thumbnail,
            KEY_GAME_ID to item.gameId,
            KEY_GAME_SLUG to item.gameSlug,
            KEY_GAME_NAME to item.gameName,
        )
    }

    protected fun getClipArguments(item: Clip): Bundle {
        return bundleOf(
            KEY_TYPE to CLIP,
            KEY_CLIP_ID to item.id,
            KEY_TITLE to item.title,
            KEY_UPLOAD_DATE to item.uploadDate,
            KEY_DURATION to item.duration,
            KEY_VIDEO_ID to item.videoId,
            KEY_VIDEO_ANIMATED_PREVIEW to item.videoAnimatedPreviewURL,
            KEY_VOD_OFFSET to (item.vodOffset ?: -1),
            KEY_CLIP_REPLAY_START_TIME to item.replayStartTime,
            KEY_CHANNEL_ID to item.channelId,
            KEY_CHANNEL_LOGIN to item.channelLogin,
            KEY_CHANNEL_NAME to item.channelName,
            KEY_PROFILE_IMAGE_URL to item.profileImageUrl,
            KEY_CHANNEL_LOGO to item.channelLogo,
            KEY_THUMBNAIL to item.thumbnail,
            KEY_URL to item.clipUrl,
            KEY_GAME_ID to item.gameId,
            KEY_GAME_SLUG to item.gameSlug,
            KEY_GAME_NAME to item.gameName,
        )
    }

    protected fun getOfflineVideoArguments(item: OfflineVideo): Bundle {
        return bundleOf(
            KEY_TYPE to OFFLINE_VIDEO,
            KEY_OFFLINE_VIDEO_ID to item.id,
            KEY_TITLE to item.name,
            KEY_URL to item.url,
            KEY_CHAT_URL to item.chatUrl,
            KEY_OFFLINE_CHAT_START_TIME to (item.sourceStartPosition?.div(1000L)?.toInt() ?: -1),
            KEY_CHANNEL_ID to item.channelId,
            KEY_CHANNEL_LOGIN to item.channelLogin,
            KEY_CHANNEL_NAME to item.channelName,
            KEY_CHANNEL_LOGO to item.channelLogo,
            KEY_GAME_ID to item.gameId,
            KEY_GAME_SLUG to item.gameSlug,
            KEY_GAME_NAME to item.gameName,
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        protected const val AUTO_QUALITY = "auto"
        protected const val AUDIO_ONLY_QUALITY = "audio_only"
        protected const val CHAT_ONLY_QUALITY = "chat_only"

        private const val REQUEST_CODE_QUALITY = 0
        private const val REQUEST_CODE_SPEED = 1
        private const val REQUEST_CODE_AUDIO_ONLY = 2
        private const val REQUEST_CODE_PLAY_PAUSE = 3
        private const val MIN_VIDEO_ZOOM_SCALE = 1f
        private const val MAX_VIDEO_ZOOM_SCALE = 8f
        private const val VIDEO_ZOOM_EPSILON = 0.01f
        private const val VIDEO_ZOOM_SCALE_DEADZONE_RATIO = 0.025f
        private const val VIDEO_ZOOM_RESET_TOLERANCE = 0.03f
        private const val VIDEO_ZOOM_FILL_ZONE_MAX_SCALE = 1.4f
        private const val VIDEO_ZOOM_TWO_FINGER_PAN_MULTIPLIER = 1.25f
        private const val VIDEO_ZOOM_FILL_HINT_ALPHA = 0.4f
        private const val VIDEO_ZOOM_INDICATOR_HIDE_DELAY_MS = 1500L
        internal const val STREAM = "stream"
        internal const val VIDEO = "video"
        internal const val CLIP = "clip"
        internal const val OFFLINE_VIDEO = "offlineVideo"

        protected const val KEY_TYPE = "type"
        protected const val KEY_STREAM_ID = "streamId"
        protected const val KEY_STREAM_SOURCE = "streamSource"
        protected const val KEY_RESOLVED_STREAM_URL = "resolvedStreamUrl"
        protected const val KEY_FORCE_STANDARD_LIVE_ENGINE = "forceStandardLiveEngine"
        protected const val KEY_VIDEO_ID = "videoId"
        protected const val KEY_VIDEO_SOURCE = "videoSource"
        protected const val KEY_CLIP_REPLAY_START_TIME = "clipReplayStartTime"
        protected const val KEY_CLIP_ID = "clipId"
        protected const val KEY_OFFLINE_VIDEO_ID = "offlineVideoId"
        protected const val KEY_TITLE = "title"
        protected const val KEY_VIEWER_COUNT = "viewerCount"
        protected const val KEY_STARTED_AT = "startedAt"
        protected const val KEY_UPLOAD_DATE = "uploadDate"
        protected const val KEY_DURATION = "duration"
        protected const val KEY_OFFSET = "offset"
        protected const val KEY_IGNORE_SAVED_POSITION = "ignoreSavedPosition"
        protected const val KEY_VIDEO_TYPE = "videoType"
        protected const val KEY_VIDEO_ANIMATED_PREVIEW = "videoAnimatedPreview"
        protected const val KEY_VOD_OFFSET = "vodOffset"
        protected const val KEY_URL = "url"
        protected const val KEY_CHAT_URL = "chatUrl"
        protected const val KEY_OFFLINE_CHAT_START_TIME = "offlineChatStartTime"
        protected const val KEY_CHANNEL_ID = "channelId"
        protected const val KEY_CHANNEL_LOGIN = "channelLogin"
        protected const val KEY_CHANNEL_NAME = "channelName"
        protected const val KEY_PROFILE_IMAGE_URL = "profileImageUrl"
        protected const val KEY_CHANNEL_LOGO = "channelLogo"
        protected const val KEY_THUMBNAIL = "thumbnail"
        protected const val KEY_GAME_ID = "gameId"
        protected const val KEY_GAME_SLUG = "gameSlug"
        protected const val KEY_GAME_NAME = "gameName"
    }

}
