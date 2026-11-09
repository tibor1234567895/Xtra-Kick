package com.xtrakick.app.ui.chat

import android.content.Context
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.ChatMessage
import com.xtrakick.app.repository.KickPublicApiRepository
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.ui.view.SlashCommand
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.KickApiHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.ceil

/**
 * Kick slash commands: use Kick official/public APIs only (never Twitch GQL).
 */
internal class KickSlashCommandDispatcher(
    private val context: Context,
    private val kickRepository: KickRepository,
    private val kickPublicApiRepository: KickPublicApiRepository,
    private val scope: CoroutineScope,
    private val emitMessage: suspend (ChatMessage) -> Unit,
    private val onDisconnect: () -> Unit,
    private val resolveChatroomId: suspend (channelId: String?, channelLogin: String?) -> String?,
    private val sendMessageFallback: (CharSequence, String?, String?, String?) -> Unit,
) {
    fun dispatch(message: CharSequence, networkLibrary: String?, kickPublicApiHeaders: Map<String, String>, accountId: String?, channelId: String?, channelLogin: String?, useApiChatMessages: Boolean, enableIntegrity: Boolean) {
        val command = message.toString().substringBefore(" ")
        val hasPublicToken = !kickPublicApiHeaders[AppConstants.HEADER_TOKEN].isNullOrBlank()
        fun missingAuth() {
            scope.launch {
                val errorMsg = if (AuthStateHelper.isKickGoogleSession(context)) {
                    context.getString(R.string.kick_command_needs_oauth)
                } else if (AuthStateHelper.isKickLoggedIn(context)) {
                    context.getString(R.string.kick_scope_required, "OAuth")
                } else {
                    context.getString(R.string.token_expired)
                }
                emitMessage(ChatMessage(systemMsg = context.getString(R.string.chat_send_msg_error, errorMsg)))
            }
        }
        // Required-argument guidance: kick.com web's autocomplete marks these arguments
        // required and the command does not run without them.
        fun missingArgUsage(usage: String) {
            scope.launch {
                emitMessage(ChatMessage(systemMsg = usage))
            }
        }
        suspend fun emitError(error: Throwable) {
            emitMessage(ChatMessage(systemMsg = context.getString(R.string.chat_send_msg_error, error.message ?: error.toString())))
        }
        suspend fun emitInfo(text: String?) {
            if (!text.isNullOrBlank()) {
                emitMessage(ChatMessage(systemMsg = text))
            }
        }
        // Chat-commands endpoint kick.com web uses for /clear and /host. No client-side
        // success message: the server-side effect is the confirmation; failures surface as chat errors.
        fun launchNative(commandName: String, parameter: String?) {
            scope.launch {
                runCatching {
                    kickRepository.sendKickChatCommand(
                        channelSlug = requireNotNull(channelLogin),
                        command = commandName,
                        parameter = parameter,
                    )
                    null
                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
            }
        }
        // Chat settings PATCH kick.com web's mod panel uses. No client-side success message:
        // Kick broadcasts ChatroomUpdatedEvent only when state actually changed; failures surface as chat errors.
        fun launchNativeChatMode(
            emotesMode: Boolean? = null,
            subscribersMode: Boolean? = null,
            followersMode: Boolean? = null,
            followingMinDurationMinutes: Int? = null,
            slowMode: Boolean? = null,
            messageIntervalSeconds: Int? = null,
        ) {
            scope.launch {
                runCatching {
                    val resolvedChannelId = channelId?.takeIf { it.isNotBlank() }
                        ?: kickRepository.getChannel(requireNotNull(channelLogin)).id?.toString()
                    kickRepository.updateKickChatSettings(
                        channelId = requireNotNull(resolvedChannelId) { "channel id unresolved" },
                        emotesMode = emotesMode,
                        subscribersMode = subscribersMode,
                        followersMode = followersMode,
                        followingMinDurationMinutes = followingMinDurationMinutes,
                        slowMode = slowMode,
                        messageIntervalSeconds = messageIntervalSeconds,
                    )
                    null
                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
            }
        }
        // Adds/removes community roles (moderator, vip, og) via kick.com's community endpoints.
        // No client-side success message: role changes show up server-side (badges, lists).
        fun launchNativeCommunityRole(add: Boolean, role: String, username: String) {
            scope.launch {
                runCatching {
                    val slug = requireNotNull(channelLogin)
                    if (add) {
                        kickRepository.addKickChannelCommunityRole(slug, role, username)
                    } else {
                        kickRepository.removeKickChannelCommunityRole(slug, role, username)
                    }
                    null
                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
            }
        }
        suspend fun resolveTargetUserId(login: String): String? {
            return kickRepository.resolveUserIdBySlug(networkLibrary, login)?.toString()
        }
        val hasDirectKickSession = !channelLogin.isNullOrBlank() && (AuthStateHelper.isKickGoogleSession(context) || kickRepository.hasKickWebsiteSessionCookieOnly())
        when {
            command.startsWith("/announce", true) -> {
                val splits = message.split(" ", limit = 2)
                if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
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
                    scope.launch {
                        runCatching {
                            val targetUsername = splits[1].removePrefix("@").trim()
                            val reason = if (splits.size >= 3) splits[2] else null
                            if (hasDirectKickSession) {
                                kickRepository.banKickChannelUser(
                                    channelSlug = requireNotNull(channelLogin),
                                    targetUsername = targetUsername,
                                    permanent = true,
                                    reason = reason,
                                )
                                null
                            } else {
                                val targetId = resolveTargetUserId(targetUsername)
                                val broadcasterUserId = channelId?.toLongOrNull()
                                val targetUserId = targetId?.toLongOrNull()
                                if (broadcasterUserId != null && targetUserId != null) {
                                    kickRepository.banOfficialUser(
                                        networkLibrary = networkLibrary,
                                        broadcasterUserId = broadcasterUserId,
                                        targetUserId = targetUserId,
                                        reason = reason,
                                    )
                                    null
                                } else if (hasPublicToken) {
                                    kickPublicApiRepository.banUser(
                                        networkLibrary, kickPublicApiHeaders, channelId, accountId, targetId,
                                        reason = reason,
                                    )
                                } else {
                                    throw IllegalStateException(context.getString(R.string.token_expired))
                                }
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else {
                    missingArgUsage("Usage: /ban <user> [reason]")
                }
            }
            command.equals("/unban", true) || command.equals("/untimeout", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    scope.launch {
                        runCatching {
                            val targetUsername = splits[1].removePrefix("@").trim()
                            if (hasDirectKickSession) {
                                val targetId = resolveTargetUserId(targetUsername)
                                kickRepository.unbanKickChannelUser(
                                    channelSlug = requireNotNull(channelLogin),
                                    targetUserIdOrUsername = targetId ?: targetUsername,
                                )
                                null
                            } else {
                                val targetId = resolveTargetUserId(targetUsername)
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
                                    throw IllegalStateException(context.getString(R.string.token_expired))
                                }
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else {
                    missingArgUsage("Usage: /unban <user>")
                }
            }
            command.equals("/timeout", true) -> {
                // kick.com web requires <minutes> for /timeout (sent in minutes); never invent a default.
                val splits = message.split(" ", limit = 4)
                val minutes = if (splits.size >= 3) kickTimeoutMinutes(splits[2]) else null
                if (splits.size >= 3 && minutes != null) {
                    scope.launch {
                        runCatching {
                            val targetUsername = splits[1].removePrefix("@").trim()
                            val reason = if (splits.size >= 4) splits[3] else null
                            if (hasDirectKickSession) {
                                kickRepository.banKickChannelUser(
                                    channelSlug = requireNotNull(channelLogin),
                                    targetUsername = targetUsername,
                                    permanent = false,
                                    durationMinutes = minutes,
                                    reason = reason,
                                )
                                null
                            } else {
                                val targetId = resolveTargetUserId(targetUsername)
                                val broadcasterUserId = channelId?.toLongOrNull()
                                val targetUserId = targetId?.toLongOrNull()
                                if (broadcasterUserId != null && targetUserId != null) {
                                    kickRepository.banOfficialUser(
                                        networkLibrary = networkLibrary,
                                        broadcasterUserId = broadcasterUserId,
                                        targetUserId = targetUserId,
                                        durationMinutes = minutes,
                                        reason = reason,
                                    )
                                    null
                                } else if (hasPublicToken) {
                                    kickPublicApiRepository.banUser(
                                        networkLibrary, kickPublicApiHeaders, channelId, accountId, targetId,
                                        duration = minutes.toString(),
                                        reason = reason,
                                    )
                                } else {
                                    throw IllegalStateException(context.getString(R.string.token_expired))
                                }
                            }
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else {
                    missingArgUsage("Usage: /timeout <user> <minutes> [reason]")
                }
            }
            command.equals("/clear", true) -> {
                if (hasDirectKickSession) {
                    launchNative("clear", null)
                } else if (hasPublicToken) {
                    scope.launch {
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
                    scope.launch {
                        runCatching {
                            val chatroomId = resolveChatroomId(channelId, channelLogin)
                            if (!chatroomId.isNullOrBlank() && (AuthStateHelper.isKickGoogleSession(context) || kickRepository.hasKickWebsiteSessionCookieOnly())) {
                                kickRepository.deleteKickChatMessage(chatroomId, splits[1])
                                null
                            } else {
                                kickRepository.deleteOfficialChatMessage(networkLibrary, splits[1])
                                null
                            }
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
                } else {
                    missingArgUsage("Usage: /delete <messageId>")
                }
            }
            command.equals("/color", true) -> {
                val splits = message.split(" ")
                if (!hasPublicToken) {
                    missingAuth()
                } else {
                    scope.launch {
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
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.startCommercial(networkLibrary, kickPublicApiHeaders, channelId, splits[1])
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                }
            }
            command.equals("/disconnect", true) -> onDisconnect()
            command.equals("/emoteonly", true) -> {
                // kick.com web requires the on_off argument ("/emoteonly <on|off>").
                val mode = message.split(" ").getOrNull(1)?.trim()
                when (mode?.lowercase()) {
                    "on", "off" -> if (hasDirectKickSession) {
                        launchNativeChatMode(emotesMode = mode.equals("on", true))
                    } else if (hasPublicToken) {
                        scope.launch {
                            runCatching {
                                kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, emote = mode.equals("on", true))
                            }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                        }
                    } else missingAuth()
                    else -> missingArgUsage("Usage: /emoteonly <on|off>")
                }
            }
            command.equals("/emoteonlyoff", true) -> {
                if (hasDirectKickSession) {
                    launchNativeChatMode(emotesMode = false)
                } else if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, emote = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/followers", true) -> {
                // kick.com web requires the on_off argument ("/followers <on|off> [minutes]").
                val splits = message.split(" ")
                val mode = splits.getOrNull(1)?.trim()
                when (mode?.lowercase()) {
                    "on", "off" -> {
                        val on = mode.equals("on", true)
                        val duration = if (splits.size >= 3) splits[2].toIntOrNull() else null
                        if (hasDirectKickSession) {
                            val (_, minutes) = kickFollowersModeArguments(splits.drop(1))
                            launchNativeChatMode(followersMode = on, followingMinDurationMinutes = minutes)
                        } else if (hasPublicToken) {
                            scope.launch {
                                runCatching {
                                    kickPublicApiRepository.updateChatSettings(
                                        networkLibrary, kickPublicApiHeaders, channelId, accountId,
                                        followers = on, followersDuration = duration,
                                    )
                                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                            }
                        } else missingAuth()
                    }
                    else -> missingArgUsage("Usage: /followers <on|off> [minutes]")
                }
            }
            command.equals("/followersoff", true) -> {
                if (hasDirectKickSession) {
                    launchNativeChatMode(followersMode = false, followingMinDurationMinutes = 0)
                } else if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, followers = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/marker", true) -> {
                val splits = message.split(" ", limit = 2)
                if (hasPublicToken) {
                    scope.launch {
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
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = true, role = "moderator", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.addModerator(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /mod <user>")
                }
            }
            command.equals("/user", true) -> {
                // kick.com web's /user opens its identity panel locally; no server endpoint.
                val splits = message.split(" ")
                if (splits.size >= 2) {
                    scope.launch {
                        emitMessage(ChatMessage(systemMsg = "User info: tap the username in chat to open the user card."))
                    }
                }
            }
            command.equals("/unmod", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = false, role = "moderator", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.removeModerator(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /unmod <user>")
                }
            }
            command.equals("/mods", true) -> {
                scope.launch {
                    emitMessage(ChatMessage(systemMsg = "Listing moderators is not available via Kick API in this build."))
                }
            }
            command.equals("/title", true) -> {
                val splits = message.split(" ", limit = 2)
                if (splits.size >= 2 && hasDirectKickSession) {
                    scope.launch {
                        runCatching {
                            kickRepository.updateKickStreamTitle(
                                channelSlug = requireNotNull(channelLogin),
                                streamTitle = splits[1],
                            )
                            null
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /title <new title>")
                }
            }
            command.equals("/category", true) -> {
                // kick.com web opens an interactive category picker for /category; no text-arg path exists.
                scope.launch {
                    emitMessage(ChatMessage(systemMsg = "Category changes are not supported here - use the kick.com streamer dashboard."))
                }
            }
            command.equals("/raid", true) || command.equals("/host", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    // kick.com web executes /raid via chat-commands with command:"host".
                    launchNative("host", splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.startRaid(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /raid <user>")
                }
            }
            command.equals("/unraid", true) -> {
                if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.cancelRaid(networkLibrary, kickPublicApiHeaders, channelId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/slow", true) -> {
                // kick.com web requires the on_off argument ("/slow <on|off> [seconds]").
                val splits = message.split(" ")
                val mode = splits.getOrNull(1)?.trim()
                when (mode?.lowercase()) {
                    "on", "off" -> {
                        val on = mode.equals("on", true)
                        if (hasDirectKickSession) {
                            // Kick web: "/slow on <seconds 1..120>" / "/slow off"; default interval 1.
                            val (_, interval) = kickSlowModeArguments(splits.drop(1))
                            launchNativeChatMode(slowMode = on, messageIntervalSeconds = interval)
                        } else if (hasPublicToken) {
                            val duration = if (splits.size >= 3) splits[2].toIntOrNull() else null
                            scope.launch {
                                runCatching {
                                    kickPublicApiRepository.updateChatSettings(
                                        networkLibrary, kickPublicApiHeaders, channelId, accountId,
                                        slow = on, slowDuration = duration,
                                    )
                                }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                            }
                        } else missingAuth()
                    }
                    else -> missingArgUsage("Usage: /slow <on|off> [seconds]")
                }
            }
            command.equals("/slowoff", true) -> {
                if (hasDirectKickSession) {
                    launchNativeChatMode(slowMode = false, messageIntervalSeconds = 1)
                } else if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, slow = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/subscribers", true) -> {
                // kick.com web requires the on_off argument ("/subscribers <on|off>").
                val mode = message.split(" ").getOrNull(1)?.trim()
                when (mode?.lowercase()) {
                    "on", "off" -> if (hasDirectKickSession) {
                        launchNativeChatMode(subscribersMode = mode.equals("on", true))
                    } else if (hasPublicToken) {
                        scope.launch {
                            runCatching {
                                kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, subs = mode.equals("on", true))
                            }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                        }
                    } else missingAuth()
                    else -> missingArgUsage("Usage: /subscribers <on|off>")
                }
            }
            command.equals("/subscribersoff", true) -> {
                if (hasDirectKickSession) {
                    launchNativeChatMode(subscribersMode = false)
                } else if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, subs = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/uniquechat", true) -> {
                if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, unique = true)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/uniquechatoff", true) -> {
                if (hasPublicToken) {
                    scope.launch {
                        runCatching {
                            kickPublicApiRepository.updateChatSettings(networkLibrary, kickPublicApiHeaders, channelId, accountId, unique = false)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else missingAuth()
            }
            command.equals("/vip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = true, role = "vip", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.addVip(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /vip <user>")
                }
            }
            command.equals("/og", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = true, role = "og", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /og <user>")
                }
            }
            command.equals("/unog", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = false, role = "og", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /unog <user>")
                }
            }
            command.equals("/unvip", true) -> {
                val splits = message.split(" ")
                if (splits.size >= 2 && hasDirectKickSession) {
                    launchNativeCommunityRole(add = false, role = "vip", username = splits[1].removePrefix("@").trim())
                } else if (splits.size >= 2 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.removeVip(networkLibrary, kickPublicApiHeaders, channelId, targetId)
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 2) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /unvip <user>")
                }
            }
            command.equals("/vips", true) -> {
                scope.launch {
                    emitMessage(ChatMessage(systemMsg = "Listing VIPs is not available via Kick API in this build."))
                }
            }
            command.equals("/w", true) -> {
                val splits = message.split(" ", limit = 3)
                if (splits.size >= 3 && hasPublicToken) {
                    scope.launch {
                        runCatching {
                            val targetId = resolveTargetUserId(splits[1])
                            kickPublicApiRepository.sendWhisper(networkLibrary, kickPublicApiHeaders, accountId, targetId, splits[2])
                        }.onSuccess { emitInfo(it) }.onFailure { emitError(it) }
                    }
                } else if (splits.size >= 3) {
                    missingAuth()
                } else {
                    missingArgUsage("Usage: /w <user> <message>")
                }
            }
            else -> sendMessageFallback(message, networkLibrary, channelId, channelLogin)
        }
    }
}

/**
 * Parses "/slow" arguments per kick.com web: tokens start with the required on|off,
 * followed by an optional seconds value (clamped to the web's 1..120, default 1).
 * Returns (on, messageIntervalSeconds).
 */
internal fun kickSlowModeArguments(tokens: List<String>): Pair<Boolean, Int> {
    val cleaned = tokens.map { it.trim() }.filter { it.isNotBlank() }
    val on = cleaned.firstOrNull()?.equals("on", true) == true
    val seconds = cleaned.getOrNull(1)?.let { it.toIntOrNull() ?: KickApiHelper.getDuration(it)?.toInt() } ?: 1
    return on to seconds.coerceIn(1, 120)
}

/**
 * Parses "/followers" arguments per kick.com web: tokens start with the required
 * on|off, followed by an optional minutes value (clamped to the web's 0..10080,
 * default 0). Returns (on, followingMinDurationMinutes).
 */
internal fun kickFollowersModeArguments(tokens: List<String>): Pair<Boolean, Int> {
    val cleaned = tokens.map { it.trim() }.filter { it.isNotBlank() }
    val on = cleaned.firstOrNull()?.equals("on", true) == true
    val minutes = cleaned.getOrNull(1)?.let { it.toIntOrNull() ?: KickApiHelper.getDuration(it)?.toInt() } ?: 0
    return on to minutes.coerceIn(0, 10080)
}

/**
 * Parses the required "/timeout <user> <minutes> [reason]" minutes argument per
 * kick.com web semantics. Plain numbers are MINUTES (kick.com web's Timeout listener
 * posts {duration: minutes} to the bans endpoint). Suffixed durations ("1m", "1h")
 * come back as seconds from KickApiHelper and are converted to whole minutes,
 * rounded up so the timeout is at least as long as requested. Returns null when
 * missing or unparseable — kick.com web requires this argument and never invents
 * a default.
 */
internal fun kickTimeoutMinutes(token: String?): Int? {
    val cleaned = token?.trim()?.removePrefix("@")
    if (cleaned.isNullOrEmpty()) return null
    val plain = cleaned.toIntOrNull()
    if (plain != null) return plain.takeIf { it > 0 }
    val seconds = KickApiHelper.getDuration(cleaned)?.toInt() ?: return null
    val minutes = ceil(seconds / 60.0).toInt()
    return minutes.takeIf { it > 0 }
}

/**
 * Catalog of slash commands shown by the chat input "/" autocomplete.
 *
 * Restricted to commands Kick actually executes server-side (verified against
 * kick.com's web frontend: bans, chat settings modes, stream-info title,
 * community roles, chat-commands clear/host) or the app's own client-side
 * commands (/timeout, /clear, ... map to native Kick commands).
 * Arms kept in [KickSlashCommandDispatcher.dispatch] for OAuth-only fallbacks
 * but excluded here because they are not Kick commands: color, commercial,
 * marker, unraid, uniquechat, uniquechatoff, w. /category (web: picker dialog)
 * and /user (web: local identity panel) have no server-side execution and are
 * excluded too.
 */
internal val slashCommands: List<SlashCommand> = listOf(
    SlashCommand("ban", "<user> [reason]"),
    SlashCommand("clear"),
    SlashCommand("delete", "<messageId>"),
    SlashCommand("disconnect"),
    SlashCommand("emoteonly", "<on|off>"),
    SlashCommand("emoteonlyoff"),
    SlashCommand("followers", "<on|off> [minutes]"),
    SlashCommand("followersoff"),
    SlashCommand("mod", "<user>"),
    SlashCommand("mods"),
    SlashCommand("og", "<user>"),
    SlashCommand("raid", "<user>"),
    SlashCommand("slow", "<on|off> [seconds]"),
    SlashCommand("slowoff"),
    SlashCommand("subscribers", "<on|off>"),
    SlashCommand("subscribersoff"),
    SlashCommand("timeout", "<user> <minutes> [reason]"),
    SlashCommand("title", "<new title>"),
    SlashCommand("unban", "<user>"),
    SlashCommand("unog", "<user>"),
    SlashCommand("unmod", "<user>"),
    SlashCommand("unvip", "<user>"),
    SlashCommand("vip", "<user>"),
    SlashCommand("vips"),
)
