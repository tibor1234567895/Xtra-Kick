package com.xtrakick.app.ui.settings

import android.app.Dialog
import android.os.Bundle
import androidx.preference.MultiSelectListPreferenceDialogFragmentCompat
import com.xtrakick.app.util.getAlertDialogBuilder

class MaterialMultiSelectListPreference : MultiSelectListPreferenceDialogFragmentCompat() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val builder = requireContext().getAlertDialogBuilder()
            .setTitle(preference.dialogTitle)
            .setIcon(preference.dialogIcon)
            .setPositiveButton(preference.positiveButtonText, this)
            .setNegativeButton(preference.negativeButtonText, this)
        val contentView = onCreateDialogView(requireContext())
        if (contentView != null) {
            onBindDialogView(contentView)
            builder.setView(contentView)
        } else {
            builder.setMessage(preference.dialogMessage)
        }
        onPrepareDialogBuilder(builder)
        return builder.create()
    }
}