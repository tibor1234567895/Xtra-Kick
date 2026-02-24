package i3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.ui.DefaultTimeBar;

public final class a0 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f8026b;

    public /* synthetic */ a0(c0 c0Var, int i10) {
        this.f8025a = i10;
        this.f8026b = c0Var;
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f8025a;
        c0 c0Var = this.f8026b;
        switch (i10) {
            case 0:
                View view = c0Var.f8039b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = c0Var.f8040c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = c0Var.f8042e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                    return;
                }
                return;
            case 2:
                c0Var.j(0);
                return;
            case 3:
                c0Var.j(0);
                return;
            case 4:
                ViewGroup viewGroup3 = c0Var.f8043f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                    return;
                }
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                ViewGroup viewGroup4 = c0Var.f8045h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                    return;
                }
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        int i10 = this.f8025a;
        int i11 = 4;
        c0 c0Var = this.f8026b;
        switch (i10) {
            case 0:
                View view = c0Var.f8047j;
                if ((view instanceof DefaultTimeBar) && !c0Var.A) {
                    DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                    ValueAnimator valueAnimator = defaultTimeBar.L;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(new float[]{defaultTimeBar.M, 0.0f});
                    valueAnimator.setDuration(250);
                    valueAnimator.start();
                    return;
                }
                return;
            case 1:
                View view2 = c0Var.f8039b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = c0Var.f8040c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = c0Var.f8042e;
                if (viewGroup2 != null) {
                    if (c0Var.A) {
                        i11 = 0;
                    }
                    viewGroup2.setVisibility(i11);
                }
                View view3 = c0Var.f8047j;
                if ((view3 instanceof DefaultTimeBar) && !c0Var.A) {
                    DefaultTimeBar defaultTimeBar2 = (DefaultTimeBar) view3;
                    ValueAnimator valueAnimator2 = defaultTimeBar2.L;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    defaultTimeBar2.N = false;
                    valueAnimator2.setFloatValues(new float[]{defaultTimeBar2.M, 1.0f});
                    valueAnimator2.setDuration(250);
                    valueAnimator2.start();
                    return;
                }
                return;
            case 2:
                c0Var.j(4);
                return;
            case 3:
                c0Var.j(4);
                return;
            case 4:
                ViewGroup viewGroup3 = c0Var.f8045h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    ViewGroup viewGroup4 = c0Var.f8045h;
                    viewGroup4.setTranslationX((float) viewGroup4.getWidth());
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                    return;
                }
                return;
            default:
                ViewGroup viewGroup5 = c0Var.f8043f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                    return;
                }
                return;
        }
    }
}
