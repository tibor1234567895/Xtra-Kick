package wb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import la.v;
import pb.p0;
import qb.h;
import xa.j;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f16238a;

    /* renamed from: b  reason: collision with root package name */
    public final v f16239b;

    /* renamed from: c  reason: collision with root package name */
    public long f16240c;

    /* renamed from: d  reason: collision with root package name */
    public long f16241d;

    /* renamed from: e  reason: collision with root package name */
    public long f16242e;

    /* renamed from: f  reason: collision with root package name */
    public long f16243f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayDeque f16244g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16245h;

    /* renamed from: i  reason: collision with root package name */
    public final e0 f16246i;

    /* renamed from: j  reason: collision with root package name */
    public final d0 f16247j;

    /* renamed from: k  reason: collision with root package name */
    public final f0 f16248k = new f0(this);

    /* renamed from: l  reason: collision with root package name */
    public final f0 f16249l = new f0(this);

    /* renamed from: m  reason: collision with root package name */
    public c f16250m;

    /* renamed from: n  reason: collision with root package name */
    public IOException f16251n;

    static {
        new c0(0);
    }

    public g0(int i10, v vVar, boolean z10, boolean z11, p0 p0Var) {
        this.f16238a = i10;
        this.f16239b = vVar;
        this.f16243f = (long) vVar.f16329z.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f16244g = arrayDeque;
        this.f16246i = new e0(this, (long) vVar.f16328y.a(), z11);
        this.f16247j = new d0(this, z10);
        if (p0Var != null) {
            if (!h()) {
                arrayDeque.add(p0Var);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!h()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final void a() {
        boolean z10;
        boolean i10;
        p0 p0Var = h.f13493a;
        synchronized (this) {
            e0 e0Var = this.f16246i;
            if (!e0Var.f16214i && e0Var.f16218m) {
                d0 d0Var = this.f16247j;
                if (d0Var.f16200h || d0Var.f16202j) {
                    z10 = true;
                    i10 = i();
                    v vVar = v.f9814a;
                }
            }
            z10 = false;
            i10 = i();
            v vVar2 = v.f9814a;
        }
        if (z10) {
            c(c.CANCEL, (IOException) null);
        } else if (!i10) {
            this.f16239b.w(this.f16238a);
        }
    }

    public final void b() {
        d0 d0Var = this.f16247j;
        if (d0Var.f16202j) {
            throw new IOException("stream closed");
        } else if (d0Var.f16200h) {
            throw new IOException("stream finished");
        } else if (this.f16250m != null) {
            Throwable th = this.f16251n;
            if (th == null) {
                c cVar = this.f16250m;
                j.c(cVar);
                th = new q0(cVar);
            }
            throw th;
        }
    }

    public final void c(c cVar, IOException iOException) {
        if (d(cVar, iOException)) {
            v vVar = this.f16239b;
            vVar.getClass();
            vVar.F.N(this.f16238a, cVar);
        }
    }

    public final boolean d(c cVar, IOException iOException) {
        p0 p0Var = h.f13493a;
        synchronized (this) {
            if (this.f16250m != null) {
                return false;
            }
            if (this.f16246i.f16214i && this.f16247j.f16200h) {
                return false;
            }
            this.f16250m = cVar;
            this.f16251n = iOException;
            notifyAll();
            v vVar = v.f9814a;
            this.f16239b.w(this.f16238a);
            return true;
        }
    }

    public final void e(c cVar) {
        if (d(cVar, (IOException) null)) {
            this.f16239b.Y(this.f16238a, cVar);
        }
    }

    public final synchronized c f() {
        return this.f16250m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final wb.d0 g() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f16245h     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x000e
            boolean r0 = r2.h()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0017
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            wb.d0 r0 = r2.f16247j
            return r0
        L_0x0017:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.g0.g():wb.d0");
    }

    public final boolean h() {
        boolean z10;
        if ((this.f16238a & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f16239b.f16311h == z10) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0023, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean i() {
        /*
            r3 = this;
            monitor-enter(r3)
            wb.c r0 = r3.f16250m     // Catch:{ all -> 0x0025 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            wb.e0 r0 = r3.f16246i     // Catch:{ all -> 0x0025 }
            boolean r2 = r0.f16214i     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0012
            boolean r0 = r0.f16218m     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
        L_0x0012:
            wb.d0 r0 = r3.f16247j     // Catch:{ all -> 0x0025 }
            boolean r2 = r0.f16200h     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x001c
            boolean r0 = r0.f16202j     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
        L_0x001c:
            boolean r0 = r3.f16245h     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.g0.i():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(pb.p0 r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            xa.j.f(r0, r3)
            pb.p0 r0 = qb.h.f13493a
            monitor-enter(r2)
            boolean r0 = r2.f16245h     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = ":status"
            java.lang.String r0 = r3.a(r0)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = ":method"
            java.lang.String r0 = r3.a(r0)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            wb.e0 r0 = r2.f16246i     // Catch:{ all -> 0x0044 }
            r0.f16217l = r3     // Catch:{ all -> 0x0044 }
            goto L_0x002a
        L_0x0023:
            r2.f16245h = r1     // Catch:{ all -> 0x0044 }
            java.util.ArrayDeque r0 = r2.f16244g     // Catch:{ all -> 0x0044 }
            r0.add(r3)     // Catch:{ all -> 0x0044 }
        L_0x002a:
            if (r4 == 0) goto L_0x0030
            wb.e0 r3 = r2.f16246i     // Catch:{ all -> 0x0044 }
            r3.f16214i = r1     // Catch:{ all -> 0x0044 }
        L_0x0030:
            boolean r3 = r2.i()     // Catch:{ all -> 0x0044 }
            r2.notifyAll()     // Catch:{ all -> 0x0044 }
            la.v r4 = la.v.f9814a     // Catch:{ all -> 0x0044 }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x0043
            wb.v r3 = r2.f16239b
            int r4 = r2.f16238a
            r3.w(r4)
        L_0x0043:
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.g0.j(pb.p0, boolean):void");
    }

    public final synchronized void k(c cVar) {
        if (this.f16250m == null) {
            this.f16250m = cVar;
            notifyAll();
        }
    }

    public final void l() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
