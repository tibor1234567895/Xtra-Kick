package mb;

import h3.u1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import wa.p;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f10843a = new u1("CLOSED", 2);

    public static final Object a(z zVar, long j10, p pVar) {
        boolean z10;
        while (true) {
            if (zVar.f10890j >= j10 && !zVar.c()) {
                return zVar;
            }
            Object obj = e.f10845h.get(zVar);
            u1 u1Var = f10843a;
            if (obj == u1Var) {
                return u1Var;
            }
            z zVar2 = (z) ((e) obj);
            if (zVar2 == null) {
                zVar2 = (z) pVar.g(Long.valueOf(zVar.f10890j + 1), zVar);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f10845h;
                    if (!atomicReferenceFieldUpdater.compareAndSet(zVar, (Object) null, zVar2)) {
                        if (atomicReferenceFieldUpdater.get(zVar) != null) {
                            z10 = false;
                            break;
                        }
                    } else {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    if (zVar.c()) {
                        zVar.d();
                    }
                }
            }
            zVar = zVar2;
        }
    }
}
