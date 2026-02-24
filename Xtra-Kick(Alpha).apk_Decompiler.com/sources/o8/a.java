package o8;

import android.animation.ValueAnimator;

public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f12308a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f12309b;

    public a(d dVar, float f10) {
        this.f12309b = dVar;
        this.f12308a = f10;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f12309b.d(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f12308a);
    }
}
