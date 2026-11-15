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
class SafeGridLayoutManagerTest {

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
        override fun getItemCount(): Int = 6
    }

    @Test
    fun safeGridLayoutManagerInstantiatesCorrectly() {
        val manager = SafeGridLayoutManager(RuntimeEnvironment.getApplication(), 2)
        assertEquals(RecyclerView.VERTICAL, manager.orientation)
        assertEquals(2, manager.spanCount)
    }

    @Test
    fun catchesIndexOutOfBoundsExceptionDuringLayout() {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeGridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ThrowingAdapter(IndexOutOfBoundsException("Inconsistency in adapter position 5(5)"))

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
        val manager = SafeGridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        recyclerView.adapter = ThrowingAdapter(IllegalStateException("Inconsistency detected. Invalid view holder adapter position"))

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
        val manager = SafeGridLayoutManager(context, 2)
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
        assertEquals(3, (recyclerView.layoutManager as SafeGridLayoutManager).recoveryAttempts)
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
        val manager = recyclerView.layoutManager as SafeGridLayoutManager
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

    private fun newManagedRecyclerView(): RecyclerView {
        val context = RuntimeEnvironment.getApplication()
        val recyclerView = RecyclerView(context)
        val manager = SafeGridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        manager.onAttachedToWindow(recyclerView)
        return recyclerView
    }

    private class HealthyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return object : RecyclerView.ViewHolder(View(parent.context)) {}
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
        override fun getItemCount(): Int = 2
    }
}
