package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class u0 extends f2 {

    /* renamed from: i  reason: collision with root package name */
    public final LinearInterpolator f2202i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final DecelerateInterpolator f2203j = new DecelerateInterpolator();

    /* renamed from: k  reason: collision with root package name */
    public PointF f2204k;

    /* renamed from: l  reason: collision with root package name */
    public final DisplayMetrics f2205l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2206m = false;

    /* renamed from: n  reason: collision with root package name */
    public float f2207n;

    /* renamed from: o  reason: collision with root package name */
    public int f2208o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f2209p = 0;

    public u0(Context context) {
        this.f2205l = context.getResources().getDisplayMetrics();
    }

    public static int h(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 == 0) {
            int i15 = i12 - i10;
            if (i15 > 0) {
                return i15;
            }
            int i16 = i13 - i11;
            if (i16 < 0) {
                return i16;
            }
            return 0;
        } else if (i14 == 1) {
            return i13 - i11;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public final void c(int i10, int i11, d2 d2Var) {
        if (this.f1984b.mLayout.H() == 0) {
            g();
            return;
        }
        int i12 = this.f2208o;
        int i13 = i12 - i10;
        int i14 = 0;
        if (i12 * i13 <= 0) {
            i13 = 0;
        }
        this.f2208o = i13;
        int i15 = this.f2209p;
        int i16 = i15 - i11;
        if (i15 * i16 > 0) {
            i14 = i16;
        }
        this.f2209p = i14;
        if (i13 == 0 && i14 == 0) {
            PointF a10 = a(this.f1983a);
            if (a10 != null) {
                float f10 = a10.x;
                if (!(f10 == 0.0f && a10.y == 0.0f)) {
                    float f11 = a10.y;
                    float sqrt = (float) Math.sqrt((double) ((f11 * f11) + (f10 * f10)));
                    float f12 = a10.x / sqrt;
                    a10.x = f12;
                    float f13 = a10.y / sqrt;
                    a10.y = f13;
                    this.f2204k = a10;
                    this.f2208o = (int) (f12 * 10000.0f);
                    this.f2209p = (int) (f13 * 10000.0f);
                    int l10 = l(10000);
                    LinearInterpolator linearInterpolator = this.f2202i;
                    d2Var.f1959a = (int) (((float) this.f2208o) * 1.2f);
                    d2Var.f1960b = (int) (((float) this.f2209p) * 1.2f);
                    d2Var.f1961c = (int) (((float) l10) * 1.2f);
                    d2Var.f1963e = linearInterpolator;
                    d2Var.f1964f = true;
                    return;
                }
            }
            d2Var.f1962d = this.f1983a;
            g();
        }
    }

    public final void d() {
    }

    public final void e() {
        this.f2209p = 0;
        this.f2208o = 0;
        this.f2204k = null;
    }

    public void f(View view, g2 g2Var, d2 d2Var) {
        int i10;
        int i11;
        int i12;
        PointF pointF = this.f2204k;
        int i13 = -1;
        int i14 = 0;
        if (pointF == null || pointF.x == 0.0f) {
            i10 = 0;
        } else if (i12 > 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        int i15 = i(view, i10);
        PointF pointF2 = this.f2204k;
        if (pointF2 == null || pointF2.y == 0.0f) {
            i13 = 0;
        } else if (i11 > 0) {
            i13 = 1;
        }
        q1 q1Var = this.f1985c;
        if (q1Var != null && q1Var.p()) {
            r1 r1Var = (r1) view.getLayoutParams();
            i14 = h((view.getTop() - q1.S(view)) - r1Var.topMargin, q1.F(view) + view.getBottom() + r1Var.bottomMargin, q1Var.getPaddingTop(), q1Var.f2157v - q1Var.getPaddingBottom(), i13);
        }
        int k10 = k((int) Math.sqrt((double) ((i14 * i14) + (i15 * i15))));
        if (k10 > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2203j;
            d2Var.f1959a = -i15;
            d2Var.f1960b = -i14;
            d2Var.f1961c = k10;
            d2Var.f1963e = decelerateInterpolator;
            d2Var.f1964f = true;
        }
    }

    public int i(View view, int i10) {
        q1 q1Var = this.f1985c;
        if (q1Var == null || !q1Var.o()) {
            return 0;
        }
        r1 r1Var = (r1) view.getLayoutParams();
        return h((view.getLeft() - q1.N(view)) - r1Var.leftMargin, q1.Q(view) + view.getRight() + r1Var.rightMargin, q1Var.getPaddingLeft(), q1Var.f2156u - q1Var.getPaddingRight(), i10);
    }

    public float j(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public final int k(int i10) {
        return (int) Math.ceil(((double) l(i10)) / 0.3356d);
    }

    public int l(int i10) {
        float abs = (float) Math.abs(i10);
        if (!this.f2206m) {
            this.f2207n = j(this.f2205l);
            this.f2206m = true;
        }
        return (int) Math.ceil((double) (abs * this.f2207n));
    }
}
