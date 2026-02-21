package m0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.support.v4.media.n;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import b8.j;
import e0.d;
import java.util.Objects;

public final class v1 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final j f10152a;

    /* renamed from: b  reason: collision with root package name */
    public q2 f10153b;

    public v1(View view, j jVar) {
        q2 q2Var;
        g2 g2Var;
        this.f10152a = jVar;
        q2 h10 = c1.h(view);
        if (h10 != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                g2Var = new f2(h10);
            } else if (i10 >= 29) {
                g2Var = new e2(h10);
            } else {
                g2Var = new d2(h10);
            }
            q2Var = g2Var.b();
        } else {
            q2Var = null;
        }
        this.f10153b = q2Var;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Interpolator interpolator;
        View view2 = view;
        WindowInsets windowInsets2 = windowInsets;
        if (!view.isLaidOut()) {
            this.f10153b = q2.h(view, windowInsets);
        } else {
            q2 h10 = q2.h(view, windowInsets);
            if (this.f10153b == null) {
                this.f10153b = c1.h(view);
            }
            if (this.f10153b == null) {
                this.f10153b = h10;
            } else {
                j j10 = w1.j(view);
                if (j10 != null && Objects.equals(j10.f2690a, windowInsets2)) {
                    return w1.i(view, windowInsets);
                }
                q2 q2Var = this.f10153b;
                int i10 = 0;
                for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                    if (!h10.a(i11).equals(q2Var.a(i11))) {
                        i10 |= i11;
                    }
                }
                if (i10 == 0) {
                    return w1.i(view, windowInsets);
                }
                q2 q2Var2 = this.f10153b;
                if ((i10 & 8) == 0) {
                    interpolator = w1.f10156g;
                } else if (h10.a(8).f4859d > q2Var2.a(8).f4859d) {
                    interpolator = w1.f10154e;
                } else {
                    interpolator = w1.f10155f;
                }
                a2 a2Var = new a2(i10, interpolator, 160);
                z1 z1Var = a2Var.f10039a;
                z1Var.d(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(z1Var.a());
                d a10 = h10.a(i10);
                d a11 = q2Var2.a(i10);
                int min = Math.min(a10.f4856a, a11.f4856a);
                int i12 = a10.f4857b;
                int i13 = a11.f4857b;
                int min2 = Math.min(i12, i13);
                int i14 = a10.f4858c;
                int i15 = a11.f4858c;
                int min3 = Math.min(i14, i15);
                ValueAnimator valueAnimator = duration;
                int i16 = a10.f4859d;
                int i17 = i10;
                int i18 = a11.f4859d;
                n nVar = new n((Object) d.b(min, min2, min3, Math.min(i16, i18)), 6, (Object) d.b(Math.max(a10.f4856a, a11.f4856a), Math.max(i12, i13), Math.max(i14, i15), Math.max(i16, i18)));
                w1.f(view2, windowInsets2, false);
                ValueAnimator valueAnimator2 = valueAnimator;
                valueAnimator2.addUpdateListener(new t1(a2Var, h10, q2Var2, i17, view));
                valueAnimator2.addListener(new l1(this, a2Var, view2, 1));
                b0.a(view2, new u1(this, view, a2Var, nVar, valueAnimator2));
                this.f10153b = h10;
                return w1.i(view, windowInsets);
            }
        }
        return w1.i(view, windowInsets);
    }
}
