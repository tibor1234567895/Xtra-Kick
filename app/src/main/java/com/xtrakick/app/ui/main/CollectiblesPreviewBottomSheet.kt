package com.xtrakick.app.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.os.BundleCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogCollectiblePreviewBinding
import com.xtrakick.app.databinding.ItemRewardOddsPillBinding
import com.xtrakick.app.model.kick.KickChallengeDropTableItem
import com.xtrakick.app.model.kick.KickCollectible
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.tokenPrefs
import java.net.URLEncoder
import java.text.DateFormat
import java.util.Date
import java.util.Locale

class CollectiblesPreviewBottomSheet : BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "CollectiblesPreviewBottomSheet"
        private const val ARG_NAME = "name"
        private const val ARG_RARITY = "rarity"
        private const val ARG_OWNED = "owned"
        private const val ARG_CARD_URL = "card_url"
        private const val ARG_UNLOCKED_AT = "unlocked_at"
        private const val ARG_DROP_TABLE = "drop_table"

        fun show(fragmentManager: FragmentManager, collectible: KickCollectible) {
            val sheet = CollectiblesPreviewBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, collectible.name)
                    putString(ARG_RARITY, collectible.rarity)
                    putBoolean(ARG_OWNED, collectible.owned)
                    putString(ARG_CARD_URL, collectible.resolvedCardUrl)
                    putLong(ARG_UNLOCKED_AT, collectible.unlockedAtEpochMs ?: 0L)
                    putSerializable(ARG_DROP_TABLE, ArrayList(collectible.dropTable))
                }
            }
            sheet.show(fragmentManager, TAG)
        }
    }

    private var _binding: DialogCollectiblePreviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogCollectiblePreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments ?: return
        val name = args.getString(ARG_NAME).orEmpty()
        val rarity = args.getString(ARG_RARITY).orEmpty()
        val owned = args.getBoolean(ARG_OWNED, false)
        val cardUrl = args.getString(ARG_CARD_URL)
        val unlockedAt = args.getLong(ARG_UNLOCKED_AT, 0L)

        @Suppress("UNCHECKED_CAST")
        val dropTable = BundleCompat.getSerializable(args, ARG_DROP_TABLE, ArrayList::class.java) as? ArrayList<KickChallengeDropTableItem> ?: arrayListOf()

        val color = KickRewardsUiUtils.rarityColor(rarity)
        val rarityLabel = KickRewardsUiUtils.rarityLabel(rarity)

        binding.previewTitle.text = name
        binding.closeButton.setOnClickListener { dismiss() }

        // Card styling & stroke
        binding.previewCard.strokeColor = color
        Glide.with(this)
            .load(cardUrl)
            .placeholder(R.drawable.ic_kick_gem)
            .error(R.drawable.ic_kick_gem)
            .into(binding.previewCardImage)

        binding.previewLockedScrim.isVisible = !owned
        binding.previewLockIcon.isVisible = !owned

        // Rarity badge
        binding.rarityBadgeDot.background?.mutate()?.setTint(color)
        binding.rarityBadgeText.text = rarityLabel
        binding.rarityBadgeText.setTextColor(color)

        // Status text
        binding.unlockStatusText.text = if (owned) {
            if (unlockedAt > 0L) {
                val dateStr = DateFormat.getDateInstance(DateFormat.MEDIUM).format(Date(unlockedAt))
                getString(R.string.collectibles_unlocked_on, dateStr)
            } else {
                getString(R.string.collectibles_unlocked)
            }
        } else {
            getString(R.string.collectibles_locked_hint)
        }

        // Odds pills
        binding.previewOddsContainer.removeAllViews()
        if (dropTable.isNotEmpty()) {
            binding.oddsHeader.isVisible = true
            binding.previewOddsScroll.isVisible = true
            val inflater = LayoutInflater.from(requireContext())
            dropTable.forEach { item ->
                val pill = ItemRewardOddsPillBinding.inflate(inflater, binding.previewOddsContainer, false)
                val tierColor = KickRewardsUiUtils.rarityColor(item.rarity)
                pill.rarityDot.background?.mutate()?.setTint(tierColor)
                pill.oddsLabel.text = "${KickRewardsUiUtils.rarityLabel(item.rarity)} ${item.percentageFormatted}"
                binding.previewOddsContainer.addView(pill.root)
            }
        } else {
            binding.oddsHeader.isVisible = false
            binding.previewOddsScroll.isVisible = false
        }

        // Share button (only for owned items)
        binding.shareButton.isVisible = owned && !cardUrl.isNullOrBlank()
        binding.shareButton.setOnClickListener {
            val username = requireContext().tokenPrefs().getString(AppConstants.USERNAME, null).orEmpty()
            val encodedImg = URLEncoder.encode(cardUrl.orEmpty(), "UTF-8")
            val encodedUser = URLEncoder.encode(username, "UTF-8")
            val shareUrl = "https://kick.com/rewards/share?img=$encodedImg&u=$encodedUser"
            val shareText = getString(R.string.collectibles_share_text, name, shareUrl)

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(intent, getString(R.string.share)))
        }

        // Interactive 3D touch tilt on card
        setupTouchTilt(binding.cardStage, binding.previewCard)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupTouchTilt(stage: View, card: View) {
        card.cameraDistance = 10000f * resources.displayMetrics.density
        val stageLocation = IntArray(2)

        val tiltListener = View.OnTouchListener { _, event ->
            val behavior = (dialog as? BottomSheetDialog)?.behavior
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    stage.parent?.requestDisallowInterceptTouchEvent(true)
                    behavior?.isDraggable = false
                    card.animate().cancel()
                    stage.getLocationOnScreen(stageLocation)
                    updateCardTilt(stage, card, stageLocation, event.rawX, event.rawY)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    stage.parent?.requestDisallowInterceptTouchEvent(true)
                    behavior?.isDraggable = false
                    updateCardTilt(stage, card, stageLocation, event.rawX, event.rawY)
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    stage.parent?.requestDisallowInterceptTouchEvent(false)
                    behavior?.isDraggable = true
                    card.animate()
                        .rotationX(0f)
                        .rotationY(0f)
                        .setDuration(280)
                        .start()
                    true
                }
                else -> false
            }
        }

        stage.setOnTouchListener(tiltListener)
        card.setOnTouchListener(tiltListener)
    }

    private fun updateCardTilt(stage: View, card: View, stageLocation: IntArray, rawX: Float, rawY: Float) {
        val localX = rawX - stageLocation[0]
        val localY = rawY - stageLocation[1]

        val centerX = stage.width / 2f
        val centerY = stage.height / 2f
        val deltaX = if (centerX > 0f) (localX - centerX) / centerX else 0f
        val deltaY = if (centerY > 0f) (localY - centerY) / centerY else 0f

        val rotY = (deltaX * 22f).coerceIn(-22f, 22f)
        val rotX = (-deltaY * 22f).coerceIn(-22f, 22f)

        card.rotationY = rotY
        card.rotationX = rotX
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
