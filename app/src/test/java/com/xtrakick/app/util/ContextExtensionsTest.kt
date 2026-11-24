package com.xtrakick.app.util

import android.app.Activity
import android.content.ContextWrapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ContextExtensionsTest {

    @Test
    fun findActivityReturnsActivityDirectly() {
        val activity = Robolectric.buildActivity(Activity::class.java).setup().get()
        assertEquals(activity, activity.findActivity())
    }

    @Test
    fun findActivityUnwrapsNestedContextWrappers() {
        val activity = Robolectric.buildActivity(Activity::class.java).setup().get()
        val wrapper1 = ContextWrapper(activity)
        val wrapper2 = ContextWrapper(wrapper1)
        assertEquals(activity, wrapper2.findActivity())
    }

    @Test
    fun findActivityReturnsNullWhenNoActivityInChain() {
        val baseContext = org.robolectric.RuntimeEnvironment.getApplication()
        val wrapper = ContextWrapper(baseContext)
        assertNull(wrapper.findActivity())
    }
}
