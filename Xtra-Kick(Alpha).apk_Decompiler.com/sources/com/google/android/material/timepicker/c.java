package com.google.android.material.timepicker;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import n0.g;
import n0.i;

public final class c extends m0.c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3947d;

    public c(ClockFaceView clockFaceView) {
        this.f3947d = clockFaceView;
    }

    public final void d(View view, i iVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f10052a;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            View view2 = (View) this.f3947d.E.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(view2);
            }
        }
        iVar.i(l.c(0, 1, intValue, 1, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        iVar.b(g.f10903e);
    }

    public final boolean g(View view, int i10, Bundle bundle) {
        if (i10 != 16) {
            return super.g(view, i10, bundle);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f3947d;
        view.getHitRect(clockFaceView.B);
        float centerX = (float) clockFaceView.B.centerX();
        float centerY = (float) clockFaceView.B.centerY();
        clockFaceView.A.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
        clockFaceView.A.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
        return true;
    }
}
