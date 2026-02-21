package k1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public abstract class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8973a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f8974b = new ArrayList(1);

    /* renamed from: c  reason: collision with root package name */
    public int f8975c;

    /* renamed from: d  reason: collision with root package name */
    public m f8976d;

    public c(boolean z10) {
        this.f8973a = z10;
    }

    public Map e() {
        return Collections.emptyMap();
    }

    public final void i(f0 f0Var) {
        f0Var.getClass();
        ArrayList arrayList = this.f8974b;
        if (!arrayList.contains(f0Var)) {
            arrayList.add(f0Var);
            this.f8975c++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(int r9) {
        /*
            r8 = this;
            k1.m r0 = r8.f8976d
            int r1 = j1.l0.f8453a
            r1 = 0
            r2 = 0
        L_0x0006:
            int r3 = r8.f8975c
            if (r2 >= r3) goto L_0x003a
            java.util.ArrayList r3 = r8.f8974b
            java.lang.Object r3 = r3.get(r2)
            k1.f0 r3 = (k1.f0) r3
            boolean r4 = r8.f8973a
            a2.h r3 = (a2.h) r3
            monitor-enter(r3)
            d9.r1 r5 = a2.h.f34n     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0029
            int r4 = r0.f9030i     // Catch:{ all -> 0x0037 }
            r5 = 8
            r4 = r4 & r5
            r6 = 1
            if (r4 != r5) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r4 != 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            if (r6 != 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            long r4 = r3.f48h     // Catch:{ all -> 0x0037 }
            long r6 = (long) r9     // Catch:{ all -> 0x0037 }
            long r4 = r4 + r6
            r3.f48h = r4     // Catch:{ all -> 0x0037 }
        L_0x0033:
            monitor-exit(r3)
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0037:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.c.r(int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s() {
        /*
            r14 = this;
            k1.m r0 = r14.f8976d
            int r1 = j1.l0.f8453a
            r1 = 0
            r2 = 0
        L_0x0006:
            int r3 = r14.f8975c
            if (r2 >= r3) goto L_0x009e
            java.util.ArrayList r3 = r14.f8974b
            java.lang.Object r3 = r3.get(r2)
            k1.f0 r3 = (k1.f0) r3
            boolean r4 = r14.f8973a
            a2.h r3 = (a2.h) r3
            monitor-enter(r3)
            d9.r1 r5 = a2.h.f34n     // Catch:{ all -> 0x009b }
            r11 = 1
            if (r4 == 0) goto L_0x002a
            int r4 = r0.f9030i     // Catch:{ all -> 0x009b }
            r5 = 8
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r4 != 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 != 0) goto L_0x002e
            goto L_0x0096
        L_0x002e:
            int r4 = r3.f46f     // Catch:{ all -> 0x009b }
            if (r4 <= 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = 0
        L_0x0035:
            j1.a.e(r4)     // Catch:{ all -> 0x009b }
            j1.d r4 = r3.f44d     // Catch:{ all -> 0x009b }
            j1.d0 r4 = (j1.d0) r4     // Catch:{ all -> 0x009b }
            r4.getClass()     // Catch:{ all -> 0x009b }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x009b }
            long r4 = r3.f47g     // Catch:{ all -> 0x009b }
            long r4 = r12 - r4
            int r6 = (int) r4     // Catch:{ all -> 0x009b }
            long r4 = r3.f50j     // Catch:{ all -> 0x009b }
            long r7 = (long) r6     // Catch:{ all -> 0x009b }
            long r4 = r4 + r7
            r3.f50j = r4     // Catch:{ all -> 0x009b }
            long r4 = r3.f51k     // Catch:{ all -> 0x009b }
            long r7 = r3.f48h     // Catch:{ all -> 0x009b }
            long r4 = r4 + r7
            r3.f51k = r4     // Catch:{ all -> 0x009b }
            if (r6 <= 0) goto L_0x0091
            float r4 = (float) r7     // Catch:{ all -> 0x009b }
            r5 = 1174011904(0x45fa0000, float:8000.0)
            float r4 = r4 * r5
            float r5 = (float) r6     // Catch:{ all -> 0x009b }
            float r4 = r4 / r5
            a2.u r5 = r3.f43c     // Catch:{ all -> 0x009b }
            double r7 = (double) r7     // Catch:{ all -> 0x009b }
            double r7 = java.lang.Math.sqrt(r7)     // Catch:{ all -> 0x009b }
            int r7 = (int) r7     // Catch:{ all -> 0x009b }
            r5.a(r7, r4)     // Catch:{ all -> 0x009b }
            long r4 = r3.f50j     // Catch:{ all -> 0x009b }
            r7 = 2000(0x7d0, double:9.88E-321)
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x007a
            long r4 = r3.f51k     // Catch:{ all -> 0x009b }
            r7 = 524288(0x80000, double:2.590327E-318)
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x0083
        L_0x007a:
            a2.u r4 = r3.f43c     // Catch:{ all -> 0x009b }
            float r4 = r4.b()     // Catch:{ all -> 0x009b }
            long r4 = (long) r4     // Catch:{ all -> 0x009b }
            r3.f52l = r4     // Catch:{ all -> 0x009b }
        L_0x0083:
            long r7 = r3.f48h     // Catch:{ all -> 0x009b }
            long r9 = r3.f52l     // Catch:{ all -> 0x009b }
            r5 = r3
            r5.c(r6, r7, r9)     // Catch:{ all -> 0x009b }
            r3.f47g = r12     // Catch:{ all -> 0x009b }
            r4 = 0
            r3.f48h = r4     // Catch:{ all -> 0x009b }
        L_0x0091:
            int r4 = r3.f46f     // Catch:{ all -> 0x009b }
            int r4 = r4 - r11
            r3.f46f = r4     // Catch:{ all -> 0x009b }
        L_0x0096:
            monitor-exit(r3)
            int r2 = r2 + 1
            goto L_0x0006
        L_0x009b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x009e:
            r0 = 0
            r14.f8976d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.c.s():void");
    }

    public final void t() {
        for (int i10 = 0; i10 < this.f8975c; i10++) {
            ((f0) this.f8974b.get(i10)).getClass();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(k1.m r8) {
        /*
            r7 = this;
            r7.f8976d = r8
            r0 = 0
            r1 = 0
        L_0x0004:
            int r2 = r7.f8975c
            if (r1 >= r2) goto L_0x0049
            java.util.ArrayList r2 = r7.f8974b
            java.lang.Object r2 = r2.get(r1)
            k1.f0 r2 = (k1.f0) r2
            boolean r3 = r7.f8973a
            a2.h r2 = (a2.h) r2
            monitor-enter(r2)
            d9.r1 r4 = a2.h.f34n     // Catch:{ all -> 0x0046 }
            r4 = 1
            if (r3 == 0) goto L_0x0028
            int r3 = r8.f9030i     // Catch:{ all -> 0x0046 }
            r5 = 8
            r3 = r3 & r5
            if (r3 != r5) goto L_0x0023
            r3 = 1
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            if (r3 != 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            goto L_0x0042
        L_0x002c:
            int r3 = r2.f46f     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x003d
            j1.d r3 = r2.f44d     // Catch:{ all -> 0x0046 }
            j1.d0 r3 = (j1.d0) r3     // Catch:{ all -> 0x0046 }
            r3.getClass()     // Catch:{ all -> 0x0046 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0046 }
            r2.f47g = r5     // Catch:{ all -> 0x0046 }
        L_0x003d:
            int r3 = r2.f46f     // Catch:{ all -> 0x0046 }
            int r3 = r3 + r4
            r2.f46f = r3     // Catch:{ all -> 0x0046 }
        L_0x0042:
            monitor-exit(r2)
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0046:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.c.u(k1.m):void");
    }
}
