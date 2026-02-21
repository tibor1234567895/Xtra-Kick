package wb;

import dc.j;
import dc.n0;
import dc.s0;
import la.v;
import pb.p0;
import qb.h;

public final class d0 implements n0 {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f16200h;

    /* renamed from: i  reason: collision with root package name */
    public final j f16201i = new j();

    /* renamed from: j  reason: collision with root package name */
    public boolean f16202j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g0 f16203k;

    public d0(g0 g0Var, boolean z10) {
        this.f16203k = g0Var;
        this.f16200h = z10;
    }

    /* JADX INFO: finally extract failed */
    public final void c(boolean z10) {
        long min;
        boolean z11;
        g0 g0Var = this.f16203k;
        synchronized (g0Var) {
            g0Var.f16249l.i();
            while (g0Var.f16242e >= g0Var.f16243f && !this.f16200h && !this.f16202j && g0Var.f() == null) {
                try {
                    g0Var.l();
                } catch (Throwable th) {
                    g0Var.f16249l.m();
                    throw th;
                }
            }
            g0Var.f16249l.m();
            g0Var.b();
            min = Math.min(g0Var.f16243f - g0Var.f16242e, this.f16201i.f4787i);
            g0Var.f16242e += min;
            if (!z10 || min != this.f16201i.f4787i) {
                z11 = false;
            } else {
                z11 = true;
            }
            v vVar = v.f9814a;
        }
        this.f16203k.f16249l.i();
        try {
            g0 g0Var2 = this.f16203k;
            g0Var2.f16239b.W(g0Var2.f16238a, z11, this.f16201i, min);
        } finally {
            this.f16203k.f16249l.m();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r0 = r14.f16203k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r0.f16247j.f16200h != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        if (r14.f16201i.f4787i <= 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r2 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r14.f16201i.f4787i <= 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        c(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        if (r1 == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        r0.f16239b.W(r0.f16238a, true, (dc.j) null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r0 = r14.f16203k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r14.f16202j = true;
        xa.j.d("null cannot be cast to non-null type java.lang.Object", r0);
        r0.notifyAll();
        r1 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        r14.f16203k.f16239b.flush();
        r14.f16203k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r14 = this;
            wb.g0 r0 = r14.f16203k
            pb.p0 r1 = qb.h.f13493a
            monitor-enter(r0)
            boolean r1 = r14.f16202j     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            wb.c r1 = r0.f()     // Catch:{ all -> 0x0067 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0015
            r1 = 1
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            la.v r4 = la.v.f9814a     // Catch:{ all -> 0x0067 }
            monitor-exit(r0)
            wb.g0 r0 = r14.f16203k
            wb.d0 r4 = r0.f16247j
            boolean r4 = r4.f16200h
            if (r4 != 0) goto L_0x0047
            dc.j r4 = r14.f16201i
            long r4 = r4.f4787i
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x002c
            r2 = 1
        L_0x002c:
            if (r2 == 0) goto L_0x003a
        L_0x002e:
            dc.j r0 = r14.f16201i
            long r0 = r0.f4787i
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0047
            r14.c(r3)
            goto L_0x002e
        L_0x003a:
            if (r1 == 0) goto L_0x0047
            wb.v r8 = r0.f16239b
            int r9 = r0.f16238a
            r10 = 1
            r11 = 0
            r12 = 0
            r8.W(r9, r10, r11, r12)
        L_0x0047:
            wb.g0 r0 = r14.f16203k
            monitor-enter(r0)
            r14.f16202j = r3     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.Object"
            xa.j.d(r1, r0)     // Catch:{ all -> 0x0064 }
            r0.notifyAll()     // Catch:{ all -> 0x0064 }
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0064 }
            monitor-exit(r0)
            wb.g0 r0 = r14.f16203k
            wb.v r0 = r0.f16239b
            r0.flush()
            wb.g0 r0 = r14.f16203k
            r0.a()
            return
        L_0x0064:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0067:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.d0.close():void");
    }

    public final void flush() {
        g0 g0Var = this.f16203k;
        p0 p0Var = h.f13493a;
        synchronized (g0Var) {
            g0Var.b();
            v vVar = v.f9814a;
        }
        while (this.f16201i.f4787i > 0) {
            c(false);
            this.f16203k.f16239b.flush();
        }
    }

    public final void o0(j jVar, long j10) {
        xa.j.f("source", jVar);
        p0 p0Var = h.f13493a;
        j jVar2 = this.f16201i;
        jVar2.o0(jVar, j10);
        while (jVar2.f4787i >= 16384) {
            c(false);
        }
    }

    public final s0 timeout() {
        return this.f16203k.f16249l;
    }
}
