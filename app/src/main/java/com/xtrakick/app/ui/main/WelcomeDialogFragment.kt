package com.xtrakick.app.ui.main

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xtrakick.app.databinding.DialogWelcomeOnboardingBinding
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.AuthStateHelper
import com.xtrakick.app.util.prefs

class WelcomeDialogFragment : BottomSheetDialogFragment() {

    private var _binding: DialogWelcomeOnboardingBinding? = null
    private val binding get() = _binding!!
    var onSignInAction: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogWelcomeOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (dialog as? BottomSheetDialog)?.behavior?.apply {
            skipCollapsed = true
            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.clipToPadding = false
        val basePaddingBottom = binding.root.paddingBottom
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { target, insets ->
            val navBars = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
            target.updatePadding(bottom = basePaddingBottom + navBars.bottom)
            insets
        }

        binding.btnSignIn.setOnClickListener {
            markCompleted()
            dismissAllowingStateLoss()
            onSignInAction?.invoke()
        }

        binding.btnContinueGuest.setOnClickListener {
            markCompleted()
            dismissAllowingStateLoss()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        markCompleted()
        super.onDismiss(dialog)
    }

    private fun markCompleted() {
        context?.prefs()?.edit()?.putBoolean(AppConstants.KEY_ONBOARDING_COMPLETED, true)?.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "WelcomeDialogFragment"

        fun newInstance(): WelcomeDialogFragment = WelcomeDialogFragment()

        fun showIfNeeded(activity: AppCompatActivity, onSignIn: () -> Unit) {
            if (activity.isFinishing || activity.isDestroyed) return
            val prefs = activity.prefs()
            if (prefs.getBoolean(AppConstants.KEY_ONBOARDING_COMPLETED, false)) return
            // Existing installs updating to the onboarding build are already signed in;
            // the welcome sheet is only for fresh, signed-out installs.
            if (AuthStateHelper.isKickLoggedIn(activity)) {
                prefs.edit().putBoolean(AppConstants.KEY_ONBOARDING_COMPLETED, true).apply()
                return
            }
            if (activity.supportFragmentManager.findFragmentByTag(TAG) == null) {
                val dialog = newInstance()
                dialog.onSignInAction = onSignIn
                dialog.show(activity.supportFragmentManager, TAG)
            }
        }
    }
}
