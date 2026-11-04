package com.xtrakick.app.ui.common

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.core.content.ContextCompat
import com.xtrakick.app.R
import com.google.android.material.color.MaterialColors
import java.util.Locale

interface ActiveTagsAdapter {
    var activeTags: Set<String>
}

object TagFilterHelper {

    private val SEPARATOR_REGEX = Regex("[\\s_\\-]+")

    private fun cleanTag(str: String): String =
        str.trim().lowercase(Locale.ROOT).replace(SEPARATOR_REGEX, "")

    fun isTagActive(tag: String?, activeTags: Collection<String>?): Boolean {
        if (tag.isNullOrBlank() || activeTags.isNullOrEmpty()) return false
        val clean = cleanTag(tag)
        if (clean.isEmpty()) return false
        return activeTags.any { active ->
            val cleanActive = cleanTag(active)
            cleanActive.isNotEmpty() && (
                clean == cleanActive ||
                (cleanActive.length >= 3 && clean.contains(cleanActive)) ||
                (clean.length >= 3 && cleanActive.contains(clean))
            )
        }
    }

    fun applyTagStyle(text: TextView, tag: String, activeTags: Collection<String>?, isEvent: Boolean = false) {
        val context = text.context
        val isHighlighted = isTagActive(tag, activeTags)
        val density = context.resources.displayMetrics.density
        text.setCompoundDrawablesRelative(null, null, null, null)
        text.contentDescription = if (isEvent) context.getString(R.string.stream_event_tag, tag) else null
        if (isHighlighted && !isEvent) {
            val hPad = (8 * density).toInt()
            val vPad = (2 * density).toInt()
            val cornerRadius = 12 * density
            val primaryColor = MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, Color.BLUE)
            val onPrimaryColor = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnPrimary, Color.WHITE)
            val bg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                setCornerRadius(cornerRadius)
                setColor(primaryColor)
            }
            text.background = bg
            text.setPadding(hPad, vPad, hPad, vPad)
            text.setTextColor(onPrimaryColor)
            text.setTypeface(text.typeface, Typeface.BOLD)
        } else {
            text.background = null
            val padding = (5 * density).toInt()
            text.setPadding(padding, 0, padding, 0)
            val typedArray = context.obtainStyledAttributes(intArrayOf(com.google.android.material.R.attr.textAppearanceBodyMedium))
            try {
                TextViewCompat.setTextAppearance(text, typedArray.getResourceId(0, 0))
            } finally {
                typedArray.recycle()
            }
            text.setTypeface(null, Typeface.NORMAL)
        }
        if (isEvent) {
            val surface = MaterialColors.getColor(context, com.google.android.material.R.attr.colorSurface, Color.BLACK)
            text.setTextColor(ContextCompat.getColor(context, if (MaterialColors.isColorLight(surface)) {
                R.color.eventTagForegroundLight
            } else {
                R.color.eventTagForegroundDark
            }))
        }
    }

    fun toggleTag(currentTags: Collection<String>, tagToToggle: String): Array<String> {
        val normalized = tagToToggle.trim()
        val isCurrentlyActive = isTagActive(normalized, currentTags)
        val newTags = if (isCurrentlyActive) {
            currentTags.filterNot { isTagActive(it, listOf(normalized)) }
        } else {
            currentTags + normalized
        }
        return newTags.distinct().sorted().toTypedArray()
    }

    fun formatFiltersText(
        resources: android.content.res.Resources,
        tags: Collection<String>,
        languages: Collection<String>,
    ): String? {
        if (tags.isEmpty() && languages.isEmpty()) return null
        return buildString {
            if (tags.isNotEmpty()) {
                append(
                    resources.getQuantityString(
                        R.plurals.tags,
                        tags.size,
                        tags.joinToString()
                    )
                )
            }
            if (languages.isNotEmpty()) {
                if (isNotEmpty()) {
                    append(". ")
                }
                append(
                    resources.getQuantityString(
                        R.plurals.languages,
                        languages.size,
                        languages.joinToString()
                    )
                )
            }
        }
    }
}
