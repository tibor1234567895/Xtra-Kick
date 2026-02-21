package n1;

import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;
import d9.r0;
import h3.b0;
import h3.e2;
import h3.f4;
import h3.g2;
import h3.n1;
import h3.o1;
import h3.t3;
import h3.w2;
import h3.x2;
import h3.y0;
import h3.y1;
import h9.a0;
import h9.w;
import j1.a;
import j1.p;
import j1.q;
import j1.v;

public final /* synthetic */ class h implements q, n1, w2 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10969h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f10970i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f10971j;

    public /* synthetic */ h(int i10, f4 f4Var, Bundle bundle) {
        this.f10969h = i10;
        this.f10970i = f4Var;
        this.f10971j = bundle;
    }

    public final void e(e2 e2Var) {
        x2 x2Var = (x2) this.f10970i;
        MediaDescriptionCompat mediaDescriptionCompat = (MediaDescriptionCompat) this.f10971j;
        int i10 = x2.f7435t;
        x2Var.getClass();
        if (TextUtils.isEmpty(mediaDescriptionCompat.f299h)) {
            v.g("MediaSessionLegacyStub", "onAddQueueItem(): Media ID shouldn't be empty");
            return;
        }
        w.a(x2Var.f7437g.g(e2Var, r0.n(t3.j(mediaDescriptionCompat))), new j0.h(this.f10969h, (Object) x2Var), h9.q.f7765h);
    }

    public final void g(y0 y0Var) {
        boolean z10;
        f4 f4Var = (f4) this.f10970i;
        Bundle bundle = (Bundle) this.f10971j;
        int i10 = o1.f7265e;
        if (y0Var.H0()) {
            b0 b0Var = y0Var.f7453a;
            b0Var.getClass();
            if (Looper.myLooper() == b0Var.N0()) {
                z10 = true;
            } else {
                z10 = false;
            }
            a.e(z10);
            a0 d10 = b0Var.f6925d.d(b0Var, f4Var, bundle);
            a.d(d10, "ControllerCallback#onCustomCommand() must not return null");
            d10.a(new p((Object) y0Var, (Object) d10, this.f10969h, 3), h9.q.f7765h);
        }
    }

    public final void invoke(Object obj) {
        ((c) obj).getClass();
    }

    public /* synthetic */ h(y1 y1Var, int i10, g2 g2Var) {
        this.f10970i = y1Var;
        this.f10969h = i10;
        this.f10971j = g2Var;
    }

    public /* synthetic */ h(Object obj, int i10, Object obj2) {
        this.f10970i = obj;
        this.f10971j = obj2;
        this.f10969h = i10;
    }
}
