package nb;

import android.support.v4.media.h;
import e0.q;
import h3.u1;
import hb.h0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import mb.x;
import s.i;
import xa.j;

public final class c implements Executor, Closeable {

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f11805o;

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f11806p;

    /* renamed from: q  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f11807q;

    /* renamed from: r  reason: collision with root package name */
    public static final u1 f11808r = new u1("NOT_IN_STACK", 2);
    private volatile int _isTerminated;
    private volatile long controlState;

    /* renamed from: h  reason: collision with root package name */
    public final int f11809h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11810i;

    /* renamed from: j  reason: collision with root package name */
    public final long f11811j;

    /* renamed from: k  reason: collision with root package name */
    public final String f11812k;

    /* renamed from: l  reason: collision with root package name */
    public final f f11813l;

    /* renamed from: m  reason: collision with root package name */
    public final f f11814m;

    /* renamed from: n  reason: collision with root package name */
    public final x f11815n;
    private volatile long parkedWorkersStack;

    static {
        new a(0);
        Class<c> cls = c.class;
        f11805o = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f11806p = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f11807q = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public c(int i10, int i11, long j10, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f11809h = i10;
        this.f11810i = i11;
        this.f11811j = j10;
        this.f11812k = str;
        boolean z13 = true;
        if (i10 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= 2097150) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (j10 <= 0 ? false : z13) {
                        this.f11813l = new f();
                        this.f11814m = new f();
                        this.f11815n = new x((i10 + 1) * 2);
                        this.controlState = ((long) i10) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(h.j("Max pool size ", i11, " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(h.j("Core pool size ", i10, " should be at least 1").toString());
    }

    public final int c() {
        boolean z10;
        boolean z11;
        synchronized (this.f11815n) {
            boolean z12 = false;
            if (f11807q.get(this) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f11806p;
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 & 2097151);
            int i11 = i10 - ((int) ((j10 & 4398044413952L) >> 21));
            if (i11 < 0) {
                i11 = 0;
            }
            if (i11 >= this.f11809h) {
                return 0;
            }
            if (i10 >= this.f11810i) {
                return 0;
            }
            int i12 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
            if (i12 <= 0 || this.f11815n.b(i12) != null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                b bVar = new b(this, i12);
                this.f11815n.c(i12, bVar);
                if (i12 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z12 = true;
                }
                if (z12) {
                    int i13 = i11 + 1;
                    bVar.start();
                    return i13;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r1 == null) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f11807q
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof nb.b
            r4 = 0
            if (r3 == 0) goto L_0x0018
            nb.b r0 = (nb.b) r0
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            if (r0 == 0) goto L_0x0024
            nb.c r3 = r0.f11804o
            boolean r3 = xa.j.a(r3, r9)
            if (r3 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r4
        L_0x0025:
            mb.x r3 = r9.f11815n
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = f11806p     // Catch:{ all -> 0x00c4 }
            long r5 = r5.get(r9)     // Catch:{ all -> 0x00c4 }
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r6 = (int) r5
            monitor-exit(r3)
            if (r2 > r6) goto L_0x007a
            r3 = 1
        L_0x0037:
            mb.x r5 = r9.f11815n
            java.lang.Object r5 = r5.b(r3)
            xa.j.c(r5)
            nb.b r5 = (nb.b) r5
            if (r5 == r0) goto L_0x0075
        L_0x0044:
            boolean r7 = r5.isAlive()
            if (r7 == 0) goto L_0x0053
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r7 = 10000(0x2710, double:4.9407E-320)
            r5.join(r7)
            goto L_0x0044
        L_0x0053:
            nb.n r5 = r5.f11797h
            nb.f r7 = r9.f11814m
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = nb.n.f11833b
            java.lang.Object r8 = r8.getAndSet(r5, r4)
            nb.j r8 = (nb.j) r8
            if (r8 == 0) goto L_0x0067
            r7.a(r8)
        L_0x0067:
            nb.j r8 = r5.b()
            if (r8 != 0) goto L_0x006f
            r8 = 0
            goto L_0x0073
        L_0x006f:
            r7.a(r8)
            r8 = 1
        L_0x0073:
            if (r8 != 0) goto L_0x0067
        L_0x0075:
            if (r3 == r6) goto L_0x007a
            int r3 = r3 + 1
            goto L_0x0037
        L_0x007a:
            nb.f r1 = r9.f11814m
            r1.b()
            nb.f r1 = r9.f11813l
            r1.b()
        L_0x0084:
            if (r0 == 0) goto L_0x008c
            nb.j r1 = r0.a(r2)
            if (r1 != 0) goto L_0x00b3
        L_0x008c:
            nb.f r1 = r9.f11813l
            java.lang.Object r1 = r1.d()
            nb.j r1 = (nb.j) r1
            if (r1 != 0) goto L_0x00b3
            nb.f r1 = r9.f11814m
            java.lang.Object r1 = r1.d()
            nb.j r1 = (nb.j) r1
            if (r1 != 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a6
            r1 = 5
            r0.h(r1)
        L_0x00a6:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f11805o
            r1 = 0
            r0.set(r9, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f11806p
            r0.set(r9, r1)
        L_0x00b2:
            return
        L_0x00b3:
            r1.run()     // Catch:{ all -> 0x00b7 }
            goto L_0x0084
        L_0x00b7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L_0x0084
        L_0x00c4:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.c.close():void");
    }

    public final void e(Runnable runnable, q qVar, boolean z10) {
        j jVar;
        boolean z11;
        long j10;
        b bVar;
        boolean z12;
        f fVar;
        int i10;
        l.f11829f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof j) {
            jVar = (j) runnable;
            jVar.f11821h = nanoTime;
            jVar.f11822i = qVar;
        } else {
            jVar = new k(runnable, nanoTime, qVar);
        }
        boolean z13 = false;
        if (jVar.f11822i.f4883h == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f11806p;
        if (z11) {
            j10 = atomicLongFieldUpdater.addAndGet(this, 2097152);
        } else {
            j10 = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof b) {
            bVar = (b) currentThread;
        } else {
            bVar = null;
        }
        if (bVar == null || !j.a(bVar.f11804o, this)) {
            bVar = null;
        }
        if (!(bVar == null || (i10 = bVar.f11799j) == 5 || (jVar.f11822i.f4883h == 0 && i10 == 2))) {
            bVar.f11803n = true;
            n nVar = bVar.f11797h;
            if (z10) {
                jVar = nVar.a(jVar);
            } else {
                nVar.getClass();
                j jVar2 = (j) n.f11833b.getAndSet(nVar, jVar);
                if (jVar2 == null) {
                    jVar = null;
                } else {
                    jVar = nVar.a(jVar2);
                }
            }
        }
        if (jVar != null) {
            if (jVar.f11822i.f4883h == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                fVar = this.f11814m;
            } else {
                fVar = this.f11813l;
            }
            if (!fVar.a(jVar)) {
                throw new RejectedExecutionException(h.p(new StringBuilder(), this.f11812k, " was terminated"));
            }
        }
        if (z10 && bVar != null) {
            z13 = true;
        }
        if (z11) {
            if (!z13 && !w() && !v(j10)) {
                w();
            }
        } else if (!z13 && !w() && !v(atomicLongFieldUpdater.get(this))) {
            w();
        }
    }

    public final void execute(Runnable runnable) {
        e(runnable, l.f11830g, false);
    }

    public final void k(b bVar, int i10, int i11) {
        while (true) {
            long j10 = f11805o.get(this);
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & -2097152;
            if (i12 == i10) {
                if (i11 == 0) {
                    b bVar2 = bVar;
                    while (true) {
                        Object c10 = bVar2.c();
                        if (c10 != f11808r) {
                            if (c10 != null) {
                                bVar2 = (b) c10;
                                i12 = bVar2.b();
                                if (i12 != 0) {
                                    break;
                                }
                            } else {
                                i12 = 0;
                                break;
                            }
                        } else {
                            i12 = -1;
                            break;
                        }
                    }
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (f11805o.compareAndSet(this, j10, j11 | ((long) i12))) {
                    return;
                }
            }
        }
    }

    public final String toString() {
        int i10;
        char c10;
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        x xVar = this.f11815n;
        int a10 = xVar.a();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 1; i16 < a10; i16++) {
            b bVar = (b) xVar.b(i16);
            if (bVar != null) {
                n nVar = bVar.f11797h;
                nVar.getClass();
                if (n.f11833b.get(nVar) != null) {
                    i10 = (n.f11834c.get(nVar) - n.f11835d.get(nVar)) + 1;
                } else {
                    i10 = n.f11834c.get(nVar) - n.f11835d.get(nVar);
                }
                int a11 = i.a(bVar.f11799j);
                if (a11 == 0) {
                    i11++;
                    sb2 = new StringBuilder();
                    sb2.append(i10);
                    c10 = 'c';
                } else if (a11 == 1) {
                    i12++;
                    sb2 = new StringBuilder();
                    sb2.append(i10);
                    c10 = 'b';
                } else if (a11 == 2) {
                    i13++;
                } else if (a11 == 3) {
                    i14++;
                    if (i10 > 0) {
                        sb2 = new StringBuilder();
                        sb2.append(i10);
                        c10 = 'd';
                    }
                } else if (a11 == 4) {
                    i15++;
                }
                sb2.append(c10);
                arrayList.add(sb2.toString());
            }
        }
        long j10 = f11806p.get(this);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f11812k);
        sb3.append('@');
        sb3.append(h0.r0(this));
        sb3.append("[Pool Size {core = ");
        int i17 = this.f11809h;
        sb3.append(i17);
        sb3.append(", max = ");
        sb3.append(this.f11810i);
        sb3.append("}, Worker States {CPU = ");
        sb3.append(i11);
        sb3.append(", blocking = ");
        sb3.append(i12);
        sb3.append(", parked = ");
        sb3.append(i13);
        sb3.append(", dormant = ");
        sb3.append(i14);
        sb3.append(", terminated = ");
        sb3.append(i15);
        sb3.append("}, running workers queues = ");
        sb3.append(arrayList);
        sb3.append(", global CPU queue size = ");
        sb3.append(this.f11813l.c());
        sb3.append(", global blocking queue size = ");
        sb3.append(this.f11814m.c());
        sb3.append(", Control State {created workers= ");
        sb3.append((int) (2097151 & j10));
        sb3.append(", blocking tasks = ");
        sb3.append((int) ((4398044413952L & j10) >> 21));
        sb3.append(", CPUs acquired = ");
        sb3.append(i17 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb3.append("}]");
        return sb3.toString();
    }

    public final boolean v(long j10) {
        int i10 = ((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21));
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.f11809h;
        if (i10 < i11) {
            int c10 = c();
            if (c10 == 1 && i11 > 1) {
                c();
            }
            if (c10 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean w() {
        u1 u1Var;
        int i10;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f11805o;
            long j10 = atomicLongFieldUpdater.get(this);
            b bVar = (b) this.f11815n.b((int) (2097151 & j10));
            if (bVar == null) {
                bVar = null;
            } else {
                long j11 = (2097152 + j10) & -2097152;
                b bVar2 = bVar;
                while (true) {
                    Object c10 = bVar2.c();
                    u1Var = f11808r;
                    if (c10 != u1Var) {
                        if (c10 != null) {
                            bVar2 = (b) c10;
                            i10 = bVar2.b();
                            if (i10 != 0) {
                                break;
                            }
                        } else {
                            i10 = 0;
                            break;
                        }
                    } else {
                        i10 = -1;
                        break;
                    }
                }
                if (i10 >= 0) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j10, j11 | ((long) i10))) {
                        bVar.g(u1Var);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (bVar == null) {
                return false;
            }
            if (b.f11796p.compareAndSet(bVar, -1, 0)) {
                LockSupport.unpark(bVar);
                return true;
            }
        }
    }
}
