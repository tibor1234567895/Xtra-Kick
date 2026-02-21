package nb;

import ab.e;
import h3.u1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import la.v;
import xa.j;
import xa.u;

public final class b extends Thread {

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f11796p = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

    /* renamed from: h  reason: collision with root package name */
    public final n f11797h = new n();

    /* renamed from: i  reason: collision with root package name */
    public final u f11798i = new u();
    private volatile int indexInArray;

    /* renamed from: j  reason: collision with root package name */
    public int f11799j = 4;

    /* renamed from: k  reason: collision with root package name */
    public long f11800k;

    /* renamed from: l  reason: collision with root package name */
    public long f11801l;

    /* renamed from: m  reason: collision with root package name */
    public int f11802m = e.f295h.b();

    /* renamed from: n  reason: collision with root package name */
    public boolean f11803n;
    private volatile Object nextParkedWorker = c.f11808r;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ c f11804o;
    private volatile int workerCtl;

    public b(c cVar, int i10) {
        this.f11804o = cVar;
        setDaemon(true);
        f(i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final nb.j a(boolean r11) {
        /*
            r10 = this;
            int r0 = r10.f11799j
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0007
            goto L_0x0032
        L_0x0007:
            nb.c r0 = r10.f11804o
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = nb.c.f11806p
        L_0x000b:
            long r5 = r9.get(r0)
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r3 = r3 & r5
            r7 = 42
            long r3 = r3 >> r7
            int r4 = (int) r3
            if (r4 != 0) goto L_0x001d
            r0 = 0
            goto L_0x002e
        L_0x001d:
            r3 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r7 = r5 - r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = nb.c.f11806p
            r4 = r0
            boolean r3 = r3.compareAndSet(r4, r5, r7)
            if (r3 == 0) goto L_0x000b
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x0034
            r10.f11799j = r1
        L_0x0032:
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            nb.c r3 = r10.f11804o
            r4 = 0
            nb.n r5 = r10.f11797h
            if (r0 == 0) goto L_0x007d
            if (r11 == 0) goto L_0x0070
            int r11 = r3.f11809h
            int r11 = r11 * 2
            int r11 = r10.d(r11)
            if (r11 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            if (r1 == 0) goto L_0x0053
            nb.j r11 = r10.e()
            if (r11 == 0) goto L_0x0053
            goto L_0x007c
        L_0x0053:
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = nb.n.f11833b
            java.lang.Object r11 = r11.getAndSet(r5, r4)
            nb.j r11 = (nb.j) r11
            if (r11 != 0) goto L_0x0064
            nb.j r11 = r5.b()
        L_0x0064:
            if (r11 == 0) goto L_0x0067
            goto L_0x007c
        L_0x0067:
            if (r1 != 0) goto L_0x0077
            nb.j r11 = r10.e()
            if (r11 == 0) goto L_0x0077
            goto L_0x007c
        L_0x0070:
            nb.j r11 = r10.e()
            if (r11 == 0) goto L_0x0077
            goto L_0x007c
        L_0x0077:
            r11 = 3
            nb.j r11 = r10.i(r11)
        L_0x007c:
            return r11
        L_0x007d:
            r5.getClass()
        L_0x0080:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = nb.n.f11833b
            java.lang.Object r0 = r11.get(r5)
            nb.j r0 = (nb.j) r0
            if (r0 != 0) goto L_0x008b
            goto L_0x00a9
        L_0x008b:
            e0.q r6 = r0.f11822i
            int r6 = r6.f4883h
            if (r6 != r1) goto L_0x0093
            r6 = 1
            goto L_0x0094
        L_0x0093:
            r6 = 0
        L_0x0094:
            if (r6 != r1) goto L_0x00a9
        L_0x0096:
            boolean r6 = r11.compareAndSet(r5, r0, r4)
            if (r6 == 0) goto L_0x009e
            r11 = 1
            goto L_0x00a5
        L_0x009e:
            java.lang.Object r6 = r11.get(r5)
            if (r6 == r0) goto L_0x0096
            r11 = 0
        L_0x00a5:
            if (r11 == 0) goto L_0x0080
            r4 = r0
            goto L_0x00c9
        L_0x00a9:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r11 = nb.n.f11835d
            int r11 = r11.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = nb.n.f11834c
            int r0 = r0.get(r5)
        L_0x00b5:
            if (r11 == r0) goto L_0x00c9
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = nb.n.f11836e
            int r2 = r2.get(r5)
            if (r2 != 0) goto L_0x00c0
            goto L_0x00c9
        L_0x00c0:
            int r0 = r0 + -1
            nb.j r2 = r5.c(r0, r1)
            if (r2 == 0) goto L_0x00b5
            r4 = r2
        L_0x00c9:
            if (r4 != 0) goto L_0x00da
            nb.f r11 = r3.f11814m
            java.lang.Object r11 = r11.d()
            r4 = r11
            nb.j r4 = (nb.j) r4
            if (r4 != 0) goto L_0x00da
            nb.j r4 = r10.i(r1)
        L_0x00da:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.b.a(boolean):nb.j");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i10) {
        int i11 = this.f11802m;
        int i12 = i11 ^ (i11 << 13);
        int i13 = i12 ^ (i12 >> 17);
        int i14 = i13 ^ (i13 << 5);
        this.f11802m = i14;
        int i15 = i10 - 1;
        return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
    }

    public final j e() {
        f fVar;
        int d10 = d(2);
        c cVar = this.f11804o;
        if (d10 == 0) {
            j jVar = (j) cVar.f11813l.d();
            if (jVar != null) {
                return jVar;
            }
            fVar = cVar.f11814m;
        } else {
            j jVar2 = (j) cVar.f11814m.d();
            if (jVar2 != null) {
                return jVar2;
            }
            fVar = cVar.f11813l;
        }
        return (j) fVar.d();
    }

    public final void f(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11804o.f11812k);
        sb2.append("-worker-");
        sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
        setName(sb2.toString());
        this.indexInArray = i10;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i10) {
        int i11 = this.f11799j;
        boolean z10 = true;
        if (i11 != 1) {
            z10 = false;
        }
        if (z10) {
            c.f11806p.addAndGet(this.f11804o, 4398046511104L);
        }
        if (i11 != i10) {
            this.f11799j = i10;
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        r7 = -2;
        r18 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        r5 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final nb.j i(int r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = nb.c.f11806p
            nb.c r3 = r0.f11804o
            long r4 = r2.get(r3)
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r2 = (int) r4
            r4 = 2
            r5 = 0
            if (r2 >= r4) goto L_0x0016
            return r5
        L_0x0016:
            int r6 = r0.d(r2)
            r10 = 0
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0020:
            if (r10 >= r2) goto L_0x00ee
            r15 = 1
            int r6 = r6 + r15
            if (r6 <= r2) goto L_0x0027
            r6 = 1
        L_0x0027:
            mb.x r4 = r3.f11815n
            java.lang.Object r4 = r4.b(r6)
            nb.b r4 = (nb.b) r4
            if (r4 == 0) goto L_0x00e4
            if (r4 == r0) goto L_0x00e4
            r9 = 3
            nb.n r4 = r4.f11797h
            if (r1 != r9) goto L_0x003d
            nb.j r9 = r4.b()
            goto L_0x0069
        L_0x003d:
            r4.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = nb.n.f11835d
            int r9 = r9.get(r4)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = nb.n.f11834c
            int r7 = r7.get(r4)
            if (r1 != r15) goto L_0x0050
            r8 = 1
            goto L_0x0051
        L_0x0050:
            r8 = 0
        L_0x0051:
            if (r9 == r7) goto L_0x0068
            if (r8 == 0) goto L_0x005e
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r13 = nb.n.f11836e
            int r13 = r13.get(r4)
            if (r13 != 0) goto L_0x005e
            goto L_0x0068
        L_0x005e:
            int r13 = r9 + 1
            nb.j r9 = r4.c(r9, r8)
            if (r9 != 0) goto L_0x0069
            r9 = r13
            goto L_0x0051
        L_0x0068:
            r9 = r5
        L_0x0069:
            xa.u r13 = r0.f11798i
            if (r9 == 0) goto L_0x0072
            r13.f16818h = r9
            r18 = r6
            goto L_0x00c0
        L_0x0072:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = nb.n.f11833b
            java.lang.Object r14 = r9.get(r4)
            nb.j r14 = (nb.j) r14
            if (r14 != 0) goto L_0x007d
            goto L_0x008e
        L_0x007d:
            e0.q r7 = r14.f11822i
            int r7 = r7.f4883h
            if (r7 != r15) goto L_0x0085
            r7 = 1
            goto L_0x0086
        L_0x0085:
            r7 = 0
        L_0x0086:
            if (r7 == 0) goto L_0x008a
            r7 = 1
            goto L_0x008b
        L_0x008a:
            r7 = 2
        L_0x008b:
            r7 = r7 & r1
            if (r7 != 0) goto L_0x0095
        L_0x008e:
            r7 = -2
            r18 = r6
        L_0x0092:
            r5 = -1
            goto L_0x00c4
        L_0x0095:
            nb.g r7 = nb.l.f11829f
            r7.getClass()
            long r7 = java.lang.System.nanoTime()
            r18 = r6
            long r5 = r14.f11821h
            long r7 = r7 - r5
            long r5 = nb.l.f11825b
            int r19 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r19 >= 0) goto L_0x00ac
            long r7 = r5 - r7
            goto L_0x0092
        L_0x00ac:
            r5 = 0
            boolean r6 = r9.compareAndSet(r4, r14, r5)
            if (r6 == 0) goto L_0x00b5
            r5 = 1
            goto L_0x00bc
        L_0x00b5:
            java.lang.Object r5 = r9.get(r4)
            if (r5 == r14) goto L_0x00e1
            r5 = 0
        L_0x00bc:
            if (r5 == 0) goto L_0x00db
            r13.f16818h = r14
        L_0x00c0:
            r5 = -1
            r7 = -1
        L_0x00c4:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00d0
            java.lang.Object r1 = r13.f16818h
            nb.j r1 = (nb.j) r1
            r2 = 0
            r13.f16818h = r2
            return r1
        L_0x00d0:
            r16 = 0
            int r4 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e6
            long r11 = java.lang.Math.min(r11, r7)
            goto L_0x00e6
        L_0x00db:
            r16 = 0
            r6 = r18
            r5 = 0
            goto L_0x0072
        L_0x00e1:
            r16 = 0
            goto L_0x00ac
        L_0x00e4:
            r18 = r6
        L_0x00e6:
            int r10 = r10 + 1
            r6 = r18
            r4 = 2
            r5 = 0
            goto L_0x0020
        L_0x00ee:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r16 = 0
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x00fa
            goto L_0x00fc
        L_0x00fa:
            r11 = r16
        L_0x00fc:
            r0.f11801l = r11
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.b.i(int):nb.j");
    }

    public final void run() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        int i10;
        loop0:
        while (true) {
            boolean z15 = false;
            while (true) {
                c cVar = this.f11804o;
                cVar.getClass();
                if (c.f11807q.get(cVar) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = 5;
                if (!z10 && this.f11799j != 5) {
                    j a10 = a(this.f11803n);
                    if (a10 == null) {
                        this.f11803n = false;
                        if (this.f11801l != 0) {
                            if (z15) {
                                h(3);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.f11801l);
                                this.f11801l = 0;
                                break;
                            }
                            z15 = true;
                        } else {
                            Object obj = this.nextParkedWorker;
                            u1 u1Var = c.f11808r;
                            if (obj != u1Var) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                f11796p.set(this, -1);
                                while (true) {
                                    if (this.nextParkedWorker != c.f11808r) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (!z12) {
                                        continue;
                                        break;
                                    }
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11796p;
                                    if (atomicIntegerFieldUpdater.get(this) != -1) {
                                        continue;
                                        break;
                                    }
                                    c cVar2 = this.f11804o;
                                    cVar2.getClass();
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = c.f11807q;
                                    if (atomicIntegerFieldUpdater2.get(cVar2) != 0) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    if (z13 || this.f11799j == i11) {
                                        break;
                                    }
                                    h(3);
                                    Thread.interrupted();
                                    if (this.f11800k == 0) {
                                        this.f11800k = System.nanoTime() + this.f11804o.f11811j;
                                    }
                                    LockSupport.parkNanos(this.f11804o.f11811j);
                                    if (System.nanoTime() - this.f11800k >= 0) {
                                        this.f11800k = 0;
                                        c cVar3 = this.f11804o;
                                        synchronized (cVar3.f11815n) {
                                            if (atomicIntegerFieldUpdater2.get(cVar3) != 0) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            if (!z14) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = c.f11806p;
                                                if (((int) (atomicLongFieldUpdater2.get(cVar3) & 2097151)) > cVar3.f11809h) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i12 = this.indexInArray;
                                                        f(0);
                                                        cVar3.k(this, i12, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(cVar3) & 2097151);
                                                        if (andDecrement != i12) {
                                                            Object b10 = cVar3.f11815n.b(andDecrement);
                                                            j.c(b10);
                                                            b bVar = (b) b10;
                                                            cVar3.f11815n.c(i12, bVar);
                                                            bVar.f(i12);
                                                            cVar3.k(bVar, andDecrement, i12);
                                                        }
                                                        cVar3.f11815n.c(andDecrement, (b) null);
                                                        v vVar = v.f9814a;
                                                        this.f11799j = 5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = 5;
                                }
                            } else {
                                c cVar4 = this.f11804o;
                                cVar4.getClass();
                                if (this.nextParkedWorker == u1Var) {
                                    do {
                                        atomicLongFieldUpdater = c.f11805o;
                                        j10 = atomicLongFieldUpdater.get(cVar4);
                                        i10 = this.indexInArray;
                                        this.nextParkedWorker = cVar4.f11815n.b((int) (j10 & 2097151));
                                    } while (!atomicLongFieldUpdater.compareAndSet(cVar4, j10, ((j10 + 2097152) & -2097152) | ((long) i10)));
                                }
                            }
                        }
                    } else {
                        this.f11801l = 0;
                        int i13 = a10.f11822i.f4883h;
                        this.f11800k = 0;
                        if (this.f11799j == 3) {
                            this.f11799j = 2;
                        }
                        c cVar5 = this.f11804o;
                        if (i13 != 0 && h(2) && !cVar5.w() && !cVar5.v(c.f11806p.get(cVar5))) {
                            cVar5.w();
                        }
                        cVar5.getClass();
                        try {
                            a10.run();
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            Thread currentThread = Thread.currentThread();
                            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
                        }
                        if (i13 != 0) {
                            c.f11806p.addAndGet(cVar5, -2097152);
                            if (this.f11799j != 5) {
                                this.f11799j = 4;
                            }
                        }
                    }
                } else {
                    h(5);
                }
            }
        }
        h(5);
    }
}
