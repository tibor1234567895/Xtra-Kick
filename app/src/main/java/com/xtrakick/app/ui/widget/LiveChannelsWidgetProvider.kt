package com.xtrakick.app.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.RemoteViews
import androidx.annotation.StringRes
import com.xtrakick.app.R
import com.xtrakick.app.ui.main.MainActivity
import java.util.concurrent.ConcurrentHashMap

class LiveChannelsWidgetProvider : AppWidgetProvider() {

    /** Non-exported receiver for the widget's refresh PendingIntent so third-party apps cannot forge refreshes. */
    class RefreshReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == ACTION_REFRESH) {
                val appContext = context.applicationContext
                performHapticFeedback(appContext)
                showRefreshingFeedback(appContext, goAsync())
                notifyDataChanged(appContext, forceRefresh = true)
            }
        }

        private fun performHapticFeedback(context: Context) {
            try {
                val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                    vibratorManager?.defaultVibrator
                } else {
                    @Suppress("DEPRECATION")
                    context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    vibrator?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(25L)
                }
            } catch (_: Exception) {
                // If vibrator is unavailable or denied, fail silently
            }
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        clearPendingFeedback(appWidgetIds)
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
    ) {
        val views = RemoteViews(context.packageName, R.layout.widget_live_channels)

        val serviceIntent = Intent(context, LiveChannelsWidgetService::class.java).apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            data = Uri.parse(toUri(Intent.URI_INTENT_SCHEME))
        }
        // The AdapterViewFactory replacement exists only from Android 12; with minSdk 26
        // these deprecated calls are the supported path for collection widgets.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            @Suppress("DEPRECATION")
            views.setRemoteAdapter(appWidgetId, R.id.widgetListView, serviceIntent)
        } else {
            @Suppress("DEPRECATION")
            views.setRemoteAdapter(R.id.widgetListView, serviceIntent)
        }
        views.setEmptyView(R.id.widgetListView, R.id.widgetEmptyView)

        val clickIntent = Intent(context, MainActivity::class.java).apply {
            action = MainActivity.INTENT_LIVE_NOTIFICATION
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val clickPendingIntent = PendingIntent.getActivity(
            context,
            0,
            clickIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE,
        )
        views.setPendingIntentTemplate(R.id.widgetListView, clickPendingIntent)

        val openAppIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val openAppPendingIntent = PendingIntent.getActivity(
            context,
            1,
            openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        views.setOnClickPendingIntent(R.id.widgetHeader, openAppPendingIntent)
        views.setOnClickPendingIntent(R.id.widgetEmptyView, openAppPendingIntent)

        val refreshIntent = Intent(context, RefreshReceiver::class.java).apply {
            action = ACTION_REFRESH
        }
        val refreshPendingIntent = PendingIntent.getBroadcast(
            context,
            2,
            refreshIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        views.setOnClickPendingIntent(R.id.widgetBtnRefresh, refreshPendingIntent)
        views.setTextViewText(R.id.widgetTitle, context.getString(R.string.live_widget_title))
        views.setInt(R.id.widgetBtnRefresh, "setImageAlpha", NORMAL_ICON_ALPHA)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    companion object {
        const val ACTION_REFRESH = "com.xtrakick.app.ACTION_REFRESH_WIDGET"
        private const val REFRESHING_TIMEOUT_MS = 16_000L
        private const val REFRESHED_FEEDBACK_DURATION_MS = 1_200L
        private const val BROADCAST_HOLD_CAP_MS = 8_500L
        private const val REFRESHING_ICON_ALPHA = 100
        private const val NORMAL_ICON_ALPHA = 255

        private val pendingRefreshWidgetIds = ConcurrentHashMap.newKeySet<Int>()
        private val mainHandler by lazy { Handler(Looper.getMainLooper()) }
        private val feedbackLock = Any()
        private val resetRunnables = HashMap<Int, Runnable>()
        private var finishBroadcastRunnable: Runnable? = null
        private var pendingRefreshResult: BroadcastReceiver.PendingResult? = null

        internal fun consumeRefreshRequest(
            appWidgetId: Int = AppWidgetManager.INVALID_APPWIDGET_ID,
        ): Boolean {
            return if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                val hadPending = pendingRefreshWidgetIds.isNotEmpty()
                pendingRefreshWidgetIds.clear()
                hadPending
            } else {
                pendingRefreshWidgetIds.remove(appWidgetId)
            }
        }

        fun showRefreshingFeedback(
            context: Context,
            pendingResult: BroadcastReceiver.PendingResult? = null,
        ) {
            val appContext = context.applicationContext
            val targetIds = resolveWidgetIds(appContext, AppWidgetManager.INVALID_APPWIDGET_ID)
            if (targetIds.isEmpty()) {
                runCatching { pendingResult?.finish() }
                return
            }
            synchronized(feedbackLock) {
                finishPendingBroadcastLocked()
                pendingRefreshResult = pendingResult
                if (pendingResult != null) {
                    val cap = Runnable {
                        synchronized(feedbackLock) {
                            finishPendingBroadcastLocked()
                        }
                    }
                    finishBroadcastRunnable = cap
                    mainHandler.postDelayed(cap, BROADCAST_HOLD_CAP_MS)
                }
                for (id in targetIds) {
                    scheduleResetLocked(appContext, id, REFRESHING_TIMEOUT_MS)
                }
            }
            updateHeaderViews(appContext, R.string.live_widget_refreshing, REFRESHING_ICON_ALPHA, targetIds)
        }

        fun showRefreshedFeedback(
            context: Context,
            appWidgetId: Int = AppWidgetManager.INVALID_APPWIDGET_ID,
        ) {
            val appContext = context.applicationContext
            val targetIds = resolveWidgetIds(appContext, appWidgetId)
            if (targetIds.isEmpty()) return
            synchronized(feedbackLock) {
                for (id in targetIds) {
                    scheduleResetLocked(appContext, id, REFRESHED_FEEDBACK_DURATION_MS)
                }
            }
            updateHeaderViews(appContext, R.string.live_widget_updated_just_now, NORMAL_ICON_ALPHA, targetIds)
        }

        fun resetWidgetHeader(
            context: Context,
            appWidgetId: Int = AppWidgetManager.INVALID_APPWIDGET_ID,
        ) {
            val appContext = context.applicationContext
            val targetIds = resolveWidgetIds(appContext, appWidgetId)
            clearPendingFeedback(targetIds)
            if (targetIds.isNotEmpty()) {
                updateHeaderViews(appContext, R.string.live_widget_title, NORMAL_ICON_ALPHA, targetIds)
            }
        }

        /** Ensures a widget never stays stuck on temporary status text if its factory unbinds early. */
        fun flushPendingHeaderReset(
            context: Context,
            appWidgetId: Int = AppWidgetManager.INVALID_APPWIDGET_ID,
        ) {
            val needsReset = synchronized(feedbackLock) {
                if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                    resetRunnables.isNotEmpty()
                } else {
                    appWidgetId in resetRunnables
                }
            }
            if (needsReset) {
                resetWidgetHeader(context, appWidgetId)
            }
        }

        private fun scheduleResetLocked(appContext: Context, appWidgetId: Int, delayMs: Long) {
            resetRunnables.remove(appWidgetId)?.let { mainHandler.removeCallbacks(it) }
            val revert = Runnable { resetWidgetHeader(appContext, appWidgetId) }
            resetRunnables[appWidgetId] = revert
            mainHandler.postDelayed(revert, delayMs)
        }

        private fun clearPendingFeedback(appWidgetIds: IntArray) {
            synchronized(feedbackLock) {
                for (id in appWidgetIds) {
                    resetRunnables.remove(id)?.let { mainHandler.removeCallbacks(it) }
                }
                if (resetRunnables.isEmpty()) {
                    finishPendingBroadcastLocked()
                }
            }
        }

        private fun finishPendingBroadcastLocked() {
            finishBroadcastRunnable?.let { mainHandler.removeCallbacks(it) }
            finishBroadcastRunnable = null
            runCatching { pendingRefreshResult?.finish() }
            pendingRefreshResult = null
        }

        private fun resolveWidgetIds(context: Context, appWidgetId: Int): IntArray {
            if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                return intArrayOf(appWidgetId)
            }
            val appWidgetManager = AppWidgetManager.getInstance(context) ?: return IntArray(0)
            val componentName = ComponentName(context, LiveChannelsWidgetProvider::class.java)
            return appWidgetManager.getAppWidgetIds(componentName) ?: IntArray(0)
        }

        private fun updateHeaderViews(
            context: Context,
            @StringRes titleRes: Int,
            alpha: Int,
            appWidgetIds: IntArray,
        ) {
            val appWidgetManager = AppWidgetManager.getInstance(context) ?: return
            if (appWidgetIds.isEmpty()) return

            val views = RemoteViews(context.packageName, R.layout.widget_live_channels).apply {
                setTextViewText(R.id.widgetTitle, context.getString(titleRes))
                setInt(R.id.widgetBtnRefresh, "setImageAlpha", alpha)
            }
            for (appWidgetId in appWidgetIds) {
                appWidgetManager.partiallyUpdateAppWidget(appWidgetId, views)
            }
        }

        fun notifyDataChanged(context: Context, forceRefresh: Boolean = false) {
            val appWidgetManager = AppWidgetManager.getInstance(context) ?: return
            val appWidgetIds = resolveWidgetIds(context, AppWidgetManager.INVALID_APPWIDGET_ID)
            if (appWidgetIds.isNotEmpty()) {
                if (forceRefresh) {
                    appWidgetIds.forEach(pendingRefreshWidgetIds::add)
                }
                // Both overloads are deprecated with no replacement; this is the
                // supported way to refresh a collection widget's data.
                @Suppress("DEPRECATION")
                appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widgetListView)
            }
        }
    }
}
