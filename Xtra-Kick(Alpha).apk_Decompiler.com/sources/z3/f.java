package z3;

import android.view.animation.Animation;
import l6.q;
import l6.x;
import n3.x3;
import xa.j;

public final class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17542a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f17543b;

    public /* synthetic */ f(m mVar, int i10) {
        this.f17542a = i10;
        this.f17543b = mVar;
    }

    public final void onAnimationEnd(Animation animation) {
        j jVar;
        int i10 = this.f17542a;
        m mVar = this.f17543b;
        switch (i10) {
            case 0:
                if (mVar.f17552j) {
                    mVar.G.setAlpha(255);
                    mVar.G.start();
                    if (mVar.L && (jVar = mVar.f17551i) != null) {
                        int i11 = x.f9680j0;
                        x3 x3Var = ((q) jVar).f9659h;
                        j.f("$pagingAdapter", x3Var);
                        x3Var.b();
                    }
                    mVar.f17563u = mVar.A.getTop();
                    return;
                }
                mVar.l();
                return;
            default:
                mVar.getClass();
                g gVar = new g(mVar, 1);
                mVar.I = gVar;
                gVar.setDuration(150);
                a aVar = mVar.A;
                aVar.f17505h = null;
                aVar.clearAnimation();
                mVar.A.startAnimation(mVar.I);
                return;
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
