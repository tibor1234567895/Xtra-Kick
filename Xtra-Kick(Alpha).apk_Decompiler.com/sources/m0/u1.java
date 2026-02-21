package m0;

import android.animation.ValueAnimator;
import android.support.v4.media.n;
import android.view.View;
import p9.b;
import p9.f;
import p9.l;
import t9.w;

public final class u1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10144h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f10145i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f10146j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f10147k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f10148l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f10149m;

    public u1(v1 v1Var, View view, a2 a2Var, n nVar, ValueAnimator valueAnimator) {
        this.f10149m = v1Var;
        this.f10145i = view;
        this.f10146j = a2Var;
        this.f10147k = nVar;
        this.f10148l = valueAnimator;
    }

    public final void run() {
        int i10 = this.f10144h;
        Object obj = this.f10148l;
        Object obj2 = this.f10147k;
        Object obj3 = this.f10145i;
        switch (i10) {
            case 0:
                w1.h((View) obj3, (n) obj2);
                ((ValueAnimator) obj).start();
                return;
            default:
                ((l) obj3).b((b) obj2, (f) obj, (Throwable) this.f10149m);
                return;
        }
    }

    public /* synthetic */ u1(l lVar, w wVar, b bVar, f fVar, Throwable th) {
        this.f10145i = lVar;
        this.f10146j = wVar;
        this.f10147k = bVar;
        this.f10148l = fVar;
        this.f10149m = th;
    }
}
