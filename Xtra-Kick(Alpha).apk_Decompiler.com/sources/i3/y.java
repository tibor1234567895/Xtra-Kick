package i3;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f8227b;

    public /* synthetic */ y(c0 c0Var, int i10) {
        this.f8226a = i10;
        this.f8227b = c0Var;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f8226a;
        c0 c0Var = this.f8227b;
        switch (i10) {
            case 0:
                c0Var.getClass();
                c0Var.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            case 1:
                c0Var.getClass();
                c0Var.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            case 2:
                c0Var.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view = c0Var.f8039b;
                if (view != null) {
                    view.setAlpha(floatValue);
                }
                ViewGroup viewGroup = c0Var.f8040c;
                if (viewGroup != null) {
                    viewGroup.setAlpha(floatValue);
                }
                ViewGroup viewGroup2 = c0Var.f8042e;
                if (viewGroup2 != null) {
                    viewGroup2.setAlpha(floatValue);
                    return;
                }
                return;
            default:
                c0Var.getClass();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view2 = c0Var.f8039b;
                if (view2 != null) {
                    view2.setAlpha(floatValue2);
                }
                ViewGroup viewGroup3 = c0Var.f8040c;
                if (viewGroup3 != null) {
                    viewGroup3.setAlpha(floatValue2);
                }
                ViewGroup viewGroup4 = c0Var.f8042e;
                if (viewGroup4 != null) {
                    viewGroup4.setAlpha(floatValue2);
                    return;
                }
                return;
        }
    }
}
