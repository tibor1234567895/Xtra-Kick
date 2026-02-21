package androidx.recyclerview.widget;

import android.view.View;

public abstract class o2 extends n1 {

    /* renamed from: g  reason: collision with root package name */
    public boolean f2116g = true;

    public final boolean a(k2 k2Var, m1 m1Var, m1 m1Var2) {
        int i10;
        int i11;
        if (m1Var == null || ((i10 = m1Var.f2084a) == (i11 = m1Var2.f2084a) && m1Var.f2085b == m1Var2.f2085b)) {
            m(k2Var);
            return true;
        }
        return o(k2Var, i10, m1Var.f2085b, i11, m1Var2.f2085b);
    }

    public final boolean b(k2 k2Var, k2 k2Var2, m1 m1Var, m1 m1Var2) {
        int i10;
        int i11;
        int i12 = m1Var.f2084a;
        int i13 = m1Var.f2085b;
        if (k2Var2.shouldIgnore()) {
            int i14 = m1Var.f2084a;
            i10 = m1Var.f2085b;
            i11 = i14;
        } else {
            i11 = m1Var2.f2084a;
            i10 = m1Var2.f2085b;
        }
        return n(k2Var, k2Var2, i12, i13, i11, i10);
    }

    public final boolean c(k2 k2Var, m1 m1Var, m1 m1Var2) {
        int i10 = m1Var.f2084a;
        int i11 = m1Var.f2085b;
        View view = k2Var.itemView;
        int left = m1Var2 == null ? view.getLeft() : m1Var2.f2084a;
        int top = m1Var2 == null ? view.getTop() : m1Var2.f2085b;
        if (k2Var.isRemoved() || (i10 == left && i11 == top)) {
            p(k2Var);
            return true;
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return o(k2Var, i10, i11, left, top);
    }

    public final boolean d(k2 k2Var, m1 m1Var, m1 m1Var2) {
        int i10 = m1Var.f2084a;
        int i11 = m1Var2.f2084a;
        if (i10 == i11 && m1Var.f2085b == m1Var2.f2085b) {
            h(k2Var);
            return false;
        }
        return o(k2Var, i10, m1Var.f2085b, i11, m1Var2.f2085b);
    }

    public final boolean f(k2 k2Var) {
        return !this.f2116g || k2Var.isInvalid();
    }

    public abstract void m(k2 k2Var);

    public abstract boolean n(k2 k2Var, k2 k2Var2, int i10, int i11, int i12, int i13);

    public abstract boolean o(k2 k2Var, int i10, int i11, int i12, int i13);

    public abstract void p(k2 k2Var);
}
