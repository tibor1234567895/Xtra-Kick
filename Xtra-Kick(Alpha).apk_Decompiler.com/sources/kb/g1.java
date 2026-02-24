package kb;

import h3.u1;
import hb.h0;
import hb.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import lb.b;
import lb.c;
import pa.e;
import qa.a;
import qa.d;

public final class g1 extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9315a = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_state");
    private volatile Object _state;

    public final boolean a(b bVar) {
        e1 e1Var = (e1) bVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9315a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, f1.f9304a);
        return true;
    }

    public final e[] b(b bVar) {
        e1 e1Var = (e1) bVar;
        f9315a.set(this, (Object) null);
        return h0.f7803b;
    }

    public final Object c(d1 d1Var) {
        boolean z10 = true;
        l lVar = new l(1, d.b(d1Var));
        lVar.w();
        u1 u1Var = f1.f9304a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9315a;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, u1Var, lVar)) {
                if (atomicReferenceFieldUpdater.get(this) != u1Var) {
                    z10 = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z10) {
            int i10 = la.l.f9802h;
            lVar.resumeWith(v.f9814a);
        }
        Object u10 = lVar.u();
        a aVar = a.COROUTINE_SUSPENDED;
        if (u10 == aVar) {
            h0.m1(d1Var);
        }
        if (u10 == aVar) {
            return u10;
        }
        return v.f9814a;
    }
}
