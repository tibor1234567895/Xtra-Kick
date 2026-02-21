package okhttp3.internal.publicsuffix;

import ac.a;
import fb.y;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import ma.q;
import ma.z;
import xa.j;

public final class PublicSuffixDatabase {

    /* renamed from: e  reason: collision with root package name */
    public static final a f12392e = new a(0);

    /* renamed from: f  reason: collision with root package name */
    public static final String f12393f = "PublicSuffixDatabase.gz";

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f12394g = {(byte) 42};

    /* renamed from: h  reason: collision with root package name */
    public static final List f12395h = q.b("*");

    /* renamed from: i  reason: collision with root package name */
    public static final PublicSuffixDatabase f12396i = new PublicSuffixDatabase();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f12397a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f12398b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public byte[] f12399c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f12400d;

    public static List c(String str) {
        int i10 = 0;
        List E = y.E(str, new char[]{'.'});
        if (!j.a(z.z(E), "")) {
            return E;
        }
        int size = E.size() - 1;
        if (size >= 0) {
            i10 = size;
        }
        return z.G(E, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r1 == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != false) goto L_0x003b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = java.net.IDN.toUnicode(r14)
            java.lang.String r1 = "unicodeDomain"
            xa.j.e(r1, r0)
            java.util.List r0 = c(r0)
            java.util.concurrent.atomic.AtomicBoolean r1 = r13.f12397a
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0052
            java.util.concurrent.atomic.AtomicBoolean r1 = r13.f12397a
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0052
            r1 = 0
        L_0x0020:
            r13.b()     // Catch:{ InterruptedIOException -> 0x0043, IOException -> 0x0028 }
            if (r1 == 0) goto L_0x005f
            goto L_0x003b
        L_0x0026:
            r14 = move-exception
            goto L_0x0048
        L_0x0028:
            r4 = move-exception
            xb.r r5 = xb.s.f16851a     // Catch:{ all -> 0x0026 }
            r5.getClass()     // Catch:{ all -> 0x0026 }
            xb.s r5 = xb.s.f16852b     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = "Failed to read public suffix list"
            r5.getClass()     // Catch:{ all -> 0x0026 }
            r5 = 5
            xb.s.i(r5, r6, r4)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x005f
        L_0x003b:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            goto L_0x005f
        L_0x0043:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0026 }
            r1 = 1
            goto L_0x0020
        L_0x0048:
            if (r1 == 0) goto L_0x0051
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0051:
            throw r14
        L_0x0052:
            java.util.concurrent.CountDownLatch r1 = r13.f12398b     // Catch:{ InterruptedException -> 0x0058 }
            r1.await()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x005f
        L_0x0058:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L_0x005f:
            byte[] r1 = r13.f12399c
            if (r1 == 0) goto L_0x0065
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            if (r1 == 0) goto L_0x01c4
            int r1 = r0.size()
            byte[][] r4 = new byte[r1][]
            r5 = 0
        L_0x006f:
            if (r5 >= r1) goto L_0x0087
            java.lang.Object r6 = r0.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.nio.charset.Charset r7 = fb.c.f5986b
            byte[] r6 = r6.getBytes(r7)
            java.lang.String r7 = "this as java.lang.String).getBytes(charset)"
            xa.j.e(r7, r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x006f
        L_0x0087:
            r5 = 0
        L_0x0088:
            r6 = 0
            java.lang.String r7 = "publicSuffixListBytes"
            if (r5 >= r1) goto L_0x00a1
            ac.a r8 = f12392e
            byte[] r9 = r13.f12399c
            if (r9 == 0) goto L_0x009d
            java.lang.String r8 = ac.a.a(r8, r9, r4, r5)
            if (r8 == 0) goto L_0x009a
            goto L_0x00a2
        L_0x009a:
            int r5 = r5 + 1
            goto L_0x0088
        L_0x009d:
            xa.j.l(r7)
            throw r6
        L_0x00a1:
            r8 = r6
        L_0x00a2:
            if (r1 <= r2) goto L_0x00c7
            java.lang.Object r5 = r4.clone()
            byte[][] r5 = (byte[][]) r5
            int r9 = r5.length
            int r9 = r9 - r2
            r10 = 0
        L_0x00ad:
            if (r10 >= r9) goto L_0x00c7
            byte[] r11 = f12394g
            r5[r10] = r11
            ac.a r11 = f12392e
            byte[] r12 = r13.f12399c
            if (r12 == 0) goto L_0x00c3
            java.lang.String r11 = ac.a.a(r11, r12, r5, r10)
            if (r11 == 0) goto L_0x00c0
            goto L_0x00c8
        L_0x00c0:
            int r10 = r10 + 1
            goto L_0x00ad
        L_0x00c3:
            xa.j.l(r7)
            throw r6
        L_0x00c7:
            r11 = r6
        L_0x00c8:
            if (r11 == 0) goto L_0x00e4
            int r1 = r1 - r2
            r5 = 0
        L_0x00cc:
            if (r5 >= r1) goto L_0x00e4
            ac.a r7 = f12392e
            byte[] r9 = r13.f12400d
            if (r9 == 0) goto L_0x00de
            java.lang.String r7 = ac.a.a(r7, r9, r4, r5)
            if (r7 == 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            int r5 = r5 + 1
            goto L_0x00cc
        L_0x00de:
            java.lang.String r14 = "publicSuffixExceptionListBytes"
            xa.j.l(r14)
            throw r6
        L_0x00e4:
            r7 = r6
        L_0x00e5:
            r1 = 46
            if (r7 == 0) goto L_0x00f8
            java.lang.String r4 = "!"
            java.lang.String r4 = r4.concat(r7)
            char[] r5 = new char[r2]
            r5[r3] = r1
            java.util.List r1 = fb.y.E(r4, r5)
            goto L_0x0124
        L_0x00f8:
            if (r8 != 0) goto L_0x00ff
            if (r11 != 0) goto L_0x00ff
            java.util.List r1 = f12395h
            goto L_0x0124
        L_0x00ff:
            if (r8 == 0) goto L_0x010a
            char[] r4 = new char[r2]
            r4[r3] = r1
            java.util.List r4 = fb.y.E(r8, r4)
            goto L_0x010c
        L_0x010a:
            ma.b0 r4 = ma.b0.f10801h
        L_0x010c:
            if (r11 == 0) goto L_0x0117
            char[] r5 = new char[r2]
            r5[r3] = r1
            java.util.List r1 = fb.y.E(r11, r5)
            goto L_0x0119
        L_0x0117:
            ma.b0 r1 = ma.b0.f10801h
        L_0x0119:
            int r5 = r4.size()
            int r7 = r1.size()
            if (r5 <= r7) goto L_0x0124
            r1 = r4
        L_0x0124:
            int r4 = r0.size()
            int r5 = r1.size()
            r7 = 33
            if (r4 != r5) goto L_0x013d
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            char r4 = r4.charAt(r3)
            if (r4 == r7) goto L_0x013d
            return r6
        L_0x013d:
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            char r4 = r4.charAt(r3)
            int r0 = r0.size()
            int r1 = r1.size()
            if (r4 != r7) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            int r1 = r1 + 1
        L_0x0154:
            int r0 = r0 - r1
            java.util.List r14 = c(r14)
            java.lang.String r1 = "<this>"
            xa.j.f(r1, r14)
            m0.h1 r4 = new m0.h1
            r4.<init>(r2, r14)
            if (r0 < 0) goto L_0x0167
            r14 = 1
            goto L_0x0168
        L_0x0167:
            r14 = 0
        L_0x0168:
            if (r14 == 0) goto L_0x01b2
            if (r0 != 0) goto L_0x016d
            goto L_0x017e
        L_0x016d:
            boolean r14 = r4 instanceof eb.c
            if (r14 == 0) goto L_0x0178
            eb.c r4 = (eb.c) r4
            eb.h r4 = r4.a(r0)
            goto L_0x017e
        L_0x0178:
            eb.b r14 = new eb.b
            r14.<init>(r4, r0)
            r4 = r14
        L_0x017e:
            xa.j.f(r1, r4)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = ""
            r14.append(r0)
            java.util.Iterator r1 = r4.iterator()
        L_0x018f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01a5
            java.lang.Object r4 = r1.next()
            int r3 = r3 + r2
            if (r3 <= r2) goto L_0x01a1
            java.lang.String r5 = "."
            r14.append(r5)
        L_0x01a1:
            fb.n.a(r14, r4, r6)
            goto L_0x018f
        L_0x01a5:
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "joinTo(StringBuilder(), …ed, transform).toString()"
            xa.j.e(r0, r14)
            return r14
        L_0x01b2:
            java.lang.String r14 = "Requested element count "
            java.lang.String r1 = " is less than zero."
            java.lang.String r14 = android.support.v4.media.h.j(r14, r0, r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r14 = r14.toString()
            r0.<init>(r14)
            throw r0
        L_0x01c4:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to load "
            r14.<init>(r0)
            java.lang.String r0 = f12393f
            java.lang.String r1 = " resource from the classpath."
            java.lang.String r14 = android.support.v4.media.h.p(r14, r0, r1)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r14 = r14.toString()
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        hb.h0.A(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r5 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = f12393f
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            dc.w r1 = new dc.w
            dc.d r0 = hb.h0.I1(r0)
            r1.<init>(r0)
            dc.i0 r0 = hb.h0.o(r1)
            int r1 = r0.readInt()     // Catch:{ all -> 0x0049 }
            long r1 = (long) r1     // Catch:{ all -> 0x0049 }
            r0.u0(r1)     // Catch:{ all -> 0x0049 }
            dc.j r3 = r0.f4784i     // Catch:{ all -> 0x0049 }
            byte[] r1 = r3.Y(r1)     // Catch:{ all -> 0x0049 }
            int r2 = r0.readInt()     // Catch:{ all -> 0x0049 }
            long r2 = (long) r2     // Catch:{ all -> 0x0049 }
            r0.u0(r2)     // Catch:{ all -> 0x0049 }
            dc.j r4 = r0.f4784i     // Catch:{ all -> 0x0049 }
            byte[] r2 = r4.Y(r2)     // Catch:{ all -> 0x0049 }
            la.v r3 = la.v.f9814a     // Catch:{ all -> 0x0049 }
            r3 = 0
            hb.h0.A(r0, r3)
            monitor-enter(r5)
            r5.f12399c = r1     // Catch:{ all -> 0x0046 }
            r5.f12400d = r2     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)
            java.util.concurrent.CountDownLatch r0 = r5.f12398b
            r0.countDown()
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0049:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004b }
        L_0x004b:
            r2 = move-exception
            hb.h0.A(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.b():void");
    }
}
