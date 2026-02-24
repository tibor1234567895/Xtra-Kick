package ob;

import h3.u1;
import hb.h0;
import hb.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import pa.e;
import qa.a;

public final class d extends i implements a {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12374h = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "owner");
    private volatile Object owner;

    public d(boolean z10) {
        super(1, z10 ? 1 : 0);
        u1 u1Var;
        if (z10) {
            u1Var = null;
        } else {
            u1Var = e.f12375a;
        }
        this.owner = u1Var;
    }

    public final boolean d() {
        return Math.max(i.f12382g.get(this), 0) == 0;
    }

    public final Object e(e eVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = i.f12382g;
            int i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = this.f12383a;
            if (i11 > i12) {
                do {
                    i10 = atomicIntegerFieldUpdater.get(this);
                    if (i10 <= i12) {
                        break;
                    }
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i10, i12));
            } else {
                z10 = false;
                if (i11 <= 0) {
                    z11 = false;
                    break;
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 - 1)) {
                    z11 = true;
                    break;
                }
            }
        }
        if (z11) {
            f12374h.set(this, (Object) null);
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            z10 = true;
        } else if (!z12) {
            if (!z12) {
                throw new IllegalStateException("unexpected".toString());
            }
            throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
        }
        if (!z10) {
            l y02 = h0.y0(qa.d.b(eVar));
            try {
                a(new c(this, y02));
                Object u10 = y02.u();
                a aVar = a.COROUTINE_SUSPENDED;
                if (u10 == aVar) {
                    h0.m1(eVar);
                }
                if (u10 != aVar) {
                    u10 = v.f9814a;
                }
                if (u10 == aVar) {
                    return u10;
                }
            } catch (Throwable th) {
                y02.C();
                throw th;
            }
        }
        return v.f9814a;
    }

    public final void f(Object obj) {
        boolean z10;
        while (d()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12374h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            u1 u1Var = e.f12375a;
            if (obj2 != u1Var) {
                boolean z11 = true;
                if (obj2 == obj || obj == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, u1Var)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z11) {
                        c();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public final String toString() {
        return "Mutex@" + h0.r0(this) + "[isLocked=" + d() + ",owner=" + f12374h.get(this) + ']';
    }
}
