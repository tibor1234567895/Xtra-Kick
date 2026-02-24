package androidx.lifecycle;

import hb.h0;
import java.util.concurrent.CancellationException;
import pa.k;
import xa.j;

public final class LifecycleCoroutineScopeImpl extends x implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final t f1628h;

    /* renamed from: i  reason: collision with root package name */
    public final k f1629i;

    public LifecycleCoroutineScopeImpl(t tVar, k kVar) {
        j.f("coroutineContext", kVar);
        this.f1628h = tVar;
        this.f1629i = kVar;
        if (tVar.b() == s.DESTROYED) {
            h0.w(kVar, (CancellationException) null);
        }
    }

    public final t c() {
        return this.f1628h;
    }

    public final void d(d0 d0Var, r rVar) {
        t tVar = this.f1628h;
        if (tVar.b().compareTo(s.DESTROYED) <= 0) {
            tVar.c(this);
            h0.w(this.f1629i, (CancellationException) null);
        }
    }

    public final k v() {
        return this.f1629i;
    }
}
