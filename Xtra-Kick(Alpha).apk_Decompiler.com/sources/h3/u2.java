package h3;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.media.session.z;
import android.util.Log;
import b5.j;
import f5.a;
import f5.e;
import f5.l;
import g1.v0;
import h9.v;
import j1.l0;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import x4.d;

public final class u2 implements v, a {

    /* renamed from: h  reason: collision with root package name */
    public final Object f7335h;

    /* renamed from: i  reason: collision with root package name */
    public final long f7336i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f7337j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f7338k;

    /* renamed from: l  reason: collision with root package name */
    public Object f7339l;

    public u2(v2 v2Var, v0 v0Var, String str, Uri uri, long j10) {
        this.f7339l = v2Var;
        this.f7337j = v0Var;
        this.f7335h = str;
        this.f7338k = uri;
        this.f7336i = j10;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x008f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b5.j r7, android.support.v4.media.session.u r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Had two simultaneous puts for: "
            java.lang.Object r1 = r6.f7337j
            f5.l r1 = (f5.l) r1
            java.lang.String r1 = r1.b(r7)
            java.lang.Object r2 = r6.f7338k
            f5.e r2 = (f5.e) r2
            monitor-enter(r2)
            java.util.HashMap r3 = r2.f5818a     // Catch:{ all -> 0x00b4 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x00b4 }
            f5.c r3 = (f5.c) r3     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x0024
            f5.d r3 = r2.f5819b     // Catch:{ all -> 0x00b4 }
            f5.c r3 = r3.a()     // Catch:{ all -> 0x00b4 }
            java.util.HashMap r4 = r2.f5818a     // Catch:{ all -> 0x00b4 }
            r4.put(r1, r3)     // Catch:{ all -> 0x00b4 }
        L_0x0024:
            int r4 = r3.f5816b     // Catch:{ all -> 0x00b4 }
            r5 = 1
            int r4 = r4 + r5
            r3.f5816b = r4     // Catch:{ all -> 0x00b4 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b4 }
            java.util.concurrent.locks.ReentrantLock r2 = r3.f5815a
            r2.lock()
            java.lang.String r2 = "DiskLruCacheWrapper"
            r3 = 2
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x003c
            java.util.Objects.toString(r7)     // Catch:{ all -> 0x00ab }
        L_0x003c:
            x4.d r7 = r6.e()     // Catch:{ IOException -> 0x0086 }
            h3.u2 r2 = r7.z(r1)     // Catch:{ IOException -> 0x0086 }
            if (r2 == 0) goto L_0x004e
        L_0x0046:
            java.lang.Object r7 = r6.f7338k
            f5.e r7 = (f5.e) r7
            r7.a(r1)
            return
        L_0x004e:
            p1.i0 r7 = r7.v(r1)     // Catch:{ IOException -> 0x0086 }
            if (r7 == 0) goto L_0x0090
            java.io.File r0 = r7.k()     // Catch:{ all -> 0x007c }
            java.lang.Object r2 = r8.f428i     // Catch:{ all -> 0x007c }
            b5.d r2 = (b5.d) r2     // Catch:{ all -> 0x007c }
            java.lang.Object r3 = r8.f429j     // Catch:{ all -> 0x007c }
            java.lang.Object r8 = r8.f430k     // Catch:{ all -> 0x007c }
            b5.n r8 = (b5.n) r8     // Catch:{ all -> 0x007c }
            boolean r8 = r2.c(r3, r0, r8)     // Catch:{ all -> 0x007c }
            if (r8 == 0) goto L_0x007e
            int r8 = r7.f12463h     // Catch:{ all -> 0x007c }
            switch(r8) {
                case 2: goto L_0x006e;
                default: goto L_0x006d;
            }     // Catch:{ all -> 0x007c }
        L_0x006d:
            goto L_0x0072
        L_0x006e:
            r7.e(r5)     // Catch:{ all -> 0x007c }
            goto L_0x007e
        L_0x0072:
            java.lang.Object r8 = r7.f12467l     // Catch:{ all -> 0x007c }
            x4.d r8 = (x4.d) r8     // Catch:{ all -> 0x007c }
            x4.d.c(r8, r7, r5)     // Catch:{ all -> 0x007c }
            r7.f12464i = r5     // Catch:{ all -> 0x007c }
            goto L_0x007e
        L_0x007c:
            r8 = move-exception
            goto L_0x0088
        L_0x007e:
            boolean r8 = r7.f12464i     // Catch:{ IOException -> 0x0086 }
            if (r8 != 0) goto L_0x0046
            r7.c()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0046
        L_0x0086:
            r7 = move-exception
            goto L_0x009a
        L_0x0088:
            boolean r0 = r7.f12464i     // Catch:{ IOException -> 0x0086 }
            if (r0 != 0) goto L_0x008f
            r7.c()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            throw r8     // Catch:{ IOException -> 0x0086 }
        L_0x0090:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0086 }
            java.lang.String r8 = r0.concat(r1)     // Catch:{ IOException -> 0x0086 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0086 }
            throw r7     // Catch:{ IOException -> 0x0086 }
        L_0x009a:
            java.lang.String r8 = "DiskLruCacheWrapper"
            r0 = 5
            boolean r8 = android.util.Log.isLoggable(r8, r0)     // Catch:{ all -> 0x00ab }
            if (r8 == 0) goto L_0x0046
            java.lang.String r8 = "DiskLruCacheWrapper"
            java.lang.String r0 = "Unable to put to disk cache"
            android.util.Log.w(r8, r0, r7)     // Catch:{ all -> 0x00ab }
            goto L_0x0046
        L_0x00ab:
            r7 = move-exception
            java.lang.Object r8 = r6.f7338k
            f5.e r8 = (f5.e) r8
            r8.a(r1)
            throw r7
        L_0x00b4:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b4 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.u2.a(b5.j, android.support.v4.media.session.u):void");
    }

    public final File b(j jVar) {
        String b10 = ((l) this.f7337j).b(jVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Objects.toString(jVar);
        }
        try {
            u2 z10 = e().z(b10);
            if (z10 != null) {
                return ((File[]) z10.f7338k)[0];
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    public final void c(Throwable th) {
        if (this == ((v2) this.f7339l).f7383e.f7448r) {
            j1.v.g("MediaSessionLegacyStub", "Failed to load bitmap: " + th.getMessage());
        }
    }

    public final void d(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        x2 x2Var = ((v2) this.f7339l).f7383e;
        if (this == x2Var.f7448r) {
            ((z) x2Var.f7442l.f428i).r(t3.n((v0) this.f7337j, (String) this.f7335h, (Uri) this.f7338k, this.f7336i, bitmap));
            n2 n2Var = ((v2) this.f7339l).f7383e.f7437g;
            l0.L(n2Var.f7242o, new h2(n2Var, 3));
        }
    }

    public final synchronized d e() {
        if (((d) this.f7339l) == null) {
            this.f7339l = d.W((File) this.f7335h, this.f7336i);
        }
        return (d) this.f7339l;
    }

    public u2(File file, long j10) {
        this.f7338k = new e();
        this.f7335h = file;
        this.f7336i = j10;
        this.f7337j = new l();
    }

    public u2(d dVar, String str, long j10, File[] fileArr, long[] jArr) {
        this.f7339l = dVar;
        this.f7335h = str;
        this.f7336i = j10;
        this.f7338k = fileArr;
        this.f7337j = jArr;
    }
}
