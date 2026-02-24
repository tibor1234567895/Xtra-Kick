package y8;

import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f17119b;

    public /* synthetic */ a(d dVar, int i10) {
        this.f17118a = i10;
        this.f17119b = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f17118a;
        d dVar = this.f17119b;
        switch (i10) {
            case 0:
                dVar.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = dVar.f17177d;
                checkableImageButton.setScaleX(floatValue);
                checkableImageButton.setScaleY(floatValue);
                return;
            default:
                dVar.getClass();
                dVar.f17177d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
