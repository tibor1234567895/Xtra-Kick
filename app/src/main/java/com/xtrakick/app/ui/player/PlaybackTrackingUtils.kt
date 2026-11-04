package com.xtrakick.app.ui.player

import android.content.SharedPreferences
import androidx.core.content.edit
import com.xtrakick.app.repository.ShownNotificationsRepository
import com.xtrakick.app.util.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object PlaybackTrackingUtils {

    @JvmStatic
    fun saveActiveLiveChannel(
        prefs: SharedPreferences,
        shownNotificationsRepository: ShownNotificationsRepository,
        scope: CoroutineScope,
        channelId: String?,
        channelLogin: String?,
    ) {
        try {
            prefs.edit {
                putString(AppConstants.ACTIVE_LIVE_CHANNEL_ID, channelId)
                putString(AppConstants.ACTIVE_LIVE_CHANNEL_LOGIN, channelLogin)
                putLong(AppConstants.ACTIVE_LIVE_UPDATED_MS, System.currentTimeMillis())
            }
        } catch (_: Exception) {
        }
        scope.launch {
            runCatching {
                shownNotificationsRepository.markStreamSessionShown(
                    channelId = channelId,
                    channelLogin = channelLogin,
                )
            }
        }
    }

    @JvmStatic
    fun clearActiveLiveChannel(prefs: SharedPreferences) {
        try {
            prefs.edit {
                remove(AppConstants.ACTIVE_LIVE_CHANNEL_ID)
                remove(AppConstants.ACTIVE_LIVE_CHANNEL_LOGIN)
                remove(AppConstants.ACTIVE_LIVE_UPDATED_MS)
            }
        } catch (_: Exception) {
        }
    }
}
