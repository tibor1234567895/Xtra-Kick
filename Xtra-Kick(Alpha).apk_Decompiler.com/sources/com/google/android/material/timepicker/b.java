package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3946h;

    public b(ClockFaceView clockFaceView) {
        this.f3946h = clockFaceView;
    }

    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f3946h;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.A.f3933k) - clockFaceView.I;
        if (height != clockFaceView.f3950y) {
            clockFaceView.f3950y = height;
            clockFaceView.l();
            int i10 = clockFaceView.f3950y;
            ClockHandView clockHandView = clockFaceView.A;
            clockHandView.f3941s = i10;
            clockHandView.invalidate();
        }
        return true;
    }
}
