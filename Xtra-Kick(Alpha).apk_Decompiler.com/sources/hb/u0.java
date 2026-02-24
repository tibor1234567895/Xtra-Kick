package hb;

import h3.u1;
import la.v;
import mb.g0;

public abstract class u0 implements Runnable, Comparable, q0 {
    private volatile Object _heap;

    /* renamed from: h  reason: collision with root package name */
    public long f7857h;

    /* renamed from: i  reason: collision with root package name */
    public int f7858i = -1;

    public u0(long j10) {
        this.f7857h = j10;
    }

    public final void a() {
        v0 v0Var;
        synchronized (this) {
            Object obj = this._heap;
            u1 u1Var = y0.f7882a;
            if (obj != u1Var) {
                if (obj instanceof v0) {
                    v0Var = (v0) obj;
                } else {
                    v0Var = null;
                }
                if (v0Var != null) {
                    v0Var.d(this);
                }
                this._heap = u1Var;
                v vVar = v.f9814a;
            }
        }
    }

    public final g0 b() {
        Object obj = this._heap;
        if (obj instanceof g0) {
            return (g0) obj;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0035, code lost:
        if ((r9 - r11.f7866c) > 0) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(long r9, hb.v0 r11, hb.w0 r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Object r0 = r8._heap     // Catch:{ all -> 0x004c }
            h3.u1 r1 = hb.y0.f7882a     // Catch:{ all -> 0x004c }
            if (r0 != r1) goto L_0x000a
            monitor-exit(r8)
            r9 = 2
            return r9
        L_0x000a:
            monitor-enter(r11)     // Catch:{ all -> 0x004c }
            hb.u0[] r0 = r11.f10855a     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r0 = r0[r1]     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r9 = move-exception
            goto L_0x004a
        L_0x0015:
            r0 = 0
        L_0x0016:
            boolean r12 = hb.w0.Y0(r12)     // Catch:{ all -> 0x0013 }
            if (r12 == 0) goto L_0x0020
            monitor-exit(r11)     // Catch:{ all -> 0x004c }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x0020:
            r2 = 0
            if (r0 != 0) goto L_0x0025
            goto L_0x0037
        L_0x0025:
            long r4 = r0.f7857h     // Catch:{ all -> 0x0013 }
            long r6 = r4 - r9
            int r12 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r9 = r4
        L_0x002f:
            long r4 = r11.f7866c     // Catch:{ all -> 0x0013 }
            long r4 = r9 - r4
            int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x0039
        L_0x0037:
            r11.f7866c = r9     // Catch:{ all -> 0x0013 }
        L_0x0039:
            long r9 = r8.f7857h     // Catch:{ all -> 0x0013 }
            long r4 = r11.f7866c     // Catch:{ all -> 0x0013 }
            long r9 = r9 - r4
            int r12 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0044
            r8.f7857h = r4     // Catch:{ all -> 0x0013 }
        L_0x0044:
            r11.a(r8)     // Catch:{ all -> 0x0013 }
            monitor-exit(r11)     // Catch:{ all -> 0x004c }
            monitor-exit(r8)
            return r1
        L_0x004a:
            monitor-exit(r11)     // Catch:{ all -> 0x004c }
            throw r9     // Catch:{ all -> 0x004c }
        L_0x004c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.u0.c(long, hb.v0, hb.w0):int");
    }

    public final int compareTo(Object obj) {
        int i10 = ((this.f7857h - ((u0) obj).f7857h) > 0 ? 1 : ((this.f7857h - ((u0) obj).f7857h) == 0 ? 0 : -1));
        if (i10 > 0) {
            return 1;
        }
        if (i10 < 0) {
            return -1;
        }
        return 0;
    }

    public final void e(v0 v0Var) {
        boolean z10;
        if (this._heap != y0.f7882a) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this._heap = v0Var;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public String toString() {
        return "Delayed[nanos=" + this.f7857h + ']';
    }
}
