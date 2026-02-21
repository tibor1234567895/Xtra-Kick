package m1;

import android.os.Looper;
import g1.u1;
import j1.a;
import j1.d;
import j1.v;

public final class m1 {

    /* renamed from: a  reason: collision with root package name */
    public final l1 f10351a;

    /* renamed from: b  reason: collision with root package name */
    public final u0 f10352b;

    /* renamed from: c  reason: collision with root package name */
    public final d f10353c;

    /* renamed from: d  reason: collision with root package name */
    public int f10354d;

    /* renamed from: e  reason: collision with root package name */
    public Object f10355e;

    /* renamed from: f  reason: collision with root package name */
    public final Looper f10356f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10357g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10358h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10359i;

    public m1(u0 u0Var, l1 l1Var, u1 u1Var, int i10, d dVar, Looper looper) {
        this.f10352b = u0Var;
        this.f10351a = l1Var;
        this.f10356f = looper;
        this.f10353c = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[SYNTHETIC, Splitter:B:16:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f10357g     // Catch:{ all -> 0x0050 }
            j1.a.e(r0)     // Catch:{ all -> 0x0050 }
            android.os.Looper r0 = r6.f10356f     // Catch:{ all -> 0x0050 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0050 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0050 }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            j1.a.e(r0)     // Catch:{ all -> 0x0050 }
            j1.d r0 = r6.f10353c     // Catch:{ all -> 0x0050 }
            j1.d0 r0 = (j1.d0) r0     // Catch:{ all -> 0x0050 }
            r0.getClass()     // Catch:{ all -> 0x0050 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0050 }
            long r0 = r0 + r7
        L_0x0024:
            boolean r2 = r6.f10359i     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x0044
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0044
            j1.d r2 = r6.f10353c     // Catch:{ all -> 0x0050 }
            r2.getClass()     // Catch:{ all -> 0x0050 }
            r6.wait(r7)     // Catch:{ all -> 0x0050 }
            j1.d r7 = r6.f10353c     // Catch:{ all -> 0x0050 }
            j1.d0 r7 = (j1.d0) r7     // Catch:{ all -> 0x0050 }
            r7.getClass()     // Catch:{ all -> 0x0050 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0050 }
            long r7 = r0 - r7
            goto L_0x0024
        L_0x0044:
            if (r2 == 0) goto L_0x0048
            monitor-exit(r6)
            return
        L_0x0048:
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0050 }
            java.lang.String r8 = "Message delivery timed out."
            r7.<init>(r8)     // Catch:{ all -> 0x0050 }
            throw r7     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.m1.a(long):void");
    }

    public final synchronized void b(boolean z10) {
        this.f10358h = z10 | this.f10358h;
        this.f10359i = true;
        notifyAll();
    }

    public final void c() {
        a.e(!this.f10357g);
        this.f10357g = true;
        u0 u0Var = this.f10352b;
        synchronized (u0Var) {
            if (!u0Var.G) {
                if (u0Var.f10508q.getThread().isAlive()) {
                    u0Var.f10506o.a(14, this).a();
                }
            }
            v.g("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            b(false);
        }
    }
}
