package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    public final q1 f2270a;

    /* renamed from: b  reason: collision with root package name */
    public int f2271b = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f2272c = new Rect();

    public z0(q1 q1Var) {
        this.f2270a = q1Var;
    }

    public static y0 a(q1 q1Var) {
        return new y0(q1Var, 0);
    }

    public static y0 b(q1 q1Var, int i10) {
        if (i10 == 0) {
            return a(q1Var);
        }
        if (i10 == 1) {
            return c(q1Var);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static y0 c(q1 q1Var) {
        return new y0(q1Var, 1);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public final int l() {
        if (Integer.MIN_VALUE == this.f2271b) {
            return 0;
        }
        return k() - this.f2271b;
    }

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i10);
}
