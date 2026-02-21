package z3;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class g extends Animation {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f17544h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f17545i;

    public /* synthetic */ g(m mVar, int i10) {
        this.f17544h = i10;
        this.f17545i = mVar;
    }

    public final void applyTransformation(float f10, Transformation transformation) {
        int i10 = this.f17544h;
        m mVar = this.f17545i;
        switch (i10) {
            case 0:
                mVar.setAnimationProgress(f10);
                return;
            case 1:
                mVar.setAnimationProgress(1.0f - f10);
                return;
            case 2:
                mVar.getClass();
                int abs = mVar.E - Math.abs(mVar.D);
                int i11 = mVar.C;
                mVar.setTargetOffsetTopAndBottom((i11 + ((int) (((float) (abs - i11)) * f10))) - mVar.A.getTop());
                e eVar = mVar.G;
                float f11 = 1.0f - f10;
                d dVar = eVar.f17536h;
                if (f11 != dVar.f17527p) {
                    dVar.f17527p = f11;
                }
                eVar.invalidateSelf();
                return;
            case 3:
                mVar.k(f10);
                return;
            default:
                mVar.getClass();
                mVar.setAnimationProgress((-0.0f * f10) + 0.0f);
                mVar.k(f10);
                return;
        }
    }
}
