package m0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import e0.d;
import java.util.Collections;

public final class t1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a2 f10134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q2 f10135b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q2 f10136c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f10137d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f10138e;

    public t1(a2 a2Var, q2 q2Var, q2 q2Var2, int i10, View view) {
        this.f10134a = a2Var;
        this.f10135b = q2Var;
        this.f10136c = q2Var2;
        this.f10137d = i10;
        this.f10138e = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        g2 g2Var;
        d dVar;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        a2 a2Var = this.f10134a;
        a2Var.f10039a.d(animatedFraction);
        float b10 = a2Var.f10039a.b();
        PathInterpolator pathInterpolator = w1.f10154e;
        int i10 = Build.VERSION.SDK_INT;
        q2 q2Var = this.f10135b;
        if (i10 >= 30) {
            g2Var = new f2(q2Var);
        } else if (i10 >= 29) {
            g2Var = new e2(q2Var);
        } else {
            g2Var = new d2(q2Var);
        }
        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
            if ((this.f10137d & i11) == 0) {
                dVar = q2Var.a(i11);
            } else {
                d a10 = q2Var.a(i11);
                d a11 = this.f10136c.a(i11);
                float f10 = 1.0f - b10;
                dVar = q2.f(a10, (int) (((double) (((float) (a10.f4856a - a11.f4856a)) * f10)) + 0.5d), (int) (((double) (((float) (a10.f4857b - a11.f4857b)) * f10)) + 0.5d), (int) (((double) (((float) (a10.f4858c - a11.f4858c)) * f10)) + 0.5d), (int) (((double) (((float) (a10.f4859d - a11.f4859d)) * f10)) + 0.5d));
            }
            g2Var.c(i11, dVar);
        }
        w1.g(this.f10138e, g2Var.b(), Collections.singletonList(a2Var));
    }
}
