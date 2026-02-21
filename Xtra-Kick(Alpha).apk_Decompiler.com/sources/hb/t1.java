package hb;

import h3.u1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import mb.b;
import mb.n;
import mb.p;
import xa.j;

public final class t1 extends b {

    /* renamed from: b  reason: collision with root package name */
    public final p f7853b;

    /* renamed from: c  reason: collision with root package name */
    public p f7854c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u1 f7855d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f7856e;

    public t1(p pVar, u1 u1Var, Object obj) {
        this.f7855d = u1Var;
        this.f7856e = obj;
        this.f7853b = pVar;
    }

    public final void b(Object obj, Object obj2) {
        boolean z10;
        p pVar;
        p pVar2 = (p) obj;
        boolean z11 = false;
        if (obj2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p pVar3 = this.f7853b;
        if (z10) {
            pVar = pVar3;
        } else {
            pVar = this.f7854c;
        }
        if (pVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p.f10873h;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(pVar2, this, pVar)) {
                    if (atomicReferenceFieldUpdater.get(pVar2) != this) {
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            if (z11 && z10) {
                p pVar4 = this.f7854c;
                j.c(pVar4);
                pVar3.i(pVar4);
            }
        }
    }

    public final u1 c(Object obj) {
        boolean z10;
        p pVar = (p) obj;
        if (this.f7855d.H() == this.f7856e) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        return n.f10872a;
    }
}
