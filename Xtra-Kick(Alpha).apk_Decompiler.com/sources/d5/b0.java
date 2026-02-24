package d5;

import b5.a;
import b5.j;
import g5.g;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import l0.d;
import w5.n;
import x5.e;
import x5.h;

public final class b0 implements j, e {
    public static final y G = new y();
    public i0 A;
    public boolean B;
    public g0 C;
    public n D;
    public volatile boolean E;
    public boolean F;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f4340h = new a0();

    /* renamed from: i  reason: collision with root package name */
    public final h f4341i = new h();

    /* renamed from: j  reason: collision with root package name */
    public final f0 f4342j;

    /* renamed from: k  reason: collision with root package name */
    public final d f4343k;

    /* renamed from: l  reason: collision with root package name */
    public final y f4344l;

    /* renamed from: m  reason: collision with root package name */
    public final c0 f4345m;

    /* renamed from: n  reason: collision with root package name */
    public final g f4346n;

    /* renamed from: o  reason: collision with root package name */
    public final g f4347o;

    /* renamed from: p  reason: collision with root package name */
    public final g f4348p;

    /* renamed from: q  reason: collision with root package name */
    public final g f4349q;

    /* renamed from: r  reason: collision with root package name */
    public final AtomicInteger f4350r = new AtomicInteger();

    /* renamed from: s  reason: collision with root package name */
    public j f4351s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4352t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4353u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4354v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4355w;

    /* renamed from: x  reason: collision with root package name */
    public o0 f4356x;

    /* renamed from: y  reason: collision with root package name */
    public a f4357y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4358z;

    public b0(g gVar, g gVar2, g gVar3, g gVar4, c0 c0Var, f0 f0Var, d dVar) {
        this.f4346n = gVar;
        this.f4347o = gVar2;
        this.f4348p = gVar3;
        this.f4349q = gVar4;
        this.f4345m = c0Var;
        this.f4342j = f0Var;
        this.f4343k = dVar;
        this.f4344l = G;
    }

    public final synchronized void a(s5.g gVar, Executor executor) {
        x xVar;
        this.f4341i.a();
        a0 a0Var = this.f4340h;
        a0Var.getClass();
        a0Var.f4336h.add(new z(gVar, executor));
        boolean z10 = true;
        if (this.f4358z) {
            e(1);
            xVar = new x(this, gVar, 1);
        } else if (this.B) {
            e(1);
            xVar = new x(this, gVar, 0);
        } else {
            if (this.E) {
                z10 = false;
            }
            n.a("Cannot add callbacks to a cancelled EngineJob", z10);
        }
        executor.execute(xVar);
    }

    public final void b() {
        HashMap hashMap;
        if (!f()) {
            this.E = true;
            n nVar = this.D;
            nVar.J = true;
            h hVar = nVar.H;
            if (hVar != null) {
                hVar.cancel();
            }
            c0 c0Var = this.f4345m;
            j jVar = this.f4351s;
            w wVar = (w) c0Var;
            synchronized (wVar) {
                k0 k0Var = wVar.f4498a;
                k0Var.getClass();
                if (this.f4355w) {
                    hashMap = k0Var.f4420b;
                } else {
                    hashMap = k0Var.f4419a;
                }
                if (equals(hashMap.get(jVar))) {
                    hashMap.remove(jVar);
                }
            }
        }
    }

    public final h c() {
        return this.f4341i;
    }

    public final void d() {
        g0 g0Var;
        synchronized (this) {
            this.f4341i.a();
            n.a("Not yet complete!", f());
            int decrementAndGet = this.f4350r.decrementAndGet();
            n.a("Can't decrement below 0", decrementAndGet >= 0);
            if (decrementAndGet == 0) {
                g0Var = this.C;
                i();
            } else {
                g0Var = null;
            }
        }
        if (g0Var != null) {
            g0Var.c();
        }
    }

    public final synchronized void e(int i10) {
        g0 g0Var;
        n.a("Not yet complete!", f());
        if (this.f4350r.getAndAdd(i10) == 0 && (g0Var = this.C) != null) {
            g0Var.a();
        }
    }

    public final boolean f() {
        return this.B || this.f4358z || this.E;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        ((d5.w) r5.f4345m).d(r5, r1, (d5.g0) null);
        r0 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r0.hasNext() == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1 = (d5.z) r0.next();
        r1.f4509b.execute(new d5.x(r5, r1.f4508a, 0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r5 = this;
            monitor-enter(r5)
            x5.h r0 = r5.f4341i     // Catch:{ all -> 0x0071 }
            r0.a()     // Catch:{ all -> 0x0071 }
            boolean r0 = r5.E     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x000f
            r5.i()     // Catch:{ all -> 0x0071 }
            monitor-exit(r5)     // Catch:{ all -> 0x0071 }
            return
        L_0x000f:
            d5.a0 r0 = r5.f4340h     // Catch:{ all -> 0x0071 }
            java.util.List r0 = r0.f4336h     // Catch:{ all -> 0x0071 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x0069
            boolean r0 = r5.B     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x0061
            r0 = 1
            r5.B = r0     // Catch:{ all -> 0x0071 }
            b5.j r1 = r5.f4351s     // Catch:{ all -> 0x0071 }
            d5.a0 r2 = r5.f4340h     // Catch:{ all -> 0x0071 }
            r2.getClass()     // Catch:{ all -> 0x0071 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0071 }
            java.util.List r2 = r2.f4336h     // Catch:{ all -> 0x0071 }
            r3.<init>(r2)     // Catch:{ all -> 0x0071 }
            int r2 = r3.size()     // Catch:{ all -> 0x0071 }
            int r2 = r2 + r0
            r5.e(r2)     // Catch:{ all -> 0x0071 }
            monitor-exit(r5)     // Catch:{ all -> 0x0071 }
            d5.c0 r0 = r5.f4345m
            r2 = 0
            d5.w r0 = (d5.w) r0
            r0.d(r5, r1, r2)
            java.util.Iterator r0 = r3.iterator()
        L_0x0043:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            d5.z r1 = (d5.z) r1
            java.util.concurrent.Executor r2 = r1.f4509b
            d5.x r3 = new d5.x
            s5.g r1 = r1.f4508a
            r4 = 0
            r3.<init>(r5, r1, r4)
            r2.execute(r3)
            goto L_0x0043
        L_0x005d:
            r5.d()
            return
        L_0x0061:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0071 }
            throw r0     // Catch:{ all -> 0x0071 }
        L_0x0069:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0071 }
            throw r0     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0071 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.b0.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        ((d5.w) r7.f4345m).d(r7, r1, r3);
        r1 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (r1.hasNext() == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r2 = (d5.z) r1.next();
        r2.f4509b.execute(new d5.x(r7, r2.f4508a, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r7 = this;
            monitor-enter(r7)
            x5.h r0 = r7.f4341i     // Catch:{ all -> 0x008c }
            r0.a()     // Catch:{ all -> 0x008c }
            boolean r0 = r7.E     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x0014
            d5.o0 r0 = r7.f4356x     // Catch:{ all -> 0x008c }
            r0.e()     // Catch:{ all -> 0x008c }
            r7.i()     // Catch:{ all -> 0x008c }
            monitor-exit(r7)     // Catch:{ all -> 0x008c }
            return
        L_0x0014:
            d5.a0 r0 = r7.f4340h     // Catch:{ all -> 0x008c }
            java.util.List r0 = r0.f4336h     // Catch:{ all -> 0x008c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0084
            boolean r0 = r7.f4358z     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x007c
            d5.y r0 = r7.f4344l     // Catch:{ all -> 0x008c }
            d5.o0 r2 = r7.f4356x     // Catch:{ all -> 0x008c }
            boolean r3 = r7.f4352t     // Catch:{ all -> 0x008c }
            b5.j r5 = r7.f4351s     // Catch:{ all -> 0x008c }
            d5.f0 r6 = r7.f4342j     // Catch:{ all -> 0x008c }
            r0.getClass()     // Catch:{ all -> 0x008c }
            d5.g0 r0 = new d5.g0     // Catch:{ all -> 0x008c }
            r4 = 1
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x008c }
            r7.C = r0     // Catch:{ all -> 0x008c }
            r0 = 1
            r7.f4358z = r0     // Catch:{ all -> 0x008c }
            d5.a0 r1 = r7.f4340h     // Catch:{ all -> 0x008c }
            r1.getClass()     // Catch:{ all -> 0x008c }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            java.util.List r1 = r1.f4336h     // Catch:{ all -> 0x008c }
            r2.<init>(r1)     // Catch:{ all -> 0x008c }
            int r1 = r2.size()     // Catch:{ all -> 0x008c }
            int r1 = r1 + r0
            r7.e(r1)     // Catch:{ all -> 0x008c }
            b5.j r1 = r7.f4351s     // Catch:{ all -> 0x008c }
            d5.g0 r3 = r7.C     // Catch:{ all -> 0x008c }
            monitor-exit(r7)     // Catch:{ all -> 0x008c }
            d5.c0 r4 = r7.f4345m
            d5.w r4 = (d5.w) r4
            r4.d(r7, r1, r3)
            java.util.Iterator r1 = r2.iterator()
        L_0x005f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0078
            java.lang.Object r2 = r1.next()
            d5.z r2 = (d5.z) r2
            java.util.concurrent.Executor r3 = r2.f4509b
            d5.x r4 = new d5.x
            s5.g r2 = r2.f4508a
            r4.<init>(r7, r2, r0)
            r3.execute(r4)
            goto L_0x005f
        L_0x0078:
            r7.d()
            return
        L_0x007c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x008c }
            throw r0     // Catch:{ all -> 0x008c }
        L_0x0084:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x008c }
            throw r0     // Catch:{ all -> 0x008c }
        L_0x008c:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x008c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.b0.h():void");
    }

    public final synchronized void i() {
        if (this.f4351s != null) {
            this.f4340h.f4336h.clear();
            this.f4351s = null;
            this.C = null;
            this.f4356x = null;
            this.B = false;
            this.E = false;
            this.f4358z = false;
            this.F = false;
            this.D.m();
            this.D = null;
            this.A = null;
            this.f4357y = null;
            this.f4343k.e(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void j(s5.g gVar) {
        boolean z10;
        this.f4341i.a();
        a0 a0Var = this.f4340h;
        a0Var.getClass();
        a0Var.f4336h.remove(new z(gVar, w5.g.f16114b));
        if (this.f4340h.f4336h.isEmpty()) {
            b();
            if (!this.f4358z) {
                if (!this.B) {
                    z10 = false;
                    if (z10 && this.f4350r.get() == 0) {
                        i();
                    }
                }
            }
            z10 = true;
            i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void k(d5.n r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.D = r3     // Catch:{ all -> 0x002f }
            d5.m r0 = d5.m.INITIALIZE     // Catch:{ all -> 0x002f }
            d5.m r0 = r3.i(r0)     // Catch:{ all -> 0x002f }
            d5.m r1 = d5.m.RESOURCE_CACHE     // Catch:{ all -> 0x002f }
            if (r0 == r1) goto L_0x0014
            d5.m r1 = d5.m.DATA_CACHE     // Catch:{ all -> 0x002f }
            if (r0 != r1) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            g5.g r0 = r2.f4346n     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x001a:
            boolean r0 = r2.f4353u     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0021
            g5.g r0 = r2.f4348p     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x0021:
            boolean r0 = r2.f4354v     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0028
            g5.g r0 = r2.f4349q     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x0028:
            g5.g r0 = r2.f4347o     // Catch:{ all -> 0x002f }
        L_0x002a:
            r0.execute(r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return
        L_0x002f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.b0.k(d5.n):void");
    }
}
