package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.carousel.CarouselLayoutManager;

public final class a1 extends u0 {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f1930q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f1931r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(int i10, Context context, Object obj) {
        super(context);
        this.f1930q = i10;
        this.f1931r = obj;
    }

    public final PointF a(int i10) {
        switch (this.f1930q) {
            case 2:
                ((CarouselLayoutManager) this.f1931r).getClass();
                return null;
            default:
                return super.a(i10);
        }
    }

    public final void f(View view, g2 g2Var, d2 d2Var) {
        DecelerateInterpolator decelerateInterpolator = this.f2203j;
        int i10 = this.f1930q;
        Object obj = this.f1931r;
        switch (i10) {
            case 0:
                b1 b1Var = (b1) obj;
                int[] c10 = b1Var.c(b1Var.f2158a.getLayoutManager(), view);
                int i11 = c10[0];
                int i12 = c10[1];
                int k10 = k(Math.max(Math.abs(i11), Math.abs(i12)));
                if (k10 > 0) {
                    d2Var.f1959a = i11;
                    d2Var.f1960b = i12;
                    d2Var.f1961c = k10;
                    d2Var.f1963e = decelerateInterpolator;
                    d2Var.f1964f = true;
                    return;
                }
                return;
            case 1:
                q2 q2Var = (q2) obj;
                RecyclerView recyclerView = q2Var.f2158a;
                if (recyclerView != null) {
                    int[] c11 = q2Var.c(recyclerView.getLayoutManager(), view);
                    int i13 = c11[0];
                    int i14 = c11[1];
                    int k11 = k(Math.max(Math.abs(i13), Math.abs(i14)));
                    if (k11 > 0) {
                        d2Var.f1959a = i13;
                        d2Var.f1960b = i14;
                        d2Var.f1961c = k11;
                        d2Var.f1963e = decelerateInterpolator;
                        d2Var.f1964f = true;
                        return;
                    }
                    return;
                }
                return;
            default:
                super.f(view, g2Var, d2Var);
                return;
        }
    }

    public final int i(View view, int i10) {
        switch (this.f1930q) {
            case 2:
                ((CarouselLayoutManager) this.f1931r).getClass();
                throw null;
            default:
                return super.i(view, i10);
        }
    }

    public final float j(DisplayMetrics displayMetrics) {
        int i10;
        switch (this.f1930q) {
            case 0:
                i10 = displayMetrics.densityDpi;
                break;
            case 1:
                i10 = displayMetrics.densityDpi;
                break;
            case 3:
                i10 = displayMetrics.densityDpi;
                break;
            default:
                return 25.0f / ((float) displayMetrics.densityDpi);
        }
        return 100.0f / ((float) i10);
    }

    public final int l(int i10) {
        switch (this.f1930q) {
            case 0:
                return Math.min(100, super.l(i10));
            default:
                return super.l(i10);
        }
    }
}
