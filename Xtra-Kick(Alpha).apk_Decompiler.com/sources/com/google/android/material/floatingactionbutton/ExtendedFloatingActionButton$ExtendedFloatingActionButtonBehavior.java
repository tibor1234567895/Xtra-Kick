package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import v7.a;
import z.b;
import z.e;

public class ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior<T> extends b {
    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior() {
    }

    public final /* bridge */ /* synthetic */ boolean a(View view, Rect rect) {
        h.B(view);
        throw null;
    }

    public final void c(e eVar) {
        if (eVar.f17329h == 0) {
            eVar.f17329h = 80;
        }
    }

    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        h.B(view);
        throw null;
    }

    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        h.B(view);
        throw null;
    }

    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15942k);
        obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
    }
}
