package com.xtrakick.app.ui.common

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.os.ConfigurationCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.xtrakick.app.util.bundleOf
import com.xtrakick.app.R
import com.xtrakick.app.databinding.DialogSelectLanguagesBinding
import com.xtrakick.app.repository.KickRepository
import com.xtrakick.app.repository.datasource.StreamsDataSource
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import java.text.Collator
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class SelectLanguagesDialog : BottomSheetDialogFragment() {

    interface OnSelectedLanguagesChanged {
        fun onChange(languages: Array<String>)
    }

    companion object {
        private const val SELECTED_LANGUAGES = "languages"

        fun newInstance(languages: Array<String>): SelectLanguagesDialog {
            return SelectLanguagesDialog().apply {
                arguments = bundleOf(SELECTED_LANGUAGES to languages)
            }
        }
    }

    private var _binding: DialogSelectLanguagesBinding? = null
    @Inject lateinit var kickRepository: KickRepository
    private val binding get() = _binding!!
    private lateinit var listener: OnSelectedLanguagesChanged

    private var selectedLanguages = mutableSetOf<String>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as OnSelectedLanguagesChanged
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogSelectLanguagesBinding.inflate(inflater, container, false)
        val languages = savedInstanceState?.getStringArray(SELECTED_LANGUAGES)
            ?: requireArguments().getStringArray(SELECTED_LANGUAGES)
        selectedLanguages = StreamsDataSource.supportedFilterSelections(languages?.asList()).toMutableSet()
        return binding.root
    }

    private fun showLanguages(codes: Collection<String>, nativeNames: Map<String, String>) {
        val appLocale = ConfigurationCompat.getLocales(resources.configuration)[0] ?: Locale.getDefault()
        val collator = Collator.getInstance(appLocale).apply { strength = Collator.PRIMARY }
        val languageItems = (codes + selectedLanguages).distinct()
            .map { code ->
                code to formatLanguageLabel(code, nativeNames[code], appLocale)
            }
            .sortedWith { a, b -> collator.compare(a.second, b.second) }
        binding.languageLayout.removeAllViews()
        languageItems.forEach { (language, label) ->
            binding.languageLayout.addView(AppCompatCheckBox(requireContext()).apply {
                text = label
                textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                isChecked = selectedLanguages.contains(language)
                setOnClickListener {
                    if (!selectedLanguages.remove(language)) {
                        selectedLanguages.add(language)
                    }
                    binding.clear.isVisible = selectedLanguages.isNotEmpty()
                }
            })
        }
        binding.clear.isVisible = selectedLanguages.isNotEmpty()
    }

    private fun formatLanguageLabel(code: String, nativeName: String?, appLocale: Locale): String {
        val tag = when (code.uppercase(Locale.ROOT)) {
            "TL" -> "fil"
            else -> code.replace('_', '-').lowercase(Locale.ROOT)
        }
        val locale = Locale.forLanguageTag(tag)
        val nativeLabel = nativeName ?: locale.getDisplayName(locale).ifBlank { code }
        val localized = locale.getDisplayName(appLocale)
            .trim()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(appLocale) else it.toString() }
        if (localized.isEmpty() || localized.equals(tag, ignoreCase = true) || localized.equals(nativeLabel, ignoreCase = true)) {
            return nativeLabel
        }
        return "$localized ($nativeLabel)"
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.skipCollapsed = true
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        val nativeNames = resources.getStringArray(R.array.gqlUserLanguageValues)
            .zip(resources.getStringArray(R.array.gqlUserLanguageEntries)).toMap()
        showLanguages(nativeNames.keys, nativeNames)
        viewLifecycleOwner.lifecycleScope.launch {
            val codes = try {
                kickRepository.getBrowseLanguageCodes()
            } catch (e: CancellationException) {
                throw e
            } catch (_: Exception) {
                emptyList()
            }
            val available = StreamsDataSource.supportedFilterSelections(codes).map { if (it == "FIL") "TL" else it }
            if (available.isNotEmpty() && available.toSet() != nativeNames.keys) {
                showLanguages(available, nativeNames)
            }
        }
        with(binding) {
            languageScrollView.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> behavior.isDraggable = false
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> behavior.isDraggable = true
                }
                false
            }
            clear.setOnClickListener {
                selectedLanguages.clear()
                for (i in 0 until languageLayout.childCount) {
                    (languageLayout.getChildAt(i) as? AppCompatCheckBox)?.isChecked = false
                }
                clear.isVisible = false
            }
            apply.setOnClickListener {
                listener.onChange(selectedLanguages.toTypedArray().sortedArray())
                dismiss()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArray(SELECTED_LANGUAGES, selectedLanguages.toTypedArray())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
