package w5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f16118a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public final long f16119b;

    /* renamed from: c  reason: collision with root package name */
    public long f16120c;

    public k(long j10) {
        this.f16119b = j10;
    }

    public final synchronized Object a(Object obj) {
        j jVar;
        jVar = (j) this.f16118a.get(obj);
        return jVar != null ? jVar.f16116a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public void c(Object obj, Object obj2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Object d(java.lang.Object r8, java.lang.Object r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.b(r9)     // Catch:{ all -> 0x004c }
            long r1 = (long) r0     // Catch:{ all -> 0x004c }
            long r3 = r7.f16119b     // Catch:{ all -> 0x004c }
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x0012
            r7.c(r8, r9)     // Catch:{ all -> 0x004c }
            monitor-exit(r7)
            return r5
        L_0x0012:
            if (r9 == 0) goto L_0x0019
            long r3 = r7.f16120c     // Catch:{ all -> 0x004c }
            long r3 = r3 + r1
            r7.f16120c = r3     // Catch:{ all -> 0x004c }
        L_0x0019:
            java.util.LinkedHashMap r1 = r7.f16118a     // Catch:{ all -> 0x004c }
            if (r9 != 0) goto L_0x001f
            r2 = r5
            goto L_0x0024
        L_0x001f:
            w5.j r2 = new w5.j     // Catch:{ all -> 0x004c }
            r2.<init>(r0, r9)     // Catch:{ all -> 0x004c }
        L_0x0024:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x004c }
            w5.j r0 = (w5.j) r0     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0041
            long r1 = r7.f16120c     // Catch:{ all -> 0x004c }
            int r3 = r0.f16117b     // Catch:{ all -> 0x004c }
            long r3 = (long) r3     // Catch:{ all -> 0x004c }
            long r1 = r1 - r3
            r7.f16120c = r1     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r0.f16116a     // Catch:{ all -> 0x004c }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x004c }
            if (r9 != 0) goto L_0x0041
            java.lang.Object r9 = r0.f16116a     // Catch:{ all -> 0x004c }
            r7.c(r8, r9)     // Catch:{ all -> 0x004c }
        L_0x0041:
            long r8 = r7.f16119b     // Catch:{ all -> 0x004c }
            r7.e(r8)     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            java.lang.Object r5 = r0.f16116a     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r7)
            return r5
        L_0x004c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.k.d(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final synchronized void e(long j10) {
        while (this.f16120c > j10) {
            Iterator it = this.f16118a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            j jVar = (j) entry.getValue();
            this.f16120c -= (long) jVar.f16117b;
            Object key = entry.getKey();
            it.remove();
            c(key, jVar.f16116a);
        }
    }
}
