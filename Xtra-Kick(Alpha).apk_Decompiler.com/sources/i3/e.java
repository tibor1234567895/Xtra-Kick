package i3;

import android.animation.ValueAnimator;
import androidx.media3.ui.DefaultTimeBar;
import y8.k;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f8075b;

    public /* synthetic */ e(int i10, Object obj) {
        this.f8074a = i10;
        this.f8075b = obj;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f8074a;
        Object obj = this.f8075b;
        switch (i10) {
            case 0:
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) obj;
                int i11 = DefaultTimeBar.W;
                defaultTimeBar.getClass();
                defaultTimeBar.M = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f1828h);
                return;
            default:
                k kVar = (k) obj;
                kVar.getClass();
                kVar.f17177d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
