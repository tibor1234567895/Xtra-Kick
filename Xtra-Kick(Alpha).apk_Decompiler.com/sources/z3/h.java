package z3;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class h extends Animation {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17546h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f17547i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ m f17548j;

    public h(m mVar, int i10, int i11) {
        this.f17548j = mVar;
        this.f17546h = i10;
        this.f17547i = i11;
    }

    public final void applyTransformation(float f10, Transformation transformation) {
        e eVar = this.f17548j.G;
        int i10 = this.f17546h;
        eVar.setAlpha((int) ((((float) (this.f17547i - i10)) * f10) + ((float) i10)));
    }
}
