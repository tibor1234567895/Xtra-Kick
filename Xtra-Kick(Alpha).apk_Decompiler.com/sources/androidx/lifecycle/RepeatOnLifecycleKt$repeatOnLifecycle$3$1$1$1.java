package androidx.lifecycle;

import hb.f0;
import hb.h0;
import hb.k;
import hb.l;
import hb.l1;
import java.util.concurrent.CancellationException;
import la.v;
import ob.a;
import ob.d;
import pa.e;
import pa.h;
import wa.p;
import xa.u;

final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ r f1634h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ u f1635i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f0 f1636j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ r f1637k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ k f1638l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ a f1639m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ p f1640n;

    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r rVar, u uVar, f0 f0Var, r rVar2, l lVar, d dVar, p pVar) {
        this.f1634h = rVar;
        this.f1635i = uVar;
        this.f1636j = f0Var;
        this.f1637k = rVar2;
        this.f1638l = lVar;
        this.f1639m = dVar;
        this.f1640n = pVar;
    }

    public final void d(d0 d0Var, r rVar) {
        r rVar2 = this.f1634h;
        u uVar = this.f1635i;
        if (rVar == rVar2) {
            uVar.f16818h = h0.b1(this.f1636j, (h) null, 0, new a1(this.f1639m, this.f1640n, (e) null), 3);
            return;
        }
        if (rVar == this.f1637k) {
            l1 l1Var = (l1) uVar.f16818h;
            if (l1Var != null) {
                l1Var.e((CancellationException) null);
            }
            uVar.f16818h = null;
        }
        if (rVar == r.ON_DESTROY) {
            int i10 = la.l.f9802h;
            this.f1638l.resumeWith(v.f9814a);
        }
    }
}
