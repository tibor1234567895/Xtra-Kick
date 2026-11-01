package com.xtrakick.app.ui.common

import android.app.Dialog
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.math.roundToInt

/**
 * Compact dialogs: centered alert menus and bottom sheets stretch across the
 * screen in landscape. These helpers cap their width instead.
 */
object CompactDialogs {
    const val ALERT_MAX_WIDTH_DP = 400
    const val SHEET_MAX_WIDTH_DP = 440

    /** Centered alert dialog: cap width in landscape, keep stock portrait sizing. */
    fun Dialog.compact(maxWidthDp: Int = ALERT_MAX_WIDTH_DP) {
        val metrics = context.resources.displayMetrics
        if (metrics.widthPixels <= metrics.heightPixels) return
        val maxPx = (maxWidthDp * metrics.density).roundToInt()
        window?.setLayout(maxPx, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    /**
     * Apply compact constraints to a bottom sheet.
     * Keeps layoutParams.width as MATCH_PARENT so portrait stays full-width,
     * while behavior.maxWidth caps width in landscape and centers the sheet.
     */
    fun applySheetConstraints(
        dialog: Dialog?,
        resources: android.content.res.Resources,
        maxWidthDp: Int = SHEET_MAX_WIDTH_DP,
    ): View? {
        val sheet = dialog?.findViewById<View>(
            com.google.android.material.R.id.design_bottom_sheet
        ) ?: return null
        val behavior = BottomSheetBehavior.from(sheet)
        val maxPx = (maxWidthDp * resources.displayMetrics.density).roundToInt()
        behavior.maxWidth = maxPx
        (sheet.layoutParams as? CoordinatorLayout.LayoutParams)?.let { params ->
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.gravity = Gravity.CENTER_HORIZONTAL
            sheet.layoutParams = params
        }
        return sheet
    }

    /**
     * Constrain every BottomSheetDialogFragment under this manager to a centered
     * panel in landscape. Portrait sheets keep full-width bottom behavior.
     * Recursive, so child-fragment sheets (player, chat) are covered.
     */
    fun FragmentManager.constrainSheets(maxWidthDp: Int = SHEET_MAX_WIDTH_DP) {
        registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewCreated(
                    fm: FragmentManager,
                    f: androidx.fragment.app.Fragment,
                    v: View,
                    savedInstanceState: android.os.Bundle?,
                ) {
                    if (f !is BottomSheetDialogFragment) return
                    v.post {
                        if (!f.isAdded) return@post
                        applySheetConstraints(f.dialog, f.resources, maxWidthDp)
                        f.dialog?.window?.decorView?.addOnLayoutChangeListener { _, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
                            if (!f.isAdded) return@addOnLayoutChangeListener
                            if (right - left != oldRight - oldLeft || bottom - top != oldBottom - oldTop) {
                                val sheet = applySheetConstraints(f.dialog, f.resources, maxWidthDp) ?: return@addOnLayoutChangeListener
                                val behavior = BottomSheetBehavior.from(sheet)
                                sheet.post {
                                    if (f.isAdded) {
                                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                                    }
                                }
                            }
                        }
                    }
                }
            },
            true,
        )
    }
}
