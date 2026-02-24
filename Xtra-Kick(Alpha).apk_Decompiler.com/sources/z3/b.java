package z3;

import android.animation.ValueAnimator;
import android.widget.TextView;

public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17507a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f17508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f17509c;

    public /* synthetic */ b(Object obj, int i10, Object obj2) {
        this.f17507a = i10;
        this.f17509c = obj;
        this.f17508b = obj2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f17507a;
        Object obj = this.f17508b;
        switch (i10) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                e eVar = (e) this.f17509c;
                d dVar = (d) obj;
                eVar.getClass();
                e.c(floatValue, dVar);
                eVar.a(floatValue, dVar, false);
                eVar.invalidateSelf();
                return;
            default:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) obj;
                textView.setScaleX(floatValue2);
                textView.setScaleY(floatValue2);
                return;
        }
    }
}
