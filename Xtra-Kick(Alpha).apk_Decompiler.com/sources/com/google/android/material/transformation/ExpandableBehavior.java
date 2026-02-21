package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k8.a;
import m0.c1;
import m0.l0;
import z.b;

@Deprecated
public abstract class ExpandableBehavior extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f3960a = 0;

    public ExpandableBehavior() {
    }

    public abstract boolean b(View view, View view2);

    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        boolean z10;
        a aVar = (a) view2;
        boolean z11 = ((FloatingActionButton) aVar).f3824v.f9254b;
        int i10 = 2;
        int i11 = this.f3960a;
        if (!z11 ? i11 != 1 : !(i11 == 0 || i11 == 2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        if (z11) {
            i10 = 1;
        }
        this.f3960a = i10;
        s((View) aVar, view, z11, true);
        return true;
    }

    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10) {
        a aVar;
        boolean z10;
        WeakHashMap weakHashMap = c1.f10054a;
        if (!l0.c(view)) {
            ArrayList k10 = coordinatorLayout.k(view);
            int size = k10.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = (View) k10.get(i11);
                if (b(view, view2)) {
                    aVar = (a) view2;
                    break;
                }
                i11++;
            }
            if (aVar != null) {
                boolean z11 = ((FloatingActionButton) aVar).f3824v.f9254b;
                int i12 = 2;
                int i13 = this.f3960a;
                if (!z11 ? i13 != 1 : !(i13 == 0 || i13 == 2)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    if (z11) {
                        i12 = 1;
                    }
                    this.f3960a = i12;
                    view.getViewTreeObserver().addOnPreDrawListener(new b9.a(this, view, i12, aVar));
                }
            }
        }
        return false;
    }

    public abstract void s(View view, View view2, boolean z10, boolean z11);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(0);
    }
}
