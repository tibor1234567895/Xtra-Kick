package com.xtrakick.app.ui.common

import android.app.Dialog
import android.content.res.Configuration
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentManager
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
                        val res = f.resources
                        if (res.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) return@post
                        val maxPx = (maxWidthDp * res.displayMetrics.density).roundToInt()
                        if (res.displayMetrics.widthPixels <= maxPx) return@post
                        val sheet = f.dialog?.findViewById<View>(
                            com.google.android.material.R.id.design_bottom_sheet
                        ) ?: return@post
                        (sheet.layoutParams as? CoordinatorLayout.LayoutParams)?.let { params ->
                            params.width = maxPx
                            params.gravity = Gravity.CENTER_HORIZONTAL
                            sheet.layoutParams = params
                        }
                    }
                }
            },
            true,
        )
    }
}
