package com.xtrakick.app.ui.settings

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import com.xtrakick.app.util.bundleOf
import androidx.core.view.children
import androidx.fragment.app.DialogFragment
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import com.xtrakick.app.R
import com.xtrakick.app.util.AppConstants
import com.xtrakick.app.util.prefs
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.color.MaterialColors

abstract class MaterialPreferenceFragment : PreferenceFragmentCompat() {

    override fun onDisplayPreferenceDialog(preference: Preference) {
        if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_MATERIAL3, true)) {
            when (preference) {
                is ListPreference -> showPreferenceDialog(preference, MaterialListPreference())
                is MultiSelectListPreference -> showPreferenceDialog(preference, MaterialMultiSelectListPreference())
                is EditTextPreference -> showPreferenceDialog(preference, MaterialEditTextPreference())
                else -> super.onDisplayPreferenceDialog(preference)
            }
        } else {
            super.onDisplayPreferenceDialog(preference)
        }
    }

    override fun scrollToPreference(key: String) {
        super.scrollToPreference(key)
        findPreference<Preference>(key)?.let { highlightPreference(it) }
    }

    override fun scrollToPreference(preference: Preference) {
        super.scrollToPreference(preference)
        highlightPreference(preference)
    }

    private fun highlightPreference(preference: Preference) {
        val recyclerView = listView ?: return
        recyclerView.postDelayed({
            recyclerView.children
                .firstOrNull { child ->
                    val titleMatches =
                        child.findViewById<TextView>(android.R.id.title)?.text == preference.title
                    val summaryMatches = preference.summary.isNullOrEmpty() ||
                        child.findViewById<TextView>(android.R.id.summary)?.text == preference.summary
                    titleMatches && summaryMatches
                }
                ?.let(::animateHighlight)
        }, 200)
    }

    private fun animateHighlight(view: View) {
        val context = view.context
        val primaryColor = MaterialColors.getColor(
            context,
            androidx.appcompat.R.attr.colorPrimary,
            Color.BLUE,
        )
        val highlightColor = ColorUtils.setAlphaComponent(primaryColor, 80)
        val originalBackground = view.background

        ValueAnimator.ofObject(ArgbEvaluator(), 0, highlightColor, highlightColor, 0).apply {
            duration = 1800L
            addUpdateListener { animator ->
                val color = animator.animatedValue as Int
                view.setBackgroundColor(color)
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    view.background = originalBackground
                }
            })
            start()
        }
    }

    protected fun setupStandardListBehavior() {
        view?.let { root ->
            ViewCompat.setOnApplyWindowInsetsListener(root) { _, windowInsets ->
                val insets = windowInsets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime()
                )
                listView.updatePadding(bottom = insets.bottom)
                WindowInsetsCompat.CONSUMED
            }
        }
        requireActivity().findViewById<AppBarLayout>(R.id.appBar)?.let { appBar ->
            if (requireContext().prefs().getBoolean(AppConstants.UI_THEME_APPBAR_LIFT, true)) {
                appBar.setLiftOnScrollTargetView(listView)
                listView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        appBar.isLifted = recyclerView.canScrollVertically(-1)
                    }
                })
                listView.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                    appBar.isLifted = listView.canScrollVertically(-1)
                }
            } else {
                appBar.setLiftable(false)
                appBar.background = null
            }
        }
        (requireActivity() as? SettingsActivity)?.let { activity ->
            activity.searchItem?.also { key ->
                activity.searchItem = null
                scrollToPreference(key)
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun showPreferenceDialog(preference: Preference, fragment: DialogFragment) {
        fragment.arguments = bundleOf("key" to preference.key)
        fragment.setTargetFragment(this, 0)
        fragment.show(parentFragmentManager, "androidx.preference.PreferenceFragment.DIALOG")
    }
}
