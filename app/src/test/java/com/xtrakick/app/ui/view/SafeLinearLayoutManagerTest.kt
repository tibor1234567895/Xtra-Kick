package com.xtrakick.app.ui.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class SafeLinearLayoutManagerTest {
    @Test fun aRealScrollFailureResynchronizesAndLeavesBothManagersUsable() {
        val context = RuntimeEnvironment.getApplication()
        for (manager in listOf(SafeLinearLayoutManager(context), SafeGridLayoutManager(context, 2))) {
            val activity = org.robolectric.Robolectric.buildActivity(android.app.Activity::class.java).setup()
            var failNextBind = false
            var failed = false
            var refreshes = 0
            val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
                override fun getItemCount() = 100
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                    object : RecyclerView.ViewHolder(View(parent.context).apply {
                        layoutParams = RecyclerView.LayoutParams(100, 40)
                    }) {}
                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    if (failNextBind) {
                        failNextBind = false
                        failed = true
                        throw IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position")
                    }
                }
            }
            adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                override fun onChanged() { refreshes++ }
            })
            val rv = RecyclerView(context).apply { layoutManager = manager; this.adapter = adapter }
            activity.get().setContentView(rv)
            fun layout() {
                rv.measure(View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(120, View.MeasureSpec.EXACTLY))
                rv.layout(0, 0, 500, 120)
            }
            layout()
            failNextBind = true
            rv.scrollBy(0, 500)
            org.junit.Assert.assertTrue("The scroll must actually hit the failing bind", failed)
            org.robolectric.Shadows.shadowOf(android.os.Looper.getMainLooper()).idle()
            layout()
            org.junit.Assert.assertTrue(refreshes > 0)
            org.junit.Assert.assertTrue(rv.childCount > 0)
            rv.scrollBy(0, 100)
            org.junit.Assert.assertTrue(rv.computeVerticalScrollOffset() > 0)
            activity.pause().stop().destroy()
        }
    }

    @Test fun unrelatedIllegalStateExceptionsAreNotHidden() {
        val context = RuntimeEnvironment.getApplication()
        for (manager in listOf(SafeLinearLayoutManager(context), SafeGridLayoutManager(context, 2))) {
            val rv = RecyclerView(context).apply {
                layoutManager = manager
                adapter = ThrowingAdapter(IllegalStateException("Application adapter bug"))
            }
            assertThrows(IllegalStateException::class.java) {
                rv.measure(View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY))
                rv.layout(0, 0, 500, 500)
            }
        }
    }

    private class ThrowingAdapter(
        private val throwType: Throwable,
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            when (throwType) {
                is IndexOutOfBoundsException -> throw throwType
                is IllegalStateException -> throw throwType
                is NullPointerException -> throw throwType
                else -> throw RuntimeException(throwType)
            }
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
        override fun getItemCount(): Int = 5
    }

    @Test
    fun safeLinearLayoutManagerInstantiatesCorrectly() {
        val manager = SafeLinearLayoutManager(RuntimeEnvironment.getApplication())
        assertEquals(RecyclerView.VERTICAL, manager.orientation)
    }

    @Test
    fun catchesIndexOutOfBoundsExceptionDuringLayout() {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeLinearLayoutManager(context)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ThrowingAdapter(IndexOutOfBoundsException("Inconsistency in adapter position 5(5)"))

        // Trigger layout pass: should catch IndexOutOfBoundsException and not crash
        recyclerView.measure(
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
        )
        recyclerView.layout(0, 0, 500, 500)
    }

    @Test
    fun catchesIllegalStateExceptionDuringLayout() {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeLinearLayoutManager(context)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ThrowingAdapter(IllegalStateException("Inconsistency detected. Invalid view holder adapter position"))

        // Trigger layout pass: should catch IllegalStateException and not crash
        recyclerView.measure(
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
        )
        recyclerView.layout(0, 0, 500, 500)
    }

    @Test
    fun rethrowsUnrelatedExceptionsDuringLayout() {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeLinearLayoutManager(context)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ThrowingAdapter(NullPointerException("Unexpected NPE"))

        recyclerView.measure(
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
        )
        assertThrows(NullPointerException::class.java) {
            recyclerView.layout(0, 0, 500, 500)
        }
    }

    @Test
    fun recoveryAttemptsAreBounded() {
        val recyclerView = newManagedRecyclerView()
        recyclerView.adapter = ThrowingAdapter(IndexOutOfBoundsException("Inconsistency in adapter position 5(5)"))

        repeat(3) {
            recyclerView.forceLayout()
            recyclerView.measure(
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
            )
            recyclerView.layout(0, 0, 500, 500)
        }
        assertEquals(3, (recyclerView.layoutManager as SafeLinearLayoutManager).recoveryAttempts)
        recyclerView.forceLayout()
        assertThrows(IndexOutOfBoundsException::class.java) {
            recyclerView.measure(
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            )
            recyclerView.layout(0, 0, 500, 500)
        }
    }

    @Test
    fun recoveryBudgetResetsAfterCleanLayout() {
        val recyclerView = newManagedRecyclerView()
        recyclerView.adapter = ThrowingAdapter(IndexOutOfBoundsException("Inconsistency in adapter position 5(5)"))

        repeat(2) {
            recyclerView.forceLayout()
            recyclerView.measure(
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
            )
            recyclerView.layout(0, 0, 500, 500)
        }
        val manager = recyclerView.layoutManager as SafeLinearLayoutManager
        assertEquals(2, manager.recoveryAttempts)

        recyclerView.adapter = HealthyAdapter()
        recyclerView.forceLayout()
        recyclerView.measure(
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.EXACTLY)
        )
        recyclerView.layout(0, 0, 500, 500)
        assertEquals(0, manager.recoveryAttempts)
    }

    /** Wires a RecyclerView to a SafeLinearLayoutManager and simulates window attach so recovery has a target. */
    private fun newManagedRecyclerView(): RecyclerView {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeLinearLayoutManager(context)
        recyclerView.layoutManager = manager
        manager.onAttachedToWindow(recyclerView)
        return recyclerView
    }

    private class HealthyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return object : RecyclerView.ViewHolder(View(parent.context)) {}
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
        override fun getItemCount(): Int = 1
    }
}
