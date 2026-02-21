package com.google.android.material.carousel;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a1;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.r1;
import androidx.recyclerview.widget.y1;
import d8.a;
import d8.c;
import d8.d;
import java.util.List;

public class CarouselLayoutManager extends q1 {

    /* renamed from: w  reason: collision with root package name */
    public int f3718w;

    public CarouselLayoutManager() {
        new a();
        new d();
        y0();
    }

    public static float N0(float f10, k5.a aVar) {
        c cVar = (c) aVar.f9124i;
        cVar.getClass();
        c cVar2 = (c) aVar.f9125j;
        cVar2.getClass();
        cVar.getClass();
        cVar2.getClass();
        return w7.a.a(0.0f, 0.0f, 0.0f, 0.0f, f10);
    }

    public static k5.a O0(float f10, List list, boolean z10) {
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = -3.4028235E38f;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < list.size(); i14++) {
            ((c) list.get(i14)).getClass();
            float abs = Math.abs(0.0f - f10);
            if (0.0f <= f10 && abs <= f11) {
                i10 = i14;
                f11 = abs;
            }
            if (0.0f > f10 && abs <= f12) {
                i12 = i14;
                f12 = abs;
            }
            if (0.0f <= f13) {
                i11 = i14;
                f13 = 0.0f;
            }
            if (0.0f > f14) {
                i13 = i14;
                f14 = 0.0f;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new k5.a((c) list.get(i10), (c) list.get(i12));
    }

    public final void A0(int i10) {
    }

    public final r1 C() {
        return new r1(-2, -2);
    }

    public final void K(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        rect.centerX();
        throw null;
    }

    public final void K0(RecyclerView recyclerView, int i10) {
        a1 a1Var = new a1(2, recyclerView.getContext(), this);
        a1Var.f1983a = i10;
        L0(a1Var);
    }

    public final boolean P0() {
        return M() == 1;
    }

    public final void Q0() {
        P0();
        throw null;
    }

    public final void d0(AccessibilityEvent accessibilityEvent) {
        super.d0(accessibilityEvent);
        if (H() > 0) {
            accessibilityEvent.setFromIndex(q1.O(G(0)));
            accessibilityEvent.setToIndex(q1.O(G(H() - 1)));
        }
    }

    public final void n0(y1 y1Var, g2 g2Var) {
        if (g2Var.b() <= 0) {
            u0(y1Var);
            return;
        }
        P0();
        y1Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public final void o0(g2 g2Var) {
        if (H() != 0) {
            q1.O(G(0));
        }
    }

    public final int u(g2 g2Var) {
        throw null;
    }

    public final int v(g2 g2Var) {
        return this.f3718w;
    }

    public final int w(g2 g2Var) {
        return 0 - 0;
    }

    public final boolean x0(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        return false;
    }

    public final int z0(int i10, y1 y1Var, g2 g2Var) {
        if (H() == 0 || i10 == 0) {
            return 0;
        }
        int i11 = this.f3718w;
        int i12 = i11 + i10;
        if (i12 < 0 || i12 > 0) {
            i10 = 0 - i11;
        }
        this.f3718w = i11 + i10;
        Q0();
        throw null;
    }
}
