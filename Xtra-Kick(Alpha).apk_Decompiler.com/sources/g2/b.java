package g2;

import d2.f0;
import d2.i0;
import d2.p;
import d2.v;
import d2.w;
import d2.x0;
import d2.y;
import g1.z0;
import j1.b0;
import o2.o;

public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6782a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f6783b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6784c;

    /* renamed from: d  reason: collision with root package name */
    public final d2.b0 f6785d;

    /* renamed from: e  reason: collision with root package name */
    public y f6786e;

    /* renamed from: f  reason: collision with root package name */
    public x0 f6787f;

    /* renamed from: g  reason: collision with root package name */
    public int f6788g;

    /* renamed from: h  reason: collision with root package name */
    public z0 f6789h;

    /* renamed from: i  reason: collision with root package name */
    public f0 f6790i;

    /* renamed from: j  reason: collision with root package name */
    public int f6791j;

    /* renamed from: k  reason: collision with root package name */
    public int f6792k;

    /* renamed from: l  reason: collision with root package name */
    public a f6793l;

    /* renamed from: m  reason: collision with root package name */
    public int f6794m;

    /* renamed from: n  reason: collision with root package name */
    public long f6795n;

    public b() {
        this(0);
    }

    public final void a() {
    }

    public final void c(long j10, long j11) {
        long j12 = 0;
        if (j10 == 0) {
            this.f6788g = 0;
        } else {
            a aVar = this.f6793l;
            if (aVar != null) {
                aVar.c(j11);
            }
        }
        if (j11 != 0) {
            j12 = -1;
        }
        this.f6795n = j12;
        this.f6794m = 0;
        this.f6783b.D(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        r3.G(r2);
        r11 = r11.f4149a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r29, d2.s0 r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            int r2 = r0.f6788g
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x03d1
            r6 = 2
            byte[] r7 = r0.f6782a
            if (r2 == r4) goto L_0x03c6
            r8 = 3
            r9 = 4
            if (r2 == r6) goto L_0x03a4
            r10 = 7
            if (r2 == r8) goto L_0x01fb
            r7 = -1
            r12 = 5
            if (r2 == r9) goto L_0x0191
            if (r2 != r12) goto L_0x018b
            d2.x0 r2 = r0.f6787f
            r2.getClass()
            d2.f0 r2 = r0.f6790i
            r2.getClass()
            g2.a r2 = r0.f6793l
            if (r2 == 0) goto L_0x003d
            d2.h r9 = r2.f4221c
            if (r9 == 0) goto L_0x0032
            r9 = 1
            goto L_0x0033
        L_0x0032:
            r9 = 0
        L_0x0033:
            if (r9 == 0) goto L_0x003d
            r9 = r30
            int r5 = r2.a(r1, r9)
            goto L_0x018a
        L_0x003d:
            long r12 = r0.f6795n
            r2 = -1
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x009f
            d2.f0 r7 = r0.f6790i
            r29.f()
            r1.n(r4)
            byte[] r8 = new byte[r4]
            r1.m(r8, r5, r4)
            byte r8 = r8[r5]
            r8 = r8 & r4
            if (r8 != r4) goto L_0x0058
            r8 = 1
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            r1.n(r6)
            if (r8 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r10 = 6
        L_0x0060:
            j1.b0 r6 = new j1.b0
            r6.<init>((int) r10)
            byte[] r9 = r6.f8414a
            r11 = 0
        L_0x0068:
            if (r11 >= r10) goto L_0x0077
            int r12 = r5 + r11
            int r13 = r10 - r11
            int r12 = r1.d(r9, r12, r13)
            if (r12 != r2) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            int r11 = r11 + r12
            goto L_0x0068
        L_0x0077:
            r6.F(r11)
            r29.f()
            d2.b0 r1 = new d2.b0
            r1.<init>()
            long r9 = r6.B()     // Catch:{ NumberFormatException -> 0x0091 }
            if (r8 == 0) goto L_0x0089
            goto L_0x008e
        L_0x0089:
            int r2 = r7.f4174b
            long r6 = (long) r2
            long r9 = r9 * r6
        L_0x008e:
            r1.f4149a = r9
            goto L_0x0092
        L_0x0091:
            r4 = 0
        L_0x0092:
            if (r4 == 0) goto L_0x009a
            long r1 = r1.f4149a
            r0.f6795n = r1
            goto L_0x018a
        L_0x009a:
            g1.b1 r1 = g1.b1.a(r3, r3)
            throw r1
        L_0x009f:
            j1.b0 r3 = r0.f6783b
            int r6 = r3.f8416c
            r9 = 1000000(0xf4240, double:4.940656E-318)
            r11 = 32768(0x8000, float:4.5918E-41)
            if (r6 >= r11) goto L_0x00de
            byte[] r12 = r3.f8414a
            int r11 = r11 - r6
            int r1 = r1.o(r12, r6, r11)
            if (r1 != r2) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            if (r4 != 0) goto L_0x00bd
            int r6 = r6 + r1
            r3.F(r6)
            goto L_0x00df
        L_0x00bd:
            int r1 = r3.f8416c
            int r6 = r3.f8415b
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x00df
            long r3 = r0.f6795n
            long r3 = r3 * r9
            d2.f0 r1 = r0.f6790i
            int r5 = j1.l0.f8453a
            int r1 = r1.f4177e
            long r5 = (long) r1
            long r8 = r3 / r5
            d2.x0 r7 = r0.f6787f
            r10 = 1
            int r11 = r0.f6794m
            r12 = 0
            r13 = 0
            r7.e(r8, r10, r11, r12, r13)
            r5 = -1
            goto L_0x018a
        L_0x00de:
            r4 = 0
        L_0x00df:
            int r1 = r3.f8415b
            int r2 = r0.f6794m
            int r6 = r0.f6791j
            if (r2 >= r6) goto L_0x00f2
            int r6 = r6 - r2
            int r2 = r3.f8416c
            int r2 = r2 - r1
            int r2 = java.lang.Math.min(r6, r2)
            r3.H(r2)
        L_0x00f2:
            d2.f0 r2 = r0.f6790i
            r2.getClass()
            int r2 = r3.f8415b
        L_0x00f9:
            int r6 = r3.f8416c
            int r6 = r6 + -16
            d2.b0 r11 = r0.f6785d
            if (r2 > r6) goto L_0x0112
            r3.G(r2)
            d2.f0 r6 = r0.f6790i
            int r12 = r0.f6792k
            boolean r6 = d2.c0.a(r3, r6, r12, r11)
            if (r6 == 0) goto L_0x010f
            goto L_0x0133
        L_0x010f:
            int r2 = r2 + 1
            goto L_0x00f9
        L_0x0112:
            if (r4 == 0) goto L_0x0140
        L_0x0114:
            int r4 = r3.f8416c
            int r6 = r0.f6791j
            int r6 = r4 - r6
            if (r2 > r6) goto L_0x013c
            r3.G(r2)
            d2.f0 r4 = r0.f6790i     // Catch:{ IndexOutOfBoundsException -> 0x0128 }
            int r6 = r0.f6792k     // Catch:{ IndexOutOfBoundsException -> 0x0128 }
            boolean r4 = d2.c0.a(r3, r4, r6, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0128 }
            goto L_0x012a
        L_0x0128:
            r4 = 0
        L_0x012a:
            int r6 = r3.f8415b
            int r12 = r3.f8416c
            if (r6 <= r12) goto L_0x0131
            r4 = 0
        L_0x0131:
            if (r4 == 0) goto L_0x0139
        L_0x0133:
            r3.G(r2)
            long r11 = r11.f4149a
            goto L_0x0144
        L_0x0139:
            int r2 = r2 + 1
            goto L_0x0114
        L_0x013c:
            r3.G(r4)
            goto L_0x0143
        L_0x0140:
            r3.G(r2)
        L_0x0143:
            r11 = r7
        L_0x0144:
            int r2 = r3.f8415b
            int r2 = r2 - r1
            r3.G(r1)
            d2.x0 r1 = r0.f6787f
            r1.d(r2, r3)
            int r1 = r0.f6794m
            int r1 = r1 + r2
            r0.f6794m = r1
            int r2 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0176
            long r6 = r0.f6795n
            long r6 = r6 * r9
            d2.f0 r2 = r0.f6790i
            int r4 = j1.l0.f8453a
            int r2 = r2.f4177e
            long r8 = (long) r2
            long r14 = r6 / r8
            d2.x0 r13 = r0.f6787f
            r16 = 1
            r18 = 0
            r19 = 0
            r17 = r1
            r13.e(r14, r16, r17, r18, r19)
            r0.f6794m = r5
            r0.f6795n = r11
        L_0x0176:
            int r1 = r3.f8416c
            int r2 = r3.f8415b
            int r1 = r1 - r2
            r4 = 16
            if (r1 >= r4) goto L_0x018a
            byte[] r4 = r3.f8414a
            java.lang.System.arraycopy(r4, r2, r4, r5, r1)
            r3.G(r5)
            r3.F(r1)
        L_0x018a:
            return r5
        L_0x018b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0191:
            r29.f()
            j1.b0 r2 = new j1.b0
            r2.<init>((int) r6)
            byte[] r4 = r2.f8414a
            r1.m(r4, r5, r6)
            int r2 = r2.A()
            int r4 = r2 >> 2
            r29.f()
            r6 = 16382(0x3ffe, float:2.2956E-41)
            if (r4 != r6) goto L_0x01f4
            r0.f6792k = r2
            d2.y r2 = r0.f6786e
            int r3 = j1.l0.f8453a
            long r3 = r29.p()
            long r18 = r29.c()
            d2.f0 r1 = r0.f6790i
            r1.getClass()
            d2.f0 r14 = r0.f6790i
            android.support.v4.media.n r1 = r14.f4183k
            if (r1 == 0) goto L_0x01ca
            d2.e0 r1 = new d2.e0
            r1.<init>(r5, r3, r14)
            goto L_0x01ee
        L_0x01ca:
            int r1 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x01e5
            long r6 = r14.f4182j
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x01e5
            g2.a r1 = new g2.a
            int r15 = r0.f6792k
            r13 = r1
            r16 = r3
            r13.<init>(r14, r15, r16, r18)
            r0.f6793l = r1
            d2.f r1 = r1.f4219a
            goto L_0x01ee
        L_0x01e5:
            d2.e0 r1 = new d2.e0
            long r3 = r14.b()
            r1.<init>(r3)
        L_0x01ee:
            r2.g(r1)
            r0.f6788g = r12
            return r5
        L_0x01f4:
            java.lang.String r1 = "First frame does not start with sync code."
            g1.b1 r1 = g1.b1.a(r1, r3)
            throw r1
        L_0x01fb:
            e.a r2 = new e.a
            d2.f0 r3 = r0.f6790i
            r4 = 24
            r2.<init>((int) r4, (java.lang.Object) r3)
            r3 = 0
        L_0x0205:
            if (r3 != 0) goto L_0x0380
            r29.f()
            j1.a0 r3 = new j1.a0
            byte[] r6 = new byte[r9]
            r3.<init>(r9, r6)
            byte[] r6 = r3.f8405a
            r1.m(r6, r5, r9)
            boolean r6 = r3.f()
            int r12 = r3.g(r10)
            int r3 = r3.g(r4)
            int r3 = r3 + r9
            if (r12 != 0) goto L_0x0235
            r3 = 38
            byte[] r12 = new byte[r3]
            r1.readFully(r12, r5, r3)
            d2.f0 r3 = new d2.f0
            r3.<init>(r9, r12)
            r27 = r6
            goto L_0x0362
        L_0x0235:
            java.lang.Object r13 = r2.f4852i
            d2.f0 r13 = (d2.f0) r13
            if (r13 == 0) goto L_0x037a
            if (r12 != r8) goto L_0x0279
            j1.b0 r12 = new j1.b0
            r12.<init>((int) r3)
            byte[] r14 = r12.f8414a
            r1.readFully(r14, r5, r3)
            android.support.v4.media.n r25 = d2.d0.a(r12)
            d2.f0 r3 = new d2.f0
            int r12 = r13.f4173a
            int r14 = r13.f4174b
            int r15 = r13.f4175c
            int r4 = r13.f4176d
            int r10 = r13.f4177e
            int r8 = r13.f4179g
            int r11 = r13.f4180h
            r27 = r6
            long r5 = r13.f4182j
            g1.z0 r13 = r13.f4184l
            r18 = r15
            r15 = r3
            r16 = r12
            r17 = r14
            r19 = r4
            r20 = r10
            r21 = r8
            r22 = r11
            r23 = r5
            r26 = r13
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r25, r26)
            goto L_0x0362
        L_0x0279:
            r27 = r6
            g1.z0 r4 = r13.f4184l
            if (r12 != r9) goto L_0x02f3
            j1.b0 r5 = new j1.b0
            r5.<init>((int) r3)
            byte[] r6 = r5.f8414a
            r8 = 0
            r1.readFully(r6, r8, r3)
            r5.H(r9)
            d0.d r3 = d2.b1.b(r5, r8, r8)
            java.lang.Object r3 = r3.f4092j
            java.lang.String[] r3 = (java.lang.String[]) r3
            java.util.List r3 = java.util.Arrays.asList(r3)
            g1.z0 r3 = d2.b1.a(r3)
            if (r4 != 0) goto L_0x02a2
            r25 = r3
            goto L_0x02c8
        L_0x02a2:
            if (r3 != 0) goto L_0x02a5
            goto L_0x02c6
        L_0x02a5:
            g1.y0[] r3 = r3.f6770h
            int r5 = r3.length
            if (r5 != 0) goto L_0x02ab
            goto L_0x02c6
        L_0x02ab:
            g1.z0 r5 = new g1.z0
            int r6 = j1.l0.f8453a
            g1.y0[] r6 = r4.f6770h
            int r8 = r6.length
            int r10 = r3.length
            int r8 = r8 + r10
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r6, r8)
            int r6 = r6.length
            int r10 = r3.length
            r11 = 0
            java.lang.System.arraycopy(r3, r11, r8, r6, r10)
            g1.y0[] r8 = (g1.y0[]) r8
            long r3 = r4.f6771i
            r5.<init>(r3, r8)
            r4 = r5
        L_0x02c6:
            r25 = r4
        L_0x02c8:
            d2.f0 r3 = new d2.f0
            int r15 = r13.f4173a
            int r4 = r13.f4174b
            int r5 = r13.f4175c
            int r6 = r13.f4176d
            int r8 = r13.f4177e
            int r10 = r13.f4179g
            int r11 = r13.f4180h
            r12 = r10
            long r9 = r13.f4182j
            android.support.v4.media.n r13 = r13.f4183k
            r14 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r8
            r20 = r12
            r21 = r11
            r22 = r9
            r24 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r24, r25)
            goto L_0x0362
        L_0x02f3:
            r5 = 6
            if (r12 != r5) goto L_0x0365
            j1.b0 r5 = new j1.b0
            r5.<init>((int) r3)
            byte[] r6 = r5.f8414a
            r8 = 0
            r1.readFully(r6, r8, r3)
            r3 = 4
            r5.H(r3)
            m2.b r3 = m2.b.u(r5)
            d9.r1 r3 = d9.r0.n(r3)
            g1.z0 r5 = new g1.z0
            r5.<init>((java.util.List) r3)
            if (r4 != 0) goto L_0x0317
            r25 = r5
            goto L_0x033a
        L_0x0317:
            g1.y0[] r3 = r5.f6770h
            int r5 = r3.length
            if (r5 != 0) goto L_0x031d
            goto L_0x0338
        L_0x031d:
            g1.z0 r5 = new g1.z0
            int r6 = j1.l0.f8453a
            g1.y0[] r6 = r4.f6770h
            int r8 = r6.length
            int r9 = r3.length
            int r8 = r8 + r9
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r6, r8)
            int r6 = r6.length
            int r9 = r3.length
            r10 = 0
            java.lang.System.arraycopy(r3, r10, r8, r6, r9)
            g1.y0[] r8 = (g1.y0[]) r8
            long r3 = r4.f6771i
            r5.<init>(r3, r8)
            r4 = r5
        L_0x0338:
            r25 = r4
        L_0x033a:
            d2.f0 r3 = new d2.f0
            int r15 = r13.f4173a
            int r4 = r13.f4174b
            int r5 = r13.f4175c
            int r6 = r13.f4176d
            int r8 = r13.f4177e
            int r9 = r13.f4179g
            int r10 = r13.f4180h
            long r11 = r13.f4182j
            android.support.v4.media.n r13 = r13.f4183k
            r14 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r11
            r24 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r24, r25)
        L_0x0362:
            r2.f4852i = r3
            goto L_0x0368
        L_0x0365:
            r1.g(r3)
        L_0x0368:
            java.lang.Object r3 = r2.f4852i
            d2.f0 r3 = (d2.f0) r3
            int r4 = j1.l0.f8453a
            r0.f6790i = r3
            r3 = r27
            r4 = 24
            r5 = 0
            r8 = 3
            r9 = 4
            r10 = 7
            goto L_0x0205
        L_0x037a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x0380:
            d2.f0 r1 = r0.f6790i
            r1.getClass()
            d2.f0 r1 = r0.f6790i
            int r1 = r1.f4175c
            r2 = 6
            int r1 = java.lang.Math.max(r1, r2)
            r0.f6791j = r1
            d2.x0 r1 = r0.f6787f
            int r2 = j1.l0.f8453a
            d2.f0 r2 = r0.f6790i
            g1.z0 r3 = r0.f6789h
            g1.a0 r2 = r2.c(r7, r3)
            r1.a(r2)
            r2 = 4
            r0.f6788g = r2
            r4 = 0
            return r4
        L_0x03a4:
            r2 = 4
            r4 = 0
            j1.b0 r5 = new j1.b0
            r5.<init>((int) r2)
            byte[] r6 = r5.f8414a
            r1.readFully(r6, r4, r2)
            long r1 = r5.w()
            r5 = 1716281667(0x664c6143, double:8.479558103E-315)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x03bf
            r1 = 3
            r0.f6788g = r1
            return r4
        L_0x03bf:
            java.lang.String r1 = "Failed to read FLAC stream marker."
            g1.b1 r1 = g1.b1.a(r1, r3)
            throw r1
        L_0x03c6:
            r4 = 0
            int r2 = r7.length
            r1.m(r7, r4, r2)
            r29.f()
            r0.f6788g = r6
            return r4
        L_0x03d1:
            boolean r2 = r0.f6784c
            r2 = r2 ^ r4
            r29.f()
            long r5 = r29.l()
            if (r2 == 0) goto L_0x03df
            r2 = r3
            goto L_0x03e1
        L_0x03df:
            i1.c r2 = o2.o.f12088b
        L_0x03e1:
            d2.i0 r7 = new d2.i0
            r7.<init>()
            g1.z0 r2 = r7.a(r1, r2)
            if (r2 == 0) goto L_0x03f3
            g1.y0[] r7 = r2.f6770h
            int r7 = r7.length
            if (r7 != 0) goto L_0x03f2
            goto L_0x03f3
        L_0x03f2:
            r3 = r2
        L_0x03f3:
            long r7 = r29.l()
            long r7 = r7 - r5
            int r2 = (int) r7
            r1.g(r2)
            r0.f6789h = r3
            r0.f6788g = r4
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f6786e = yVar;
        this.f6787f = yVar.d(0, 1);
        yVar.a();
    }

    public final boolean h(w wVar) {
        z0 a10 = new i0().a(wVar, o.f12088b);
        if (a10 != null) {
            int length = a10.f6770h.length;
        }
        b0 b0Var = new b0(4);
        ((p) wVar).k(b0Var.f8414a, 0, 4, false);
        if (b0Var.w() == 1716281667) {
            return true;
        }
        return false;
    }

    public b(int i10) {
        this.f6782a = new byte[42];
        this.f6783b = new b0(0, new byte[32768]);
        this.f6784c = false;
        this.f6785d = new d2.b0();
        this.f6788g = 0;
    }
}
