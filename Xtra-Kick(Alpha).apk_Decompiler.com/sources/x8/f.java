package x8;

import android.animation.ValueAnimator;
import android.view.View;

public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f16748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f16749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f16750c;

    public f(g gVar, View view, View view2) {
        this.f16750c = gVar;
        this.f16748a = view;
        this.f16749b = view2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f16750c.c(this.f16748a, this.f16749b, valueAnimator.getAnimatedFraction());
    }
}
