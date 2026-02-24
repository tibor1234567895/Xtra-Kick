package hb;

import h3.u1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import mb.i;
import pa.e;
import xa.j;

public final class o extends n1 {

    /* renamed from: l  reason: collision with root package name */
    public final l f7830l;

    public o(l lVar) {
        this.f7830l = lVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        o((Throwable) obj);
        return v.f9814a;
    }

    public final void o(Throwable th) {
        boolean z10;
        u1 p10 = p();
        l lVar = this.f7830l;
        Throwable t10 = lVar.t(p10);
        boolean z11 = false;
        if (lVar.z()) {
            e eVar = lVar.f7821k;
            j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", eVar);
            i iVar = (i) eVar;
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.f10859o;
                Object obj = atomicReferenceFieldUpdater.get(iVar);
                u1 u1Var = mb.j.f10865b;
                boolean z12 = true;
                if (j.a(obj, u1Var)) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(iVar, u1Var, t10)) {
                            if (atomicReferenceFieldUpdater.get(iVar) != u1Var) {
                                z10 = false;
                                break;
                            }
                        } else {
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        break;
                    }
                } else if (obj instanceof Throwable) {
                    break;
                } else {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(iVar, obj, (Object) null)) {
                            if (atomicReferenceFieldUpdater.get(iVar) != obj) {
                                z12 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z12) {
                        break;
                    }
                }
            }
            z11 = true;
        }
        if (!z11) {
            lVar.q(t10);
            if (!lVar.z()) {
                lVar.r();
            }
        }
    }
}
