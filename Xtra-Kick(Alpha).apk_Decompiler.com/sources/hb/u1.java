package hb;

import androidx.fragment.app.y;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.a;
import mb.p;
import mb.v;
import pa.h;
import pa.i;
import pa.k;
import wa.l;
import xa.j;

public class u1 implements l1, r, b2 {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7859h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7860i;
    private volatile Object _parentHandle;
    private volatile Object _state;

    static {
        Class<u1> cls = u1.class;
        Class<Object> cls2 = Object.class;
        f7859h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f7860i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public u1(boolean z10) {
        r0 r0Var;
        if (z10) {
            r0Var = v1.f7873g;
        } else {
            r0Var = v1.f7872f;
        }
        this._state = r0Var;
    }

    public static q S(p pVar) {
        while (pVar.n()) {
            pVar = pVar.m();
        }
        while (true) {
            pVar = pVar.l();
            if (!pVar.n()) {
                if (pVar instanceof q) {
                    return (q) pVar;
                }
                if (pVar instanceof y1) {
                    return null;
                }
            }
        }
    }

    public static String Z(Object obj) {
        if (!(obj instanceof s1)) {
            return obj instanceof f1 ? ((f1) obj).c() ? "Active" : "New" : obj instanceof w ? "Cancelled" : "Completed";
        }
        s1 s1Var = (s1) obj;
        if (s1Var.d()) {
            return "Cancelling";
        }
        if (s1Var.e()) {
            return "Completing";
        }
    }

    public final Throwable A(Object obj) {
        Throwable th;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        u1 u1Var = (u1) ((b2) obj);
        Object H = u1Var.H();
        CancellationException cancellationException = null;
        if (H instanceof s1) {
            th = ((s1) H).b();
        } else if (H instanceof w) {
            th = ((w) H).f7875a;
        } else if (!(H instanceof f1)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + H).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException == null) {
            cancellationException = new m1("Parent job is ".concat(Z(H)), th, u1Var);
        }
        return cancellationException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb A[LOOP:2: B:56:0x00cb->B:59:0x00d6, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object B(hb.s1 r9, java.lang.Object r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof hb.w
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r10
            hb.w r0 = (hb.w) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 == 0) goto L_0x000f
            java.lang.Throwable r0 = r0.f7875a
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            monitor-enter(r9)
            r9.d()     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r2 = r9.g(r0)     // Catch:{ all -> 0x00dc }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00dc }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0031
            boolean r3 = r9.d()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x0053
            hb.m1 r3 = new hb.m1     // Catch:{ all -> 0x00dc }
            java.lang.String r6 = r8.u()     // Catch:{ all -> 0x00dc }
            r3.<init>(r6, r1, r8)     // Catch:{ all -> 0x00dc }
            r1 = r3
            goto L_0x0053
        L_0x0031:
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x00dc }
        L_0x0035:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x0048
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x00dc }
            r7 = r6
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00dc }
            boolean r7 = r7 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00dc }
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x0035
            r1 = r6
        L_0x0048:
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x004d
            goto L_0x0053
        L_0x004d:
            java.lang.Object r1 = r2.get(r5)     // Catch:{ all -> 0x00dc }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00dc }
        L_0x0053:
            if (r1 == 0) goto L_0x008b
            int r3 = r2.size()     // Catch:{ all -> 0x00dc }
            if (r3 > r4) goto L_0x005c
            goto L_0x008b
        L_0x005c:
            int r3 = r2.size()     // Catch:{ all -> 0x00dc }
            java.util.IdentityHashMap r6 = new java.util.IdentityHashMap     // Catch:{ all -> 0x00dc }
            r6.<init>(r3)     // Catch:{ all -> 0x00dc }
            java.util.Set r3 = java.util.Collections.newSetFromMap(r6)     // Catch:{ all -> 0x00dc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00dc }
        L_0x006d:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x008b
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x00dc }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00dc }
            if (r6 == r1) goto L_0x006d
            if (r6 == r1) goto L_0x006d
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00dc }
            if (r7 != 0) goto L_0x006d
            boolean r7 = r3.add(r6)     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x006d
            la.a.a(r1, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x006d
        L_0x008b:
            monitor-exit(r9)
            if (r1 != 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            if (r1 != r0) goto L_0x0092
            goto L_0x0097
        L_0x0092:
            hb.w r10 = new hb.w
            r10.<init>(r1, r5)
        L_0x0097:
            if (r1 == 0) goto L_0x00b8
            boolean r0 = r8.t(r1)
            if (r0 != 0) goto L_0x00a8
            boolean r0 = r8.I(r1)
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r0 = 0
            goto L_0x00a9
        L_0x00a8:
            r0 = 1
        L_0x00a9:
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally"
            xa.j.d(r0, r10)
            r0 = r10
            hb.w r0 = (hb.w) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = hb.w.f7874b
            r1.compareAndSet(r0, r5, r4)
        L_0x00b8:
            r8.U(r10)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7859h
            boolean r1 = r10 instanceof hb.f1
            if (r1 == 0) goto L_0x00ca
            hb.g1 r1 = new hb.g1
            r2 = r10
            hb.f1 r2 = (hb.f1) r2
            r1.<init>(r2)
            goto L_0x00cb
        L_0x00ca:
            r1 = r10
        L_0x00cb:
            boolean r2 = r0.compareAndSet(r8, r9, r1)
            if (r2 == 0) goto L_0x00d2
            goto L_0x00d8
        L_0x00d2:
            java.lang.Object r2 = r0.get(r8)
            if (r2 == r9) goto L_0x00cb
        L_0x00d8:
            r8.y(r9, r10)
            return r10
        L_0x00dc:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.B(hb.s1, java.lang.Object):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.concurrent.CancellationException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.CancellationException C() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.H()
            boolean r1 = r0 instanceof hb.s1
            r2 = 0
            java.lang.String r3 = "Job is still new or active: "
            if (r1 == 0) goto L_0x004c
            hb.s1 r0 = (hb.s1) r0
            java.lang.Throwable r0 = r0.b()
            if (r0 == 0) goto L_0x0036
            java.lang.Class r1 = r4.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r3 = " is cancelling"
            java.lang.String r1 = r1.concat(r3)
            boolean r3 = r0 instanceof java.util.concurrent.CancellationException
            if (r3 == 0) goto L_0x0028
            r2 = r0
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L_0x0028:
            if (r2 != 0) goto L_0x0080
            hb.m1 r2 = new hb.m1
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = r4.u()
        L_0x0032:
            r2.<init>(r1, r0, r4)
            goto L_0x0080
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x004c:
            boolean r1 = r0 instanceof hb.f1
            if (r1 != 0) goto L_0x0081
            boolean r1 = r0 instanceof hb.w
            if (r1 == 0) goto L_0x006c
            hb.w r0 = (hb.w) r0
            java.lang.Throwable r0 = r0.f7875a
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException
            if (r1 == 0) goto L_0x005f
            r2 = r0
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L_0x005f:
            if (r2 != 0) goto L_0x0080
            hb.m1 r1 = new hb.m1
            java.lang.String r2 = r4.u()
            r1.<init>(r2, r0, r4)
            r2 = r1
            goto L_0x0080
        L_0x006c:
            hb.m1 r0 = new hb.m1
            java.lang.Class r1 = r4.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r3 = " has completed normally"
            java.lang.String r1 = r1.concat(r3)
            r0.<init>(r1, r2, r4)
            r2 = r0
        L_0x0080:
            return r2
        L_0x0081:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.C():java.util.concurrent.CancellationException");
    }

    public final Object D() {
        Object H = H();
        if (!(!(H instanceof f1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(H instanceof w)) {
            return v1.a(H);
        } else {
            throw ((w) H).f7875a;
        }
    }

    public boolean E() {
        return true;
    }

    public boolean F() {
        return this instanceof t;
    }

    public final y1 G(f1 f1Var) {
        y1 f10 = f1Var.f();
        if (f10 != null) {
            return f10;
        }
        if (f1Var instanceof r0) {
            return new y1();
        }
        if (f1Var instanceof p1) {
            W((p1) f1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + f1Var).toString());
    }

    public final Object H() {
        while (true) {
            Object obj = f7859h.get(this);
            if (!(obj instanceof v)) {
                return obj;
            }
            ((v) obj).a(this);
        }
    }

    public boolean I(Throwable th) {
        return false;
    }

    public final k I0(k kVar) {
        return h0.j1(this, kVar);
    }

    public void J(y yVar) {
        throw yVar;
    }

    public final void K(l1 l1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7860i;
        if (l1Var == null) {
            atomicReferenceFieldUpdater.set(this, z1.f7886h);
            return;
        }
        u1 u1Var = (u1) l1Var;
        u1Var.X();
        q0 Q0 = h0.Q0(u1Var, true, new q(this), 2);
        j.d("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle", Q0);
        p pVar = (p) Q0;
        atomicReferenceFieldUpdater.set(this, pVar);
        if (!(H() instanceof f1)) {
            pVar.a();
            atomicReferenceFieldUpdater.set(this, z1.f7886h);
        }
    }

    public final q0 L(l lVar) {
        return M(false, true, lVar);
    }

    /* JADX WARNING: type inference failed for: r5v9, types: [hb.e1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final hb.q0 M(boolean r9, boolean r10, wa.l r11) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            if (r9 == 0) goto L_0x0015
            boolean r2 = r11 instanceof hb.n1
            if (r2 == 0) goto L_0x000c
            r2 = r11
            hb.n1 r2 = (hb.n1) r2
            goto L_0x000d
        L_0x000c:
            r2 = r1
        L_0x000d:
            if (r2 != 0) goto L_0x0026
            hb.i1 r2 = new hb.i1
            r2.<init>(r11)
            goto L_0x0026
        L_0x0015:
            boolean r2 = r11 instanceof hb.p1
            if (r2 == 0) goto L_0x001d
            r2 = r11
            hb.p1 r2 = (hb.p1) r2
            goto L_0x001e
        L_0x001d:
            r2 = r1
        L_0x001e:
            if (r2 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            hb.j1 r2 = new hb.j1
            r2.<init>(r0, r11)
        L_0x0026:
            r2.f7835k = r8
        L_0x0028:
            java.lang.Object r3 = r8.H()
            boolean r4 = r3 instanceof hb.r0
            if (r4 == 0) goto L_0x006b
            r4 = r3
            hb.r0 r4 = (hb.r0) r4
            boolean r5 = r4.f7838h
            if (r5 == 0) goto L_0x004b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f7859h
        L_0x0039:
            boolean r4 = r5.compareAndSet(r8, r3, r2)
            if (r4 == 0) goto L_0x0041
            r3 = 1
            goto L_0x0048
        L_0x0041:
            java.lang.Object r4 = r5.get(r8)
            if (r4 == r3) goto L_0x0039
            r3 = 0
        L_0x0048:
            if (r3 == 0) goto L_0x0028
            return r2
        L_0x004b:
            hb.y1 r3 = new hb.y1
            r3.<init>()
            boolean r5 = r4.f7838h
            if (r5 == 0) goto L_0x0055
            goto L_0x005b
        L_0x0055:
            hb.e1 r5 = new hb.e1
            r5.<init>(r3)
            r3 = r5
        L_0x005b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f7859h
            boolean r6 = r5.compareAndSet(r8, r4, r3)
            if (r6 == 0) goto L_0x0064
            goto L_0x0028
        L_0x0064:
            java.lang.Object r5 = r5.get(r8)
            if (r5 == r4) goto L_0x005b
            goto L_0x0028
        L_0x006b:
            boolean r4 = r3 instanceof hb.f1
            if (r4 == 0) goto L_0x00c7
            r4 = r3
            hb.f1 r4 = (hb.f1) r4
            hb.y1 r4 = r4.f()
            if (r4 != 0) goto L_0x0083
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode"
            xa.j.d(r4, r3)
            hb.p1 r3 = (hb.p1) r3
            r8.W(r3)
            goto L_0x0028
        L_0x0083:
            hb.z1 r5 = hb.z1.f7886h
            if (r9 == 0) goto L_0x00b7
            boolean r6 = r3 instanceof hb.s1
            if (r6 == 0) goto L_0x00b7
            monitor-enter(r3)
            r6 = r3
            hb.s1 r6 = (hb.s1) r6     // Catch:{ all -> 0x00b4 }
            java.lang.Throwable r6 = r6.b()     // Catch:{ all -> 0x00b4 }
            if (r6 == 0) goto L_0x00a2
            boolean r7 = r11 instanceof hb.q     // Catch:{ all -> 0x00b4 }
            if (r7 == 0) goto L_0x00b0
            r7 = r3
            hb.s1 r7 = (hb.s1) r7     // Catch:{ all -> 0x00b4 }
            boolean r7 = r7.e()     // Catch:{ all -> 0x00b4 }
            if (r7 != 0) goto L_0x00b0
        L_0x00a2:
            boolean r5 = r8.o(r3, r4, r2)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x00ab
            monitor-exit(r3)
            goto L_0x0028
        L_0x00ab:
            if (r6 != 0) goto L_0x00af
            monitor-exit(r3)
            return r2
        L_0x00af:
            r5 = r2
        L_0x00b0:
            la.v r7 = la.v.f9814a     // Catch:{ all -> 0x00b4 }
            monitor-exit(r3)
            goto L_0x00b8
        L_0x00b4:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        L_0x00b7:
            r6 = r1
        L_0x00b8:
            if (r6 == 0) goto L_0x00c0
            if (r10 == 0) goto L_0x00bf
            r11.invoke(r6)
        L_0x00bf:
            return r5
        L_0x00c0:
            boolean r3 = r8.o(r3, r4, r2)
            if (r3 == 0) goto L_0x0028
            return r2
        L_0x00c7:
            if (r10 == 0) goto L_0x00d8
            boolean r9 = r3 instanceof hb.w
            if (r9 == 0) goto L_0x00d0
            hb.w r3 = (hb.w) r3
            goto L_0x00d1
        L_0x00d0:
            r3 = r1
        L_0x00d1:
            if (r3 == 0) goto L_0x00d5
            java.lang.Throwable r1 = r3.f7875a
        L_0x00d5:
            r11.invoke(r1)
        L_0x00d8:
            hb.z1 r9 = hb.z1.f7886h
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.M(boolean, boolean, wa.l):hb.q0");
    }

    public final h N(i iVar) {
        return h0.Z(this, iVar);
    }

    public boolean O() {
        return this instanceof f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object P(ra.c r5) {
        /*
            r4 = this;
        L_0x0000:
            java.lang.Object r0 = r4.H()
            boolean r1 = r0 instanceof hb.f1
            r2 = 1
            if (r1 != 0) goto L_0x000b
            r0 = 0
            goto L_0x0012
        L_0x000b:
            int r0 = r4.Y(r0)
            if (r0 < 0) goto L_0x0000
            r0 = 1
        L_0x0012:
            if (r0 != 0) goto L_0x001e
            pa.k r5 = r5.getContext()
            hb.h0.T(r5)
            la.v r5 = la.v.f9814a
            return r5
        L_0x001e:
            hb.l r0 = new hb.l
            pa.e r1 = qa.d.b(r5)
            r0.<init>(r2, r1)
            r0.w()
            hb.j1 r1 = new hb.j1
            r3 = 2
            r1.<init>(r3, r0)
            hb.q0 r1 = r4.L(r1)
            hb.h r3 = new hb.h
            r3.<init>(r2, r1)
            r0.j(r3)
            java.lang.Object r0 = r0.u()
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x0047
            hb.h0.m1(r5)
        L_0x0047:
            if (r0 != r1) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            la.v r0 = la.v.f9814a
        L_0x004c:
            if (r0 != r1) goto L_0x004f
            return r0
        L_0x004f:
            la.v r5 = la.v.f9814a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.P(ra.c):java.lang.Object");
    }

    public final Object Q(Object obj) {
        Object a02;
        w wVar;
        do {
            a02 = a0(H(), obj);
            if (a02 == v1.f7867a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof w) {
                    wVar = (w) obj;
                } else {
                    wVar = null;
                }
                if (wVar != null) {
                    th = wVar.f7875a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (a02 == v1.f7869c);
        return a02;
    }

    public String R() {
        return getClass().getSimpleName();
    }

    public final void T(y1 y1Var, Throwable th) {
        Object j10 = y1Var.j();
        j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", j10);
        y yVar = null;
        for (p pVar = (p) j10; !j.a(pVar, y1Var); pVar = pVar.l()) {
            if (pVar instanceof n1) {
                p1 p1Var = (p1) pVar;
                try {
                    p1Var.o(th);
                } catch (Throwable th2) {
                    if (yVar != null) {
                        a.a(yVar, th2);
                    } else {
                        yVar = new y("Exception in completion handler " + p1Var + " for " + this, th2);
                        la.v vVar = la.v.f9814a;
                    }
                }
            }
        }
        if (yVar != null) {
            J(yVar);
        }
        t(th);
    }

    public void U(Object obj) {
    }

    public void V() {
    }

    public final void W(p1 p1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z10;
        y1 y1Var = new y1();
        p1Var.getClass();
        p.f10874i.lazySet(y1Var, p1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = p.f10873h;
        atomicReferenceFieldUpdater2.lazySet(y1Var, p1Var);
        while (true) {
            if (p1Var.j() == p1Var) {
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(p1Var, p1Var, y1Var)) {
                        if (atomicReferenceFieldUpdater2.get(p1Var) != p1Var) {
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
                if (z10) {
                    y1Var.i(p1Var);
                    break;
                }
            } else {
                break;
            }
        }
        p l10 = p1Var.l();
        do {
            atomicReferenceFieldUpdater = f7859h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, p1Var, l10) || atomicReferenceFieldUpdater.get(this) != p1Var) {
            }
            atomicReferenceFieldUpdater = f7859h;
            return;
        } while (atomicReferenceFieldUpdater.get(this) != p1Var);
    }

    public final boolean X() {
        int Y;
        do {
            Y = Y(H());
            if (Y == 0) {
                return false;
            }
        } while (Y != 1);
        return true;
    }

    public final int Y(Object obj) {
        boolean z10 = obj instanceof r0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7859h;
        boolean z11 = false;
        if (z10) {
            if (((r0) obj).f7838h) {
                return 0;
            }
            r0 r0Var = v1.f7873g;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, r0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return -1;
            }
            V();
            return 1;
        } else if (!(obj instanceof e1)) {
            return 0;
        } else {
            y1 y1Var = ((e1) obj).f7790h;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, y1Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return -1;
            }
            V();
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c1, code lost:
        if (r6 == null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c3, code lost:
        T(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c8, code lost:
        if ((r9 instanceof hb.q) == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ca, code lost:
        r0 = (hb.q) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ce, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00cf, code lost:
        if (r0 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d1, code lost:
        r9 = r9.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d5, code lost:
        if (r9 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d7, code lost:
        r4 = S(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00dc, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00dd, code lost:
        if (r4 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00e3, code lost:
        if (b0(r3, r4, r10) == false) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return B(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return hb.v1.f7868b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a0(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof hb.f1
            if (r0 != 0) goto L_0x0007
            h3.u1 r9 = hb.v1.f7867a
            return r9
        L_0x0007:
            boolean r0 = r9 instanceof hb.r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0011
            boolean r0 = r9 instanceof hb.p1
            if (r0 == 0) goto L_0x004e
        L_0x0011:
            boolean r0 = r9 instanceof hb.q
            if (r0 != 0) goto L_0x004e
            boolean r0 = r10 instanceof hb.w
            if (r0 != 0) goto L_0x004e
            r0 = r9
            hb.f1 r0 = (hb.f1) r0
            h3.u1 r9 = hb.v1.f7867a
            boolean r9 = r10 instanceof hb.f1
            if (r9 == 0) goto L_0x002c
            hb.g1 r9 = new hb.g1
            r3 = r10
            hb.f1 r3 = (hb.f1) r3
            r9.<init>(r3)
            r3 = r9
            goto L_0x002d
        L_0x002c:
            r3 = r10
        L_0x002d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = f7859h
            boolean r4 = r9.compareAndSet(r8, r0, r3)
            if (r4 == 0) goto L_0x0037
            r9 = 1
            goto L_0x003e
        L_0x0037:
            java.lang.Object r9 = r9.get(r8)
            if (r9 == r0) goto L_0x002d
            r9 = 0
        L_0x003e:
            if (r9 != 0) goto L_0x0041
            goto L_0x0048
        L_0x0041:
            r8.U(r10)
            r8.y(r0, r10)
            r1 = 1
        L_0x0048:
            if (r1 == 0) goto L_0x004b
            return r10
        L_0x004b:
            h3.u1 r9 = hb.v1.f7869c
            return r9
        L_0x004e:
            hb.f1 r9 = (hb.f1) r9
            hb.y1 r0 = r8.G(r9)
            if (r0 != 0) goto L_0x005a
            h3.u1 r9 = hb.v1.f7869c
            goto L_0x00ec
        L_0x005a:
            boolean r3 = r9 instanceof hb.s1
            r4 = 0
            if (r3 == 0) goto L_0x0063
            r3 = r9
            hb.s1 r3 = (hb.s1) r3
            goto L_0x0064
        L_0x0063:
            r3 = r4
        L_0x0064:
            if (r3 != 0) goto L_0x006b
            hb.s1 r3 = new hb.s1
            r3.<init>(r0, r4)
        L_0x006b:
            xa.u r5 = new xa.u
            r5.<init>()
            monitor-enter(r3)
            boolean r6 = r3.e()     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x007a
            h3.u1 r9 = hb.v1.f7867a     // Catch:{ all -> 0x00ed }
            goto L_0x0095
        L_0x007a:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = hb.s1.f7847i     // Catch:{ all -> 0x00ed }
            r6.set(r3, r2)     // Catch:{ all -> 0x00ed }
            if (r3 == r9) goto L_0x0097
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f7859h     // Catch:{ all -> 0x00ed }
        L_0x0083:
            boolean r7 = r6.compareAndSet(r8, r9, r3)     // Catch:{ all -> 0x00ed }
            if (r7 == 0) goto L_0x008b
            r1 = 1
            goto L_0x0091
        L_0x008b:
            java.lang.Object r7 = r6.get(r8)     // Catch:{ all -> 0x00ed }
            if (r7 == r9) goto L_0x0083
        L_0x0091:
            if (r1 != 0) goto L_0x0097
            h3.u1 r9 = hb.v1.f7869c     // Catch:{ all -> 0x00ed }
        L_0x0095:
            monitor-exit(r3)
            goto L_0x00ec
        L_0x0097:
            boolean r1 = r3.d()     // Catch:{ all -> 0x00ed }
            boolean r6 = r10 instanceof hb.w     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x00a3
            r6 = r10
            hb.w r6 = (hb.w) r6     // Catch:{ all -> 0x00ed }
            goto L_0x00a4
        L_0x00a3:
            r6 = r4
        L_0x00a4:
            if (r6 == 0) goto L_0x00ab
            java.lang.Throwable r6 = r6.f7875a     // Catch:{ all -> 0x00ed }
            r3.a(r6)     // Catch:{ all -> 0x00ed }
        L_0x00ab:
            java.lang.Throwable r6 = r3.b()     // Catch:{ all -> 0x00ed }
            r1 = r1 ^ r2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00ed }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ed }
            if (r1 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r6 = r4
        L_0x00bc:
            r5.f16818h = r6     // Catch:{ all -> 0x00ed }
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x00ed }
            monitor-exit(r3)
            if (r6 == 0) goto L_0x00c6
            r8.T(r0, r6)
        L_0x00c6:
            boolean r0 = r9 instanceof hb.q
            if (r0 == 0) goto L_0x00ce
            r0 = r9
            hb.q r0 = (hb.q) r0
            goto L_0x00cf
        L_0x00ce:
            r0 = r4
        L_0x00cf:
            if (r0 != 0) goto L_0x00dc
            hb.y1 r9 = r9.f()
            if (r9 == 0) goto L_0x00dd
            hb.q r4 = S(r9)
            goto L_0x00dd
        L_0x00dc:
            r4 = r0
        L_0x00dd:
            if (r4 == 0) goto L_0x00e8
            boolean r9 = r8.b0(r3, r4, r10)
            if (r9 == 0) goto L_0x00e8
            h3.u1 r9 = hb.v1.f7868b
            goto L_0x00ec
        L_0x00e8:
            java.lang.Object r9 = r8.B(r3, r10)
        L_0x00ec:
            return r9
        L_0x00ed:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.a0(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final boolean b0(s1 s1Var, q qVar, Object obj) {
        do {
            if (h0.Q0(qVar.f7836l, false, new r1(this, s1Var, qVar, obj), 1) != z1.f7886h) {
                return true;
            }
            qVar = S(qVar);
        } while (qVar != null);
        return false;
    }

    public boolean c() {
        Object H = H();
        return (H instanceof f1) && ((f1) H).c();
    }

    public void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new m1(u(), (Throwable) null, this);
        }
        s(cancellationException);
    }

    public final i getKey() {
        return l1.f7823b;
    }

    public final Object j0(Object obj, wa.p pVar) {
        j.f("operation", pVar);
        return pVar.g(obj, this);
    }

    public Object k() {
        return D();
    }

    public final boolean o(Object obj, y1 y1Var, p1 p1Var) {
        boolean z10;
        char c10;
        t1 t1Var = new t1(p1Var, this, obj);
        do {
            p m10 = y1Var.m();
            p.f10874i.lazySet(p1Var, m10);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p.f10873h;
            atomicReferenceFieldUpdater.lazySet(p1Var, y1Var);
            t1Var.f7854c = y1Var;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(m10, y1Var, t1Var)) {
                    if (atomicReferenceFieldUpdater.get(m10) != y1Var) {
                        z10 = false;
                        break;
                    }
                } else {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                c10 = 0;
            } else if (t1Var.a(m10) == null) {
                c10 = 1;
            } else {
                c10 = 2;
            }
            if (c10 == 1) {
                return true;
            }
        } while (c10 != 2);
        return false;
    }

    public void p(Object obj) {
    }

    public void q(Object obj) {
        p(obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c6, code lost:
        r10 = hb.v1.f7867a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f6, code lost:
        r0 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00c6 A[EDGE_INSN: B:85:0x00c6->B:63:0x00c6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x003f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean r(java.lang.Object r10) {
        /*
            r9 = this;
            h3.u1 r0 = hb.v1.f7867a
            boolean r1 = r9.F()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0039
        L_0x000a:
            java.lang.Object r0 = r9.H()
            boolean r1 = r0 instanceof hb.f1
            if (r1 == 0) goto L_0x0032
            boolean r1 = r0 instanceof hb.s1
            if (r1 == 0) goto L_0x0020
            r1 = r0
            hb.s1 r1 = (hb.s1) r1
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0020
            goto L_0x0032
        L_0x0020:
            hb.w r1 = new hb.w
            java.lang.Throwable r4 = r9.A(r10)
            r1.<init>(r4, r2)
            java.lang.Object r0 = r9.a0(r0, r1)
            h3.u1 r1 = hb.v1.f7869c
            if (r0 == r1) goto L_0x000a
            goto L_0x0034
        L_0x0032:
            h3.u1 r0 = hb.v1.f7867a
        L_0x0034:
            h3.u1 r1 = hb.v1.f7868b
            if (r0 != r1) goto L_0x0039
            return r3
        L_0x0039:
            h3.u1 r1 = hb.v1.f7867a
            if (r0 != r1) goto L_0x00f7
            r0 = 0
            r1 = r0
        L_0x003f:
            java.lang.Object r4 = r9.H()
            boolean r5 = r4 instanceof hb.s1
            if (r5 == 0) goto L_0x008c
            monitor-enter(r4)
            r5 = r4
            hb.s1 r5 = (hb.s1) r5     // Catch:{ all -> 0x0089 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = hb.s1.f7849k     // Catch:{ all -> 0x0089 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x0089 }
            h3.u1 r6 = hb.v1.f7871e     // Catch:{ all -> 0x0089 }
            if (r5 != r6) goto L_0x0057
            r5 = 1
            goto L_0x0058
        L_0x0057:
            r5 = 0
        L_0x0058:
            if (r5 == 0) goto L_0x005f
            h3.u1 r10 = hb.v1.f7870d     // Catch:{ all -> 0x0089 }
            monitor-exit(r4)
            goto L_0x00f6
        L_0x005f:
            r5 = r4
            hb.s1 r5 = (hb.s1) r5     // Catch:{ all -> 0x0089 }
            boolean r5 = r5.d()     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x006c
            java.lang.Throwable r1 = r9.A(r10)     // Catch:{ all -> 0x0089 }
        L_0x006c:
            r10 = r4
            hb.s1 r10 = (hb.s1) r10     // Catch:{ all -> 0x0089 }
            r10.a(r1)     // Catch:{ all -> 0x0089 }
            r10 = r4
            hb.s1 r10 = (hb.s1) r10     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r10 = r10.b()     // Catch:{ all -> 0x0089 }
            r1 = r5 ^ 1
            if (r1 == 0) goto L_0x007e
            r0 = r10
        L_0x007e:
            monitor-exit(r4)
            if (r0 == 0) goto L_0x00c6
            hb.s1 r4 = (hb.s1) r4
            hb.y1 r10 = r4.f7850h
            r9.T(r10, r0)
            goto L_0x00c6
        L_0x0089:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L_0x008c:
            boolean r5 = r4 instanceof hb.f1
            if (r5 == 0) goto L_0x00f4
            if (r1 != 0) goto L_0x0096
            java.lang.Throwable r1 = r9.A(r10)
        L_0x0096:
            r5 = r4
            hb.f1 r5 = (hb.f1) r5
            boolean r6 = r5.c()
            if (r6 == 0) goto L_0x00c9
            hb.y1 r6 = r9.G(r5)
            if (r6 != 0) goto L_0x00a6
            goto L_0x00be
        L_0x00a6:
            hb.s1 r7 = new hb.s1
            r7.<init>(r6, r1)
        L_0x00ab:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f7859h
            boolean r8 = r4.compareAndSet(r9, r5, r7)
            if (r8 == 0) goto L_0x00b5
            r4 = 1
            goto L_0x00bc
        L_0x00b5:
            java.lang.Object r4 = r4.get(r9)
            if (r4 == r5) goto L_0x00ab
            r4 = 0
        L_0x00bc:
            if (r4 != 0) goto L_0x00c0
        L_0x00be:
            r4 = 0
            goto L_0x00c4
        L_0x00c0:
            r9.T(r6, r1)
            r4 = 1
        L_0x00c4:
            if (r4 == 0) goto L_0x003f
        L_0x00c6:
            h3.u1 r10 = hb.v1.f7867a
            goto L_0x00f6
        L_0x00c9:
            hb.w r5 = new hb.w
            r5.<init>(r1, r2)
            java.lang.Object r5 = r9.a0(r4, r5)
            h3.u1 r6 = hb.v1.f7867a
            if (r5 == r6) goto L_0x00dc
            h3.u1 r4 = hb.v1.f7869c
            if (r5 == r4) goto L_0x003f
            r0 = r5
            goto L_0x00f7
        L_0x00dc:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot happen in "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00f4:
            h3.u1 r10 = hb.v1.f7870d
        L_0x00f6:
            r0 = r10
        L_0x00f7:
            h3.u1 r10 = hb.v1.f7867a
            if (r0 != r10) goto L_0x00fc
            goto L_0x0109
        L_0x00fc:
            h3.u1 r10 = hb.v1.f7868b
            if (r0 != r10) goto L_0x0101
            goto L_0x0109
        L_0x0101:
            h3.u1 r10 = hb.v1.f7870d
            if (r0 != r10) goto L_0x0106
            goto L_0x010a
        L_0x0106:
            r9.p(r0)
        L_0x0109:
            r2 = 1
        L_0x010a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u1.r(java.lang.Object):boolean");
    }

    public void s(CancellationException cancellationException) {
        r(cancellationException);
    }

    public final boolean t(Throwable th) {
        if (O()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        p pVar = (p) f7860i.get(this);
        if (pVar == null || pVar == z1.f7886h) {
            return z10;
        }
        if (pVar.d(th) || z10) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(R() + '{' + Z(H()) + '}');
        sb2.append('@');
        sb2.append(h0.r0(this));
        return sb2.toString();
    }

    public String u() {
        return "Job was cancelled";
    }

    public final k w(i iVar) {
        return h0.d1(this, iVar);
    }

    public boolean x(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return r(th) && E();
    }

    public final void y(f1 f1Var, Object obj) {
        w wVar;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7860i;
        p pVar = (p) atomicReferenceFieldUpdater.get(this);
        if (pVar != null) {
            pVar.a();
            atomicReferenceFieldUpdater.set(this, z1.f7886h);
        }
        y yVar = null;
        if (obj instanceof w) {
            wVar = (w) obj;
        } else {
            wVar = null;
        }
        if (wVar != null) {
            th = wVar.f7875a;
        } else {
            th = null;
        }
        if (f1Var instanceof p1) {
            try {
                ((p1) f1Var).o(th);
            } catch (Throwable th2) {
                J(new y("Exception in completion handler " + f1Var + " for " + this, th2));
            }
        } else {
            y1 f10 = f1Var.f();
            if (f10 != null) {
                Object j10 = f10.j();
                j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", j10);
                for (p pVar2 = (p) j10; !j.a(pVar2, f10); pVar2 = pVar2.l()) {
                    if (pVar2 instanceof p1) {
                        p1 p1Var = (p1) pVar2;
                        try {
                            p1Var.o(th);
                        } catch (Throwable th3) {
                            if (yVar != null) {
                                a.a(yVar, th3);
                            } else {
                                yVar = new y("Exception in completion handler " + p1Var + " for " + this, th3);
                                la.v vVar = la.v.f9814a;
                            }
                        }
                    }
                }
                if (yVar != null) {
                    J(yVar);
                }
            }
        }
    }
}
