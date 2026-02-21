package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b4.e0;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import n0.g;
import u0.h;
import z.b;
import z7.a;

public class SwipeDismissBehavior<V extends View> extends b {

    /* renamed from: a  reason: collision with root package name */
    public h f3653a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3654b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3655c;

    /* renamed from: d  reason: collision with root package name */
    public int f3656d = 2;

    /* renamed from: e  reason: collision with root package name */
    public final float f3657e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    public float f3658f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f3659g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public final a f3660h = new a(this);

    public boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10 = this.f3654b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f3654b = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3654b = false;
        }
        if (!z10) {
            return false;
        }
        if (this.f3653a == null) {
            this.f3653a = new h(coordinatorLayout.getContext(), coordinatorLayout, this.f3660h);
        }
        if (this.f3655c || !this.f3653a.s(motionEvent)) {
            return false;
        }
        return true;
    }

    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        WeakHashMap weakHashMap = c1.f10054a;
        if (i0.c(view) == 0) {
            i0.s(view, 1);
            c1.m(view, 1048576);
            c1.i(view, 0);
            if (s(view)) {
                c1.n(view, g.f10908j, new e0(19, this));
            }
        }
        return false;
    }

    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f3653a == null) {
            return false;
        }
        if (this.f3655c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f3653a.l(motionEvent);
        return true;
    }

    public boolean s(View view) {
        return true;
    }
}
