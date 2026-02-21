package hb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import mb.p;
import mb.w;
import xa.j;

public abstract class p1 extends y implements q0, f1 {

    /* renamed from: k  reason: collision with root package name */
    public u1 f7835k;

    public final void a() {
        boolean z10;
        p pVar;
        boolean z11;
        u1 p10 = p();
        do {
            Object H = p10.H();
            z10 = false;
            if (H instanceof p1) {
                if (H == this) {
                    r0 r0Var = v1.f7873g;
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = u1.f7859h;
                        if (!atomicReferenceFieldUpdater.compareAndSet(p10, H, r0Var)) {
                            if (atomicReferenceFieldUpdater.get(p10) != H) {
                                continue;
                                break;
                            }
                        } else {
                            z10 = true;
                            continue;
                            break;
                        }
                    }
                } else {
                    return;
                }
            } else if ((H instanceof f1) && ((f1) H).f() != null) {
                do {
                    Object j10 = j();
                    if (!(j10 instanceof w)) {
                        if (j10 != this) {
                            j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", j10);
                            pVar = (p) j10;
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = p.f10875j;
                            w wVar = (w) atomicReferenceFieldUpdater2.get(pVar);
                            if (wVar == null) {
                                wVar = new w(pVar);
                                atomicReferenceFieldUpdater2.lazySet(pVar, wVar);
                            }
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = p.f10873h;
                                if (!atomicReferenceFieldUpdater3.compareAndSet(this, j10, wVar)) {
                                    if (atomicReferenceFieldUpdater3.get(this) != j10) {
                                        z11 = false;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z11 = true;
                                    continue;
                                    break;
                                }
                            }
                        } else {
                            p pVar2 = (p) j10;
                            return;
                        }
                    } else {
                        p pVar3 = ((w) j10).f10887a;
                        return;
                    }
                } while (!z11);
                pVar.h();
                return;
            } else {
                return;
            }
        } while (!z10);
    }

    public final boolean c() {
        return true;
    }

    public final y1 f() {
        return null;
    }

    public l1 getParent() {
        return p();
    }

    public final u1 p() {
        u1 u1Var = this.f7835k;
        if (u1Var != null) {
            return u1Var;
        }
        j.l("job");
        throw null;
    }

    public final String toString() {
        return getClass().getSimpleName() + '@' + h0.r0(this) + "[job@" + h0.r0(p()) + ']';
    }
}
