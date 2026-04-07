package com.github.andreyasadchy.xtra.ui.chat

import android.content.ContentResolver
import android.content.Context
import android.os.SystemClock
import android.util.Base64
import android.util.JsonReader
import android.util.JsonToken
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.andreyasadchy.xtra.BuildConfig
import com.github.andreyasadchy.xtra.R
import com.github.andreyasadchy.xtra.model.chat.Badge
import com.github.andreyasadchy.xtra.model.chat.ChannelPointReward
import com.github.andreyasadchy.xtra.model.chat.ChannelPointsSummary
import com.github.andreyasadchy.xtra.model.chat.ChatMessage
import com.github.andreyasadchy.xtra.model.chat.Chatter
import com.github.andreyasadchy.xtra.model.chat.CheerEmote
import com.github.andreyasadchy.xtra.model.chat.Emote
import com.github.andreyasadchy.xtra.model.chat.NamePaint
import com.github.andreyasadchy.xtra.model.chat.Poll
import com.github.andreyasadchy.xtra.model.chat.PinnedGift
import com.github.andreyasadchy.xtra.model.chat.Prediction
import com.github.andreyasadchy.xtra.model.chat.Raid
import com.github.andreyasadchy.xtra.model.chat.RecentEmote
import com.github.andreyasadchy.xtra.model.chat.Reply
import com.github.andreyasadchy.xtra.model.chat.RoomState
import com.github.andreyasadchy.xtra.model.chat.StvBadge
import com.github.andreyasadchy.xtra.model.chat.StvUser
import com.github.andreyasadchy.xtra.model.chat.TwitchBadge
import com.github.andreyasadchy.xtra.model.chat.TwitchEmote
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.repository.GraphQLRepository
import com.github.andreyasadchy.xtra.repository.HelixRepository
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.PlayerRepository
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.WebSocketRuntime
import com.github.andreyasadchy.xtra.util.chat.ChatReadIRC
import com.github.andreyasadchy.xtra.util.chat.ChatReadWebSocket
import com.github.andreyasadchy.xtra.util.chat.ChatUtils
import com.github.andreyasadchy.xtra.util.chat.ChatWriteIRC
import com.github.andreyasadchy.xtra.util.chat.ChatWriteWebSocket
import com.github.andreyasadchy.xtra.util.chat.EventSubUtils
import com.github.andreyasadchy.xtra.util.chat.EventSubWebSocket
import com.github.andreyasadchy.xtra.util.chat.HermesWebSocket
import com.github.andreyasadchy.xtra.util.chat.KickPusherChatWebSocket
import com.github.andreyasadchy.xtra.util.chat.PubSubUtils
import com.github.andreyasadchy.xtra.util.chat.RecentMessageUtils
import com.github.andreyasadchy.xtra.util.chat.StvEventApiUtils
import com.github.andreyasadchy.xtra.util.chat.StvEventApiWebSocket
import com.github.andreyasadchy.xtra.util.chat.WebSocketDisconnectUtils
import com.github.andreyasadchy.xtra.util.prefs
import com.github.andreyasadchy.xtra.util.tokenPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.PriorityQueue
import java.util.Timer
import java.util.TimeZone
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.net.ssl.X509TrustManager
import kotlin.concurrent.scheduleAtFixedRate


@HiltViewModel
class ChatViewModel @Inject constructor(
    @param:ApplicationContext private val applicationContext: Context,
    private val graphQLRepository: GraphQLRepository,
    private val helixRepository: HelixRepository,
    private val kickRepository: KickRepository,
    private val playerRepository: PlayerRepository,
    private val trustManager: X509TrustManager?,
    private val json: Json,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    private var chatReadIRC: ChatReadIRC? = null
    private var chatWriteIRC: ChatWriteIRC? = null
    private var chatReadWebSocket: ChatReadWebSocket? = null
    private var chatWriteWebSocket: ChatWriteWebSocket? = null
    private var kickPusherChatWebSocket: KickPusherChatWebSocket? = null
    private var chatReadJob: Job? = null
    private var chatWriteJob: Job? = null
    private var eventSub: EventSubWebSocket? = null
    private var hermesWebSocket: HermesWebSocket? = null
    private var pubSubJob: Job? = null
    private var stvEventApi: StvEventApiWebSocket? = null
    private var stvEventApiJob: Job? = null
    private var stvUserId: String? = null
    private var stvLastPresenceUpdate: Long? = null
    private val allEmotes = mutableListOf<String>()
    private var usedRaidId: String? = null
    private var usedPollId: String? = null
    private var pollTimeoutJob: Job? = null
    private var usedPredictionId: String? = null
    private var predictionTimeoutJob: Job? = null
    private var kickChatJob: Job? = null
    private val kickMessageIds = LinkedHashSet<String>()
    private val kickBroadcasterUserIds = ConcurrentHashMap<String, Long>()
    private var kickReplayFallbackEnabled = false
    private var kickReplayFallbackChannelId: String? = null
    private var kickReplayFallbackChannelLogin: String? = null
    private var kickReplayFallbackStartTimeMs: Long? = null
    private var kickReplayFallbackUrl: String? = null
    private var kickReplayFallbackGetCurrentPosition: (() -> Long?)? = null
    private var kickReplaySessionKey: String? = null
    private var kickReplaySessionStartPositionMs: Long? = null
    private var kickRealtimeLastDisconnectMessage: String? = null
    private var kickRealtimeLastDisconnectAtMs: Long = 0L
    private val kickReplayPreloadWindowMs = 60_000L
    private val kickReplayPreloadMaxMessages = 120
    private val kickReplayPollIntervalMs = 5_000L
    private val kickReplayEmitIntervalMs = 750L
    private val kickReplayEmitLeadMs = 500L
    private val kickReplyThreadHistoryWindowMs = 6L * 60L * 60L * 1000L
    private val kickRealtimeChatroomIdPrefix = "kick_realtime_chatroom_id"
    private val kickPreferredMessageSourcePrefix = "kick_preferred_message_source"
    private val kickReplayPendingMessages = PriorityQueue(
        11,
        compareBy<ChatMessage> { it.timestamp ?: Long.MIN_VALUE }
            .thenBy { kickMessageKey(it) }
    )
    private val kickReplayPendingKeys = LinkedHashSet<String>()
    private val kickReplayChatDebugTag = "KickReplayChatDebug"
    private val kickReplayChatRequestSeq = AtomicLong(0L)
    var autoReconnect = true

    private var chatReplayManager: ChatReplayManager? = null
    private var chatReplayManagerLocal: ChatReplayManagerLocal? = null

    val recentEmotes by lazy { playerRepository.loadRecentEmotesFlow() }
    val hasRecentEmotes = MutableStateFlow(false)
    val userEmotes = mutableListOf<Emote>()
    private var loadedUserEmotes = false
    val localTwitchEmotes = mutableListOf<TwitchEmote>()
    val thirdPartyEmotes = mutableListOf<Emote>()
    val globalBadges = mutableListOf<TwitchBadge>()
    val channelBadges = mutableListOf<TwitchBadge>()
    val cheerEmotes = mutableListOf<CheerEmote>()

    val roomState = MutableStateFlow<RoomState?>(null)
    val raid = MutableStateFlow<Raid?>(null)
    val raidClicked = MutableStateFlow<Raid?>(null)
    var raidClosed = false
    val poll = MutableStateFlow<Poll?>(null)
    var pollClosed = false
    val pollSecondsLeft = MutableStateFlow<Int?>(null)
    var pollTimer: Timer? = null
    val prediction = MutableStateFlow<Prediction?>(null)
    var predictionClosed = false
    val predictionSecondsLeft = MutableStateFlow<Int?>(null)
    var predictionTimer: Timer? = null
    private val _streamInfo = MutableStateFlow<PubSubUtils.StreamInfo?>(null)
    val streamInfo: StateFlow<PubSubUtils.StreamInfo?> = _streamInfo
    private val _playbackMessage = MutableStateFlow<PubSubUtils.PlaybackMessage?>(null)
    val playbackMessage: StateFlow<PubSubUtils.PlaybackMessage?> = _playbackMessage
    var streamId: String? = null
    private val rewardList = mutableListOf<ChatMessage>()
    private var lastPinnedGiftId: String? = null
    val namePaints = mutableListOf<NamePaint>()
    val stvBadges = mutableListOf<StvBadge>()
    val personalEmoteSets = mutableMapOf<String, List<Emote>>()
    val stvUsers = mutableListOf<StvUser>()
    var channelStvEmoteSetId: String? = null
    var userStvEmoteSetId: String? = null

    val reloadMessages = MutableStateFlow(false)
    val hideRaid = MutableStateFlow(false)
    val hidePoll = MutableStateFlow(false)
    val hidePrediction = MutableStateFlow(false)
    val pinnedGift = MutableStateFlow<PinnedGift?>(null)
    val pinnedGiftDismissed = MutableStateFlow(false)
    val channelPointsBalance = MutableStateFlow<Int?>(null)
    val channelPointRewards = MutableStateFlow<List<ChannelPointReward>>(emptyList())
    val channelPointRewardsAvailable = MutableStateFlow(false)
    val channelPointsSummary = MutableStateFlow(ChannelPointsSummary())

    val newMessage = MutableSharedFlow<Triple<ChatMessage, Int, Int>>()
    val addMessages = MutableSharedFlow<Pair<List<ChatMessage>, Int>>(replay = 1, extraBufferCapacity = 1)
    val appendMessages = MutableSharedFlow<Pair<List<ChatMessage>, Int>>()
    val removeMessages = MutableSharedFlow<Int>()
    val updateUserMessages = MutableSharedFlow<String>()
    val updateMessage = MutableSharedFlow<Pair<Int, ChatMessage>>()
    val liveLatencyMs = MutableStateFlow(0L)

    fun setLiveLatency(ms: Long) {
        liveLatencyMs.value = ms
    }

    private fun effectiveDelayMs(): Long {
        return when (applicationContext.prefs().getString(C.CHAT_DELAY_MODE, "0")) {
            "1" -> liveLatencyMs.value
            "2" -> applicationContext.prefs().getInt(C.CHAT_DELAY_CUSTOM_SECS, 5) * 1000L
            else -> 0L
        }
    }

    fun dismissPinnedGift() {
        pinnedGiftDismissed.value = true
    }

    fun restorePinnedGift() {
        pinnedGift.value?.let {
            pinnedGiftDismissed.value = false
        }
    }

    private fun clearPinnedGift() {
        pinnedGift.value = null
        pinnedGiftDismissed.value = false
        lastPinnedGiftId = null
    }

    private fun updatePinnedGift(nextPinnedGift: PinnedGift?) {
        if (nextPinnedGift == null) {
            clearPinnedGift()
            return
        }
        val isReplacement = lastPinnedGiftId != nextPinnedGift.id
        pinnedGift.value = nextPinnedGift
        if (isReplacement) {
            pinnedGiftDismissed.value = false
        }
        lastPinnedGiftId = nextPinnedGift.id
    }

    private fun updateChannelPointsSummary() {
        channelPointsSummary.value = ChannelPointsSummary(
            balance = channelPointsBalance.value,
            rewards = channelPointRewards.value,
            rewardsAvailable = channelPointRewardsAvailable.value
        )
    }

    private fun updateChannelPointsBalance(balance: Int?) {
        channelPointsBalance.value = balance
        updateChannelPointsSummary()
    }

    private fun updateChannelPointRewards(rewards: List<ChannelPointReward>, available: Boolean) {
        channelPointRewards.value = rewards
        channelPointRewardsAvailable.value = available
        updateChannelPointsSummary()
    }

    private fun getKickAccountId(): String? {
        return applicationContext.tokenPrefs().getString(C.KICK_USER_ID, null)?.takeIf { it.isNotBlank() }
            ?: applicationContext.tokenPrefs().getString(C.USER_ID, null)?.takeIf { it.isNotBlank() }
    }

    private fun getKickAccountLogin(): String? {
        return applicationContext.tokenPrefs().getString(C.KICK_USER_LOGIN, null)?.takeIf { it.isNotBlank() }
            ?: applicationContext.tokenPrefs().getString(C.USERNAME, null)?.takeIf { it.isNotBlank() }
    }
    val userEmotesUpdated = MutableSharedFlow<Unit>()
    val thirdPartyEmotesUpdated = MutableSharedFlow<Unit>()

    private var messageLimit = 600
    val chatMessages = mutableListOf<ChatMessage>()
    val autoCompleteList = mutableListOf<Any?>()
    private val chatters = ConcurrentHashMap<String, Chatter>()
    @Volatile
    private var kickLivePollingFallbackActive = false

    fun startLive(networkLibrary: String?, channelId: String?, channelLogin: String?, channelName: String?, streamId: String?) {
        if (chatReadIRC == null && chatReadWebSocket == null && eventSub == null && kickChatJob == null && channelLogin != null) {
            messageLimit = applicationContext.prefs().getInt(C.CHAT_LIMIT, 600)
            this.streamId = streamId
            kickLivePollingFallbackActive = false
            startLiveChat(channelId, channelLogin)
            addChatter(channelName)
            loadEmotes(channelId, channelLogin)
            if (applicationContext.prefs().getBoolean(C.CHAT_RECENT, true)) {
                loadRecentMessages(networkLibrary, channelLogin, channelId)
            }
            val isLoggedIn = com.github.andreyasadchy.xtra.util.AuthStateHelper.isKickLoggedIn(applicationContext)
            if (isLoggedIn) {
                loadUserEmotes(channelId)
            }
        }
    }

    fun startReplay(
        channelId: String?,
        channelLogin: String?,
        chatUrl: String? = null,
        videoId: String? = null,
        startTime: Int = 0,
        getCurrentPosition: () -> Long?,
        getCurrentSpeed: () -> Float?,
        kickReplayFallback: Boolean = false,
        kickReplayStartTime: String? = null,
        kickReplayUrl: String? = null
    ) {
        if (chatReplayManager == null && chatReplayManagerLocal == null) {
            messageLimit = applicationContext.prefs().getInt(C.CHAT_LIMIT, 600)
            startReplayChat(videoId, startTime, chatUrl, getCurrentPosition, getCurrentSpeed, channelId, channelLogin, kickReplayFallback, kickReplayStartTime, kickReplayUrl)
            if (videoId != null || kickReplayFallback) {
                loadEmotes(channelId, channelLogin)
            }
        }
    }

    fun resumeLive(channelId: String?, channelLogin: String?) {
        if (channelLogin != null && autoReconnect) {
            if (!kickLivePollingFallbackActive && chatReadJob?.isActive == false) {
                startLiveChat(channelId, channelLogin)
            }
        }
    }

    fun resumeReplay(
        channelId: String?,
        channelLogin: String?,
        chatUrl: String?,
        videoId: String?,
        startTime: Int,
        getCurrentPosition: () -> Long?,
        getCurrentSpeed: () -> Float?,
        kickReplayFallback: Boolean = false,
        kickReplayStartTime: String? = null,
        kickReplayUrl: String? = null
    ) {
        if (kickReplayFallback) {
            if (kickChatJob?.isActive != true) {
                startReplayChat(videoId, startTime, chatUrl, getCurrentPosition, getCurrentSpeed, channelId, channelLogin, true, kickReplayStartTime, kickReplayUrl)
            }
            return
        }
        if (chatReplayManager?.isActive == false || chatReplayManagerLocal?.isActive == false) {
            startReplayChat(videoId, startTime, chatUrl, getCurrentPosition, getCurrentSpeed, channelId, channelLogin, kickReplayFallback, kickReplayStartTime, kickReplayUrl)
        }
    }

    override fun onCleared() {
        stopLiveChat()
        stopReplayChat()
        pollSecondsLeft.value = null
        pollTimer?.cancel()
        predictionSecondsLeft.value = null
        predictionTimer?.cancel()
        super.onCleared()
    }

    private fun loadEmotes(channelId: String?, channelLogin: String?) {
        val kickMode = isKickPreferred()
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val helixHeaders = KickApiHelper.getHelixHeaders(applicationContext)
        val gqlHeaders = KickApiHelper.getGQLHeaders(applicationContext, true)
        val emoteQuality = applicationContext.prefs().getString(C.CHAT_IMAGE_QUALITY, "4") ?: "4"
        val animateGifs = applicationContext.prefs().getBoolean(C.ANIMATED_EMOTES, true)
        val useWebp = applicationContext.prefs().getBoolean(C.CHAT_USE_WEBP, true)
        val enableIntegrity = applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false)
        synchronized(thirdPartyEmotes) {
            thirdPartyEmotes.clear()
        }
        if (kickMode && !channelLogin.isNullOrBlank()) {
            viewModelScope.launch {
                try {
                    // Populate Kick badge URL cache regardless of third-party emote settings.
                    kickRepository.getChannel(channelLogin)
                    if (BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)) {
                        Log.d("KickBadgeDebug", "prefetchByLogin success login=$channelLogin")
                    }
                } catch (_: Exception) {
                    if (BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)) {
                        Log.w("KickBadgeDebug", "prefetchByLogin failed login=$channelLogin")
                    }
                    channelId?.takeIf { it.isNotBlank() }?.let { idCandidate ->
                        runCatching {
                            kickRepository.getChannel(idCandidate)
                            if (BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)) {
                                Log.d("KickBadgeDebug", "prefetchById success id=$idCandidate")
                            }
                        }.onFailure {
                            if (BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_BADGE_LOGS, false)) {
                                Log.w("KickBadgeDebug", "prefetchById failed id=$idCandidate")
                            }
                        }
                    }
                }
            }
        }
        if (kickMode) {
            synchronized(globalBadges) {
                globalBadges.clear()
            }
            synchronized(channelBadges) {
                channelBadges.clear()
            }
            synchronized(cheerEmotes) {
                cheerEmotes.clear()
            }
        } else {
            val saved = savedGlobalBadges
            if (!saved.isNullOrEmpty()) {
                synchronized(globalBadges) {
                    globalBadges.clear()
                    globalBadges.addAll(saved)
                }
                if (!reloadMessages.value) {
                    reloadMessages.value = true
                }
            } else {
                viewModelScope.launch {
                    try {
                        val badges = playerRepository.loadGlobalBadges(networkLibrary, helixHeaders, gqlHeaders, emoteQuality, enableIntegrity)
                        if (badges.isNotEmpty()) {
                            savedGlobalBadges = badges
                            synchronized(globalBadges) {
                                globalBadges.clear()
                                globalBadges.addAll(badges)
                            }
                            if (!reloadMessages.value) {
                                reloadMessages.value = true
                            }
                        }
                    } catch (e: Exception) {
                        if (e.message == "failed integrity check" && integrity.value == null) {
                            integrity.value = "refresh"
                        }
                    }
                }
            }
        }
        if (applicationContext.prefs().getBoolean(C.CHAT_ENABLE_STV, true)) {
            val saved = savedGlobalStvEmotes
            if (!saved.isNullOrEmpty()) {
                synchronized(thirdPartyEmotes) {
                    thirdPartyEmotes.addAll(saved)
                    thirdPartyEmotes.sortBy { it.source }
                }
                if (!reloadMessages.value) {
                    reloadMessages.value = true
                }
                viewModelScope.launch {
                    thirdPartyEmotesUpdated.emit(Unit)
                }
                synchronized(autoCompleteList) {
                    autoCompleteList.addAll(saved.filter { it !in autoCompleteList })
                }
                synchronized(allEmotes) {
                    allEmotes.addAll(saved.filter { it.name !in allEmotes }.mapNotNull { it.name })
                }
            } else {
                viewModelScope.launch {
                    try {
                        val emotes = playerRepository.loadGlobalStvEmotes(networkLibrary, useWebp)
                        if (emotes.isNotEmpty()) {
                            savedGlobalStvEmotes = emotes
                            synchronized(thirdPartyEmotes) {
                                thirdPartyEmotes.addAll(emotes)
                                thirdPartyEmotes.sortBy { it.source }
                            }
                            if (!reloadMessages.value) {
                                reloadMessages.value = true
                            }
                            thirdPartyEmotesUpdated.emit(Unit)
                            synchronized(autoCompleteList) {
                                autoCompleteList.addAll(emotes.filter { it !in autoCompleteList })
                            }
                            synchronized(allEmotes) {
                                allEmotes.addAll(emotes.filter { it.name !in allEmotes }.mapNotNull { it.name })
                            }
                        }
                    } catch (e: Exception) {

                    }
                }
            }
            if (!channelId.isNullOrBlank()) {
                viewModelScope.launch {
                    try {
                        val response = loadStvChannelEmotes(networkLibrary, channelId, channelLogin, useWebp)
                        val setId = response.first
                        val emotes = response.second
                        if (emotes.isNotEmpty()) {
                            channelStvEmoteSetId = setId
                            synchronized(thirdPartyEmotes) {
                                thirdPartyEmotes.addAll(emotes)
                                thirdPartyEmotes.sortBy { it.source }
                            }
                            if (!reloadMessages.value) {
                                reloadMessages.value = true
                            }
                            thirdPartyEmotesUpdated.emit(Unit)
                            synchronized(autoCompleteList) {
                                autoCompleteList.addAll(emotes.filter { it !in autoCompleteList })
                            }
                            synchronized(allEmotes) {
                                allEmotes.addAll(emotes.filter { it.name !in allEmotes }.mapNotNull { it.name })
                            }
                        }
                    } catch (e: Exception) {

                    }
                }
            }
        }
        if (!kickMode && (!channelId.isNullOrBlank() || !channelLogin.isNullOrBlank())) {
            viewModelScope.launch {
                try {
                    val badges = playerRepository.loadChannelBadges(networkLibrary, helixHeaders, gqlHeaders, channelId, channelLogin, emoteQuality, enableIntegrity)
                    if (badges.isNotEmpty()) {
                        synchronized(channelBadges) {
                            channelBadges.clear()
                            channelBadges.addAll(badges)
                        }
                        if (!reloadMessages.value) {
                            reloadMessages.value = true
                        }
                    }
                } catch (e: Exception) {
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "refresh"
                    }
                }
            }
            viewModelScope.launch {
                try {
                    val emotes = playerRepository.loadCheerEmotes(networkLibrary, helixHeaders, gqlHeaders, channelId, channelLogin, animateGifs, enableIntegrity)
                    if (emotes.isNotEmpty()) {
                        synchronized(cheerEmotes) {
                            cheerEmotes.clear()
                            cheerEmotes.addAll(emotes)
                        }
                        if (!reloadMessages.value) {
                            reloadMessages.value = true
                        }
                    }
                } catch (e: Exception) {
                    if (e.message == "failed integrity check" && integrity.value == null) {
                        integrity.value = "refresh"
                    }
                }
            }
        }
    }

    private fun loadUserEmotes(channelId: String?) {
        if (isKickPreferred()) {
            synchronized(userEmotes) {
                userEmotes.clear()
            }
            loadedUserEmotes = false
            return
        }
        val saved = savedUserEmotes
        if (!saved.isNullOrEmpty()) {
            synchronized(userEmotes) {
                userEmotes.clear()
                userEmotes.addAll(
                    saved.sortedByDescending { it.ownerId == channelId }.map {
                        Emote(
                            name = it.name,
                            url1x = it.url1x,
                            url2x = it.url2x,
                            url3x = it.url3x,
                            url4x = it.url4x,
                            format = it.format
                        )
                    }
                )
            }
            viewModelScope.launch {
                userEmotesUpdated.emit(Unit)
            }
            synchronized(allEmotes) {
                allEmotes.addAll(saved.filter { it.name !in allEmotes }.mapNotNull { it.name })
            }
        } else {
            val helixHeaders = KickApiHelper.getHelixHeaders(applicationContext)
            val gqlHeaders = KickApiHelper.getGQLHeaders(applicationContext, true)
            if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank() || !helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                viewModelScope.launch {
                    try {
                        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                        val accountId = applicationContext.tokenPrefs().getString(C.USER_ID, null)
                        val animateGifs =  applicationContext.prefs().getBoolean(C.ANIMATED_EMOTES, true)
                        val enableIntegrity = applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false)
                        val emotes = playerRepository.loadUserEmotes(networkLibrary, helixHeaders, gqlHeaders, channelId, accountId, animateGifs, enableIntegrity)
                        if (emotes.isNotEmpty()) {
                            val sorted = emotes.sortedByDescending { it.setId }
                            synchronized(userEmotes) {
                                userEmotes.clear()
                                userEmotes.addAll(
                                    sorted.sortedByDescending { it.ownerId == channelId }.map {
                                        Emote(
                                            name = it.name,
                                            url1x = it.url1x,
                                            url2x = it.url2x,
                                            url3x = it.url3x,
                                            url4x = it.url4x,
                                            format = it.format
                                        )
                                    }
                                )
                            }
                            userEmotesUpdated.emit(Unit)
                            synchronized(allEmotes) {
                                allEmotes.addAll(sorted.filter { it.name !in allEmotes }.mapNotNull { it.name })
                            }
                            loadedUserEmotes = true
                        }
                    } catch (e: Exception) {
                        if (e.message == "failed integrity check" && integrity.value == null) {
                            integrity.value = "refresh"
                        }
                    }
                }
            }
        }
    }

    fun loadRecentEmotes() {
        viewModelScope.launch {
            hasRecentEmotes.value = playerRepository.loadRecentEmotes().isNotEmpty()
        }
    }

    fun getEmoteBytes(chatUrl: String, localData: Pair<Long, Int>): ByteArray? {
        return if (chatUrl.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
            applicationContext.contentResolver.openInputStream(chatUrl.toUri())?.bufferedReader()
        } else {
            FileInputStream(File(chatUrl)).bufferedReader()
        }?.use { fileReader ->
            val buffer = CharArray(localData.second)
            fileReader.skip(localData.first)
            fileReader.read(buffer, 0, localData.second)
            Base64.decode(buffer.concatToString(), Base64.NO_WRAP or Base64.NO_PADDING)
        }
    }

    fun reloadEmotes(channelId: String?, channelLogin: String?) {
        savedGlobalBadges = null
        savedGlobalStvEmotes = null
        loadEmotes(channelId, channelLogin)
    }

    fun loadRecentMessages(networkLibrary: String?, channelLogin: String, channelId: String?) {
        viewModelScope.launch {
            val debugKickRealtimeChat = BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false)
            try {
                val list = if (isKickPreferred() && !channelId.isNullOrBlank()) {
                    val kickMessageSources = resolveKickMessageSources(channelId, channelLogin)
                    Log.w("KickRecentChat", "preload start channelId=$channelId channelLogin=$channelLogin sources=$kickMessageSources")
                    val fetchedMessages = fetchKickMessages(
                        messageSources = kickMessageSources,
                        channelId = channelId,
                        channelLogin = channelLogin
                    ).ifEmpty {
                        val liveHistorySources = buildList {
                            add(channelId)
                            addAll(kickMessageSources)
                        }.distinct()
                        Log.w(
                            "KickRecentChat",
                            "preload live history fallback channelId=$channelId channelLogin=$channelLogin sources=$liveHistorySources"
                        )
                        fetchKickLiveHistoryMessages(
                            messageSources = liveHistorySources,
                            channelId = channelId,
                            channelLogin = channelLogin
                        ).ifEmpty {
                            val historyStartTime = formatIso8601Utc(
                                System.currentTimeMillis() - 5L * 60L * 1000L
                            )
                            Log.w("KickRecentChat", "preload history fallback channelId=$channelId channelLogin=$channelLogin start=$historyStartTime")
                            fetchKickHistoryMessages(
                                messageSources = kickMessageSources,
                                startTime = historyStartTime,
                                channelId = channelId,
                                channelLogin = channelLogin,
                                debugPhase = "live_preload",
                                maxPages = 2
                            )
                        }
                    }
                    val displayMessages = buildKickDisplayMessages(fetchedMessages)
                    Log.w(
                        "KickRecentChat",
                        "preload result channelId=$channelId channelLogin=$channelLogin fetched=${fetchedMessages.size} display=${displayMessages.size}"
                    )
                    if (debugKickRealtimeChat) {
                        Log.d(
                            "KickRecentChat",
                            "sources=$kickMessageSources fetched=${fetchedMessages.size} display=${displayMessages.size} channelId=$channelId channelLogin=$channelLogin"
                        )
                    }
                    displayMessages
                        .onEach { message ->
                            if (!message.isReply) {
                                message.id?.let { id ->
                                    synchronized(kickMessageIds) {
                                        kickMessageIds.add(id)
                                    }
                                }
                            }
                        }
                        .toMutableList()
                } else {
                    val recentList = mutableListOf<ChatMessage>()
                    playerRepository.loadRecentMessages(networkLibrary, channelLogin, applicationContext.prefs().getInt(C.CHAT_RECENT_LIMIT, 100).toString()).messages.forEach { message ->
                        when {
                            message.contains("PRIVMSG") -> RecentMessageUtils.parseChatMessage(message, false)
                            message.contains("USERNOTICE") -> {
                                if (applicationContext.prefs().getBoolean(C.CHAT_SHOW_USERNOTICE, true)) {
                                    RecentMessageUtils.parseChatMessage(message, true)
                                } else null
                            }
                            message.contains("CLEARMSG") -> {
                                if (applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARMSG, true)) {
                                    val pair = RecentMessageUtils.parseClearMessage(message)
                                    val deletedMessageIndex = pair.second?.let { targetId -> recentList.indexOfLast { it.id == targetId } } ?: -1
                                    if (deletedMessageIndex != -1) {
                                        recentList[deletedMessageIndex] = createDeletedMessage(recentList[deletedMessageIndex])
                                        null
                                    } else {
                                        getClearMessage(pair.first, null, applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1"))
                                    }
                                } else null
                            }
                            message.contains("CLEARCHAT") -> {
                                if (applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARCHAT, true)) {
                                    RecentMessageUtils.parseClearChat(applicationContext, message)
                                } else null
                            }
                            message.contains("NOTICE") -> RecentMessageUtils.parseNotice(applicationContext, message)
                            else -> null
                        }?.let {
                            buildReplyPreviewMessage(it, recentList)?.let(recentList::add)
                            recentList.add(it)
                        }
                    }
                    recentList
                }
                if (list.isNotEmpty()) {
                    synchronized(chatMessages) {
                        val left = messageLimit - chatMessages.size
                        if (left > 0) {
                            val items = list.takeLast(left)
                            chatMessages.addAll(0, items)
                            Pair(items, chatMessages.lastIndex)
                        } else null
                    }.let {
                        if (it != null) {
                            Log.w(
                                "KickRecentChat",
                                "preload emit channelId=$channelId channelLogin=$channelLogin added=${it.first.size} total=${synchronized(chatMessages) { chatMessages.size }}"
                            )
                            if (debugKickRealtimeChat) {
                                Log.d(
                                    "KickRecentChat",
                                    "emit added=${it.first.size} lastIndex=${it.second} total=${synchronized(chatMessages) { chatMessages.size }}"
                                )
                            }
                            addMessages.emit(it)
                        }
                    }
                } else if (debugKickRealtimeChat) {
                    Log.d("KickRecentChat", "no recent messages emitted for channelId=$channelId channelLogin=$channelLogin")
                }
            } catch (e: Exception) {
                Log.w("KickRecentChat", "loadRecentMessages failed channelId=$channelId channelLogin=$channelLogin", e)
                if (debugKickRealtimeChat) {
                    Log.w("KickRecentChat", "loadRecentMessages failed channelId=$channelId channelLogin=$channelLogin", e)
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun clearAddMessagesReplay() {
        addMessages.resetReplayCache()
    }

    private fun isKickPreferred(): Boolean {
        val pref = applicationContext.prefs().getString(C.API_PREFS_STREAMS, null) ?: C.DEFAULT_API_PREFS_STREAMS
        return pref.split(',').any { item ->
            val split = item.split(':')
            split.getOrNull(0) == C.KICK && split.getOrNull(1) != "0"
        }
    }

    private suspend fun resolveKickMessageSources(channelId: String, channelLogin: String): List<String> {
        val channel = runCatching { kickRepository.getChannel(channelLogin) }.getOrNull()
            ?: runCatching { kickRepository.getChannel(channelId) }.getOrNull()
        val resolvedChatroomIds = linkedSetOf<String>().apply {
            getCachedKickRealtimeChatroomId(channelId, channelLogin)?.let(::add)
            runCatching { kickRepository.resolveDedicatedChatroomCandidates(channelLogin) }.getOrNull().orEmpty().forEach(::add)
            kickRepository.getChatroomId(channel ?: return@apply)?.takeIf { it.isNotBlank() }?.let(::add)
        }
        return LinkedHashSet<String>().apply {
            getCachedKickPreferredMessageSource(channelId, channelLogin)?.let(::add)
            addAll(resolvedChatroomIds)
            channel?.userId?.toString()?.takeIf { it.isNotBlank() }?.let(::add)
            channel?.user?.id?.toString()?.takeIf { it.isNotBlank() }?.let(::add)
            add(channelId)
            add(channelLogin)
        }.filter { it.isNotBlank() }
    }

    private fun getKickRealtimeChatroomPreferenceKeys(channelId: String?, channelLogin: String?): List<String> {
        return buildList {
            channelId?.trim()?.takeIf { it.isNotBlank() }?.let { add("$kickRealtimeChatroomIdPrefix:id:${it.lowercase(Locale.ROOT)}") }
            channelLogin?.trim()?.takeIf { it.isNotBlank() }?.let { add("$kickRealtimeChatroomIdPrefix:login:${it.lowercase(Locale.ROOT)}") }
        }
    }

    private fun getCachedKickRealtimeChatroomId(channelId: String?, channelLogin: String?): String? {
        val prefs = applicationContext.prefs()
        return getKickRealtimeChatroomPreferenceKeys(channelId, channelLogin)
            .asSequence()
            .mapNotNull { key -> prefs.getString(key, null)?.trim() }
            .firstOrNull { it.isNotBlank() }
    }

    private fun cacheKickRealtimeChatroomId(chatroomId: String, channelId: String?, channelLogin: String?) {
        val normalizedChatroomId = chatroomId.trim()
        if (normalizedChatroomId.isBlank()) {
            return
        }
        val keys = getKickRealtimeChatroomPreferenceKeys(channelId, channelLogin)
        if (keys.isEmpty()) {
            return
        }
        applicationContext.prefs().edit().apply {
            keys.forEach { key -> putString(key, normalizedChatroomId) }
        }.apply()
    }

    private fun getKickMessageSourcePreferenceKeys(channelId: String?, channelLogin: String?): List<String> {
        return buildList {
            channelId?.trim()?.takeIf { it.isNotBlank() }?.let { add("$kickPreferredMessageSourcePrefix:id:${it.lowercase(Locale.ROOT)}") }
            channelLogin?.trim()?.takeIf { it.isNotBlank() }?.let { add("$kickPreferredMessageSourcePrefix:login:${it.lowercase(Locale.ROOT)}") }
        }
    }

    private fun getCachedKickPreferredMessageSource(channelId: String?, channelLogin: String?): String? {
        val prefs = applicationContext.prefs()
        return getKickMessageSourcePreferenceKeys(channelId, channelLogin)
            .asSequence()
            .mapNotNull { key -> prefs.getString(key, null)?.trim() }
            .firstOrNull { it.isNotBlank() }
    }

    private fun cacheKickPreferredMessageSource(source: String, channelId: String?, channelLogin: String?) {
        val normalizedSource = source.trim()
        if (normalizedSource.isBlank()) {
            return
        }
        val keys = getKickMessageSourcePreferenceKeys(channelId, channelLogin)
        if (keys.isEmpty()) {
            return
        }
        val prefs = applicationContext.prefs()
        prefs.edit().apply {
            keys.forEach { key -> putString(key, normalizedSource) }
        }.apply()
    }

    private suspend fun resolveKickRealtimeChatroomId(channelId: String, channelLogin: String): String {
        getCachedKickRealtimeChatroomId(channelId, channelLogin)?.let { return it }
        val resolvedChatroomId = runCatching { kickRepository.resolveDedicatedChatroomCandidates(channelLogin) }.getOrNull().orEmpty().firstOrNull()
            ?: runCatching { kickRepository.resolveDedicatedChatroomCandidates(channelId) }.getOrNull().orEmpty().firstOrNull()
            ?: runCatching { kickRepository.getChannel(channelLogin) }.getOrNull()?.let(kickRepository::getChatroomId)
            ?: channelId
        cacheKickRealtimeChatroomId(resolvedChatroomId, channelId, channelLogin)
        return resolvedChatroomId
    }

    private suspend fun resolveKickBroadcasterUserId(channelId: String?, channelLogin: String?): Long? {
        val channelIdValue = channelId?.trim().takeUnless { it.isNullOrBlank() }
        val channelLoginValue = channelLogin?.trim().takeUnless { it.isNullOrBlank() }
        val candidates = linkedSetOf<String>().apply {
            channelLoginValue?.let(::add)
            channelIdValue?.let(::add)
        }
        candidates.forEach { candidate ->
            kickBroadcasterUserIds[candidate]?.let { return it }
            val resolved = try {
                kickRepository.getChannel(candidate).userId
            } catch (_: Exception) {
                null
            }
            if (resolved != null) {
                kickBroadcasterUserIds[candidate] = resolved
                channelIdValue?.let { kickBroadcasterUserIds[it] = resolved }
                channelLoginValue?.let { kickBroadcasterUserIds[it] = resolved }
                return resolved
            }
        }
        return null
    }

    private suspend fun loadStvChannelEmotes(networkLibrary: String?, channelId: String, channelLogin: String?, useWebp: Boolean): Pair<String?, List<Emote>> {
        if (!isKickPreferred()) {
            return playerRepository.loadStvEmotes(networkLibrary, channelId, useWebp)
        }
        var lastError: Exception? = null
        val candidates = LinkedHashSet<String>().apply {
            resolveKickBroadcasterUserId(channelId, channelLogin)?.toString()?.let(::add)
            channelId.trim().takeIf { it.isNotBlank() }?.let(::add)
            channelLogin?.trim()?.takeIf { it.isNotBlank() }?.let(::add)
        }
        candidates.forEach { candidate ->
            try {
                return playerRepository.loadStvKickEmotes(networkLibrary, candidate, useWebp)
            } catch (e: Exception) {
                lastError = e
            }
        }
        try {
            return playerRepository.loadStvEmotes(networkLibrary, channelId, useWebp)
        } catch (e: Exception) {
            lastError = e
        }
        throw lastError
    }

    private fun addKickInlineEmotes(rawMessage: String?): Boolean {
        if (rawMessage.isNullOrBlank()) return false
        val parsed = KICK_INLINE_EMOTE_REGEX.findAll(rawMessage).mapNotNull { match ->
            val id = match.groupValues.getOrNull(1)?.trim()
            val name = match.groupValues.getOrNull(2)?.trim()
            if (!id.isNullOrBlank() && !name.isNullOrBlank()) {
                Emote(
                    name = name,
                    url1x = "https://files.kick.com/emotes/${id}/fullsize",
                    url2x = "https://files.kick.com/emotes/${id}/fullsize",
                    url3x = "https://files.kick.com/emotes/${id}/fullsize",
                    url4x = "https://files.kick.com/emotes/${id}/fullsize",
                    format = "gif",
                    isAnimated = true
                )
            } else null
        }.toList()
        if (parsed.isEmpty()) return false
        val added = mutableListOf<Emote>()
        synchronized(thirdPartyEmotes) {
            parsed.forEach { emote ->
                if (thirdPartyEmotes.none { it.name == emote.name }) {
                    thirdPartyEmotes.add(emote)
                    added.add(emote)
                }
            }
        }
        if (added.isEmpty()) return false
        synchronized(autoCompleteList) {
            autoCompleteList.addAll(added.filter { it !in autoCompleteList })
        }
        synchronized(allEmotes) {
            allEmotes.addAll(added.mapNotNull { it.name }.filter { it !in allEmotes })
        }
        return true
    }

    private data class KickClipEmitStats(
        val total: Int,
        val emitted: Int,
        val deduped: Int,
    )

    private data class KickClipQueueStats(
        val total: Int,
        val queued: Int,
        val alreadyEmitted: Int,
        val alreadyQueued: Int,
    )

    private data class KickRealtimeMessage(
        val eventName: String?,
        val message: KickMessage,
    )

    private fun isKickReplayChatDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_CLIP_CHAT, true)
    }

    private inline fun logKickReplayChat(stage: String, sessionKey: String?, message: () -> String) {
        if (!isKickReplayChatDebugEnabled()) return
        Log.i(kickReplayChatDebugTag, "stage=$stage session=${sessionKey ?: "-"} ${message()}")
    }

    private fun messageRangeSummary(messages: List<ChatMessage>): String {
        if (messages.isEmpty()) return "range=empty"
        return "range=${messages.firstOrNull()?.timestamp ?: "null"}..${messages.lastOrNull()?.timestamp ?: "null"}"
    }

    private fun kickMessageKey(message: ChatMessage): String {
        if (message.isReply) {
            val parentId = message.replyParent?.id ?: message.reply?.threadParentId
            return "reply:${parentId ?: "unknown"}:${message.reply?.userLogin}:${message.reply?.message}"
        }
        return message.id ?: "${message.timestamp}:${message.userName}:${message.message}"
    }

    private fun findReplyParentMessage(reply: Reply?, additionalMessages: List<ChatMessage> = emptyList()): ChatMessage? {
        val threadParentId = reply?.threadParentId?.takeIf { it.isNotBlank() } ?: return null
        return additionalMessages
            .asReversed()
            .firstOrNull { !it.isReply && it.id == threadParentId }
            ?: synchronized(chatMessages) {
                chatMessages
                    .asReversed()
                    .firstOrNull { !it.isReply && it.id == threadParentId }
            }
    }

    private fun buildReplyPreviewMessage(message: ChatMessage, additionalMessages: List<ChatMessage> = emptyList()): ChatMessage? {
        val reply = message.reply?.takeIf { !it.threadParentId.isNullOrBlank() && it.message != null } ?: return null
        val replyParent = findReplyParentMessage(reply, additionalMessages)
        val previewReply = replyParent
            ?.takeIf { it.message == reply.message }
            ?.let {
                Reply(
                    threadParentId = reply.threadParentId,
                    userLogin = it.userLogin ?: reply.userLogin,
                    userName = it.userName ?: reply.userName,
                    message = it.message ?: reply.message
                )
            }
            ?: reply
        return ChatMessage(
            reply = previewReply,
            isReply = true,
            replyParent = replyParent ?: message,
            timestamp = message.timestamp,
            fullMsg = message.fullMsg
        )
    }

    private fun buildKickDisplayMessages(messages: List<ChatMessage>): List<ChatMessage> {
        return buildList {
            messages.forEach { message ->
                buildReplyPreviewMessage(message, messages)?.let(::add)
                add(message)
            }
        }
    }

    private fun filterKickThreadMessages(messages: List<ChatMessage>, selectedMessage: ChatMessage, threadParentId: String): List<ChatMessage> {
        val sorted = messages
            .filter { !it.isReply }
            .sortedBy { it.timestamp ?: Long.MAX_VALUE }
        if (sorted.isEmpty()) return emptyList()
        val knownIds = linkedSetOf(threadParentId).apply {
            selectedMessage.id?.let(::add)
            selectedMessage.reply?.threadParentId?.let(::add)
        }
        val addedKeys = linkedSetOf<String>()
        val threadMessages = mutableListOf<ChatMessage>()
        var changed: Boolean
        do {
            changed = false
            sorted.forEach { message ->
                val include = message.id == threadParentId ||
                    message.id == selectedMessage.id ||
                    message.reply?.threadParentId?.let { it in knownIds } == true
                if (!include) return@forEach
                val key = kickMessageKey(message)
                if (!addedKeys.add(key)) return@forEach
                threadMessages += message
                message.id?.let { id ->
                    if (knownIds.add(id)) {
                        changed = true
                    }
                }
            }
        } while (changed)
        return threadMessages
    }

    private fun resetKickReplayPendingQueue() {
        kickReplayPendingMessages.clear()
        kickReplayPendingKeys.clear()
    }

    private fun queueKickReplayMessages(messages: List<ChatMessage>): KickClipQueueStats {
        var queued = 0
        var alreadyEmitted = 0
        var alreadyQueued = 0
        messages.forEach { message ->
            val key = kickMessageKey(message)
            val seen = synchronized(kickMessageIds) { kickMessageIds.contains(key) }
            if (seen) {
                alreadyEmitted += 1
                return@forEach
            }
            if (!kickReplayPendingKeys.add(key)) {
                alreadyQueued += 1
                return@forEach
            }
            kickReplayPendingMessages.offer(message)
            queued += 1
        }
        return KickClipQueueStats(
            total = messages.size,
            queued = queued,
            alreadyEmitted = alreadyEmitted,
            alreadyQueued = alreadyQueued
        )
    }

    private suspend fun emitDueKickReplayMessages(cutoffTimestampMs: Long): KickClipEmitStats {
        if (kickReplayPendingMessages.isEmpty()) {
            return KickClipEmitStats(total = 0, emitted = 0, deduped = 0)
        }
        val due = mutableListOf<ChatMessage>()
        while (kickReplayPendingMessages.isNotEmpty()) {
            val next = kickReplayPendingMessages.peek() ?: break
            val nextTimestamp = next.timestamp
            if (nextTimestamp != null && nextTimestamp > cutoffTimestampMs) {
                break
            }
            kickReplayPendingMessages.poll()
            kickReplayPendingKeys.remove(kickMessageKey(next))
            due += next
        }
        if (due.isEmpty()) {
            return KickClipEmitStats(total = 0, emitted = 0, deduped = 0)
        }
        return emitKickMessages(due)
    }

    private fun mapKickMessages(rawMessages: List<KickMessage>): List<ChatMessage> {
        val nameDisplay = applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1")
        val showClearMsg = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARMSG, true)
        val showClearChat = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARCHAT, true)
        val mappedMessages = mutableListOf<ChatMessage>()
        rawMessages.forEach { rawMessage ->
            val chatMessage = kickRepository.toChatMessage(rawMessage)
            when {
                kickRepository.isKickSingleMessageDelete(rawMessage) -> {
                    if (!showClearMsg) {
                        return@forEach
                    }
                    val targetId = kickRepository.getKickModerationTargetMessageId(rawMessage)
                    val deletedMessageIndex = targetId?.let { id -> mappedMessages.indexOfLast { it.id == id } } ?: -1
                    val deletedMessage = when {
                        deletedMessageIndex != -1 -> createDeletedMessage(mappedMessages[deletedMessageIndex]).also { mappedMessages[deletedMessageIndex] = it }
                        else -> targetId?.let { id ->
                            synchronized(chatMessages) {
                                chatMessages.findLast { it.id == id }
                            }
                        }
                    }
                    if (deletedMessageIndex != -1) {
                        return@forEach
                    }
                    if (deletedMessage != null) {
                        mappedMessages += getClearMessage(chatMessage, deletedMessage, nameDisplay)
                    } else {
                        mappedMessages += getClearMessage(chatMessage, null, nameDisplay)
                    }
                }
                chatMessage.msgId == "kick_moderation" -> {
                    if (showClearChat) {
                        mappedMessages += chatMessage
                    }
                }
                !chatMessage.message.isNullOrBlank() || !chatMessage.systemMsg.isNullOrBlank() -> {
                    mappedMessages += chatMessage
                }
            }
        }
        return mappedMessages
    }

    private suspend fun fetchKickMessages(
        messageSources: List<String>,
        channelId: String? = null,
        channelLogin: String? = null
    ): List<ChatMessage> {
        val debugKickRealtimeChat = BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false)
        for (source in messageSources) {
            try {
                val response = kickRepository.getRecentMessages(source)
                val rawMessages = response.messages
                val rawCount = rawMessages.size
                val messages = mapKickMessages(rawMessages)
                    .sortedBy { it.timestamp }
                if (debugKickRealtimeChat) {
                    Log.d("KickRecentChat", "source=$source rawCount=$rawCount mappedCount=${messages.size}")
                }
                if (rawCount == 0) {
                    continue
                }
                var newKickEmotesAdded = false
                messages.forEach { message ->
                    if (addKickInlineEmotes(message.fullMsg)) {
                        newKickEmotesAdded = true
                    }
                }
                if (newKickEmotesAdded) {
                    synchronized(thirdPartyEmotes) {
                        thirdPartyEmotes.sortBy { it.source }
                    }
                    if (!reloadMessages.value) {
                        reloadMessages.value = true
                    }
                    thirdPartyEmotesUpdated.emit(Unit)
                }
                if (messages.isNotEmpty()) {
                    cacheKickPreferredMessageSource(source, channelId, channelLogin)
                    return messages
                }
            } catch (e: Exception) {
                if (debugKickRealtimeChat) {
                    Log.w("KickRecentChat", "source=$source fetch failed", e)
                }
            }
        }
        return emptyList()
    }

    private suspend fun fetchKickHistoryMessages(
        messageSources: List<String>,
        startTime: String,
        channelId: String? = null,
        channelLogin: String? = null,
        debugSessionKey: String? = null,
        debugPhase: String = "timeline",
        maxPages: Int = 1,
        throwOnTotalFailure: Boolean = false
    ): List<ChatMessage> {
        var lastError: Exception? = null
        var hadSuccessfulResponse = false
        for (source in messageSources) {
            try {
                val collected = mutableListOf<ChatMessage>()
                var newKickEmotesAdded = false
                var cursor: String? = null
                var page = 0
                do {
                    val requestId = kickReplayChatRequestSeq.incrementAndGet()
                    logKickReplayChat(
                        stage = "request",
                        sessionKey = debugSessionKey
                    ) {
                        "id=$requestId phase=$debugPhase source=$source startTime=$startTime cursor=${cursor ?: "-"} page=${page + 1}"
                    }
                    val response = kickRepository.getChatHistory(source, startTime, cursor)
                    hadSuccessfulResponse = true
                    val rawMessages = response.messages
                    val rawCount = rawMessages.size
                    val messages = mapKickMessages(rawMessages)
                        .sortedBy { it.timestamp }
                    logKickReplayChat(
                        stage = "response",
                        sessionKey = debugSessionKey
                    ) {
                        "id=$requestId phase=$debugPhase source=$source raw=$rawCount mapped=${messages.size} cursor=${response.cursor ?: "-"} page=${page + 1} ${messageRangeSummary(messages)}"
                    }
                    messages.forEach { message ->
                        if (addKickInlineEmotes(message.fullMsg)) {
                            newKickEmotesAdded = true
                        }
                    }
                    collected += messages
                    cursor = response.cursor?.takeIf { it.isNotBlank() }
                    page += 1
                } while (cursor != null && page < maxPages && collected.size < kickReplayPreloadMaxMessages)
                if (newKickEmotesAdded) {
                    synchronized(thirdPartyEmotes) {
                        thirdPartyEmotes.sortBy { it.source }
                    }
                    if (!reloadMessages.value) {
                        reloadMessages.value = true
                    }
                    thirdPartyEmotesUpdated.emit(Unit)
                }
                val dedupedMessages = collected
                    .distinctBy(::kickMessageKey)
                    .sortedBy { it.timestamp }
                if (dedupedMessages.isNotEmpty()) {
                    cacheKickPreferredMessageSource(source, channelId, channelLogin)
                    return dedupedMessages
                }
            } catch (e: Exception) {
                logKickReplayChat(
                    stage = "request_error",
                    sessionKey = debugSessionKey
                ) {
                    "phase=$debugPhase source=$source error=${e::class.java.simpleName}:${e.message}"
                }
                lastError = e
            }
        }
        if (hadSuccessfulResponse || !throwOnTotalFailure) {
            return emptyList()
        }
        if (lastError != null) {
            throw lastError
        }
        return emptyList()
    }

    private suspend fun fetchKickLiveHistoryMessages(
        messageSources: List<String>,
        channelId: String? = null,
        channelLogin: String? = null
    ): List<ChatMessage> {
        val debugKickRealtimeChat = BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false)
        for (source in messageSources) {
            try {
                val response = kickRepository.getLiveChatHistory(source)
                val rawMessages = response.messages
                val rawCount = rawMessages.size
                val messages = mapKickMessages(rawMessages)
                    .sortedBy { it.timestamp }
                Log.w(
                    "KickRecentChat",
                    "live history source=$source rawCount=$rawCount mappedCount=${messages.size}"
                )
                if (rawCount == 0) {
                    continue
                }
                var newKickEmotesAdded = false
                messages.forEach { message ->
                    if (addKickInlineEmotes(message.fullMsg)) {
                        newKickEmotesAdded = true
                    }
                }
                if (newKickEmotesAdded) {
                    synchronized(thirdPartyEmotes) {
                        thirdPartyEmotes.sortBy { it.source }
                    }
                    if (!reloadMessages.value) {
                        reloadMessages.value = true
                    }
                    thirdPartyEmotesUpdated.emit(Unit)
                }
                if (messages.isNotEmpty()) {
                    cacheKickPreferredMessageSource(source, channelId, channelLogin)
                    return messages
                }
            } catch (e: Exception) {
                if (debugKickRealtimeChat) {
                    Log.w("KickRecentChat", "live history source=$source fetch failed", e)
                }
            }
        }
        return emptyList()
    }

    suspend fun loadKickReplyThreadHistory(
        channelId: String?,
        channelLogin: String?,
        selectedMessage: ChatMessage,
        historyStartTimeMs: Long,
    ): List<ChatMessage> {
        if (!isKickPreferred() || channelLogin.isNullOrBlank()) {
            return emptyList()
        }
        val threadParentId = selectedMessage.reply?.threadParentId ?: selectedMessage.id ?: return emptyList()
        val resolvedChannelId = channelId?.takeIf { it.isNotBlank() }
            ?: kickRepository.getChannel(channelLogin).id?.toString()
            ?: return emptyList()
        val messageSources = resolveKickMessageSources(resolvedChannelId, channelLogin)
        val historyMessages = fetchKickMessages(
            messageSources = messageSources,
            channelId = resolvedChannelId,
            channelLogin = channelLogin
        ).ifEmpty {
            fetchKickLiveHistoryMessages(
                messageSources = messageSources,
                channelId = resolvedChannelId,
                channelLogin = channelLogin
            ).ifEmpty {
                fetchKickHistoryMessages(
                    messageSources = messageSources,
                    startTime = formatIso8601Utc(historyStartTimeMs.coerceAtLeast(0L)),
                    channelId = resolvedChannelId,
                    channelLogin = channelLogin,
                    debugPhase = "reply_thread"
                )
            }
        }
        return filterKickThreadMessages(historyMessages, selectedMessage, threadParentId)
    }

    private suspend fun emitKickMessages(messages: List<ChatMessage>): KickClipEmitStats {
        var emitted = 0
        var deduped = 0
        messages.forEach { message ->
            val key = message.id ?: "${message.timestamp}:${message.userName}:${message.message}"
            val shouldEmit = synchronized(kickMessageIds) {
                val isNew = kickMessageIds.add(key)
                if (kickMessageIds.size > 5000) {
                    kickMessageIds.iterator().apply {
                        if (hasNext()) {
                            next()
                            remove()
                        }
                    }
                }
                isNew
            }
            if (shouldEmit) {
                buildReplyPreviewMessage(message)?.let { onMessage(it) }
                onMessage(message)
                addChatter(message.userName)
                emitted += 1
            } else {
                deduped += 1
            }
        }
        return KickClipEmitStats(
            total = messages.size,
            emitted = emitted,
            deduped = deduped
        )
    }

    private suspend fun clearChatMessages(): Int {
        val size = synchronized(chatMessages) {
            val size = chatMessages.size
            chatMessages.clear()
            size
        }
        if (size > 0) {
            removeMessages.emit(size)
        }
        return size
    }

    private fun seedKickMessageIdsFromCurrentMessages() {
        synchronized(kickMessageIds) {
            kickMessageIds.clear()
            synchronized(chatMessages) {
                chatMessages.forEach { message ->
                    val key = message.id ?: "${message.timestamp}:${message.userName}:${message.message}"
                    kickMessageIds.add(key)
                }
            }
            while (kickMessageIds.size > 5000) {
                kickMessageIds.iterator().apply {
                    if (hasNext()) {
                        next()
                        remove()
                    }
                }
            }
        }
    }

    private fun startKickChat(channelId: String, channelLogin: String, channelName: String?) {
        kickLivePollingFallbackActive = true
        stopLiveChat()
        synchronized(kickMessageIds) {
            kickMessageIds.clear()
        }
        addChatter(channelName)
        kickChatJob = viewModelScope.launch {
            runCatching {
                // Warm badge URL cache before first message fetch so Kick badges can resolve immediately.
                kickRepository.getChannel(channelLogin)
            }.onFailure {
                runCatching { kickRepository.getChannel(channelId) }
            }
            val kickMessageSources = resolveKickMessageSources(channelId, channelLogin)
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_join).format(channelLogin)))
            delay(1500)
            while (currentCoroutineContext().isActive) {
                try {
                    fetchKickMessages(
                        messageSources = kickMessageSources,
                        channelId = channelId,
                        channelLogin = channelLogin
                    )
                        .forEach { message ->
                            val key = message.id ?: "${message.timestamp}:${message.userName}:${message.message}"
                            val shouldEmit = synchronized(kickMessageIds) {
                                val isNew = kickMessageIds.add(key)
                                if (kickMessageIds.size > 5000) {
                                    kickMessageIds.iterator().apply {
                                        if (hasNext()) {
                                            next()
                                            remove()
                                        }
                                    }
                                }
                                isNew
                            }
                            if (shouldEmit) {
                                buildReplyPreviewMessage(message)?.let { preview ->
                                    onMessage(preview)
                                }
                                onMessage(message)
                                addChatter(message.userName)
                            }
                        }
                } catch (e: CancellationException) {
                    throw e
                } catch (_: Exception) {

                }
                delay(2000)
            }
        }
    }

    private fun startKickReplayChat(
        channelId: String,
        channelLogin: String,
        channelName: String?,
        replayStartTimeMs: Long,
        kickReplayUrl: String?,
        getCurrentPosition: () -> Long?,
        showClipStartMarker: Boolean = true,
        forceNewSession: Boolean = false
    ) {
        val currentPlaybackPositionMs = getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
        val sessionKey = "$channelId|$replayStartTimeMs"
        val previousPlaybackPositionMs = kickReplaySessionStartPositionMs
        val largeSeek = previousPlaybackPositionMs != null &&
            kotlin.math.abs(currentPlaybackPositionMs - previousPlaybackPositionMs) > 20_000L
        val isNewSession = forceNewSession || largeSeek || kickReplaySessionKey != sessionKey
        logKickReplayChat(stage = "session_start", sessionKey = sessionKey) {
            "channelId=$channelId channelLogin=$channelLogin replayStartMs=$replayStartTimeMs " +
                "isNewSession=$isNewSession currentPositionMs=$currentPlaybackPositionMs previousPositionMs=$previousPlaybackPositionMs largeSeek=$largeSeek"
        }
        kickReplaySessionKey = sessionKey
        kickReplaySessionStartPositionMs = currentPlaybackPositionMs
        stopLiveChat()
        resetKickReplayPendingQueue()
        if (isNewSession) {
            synchronized(kickMessageIds) {
                kickMessageIds.clear()
            }
        } else {
            seedKickMessageIdsFromCurrentMessages()
        }
        addChatter(channelName)
        kickChatJob = viewModelScope.launch {
            val resolvedReplayStartTimeMs = runCatching {
                kickReplayUrl?.let { clipUrl -> kickRepository.getClipPlaylistStartTimeMs(clipUrl) }
            }.getOrNull()
            val effectiveReplayStartTimeMs = resolvedReplayStartTimeMs ?: replayStartTimeMs
            if (resolvedReplayStartTimeMs != null && resolvedReplayStartTimeMs != replayStartTimeMs) {
                logKickReplayChat(stage = "replay_start_override", sessionKey = sessionKey) {
                    "from=$replayStartTimeMs to=$resolvedReplayStartTimeMs clipUrl=$kickReplayUrl"
                }
            }
            val initialPlaybackPositionMs = currentPlaybackPositionMs
            val initialPlaybackTimestampMs = effectiveReplayStartTimeMs + initialPlaybackPositionMs
            runCatching {
                kickRepository.getChannel(channelLogin)
            }.onFailure {
            runCatching { kickRepository.getChannel(channelId) }
            }
            val kickMessageSources = resolveKickMessageSources(channelId, channelLogin)
                .map { it.trim() }
                .filter { source -> source.isNotBlank() && source.all(Char::isDigit) }
                .ifEmpty { listOf(channelId.trim()) }
            logKickReplayChat(stage = "sources", sessionKey = sessionKey) {
                "values=${kickMessageSources.joinToString(",")}"
            }
            if (isNewSession) {
                val removedMessages = clearChatMessages()
                logKickReplayChat(stage = "clear_messages", sessionKey = sessionKey) {
                    "removed=$removedMessages"
                }
                val preloadStartTime = formatIso8601Utc((initialPlaybackTimestampMs - kickReplayPreloadWindowMs).coerceAtLeast(0L))
                try {
                    val preloadMessages = fetchKickHistoryMessages(
                        messageSources = kickMessageSources,
                        startTime = preloadStartTime,
                        channelId = channelId,
                        channelLogin = channelLogin,
                        debugSessionKey = sessionKey,
                        debugPhase = "preload",
                        maxPages = 4
                    )
                        .filter { it.timestamp == null || it.timestamp < initialPlaybackTimestampMs }
                        .takeLast(kickReplayPreloadMaxMessages)
                    val stats = emitKickMessages(preloadMessages)
                    logKickReplayChat(stage = "emit", sessionKey = sessionKey) {
                        "phase=preload startPositionMs=$initialPlaybackPositionMs playbackTs=$initialPlaybackTimestampMs " +
                            "${messageRangeSummary(preloadMessages)} total=${stats.total} emitted=${stats.emitted} deduped=${stats.deduped}"
                    }
                } catch (e: CancellationException) {
                    logKickReplayChat(stage = "cancelled", sessionKey = sessionKey) {
                        "phase=preload"
                    }
                    throw e
                } catch (e: Exception) {
                    logKickReplayChat(stage = "error", sessionKey = sessionKey) {
                        "phase=preload error=${e::class.java.simpleName}:${e.message}"
                    }
                }
                if (showClipStartMarker) {
                    onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_clip_replay_starts)))
                    logKickReplayChat(stage = "marker", sessionKey = sessionKey) {
                        "type=clip_chat_start"
                    }
                }
            }
            var nextPollAtMs = 0L
            while (currentCoroutineContext().isActive) {
                try {
                    val rawPosition = getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
                    val position = rawPosition
                    val playbackTimestampMs = effectiveReplayStartTimeMs + position
                    val dueStats = emitDueKickReplayMessages(playbackTimestampMs + kickReplayEmitLeadMs)
                    if (dueStats.total > 0) {
                        logKickReplayChat(stage = "emit_due", sessionKey = sessionKey) {
                            "rawPositionMs=$rawPosition positionMs=$position playbackTs=$playbackTimestampMs total=${dueStats.total} emitted=${dueStats.emitted} deduped=${dueStats.deduped} pending=${kickReplayPendingMessages.size}"
                        }
                    }
                    val nowMs = SystemClock.elapsedRealtime()
                    if (nowMs >= nextPollAtMs) {
                        val startTime = formatIso8601Utc(playbackTimestampMs)
                        logKickReplayChat(stage = "timeline_tick", sessionKey = sessionKey) {
                            "rawPositionMs=$rawPosition positionMs=$position startTime=$startTime pending=${kickReplayPendingMessages.size}"
                        }
                        val timelineMessages = fetchKickHistoryMessages(
                            messageSources = kickMessageSources,
                            startTime = startTime,
                            channelId = channelId,
                            channelLogin = channelLogin,
                            debugSessionKey = sessionKey,
                            debugPhase = "timeline"
                        )
                        val queueStats = queueKickReplayMessages(timelineMessages)
                        if (queueStats.queued > 0 || queueStats.alreadyQueued > 0) {
                            logKickReplayChat(stage = "queue", sessionKey = sessionKey) {
                                "phase=timeline ${messageRangeSummary(timelineMessages)} total=${queueStats.total} queued=${queueStats.queued} alreadyEmitted=${queueStats.alreadyEmitted} alreadyQueued=${queueStats.alreadyQueued} pending=${kickReplayPendingMessages.size}"
                            }
                        }
                        val immediateDueStats = emitDueKickReplayMessages(playbackTimestampMs + kickReplayEmitLeadMs)
                        if (immediateDueStats.total > 0) {
                            logKickReplayChat(stage = "emit_due", sessionKey = sessionKey) {
                                "phase=post_poll positionMs=$position playbackTs=$playbackTimestampMs total=${immediateDueStats.total} emitted=${immediateDueStats.emitted} deduped=${immediateDueStats.deduped} pending=${kickReplayPendingMessages.size}"
                            }
                        }
                        nextPollAtMs = nowMs + kickReplayPollIntervalMs
                    }
                } catch (e: CancellationException) {
                    logKickReplayChat(stage = "cancelled", sessionKey = sessionKey) {
                        "phase=timeline"
                    }
                    throw e
                } catch (e: Exception) {
                    logKickReplayChat(stage = "error", sessionKey = sessionKey) {
                        "phase=timeline error=${e::class.java.simpleName}:${e.message}"
                    }
                }
                delay(kickReplayEmitIntervalMs)
            }
            logKickReplayChat(stage = "session_end", sessionKey = sessionKey) {
                "reason=job_inactive"
            }
        }
    }

    private fun getClearMessage(chatMessage: ChatMessage, deletedMessage: ChatMessage?, nameDisplay: String?): ChatMessage {
        val login = deletedMessage?.userLogin ?: chatMessage.userLogin
        val userName = if (deletedMessage?.userName != null && login != null && !login.equals(deletedMessage.userName, true)) {
            when (nameDisplay) {
                "0" -> "${deletedMessage.userName}(${login})"
                "1" -> deletedMessage.userName
                else -> login
            }
        } else {
            deletedMessage?.userName ?: login
        }
        val message = ContextCompat.getString(applicationContext, R.string.chat_clearmsg).format(userName, deletedMessage?.message ?: chatMessage.message)
        val messageIndex = message.indexOf(": ") + 2
        return ChatMessage(
            userId = deletedMessage?.userId,
            userLogin = login,
            userName = deletedMessage?.userName,
            systemMsg = message,
            emotes = deletedMessage?.emotes?.map {
                TwitchEmote(
                    id = it.id,
                    begin = it.begin + messageIndex,
                    end = it.end + messageIndex
                )
            },
            timestamp = chatMessage.timestamp,
            fullMsg = chatMessage.fullMsg
        )
    }

    private fun createDeletedMessage(chatMessage: ChatMessage): ChatMessage {
        return ChatMessage(
            id = chatMessage.id,
            userId = chatMessage.userId,
            userLogin = chatMessage.userLogin,
            userName = chatMessage.userName,
            message = chatMessage.message,
            color = chatMessage.color,
            emotes = chatMessage.emotes,
            badges = chatMessage.badges,
            isAction = chatMessage.isAction,
            isDeleted = true,
            isFirst = chatMessage.isFirst,
            bits = chatMessage.bits,
            systemMsg = chatMessage.systemMsg,
            msgId = chatMessage.msgId,
            reward = chatMessage.reward,
            reply = chatMessage.reply,
            isReply = chatMessage.isReply,
            replyParent = chatMessage.replyParent,
            timestamp = chatMessage.timestamp,
            fullMsg = chatMessage.fullMsg
        )
    }

    private suspend fun markMessageDeleted(targetId: String?): ChatMessage? {
        if (targetId.isNullOrBlank()) {
            return null
        }
        val update = synchronized(chatMessages) {
            val index = chatMessages.indexOfLast { it.id == targetId }
            if (index == -1) {
                null
            } else {
                val updatedMessage = createDeletedMessage(chatMessages[index])
                chatMessages[index] = updatedMessage
                index to updatedMessage
            }
        }
        update?.let { updateMessage.emit(it) }
        return update?.second
    }

    suspend fun onMessage(message: ChatMessage) {
        val delayMs = effectiveDelayMs()
        if (delayMs > 0L) {
            viewModelScope.launch { delay(delayMs); processMessage(message) }
        } else {
            processMessage(message)
        }
    }

    private suspend fun processMessage(message: ChatMessage) {
        synchronized(chatMessages) {
            chatMessages.add(message)
            val removeCount = if (chatMessages.size > messageLimit) {
                chatMessages.size - messageLimit
            } else 0
            if (newMessage.subscriptionCount.value > 0) {
                Triple(message, chatMessages.lastIndex, removeCount)
            } else {
                if (removeCount > 0) {
                    repeat(removeCount) {
                        chatMessages.removeAt(0)
                    }
                }
                null
            }
        }?.let {
            newMessage.emit(it)
        }
    }

    fun startLiveChat(channelId: String?, channelLogin: String) {
        stopLiveChat()
        val kickMode = isKickPreferred()
        val gqlHeaders = KickApiHelper.getGQLHeaders(applicationContext, true)
        val helixHeaders = KickApiHelper.getHelixHeaders(applicationContext)
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val enableIntegrity = applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false)
        val accountId = if (kickMode) getKickAccountId() else applicationContext.tokenPrefs().getString(C.USER_ID, null)
        val accountLogin = if (kickMode) getKickAccountLogin() else applicationContext.tokenPrefs().getString(C.USERNAME, null)
        val isLoggedIn = com.github.andreyasadchy.xtra.util.AuthStateHelper.isKickLoggedIn(applicationContext)
        val usePubSub = applicationContext.prefs().getBoolean(C.CHAT_PUBSUB_ENABLED, true)
        val showUserNotice = applicationContext.prefs().getBoolean(C.CHAT_SHOW_USERNOTICE, true)
        val showClearMsg = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARMSG, true)
        val showClearChat = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARCHAT, true)
        val nameDisplay = applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1")
        val useApiChatMessages = applicationContext.prefs().getBoolean(C.DEBUG_API_CHAT_MESSAGES, true)
        val showWebSocketDebugInfo = applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)
        if (showWebSocketDebugInfo) {
            Log.d("WebSocketRuntime", "connect chat snapshot=${WebSocketRuntime.snapshot()}")
        }
        val debugKickRealtimeChat = BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false)
        val gqlWebClientId = applicationContext.prefs().getString(C.GQL_CLIENT_ID_WEB, "kimne78kx3ncx6brgo4mv6wki5h1ko")
        if (kickMode) {
            synchronized(kickMessageIds) {
                kickMessageIds.clear()
            }
            viewModelScope.launch {
                kickRepository.getInitialPinnedGift(channelLogin, channelId)?.let { update ->
                    if (update.cleared) {
                        clearPinnedGift()
                    } else {
                        updatePinnedGift(update.pinnedGift)
                    }
                }
            }
            chatReadJob = viewModelScope.launch {
                runCatching {
                    kickRepository.getChannel(channelLogin)
                }.onFailure {
                    channelId?.takeIf { it.isNotBlank() }?.let { fallbackChannelId ->
                        runCatching { kickRepository.getChannel(fallbackChannelId) }
                    }
                }
                val fallbackId = channelId?.takeIf { it.isNotBlank() } ?: channelLogin
                val kickChatroomId = if (!channelId.isNullOrBlank()) {
                    resolveKickRealtimeChatroomId(channelId, channelLogin)
                } else {
                    fallbackId
                }
                if (debugKickRealtimeChat) {
                    Log.d("KickRealtimeChat", "resolved chatroomId=$kickChatroomId channelId=$channelId channelLogin=$channelLogin")
                }
                if (!isActive) {
                    return@launch
                }
                kickPusherChatWebSocket = KickPusherChatWebSocket(
                    chatroomId = kickChatroomId,
                    trustManager = trustManager,
                    listener = KickPusherChatListener(channelLogin, channelId, nameDisplay, showClearMsg, showClearChat),
                    debugLogging = debugKickRealtimeChat
                )
                kickPusherChatWebSocket?.connect(this)?.join()
            }
        } else if (applicationContext.prefs().getBoolean(C.DEBUG_EVENTSUB_CHAT, false) && !helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
            eventSub = EventSubWebSocket(trustManager, EventSubListener(helixHeaders, channelLogin, showUserNotice, showClearChat, usePubSub, networkLibrary, isLoggedIn, accountId, channelId))
            chatReadJob = eventSub?.connect(viewModelScope)
        } else {
            val gqlToken = gqlHeaders[C.HEADER_TOKEN]?.removePrefix("OAuth ")
            val helixToken = helixHeaders[C.HEADER_TOKEN]?.removePrefix("Bearer ")
            if (applicationContext.prefs().getBoolean(C.CHAT_USE_WEBSOCKET, true)) {
                chatReadWebSocket = ChatReadWebSocket(channelLogin, trustManager, ChatReadListener(channelLogin, nameDisplay, showUserNotice, showClearMsg, showClearChat, usePubSub, networkLibrary, isLoggedIn, accountId, channelId))
                chatReadJob = chatReadWebSocket?.connect(viewModelScope)
                if (isLoggedIn && (!gqlToken.isNullOrBlank() || !helixHeaders[C.HEADER_TOKEN].isNullOrBlank() && !useApiChatMessages)) {
                    chatWriteWebSocket = ChatWriteWebSocket(
                        userLogin = accountLogin,
                        userToken = gqlToken?.takeIf { it.isNotBlank() } ?: helixToken,
                        channelLogin = channelLogin,
                        trustManager = trustManager,
                        listener = ChatWriteListener(channelId, showWebSocketDebugInfo)
                    )
                    chatWriteJob = chatWriteWebSocket?.connect(viewModelScope)
                }
            } else {
                val useSSL = applicationContext.prefs().getBoolean(C.CHAT_USE_SSL, true)
                chatReadIRC = ChatReadIRC(useSSL, channelLogin, trustManager, ChatReadListener(channelLogin, nameDisplay, showUserNotice, showClearMsg, showClearChat, usePubSub, networkLibrary, isLoggedIn, accountId, channelId))
                chatReadJob = viewModelScope.launch(Dispatchers.IO) {
                    chatReadIRC?.start()
                }
                if (isLoggedIn && (!gqlToken.isNullOrBlank() || !helixHeaders[C.HEADER_TOKEN].isNullOrBlank() && !useApiChatMessages)) {
                    chatWriteIRC = ChatWriteIRC(
                        useSSL = useSSL,
                        userLogin = accountLogin,
                        userToken = gqlToken?.takeIf { it.isNotBlank() } ?: helixToken,
                        channelLogin = channelLogin,
                        trustManager = trustManager,
                        listener = ChatWriteListener(channelId, showWebSocketDebugInfo)
                    )
                    chatWriteJob = viewModelScope.launch(Dispatchers.IO) {
                        chatWriteIRC?.start()
                    }
                }
            }
        }
        val collectPoints = applicationContext.prefs().getBoolean(C.CHAT_POINTS_COLLECT, true)
        val throttleBackgroundActivity = applicationContext.prefs().getBoolean(C.CHAT_THROTTLE_BACKGROUND, true)
        val gqlWebToken = applicationContext.tokenPrefs().getString(C.GQL_TOKEN_WEB, null)
        val kickAccessToken = applicationContext.tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)
        val notifyPoints = applicationContext.prefs().getBoolean(C.CHAT_POINTS_NOTIFY, false)
        val showRaids = applicationContext.prefs().getBoolean(C.CHAT_RAIDS_SHOW, true)
        val showPolls = applicationContext.prefs().getBoolean(C.CHAT_POLLS_SHOW, true)
        val showPredictions = applicationContext.prefs().getBoolean(C.CHAT_PREDICTIONS_SHOW, true)

        fun connectHermes(userId: String?) {
            val subscriptionToken = when {
                enableIntegrity -> gqlHeaders[C.HEADER_TOKEN]?.removePrefix("OAuth ")
                kickMode -> kickAccessToken
                else -> gqlWebToken
            }
            hermesWebSocket = HermesWebSocket(
                channelId = channelId ?: return,
                userId = userId,
                gqlClientId = if (enableIntegrity) {
                    gqlHeaders[C.HEADER_CLIENT_ID]
                } else {
                    gqlWebClientId
                },
                gqlToken = subscriptionToken,
                collectPoints = collectPoints,
                throttleBackgroundActivity = throttleBackgroundActivity,
                showRaids = showRaids,
                showPolls = showPolls,
                showPredictions = showPredictions,
                trustManager = trustManager,
                listener = PubSubListener(channelLogin, collectPoints, notifyPoints, showRaids, showPolls, showPredictions, networkLibrary, gqlHeaders, isLoggedIn, userId, channelId, enableIntegrity, showWebSocketDebugInfo)
            )
            pubSubJob = hermesWebSocket?.connect(viewModelScope)
        }
        if (!kickMode && usePubSub && !channelId.isNullOrBlank() && (accountId.isNullOrBlank() || !collectPoints || !gqlWebToken.isNullOrBlank() || enableIntegrity)) {
            connectHermes(accountId)
        }
        if (kickMode && isLoggedIn && !channelLogin.isNullOrBlank()) {
            val liveChannelLogin = channelLogin
                ?: return
            loadKickChannelPointState(networkLibrary, gqlHeaders, channelId, channelLogin)
            if (usePubSub && !channelId.isNullOrBlank()) {
                connectHermes(accountId)
            }
            if (accountId.isNullOrBlank()) {
                viewModelScope.launch {
                    val identity = runCatching { kickRepository.ensureKickCurrentUserIdentity() }.getOrNull()
                    val liveChannelId = channelId
                    if (!identity?.id.isNullOrBlank() && !liveChannelId.isNullOrBlank()) {
                        hermesWebSocket?.disconnect(pubSubJob)
                        connectHermes(identity?.id)
                    }
                    loadKickChannelPointState(networkLibrary, gqlHeaders, channelId, liveChannelLogin)
                }
            }
        } else {
            updateChannelPointsBalance(null)
            updateChannelPointRewards(emptyList(), false)
        }
        val showNamePaints = applicationContext.prefs().getBoolean(C.CHAT_SHOW_PAINTS, true)
        val showStvBadges = applicationContext.prefs().getBoolean(C.CHAT_SHOW_STV_BADGES, true)
        val showPersonalEmotes = applicationContext.prefs().getBoolean(C.CHAT_SHOW_PERSONAL_EMOTES, true)
        val stvLiveUpdates = applicationContext.prefs().getBoolean(C.CHAT_STV_LIVE_UPDATES, true)
        if ((showNamePaints || showStvBadges || showPersonalEmotes || stvLiveUpdates) && !channelId.isNullOrBlank()) {
            val useWebp = applicationContext.prefs().getBoolean(C.CHAT_USE_WEBP, true)
            stvEventApi = StvEventApiWebSocket(
                channelId = channelId,
                trustManager = trustManager,
                listener = StvEventApiListener(useWebp, showNamePaints, showStvBadges, showPersonalEmotes, stvLiveUpdates, networkLibrary, isLoggedIn, accountId, channelId, showWebSocketDebugInfo)
            )
            stvEventApiJob = stvEventApi?.connect(viewModelScope)
            if (isLoggedIn && !accountId.isNullOrBlank()) {
                viewModelScope.launch {
                    try {
                        stvUserId = playerRepository.getStvUser(networkLibrary, accountId).takeIf { !it.isNullOrBlank() }
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }

    private fun loadKickChannelPointState(
        networkLibrary: String?,
        gqlHeaders: Map<String, String>,
        channelId: String?,
        channelLogin: String?,
    ) {
        updateChannelPointsBalance(null)
        updateChannelPointRewards(emptyList(), false)
    }

    fun stopLiveChat() {
        if (applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)) {
            Log.d("WebSocketRuntime", "disconnect chat snapshot(before)=${WebSocketRuntime.snapshot()}")
        }
        kickChatJob?.cancel()
        kickChatJob = null
        synchronized(kickMessageIds) {
            kickMessageIds.clear()
        }
        if (chatReadIRC != null) {
            MainScope().launch(Dispatchers.IO) {
                chatReadIRC?.disconnect(chatReadJob)
            }
        } else {
            if (kickPusherChatWebSocket != null) {
                MainScope().launch(Dispatchers.IO) {
                    kickPusherChatWebSocket?.disconnect(chatReadJob)
                }
            } else if (chatReadWebSocket != null) {
                MainScope().launch(Dispatchers.IO) {
                    chatReadWebSocket?.disconnect(chatReadJob)
                }
            } else {
                if (eventSub != null) {
                    MainScope().launch(Dispatchers.IO) {
                        eventSub?.disconnect(chatReadJob)
                    }
                }
            }
        }
        kickPusherChatWebSocket = null
        if (chatWriteIRC != null) {
            MainScope().launch(Dispatchers.IO) {
                chatWriteIRC?.disconnect(chatWriteJob)
            }
        } else {
            if (chatWriteWebSocket != null) {
                MainScope().launch(Dispatchers.IO) {
                    chatWriteWebSocket?.disconnect(chatWriteJob)
                }
            }
        }
        if (hermesWebSocket != null) {
            MainScope().launch(Dispatchers.IO) {
                hermesWebSocket?.disconnect(pubSubJob)
            }
        }
        if (stvEventApi != null) {
            MainScope().launch(Dispatchers.IO) {
                stvEventApi?.disconnect(stvEventApiJob)
            }
        }
        if (applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)) {
            Log.d("WebSocketRuntime", "disconnect chat snapshot(after)=${WebSocketRuntime.snapshot()}")
        }
    }

    fun isActive(): Boolean? {
        return kickChatJob?.isActive ?: chatReadJob?.isActive
    }

    fun disconnect() {
        stopLiveChat()
        kickReplaySessionKey = null
        usedRaidId = null
        raidClosed = true
        usedPollId = null
        pollClosed = true
        pollSecondsLeft.value = null
        pollTimer?.cancel()
        usedPredictionId = null
        predictionClosed = true
        predictionSecondsLeft.value = null
        predictionTimer?.cancel()
        viewModelScope.launch {
            synchronized(chatMessages) {
                val size = chatMessages.size
                chatMessages.clear()
                size
            }.let {
                removeMessages.emit(it)
            }
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.disconnected)))
        }
        if (!hideRaid.value) {
            hideRaid.value = true
        }
        if (!hidePoll.value) {
            hidePoll.value = true
        }
        if (!hidePrediction.value) {
            hidePrediction.value = true
        }
        clearPinnedGift()
        updateChannelPointsBalance(null)
        updateChannelPointRewards(emptyList(), false)
        roomState.value = RoomState("0", "-1", "0", "0", "0")
        autoReconnect = false
    }

    private inner class ChatReadListener(
        private val channelLogin: String,
        private val nameDisplay: String?,
        private val showUserNotice: Boolean,
        private val showClearMsg: Boolean,
        private val showClearChat: Boolean,
        private val usePubSub: Boolean,
        private val networkLibrary: String?,
        private val isLoggedIn: Boolean,
        private val accountId: String?,
        private val channelId: String?,
    ) : ChatReadWebSocket.Listener {
        override suspend fun onConnect() {
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_join).format(channelLogin)))
        }

        override suspend fun onChatMessage(message: String, userNotice: Boolean) {
            if (!userNotice || showUserNotice) {
                val chatMessage = ChatUtils.parseChatMessage(message, userNotice)
                if (chatMessage.reply?.message != null) {
                    buildReplyPreviewMessage(chatMessage)?.let { onMessage(it) }
                }
                if (usePubSub && chatMessage.reward != null && !chatMessage.reward.id.isNullOrBlank()) {
                    onRewardMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
                } else {
                    onChatMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
                }
            }
        }

        override suspend fun onClearMessage(message: String) {
            if (showClearMsg) {
                val result = ChatUtils.parseClearMessage(message)
                val chatMessage = result.first
                val targetId = result.second
                val deletedMessage = markMessageDeleted(targetId)
                if (deletedMessage == null) {
                    val clearMessage = getClearMessage(chatMessage, null, nameDisplay)
                    onMessage(clearMessage)
                }
            }
        }

        override suspend fun onClearChat(message: String) {
            if (showClearChat) {
                onMessage(ChatUtils.parseClearChat(applicationContext, message))
            }
        }

        override suspend fun onNotice(message: String) {
            if (!isLoggedIn) {
                val result = ChatUtils.parseNotice(applicationContext, message)
                val chatMessage = result.first
                val messageId = result.second
                onMessage(chatMessage)
                if (messageId == "unraid_success") {
                    if (!hideRaid.value) {
                        hideRaid.value = true
                    }
                }
            }
        }

        override suspend fun onRoomState(message: String) {
            roomState.value = ChatUtils.parseRoomState(message)
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            onMessage(ChatMessage(
                systemMsg = ContextCompat.getString(applicationContext, R.string.chat_disconnect).format(channelLogin, message),
                fullMsg = fullMsg
            ))
        }
    }

    private inner class KickPusherChatListener(
        private val channelLogin: String,
        private val channelId: String?,
        private val nameDisplay: String?,
        private val showClearMsg: Boolean,
        private val showClearChat: Boolean,
    ) : KickPusherChatWebSocket.Listener {
        override suspend fun onConnect() {
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_join).format(channelLogin)))
        }

        override suspend fun onChatEvent(eventName: String, messageJson: String) {
            kickRepository.parsePinnedGiftUpdate(eventName, messageJson)?.let { update ->
                if (update.cleared) {
                    clearPinnedGift()
                } else {
                    updatePinnedGift(update.pinnedGift)
                }
            }
            val realtimeMessage = parseKickRealtimeMessage(eventName, messageJson) ?: return
            val kickMessage = realtimeMessage.message
            val chatMessage = kickRepository.toChatMessage(kickMessage, realtimeMessage.eventName)
            if (chatMessage.message.isNullOrBlank() && chatMessage.systemMsg.isNullOrBlank()) {
                return
            }
            if (kickRepository.isKickSingleMessageDelete(kickMessage, realtimeMessage.eventName)) {
                if (!showClearMsg) {
                    return
                }
                val targetId = kickRepository.getKickModerationTargetMessageId(kickMessage)
                val deletedMessage = markMessageDeleted(targetId)
                if (deletedMessage == null) {
                    onMessage(getClearMessage(chatMessage, null, nameDisplay))
                }
                return
            }
            if (chatMessage.msgId == "kick_moderation" && !showClearChat) {
                return
            }
            var newKickEmotesAdded = false
            if (addKickInlineEmotes(chatMessage.fullMsg)) {
                newKickEmotesAdded = true
            }
            if (newKickEmotesAdded) {
                userEmotesUpdated.emit(Unit)
            }
            emitKickMessages(listOf(chatMessage))
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            val isHostResolutionFailure = WebSocketDisconnectUtils.isHostResolutionFailure(message)
            val shouldEmitDisconnect = shouldEmitKickRealtimeDisconnect(message)
            if (!isHostResolutionFailure && shouldEmitDisconnect) {
                onMessage(
                    ChatMessage(
                        systemMsg = ContextCompat.getString(applicationContext, R.string.chat_disconnect).format(channelLogin, message),
                        fullMsg = fullMsg
                    )
                )
            }
            if (!channelLogin.isBlank() && autoReconnect && !isHostResolutionFailure) {
                viewModelScope.launch {
                    delay(3000)
                    if (chatReadJob?.isActive != true) {
                        startLiveChat(channelId, channelLogin)
                    }
                }
            }
        }
    }

    private fun shouldEmitKickRealtimeDisconnect(message: String): Boolean {
        val now = System.currentTimeMillis()
        val sameAsLast = kickRealtimeLastDisconnectMessage == message
        val recent = now - kickRealtimeLastDisconnectAtMs < 15_000L
        if (sameAsLast && recent) {
            return false
        }
        kickRealtimeLastDisconnectMessage = message
        kickRealtimeLastDisconnectAtMs = now
        return true
    }

    private fun parseKickRealtimeMessage(eventName: String?, messageJson: String): KickRealtimeMessage? {
        fun decodeCandidate(raw: String?): KickMessage? {
            if (raw.isNullOrBlank()) return null
            return runCatching { json.decodeFromString<KickMessage>(raw) }.getOrNull()
        }
        decodeCandidate(messageJson)?.let { return KickRealtimeMessage(eventName, it) }
        val root = runCatching { JSONObject(messageJson) }.getOrNull() ?: return null
        val candidates = mutableListOf<String>()
        fun addObj(obj: JSONObject?) {
            if (obj != null) candidates.add(obj.toString())
        }
        addObj(root)
        addObj(root.optJSONObject("data"))
        addObj(root.optJSONObject("message"))
        addObj(root.optJSONObject("payload"))
        val dataRaw = root.opt("data")
        if (dataRaw is String) {
            addObj(runCatching { JSONObject(dataRaw) }.getOrNull())
            val arr = runCatching { JSONArray(dataRaw) }.getOrNull()
            if (arr != null) {
                for (i in 0 until arr.length()) {
                    addObj(arr.optJSONObject(i))
                }
            }
        }
        val payload = root.optJSONObject("payload")
        addObj(payload?.optJSONObject("data"))
        for (candidate in candidates) {
            decodeCandidate(candidate)?.let { return KickRealtimeMessage(eventName, it) }
        }
        return null
    }

    private inner class ChatWriteListener(
        private val channelId: String?,
        private val showWebSocketDebugInfo: Boolean,
    ) : ChatReadWebSocket.Listener {
        override suspend fun onConnect() {
            if (showWebSocketDebugInfo) {
                onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_connected).format("Chat write socket")))
            }
        }

        override suspend fun onNotice(message: String) {
            val result = ChatUtils.parseNotice(applicationContext, message)
            val chatMessage = result.first
            val messageId = result.second
            onMessage(chatMessage)
            if (messageId == "unraid_success") {
                if (!hideRaid.value) {
                    hideRaid.value = true
                }
            }
        }

        override suspend fun onUserState(message: String) {
            val emoteSets = ChatUtils.parseEmoteSets(message)
            if (emoteSets != null && savedEmoteSets != emoteSets) {
                savedEmoteSets = emoteSets
                if (!loadedUserEmotes) {
                    loadEmoteSets(channelId)
                }
            }
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            if (showWebSocketDebugInfo) {
                onMessage(ChatMessage(
                    systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_disconnected).format("Chat write socket", message),
                    fullMsg = fullMsg
                ))
            }
        }
    }

    private inner class EventSubListener(
        private val helixHeaders: Map<String, String>,
        private val channelLogin: String,
        private val showUserNotice: Boolean,
        private val showClearChat: Boolean,
        private val usePubSub: Boolean,
        private val networkLibrary: String?,
        private val isLoggedIn: Boolean,
        private val accountId: String?,
        private val channelId: String?,
    ) : EventSubWebSocket.Listener {
        override suspend fun onConnect() {
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_join).format(channelLogin)))
        }

        override suspend fun onWelcomeMessage(sessionId: String) {
            listOf(
                "channel.chat.clear",
                "channel.chat.message",
                "channel.chat.notification",
                "channel.chat_settings.update",
            ).forEach {
                viewModelScope.launch {
                    try {
                        helixRepository.createEventSubSubscription(networkLibrary, helixHeaders, accountId, channelId, it, sessionId)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    } catch (e: Exception) {

                    }
                }
            }
        }

        override suspend fun onChatMessage(event: JSONObject, timestamp: String?) {
            val chatMessage = EventSubUtils.parseChatMessage(event, timestamp)
            if (usePubSub && chatMessage.reward != null && !chatMessage.reward.id.isNullOrBlank()) {
                onRewardMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
            } else {
                onChatMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
            }
        }

        override suspend fun onUserNotice(event: JSONObject, timestamp: String?) {
            if (showUserNotice) {
                onChatMessage(EventSubUtils.parseUserNotice(event, timestamp), networkLibrary, isLoggedIn, accountId, channelId)
            }
        }

        override suspend fun onClearChat(event: JSONObject, timestamp: String?) {
            if (showClearChat && chatReadIRC == null && chatReadWebSocket == null) {
                onMessage(EventSubUtils.parseClearChat(applicationContext, event, timestamp))
            }
        }

        override suspend fun onRoomState(event: JSONObject, timestamp: String?) {
            roomState.value = EventSubUtils.parseRoomState(event)
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            onMessage(ChatMessage(
                systemMsg = ContextCompat.getString(applicationContext, R.string.chat_disconnect).format(channelLogin, message),
                fullMsg = fullMsg
            ))
        }
    }

    private inner class PubSubListener(
        private val channelLogin: String,
        private val collectPoints: Boolean,
        private val notifyPoints: Boolean,
        private val showRaids: Boolean,
        private val showPolls: Boolean,
        private val showPredictions: Boolean,
        private val networkLibrary: String?,
        private val gqlHeaders: Map<String, String>,
        private val isLoggedIn: Boolean,
        private val accountId: String?,
        private val channelId: String?,
        private val enableIntegrity: Boolean,
        private val showWebSocketDebugInfo: Boolean,
    ) : HermesWebSocket.Listener {
        override suspend fun onConnect() {
            if (showWebSocketDebugInfo) {
                onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_connected).format("PubSub")))
            }
        }

        override suspend fun onPlaybackMessage(message: JSONObject) {
            val playbackMessage = PubSubUtils.parsePlaybackMessage(message)
            if (playbackMessage != null) {
                playbackMessage.live?.let {
                    if (it) {
                        onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.stream_live).format(channelLogin)))
                    } else {
                        onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.stream_offline).format(channelLogin)))
                    }
                }
                _playbackMessage.value = playbackMessage
            }
        }

        override suspend fun onStreamInfo(message: JSONObject) {
            _streamInfo.value = PubSubUtils.parseStreamInfo(message)
        }

        override suspend fun onRewardMessage(message: JSONObject) {
            val chatMessage = PubSubUtils.parseRewardMessage(message)
            if (!accountId.isNullOrBlank() && chatMessage.userId == accountId) {
                updateChannelPointsBalance(
                    channelPointsBalance.value?.let { balance ->
                        chatMessage.reward?.cost?.let { cost -> (balance - cost).coerceAtLeast(0) } ?: balance
                    }
                )
            }
            if (!chatMessage.message.isNullOrBlank()) {
                onRewardMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
            } else {
                onChatMessage(chatMessage, networkLibrary, isLoggedIn, accountId, channelId)
            }
        }

        override suspend fun onPointsEarned(message: JSONObject) {
            val result = PubSubUtils.parsePointsEarned(message)
            val points = result.first
            val messageChannelId = result.second
            if (channelId == messageChannelId) {
                updateChannelPointsBalance(
                    channelPointsBalance.value?.let { current ->
                        (current + (points.pointsGained ?: 0)).coerceAtLeast(0)
                    } ?: points.pointsGained
                )
                if (notifyPoints) {
                    onMessage(ChatMessage(
                        systemMsg = ContextCompat.getString(applicationContext, R.string.points_earned).format(points.pointsGained),
                        timestamp = points.timestamp,
                        fullMsg = points.fullMsg
                    ))
                }
            }
        }

        override suspend fun onClaimAvailable() {
            if (collectPoints) {
                if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        try {
                            val response = graphQLRepository.loadChannelPointsContext(networkLibrary, gqlHeaders, channelLogin)
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                            response.data?.community?.channel?.self?.communityPoints?.availableClaim?.id?.let { claimId ->
                                val claimResponse = graphQLRepository.loadClaimPoints(networkLibrary, gqlHeaders, channelId, claimId)
                                if (enableIntegrity && integrity.value == null) {
                                    claimResponse.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }
                            response.data?.community?.channel?.self?.communityPoints?.balance?.let {
                                updateChannelPointsBalance(it)
                            }
                        } catch (e: Exception) {

                        }
                    }
                }
            }
        }

        override suspend fun onMinuteWatched() {
            if (!streamId.isNullOrBlank()) {
                try {
                    playerRepository.sendMinuteWatched(networkLibrary, accountId, streamId, channelId, channelLogin)
                } catch (e: Exception) {

                }
            }
        }

        override suspend fun onRaidUpdate(message: JSONObject, openStream: Boolean) {
            if (showRaids) {
                PubSubUtils.onRaidUpdate(message, openStream)?.let {
                    if (it.raidId != usedRaidId) {
                        usedRaidId = it.raidId
                        raidClosed = false
                        if (collectPoints && !gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            viewModelScope.launch {
                                try {
                                    val response = graphQLRepository.loadJoinRaid(networkLibrary, gqlHeaders, it.raidId)
                                    if (enableIntegrity && integrity.value == null) {
                                        response.errors?.find { it.message == "failed integrity check" }?.let {
                                            integrity.value = "refresh"
                                            return@launch
                                        }
                                    }
                                } catch (e: Exception) {

                                }
                            }
                        }
                    }
                    raid.value = it
                }
            }
        }

        override suspend fun onPollUpdate(message: JSONObject) {
            if (showPolls) {
                PubSubUtils.onPollUpdate(message)?.let {
                    if (it.id != usedPollId) {
                        usedPollId = it.id
                        pollClosed = false
                        pollTimeoutJob?.cancel()
                        if (it.remainingMilliseconds != null) {
                            val secondsLeft = it.remainingMilliseconds / 1000
                            if (secondsLeft > 0) {
                                pollSecondsLeft.value = secondsLeft
                                pollTimer?.cancel()
                                pollTimer = Timer().apply {
                                    scheduleAtFixedRate(1000, 1000) {
                                        val seconds = pollSecondsLeft.value
                                        if (seconds != null) {
                                            pollSecondsLeft.value = seconds - 1
                                            if (seconds <= 1) {
                                                this@apply.cancel()
                                            }
                                        } else {
                                            this@apply.cancel()
                                        }
                                    }
                                }
                            }
                        }
                    } else if (it.status == "COMPLETED" || it.status == "TERMINATED") {
                        pollClosed = false
                    }
                    poll.value = it
                }
            }
        }

        override suspend fun onPredictionUpdate(message: JSONObject) {
            if (showPredictions) {
                PubSubUtils.onPredictionUpdate(message)?.let {
                    if (it.id != usedPredictionId) {
                        usedPredictionId = it.id
                        predictionClosed = false
                        predictionTimeoutJob?.cancel()
                        if (it.createdAt != null && it.predictionWindowSeconds != null) {
                            val secondsLeft = ((((it.createdAt + (it.predictionWindowSeconds * 1000)) - System.currentTimeMillis())) / 1000).toInt()
                            if (secondsLeft > 0) {
                                predictionSecondsLeft.value = secondsLeft
                                predictionTimer?.cancel()
                                predictionTimer = Timer().apply {
                                    scheduleAtFixedRate(1000, 1000) {
                                        val seconds = predictionSecondsLeft.value
                                        if (seconds != null) {
                                            predictionSecondsLeft.value = seconds - 1
                                            if (seconds <= 1) {
                                                this@apply.cancel()
                                            }
                                        } else {
                                            this@apply.cancel()
                                        }
                                    }
                                }
                            }
                        }
                    } else if (it.status == "LOCKED" || it.status == "CANCEL_PENDING" || it.status == "RESOLVE_PENDING") {
                        predictionClosed = false
                    }
                    prediction.value = it
                }
            }
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            if (showWebSocketDebugInfo && !WebSocketDisconnectUtils.isHostResolutionFailure(message)) {
                onMessage(ChatMessage(
                    systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_disconnected).format("PubSub", message),
                    fullMsg = fullMsg
                ))
            }
        }
    }

    private inner class StvEventApiListener(
        private val useWebp: Boolean,
        private val showNamePaints: Boolean,
        private val showStvBadges: Boolean,
        private val showPersonalEmotes: Boolean,
        private val stvLiveUpdates: Boolean,
        private val networkLibrary: String?,
        private val isLoggedIn: Boolean,
        private val accountId: String?,
        private val channelId: String?,
        private val showWebSocketDebugInfo: Boolean,
    ) : StvEventApiWebSocket.Listener {
        override suspend fun onConnect() {
            if (showWebSocketDebugInfo) {
                onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_connected).format("7TV Event API")))
            }
        }

        override suspend fun onEmoteSetUpdate(body: JSONObject) {
            val result = StvEventApiUtils.parseEmoteSetUpdate(body, useWebp, channelStvEmoteSetId)
            if (result != null) {
                if (result.channelSet) {
                    if (stvLiveUpdates) {
                        val removedEmotes = (result.removed + result.updated.map { it.first }).map { it.name }
                        val newEmotes = result.added + result.updated.map { it.second }
                        synchronized(thirdPartyEmotes) {
                            thirdPartyEmotes.removeAll { it.name in removedEmotes }
                            thirdPartyEmotes.addAll(newEmotes)
                        }
                        if (!reloadMessages.value) {
                            reloadMessages.value = true
                        }
                        viewModelScope.launch {
                            thirdPartyEmotesUpdated.emit(Unit)
                        }
                        synchronized(allEmotes) {
                            allEmotes.removeAll { it in removedEmotes }
                            allEmotes.addAll(newEmotes.filter { it.name !in allEmotes }.mapNotNull { it.name })
                        }
                    }
                } else {
                    if (showPersonalEmotes) {
                        val removedEmotes = (result.removed + result.updated.map { it.first }).map { it.name }
                        synchronized(personalEmoteSets) {
                            val existingSet = personalEmoteSets[result.setId]?.filter { it.name !in removedEmotes } ?: emptyList()
                            personalEmoteSets.remove(result.setId)
                            val set = existingSet + result.added + result.updated.map { it.second }
                            personalEmoteSets[result.setId] = set
                        }
                        if (isLoggedIn && !accountId.isNullOrBlank() && result.setId == userStvEmoteSetId) {
                            viewModelScope.launch {
                                thirdPartyEmotesUpdated.emit(Unit)
                            }
                        }
                    }
                }
            }
        }

        override suspend fun onCosmetic(body: JSONObject) {
            val result = StvEventApiUtils.parseCosmetic(body, useWebp)
            if (result != null) {
                when (result) {
                    is StvEventApiUtils.Cosmetic.Paint -> {
                        if (showNamePaints) {
                            synchronized(namePaints) {
                                namePaints.find { it.id == result.paint.id }?.let { namePaints.remove(it) }
                                namePaints.add(result.paint)
                            }
                        }
                    }
                    is StvEventApiUtils.Cosmetic.Badge -> {
                        if (showStvBadges) {
                            synchronized(stvBadges) {
                                stvBadges.find { it.id == result.badge.id }?.let { stvBadges.remove(it) }
                                stvBadges.add(result.badge)
                            }
                        }
                    }
                }
            }
        }

        override suspend fun onEntitlement(body: JSONObject) {
            val result = StvEventApiUtils.parseEntitlement(body)
            if (result != null) {
                when (result) {
                    is StvEventApiUtils.Entitlement.Paint -> {
                        if (showNamePaints) {
                            synchronized(stvUsers) {
                                val user = stvUsers.find { it.userId == result.userId }
                                if (user != null) {
                                    if (user.paintId != result.paintId) {
                                        user.paintId = result.paintId
                                        true
                                    } else false
                                } else {
                                    stvUsers.add(StvUser(
                                        userId = result.userId,
                                        paintId = result.paintId
                                    ))
                                    true
                                }
                            }.let {
                                if (it) {
                                    updateUserMessages.emit(result.userId)
                                }
                            }
                        }
                    }
                    is StvEventApiUtils.Entitlement.Badge -> {
                        if (showStvBadges) {
                            synchronized(stvUsers) {
                                val user = stvUsers.find { it.userId == result.userId }
                                if (user != null) {
                                    if (user.badgeId != result.badgeId) {
                                        user.badgeId = result.badgeId
                                        true
                                    } else false
                                } else {
                                    stvUsers.add(StvUser(
                                        userId = result.userId,
                                        badgeId = result.badgeId
                                    ))
                                    true
                                }
                            }.let {
                                if (it) {
                                    updateUserMessages.emit(result.userId)
                                }
                            }
                        }
                    }
                    is StvEventApiUtils.Entitlement.EmoteSet -> {
                        if (showPersonalEmotes) {
                            synchronized(stvUsers) {
                                val user = stvUsers.find { it.userId == result.userId }
                                if (user != null) {
                                    if (user.emoteSetId != result.setId) {
                                        user.emoteSetId = result.setId
                                        true
                                    } else false
                                } else {
                                    stvUsers.add(StvUser(
                                        userId = result.userId,
                                        emoteSetId = result.setId
                                    ))
                                    true
                                }
                            }.let {
                                if (it) {
                                    updateUserMessages.emit(result.userId)
                                }
                            }
                            if (isLoggedIn && !accountId.isNullOrBlank() && result.userId == accountId) {
                                userStvEmoteSetId = result.setId
                                viewModelScope.launch {
                                    thirdPartyEmotesUpdated.emit(Unit)
                                }
                            }
                        }
                    }
                }
            }
        }

        override suspend fun onUpdatePresence(sessionId: String) {
            onUpdatePresence(networkLibrary, sessionId, channelId, true)
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            if (showWebSocketDebugInfo) {
                onMessage(ChatMessage(
                    systemMsg = ContextCompat.getString(applicationContext, R.string.websocket_disconnected).format("7TV Event API", message),
                    fullMsg = fullMsg
                ))
            }
        }
    }

    private suspend fun onChatMessage(message: ChatMessage, networkLibrary: String?, isLoggedIn: Boolean, accountId: String?, channelId: String?) {
        onMessage(message)
        addChatter(message.userName)
        if (isLoggedIn && !accountId.isNullOrBlank() && message.userId == accountId) {
            onUpdatePresence(networkLibrary, null, channelId, false)
        }
    }

    private fun addChatter(displayName: String?) {
        if (displayName != null && !chatters.containsKey(displayName)) {
            val chatter = Chatter(displayName)
            chatters[displayName] = chatter
            synchronized(autoCompleteList) {
                autoCompleteList.add(chatter)
            }
        }
    }

    private fun onUpdatePresence(networkLibrary: String?, sessionId: String?, channelId: String?, self: Boolean) {
        stvUserId?.let { stvUserId ->
            if (stvUserId.isNotBlank() && !channelId.isNullOrBlank() && (self && !sessionId.isNullOrBlank() || !self) &&
                stvLastPresenceUpdate?.let { (System.currentTimeMillis() - it) > 10000 } != false) {
                stvLastPresenceUpdate = System.currentTimeMillis()
                viewModelScope.launch {
                    try {
                        playerRepository.sendStvPresence(networkLibrary, stvUserId, channelId, sessionId, self)
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }

    private suspend fun onRewardMessage(message: ChatMessage, networkLibrary: String?, isLoggedIn: Boolean, accountId: String?, channelId: String?) {
        val enrichedMessage = message.reward?.id?.let { rewardId ->
            channelPointRewards.value.find { it.id == rewardId }?.let { knownReward ->
                ChatMessage(
                    id = message.id,
                    userId = message.userId,
                    userLogin = message.userLogin,
                    userName = message.userName,
                    message = message.message,
                    color = message.color,
                    emotes = message.emotes,
                    badges = message.badges,
                    isAction = message.isAction,
                    isFirst = message.isFirst,
                    bits = message.bits,
                    systemMsg = message.systemMsg,
                    msgId = message.msgId,
                    reward = ChannelPointReward(
                        id = rewardId,
                        title = message.reward?.title ?: knownReward.title,
                        cost = message.reward?.cost ?: knownReward.cost,
                        url1x = message.reward?.url1x ?: knownReward.url1x,
                        url2x = message.reward?.url2x ?: knownReward.url2x,
                        url4x = message.reward?.url4x ?: knownReward.url4x,
                        backgroundColor = message.reward?.backgroundColor ?: knownReward.backgroundColor,
                        isEnabled = message.reward?.isEnabled ?: knownReward.isEnabled,
                        isUserInputRequired = message.reward?.isUserInputRequired ?: knownReward.isUserInputRequired,
                        prompt = message.reward?.prompt ?: knownReward.prompt,
                    ),
                    reply = message.reply,
                    isReply = message.isReply,
                    replyParent = message.replyParent,
                    timestamp = message.timestamp,
                    fullMsg = message.fullMsg,
                )
            }
        } ?: message
        if (enrichedMessage.reward?.id != null) {
            synchronized(rewardList) {
                val item = rewardList.find { it.reward?.id == enrichedMessage.reward.id && it.userId == enrichedMessage.userId }
                if (item != null) {
                    rewardList.remove(item)
                    item
                } else {
                    rewardList.add(enrichedMessage)
                    null
                }
            }.let { item ->
                if (item != null) {
                    onChatMessage(ChatMessage(
                        id = enrichedMessage.id ?: item.id,
                        userId = enrichedMessage.userId ?: item.userId,
                        userLogin = enrichedMessage.userLogin ?: item.userLogin,
                        userName = enrichedMessage.userName ?: item.userName,
                        message = enrichedMessage.message ?: item.message,
                        color = enrichedMessage.color ?: item.color,
                        emotes = enrichedMessage.emotes ?: item.emotes,
                        badges = enrichedMessage.badges ?: item.badges,
                        isAction = enrichedMessage.isAction || item.isAction,
                        isFirst = enrichedMessage.isFirst || item.isFirst,
                        bits = enrichedMessage.bits ?: item.bits,
                        systemMsg = enrichedMessage.systemMsg ?: item.systemMsg,
                        msgId = enrichedMessage.msgId ?: item.msgId,
                        reward = ChannelPointReward(
                            id = enrichedMessage.reward.id,
                            title = enrichedMessage.reward.title ?: item.reward?.title,
                            cost = enrichedMessage.reward.cost ?: item.reward?.cost,
                            url1x = enrichedMessage.reward.url1x ?: item.reward?.url1x,
                            url2x = enrichedMessage.reward.url2x ?: item.reward?.url2x,
                            url4x = enrichedMessage.reward.url4x ?: item.reward?.url4x,
                            backgroundColor = enrichedMessage.reward.backgroundColor ?: item.reward?.backgroundColor,
                            isEnabled = enrichedMessage.reward.isEnabled ?: item.reward?.isEnabled,
                            isUserInputRequired = enrichedMessage.reward.isUserInputRequired ?: item.reward?.isUserInputRequired,
                            prompt = enrichedMessage.reward.prompt ?: item.reward?.prompt,
                        ),
                        timestamp = enrichedMessage.timestamp ?: item.timestamp,
                        fullMsg = enrichedMessage.fullMsg ?: item.fullMsg,
                    ), networkLibrary, isLoggedIn, accountId, channelId)
                }
            }
        } else {
            onChatMessage(enrichedMessage, networkLibrary, isLoggedIn, accountId, channelId)
        }
    }

    private fun loadEmoteSets(channelId: String?) {
        val helixHeaders = KickApiHelper.getHelixHeaders(applicationContext)
        if (!savedEmoteSets.isNullOrEmpty() && !helixHeaders[C.HEADER_CLIENT_ID].isNullOrBlank() && !helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
            viewModelScope.launch {
                try {
                    val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
                    val animateGifs =  applicationContext.prefs().getBoolean(C.ANIMATED_EMOTES, true)
                    val emotes = mutableListOf<TwitchEmote>()
                    savedEmoteSets?.chunked(25)?.forEach { list ->
                        playerRepository.loadEmotesFromSet(networkLibrary, helixHeaders, list, animateGifs).let { emotes.addAll(it) }
                    }
                    if (emotes.isNotEmpty()) {
                        val sorted = emotes.sortedByDescending { it.setId }
                        savedUserEmotes = sorted
                        synchronized(userEmotes) {
                            userEmotes.clear()
                            userEmotes.addAll(
                                sorted.sortedByDescending { it.ownerId == channelId }.map {
                                    Emote(
                                        name = it.name,
                                        url1x = it.url1x,
                                        url2x = it.url2x,
                                        url3x = it.url3x,
                                        url4x = it.url4x,
                                        format = it.format
                                    )
                                }
                            )
                        }
                        userEmotesUpdated.emit(Unit)
                        synchronized(allEmotes) {
                            allEmotes.addAll(sorted.filter { it.name !in allEmotes }.mapNotNull { it.name })
                        }
                    }
                } catch (e: Exception) {

                }
            }
        }
    }

    fun startPollTimeout(hide: () -> Unit) {
        pollTimeoutJob?.cancel()
        pollTimeoutJob = viewModelScope.launch {
            delay(20000)
            hide()
        }
    }

    fun startPredictionTimeout(hide: () -> Unit) {
        predictionTimeoutJob?.cancel()
        predictionTimeoutJob = viewModelScope.launch {
            delay(20000)
            hide()
        }
    }

    fun send(message: CharSequence, replyId: String?, networkLibrary: String?, gqlHeaders: Map<String, String>, helixHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiCommands: Boolean, useApiChatMessages: Boolean, enableIntegrity: Boolean) {
        if (replyId != null) {
            sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity, replyId)
        } else {
            if (useApiCommands) {
                if (message.toString().startsWith("/")) {
                    try {
                        sendCommand(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    } catch (e: Exception) {

                    }
                } else {
                    sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                }
            } else {
                if (message.toString() == "/dc" || message.toString() == "/disconnect") {
                    disconnect()
                } else {
                    sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                }
            }
        }
    }

    private fun sendMessage(message: CharSequence, networkLibrary: String?, gqlHeaders: Map<String, String>, helixHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiChatMessages: Boolean, enableIntegrity: Boolean, replyId: String? = null) {
        try {
            viewModelScope.launch {
                if (isKickPreferred()) {
                    val accessToken = applicationContext.tokenPrefs().getString(C.KICK_ACCESS_TOKEN, null)
                    val broadcasterId = resolveKickBroadcasterUserId(channelId, channelLogin)
                    if (!accessToken.isNullOrBlank() && broadcasterId != null) {
                        runCatching {
                            kickRepository.sendChatMessage(accessToken, broadcasterId, message.toString(), replyId)
                        }.onFailure {
                            onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, it.message)))
                        }
                    } else {
                        val reason = if (accessToken.isNullOrBlank()) {
                            "missing kick auth scope"
                        } else {
                            "missing kick broadcaster user id"
                        }
                        onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, reason)))
                    }
                    return@launch
                }
                if (useApiChatMessages) {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.sendMessage(networkLibrary, gqlHeaders, channelId, message.toString(), replyId).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.sendMessage(networkLibrary, helixHeaders, accountId, channelId, message.toString(), replyId)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                } else {
                    chatWriteIRC?.send(message, replyId) ?: chatWriteWebSocket?.send(message, replyId)
                }
            }
        } catch (e: Exception) {

        }
        val usedEmotes = hashSetOf<RecentEmote>()
        val currentTime = System.currentTimeMillis()
        synchronized(allEmotes) {
            message.split(' ').forEach { word ->
                allEmotes.find { it == word }?.let { usedEmotes.add(RecentEmote(word, currentTime)) }
            }
        }
        if (usedEmotes.isNotEmpty()) {
            viewModelScope.launch {
                playerRepository.insertRecentEmotes(usedEmotes)
            }
        }
    }

    private fun sendCommand(message: CharSequence, networkLibrary: String?, gqlHeaders: Map<String, String>, helixHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiChatMessages: Boolean, enableIntegrity: Boolean) {
        val command = message.toString().substringBefore(" ")
        when {
            command.startsWith("/announce", true) -> {
                val splits = message.split(" ", limit = 2)
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.sendAnnouncement(networkLibrary, gqlHeaders, channelId, splits[1], splits[0].substringAfter("/announce", "").ifBlank { null }).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                helixRepository.sendAnnouncement(networkLibrary, helixHeaders, channelId, accountId, splits[1], splits[0].substringAfter("/announce", "").ifBlank { null })
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/ban", true) -> {
                val splits = message.split(" ", limit = 3)
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.banUser(networkLibrary, gqlHeaders, channelId, splits[1],
                                reason = if (splits.size >= 3) splits[2] else null
                            ).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.banUser(networkLibrary, helixHeaders, channelId, accountId, targetId,
                                    reason = if (splits.size >= 3) splits[2] else null
                                )
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/unban", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.unbanUser(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.unbanUser(networkLibrary, helixHeaders, channelId, accountId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/clear", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        helixRepository.deleteMessages(networkLibrary, helixHeaders, channelId, accountId)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/color", true) -> {
                val splits = message.split(" ")
                viewModelScope.launch {
                    if (splits.size >= 2) {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.updateChatColor(networkLibrary, gqlHeaders, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                helixRepository.updateChatColor(networkLibrary, helixHeaders, accountId, splits[1])
                            } else null
                        }
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.getChatColor(networkLibrary, helixHeaders, accountId)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/commercial", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    val splits = message.split(" ")
                    if (splits.size >= 2) {
                        viewModelScope.launch {
                            helixRepository.startCommercial(networkLibrary, helixHeaders, channelId, splits[1])?.let {
                                onMessage(ChatMessage(systemMsg = it))
                            }
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/delete", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    val splits = message.split(" ")
                    if (splits.size >= 2) {
                        viewModelScope.launch {
                            helixRepository.deleteMessages(networkLibrary, helixHeaders, channelId, accountId, splits[1])?.let {
                                onMessage(ChatMessage(systemMsg = it))
                            }
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/disconnect", true) -> disconnect()
            command.equals("/emoteonly", true) -> {
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.updateChatSettings(networkLibrary, gqlHeaders, channelId, emote = true).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, emote = true)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/emoteonlyoff", true) -> {
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.updateChatSettings(networkLibrary, gqlHeaders, channelId, emote = false).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, emote = false)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/followers", true) -> {
                val splits = message.split(" ")
                val duration = if (splits.size >= 2) splits[1].toIntOrNull() else null
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.setFollowersOnlyMode(networkLibrary, gqlHeaders, channelId, duration ?: 0).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId,
                                followers = true,
                                followersDuration = duration
                            )
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/followersoff", true) -> {
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.setFollowersOnlyMode(networkLibrary, gqlHeaders, channelId, -1).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, followers = false)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/marker", true) -> {
                val splits = message.split(" ", limit = 2)
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.createStreamMarker(networkLibrary, gqlHeaders, channelLogin).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.createStreamMarker(networkLibrary, helixHeaders, channelId, if (splits.size >= 2) splits[1] else null)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/mod", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.addModerator(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.addModerator(networkLibrary, helixHeaders, channelId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/unmod", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.removeModerator(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.removeModerator(networkLibrary, helixHeaders, channelId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/mods", true) -> {
                viewModelScope.launch {
                    graphQLRepository.getModerators(networkLibrary, gqlHeaders, channelLogin).also { response ->
                        if (enableIntegrity && integrity.value == null) {
                            response.errors?.find { it.message == "failed integrity check" }?.let {
                                integrity.value = "refresh"
                                return@launch
                            }
                        }
                    }.let {
                        onMessage(ChatMessage(systemMsg = it.data?.user?.mods?.edges?.map { it.node.login }?.toString() ?: it.toString()))
                    }
                }
            }
            command.equals("/raid", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            val targetId = try {
                                graphQLRepository.loadQueryUser(networkLibrary, gqlHeaders, login = splits[1]).also { response ->
                                    if (enableIntegrity && integrity.value == null) {
                                        response.errors?.find { it.message == "failed integrity check" }?.let {
                                            integrity.value = "refresh"
                                            return@launch
                                        }
                                    }
                                }.data!!.user?.id
                            } catch (e: Exception) {
                                helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                            }
                            graphQLRepository.startRaid(networkLibrary, gqlHeaders, channelId, targetId).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.startRaid(networkLibrary, helixHeaders, channelId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/unraid", true) -> {
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.cancelRaid(networkLibrary, gqlHeaders, channelId).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.cancelRaid(networkLibrary, helixHeaders, channelId)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/slow", true) -> {
                val splits = message.split(" ")
                val duration = if (splits.size >= 2) splits[1].toIntOrNull() else null
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.setSlowMode(networkLibrary, gqlHeaders, channelId, duration ?: 30).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId,
                                slow = true,
                                slowDuration = duration
                            )
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/slowoff", true) -> {
                viewModelScope.launch {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        graphQLRepository.setSlowMode(networkLibrary, gqlHeaders, channelId, 0).also { response ->
                            if (enableIntegrity && integrity.value == null) {
                                response.errors?.find { it.message == "failed integrity check" }?.let {
                                    integrity.value = "refresh"
                                    return@launch
                                }
                            }
                        }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                    } else {
                        if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, slow = false)
                        } else null
                    }?.let {
                        onMessage(ChatMessage(systemMsg = it))
                    }
                }
            }
            command.equals("/subscribers", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, subs = true)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/subscribersoff", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, subs = false)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/timeout", true) -> {
                val splits = message.split(" ", limit = 4)
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.banUser(networkLibrary, gqlHeaders, channelId, splits[1],
                                duration = if (splits.size >= 3) splits[2] else "10m",
                                reason = if (splits.size >= 4) splits[3] else null
                            ).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.banUser(networkLibrary, helixHeaders, channelId, accountId, targetId,
                                    duration = if (splits.size >= 3) splits[2] else "600",
                                    reason = if (splits.size >= 4) splits[3] else null
                                )
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/untimeout", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.unbanUser(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.unbanUser(networkLibrary, helixHeaders, channelId, accountId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/uniquechat", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, unique = true)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/uniquechatoff", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    viewModelScope.launch {
                        helixRepository.updateChatSettings(networkLibrary, helixHeaders, channelId, accountId, unique = false)?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                } else {
                    if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                        sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    }
                }
            }
            command.equals("/vip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.addVip(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.addVip(networkLibrary, helixHeaders, channelId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/unvip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        if (!gqlHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                            graphQLRepository.removeVip(networkLibrary, gqlHeaders, channelId, splits[1]).also { response ->
                                if (enableIntegrity && integrity.value == null) {
                                    response.errors?.find { it.message == "failed integrity check" }?.let {
                                        integrity.value = "refresh"
                                        return@launch
                                    }
                                }
                            }.takeIf { !it.errors.isNullOrEmpty() }?.toString()
                        } else {
                            if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                                val targetId = helixRepository.getUsers(
                                    networkLibrary = networkLibrary,
                                    headers = helixHeaders,
                                    logins = listOf(splits[1])
                                ).data.firstOrNull()?.channelId
                                helixRepository.removeVip(networkLibrary, helixHeaders, channelId, targetId)
                            } else null
                        }?.let {
                            onMessage(ChatMessage(systemMsg = it))
                        }
                    }
                }
            }
            command.equals("/vips", true) -> {
                viewModelScope.launch {
                    graphQLRepository.getVips(networkLibrary, gqlHeaders, channelLogin).also { response ->
                        if (enableIntegrity && integrity.value == null) {
                            response.errors?.find { it.message == "failed integrity check" }?.let {
                                integrity.value = "refresh"
                                return@launch
                            }
                        }
                    }.let {
                        onMessage(ChatMessage(systemMsg = it.data?.user?.vips?.edges?.map { it.node.login }?.toString() ?: it.toString()))
                    }
                }
            }
            command.equals("/w", true) -> {
                if (!helixHeaders[C.HEADER_TOKEN].isNullOrBlank()) {
                    val splits = message.split(" ", limit = 3)
                    if (splits.size >= 3) {
                        viewModelScope.launch {
                            val targetId = helixRepository.getUsers(
                                networkLibrary = networkLibrary,
                                headers = helixHeaders,
                                logins = listOf(splits[1])
                            ).data.firstOrNull()?.channelId
                            helixRepository.sendWhisper(networkLibrary, helixHeaders, accountId, targetId, splits[2])?.let {
                                onMessage(ChatMessage(systemMsg = it))
                            }
                        }
                    }
                }
            }
            else -> sendMessage(message, networkLibrary, gqlHeaders, helixHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
        }
    }

    fun startReplayChat(
        videoId: String?,
        startTime: Int,
        chatUrl: String?,
        getCurrentPosition: () -> Long?,
        getCurrentSpeed: () -> Float?,
        channelId: String?,
        channelLogin: String?,
        kickReplayFallback: Boolean = false,
        kickReplayStartTime: String? = null,
        kickReplayUrl: String? = null
    ) {
        stopReplayChat()
        if (!chatUrl.isNullOrBlank()) {
            logKickReplayChat(stage = "fallback_disabled", sessionKey = kickReplaySessionKey) {
                "reason=chat_url_present"
            }
            kickReplayFallbackEnabled = false
            kickReplayFallbackChannelId = null
            kickReplayFallbackChannelLogin = null
            kickReplayFallbackStartTimeMs = null
            kickReplayFallbackGetCurrentPosition = null
            kickReplaySessionKey = null
            kickReplaySessionStartPositionMs = null
            chatReplayManagerLocal = ChatReplayManagerLocal(
                getCurrentPosition = getCurrentPosition,
                getCurrentSpeed = getCurrentSpeed,
                coroutineScope = viewModelScope,
                listener = ChatReplayListener(),
            )
            readChatFile(chatUrl, channelId, channelLogin)
        } else {
            if (kickReplayFallback && !channelId.isNullOrBlank() && !channelLogin.isNullOrBlank()) {
                logKickReplayChat(stage = "fallback_enabled", sessionKey = null) {
                    "channelId=$channelId channelLogin=$channelLogin replayStart=$kickReplayStartTime"
                }
                kickReplayFallbackEnabled = true
                kickReplayFallbackChannelId = channelId
                kickReplayFallbackChannelLogin = channelLogin
                kickReplayFallbackStartTimeMs = kickReplayStartTime
                    ?.let { KickApiHelper.parseIso8601DateUTC(it) }
                kickReplayFallbackUrl = kickReplayUrl
                kickReplayFallbackGetCurrentPosition = getCurrentPosition
                kickReplayFallbackStartTimeMs?.let { replayStartTimeMs ->
                    val isClipReplay = kickReplayUrl?.contains("/clips/", ignoreCase = true) == true ||
                            kickReplayUrl?.contains("clips.kick.com", ignoreCase = true) == true
                    startKickReplayChat(channelId, channelLogin, channelLogin, replayStartTimeMs, kickReplayUrl, getCurrentPosition, isClipReplay)
                }
                return
            }
            logKickReplayChat(stage = "fallback_disabled", sessionKey = kickReplaySessionKey) {
                "reason=kick_replay_not_applicable"
            }
            kickReplayFallbackEnabled = false
            kickReplayFallbackChannelId = null
            kickReplayFallbackChannelLogin = null
            kickReplayFallbackStartTimeMs = null
            kickReplayFallbackUrl = null
            kickReplayFallbackGetCurrentPosition = null
            kickReplaySessionKey = null
            kickReplaySessionStartPositionMs = null
            if (!videoId.isNullOrBlank()) {
                chatReplayManager = ChatReplayManager(
                    networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
                    gqlHeaders = KickApiHelper.getGQLHeaders(applicationContext, true),
                    graphQLRepository = graphQLRepository,
                    json = json,
                    enableIntegrity = applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false),
                    videoId = videoId,
                    startTime = startTime.times(1000L),
                    getCurrentPosition = getCurrentPosition,
                    getCurrentSpeed = getCurrentSpeed,
                    coroutineScope = viewModelScope,
                    listener = ChatReplayListener(),
                )
            }
        }
    }

    fun startReplayChatLoad() {
        if (kickReplayFallbackEnabled) {
            val channelId = kickReplayFallbackChannelId
            val channelLogin = kickReplayFallbackChannelLogin
            val replayStartTimeMs = kickReplayFallbackStartTimeMs
            val kickReplayUrl = kickReplayFallbackUrl
            val getCurrentPosition = kickReplayFallbackGetCurrentPosition
            if (
                !channelId.isNullOrBlank() &&
                !channelLogin.isNullOrBlank() &&
                replayStartTimeMs != null &&
                getCurrentPosition != null &&
                kickChatJob?.isActive != true
            ) {
                logKickReplayChat(stage = "startReplayChatLoad", sessionKey = kickReplaySessionKey) {
                    "restarting_fallback channelId=$channelId"
                }
                val isClipReplay = kickReplayUrl?.contains("/clips/", ignoreCase = true) == true ||
                        kickReplayUrl?.contains("clips.kick.com", ignoreCase = true) == true
                startKickReplayChat(channelId, channelLogin, channelLogin, replayStartTimeMs, kickReplayUrl, getCurrentPosition, isClipReplay)
            }
        } else {
            chatReplayManager?.start() ?: chatReplayManagerLocal?.startLoad()
        }
    }

    fun stopReplayChat() {
        if (kickReplayFallbackEnabled) {
            val hadKickChatJob = kickChatJob != null
            if (hadKickChatJob) {
                logKickReplayChat(stage = "stopReplayChat", sessionKey = kickReplaySessionKey) {
                    "cancelKickChatJob=true"
                }
            }
            kickChatJob?.cancel()
            kickChatJob = null
            resetKickReplayPendingQueue()
        } else {
            chatReplayManager?.stop() ?: chatReplayManagerLocal?.stop()
        }
    }

    fun updatePosition(position: Long) {
        chatReplayManager?.updatePosition(position) ?: chatReplayManagerLocal?.updatePosition(position)
    }

    fun updateSpeed(speed: Float) {
        chatReplayManager?.updateSpeed(speed) ?: chatReplayManagerLocal?.updateSpeed(speed)
    }

    private fun formatIso8601Utc(timestampMs: Long): String {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            java.time.Instant.ofEpochMilli(timestampMs).toString()
        } else {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date(timestampMs))
        }
    }

    private inner class ChatReplayListener : ChatReplayManager.Listener {
        override suspend fun onChatMessage(message: ChatMessage) {
            onMessage(message)
        }

        override suspend fun onChatMessages(messages: List<ChatMessage>) {
            if (messages.isEmpty()) return
            synchronized(chatMessages) {
                val left = messageLimit - chatMessages.size
                if (left > 0) {
                    val items = messages.takeLast(left)
                    val insertStart = chatMessages.size
                    chatMessages.addAll(items)
                    items to insertStart
                } else null
            }?.let { appendMessages.emit(it) }
        }

        override suspend fun clearMessages() {
            synchronized(chatMessages) {
                val size = chatMessages.size
                chatMessages.clear()
                size
            }.let {
                removeMessages.emit(it)
            }
        }

        override suspend fun getIntegrityToken() {
            if (integrity.value == null) {
                integrity.value = "refresh"
            }
        }
    }

    private fun readChatFile(url: String, channelId: String?, channelLogin: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val nameDisplay = applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1")
                val messages = mutableListOf<ChatMessage>()
                var startTimeMs = 0L
                val twitchEmotes = mutableListOf<TwitchEmote>()
                val twitchBadges = mutableListOf<TwitchBadge>()
                val cheerEmotesList = mutableListOf<CheerEmote>()
                val emotes = mutableListOf<Emote>()
                if (url.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                    applicationContext.contentResolver.openInputStream(url.toUri())?.bufferedReader()
                } else {
                    FileInputStream(File(url)).bufferedReader()
                }?.use { fileReader ->
                    JsonReader(fileReader).use { reader ->
                        reader.isLenient = true
                        var position = 0L
                        var token: JsonToken
                        do {
                            token = reader.peek()
                            when (token) {
                                JsonToken.END_DOCUMENT -> {}
                                JsonToken.BEGIN_OBJECT -> {
                                    reader.beginObject().also { position += 1 }
                                    while (reader.hasNext()) {
                                        when (reader.peek()) {
                                            JsonToken.NAME -> {
                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                    "liveStartTime" -> { KickApiHelper.parseIso8601DateUTC(reader.nextString().also { position += it.length + 2 })?.let { startTimeMs = it } }
                                                    "liveComments" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            val message = reader.nextString().also { position += it.length + 2 + it.count { c -> c == '"' || c == '\\' } }
                                                            when {
                                                                message.contains("PRIVMSG") -> {
                                                                    val chatMessage = ChatUtils.parseChatMessage(message, false)
                                                                    buildReplyPreviewMessage(chatMessage, messages)?.let(messages::add)
                                                                    messages.add(chatMessage)
                                                                }
                                                                message.contains("USERNOTICE") -> {
                                                                    val chatMessage = ChatUtils.parseChatMessage(message, true)
                                                                    buildReplyPreviewMessage(chatMessage, messages)?.let(messages::add)
                                                                    messages.add(chatMessage)
                                                                }
                                                                message.contains("CLEARMSG") -> {
                                                                    val pair = ChatUtils.parseClearMessage(message)
                                                                    val deletedMessageIndex = pair.second?.let { targetId -> messages.indexOfLast { it.id == targetId } } ?: -1
                                                                    if (deletedMessageIndex != -1) {
                                                                        messages[deletedMessageIndex] = createDeletedMessage(messages[deletedMessageIndex])
                                                                    } else {
                                                                        messages.add(getClearMessage(pair.first, null, nameDisplay))
                                                                    }
                                                                }
                                                                message.contains("CLEARCHAT") -> messages.add(ChatUtils.parseClearChat(applicationContext, message))
                                                            }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "comments" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            reader.beginObject().also { position += 1 }
                                                            val message = StringBuilder()
                                                            var id: String? = null
                                                            var offsetSeconds: Int? = null
                                                            var userId: String? = null
                                                            var userLogin: String? = null
                                                            var userName: String? = null
                                                            var color: String? = null
                                                            val emotesList = mutableListOf<TwitchEmote>()
                                                            val badgesList = mutableListOf<Badge>()
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                    "id" -> id = reader.nextString().also { position += it.length + 2 }
                                                                    "commenter" -> {
                                                                        reader.beginObject().also { position += 1 }
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName().also { position += it.length + 3 }) {
                                                                                "id" -> userId = reader.nextString().also { position += it.length + 2 }
                                                                                "login" -> userLogin = reader.nextString().also { position += it.length + 2 }
                                                                                "displayName" -> userName = reader.nextString().also { position += it.length + 2 }
                                                                                else -> position += skipJsonValue(reader)
                                                                            }
                                                                            if (reader.peek() != JsonToken.END_OBJECT) {
                                                                                position += 1
                                                                            }
                                                                        }
                                                                        reader.endObject().also { position += 1 }
                                                                    }
                                                                    "contentOffsetSeconds" -> offsetSeconds = reader.nextInt().also { position += it.toString().length }
                                                                    "message" -> {
                                                                        reader.beginObject().also { position += 1 }
                                                                        while (reader.hasNext()) {
                                                                            when (reader.nextName().also { position += it.length + 3 }) {
                                                                                "fragments" -> {
                                                                                    reader.beginArray().also { position += 1 }
                                                                                    while (reader.hasNext()) {
                                                                                        reader.beginObject().also { position += 1 }
                                                                                        var emoteId: String? = null
                                                                                        var fragmentText: String? = null
                                                                                        while (reader.hasNext()) {
                                                                                            when (reader.nextName().also { position += it.length + 3 }) {
                                                                                                "emote" -> {
                                                                                                    when (reader.peek()) {
                                                                                                        JsonToken.BEGIN_OBJECT -> {
                                                                                                            reader.beginObject().also { position += 1 }
                                                                                                            while (reader.hasNext()) {
                                                                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                                                                    "emoteID" -> emoteId = reader.nextString().also { position += it.length + 2 }
                                                                                                                    else -> position += skipJsonValue(reader)
                                                                                                                }
                                                                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                                                                    position += 1
                                                                                                                }
                                                                                                            }
                                                                                                            reader.endObject().also { position += 1 }
                                                                                                        }
                                                                                                        else -> position += skipJsonValue(reader)
                                                                                                    }
                                                                                                }
                                                                                                "text" -> fragmentText = reader.nextString().also { position += it.length + 2 + it.count { c -> c == '"' || c == '\\' } }
                                                                                                else -> position += skipJsonValue(reader)
                                                                                            }
                                                                                            if (reader.peek() != JsonToken.END_OBJECT) {
                                                                                                position += 1
                                                                                            }
                                                                                        }
                                                                                        if (fragmentText != null && !emoteId.isNullOrBlank()) {
                                                                                            emotesList.add(TwitchEmote(
                                                                                                id = emoteId,
                                                                                                begin = message.codePointCount(0, message.length),
                                                                                                end = message.codePointCount(0, message.length) + fragmentText.lastIndex
                                                                                            ))
                                                                                        }
                                                                                        message.append(fragmentText)
                                                                                        reader.endObject().also { position += 1 }
                                                                                        if (reader.peek() != JsonToken.END_ARRAY) {
                                                                                            position += 1
                                                                                        }
                                                                                    }
                                                                                    reader.endArray().also { position += 1 }
                                                                                }
                                                                                "userBadges" -> {
                                                                                    reader.beginArray().also { position += 1 }
                                                                                    while (reader.hasNext()) {
                                                                                        reader.beginObject().also { position += 1 }
                                                                                        var set: String? = null
                                                                                        var version: String? = null
                                                                                        while (reader.hasNext()) {
                                                                                            when (reader.nextName().also { position += it.length + 3 }) {
                                                                                                "setID" -> set = reader.nextString().also { position += it.length + 2 }
                                                                                                "version" -> version = reader.nextString().also { position += it.length + 2 }
                                                                                                else -> position += skipJsonValue(reader)
                                                                                            }
                                                                                            if (reader.peek() != JsonToken.END_OBJECT) {
                                                                                                position += 1
                                                                                            }
                                                                                        }
                                                                                        if (!set.isNullOrBlank() && !version.isNullOrBlank()) {
                                                                                            badgesList.add(Badge(set, version))
                                                                                        }
                                                                                        reader.endObject().also { position += 1 }
                                                                                        if (reader.peek() != JsonToken.END_ARRAY) {
                                                                                            position += 1
                                                                                        }
                                                                                    }
                                                                                    reader.endArray().also { position += 1 }
                                                                                }
                                                                                "userColor" -> {
                                                                                    when (reader.peek()) {
                                                                                        JsonToken.STRING -> color = reader.nextString().also { position += it.length + 2 }
                                                                                        else -> position += skipJsonValue(reader)
                                                                                    }
                                                                                }
                                                                                else -> position += skipJsonValue(reader)
                                                                            }
                                                                            if (reader.peek() != JsonToken.END_OBJECT) {
                                                                                position += 1
                                                                            }
                                                                        }
                                                                        messages.add(ChatMessage(
                                                                            id = id,
                                                                            userId = userId,
                                                                            userLogin = userLogin,
                                                                            userName = userName,
                                                                            message = message.toString(),
                                                                            color = color,
                                                                            emotes = emotesList,
                                                                            badges = badgesList,
                                                                            bits = 0,
                                                                            timestamp = offsetSeconds?.times(1000L),
                                                                            fullMsg = null
                                                                        ))
                                                                        reader.endObject().also { position += 1 }
                                                                    }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                    position += 1
                                                                }
                                                            }
                                                            reader.endObject().also { position += 1 }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "twitchEmotes" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            reader.beginObject().also { position += 1 }
                                                            var id: String? = null
                                                            var data: Pair<Long, Int>? = null
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                    "data" -> {
                                                                        position += 1
                                                                        val length = reader.nextString().length
                                                                        data = Pair(position, length)
                                                                        position += length + 1
                                                                    }
                                                                    "id" -> id = reader.nextString().also { position += it.length + 2 }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                    position += 1
                                                                }
                                                            }
                                                            if (!id.isNullOrBlank() && data != null) {
                                                                twitchEmotes.add(TwitchEmote(
                                                                    id = id,
                                                                    localData = data
                                                                ))
                                                            }
                                                            reader.endObject().also { position += 1 }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "twitchBadges" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            reader.beginObject().also { position += 1 }
                                                            var setId: String? = null
                                                            var version: String? = null
                                                            var data: Pair<Long, Int>? = null
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                    "data" -> {
                                                                        position += 1
                                                                        val length = reader.nextString().length
                                                                        data = Pair(position, length)
                                                                        position += length + 1
                                                                    }
                                                                    "setId" -> setId = reader.nextString().also { position += it.length + 2 }
                                                                    "version" -> version = reader.nextString().also { position += it.length + 2 }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                    position += 1
                                                                }
                                                            }
                                                            if (!setId.isNullOrBlank() && !version.isNullOrBlank() && data != null) {
                                                                twitchBadges.add(TwitchBadge(
                                                                    setId = setId,
                                                                    version = version,
                                                                    localData = data
                                                                ))
                                                            }
                                                            reader.endObject().also { position += 1 }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "cheerEmotes" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            reader.beginObject().also { position += 1 }
                                                            var name: String? = null
                                                            var data: Pair<Long, Int>? = null
                                                            var minBits: Int? = null
                                                            var color: String? = null
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                    "data" -> {
                                                                        position += 1
                                                                        val length = reader.nextString().length
                                                                        data = Pair(position, length)
                                                                        position += length + 1
                                                                    }
                                                                    "name" -> name = reader.nextString().also { position += it.length + 2 }
                                                                    "minBits" -> minBits = reader.nextInt().also { position += it.toString().length }
                                                                    "color" -> {
                                                                        when (reader.peek()) {
                                                                            JsonToken.STRING -> color = reader.nextString().also { position += it.length + 2 }
                                                                            else -> position += skipJsonValue(reader)
                                                                        }
                                                                    }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                    position += 1
                                                                }
                                                            }
                                                            if (!name.isNullOrBlank() && minBits != null && data != null) {
                                                                cheerEmotesList.add(CheerEmote(
                                                                    name = name,
                                                                    localData = data,
                                                                    minBits = minBits,
                                                                    color = color
                                                                ))
                                                            }
                                                            reader.endObject().also { position += 1 }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "emotes" -> {
                                                        reader.beginArray().also { position += 1 }
                                                        while (reader.hasNext()) {
                                                            reader.beginObject().also { position += 1 }
                                                            var data: Pair<Long, Int>? = null
                                                            var name: String? = null
                                                            var isOverlayEmote = false
                                                            while (reader.hasNext()) {
                                                                when (reader.nextName().also { position += it.length + 3 }) {
                                                                    "data" -> {
                                                                        position += 1
                                                                        val length = reader.nextString().length
                                                                        data = Pair(position, length)
                                                                        position += length + 1
                                                                    }
                                                                    "name" -> name = reader.nextString().also { position += it.length + 2 }
                                                                    "isZeroWidth" -> isOverlayEmote = reader.nextBoolean().also { position += it.toString().length }
                                                                    else -> position += skipJsonValue(reader)
                                                                }
                                                                if (reader.peek() != JsonToken.END_OBJECT) {
                                                                    position += 1
                                                                }
                                                            }
                                                            if (!name.isNullOrBlank() && data != null) {
                                                                emotes.add(Emote(
                                                                    name = name,
                                                                    localData = data,
                                                                    isOverlayEmote = isOverlayEmote
                                                                ))
                                                            }
                                                            reader.endObject().also { position += 1 }
                                                            if (reader.peek() != JsonToken.END_ARRAY) {
                                                                position += 1
                                                            }
                                                        }
                                                        reader.endArray().also { position += 1 }
                                                    }
                                                    "startTime" -> { startTimeMs = reader.nextInt().also { position += it.toString().length }.times(1000L) }
                                                    else -> position += skipJsonValue(reader)
                                                }
                                            }
                                            else -> position += skipJsonValue(reader)
                                        }
                                        if (reader.peek() != JsonToken.END_OBJECT) {
                                            position += 1
                                        }
                                    }
                                    reader.endObject().also { position += 1 }
                                }
                                else -> position += skipJsonValue(reader)
                            }
                        } while (token != JsonToken.END_DOCUMENT)
                    }
                }
                synchronized(localTwitchEmotes) {
                    localTwitchEmotes.clear()
                    localTwitchEmotes.addAll(twitchEmotes)
                }
                synchronized(channelBadges) {
                    channelBadges.clear()
                    channelBadges.addAll(twitchBadges)
                }
                synchronized(cheerEmotes) {
                    cheerEmotes.clear()
                    cheerEmotes.addAll(cheerEmotesList)
                }
                synchronized(thirdPartyEmotes) {
                    thirdPartyEmotes.clear()
                    thirdPartyEmotes.addAll(emotes)
                }
                if (emotes.isEmpty()) {
                    viewModelScope.launch {
                        loadEmotes(channelId, channelLogin)
                    }
                }
                if (messages.isNotEmpty()) {
                    viewModelScope.launch {
                        chatReplayManagerLocal?.setMessages(messages, startTimeMs)
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

    private fun skipJsonValue(reader: JsonReader): Int {
        var length = 0
        when (reader.peek()) {
            JsonToken.BEGIN_ARRAY -> {
                reader.beginArray().also { length += 1 }
                while (reader.hasNext()) {
                    when (reader.peek()) {
                        JsonToken.NAME -> length += reader.nextName().length + 3
                        else -> {
                            length += skipJsonValue(reader)
                            if (reader.peek() != JsonToken.END_ARRAY) {
                                length += 1
                            }
                        }
                    }
                }
                reader.endArray().also { length += 1 }
            }
            JsonToken.END_ARRAY -> length += 1
            JsonToken.BEGIN_OBJECT -> {
                reader.beginObject().also { length += 1 }
                while (reader.hasNext()) {
                    when (reader.peek()) {
                        JsonToken.NAME -> length += reader.nextName().length + 3
                        else -> {
                            length += skipJsonValue(reader)
                            if (reader.peek() != JsonToken.END_OBJECT) {
                                length += 1
                            }
                        }
                    }
                }
                reader.endObject().also { length += 1 }
            }
            JsonToken.END_OBJECT -> length += 1
            JsonToken.STRING -> reader.nextString().let { length += it.length + 2 + it.count { c -> c == '"' || c == '\\' } }
            JsonToken.NUMBER -> length += reader.nextString().length
            JsonToken.BOOLEAN -> length += reader.nextBoolean().toString().length
            else -> reader.skipValue()
        }
        return length
    }

    companion object {
        private val KICK_INLINE_EMOTE_REGEX = Regex("\\[emote:(\\d+):([^\\]]+)]")
        private var savedEmoteSets: List<String>? = null
        private var savedUserEmotes: List<TwitchEmote>? = null
        private var savedGlobalBadges: List<TwitchBadge>? = null
        private var savedGlobalStvEmotes: List<Emote>? = null
    }
}
