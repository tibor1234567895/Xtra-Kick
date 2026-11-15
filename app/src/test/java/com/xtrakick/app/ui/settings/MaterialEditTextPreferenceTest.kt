package com.xtrakick.app.ui.settings

import android.app.Application
import android.app.Dialog
import android.widget.EditText
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.util.ReflectionHelpers
import org.robolectric.util.ReflectionHelpers.ClassParameter

@Config(application = Application::class, sdk = [28, 31])
@RunWith(RobolectricTestRunner::class)
class MaterialEditTextPreferenceTest {
    @Test
    fun requestingKeyboardBeforeWindowAttachmentDoesNotCrash() {
        val fragment = MaterialEditTextPreference()
        val dialog = Dialog(RuntimeEnvironment.getApplication())

        ReflectionHelpers.callInstanceMethod<Unit>(
            fragment, "requestInputMethod", ClassParameter.from(Dialog::class.java, dialog),
        )
    }

    @Test
    fun destroyingViewClearsTheKeyboardTargetAndAllowsRepeatedCleanup() {
        val fragment = MaterialEditTextPreference()
        ReflectionHelpers.setField(fragment, "mEditText", EditText(RuntimeEnvironment.getApplication()))

        fragment.onDestroyView()

        assertNull(ReflectionHelpers.getField<Any?>(fragment, "mEditText"))
        fragment.onDestroyView()
    }
}
