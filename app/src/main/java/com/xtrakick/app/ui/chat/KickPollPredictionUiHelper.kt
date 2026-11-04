package com.xtrakick.app.ui.chat

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.ColorUtils
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.color.MaterialColors
import com.xtrakick.app.R
import com.xtrakick.app.model.chat.Poll
import com.xtrakick.app.model.chat.Prediction
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.util.getAlertDialogBuilder
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.NumberFormat
import kotlin.math.max
import kotlin.math.roundToInt

class KickPollPredictionUiHelper(
    private val fragment: Fragment,
    private val kickRepository: KickRepository,
    private val viewModel: ChatViewModel,
    private val getChannelLogin: () -> String?,
    private val onRewardStateChanged: () -> Unit,
) {
    private val context: Context get() = fragment.requireContext()
    private val lifecycleScope get() = fragment.viewLifecycleOwner.lifecycleScope

    private fun showKickApiError(error: Throwable) {
        Toast.makeText(context, error.message ?: context.getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    private fun dp(value: Int): Int = (value * context.resources.displayMetrics.density).roundToInt()

    fun buildKickPollChoicesText(poll: Poll, clickable: Boolean): CharSequence {
        val channelLogin = getChannelLogin()
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val neutralBackground = ColorUtils.setAlphaComponent(primaryColor, 28)
        val selectedBackground = ColorUtils.setAlphaComponent(primaryColor, 72)
        val selectedTextColor = Color.WHITE
        val maxVotes = poll.choices.orEmpty().maxOfOrNull { it.totalVotes ?: 0 } ?: 0
        val winnerCount = poll.choices.orEmpty().count { (it.totalVotes ?: 0) == maxVotes && maxVotes > 0 }
        val builder = SpannableStringBuilder()
        poll.choices.orEmpty().forEachIndexed { index, choice ->
            if (index > 0) {
                builder.append('\n')
            }
            val isSelected = poll.votedChoiceId != null && choice.id == poll.votedChoiceId
            val isUniqueWinner = poll.status != "ACTIVE" && winnerCount == 1 && maxVotes > 0 && (choice.totalVotes ?: 0) == maxVotes
            val line = context.getString(
                if (isUniqueWinner) R.string.poll_choice_winner else R.string.poll_choice,
                (((choice.totalVotes ?: 0).toLong() * 100.0) / max((poll.totalVotes ?: 0), 1)).roundToInt(),
                choice.totalVotes?.let { NumberFormat.getInstance().format(it) },
                choice.title
            )
            val start = builder.length
            builder.append(line)
            val end = builder.length
            when {
                poll.status == "ACTIVE" && poll.hasVoted == true && isSelected -> {
                    builder.setSpan(BackgroundColorSpan(selectedBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(ForegroundColorSpan(selectedTextColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                poll.status == "ACTIVE" && poll.hasVoted != true && choice.id != null -> {
                    builder.setSpan(BackgroundColorSpan(neutralBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                isUniqueWinner -> {
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
            if (clickable &&
                channelLogin != null &&
                poll.status == "ACTIVE" &&
                poll.hasVoted != true &&
                choice.id != null
            ) {
                builder.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            submitKickPollVote(channelLogin, choice.id)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.isUnderlineText = false
                            ds.color = ds.linkColor
                        }
                    },
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return builder
    }

    private fun submitKickPollVote(channelLogin: String, choiceId: Int) {
        lifecycleScope.launch {
            runCatching {
                kickRepository.voteKickWebPoll(channelLogin, choiceId)
            }.onSuccess { updatedPoll ->
                updatedPoll?.let(viewModel::applyLocalPollUpdate)
                Toast.makeText(context, context.getString(R.string.kick_poll_vote_submitted), Toast.LENGTH_SHORT).show()
            }.onFailure(::showKickApiError)
        }
    }

    fun buildKickPredictionOutcomesText(prediction: Prediction, clickable: Boolean): CharSequence {
        val channelLogin = getChannelLogin()
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val neutralBackground = ColorUtils.setAlphaComponent(primaryColor, 28)
        val selectedBackground = ColorUtils.setAlphaComponent(primaryColor, 72)
        val selectedTextColor = Color.WHITE
        val totalPoints = prediction.outcomes?.sumOf { it.totalPoints?.toLong() ?: 0 } ?: 0
        val selectedOutcomeId = prediction.userVote?.outcomeId
        val resolved = prediction.status == "RESOLVED" || prediction.status == "RESOLVE_PENDING"
        val builder = SpannableStringBuilder()
        prediction.outcomes.orEmpty().forEachIndexed { index, outcome ->
            if (index > 0) {
                builder.append('\n')
            }
            val isSelected = selectedOutcomeId != null && outcome.id == selectedOutcomeId
            val isWinner = resolved && prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id
            val line = context.getString(
                if (isWinner) R.string.prediction_outcome_compact_winner else R.string.prediction_outcome_compact,
                (((outcome.totalPoints ?: 0).toLong() * 100.0) / max(totalPoints, 1)).roundToInt(),
                outcome.title
            )
            val start = builder.length
            builder.append(line)
            val end = builder.length
            when {
                isSelected -> {
                    builder.setSpan(BackgroundColorSpan(selectedBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(ForegroundColorSpan(selectedTextColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                prediction.status == "ACTIVE" && selectedOutcomeId == null && outcome.id != null -> {
                    builder.setSpan(BackgroundColorSpan(neutralBackground), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
                isWinner -> {
                    builder.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
            if (clickable &&
                channelLogin != null &&
                prediction.status == "ACTIVE" &&
                outcome.id != null &&
                (selectedOutcomeId == null || selectedOutcomeId == outcome.id)
            ) {
                builder.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            showKickPredictionVoteDialog(prediction, outcome)
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.isUnderlineText = false
                            ds.color = ds.linkColor
                        }
                    },
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        return builder
    }

    private fun showKickPredictionVoteDialog(
        prediction: Prediction,
        outcome: Prediction.PredictionOutcome,
    ) {
        val channelLogin = getChannelLogin() ?: return
        val outcomeId = outcome.id ?: return
        val selectedOutcomeId = prediction.userVote?.outcomeId
        if (selectedOutcomeId != null && selectedOutcomeId != outcomeId) {
            Toast.makeText(context, context.getString(R.string.kick_prediction_vote_only_selected), Toast.LENGTH_SHORT).show()
            return
        }
        var currentBalance = viewModel.channelPointsBalance.value
        val currentStake = prediction.userVote?.takeIf { it.outcomeId == outcomeId }?.totalVoteAmount
        val minAmount = 10
        val content = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
        val balanceText = TextView(context).apply {
            text = buildString {
                append(context.getString(R.string.channel_points_balance, currentBalance?.let { NumberFormat.getInstance().format(it) } ?: context.getString(R.string.channel_points_loading)))
                append('\n')
                append(context.getString(R.string.kick_prediction_vote_minimum, NumberFormat.getInstance().format(minAmount)))
                if (currentStake != null) {
                    append('\n')
                    append(context.getString(R.string.kick_prediction_vote_current_stake, NumberFormat.getInstance().format(currentStake)))
                }
            }
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
            setPadding(0, 0, 0, dp(12))
        }
        content.addView(balanceText)
        val input = EditText(context).apply {
            inputType = InputType.TYPE_CLASS_NUMBER
            hint = context.getString(R.string.kick_prediction_vote_amount_hint)
        }
        content.addView(input)
        val dialog = context.getAlertDialogBuilder()
            .setTitle(outcome.title)
            .setView(content)
            .setPositiveButton(context.getString(R.string.kick_prediction_vote_submit), null)
            .setNegativeButton(context.getString(R.string.close), null)
            .show()
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val updateButtonState = {
            val amount = input.text?.toString()?.toIntOrNull()
            val balance = currentBalance
            positiveButton.isEnabled = balance != null && amount != null && amount >= minAmount && amount <= balance
        }
        val updateBalanceText = {
            balanceText.text = buildString {
                append(context.getString(R.string.channel_points_balance, currentBalance?.let { NumberFormat.getInstance().format(it) } ?: context.getString(R.string.channel_points_loading)))
                append('\n')
                append(context.getString(R.string.kick_prediction_vote_minimum, NumberFormat.getInstance().format(minAmount)))
                if (currentStake != null) {
                    append('\n')
                    append(context.getString(R.string.kick_prediction_vote_current_stake, NumberFormat.getInstance().format(currentStake)))
                }
            }
        }
        positiveButton.isEnabled = false
        input.addTextChangedListener(onTextChanged = { _, _, _, _ ->
            updateButtonState()
        })
        updateButtonState()
        var balanceJob: Job? = lifecycleScope.launch {
            viewModel.channelPointsBalance.collectLatest { balance ->
                currentBalance = balance
                updateBalanceText()
                updateButtonState()
            }
        }
        dialog.setOnDismissListener {
            balanceJob?.cancel()
            balanceJob = null
        }
        if (currentBalance == null) {
            onRewardStateChanged()
        }
        positiveButton.setOnClickListener {
            val amount = input.text?.toString()?.toIntOrNull() ?: return@setOnClickListener
            submitKickPredictionVote(channelLogin, outcomeId, amount)
            dialog.dismiss()
        }
    }

    private fun submitKickPredictionVote(
        channelLogin: String,
        outcomeId: String,
        amount: Int,
    ) {
        lifecycleScope.launch {
            runCatching {
                kickRepository.voteKickWebPrediction(channelLogin, outcomeId, amount)
            }.onSuccess { updatedPrediction ->
                updatedPrediction?.let(viewModel::applyLocalPredictionUpdate)
                onRewardStateChanged()
                Toast.makeText(context, context.getString(R.string.kick_prediction_vote_submitted), Toast.LENGTH_SHORT).show()
            }.onFailure(::showKickApiError)
        }
    }
}
