package com.xtrakick.app.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.text.format.Formatter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogAppUpdateBinding
import com.xtrakick.app.databinding.DialogUpdateDownloadBinding
import com.xtrakick.app.model.AppUpdateInfo
import kotlin.math.roundToInt

data class UpdateDownloadProgress(val bytesRead: Long, val totalBytes: Long?)

/**
 * Vertical LinearLayout that measures all pinned children (header, section title, action buttons)
 * at their natural height first, then bounds the flexible changelog container to the remaining
 * vertical budget (up to [maxChangelogHeightPx]). Guarantees action buttons stay visible regardless
 * of orientation, 3-button nav insets, multi-line titles, or accessibility font scaling.
 */
class UpdateDialogContentLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    var maxDialogHeightPx: Int = Int.MAX_VALUE
        set(value) {
            if (field != value) {
                field = value
                requestLayout()
            }
        }

    var maxChangelogHeightPx: Int = Int.MAX_VALUE
        set(value) {
            if (field != value) {
                field = value
                requestLayout()
            }
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val specHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        val specHeightSize = MeasureSpec.getSize(heightMeasureSpec)
        val boundedHeight = when {
            specHeightMode == MeasureSpec.UNSPECIFIED -> maxDialogHeightPx
            maxDialogHeightPx == Int.MAX_VALUE -> specHeightSize
            else -> minOf(specHeightSize, maxDialogHeightPx)
        }

        val unspecifiedHeight = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        var changelogChild: View? = null
        var maxChildWidth = 0
        var pinnedHeight = paddingTop + paddingBottom

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            when {
                child.visibility == GONE -> Unit
                child.id == R.id.changelogCard -> changelogChild = child
                else -> {
                    measureChildWithMargins(child, widthMeasureSpec, 0, unspecifiedHeight, 0)
                    val lp = child.layoutParams as MarginLayoutParams
                    maxChildWidth = maxOf(maxChildWidth, child.measuredWidth + lp.leftMargin + lp.rightMargin)
                    pinnedHeight += child.measuredHeight + lp.topMargin + lp.bottomMargin
                }
            }
        }

        val resolvedWidth = resolveSize(maxChildWidth + paddingLeft + paddingRight, widthMeasureSpec)
        val exactWidthSpec = MeasureSpec.makeMeasureSpec(resolvedWidth, MeasureSpec.EXACTLY)

        if (specWidthMode != MeasureSpec.EXACTLY) {
            pinnedHeight = paddingTop + paddingBottom
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                if (child.visibility == GONE || child === changelogChild) continue
                val lp = child.layoutParams as MarginLayoutParams
                if (lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
                    measureChildWithMargins(child, exactWidthSpec, 0, unspecifiedHeight, 0)
                }
                pinnedHeight += child.measuredHeight + lp.topMargin + lp.bottomMargin
            }
        }

        var totalHeight = pinnedHeight
        changelogChild?.let { card ->
            val lp = card.layoutParams as MarginLayoutParams
            val remaining = if (boundedHeight == Int.MAX_VALUE) {
                maxChangelogHeightPx
            } else {
                (boundedHeight - pinnedHeight - lp.topMargin - lp.bottomMargin).coerceAtLeast(0)
            }
            val changelogCap = minOf(maxChangelogHeightPx, remaining)
            val cardHeightSpec = MeasureSpec.makeMeasureSpec(changelogCap, MeasureSpec.AT_MOST)
            measureChildWithMargins(card, exactWidthSpec, 0, cardHeightSpec, 0)
            totalHeight += card.measuredHeight + lp.topMargin + lp.bottomMargin
        }

        setMeasuredDimension(resolvedWidth, resolveSize(totalHeight, heightMeasureSpec))
    }
}

object AppUpdateDialogHelper {

    private const val CHANGELOG_MAX_HEIGHT_DP = 160
    private const val DIALOG_MAX_WIDTH_DP = 440
    private const val DIALOG_MIN_WIDTH_DP = 280
    private const val DIALOG_HORIZONTAL_MARGIN_DP = 32
    private const val DIALOG_VERTICAL_MARGIN_DP = 24
    private const val FALLBACK_STATUS_BAR_DP = 24
    private const val PORTRAIT_HORIZONTAL_PADDING_DP = 24
    private const val PORTRAIT_VERTICAL_PADDING_DP = 22
    private const val PORTRAIT_SECTION_MARGIN_DP = 16
    private const val PORTRAIT_ITEM_MARGIN_DP = 8
    private const val LANDSCAPE_HORIZONTAL_PADDING_DP = 20
    private const val LANDSCAPE_VERTICAL_PADDING_DP = 14
    private const val LANDSCAPE_WHATS_NEW_MARGIN_DP = 8
    private const val LANDSCAPE_BUTTONS_MARGIN_DP = 10
    private const val LANDSCAPE_ITEM_MARGIN_DP = 6

    private val GIT_SHA_PREFIX = Regex("^[0-9a-fA-F]{7,10}\\s+")
    private val MARKDOWN_HEADER = Regex("^#+\\s*")
    private val LIST_PREFIX = Regex("^[\\*\\-\\•]\\s*")

    internal data class ResponsiveDialogMetrics(
        val horizontalPaddingPx: Int,
        val verticalPaddingPx: Int,
        val whatsNewTopMarginPx: Int,
        val changelogTopMarginPx: Int,
        val buttonsTopMarginPx: Int,
        val secondaryRowTopMarginPx: Int,
        val maxDialogHeightPx: Int,
        val changelogMaxHeightPx: Int,
        val windowWidthPx: Int,
    )

    internal fun computeResponsiveMetrics(
        density: Float,
        usableWidthPx: Int,
        usableHeightPx: Int,
    ): ResponsiveDialogMetrics {
        fun dp(value: Int): Int = (value * density).roundToInt()

        val isLandscape = usableWidthPx > usableHeightPx
        val maxDialogHeightPx = (usableHeightPx - dp(DIALOG_VERTICAL_MARGIN_DP)).coerceAtLeast(1)
        val availableWidth = (usableWidthPx - dp(DIALOG_HORIZONTAL_MARGIN_DP)).coerceAtLeast(0)
        val windowWidthPx = if (availableWidth > 0) {
            minOf(dp(DIALOG_MAX_WIDTH_DP), maxOf(minOf(dp(DIALOG_MIN_WIDTH_DP), usableWidthPx), availableWidth))
        } else {
            WindowManager.LayoutParams.WRAP_CONTENT
        }

        return ResponsiveDialogMetrics(
            horizontalPaddingPx = dp(if (isLandscape) LANDSCAPE_HORIZONTAL_PADDING_DP else PORTRAIT_HORIZONTAL_PADDING_DP),
            verticalPaddingPx = dp(if (isLandscape) LANDSCAPE_VERTICAL_PADDING_DP else PORTRAIT_VERTICAL_PADDING_DP),
            whatsNewTopMarginPx = dp(if (isLandscape) LANDSCAPE_WHATS_NEW_MARGIN_DP else PORTRAIT_SECTION_MARGIN_DP),
            changelogTopMarginPx = dp(if (isLandscape) LANDSCAPE_ITEM_MARGIN_DP else PORTRAIT_ITEM_MARGIN_DP),
            buttonsTopMarginPx = dp(if (isLandscape) LANDSCAPE_BUTTONS_MARGIN_DP else PORTRAIT_SECTION_MARGIN_DP),
            secondaryRowTopMarginPx = dp(if (isLandscape) LANDSCAPE_ITEM_MARGIN_DP else PORTRAIT_ITEM_MARGIN_DP),
            maxDialogHeightPx = maxDialogHeightPx,
            changelogMaxHeightPx = dp(CHANGELOG_MAX_HEIGHT_DP),
            windowWidthPx = windowWidthPx,
        )
    }

    private tailrec fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }

    private fun usableHostWindowSizePx(context: Context): Pair<Int, Int> {
        val activity = context.findActivity()
        if (activity != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val metrics = activity.windowManager.currentWindowMetrics
            val insets = metrics.windowInsets.getInsetsIgnoringVisibility(
                WindowInsets.Type.systemBars() or WindowInsets.Type.displayCutout()
            )
            val bounds = metrics.bounds
            val usableWidth = (bounds.width() - insets.left - insets.right).coerceAtLeast(0)
            val usableHeight = (bounds.height() - insets.top - insets.bottom).coerceAtLeast(0)
            if (usableWidth > 0 && usableHeight > 0) {
                return usableWidth to usableHeight
            }
        }
        val hostDecor = activity?.window?.decorView
        if (hostDecor != null && hostDecor.width > 0 && hostDecor.height > 0) {
            val rootInsets = ViewCompat.getRootWindowInsets(hostDecor)
            val bars = rootInsets?.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            val left = bars?.left ?: 0
            val right = bars?.right ?: 0
            val top = bars?.top ?: 0
            val bottom = bars?.bottom ?: 0
            val usableWidth = (hostDecor.width - left - right).coerceAtLeast(0)
            val usableHeight = (hostDecor.height - top - bottom).coerceAtLeast(0)
            if (usableWidth > 0 && usableHeight > 0) {
                return usableWidth to usableHeight
            }
        }
        val dm = context.resources.displayMetrics
        val statusBarFallback = (FALLBACK_STATUS_BAR_DP * dm.density).roundToInt()
        return dm.widthPixels to (dm.heightPixels - statusBarFallback).coerceAtLeast(0)
    }

    private fun applyResponsiveLayout(
        binding: DialogAppUpdateBinding,
        metrics: ResponsiveDialogMetrics,
    ) {
        binding.dialogContentLayout.setPaddingRelative(
            metrics.horizontalPaddingPx,
            metrics.verticalPaddingPx,
            metrics.horizontalPaddingPx,
            metrics.verticalPaddingPx,
        )
        binding.whatsNewHeader.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = metrics.whatsNewTopMarginPx
        }
        binding.changelogCard.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = metrics.changelogTopMarginPx
        }
        binding.buttonsLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = metrics.buttonsTopMarginPx
        }
        binding.secondaryButtonsRow.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = metrics.secondaryRowTopMarginPx
        }
        binding.dialogContentLayout.maxDialogHeightPx = metrics.maxDialogHeightPx
        binding.dialogContentLayout.maxChangelogHeightPx = metrics.changelogMaxHeightPx
    }

    private fun clearDialogPanelBackgrounds(dialog: AlertDialog) {
        // Theme overlays (@style/Dialog on AMOLED, @style/MaterialDialog on AppCompat) paint
        // opaque rectangular backgrounds on AlertDialog's internal panels behind the rounded card.
        dialog.findViewById<View>(androidx.appcompat.R.id.parentPanel)?.background = null
        dialog.findViewById<View>(androidx.appcompat.R.id.customPanel)?.background = null
        dialog.findViewById<View>(android.R.id.custom)?.background = null
    }

    fun formatChangelog(rawNotes: String?, defaultDescription: String): String {
        if (rawNotes.isNullOrBlank()) return defaultDescription

        val lines = rawNotes.lines()
            .map { it.trim() }
            .map { line ->
                var cleaned = line
                cleaned = GIT_SHA_PREFIX.replace(cleaned, "")
                cleaned = MARKDOWN_HEADER.replace(cleaned, "")
                cleaned = LIST_PREFIX.replace(cleaned, "")
                cleaned.trim()
            }
            .filter { line ->
                line.isNotBlank() &&
                    !line.startsWith("Merge branch ", ignoreCase = true) &&
                    !line.startsWith("Merge pull request ", ignoreCase = true) &&
                    !line.contains("into integrate-dependabot", ignoreCase = true) &&
                    !line.contains("Active Changelog:", ignoreCase = true) &&
                    !line.startsWith("Release build ", ignoreCase = true) &&
                    !line.matches(Regex("^[\\s\\-_=*]+$"))
            }

        if (lines.isEmpty()) return defaultDescription

        return lines.joinToString("\n") { "• $it" }
    }

    fun showUpdateDialog(
        context: Context,
        updateInfo: AppUpdateInfo,
        onUpdate: () -> Unit,
        onRemindLater: () -> Unit,
        onSkip: () -> Unit,
        onDismiss: (AlertDialog) -> Unit = {},
    ): AlertDialog {
        val binding = DialogAppUpdateBinding.inflate(LayoutInflater.from(context))

        val title = updateInfo.releaseTitle?.takeIf { it.isNotBlank() }
            ?: context.getString(R.string.update_available)
        binding.updateTitle.text = title

        val sizeText = updateInfo.size?.takeIf { it > 0 }?.let {
            Formatter.formatShortFileSize(context, it)
        }
        binding.updateSubtitle.text = if (sizeText != null) {
            context.getString(R.string.update_available) + " • " + sizeText
        } else {
            context.getString(R.string.update_available)
        }

        val defaultDesc = context.getString(R.string.update_dialog_default_description)
        binding.changelogText.text = formatChangelog(updateInfo.releaseNotes, defaultDesc)

        val dialog = context.getAlertDialogBuilder()
            .setView(binding.root)
            .setCancelable(true)
            .create()

        var lastMetrics: ResponsiveDialogMetrics? = null
        var lastWindowWidthPx: Int? = null

        fun syncResponsiveMetrics(applyWindowSize: Boolean) {
            val (usableWidthPx, usableHeightPx) = usableHostWindowSizePx(context)
            val metrics = computeResponsiveMetrics(
                density = context.resources.displayMetrics.density,
                usableWidthPx = usableWidthPx,
                usableHeightPx = usableHeightPx,
            )
            if (metrics != lastMetrics) {
                lastMetrics = metrics
                applyResponsiveLayout(binding, metrics)
            }
            if (applyWindowSize && metrics.windowWidthPx != lastWindowWidthPx && dialog.isShowing) {
                lastWindowWidthPx = metrics.windowWidthPx
                dialog.window?.setLayout(
                    metrics.windowWidthPx,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                )
            }
        }

        binding.closeButton.setOnClickListener {
            onRemindLater()
            dialog.dismiss()
        }

        binding.updateButton.setOnClickListener {
            dialog.dismiss()
            onUpdate()
        }

        binding.remindLaterButton.setOnClickListener {
            onRemindLater()
            dialog.dismiss()
        }

        binding.skipButton.setOnClickListener {
            onSkip()
            dialog.dismiss()
        }

        syncResponsiveMetrics(applyWindowSize = false)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        clearDialogPanelBackgrounds(dialog)
        syncResponsiveMetrics(applyWindowSize = true)

        // Observe the host Activity's decorView (not the floating dialog's) so live rotation
        // and split-screen resizes always re-measure even when portrait width >= 440dp.
        val hostDecor = context.findActivity()?.window?.decorView
        val hostLayoutListener = View.OnLayoutChangeListener { _, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            if (right - left != oldRight - oldLeft || bottom - top != oldBottom - oldTop) {
                binding.root.post {
                    if (dialog.isShowing) {
                        syncResponsiveMetrics(applyWindowSize = true)
                    }
                }
            }
        }
        hostDecor?.addOnLayoutChangeListener(hostLayoutListener)
        dialog.setOnDismissListener {
            hostDecor?.removeOnLayoutChangeListener(hostLayoutListener)
            onDismiss(dialog)
        }

        return dialog
    }

    class UpdateDownloadDialog internal constructor(
        private val context: Context,
        private val binding: DialogUpdateDownloadBinding,
        private val dialog: AlertDialog,
        private val formattedTotal: String?,
    ) {
        private var lastPercent = -1
        private var lastFormattedRead: String? = null

        fun update(progress: UpdateDownloadProgress) {
            val total = progress.totalBytes
            if (formattedTotal == null || total == null || total <= 0L) return

            val formattedRead = Formatter.formatFileSize(context, progress.bytesRead)
            if (formattedRead != lastFormattedRead) {
                lastFormattedRead = formattedRead
                binding.textView.text = context.getString(
                    R.string.downloading_update_progress,
                    formattedRead,
                    formattedTotal,
                )
            }
            val percent = ((progress.bytesRead * 100L) / total).toInt().coerceIn(0, 100)
            if (percent != lastPercent) {
                lastPercent = percent
                binding.progressBar.setProgressCompat(percent, true)
            }
        }

        fun dismiss() {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
    }

    fun showDownloadDialog(
        context: Context,
        initial: UpdateDownloadProgress,
        onCancel: () -> Unit,
    ): UpdateDownloadDialog {
        val binding = DialogUpdateDownloadBinding.inflate(LayoutInflater.from(context))
        val formattedTotal = initial.totalBytes?.takeIf { it > 0L }?.let {
            Formatter.formatFileSize(context, it)
        }
        // Must configure indeterminate mode BEFORE the LinearProgressIndicator becomes visible.
        binding.progressBar.isIndeterminate = formattedTotal == null
        if (formattedTotal != null) {
            binding.progressBar.max = 100
        } else {
            binding.textView.text = context.getString(R.string.downloading_update)
        }

        val dialog = context.getAlertDialogBuilder()
            .setView(binding.root)
            .setNegativeButton(context.getString(android.R.string.cancel)) { _, _ ->
                onCancel()
            }
            .setOnCancelListener {
                onCancel()
            }
            .create()

        val handle = UpdateDownloadDialog(context, binding, dialog, formattedTotal)
        handle.update(initial)
        dialog.show()
        return handle
    }
}
