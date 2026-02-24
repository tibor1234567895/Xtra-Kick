package p1;

import android.os.Handler;
import android.os.Looper;

public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public boolean f12408a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f12409b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(e eVar, Looper looper) {
        super(looper);
        this.f12409b = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.os.Message r8, p1.k0 r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.obj
            p1.b r0 = (p1.b) r0
            boolean r1 = r0.f12413b
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r0.f12415d
            r3 = 1
            int r1 = r1 + r3
            r0.f12415d = r1
            p1.e r4 = r7.f12409b
            a2.i r4 = r4.f12432j
            r5 = 3
            int r4 = r4.b(r5)
            if (r1 <= r4) goto L_0x001c
            return r2
        L_0x001c:
            v1.r r1 = new v1.r
            android.os.SystemClock.elapsedRealtime()
            android.os.SystemClock.elapsedRealtime()
            java.lang.Throwable r1 = r9.getCause()
            boolean r1 = r1 instanceof java.io.IOException
            if (r1 == 0) goto L_0x0033
            java.lang.Throwable r9 = r9.getCause()
            java.io.IOException r9 = (java.io.IOException) r9
            goto L_0x003d
        L_0x0033:
            p1.d r1 = new p1.d
            java.lang.Throwable r9 = r9.getCause()
            r1.<init>(r9)
            r9 = r1
        L_0x003d:
            p1.e r1 = r7.f12409b
            a2.i r1 = r1.f12432j
            int r0 = r0.f12415d
            r1.getClass()
            boolean r1 = r9 instanceof g1.b1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0082
            boolean r1 = r9 instanceof java.io.FileNotFoundException
            if (r1 != 0) goto L_0x0082
            boolean r1 = r9 instanceof k1.w
            if (r1 != 0) goto L_0x0082
            boolean r1 = r9 instanceof a2.p
            if (r1 != 0) goto L_0x0082
            int r1 = k1.i.f9006i
        L_0x005d:
            if (r9 == 0) goto L_0x0073
            boolean r1 = r9 instanceof k1.i
            if (r1 == 0) goto L_0x006e
            r1 = r9
            k1.i r1 = (k1.i) r1
            int r1 = r1.f9007h
            r6 = 2008(0x7d8, float:2.814E-42)
            if (r1 != r6) goto L_0x006e
            r9 = 1
            goto L_0x0074
        L_0x006e:
            java.lang.Throwable r9 = r9.getCause()
            goto L_0x005d
        L_0x0073:
            r9 = 0
        L_0x0074:
            if (r9 == 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            int r0 = r0 - r3
            int r0 = r0 * 1000
            r9 = 5000(0x1388, float:7.006E-42)
            int r9 = java.lang.Math.min(r0, r9)
            long r0 = (long) r9
            goto L_0x0083
        L_0x0082:
            r0 = r4
        L_0x0083:
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0088
            return r2
        L_0x0088:
            monitor-enter(r7)
            boolean r9 = r7.f12408a     // Catch:{ all -> 0x0098 }
            if (r9 != 0) goto L_0x0096
            android.os.Message r8 = android.os.Message.obtain(r8)     // Catch:{ all -> 0x0098 }
            r7.sendMessageDelayed(r8, r0)     // Catch:{ all -> 0x0098 }
            monitor-exit(r7)     // Catch:{ all -> 0x0098 }
            return r3
        L_0x0096:
            monitor-exit(r7)     // Catch:{ all -> 0x0098 }
            return r2
        L_0x0098:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0098 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.a.a(android.os.Message, p1.k0):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: p1.k0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: p1.k0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: p1.k0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.obj
            p1.b r0 = (p1.b) r0
            int r1 = r6.what     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            if (r1 == 0) goto L_0x0020
            r2 = 1
            if (r1 != r2) goto L_0x001a
            p1.e r1 = r5.f12409b     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            p1.i0 r2 = r1.f12434l     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            java.util.UUID r1 = r1.f12435m     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            java.lang.Object r3 = r0.f12414c     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            p1.a0 r3 = (p1.a0) r3     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            byte[] r1 = r2.g(r1, r3)     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            goto L_0x003e
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            r1.<init>()     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            throw r1     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
        L_0x0020:
            p1.e r1 = r5.f12409b     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            p1.i0 r1 = r1.f12434l     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            java.lang.Object r2 = r0.f12414c     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            p1.b0 r2 = (p1.b0) r2     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            byte[] r1 = r1.i(r2)     // Catch:{ k0 -> 0x0036, Exception -> 0x002d }
            goto L_0x003e
        L_0x002d:
            r1 = move-exception
            java.lang.String r2 = "DefaultDrmSession"
            java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
            j1.v.h(r2, r3, r1)
            goto L_0x003e
        L_0x0036:
            r1 = move-exception
            boolean r2 = r5.a(r6, r1)
            if (r2 == 0) goto L_0x003e
            return
        L_0x003e:
            p1.e r2 = r5.f12409b
            a2.i r2 = r2.f12432j
            long r3 = r0.f12412a
            r2.getClass()
            monitor-enter(r5)
            boolean r2 = r5.f12408a     // Catch:{ all -> 0x0061 }
            if (r2 != 0) goto L_0x005f
            p1.e r2 = r5.f12409b     // Catch:{ all -> 0x0061 }
            p1.c r2 = r2.f12437o     // Catch:{ all -> 0x0061 }
            int r6 = r6.what     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.f12414c     // Catch:{ all -> 0x0061 }
            android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0061 }
            android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0061 }
            r6.sendToTarget()     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r5)     // Catch:{ all -> 0x0061 }
            return
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0061 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.a.handleMessage(android.os.Message):void");
    }
}
