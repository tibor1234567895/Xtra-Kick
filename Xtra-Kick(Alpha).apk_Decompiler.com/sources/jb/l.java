package jb;

import androidx.fragment.app.y;
import h3.u1;
import hb.h0;
import hb.k2;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import mb.z;
import pa.k;
import xa.j;

public final class l extends z {

    /* renamed from: l  reason: collision with root package name */
    public final c f8925l;

    /* renamed from: m  reason: collision with root package name */
    public final AtomicReferenceArray f8926m = new AtomicReferenceArray(e.f8901b * 2);

    public l(long j10, l lVar, c cVar, int i10) {
        super(j10, lVar, i10);
        this.f8925l = cVar;
    }

    public final int f() {
        return e.f8901b;
    }

    public final void g(int i10, k kVar) {
        boolean z10;
        c cVar;
        u1 u1Var;
        y v10;
        y v11;
        int i11 = e.f8901b;
        if (i10 >= i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 -= i11;
        }
        Object obj = this.f8926m.get(i10 * 2);
        while (true) {
            Object k10 = k(i10);
            boolean z11 = k10 instanceof k2;
            cVar = this.f8925l;
            if (z11 || (k10 instanceof u)) {
                if (z10) {
                    u1Var = e.f8909j;
                } else {
                    u1Var = e.f8910k;
                }
                if (j(k10, i10, u1Var)) {
                    n(i10, (Object) null);
                    l(i10, !z10);
                    if (z10) {
                        j.c(cVar);
                        wa.l lVar = cVar.f8898i;
                        if (lVar != null && (v10 = h0.v(lVar, obj, (y) null)) != null) {
                            h0.K0(kVar, v10);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else if (k10 == e.f8909j || k10 == e.f8910k) {
                n(i10, (Object) null);
            } else if (!(k10 == e.f8906g || k10 == e.f8905f)) {
                if (k10 != e.f8908i && k10 != e.f8903d && k10 != e.f8911l) {
                    throw new IllegalStateException(("unexpected state: " + k10).toString());
                }
                return;
            }
        }
        n(i10, (Object) null);
        if (z10) {
            j.c(cVar);
            wa.l lVar2 = cVar.f8898i;
            if (lVar2 != null && (v11 = h0.v(lVar2, obj, (y) null)) != null) {
                h0.K0(kVar, v11);
            }
        }
    }

    public final boolean j(Object obj, int i10, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f8926m;
        int i11 = (i10 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i11, obj, obj2)) {
            if (atomicReferenceArray.get(i11) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i10) {
        return this.f8926m.get((i10 * 2) + 1);
    }

    public final void l(int i10, boolean z10) {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z11;
        long j11;
        if (z10) {
            c cVar = this.f8925l;
            j.c(cVar);
            long j12 = (this.f10890j * ((long) e.f8901b)) + ((long) i10);
            if (!cVar.w()) {
                do {
                } while (cVar.o() <= j12);
                int i11 = e.f8902c;
                int i12 = 0;
                while (true) {
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = c.f8891m;
                    if (i12 < i11) {
                        long o10 = cVar.o();
                        if (o10 == (atomicLongFieldUpdater2.get(cVar) & 4611686018427387903L) && o10 == cVar.o()) {
                            break;
                        }
                        i12++;
                    } else {
                        do {
                            j10 = atomicLongFieldUpdater2.get(cVar);
                        } while (!atomicLongFieldUpdater2.compareAndSet(cVar, j10, 4611686018427387904L + (j10 & 4611686018427387903L)));
                        while (true) {
                            long o11 = cVar.o();
                            atomicLongFieldUpdater = c.f8891m;
                            long j13 = atomicLongFieldUpdater.get(cVar);
                            long j14 = j13 & 4611686018427387903L;
                            if ((j13 & 4611686018427387904L) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (o11 == j14 && o11 == cVar.o()) {
                                break;
                            } else if (!z11) {
                                atomicLongFieldUpdater.compareAndSet(cVar, j13, j14 + 4611686018427387904L);
                            }
                        }
                        do {
                            j11 = atomicLongFieldUpdater.get(cVar);
                        } while (!atomicLongFieldUpdater.compareAndSet(cVar, j11, 0 + (j11 & 4611686018427387903L)));
                    }
                }
            }
        }
        h();
    }

    public final Object m(int i10) {
        Object obj = this.f8926m.get(i10 * 2);
        n(i10, (Object) null);
        return obj;
    }

    public final void n(int i10, Object obj) {
        this.f8926m.lazySet(i10 * 2, obj);
    }

    public final void o(int i10, u1 u1Var) {
        this.f8926m.set((i10 * 2) + 1, u1Var);
    }
}
