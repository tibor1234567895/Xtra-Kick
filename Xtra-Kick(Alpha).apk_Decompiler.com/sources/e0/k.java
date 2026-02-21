package e0;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import q.j;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final r f4865a;

    /* renamed from: b  reason: collision with root package name */
    public static final j f4866b = new j(16);

    static {
        r lVar;
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            lVar = new p();
        } else if (i10 >= 28) {
            lVar = new o();
        } else if (i10 >= 26) {
            lVar = new n();
        } else {
            if (i10 >= 24) {
                Method method = m.f4874d;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    lVar = new m();
                }
            }
            lVar = new l();
        }
        f4865a = lVar;
    }

    private k() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r3.equals(r5) == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r15, d0.f r16, android.content.res.Resources r17, int r18, java.lang.String r19, int r20, int r21, d0.p r22, boolean r23) {
        /*
            r0 = r15
            r1 = r16
            r7 = r21
            r2 = r22
            boolean r3 = r1 instanceof d0.i
            r8 = -3
            if (r3 == 0) goto L_0x017c
            d0.i r1 = (d0.i) r1
            java.lang.String r3 = r1.f4103d
            r4 = 0
            r9 = 0
            if (r3 == 0) goto L_0x002e
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x001b
            goto L_0x002e
        L_0x001b:
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r4)
            android.graphics.Typeface r5 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r4)
            if (r3 == 0) goto L_0x002e
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r3 = r9
        L_0x002f:
            if (r3 == 0) goto L_0x0037
            if (r2 == 0) goto L_0x0036
            r2.b(r3)
        L_0x0036:
            return r3
        L_0x0037:
            r10 = 1
            if (r23 == 0) goto L_0x003f
            int r3 = r1.f4102c
            if (r3 != 0) goto L_0x0043
            goto L_0x0041
        L_0x003f:
            if (r2 != 0) goto L_0x0043
        L_0x0041:
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            r5 = -1
            if (r23 == 0) goto L_0x004b
            int r6 = r1.f4101b
            r11 = r6
            goto L_0x004c
        L_0x004b:
            r11 = -1
        L_0x004c:
            android.os.Handler r6 = new android.os.Handler
            android.os.Looper r12 = android.os.Looper.getMainLooper()
            r6.<init>(r12)
            e0.j r12 = new e0.j
            r12.<init>(r2)
            androidx.appcompat.widget.b0 r13 = r1.f4100a
            android.support.v4.media.n r14 = new android.support.v4.media.n
            r1 = 5
            r14.<init>((java.lang.Object) r12, (int) r1, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x00ec
            q.j r1 = j0.g.f8391a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Object r2 = r13.f735g
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r2 = "-"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = r1.toString()
            q.j r1 = j0.g.f8391a
            java.lang.Object r1 = r1.b(r2)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x009a
            java.lang.Object r0 = r14.f337i
            j0.j r0 = (j0.j) r0
            java.lang.Object r2 = r14.f338j
            android.os.Handler r2 = (android.os.Handler) r2
            android.support.v4.media.i r3 = new android.support.v4.media.i
            r3.<init>(r14, r0, r1, r10)
            r2.post(r3)
            goto L_0x0120
        L_0x009a:
            if (r11 != r5) goto L_0x00a7
            j0.f r0 = j0.g.a(r2, r15, r13, r7)
            r14.z(r0)
            android.graphics.Typeface r9 = r0.f8389a
            goto L_0x0176
        L_0x00a7:
            j0.d r10 = new j0.d
            r6 = 0
            r1 = r10
            r3 = r15
            r4 = r13
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.concurrent.ThreadPoolExecutor r0 = j0.g.f8392b     // Catch:{ InterruptedException -> 0x00d9 }
            java.util.concurrent.Future r0 = r0.submit(r10)     // Catch:{ InterruptedException -> 0x00d9 }
            long r1 = (long) r11
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x00d2, InterruptedException -> 0x00d0, TimeoutException -> 0x00c8 }
            java.lang.Object r0 = r0.get(r1, r3)     // Catch:{ ExecutionException -> 0x00d2, InterruptedException -> 0x00d0, TimeoutException -> 0x00c8 }
            j0.f r0 = (j0.f) r0     // Catch:{ InterruptedException -> 0x00d9 }
            r14.z(r0)     // Catch:{ InterruptedException -> 0x00d9 }
            android.graphics.Typeface r9 = r0.f8389a     // Catch:{ InterruptedException -> 0x00d9 }
            goto L_0x0176
        L_0x00c8:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x00d9 }
            java.lang.String r1 = "timeout"
            r0.<init>(r1)     // Catch:{ InterruptedException -> 0x00d9 }
            throw r0     // Catch:{ InterruptedException -> 0x00d9 }
        L_0x00d0:
            r0 = move-exception
            throw r0     // Catch:{ InterruptedException -> 0x00d9 }
        L_0x00d2:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ InterruptedException -> 0x00d9 }
            r1.<init>(r0)     // Catch:{ InterruptedException -> 0x00d9 }
            throw r1     // Catch:{ InterruptedException -> 0x00d9 }
        L_0x00d9:
            java.lang.Object r0 = r14.f337i
            j0.j r0 = (j0.j) r0
            java.lang.Object r1 = r14.f338j
            android.os.Handler r1 = (android.os.Handler) r1
            c.f r2 = new c.f
            r3 = 4
            r2.<init>((java.lang.Object) r14, (java.lang.Object) r0, (int) r8, (int) r3)
            r1.post(r2)
            goto L_0x0176
        L_0x00ec:
            q.j r1 = j0.g.f8391a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Object r2 = r13.f735g
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r2 = "-"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r8 = r1.toString()
            q.j r1 = j0.g.f8391a
            java.lang.Object r1 = r1.b(r8)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0122
            java.lang.Object r0 = r14.f337i
            j0.j r0 = (j0.j) r0
            java.lang.Object r2 = r14.f338j
            android.os.Handler r2 = (android.os.Handler) r2
            android.support.v4.media.i r3 = new android.support.v4.media.i
            r3.<init>(r14, r0, r1, r10)
            r2.post(r3)
        L_0x0120:
            r9 = r1
            goto L_0x0176
        L_0x0122:
            j0.e r1 = new j0.e
            r1.<init>(r4, r14)
            java.lang.Object r3 = j0.g.f8393c
            monitor-enter(r3)
            q.k r2 = j0.g.f8394d     // Catch:{ all -> 0x0179 }
            java.lang.Object r4 = r2.getOrDefault(r8, r9)     // Catch:{ all -> 0x0179 }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x0179 }
            if (r4 == 0) goto L_0x0139
            r4.add(r1)     // Catch:{ all -> 0x0179 }
            monitor-exit(r3)     // Catch:{ all -> 0x0179 }
            goto L_0x0176
        L_0x0139:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0179 }
            r4.<init>()     // Catch:{ all -> 0x0179 }
            r4.add(r1)     // Catch:{ all -> 0x0179 }
            r2.put(r8, r4)     // Catch:{ all -> 0x0179 }
            monitor-exit(r3)     // Catch:{ all -> 0x0179 }
            j0.d r11 = new j0.d
            r6 = 1
            r1 = r11
            r2 = r8
            r3 = r15
            r4 = r13
            r5 = r21
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.concurrent.ThreadPoolExecutor r0 = j0.g.f8392b
            j0.e r1 = new j0.e
            r1.<init>(r10, r8)
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r2 != 0) goto L_0x0168
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            r2.<init>(r3)
            goto L_0x016d
        L_0x0168:
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
        L_0x016d:
            android.support.v4.media.i r3 = new android.support.v4.media.i
            r4 = 3
            r3.<init>(r2, r11, r1, r4)
            r0.execute(r3)
        L_0x0176:
            r4 = r17
            goto L_0x0191
        L_0x0179:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0179 }
            throw r0
        L_0x017c:
            e0.r r3 = f4865a
            d0.g r1 = (d0.g) r1
            r4 = r17
            android.graphics.Typeface r9 = r3.a(r15, r1, r4, r7)
            if (r2 == 0) goto L_0x0191
            if (r9 == 0) goto L_0x018e
            r2.b(r9)
            goto L_0x0191
        L_0x018e:
            r2.a(r8)
        L_0x0191:
            if (r9 == 0) goto L_0x019c
            q.j r0 = f4866b
            java.lang.String r1 = b(r17, r18, r19, r20, r21)
            r0.c(r1, r9)
        L_0x019c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.k.a(android.content.Context, d0.f, android.content.res.Resources, int, java.lang.String, int, int, d0.p, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }
}
