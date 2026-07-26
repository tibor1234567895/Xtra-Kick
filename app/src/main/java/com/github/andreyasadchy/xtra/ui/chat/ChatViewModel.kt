package com.github.andreyasadchy.xtra.ui.chat

import android.content.ContentResolver
import android.content.Context
import android.os.SystemClock
import android.util.Base64
import android.util.JsonReader
import android.util.JsonToken
import android.util.Log
import androidx.core.content.edit
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
import com.github.andreyasadchy.xtra.model.chat.ChatBadge
import com.github.andreyasadchy.xtra.model.chat.ChatEmote
import com.github.andreyasadchy.xtra.model.kick.KickMessage
import com.github.andreyasadchy.xtra.model.kick.KickOfficialReward
import com.github.andreyasadchy.xtra.repository.KickGraphQLRepository
import com.github.andreyasadchy.xtra.repository.KickPublicApiRepository
import com.github.andreyasadchy.xtra.repository.KickAuthRequestException
import com.github.andreyasadchy.xtra.repository.KickRepository
import com.github.andreyasadchy.xtra.repository.MutedChatUsersRepository
import com.github.andreyasadchy.xtra.repository.PlayerRepository
import com.github.andreyasadchy.xtra.util.AuthStateHelper
import com.github.andreyasadchy.xtra.util.C
import com.github.andreyasadchy.xtra.util.DiagnosticLogger
import com.github.andreyasadchy.xtra.util.KickApiHelper
import com.github.andreyasadchy.xtra.util.KickOAuthConfig
import com.github.andreyasadchy.xtra.util.WebSocketRuntime
import com.github.andreyasadchy.xtra.util.chat.ChatListParityUtils
import com.github.andreyasadchy.xtra.util.chat.ChatReplayPacing
import com.github.andreyasadchy.xtra.util.chat.ChatUtils
import com.github.andreyasadchy.xtra.util.chat.KickChatSendErrorMapper
import com.github.andreyasadchy.xtra.util.chat.KickPusherChatWebSocket
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
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
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
    private val kickGraphQLRepository: KickGraphQLRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val kickRepository: KickRepository,
    private val mutedChatUsersRepository: MutedChatUsersRepository,
    private val playerRepository: PlayerRepository,
    private val trustManager: X509TrustManager?,
    private val json: Json,
) : ViewModel() {

    val integrity = MutableStateFlow<String?>(null)

    private var kickPusherChatWebSocket: KickPusherChatWebSocket? = null
    private var chatReadJob: Job? = null
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
    private var kickReplayLastPlaybackPositionMs: Long? = null
    private var kickInitialRoomStateLoaded = false
    private var kickRealtimeLastDisconnectMessage: String? = null
    private var kickRealtimeLastDisconnectAtMs: Long = 0L
    private var kickRealtimeReconnectAttempt = 0
    private var kickReplayMessageSources: List<String>? = null
    private var intentionalChatDisconnectUntilMs: Long = 0L
    private val kickReplayPreloadWindowMs = 1L * 60L * 1000L
    private val kickReplayPreloadFallbackWindowsMs = listOf(
        30L * 60L * 1000L,
        60L * 60L * 1000L,
        3L * 60L * 60L * 1000L,
        6L * 60L * 60L * 1000L,
    )
    private val kickReplayPreloadMaxMessages = 30
    private val kickReplayPollIntervalMs = 1_000L
    private val kickReplayEmitIntervalMs = 150L
    private val kickReplayEmitLeadMs = 500L

    /**
     * How far behind the playhead the queue may fall before pacing is abandoned.
     *
     * Preloads and seeks drop a large backlog into the queue at once, and that backlog has to go
     * out immediately - pacing it would leave chat permanently trailing the video. Only the steady
     * state, where the head of the queue is roughly at the playhead, gets spread out.
     */
    private val kickReplayCatchupThresholdMs = 3_000L

    /**
     * How far ahead of the playhead the pending queue should stay stocked.
     *
     * The timeline poll used to pull a single page per second, which on a busy channel is about a
     * second of chat. Any slow response then left the pacer with nothing to release, showing up as
     * a multi-second freeze rather than a smooth stream. Keeping a buffer this deep means a late
     * response is invisible.
     */
    private val kickReplayTargetLookaheadMs = 8_000L

    /** Pages to pull per timeline poll while the buffer is below [kickReplayTargetLookaheadMs]. */
    private val kickReplayTimelineMaxPages = 3

    /** Newest timestamp ever queued, i.e. how far ahead history has been fetched. */
    private var kickReplayQueuedThroughMs: Long? = null

    /** Timestamp bucket currently being spread, or null when none is in flight. */
    private var kickReplayPacingBucketMs: Long? = null

    /** Messages to release per tick for [kickReplayPacingBucketMs]. */
    private var kickReplayPacingPerTick = 1
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
    val kickEmoteGroups = MutableStateFlow<List<KickRepository.KickEmoteGroup>>(emptyList())
    val userEmotes = mutableListOf<Emote>()
    private var loadedUserEmotes = false
    val localChatEmotes = mutableListOf<ChatEmote>()
    val thirdPartyEmotes = mutableListOf<Emote>()
    val globalBadges = mutableListOf<ChatBadge>()
    val channelBadges = mutableListOf<ChatBadge>()
    val cheerEmotes = mutableListOf<CheerEmote>()

    val roomState = MutableStateFlow<RoomState?>(null)
    val raid = MutableStateFlow<Raid?>(null)
    val raidClicked = MutableStateFlow<Raid?>(null)
    var raidClosed = false
    val poll = MutableStateFlow<Poll?>(null)
    var pollClosed = false
    val pollSecondsLeft = MutableStateFlow<Int?>(null)
    var pollTimer: Job? = null
    val prediction = MutableStateFlow<Prediction?>(null)
    val latestPrediction = MutableStateFlow<Prediction?>(null)
    private var currentPrediction: Prediction? = null
    var predictionClosed = false
    val predictionSecondsLeft = MutableStateFlow<Int?>(null)
    var predictionTimer: Timer? = null
    var streamId: String? = null
    private val rewardList = mutableListOf<ChatMessage>()
    private var lastPinnedGiftId: String? = null
    val namePaints = mutableListOf<NamePaint>()
    val stvBadges = mutableListOf<StvBadge>()
    val personalEmoteSets = mutableMapOf<String, List<Emote>>()
    val stvUsers = mutableListOf<StvUser>()
    var channelStvEmoteSetId: String? = null
    var userStvEmoteSetId: String? = null
    private var currentKickEmoteChannelLogin: String? = null

    val reloadMessages = MutableStateFlow(false)
    val hideRaid = MutableStateFlow(false)
    val hidePoll = MutableStateFlow(false)
    val hidePrediction = MutableStateFlow(false)
    val pinnedGift = MutableStateFlow<PinnedGift?>(null)
    val pinnedGiftDismissed = MutableStateFlow(false)
    val pinnedGiftExpanded = MutableStateFlow(false)
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

    fun togglePinnedGiftExpanded() {
        pinnedGiftExpanded.value = !pinnedGiftExpanded.value
    }

    private fun clearPinnedGift() {
        pinnedGift.value = null
        pinnedGiftDismissed.value = false
        pinnedGiftExpanded.value = false
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
            pinnedGiftExpanded.value = false
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
    // ArrayDeque, not ArrayList: both lists are trimmed from the head on every message once the
    // channel is busy enough to sit at messageLimit, and removing index 0 from an ArrayList
    // copies the remaining 600 elements each time. ArrayDeque drops the head in constant time
    // and still gives the adapter O(1) indexed access.
    private val rawChatMessages = ArrayDeque<ChatMessage>()
    val chatMessages = ArrayDeque<ChatMessage>()
    val refreshMessages = MutableSharedFlow<Unit>(replay = 1, extraBufferCapacity = 1)
    val autoCompleteList = mutableListOf<Any?>()
    private val chatters = ConcurrentHashMap<String, Chatter>()
    @Volatile
    private var mutedUserKeys = emptySet<String>()
    @Volatile
    private var kickLivePollingFallbackActive = false
    init {
        viewModelScope.launch {
            mutedChatUsersRepository.loadUsersFlow().collectLatest { users ->
                mutedUserKeys = buildMutedUserKeys(users)
                rebuildVisibleMessages()
            }
        }
        viewModelScope.launch {
            playerRepository.resolutionChangeFlow.collect { res ->
                val newMsg = ContextCompat.getString(applicationContext, R.string.resolution_auto_changed).format(res)
                onMessage(ChatMessage(systemMsg = newMsg))
            }
        }
        viewModelScope.launch {
            playerRepository.qualityChangeFlow.collect { message ->
                val newMsg = ContextCompat.getString(applicationContext, R.string.quality_auto_changed).format(message)
                onMessage(ChatMessage(systemMsg = newMsg))
            }
        }
    }

    private fun loadKickInitialRoomStateIfNeeded(channelId: String?, channelLogin: String?, forceRefresh: Boolean = false) {
        if (channelLogin.isNullOrBlank()) {
            return
        }
        if (!forceRefresh && kickInitialRoomStateLoaded && roomState.value != null) {
            return
        }
        kickInitialRoomStateLoaded = true
        viewModelScope.launch {
            kickRepository.getInitialRoomState(channelLogin, channelId)?.let {
                roomState.value = it
            }
        }
    }

    private fun buildMutedUserKeys(users: List<com.github.andreyasadchy.xtra.model.ui.MutedChatUser>): Set<String> {
        return buildSet {
            users.forEach { user ->
                user.userId?.trim()?.takeIf { it.isNotEmpty() }?.let { add("id:$it") }
                user.userLogin?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotEmpty() }?.let { add("login:$it") }
                user.userName?.trim()?.lowercase(Locale.ROOT)?.takeIf { it.isNotEmpty() }?.let { add("name:$it") }
            }
        }
    }

    private fun isMutedUser(userId: String?, userLogin: String?, userName: String?): Boolean {
        val keys = mutedUserKeys
        if (keys.isEmpty()) return false
        return (!userId.isNullOrBlank() && keys.contains("id:$userId")) ||
            (!userLogin.isNullOrBlank() && keys.contains("login:${userLogin.lowercase(Locale.ROOT)}")) ||
            (!userName.isNullOrBlank() && keys.contains("name:${userName.lowercase(Locale.ROOT)}"))
    }

    private fun isMutedMessage(message: ChatMessage): Boolean {
        return isMutedUser(message.userId, message.userLogin, message.userName)
    }

    private suspend fun rebuildVisibleMessages() {
        synchronized(chatMessages) {
            chatMessages.clear()
            synchronized(rawChatMessages) {
                chatMessages.addAll(rawChatMessages.filterNot(::isMutedMessage))
            }
        }
        refreshMessages.emit(Unit)
    }

    fun startLive(networkLibrary: String?, channelId: String?, channelLogin: String?, channelName: String?, streamId: String?) {
        if (kickChatJob == null && channelLogin != null) {
            messageLimit = applicationContext.prefs().getInt(C.CHAT_LIMIT, 600)
            this.streamId = streamId
            kickLivePollingFallbackActive = false
            kickInitialRoomStateLoaded = false
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
            kickInitialRoomStateLoaded = false
            loadKickInitialRoomStateIfNeeded(channelId, channelLogin)
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
        currentPrediction = null
        latestPrediction.value = null
        predictionSecondsLeft.value = null
        predictionTimer?.cancel()
        super.onCleared()
    }

    private fun loadEmotes(channelId: String?, channelLogin: String?) {
        currentKickEmoteChannelLogin = channelLogin?.trim()?.lowercase(Locale.ROOT)
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(applicationContext)
        val kickWebHeaders = KickApiHelper.getKickWebHeaders(applicationContext, true)
        val emoteQuality = applicationContext.prefs().getString(C.CHAT_IMAGE_QUALITY, "4") ?: "4"
        val animateGifs = applicationContext.prefs().getBoolean(C.ANIMATED_EMOTES, true)
        val useWebp = applicationContext.prefs().getBoolean(C.CHAT_USE_WEBP, true)
        val enableIntegrity = applicationContext.prefs().getBoolean(C.ENABLE_INTEGRITY, false)
        synchronized(thirdPartyEmotes) {
            thirdPartyEmotes.clear()
        }
        kickEmoteGroups.value = emptyList()
        if (!channelLogin.isNullOrBlank()) {
            viewModelScope.launch {
                try {
                    // Populate Kick badge URL cache regardless of third-party emote settings.
                    kickRepository.getChannel(channelLogin)
                } catch (_: Exception) {
                    channelId?.takeIf { it.isNotBlank() }?.let { idCandidate ->
                        runCatching {
                            kickRepository.getChannel(idCandidate)
                        }
                    }
                }
            }
            viewModelScope.launch {
                try {
                    val includeCurrentChannelSubscriberEmotes = kickRepository.canAccessKickSubscriberEmotes(channelLogin)
                    val groups = kickRepository.loadKickNativeEmoteGroups(channelLogin, includeCurrentChannelSubscriberEmotes)
                    kickEmoteGroups.value = groups
                    val emotes = groups.flatMap { it.emotes }
                    if (emotes.isNotEmpty()) {
                        synchronized(thirdPartyEmotes) {
                            thirdPartyEmotes.addAll(emotes.filter { emote -> thirdPartyEmotes.none { it.name == emote.name } })
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
                } catch (_: Exception) {

                }
            }
        }
        synchronized(globalBadges) {
            globalBadges.clear()
        }
        synchronized(channelBadges) {
            channelBadges.clear()
        }
        synchronized(cheerEmotes) {
            cheerEmotes.clear()
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
    }

    fun getPrimaryKickEmoteGroup(): KickRepository.KickEmoteGroup? {
        val currentLogin = currentKickEmoteChannelLogin ?: return kickEmoteGroups.value.firstOrNull()
        return kickEmoteGroups.value.firstOrNull { group ->
            group.id.equals(currentLogin, ignoreCase = true)
        } ?: kickEmoteGroups.value.firstOrNull()
    }

    fun getCurrentKickEmoteGroup(): KickRepository.KickEmoteGroup? {
        val currentLogin = currentKickEmoteChannelLogin ?: return null
        return kickEmoteGroups.value.firstOrNull { group ->
            group.id.equals(currentLogin, ignoreCase = true)
        }
    }

    fun getSevenTvEmotes(): List<Emote> {
        val personalEmotes = userStvEmoteSetId?.let { setId ->
            synchronized(personalEmoteSets) {
                personalEmoteSets[setId]
            }
        } ?: emptyList()
        return (personalEmotes + synchronized(thirdPartyEmotes) {
            thirdPartyEmotes.filter { it.thirdParty }
        }).distinctBy { it.name }
    }

    private fun getEmoteLookupMap(): Map<String, Emote> {
        val lookup = LinkedHashMap<String, Emote>()
        synchronized(userEmotes) {
            userEmotes.forEach { emote ->
                val name = emote.name ?: return@forEach
                lookup.putIfAbsent(name, emote)
            }
        }
        kickEmoteGroups.value
            .flatMap { it.emotes }
            .forEach { emote ->
                val name = emote.name ?: return@forEach
                lookup.putIfAbsent(name, emote)
            }
        getSevenTvEmotes().forEach { emote ->
            val name = emote.name ?: return@forEach
            lookup.putIfAbsent(name, emote)
        }
        return lookup
    }

    fun getResolvedRecentEmotes(recentEmotes: List<RecentEmote>): List<Emote> {
        val emoteLookup = getEmoteLookupMap()
        return recentEmotes
            .sortedByDescending { it.usedAt }
            .mapNotNull { recentEmote -> emoteLookup[recentEmote.name] }
            .distinctBy { it.name }
    }

    fun getEmotePickerSections(recentEmotes: List<RecentEmote>, query: String): List<EmotePickerSection> {
        val normalizedQuery = query.trim()
        val hasQuery = normalizedQuery.isNotEmpty()
        val currentKickGroup = getCurrentKickEmoteGroup()

        fun List<Emote>.filterForQuery(): List<Emote> {
            return if (hasQuery) {
                filter { it.name?.contains(normalizedQuery, ignoreCase = true) == true }
            } else {
                this
            }.distinctBy { it.name }
        }

        return buildList {
            if (!hasQuery) {
                getResolvedRecentEmotes(recentEmotes)
                    .takeIf { it.isNotEmpty() }
                    ?.let { emotes ->
                        add(
                            EmotePickerSection(
                                key = "recent",
                                title = "Recent",
                                emotes = emotes,
                                expandedByDefault = true,
                            )
                        )
                    }
            }

            currentKickGroup?.emotes
                ?.filterForQuery()
                ?.takeIf { it.isNotEmpty() }
                ?.let { emotes ->
                    add(
                        EmotePickerSection(
                            key = "kick-current",
                            title = currentKickGroup.title,
                            emotes = emotes,
                            expandedByDefault = true,
                        )
                    )
                }

            val otherKickGroups = kickEmoteGroups.value.filterNot { group ->
                val currentId = currentKickGroup?.id
                currentId != null && group.id.equals(currentId, ignoreCase = true)
            }
            val globalKickEmotes = LinkedHashMap<String, Emote>()
            otherKickGroups.forEach { group ->
                val isGlobalLike = group.title.equals("Global", ignoreCase = true) ||
                    group.title.equals("Emojis", ignoreCase = true) ||
                    group.id.equals("Emoji", ignoreCase = true)
                if (isGlobalLike) {
                    group.emotes.forEach { emote ->
                        val name = emote.name ?: return@forEach
                        globalKickEmotes.putIfAbsent(name, emote)
                    }
                } else {
                    val emotes = group.emotes.filterForQuery()
                    if (emotes.isEmpty()) {
                        return@forEach
                    }
                    add(
                        EmotePickerSection(
                            key = "kick-${group.id}",
                            title = group.title,
                            emotes = emotes,
                            expandedByDefault = hasQuery,
                        )
                    )
                }
            }
            globalKickEmotes.values
                .toList()
                .filterForQuery()
                .takeIf { it.isNotEmpty() }
                ?.let { emotes ->
                    add(
                        EmotePickerSection(
                            key = "kick-global",
                            title = "Global",
                            emotes = emotes,
                            expandedByDefault = hasQuery,
                        )
                    )
                }

            getSevenTvEmotes()
                .filterForQuery()
                .takeIf { it.isNotEmpty() }
                ?.let { emotes ->
                    add(
                        EmotePickerSection(
                            key = "7tv",
                            title = "7TV",
                            emotes = emotes,
                            expandedByDefault = hasQuery,
                        )
                    )
                }
        }
    }

    /**
     * Kick has no per-user emote set endpoint, so this only clears whatever a previous
     * session left behind. The Twitch loader that used to follow was unreachable.
     */
    private fun loadUserEmotes(channelId: String?) {
        synchronized(userEmotes) {
            userEmotes.clear()
        }
        loadedUserEmotes = false
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
            val debugKickRealtimeChat = isKickRecentChatDebugEnabled()
            try {
                val list = if (!channelId.isNullOrBlank()) {
                    val kickMessageSources = resolveKickMessageSources(channelId, channelLogin)
                    if (debugKickRealtimeChat) {
                        Log.d("KickRecentChat", "preload start channelId=$channelId channelLogin=$channelLogin sources=$kickMessageSources")
                    }
                    val liveHistorySources = buildList {
                        add(channelId)
                        addAll(kickMessageSources)
                    }.distinct()
                    if (debugKickRealtimeChat) {
                        Log.d(
                            "KickRecentChat",
                            "preload live history primary channelId=$channelId channelLogin=$channelLogin sources=$liveHistorySources"
                        )
                    }
                    val fetchedMessages = fetchKickLiveHistoryMessages(
                        messageSources = liveHistorySources,
                        channelId = channelId,
                        channelLogin = channelLogin
                    ).ifEmpty {
                        if (debugKickRealtimeChat) {
                            Log.d(
                                "KickRecentChat",
                                "preload recent fallback channelId=$channelId channelLogin=$channelLogin sources=$kickMessageSources"
                            )
                        }
                        fetchKickMessages(
                            messageSources = liveHistorySources,
                            channelId = channelId,
                            channelLogin = channelLogin
                        ).ifEmpty {
                            val historyStartTime = formatIso8601Utc(
                                System.currentTimeMillis() - 5L * 60L * 1000L
                            )
                            if (debugKickRealtimeChat) {
                                Log.d("KickRecentChat", "preload history fallback channelId=$channelId channelLogin=$channelLogin start=$historyStartTime")
                            }
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
                    if (debugKickRealtimeChat) {
                        Log.w(
                            "KickRecentChat",
                            "preload result channelId=$channelId channelLogin=$channelLogin fetched=${fetchedMessages.size} display=${displayMessages.size}"
                        )
                    }
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
                    synchronized(rawChatMessages) {
                        val left = messageLimit - rawChatMessages.size
                        if (left > 0) {
                            val items = list.takeLast(left)
                            rawChatMessages.addAll(0, items)
                            val visibleItems = items.filterNot(::isMutedMessage)
                            synchronized(chatMessages) {
                                chatMessages.addAll(0, visibleItems)
                                Pair(visibleItems, chatMessages.lastIndex)
                            }
                        } else null
                    }.let {
                        if (it != null && it.first.isNotEmpty()) {
                            if (debugKickRealtimeChat) {
                                Log.w(
                                    "KickRecentChat",
                                    "preload emit channelId=$channelId channelLogin=$channelLogin added=${it.first.size} total=${synchronized(chatMessages) { chatMessages.size }}"
                                )
                            }
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

    private suspend fun getKickAccessTokenForChatSend(forceRefresh: Boolean = false): String? {
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val headers = kickRepository.getKickPublicApiHeadersWithRefresh(
            networkLibrary = networkLibrary,
            forceRefresh = forceRefresh,
        )
        return headers[C.HEADER_TOKEN]
            ?.removePrefix("Bearer ")
            ?.trim()
            ?.takeIf { it.isNotBlank() }
    }

    private suspend fun loadStvChannelEmotes(networkLibrary: String?, channelId: String, channelLogin: String?, useWebp: Boolean): Pair<String?, List<Emote>> {
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
        val aiModerated: Boolean = false,
    )

    private fun isKickReplayChatDebugEnabled(): Boolean {
        return BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_CLIP_CHAT, false)
    }

    private fun isKickRecentChatDebugEnabled(): Boolean {
        if (!BuildConfig.DEBUG) {
            return false
        }
        val prefs = applicationContext.prefs()
        return prefs.getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false) || prefs.getBoolean(C.DEBUG_KICK_CLIP_CHAT, false)
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
        val reply = message.reply?.takeIf { !it.threadParentId.isNullOrBlank() } ?: return null
        val replyParent = findReplyParentMessage(reply, additionalMessages)
        val previewMessage = replyParent?.message ?: reply.message ?: replyParent?.systemMsg ?: return null
        val previewReply = Reply(
            threadParentId = reply.threadParentId,
            userLogin = replyParent?.userLogin ?: reply.userLogin,
            userName = replyParent?.userName ?: reply.userName,
            message = previewMessage
        )
        return ChatMessage(
            reply = previewReply,
            isReply = true,
            replyParent = replyParent,
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
        kickReplayPacingBucketMs = null
        kickReplayPacingPerTick = 1
        kickReplayQueuedThroughMs = null
    }

    /**
     * How many messages of a bucket to release per tick so the bucket spans the second it covers.
     *
     * Counts the whole pending queue rather than a prefix because [kickReplayPendingMessages] is a
     * PriorityQueue - its iteration order is arbitrary, so a matching timestamp can sit anywhere.
     * Only runs once per bucket, so roughly once per second of playback.
     */
    private fun kickReplayPerTickForBucket(bucketTimestampMs: Long): Int {
        var bucketSize = 0
        kickReplayPendingMessages.forEach { pending ->
            if (pending.timestamp == bucketTimestampMs) {
                bucketSize += 1
            }
        }
        return ChatReplayPacing.perTickRelease(bucketSize, kickReplayEmitIntervalMs)
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
            message.timestamp?.let { timestamp ->
                if (timestamp > (kickReplayQueuedThroughMs ?: Long.MIN_VALUE)) {
                    kickReplayQueuedThroughMs = timestamp
                }
            }
            queued += 1
        }
        return KickClipQueueStats(
            total = messages.size,
            queued = queued,
            alreadyEmitted = alreadyEmitted,
            alreadyQueued = alreadyQueued
        )
    }

    private suspend fun emitDueKickReplayMessages(cutoffTimestampMs: Long, replayStartTimeMs: Long): KickClipEmitStats {
        if (kickReplayPendingMessages.isEmpty()) {
            return KickClipEmitStats(total = 0, emitted = 0, deduped = 0)
        }
        // Kick reports comment times as whole seconds, so every message from the same second falls
        // due on the same tick. Releasing the whole bucket at once is what made replay lurch a
        // screenful at a time and scroll most of it past unread; spread it over the ticks that
        // cover that second instead. Buckets more than kickReplayCatchupThresholdMs behind the
        // playhead are a backlog from a preload or seek and still go out in one go.
        val headTimestamp = kickReplayPendingMessages.peek()?.timestamp
        val paced = headTimestamp != null &&
            cutoffTimestampMs - headTimestamp <= kickReplayCatchupThresholdMs
        val perTick = if (paced) {
            if (headTimestamp != kickReplayPacingBucketMs) {
                kickReplayPacingBucketMs = headTimestamp
                kickReplayPacingPerTick = kickReplayPerTickForBucket(headTimestamp)
            }
            kickReplayPacingPerTick
        } else {
            Int.MAX_VALUE
        }

        val due = mutableListOf<ChatMessage>()
        while (kickReplayPendingMessages.isNotEmpty() && due.size < perTick) {
            val next = kickReplayPendingMessages.peek() ?: break
            val nextTimestamp = next.timestamp
            if (nextTimestamp != null && nextTimestamp > cutoffTimestampMs) {
                break
            }
            // Deliberately not stopping at a bucket boundary. Doing that drained a second in
            // about six ticks and then idled until the next second came into range, which read
            // as a pause on every cycle. Flowing straight into the next eligible bucket keeps
            // the stream continuous; the release rate is re-derived below when the bucket
            // changes, so a busier second still gets a bigger allowance.
            if (paced && nextTimestamp != null && nextTimestamp != kickReplayPacingBucketMs) {
                kickReplayPacingBucketMs = nextTimestamp
                kickReplayPacingPerTick = kickReplayPerTickForBucket(nextTimestamp)
            }
            kickReplayPendingMessages.poll()
            kickReplayPendingKeys.remove(kickMessageKey(next))
            due += next
        }
        if (due.isEmpty()) {
            return KickClipEmitStats(total = 0, emitted = 0, deduped = 0)
        }
        return emitKickMessages(due, replayStartTimeMs)
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
                    Log.d("KickRecentChat", "source=$source fetch failed", e)
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
        throwOnTotalFailure: Boolean = false,
        initialCursor: String? = null
    ): List<ChatMessage> {
        var lastError: Exception? = null
        var hadSuccessfulResponse = false
        for (source in messageSources) {
            try {
                val collected = mutableListOf<ChatMessage>()
                var newKickEmotesAdded = false
                var cursor: String? = initialCursor
                var page = 0
                val seenCursors = mutableSetOf<String>()
                do {
                    val requestCursor = cursor
                    val requestId = kickReplayChatRequestSeq.incrementAndGet()
                    logKickReplayChat(
                        stage = "request",
                        sessionKey = debugSessionKey
                    ) {
                        "id=$requestId phase=$debugPhase source=$source startTime=$startTime cursor=${requestCursor ?: "-"} page=${page + 1}"
                    }
                    val response = kickRepository.getChatHistory(source, startTime, requestCursor)
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
                    cursor = response.cursor?.takeIf { it.isNotBlank() && it != requestCursor && seenCursors.add(it) }
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

    private suspend fun fetchKickPreloadHistoryMessages(
        messageSources: List<String>,
        playbackTimestampMs: Long,
        channelId: String,
        channelLogin: String,
        debugSessionKey: String,
        maxPages: Int,
    ): List<ChatMessage> {
        val syntheticCursor = ((playbackTimestampMs - kickReplayPreloadWindowMs) * 1000L).toString()
        val messages = fetchKickHistoryMessages(
            messageSources = messageSources,
            startTime = "",
            channelId = channelId,
            channelLogin = channelLogin,
            debugSessionKey = debugSessionKey,
            debugPhase = "preload_fast",
            maxPages = maxPages,
            initialCursor = syntheticCursor
        )
            .filter { it.timestamp == null || it.timestamp < playbackTimestampMs }
            .takeLast(kickReplayPreloadMaxMessages)
            
        logKickReplayChat(stage = "preload_fast", sessionKey = debugSessionKey) {
            "${messageRangeSummary(messages)} total=${messages.size}"
        }
        return messages
    }

    private suspend fun fetchKickLiveHistoryMessages(
        messageSources: List<String>,
        channelId: String? = null,
        channelLogin: String? = null
    ): List<ChatMessage> {
        val debugKickRealtimeChat = isKickRecentChatDebugEnabled()
        for (source in messageSources) {
            try {
                val response = kickRepository.getLiveChatHistory(source)
                val rawMessages = response.messages
                val rawCount = rawMessages.size
                val messages = mapKickMessages(rawMessages)
                    .sortedBy { it.timestamp }
                if (debugKickRealtimeChat) {
                    Log.d(
                        "KickRecentChat",
                        "live history source=$source rawCount=$rawCount mappedCount=${messages.size}"
                    )
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
                    Log.d("KickRecentChat", "live history source=$source fetch failed", e)
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
        if (channelLogin.isNullOrBlank()) {
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

    /**
     * Appends [messages] as one block, reported with a single [appendMessages] emission.
     *
     * For backlogs: the history that fills the screen after a seek or at the start of a session.
     * Pushing those through [onMessage] one at a time makes the list insert and scroll to the
     * bottom once per message, so the whole backlog visibly scrolls past - several screenfuls of
     * chat racing by - instead of simply already being there when the video resumes.
     */
    private suspend fun appendChatMessagesInBulk(messages: List<ChatMessage>) {
        if (messages.isEmpty()) return
        synchronized(rawChatMessages) {
            val left = messageLimit - rawChatMessages.size
            if (left > 0) {
                val items = messages.takeLast(left)
                rawChatMessages.addAll(items)
                val visibleItems = items.filterNot(::isMutedMessage)
                synchronized(chatMessages) {
                    val insertStart = chatMessages.size
                    chatMessages.addAll(visibleItems)
                    visibleItems to insertStart
                }
            } else null
        }?.takeIf { it.first.isNotEmpty() }?.let { appendMessages.emit(it) }
    }

    /**
     * @param asBulk route the surviving messages through [appendChatMessagesInBulk] instead of
     *   emitting them one by one. Use for backlogs, never for messages arriving in step with
     *   playback - those need to appear individually to read as a live stream of chat.
     */
    private suspend fun emitKickMessages(
        messages: List<ChatMessage>,
        replayStartTimeMs: Long? = null,
        asBulk: Boolean = false,
    ): KickClipEmitStats {
        var emitted = 0
        var deduped = 0
        val bulk = if (asBulk) mutableListOf<ChatMessage>() else null
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
                val displayMessage = if (replayStartTimeMs != null) {
                    message.withRelativeReplayTimestamp(replayStartTimeMs)
                } else {
                    message
                }
                if (bulk != null) {
                    buildReplyPreviewMessage(displayMessage)?.let { bulk += it }
                    bulk += displayMessage
                } else {
                    buildReplyPreviewMessage(displayMessage)?.let { onMessage(it) }
                    onMessage(displayMessage)
                }
                addChatter(displayMessage.userName)
                emitted += 1
            } else {
                deduped += 1
            }
        }
        if (bulk != null) {
            appendChatMessagesInBulk(bulk)
        }
        return KickClipEmitStats(
            total = messages.size,
            emitted = emitted,
            deduped = deduped
        )
    }

    private fun ChatMessage.withRelativeReplayTimestamp(replayStartTimeMs: Long): ChatMessage {
        val relativeTimestamp = timestamp?.let { (it - replayStartTimeMs).coerceAtLeast(0L) }
        return ChatMessage(
            id = id,
            userId = userId,
            userLogin = userLogin,
            userName = userName,
            message = message,
            color = color,
            emotes = emotes,
            badges = badges,
            isAction = isAction,
            isDeleted = isDeleted,
            isFirst = isFirst,
            bits = bits,
            systemMsg = systemMsg,
            msgId = msgId,
            reward = reward,
            reply = reply,
            isReply = isReply,
            replyParent = replyParent,
            timestamp = relativeTimestamp,
            fullMsg = fullMsg
        )
    }

    private suspend fun clearChatMessages(): Int {
        val size = synchronized(chatMessages) {
            val size = chatMessages.size
            chatMessages.clear()
            synchronized(rawChatMessages) {
                rawChatMessages.clear()
            }
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
            synchronized(rawChatMessages) {
                rawChatMessages.forEach { message ->
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

    private fun markIntentionalChatDisconnect() {
        intentionalChatDisconnectUntilMs = SystemClock.elapsedRealtime() + 5_000L
    }

    private fun shouldSuppressIntentionalChatDisconnect(message: String?): Boolean {
        if (SystemClock.elapsedRealtime() > intentionalChatDisconnectUntilMs) {
            return false
        }
        val normalized = message?.lowercase(Locale.ROOT).orEmpty()
        return normalized.contains("software caused connection abort") ||
            normalized.contains("socket closed") ||
            normalized.contains("connection reset") ||
            normalized.contains("broken pipe")
    }

    private fun startKickReplayChat(
        channelId: String,
        channelLogin: String,
        channelName: String?,
        replayStartTimeMs: Long,
        kickReplayUrl: String?,
        getCurrentPosition: () -> Long?,
        showClipStartMarker: Boolean = true,
        forceNewSession: Boolean = false,
        seekPosition: Long? = null
    ) {
        val currentPlaybackPositionMs = seekPosition ?: getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
        val sessionKey = "$channelId|$replayStartTimeMs"
        val previousPlaybackPositionMs = kickReplayLastPlaybackPositionMs
        val largeSeek = previousPlaybackPositionMs != null &&
            kotlin.math.abs(currentPlaybackPositionMs - previousPlaybackPositionMs) > 20_000L
        val isNewSession = forceNewSession || largeSeek || kickReplaySessionKey != sessionKey
        logKickReplayChat(stage = "session_start", sessionKey = sessionKey) {
            "channelId=$channelId channelLogin=$channelLogin replayStartMs=$replayStartTimeMs " +
                "isNewSession=$isNewSession currentPositionMs=$currentPlaybackPositionMs previousPositionMs=$previousPlaybackPositionMs largeSeek=$largeSeek"
        }
        kickReplaySessionKey = sessionKey
        kickReplayLastPlaybackPositionMs = currentPlaybackPositionMs
        stopLiveChat()
        resetKickReplayPendingQueue()
        if (isNewSession) {
            kickReplayMessageSources = null
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
            val initialPlaybackPositionMs = resolveInitialKickReplayPlaybackPosition(
                currentPlaybackPositionMs = currentPlaybackPositionMs,
                getCurrentPosition = getCurrentPosition,
                sessionKey = sessionKey
            )
            val initialPlaybackTimestampMs = effectiveReplayStartTimeMs + initialPlaybackPositionMs
            
            val kickMessageSources = kickReplayMessageSources ?: run {
                val sources = resolveKickMessageSources(channelId, channelLogin)
                    .map { it.trim() }
                    .filter { source -> source.isNotBlank() && source.all(Char::isDigit) }
                    .ifEmpty { listOf(channelId.trim()) }
                kickReplayMessageSources = sources
                sources
            }
            
            logKickReplayChat(stage = "sources", sessionKey = sessionKey) {
                "values=${kickMessageSources.joinToString(",")}"
            }
            if (isNewSession) {
                val removedMessages = clearChatMessages()
                logKickReplayChat(stage = "clear_messages", sessionKey = sessionKey) {
                    "removed=$removedMessages"
                }
                try {
                    val preloadMessages = fetchKickPreloadHistoryMessages(
                        messageSources = kickMessageSources,
                        playbackTimestampMs = initialPlaybackTimestampMs,
                        channelId = channelId,
                        channelLogin = channelLogin,
                        debugSessionKey = sessionKey,
                        maxPages = 4
                    )
                    // asBulk: this is the backlog that fills the screen behind the seek target. It
                    // must land as one block - emitted one by one it scrolls several screenfuls of
                    // chat past before settling, which is what a seek used to look like.
                    val stats = emitKickMessages(preloadMessages, effectiveReplayStartTimeMs, asBulk = true)
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
            // Emitting and polling run as separate coroutines on purpose. They used to share one
            // loop, which awaited fetchKickHistoryMessages inline, so every poll stalled emission
            // for as long as the request took: chat came out as a few evenly spaced batches and
            // then a long gap once a second, with the gap being the network round trip. Splitting
            // them keeps the release cadence at kickReplayEmitIntervalMs regardless of how slow
            // the timeline request is.
            //
            // Both loops touch kickReplayPendingMessages and the pacing state, and both stay on
            // this scope's main dispatcher, so they interleave only at suspension points - none of
            // which sit inside the queue reads and writes.
            coroutineScope {
                launch {
                    while (currentCoroutineContext().isActive) {
                        try {
                            val rawPosition = getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
                            kickReplayLastPlaybackPositionMs = rawPosition
                            val playbackTimestampMs = effectiveReplayStartTimeMs + rawPosition
                            val dueStats = emitDueKickReplayMessages(playbackTimestampMs + kickReplayEmitLeadMs, effectiveReplayStartTimeMs)
                            if (dueStats.total > 0) {
                                logKickReplayChat(stage = "emit_due", sessionKey = sessionKey) {
                                    "rawPositionMs=$rawPosition positionMs=$rawPosition playbackTs=$playbackTimestampMs total=${dueStats.total} emitted=${dueStats.emitted} deduped=${dueStats.deduped} pending=${kickReplayPendingMessages.size}"
                                }
                            }
                        } catch (e: CancellationException) {
                            logKickReplayChat(stage = "cancelled", sessionKey = sessionKey) {
                                "phase=emit"
                            }
                            throw e
                        } catch (e: Exception) {
                            logKickReplayChat(stage = "error", sessionKey = sessionKey) {
                                "phase=emit error=${e::class.java.simpleName}:${e.message}"
                            }
                        }
                        delay(kickReplayEmitIntervalMs)
                    }
                }
                launch {
                    while (currentCoroutineContext().isActive) {
                        try {
                            val position = getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
                            val playbackTimestampMs = effectiveReplayStartTimeMs + position
                            // Fetch from the deepest point already buffered rather than from the
                            // playhead, so each poll extends the buffer instead of re-requesting
                            // the window we are currently playing out.
                            val bufferedThroughMs = maxOf(kickReplayQueuedThroughMs ?: playbackTimestampMs, playbackTimestampMs)
                            val bufferedAheadMs = bufferedThroughMs - playbackTimestampMs
                            // Rewind one bucket before re-requesting. A page can end part way
                            // through a second, and if the endpoint treats start_time as exclusive,
                            // resuming exactly at the last message would drop the rest of that
                            // second. The overlap costs one redundant second per poll, which
                            // queueKickReplayMessages already discards by message id.
                            val fetchFromMs = (bufferedThroughMs - ChatReplayPacing.SPREAD_WINDOW_MS)
                                .coerceAtLeast(playbackTimestampMs)
                            val startTime = formatIso8601Utc(fetchFromMs)
                            logKickReplayChat(stage = "timeline_tick", sessionKey = sessionKey) {
                                "positionMs=$position startTime=$startTime bufferedAheadMs=$bufferedAheadMs pending=${kickReplayPendingMessages.size}"
                            }
                            if (bufferedAheadMs >= kickReplayTargetLookaheadMs) {
                                // Deep enough already; skipping the request keeps the poll rate off
                                // Kick's API when there is nothing to gain.
                                delay(kickReplayPollIntervalMs)
                                continue
                            }
                            val timelineMessages = fetchKickHistoryMessages(
                                messageSources = kickMessageSources,
                                startTime = startTime,
                                channelId = channelId,
                                channelLogin = channelLogin,
                                debugSessionKey = sessionKey,
                                debugPhase = "timeline",
                                maxPages = kickReplayTimelineMaxPages
                            )
                            val queueStats = queueKickReplayMessages(timelineMessages)
                            if (queueStats.queued > 0 || queueStats.alreadyQueued > 0) {
                                logKickReplayChat(stage = "queue", sessionKey = sessionKey) {
                                    "phase=timeline ${messageRangeSummary(timelineMessages)} total=${queueStats.total} queued=${queueStats.queued} alreadyEmitted=${queueStats.alreadyEmitted} alreadyQueued=${queueStats.alreadyQueued} pending=${kickReplayPendingMessages.size}"
                                }
                            }
                            // No emit here on purpose: the emit loop picks newly queued messages up
                            // within one tick, and releasing them here too would put an extra
                            // out-of-cadence batch on screen every poll.
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
                        delay(kickReplayPollIntervalMs)
                    }
                }
            }
            logKickReplayChat(stage = "session_end", sessionKey = sessionKey) {
                "reason=job_inactive"
            }
        }
    }

    private fun getClearMessage(
        chatMessage: ChatMessage,
        deletedMessage: ChatMessage?,
        nameDisplay: String?,
        deletedBy: String? = null,
    ): ChatMessage {
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
        val deletedText = deletedMessage?.message ?: chatMessage.message
        val message = if (!deletedBy.isNullOrBlank()) {
            if (deletedText.isNullOrBlank()) {
                ContextCompat.getString(applicationContext, R.string.chat_clearmsg_by_generic).format(deletedBy)
            } else {
                ContextCompat.getString(applicationContext, R.string.chat_clearmsg_by).format(deletedBy, deletedText)
            }
        } else if (userName.isNullOrBlank() && deletedText.isNullOrBlank()) {
            ContextCompat.getString(applicationContext, R.string.chat_clearmsg_generic)
        } else {
            ContextCompat.getString(applicationContext, R.string.chat_clearmsg).format(
                userName ?: ContextCompat.getString(applicationContext, R.string.pinned_gift_unknown_user),
                deletedText ?: ""
            )
        }
        val messageIndex = message.indexOf(": ") + 2
        return ChatMessage(
            userId = deletedMessage?.userId,
            userLogin = login,
            userName = deletedMessage?.userName,
            systemMsg = message,
            emotes = deletedMessage?.emotes?.map {
                ChatEmote(
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

    private suspend fun markMessageDeleted(targetId: String?, fallbackMessage: ChatMessage? = null): ChatMessage? {
        synchronized(rawChatMessages) {
            fun sameRawUser(candidate: ChatMessage): Boolean {
                return fallbackMessage != null && (
                    (!fallbackMessage.userId.isNullOrBlank() && candidate.userId == fallbackMessage.userId) ||
                        (!fallbackMessage.userLogin.isNullOrBlank() && candidate.userLogin.equals(fallbackMessage.userLogin, true)) ||
                        (!fallbackMessage.userName.isNullOrBlank() && candidate.userName.equals(fallbackMessage.userName, true))
                    )
            }

            val rawIndex = when {
                !targetId.isNullOrBlank() -> rawChatMessages.indexOfLast { it.id == targetId }
                fallbackMessage != null -> rawChatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted &&
                        candidate.message == fallbackMessage.message &&
                        sameRawUser(candidate)
                }
                else -> -1
            }.takeIf { it != -1 } ?: when {
                fallbackMessage != null && !fallbackMessage.message.isNullOrBlank() -> rawChatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted && candidate.message == fallbackMessage.message
                }
                fallbackMessage != null -> rawChatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted && sameRawUser(candidate)
                }
                else -> -1
            }
            if (rawIndex != -1) {
                rawChatMessages[rawIndex] = createDeletedMessage(rawChatMessages[rawIndex])
            }
        }
        val update = synchronized(chatMessages) {
            fun sameUser(candidate: ChatMessage): Boolean {
                return fallbackMessage != null && (
                    (!fallbackMessage.userId.isNullOrBlank() && candidate.userId == fallbackMessage.userId) ||
                        (!fallbackMessage.userLogin.isNullOrBlank() && candidate.userLogin.equals(fallbackMessage.userLogin, true)) ||
                        (!fallbackMessage.userName.isNullOrBlank() && candidate.userName.equals(fallbackMessage.userName, true))
                    )
            }

            val index = when {
                !targetId.isNullOrBlank() -> chatMessages.indexOfLast { it.id == targetId }
                fallbackMessage != null -> chatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted &&
                        candidate.message == fallbackMessage.message &&
                        sameUser(candidate)
                }
                else -> -1
            }.takeIf { it != -1 } ?: when {
                fallbackMessage != null && !fallbackMessage.message.isNullOrBlank() -> chatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted && candidate.message == fallbackMessage.message
                }
                fallbackMessage != null -> chatMessages.indexOfLast { candidate ->
                    !candidate.isDeleted && sameUser(candidate)
                }
                else -> -1
            }
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

    private suspend fun markUserMessagesDeleted(userId: String?, userLogin: String?, userName: String?) {
        synchronized(rawChatMessages) {
            rawChatMessages.replaceAll { message ->
                val matchesUser = (!userId.isNullOrBlank() && message.userId == userId) ||
                    (!userLogin.isNullOrBlank() && message.userLogin.equals(userLogin, true)) ||
                    (!userName.isNullOrBlank() && message.userName.equals(userName, true))
                if (!message.isReply && !message.isDeleted && matchesUser) {
                    createDeletedMessage(message)
                } else {
                    message
                }
            }
        }
        val updates = synchronized(chatMessages) {
            chatMessages.mapIndexedNotNull { index, message ->
                val matchesUser = (!userId.isNullOrBlank() && message.userId == userId) ||
                    (!userLogin.isNullOrBlank() && message.userLogin.equals(userLogin, true)) ||
                    (!userName.isNullOrBlank() && message.userName.equals(userName, true))
                if (!message.isReply && !message.isDeleted && matchesUser) {
                    val updatedMessage = createDeletedMessage(message)
                    chatMessages[index] = updatedMessage
                    index to updatedMessage
                } else {
                    null
                }
            }
        }
        updates.forEach { updateMessage.emit(it) }
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
        synchronized(rawChatMessages) {
            rawChatMessages.add(message)
            val removedRawItems = if (rawChatMessages.size > messageLimit) {
                List(rawChatMessages.size - messageLimit) { rawChatMessages.removeFirst() }
            } else {
                emptyList()
            }
            synchronized(chatMessages) {
                val removeCount = removedRawItems.count { !isMutedMessage(it) }
                repeat(removeCount.coerceAtMost(chatMessages.size)) {
                    chatMessages.removeFirst()
                }
                val visibleMessage = message.takeUnless(::isMutedMessage)
                if (visibleMessage != null) {
                    chatMessages.add(visibleMessage)
                    // Assign the row's alternating-shadow slot here, while we know it is the one
                    // message at the tail without one. Leaving it to bind time made every bind
                    // pay for a full sweep of the list looking for unassigned slots.
                    ChatListParityUtils.assignSlotForAppendedMessage(chatMessages)
                }
                if (newMessage.subscriptionCount.value > 0 && visibleMessage != null) {
                    Triple(visibleMessage, chatMessages.lastIndex, removeCount)
                } else {
                    null
                }
            }
        }?.let {
            newMessage.emit(it)
        }
    }

    fun startLiveChat(channelId: String?, channelLogin: String) {
        stopLiveChat()
        val kickPublicApiHeaders = KickApiHelper.getKickPublicApiHeaders(applicationContext)
        val networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp")
        val accountId = getKickAccountId()
        val isLoggedIn = com.github.andreyasadchy.xtra.util.AuthStateHelper.isKickLoggedIn(applicationContext)
        val showUserNotice = applicationContext.prefs().getBoolean(C.CHAT_SHOW_USERNOTICE, true)
        val showClearMsg = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARMSG, true)
        val showClearChat = applicationContext.prefs().getBoolean(C.CHAT_SHOW_CLEARCHAT, true)
        val notifyKickPoints = applicationContext.prefs().getBoolean(C.CHAT_POINTS_NOTIFY, true)
        val showPolls = applicationContext.prefs().getBoolean(C.CHAT_POLLS_SHOW, true)
        val showPredictions = applicationContext.prefs().getBoolean(C.CHAT_PREDICTIONS_SHOW, true)
        val nameDisplay = applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1")
        val showWebSocketDebugInfo = applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)
        if (showWebSocketDebugInfo) {
            Log.d("WebSocketRuntime", "connect chat snapshot=${WebSocketRuntime.snapshot()}")
        }
        val debugKickRealtimeChat = BuildConfig.DEBUG && applicationContext.prefs().getBoolean(C.DEBUG_KICK_REALTIME_CHAT, false)
        seedKickMessageIdsFromCurrentMessages()
        viewModelScope.launch {
            kickRepository.getInitialPinnedGift(channelLogin, channelId)?.let { update ->
                if (update.cleared) {
                    clearPinnedGift()
                } else {
                    updatePinnedGift(update.pinnedGift)
                }
            }
        }
        loadKickInitialRoomStateIfNeeded(channelId, channelLogin)
        chatReadJob = viewModelScope.launch {
            val resolvedChannel = runCatching {
                kickRepository.getChannel(channelLogin)
            }.onFailure {
                channelId?.takeIf { it.isNotBlank() }?.let { fallbackChannelId ->
                    runCatching { kickRepository.getChannel(fallbackChannelId) }
                }
            }.getOrNull()
            val effectiveChannelId = resolvedChannel?.id?.toString()?.takeIf { it.isNotBlank() }
                ?: channelId?.takeIf { it.isNotBlank() }
            val livestreamId = resolvedChannel?.livestream?.id?.toString()?.takeIf { it.isNotBlank() }
            val categoryId = resolvedChannel?.livestream?.category?.id?.toString()?.takeIf { it.isNotBlank() }
            val fallbackId = effectiveChannelId ?: channelLogin
            val kickChatroomId = if (!effectiveChannelId.isNullOrBlank()) {
                resolveKickRealtimeChatroomId(effectiveChannelId, channelLogin)
            } else {
                fallbackId
            }
            if (debugKickRealtimeChat) {
                Log.d("KickRealtimeChat", "resolved chatroomId=$kickChatroomId channelId=$effectiveChannelId channelLogin=$channelLogin")
            }
            if (!isActive) {
                return@launch
            }
            kickPusherChatWebSocket = KickPusherChatWebSocket(
                chatroomId = kickChatroomId,
                channelId = effectiveChannelId,
                publicChannelNames = buildList {
                    categoryId?.let { add("drops_category_$it") }
                },
                privateChannelNames = buildList {
                    accountId?.takeIf { it.isNotBlank() }?.let { add("private-channelpoints-$it") }
                    accountId?.takeIf { it.isNotBlank() }?.let { add("private-userfeed.$it") }
                    accountId?.takeIf { it.isNotBlank() }?.let { add("private-$it") }
                    livestreamId?.let { add("private-livestream.$it") }
                },
                authorizePrivateChannel = { privateChannelName, socketId ->
                    kickRepository.authorizeKickPusherPrivateChannel(socketId, privateChannelName)
                },
                trustManager = trustManager,
                listener = KickPusherChatListener(channelLogin, effectiveChannelId, nameDisplay, showUserNotice, showClearMsg, showClearChat, notifyKickPoints, showPolls, showPredictions, debugKickRealtimeChat),
                debugLogging = debugKickRealtimeChat
            )
            kickPusherChatWebSocket?.connect(this)?.join()
        }
        updateChannelPointsBalance(null)
        updateChannelPointRewards(emptyList(), false)
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

    fun refreshKickChannelPointState(
        networkLibrary: String?,
        channelId: String?,
        channelLogin: String?,
    ) {
        loadKickChannelPointState(networkLibrary, channelId, channelLogin)
    }

    private fun loadKickChannelPointState(
        networkLibrary: String?,
        channelId: String?,
        channelLogin: String?,
    ) {
        updateChannelPointsBalance(null)
        updateChannelPointRewards(emptyList(), false)
        latestPrediction.value = null
        if (channelLogin.isNullOrBlank()) {
            return
        }
        viewModelScope.launch {
            runCatching {
                kickRepository.getLatestKickPrediction(channelLogin)
            }.onSuccess {
                latestPrediction.value = it
            }
            val fallbackResult = runCatching {
                kickRepository.getChannelPointRewards(
                    channelSlug = channelLogin,
                    channelId = channelId,
                    forceRefresh = true,
                )
            }.getOrNull()
            val isOwnerChannel = getKickAccountLogin()?.equals(channelLogin, ignoreCase = true) == true
            val configuredScopes = applicationContext.prefs().getString(C.KICK_SCOPES, null)
            val canReadOfficialRewards = isOwnerChannel &&
                (
                    KickOAuthConfig.hasScopes(configuredScopes, setOf("channel:rewards:read")) ||
                        KickOAuthConfig.hasScopes(configuredScopes, setOf("channel:rewards:write"))
                    )
            val officialRewards = if (canReadOfficialRewards) {
                runCatching { kickRepository.getOfficialChannelRewards(networkLibrary) }
                    .getOrDefault(emptyList())
                    .map(::toChannelPointReward)
            } else {
                emptyList()
            }
            val mergedRewards = LinkedHashMap<String, ChannelPointReward>()
            fallbackResult?.rewards.orEmpty().forEach { reward ->
                val key = reward.id ?: "${reward.title.orEmpty()}|${reward.cost ?: -1}"
                mergedRewards[key] = reward
            }
            officialRewards.forEach { reward ->
                val key = reward.id ?: "${reward.title.orEmpty()}|${reward.cost ?: -1}"
                val existing = mergedRewards[key]
                mergedRewards[key] = if (existing == null) {
                    reward
                } else {
                    existing.copy(
                        title = reward.title ?: existing.title,
                        cost = reward.cost ?: existing.cost,
                        backgroundColor = reward.backgroundColor ?: existing.backgroundColor,
                        isEnabled = reward.isEnabled ?: existing.isEnabled,
                        isUserInputRequired = reward.isUserInputRequired ?: existing.isUserInputRequired,
                        prompt = reward.prompt ?: existing.prompt,
                    )
                }
            }
            updateChannelPointsBalance(fallbackResult?.balance)
            updateChannelPointRewards(
                rewards = mergedRewards.values.toList(),
                available = fallbackResult?.available == true || officialRewards.isNotEmpty()
            )
        }
    }

    private fun toChannelPointReward(reward: KickOfficialReward): ChannelPointReward {
        return ChannelPointReward(
            id = reward.id,
            title = reward.title,
            cost = reward.cost,
            backgroundColor = reward.backgroundColor,
            isEnabled = reward.isEnabled,
            isUserInputRequired = reward.isUserInputRequired,
            prompt = reward.description,
        )
    }

    fun stopLiveChat() {
        markIntentionalChatDisconnect()
        if (applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)) {
            Log.d("WebSocketRuntime", "disconnect chat snapshot(before)=${WebSocketRuntime.snapshot()}")
        }
        kickChatJob?.cancel()
        kickChatJob = null
        synchronized(kickMessageIds) {
            kickMessageIds.clear()
        }
        // Capture into a local: `kickPusherChatWebSocket = null` below runs synchronously on
        // this thread, before the dispatched Dispatchers.IO body ever starts, so reading the
        // field inside the coroutine always resolved null and the disconnect was a no-op. That
        // leaked one Dispatchers.IO thread parked in a blocking read per teardown, left the
        // Pusher socket reconnecting forever, and kept the old channel's listener ingesting
        // messages after every channel switch.
        val pusherSocket = kickPusherChatWebSocket
        if (pusherSocket != null) {
            val jobToCancel = chatReadJob
            MainScope().launch(Dispatchers.IO) {
                pusherSocket.disconnect(jobToCancel)
            }
        }
        kickPusherChatWebSocket = null
        if (stvEventApi != null) {
            MainScope().launch(Dispatchers.IO) {
                stvEventApi?.disconnect(stvEventApiJob)
            }
        }
        if (applicationContext.prefs().getBoolean(C.DEBUG_WEBSOCKET_INFO, false)) {
            Log.d("WebSocketRuntime", "disconnect chat snapshot(after)=${WebSocketRuntime.snapshot()}")
        }
    }

    fun isActive(): Boolean {
        if (!autoReconnect) {
            return false
        }
        return kickLivePollingFallbackActive || kickChatJob?.isActive == true || chatReadJob?.isActive == true
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
        currentPrediction = null
        latestPrediction.value = null
        predictionClosed = true
        predictionSecondsLeft.value = null
        predictionTimer?.cancel()
        viewModelScope.launch {
            synchronized(chatMessages) {
                val size = chatMessages.size
                chatMessages.clear()
                synchronized(rawChatMessages) {
                    rawChatMessages.clear()
                }
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
        kickInitialRoomStateLoaded = false
        autoReconnect = false
    }

    private inner class KickPusherChatListener(
        private val channelLogin: String,
        private val channelId: String?,
        private val nameDisplay: String?,
        private val showUserNotice: Boolean,
        private val showClearMsg: Boolean,
        private val showClearChat: Boolean,
        private val notifyPoints: Boolean,
        private val showPolls: Boolean,
        private val showPredictions: Boolean,
        private val debugLogging: Boolean,
    ) : KickPusherChatWebSocket.Listener {
        override suspend fun onConnect() {
            kickRealtimeReconnectAttempt = 0
            onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_join).format(channelLogin)))
        }

        override suspend fun onChatEvent(eventName: String, channelName: String?, messageJson: String) {
            val normalizedEvent = eventName.trim().lowercase(Locale.ROOT)
            if (eventName.equals("App\\Events\\PollDeleteEvent", ignoreCase = true)) {
                pollTimer?.cancel()
                pollSecondsLeft.value = null
                poll.value = null
                if (!hidePoll.value) {
                    hidePoll.value = true
                }
                return
            }
            kickRepository.parseKickRealtimeChannelPointsUpdate(eventName, messageJson)?.let { pointsUpdate ->
                val currentAccountId = getKickAccountId()
                val isCurrentUser = currentAccountId.isNullOrBlank() || pointsUpdate.userId.isNullOrBlank() || currentAccountId == pointsUpdate.userId
                val isCurrentChannel = channelId.isNullOrBlank() || pointsUpdate.channelId.isNullOrBlank() || channelId == pointsUpdate.channelId
                if (isCurrentUser && isCurrentChannel) {
                    updateChannelPointsBalance(pointsUpdate.balance)
                    if (notifyPoints && pointsUpdate.reason.equals("EARNED", ignoreCase = true) && (pointsUpdate.points ?: 0) > 0) {
                        onMessage(
                            ChatMessage(
                                systemMsg = ContextCompat.getString(applicationContext, R.string.points_earned).format(pointsUpdate.points),
                                fullMsg = messageJson,
                            )
                        )
                    }
                }
            }
            if (showPolls) {
                kickRepository.parseKickRealtimePollUpdate(eventName, messageJson)?.let {
                    applyPollUpdate(it)
                    return
                }
            }
            if (showPredictions) {
                kickRepository.parseKickRealtimePredictionUpdate(eventName, messageJson)?.let {
                    applyPredictionUpdate(it)
                    return
                }
            }
            if (normalizedEvent == "chatroomclearevent" || normalizedEvent == "app\\events\\chatroomclearevent") {
                if (showClearChat) {
                    clearChatMessages()
                    emitKickMessages(
                        listOf(
                            ChatMessage(
                                id = "kick_clear_chat:${messageJson.hashCode()}",
                                systemMsg = ContextCompat.getString(applicationContext, R.string.chat_clear),
                                msgId = "kick_moderation",
                                fullMsg = messageJson,
                            )
                        )
                    )
                }
                return
            }
            kickRepository.parseKickChannelMoveEvent(eventName, messageJson)?.let { moveEvent ->
                if (showUserNotice) {
                    emitKickMessages(
                        listOf(
                            ChatMessage(
                                id = moveEvent.raid.raidId ?: "kick_move:${moveEvent.message.hashCode()}",
                                systemMsg = moveEvent.message,
                                msgId = "kick_usernotice",
                                fullMsg = moveEvent.rawPayload,
                            )
                        )
                    )
                }
                if (!moveEvent.raid.raidId.isNullOrBlank() && moveEvent.raid.raidId != usedRaidId) {
                    usedRaidId = moveEvent.raid.raidId
                    raidClosed = false
                }
                raid.value = moveEvent.raid
                return
            }
            kickRepository.parsePinnedGiftUpdate(eventName, messageJson)?.let { update ->
                if (update.cleared) {
                    clearPinnedGift()
                } else {
                    updatePinnedGift(update.pinnedGift)
                }
            }
            val shouldRefreshRoomState = kickRepository.shouldRefreshRoomStateFromRealtimeEvent(eventName, messageJson)
            kickRepository.parseRealtimeRoomStateUpdate(eventName, messageJson)?.let { updatedRoomState ->
                roomState.value = updatedRoomState
            }
            if (shouldRefreshRoomState) {
                loadKickInitialRoomStateIfNeeded(channelId, channelLogin, forceRefresh = true)
            }
            kickRepository.parseKickRealtimeEvent(eventName, messageJson)?.let { parsedEvent ->
                if (!parsedEvent.clearTargetUserId.isNullOrBlank() ||
                    !parsedEvent.clearTargetUserLogin.isNullOrBlank() ||
                    !parsedEvent.clearTargetUserName.isNullOrBlank()
                ) {
                    markUserMessagesDeleted(
                        parsedEvent.clearTargetUserId,
                        parsedEvent.clearTargetUserLogin,
                        parsedEvent.clearTargetUserName
                    )
                }
                val parsedChatMessage = parsedEvent.chatMessage
                if (parsedChatMessage.msgId == "kick_usernotice" && !showUserNotice) {
                    return
                }
                if (parsedChatMessage.msgId == "kick_moderation" && !showClearChat) {
                    return
                }
                if (parsedChatMessage.message.isNullOrBlank() &&
                    parsedChatMessage.systemMsg.isNullOrBlank() &&
                    parsedChatMessage.msgId == null
                ) {
                    return
                }
                if (addKickInlineEmotes(parsedChatMessage.fullMsg)) {
                    thirdPartyEmotesUpdated.emit(Unit)
                }
                emitKickMessages(listOf(parsedChatMessage))
                return
            }
            val realtimeMessage = parseKickRealtimeMessage(eventName, messageJson) ?: run {
                logUnsupportedKickRealtimeEvent(eventName, channelName, messageJson)
                return
            }
            val kickMessage = realtimeMessage.message
            val chatMessage = kickRepository.toChatMessage(kickMessage, realtimeMessage.eventName)
            if (kickRepository.isKickSingleMessageDelete(kickMessage, realtimeMessage.eventName)) {
                if (!showClearMsg) {
                    return
                }
                val targetId = kickRepository.getKickModerationTargetMessageId(kickMessage)
                val deletedMessage = markMessageDeleted(targetId, chatMessage)
                if (deletedMessage == null) {
                    val deletedBy = if (realtimeMessage.aiModerated) {
                        ContextCompat.getString(applicationContext, R.string.kick_automod)
                    } else {
                        null
                    }
                    onMessage(getClearMessage(chatMessage, null, nameDisplay, deletedBy))
                }
                return
            }
            when (realtimeMessage.eventName) {
                "App\\Events\\UserBannedEvent" -> {
                    val (targetUserId, targetUserLogin, targetUserName) = kickRepository.getKickModerationTargetUserInfo(kickMessage)
                    if (!targetUserId.isNullOrBlank() || !targetUserLogin.isNullOrBlank() || !targetUserName.isNullOrBlank()) {
                        markUserMessagesDeleted(targetUserId, targetUserLogin, targetUserName)
                    }
                }
            }
            if (chatMessage.message.isNullOrBlank() && chatMessage.systemMsg.isNullOrBlank() && chatMessage.msgId == null) {
                return
            }
            if (chatMessage.msgId == "kick_usernotice" && !showUserNotice) {
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
                thirdPartyEmotesUpdated.emit(Unit)
            }
            emitKickMessages(listOf(chatMessage))
        }

        private fun logUnsupportedKickRealtimeEvent(eventName: String, channelName: String?, messageJson: String) {
            if (!debugLogging) return
            DiagnosticLogger.w(
                "KickRealtimeChat",
                "unsupported event=$eventName channel=${channelName ?: "<none>"} payload=${messageJson.take(300)}"
            )
        }

        override suspend fun onDisconnect(message: String, fullMsg: String?) {
            if (shouldSuppressIntentionalChatDisconnect(message)) {
                return
            }
            val isHostResolutionFailure = WebSocketDisconnectUtils.isHostResolutionFailure(message)
            val isTransientGatewayFailure = WebSocketDisconnectUtils.isTransientGatewayFailure(message)
            if (isTransientGatewayFailure) {
                DiagnosticLogger.w(
                    "KickRealtimeChat",
                    "transient gateway disconnect channel=$channelLogin attempt=${kickRealtimeReconnectAttempt + 1} message=$message"
                )
            }
            val shouldEmitDisconnect = shouldEmitKickRealtimeDisconnect(message)
            if (!isHostResolutionFailure && !isTransientGatewayFailure && shouldEmitDisconnect) {
                onMessage(
                    ChatMessage(
                        systemMsg = ContextCompat.getString(applicationContext, R.string.chat_disconnect).format(channelLogin, message),
                        fullMsg = fullMsg
                    )
                )
            } else if (isTransientGatewayFailure && shouldEmitDisconnect) {
                onMessage(ChatMessage(systemMsg = ContextCompat.getString(applicationContext, R.string.chat_reconnecting).format(channelLogin), fullMsg = fullMsg))
            }
            if (!channelLogin.isBlank() && autoReconnect && !isHostResolutionFailure) {
                val delayMs = if (isTransientGatewayFailure) {
                    kickRealtimeReconnectAttempt = (kickRealtimeReconnectAttempt + 1).coerceAtMost(5)
                    1000L * kickRealtimeReconnectAttempt
                } else {
                    3000L
                }
                viewModelScope.launch {
                    delay(delayMs)
                    if (chatReadJob?.isActive != true) {
                        startLiveChat(channelId, channelLogin)
                    }
                }
            }
        }
    }

    private fun applyPredictionUpdate(predictionUpdate: Prediction) {
        val mergedPrediction = currentPrediction
            ?.takeIf { it.id == predictionUpdate.id }
            ?.let { existing ->
                Prediction(
                    id = predictionUpdate.id ?: existing.id,
                    createdAt = predictionUpdate.createdAt ?: existing.createdAt,
                    endedAt = predictionUpdate.endedAt ?: existing.endedAt,
                    outcomes = predictionUpdate.outcomes ?: existing.outcomes,
                    predictionWindowSeconds = predictionUpdate.predictionWindowSeconds ?: existing.predictionWindowSeconds,
                    status = predictionUpdate.status ?: existing.status,
                    title = predictionUpdate.title ?: existing.title,
                    winningOutcomeId = predictionUpdate.winningOutcomeId ?: existing.winningOutcomeId,
                    userVote = predictionUpdate.userVote ?: existing.userVote,
                )
            } ?: predictionUpdate
        if (mergedPrediction.id != usedPredictionId) {
            usedPredictionId = mergedPrediction.id
            predictionClosed = false
            predictionTimeoutJob?.cancel()
            if (mergedPrediction.createdAt != null && mergedPrediction.predictionWindowSeconds != null) {
                val secondsLeft = ((((mergedPrediction.createdAt + (mergedPrediction.predictionWindowSeconds * 1000)) - System.currentTimeMillis())) / 1000).toInt()
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
        } else if (mergedPrediction.status == "LOCKED" || mergedPrediction.status == "CANCEL_PENDING" || mergedPrediction.status == "RESOLVE_PENDING") {
            predictionClosed = false
        }
        currentPrediction = mergedPrediction
        latestPrediction.value = mergedPrediction
        prediction.value = mergedPrediction
    }

    private fun applyPollUpdate(pollUpdate: Poll) {
        val mergedPoll = poll.value
            ?.takeIf { it.id == pollUpdate.id }
            ?.let { existing ->
                Poll(
                    id = pollUpdate.id ?: existing.id,
                    title = pollUpdate.title ?: existing.title,
                    status = pollUpdate.status ?: existing.status,
                    choices = pollUpdate.choices ?: existing.choices,
                    totalVotes = pollUpdate.totalVotes ?: existing.totalVotes,
                    remainingMilliseconds = pollUpdate.remainingMilliseconds ?: existing.remainingMilliseconds,
                    resultDisplayMilliseconds = pollUpdate.resultDisplayMilliseconds ?: existing.resultDisplayMilliseconds,
                    hasVoted = pollUpdate.hasVoted ?: existing.hasVoted,
                    votedChoiceId = pollUpdate.votedChoiceId ?: existing.votedChoiceId,
                )
            } ?: pollUpdate
        val shouldResetTimer = mergedPoll.status == "ACTIVE"
        if (mergedPoll.id != usedPollId) {
            usedPollId = mergedPoll.id
            pollClosed = false
            pollTimeoutJob?.cancel()
        } else if (mergedPoll.status == "COMPLETED" || mergedPoll.status == "TERMINATED") {
            pollClosed = false
        }
        poll.value = mergedPoll
        if (shouldResetTimer) {
            restartPollCountdown(mergedPoll)
        } else {
            pollTimer?.cancel()
            pollSecondsLeft.value = null
        }
    }

    fun applyLocalPollUpdate(pollUpdate: Poll) {
        applyPollUpdate(pollUpdate)
    }

    fun applyLocalPredictionUpdate(predictionUpdate: Prediction) {
        applyPredictionUpdate(predictionUpdate)
    }

    private fun restartPollCountdown(pollUpdate: Poll) {
        val secondsLeft = (pollUpdate.remainingMilliseconds ?: 0) / 1000
        pollTimer?.cancel()
        if (secondsLeft <= 0) {
            pollSecondsLeft.value = null
            poll.value = pollUpdate.copyCompleted()
            return
        }
        pollSecondsLeft.value = secondsLeft
        pollTimer = viewModelScope.launch {
            while (isActive) {
                delay(1000)
                val seconds = pollSecondsLeft.value ?: break
                if (seconds <= 1) {
                    pollSecondsLeft.value = null
                    val currentPoll = poll.value
                    if (currentPoll != null) {
                        val completedPoll = currentPoll.copyCompleted()
                        poll.value = completedPoll
                    }
                    break
                } else {
                    pollSecondsLeft.value = seconds - 1
                }
            }
        }
    }

    private fun Poll.copyCompleted(): Poll {
        return Poll(
            id = id,
            title = title,
            status = "COMPLETED",
            choices = choices,
            totalVotes = totalVotes,
            remainingMilliseconds = 0,
            resultDisplayMilliseconds = resultDisplayMilliseconds,
            hasVoted = hasVoted,
            votedChoiceId = votedChoiceId,
        )
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
        val directAiModerated = runCatching { JSONObject(messageJson) }.getOrNull()?.optBoolean("aiModerated", false) == true
        decodeCandidate(messageJson)?.let { return KickRealtimeMessage(eventName, it, directAiModerated) }
        val root = runCatching { JSONObject(messageJson) }.getOrNull() ?: return null
        val candidates = mutableListOf<String>()
        var aiModerated = root.optBoolean("aiModerated", false)
        fun addObj(obj: JSONObject?) {
            if (obj != null) candidates.add(obj.toString())
        }
        addObj(root)
        root.optJSONObject("data")?.let {
            aiModerated = aiModerated || it.optBoolean("aiModerated", false)
            addObj(it)
        }
        root.optJSONObject("message")?.let {
            aiModerated = aiModerated || it.optBoolean("aiModerated", false)
            addObj(it)
        }
        root.optJSONObject("payload")?.let {
            aiModerated = aiModerated || it.optBoolean("aiModerated", false)
            addObj(it)
        }
        val dataRaw = root.opt("data")
        if (dataRaw is String) {
            runCatching { JSONObject(dataRaw) }.getOrNull()?.let {
                aiModerated = aiModerated || it.optBoolean("aiModerated", false)
                addObj(it)
            }
            val arr = runCatching { JSONArray(dataRaw) }.getOrNull()
            if (arr != null) {
                for (i in 0 until arr.length()) {
                    addObj(arr.optJSONObject(i))
                }
            }
        }
        val payload = root.optJSONObject("payload")
        payload?.optJSONObject("data")?.let {
            aiModerated = aiModerated || it.optBoolean("aiModerated", false)
            addObj(it)
        }
        for (candidate in candidates) {
            decodeCandidate(candidate)?.let { return KickRealtimeMessage(eventName, it, aiModerated) }
        }
        return null
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

    fun startPollTimeout(delayMs: Long = 20_000L, hide: () -> Unit) {
        pollTimeoutJob?.cancel()
        pollTimeoutJob = viewModelScope.launch {
            delay(delayMs)
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

    fun send(message: CharSequence, replyId: String?, networkLibrary: String?, kickWebHeaders: Map<String, String>, kickPublicApiHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiCommands: Boolean, useApiChatMessages: Boolean, enableIntegrity: Boolean) {
        if (replyId != null) {
            sendMessage(message, networkLibrary, channelId, channelLogin, replyId)
        } else {
            if (useApiCommands) {
                if (message.toString().startsWith("/")) {
                    try {
                        sendCommand(message, networkLibrary, kickPublicApiHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
                    } catch (e: Exception) {

                    }
                } else {
                    sendMessage(message, networkLibrary, channelId, channelLogin)
                }
            } else {
                if (message.toString() == "/dc" || message.toString() == "/disconnect") {
                    disconnect()
                } else {
                    sendMessage(message, networkLibrary, channelId, channelLogin)
                }
            }
        }
    }

    private fun sendMessage(message: CharSequence, networkLibrary: String?, channelId: String?, channelLogin: String?, replyId: String? = null) {
        try {
            viewModelScope.launch {
                val accessToken = try {
                    getKickAccessTokenForChatSend()
                } catch (e: Exception) {
                    if (KickAuthRequestException.isBackendUnavailable(e)) {
                        onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, applicationContext.getString(R.string.kick_oauth_backend_unreachable))))
                    } else {
                        AuthStateHelper.markUnexpectedLogout(applicationContext)
                        AuthStateHelper.clearKickAuth(applicationContext)
                        AuthStateHelper.clearLegacyWebAuth(applicationContext)
                        onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, applicationContext.getString(R.string.token_expired))))
                    }
                    return@launch
                }
                val broadcasterId = resolveKickBroadcasterUserId(channelId, channelLogin)
                if (!accessToken.isNullOrBlank() && broadcasterId != null) {
                    runCatching {
                        kickRepository.sendChatMessage(accessToken, broadcasterId, message.toString(), replyId)
                    }.onFailure { initialError ->
                        if (initialError.message?.contains("(401)", ignoreCase = true) == true) {
                            val retryToken = try {
                                getKickAccessTokenForChatSend(forceRefresh = true)
                            } catch (refreshError: Exception) {
                                if (!KickAuthRequestException.isBackendUnavailable(refreshError)) {
                                    AuthStateHelper.markUnexpectedLogout(applicationContext)
                                    AuthStateHelper.clearKickAuth(applicationContext)
                                    AuthStateHelper.clearLegacyWebAuth(applicationContext)
                                }
                                null
                            }
                            if (!retryToken.isNullOrBlank()) {
                                runCatching {
                                    kickRepository.sendChatMessage(retryToken, broadcasterId, message.toString(), replyId)
                                }.onFailure { retryError ->
                                    onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, formatKickChatSendError(retryError))))
                                }
                            } else {
                                onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, applicationContext.getString(R.string.token_expired))))
                            }
                        } else {
                            onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, formatKickChatSendError(initialError))))
                        }
                    }
                } else {
                    val reason = if (accessToken.isNullOrBlank()) {
                        "missing kick auth scope"
                    } else {
                        "missing kick broadcaster user id"
                    }
                    onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, reason)))
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

    private fun formatKickChatSendError(error: Throwable): String {
        return when (KickChatSendErrorMapper.classify(error.message, roomState.value)) {
            KickChatSendErrorMapper.Reason.TOKEN_EXPIRED -> applicationContext.getString(R.string.token_expired)
            KickChatSendErrorMapper.Reason.FOLLOWERS_ONLY -> {
                val followersDuration = roomState.value?.followers?.takeIf { it != "-1" && it != "0" }
                if (followersDuration != null) {
                    applicationContext.getString(
                        R.string.kick_chat_send_followers_for,
                        KickApiHelper.getDurationFromSeconds(applicationContext, followersDuration)
                    )
                } else {
                    applicationContext.getString(R.string.kick_chat_send_followers_only)
                }
            }
            KickChatSendErrorMapper.Reason.SUBSCRIBERS_ONLY -> applicationContext.getString(R.string.irc_notice_msg_subsonly)
            KickChatSendErrorMapper.Reason.EMOTES_ONLY -> applicationContext.getString(R.string.irc_notice_msg_emoteonly)
            KickChatSendErrorMapper.Reason.SLOW_MODE -> applicationContext.getString(
                R.string.irc_notice_msg_slowmode,
                roomState.value?.slow?.takeIf { it != "0" } ?: "0"
            )
            KickChatSendErrorMapper.Reason.BOT_PROTECTION -> applicationContext.getString(R.string.kick_chat_send_bot_protection)
            KickChatSendErrorMapper.Reason.RATE_LIMITED -> applicationContext.getString(R.string.irc_notice_msg_ratelimit)
            KickChatSendErrorMapper.Reason.FORBIDDEN -> applicationContext.getString(R.string.kick_chat_send_forbidden)
            KickChatSendErrorMapper.Reason.GENERIC -> error.message
                ?.takeUnless { it.contains('{') || it.contains("Kick request failed", ignoreCase = true) }
                ?.take(180)
                ?: applicationContext.getString(R.string.kick_chat_send_forbidden)
        }
    }

    private fun sendCommand(message: CharSequence, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiChatMessages: Boolean, enableIntegrity: Boolean) {
        sendKickCommand(message, networkLibrary, kickPublicApiHeaders, accountId, channelId, channelLogin, useApiChatMessages, enableIntegrity)
    }

    /**
     * Kick slash commands: use Kick official/public APIs only (never Twitch GQL).
     */
    private fun sendKickCommand(
        message: CharSequence,
        networkLibrary: String?,
        kickPublicApiHeaders: Map<String, String>,
        accountId: String?,
        channelId: String?,
        channelLogin: String?,
        useApiChatMessages: Boolean,
        enableIntegrity: Boolean,
    ) {
        val command = message.toString().substringBefore(" ")
        val hasPublicToken = !kickPublicApiHeaders[C.HEADER_TOKEN].isNullOrBlank()
        val kickWebHeaders = KickApiHelper.getKickWebHeaders(applicationContext, true)
        fun missingAuth() {
            viewModelScope.launch {
                onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, applicationContext.getString(R.string.token_expired))))
            }
        }
        suspend fun emitError(error: Throwable) {
            onMessage(ChatMessage(systemMsg = applicationContext.getString(R.string.chat_send_msg_error, error.message ?: error.toString())))
        }
        suspend fun emitInfo(text: String?) {
            if (!text.isNullOrBlank()) {
                onMessage(ChatMessage(systemMsg = text))
            }
        }
        suspend fun resolveTargetUserId(login: String): String? {
            return runCatching {
                kickPublicApiRepository.getUsers(
                    networkLibrary = networkLibrary,
                    headers = kickPublicApiHeaders,
                    logins = listOf(login),
                ).data.firstOrNull()?.channelId
            }.getOrNull()
                ?: runCatching {
                    kickRepository.getChannel(login).id?.toString()
                        ?: kickRepository.getChannel(login).user?.id?.toString()
                }.getOrNull()
        }
        when {
            command.startsWith("/announce", true) -> {
                val splits = message.split(" ", limit = 2)
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.sendAnnouncement(
                                networkLibrary, kickPublicApiHeaders, channelId, accountId, splits[1],
                                splits[0].substringAfter("/announce", "").ifBlank { null },
                            )
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/ban", true) -> {
                val splits = message.split(" ", limit = 3)
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            val broadcasterUserId = channelId?.toLongOrNull()
                            val targetUserId = targetId?.toLongOrNull()
                            if (broadcasterUserId != null && targetUserId != null) {
                                kickRepository.banOfficialUser(
                                    networkLibrary = networkLibrary,
                                    broadcasterUserId = broadcasterUserId,
                                    targetUserId = targetUserId,
                                    reason = if (splits.size >= 3) splits[2] else null,
                                )
                                null
                            } else if (hasPublicToken) {
                                kickPublicApiRepository.banUser(
                                    networkLibrary, kickPublicApiHeaders, channelId, accountId, targetId,
                                    reason = if (splits.size >= 3) splits[2] else null,
                                )
                            } else {
                                throw IllegalStateException(applicationContext.getString(R.string.token_expired))
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                }
            }
            command.equals("/unban", true) || command.equals("/untimeout", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            val broadcasterUserId = channelId?.toLongOrNull()
                            val targetUserId = targetId?.toLongOrNull()
                            if (broadcasterUserId != null && targetUserId != null) {
                                kickRepository.unbanOfficialUser(
                                    networkLibrary = networkLibrary,
                                    broadcasterUserId = broadcasterUserId,
                                    targetUserId = targetUserId,
                                )
                                null
                            } else if (hasPublicToken) {
                                kickPublicApiRepository.unbanUser(networkLibrary, kickPublicApiHeaders, channelId, accountId, targetId)
                            } else {
                                throw IllegalStateException(applicationContext.getString(R.string.token_expired))
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                }
            }
            command.equals("/timeout", true) -> {
                val splits = message.split(" ", limit = 4)
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            val broadcasterUserId = channelId?.toLongOrNull()
                            val targetUserId = targetId?.toLongOrNull()
                            val durationSeconds = if (splits.size >= 3) {
                                splits[2].toIntOrNull()
                                    ?: KickApiHelper.getDuration(splits[2])?.toInt()
                                    ?: 600
                            } else {
                                600
                            }
                            if (broadcasterUserId != null && targetUserId != null) {
                                kickRepository.banOfficialUser(
                                    networkLibrary = networkLibrary,
                                    broadcasterUserId = broadcasterUserId,
                                    targetUserId = targetUserId,
                                    durationSeconds = durationSeconds,
                                    reason = if (splits.size >= 4) splits[3] else null,
                                )
                                null
                            } else if (hasPublicToken) {
                                kickPublicApiRepository.banUser(
                                    networkLibrary, kickPublicApiHeaders, channelId, accountId, targetId,
                                    duration = durationSeconds.toString(),
                                    reason = if (splits.size >= 4) splits[3] else null,
                                )
                            } else {
                                throw IllegalStateException(applicationContext.getString(R.string.token_expired))
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                }
            }
            command.equals("/clear", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.deleteMessages(networkLibrary, kickPublicApiHeaders, channelId, accountId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else {
                    missingAuth()
                }
            }
            command.equals("/delete", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    viewModelScope.launch {
                        runCatching {
                            kickRepository.deleteOfficialChatMessage(networkLibrary, splits[1])
                            null
                        }.onSuccess { emitInfo(it) }.onFailure { error ->
                            if (hasPublicToken) {
                                runCatching {
                                    kickPublicApiRepository.deleteMessages(networkLibrary, kickPublicApiHeaders, channelId, accountId, splits[1])
                                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                            } else {
                                emitError(error)
                            }
                        }
                    }
                }
            }
            command.equals("/color", true) -> {
                val splits = message.split(" ")
                if (!hasPublicToken) {
                    missingAuth()
                } else {
                    viewModelScope.launch {
                        runCatching {
                            if (splits.size >= 2) {
                                kickPublicApiRepository.updateChatColor(networkLibrary, kickPublicApiHeaders, accountId, splits[1])
                            } else {
                                kickPublicApiRepository.getChatColor(networkLibrary, kickPublicApiHeaders, accountId)
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                }
            }
            command.equals("/commercial", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.startCommercial(networkLibrary, kickPublicApiHeaders, channelId, splits[1])
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/disconnect", true) -> disconnect()
            command.equals("/emoteonly", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, emote = true)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/emoteonlyoff", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, emote = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/followers", true) -> {
                val splits = message.split(" ")
                val duration = if (splits.size >= 2) splits[1].toIntOrNull() else null
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(
                                networkLibrary, kickPublicApiHeaders, channelId, accountId,
                                followers = true, followersDuration = duration,
                            )
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/followersoff", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, followers = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/marker", true) -> {
                val splits = message.split(" ", limit = 2)
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.createStreamMarker(
                                networkLibrary, kickPublicApiHeaders, channelId,
                                if (splits.size >= 2) splits[1] else null,
                            )
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/mod", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.addModerator(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/unmod", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.removeModerator(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/mods", true) -> {
                viewModelScope.launch {
                    onMessage(ChatMessage(systemMsg = "Listing moderators is not available via Kick API in this build."))
                }
            }
            command.equals("/raid", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.startRaid(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/unraid", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.cancelRaid(networkLibrary, kickPublicApiHeaders, channelId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/slow", true) -> {
                val splits = message.split(" ")
                val duration = if (splits.size >= 2) splits[1].toIntOrNull() else null
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(
                                networkLibrary, kickPublicApiHeaders, channelId, accountId,
                                slow = true, slowDuration = duration,
                            )
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/slowoff", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, slow = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/subscribers", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, subs = true)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/subscribersoff", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, subs = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/uniquechat", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, unique = true)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/uniquechatoff", true) -> {
                if (hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, unique = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/vip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.addVip(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/unvip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.removeVip(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/vips", true) -> {
                viewModelScope.launch {
                    onMessage(ChatMessage(systemMsg = "Listing VIPs is not available via Kick API in this build."))
                }
            }
            command.equals("/w", true) -> {
                val splits = message.split(" ", limit = 3)
                if (splits.size >= 3 && hasPublicToken) {
                    viewModelScope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.sendWhisper(networkLibrary, kickPublicApiHeaders, accountId, targetId, splits[2])
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 3) {
                    missingAuth()
                }
            }
            else -> sendMessage(message, networkLibrary, channelId, channelLogin)
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
            kickReplayLastPlaybackPositionMs = null
            chatReplayManagerLocal = ChatReplayManagerLocal(
                getCurrentPosition = getCurrentPosition,
                getCurrentSpeed = getCurrentSpeed,
                coroutineScope = viewModelScope,
                listener = ChatReplayListener(),
            )
            readChatFile(chatUrl, channelId, channelLogin, startTime.takeIf { it >= 0 })
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
                val startTimeMs = kickReplayFallbackStartTimeMs ?: 0L
                val isClipReplay = kickReplayUrl?.contains("/clips/", ignoreCase = true) == true ||
                        kickReplayUrl?.contains("clips.kick.com", ignoreCase = true) == true
                startKickReplayChat(
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelLogin,
                    replayStartTimeMs = startTimeMs,
                    kickReplayUrl = kickReplayUrl,
                    getCurrentPosition = getCurrentPosition,
                    showClipStartMarker = isClipReplay
                )
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
            kickReplayLastPlaybackPositionMs = null
            if (!videoId.isNullOrBlank()) {
                chatReplayManager = ChatReplayManager(
                    networkLibrary = applicationContext.prefs().getString(C.NETWORK_LIBRARY, "OkHttp"),
                    kickWebHeaders = KickApiHelper.getKickWebHeaders(applicationContext, true),
                    kickGraphQLRepository = kickGraphQLRepository,
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

    fun startReplayChatLoad(seekPosition: Long? = null) {
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
                (seekPosition != null || kickChatJob?.isActive != true)
            ) {
                logKickReplayChat(stage = "startReplayChatLoad", sessionKey = kickReplaySessionKey) {
                    "restarting_fallback channelId=$channelId seekPosition=$seekPosition"
                }
                val isClipReplay = kickReplayUrl?.contains("/clips/", ignoreCase = true) == true ||
                        kickReplayUrl?.contains("clips.kick.com", ignoreCase = true) == true
                startKickReplayChat(
                    channelId = channelId,
                    channelLogin = channelLogin,
                    channelName = channelLogin,
                    replayStartTimeMs = replayStartTimeMs,
                    kickReplayUrl = kickReplayUrl,
                    getCurrentPosition = getCurrentPosition,
                    showClipStartMarker = isClipReplay,
                    seekPosition = seekPosition
                )
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
            kickReplayMessageSources = null
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

    private suspend fun resolveInitialKickReplayPlaybackPosition(
        currentPlaybackPositionMs: Long,
        getCurrentPosition: () -> Long?,
        sessionKey: String,
    ): Long {
        if (currentPlaybackPositionMs > 0L) {
            return currentPlaybackPositionMs
        }
        repeat(10) {
            delay(150L)
            val resolvedPosition = getCurrentPosition()?.coerceAtLeast(0L) ?: 0L
            if (resolvedPosition > 0L) {
                logKickReplayChat(stage = "initial_position_resolved", sessionKey = sessionKey) {
                    "from=$currentPlaybackPositionMs to=$resolvedPosition"
                }
                return resolvedPosition
            }
        }
        return currentPlaybackPositionMs
    }

    private fun formatIso8601Utc(timestampMs: Long): String {
        // Kick's history API requires milliseconds in the timestamp (e.g. 2026-04-30T17:06:00.000Z).
        // Without milliseconds the VOD history endpoint returns empty results.
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val instant = java.time.Instant.ofEpochMilli(timestampMs)
            val seconds = instant.epochSecond
            val millis = instant.nano / 1_000_000
            val base = java.time.Instant.ofEpochSecond(seconds).toString() // e.g. 2026-04-30T17:06:00Z
            if (base.endsWith("Z")) {
                base.dropLast(1) + "." + millis.toString().padStart(3, '0') + "Z"
            } else {
                base
            }
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
            appendChatMessagesInBulk(messages)
        }

        override suspend fun clearMessages() {
            synchronized(chatMessages) {
                val size = chatMessages.size
                chatMessages.clear()
                synchronized(rawChatMessages) {
                    rawChatMessages.clear()
                }
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

    private fun readChatFile(url: String, channelId: String?, channelLogin: String?, fallbackStartTimeSeconds: Int? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val nameDisplay = applicationContext.prefs().getString(C.UI_NAME_DISPLAY, "1")
                val messages = mutableListOf<ChatMessage>()
                var startTimeMs = fallbackStartTimeSeconds?.times(1000L) ?: 0L
                var fileStartTimeFound = false
                val chatEmotes = mutableListOf<ChatEmote>()
                val ChatBadges = mutableListOf<ChatBadge>()
                val cheerEmotesList = mutableListOf<CheerEmote>()
                val emotes = mutableListOf<Emote>()
                if (url.toUri().scheme == ContentResolver.SCHEME_CONTENT) {
                    applicationContext.contentResolver.openInputStream(url.toUri())?.bufferedReader()
                } else {
                    FileInputStream(File(url)).bufferedReader()
                }?.use { fileReader ->
                    try {
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
                                                            var previousWasEmote = false
                                                            var id: String? = null
                                                            var offsetSeconds: Int? = null
                                                            var userId: String? = null
                                                            var userLogin: String? = null
                                                            var userName: String? = null
                                                            var color: String? = null
                                                            val emotesList = mutableListOf<ChatEmote>()
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
                                                                                            emotesList.add(ChatEmote(
                                                                                                id = emoteId,
                                                                                                begin = message.codePointCount(0, message.length),
                                                                                                end = message.codePointCount(0, message.length) + fragmentText.lastIndex
                                                                                            ))
                                                                                        }
                                                                                        fragmentText?.let { text ->
                                                                                            val currentIsEmote = !emoteId.isNullOrBlank()
                                                                                            if (shouldInsertFragmentSpace(message, text, currentIsEmote, previousWasEmote)) {
                                                                                                message.append(' ')
                                                                                            }
                                                                                            message.append(text)
                                                                                            previousWasEmote = currentIsEmote
                                                                                        }
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
                                                    "chatEmotes" -> {
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
                                                                chatEmotes.add(ChatEmote(
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
                                                    "ChatBadges" -> {
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
                                                                ChatBadges.add(ChatBadge(
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
                                                    "startTime" -> {
                                                        fileStartTimeFound = true
                                                        startTimeMs = reader.nextInt().also { position += it.toString().length }.times(1000L)
                                                    }
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
                    } catch (_: Exception) {
                        // Partial local chat files are common during interrupted downloads; keep the messages parsed so far.
                    }
                }
                synchronized(localChatEmotes) {
                    localChatEmotes.clear()
                    localChatEmotes.addAll(chatEmotes)
                }
                synchronized(channelBadges) {
                    channelBadges.clear()
                    channelBadges.addAll(ChatBadges)
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
                if (!fileStartTimeFound && (fallbackStartTimeSeconds == null || fallbackStartTimeSeconds <= 0) && startTimeMs == 0L) {
                    messages.firstOrNull()?.timestamp?.let { firstTimestamp ->
                        if (firstTimestamp >= 10 * 60 * 1000L) {
                            startTimeMs = firstTimestamp
                        }
                    }
                }
                if (messages.isNotEmpty()) {
                    viewModelScope.launch {
                        chatReplayManagerLocal?.setMessages(messages, startTimeMs)
                    }
                }
            } catch (_: Exception) {
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

    private fun shouldInsertFragmentSpace(builder: StringBuilder, fragmentText: String, currentIsEmote: Boolean, previousWasEmote: Boolean): Boolean {
        if (builder.isEmpty() || fragmentText.isEmpty()) return false
        val previousChar = builder.last()
        val nextChar = fragmentText.first()
        if (previousChar.isWhitespace() || nextChar.isWhitespace()) return false
        if (!(previousWasEmote || currentIsEmote)) return false
        if (previousChar in "([{" || nextChar in ".,!?;:)]}") return false
        return true
    }

    companion object {
        private val KICK_INLINE_EMOTE_REGEX = Regex("\\[emote:(\\d+):([^\\]]+)]")
        private var savedEmoteSets: List<String>? = null
        private var savedUserEmotes: List<ChatEmote>? = null
        private var savedGlobalBadges: List<ChatBadge>? = null
        private var savedGlobalStvEmotes: List<Emote>? = null
    }
}
