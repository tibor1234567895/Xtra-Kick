package dc;

import java.util.concurrent.locks.ReentrantLock;
import la.v;
import xa.j;

public final class o implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public final y f4807h;

    /* renamed from: i  reason: collision with root package name */
    public long f4808i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4809j;

    public o(y yVar, long j10) {
        j.f("fileHandle", yVar);
        this.f4807h = yVar;
        this.f4808i = j10;
    }

    public final void close() {
        if (!this.f4809j) {
            this.f4809j = true;
            y yVar = this.f4807h;
            ReentrantLock reentrantLock = yVar.f4849j;
            reentrantLock.lock();
            try {
                int i10 = yVar.f4848i - 1;
                yVar.f4848i = i10;
                if (i10 == 0) {
                    if (yVar.f4847h) {
                        v vVar = v.f9814a;
                        reentrantLock.unlock();
                        synchronized (yVar) {
                            yVar.f4850k.close();
                        }
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        r2 = r8 - r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(dc.j r17, long r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r4 = "sink"
            xa.j.f(r4, r0)
            boolean r4 = r1.f4809j
            r5 = 1
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x00a4
            dc.y r4 = r1.f4807h
            long r6 = r1.f4808i
            r4.getClass()
            r8 = 0
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0020
            r8 = 1
            goto L_0x0021
        L_0x0020:
            r8 = 0
        L_0x0021:
            if (r8 == 0) goto L_0x0094
            long r2 = r2 + r6
            r8 = r6
        L_0x0025:
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0086
            dc.k0 r5 = r0.M0(r5)
            byte[] r10 = r5.f4788a
            int r11 = r5.f4790c
            long r12 = r2 - r8
            int r14 = 8192 - r11
            long r14 = (long) r14
            long r12 = java.lang.Math.min(r12, r14)
            int r13 = (int) r12
            monitor-enter(r4)
            java.lang.String r12 = "array"
            xa.j.f(r12, r10)     // Catch:{ all -> 0x0083 }
            java.io.RandomAccessFile r12 = r4.f4850k     // Catch:{ all -> 0x0083 }
            r12.seek(r8)     // Catch:{ all -> 0x0083 }
            r12 = 0
        L_0x0047:
            if (r12 >= r13) goto L_0x005b
            java.io.RandomAccessFile r15 = r4.f4850k     // Catch:{ all -> 0x0083 }
            int r14 = r13 - r12
            int r14 = r15.read(r10, r11, r14)     // Catch:{ all -> 0x0083 }
            r15 = -1
            if (r14 != r15) goto L_0x0059
            if (r12 != 0) goto L_0x005b
            monitor-exit(r4)
            r12 = -1
            goto L_0x005c
        L_0x0059:
            int r12 = r12 + r14
            goto L_0x0047
        L_0x005b:
            monitor-exit(r4)
        L_0x005c:
            r10 = -1
            if (r12 != r10) goto L_0x0075
            int r2 = r5.f4789b
            int r3 = r5.f4790c
            if (r2 != r3) goto L_0x006e
            dc.k0 r2 = r5.a()
            r0.f4786h = r2
            dc.l0.a(r5)
        L_0x006e:
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0086
            r2 = -1
            goto L_0x0088
        L_0x0075:
            int r10 = r5.f4790c
            int r10 = r10 + r12
            r5.f4790c = r10
            long r10 = (long) r12
            long r8 = r8 + r10
            long r12 = r0.f4787i
            long r12 = r12 + r10
            r0.f4787i = r12
            r5 = 1
            goto L_0x0025
        L_0x0083:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0086:
            long r2 = r8 - r6
        L_0x0088:
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            long r4 = r1.f4808i
            long r4 = r4 + r2
            r1.f4808i = r4
        L_0x0093:
            return r2
        L_0x0094:
            java.lang.String r0 = "byteCount < 0: "
            java.lang.String r0 = android.support.v4.media.h.k(r0, r2)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x00a4:
            java.lang.String r0 = "closed"
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.o.read(dc.j, long):long");
    }

    public final s0 timeout() {
        return s0.f4821d;
    }
}
