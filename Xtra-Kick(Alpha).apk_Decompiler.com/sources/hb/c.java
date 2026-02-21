package hb;

import h3.u1;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.l;
import la.v;

public final class c extends p1 {

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7779o = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer");
    private volatile Object _disposer;

    /* renamed from: l  reason: collision with root package name */
    public final k f7780l;

    /* renamed from: m  reason: collision with root package name */
    public q0 f7781m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ e f7782n;

    public c(e eVar, l lVar) {
        this.f7782n = eVar;
        this.f7780l = lVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        o((Throwable) obj);
        return v.f9814a;
    }

    public final void o(Throwable th) {
        k kVar = this.f7780l;
        if (th != null) {
            u1 m10 = kVar.m(th);
            if (m10 != null) {
                kVar.n(m10);
                d dVar = (d) f7779o.get(this);
                if (dVar != null) {
                    dVar.c();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f7787b;
        e eVar = this.f7782n;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            k0[] k0VarArr = eVar.f7788a;
            ArrayList arrayList = new ArrayList(k0VarArr.length);
            for (k0 k10 : k0VarArr) {
                arrayList.add(k10.k());
            }
            int i10 = l.f9802h;
            kVar.resumeWith(arrayList);
        }
    }
}
