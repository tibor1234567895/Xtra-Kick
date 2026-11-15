package com.xtrakick.app.ui.view

import android.app.Application
import android.view.ContextThemeWrapper
import com.xtrakick.app.R
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.util.ReflectionHelpers
import org.robolectric.util.ReflectionHelpers.ClassParameter

@Config(application = Application::class)
@RunWith(RobolectricTestRunner::class)
class StrictEditTextTest {
    private val context = ContextThemeWrapper(RuntimeEnvironment.getApplication(), R.style.BaseDarkTheme)

    @Test
    fun selectionCallbackToleratesMissingEditable() {
        val editText = StrictEditText(context)
        ReflectionHelpers.setField(editText, "mText", null)
        ReflectionHelpers.callInstanceMethod<Unit>(
            editText, "onSelectionChanged",
            ClassParameter.from(Int::class.javaPrimitiveType, 0),
            ClassParameter.from(Int::class.javaPrimitiveType, 0),
        )
    }

    @Test
    fun selectionStillStaysAtTheEndOfExistingText() {
        val editText = StrictEditText(context)
        editText.setText("01:23")
        editText.setSelection(0)

        assertEquals(5, editText.selectionStart)
        assertEquals(5, editText.selectionEnd)
    }
}
