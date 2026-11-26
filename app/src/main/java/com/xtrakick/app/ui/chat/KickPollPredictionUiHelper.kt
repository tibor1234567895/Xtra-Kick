package com.xtrakick.app.ui.chat

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.InputType
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
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
    private var submittingPollVote = false
    private var submittingPredictionVote = false

    companion object {
        private val ACCENT_BLUE = Color.parseColor("#3898FF")
        private val ACCENT_PINK = Color.parseColor("#F5009B")
        private val ACCENT_GREEN = Color.parseColor("#22C55E")
        private val COUNTDOWN_BAR_GREEN = Color.parseColor("#8C4ADE80")
    }

    private fun showKickApiError(error: Throwable) {
        if (error is kotlinx.coroutines.CancellationException) throw error
        if (!fragment.isAdded) return
        Toast.makeText(context, error.message ?: context.getString(R.string.connection_error), Toast.LENGTH_LONG).show()
    }

    private fun dp(value: Int): Int = (value * context.resources.displayMetrics.density).roundToInt()

    fun outcomeAccentColor(index: Int, primaryColor: Int): Int {
        return when (index % 4) {
            0 -> ACCENT_BLUE
            1 -> ACCENT_PINK
            2 -> ACCENT_GREEN
            else -> primaryColor
        }
    }

    fun createCountdownProgressBar(initialProgress: Float?, trackColor: Int): ProgressBar {
        return ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal).apply {
            max = 1000
            progress = ((initialProgress ?: 0f) * 1000f).roundToInt().coerceIn(0, 1000)
            isVisible = initialProgress != null
            progressTintList = android.content.res.ColorStateList.valueOf(COUNTDOWN_BAR_GREEN)
            progressBackgroundTintList = android.content.res.ColorStateList.valueOf(trackColor)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(3),
            ).apply {
                topMargin = dp(12)
            }
        }
    }

    fun createProgressBarRow(
        percent: Int,
        fillColor: Int,
        trackColor: Int,
        heightDp: Int = 4,
        topMarginDp: Int = 7,
    ): View {
        val clamped = percent.coerceIn(0, 100)
        val radius = (heightDp / 2f) * context.resources.displayMetrics.density
        return LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = radius
                setColor(trackColor)
            }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(heightDp),
            ).apply {
                topMargin = dp(topMarginDp)
            }
            if (clamped > 0) {
                addView(View(context).apply {
                    background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = radius
                        setColor(fillColor)
                    }
                    layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        clamped.toFloat(),
                    )
                })
            }
            if (clamped < 100) {
                addView(View(context).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        (100 - clamped).toFloat(),
                    )
                })
            }
        }
    }

    fun styleBannerCard(cardView: View, statusView: TextView, active: Boolean) {
        val cardSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainer, Color.DKGRAY)
        val rowSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainerHigh, Color.GRAY)
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.WHITE)
        val onSurfaceVariant = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY)
        cardView.background = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(14).toFloat()
            setColor(cardSurface)
        }
        statusView.setTextColor(if (active) primaryColor else onSurfaceVariant)
        statusView.background = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(10).toFloat()
            setColor(if (active) ColorUtils.setAlphaComponent(primaryColor, 32) else rowSurface)
        }
    }

    fun applySelectableRipple(view: View) {
        val outValue = TypedValue()
        if (context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)) {
            view.foreground = ContextCompat.getDrawable(context, outValue.resourceId)
        }
    }

    fun populatePollChoiceButtons(
        container: LinearLayout,
        poll: Poll,
        clickable: Boolean,
    ) {
        container.removeAllViews()
        val channelLogin = getChannelLogin()
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val rowSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainerHigh, Color.DKGRAY)
        val onSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurface, Color.WHITE)
        val onSurfaceVariant = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY)
        val trackColor = ColorUtils.setAlphaComponent(onSurface, 24)
        val selectedStrokePx = (1.5f * context.resources.displayMetrics.density).roundToInt()
        val canVotePoll = clickable && channelLogin != null && poll.isActive() && poll.hasVoted != true
        if (canVotePoll) {
            container.addView(TextView(context).apply {
                text = context.getString(R.string.kick_poll_tap_to_vote)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodySmall)
                setTextColor(onSurfaceVariant)
                setPadding(0, 0, 0, dp(4))
            })
        }
        val maxVotes = poll.choices.orEmpty().maxOfOrNull { it.totalVotes ?: 0 } ?: 0
        val winnerCount = poll.choices.orEmpty().count { (it.totalVotes ?: 0) == maxVotes && maxVotes > 0 }
        val totalVotes = max(poll.totalVotes ?: 0, 1)
        poll.choices.orEmpty().forEachIndexed { index, choice ->
            val isSelected = poll.votedChoiceId != null && choice.id == poll.votedChoiceId
            val isUniqueWinner = !poll.isActive() && winnerCount == 1 && maxVotes > 0 && (choice.totalVotes ?: 0) == maxVotes
            val choiceClickable = canVotePoll && choice.id != null
            val percent = (((choice.totalVotes ?: 0).toLong() * 100.0) / totalVotes).roundToInt()
            val accent = outcomeAccentColor(index, primaryColor)
            val titleLabel = if (isUniqueWinner) {
                context.getString(R.string.channel_points_prediction_outcome_winner_title, choice.title)
            } else {
                choice.title.orEmpty()
            }
            val votesLabel = choice.totalVotes?.let { NumberFormat.getInstance().format(it) } ?: "0"

            container.addView(LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                background = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = dp(10).toFloat()
                    if (isSelected || isUniqueWinner) {
                        setColor(ColorUtils.setAlphaComponent(accent, 32))
                        setStroke(selectedStrokePx, ColorUtils.setAlphaComponent(accent, 175))
                    } else {
                        setColor(rowSurface)
                    }
                }
                setPadding(dp(10), dp(7), dp(10), dp(7))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                ).apply {
                    if (index > 0) topMargin = dp(6)
                }
                if (choiceClickable) {
                    isClickable = true
                    isFocusable = true
                    applySelectableRipple(this)
                    val choiceId = choice.id
                    setOnClickListener {
                        submitKickPollVote(choiceId)
                    }
                }
                addView(LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    addView(TextView(context).apply {
                        text = titleLabel
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                        setTextColor(onSurface)
                        setTypeface(typeface, if (isSelected || isUniqueWinner) Typeface.BOLD else Typeface.NORMAL)
                        maxLines = 2
                        ellipsize = TextUtils.TruncateAt.END
                        layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    })
                    addView(TextView(context).apply {
                        text = "${context.getString(R.string.channel_points_prediction_percent, percent)} ($votesLabel)"
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_LabelMedium)
                        setTextColor(if (isSelected || isUniqueWinner) accent else onSurfaceVariant)
                        setTypeface(typeface, Typeface.BOLD)
                        setPadding(dp(8), 0, 0, 0)
                    })
                })
                addView(createProgressBarRow(percent, accent, trackColor, heightDp = 3, topMarginDp = 5))
            })
        }
    }

    fun submitKickPollVote(choiceId: Int) {
        val channelLogin = getChannelLogin() ?: return
        if (submittingPollVote) return
        submittingPollVote = true
        lifecycleScope.launch {
            try {
                runCatching {
                    kickRepository.voteKickWebPoll(channelLogin, choiceId)
                }.onSuccess { updatedPoll ->
                    viewModel.applyOptimisticPollVote(choiceId, updatedPoll)
                    if (fragment.isAdded) {
                        Toast.makeText(context, context.getString(R.string.kick_poll_vote_submitted), Toast.LENGTH_SHORT).show()
                    }
                }.onFailure(::showKickApiError)
            } finally {
                submittingPollVote = false
            }
        }
    }

    fun populatePredictionOutcomeButtons(
        container: LinearLayout,
        prediction: Prediction,
        clickable: Boolean,
    ) {
        container.removeAllViews()
        val channelLogin = getChannelLogin()
        val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
        val rowSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurfaceContainerHigh, Color.DKGRAY)
        val onSurface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurface, Color.WHITE)
        val onSurfaceVariant = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSurfaceVariant, Color.LTGRAY)
        val trackColor = ColorUtils.setAlphaComponent(onSurface, 24)
        val selectedStrokePx = (1.5f * context.resources.displayMetrics.density).roundToInt()
        val totalPoints = prediction.outcomes?.sumOf { it.totalPoints?.toLong() ?: 0 } ?: 0
        val selectedOutcomeId = prediction.userVote?.outcomeId
        val resolved = prediction.isResolved()
        val canBetAny = clickable && channelLogin != null && prediction.isActive()
        if (canBetAny) {
            container.addView(TextView(context).apply {
                text = context.getString(R.string.kick_prediction_tap_to_bet)
                setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodySmall)
                setTextColor(onSurfaceVariant)
                setPadding(0, 0, 0, dp(4))
            })
        }
        prediction.outcomes.orEmpty().forEachIndexed { index, outcome ->
            val isSelected = selectedOutcomeId != null && outcome.id == selectedOutcomeId
            val isWinner = resolved && (outcome.isWinner == true || (prediction.winningOutcomeId != null && prediction.winningOutcomeId == outcome.id))
            val outcomeSelectable = canBetAny && outcome.id != null && (selectedOutcomeId == null || selectedOutcomeId == outcome.id)
            val percent = (((outcome.totalPoints ?: 0).toLong() * 100.0) / max(totalPoints, 1)).roundToInt()
            val accent = outcomeAccentColor(index, primaryColor)
            val titleLabel = if (isWinner) {
                context.getString(R.string.channel_points_prediction_outcome_winner_title, outcome.title)
            } else {
                outcome.title.orEmpty()
            }

            container.addView(LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                background = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = dp(10).toFloat()
                    when {
                        isWinner -> {
                            setColor(ColorUtils.setAlphaComponent(accent, 38))
                            setStroke(selectedStrokePx, ColorUtils.setAlphaComponent(accent, 190))
                        }
                        isSelected -> {
                            setColor(ColorUtils.setAlphaComponent(accent, 30))
                            setStroke(selectedStrokePx, ColorUtils.setAlphaComponent(accent, 175))
                        }
                        else -> {
                            setColor(rowSurface)
                        }
                    }
                }
                setPadding(dp(10), dp(7), dp(10), dp(7))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                ).apply {
                    if (index > 0) topMargin = dp(6)
                }
                if (canBetAny && outcome.id != null) {
                    isClickable = true
                    isFocusable = true
                    applySelectableRipple(this)
                    alpha = if (outcomeSelectable) 1f else 0.48f
                    setOnClickListener {
                        showKickPredictionVoteDialog(prediction, outcome)
                    }
                }
                addView(LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    addView(TextView(context).apply {
                        text = titleLabel
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                        setTextColor(onSurface)
                        setTypeface(typeface, if (isSelected || isWinner) Typeface.BOLD else Typeface.NORMAL)
                        maxLines = 2
                        ellipsize = TextUtils.TruncateAt.END
                        layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    })
                    addView(TextView(context).apply {
                        text = context.getString(R.string.channel_points_prediction_percent, percent)
                        setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_LabelLarge)
                        setTextColor(if (isSelected || isWinner) accent else onSurface)
                        setTypeface(typeface, Typeface.BOLD)
                        setPadding(dp(8), 0, 0, 0)
                    })
                })
                addView(createProgressBarRow(percent, accent, trackColor, heightDp = 3, topMarginDp = 5))
            })
        }
    }

    fun showKickPredictionVoteDialog(
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
            setPadding(dp(24), dp(8), dp(24), 0)
        }
        val balanceText = TextView(context).apply {
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
            setPadding(0, 0, 0, dp(12))
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
        updateBalanceText()
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
        if (submittingPredictionVote) return
        submittingPredictionVote = true
        lifecycleScope.launch {
            try {
                runCatching {
                    kickRepository.voteKickWebPrediction(channelLogin, outcomeId, amount)
                }.onSuccess { updatedPrediction ->
                    viewModel.applyOptimisticPredictionBet(outcomeId, amount, updatedPrediction)
                    onRewardStateChanged()
                    if (fragment.isAdded) {
                        Toast.makeText(context, context.getString(R.string.kick_prediction_vote_submitted), Toast.LENGTH_SHORT).show()
                    }
                }.onFailure(::showKickApiError)
            } finally {
                submittingPredictionVote = false
            }
        }
    }
}
