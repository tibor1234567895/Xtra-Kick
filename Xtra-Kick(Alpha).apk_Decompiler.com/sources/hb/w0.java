package hb;

import h3.u1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import ma.l;
import mb.t;
import pa.k;

public abstract class w0 extends x0 implements m0 {

    /* renamed from: n  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7876n;

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7877o;

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7878p;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    static {
        Class<w0> cls = w0.class;
        Class<Object> cls2 = Object.class;
        f7876n = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        f7877o = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        f7878p = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    public static final boolean Y0(w0 w0Var) {
        w0Var.getClass();
        if (f7878p.get(w0Var) != 0) {
            return true;
        }
        return false;
    }

    public final void M0(k kVar, Runnable runnable) {
        Z0(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0075 A[LOOP:2: B:44:0x0075->B:47:0x0080, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long U0() {
        /*
            r12 = this;
            boolean r0 = r12.V0()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7877o
            java.lang.Object r0 = r0.get(r12)
            hb.v0 r0 = (hb.v0) r0
            r3 = 0
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x0055
            int r6 = r0.b()
            if (r6 != 0) goto L_0x001e
            r6 = 1
            goto L_0x001f
        L_0x001e:
            r6 = 0
        L_0x001f:
            if (r6 != 0) goto L_0x0055
            long r6 = java.lang.System.nanoTime()
        L_0x0025:
            monitor-enter(r0)
            hb.u0[] r8 = r0.f10855a     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x002d
            r8 = r8[r5]     // Catch:{ all -> 0x0052 }
            goto L_0x002e
        L_0x002d:
            r8 = r3
        L_0x002e:
            if (r8 != 0) goto L_0x0033
            monitor-exit(r0)
            r8 = r3
            goto L_0x004f
        L_0x0033:
            long r9 = r8.f7857h     // Catch:{ all -> 0x0052 }
            long r9 = r6 - r9
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 < 0) goto L_0x003d
            r9 = 1
            goto L_0x003e
        L_0x003d:
            r9 = 0
        L_0x003e:
            if (r9 == 0) goto L_0x0045
            boolean r8 = r12.a1(r8)     // Catch:{ all -> 0x0052 }
            goto L_0x0046
        L_0x0045:
            r8 = 0
        L_0x0046:
            if (r8 == 0) goto L_0x004d
            hb.u0 r8 = r0.e(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x004e
        L_0x004d:
            r8 = r3
        L_0x004e:
            monitor-exit(r0)
        L_0x004f:
            if (r8 != 0) goto L_0x0025
            goto L_0x0055
        L_0x0052:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0055:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7876n
            java.lang.Object r6 = r0.get(r12)
            if (r6 != 0) goto L_0x005e
            goto L_0x009c
        L_0x005e:
            boolean r7 = r6 instanceof mb.t
            if (r7 == 0) goto L_0x0083
            r7 = r6
            mb.t r7 = (mb.t) r7
            java.lang.Object r8 = r7.d()
            h3.u1 r9 = mb.t.f10881h
            if (r8 == r9) goto L_0x0071
            r3 = r8
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            goto L_0x009c
        L_0x0071:
            mb.t r7 = r7.c()
        L_0x0075:
            boolean r8 = r0.compareAndSet(r12, r6, r7)
            if (r8 == 0) goto L_0x007c
            goto L_0x0055
        L_0x007c:
            java.lang.Object r8 = r0.get(r12)
            if (r8 == r6) goto L_0x0075
            goto L_0x0055
        L_0x0083:
            h3.u1 r7 = hb.y0.f7883b
            if (r6 != r7) goto L_0x0088
            goto L_0x009c
        L_0x0088:
            boolean r7 = r0.compareAndSet(r12, r6, r3)
            if (r7 == 0) goto L_0x0090
            r0 = 1
            goto L_0x0097
        L_0x0090:
            java.lang.Object r7 = r0.get(r12)
            if (r7 == r6) goto L_0x0088
            r0 = 0
        L_0x0097:
            if (r0 == 0) goto L_0x0055
            r3 = r6
            java.lang.Runnable r3 = (java.lang.Runnable) r3
        L_0x009c:
            if (r3 == 0) goto L_0x00a2
            r3.run()
            return r1
        L_0x00a2:
            ma.l r0 = r12.f7846l
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L_0x00ac
            goto L_0x00b2
        L_0x00ac:
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b4
        L_0x00b2:
            r8 = r6
            goto L_0x00b5
        L_0x00b4:
            r8 = r1
        L_0x00b5:
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x00ba
            goto L_0x010a
        L_0x00ba:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7876n
            java.lang.Object r0 = r0.get(r12)
            if (r0 == 0) goto L_0x00ea
            boolean r3 = r0 instanceof mb.t
            if (r3 == 0) goto L_0x00e5
            mb.t r0 = (mb.t) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = mb.t.f10880g
            long r8 = r3.get(r0)
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r10 = r10 & r8
            long r10 = r10 >> r5
            int r0 = (int) r10
            r10 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r8 = r8 & r10
            r3 = 30
            long r8 = r8 >> r3
            int r3 = (int) r8
            if (r0 != r3) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r4 = 0
        L_0x00e2:
            if (r4 != 0) goto L_0x00ea
            goto L_0x010a
        L_0x00e5:
            h3.u1 r3 = hb.y0.f7883b
            if (r0 != r3) goto L_0x010a
            goto L_0x0109
        L_0x00ea:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7877o
            java.lang.Object r0 = r0.get(r12)
            hb.v0 r0 = (hb.v0) r0
            if (r0 == 0) goto L_0x0109
            hb.u0 r0 = r0.c()
            if (r0 != 0) goto L_0x00fb
            goto L_0x0109
        L_0x00fb:
            long r3 = r0.f7857h
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0107
            goto L_0x010a
        L_0x0107:
            r1 = r3
            goto L_0x010a
        L_0x0109:
            r1 = r6
        L_0x010a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.w0.U0():long");
    }

    public final void W(long j10, l lVar) {
        u1 u1Var = y0.f7882a;
        long j11 = 0;
        if (j10 > 0) {
            if (j10 >= 9223372036854L) {
                j11 = Long.MAX_VALUE;
            } else {
                j11 = 1000000 * j10;
            }
        }
        if (j11 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            t0 t0Var = new t0(this, j11 + nanoTime, lVar);
            c1(nanoTime, t0Var);
            lVar.j(new h(1, t0Var));
        }
    }

    public void Z0(Runnable runnable) {
        if (a1(runnable)) {
            Thread W0 = W0();
            if (Thread.currentThread() != W0) {
                LockSupport.unpark(W0);
                return;
            }
            return;
        }
        i0.f7808q.Z0(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042 A[LOOP:2: B:23:0x0042->B:26:0x004d, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a1(java.lang.Runnable r7) {
        /*
            r6 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f7876n
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = f7878p
            int r2 = r2.get(r6)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0016
            return r3
        L_0x0016:
            if (r1 != 0) goto L_0x002a
        L_0x0018:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L_0x0021
            r3 = 1
            goto L_0x0027
        L_0x0021:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L_0x0018
        L_0x0027:
            if (r3 == 0) goto L_0x0000
            return r4
        L_0x002a:
            boolean r2 = r1 instanceof mb.t
            if (r2 == 0) goto L_0x0051
            r2 = r1
            mb.t r2 = (mb.t) r2
            int r5 = r2.a(r7)
            if (r5 == 0) goto L_0x0050
            if (r5 == r4) goto L_0x003e
            r0 = 2
            if (r5 == r0) goto L_0x003d
            goto L_0x0000
        L_0x003d:
            return r3
        L_0x003e:
            mb.t r2 = r2.c()
        L_0x0042:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L_0x0049
            goto L_0x0000
        L_0x0049:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L_0x0042
            goto L_0x0000
        L_0x0050:
            return r4
        L_0x0051:
            h3.u1 r2 = hb.y0.f7883b
            if (r1 != r2) goto L_0x0056
            return r3
        L_0x0056:
            mb.t r2 = new mb.t
            r5 = 8
            r2.<init>(r5, r4)
            r5 = r1
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r2.a(r5)
            r2.a(r7)
        L_0x0066:
            boolean r5 = r0.compareAndSet(r6, r1, r2)
            if (r5 == 0) goto L_0x006e
            r3 = 1
            goto L_0x0074
        L_0x006e:
            java.lang.Object r5 = r0.get(r6)
            if (r5 == r1) goto L_0x0066
        L_0x0074:
            if (r3 == 0) goto L_0x0000
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.w0.a1(java.lang.Runnable):boolean");
    }

    public final boolean b1() {
        boolean z10;
        boolean z11;
        l lVar = this.f7846l;
        if (lVar != null) {
            z10 = lVar.isEmpty();
        } else {
            z10 = true;
        }
        if (!z10) {
            return false;
        }
        v0 v0Var = (v0) f7877o.get(this);
        if (v0Var != null) {
            if (v0Var.b() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return false;
            }
        }
        Object obj = f7876n.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof t) {
            long j10 = t.f10880g.get((t) obj);
            if (((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == y0.f7883b) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[LOOP:0: B:10:0x0021->B:13:0x002c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c1(long r7, hb.u0 r9) {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f7878p
            int r0 = r0.get(r6)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f7877o
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x003b
        L_0x0014:
            java.lang.Object r0 = r4.get(r6)
            hb.v0 r0 = (hb.v0) r0
            if (r0 != 0) goto L_0x0037
            hb.v0 r5 = new hb.v0
            r5.<init>(r7)
        L_0x0021:
            boolean r0 = r4.compareAndSet(r6, r3, r5)
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.lang.Object r0 = r4.get(r6)
            if (r0 == 0) goto L_0x0021
        L_0x002e:
            java.lang.Object r0 = r4.get(r6)
            xa.j.c(r0)
            hb.v0 r0 = (hb.v0) r0
        L_0x0037:
            int r0 = r9.c(r7, r0, r6)
        L_0x003b:
            if (r0 == 0) goto L_0x0053
            if (r0 == r2) goto L_0x004f
            r7 = 2
            if (r0 != r7) goto L_0x0043
            goto L_0x0071
        L_0x0043:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "unexpected result"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x004f:
            r6.X0(r7, r9)
            goto L_0x0071
        L_0x0053:
            java.lang.Object r7 = r4.get(r6)
            hb.v0 r7 = (hb.v0) r7
            if (r7 == 0) goto L_0x005f
            hb.u0 r3 = r7.c()
        L_0x005f:
            if (r3 != r9) goto L_0x0062
            r1 = 1
        L_0x0062:
            if (r1 == 0) goto L_0x0071
            java.lang.Thread r7 = r6.W0()
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            if (r8 == r7) goto L_0x0071
            java.util.concurrent.locks.LockSupport.unpark(r7)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.w0.c1(long, hb.u0):void");
    }

    public void shutdown() {
        u0 u0Var;
        boolean z10;
        boolean z11;
        f2.f7793a.getClass();
        f2.f7794b.set((Object) null);
        f7878p.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7876n;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                u1 u1Var = y0.f7883b;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, u1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != null) {
                            z11 = false;
                            break;
                        }
                    } else {
                        z11 = true;
                        break;
                    }
                }
                if (z11) {
                    break;
                }
            } else if (obj instanceof t) {
                ((t) obj).b();
                break;
            } else if (obj == y0.f7883b) {
                break;
            } else {
                t tVar = new t(8, true);
                tVar.a((Runnable) obj);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, tVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
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
            }
        }
        do {
        } while (U0() <= 0);
        long nanoTime = System.nanoTime();
        while (true) {
            v0 v0Var = (v0) f7877o.get(this);
            if (v0Var != null) {
                synchronized (v0Var) {
                    if (v0Var.b() > 0) {
                        u0Var = v0Var.e(0);
                    } else {
                        u0Var = null;
                    }
                }
                if (u0Var != null) {
                    X0(nanoTime, u0Var);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
