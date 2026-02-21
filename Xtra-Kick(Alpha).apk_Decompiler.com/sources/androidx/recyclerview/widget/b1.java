package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

public class b1 extends q2 {

    /* renamed from: c  reason: collision with root package name */
    public y0 f1943c;

    /* renamed from: d  reason: collision with root package name */
    public y0 f1944d;

    public static int h(View view, z0 z0Var) {
        return ((z0Var.e(view) / 2) + z0Var.f(view)) - ((z0Var.k() / 2) + z0Var.j());
    }

    public static View i(q1 q1Var, z0 z0Var) {
        int H = q1Var.H();
        View view = null;
        if (H == 0) {
            return null;
        }
        int k10 = (z0Var.k() / 2) + z0Var.j();
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < H; i11++) {
            View G = q1Var.G(i11);
            int abs = Math.abs(((z0Var.e(G) / 2) + z0Var.f(G)) - k10);
            if (abs < i10) {
                view = G;
                i10 = abs;
            }
        }
        return view;
    }

    public final int[] c(q1 q1Var, View view) {
        int[] iArr = new int[2];
        if (q1Var.o()) {
            iArr[0] = h(view, j(q1Var));
        } else {
            iArr[0] = 0;
        }
        if (q1Var.p()) {
            iArr[1] = h(view, k(q1Var));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final a1 d(q1 q1Var) {
        if (!(q1Var instanceof e2)) {
            return null;
        }
        return new a1(0, this.f2158a.getContext(), this);
    }

    public View e(q1 q1Var) {
        z0 z0Var;
        if (q1Var.p()) {
            z0Var = k(q1Var);
        } else if (!q1Var.o()) {
            return null;
        } else {
            z0Var = j(q1Var);
        }
        return i(q1Var, z0Var);
    }

    public final int f(q1 q1Var, int i10, int i11) {
        z0 z0Var;
        boolean z10;
        PointF d10;
        int L = q1Var.L();
        if (L == 0) {
            return -1;
        }
        View view = null;
        if (q1Var.p()) {
            z0Var = k(q1Var);
        } else if (q1Var.o()) {
            z0Var = j(q1Var);
        } else {
            z0Var = null;
        }
        if (z0Var == null) {
            return -1;
        }
        int H = q1Var.H();
        boolean z11 = false;
        View view2 = null;
        int i12 = RecyclerView.UNDEFINED_DURATION;
        int i13 = Integer.MAX_VALUE;
        for (int i14 = 0; i14 < H; i14++) {
            View G = q1Var.G(i14);
            if (G != null) {
                int h10 = h(G, z0Var);
                if (h10 <= 0 && h10 > i12) {
                    view2 = G;
                    i12 = h10;
                }
                if (h10 >= 0 && h10 < i13) {
                    view = G;
                    i13 = h10;
                }
            }
        }
        int i15 = 1;
        if (!q1Var.o() ? i11 <= 0 : i10 <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && view != null) {
            return q1.O(view);
        }
        if (!z10 && view2 != null) {
            return q1.O(view2);
        }
        if (z10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int O = q1.O(view);
        int L2 = q1Var.L();
        if ((q1Var instanceof e2) && (d10 = ((e2) q1Var).d(L2 - 1)) != null && (d10.x < 0.0f || d10.y < 0.0f)) {
            z11 = true;
        }
        if (z11 == z10) {
            i15 = -1;
        }
        int i16 = O + i15;
        if (i16 < 0 || i16 >= L) {
            return -1;
        }
        return i16;
    }

    public final z0 j(q1 q1Var) {
        y0 y0Var = this.f1944d;
        if (y0Var == null || y0Var.f2270a != q1Var) {
            this.f1944d = z0.a(q1Var);
        }
        return this.f1944d;
    }

    public final z0 k(q1 q1Var) {
        y0 y0Var = this.f1943c;
        if (y0Var == null || y0Var.f2270a != q1Var) {
            this.f1943c = z0.c(q1Var);
        }
        return this.f1943c;
    }
}
