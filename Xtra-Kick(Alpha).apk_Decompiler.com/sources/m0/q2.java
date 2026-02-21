package m0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import e0.d;
import java.util.WeakHashMap;
import l0.b;

public final class q2 {

    /* renamed from: b  reason: collision with root package name */
    public static final q2 f10130b = (Build.VERSION.SDK_INT >= 30 ? l2.f10119q : m2.f10120b);

    /* renamed from: a  reason: collision with root package name */
    public final m2 f10131a;

    public q2() {
        this.f10131a = new m2(this);
    }

    public static d f(d dVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, dVar.f4856a - i10);
        int max2 = Math.max(0, dVar.f4857b - i11);
        int max3 = Math.max(0, dVar.f4858c - i12);
        int max4 = Math.max(0, dVar.f4859d - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? dVar : d.b(max, max2, max3, max4);
    }

    public static q2 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        q2 q2Var = new q2(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (l0.b(view)) {
                q2 h10 = c1.h(view);
                m2 m2Var = q2Var.f10131a;
                m2Var.p(h10);
                m2Var.d(view.getRootView());
            }
        }
        return q2Var;
    }

    public final d a(int i10) {
        return this.f10131a.f(i10);
    }

    public final int b() {
        return this.f10131a.j().f4859d;
    }

    public final int c() {
        return this.f10131a.j().f4856a;
    }

    public final int d() {
        return this.f10131a.j().f4858c;
    }

    public final int e() {
        return this.f10131a.j().f4857b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q2)) {
            return false;
        }
        return b.a(this.f10131a, ((q2) obj).f10131a);
    }

    public final WindowInsets g() {
        m2 m2Var = this.f10131a;
        if (m2Var instanceof h2) {
            return ((h2) m2Var).f10094c;
        }
        return null;
    }

    public final int hashCode() {
        m2 m2Var = this.f10131a;
        if (m2Var == null) {
            return 0;
        }
        return m2Var.hashCode();
    }

    public q2(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        this.f10131a = i10 >= 30 ? new l2(this, windowInsets) : i10 >= 29 ? new k2(this, windowInsets) : i10 >= 28 ? new j2(this, windowInsets) : new i2(this, windowInsets);
    }
}
