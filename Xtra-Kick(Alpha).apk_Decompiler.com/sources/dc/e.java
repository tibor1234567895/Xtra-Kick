package dc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import xa.j;

public class e extends s0 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f4752h = new a(0);

    /* renamed from: i  reason: collision with root package name */
    public static final ReentrantLock f4753i;

    /* renamed from: j  reason: collision with root package name */
    public static final Condition f4754j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f4755k;

    /* renamed from: l  reason: collision with root package name */
    public static final long f4756l;

    /* renamed from: m  reason: collision with root package name */
    public static e f4757m;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4758e;

    /* renamed from: f  reason: collision with root package name */
    public e f4759f;

    /* renamed from: g  reason: collision with root package name */
    public long f4760g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f4753i = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        j.e("lock.newCondition()", newCondition);
        f4754j = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60);
        f4755k = millis;
        f4756l = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0064 A[EDGE_INSN: B:40:0x0064->B:26:0x0064 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r10 = this;
            long r0 = r10.f4824c
            boolean r2 = r10.f4822a
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x000d
            if (r2 != 0) goto L_0x000d
            return
        L_0x000d:
            dc.a r3 = f4752h
            r3.getClass()
            java.util.concurrent.locks.ReentrantLock r3 = f4753i
            r3.lock()
            boolean r4 = r10.f4758e     // Catch:{ all -> 0x0089 }
            r6 = 1
            r4 = r4 ^ r6
            if (r4 == 0) goto L_0x007d
            r10.f4758e = r6     // Catch:{ all -> 0x0089 }
            dc.e r4 = f4757m     // Catch:{ all -> 0x0089 }
            if (r4 != 0) goto L_0x0032
            dc.e r4 = new dc.e     // Catch:{ all -> 0x0089 }
            r4.<init>()     // Catch:{ all -> 0x0089 }
            f4757m = r4     // Catch:{ all -> 0x0089 }
            dc.b r4 = new dc.b     // Catch:{ all -> 0x0089 }
            r4.<init>()     // Catch:{ all -> 0x0089 }
            r4.start()     // Catch:{ all -> 0x0089 }
        L_0x0032:
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0044
            if (r2 == 0) goto L_0x0044
            long r4 = r10.c()     // Catch:{ all -> 0x0089 }
            long r4 = r4 - r6
            long r0 = java.lang.Math.min(r0, r4)     // Catch:{ all -> 0x0089 }
            goto L_0x0046
        L_0x0044:
            if (r5 == 0) goto L_0x0048
        L_0x0046:
            long r0 = r0 + r6
            goto L_0x004e
        L_0x0048:
            if (r2 == 0) goto L_0x0077
            long r0 = r10.c()     // Catch:{ all -> 0x0089 }
        L_0x004e:
            r10.f4760g = r0     // Catch:{ all -> 0x0089 }
            long r0 = r0 - r6
            dc.e r2 = f4757m     // Catch:{ all -> 0x0089 }
        L_0x0053:
            xa.j.c(r2)     // Catch:{ all -> 0x0089 }
            dc.e r4 = r2.f4759f     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0064
            long r8 = r4.f4760g     // Catch:{ all -> 0x0089 }
            long r8 = r8 - r6
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r2 = r4
            goto L_0x0053
        L_0x0064:
            r10.f4759f = r4     // Catch:{ all -> 0x0089 }
            r2.f4759f = r10     // Catch:{ all -> 0x0089 }
            dc.e r0 = f4757m     // Catch:{ all -> 0x0089 }
            if (r2 != r0) goto L_0x0071
            java.util.concurrent.locks.Condition r0 = f4754j     // Catch:{ all -> 0x0089 }
            r0.signal()     // Catch:{ all -> 0x0089 }
        L_0x0071:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x0089 }
            r3.unlock()
            return
        L_0x0077:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x0089 }
            r0.<init>()     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x007d:
            java.lang.String r0 = "Unbalanced enter/exit"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0089 }
            r1.<init>(r0)     // Catch:{ all -> 0x0089 }
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r0 = move-exception
            r3.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.e.i():void");
    }

    public final boolean j() {
        a aVar = f4752h;
        aVar.getClass();
        aVar.getClass();
        ReentrantLock reentrantLock = f4753i;
        reentrantLock.lock();
        try {
            if (this.f4758e) {
                this.f4758e = false;
                e eVar = f4757m;
                while (eVar != null) {
                    e eVar2 = eVar.f4759f;
                    if (eVar2 == this) {
                        eVar.f4759f = this.f4759f;
                        this.f4759f = null;
                    } else {
                        eVar = eVar2;
                    }
                }
                reentrantLock.unlock();
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void l() {
    }
}
