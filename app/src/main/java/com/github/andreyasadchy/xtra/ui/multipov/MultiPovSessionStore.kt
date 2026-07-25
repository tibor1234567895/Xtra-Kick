package com.github.andreyasadchy.xtra.ui.multipov

import android.content.SharedPreferences
import androidx.core.content.edit
import com.github.andreyasadchy.xtra.model.ui.Stream
import com.github.andreyasadchy.xtra.util.C
import org.json.JSONArray
import org.json.JSONObject

data class MultiPovSessionChannel(
    val channelId: String? = null,
    val channelLogin: String? = null,
    val channelName: String? = null,
    val profileImageUrl: String? = null,
    val streamId: String? = null,
    val title: String? = null,
) {
    fun toStream(): Stream = Stream(
        id = streamId,
        source = C.KICK,
        channelId = channelId,
        channelLogin = channelLogin,
        channelName = channelName,
        title = title,
        profileImageUrl = profileImageUrl,
    )
}

data class MultiPovSession(
    val channels: List<MultiPovSessionChannel>,
    val focusedKey: String? = null,
    val streamQuality: String = MultiPovQuality.DEFAULT_PREF,
    val bandwidthSaving: Boolean = false,
) {
    fun toStreams(): List<Stream> = channels.map { it.toStream() }
}

object MultiPovSessionStore {
    private const val KEY = "multipov_last_session_json"

    fun save(prefs: SharedPreferences, state: MultiPovUiState) {
        if (state.slots.isEmpty()) {
            clear(prefs)
            return
        }
        val root = JSONObject()
        val channels = JSONArray()
        state.slots.forEach { slot ->
            channels.put(
                JSONObject().apply {
                    put("channelId", slot.stream.channelId)
                    put("channelLogin", slot.stream.channelLogin)
                    put("channelName", slot.stream.channelName)
                    put("profileImageUrl", slot.stream.profileImageUrl)
                    put("streamId", slot.stream.id)
                    put("title", slot.stream.title)
                }
            )
        }
        prefs.edit {
            putString(
                KEY,
                JSONObject()
                    .put("focusedKey", state.focusedKey)
                    .put("streamQuality", state.streamQuality.prefValue)
                    .put("bandwidthSaving", state.bandwidthSaving)
                    // Older builds read secondaryQuality; keep writing for one-release compatibility.
                    .put("secondaryQuality", state.streamQuality.prefValue)
                    .put("channels", channels)
                    .toString(),
            )
        }
    }

    fun load(prefs: SharedPreferences): MultiPovSession? {
        val raw = prefs.getString(KEY, null)?.takeIf { it.isNotBlank() } ?: return null
        return runCatching {
            val root = JSONObject(raw)
            val channelsJson = root.optJSONArray("channels") ?: return null
            val channels = buildList {
                for (i in 0 until channelsJson.length()) {
                    val obj = channelsJson.optJSONObject(i) ?: continue
                    val login = obj.optString("channelLogin").takeIf { it.isNotBlank() }
                    val id = obj.optString("channelId").takeIf { it.isNotBlank() }
                    if (login.isNullOrBlank() && id.isNullOrBlank()) continue
                    add(
                        MultiPovSessionChannel(
                            channelId = id,
                            channelLogin = login,
                            channelName = obj.optString("channelName").takeIf { it.isNotBlank() },
                            profileImageUrl = obj.optString("profileImageUrl").takeIf { it.isNotBlank() },
                            streamId = obj.optString("streamId").takeIf { it.isNotBlank() },
                            title = obj.optString("title").takeIf { it.isNotBlank() },
                        )
                    )
                }
            }
            if (channels.isEmpty()) {
                null
            } else {
                MultiPovSession(
                    channels = channels,
                    focusedKey = root.optString("focusedKey").takeIf { it.isNotBlank() },
                    streamQuality = root.optString("streamQuality")
                        .ifBlank { root.optString("secondaryQuality") }
                        .ifBlank { MultiPovQuality.DEFAULT_PREF },
                    bandwidthSaving = root.optBoolean("bandwidthSaving", false),
                )
            }
        }.getOrNull()
    }

    fun hasSession(prefs: SharedPreferences): Boolean = load(prefs) != null

    fun clear(prefs: SharedPreferences) {
        prefs.edit { remove(KEY) }
    }
}
