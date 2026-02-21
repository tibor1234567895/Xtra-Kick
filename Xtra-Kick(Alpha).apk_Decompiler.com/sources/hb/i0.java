package hb;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class i0 extends w0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: q  reason: collision with root package name */
    public static final i0 f7808q;

    /* renamed from: r  reason: collision with root package name */
    public static final long f7809r;

    static {
        Long l10;
        i0 i0Var = new i0();
        f7808q = i0Var;
        i0Var.S0(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f7809r = timeUnit.toNanos(l10.longValue());
    }

    private i0() {
    }

    public final Thread W0() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final void X0(long j10, u0 u0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final void Z0(Runnable runnable) {
        boolean z10;
        if (debugStatus == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            super.Z0(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void d1() {
        boolean z10;
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            debugStatus = 3;
            w0.f7876n.set(this, (Object) null);
            w0.f7877o.set(this, (Object) null);
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0096, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x009b, code lost:
        _thread = null;
        d1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a4, code lost:
        if (b1() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a6, code lost:
        W0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a9, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            hb.f2 r0 = hb.f2.f7793a
            r0.getClass()
            java.lang.ThreadLocal r0 = hb.f2.f7794b
            r0.set(r1)
            r2 = 0
            monitor-enter(r17)     // Catch:{ all -> 0x0096 }
            int r0 = debugStatus     // Catch:{ all -> 0x0098 }
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r0 == r4) goto L_0x001b
            if (r0 != r3) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            monitor-exit(r17)     // Catch:{ all -> 0x0096 }
            r0 = 0
            goto L_0x0028
        L_0x0021:
            debugStatus = r6     // Catch:{ all -> 0x0098 }
            r17.notifyAll()     // Catch:{ all -> 0x0098 }
            monitor-exit(r17)     // Catch:{ all -> 0x0096 }
            r0 = 1
        L_0x0028:
            if (r0 != 0) goto L_0x0039
            _thread = r2
            r17.d1()
            boolean r0 = r17.b1()
            if (r0 != 0) goto L_0x0038
            r17.W0()
        L_0x0038:
            return
        L_0x0039:
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = r7
        L_0x003f:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0096 }
            long r11 = r17.U0()     // Catch:{ all -> 0x0096 }
            r13 = 0
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0072
            long r15 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0096 }
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0057
            long r9 = f7809r     // Catch:{ all -> 0x0096 }
            long r9 = r9 + r15
        L_0x0057:
            long r15 = r9 - r15
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x006c
            _thread = r2
            r17.d1()
            boolean r0 = r17.b1()
            if (r0 != 0) goto L_0x006b
            r17.W0()
        L_0x006b:
            return
        L_0x006c:
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x0073
            r11 = r15
            goto L_0x0073
        L_0x0072:
            r9 = r7
        L_0x0073:
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x003f
            int r0 = debugStatus     // Catch:{ all -> 0x0096 }
            if (r0 == r4) goto L_0x0080
            if (r0 != r3) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r0 = 0
            goto L_0x0081
        L_0x0080:
            r0 = 1
        L_0x0081:
            if (r0 == 0) goto L_0x0092
            _thread = r2
            r17.d1()
            boolean r0 = r17.b1()
            if (r0 != 0) goto L_0x0091
            r17.W0()
        L_0x0091:
            return
        L_0x0092:
            java.util.concurrent.locks.LockSupport.parkNanos(r1, r11)     // Catch:{ all -> 0x0096 }
            goto L_0x003f
        L_0x0096:
            r0 = move-exception
            goto L_0x009b
        L_0x0098:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0096 }
            throw r0     // Catch:{ all -> 0x0096 }
        L_0x009b:
            _thread = r2
            r17.d1()
            boolean r2 = r17.b1()
            if (r2 != 0) goto L_0x00a9
            r17.W0()
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.i0.run():void");
    }

    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
