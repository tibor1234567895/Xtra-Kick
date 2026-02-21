package wb;

import dc.j;
import dc.p0;
import dc.s0;
import la.v;
import qb.h;

public final class e0 implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final long f16213h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16214i;

    /* renamed from: j  reason: collision with root package name */
    public final j f16215j = new j();

    /* renamed from: k  reason: collision with root package name */
    public final j f16216k = new j();

    /* renamed from: l  reason: collision with root package name */
    public pb.p0 f16217l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f16218m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ g0 f16219n;

    public e0(g0 g0Var, long j10, boolean z10) {
        this.f16219n = g0Var;
        this.f16213h = j10;
        this.f16214i = z10;
    }

    public final void close() {
        long j10;
        g0 g0Var = this.f16219n;
        synchronized (g0Var) {
            this.f16218m = true;
            j jVar = this.f16216k;
            j10 = jVar.f4787i;
            jVar.c();
            g0Var.notifyAll();
            v vVar = v.f9814a;
        }
        if (j10 > 0) {
            pb.p0 p0Var = h.f13493a;
            this.f16219n.f16239b.N(j10);
        }
        this.f16219n.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[SYNTHETIC, Splitter:B:45:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7 A[SYNTHETIC, Splitter:B:58:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(dc.j r13, long r14) {
        /*
            r12 = this;
            java.lang.String r0 = "sink"
            xa.j.f(r0, r13)
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x000d
            r2 = 1
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 == 0) goto L_0x00cb
        L_0x0010:
            wb.g0 r2 = r12.f16219n
            monitor-enter(r2)
            wb.v r3 = r2.f16239b     // Catch:{ all -> 0x00c8 }
            boolean r3 = r3.f16311h     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x0026
            wb.d0 r3 = r2.f16247j     // Catch:{ all -> 0x00c8 }
            boolean r4 = r3.f16202j     // Catch:{ all -> 0x00c8 }
            if (r4 != 0) goto L_0x0026
            boolean r3 = r3.f16200h     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r3 = 0
            goto L_0x0027
        L_0x0026:
            r3 = 1
        L_0x0027:
            if (r3 == 0) goto L_0x002e
            wb.f0 r4 = r2.f16248k     // Catch:{ all -> 0x00c8 }
            r4.i()     // Catch:{ all -> 0x00c8 }
        L_0x002e:
            wb.c r4 = r2.f()     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0049
            boolean r4 = r12.f16214i     // Catch:{ all -> 0x00bf }
            if (r4 != 0) goto L_0x0049
            java.io.IOException r4 = r2.f16251n     // Catch:{ all -> 0x00bf }
            if (r4 != 0) goto L_0x004a
            wb.q0 r4 = new wb.q0     // Catch:{ all -> 0x00bf }
            wb.c r5 = r2.f()     // Catch:{ all -> 0x00bf }
            xa.j.c(r5)     // Catch:{ all -> 0x00bf }
            r4.<init>(r5)     // Catch:{ all -> 0x00bf }
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            boolean r5 = r12.f16218m     // Catch:{ all -> 0x00bf }
            if (r5 != 0) goto L_0x00b7
            dc.j r5 = r12.f16216k     // Catch:{ all -> 0x00bf }
            long r6 = r5.f4787i     // Catch:{ all -> 0x00bf }
            r8 = -1
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x0085
            long r0 = java.lang.Math.min(r14, r6)     // Catch:{ all -> 0x00bf }
            long r0 = r5.read(r13, r0)     // Catch:{ all -> 0x00bf }
            long r5 = r2.f16240c     // Catch:{ all -> 0x00bf }
            long r5 = r5 + r0
            r2.f16240c = r5     // Catch:{ all -> 0x00bf }
            long r10 = r2.f16241d     // Catch:{ all -> 0x00bf }
            long r5 = r5 - r10
            if (r4 != 0) goto L_0x0092
            wb.v r7 = r2.f16239b     // Catch:{ all -> 0x00bf }
            wb.p0 r7 = r7.f16328y     // Catch:{ all -> 0x00bf }
            int r7 = r7.a()     // Catch:{ all -> 0x00bf }
            int r7 = r7 / 2
            long r10 = (long) r7     // Catch:{ all -> 0x00bf }
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x0092
            wb.v r7 = r2.f16239b     // Catch:{ all -> 0x00bf }
            int r10 = r2.f16238a     // Catch:{ all -> 0x00bf }
            r7.Z(r10, r5)     // Catch:{ all -> 0x00bf }
            long r5 = r2.f16240c     // Catch:{ all -> 0x00bf }
            r2.f16241d = r5     // Catch:{ all -> 0x00bf }
            goto L_0x0092
        L_0x0085:
            boolean r0 = r12.f16214i     // Catch:{ all -> 0x00bf }
            if (r0 != 0) goto L_0x0091
            if (r4 != 0) goto L_0x0091
            r2.l()     // Catch:{ all -> 0x00bf }
            r0 = 1
            r5 = r8
            goto L_0x0095
        L_0x0091:
            r0 = r8
        L_0x0092:
            r5 = 0
            r5 = r0
            r0 = 0
        L_0x0095:
            if (r3 == 0) goto L_0x009c
            wb.f0 r1 = r2.f16248k     // Catch:{ all -> 0x00c8 }
            r1.m()     // Catch:{ all -> 0x00c8 }
        L_0x009c:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x00c8 }
            monitor-exit(r2)
            if (r0 == 0) goto L_0x00a5
            r0 = 0
            goto L_0x0010
        L_0x00a5:
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x00b3
            pb.p0 r13 = qb.h.f13493a
            wb.g0 r13 = r12.f16219n
            wb.v r13 = r13.f16239b
            r13.N(r5)
            return r5
        L_0x00b3:
            if (r4 != 0) goto L_0x00b6
            return r8
        L_0x00b6:
            throw r4
        L_0x00b7:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x00bf }
            java.lang.String r14 = "stream closed"
            r13.<init>(r14)     // Catch:{ all -> 0x00bf }
            throw r13     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r13 = move-exception
            if (r3 == 0) goto L_0x00c7
            wb.f0 r14 = r2.f16248k     // Catch:{ all -> 0x00c8 }
            r14.m()     // Catch:{ all -> 0x00c8 }
        L_0x00c7:
            throw r13     // Catch:{ all -> 0x00c8 }
        L_0x00c8:
            r13 = move-exception
            monitor-exit(r2)
            throw r13
        L_0x00cb:
            java.lang.String r13 = "byteCount < 0: "
            java.lang.String r13 = android.support.v4.media.h.k(r13, r14)
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.e0.read(dc.j, long):long");
    }

    public final s0 timeout() {
        return this.f16219n.f16248k;
    }
}
