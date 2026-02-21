package androidx.lifecycle;

import hb.d0;
import hb.p0;
import hb.x1;
import mb.u;
import nb.e;
import pa.k;
import xa.j;

public final class r0 extends d0 {

    /* renamed from: j  reason: collision with root package name */
    public final j f1745j = new j();

    public final void M0(k kVar, Runnable runnable) {
        boolean z10;
        j.f("context", kVar);
        j.f("block", runnable);
        j jVar = this.f1745j;
        jVar.getClass();
        e eVar = p0.f7833a;
        x1 Q0 = u.f10886a.Q0();
        if (!Q0.O0(kVar)) {
            if (jVar.f1704b || !jVar.f1703a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (jVar.f1706d.offer(runnable)) {
                    jVar.a();
                    return;
                }
                throw new IllegalStateException("cannot enqueue any more runnables".toString());
            }
        }
        Q0.M0(kVar, new g.r0(jVar, 5, runnable));
    }

    public final boolean O0(k kVar) {
        boolean z10;
        j.f("context", kVar);
        e eVar = p0.f7833a;
        if (u.f10886a.Q0().O0(kVar)) {
            return true;
        }
        j jVar = this.f1745j;
        if (jVar.f1704b || !jVar.f1703a) {
            z10 = true;
        } else {
            z10 = false;
        }
        return !z10;
    }
}
