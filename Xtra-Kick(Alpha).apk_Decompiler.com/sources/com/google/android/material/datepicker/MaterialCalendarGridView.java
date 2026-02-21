package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import java.util.Calendar;
import m0.c1;

final class MaterialCalendarGridView extends GridView {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3734h;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        c0.d((Calendar) null);
        if (r.t0(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f3734h = r.u0(getContext(), R.attr.nestedScrollable);
        c1.p(this, new o(this));
    }

    /* renamed from: a */
    public final v getAdapter() {
        return (v) super.getAdapter();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        v a10 = getAdapter();
        a10.getClass();
        int max = Math.max(a10.a(), getFirstVisiblePosition());
        int min = Math.min((a10.a() + a10.f3800h.f3795l) - 1, getLastVisiblePosition());
        a10.getItem(max);
        a10.getItem(min);
        throw null;
    }

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        int i11;
        if (z10) {
            if (i10 == 33) {
                v a10 = getAdapter();
                i11 = (a10.a() + a10.f3800h.f3795l) - 1;
            } else if (i10 == 130) {
                i11 = getAdapter().a();
            } else {
                super.onFocusChanged(true, i10, rect);
                return;
            }
            setSelection(i11);
            return;
        }
        super.onFocusChanged(false, i10, rect);
    }

    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    public final void onMeasure(int i10, int i11) {
        if (this.f3734h) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, RecyclerView.UNDEFINED_DURATION));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    public final void setSelection(int i10) {
        if (i10 < getAdapter().a()) {
            i10 = getAdapter().a();
        }
        super.setSelection(i10);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof v) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()}));
        }
    }
}
