package c4;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public final class b extends Animatable2.AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f2876a;

    public b(c cVar) {
        this.f2876a = cVar;
    }

    public final void onAnimationEnd(Drawable drawable) {
        this.f2876a.a(drawable);
    }

    public final void onAnimationStart(Drawable drawable) {
        this.f2876a.b(drawable);
    }
}
