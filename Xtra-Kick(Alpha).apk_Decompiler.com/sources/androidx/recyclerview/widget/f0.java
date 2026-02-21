package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

public final class f0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f1979a;

    public f0(g0 g0Var) {
        this.f1979a = g0Var;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        g0 g0Var = this.f1979a;
        g0Var.f1994c.setAlpha(floatValue);
        g0Var.f1995d.setAlpha(floatValue);
        g0Var.f2010s.invalidate();
    }
}
