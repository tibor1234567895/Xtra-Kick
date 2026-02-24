package hb;

import androidx.fragment.app.y;
import h3.u1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import mb.i;
import mb.j;
import mb.z;
import pa.e;
import pa.k;
import qa.a;
import ra.d;

public class l extends o0 implements k, d, k2 {

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7818m;

    /* renamed from: n  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7819n;

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7820o;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _parentHandle;
    private volatile Object _state = b.f7777h;

    /* renamed from: k  reason: collision with root package name */
    public final e f7821k;

    /* renamed from: l  reason: collision with root package name */
    public final k f7822l;

    static {
        Class<l> cls = l.class;
        f7818m = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        f7819n = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f7820o = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public l(int i10, e eVar) {
        super(i10);
        this.f7821k = eVar;
        this.f7822l = eVar.getContext();
    }

    public static void A(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object E(a2 a2Var, Object obj, int i10, wa.l lVar) {
        if (obj instanceof w) {
            return obj;
        }
        boolean z10 = true;
        if (!(i10 == 1 || i10 == 2)) {
            z10 = false;
        }
        if (!z10) {
            return obj;
        }
        if (lVar == null && !(a2Var instanceof i)) {
            return obj;
        }
        return new v(obj, a2Var instanceof i ? (i) a2Var : null, lVar, (CancellationException) null, 16);
    }

    public String B() {
        return "CancellableContinuation";
    }

    public final void C() {
        i iVar;
        e eVar = this.f7821k;
        Throwable th = null;
        if (eVar instanceof i) {
            iVar = (i) eVar;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.f10859o;
                Object obj = atomicReferenceFieldUpdater.get(iVar);
                u1 u1Var = j.f10865b;
                boolean z10 = false;
                if (obj == u1Var) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(iVar, u1Var, this)) {
                            if (atomicReferenceFieldUpdater.get(iVar) != u1Var) {
                                continue;
                                break;
                            }
                        } else {
                            z10 = true;
                            continue;
                            break;
                        }
                    }
                    if (z10) {
                        break;
                    }
                } else if (obj instanceof Throwable) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(iVar, obj, (Object) null)) {
                            if (atomicReferenceFieldUpdater.get(iVar) != obj) {
                                break;
                            }
                        } else {
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        th = obj;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
            }
            if (th != null) {
                r();
                q(th);
            }
        }
    }

    public final void D(Object obj, int i10, wa.l lVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7819n;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            z10 = true;
            if (obj2 instanceof a2) {
                Object E = E((a2) obj2, obj, i10, lVar);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, E)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z10 = false;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                if (obj2 instanceof n) {
                    n nVar = (n) obj2;
                    nVar.getClass();
                    if (n.f7828c.compareAndSet(nVar, 0, 1)) {
                        if (lVar != null) {
                            o(lVar, nVar.f7875a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        } while (!z10);
        if (!z()) {
            r();
        }
        s(i10);
    }

    public final u1 F(Object obj, wa.l lVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7819n;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof a2) {
                Object E = E((a2) obj2, obj, this.f7831j, lVar);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, E)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z10 = false;
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
                boolean z11 = obj2 instanceof v;
                return null;
            }
        } while (!z10);
        if (!z()) {
            r();
        }
        return m.f7824a;
    }

    public final void a(z zVar, int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f7818m;
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!((i11 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        y(zVar);
    }

    public final void b(Object obj, CancellationException cancellationException) {
        boolean z10;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7819n;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof a2) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof w)) {
                boolean z11 = false;
                if (obj2 instanceof v) {
                    v vVar = (v) obj2;
                    if (vVar.f7865e != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        v a10 = v.a(vVar, (i) null, cancellationException, 15);
                        while (true) {
                            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a10)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    break;
                                }
                            } else {
                                z11 = true;
                                break;
                            }
                        }
                        if (z11) {
                            i iVar = vVar.f7862b;
                            if (iVar != null) {
                                l(iVar, cancellationException);
                            }
                            wa.l lVar = vVar.f7863c;
                            if (lVar != null) {
                                o(lVar, cancellationException);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    v vVar2 = new v(obj2, (i) null, (wa.l) null, cancellationException, 14);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, vVar2)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z11 = true;
                            break;
                        }
                    }
                    if (z11) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public final e c() {
        return this.f7821k;
    }

    public final void d(d0 d0Var, v vVar) {
        i iVar;
        d0 d0Var2;
        int i10;
        e eVar = this.f7821k;
        if (eVar instanceof i) {
            iVar = (i) eVar;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            d0Var2 = iVar.f10860k;
        } else {
            d0Var2 = null;
        }
        if (d0Var2 == d0Var) {
            i10 = 4;
        } else {
            i10 = this.f7831j;
        }
        D(vVar, i10, (wa.l) null);
    }

    public final Throwable e(Object obj) {
        Throwable e10 = super.e(obj);
        if (e10 != null) {
            return e10;
        }
        return null;
    }

    public final u1 f(Object obj, wa.l lVar) {
        return F(obj, lVar);
    }

    public final Object g(Object obj) {
        return obj instanceof v ? ((v) obj).f7861a : obj;
    }

    public final d getCallerFrame() {
        e eVar = this.f7821k;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final k getContext() {
        return this.f7822l;
    }

    public final void i(Object obj, wa.l lVar) {
        D(obj, this.f7831j, lVar);
    }

    public final void j(wa.l lVar) {
        i iVar;
        if (lVar instanceof i) {
            iVar = (i) lVar;
        } else {
            iVar = new h(2, lVar);
        }
        y(iVar);
    }

    public final Object k() {
        return f7819n.get(this);
    }

    public final void l(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            h0.K0(this.f7822l, new y("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final u1 m(Throwable th) {
        return F(new w(th, false), (wa.l) null);
    }

    public final void n(Object obj) {
        s(this.f7831j);
    }

    public final void o(wa.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            h0.K0(this.f7822l, new y("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void p(z zVar, Throwable th) {
        k kVar = this.f7822l;
        int i10 = f7818m.get(this) & 536870911;
        if (i10 != 536870911) {
            try {
                zVar.g(i10, kVar);
            } catch (Throwable th2) {
                h0.K0(kVar, new y("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    public final void q(Throwable th) {
        Object obj;
        boolean z10;
        boolean z11;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7819n;
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof a2) {
                z10 = true;
                if ((obj instanceof i) || (obj instanceof z)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                n nVar = new n(this, th, z11);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            z10 = false;
                            continue;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z10);
        a2 a2Var = (a2) obj;
        if (a2Var instanceof i) {
            l((i) obj, th);
        } else if (a2Var instanceof z) {
            p((z) obj, th);
        }
        if (!z()) {
            r();
        }
        s(this.f7831j);
    }

    public final void r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7820o;
        q0 q0Var = (q0) atomicReferenceFieldUpdater.get(this);
        if (q0Var != null) {
            q0Var.a();
            atomicReferenceFieldUpdater.set(this, z1.f7886h);
        }
    }

    public final void resumeWith(Object obj) {
        Throwable a10 = la.l.a(obj);
        if (a10 != null) {
            obj = new w(a10, false);
        }
        D(obj, this.f7831j, (wa.l) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(int r7) {
        /*
            r6 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f7818m
            int r1 = r0.get(r6)
            int r2 = r1 >> 29
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001c
            if (r2 != r4) goto L_0x0010
            r0 = 0
            goto L_0x002a
        L_0x0010:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x001c:
            r2 = 536870911(0x1fffffff, float:1.0842021E-19)
            r2 = r2 & r1
            r5 = 1073741824(0x40000000, float:2.0)
            int r2 = r2 + r5
            boolean r0 = r0.compareAndSet(r6, r1, r2)
            if (r0 == 0) goto L_0x0000
            r0 = 1
        L_0x002a:
            if (r0 == 0) goto L_0x002d
            return
        L_0x002d:
            r0 = 4
            if (r7 != r0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            pa.e r1 = r6.f7821k
            if (r0 != 0) goto L_0x008e
            boolean r2 = r1 instanceof mb.i
            if (r2 == 0) goto L_0x008e
            r2 = 2
            if (r7 == r4) goto L_0x0043
            if (r7 != r2) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r7 = 0
            goto L_0x0044
        L_0x0043:
            r7 = 1
        L_0x0044:
            int r5 = r6.f7831j
            if (r5 == r4) goto L_0x004a
            if (r5 != r2) goto L_0x004b
        L_0x004a:
            r3 = 1
        L_0x004b:
            if (r7 != r3) goto L_0x008e
            r7 = r1
            mb.i r7 = (mb.i) r7
            hb.d0 r7 = r7.f10860k
            pa.k r0 = r1.getContext()
            boolean r2 = r7.O0(r0)
            if (r2 == 0) goto L_0x0060
            r7.M0(r0, r6)
            goto L_0x0091
        L_0x0060:
            hb.f2 r7 = hb.f2.f7793a
            r7.getClass()
            hb.s0 r7 = hb.f2.a()
            boolean r0 = r7.T0()
            if (r0 == 0) goto L_0x0073
            r7.R0(r6)
            goto L_0x0091
        L_0x0073:
            r7.S0(r4)
            hb.h0.u1(r6, r1, r4)     // Catch:{ all -> 0x0080 }
        L_0x0079:
            boolean r0 = r7.V0()     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0079
            goto L_0x0085
        L_0x0080:
            r0 = move-exception
            r1 = 0
            r6.h(r0, r1)     // Catch:{ all -> 0x0089 }
        L_0x0085:
            r7.Q0(r4)
            goto L_0x0091
        L_0x0089:
            r0 = move-exception
            r7.Q0(r4)
            throw r0
        L_0x008e:
            hb.h0.u1(r6, r1, r0)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.l.s(int):void");
    }

    public Throwable t(u1 u1Var) {
        return u1Var.C();
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(B());
        sb2.append('(');
        sb2.append(h0.S1(this.f7821k));
        sb2.append("){");
        Object obj = f7819n.get(this);
        if (obj instanceof a2) {
            str = "Active";
        } else if (obj instanceof n) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb2.append(str);
        sb2.append("}@");
        sb2.append(h0.r0(this));
        return sb2.toString();
    }

    public final Object u() {
        boolean z10;
        boolean z11;
        boolean z12 = z();
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7818m;
            int i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            z10 = false;
            if (i11 == 0) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, (536870911 & i10) + 536870912)) {
                    z11 = true;
                    break;
                }
            } else if (i11 == 2) {
                z11 = false;
            } else {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z11) {
            if (((q0) f7820o.get(this)) == null) {
                x();
            }
            if (z12) {
                C();
            }
            return a.COROUTINE_SUSPENDED;
        }
        if (z12) {
            C();
        }
        Object obj = f7819n.get(this);
        if (!(obj instanceof w)) {
            int i12 = this.f7831j;
            if (i12 == 1 || i12 == 2) {
                z10 = true;
            }
            if (z10) {
                l1 l1Var = (l1) this.f7822l.N(l1.f7823b);
                if (l1Var != null && !l1Var.c()) {
                    CancellationException C = ((u1) l1Var).C();
                    b(obj, C);
                    throw C;
                }
            }
            return g(obj);
        }
        throw ((w) obj).f7875a;
    }

    public final void w() {
        q0 x10 = x();
        if (x10 != null && (!(f7819n.get(this) instanceof a2))) {
            x10.a();
            f7820o.set(this, z1.f7886h);
        }
    }

    public final q0 x() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        l1 l1Var = (l1) this.f7822l.N(l1.f7823b);
        if (l1Var == null) {
            return null;
        }
        q0 Q0 = h0.Q0(l1Var, true, new o(this), 2);
        do {
            atomicReferenceFieldUpdater = f7820o;
            if (atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, Q0) || atomicReferenceFieldUpdater.get(this) != null) {
                return Q0;
            }
            atomicReferenceFieldUpdater = f7820o;
            break;
        } while (atomicReferenceFieldUpdater.get(this) != null);
        return Q0;
    }

    public final void y(Object obj) {
        boolean z10;
        boolean z11;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7819n;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z12 = false;
            if (obj2 instanceof b) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    } else {
                        z12 = true;
                        break;
                    }
                }
                if (z12) {
                    return;
                }
            } else {
                if (obj2 instanceof i) {
                    z10 = true;
                } else {
                    z10 = obj2 instanceof z;
                }
                Throwable th = null;
                if (!z10) {
                    boolean z13 = obj2 instanceof w;
                    if (z13) {
                        w wVar = (w) obj2;
                        wVar.getClass();
                        if (!w.f7874b.compareAndSet(wVar, 0, 1)) {
                            A(obj, obj2);
                            throw null;
                        } else if (obj2 instanceof n) {
                            if (!z13) {
                                wVar = null;
                            }
                            if (wVar != null) {
                                th = wVar.f7875a;
                            }
                            if (obj instanceof i) {
                                l((i) obj, th);
                                return;
                            }
                            xa.j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>", obj);
                            p((z) obj, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj2 instanceof v) {
                        v vVar = (v) obj2;
                        if (vVar.f7862b != null) {
                            A(obj, obj2);
                            throw null;
                        } else if (!(obj instanceof z)) {
                            xa.j.d("null cannot be cast to non-null type kotlinx.coroutines.CancelHandler", obj);
                            i iVar = (i) obj;
                            Throwable th2 = vVar.f7865e;
                            if (th2 != null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                l(iVar, th2);
                                return;
                            }
                            v a10 = v.a(vVar, iVar, (CancellationException) null, 29);
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a10)) {
                                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                        break;
                                    }
                                } else {
                                    z12 = true;
                                    break;
                                }
                            }
                            if (z12) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!(obj instanceof z)) {
                        xa.j.d("null cannot be cast to non-null type kotlinx.coroutines.CancelHandler", obj);
                        v vVar2 = new v(obj2, (i) obj, (wa.l) null, (CancellationException) null, 28);
                        while (true) {
                            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, vVar2)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    break;
                                }
                            } else {
                                z12 = true;
                                break;
                            }
                        }
                        if (z12) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    A(obj, obj2);
                    throw null;
                }
            }
        }
    }

    public final boolean z() {
        boolean z10;
        boolean z11;
        if (this.f7831j == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            e eVar = this.f7821k;
            xa.j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", eVar);
            if (i.f10859o.get((i) eVar) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }
}
