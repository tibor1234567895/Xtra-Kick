package com.xtrakick.app.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import com.xtrakick.app.R
import com.xtrakick.app.ui.main.MainActivity
import java.util.concurrent.atomic.AtomicBoolean

class LiveChannelsWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_REFRESH) {
            notifyDataChanged(context, forceRefresh = true)
        }
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

        val refreshIntent = Intent(context, LiveChannelsWidgetProvider::class.java).apply {
            action = ACTION_REFRESH
        }
        val refreshPendingIntent = PendingIntent.getBroadcast(
            context,
            2,
            refreshIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        views.setOnClickPendingIntent(R.id.widgetBtnRefresh, refreshPendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    companion object {
        const val ACTION_REFRESH = "com.xtrakick.app.ACTION_REFRESH_WIDGET"
        private val refreshRequested = AtomicBoolean()

        internal fun consumeRefreshRequest(): Boolean = refreshRequested.getAndSet(false)

        fun notifyDataChanged(context: Context, forceRefresh: Boolean = false) {
            val appWidgetManager = AppWidgetManager.getInstance(context) ?: return
            val componentName = ComponentName(context, LiveChannelsWidgetProvider::class.java)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(componentName)
            if (appWidgetIds != null && appWidgetIds.isNotEmpty()) {
                if (forceRefresh) refreshRequested.set(true)
                // Both overloads are deprecated with no replacement; this is the
                // supported way to refresh a collection widget's data.
                @Suppress("DEPRECATION")
                appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widgetListView)
            }
        }
    }
}
