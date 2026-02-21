package f3;

import d2.x0;
import d2.y;
import j1.a0;
import j1.b0;

public final class c implements k {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f5494a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5495b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5496c;

    /* renamed from: d  reason: collision with root package name */
    public String f5497d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f5498e;

    /* renamed from: f  reason: collision with root package name */
    public int f5499f;

    /* renamed from: g  reason: collision with root package name */
    public int f5500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5501h;

    /* renamed from: i  reason: collision with root package name */
    public long f5502i;

    /* renamed from: j  reason: collision with root package name */
    public g1.a0 f5503j;

    /* renamed from: k  reason: collision with root package name */
    public int f5504k;

    /* renamed from: l  reason: collision with root package name */
    public long f5505l;

    public c() {
        this((String) null);
    }

    public final void a() {
        this.f5499f = 0;
        this.f5500g = 0;
        this.f5501h = false;
        this.f5505l = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:224:0x037d, code lost:
        if (r23.v() == 11) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x038b, code lost:
        if (r2 == 11) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x038f, code lost:
        r12 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            d2.x0 r2 = r0.f5498e
            j1.a.f(r2)
        L_0x0009:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x03a5
            int r3 = r0.f5499f
            r4 = 0
            r5 = 1
            r6 = 2
            r7 = 11
            j1.b0 r8 = r0.f5495b
            if (r3 == 0) goto L_0x036c
            if (r3 == r5) goto L_0x0054
            if (r3 == r6) goto L_0x0020
            goto L_0x0009
        L_0x0020:
            int r3 = r0.f5504k
            int r5 = r0.f5500g
            int r3 = r3 - r5
            int r2 = java.lang.Math.min(r2, r3)
            d2.x0 r3 = r0.f5498e
            r3.d(r2, r1)
            int r3 = r0.f5500g
            int r3 = r3 + r2
            r0.f5500g = r3
            int r9 = r0.f5504k
            if (r3 != r9) goto L_0x0009
            long r6 = r0.f5505l
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0051
            d2.x0 r5 = r0.f5498e
            r8 = 1
            r10 = 0
            r11 = 0
            r5.e(r6, r8, r9, r10, r11)
            long r2 = r0.f5505l
            long r5 = r0.f5502i
            long r2 = r2 + r5
            r0.f5505l = r2
        L_0x0051:
            r0.f5499f = r4
            goto L_0x0009
        L_0x0054:
            byte[] r3 = r8.f8414a
            int r9 = r0.f5500g
            r10 = 128(0x80, float:1.794E-43)
            int r9 = 128 - r9
            int r2 = java.lang.Math.min(r2, r9)
            int r9 = r0.f5500g
            r1.d(r3, r9, r2)
            int r3 = r0.f5500g
            int r3 = r3 + r2
            r0.f5500g = r3
            if (r3 != r10) goto L_0x006e
            r2 = 1
            goto L_0x006f
        L_0x006e:
            r2 = 0
        L_0x006f:
            if (r2 == 0) goto L_0x0009
            j1.a0 r2 = r0.f5494a
            r2.k(r4)
            int r3 = r2.e()
            r9 = 40
            r2.m(r9)
            r9 = 5
            int r11 = r2.g(r9)
            r12 = 10
            if (r11 <= r12) goto L_0x008a
            r11 = 1
            goto L_0x008b
        L_0x008a:
            r11 = 0
        L_0x008b:
            r2.k(r3)
            int[] r3 = d2.c.f4153d
            int[] r13 = d2.c.f4151b
            r15 = 8
            r14 = 3
            java.lang.String r4 = "audio/ac3"
            if (r11 == 0) goto L_0x02b7
            r11 = 16
            r2.m(r11)
            int r10 = r2.g(r6)
            if (r10 == 0) goto L_0x00ae
            if (r10 == r5) goto L_0x00ac
            if (r10 == r6) goto L_0x00aa
            r10 = -1
            goto L_0x00af
        L_0x00aa:
            r10 = 2
            goto L_0x00af
        L_0x00ac:
            r10 = 1
            goto L_0x00af
        L_0x00ae:
            r10 = 0
        L_0x00af:
            r2.m(r14)
            int r7 = r2.g(r7)
            int r7 = r7 + r5
            int r7 = r7 * 2
            int r11 = r2.g(r6)
            if (r11 != r14) goto L_0x00cb
            int[] r13 = d2.c.f4152c
            int r16 = r2.g(r6)
            r13 = r13[r16]
            r6 = 6
            r19 = 3
            goto L_0x00d9
        L_0x00cb:
            int r16 = r2.g(r6)
            int[] r18 = d2.c.f4150a
            r18 = r18[r16]
            r13 = r13[r11]
            r19 = r16
            r6 = r18
        L_0x00d9:
            int r5 = r6 * 256
            int r16 = r7 * r13
            int r20 = r6 * 32
            int r16 = r16 / r20
            int r9 = r2.g(r14)
            boolean r21 = r2.f()
            r3 = r3[r9]
            int r3 = r3 + r21
            r2.m(r12)
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x00f9
            r2.m(r15)
        L_0x00f9:
            if (r9 != 0) goto L_0x0108
            r12 = 5
            r2.m(r12)
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0108
            r2.m(r15)
        L_0x0108:
            r12 = 1
            if (r10 != r12) goto L_0x0116
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0116
            r12 = 16
            r2.m(r12)
        L_0x0116:
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0248
            r12 = 2
            if (r9 <= r12) goto L_0x0122
            r2.m(r12)
        L_0x0122:
            r18 = r9 & 1
            if (r18 == 0) goto L_0x012d
            if (r9 <= r12) goto L_0x012d
            r12 = 6
            r2.m(r12)
            goto L_0x012e
        L_0x012d:
            r12 = 6
        L_0x012e:
            r17 = r9 & 4
            if (r17 == 0) goto L_0x0135
            r2.m(r12)
        L_0x0135:
            if (r21 == 0) goto L_0x0141
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0141
            r12 = 5
            r2.m(r12)
        L_0x0141:
            if (r10 != 0) goto L_0x0248
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x014e
            r12 = 6
            r2.m(r12)
            goto L_0x014f
        L_0x014e:
            r12 = 6
        L_0x014f:
            if (r9 != 0) goto L_0x015a
            boolean r17 = r2.f()
            if (r17 == 0) goto L_0x015a
            r2.m(r12)
        L_0x015a:
            boolean r17 = r2.f()
            if (r17 == 0) goto L_0x0163
            r2.m(r12)
        L_0x0163:
            r12 = 2
            int r15 = r2.g(r12)
            r14 = 1
            if (r15 != r14) goto L_0x0172
            r14 = 5
            r2.m(r14)
        L_0x016f:
            r15 = 2
            goto L_0x0211
        L_0x0172:
            r14 = 5
            if (r15 != r12) goto L_0x017b
            r12 = 12
            r2.m(r12)
            goto L_0x016f
        L_0x017b:
            r12 = 3
            if (r15 != r12) goto L_0x016f
            int r12 = r2.g(r14)
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01e5
            r2.m(r14)
            boolean r14 = r2.f()
            if (r14 == 0) goto L_0x0196
            r14 = 4
            r2.m(r14)
            goto L_0x0197
        L_0x0196:
            r14 = 4
        L_0x0197:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01a0
            r2.m(r14)
        L_0x01a0:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01a9
            r2.m(r14)
        L_0x01a9:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01b2
            r2.m(r14)
        L_0x01b2:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01bb
            r2.m(r14)
        L_0x01bb:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01c4
            r2.m(r14)
        L_0x01c4:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01cd
            r2.m(r14)
        L_0x01cd:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01e5
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01dc
            r2.m(r14)
        L_0x01dc:
            boolean r15 = r2.f()
            if (r15 == 0) goto L_0x01e5
            r2.m(r14)
        L_0x01e5:
            boolean r14 = r2.f()
            if (r14 == 0) goto L_0x0205
            r14 = 5
            r2.m(r14)
            boolean r14 = r2.f()
            if (r14 == 0) goto L_0x0205
            r14 = 7
            r2.m(r14)
            boolean r14 = r2.f()
            if (r14 == 0) goto L_0x0205
            r14 = 8
            r2.m(r14)
            goto L_0x0207
        L_0x0205:
            r14 = 8
        L_0x0207:
            r15 = 2
            int r12 = r12 + r15
            int r12 = r12 * 8
            r2.m(r12)
            r2.c()
        L_0x0211:
            if (r9 >= r15) goto L_0x0229
            boolean r12 = r2.f()
            r14 = 14
            if (r12 == 0) goto L_0x021e
            r2.m(r14)
        L_0x021e:
            if (r9 != 0) goto L_0x0229
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0229
            r2.m(r14)
        L_0x0229:
            boolean r12 = r2.f()
            if (r12 == 0) goto L_0x0248
            r14 = r19
            r12 = 5
            if (r14 != 0) goto L_0x0238
            r2.m(r12)
            goto L_0x024a
        L_0x0238:
            r15 = 0
        L_0x0239:
            if (r15 >= r6) goto L_0x024a
            boolean r19 = r2.f()
            if (r19 == 0) goto L_0x0244
            r2.m(r12)
        L_0x0244:
            int r15 = r15 + 1
            r12 = 5
            goto L_0x0239
        L_0x0248:
            r14 = r19
        L_0x024a:
            boolean r6 = r2.f()
            if (r6 == 0) goto L_0x0281
            r6 = 5
            r2.m(r6)
            r6 = 2
            if (r9 != r6) goto L_0x025b
            r12 = 4
            r2.m(r12)
        L_0x025b:
            r12 = 6
            if (r9 < r12) goto L_0x0261
            r2.m(r6)
        L_0x0261:
            boolean r6 = r2.f()
            if (r6 == 0) goto L_0x026d
            r6 = 8
            r2.m(r6)
            goto L_0x026f
        L_0x026d:
            r6 = 8
        L_0x026f:
            if (r9 != 0) goto L_0x027a
            boolean r9 = r2.f()
            if (r9 == 0) goto L_0x027a
            r2.m(r6)
        L_0x027a:
            r6 = 3
            if (r11 >= r6) goto L_0x0282
            r2.l()
            goto L_0x0282
        L_0x0281:
            r6 = 3
        L_0x0282:
            if (r10 != 0) goto L_0x0289
            if (r14 == r6) goto L_0x0289
            r2.l()
        L_0x0289:
            r9 = 2
            if (r10 != r9) goto L_0x0299
            if (r14 == r6) goto L_0x0294
            boolean r6 = r2.f()
            if (r6 == 0) goto L_0x0299
        L_0x0294:
            r6 = 6
            r2.m(r6)
            goto L_0x029a
        L_0x0299:
            r6 = 6
        L_0x029a:
            boolean r9 = r2.f()
            if (r9 == 0) goto L_0x02b2
            int r6 = r2.g(r6)
            r9 = 1
            if (r6 != r9) goto L_0x02b2
            r6 = 8
            int r2 = r2.g(r6)
            if (r2 != r9) goto L_0x02b2
            java.lang.String r2 = "audio/eac3-joc"
            goto L_0x02b4
        L_0x02b2:
            java.lang.String r2 = "audio/eac3"
        L_0x02b4:
            r9 = r16
            goto L_0x030f
        L_0x02b7:
            r5 = 32
            r2.m(r5)
            r5 = 2
            int r6 = r2.g(r5)
            r5 = 3
            if (r6 != r5) goto L_0x02c6
            r5 = 0
            goto L_0x02c7
        L_0x02c6:
            r5 = r4
        L_0x02c7:
            r7 = 6
            int r7 = r2.g(r7)
            int[] r9 = d2.c.f4154e
            int r10 = r7 / 2
            r9 = r9[r10]
            int r9 = r9 * 1000
            int r7 = d2.c.a(r6, r7)
            r10 = 8
            r2.m(r10)
            r10 = 3
            int r11 = r2.g(r10)
            r10 = r11 & 1
            if (r10 == 0) goto L_0x02ee
            r10 = 1
            if (r11 == r10) goto L_0x02ee
            r10 = 2
            r2.m(r10)
            goto L_0x02ef
        L_0x02ee:
            r10 = 2
        L_0x02ef:
            r12 = r11 & 4
            if (r12 == 0) goto L_0x02f6
            r2.m(r10)
        L_0x02f6:
            if (r11 != r10) goto L_0x02fb
            r2.m(r10)
        L_0x02fb:
            r10 = 3
            if (r6 >= r10) goto L_0x0301
            r14 = r13[r6]
            goto L_0x0302
        L_0x0301:
            r14 = -1
        L_0x0302:
            boolean r2 = r2.f()
            r3 = r3[r11]
            int r3 = r3 + r2
            r2 = 1536(0x600, float:2.152E-42)
            r2 = r5
            r13 = r14
            r5 = 1536(0x600, float:2.152E-42)
        L_0x030f:
            g1.a0 r6 = r0.f5503j
            if (r6 == 0) goto L_0x0323
            int r10 = r6.F
            if (r3 != r10) goto L_0x0323
            int r10 = r6.G
            if (r13 != r10) goto L_0x0323
            java.lang.String r6 = r6.f6276s
            boolean r6 = j1.l0.a(r2, r6)
            if (r6 != 0) goto L_0x034c
        L_0x0323:
            g1.z r6 = new g1.z
            r6.<init>()
            java.lang.String r10 = r0.f5497d
            r6.f6744a = r10
            r6.f6754k = r2
            r6.f6767x = r3
            r6.f6768y = r13
            java.lang.String r3 = r0.f5496c
            r6.f6746c = r3
            r6.f6750g = r9
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0340
            r6.f6749f = r9
        L_0x0340:
            g1.a0 r2 = new g1.a0
            r2.<init>(r6)
            r0.f5503j = r2
            d2.x0 r3 = r0.f5498e
            r3.a(r2)
        L_0x034c:
            r0.f5504k = r7
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = (long) r5
            long r4 = r4 * r2
            g1.a0 r2 = r0.f5503j
            int r2 = r2.G
            long r2 = (long) r2
            long r4 = r4 / r2
            r0.f5502i = r4
            r2 = 0
            r8.G(r2)
            d2.x0 r2 = r0.f5498e
            r3 = 128(0x80, float:1.794E-43)
            r2.d(r3, r8)
            r2 = 2
            r0.f5499f = r2
            goto L_0x0009
        L_0x036c:
            int r2 = r1.f8416c
            int r3 = r1.f8415b
            int r2 = r2 - r3
            r3 = 119(0x77, float:1.67E-43)
            if (r2 <= 0) goto L_0x0393
            boolean r2 = r0.f5501h
            if (r2 != 0) goto L_0x0380
            int r2 = r23.v()
            if (r2 != r7) goto L_0x038f
            goto L_0x038d
        L_0x0380:
            int r2 = r23.v()
            if (r2 != r3) goto L_0x038b
            r4 = 0
            r0.f5501h = r4
            r12 = 1
            goto L_0x0394
        L_0x038b:
            if (r2 != r7) goto L_0x038f
        L_0x038d:
            r12 = 1
            goto L_0x0390
        L_0x038f:
            r12 = 0
        L_0x0390:
            r0.f5501h = r12
            goto L_0x036c
        L_0x0393:
            r12 = 0
        L_0x0394:
            if (r12 == 0) goto L_0x0009
            r2 = 1
            r0.f5499f = r2
            byte[] r4 = r8.f8414a
            r5 = 0
            r4[r5] = r7
            r4[r2] = r3
            r2 = 2
            r0.f5500g = r2
            goto L_0x0009
        L_0x03a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.c.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5497d = j0Var.f5631e;
        j0Var.b();
        this.f5498e = yVar.d(j0Var.f5630d, 1);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5505l = j10;
        }
    }

    public final void f() {
    }

    public c(String str) {
        a0 a0Var = new a0(128, new byte[128]);
        this.f5494a = a0Var;
        this.f5495b = new b0(a0Var.f8405a);
        this.f5499f = 0;
        this.f5505l = -9223372036854775807L;
        this.f5496c = str;
    }
}
