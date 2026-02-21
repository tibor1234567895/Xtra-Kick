package dc;

public final class b extends Thread {
    public b() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|(5:5|6|7|19|8)(5:9|10|11|12|(2:14|23)(1:22))|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:18:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
        L_0x0000:
            dc.a r0 = dc.e.f4752h     // Catch:{ InterruptedException -> 0x0000 }
            r0.getClass()     // Catch:{ InterruptedException -> 0x0000 }
            java.util.concurrent.locks.ReentrantLock r0 = dc.e.f4753i     // Catch:{ InterruptedException -> 0x0000 }
            r0.lock()     // Catch:{ InterruptedException -> 0x0000 }
            dc.e r1 = dc.a.a()     // Catch:{ all -> 0x0024 }
            dc.e r2 = dc.e.f4757m     // Catch:{ all -> 0x0024 }
            if (r1 != r2) goto L_0x0019
            r1 = 0
            dc.e.f4757m = r1     // Catch:{ all -> 0x0024 }
            r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
            return
        L_0x0019:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x0024 }
            r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
            if (r1 == 0) goto L_0x0000
            r1.l()     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000
        L_0x0024:
            r1 = move-exception
            r0.unlock()     // Catch:{ InterruptedException -> 0x0000 }
            throw r1     // Catch:{ InterruptedException -> 0x0000 }
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.b.run():void");
    }
}
