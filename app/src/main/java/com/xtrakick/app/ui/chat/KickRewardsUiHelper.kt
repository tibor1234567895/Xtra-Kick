package com.xtrakick.app.ui.chat

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.xtrakick.app.R
import com.xtrakick.app.model.kick.KickOfficialReward
import com.xtrakick.app.model.kick.KickOfficialRewardCreateRequest
import com.xtrakick.app.model.kick.KickOfficialRewardUpdateRequest
import com.xtrakick.app.model.kick.KickRewardRedemption
import com.xtrakick.app.model.kick.KickRewardRedemptionsPage
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.KickOAuthConfig
import com.xtrakick.app.util.getAlertDialogBuilder
import com.xtrakick.app.util.prefs
import com.xtrakick.app.util.tokenPrefs
import kotlinx.coroutines.launch

class KickRewardsUiHelper(
    private val fragment: Fragment,
    private val kickRepository: KickRepository,
    private val getNetworkLibrary: () -> String?,
    private val getChannelLogin: () -> String?,
    private val onRewardStateChanged: () -> Unit,
) {
    private val context: Context get() = fragment.requireContext()
    private val lifecycleScope get() = fragment.viewLifecycleOwner.lifecycleScope

    fun currentKickScopes(): String? {
        return context.prefs().getString(AppConstants.KICK_SCOPES, null)
    }

    fun isKickRewardsOwnerChannel(): Boolean {
        val accountLogin = context.tokenPrefs().getString(AppConstants.KICK_USER_LOGIN, null)
        val channelLogin = getChannelLogin()
        return !accountLogin.isNullOrBlank() &&
            !channelLogin.isNullOrBlank() &&
            accountLogin.equals(channelLogin, ignoreCase = true)
    }

    fun hasKickScopes(vararg scopes: String): Boolean {
        return KickOAuthConfig.hasScopes(currentKickScopes(), scopes.toSet())
    }

    fun hasAnyKickScope(vararg scopes: String): Boolean {
        val configured = currentKickScopes()
        return scopes.any { scope -> KickOAuthConfig.hasScopes(configured, setOf(scope)) }
    }

    fun requireKickRewardScopes(vararg scopes: String): Boolean {
        if (!AuthStateHelper.isKickLoggedIn(context)) {
            context.getAlertDialogBuilder()
                .setMessage(context.getString(R.string.log_in))
                .setPositiveButton(context.getString(R.string.close), null)
                .show()
            return false
        }
        if (!hasKickScopes(*scopes)) {
            Toast.makeText(
                context,
                context.getString(
                    if (scopes.size > 1) R.string.kick_scope_required_multiple else R.string.kick_scope_required,
                    scopes.joinToString(" ")
                ),
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        return true
    }

    private fun showKickApiError(error: Throwable) {
        Toast.makeText(context, error.message ?: context.getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    fun showKickChannelPointActionsDialog() {
        context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.channel_points_rewards_title))
            .setItems(
                arrayOf(
                    context.getString(R.string.kick_manage_rewards),
                    context.getString(R.string.kick_manage_redemptions),
                )
            ) { _, which ->
                when (which) {
                    0 -> openRewardsManager()
                    1 -> openRedemptionsManager()
                }
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }

    fun openRewardsManager() {
        if (!isKickRewardsOwnerChannel() || !hasAnyKickScope("channel:rewards:read", "channel:rewards:write")) {
            requireKickRewardScopes("channel:rewards:read")
            return
        }
        lifecycleScope.launch {
            runCatching {
                kickRepository.getOfficialChannelRewards(getNetworkLibrary())
            }.onSuccess(::showKickRewardsManagerDialog)
                .onFailure(::showKickApiError)
        }
    }

    private fun showKickRewardsManagerDialog(rewards: List<KickOfficialReward>) {
        val labels = rewards.map(::formatKickRewardLabel).toTypedArray()
        val builder = context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.kick_manage_rewards))
            .setNegativeButton(context.getString(R.string.close), null)
            .setPositiveButton(context.getString(R.string.kick_reward_create)) { _, _ ->
                showKickRewardEditor()
            }
            .setNeutralButton(context.getString(R.string.refresh)) { _, _ ->
                onRewardStateChanged()
                openRewardsManager()
            }
        if (labels.isNotEmpty()) {
            builder.setItems(labels) { _, which ->
                rewards.getOrNull(which)?.let(::showKickRewardActionsDialog)
            }
        } else {
            builder.setMessage(context.getString(R.string.kick_reward_empty))
        }
        builder.show()
    }

    private fun formatKickRewardLabel(reward: KickOfficialReward): String {
        val title = reward.title ?: reward.id ?: context.getString(R.string.kick_manage_rewards)
        val cost = reward.cost?.toString() ?: "?"
        val extras = buildList {
            if (reward.isEnabled == false) add("disabled")
            if (reward.isPaused == true) add("paused")
        }
        return if (extras.isEmpty()) {
            "$title ($cost)"
        } else {
            "$title ($cost, ${extras.joinToString(", ")})"
        }
    }

    private fun showKickRewardActionsDialog(reward: KickOfficialReward) {
        context.getAlertDialogBuilder()
            .setTitle(reward.title ?: reward.id ?: context.getString(R.string.kick_manage_rewards))
            .setMessage(
                buildString {
                    appendLine(context.getString(R.string.kick_reward_cost) + ": " + (reward.cost ?: "?"))
                    reward.description?.takeIf { it.isNotBlank() }?.let {
                        appendLine(context.getString(R.string.kick_reward_description) + ": $it")
                    }
                    reward.backgroundColor?.takeIf { it.isNotBlank() }?.let {
                        appendLine(context.getString(R.string.kick_reward_background_color) + ": $it")
                    }
                    appendLine(context.getString(R.string.kick_reward_enabled) + ": " + (reward.isEnabled ?: false))
                    appendLine(context.getString(R.string.kick_reward_paused) + ": " + (reward.isPaused ?: false))
                    append(context.getString(R.string.kick_reward_requires_input) + ": " + (reward.isUserInputRequired ?: false))
                }
            )
            .setPositiveButton(context.getString(R.string.kick_reward_edit)) { _, _ ->
                showKickRewardEditor(reward)
            }
            .setNeutralButton(context.getString(R.string.delete)) { _, _ ->
                confirmKickRewardDelete(reward)
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }

    private data class RewardEditorView(
        val view: View,
        val title: EditText,
        val description: EditText,
        val cost: EditText,
        val backgroundColor: EditText,
        val enabled: SwitchCompat,
        val paused: SwitchCompat?,
        val requiresInput: SwitchCompat,
        val skipQueue: SwitchCompat,
    )

    private fun showKickRewardEditor(existing: KickOfficialReward? = null) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val editor = createRewardEditorView(existing)
        context.getAlertDialogBuilder()
            .setTitle(if (existing == null) context.getString(R.string.kick_reward_create) else context.getString(R.string.kick_reward_edit))
            .setView(editor.view)
            .setPositiveButton(context.getString(R.string.save)) { _, _ ->
                val title = editor.title.text.toString().trim()
                val description = editor.description.text.toString().trim().takeIf { it.isNotBlank() }
                val cost = editor.cost.text.toString().trim().toIntOrNull()
                val backgroundColor = editor.backgroundColor.text.toString().trim().takeIf { it.isNotBlank() }
                lifecycleScope.launch {
                    runCatching {
                        if (existing == null) {
                            kickRepository.createOfficialChannelReward(
                                getNetworkLibrary(),
                                KickOfficialRewardCreateRequest(
                                    title = title,
                                    cost = cost ?: 0,
                                    description = description,
                                    backgroundColor = backgroundColor,
                                    isEnabled = editor.enabled.isChecked,
                                    isUserInputRequired = editor.requiresInput.isChecked,
                                    shouldRedemptionsSkipRequestQueue = editor.skipQueue.isChecked,
                                )
                            )
                        } else {
                            kickRepository.updateOfficialChannelReward(
                                getNetworkLibrary(),
                                rewardId = existing.id ?: error("Missing reward id"),
                                input = KickOfficialRewardUpdateRequest(
                                    title = title,
                                    cost = cost,
                                    description = description,
                                    backgroundColor = backgroundColor,
                                    isEnabled = editor.enabled.isChecked,
                                    isPaused = editor.paused?.isChecked,
                                    isUserInputRequired = editor.requiresInput.isChecked,
                                    shouldRedemptionsSkipRequestQueue = editor.skipQueue.isChecked,
                                )
                            )
                        }
                    }.onSuccess {
                        Toast.makeText(context, R.string.kick_rewards_saved, Toast.LENGTH_SHORT).show()
                        onRewardStateChanged()
                        openRewardsManager()
                    }.onFailure(::showKickApiError)
                }
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }

    private fun createRewardEditorView(existing: KickOfficialReward?): RewardEditorView {
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 16, 32, 16)
        }
        fun addField(hintRes: Int, value: String? = null, inputType: Int = InputType.TYPE_CLASS_TEXT): EditText {
            return EditText(context).apply {
                hint = context.getString(hintRes)
                setText(value.orEmpty())
                this.inputType = inputType
                container.addView(this)
            }
        }
        fun addSwitch(labelRes: Int, checked: Boolean): SwitchCompat {
            return SwitchCompat(context).apply {
                text = context.getString(labelRes)
                isChecked = checked
                container.addView(this)
            }
        }
        val title = addField(R.string.kick_reward_title, existing?.title)
        val description = addField(R.string.kick_reward_description, existing?.description)
        val cost = addField(R.string.kick_reward_cost, existing?.cost?.toString(), InputType.TYPE_CLASS_NUMBER)
        val backgroundColor = addField(R.string.kick_reward_background_color, existing?.backgroundColor)
        val enabled = addSwitch(R.string.kick_reward_enabled, existing?.isEnabled != false)
        val paused = existing?.let { addSwitch(R.string.kick_reward_paused, it.isPaused == true) }
        val requiresInput = addSwitch(R.string.kick_reward_requires_input, existing?.isUserInputRequired == true)
        val skipQueue = addSwitch(R.string.kick_reward_skip_queue, existing?.shouldRedemptionsSkipRequestQueue == true)
        return RewardEditorView(
            view = ScrollView(context).apply { addView(container) },
            title = title,
            description = description,
            cost = cost,
            backgroundColor = backgroundColor,
            enabled = enabled,
            paused = paused,
            requiresInput = requiresInput,
            skipQueue = skipQueue,
        )
    }

    private fun confirmKickRewardDelete(reward: KickOfficialReward) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val rewardId = reward.id ?: return
        context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.kick_reward_delete))
            .setMessage(reward.title ?: rewardId)
            .setPositiveButton(context.getString(R.string.yes)) { _, _ ->
                lifecycleScope.launch {
                    runCatching {
                        kickRepository.deleteOfficialChannelReward(getNetworkLibrary(), rewardId)
                    }.onSuccess {
                        Toast.makeText(context, R.string.kick_reward_deleted, Toast.LENGTH_SHORT).show()
                        onRewardStateChanged()
                        openRewardsManager()
                    }.onFailure(::showKickApiError)
                }
            }
            .setNegativeButton(context.getString(R.string.no), null)
            .show()
    }

    fun openRedemptionsManager(status: String? = "pending", rewardId: String? = null, cursor: String? = null) {
        if (!isKickRewardsOwnerChannel() || !hasAnyKickScope("channel:rewards:read", "channel:rewards:write")) {
            requireKickRewardScopes("channel:rewards:read")
            return
        }
        lifecycleScope.launch {
            runCatching {
                kickRepository.getOfficialRewardRedemptions(
                    networkLibrary = getNetworkLibrary(),
                    rewardId = rewardId,
                    status = status,
                    cursor = cursor,
                )
            }.onSuccess { page ->
                showKickRedemptionsDialog(page, status, rewardId)
            }.onFailure(::showKickApiError)
        }
    }

    private fun showKickRedemptionsDialog(page: KickRewardRedemptionsPage, status: String?, rewardId: String?) {
        val visible = page.groups.flatMap { group ->
            group.redemptions.map { redemption -> (group.reward?.title ?: context.getString(R.string.kick_manage_redemptions)) to redemption }
        }
        val message = if (visible.isEmpty()) {
            context.getString(R.string.kick_redemptions_empty)
        } else {
            visible.joinToString("\n\n") { (title, redemption) -> formatKickRedemptionLabel(title, redemption) }
        }
        context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.kick_manage_redemptions))
            .setMessage(message)
            .setPositiveButton(if (visible.isNotEmpty()) context.getString(R.string.kick_redemption_accept) else context.getString(R.string.close)) { _, _ ->
                if (visible.isNotEmpty()) {
                    showKickRedemptionSelectionDialog(visible, status, rewardId)
                }
            }
            .setNeutralButton(context.getString(R.string.kick_redemption_filters)) { _, _ ->
                showKickRedemptionFilterDialog(status, rewardId, page.nextCursor)
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }

    private fun formatKickRedemptionLabel(rewardTitle: String, redemption: KickRewardRedemption): String {
        return buildString {
            append(rewardTitle)
            append(" • ")
            append(redemption.redeemer?.username ?: redemption.redeemer?.userId ?: redemption.id ?: "?")
            append(" • ")
            append(redemption.status ?: "?")
            redemption.userInput?.takeIf { it.isNotBlank() }?.let {
                append("\n")
                append(it)
            }
        }
    }

    private fun showKickRedemptionSelectionDialog(
        visible: List<Pair<String, KickRewardRedemption>>,
        status: String?,
        rewardId: String?,
    ) {
        if (!requireKickRewardScopes("channel:rewards:write")) return
        val labels = visible.map { (title, redemption) -> formatKickRedemptionLabel(title, redemption) }.toTypedArray()
        val checked = BooleanArray(labels.size)
        context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.kick_manage_redemptions))
            .setMultiChoiceItems(labels, checked) { _, which, isChecked ->
                checked[which] = isChecked
            }
            .setPositiveButton(context.getString(R.string.kick_redemption_accept)) { _, _ ->
                updateKickSelectedRedemptions(visible, checked, true, status, rewardId)
            }
            .setNeutralButton(context.getString(R.string.kick_redemption_reject)) { _, _ ->
                updateKickSelectedRedemptions(visible, checked, false, status, rewardId)
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }

    private fun updateKickSelectedRedemptions(
        visible: List<Pair<String, KickRewardRedemption>>,
        checked: BooleanArray,
        accept: Boolean,
        status: String?,
        rewardId: String?,
    ) {
        val ids = checked.indices.mapNotNull { index ->
            visible.getOrNull(index)?.second?.id?.takeIf { checked[index] }
        }
        if (ids.isEmpty()) {
            Toast.makeText(context, R.string.kick_no_selection, Toast.LENGTH_SHORT).show()
            return
        }
        lifecycleScope.launch {
            runCatching {
                if (accept) {
                    kickRepository.acceptOfficialRewardRedemptions(getNetworkLibrary(), ids)
                } else {
                    kickRepository.rejectOfficialRewardRedemptions(getNetworkLibrary(), ids)
                }
            }.onSuccess { failures ->
                if (failures.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        failures.joinToString("\n") { "${it.id ?: "?"}: ${it.reason ?: "UNKNOWN"}" },
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(context, R.string.kick_redemptions_updated, Toast.LENGTH_SHORT).show()
                }
                onRewardStateChanged()
                openRedemptionsManager(status = status, rewardId = rewardId)
            }.onFailure(::showKickApiError)
        }
    }

    private fun showKickRedemptionFilterDialog(currentStatus: String?, rewardId: String?, nextCursor: String?) {
        lifecycleScope.launch {
            val rewards = runCatching {
                kickRepository.getOfficialChannelRewards(getNetworkLibrary())
            }.getOrDefault(emptyList())
            val options = buildList {
                nextCursor?.let { add(context.getString(R.string.kick_load_more)) }
                add(context.getString(R.string.kick_all_rewards))
                addAll(rewards.map { it.title ?: it.id ?: context.getString(R.string.kick_manage_rewards) })
            }
            context.getAlertDialogBuilder()
                .setTitle(context.getString(R.string.kick_select_reward))
                .setItems(options.toTypedArray()) { _, which ->
                    if (nextCursor != null && which == 0) {
                        openRedemptionsManager(status = currentStatus, rewardId = rewardId, cursor = nextCursor)
                        return@setItems
                    }
                    val baseIndex = if (nextCursor != null) 1 else 0
                    val selectedRewardId = if (which == baseIndex) null else rewards.getOrNull(which - baseIndex - 1)?.id
                    showKickRedemptionStatusDialog(selectedRewardId)
                }
                .setNegativeButton(context.getString(R.string.close), null)
                .show()
        }
    }

    private fun showKickRedemptionStatusDialog(selectedRewardId: String?) {
        val options = arrayOf(
            context.getString(R.string.kick_redemption_status_all),
            context.getString(R.string.kick_redemption_status_pending),
            context.getString(R.string.kick_redemption_status_accepted),
            context.getString(R.string.kick_redemption_status_rejected),
        )
        context.getAlertDialogBuilder()
            .setTitle(context.getString(R.string.kick_redemption_filters))
            .setItems(options) { _, which ->
                val selectedStatus = when (which) {
                    1 -> "pending"
                    2 -> "accepted"
                    3 -> "rejected"
                    else -> null
                }
                openRedemptionsManager(status = selectedStatus, rewardId = selectedRewardId)
            }
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
    }
}
