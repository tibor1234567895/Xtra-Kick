package w4;

import t4.a;
import t4.c;
import t4.g;

public final class l implements i {
    static {
        new k(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r9 = this;
            w4.h r0 = w4.h.f16086a
            monitor-enter(r0)
            int r1 = w4.h.f16088c     // Catch:{ all -> 0x0041 }
            int r2 = r1 + 1
            w4.h.f16088c = r2     // Catch:{ all -> 0x0041 }
            r2 = 30
            r3 = 0
            r4 = 1
            if (r1 >= r2) goto L_0x0020
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0041 }
            long r5 = w4.h.f16089d     // Catch:{ all -> 0x0041 }
            r7 = 30000(0x7530, float:4.2039E-41)
            long r7 = (long) r7     // Catch:{ all -> 0x0041 }
            long r5 = r5 + r7
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r1 = 0
            goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            if (r1 == 0) goto L_0x003d
            w4.h.f16088c = r3     // Catch:{ all -> 0x0041 }
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0041 }
            w4.h.f16089d = r1     // Catch:{ all -> 0x0041 }
            java.io.File r1 = w4.h.f16087b     // Catch:{ all -> 0x0041 }
            java.lang.String[] r1 = r1.list()     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0035
            java.lang.String[] r1 = new java.lang.String[r3]     // Catch:{ all -> 0x0041 }
        L_0x0035:
            int r1 = r1.length     // Catch:{ all -> 0x0041 }
            r2 = 800(0x320, float:1.121E-42)
            if (r1 >= r2) goto L_0x003b
            r3 = 1
        L_0x003b:
            w4.h.f16090e = r3     // Catch:{ all -> 0x0041 }
        L_0x003d:
            boolean r1 = w4.h.f16090e     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)
            return r1
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l.a():boolean");
    }

    public final boolean b(g gVar) {
        int i10;
        c cVar = gVar.f14548a;
        int i11 = Integer.MAX_VALUE;
        if (cVar instanceof a) {
            i10 = ((a) cVar).f14542a;
        } else {
            i10 = Integer.MAX_VALUE;
        }
        if (i10 > 100) {
            c cVar2 = gVar.f14549b;
            if (cVar2 instanceof a) {
                i11 = ((a) cVar2).f14542a;
            }
            if (i11 > 100) {
                return true;
            }
        }
        return false;
    }
}
