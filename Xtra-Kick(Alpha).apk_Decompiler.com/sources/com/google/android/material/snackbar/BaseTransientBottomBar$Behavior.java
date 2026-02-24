package com.google.android.material.snackbar;

import android.support.v4.media.h;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b4.e0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import v8.c;
import v8.e;

public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: i  reason: collision with root package name */
    public final e0 f3856i = new e0((SwipeDismissBehavior) this);

    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        e0 e0Var = this.f3856i;
        e0Var.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                e a10 = e.a();
                h.y(e0Var.f2538i);
                synchronized (a10.f15969a) {
                }
            }
        } else if (coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            e a11 = e.a();
            h.y(e0Var.f2538i);
            a11.b();
        }
        return super.g(coordinatorLayout, view, motionEvent);
    }

    public final boolean s(View view) {
        this.f3856i.getClass();
        return view instanceof c;
    }
}
