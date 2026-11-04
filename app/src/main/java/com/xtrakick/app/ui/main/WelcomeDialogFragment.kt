package com.xtrakick.app.ui.main

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
