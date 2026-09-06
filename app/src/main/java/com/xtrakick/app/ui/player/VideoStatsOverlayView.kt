package com.xtrakick.app.ui.player

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.isVisible
import com.xtrakick.app.R
import com.xtrakick.app.databinding.ViewVideoStatsOverlayBinding
import com.xtrakick.app.model.ui.VideoStatsInfo

class VideoStatsOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewVideoStatsOverlayBinding.inflate(LayoutInflater.from(context), this, true)
    private var currentStats: VideoStatsInfo? = null

    var onCloseRequested: (() -> Unit)? = null

    private var dX = 0f
    private var dY = 0f
    private var isDragging = false

    private var isCompact = false
    private var isTransparent = false

    init {
        setupDragHandle()
        setupButtons()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupDragHandle() {
        val dragTouchListener = OnTouchListener { _, event ->
            val parentView = parent as? android.view.ViewGroup ?: return@OnTouchListener false
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    dX = x - event.rawX
                    dY = y - event.rawY
                    isDragging = true
                    parentView.requestDisallowInterceptTouchEvent(true)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    if (isDragging) {
                        val parentWidth = parentView.width.toFloat()
                        val parentHeight = parentView.height.toFloat()
                        val viewWidth = width.toFloat()

                        // Allow the card to cross outside the player edges so the user can push it
                        // mostly offscreen to hide it temporarily. Keep at least 48dp visible on screen
                        // so the user can easily grab it and pull it back.
                        val minVisibleMargin = 48f * resources.displayMetrics.density
                        val minX = -(viewWidth - minVisibleMargin)
                        val maxX = parentWidth - minVisibleMargin
                        val minY = 0f
                        val maxY = (parentHeight - minVisibleMargin).coerceAtLeast(0f)

                        val targetX = (event.rawX + dX).coerceIn(minX, maxX)
                        val targetY = (event.rawY + dY).coerceIn(minY, maxY)

                        animate()
                            .x(targetX)
                            .y(targetY)
                            .setDuration(0)
                            .start()
                    }
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    isDragging = false
                    parentView.requestDisallowInterceptTouchEvent(false)
                    true
                }
                else -> false
            }
        }

        binding.headerLayout.setOnTouchListener(dragTouchListener)
        binding.minimalInlineLayout.setOnTouchListener(dragTouchListener)
    }

    private fun setupButtons() {
        binding.opacityButton.setOnClickListener {
            toggleTransparency()
        }

        binding.compactButton.setOnClickListener {
            toggleCompact()
        }

        binding.minimalExpandButton.setOnClickListener {
            toggleCompact()
        }

        binding.copyButton.setOnClickListener {
            val stats = currentStats ?: return@setOnClickListener
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
            val clip = ClipData.newPlainText("Xtra Video Stats", stats.toClipboardText())
            clipboard?.setPrimaryClip(clip)
            Toast.makeText(context, R.string.video_stats_copied, Toast.LENGTH_SHORT).show()
        }

        binding.closeButton.setOnClickListener {
            onCloseRequested?.invoke()
        }

        binding.minimalCloseButton.setOnClickListener {
            onCloseRequested?.invoke()
        }
    }

    private fun toggleTransparency() {
        isTransparent = !isTransparent
        // Regular card background is #E6101216 (~90% opacity).
        // Transparent mode drops card alpha to 0.45f and header to softer tint.
        if (isTransparent) {
            binding.statsCard.alpha = 0.45f
            binding.opacityButton.alpha = 0.6f
        } else {
            binding.statsCard.alpha = 1.0f
            binding.opacityButton.alpha = 1.0f
        }
    }

    private fun toggleCompact() {
        isCompact = !isCompact
        binding.compactButton.setImageResource(if (isCompact) R.drawable.ic_expand_24 else R.drawable.ic_minimize_24)

        with(binding) {
            // When in compact / minimal mode:
            // Shrink card width to wrap_content so it's a tiny gaming HUD strip,
            // round corners tighter, reduce background to sheer dark scrim.
            // When expanding back to full stats, restore fixed 250dp width and 12dp corners.
            val density = resources.displayMetrics.density
            val cardParams = statsCard.layoutParams
            if (isCompact) {
                cardParams.width = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                statsCard.radius = 4f * density
                statsCard.setCardBackgroundColor(android.graphics.Color.parseColor("#99000000"))
                statsCard.strokeWidth = 0
            } else {
                cardParams.width = (250f * density).toInt()
                statsCard.radius = 12f * density
                statsCard.setCardBackgroundColor(android.graphics.Color.parseColor("#E6101216"))
                statsCard.strokeWidth = (1f * density).toInt()
            }
            statsCard.layoutParams = cardParams

            headerLayout.isVisible = !isCompact
            headerDivider.isVisible = !isCompact
            statsContentLayout.isVisible = !isCompact
            minimalInlineLayout.isVisible = isCompact
        }

        currentStats?.let { updateStats(it) }
    }

    fun updateStats(stats: VideoStatsInfo?) {
        currentStats = stats
        if (stats == null) return

        with(binding) {
            if (isCompact) {
                // In compact gaming HUD mode, only update the inline indicators
                val fpsRaw = stats.fps ?: ""
                val fpsClean = if (fpsRaw.contains(" ")) fpsRaw.substringBefore(" ") else fpsRaw
                val fpsText = if (fpsClean.isNotBlank()) "$fpsClean FPS" else ""
                val dropsText = stats.skippedFrames?.let { sf ->
                    val dropped = sf.substringBefore(" /").trim()
                    val droppedCount = dropped.toIntOrNull() ?: 0
                    if (droppedCount > 0) "(-$droppedCount)" else ""
                } ?: ""
                val bitrateText = stats.downloadBitrate ?: stats.bandwidthEstimate ?: ""

                val hasFps = fpsText.isNotBlank()
                val hasBitrate = bitrateText.isNotBlank()

                valMinimalFps.isVisible = hasFps
                if (valMinimalFps.text != fpsText) valMinimalFps.text = fpsText

                valMinimalDrops.isVisible = dropsText.isNotBlank()
                if (valMinimalDrops.text != dropsText) valMinimalDrops.text = dropsText

                valMinimalSeparator.isVisible = hasFps && hasBitrate
                valMinimalBitrate.isVisible = hasBitrate
                if (valMinimalBitrate.text != bitrateText) valMinimalBitrate.text = bitrateText
            } else {
                // Update full view rows
                updateRow(rowFps, valFps, stats.fps)
                updateRow(rowSkippedFrames, valSkippedFrames, stats.skippedFrames)
                updateRow(rowDownloadBitrate, valDownloadBitrate, stats.downloadBitrate)
                updateRow(rowBandwidthEstimate, valBandwidthEstimate, stats.bandwidthEstimate)
                updateRow(rowResolution, valResolution, stats.resolution)
                updateRow(rowViewportResolution, valViewportResolution, stats.viewportResolution)
                updateRow(rowBufferSize, valBufferSize, stats.bufferSize)
                updateRow(rowLatency, valLatency, stats.latencyToBroadcaster)
                updateRow(rowCodecs, valCodecs, stats.codecs)
                updateRow(rowProtocol, valProtocol, stats.protocol)
                updateRow(rowBackendVersion, valBackendVersion, stats.backendVersion)
            }
        }
    }

    private fun updateRow(row: View, textView: android.widget.TextView, value: String?) {
        if (!value.isNullOrBlank()) {
            row.isVisible = true
            if (textView.text != value) {
                textView.text = value
            }
        } else {
            row.isVisible = false
        }
    }
}
