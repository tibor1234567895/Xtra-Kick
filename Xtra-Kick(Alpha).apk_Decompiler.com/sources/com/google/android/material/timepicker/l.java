package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

public final class l implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f3959h;

    public l(GestureDetector gestureDetector) {
        this.f3959h = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f3959h.onTouchEvent(motionEvent);
        }
        return false;
    }
}
