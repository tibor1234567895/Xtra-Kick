package ob;

import h3.u1;
import hb.d0;
import hb.k;
import hb.k2;
import hb.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import mb.z;

public final class c implements k, k2 {

    /* renamed from: h  reason: collision with root package name */
    public final l f12371h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f12372i = null;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f12373j;

    public c(d dVar, l lVar) {
        this.f12373j = dVar;
        this.f12371h = lVar;
    }

    public final void a(z zVar, int i10) {
        this.f12371h.a(zVar, i10);
    }

    public final void d(d0 d0Var, v vVar) {
        this.f12371h.d(d0Var, vVar);
    }

    public final u1 f(Object obj, wa.l lVar) {
        d dVar = this.f12373j;
        b bVar = new b(dVar, this, 1);
        u1 F = this.f12371h.F((v) obj, bVar);
        if (F != null) {
            d.f12374h.set(dVar, this.f12372i);
        }
        return F;
    }

    public final pa.k getContext() {
        return this.f12371h.f7822l;
    }

    public final void i(Object obj, wa.l lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f12374h;
        Object obj2 = this.f12372i;
        d dVar = this.f12373j;
        atomicReferenceFieldUpdater.set(dVar, obj2);
        b bVar = new b(dVar, this, 0);
        this.f12371h.i((v) obj, bVar);
    }

    public final void j(wa.l lVar) {
        this.f12371h.j(lVar);
    }

    public final u1 m(Throwable th) {
        return this.f12371h.m(th);
    }

    public final void n(Object obj) {
        this.f12371h.n(obj);
    }

    public final void resumeWith(Object obj) {
        this.f12371h.resumeWith(obj);
    }
}
