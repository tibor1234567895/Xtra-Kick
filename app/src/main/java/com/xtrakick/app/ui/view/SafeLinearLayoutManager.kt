package com.xtrakick.app.ui.view

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.util.DiagnosticLogger
import java.lang.ref.WeakReference

/** Retries known RecyclerView consistency failures after a full adapter resynchronization. */
class SafeLinearLayoutManager : LinearLayoutManager {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private var attachedRecyclerView: WeakReference<RecyclerView>? = null
    private var lastLogMs = 0L

    /** Recovery attempts since the last successful layout or attach; visible for tests. */
    internal var recoveryAttempts = 0

    companion object {
        private const val TAG = "SafeLinearLayoutManager"
        private const val MAX_RECOVERY_ATTEMPTS = 3
        private const val LOG_RATE_LIMIT_MS = 5_000L
    }

    override fun onAttachedToWindow(view: RecyclerView?) {
        super.onAttachedToWindow(view)
        recoveryAttempts = 0
        attachedRecyclerView = if (view != null) WeakReference(view) else null
    }

    override fun onDetachedFromWindow(view: RecyclerView?, recycler: RecyclerView.Recycler?) {
        super.onDetachedFromWindow(view, recycler)
        attachedRecyclerView = null
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        try {
            super.onLayoutChildren(recycler, state)
            recoveryAttempts = 0
        } catch (e: Exception) {
            if (isConsistencyFailure(e) && recoveryAttempts < MAX_RECOVERY_ATTEMPTS) {
                logCatch("onLayoutChildren", e)
                attemptRecovery(stopFling = false)
            } else {
                throw e
            }
        }
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return try {
            super.scrollVerticallyBy(dy, recycler, state)
        } catch (e: Exception) {
            if (isConsistencyFailure(e) && recoveryAttempts < MAX_RECOVERY_ATTEMPTS) {
                logCatch("scrollVerticallyBy", e)
                attemptRecovery(stopFling = true)
                0
            } else {
                throw e
            }
        }
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return try {
            super.scrollHorizontallyBy(dx, recycler, state)
        } catch (e: Exception) {
            if (isConsistencyFailure(e) && recoveryAttempts < MAX_RECOVERY_ATTEMPTS) {
                logCatch("scrollHorizontallyBy", e)
                attemptRecovery(stopFling = true)
                0
            } else {
                throw e
            }
        }
    }

    private fun isConsistencyFailure(error: Exception): Boolean {
        if (error !is IndexOutOfBoundsException && error !is IllegalStateException) return false
        val message = error.message.orEmpty()
        return message.contains("Inconsistency", ignoreCase = true) ||
            message.startsWith("Layout state should be one of") ||
            message.startsWith("Invalid item position")
    }

    private fun attemptRecovery(stopFling: Boolean) {
        val rv = attachedRecyclerView?.get() ?: return
        if (stopFling) rv.stopScroll()
        recoveryAttempts++
        rv.recycledViewPool.clear()
        rv.post {
            rv.adapter?.notifyDataSetChanged()
            rv.requestLayout()
        }
    }

    private fun logCatch(source: String, error: Throwable) {
        val now = SystemClock.uptimeMillis()
        if (now - lastLogMs >= LOG_RATE_LIMIT_MS) {
            lastLogMs = now
            DiagnosticLogger.w(TAG, "Intercepted race condition in $source: ${error.message}", error)
        }
    }
}
